package com.fasterxml.jackson.databind.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonNodeType.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f12788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f12789b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f12790c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f12791d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f12792e = null;
    public static final m f = null;
    public static final m g = null;
    public static final m h = null;
    public static final m i = null;
    private static final /* synthetic */ m[] j = null;

    private m(String r1, int r2) {
        super(r1, r2);
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(j.clone(), m[].class, "com.obric.aiagent.plugin");
    }

    static {
        m r0 = new m("ARRAY", 0);
        f12788a = r0;
        m r1 = new m("BINARY", 1);
        f12789b = r1;
        m r3 = new m("BOOLEAN", 2);
        f12790c = r3;
        m r5 = new m("MISSING", 3);
        f12791d = r5;
        m r7 = new m("NULL", 4);
        f12792e = r7;
        m r9 = new m("NUMBER", 5);
        f = r9;
        m r11 = new m("OBJECT", 6);
        g = r11;
        m r13 = new m("POJO", 7);
        h = r13;
        m r15 = new m("STRING", 8);
        i = r15;
        j = new m[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }
}
