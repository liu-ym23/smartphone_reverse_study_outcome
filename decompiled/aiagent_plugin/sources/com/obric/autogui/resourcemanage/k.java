package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestScene.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f30631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f30632b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f30633c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f30634d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f30635e = null;
    public static final k f = null;
    public static final k g = null;
    public static final k h = null;
    private static final /* synthetic */ k[] i = null;
    private static final /* synthetic */ d.d.a j = null;

    private static final /* synthetic */ k[] a() {
        return new k[]{f30631a, f30632b, f30633c, f30634d, f30635e, f, g, h};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f30631a = new k("COLD_START", 0);
        f30632b = new k("FORCE", 1);
        f30633c = new k("BACKGROUND", 2);
        f30634d = new k("LOOP", 3);
        f30635e = new k("WIFI_AVAILABLE", 4);
        f = new k("SETTINGS_READY", 5);
        g = new k("ON_DEMAND", 6);
        h = new k("SCRIPT_START_FAILED", 7);
        k[] r0 = a();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static k valueOf(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.aiagent.plugin");
    }

    public static k[] values() {
        return (k[]) ZeusTransformUtils.preCheckCast(i.clone(), k[].class, "com.obric.aiagent.plugin");
    }
}
