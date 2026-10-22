package org.c.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CommentType.java */
/* JADX INFO: loaded from: classes5.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f40340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f40341b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f40342c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f40343d = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f40343d.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("BLANK_LINE", 0);
        f40340a = r0;
        c r1 = new c("BLOCK", 1);
        f40341b = r1;
        c r3 = new c("IN_LINE", 2);
        f40342c = r3;
        f40343d = new c[]{r0, r1, r3};
    }
}
