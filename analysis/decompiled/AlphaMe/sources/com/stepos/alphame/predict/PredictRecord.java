package com.stepos.alphame.predict;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.stepos.alphame.awareness.TimetableTracker;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.utils.UsageStatsUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PredictRecord {
    public static final String KEY = "predictRecord";
    private static final long MINUTE = 60000;
    private static final long SECEND = 1000;
    private int AIMatched1;
    private int AIMatched4;
    private int AIMatched8;
    private HashMap<String, AppMatchRecord> appRecords = new HashMap<>();
    private long date;
    private int favoriteMatched1;
    private int favoriteMatched4;
    private int favoriteMatched8;
    private int total;

    public static PredictRecord fromJsonString(String str) {
        PredictRecord predictRecord = new PredictRecord();
        try {
            return (PredictRecord) JSON.parseObject(str).toJavaObject(PredictRecord.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return predictRecord;
        }
    }

    private AppMatchRecord getAppRecord(String str) {
        AppMatchRecord appMatchRecord = this.appRecords.get(str);
        if (appMatchRecord != null) {
            return appMatchRecord;
        }
        AppMatchRecord appMatchRecord2 = new AppMatchRecord();
        appMatchRecord2.pkgName = str;
        this.appRecords.put(str, appMatchRecord2);
        return appMatchRecord2;
    }

    public float getAIMatchRate1() {
        return this.AIMatched1 / this.total;
    }

    public float getAIMatchRate4() {
        return this.AIMatched4 / this.total;
    }

    public float getAIMatchRate8() {
        return this.AIMatched8 / this.total;
    }

    public int getAIMatched1() {
        return this.AIMatched1;
    }

    public int getAIMatched4() {
        return this.AIMatched4;
    }

    public int getAIMatched8() {
        return this.AIMatched8;
    }

    public HashMap<String, AppMatchRecord> getAppRecords() {
        return this.appRecords;
    }

    public long getDate() {
        return this.date;
    }

    public float getFavoriteMatchRate1() {
        return this.favoriteMatched1 / this.total;
    }

    public float getFavoriteMatchRate4() {
        return this.favoriteMatched4 / this.total;
    }

    public float getFavoriteMatchRate8() {
        return this.favoriteMatched8 / this.total;
    }

    public int getFavoriteMatched1() {
        return this.favoriteMatched1;
    }

    public int getFavoriteMatched4() {
        return this.favoriteMatched4;
    }

    public int getFavoriteMatched8() {
        return this.favoriteMatched8;
    }

    public int getTotal() {
        return this.total;
    }

    public void inc() {
        this.total++;
    }

    public void matchAI1() {
        this.AIMatched1++;
        this.AIMatched4++;
        this.AIMatched8++;
    }

    public void matchAI4() {
        this.AIMatched4++;
        this.AIMatched8++;
    }

    public void matchAI8() {
        this.AIMatched8++;
    }

    public void matchApp(String str) {
        getAppRecord(str).hitTimes++;
    }

    public void matchFavorite1() {
        this.favoriteMatched1++;
        this.favoriteMatched4++;
        this.favoriteMatched8++;
    }

    public void matchFavorite4() {
        this.favoriteMatched4++;
        this.favoriteMatched8++;
    }

    public void matchFavorite8() {
        this.favoriteMatched8++;
    }

    public void missApp(String str) {
        getAppRecord(str).missTimes++;
    }

    public void openApp(String str) {
        getAppRecord(str).openTimes++;
    }

    public void reset() {
        this.AIMatched1 = 0;
        this.AIMatched4 = 0;
        this.AIMatched8 = 0;
        this.favoriteMatched1 = 0;
        this.favoriteMatched4 = 0;
        this.favoriteMatched8 = 0;
        this.total = 0;
        this.appRecords.clear();
    }

    public String savePredictRecord(Context context, boolean z4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z4 || Math.abs(jCurrentTimeMillis - getDate()) > VehicleBluetoothManager.FAIL_RETRY_TIMEOUT) {
            setDate(jCurrentTimeMillis);
            context.getSharedPreferences(TimetableTracker.PREF_NAME, 0).edit().putString(KEY, toJsonString()).apply();
        }
        return toJsonString();
    }

    public void setAIMatched1(int i4) {
        this.AIMatched1 = i4;
    }

    public void setAIMatched4(int i4) {
        this.AIMatched4 = i4;
    }

    public void setAIMatched8(int i4) {
        this.AIMatched8 = i4;
    }

    public void setAppRecords(HashMap<String, AppMatchRecord> map) {
        this.appRecords = map;
    }

    public void setDate(long j4) {
        this.date = j4;
    }

    public void setFavoriteMatched1(int i4) {
        this.favoriteMatched1 = i4;
    }

    public void setFavoriteMatched4(int i4) {
        this.favoriteMatched4 = i4;
    }

    public void setFavoriteMatched8(int i4) {
        this.favoriteMatched8 = i4;
    }

    public void setTotal(int i4) {
        this.total = i4;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return "total = " + this.total + "\n AI 1 match rate = " + getAIMatchRate1() + "\n AI 4 match rate = " + getAIMatchRate4() + "\n AI 8 matched rate = " + getAIMatchRate8() + "\n favorite 1 match rate = " + getFavoriteMatchRate1() + "\n favorite 4 match rate = " + getFavoriteMatchRate4() + "\n favorite 8 match rate = " + getFavoriteMatchRate8();
    }

    public void uploadPredictRecord(Context context) {
        HashMap map = new HashMap();
        map.put(UsageStatsUtils.KEY_ONE_RESULT, "" + getAIMatchRate1());
        map.put(UsageStatsUtils.KEY_FOUR_RESULT, "" + getAIMatchRate4());
        map.put(UsageStatsUtils.KEY_EIGHT_RESULT, "" + getAIMatchRate8());
        map.put(UsageStatsUtils.KEY_APP_OPEN_TIMES, "" + getTotal());
        UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_APP_SUGGESTION, null, map);
        HashMap map2 = new HashMap();
        map2.put(UsageStatsUtils.KEY_ONE_RESULT, "" + getFavoriteMatchRate1());
        map2.put(UsageStatsUtils.KEY_FOUR_RESULT, "" + getFavoriteMatchRate4());
        map2.put(UsageStatsUtils.KEY_EIGHT_RESULT, "" + getFavoriteMatchRate8());
        map2.put(UsageStatsUtils.KEY_APP_OPEN_TIMES, "" + getTotal());
        UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_FAVORITE_SUGGESTION, null, map2);
        for (AppMatchRecord appMatchRecord : this.appRecords.values()) {
            HashMap map3 = new HashMap();
            map3.put("package_name", "" + appMatchRecord.pkgName);
            map3.put(UsageStatsUtils.KEY_OPEN_TIMES, "" + appMatchRecord.openTimes);
            map3.put(UsageStatsUtils.KEY_HIT_TIMES, "" + appMatchRecord.hitTimes);
            map3.put(UsageStatsUtils.KEY_WRONG_TIMES, "" + appMatchRecord.wrongTimes);
            map3.put(UsageStatsUtils.KEY_MISS_TIMES, "" + appMatchRecord.missTimes);
            UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_APP_HIT_RATE, null, map3);
        }
        reset();
        savePredictRecord(context, true);
    }

    public void wrongApp(String str) {
        getAppRecord(str).wrongTimes++;
    }
}
