package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectPolicyModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f26393b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f26394c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f26395d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f26396e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    private static final /* synthetic */ a[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final String i;
    private final String j;

    public static d.d.a<a> c() {
        return l;
    }

    private static final /* synthetic */ a[] d() {
        return new a[]{f26392a, f26393b, f26394c, f26395d, f26396e, f, g, h};
    }

    private a(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.i = r3;
        this.j = r4;
    }

    /* synthetic */ a(String r1, int r2, String r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = r3;
    L5:
        this(r1, r2, r3, r4);
    }

    public final String a() {
        return this.i;
    }

    public final String b() {
        return this.j;
    }

    static {
        f26392a = new a("CLICK", 0, "click", null, 2, null);
        String r12 = null;
        int r13 = 2;
        d.h.b.h r14 = null;
        f26393b = new a("DOUBLE_CLICK", 1, "double_click", r12, r13, r14);
        f26394c = new a("LONG_PRESS", 2, "long_press", null, 2, null);
        f26395d = new a("TYPE", 3, "type", r12, r13, r14);
        f26396e = new a("TYPE_ENTER", 4, "type", "type_enter");
        f = new a("SWIPE", 5, "swipe", null, 2, null);
        g = new a("OPEN_APP", 6, "open_app", null, 2, null);
        h = new a("PRESS_BACK", 7, "press_back", null, 2, null);
        a[] r0 = d();
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
