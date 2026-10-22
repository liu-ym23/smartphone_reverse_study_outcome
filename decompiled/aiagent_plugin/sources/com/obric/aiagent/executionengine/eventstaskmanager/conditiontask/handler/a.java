package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConditionCheckResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17016b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17017c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f17018d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17019e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    private static final /* synthetic */ a[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final boolean j;

    private static final /* synthetic */ a[] b() {
        return new a[]{f17015a, f17016b, f17017c, f17018d, f17019e, f, g, h, i};
    }

    private a(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.j = r3;
    }

    public final boolean a() {
        return this.j;
    }

    static {
        f17015a = new a("GROUP_CHECK_FAIL", 0, false);
        f17016b = new a("SUCCESS", 1, true);
        f17017c = new a("LOCATION_CHECK_FAIL", 2, false);
        f17018d = new a("TIME_CHECK_FAIL", 3, false);
        f17019e = new a("WIFI_CHECK_FAIL", 4, false);
        f = new a("BLUETOOTH_CHECK_FAIL", 5, false);
        g = new a("BATTERY_CHECK_FAIL", 6, false);
        h = new a("STORAGE_CHECK_FAIL", 7, false);
        i = new a("SMS_CHECK_FAIL", 8, false);
        a[] r0 = b();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(k.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
