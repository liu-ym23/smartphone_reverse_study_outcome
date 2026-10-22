package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: EnumDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class k extends ae<Object> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object[] f12429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.i f12430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l.i f12431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Boolean f12432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12433e;
    private final Enum<?> f;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.b.k$1, reason: invalid class name */
    /* JADX INFO: compiled from: EnumDeserializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12434a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.b.values().length];
            f12434a = r0;
            r0[com.fasterxml.jackson.databind.a.b.f12187c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12434a[com.fasterxml.jackson.databind.a.b.f12188d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12434a[com.fasterxml.jackson.databind.a.b.f12186b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    public k(com.fasterxml.jackson.databind.l.k r2, Boolean r3) {
        super(r2.e());
        this.f12430b = r2.a();
        this.f12429a = r2.c();
        this.f = r2.b();
        this.f12432d = r3;
        this.f12433e = r2.f();
    }

    public k(k r2, Boolean r3) {
        super(r2);
        this.f12430b = r2.f12430b;
        this.f12429a = r2.f12429a;
        this.f = r2.f;
        this.f12432d = r3;
        this.f12433e = r2.f12433e;
    }

    public static com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.g r7, Class<?> r8, com.fasterxml.jackson.databind.e.k r9, com.fasterxml.jackson.databind.b.y r10, com.fasterxml.jackson.databind.b.v[] r11) {
        if (r7.g() == false) goto L6;
        com.fasterxml.jackson.databind.l.h.a(r9.h(), r7.a(com.fasterxml.jackson.databind.r.o));
    L6:
        return new n(r8, r9, r9.b(0), r10, r11);
    }

    public static com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.g r2, Class<?> r3, com.fasterxml.jackson.databind.e.k r4) {
        if (r2.g() == false) goto L6;
        com.fasterxml.jackson.databind.l.h.a(r4.h(), r2.a(com.fasterxml.jackson.databind.r.o));
    L6:
        return new n(r3, r4);
    }

    public k a(Boolean r2) {
        if (Objects.equals(this.f12432d, r2) == false) goto L6;
        return this;
    L6:
        return new k(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
        Boolean r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a(), JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        if (r5 != null) goto L6;
        r5 = this.f12432d;
    L6:
        return a(r5);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.i;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.a(com.fasterxml.jackson.a.n.h) == false) goto L7;
        return a(r2, r3, r2.x());
    L7:
        if (r2.a(com.fasterxml.jackson.a.n.i) == false) goto L15;
        if (this.f12433e == false) goto L13;
        return a(r2, r3, r2.x());
    L13:
        return a(r2, r3, r2.H());
    L15:
        if (r2.r() == false) goto L19;
        return a(r2, r3, r3.a(r2, this, this.B));
    L19:
        return b(r2, r3);
    }

    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, String r5) {
        if (r4.a(com.fasterxml.jackson.databind.i.w) == false) goto L5;
        com.fasterxml.jackson.databind.l.i r0 = d(r4);
    L6:
        Object r1 = r0.a(r5);
        if (r1 != null) goto L16;
        String r2 = r5.trim();
        if (r2 == r5) goto L15;
        Object r6 = r0.a(r2);
        if (r6 == null) goto L15;
        return r6;
    L15:
        return a(r3, r4, r0, r2);
    L16:
        return r1;
    L5:
        r0 = this.f12430b;
        goto L6
    }

    public Object a(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, int r11) {
        com.fasterxml.jackson.databind.a.b r12 = r10.a(b(), a(), com.fasterxml.jackson.databind.a.e.f12201c);
        if (r12 == com.fasterxml.jackson.databind.a.b.f12185a) goto L5;
    L9:
        int r13 = AnonymousClass1.f12434a[r12.ordinal()];
        if (r13 != 1) goto L12;
        return null;
    L12:
        if (r13 == 2) goto L30;
        if (r11 < 0) goto L19;
        Object[] r14 = this.f12429a;
        if (r11 >= r14.length) goto L19;
        return r14[r11];
    L19:
        if (this.f == null) goto L25;
        if (r10.a(com.fasterxml.jackson.databind.i.y) == false) goto L25;
        return this.f;
    L25:
        if (r10.a(com.fasterxml.jackson.databind.i.x) == false) goto L27;
        return null;
    L27:
        return r10.a(h(), Integer.valueOf(r11), "index value outside legal index range [0..%s]", new Object[]{Integer.valueOf(this.f12429a.length - 1)});
    L30:
        return c(r10);
    L5:
        if (r10.a(com.fasterxml.jackson.databind.i.g) == true) goto L7;
        a(r10, r12, a(), Integer.valueOf(r11), "Integer value (" + r11 + ")");
        goto L9
    L7:
        return r10.a(h(), Integer.valueOf(r11), "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
    }

    private final Object a(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, com.fasterxml.jackson.databind.l.i r11, String r12) {
        String r13 = r12.trim();
        if (r13.isEmpty() == false) goto L25;
        if (this.f == null) goto L11;
        if (r10.a(com.fasterxml.jackson.databind.i.y) == false) goto L11;
        return this.f;
    L11:
        if (r10.a(com.fasterxml.jackson.databind.i.x) == false) goto L14;
        return null;
    L14:
        if (r12.isEmpty() == false) goto L16;
        com.fasterxml.jackson.databind.a.b r14 = a(r10, h(r10), a(), r12, "empty String (\"\")");
    L17:
        int r15 = AnonymousClass1.f12434a[r14.ordinal()];
        if (r15 == 2) goto L23;
        if (r15 == 3) goto L23;
        return null;
    L23:
        return c(r10);
    L16:
        r14 = a(r10, j(r10), a(), r12, "blank String (all whitespace)");
        goto L17
    L25:
        if (Boolean.TRUE.equals(this.f12432d) == false) goto L30;
        Object r16 = r11.b(r13);
        if (r16 == null) goto L47;
        return r16;
    L47:
        if (this.f == null) goto L53;
        if (r10.a(com.fasterxml.jackson.databind.i.y) == false) goto L53;
        return this.f;
    L53:
        if (r10.a(com.fasterxml.jackson.databind.i.x) == false) goto L56;
        return null;
    L56:
        return r10.b(h(), r13, "not one of the values accepted for Enum class: %s", new Object[]{r11.a()});
    L30:
        if (r10.a(com.fasterxml.jackson.databind.i.g) == true) goto L47;
        if (this.f12433e == true) goto L47;
        char r17 = r13.charAt(0);
        if (r17 < '0') goto L47;
        if (r17 > '9') goto L47;
        int r18 = Integer.parseInt(r13);     // Catch: NumberFormatException -> L57
        if (r10.a(com.fasterxml.jackson.databind.r.B) == false) goto L40;
        if (r18 < 0) goto L47;
        Object[] r2 = this.f12429a;     // Catch: NumberFormatException -> L57
        if (r18 >= r2.length) goto L47;
        return r2[r18];
    L40:
        return r10.b(h(), r13, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
    }

    public Object b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.a(com.fasterxml.jackson.a.n.f12154d) == false) goto L7;
        return e(r2, r3);
    L7:
        return r3.a(h(), r2);
    }

    public Class<?> h() {
        return a();
    }

    public com.fasterxml.jackson.databind.l.i d(com.fasterxml.jackson.databind.h r2) {
        com.fasterxml.jackson.databind.l.i r0 = this.f12431c;
        if (r0 != null) goto L11;
        monitor-enter(this);
        r0 = com.fasterxml.jackson.databind.l.k.b(r2.c(), h()).a();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f12431c = r0;
    L8:
        th = move-exception;
        throw th;
    L11:
        return r0;
    }
}
