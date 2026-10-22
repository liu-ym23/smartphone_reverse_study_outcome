package androidx.sqlite.db;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SimpleSQLiteQuery.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f2731b;

    public a(String r1, Object[] r2) {
        this.f2730a = r1;
        this.f2731b = r2;
    }

    public a(String r2) {
        this(r2, null);
    }

    @Override // androidx.sqlite.db.f
    public String b() {
        return this.f2730a;
    }

    @Override // androidx.sqlite.db.f
    public void a(e r3) {
        a((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin"), this.f2731b);
    }

    public static void a(e r3, Object[] r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Object r2 = r4[r1];
        r1 = r1 + 1;
        a(r5, r1, r2);
        goto L6
    }

    private static void a(e r2, int r3, Object r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        r5.a(r3);
        return;
    L6:
        if ((r4 instanceof byte[]) == false) goto L9;
        r5.a(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L12;
        r5.a(r3, ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L15;
        r5.a(r3, ((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.aiagent.plugin")).doubleValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L18;
        r5.a(r3, ((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L21;
        r5.a(r3, ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L24;
        r5.a(r3, ((Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.aiagent.plugin")).shortValue());
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L27;
        r5.a(r3, ((Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.aiagent.plugin")).byteValue());
        return;
    L27:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L30;
        r5.a(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        return;
    L30:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L38;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L34;
        long r0 = 1;
    L35:
        r5.a(r3, r0);
        return;
    L34:
        r0 = 0;
        goto L35
    L38:
        throw new IllegalArgumentException("Cannot bind " + r4 + " at index " + r3 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}
