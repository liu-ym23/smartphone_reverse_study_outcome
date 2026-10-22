package com.fasterxml.jackson.databind.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoercionInputShape.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f12200b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f12201c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f12202d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f12203e = null;
    public static final e f = null;
    public static final e g = null;
    public static final e h = null;
    public static final e i = null;
    public static final e j = null;
    private static final /* synthetic */ e[] k = null;

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(k.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    static {
        e r0 = new e("Array", 0);
        f12199a = r0;
        e r1 = new e("Object", 1);
        f12200b = r1;
        e r3 = new e("Integer", 2);
        f12201c = r3;
        e r5 = new e("Float", 3);
        f12202d = r5;
        e r7 = new e("Boolean", 4);
        f12203e = r7;
        e r9 = new e("String", 5);
        f = r9;
        e r11 = new e("Binary", 6);
        g = r11;
        e r13 = new e("EmptyArray", 7);
        h = r13;
        e r15 = new e("EmptyObject", 8);
        i = r15;
        e r14 = new e("EmptyString", 9);
        j = r14;
        k = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }
}
