package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LogicalType.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f12968b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f12969c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f12970d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f12971e = null;
    public static final f f = null;
    public static final f g = null;
    public static final f h = null;
    public static final f i = null;
    public static final f j = null;
    public static final f k = null;
    public static final f l = null;
    public static final f m = null;
    private static final /* synthetic */ f[] n = null;

    private f(String r1, int r2) {
        super(r1, r2);
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(n.clone(), f[].class, "com.obric.aiagent.plugin");
    }

    static {
        f r0 = new f("Array", 0);
        f12967a = r0;
        f r1 = new f("Collection", 1);
        f12968b = r1;
        f r3 = new f("Map", 2);
        f12969c = r3;
        f r5 = new f("POJO", 3);
        f12970d = r5;
        f r7 = new f("Untyped", 4);
        f12971e = r7;
        f r9 = new f("Integer", 5);
        f = r9;
        f r11 = new f("Float", 6);
        g = r11;
        f r13 = new f("Boolean", 7);
        h = r13;
        f r15 = new f("Enum", 8);
        i = r15;
        f r14 = new f("Textual", 9);
        j = r14;
        f r12 = new f("Binary", 10);
        k = r12;
        f r10 = new f("DateTime", 11);
        l = r10;
        f r8 = new f("OtherScalar", 12);
        m = r8;
        n = new f[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
    }
}
