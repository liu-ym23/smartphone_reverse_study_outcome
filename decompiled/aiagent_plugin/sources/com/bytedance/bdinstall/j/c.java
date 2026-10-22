package com.bytedance.bdinstall.j;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DeviceCategory.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f6307b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f6308c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f6309d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f6310e = null;
    public static final c f = null;
    public static final c g = null;
    private static final /* synthetic */ c[] i = null;
    private String h;

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(i.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("PHONE", 0, "phone");
        f6306a = r0;
        c r1 = new c("PAD", 1, "pad");
        f6307b = r1;
        c r3 = new c("TV", 2, "tv");
        f6308c = r3;
        c r5 = new c("CAR", 3, "car");
        f6309d = r5;
        c r7 = new c("VR", 4, "vr");
        f6310e = r7;
        c r9 = new c("AR", 5, "ar");
        f = r9;
        c r11 = new c("WATCH", 6, "watch");
        g = r11;
        i = new c[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private c(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public String a() {
        return this.h;
    }
}
