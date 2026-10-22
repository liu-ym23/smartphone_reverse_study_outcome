package com.android.server.am;

import com.zte.ai.NameScore;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AIPredictResultInfo {
    private static final float DEFAULT_SCORE_VAL = -1.0f;
    static final int SHORT_CUT_SIZE_MIN = 2;
    String extra;
    boolean mChangedFlag;
    long mDataUpdateCnt;
    float[] mShortCutScoreCache;
    long[] mShortCutScoreToLongCache;
    long mValidDataChangedCnt;
    int maxPredCount;
    int preSlotInSeconds;
    long preTimeInMillis;
    List<NameScore> result;
    String typeName;

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1085clone() throws CloneNotSupportedException {
        return clone();
    }

    private void innerUpateScoreLongCacheFromScoreCache() {
        if (this.mShortCutScoreCache == null) goto L16;
        int size = this.mShortCutScoreCache.length;
        if (size <= 0) goto L14;
        long[] newLongArray = new long[size];
        int i = 0;
    L7:
        if (i >= size) goto L10;
        newLongArray[i] = (long) Math.ceil(this.mShortCutScoreCache[i]);
        i = i + 1;
        goto L7
    L10:
        if (Arrays.equals(newLongArray, this.mShortCutScoreToLongCache) == false) goto L12;
        this.mChangedFlag = false;
        return;
    L12:
        this.mChangedFlag = true;
        this.mShortCutScoreToLongCache = newLongArray;
        this.mValidDataChangedCnt++;
        return;
    L14:
        this.mShortCutScoreToLongCache = null;
        return;
    L16:
        this.mShortCutScoreToLongCache = null;
    }

    private void innerUpateShortCutCache() {
        if (this.result == null) goto L18;
        int size = this.result.size();
        if (size <= 0) goto L16;
        this.mShortCutScoreCache = new float[size];
        if (this.mShortCutScoreCache == null) goto L19;
        int i = 0;
    L9:
        if (i >= size) goto L19;
        NameScore nameScore = this.result.get(i);
        if (nameScore == null) goto L13;
        this.mShortCutScoreCache[i] = nameScore.getScore();
    L14:
        i = i + 1;
        goto L9
    L13:
        this.mShortCutScoreCache[i] = -1.0f;
    L19:
        innerUpateScoreLongCacheFromScoreCache();
        return;
    L16:
        this.mShortCutScoreCache = null;
        goto L19
    L18:
        this.mShortCutScoreCache = null;
        goto L19
    }

    public AIPredictResultInfo() {
    }

    public AIPredictResultInfo(String typeName, List<NameScore> result, long preTimeInMillis, int preSlotInSeconds, int maxPredCount, String extra) {
        this.typeName = typeName;
        this.result = result;
        this.preTimeInMillis = preTimeInMillis;
        this.preSlotInSeconds = preSlotInSeconds;
        this.maxPredCount = maxPredCount;
        this.extra = extra;
        innerUpateShortCutCache();
        this.mDataUpdateCnt = 1;
    }

    public static AIPredictResultInfo createInstance() {
        return new AIPredictResultInfo();
    }

    public static AIPredictResultInfo createInstance(String typeName, List<NameScore> result, long preTimeInMillis, int preSlotInSeconds, int maxPredCount, String extra) {
        return new AIPredictResultInfo(typeName, result, preTimeInMillis, preSlotInSeconds, maxPredCount, extra);
    }

    public AIPredictResultInfo clone() {
        AIPredictResultInfo clonedInfo = new AIPredictResultInfo(this.typeName, this.result, this.preTimeInMillis, this.preSlotInSeconds, this.maxPredCount, this.extra);
        clonedInfo.mChangedFlag = this.mChangedFlag;
        clonedInfo.mDataUpdateCnt = this.mDataUpdateCnt;
        clonedInfo.mValidDataChangedCnt = this.mValidDataChangedCnt;
        return clonedInfo;
    }

    void reset() {
        this.typeName = null;
        this.result = null;
        this.preTimeInMillis = 0;
        this.preSlotInSeconds = 0;
        this.maxPredCount = 0;
        this.extra = null;
        innerUpateShortCutCache();
    }

    public void reset(String typeName, List<NameScore> result, long preTimeInMillis, int preSlotInSeconds, int maxPredCount, String extra) {
        this.typeName = typeName;
        this.result = result;
        this.preTimeInMillis = preTimeInMillis;
        this.preSlotInSeconds = preSlotInSeconds;
        this.maxPredCount = maxPredCount;
        this.extra = extra;
        innerUpateShortCutCache();
        this.mDataUpdateCnt++;
    }

    public boolean isExpired() {
        long currTimeInMillis = System.currentTimeMillis();
        if (currTimeInMillis >= this.preTimeInMillis) goto L5;
        return true;
    L5:
        if (currTimeInMillis > (this.preTimeInMillis + (((long) this.preSlotInSeconds) * 1000))) goto L10;
        return false;
    L10:
        return true;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<NameScore> getResult() {
        return this.result;
    }

    public void setResult(List<NameScore> result) {
        this.result = result;
        innerUpateShortCutCache();
    }

    public long getPreTimeInMillis() {
        return this.preTimeInMillis;
    }

    public void setPreTimeInMillis(long preTimeInMillis) {
        this.preTimeInMillis = preTimeInMillis;
    }

    public int getPreSlotInSeconds() {
        return this.preSlotInSeconds;
    }

    public void setPreSlotInSeconds(int preSlotInSeconds) {
        this.preSlotInSeconds = preSlotInSeconds;
    }

    public int getMaxPredCount() {
        return this.maxPredCount;
    }

    public void setMaxPredCount(int maxPredCount) {
        this.maxPredCount = maxPredCount;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public boolean getChangedFlag() {
        return this.mChangedFlag;
    }

    public void setChangedFlag(boolean flag) {
        this.mChangedFlag = flag;
    }

    public float[] getShortCutScoreCache() {
        if (this.mShortCutScoreCache != null) goto L5;
        return null;
    L5:
        if (this.mShortCutScoreCache.length <= 0) goto L15;
        int size = this.mShortCutScoreCache.length;
        float[] newFloatArr = new float[size];
        int i = 0;
    L8:
        if (i >= size) goto L11;
        newFloatArr[i] = this.mShortCutScoreCache[i];
        i = i + 1;
        goto L8
    L11:
        return newFloatArr;
    L15:
        return null;
    }

    public void setShortCutScoreCache(float[] value) {
        this.mShortCutScoreCache = value;
        innerUpateScoreLongCacheFromScoreCache();
    }

    public long[] getShortCutScoreLongCache() {
        if (this.mShortCutScoreToLongCache != null) goto L5;
        return null;
    L5:
        if (this.mShortCutScoreToLongCache.length <= 0) goto L15;
        int size = this.mShortCutScoreToLongCache.length;
        long[] newLongArr = new long[size];
        int i = 0;
    L8:
        if (i >= size) goto L11;
        newLongArr[i] = this.mShortCutScoreToLongCache[i];
        i = i + 1;
        goto L8
    L11:
        return newLongArr;
    L15:
        return null;
    }

    public String toString() {
        return "AIPredictResultInfo{typeName='" + this.typeName + ", result=" + this.result + ", preTimeInMillis=" + this.preTimeInMillis + ", preSlotInSeconds=" + this.preSlotInSeconds + ", maxPredCount=" + this.maxPredCount + ", extra='" + this.extra + ", updateCnt=" + this.mDataUpdateCnt + ", changedCnt=" + this.mValidDataChangedCnt + ", lastChanged=" + this.mChangedFlag + ", shortcutcache='" + Arrays.toString(this.mShortCutScoreCache) + ", shortcutcachelong='" + Arrays.toString(this.mShortCutScoreToLongCache) + ", isExpired='" + isExpired() + '}';
    }
}
