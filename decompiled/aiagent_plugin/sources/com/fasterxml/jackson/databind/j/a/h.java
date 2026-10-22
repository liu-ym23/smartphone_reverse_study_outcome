package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: MapEntrySerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class h extends com.fasterxml.jackson.databind.j.i<Map.Entry<?, ?>> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f12807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f12809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12811e;
    protected final com.fasterxml.jackson.databind.k f;
    protected com.fasterxml.jackson.databind.p<Object> g;
    protected com.fasterxml.jackson.databind.p<Object> h;
    protected final com.fasterxml.jackson.databind.h.h i;
    protected k j;
    protected final Object k;
    protected final boolean l;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.a.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: MapEntrySerializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12812a = null;

        static {
            int[] r0 = new int[JsonInclude.Include.values().length];
            f12812a = r0;
            r0[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f12812a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f12812a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f12812a[JsonInclude.Include.CUSTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f12812a[JsonInclude.Include.NON_NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f12812a[JsonInclude.Include.ALWAYS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Map.Entry<?, ?> r2) {
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        return true;
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5) {
        a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(ac r3, Object r4) {
        return a(r3, (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Map.Entry<?, ?> r3) {
        return a2((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    static {
        f12807a = JsonInclude.Include.NON_EMPTY;
    }

    public h(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.k r5, boolean r6, com.fasterxml.jackson.databind.h.h r7, com.fasterxml.jackson.databind.d r8) {
        com.fasterxml.jackson.databind.d r9 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12810d = r3;
        this.f12811e = r4;
        this.f = r5;
        this.f12809c = r6;
        this.i = r7;
        this.f12808b = r9;
        this.j = k.a();
        this.k = null;
        this.l = false;
    }

    public h(h r2, com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p<?> r5, com.fasterxml.jackson.databind.p<?> r6, Object r7, boolean r8) {
        com.fasterxml.jackson.databind.d r9 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        super(Map.class, false);
        this.f12810d = r2.f12810d;
        this.f12811e = r2.f12811e;
        this.f = r2.f;
        this.f12809c = r2.f12809c;
        this.i = r2.i;
        this.g = r5;
        this.h = r6;
        this.j = k.a();
        this.f12808b = r2.f12808b;
        this.k = r7;
        this.l = r8;
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r10) {
        return new h(this, this.f12808b, r10, this.g, this.h, this.k, this.l);
    }

    public h a(com.fasterxml.jackson.databind.d r9, com.fasterxml.jackson.databind.p<?> r10, com.fasterxml.jackson.databind.p<?> r11, Object r12, boolean r13) {
        return new h(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r9, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), this.i, r10, r11, r12, r13);
    }

    public h a(Object r10, boolean r11) {
        if (this.k != r10) goto L8;
        if (this.l != r11) goto L8;
        return this;
    L8:
        return new h(this, this.f12808b, this.i, this.g, this.h, r10, r11);
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(ac r10, com.fasterxml.jackson.databind.d r11) {
        com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r11, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r12 = r10.d();
        Object r0 = null;
        if (r1 != null) goto L5;
        com.fasterxml.jackson.databind.e.j r2 = null;
    L6:
        if (r2 == null) goto L16;
        if (r12 == null) goto L16;
        Object r3 = r12.n(r2);
        if (r3 == null) goto L11;
        com.fasterxml.jackson.databind.p<?> r4 = r10.b(r2, r3);
    L12:
        Object r13 = r12.o(r2);
        if (r13 == null) goto L15;
        com.fasterxml.jackson.databind.p<Object> r14 = r10.b(r2, r13);
    L17:
        if (r14 != null) goto L19;
        r14 = this.h;
    L19:
        com.fasterxml.jackson.databind.p<?> r15 = a(r10, r1, r14);
        if (r15 == null) goto L22;
    L26:
        if (r4 != null) goto L28;
        r4 = this.g;
    L28:
        if (r4 != null) goto L30;
        com.fasterxml.jackson.databind.p<?> r5 = r10.d(this.f12811e, r1);
    L31:
        Object r6 = this.k;
        boolean r7 = this.l;
        boolean r8 = true;
        if (r1 == null) goto L64;
        JsonInclude.Value r9 = r1.b(r10.c(), null);
        if (r9 == null) goto L64;
        JsonInclude.Include r16 = r9.getContentInclusion();
        if (r16 == JsonInclude.Include.USE_DEFAULTS) goto L64;
        int r17 = AnonymousClass1.f12812a[r16.ordinal()];
        if (r17 != 1) goto L40;
        Object r18 = com.fasterxml.jackson.databind.l.e.a(this.f);
        if (r18 != null) goto L61;
    L63:
        Object r19 = r18;
    L66:
        return a(r1, r5, r15, r19, r8);
    L61:
        if (r18.getClass().isArray() == false) goto L63;
        r18 = com.fasterxml.jackson.databind.l.c.a(r18);
        goto L63
    L40:
        if (r17 == 2) goto L56;
        if (r17 != 3) goto L44;
        r18 = f12807a;
        goto L63
    L44:
        if (r17 != 4) goto L46;
        r0 = r10.a(null, r9.getContentFilter());
        if (r0 == null) goto L49;
        boolean r110 = r10.b(r0);
    L48:
        r8 = r110;
    L49:
        r19 = r0;
        goto L66
    L46:
        if (r17 == 5) goto L49;
        r110 = false;
        goto L48
    L56:
        if (this.f.a() == false) goto L49;
        r0 = f12807a;
    L64:
        r8 = r7;
        r19 = r6;
        goto L66
    L30:
        r5 = r10.b(r4, r1);
        goto L31
    L22:
        if (this.f12809c == false) goto L26;
        if (this.f.t() == true) goto L26;
        r15 = r10.c(this.f, r1);
        goto L26
    L15:
        r14 = null;
        goto L17
    L11:
        r4 = null;
    L16:
        r14 = null;
        r4 = null;
        goto L17
    L5:
        r2 = r1.d();
        goto L6
    }

    public com.fasterxml.jackson.databind.k d() {
        return this.f;
    }

    public boolean a(ac r4, Map.Entry<?, ?> r5) {
        Object r6 = ((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.aiagent.plugin")).getValue();
        if (r6 != null) goto L7;
        return this.l;
    L7:
        if (this.k != null) goto L9;
        return false;
    L9:
        com.fasterxml.jackson.databind.p<Object> r0 = this.h;
        if (r0 != null) goto L17;
        Class<?> r1 = r6.getClass();
        com.fasterxml.jackson.databind.p<Object> r2 = this.j.a(r1);
        if (r2 == null) goto L23;
        r0 = r2;
        goto L17
    L23:
        r0 = a(this.j, r1, r4);     // Catch: com.fasterxml.jackson.databind.m -> L15
    L15:
        return false;
    L17:
        Object r3 = this.k;
        if (r3 != f12807a) goto L22;
        return r0.a(r4, r6);
    L22:
        return r3.equals(r6);
    }

    public void a(Map.Entry<?, ?> r3, com.fasterxml.jackson.a.h r4, ac r5) {
        Map.Entry<?, ?> r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        r4.c(r6);
        b(r6, r4, r5);
        r4.k();
    }

    public void a(Map.Entry<?, ?> r3, com.fasterxml.jackson.a.h r4, ac r5, com.fasterxml.jackson.databind.h.h r6) {
        Map.Entry<?, ?> r7 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        r4.a(r7);
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r7, com.fasterxml.jackson.a.n.f12152b));
        b(r7, r4, r5);
        r6.b(r4, r0);
    }

    public void b(Map.Entry<?, ?> r8, com.fasterxml.jackson.a.h r9, ac r10) {
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r8, Map.Entry.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = this.i;
        Object r1 = r11.getKey();
        if (r1 != null) goto L5;
        com.fasterxml.jackson.databind.p<Object> r2 = r10.e(this.f12811e, this.f12808b);
    L6:
        Object r3 = r11.getValue();
        if (r3 == null) goto L9;
        com.fasterxml.jackson.databind.p<Object> r4 = this.h;
        if (r4 != null) goto L21;
        Class<?> r5 = r3.getClass();
        com.fasterxml.jackson.databind.p<Object> r6 = this.j.a(r5);
        if (r6 == null) goto L17;
        r4 = r6;
        goto L21
    L17:
        if (this.f.v() == false) goto L19;
        r4 = a(this.j, r10.a(this.f, r5), r10);
        goto L21
    L19:
        r4 = a(this.j, r5, r10);
    L21:
        Object r7 = this.k;
        if (r7 != null) goto L24;
    L31:
        r2.a(r1, r9, r10);
        if (r0 != null) goto L34;
        r4.a(r3, r9, r10);     // Catch: Exception -> L36
    L39:
        return;
    L34:
        r4.a(r3, r9, r10, r0);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        a(r10, e, r11, "" + r1);
        return;
    L24:
        if (r7 != f12807a) goto L29;
        if (r4.a(r10, r3) == false) goto L29;
        return;
    L29:
        if (this.k.equals(r3) == false) goto L31;
        return;
    L9:
        if (this.l == false) goto L11;
        return;
    L11:
        r4 = r10.k();
        goto L31
    L5:
        r2 = this.g;
        goto L6
    }

    public final com.fasterxml.jackson.databind.p<Object> a(k r2, Class<?> r3, ac r4) {
        k.d r5 = r2.b(r3, r4, this.f12808b);
        if (r2 == r5.f12828b) goto L6;
        this.j = r5.f12828b;
    L6:
        return r5.f12827a;
    }

    public final com.fasterxml.jackson.databind.p<Object> a(k r2, com.fasterxml.jackson.databind.k r3, ac r4) {
        k.d r5 = r2.b(r3, r4, this.f12808b);
        if (r2 == r5.f12828b) goto L6;
        this.j = r5.f12828b;
    L6:
        return r5.f12827a;
    }
}
