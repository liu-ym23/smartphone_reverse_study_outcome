package com.a.c.b.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SpecialChar.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3133b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f3134c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f3135d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f3136e = null;
    public static final c f = null;
    private static final /* synthetic */ c[] g = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(g.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("LW", 0);
        f3132a = r0;
        c r1 = new c("L", 1);
        f3133b = r1;
        c r3 = new c("W", 2);
        f3134c = r3;
        c r5 = new c("HASH", 3);
        f3135d = r5;
        c r7 = new c("QUESTION_MARK", 4);
        f3136e = r7;
        c r9 = new c("NONE", 5);
        f = r9;
        g = new c[]{r0, r1, r3, r5, r7, r9};
    }
}
