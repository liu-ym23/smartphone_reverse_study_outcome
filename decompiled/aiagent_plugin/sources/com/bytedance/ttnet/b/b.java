package com.bytedance.ttnet.b;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: compiled from: CronetDataStorageAccess.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Observable {
    private static final String TAG = "CronetDataStorageAccess";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f11383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f11384b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f11385c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f11386d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f11387e = "";
    private static volatile String f = "";

    static {
    }

    public b() {
    }

    public static b a() {
        if (f11383a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11383a != null) goto L9;
        f11383a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f11383a;
    }

    public void a(String r3, String r4, String r5, String r6, String r7, String r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onStoreIdcChanged idc: " + r3 + " region: " + r4 + " source: " + r5 + " sec_uid:" + r7 + " logid:" + r8);
    L5:
        f11384b = r3;
        f11385c = r4;
        f11386d = r5;
        f11387e = r6;
        f = r7;
        HashMap r0 = new HashMap();
        r0.put("store_idc", r3);
        r0.put("store_region", r4);
        r0.put("region_source", r5);
        r0.put("region_legacy_user", r6);
        r0.put("sec_uid", r7);
        r0.put("logid", r8);
        a(r0);
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        setChanged();
        notifyObservers(r4);
    }
}
