package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: POJOPropertyBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class ae extends t implements Comparable<ae> {
    private static final com.fasterxml.jackson.databind.b.a m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f12580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.m<?> f12581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.x f12583e;
    protected final com.fasterxml.jackson.databind.x f;
    protected a<h> g;
    protected a<n> h;
    protected a<k> i;
    protected a<k> j;
    protected transient com.fasterxml.jackson.databind.w k;
    protected transient com.fasterxml.jackson.databind.b.a l;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.e.ae$6, reason: invalid class name */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12589a = null;

        static {
            int[] r0 = new int[JsonProperty.Access.values().length];
            f12589a = r0;
            r0[JsonProperty.Access.READ_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f12589a[JsonProperty.Access.READ_WRITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f12589a[JsonProperty.Access.WRITE_ONLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f12589a[JsonProperty.Access.AUTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    protected static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f12590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<T> f12591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.x f12592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f12593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f12594e;
        public final boolean f;

        public a(T r1, a<T> r2, com.fasterxml.jackson.databind.x r3, boolean r4, boolean r5, boolean r6) {
            this.f12590a = r1;
            this.f12591b = r2;
            if (r3 != null) goto L5;
        L8:
            com.fasterxml.jackson.databind.x r7 = null;
        L9:
            this.f12592c = r7;
            if (r4 == false) goto L17;
            if (r7 == null) goto L16;
            if (r3.c() == true) goto L17;
            r4 = false;
            goto L17
        L16:
            throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
        L17:
            this.f12593d = r4;
            this.f12594e = r5;
            this.f = r6;
            return;
        L5:
            if (r3.e() == true) goto L8;
            r7 = r3;
            goto L9
        }

        public a<T> a() {
            if (this.f12591b != null) goto L6;
            return this;
        L6:
            return new a(this.f12590a, null, this.f12592c, this.f12593d, this.f12594e, this.f);
        }

        public a<T> a(T r9) {
            if (r9 != this.f12590a) goto L6;
            return this;
        L6:
            return new a(r9, this.f12591b, this.f12592c, this.f12593d, this.f12594e, this.f);
        }

        public a<T> a(a<T> r9) {
            if (r9 != this.f12591b) goto L6;
            return this;
        L6:
            return new a(this.f12590a, r9, this.f12592c, this.f12593d, this.f12594e, this.f);
        }

        public a<T> b() {
            if (this.f == false) goto L9;
            a<T> r2 = this.f12591b;
            if (r2 != null) goto L8;
            return null;
        L8:
            return r2.b();
        L9:
            a<T> r0 = this.f12591b;
            if (r0 == null) goto L16;
            a<T> r1 = r0.b();
            if (r1 != this.f12591b) goto L14;
            return this;
        L14:
            return a(r1);
        L16:
            return this;
        }

        public a<T> c() {
            a<T> r0 = this.f12591b;
            if (r0 != null) goto L5;
            a<T> r1 = null;
        L7:
            if (this.f12594e == true) goto L9;
            return r1;
        L9:
            return a(r1);
        L5:
            r1 = r0.c();
            goto L7
        }

        public a<T> b(a<T> r2) {
            a<T> r0 = this.f12591b;
            if (r0 != null) goto L7;
            return a(r2);
        L7:
            return a(r0.b(r2));
        }

        public a<T> d() {
            a<T> r0 = this.f12591b;
            if (r0 != null) goto L5;
            return this;
        L5:
            a<T> r1 = r0.d();
            if (this.f12592c == null) goto L14;
            if (r1.f12592c != null) goto L12;
            return a(null);
        L12:
            return a(r1);
        L14:
            if (r1.f12592c == null) goto L16;
            return r1;
        L16:
            boolean r2 = this.f12594e;
            if (r2 == r1.f12594e) goto L19;
            if (r2 == true) goto L22;
            return r1;
        L22:
            return a(null);
        L19:
            return a(r1);
        }

        public String toString() {
            String r0 = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", new Object[]{this.f12590a.toString(), Boolean.valueOf(this.f12594e), Boolean.valueOf(this.f), Boolean.valueOf(this.f12593d)});
            if (this.f12591b != null) goto L5;
            return r0;
        L5:
            return r0 + ", " + this.f12591b.toString();
        }
    }

    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    protected static class b<T extends j> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a<T> f12595a;

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        public b(a<T> r1) {
            this.f12595a = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12595a == null) goto L5;
            return true;
        L5:
            return false;
        }

        public T a() {
            a<T> r0 = this.f12595a;
            if (r0 == null) goto L7;
            T r1 = (T) ZeusTransformUtils.preCheckCast(r0.f12590a, j.class, "com.obric.aiagent.plugin");
            this.f12595a = this.f12595a.f12591b;
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    private interface c<T> {
        T b(j r1);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ae r3) {
        return a((ae) ZeusTransformUtils.preCheckCast(r3, ae.class, "com.obric.aiagent.plugin"));
    }

    static {
        m = com.fasterxml.jackson.databind.b.a.a("");
    }

    public ae(com.fasterxml.jackson.databind.a.m<?> r7, com.fasterxml.jackson.databind.b r8, boolean r9, com.fasterxml.jackson.databind.x r10) {
        this(r7, r8, r9, r10, r10);
    }

    public ae(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.b r2, boolean r3, com.fasterxml.jackson.databind.x r4, com.fasterxml.jackson.databind.x r5) {
        this.f12581c = r1;
        this.f12582d = r2;
        this.f = r4;
        this.f12583e = r5;
        this.f12580b = r3;
    }

    public ae(ae r2, com.fasterxml.jackson.databind.x r3) {
        this.f12581c = r2.f12581c;
        this.f12582d = r2.f12582d;
        this.f = r2.f;
        this.f12583e = r3;
        this.g = r2.g;
        this.h = r2.h;
        this.i = r2.i;
        this.j = r2.j;
        this.f12580b = r2.f12580b;
    }

    public ae b(com.fasterxml.jackson.databind.x r2) {
        return new ae(this, r2);
    }

    public ae a(String r2) {
        com.fasterxml.jackson.databind.x r3 = this.f12583e.b(r2);
        if (r3 != this.f12583e) goto L6;
        return this;
    L6:
        return new ae(this, r3);
    }

    public int a(ae r2) {
        if (this.h == null) goto L9;
        if (r2.h != null) goto L13;
        return -1;
    L13:
        return a().compareTo(r2.a());
    L9:
        if (r2.h == null) goto L13;
        return 1;
    }

    @Override // com.fasterxml.jackson.databind.e.t, com.fasterxml.jackson.databind.l.r
    public String a() {
        com.fasterxml.jackson.databind.x r0 = this.f12583e;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.b();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.x b() {
        return this.f12583e;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean a(com.fasterxml.jackson.databind.x r1) {
        return this.f12583e.equals(r1);
    }

    public String C() {
        return this.f.b();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.x c() {
        j r0 = v();
        if (r0 == null) goto L8;
        com.fasterxml.jackson.databind.b r1 = this.f12582d;
        if (r1 == null) goto L8;
        return r1.g(r0);
    L8:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean d() {
        if (e(this.g) == false) goto L5;
    L12:
        return true;
    L5:
        if (e(this.i) == true) goto L12;
        if (e(this.j) == true) goto L12;
        if (f(this.h) == true) goto L12;
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean e() {
        if (f(this.g) == false) goto L5;
    L12:
        return true;
    L5:
        if (f(this.i) == true) goto L12;
        if (f(this.j) == true) goto L12;
        if (f(this.h) == true) goto L12;
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.w h() {
        if (this.k != null) goto L21;
        j r0 = H();
        if (r0 != null) goto L7;
        this.k = com.fasterxml.jackson.databind.w.f13127c;
        goto L21
    L7:
        Boolean r1 = this.f12582d.f(r0);
        String r2 = this.f12582d.i(r0);
        Integer r3 = this.f12582d.j(r0);
        String r4 = this.f12582d.h(r0);
        if (r1 != null) goto L16;
        if (r3 != null) goto L16;
        if (r4 != null) goto L16;
        com.fasterxml.jackson.databind.w r5 = com.fasterxml.jackson.databind.w.f13127c;
        if (r2 == null) goto L15;
        r5 = r5.a(r2);
    L15:
        this.k = r5;
    L18:
        if (this.f12580b == true) goto L21;
        this.k = a(this.k, r0);
    L16:
        this.k = com.fasterxml.jackson.databind.w.a(r1, r2, r3, r4);
    L21:
        return this.k;
    }

    public com.fasterxml.jackson.databind.w a(com.fasterxml.jackson.databind.w r7, j r8) {
        j r0 = s();
        boolean r1 = false;
        Nulls r2 = null;
        boolean r3 = true;
        if (r8 == null) goto L33;
        com.fasterxml.jackson.databind.b r4 = this.f12582d;
        if (r4 == null) goto L16;
        if (r0 == null) goto L13;
        Boolean r5 = r4.E(r8);
        if (r5 == null) goto L13;
        if (r5.booleanValue() == false) goto L12;
        r7 = r7.a(com.fasterxml.jackson.databind.w.a.c(r0));
    L12:
        r3 = false;
    L13:
        JsonSetter.Value r6 = this.f12582d.D(r8);
        if (r6 == null) goto L16;
        r2 = r6.nonDefaultValueNulls();
        Nulls r9 = r6.nonDefaultContentNulls();
    L17:
        if (r3 == true) goto L20;
        if (r2 == null) goto L20;
        if (r9 == null) goto L20;
    L34:
        r1 = r3;
    L35:
        if (r1 == true) goto L38;
        if (r2 == null) goto L38;
        if (r9 == null) goto L38;
    L48:
        if (r2 != null) goto L51;
        if (r9 != null) goto L51;
        return r7;
    L51:
        return r7.a(r2, r9);
    L38:
        JsonSetter.Value r10 = this.f12581c.p();
        if (r2 != null) goto L41;
        r2 = r10.nonDefaultValueNulls();
    L41:
        if (r9 != null) goto L43;
        r9 = r10.nonDefaultContentNulls();
    L43:
        if (r1 == false) goto L48;
        if (Boolean.TRUE.equals(this.f12581c.q()) == false) goto L48;
        if (r0 == null) goto L48;
        r7 = r7.a(com.fasterxml.jackson.databind.w.a.a(r0));
    L20:
        com.fasterxml.jackson.databind.a.g r11 = this.f12581c.d(a(r8));
        JsonSetter.Value r12 = r11.g();
        if (r12 == null) goto L26;
        if (r2 != null) goto L24;
        r2 = r12.nonDefaultValueNulls();
    L24:
        if (r9 != null) goto L26;
        r9 = r12.nonDefaultContentNulls();
    L26:
        if (r3 == false) goto L34;
        if (r0 == null) goto L34;
        Boolean r13 = r11.i();
        if (r13 == null) goto L34;
        if (r13.booleanValue() == false) goto L35;
        r7 = r7.a(com.fasterxml.jackson.databind.w.a.b(r0));
    L16:
        r9 = null;
        goto L17
    L33:
        r9 = null;
        goto L34
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.k f() {
        if (this.f12580b == false) goto L12;
        com.fasterxml.jackson.databind.e.b r0 = n();
        if (r0 != null) goto L11;
        r0 = p();
        if (r0 != null) goto L11;
        return com.fasterxml.jackson.databind.k.o.c();
    L11:
        return r0.getType();
    L12:
        com.fasterxml.jackson.databind.e.b r1 = q();
        if (r1 != null) goto L19;
        k r2 = o();
        if (r2 != null) goto L17;
        r1 = p();
        goto L19
    L17:
        return ((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin")).b(0);
    L19:
        if (r1 != null) goto L25;
        r1 = n();
        if (r1 != null) goto L25;
        return com.fasterxml.jackson.databind.k.o.c();
    L25:
        return r1.getType();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public Class<?> g() {
        return f().e();
    }

    public boolean D() {
        if (this.i == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean k() {
        if (this.j == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean l() {
        if (this.g == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean m() {
        if (this.h == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean i() {
        if (this.h == null) goto L5;
    L10:
        return true;
    L5:
        if (this.j != null) goto L10;
        if (this.g != null) goto L10;
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean j() {
        if (this.i == null) goto L5;
    L8:
        return true;
    L5:
        if (this.g != null) goto L8;
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public k n() {
        a r0 = this.i;
        if (r0 != null) goto L6;
        return null;
    L6:
        a r1 = r0.f12591b;
        if (r1 == null) goto L9;
    L10:
        if (r1 == null) goto L26;
        Class<?> r3 = ((k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin")).f();
        Class<?> r4 = ((k) ZeusTransformUtils.preCheckCast(r1.f12590a, k.class, "com.obric.aiagent.plugin")).f();
        if (r3 != r4) goto L14;
    L19:
        int r5 = a((k) ZeusTransformUtils.preCheckCast(r1.f12590a, k.class, "com.obric.aiagent.plugin"));
        int r6 = a((k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin"));
        if (r5 == r6) goto L25;
        if (r5 >= r6) goto L23;
    L22:
        r0 = r1;
    L23:
        r1 = r1.f12591b;
        goto L10
    L25:
        throw new IllegalArgumentException("Conflicting getter definitions for property \"" + a() + "\": " + ((k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin")).i() + " vs " + ((k) ZeusTransformUtils.preCheckCast(r1.f12590a, k.class, "com.obric.aiagent.plugin")).i());
    L14:
        if (r3.isAssignableFrom(r4) == true) goto L22;
        if (r4.isAssignableFrom(r3) == false) goto L19;
    L26:
        this.i = r0.a();
        return (k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin");
    L9:
        return (k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin");
    }

    public k E() {
        a<k> r2 = this.i;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (k) ZeusTransformUtils.preCheckCast(r2.f12590a, k.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.e.t
    public k o() {
        a r0 = this.j;
        if (r0 != null) goto L6;
        return null;
    L6:
        a r1 = r0.f12591b;
        if (r1 == null) goto L9;
    L10:
        if (r1 == null) goto L20;
        k r3 = a((k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.preCheckCast(r1.f12590a, k.class, "com.obric.aiagent.plugin"));
        if (r3 == r0.f12590a) goto L17;
        if (r3 != r1.f12590a) goto L19;
        r0 = r1;
        goto L17
    L19:
        return a(r0, r1);
    L17:
        r1 = r1.f12591b;
        goto L10
    L20:
        this.j = r0.a();
        return (k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin");
    L9:
        return (k) ZeusTransformUtils.preCheckCast(r0.f12590a, k.class, "com.obric.aiagent.plugin");
    }

    public k F() {
        a<k> r2 = this.j;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (k) ZeusTransformUtils.preCheckCast(r2.f12590a, k.class, "com.obric.aiagent.plugin");
    }

    public k a(a<k> r6, a<k> r7) {
        ArrayList r0 = new ArrayList();
        r0.add(r6.f12590a);
        r0.add(r7.f12590a);
        a r8 = r7.f12591b;
        a r9 = r6;
    L4:
        if (r8 == null) goto L14;
        k r1 = a((k) ZeusTransformUtils.preCheckCast(r9.f12590a, k.class, "com.obric.aiagent.plugin"), (k) ZeusTransformUtils.preCheckCast(r8.f12590a, k.class, "com.obric.aiagent.plugin"));
        if (r1 == r9.f12590a) goto L12;
        if (r1 != r8.f12590a) goto L11;
        r0.clear();
        r9 = r8;
        goto L12
    L11:
        r0.add(r8.f12590a);
    L12:
        r8 = r8.f12591b;
        r9 = r9;
        goto L4
    L14:
        if (r0.isEmpty() == false) goto L18;
        this.j = r9.a();
        return (k) ZeusTransformUtils.preCheckCast(r9.f12590a, k.class, "com.obric.aiagent.plugin");
    L18:
        throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s", new Object[]{a(), (String) ZeusTransformUtils.preCheckCast(r0.stream().map($$Lambda$2UN4bD49xz4fgHdwM4tGf65bnoM.INSTANCE).collect(Collectors.joining(" vs ")), String.class, "com.obric.aiagent.plugin")}));
    }

    public k a(k r4, k r5) {
        Class<?> r0 = r4.f();
        Class<?> r1 = r5.f();
        if (r0 != r1) goto L5;
    L10:
        int r2 = b(r5);
        int r3 = b(r4);
        if (r2 == r3) goto L15;
        if (r2 >= r3) goto L14;
        return r5;
    L14:
        return r4;
    L15:
        com.fasterxml.jackson.databind.b r6 = this.f12582d;
        if (r6 != null) goto L19;
        return null;
    L19:
        return r6.a(this.f12581c, r4, r5);
    L5:
        if (r0.isAssignableFrom(r1) == false) goto L8;
        return r5;
    L8:
        if (r1.isAssignableFrom(r0) == false) goto L10;
        return r4;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public h p() {
        a<h> r0 = this.g;
        if (r0 != null) goto L6;
        return null;
    L6:
        h r1 = (h) ZeusTransformUtils.preCheckCast(r0.f12590a, h.class, "com.obric.aiagent.plugin");
        a r2 = this.g.f12591b;
    L7:
        if (r2 == null) goto L18;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r2.f12590a, h.class, "com.obric.aiagent.plugin");
        Class<?> r4 = r1.f();
        Class<?> r5 = r3.f();
        if (r4 == r5) goto L17;
        if (r4.isAssignableFrom(r5) == false) goto L14;
        r1 = r3;
    L15:
        r2 = r2.f12591b;
        goto L7
    L14:
        if (r5.isAssignableFrom(r4) == true) goto L15;
    L17:
        throw new IllegalArgumentException("Multiple fields representing property \"" + a() + "\": " + r1.i() + " vs " + r3.i());
    L18:
        return r1;
    }

    public h G() {
        a<h> r2 = this.g;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (h) ZeusTransformUtils.preCheckCast(r2.f12590a, h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public n q() {
        a r0 = this.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(((n) ZeusTransformUtils.preCheckCast(r0.f12590a, n.class, "com.obric.aiagent.plugin")).d(), f.class) == true) goto L9;
        r0 = r0.f12591b;
        if (r0 != null) goto L7;
        return (n) ZeusTransformUtils.preCheckCast(this.h.f12590a, n.class, "com.obric.aiagent.plugin");
    L9:
        return (n) ZeusTransformUtils.preCheckCast(r0.f12590a, n.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public Iterator<n> r() {
        if (this.h != null) goto L7;
        return com.fasterxml.jackson.databind.l.h.a();
    L7:
        return new b(this.h);
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public j v() {
        if (this.f12580b == true) goto L5;
        j r0 = t();
        if (r0 == null) goto L9;
        return r0;
    L9:
        return s();
    L5:
        return s();
    }

    public j H() {
        if (this.f12580b == false) goto L13;
        a<k> r0 = this.i;
        if (r0 != null) goto L7;
        a<h> r3 = this.g;
        if (r3 != null) goto L11;
        return null;
    L11:
        return (j) ZeusTransformUtils.preCheckCast(r3.f12590a, j.class, "com.obric.aiagent.plugin");
    L7:
        return (j) ZeusTransformUtils.preCheckCast(r0.f12590a, j.class, "com.obric.aiagent.plugin");
    L13:
        a<n> r1 = this.h;
        if (r1 != null) goto L16;
        a<k> r2 = this.j;
        if (r2 != null) goto L20;
        a<h> r4 = this.g;
        if (r4 != null) goto L24;
        a<k> r5 = this.i;
        if (r5 != null) goto L28;
        return null;
    L28:
        return (j) ZeusTransformUtils.preCheckCast(r5.f12590a, j.class, "com.obric.aiagent.plugin");
    L24:
        return (j) ZeusTransformUtils.preCheckCast(r4.f12590a, j.class, "com.obric.aiagent.plugin");
    L20:
        return (j) ZeusTransformUtils.preCheckCast(r2.f12590a, j.class, "com.obric.aiagent.plugin");
    L16:
        return (j) ZeusTransformUtils.preCheckCast(r1.f12590a, j.class, "com.obric.aiagent.plugin");
    }

    public int a(k r2) {
        String r1 = r2.b();
        if (r1.startsWith(MonitorConstants.CONNECT_TYPE_GET) == false) goto L9;
        if (r1.length() <= 3) goto L9;
        return 1;
    L9:
        if (r1.startsWith("is") == true) goto L11;
    L13:
        return 3;
    L11:
        if (r1.length() <= 2) goto L13;
        return 2;
    }

    public int b(k r1) {
        String r0 = r1.b();
        if (r0.startsWith("set") == true) goto L5;
        return 2;
    L5:
        if (r0.length() <= 3) goto L10;
        return 1;
    L10:
        return 2;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public Class<?>[] w() {
        return (Class[]) ZeusTransformUtils.preCheckCast(a(new AnonymousClass1(this)), Class[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.b.a x() {
        com.fasterxml.jackson.databind.b.a r0 = this.l;
        if (r0 != null) goto L5;
        com.fasterxml.jackson.databind.b.a r1 = (com.fasterxml.jackson.databind.b.a) ZeusTransformUtils.preCheckCast(a(new AnonymousClass2(this)), com.fasterxml.jackson.databind.b.a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L12;
        com.fasterxml.jackson.databind.b.a r2 = m;
    L13:
        this.l = r2;
        return r1;
    L12:
        r2 = r1;
        goto L13
    L5:
        if (r0 != m) goto L8;
        return null;
    L8:
        return r0;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean z() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(a(new AnonymousClass3(this)), Boolean.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public ac A() {
        return (ac) ZeusTransformUtils.preCheckCast(a(new AnonymousClass4(this)), ac.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public JsonInclude.Value B() {
        j r0 = s();
        com.fasterxml.jackson.databind.b r1 = this.f12582d;
        if (r1 != null) goto L5;
        JsonInclude.Value r2 = null;
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        return JsonInclude.Value.empty();
    L5:
        r2 = r1.s(r0);
        goto L6
    }

    public JsonProperty.Access I() {
        return (JsonProperty.Access) ZeusTransformUtils.preCheckCast(a(new AnonymousClass5(this), JsonProperty.Access.AUTO), JsonProperty.Access.class, "com.obric.aiagent.plugin");
    }

    public void a(h r9, com.fasterxml.jackson.databind.x r10, boolean r11, boolean r12, boolean r13) {
        this.g = new a(r9, this.g, r10, r11, r12, r13);
    }

    public void a(n r9, com.fasterxml.jackson.databind.x r10, boolean r11, boolean r12, boolean r13) {
        this.h = new a(r9, this.h, r10, r11, r12, r13);
    }

    public void a(k r9, com.fasterxml.jackson.databind.x r10, boolean r11, boolean r12, boolean r13) {
        this.i = new a(r9, this.i, r10, r11, r12, r13);
    }

    public void b(k r9, com.fasterxml.jackson.databind.x r10, boolean r11, boolean r12, boolean r13) {
        this.j = new a(r9, this.j, r10, r11, r12, r13);
    }

    public void b(ae r3) {
        this.g = b(this.g, r3.g);
        this.h = b(this.h, r3.h);
        this.i = b(this.i, r3.i);
        this.j = b(this.j, r3.j);
    }

    private static <T> a<T> b(a<T> r0, a<T> r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        if (r1 != null) goto L7;
        return r0;
    L7:
        return r0.b(r1);
    }

    public void J() {
        this.g = b(this.g);
        this.i = b(this.i);
        this.j = b(this.j);
        this.h = b(this.h);
    }

    public JsonProperty.Access a(boolean r6, ad r7) {
        JsonProperty.Access r0 = I();
        if (r0 != null) goto L5;
        r0 = JsonProperty.Access.AUTO;
    L5:
        int r1 = AnonymousClass6.f12589a[r0.ordinal()];
        if (r1 != 1) goto L8;
        if (r7 == null) goto L24;
        r7.a(a());
        Iterator<com.fasterxml.jackson.databind.x> r8 = O().iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        r7.a(((com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(r8.next(), com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin")).b());
    L24:
        this.j = null;
        this.h = null;
        if (this.f12580b == true) goto L27;
        this.g = null;
    L27:
        return r0;
    L8:
        if (r1 == 2) goto L27;
        if (r1 == 3) goto L16;
        this.i = c(this.i);
        this.h = c(this.h);
        if (r6 == true) goto L14;
    L15:
        this.g = c(this.g);
        this.j = c(this.j);
        goto L27
    L14:
        if (this.i != null) goto L27;
    L16:
        this.i = null;
        if (this.f12580b == false) goto L27;
        this.g = null;
        goto L27
    }

    public void K() {
        this.h = null;
    }

    public void L() {
        this.g = d(this.g);
        this.i = d(this.i);
        this.j = d(this.j);
        this.h = d(this.h);
    }

    public void a(boolean r6) {
        if (r6 == false) goto L10;
        a<k> r7 = this.i;
        if (r7 == null) goto L7;
        this.i = a(this.i, a(0, new a[]{r7, this.g, this.h, this.j}));
        return;
    L7:
        a<h> r8 = this.g;
        if (r8 == null) goto L21;
        this.g = a(this.g, a(0, new a[]{r8, this.h, this.j}));
        return;
    L21:
        return;
    L10:
        a<n> r9 = this.h;
        if (r9 == null) goto L13;
        this.h = a(this.h, a(0, new a[]{r9, this.j, this.g, this.i}));
        return;
    L13:
        a<k> r10 = this.j;
        if (r10 == null) goto L16;
        this.j = a(this.j, a(0, new a[]{r10, this.g, this.i}));
        return;
    L16:
        a<h> r11 = this.g;
        if (r11 == null) goto L25;
        this.g = a(this.g, a(0, new a[]{r11, this.i}));
        return;
    }

    private q a(int r3, a<? extends j>... r4) {
        q r0 = a(r4[r3]);
    L3:
        r3 = r3 + 1;
        if (r3 >= r4.length) goto L9;
        if (r4[r3] == null) goto L3;
        return q.a(r0, a(r3, r4));
    L9:
        return r0;
    }

    private <T extends j> q a(a<T> r4) {
        q r0 = ((j) ZeusTransformUtils.preCheckCast(r4.f12590a, j.class, "com.obric.aiagent.plugin")).j();
        if (r4.f12591b != null) goto L5;
        return r0;
    L5:
        return q.a(r0, a(r4.f12591b));
    }

    private <T extends j> a<T> a(a<T> r4, q r5) {
        j r0 = (j) ZeusTransformUtils.preCheckCast(((j) ZeusTransformUtils.preCheckCast(r4.f12590a, j.class, "com.obric.aiagent.plugin")).b(r5), j.class, "com.obric.aiagent.plugin");
        a<T> r1 = r4.f12591b;
        a r6 = r4;
        if (r1 == null) goto L6;
        r6 = r4.a(a(r4.f12591b, r5));
    L6:
        return r6.a(r0);
    }

    private <T> a<T> b(a<T> r1) {
        if (r1 != null) goto L5;
        return r1;
    L5:
        return r1.b();
    }

    private <T> a<T> c(a<T> r1) {
        if (r1 != null) goto L5;
        return r1;
    L5:
        return r1.c();
    }

    private <T> a<T> d(a<T> r1) {
        if (r1 != null) goto L5;
        return r1;
    L5:
        return r1.d();
    }

    private <T> boolean e(a<T> r1) {
    L2:
        if (r1 == null) goto L10;
        if (r1.f12592c == null) goto L9;
        if (r1.f12592c.c() == false) goto L9;
        return true;
    L9:
        r1 = r1.f12591b;
        goto L2
    L10:
        return false;
    }

    private <T> boolean f(a<T> r1) {
    L2:
        if (r1 == null) goto L10;
        if (r1.f12592c == null) goto L9;
        if (r1.f12593d == false) goto L9;
        return true;
    L9:
        r1 = r1.f12591b;
        goto L2
    L10:
        return false;
    }

    public boolean M() {
        if (g(this.g) == false) goto L5;
    L12:
        return true;
    L5:
        if (g(this.i) == true) goto L12;
        if (g(this.j) == true) goto L12;
        if (g(this.h) == true) goto L12;
        return false;
    }

    private <T> boolean g(a<T> r1) {
    L2:
        if (r1 == null) goto L8;
        if (r1.f12594e == true) goto L5;
        r1 = r1.f12591b;
        goto L2
    L5:
        return true;
    L8:
        return false;
    }

    public boolean N() {
        if (h(this.g) == false) goto L5;
    L12:
        return true;
    L5:
        if (h(this.i) == true) goto L12;
        if (h(this.j) == true) goto L12;
        if (h(this.h) == true) goto L12;
        return false;
    }

    private <T> boolean h(a<T> r1) {
    L2:
        if (r1 == null) goto L8;
        if (r1.f == true) goto L5;
        r1 = r1.f12591b;
        goto L2
    L5:
        return true;
    L8:
        return false;
    }

    public Set<com.fasterxml.jackson.databind.x> O() {
        Set<com.fasterxml.jackson.databind.x> r0 = a(this.g, null);
        Set<com.fasterxml.jackson.databind.x> r1 = a(this.i, r0);
        Set<com.fasterxml.jackson.databind.x> r2 = a(this.j, r1);
        Set<com.fasterxml.jackson.databind.x> r3 = a(this.h, r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Collections.emptySet();
    }

    public Collection<ae> a(Collection<com.fasterxml.jackson.databind.x> r3) {
        Collection<com.fasterxml.jackson.databind.x> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        a(r4, r0, this.g);
        a(r4, r0, this.i);
        a(r4, r0, this.j);
        a(r4, r0, this.h);
        return r0.values();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v0 ??, still in use, count: 1, list:
          (r9v0 ?? I:java.lang.Object) from 0x003c: INVOKE (r12v2 ?? I:java.util.Map), (r8v0 ?? I:java.lang.Object), (r9v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:1201)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private void a(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v0 ??, still in use, count: 1, list:
          (r9v0 ?? I:java.lang.Object) from 0x003c: INVOKE (r12v2 ?? I:java.util.Map), (r8v0 ?? I:java.lang.Object), (r9v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:1201)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private Set<com.fasterxml.jackson.databind.x> a(a<? extends j> r2, Set<com.fasterxml.jackson.databind.x> r3) {
        Set<com.fasterxml.jackson.databind.x> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        a r4 = r2;
    L3:
        if (r4 == null) goto L13;
        if (r4.f12593d == false) goto L12;
        if (r4.f12592c == null) goto L12;
        if (r1 != null) goto L11;
        r1 = new HashSet();
    L11:
        r1.add(r4.f12592c);
    L12:
        r4 = r4.f12591b;
        goto L3
    L13:
        return r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[Property '").append(this.f12583e).append("'; ctors: ").append(this.h).append(", field(s): ").append(this.g).append(", getter(s): ").append(this.i).append(", setter(s): ").append(this.j);
        r0.append("]");
        return r0.toString();
    }

    public <T> T a(c<T> r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        T r2 = null;
        if (this.f12582d != null) goto L5;
        return null;
    L5:
        if (this.f12580b == false) goto L9;
        a<k> r0 = this.i;
        if (r0 == null) goto L16;
        r2 = (T) r5.b((j) ZeusTransformUtils.preCheckCast(r0.f12590a, j.class, "com.obric.aiagent.plugin"));
    L16:
        if (r2 != null) goto L22;
        a<h> r3 = this.g;
        if (r3 != null) goto L20;
        return r2;
    L20:
        return (T) r5.b((j) ZeusTransformUtils.preCheckCast(r3.f12590a, j.class, "com.obric.aiagent.plugin"));
    L22:
        return r2;
    L9:
        a<n> r1 = this.h;
        if (r1 == null) goto L12;
        r2 = (T) r5.b((j) ZeusTransformUtils.preCheckCast(r1.f12590a, j.class, "com.obric.aiagent.plugin"));
    L12:
        if (r2 != null) goto L16;
        a<k> r6 = this.j;
        if (r6 == null) goto L16;
        r2 = (T) r5.b((j) ZeusTransformUtils.preCheckCast(r6.f12590a, j.class, "com.obric.aiagent.plugin"));
        goto L16
    }

    public <T> T a(c<T> r5, T r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f12582d != null) goto L6;
        return null;
    L6:
        if (this.f12580b == false) goto L32;
        a<k> r0 = this.i;
        if (r0 == null) goto L13;
        T r1 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r0.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L13;
        if (r1 == r6) goto L13;
        return r1;
    L13:
        a<h> r2 = this.g;
        if (r2 == null) goto L19;
        T r3 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r2.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L19;
        if (r3 == r6) goto L19;
        return r3;
    L19:
        a<n> r4 = this.h;
        if (r4 == null) goto L25;
        T r8 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r4.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L25;
        if (r8 == r6) goto L25;
        return r8;
    L25:
        a<k> r9 = this.j;
        if (r9 == null) goto L31;
        T r10 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r9.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r10 == null) goto L31;
        if (r10 == r6) goto L31;
        return r10;
    L31:
        return null;
    L32:
        a<n> r11 = this.h;
        if (r11 == null) goto L38;
        T r12 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r11.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L38;
        if (r12 == r6) goto L38;
        return r12;
    L38:
        a<k> r13 = this.j;
        if (r13 == null) goto L44;
        T r14 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r13.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r14 == null) goto L44;
        if (r14 == r6) goto L44;
        return r14;
    L44:
        a<h> r15 = this.g;
        if (r15 == null) goto L50;
        T r16 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r15.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r16 == null) goto L50;
        if (r16 == r6) goto L50;
        return r16;
    L50:
        a<k> r17 = this.i;
        if (r17 == null) goto L56;
        T r18 = (T) r7.b((j) ZeusTransformUtils.preCheckCast(r17.f12590a, j.class, "com.obric.aiagent.plugin"));
        if (r18 == null) goto L56;
        if (r18 == r6) goto L56;
        return r18;
    L56:
        return null;
    }

    public Class<?> a(j r2) {
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L9;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin");
        if (r1.e() <= 0) goto L9;
        return r1.b(0).e();
    L9:
        return r2.getType().e();
    }
}
