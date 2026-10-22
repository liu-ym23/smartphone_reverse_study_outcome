package com.bytedance.memory.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BaseType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8808b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8809c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8810d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8811e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    private static Map<Integer, a> j;
    private static final /* synthetic */ a[] m = null;
    private int k;
    private int l;

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(m.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        int r2 = 0;
        a r0 = new a("OBJECT", 0, 2, 0);
        f8807a = r0;
        a r1 = new a("BOOLEAN", 1, 4, 1);
        f8808b = r1;
        a r4 = new a("CHAR", 2, 5, 2);
        f8809c = r4;
        a r7 = new a("FLOAT", 3, 6, 4);
        f8810d = r7;
        a r9 = new a("DOUBLE", 4, 7, 8);
        f8811e = r9;
        a r12 = new a("BYTE", 5, 8, 1);
        f = r12;
        a r15 = new a("SHORT", 6, 9, 2);
        g = r15;
        a r8 = new a("INT", 7, 10, 4);
        h = r8;
        a r3 = new a("LONG", 8, 11, 8);
        i = r3;
        m = new a[]{r0, r1, r4, r7, r9, r12, r15, r8, r3};
        j = new HashMap();
        a[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r2 >= r6) goto L5;
        a r10 = r5[r2];
        j.put(Integer.valueOf(r10.k), r10);
        r2 = r2 + 1;
        goto L3
    }

    private a(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.k = r3;
        this.l = r4;
    }

    public static a getType(int r2) {
        return (a) ZeusTransformUtils.preCheckCast(j.get(Integer.valueOf(r2)), a.class, "com.obric.aiagent.plugin");
    }

    public int a(int r1) {
        int r0 = this.l;
        if (r0 != 0) goto L5;
        return r1;
    L5:
        return r0;
    }
}
