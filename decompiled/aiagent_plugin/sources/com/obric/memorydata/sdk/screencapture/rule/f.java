package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f33895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f33896b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f33897c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f33898d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ f[] f33899e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ f[] a() {
        return new f[]{f33895a, f33896b, f33897c, f33898d};
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33895a = new f("EVENT", 0);
        f33896b = new f("SOURCE", 1);
        f33897c = new f("ROOT_VIEW_TREE", 2);
        f33898d = new f("TOUCH_POSITION", 3);
        f[] r0 = a();
        f33899e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f33899e.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
