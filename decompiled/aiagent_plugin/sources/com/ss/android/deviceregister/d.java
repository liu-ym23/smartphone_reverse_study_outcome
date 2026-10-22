package com.ss.android.deviceregister;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeviceCategory.java */
/* JADX INFO: loaded from: classes4.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f37419a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f37420b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f37421c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f37422d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f37423e = null;
    public static final d f = null;
    public static final d g = null;
    private static final /* synthetic */ d[] i = null;
    private String h;

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(i.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        d r0 = new d("PHONE", 0, "phone");
        f37419a = r0;
        d r1 = new d("PAD", 1, "pad");
        f37420b = r1;
        d r3 = new d("TV", 2, "tv");
        f37421c = r3;
        d r5 = new d("CAR", 3, "car");
        f37422d = r5;
        d r7 = new d("VR", 4, "vr");
        f37423e = r7;
        d r9 = new d("AR", 5, "ar");
        f = r9;
        d r11 = new d("WATCH", 6, "watch");
        g = r11;
        i = new d[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private d(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public String a() {
        return this.h;
    }
}
