package com.bytedance.apm.perf;

import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.ListUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PerfFilterManager {
    private static volatile PerfFilterManager singleton;
    private ConcurrentHashMap<String, String> mPerfFilters;
    private CopyOnWriteArraySet<String> mSceneSet;

    private PerfFilterManager() {
        this.mSceneSet = new CopyOnWriteArraySet();
        this.mPerfFilters = new ConcurrentHashMap();
    }

    public static PerfFilterManager getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(PerfFilterManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new PerfFilterManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PerfFilterManager.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    public void startScene(String r1) {
        this.mSceneSet.add(r1);
    }

    public void stopScene(String r1) {
        this.mSceneSet.remove(r1);
    }

    public void addPerfTag(String r1, String r2) {
        this.mPerfFilters.put(r1, r2);
    }

    public JSONObject getPerfFiltersJson() {
        return getPerfFiltersJson(false);
    }

    public JSONObject getPerfFiltersJson(boolean r4) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r3 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r3.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r3.next();     // Catch: JSONException -> L10
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r4 == false) goto L9;
        DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(r0);     // Catch: JSONException -> L10
        DeviceInfoUtil.getInstance().addConstantDeviceInfo(r0);     // Catch: JSONException -> L10
    L9:
        return r0;
    }

    public String getSceneString() {
        String r1 = ListUtils.arrayToString(this.mSceneSet.toArray(), ContactsUtils.CHAR_POUND);
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    public CopyOnWriteArraySet<String> getSceneSet() {
        return this.mSceneSet;
    }

    public ConcurrentHashMap<String, String> getPerfFilters() {
        return this.mPerfFilters;
    }

    public void removePerfTag(String r1, String r2) {
        this.mPerfFilters.remove(r1, r2);
    }
}
