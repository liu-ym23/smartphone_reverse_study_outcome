package com.fasterxml.jackson.a.e;

import com.fasterxml.jackson.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonReadFeature.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum d extends Enum<d> implements com.fasterxml.jackson.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f12028b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f12029c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f12030d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f12031e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    private static final /* synthetic */ d[] o = null;
    private final boolean l;
    private final int m;
    private final k.a n;

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(o.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        d r0 = new d("ALLOW_JAVA_COMMENTS", 0, false, k.a.f12139b);
        f12027a = r0;
        d r1 = new d("ALLOW_YAML_COMMENTS", 1, false, k.a.f12140c);
        f12028b = r1;
        d r2 = new d("ALLOW_SINGLE_QUOTES", 2, false, k.a.f12142e);
        f12029c = r2;
        d r4 = new d("ALLOW_UNQUOTED_FIELD_NAMES", 3, false, k.a.f12141d);
        f12030d = r4;
        d r6 = new d("ALLOW_UNESCAPED_CONTROL_CHARS", 4, false, k.a.f);
        f12031e = r6;
        d r8 = new d("ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER", 5, false, k.a.g);
        f = r8;
        d r10 = new d("ALLOW_LEADING_ZEROS_FOR_NUMBERS", 6, false, k.a.h);
        g = r10;
        d r12 = new d("ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS", 7, false, k.a.i);
        h = r12;
        d r14 = new d("ALLOW_NON_NUMERIC_NUMBERS", 8, false, k.a.j);
        i = r14;
        d r13 = new d("ALLOW_MISSING_VALUES", 9, false, k.a.k);
        j = r13;
        d r11 = new d("ALLOW_TRAILING_COMMA", 10, false, k.a.l);
        k = r11;
        o = new d[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11};
    }

    private d(String r1, int r2, boolean r3, k.a r4) {
        super(r1, r2);
        this.l = r3;
        this.m = 1 << ordinal();
        this.n = r4;
    }

    @Override // com.fasterxml.jackson.a.h.h
    public boolean b() {
        return this.l;
    }

    @Override // com.fasterxml.jackson.a.h.h
    public int c() {
        return this.m;
    }

    public k.a a() {
        return this.n;
    }
}
