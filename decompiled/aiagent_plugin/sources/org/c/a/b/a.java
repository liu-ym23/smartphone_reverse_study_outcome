package org.c.a.b;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Emitter.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    private static final Pattern M = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f40344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f40345b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<Character> f40346c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Character, String> f40347d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f40348e = null;
    private int A;
    private final char[] B;
    private final boolean C;
    private final int D;
    private final boolean E;
    private Map<String, String> F;
    private String G;
    private String H;
    private org.c.a.b.d I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private org.c.a.a.d f40349J;
    private final org.c.a.a.a K;
    private final org.c.a.a.a L;
    private final Writer f;
    private final org.c.a.m.a<org.c.a.b.c> g;
    private org.c.a.b.c h;
    private final Queue<org.c.a.d.g> i;
    private org.c.a.d.g j;
    private final org.c.a.m.a<Integer> k;
    private Integer l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private final Boolean u;
    private final Boolean v;
    private final boolean w;
    private int x;
    private final int y;
    private final boolean z;

    /* JADX INFO: renamed from: org.c.a.b.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: Emitter.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40350a = null;

        static {
            int[] r0 = new int[org.c.a.a.d.values().length];
            f40350a = r0;
            r0[org.c.a.a.d.f40324a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f40350a[org.c.a.a.d.f40325b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f40350a[org.c.a.a.d.f40327d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f40350a[org.c.a.a.d.f40326c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: renamed from: org.c.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Emitter.java */
    private class C1094a implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40352b;

        public C1094a(a r1, boolean r2) {
            this.f40351a = r1;
            this.f40352b = r2;
        }

        @Override // org.c.a.b.c
        public void a() {
            a r0 = this.f40351a;
            a.a(r0, a.f(r0).b(a.a(this.f40351a)));
            a.g(this.f40351a);
            if (this.f40352b == false) goto L5;
        L7:
            this.f40351a.d();
            AnonymousClass1 r1 = null;
            if (a.q(this.f40351a) == false) goto L10;
            a.h(this.f40351a).a(new b(this.f40351a, r1));
            a.a(this.f40351a, false, true, true);
            return;
        L10:
            this.f40351a.a("?", true, false, true);
            a.h(this.f40351a).a(new c(this.f40351a, r1));
            a.a(this.f40351a, false, true, false);
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(a.a(this.f40351a), org.c.a.d.i.class) == false) goto L7;
            a r2 = this.f40351a;
            a.a(r2, (Integer) ZeusTransformUtils.preCheckCast(a.i(r2).a(), Integer.class, "com.obric.aiagent.plugin"));
            a r6 = this.f40351a;
            a.a(r6, (org.c.a.b.c) ZeusTransformUtils.preCheckCast(a.h(r6).a(), org.c.a.b.c.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class b implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40353a;

        private b(a r1) {
            this.f40353a = r1;
        }

        /* synthetic */ b(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            this.f40353a.a(":", false, false, false);
            a r0 = this.f40353a;
            a.a(r0, a.k(r0).b(a.a(this.f40353a)));
            a r1 = this.f40353a;
            if (a.b(r1, a.a(r1)) == false) goto L5;
        L7:
            a r2 = this.f40353a;
            a.a(r2, a.f(r2).b(a.a(this.f40353a)));
            if (a.f(this.f40353a).c() == true) goto L10;
            a.a(this.f40353a, true, false);
            a.g(this.f40353a);
            this.f40353a.d();
            a r3 = this.f40353a;
            a.a(r3, (Integer) ZeusTransformUtils.preCheckCast(a.i(r3).a(), Integer.class, "com.obric.aiagent.plugin"));
        L10:
            a.h(this.f40353a).a(new C1094a(this.f40353a, false));
            a.a(this.f40353a, false, true, false);
            a.k(this.f40353a).a();
            a.l(this.f40353a);
            return;
        L5:
            if (a.l(this.f40353a) == false) goto L7;
            a.a(this.f40353a, true, false);
            this.f40353a.d();
            a r4 = this.f40353a;
            a.a(r4, (Integer) ZeusTransformUtils.preCheckCast(a.i(r4).a(), Integer.class, "com.obric.aiagent.plugin"));
            goto L7
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class c implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40354a;

        private c(a r1) {
            this.f40354a = r1;
        }

        /* synthetic */ c(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            this.f40354a.d();
            this.f40354a.a(":", true, false, true);
            a r0 = this.f40354a;
            a.a(r0, a.k(r0).b(a.a(this.f40354a)));
            a.l(this.f40354a);
            a r1 = this.f40354a;
            a.a(r1, a.f(r1).b(a.a(this.f40354a)));
            a.g(this.f40354a);
            a.h(this.f40354a).a(new C1094a(this.f40354a, false));
            a.a(this.f40354a, false, true, false);
            a.k(this.f40354a).a(a.a(this.f40354a));
            a.l(this.f40354a);
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class d implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40356b;

        public d(a r1, boolean r2) {
            this.f40355a = r1;
            this.f40356b = r2;
        }

        @Override // org.c.a.b.c
        public void a() {
            if (this.f40356b == true) goto L8;
            if (ZeusTransformUtils.instanceOf(a.a(this.f40355a), org.c.a.d.m.class) == false) goto L8;
            a r0 = this.f40355a;
            a.a(r0, (Integer) ZeusTransformUtils.preCheckCast(a.i(r0).a(), Integer.class, "com.obric.aiagent.plugin"));
            a r5 = this.f40355a;
            a.a(r5, (org.c.a.b.c) ZeusTransformUtils.preCheckCast(a.h(r5).a(), org.c.a.b.c.class, "com.obric.aiagent.plugin"));
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(a.a(this.f40355a), org.c.a.d.d.class) == false) goto L10;
            a.f(this.f40355a).a(a.a(this.f40355a));
            return;
        L10:
            this.f40355a.d();
            if (a.r(this.f40355a) == true) goto L13;
        L14:
            a r1 = this.f40355a;
            a.a(r1, a.s(r1));
        L15:
            this.f40355a.a("-", true, false, true);
            if (a.r(this.f40355a) == false) goto L21;
            if (this.f40356b == false) goto L21;
            a r2 = this.f40355a;
            a.a(r2, Integer.valueOf(a.t(r2).intValue() + a.s(this.f40355a)));
        L21:
            if (a.f(this.f40355a).c() == true) goto L28;
            a.a(this.f40355a, false, false);
            a.g(this.f40355a);
            if (ZeusTransformUtils.instanceOf(a.a(this.f40355a), org.c.a.d.l.class) == false) goto L27;
            a r3 = this.f40355a;
            a.a(r3, a.c(r3, ((org.c.a.d.l) ZeusTransformUtils.preCheckCast(a.a(r3), org.c.a.d.l.class, "com.obric.aiagent.plugin")).e()));
            if (a.u(this.f40355a).b() == true) goto L27;
            this.f40355a.d();
        L27:
            a r4 = this.f40355a;
            a.a(r4, (Integer) ZeusTransformUtils.preCheckCast(a.i(r4).a(), Integer.class, "com.obric.aiagent.plugin"));
        L28:
            a.h(this.f40355a).a(new d(this.f40355a, false));
            a.a(this.f40355a, false, false, false);
            a.k(this.f40355a).a();
            a.l(this.f40355a);
            return;
        L13:
            if (this.f40356b == false) goto L15;
            goto L14
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class e implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40357a;

        private e(a r1) {
            this.f40357a = r1;
        }

        /* synthetic */ e(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            a r0 = this.f40357a;
            a.a(r0, a.f(r0).b(a.a(this.f40357a)));
            a.g(this.f40357a);
            if (ZeusTransformUtils.instanceOf(a.a(this.f40357a), org.c.a.d.e.class) == false) goto L10;
            this.f40357a.d();
            if (((org.c.a.d.e) ZeusTransformUtils.preCheckCast(a.a(this.f40357a), org.c.a.d.e.class, "com.obric.aiagent.plugin")).b() == false) goto L7;
            this.f40357a.a("...", true, false, false);
            this.f40357a.d();
        L7:
            this.f40357a.a();
            a.a(this.f40357a, new g(this.f40357a, false));
            return;
        L10:
            throw new org.c.a.b.b("expected DocumentEndEvent, but got " + a.a(this.f40357a));
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class f implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40358a;

        private f(a r1) {
            this.f40358a = r1;
        }

        /* synthetic */ f(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            a r0 = this.f40358a;
            a.a(r0, a.f(r0).b(a.a(this.f40358a)));
            AnonymousClass1 r1 = null;
            if (a.f(this.f40358a).c() == true) goto L8;
            a.g(this.f40358a);
            if (ZeusTransformUtils.instanceOf(a.a(this.f40358a), org.c.a.d.e.class) == false) goto L8;
            new e(this.f40358a, r1).a();
            return;
        L8:
            a.h(this.f40358a).a(new e(this.f40358a, r1));
            a.a(this.f40358a, true, false, false);
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class g implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40360b;

        public g(a r1, boolean r2) {
            this.f40359a = r1;
            this.f40360b = r2;
        }

        @Override // org.c.a.b.c
        public void a() {
            AnonymousClass1 r1 = null;
            if (ZeusTransformUtils.instanceOf(a.a(this.f40359a), org.c.a.d.f.class) == false) goto L42;
            org.c.a.d.f r0 = (org.c.a.d.f) ZeusTransformUtils.preCheckCast(a.a(this.f40359a), org.c.a.d.f.class, "com.obric.aiagent.plugin");
            if (r0.c() != null) goto L9;
            if (r0.e() != null) goto L9;
        L12:
            if (r0.c() == null) goto L14;
            this.f40359a.b(a.a(this.f40359a, r0.c()));
        L14:
            a.a(this.f40359a, new LinkedHashMap(a.e()));
            if (r0.e() == null) goto L21;
            Iterator r2 = new TreeSet(r0.e().keySet()).iterator();
        L18:
            if (r2.hasNext() == false) goto L21;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(r0.e().get(r6), String.class, "com.obric.aiagent.plugin");
            a.c(this.f40359a).put(r7, r6);
            this.f40359a.a(a.a(this.f40359a, r6), a.b(this.f40359a, r7));
        L21:
            if (this.f40360b == true) goto L23;
        L35:
            boolean r3 = false;
        L36:
            if (r3 == true) goto L40;
            this.f40359a.d();
            this.f40359a.a("---", true, false, false);
            if (a.d(this.f40359a).booleanValue() == false) goto L40;
            this.f40359a.d();
        L40:
            a.a(this.f40359a, new f(this.f40359a, r1));
            return;
        L23:
            if (r0.b() == true) goto L35;
            if (a.d(this.f40359a).booleanValue() == true) goto L35;
            if (r0.c() != null) goto L35;
            if (r0.e() == null) goto L33;
            if (r0.e().isEmpty() == false) goto L35;
        L33:
            if (a.e(this.f40359a) == true) goto L35;
            r3 = true;
        L9:
            if (a.b(this.f40359a) == false) goto L12;
            this.f40359a.a("...", true, false, false);
            this.f40359a.d();
            goto L12
        L42:
            if (ZeusTransformUtils.instanceOf(a.a(this.f40359a), org.c.a.d.o.class) == false) goto L45;
            this.f40359a.c();
            a.a(this.f40359a, new q(this.f40359a, r1));
            return;
        L45:
            if (ZeusTransformUtils.instanceOf(a.a(this.f40359a), org.c.a.d.d.class) == false) goto L49;
            a.f(this.f40359a).a(a.a(this.f40359a));
            a.g(this.f40359a);
            return;
        L49:
            throw new org.c.a.b.b("expected DocumentStartEvent, but got " + a.a(this.f40359a));
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class h implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40361a;

        private h(a r1) {
            this.f40361a = r1;
        }

        /* synthetic */ h(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            new C1094a(this.f40361a, true).a();
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class i implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40362a;

        private i(a r1) {
            this.f40362a = r1;
        }

        /* synthetic */ i(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            new d(this.f40362a, true).a();
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class j implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40363a;

        private j(a r1) {
            this.f40363a = r1;
        }

        /* synthetic */ j(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            new g(this.f40363a, true).a();
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class k implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40364a;

        private k(a r1) {
            this.f40364a = r1;
        }

        /* synthetic */ k(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            a r0 = this.f40364a;
            a.a(r0, a.f(r0).b(a.a(this.f40364a)));
            a.g(this.f40364a);
            if (ZeusTransformUtils.instanceOf(a.a(this.f40364a), org.c.a.d.i.class) == false) goto L6;
            a r1 = this.f40364a;
            a.a(r1, (Integer) ZeusTransformUtils.preCheckCast(a.i(r1).a(), Integer.class, "com.obric.aiagent.plugin"));
            a.j(this.f40364a);
            this.f40364a.a("}", false, false, false);
            a.k(this.f40364a).a();
            a.l(this.f40364a);
            a r6 = this.f40364a;
            a.a(r6, (org.c.a.b.c) ZeusTransformUtils.preCheckCast(a.h(r6).a(), org.c.a.b.c.class, "com.obric.aiagent.plugin"));
            return;
        L6:
            if (a.d(this.f40364a).booleanValue() == false) goto L8;
        L13:
            this.f40364a.d();
        L14:
            AnonymousClass1 r2 = null;
            if (a.d(this.f40364a).booleanValue() == false) goto L17;
        L19:
            this.f40364a.a("?", true, false, false);
            a.h(this.f40364a).a(new o(this.f40364a, r2));
            a.a(this.f40364a, false, true, false);
            return;
        L17:
            if (a.q(this.f40364a) == false) goto L19;
            a.h(this.f40364a).a(new n(this.f40364a, r2));
            a.a(this.f40364a, false, true, true);
            return;
        L8:
            if (a.m(this.f40364a) <= a.n(this.f40364a)) goto L12;
            if (a.o(this.f40364a) == true) goto L13;
        L12:
            if (a.p(this.f40364a).booleanValue() == false) goto L14;
            goto L13
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class l implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40365a;

        private l(a r1) {
            this.f40365a = r1;
        }

        /* synthetic */ l(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            if (ZeusTransformUtils.instanceOf(a.a(this.f40365a), org.c.a.d.m.class) == false) goto L6;
            a r0 = this.f40365a;
            a.a(r0, (Integer) ZeusTransformUtils.preCheckCast(a.i(r0).a(), Integer.class, "com.obric.aiagent.plugin"));
            a.j(this.f40365a);
            this.f40365a.a("]", false, false, false);
            a.k(this.f40365a).a();
            a.l(this.f40365a);
            a r5 = this.f40365a;
            a.a(r5, (org.c.a.b.c) ZeusTransformUtils.preCheckCast(a.h(r5).a(), org.c.a.b.c.class, "com.obric.aiagent.plugin"));
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(a.a(this.f40365a), org.c.a.d.d.class) == false) goto L9;
            a.f(this.f40365a).a(a.a(this.f40365a));
            a.g(this.f40365a);
            return;
        L9:
            if (a.d(this.f40365a).booleanValue() == false) goto L11;
        L16:
            this.f40365a.d();
        L17:
            a.h(this.f40365a).a(new p(this.f40365a, null));
            a.a(this.f40365a, false, false, false);
            a r1 = this.f40365a;
            a.a(r1, a.k(r1).a(a.a(this.f40365a)));
            a.l(this.f40365a);
            return;
        L11:
            if (a.m(this.f40365a) <= a.n(this.f40365a)) goto L15;
            if (a.o(this.f40365a) == true) goto L16;
        L15:
            if (a.p(this.f40365a).booleanValue() == false) goto L17;
            goto L16
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class m implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40366a;

        private m(a r1) {
            this.f40366a = r1;
        }

        /* synthetic */ m(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            if (ZeusTransformUtils.instanceOf(a.a(this.f40366a), org.c.a.d.i.class) == false) goto L11;
            a r0 = this.f40366a;
            a.a(r0, (Integer) ZeusTransformUtils.preCheckCast(a.i(r0).a(), Integer.class, "com.obric.aiagent.plugin"));
            a.j(this.f40366a);
            if (a.d(this.f40366a).booleanValue() == false) goto L8;
            this.f40366a.a(",", false, false, false);
            this.f40366a.d();
        L8:
            if (a.p(this.f40366a).booleanValue() == false) goto L10;
            this.f40366a.d();
        L10:
            this.f40366a.a("}", false, false, false);
            a.k(this.f40366a).a();
            a.l(this.f40366a);
            a r6 = this.f40366a;
            a.a(r6, (org.c.a.b.c) ZeusTransformUtils.preCheckCast(a.h(r6).a(), org.c.a.b.c.class, "com.obric.aiagent.plugin"));
            return;
        L11:
            this.f40366a.a(",", false, false, false);
            a r1 = this.f40366a;
            a.a(r1, a.f(r1).b(a.a(this.f40366a)));
            a.g(this.f40366a);
            if (a.d(this.f40366a).booleanValue() == false) goto L14;
        L19:
            this.f40366a.d();
        L20:
            AnonymousClass1 r2 = null;
            if (a.d(this.f40366a).booleanValue() == false) goto L23;
        L25:
            this.f40366a.a("?", true, false, false);
            a.h(this.f40366a).a(new o(this.f40366a, r2));
            a.a(this.f40366a, false, true, false);
            return;
        L23:
            if (a.q(this.f40366a) == false) goto L25;
            a.h(this.f40366a).a(new n(this.f40366a, r2));
            a.a(this.f40366a, false, true, true);
            return;
        L14:
            if (a.m(this.f40366a) <= a.n(this.f40366a)) goto L18;
            if (a.o(this.f40366a) == true) goto L19;
        L18:
            if (a.p(this.f40366a).booleanValue() == false) goto L20;
            goto L19
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class n implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40367a;

        private n(a r1) {
            this.f40367a = r1;
        }

        /* synthetic */ n(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            this.f40367a.a(":", false, false, false);
            a r0 = this.f40367a;
            a.a(r0, a.k(r0).b(a.a(this.f40367a)));
            a.l(this.f40367a);
            a.h(this.f40367a).a(new m(this.f40367a, null));
            a.a(this.f40367a, false, true, false);
            a.k(this.f40367a).a(a.a(this.f40367a));
            a.l(this.f40367a);
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class o implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40368a;

        private o(a r1) {
            this.f40368a = r1;
        }

        /* synthetic */ o(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            if (a.d(this.f40368a).booleanValue() == false) goto L5;
        L8:
            this.f40368a.d();
        L9:
            this.f40368a.a(":", true, false, false);
            a r0 = this.f40368a;
            a.a(r0, a.k(r0).b(a.a(this.f40368a)));
            a.l(this.f40368a);
            a.h(this.f40368a).a(new m(this.f40368a, null));
            a.a(this.f40368a, false, true, false);
            a.k(this.f40368a).a(a.a(this.f40368a));
            a.l(this.f40368a);
            return;
        L5:
            if (a.m(this.f40368a) > a.n(this.f40368a)) goto L8;
            if (a.p(this.f40368a).booleanValue() == false) goto L9;
            goto L8
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class p implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40369a;

        private p(a r1) {
            this.f40369a = r1;
        }

        /* synthetic */ p(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            if (ZeusTransformUtils.instanceOf(a.a(this.f40369a), org.c.a.d.m.class) == false) goto L15;
            a r0 = this.f40369a;
            a.a(r0, (Integer) ZeusTransformUtils.preCheckCast(a.i(r0).a(), Integer.class, "com.obric.aiagent.plugin"));
            a.j(this.f40369a);
            if (a.d(this.f40369a).booleanValue() == false) goto L8;
            this.f40369a.a(",", false, false, false);
            this.f40369a.d();
        L10:
            this.f40369a.a("]", false, false, false);
            a.k(this.f40369a).a();
            a.l(this.f40369a);
            if (a.p(this.f40369a).booleanValue() == false) goto L13;
            this.f40369a.d();
        L13:
            a r6 = this.f40369a;
            a.a(r6, (org.c.a.b.c) ZeusTransformUtils.preCheckCast(a.h(r6).a(), org.c.a.b.c.class, "com.obric.aiagent.plugin"));
            return;
        L8:
            if (a.p(this.f40369a).booleanValue() == false) goto L10;
            this.f40369a.d();
            goto L10
        L15:
            if (ZeusTransformUtils.instanceOf(a.a(this.f40369a), org.c.a.d.d.class) == false) goto L17;
            a r1 = this.f40369a;
            a.a(r1, a.f(r1).a(a.a(this.f40369a)));
            return;
        L17:
            this.f40369a.a(",", false, false, false);
            a.g(this.f40369a);
            if (a.d(this.f40369a).booleanValue() == false) goto L20;
        L25:
            this.f40369a.d();
        L26:
            a.h(this.f40369a).a(new p(this.f40369a));
            a.a(this.f40369a, false, false, false);
            a r2 = this.f40369a;
            a.a(r2, a.k(r2).a(a.a(this.f40369a)));
            a.l(this.f40369a);
            return;
        L20:
            if (a.m(this.f40369a) <= a.n(this.f40369a)) goto L24;
            if (a.o(this.f40369a) == true) goto L25;
        L24:
            if (a.p(this.f40369a).booleanValue() == false) goto L26;
            goto L25
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class q implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40370a;

        private q(a r1) {
            this.f40370a = r1;
        }

        /* synthetic */ q(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            throw new org.c.a.b.b("expecting nothing, but got " + a.a(this.f40370a));
        }
    }

    /* JADX INFO: compiled from: Emitter.java */
    private class r implements org.c.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f40371a;

        private r(a r1) {
            this.f40371a = r1;
        }

        /* synthetic */ r(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.b.c
        public void a() {
            if (ZeusTransformUtils.instanceOf(a.a(this.f40371a), org.c.a.d.p.class) == false) goto L7;
            this.f40371a.b();
            a.a(this.f40371a, new j(this.f40371a, null));
            return;
        L7:
            throw new org.c.a.b.b("expected StreamStartEvent, but got " + a.a(this.f40371a));
        }
    }

    void b() {
    }

    static /* synthetic */ Integer a(a r0, Integer r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ String a(a r0, String r1) {
        return r0.e(r1);
    }

    static /* synthetic */ String a(a r0, org.c.a.a.e r1) {
        return r0.a(r1);
    }

    static /* synthetic */ Map a(a r2, Map r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        r2.F = r4;
        return r4;
    }

    static /* synthetic */ org.c.a.b.c a(a r2, org.c.a.b.c r3) {
        org.c.a.b.c r4 = (org.c.a.b.c) ZeusTransformUtils.wrapperContextForParams(r3, org.c.a.b.c.class, "com.obric.aiagent.plugin");
        r2.h = r4;
        return r4;
    }

    static /* synthetic */ org.c.a.b.d a(a r0, org.c.a.b.d r1) {
        r0.I = r1;
        return r1;
    }

    static /* synthetic */ org.c.a.d.g a(a r0) {
        return r0.j;
    }

    static /* synthetic */ org.c.a.d.g a(a r0, org.c.a.d.g r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ void a(a r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(a r0, boolean r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(a r0, boolean r1, boolean r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ String b(a r0, String r1) {
        return r0.f(r1);
    }

    static /* synthetic */ boolean b(a r0) {
        return r0.t;
    }

    static /* synthetic */ boolean b(a r0, org.c.a.d.g r1) {
        return r0.b(r1);
    }

    static /* synthetic */ Map c(a r0) {
        return r0.F;
    }

    static /* synthetic */ org.c.a.b.d c(a r0, String r1) {
        return r0.h(r1);
    }

    static /* synthetic */ Boolean d(a r0) {
        return r0.u;
    }

    static /* synthetic */ Map e() {
        return f40348e;
    }

    static /* synthetic */ boolean e(a r0) {
        return r0.o();
    }

    static /* synthetic */ org.c.a.a.a f(a r0) {
        return r0.K;
    }

    static /* synthetic */ void g(a r0) {
        r0.t();
    }

    static /* synthetic */ org.c.a.m.a h(a r0) {
        return r0.g;
    }

    static /* synthetic */ org.c.a.m.a i(a r0) {
        return r0.k;
    }

    static /* synthetic */ int j(a r2) {
        int r0 = r2.m;
        r2.m = r0 - 1;
        return r0;
    }

    static /* synthetic */ org.c.a.a.a k(a r0) {
        return r0.L;
    }

    static /* synthetic */ boolean l(a r0) {
        return r0.u();
    }

    static /* synthetic */ int m(a r0) {
        return r0.q;
    }

    static /* synthetic */ int n(a r0) {
        return r0.A;
    }

    static /* synthetic */ boolean o(a r0) {
        return r0.C;
    }

    static /* synthetic */ Boolean p(a r0) {
        return r0.v;
    }

    static /* synthetic */ boolean q(a r0) {
        return r0.p();
    }

    static /* synthetic */ boolean r(a r0) {
        return r0.z;
    }

    static /* synthetic */ int s(a r0) {
        return r0.y;
    }

    static /* synthetic */ Integer t(a r0) {
        return r0.l;
    }

    static /* synthetic */ org.c.a.b.d u(a r0) {
        return r0.I;
    }

    static {
        f40344a = new char[]{' '};
        f40345b = Pattern.compile("\\s");
        HashSet r0 = new HashSet();
        f40346c = r0;
        r0.add('[');
        r0.add(']');
        r0.add('{');
        r0.add('}');
        r0.add(',');
        r0.add('*');
        r0.add('&');
        HashMap r1 = new HashMap();
        f40347d = r1;
        r1.put((char) 0, "0");
        r1.put((char) 7, "a");
        r1.put('\b', "b");
        r1.put('\t', "t");
        r1.put('\n', "n");
        r1.put((char) 11, "v");
        r1.put('\f', com.bytedance.apm.util.f.f4978a);
        r1.put('\r', DownloadFileUtils.MODE_READ);
        r1.put((char) 27, "e");
        r1.put('\"', "\"");
        r1.put('\\', "\\");
        r1.put((char) 133, "N");
        r1.put((char) 160, "_");
        r1.put((char) 8232, "L");
        r1.put((char) 8233, "P");
        LinkedHashMap r2 = new LinkedHashMap();
        f40348e = r2;
        r2.put("!", "!");
        r2.put("tag:yaml.org,2002:", "!!");
        M = Pattern.compile("^![-_\\w]*!$");
    }

    public a(Writer r7, org.c.a.a r8) {
        this.f = r7;
        this.g = new org.c.a.m.a(100);
        this.h = new r(this, null);
        ArrayDeque r9 = new ArrayDeque(100);
        this.i = r9;
        this.j = null;
        this.k = new org.c.a.m.a(10);
        this.l = null;
        this.m = 0;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.r = true;
        this.s = true;
        this.t = false;
        this.u = Boolean.valueOf(r8.e());
        this.v = Boolean.valueOf(r8.f());
        this.w = r8.a();
        this.x = 2;
        if (r8.b() > 1) goto L5;
    L7:
        this.y = r8.c();
        this.z = r8.d();
        this.A = 80;
        if (r8.g() <= (this.x * 2)) goto L10;
        this.A = r8.g();
    L10:
        this.B = r8.i().a().toCharArray();
        this.C = r8.h();
        this.D = r8.k();
        this.E = r8.l();
        this.F = new LinkedHashMap();
        this.G = null;
        this.H = null;
        this.I = null;
        this.f40349J = null;
        this.K = new org.c.a.a.a(r9, new org.c.a.a.c[]{org.c.a.a.c.f40340a, org.c.a.a.c.f40341b});
        this.L = new org.c.a.a.a(r9, new org.c.a.a.c[]{org.c.a.a.c.f40342c});
        return;
    L5:
        if (r8.b() >= 10) goto L7;
        this.x = r8.b();
        goto L7
    }

    public void a(org.c.a.d.g r3) {
        this.i.add(r3);
    L4:
        if (f() == true) goto L6;
        this.j = (org.c.a.d.g) ZeusTransformUtils.preCheckCast(this.i.poll(), org.c.a.d.g.class, "com.obric.aiagent.plugin");
        this.h.a();
        this.j = null;
        goto L4
    }

    private boolean f() {
        if (this.i.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<org.c.a.d.g> r0 = this.i.iterator();
        Object r2 = ZeusTransformUtils.preCheckCast(r0.next(), org.c.a.d.g.class, "com.obric.aiagent.plugin");
    L6:
        org.c.a.d.g r3 = (org.c.a.d.g) r2;
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.d.class) == false) goto L13;
        if (r0.hasNext() == false) goto L10;
        r2 = ZeusTransformUtils.preCheckCast(r0.next(), org.c.a.d.g.class, "com.obric.aiagent.plugin");
        goto L6
    L10:
        return true;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.f.class) == false) goto L17;
        return a(r0, 1);
    L17:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.n.class) == false) goto L21;
        return a(r0, 2);
    L21:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.j.class) == false) goto L25;
        return a(r0, 3);
    L25:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.p.class) == false) goto L29;
        return a(r0, 2);
    L29:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.o.class) == false) goto L32;
        return false;
    L32:
        if (this.E == true) goto L34;
        return false;
    L34:
        return a(r0, 1);
    }

    private boolean a(Iterator<org.c.a.d.g> r6, int r7) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r6, Iterator.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r5.hasNext() == false) goto L25;
        org.c.a.d.g r3 = (org.c.a.d.g) ZeusTransformUtils.preCheckCast(r5.next(), org.c.a.d.g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.d.class) == true) goto L4;
        r1 = r1 + 1;
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.f.class) == false) goto L11;
    L22:
        r2 = r2 + 1;
    L23:
        if (r2 >= 0) goto L4;
        return false;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.c.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.e.class) == false) goto L16;
    L21:
        r2 = r2 - 1;
        goto L23
    L16:
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.b.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.o.class) == false) goto L23;
        r2 = -1;
        goto L23
    L25:
        if (r1 >= r7) goto L34;
        return true;
    L34:
        return false;
    }

    private void a(boolean r3, boolean r4) {
        this.k.a(this.l);
        Integer r0 = this.l;
        if (r0 != null) goto L7;
        if (r3 == false) goto L6;
        this.l = Integer.valueOf(this.x);
        return;
    L6:
        this.l = 0;
        return;
    L7:
        if (r4 == true) goto L12;
        this.l = Integer.valueOf(r0.intValue() + this.x);
        return;
    }

    private void a(boolean r1, boolean r2, boolean r3) {
        this.n = r1;
        this.o = r2;
        this.p = r3;
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.a.class) == false) goto L6;
        g();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.l.class) == false) goto L8;
    L12:
        d("&");
        q();
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.l.class) == false) goto L16;
        h();
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.n.class) == false) goto L29;
        if (this.m == 0) goto L20;
    L27:
        i();
        return;
    L20:
        if (this.u.booleanValue() == true) goto L27;
        if (((org.c.a.d.n) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.n.class, "com.obric.aiagent.plugin")).e() == true) goto L27;
        if (m() == true) goto L27;
        k();
        return;
    L29:
        if (this.m == 0) goto L31;
    L38:
        j();
        return;
    L31:
        if (this.u.booleanValue() == true) goto L38;
        if (((org.c.a.d.j) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.j.class, "com.obric.aiagent.plugin")).e() == true) goto L38;
        if (n() == true) goto L38;
        l();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.c.class) == true) goto L12;
        throw new org.c.a.b.b("expected NodeEvent, but got " + this.j);
    }

    private void g() {
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.a.class) == false) goto L7;
        d("*");
        this.h = (org.c.a.b.c) ZeusTransformUtils.preCheckCast(this.g.a(), org.c.a.b.c.class, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new org.c.a.b.b("Alias must be provided");
    }

    private void h() {
        a(true, false);
        s();
        this.l = (Integer) ZeusTransformUtils.preCheckCast(this.k.a(), Integer.class, "com.obric.aiagent.plugin");
        this.h = (org.c.a.b.c) ZeusTransformUtils.preCheckCast(this.g.a(), org.c.a.b.c.class, "com.obric.aiagent.plugin");
    }

    private void i() {
        a("[", true, true, false);
        this.m++;
        a(true, false);
        if (this.v.booleanValue() == false) goto L5;
        d();
    L5:
        this.h = new l(this, null);
    }

    private void j() {
        a("{", true, true, false);
        this.m++;
        a(true, false);
        if (this.v.booleanValue() == false) goto L5;
        d();
    L5:
        this.h = new k(this, null);
    }

    private void k() {
        if (this.o == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a(false, r0);
        this.h = new i(this, null);
        return;
    L5:
        if (this.s == true) goto L7;
        r0 = true;
        goto L8
    }

    private void l() {
        a(false, false);
        this.h = new h(this, null);
    }

    private boolean b(org.c.a.d.g r3) {
        if (r3.a(org.c.a.d.g.a.g) == true) goto L5;
        return false;
    L5:
        org.c.a.a.d r2 = ((org.c.a.d.l) ZeusTransformUtils.preCheckCast(r3, org.c.a.d.l.class, "com.obric.aiagent.plugin")).c();
        if (r2 != org.c.a.a.d.f40327d) goto L8;
    L9:
        return true;
    L8:
        if (r2 == org.c.a.a.d.f40326c) goto L9;
        return false;
    }

    private boolean m() {
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.n.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.i.isEmpty() == true) goto L9;
        if (ZeusTransformUtils.instanceOf(this.i.peek(), org.c.a.d.m.class) == false) goto L9;
        return true;
    }

    private boolean n() {
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.j.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.i.isEmpty() == true) goto L9;
        if (ZeusTransformUtils.instanceOf(this.i.peek(), org.c.a.d.i.class) == false) goto L9;
        return true;
    }

    private boolean o() {
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.f.class) == true) goto L5;
        return false;
    L5:
        if (this.i.isEmpty() == true) goto L25;
        org.c.a.d.g r3 = (org.c.a.d.g) ZeusTransformUtils.preCheckCast(this.i.peek(), org.c.a.d.g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, org.c.a.d.l.class) == false) goto L20;
        org.c.a.d.l r4 = (org.c.a.d.l) ZeusTransformUtils.preCheckCast(r3, org.c.a.d.l.class, "com.obric.aiagent.plugin");
        if (r4.h() == null) goto L12;
        return false;
    L12:
        if (r4.b() == null) goto L14;
        return false;
    L14:
        if (r4.i() != null) goto L16;
        return false;
    L16:
        if (r4.e().length() != 0) goto L24;
        return true;
    L24:
        return false;
    L20:
        return false;
    L25:
        return false;
    }

    private boolean p() {
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.k.class) == true) goto L5;
    L10:
        int r0 = 0;
    L11:
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.l.class) == false) goto L15;
        r3 = ((org.c.a.d.l) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.l.class, "com.obric.aiagent.plugin")).b();
    L17:
        if (r3 == null) goto L23;
        if (this.H != null) goto L21;
        this.H = g(r3);
    L21:
        r0 = r0 + this.H.length();
    L23:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.l.class) == false) goto L29;
        if (this.I != null) goto L27;
        this.I = h(((org.c.a.d.l) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.l.class, "com.obric.aiagent.plugin")).e());
    L27:
        r0 = r0 + this.I.a().length();
    L29:
        if (r0 < this.D) goto L31;
        return false;
    L31:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.a.class) == false) goto L33;
    L42:
        return true;
    L33:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.l.class) == false) goto L39;
        if (this.I.b() == true) goto L39;
        if (this.I.c() == false) goto L42;
    L39:
        if (m() == true) goto L42;
        if (n() == true) goto L42;
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.c.class) == false) goto L17;
        r3 = ((org.c.a.d.c) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.c.class, "com.obric.aiagent.plugin")).b();
        goto L17
    L5:
        if (((org.c.a.d.k) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.k.class, "com.obric.aiagent.plugin")).h() == null) goto L10;
        if (this.G != null) goto L9;
        this.G = a(((org.c.a.d.k) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.k.class, "com.obric.aiagent.plugin")).h());
    L9:
        r0 = this.G.length() + 0;
        goto L11
    }

    private void d(String r4) {
        org.c.a.d.k r0 = (org.c.a.d.k) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.k.class, "com.obric.aiagent.plugin");
        if (r0.h() != null) goto L7;
        this.G = null;
        return;
    L7:
        if (this.G != null) goto L9;
        this.G = a(r0.h());
    L9:
        a(r4 + this.G, true, false, false);
        this.G = null;
    }

    private void q() {
        if (ZeusTransformUtils.instanceOf(this.j, org.c.a.d.l.class) == false) goto L24;
        org.c.a.d.l r0 = (org.c.a.d.l) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.l.class, "com.obric.aiagent.plugin");
        String r1 = r0.b();
        if (this.f40349J != null) goto L8;
        this.f40349J = r();
    L8:
        if (this.u.booleanValue() == false) goto L11;
        if (r1 == null) goto L11;
    L21:
        if (r0.i().a() == false) goto L31;
        if (r1 != null) goto L31;
        this.H = null;
        r1 = "!";
    L31:
        if (r1 == null) goto L38;
        if (this.H != null) goto L35;
        this.H = g(r1);
    L35:
        a(this.H, true, false, false);
        this.H = null;
        return;
    L38:
        throw new org.c.a.b.b("tag is not specified");
    L11:
        if (this.f40349J != null) goto L15;
        if (r0.i().a() == false) goto L15;
    L18:
        this.H = null;
        return;
    L15:
        if (this.f40349J == null) goto L21;
        if (r0.i().b() == false) goto L21;
    L24:
        org.c.a.d.c r2 = (org.c.a.d.c) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.c.class, "com.obric.aiagent.plugin");
        r1 = r2.b();
        if (this.u.booleanValue() == false) goto L28;
        if (r1 != null) goto L31;
    L28:
        if (r2.c() == false) goto L31;
        this.H = null;
    }

    private org.c.a.a.d r() {
        org.c.a.d.l r0 = (org.c.a.d.l) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.l.class, "com.obric.aiagent.plugin");
        if (this.I != null) goto L6;
        this.I = h(r0.e());
    L6:
        if (r0.j() == true) goto L10;
        if (r0.c() != org.c.a.a.d.f40324a) goto L10;
    L12:
        return org.c.a.a.d.f40324a;
    L10:
        if (this.u.booleanValue() == true) goto L12;
        if (r0.j() == false) goto L34;
        if (r0.i().a() == false) goto L34;
        if (this.p == false) goto L24;
        if (this.I.b() == true) goto L34;
        if (this.I.c() == true) goto L34;
    L24:
        if (this.m == 0) goto L28;
        if (this.I.d() == false) goto L28;
        return null;
    L28:
        if (this.m != 0) goto L34;
        if (this.I.e() == false) goto L34;
        return null;
    L34:
        if (r0.j() == true) goto L48;
        if (r0.c() == org.c.a.a.d.f40326c) goto L40;
        if (r0.c() != org.c.a.a.d.f40327d) goto L48;
    L40:
        if (this.m != 0) goto L48;
        if (this.p == true) goto L48;
        if (this.I.g() == false) goto L48;
        return r0.c();
    L48:
        if (r0.j() == true) goto L52;
        if (r0.c() == org.c.a.a.d.f40325b) goto L52;
    L60:
        return org.c.a.a.d.f40324a;
    L52:
        if (this.I.f() == false) goto L60;
        if (this.p == false) goto L58;
        if (this.I.c() == true) goto L60;
    L58:
        return org.c.a.a.d.f40325b;
    }

    private void s() {
        org.c.a.d.l r0 = (org.c.a.d.l) ZeusTransformUtils.preCheckCast(this.j, org.c.a.d.l.class, "com.obric.aiagent.plugin");
        if (this.I != null) goto L6;
        this.I = h(r0.e());
    L6:
        if (this.f40349J != null) goto L9;
        this.f40349J = r();
    L9:
        if (this.p == false) goto L11;
    L13:
        boolean r1 = false;
    L15:
        if (this.f40349J != null) goto L17;
        b(this.I.a(), r1);
    L31:
        this.I = null;
        this.f40349J = null;
        return;
    L17:
        int r2 = AnonymousClass1.f40350a[this.f40349J.ordinal()];
        if (r2 != 1) goto L20;
        d(this.I.a(), r1);
        goto L31
    L20:
        if (r2 != 2) goto L22;
        c(this.I.a(), r1);
        goto L31
    L22:
        if (r2 != 3) goto L24;
        a(this.I.a(), r1);
        goto L31
    L24:
        if (r2 != 4) goto L27;
        c(this.I.a());
        goto L31
    L27:
        throw new org.c.a.c.c("Unexpected style: " + this.f40349J);
    L11:
        if (this.C == false) goto L13;
        r1 = true;
        goto L15
    }

    private String a(org.c.a.a.e r3) {
        if (r3.a() != 1) goto L7;
        return r3.b();
    L7:
        throw new org.c.a.b.b("unsupported YAML version: " + r3);
    }

    private String e(String r3) {
        if (r3.length() == 0) goto L19;
        if (r3.charAt(0) != '!') goto L17;
        if (r3.charAt(r3.length() - 1) != '!') goto L17;
        if ("!".equals(r3) == false) goto L11;
    L15:
        return r3;
    L11:
        if (M.matcher(r3).matches() == true) goto L15;
        throw new org.c.a.b.b("invalid character in the tag handle: " + r3);
    L17:
        throw new org.c.a.b.b("tag handle must start and end with '!': " + r3);
    L19:
        throw new org.c.a.b.b("tag handle must not be empty");
    }

    private String f(String r4) {
        if (r4.length() == 0) goto L16;
        StringBuilder r3 = new StringBuilder();
        if (r4.charAt(0) != '!') goto L7;
        int r1 = 1;
    L9:
        if (r1 >= r4.length()) goto L11;
        r1 = r1 + 1;
        goto L9
    L11:
        if (r1 <= 0) goto L14;
        r3.append(r4, 0, r1);
    L14:
        return r3.toString();
    L7:
        r1 = 0;
        goto L9
    L16:
        throw new org.c.a.b.b("tag prefix must not be empty");
    }

    private String g(String r7) {
        if (r7.length() == 0) goto L29;
        if ("!".equals(r7) == false) goto L7;
        return r7;
    L7:
        String r1 = null;
        Iterator<String> r2 = this.F.keySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (r7.startsWith(r3) == false) goto L9;
        if ("!".equals(r3) == true) goto L16;
        if (r3.length() >= r7.length()) goto L9;
    L16:
        r1 = r3;
        goto L9
    L17:
        if (r1 == null) goto L19;
        r7 = r7.substring(r1.length());
        r1 = (String) ZeusTransformUtils.preCheckCast(this.F.get(r1), String.class, "com.obric.aiagent.plugin");
    L19:
        int r6 = r7.length();
        if (r6 <= 0) goto L22;
        String r8 = r7.substring(0, r6);
    L23:
        if (r1 == null) goto L27;
        return r1 + r8;
    L27:
        return "!<" + r8 + ">";
    L22:
        r8 = "";
        goto L23
    L29:
        throw new org.c.a.b.b("tag must not be empty");
    }

    static String a(String r4) {
        if (r4.length() == 0) goto L18;
        Iterator<Character> r0 = f40346c.iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        Character r1 = (Character) ZeusTransformUtils.preCheckCast(r0.next(), Character.class, "com.obric.aiagent.plugin");
        if (r4.indexOf(r1.charValue()) <= (-1)) goto L6;
        throw new org.c.a.b.b("Invalid character '" + r1 + "' in the anchor: " + r4);
    L13:
        if (f40345b.matcher(r4).find() == true) goto L16;
        return r4;
    L16:
        throw new org.c.a.b.b("Anchor may not contain spaces: " + r4);
    L18:
        throw new org.c.a.b.b("anchor must not be empty");
    }

    private org.c.a.b.d h(String r21) {
        if (r21.length() != 0) goto L7;
        return new org.c.a.b.d(r21, true, false, false, true, true, false);
    L7:
        if (r21.startsWith("---") == false) goto L9;
    L12:
        boolean r0 = true;
        boolean r4 = true;
    L14:
        if (r21.length() != 1) goto L16;
    L19:
        boolean r5 = true;
    L20:
        boolean r14 = true;
        boolean r6 = r5;
        int r7 = 0;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        boolean r13 = false;
        boolean r15 = false;
        boolean r16 = false;
        boolean r17 = false;
        boolean r18 = r4;
        boolean r19 = false;
    L22:
        if (r7 >= r21.length()) goto L119;
        int r2 = r21.codePointAt(r7);
        if (r7 == 0) goto L26;
        boolean r110 = r0;
        if (",?[]{}".indexOf(r2) == (-1)) goto L42;
        int r1 = 58;
        r18 = true;
    L43:
        if (r2 != r1) goto L48;
        if (r6 == false) goto L46;
        r0 = true;
    L47:
        r18 = true;
    L50:
        if (r2 != 35) goto L53;
        if (r14 == false) goto L53;
    L52:
        r0 = true;
        r18 = true;
    L53:
        boolean r3 = org.c.a.j.a.f40482a.a(r2);
        if (r3 == false) goto L56;
        r19 = true;
    L56:
        int r111 = 32;
        if (r2 == 10) goto L81;
        if (32 > r2) goto L62;
        if (r2 <= 126) goto L81;
    L62:
        if (r2 == 133) goto L78;
        if (r2 < 160) goto L68;
        if (r2 <= 55295) goto L78;
    L68:
        if (r2 < 57344) goto L72;
        if (r2 <= 65533) goto L78;
    L72:
        if (r2 >= 65536) goto L74;
    L76:
        r15 = true;
    L82:
        if (r2 != r111) goto L91;
        if (r7 != 0) goto L86;
        r8 = true;
    L86:
        if (r7 != (r21.length() - 1)) goto L88;
        r10 = true;
    L88:
        if (r17 == false) goto L90;
        r12 = true;
    L90:
        r16 = true;
    L101:
        r17 = false;
    L102:
        r7 = r7 + Character.charCount(r2);
        if (org.c.a.j.a.f40486e.a(r2) == true) goto L107;
        if (r3 == true) goto L107;
        r14 = false;
    L108:
        boolean r112 = r0;
        if ((r7 + 1) >= r21.length()) goto L117;
        int r20 = Character.charCount(r21.codePointAt(r7)) + r7;
        if (r20 >= r21.length()) goto L117;
        if (org.c.a.j.a.f40486e.a(r21.codePointAt(r20)) == true) goto L117;
        if (r3 == true) goto L117;
        boolean r22 = false;
    L118:
        r6 = r22;
        r0 = r112;
    L117:
        r22 = true;
    L107:
        r14 = true;
        goto L108
    L91:
        if (r3 == false) goto L100;
        if (r7 != 0) goto L95;
        r9 = true;
    L95:
        if (r7 != (r21.length() - 1)) goto L97;
        r11 = true;
    L97:
        if (r16 == false) goto L99;
        r13 = true;
    L99:
        r16 = false;
        r17 = true;
        goto L102
    L100:
        r16 = false;
        goto L101
    L74:
        if (r2 > 1114111) goto L76;
    L78:
        if (this.w == true) goto L81;
        r111 = 32;
        r15 = true;
    L81:
        r111 = 32;
        goto L82
    L46:
        r0 = r110;
        goto L47
    L48:
        r0 = r110;
        goto L50
    L42:
        r1 = 58;
        goto L43
    L26:
        if ("#,[]{}&*!|>'\"%@`".indexOf(r2) == (-1)) goto L29;
        r0 = true;
        r18 = true;
    L29:
        if (r2 != 63) goto L31;
    L32:
        if (r6 == false) goto L34;
        r0 = true;
    L34:
        r18 = true;
    L36:
        if (r2 != 45) goto L53;
        if (r6 == false) goto L53;
    L31:
        if (r2 != 58) goto L36;
    L119:
        boolean r113 = r0;
        if (r8 == true) goto L126;
        if (r9 == true) goto L126;
        if (r10 == true) goto L126;
        if (r11 == true) goto L126;
        boolean r23 = true;
        boolean r114 = true;
    L127:
        boolean r24 = !r10;
        if (r12 == false) goto L130;
        r23 = false;
        r114 = false;
    L130:
        boolean r25 = true ^ r12;
        if (r13 == true) goto L135;
        if (r15 == true) goto L135;
        boolean r26 = r25;
        boolean r27 = r24;
    L136:
        if (r19 == false) goto L138;
        r114 = false;
    L138:
        if (r18 == false) goto L140;
        r114 = false;
    L140:
        if (r113 == false) goto L142;
        boolean r28 = false;
    L144:
        return new org.c.a.b.d(r21, false, r19, r114, r28, r26, r27);
    L142:
        r28 = r23;
    L135:
        r23 = false;
        r26 = false;
        r27 = false;
        r114 = false;
    L126:
        r23 = false;
        r114 = false;
        goto L127
    L16:
        if (org.c.a.j.a.f40485d.a(r21.codePointAt(1)) == true) goto L19;
        r5 = false;
        goto L20
    L9:
        if (r21.startsWith("...") == true) goto L12;
        r0 = false;
        r4 = false;
        goto L14
    }

    void a() {
        this.f.flush();
    }

    void c() {
        a();
    }

    void a(String r3, boolean r4, boolean r5, boolean r6) {
        boolean r1 = true;
        if (this.r == true) goto L6;
        if (r4 == false) goto L6;
        this.q++;
        this.f.write(f40344a);
    L6:
        this.r = r5;
        if (this.s == false) goto L10;
        if (r6 == false) goto L10;
    L11:
        this.s = r1;
        this.q += r3.length();
        this.t = false;
        this.f.write(r3);
        return;
    L10:
        r1 = false;
        goto L11
    }

    void d() {
        Integer r0 = this.l;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L7:
        if (this.s == false) goto L13;
        int r2 = this.q;
        if (r2 > r1) goto L13;
        if (r2 == r1) goto L12;
    L14:
        a(r1 - this.q);
        return;
    L12:
        if (this.r == true) goto L14;
    L13:
        i(null);
        goto L14
    L5:
        r1 = 0;
        goto L7
    }

    private void a(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.r = true;
        char[] r0 = new char[r4];
        int r1 = 0;
    L5:
        if (r1 >= r4) goto L7;
        r0[r1] = ' ';
        r1 = r1 + 1;
        goto L5
    L7:
        this.q += r4;
        this.f.write(r0);
    }

    private void i(String r2) {
        this.r = true;
        this.s = true;
        this.q = 0;
        if (r2 != null) goto L5;
        this.f.write(this.B);
        return;
    L5:
        this.f.write(r2);
    }

    void b(String r3) {
        this.f.write("%YAML ");
        this.f.write(r3);
        i(null);
    }

    void a(String r3, String r4) {
        this.f.write("%TAG ");
        this.f.write(r3);
        this.f.write(f40344a);
        this.f.write(r4);
        i(null);
    }

    private void c(String r17, boolean r18) {
        a("'", true, false, false);
        int r5 = 0;
        boolean r6 = false;
        boolean r7 = false;
        int r8 = 0;
    L4:
        if (r5 > r17.length()) goto L52;
        if (r5 >= r17.length()) goto L8;
        char r9 = r17.charAt(r5);
    L10:
        if (r6 == false) goto L23;
        if (r9 == 0) goto L14;
        if (r9 != ' ') goto L14;
    L44:
        if (r9 != '\'') goto L46;
        this.q += 2;
        this.f.write("''");
        r8 = r5 + 1;
    L46:
        if (r9 == 0) goto L51;
        if (r9 != ' ') goto L49;
        r6 = true;
    L50:
        r7 = org.c.a.j.a.f40482a.a(r9);
        goto L51
    L49:
        r6 = false;
    L51:
        r5 = r5 + 1;
    L14:
        if ((r8 + 1) == r5) goto L16;
    L22:
        int r11 = r5 - r8;
        this.q += r11;
        this.f.write(r17, r8, r11);
    L42:
        r8 = r5;
        goto L44
    L16:
        if (this.q <= this.A) goto L22;
        if (r18 == false) goto L22;
        if (r8 == 0) goto L22;
        if (r5 == r17.length()) goto L22;
        d();
        goto L42
    L23:
        if (r7 == false) goto L39;
        if (r9 == 0) goto L28;
        if (org.c.a.j.a.f40482a.b(r9) == false) goto L44;
    L28:
        if (r17.charAt(r8) != '\n') goto L30;
        i(null);
    L30:
        char[] r10 = r17.substring(r8, r5).toCharArray();
        int r12 = r10.length;
        int r14 = 0;
    L31:
        if (r14 >= r12) goto L37;
        char r15 = r10[r14];
        if (r15 != '\n') goto L35;
        i(null);
    L36:
        r14 = r14 + 1;
        goto L31
    L35:
        i(String.valueOf(r15));
        goto L36
    L37:
        d();
        goto L42
    L39:
        if (org.c.a.j.a.f40482a.a(r9, "\u0000 '") == false) goto L44;
        if (r8 >= r5) goto L44;
        int r13 = r5 - r8;
        this.q += r13;
        this.f.write(r17, r8, r13);
        goto L42
    L8:
        r9 = 0;
        goto L10
    L52:
        a("'", false, false, false);
    }

    private void d(String r14, boolean r15) {
        a("\"", true, false, false);
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 > r14.length()) goto L59;
        Character r5 = null;
        if (r3 >= r14.length()) goto L9;
        r5 = Character.valueOf(r14.charAt(r3));
    L9:
        if (r5 != null) goto L11;
    L16:
        if (r4 >= r3) goto L18;
        int r8 = r3 - r4;
        this.q += r8;
        this.f.write(r14, r4, r8);
        r4 = r3;
    L18:
        if (r5 == null) goto L41;
        Map<Character, String> r6 = f40347d;
        if (r6.containsKey(r5) == false) goto L23;
        String r7 = "\\" + ((String) ZeusTransformUtils.preCheckCast(r6.get(r5), String.class, "com.obric.aiagent.plugin"));
    L40:
        this.q += r7.length();
        this.f.write(r7);
        r4 = r3 + 1;
        goto L41
    L23:
        if (this.w == false) goto L29;
        if (org.c.a.h.b.a(r5.charValue()) == false) goto L29;
        r7 = String.valueOf(r5);
    L29:
        if (r5.charValue() > 255) goto L32;
        String r9 = "0" + Integer.toString(r5.charValue(), 16);
        r7 = "\\x" + r9.substring(r9.length() - 2);
        goto L40
    L32:
        if (r5.charValue() >= 55296) goto L34;
    L39:
        String r10 = "000" + Integer.toString(r5.charValue(), 16);
        r7 = "\\u" + r10.substring(r10.length() - 4);
        goto L40
    L34:
        if (r5.charValue() > 56319) goto L39;
        int r11 = r3 + 1;
        if (r11 >= r14.length()) goto L38;
        String r12 = "000" + Long.toHexString(Character.toCodePoint(r5.charValue(), Character.valueOf(r14.charAt(r11)).charValue()));
        r7 = "\\U" + r12.substring(r12.length() - 8);
        r3 = r11;
        goto L40
    L38:
        String r13 = "000" + Integer.toString(r5.charValue(), 16);
        r7 = "\\u" + r13.substring(r13.length() - 4);
    L41:
        if (r3 <= 0) goto L58;
        if (r3 >= (r14.length() - 1)) goto L58;
        if (r5.charValue() == ' ') goto L48;
        if (r4 < r3) goto L58;
    L48:
        if ((this.q + (r3 - r4)) <= this.A) goto L58;
        if (r15 == false) goto L58;
        if (r4 < r3) goto L52;
        String r16 = "\\";
    L53:
        if (r4 >= r3) goto L55;
        r4 = r3;
    L55:
        this.q += r16.length();
        this.f.write(r16);
        d();
        this.r = false;
        this.s = false;
        if (r14.charAt(r4) != ' ') goto L58;
        this.q++;
        this.f.write("\\");
        goto L58
    L52:
        r16 = r14.substring(r4, r3) + "\\";
    L58:
        r3 = r3 + 1;
        goto L4
    L11:
        if ("\"\\\u0085\u2028\u2029\ufeff".indexOf(r5.charValue()) != (-1)) goto L16;
        if (' ' > r5.charValue()) goto L16;
        if (r5.charValue() <= '~') goto L41;
    L59:
        a("\"", false, false, false);
    }

    private boolean a(List<org.c.a.a.b> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (this.E == false) goto L29;
        Iterator r12 = r11.iterator();
        boolean r4 = true;
        boolean r3 = false;
        int r5 = 0;
    L6:
        if (r12.hasNext() == false) goto L25;
        org.c.a.a.b r6 = (org.c.a.a.b) ZeusTransformUtils.preCheckCast(r12.next(), org.c.a.a.b.class, "com.obric.aiagent.plugin");
        if (r6.a() != org.c.a.a.c.f40340a) goto L10;
        i(null);
        d();
    L23:
        r3 = true;
        goto L6
    L10:
        if (r4 == true) goto L12;
        a(r5);
        a("#", false, false, false);
    L21:
        this.f.write(r6.b());
        i(null);
        goto L23
    L12:
        if (r6.a() != org.c.a.a.c.f40342c) goto L14;
        boolean r7 = true;
    L15:
        a("#", r7, false, false);
        int r8 = this.q;
        if (r8 <= 0) goto L18;
        int r9 = r8 - 1;
    L19:
        r5 = r9;
        r4 = false;
        goto L21
    L18:
        r9 = 0;
        goto L19
    L14:
        r7 = false;
        goto L15
    L25:
        return r3;
    L29:
        return false;
    }

    private void t() {
        if (this.K.c() == true) goto L6;
        d();
        a(this.K.b());
        return;
    }

    private boolean u() {
        return a(this.L.b());
    }

    private String j(String r5) {
        StringBuilder r0 = new StringBuilder();
        if (org.c.a.j.a.f40482a.a(r5.charAt(0), " ") == false) goto L6;
        r0.append(this.x);
    L6:
        if (org.c.a.j.a.f40482a.b(r5.charAt(r5.length() - 1)) == false) goto L9;
        r0.append("-");
    L14:
        return r0.toString();
    L9:
        if (r5.length() != 1) goto L11;
    L12:
        r0.append("+");
        goto L14
    L11:
        if (org.c.a.j.a.f40482a.a(r5.charAt(r5.length() - 2)) == false) goto L14;
        goto L12
    }

    void a(String r17, boolean r18) {
        String r2 = j(r17);
        a(">" + r2, true, false, false);
        if (r2.length() <= 0) goto L8;
        if (r2.charAt(r2.length() - 1) != '+') goto L8;
        this.t = true;
    L8:
        if (u() == true) goto L10;
        i(null);
    L10:
        boolean r6 = true;
        boolean r9 = true;
        int r3 = 0;
        boolean r7 = false;
        int r8 = 0;
    L12:
        if (r3 > r17.length()) goto L62;
        if (r3 >= r17.length()) goto L16;
        char r10 = r17.charAt(r3);
    L18:
        if (r6 == false) goto L41;
        if (r10 == 0) goto L23;
        if (org.c.a.j.a.f40482a.b(r10) == true) goto L23;
    L56:
        if (r10 == 0) goto L61;
        r6 = org.c.a.j.a.f40482a.a(r10);
        if (r10 != ' ') goto L60;
        r7 = true;
        goto L61
    L60:
        r7 = false;
    L61:
        r3 = r3 + 1;
    L23:
        if (r9 == true) goto L29;
        if (r10 == 0) goto L29;
        if (r10 == ' ') goto L29;
        if (r17.charAt(r8) != '\n') goto L29;
        i(null);
    L29:
        if (r10 != ' ') goto L31;
        r9 = true;
    L32:
        char[] r11 = r17.substring(r8, r3).toCharArray();
        int r13 = r11.length;
        int r14 = 0;
    L33:
        if (r14 >= r13) goto L39;
        char r15 = r11[r14];
        if (r15 != '\n') goto L37;
        i(null);
    L38:
        r14 = r14 + 1;
        goto L33
    L37:
        i(String.valueOf(r15));
        goto L38
    L39:
        if (r10 == 0) goto L55;
        d();
    L55:
        r8 = r3;
        goto L56
    L31:
        r9 = false;
        goto L32
    L41:
        if (r7 == false) goto L51;
        if (r10 == ' ') goto L56;
        if ((r8 + 1) == r3) goto L46;
    L49:
        int r12 = r3 - r8;
        this.q += r12;
        this.f.write(r17, r8, r12);
        goto L55
    L46:
        if (this.q <= this.A) goto L49;
        if (r18 == false) goto L49;
        d();
        goto L55
    L51:
        if (org.c.a.j.a.f40482a.a(r10, "\u0000 ") == false) goto L56;
        int r16 = r3 - r8;
        this.q += r16;
        this.f.write(r17, r8, r16);
        if (r10 != 0) goto L55;
        i(null);
        goto L55
    L16:
        r10 = 0;
        goto L18
    }

    void c(String r11) {
        String r0 = j(r11);
        boolean r2 = true;
        a("|" + r0, true, false, false);
        if (r0.length() <= 0) goto L8;
        if (r0.charAt(r0.length() - 1) != '+') goto L8;
        this.t = true;
    L8:
        if (u() == true) goto L10;
        i(null);
    L10:
        int r1 = 0;
        int r4 = 0;
    L12:
        if (r1 > r11.length()) goto L40;
        if (r1 >= r11.length()) goto L16;
        char r5 = r11.charAt(r1);
    L17:
        if (r2 == false) goto L30;
        if (r5 != 0) goto L20;
    L21:
        char[] r6 = r11.substring(r4, r1).toCharArray();
        int r7 = r6.length;
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L28;
        char r9 = r6[r8];
        if (r9 != '\n') goto L26;
        i(null);
    L27:
        r8 = r8 + 1;
        goto L22
    L26:
        i(String.valueOf(r9));
        goto L27
    L28:
        if (r5 == 0) goto L36;
        d();
    L36:
        r4 = r1;
    L37:
        if (r5 == 0) goto L39;
        r2 = org.c.a.j.a.f40482a.a(r5);
    L39:
        r1 = r1 + 1;
        goto L12
    L20:
        if (org.c.a.j.a.f40482a.b(r5) == false) goto L37;
    L30:
        if (r5 != 0) goto L32;
    L33:
        this.f.write(r11, r4, r1 - r4);
        if (r5 != 0) goto L36;
        i(null);
        goto L36
    L32:
        if (org.c.a.j.a.f40482a.a(r5) == false) goto L37;
    L16:
        r5 = 0;
        goto L17
    }

    void b(String r14, boolean r15) {
        if (this.n == false) goto L6;
        this.t = true;
    L6:
        if (r14.length() != 0) goto L9;
        return;
    L9:
        if (this.r == true) goto L11;
        this.q++;
        this.f.write(f40344a);
    L11:
        this.r = false;
        this.s = false;
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
        int r5 = 0;
    L13:
        if (r2 > r14.length()) goto L52;
        if (r2 >= r14.length()) goto L17;
        char r6 = r14.charAt(r2);
    L19:
        if (r3 == false) goto L28;
        if (r6 != ' ') goto L22;
    L46:
        if (r6 == 0) goto L51;
        if (r6 != ' ') goto L49;
        r3 = true;
    L50:
        r4 = org.c.a.j.a.f40482a.a(r6);
        goto L51
    L49:
        r3 = false;
    L51:
        r2 = r2 + 1;
        goto L13
    L22:
        if ((r5 + 1) == r2) goto L24;
    L27:
        int r8 = r2 - r5;
        this.q += r8;
        this.f.write(r14, r5, r8);
    L45:
        r5 = r2;
        goto L46
    L24:
        if (this.q <= this.A) goto L27;
        if (r15 == false) goto L27;
        d();
        this.r = false;
        this.s = false;
        goto L45
    L28:
        if (r4 == false) goto L43;
        if (org.c.a.j.a.f40482a.b(r6) == false) goto L46;
        if (r14.charAt(r5) != '\n') goto L34;
        i(null);
    L34:
        char[] r7 = r14.substring(r5, r2).toCharArray();
        int r9 = r7.length;
        int r11 = 0;
    L35:
        if (r11 >= r9) goto L41;
        char r12 = r7[r11];
        if (r12 != '\n') goto L39;
        i(null);
    L40:
        r11 = r11 + 1;
        goto L35
    L39:
        i(String.valueOf(r12));
        goto L40
    L41:
        d();
        this.r = false;
        this.s = false;
        goto L45
    L43:
        if (org.c.a.j.a.f40482a.a(r6, "\u0000 ") == false) goto L46;
        int r10 = r2 - r5;
        this.q += r10;
        this.f.write(r14, r5, r10);
        goto L45
    L17:
        r6 = 0;
        goto L19
    }
}
