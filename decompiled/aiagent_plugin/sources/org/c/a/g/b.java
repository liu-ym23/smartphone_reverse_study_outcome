package org.c.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ParserImpl.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f40426b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final org.c.a.j.b f40427a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private org.c.a.d.g f40428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final org.c.a.m.a<org.c.a.g.c> f40429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final org.c.a.m.a<org.c.a.c.a> f40430e;
    private org.c.a.g.c f;
    private org.c.a.g.d g;

    /* JADX INFO: renamed from: org.c.a.g.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: ParserImpl.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class a implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40431a;

        private a(b r1) {
            this.f40431a = r1;
        }

        /* synthetic */ a(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.l.v r0 = this.f40431a.f40427a.b();
            b.c(this.f40431a).a(r0.e());
            return new C1095b(this.f40431a, null).a();
        }
    }

    /* JADX INFO: renamed from: org.c.a.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ParserImpl.java */
    private class C1095b implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40432a;

        private C1095b(b r1) {
            this.f40432a = r1;
        }

        /* synthetic */ C1095b(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40432a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L7;
            b.a(this.f40432a, new C1095b(this.f40432a));
            b r6 = this.f40432a;
            return b.a(r6, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r6.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L7:
            if (this.f40432a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.o}) == false) goto L15;
            org.c.a.l.v r0 = this.f40432a.f40427a.b();
            AnonymousClass1 r2 = null;
            if (this.f40432a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.o, org.c.a.l.v.a.t, org.c.a.l.v.a.f40516c}) == true) goto L12;
            b.a(this.f40432a).a(new c(this.f40432a, r2));
            return b.d(this.f40432a);
        L12:
            b.a(this.f40432a, new c(this.f40432a, r2));
            return b.a(this.f40432a, r0.f());
        L15:
            if (this.f40432a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40516c}) == false) goto L18;
            org.c.a.l.v r1 = this.f40432a.f40427a.b();
            org.c.a.d.i r3 = new org.c.a.d.i(r1.e(), r1.f());
            b r4 = this.f40432a;
            b.a(r4, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r4).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
            b.c(this.f40432a).a();
            return r3;
        L18:
            org.c.a.l.v r5 = this.f40432a.f40427a.a();
            throw new org.c.a.g.a("while parsing a block mapping", (org.c.a.c.a) ZeusTransformUtils.preCheckCast(b.c(this.f40432a).a(), org.c.a.c.a.class, "com.obric.aiagent.plugin"), "expected <block end>, but found '" + r5.b() + "'", r5.e());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class c implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40433a;

        private c(b r1) {
            this.f40433a = r1;
        }

        /* synthetic */ c(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            AnonymousClass1 r2 = null;
            if (this.f40433a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.t}) == false) goto L15;
            org.c.a.l.v r0 = this.f40433a.f40427a.b();
            if (this.f40433a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L9;
            b.a(this.f40433a, new d(this.f40433a, r2));
            return b.e(this.f40433a).a();
        L9:
            if (this.f40433a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.o, org.c.a.l.v.a.t, org.c.a.l.v.a.f40516c}) == true) goto L12;
            b.a(this.f40433a).a(new C1095b(this.f40433a, r2));
            return b.d(this.f40433a);
        L12:
            b.a(this.f40433a, new C1095b(this.f40433a, r2));
            return b.a(this.f40433a, r0.f());
        L15:
            if (this.f40433a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.p}) == false) goto L18;
            b.a(this.f40433a).a(new C1095b(this.f40433a, r2));
            return b.d(this.f40433a);
        L18:
            b.a(this.f40433a, new C1095b(this.f40433a, r2));
            return b.a(this.f40433a, this.f40433a.f40427a.a().e());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class d implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<org.c.a.l.g> f40434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f40435b;

        private d(b r1) {
            this.f40435b = r1;
            this.f40434a = new LinkedList();
        }

        /* synthetic */ d(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40435b.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L7;
            this.f40434a.add((org.c.a.l.g) ZeusTransformUtils.preCheckCast(this.f40435b.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
            return a();
        L7:
            if (this.f40435b.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.o, org.c.a.l.v.a.t, org.c.a.l.v.a.f40516c}) == false) goto L9;
            b.a(this.f40435b, new e(this.f40435b, this.f40434a));
            b r6 = this.f40435b;
            return b.a(r6, r6.f40427a.a().e());
        L9:
            if (this.f40434a.isEmpty() == false) goto L11;
            b.a(this.f40435b).a(new C1095b(this.f40435b, null));
            return b.d(this.f40435b);
        L11:
            return b.a(this.f40435b, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(this.f40434a.remove(0), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class e implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<org.c.a.l.g> f40436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f40437b;

        public e(b r3, List<org.c.a.l.g> r4) {
            List<org.c.a.l.g> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f40437b = r3;
            this.f40436a = r5;
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40436a.isEmpty() == true) goto L7;
            return b.a(this.f40437b, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(this.f40436a.remove(0), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L7:
            return new C1095b(this.f40437b, null).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class f implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40438a;

        private f(b r1) {
            this.f40438a = r1;
        }

        /* synthetic */ f(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            return b.a(this.f40438a, true, false);
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class g implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40439a;

        private g(b r1) {
            this.f40439a = r1;
        }

        /* synthetic */ g(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40439a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L7;
            b.a(this.f40439a, new g(this.f40439a));
            b r6 = this.f40439a;
            return b.a(r6, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r6.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L7:
            if (this.f40439a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40517d}) == false) goto L11;
            return new h(this.f40439a, (org.c.a.l.d) ZeusTransformUtils.preCheckCast(this.f40439a.f40427a.b(), org.c.a.l.d.class, "com.obric.aiagent.plugin")).a();
        L11:
            if (this.f40439a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40516c}) == false) goto L14;
            org.c.a.l.v r0 = this.f40439a.f40427a.b();
            org.c.a.d.m r1 = new org.c.a.d.m(r0.e(), r0.f());
            b r2 = this.f40439a;
            b.a(r2, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r2).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
            b.c(this.f40439a).a();
            return r1;
        L14:
            org.c.a.l.v r3 = this.f40439a.f40427a.a();
            throw new org.c.a.g.a("while parsing a block collection", (org.c.a.c.a) ZeusTransformUtils.preCheckCast(b.c(this.f40439a).a(), org.c.a.c.a.class, "com.obric.aiagent.plugin"), "expected <block end>, but found '" + r3.b() + "'", r3.e());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class h implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        org.c.a.l.d f40440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f40441b;

        public h(b r1, org.c.a.l.d r2) {
            this.f40441b = r1;
            this.f40440a = r2;
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40441b.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L6;
            b.a(this.f40441b, new h(this.f40441b, this.f40440a));
            b r5 = this.f40441b;
            return b.a(r5, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r5.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L6:
            AnonymousClass1 r1 = null;
            if (this.f40441b.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40517d, org.c.a.l.v.a.f40516c}) == true) goto L10;
            b.a(this.f40441b).a(new g(this.f40441b, r1));
            return new f(this.f40441b, r1).a();
        L10:
            b.a(this.f40441b, new g(this.f40441b, r1));
            return b.a(this.f40441b, this.f40440a.f());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class i implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40442a;

        private i(b r1) {
            this.f40442a = r1;
        }

        /* synthetic */ i(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.l.v r0 = this.f40442a.f40427a.b();
            b.c(this.f40442a).a(r0.e());
            return new g(this.f40442a, null).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class j implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40443a;

        private j(b r1) {
            this.f40443a = r1;
        }

        /* synthetic */ j(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40443a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L7;
            b.a(this.f40443a, new j(this.f40443a));
            b r6 = this.f40443a;
            return b.a(r6, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r6.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L7:
            if (this.f40443a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.g, org.c.a.l.v.a.i, org.c.a.l.v.a.h, org.c.a.l.v.a.q}) == false) goto L11;
            b r0 = this.f40443a;
            org.c.a.d.g r1 = b.a(r0, r0.f40427a.a().e());
            b r7 = this.f40443a;
            b.a(r7, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r7).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
            return r1;
        L11:
            return new f(this.f40443a, null).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class k implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40444a;

        private k(b r1) {
            this.f40444a = r1;
        }

        /* synthetic */ k(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.c.a r0 = this.f40444a.f40427a.a().e();
            boolean r2 = true;
            if (this.f40444a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.h}) == false) goto L5;
            org.c.a.c.a r1 = this.f40444a.f40427a.b().f();
        L6:
            org.c.a.d.e r3 = new org.c.a.d.e(r0, r1, r2);
            b.a(this.f40444a, new l(this.f40444a, null));
            return r3;
        L5:
            r1 = r0;
            r2 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class l implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40445a;

        private l(b r1) {
            this.f40445a = r1;
        }

        /* synthetic */ l(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
        L3:
            if (this.f40445a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.h}) == false) goto L5;
            this.f40445a.f40427a.b();
            goto L3
        L5:
            AnonymousClass1 r2 = null;
            if (this.f40445a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.q}) == true) goto L19;
            org.c.a.c.a r6 = this.f40445a.f40427a.a().e();
            org.c.a.g.d r0 = b.b(this.f40445a);
        L9:
            if (this.f40445a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L12;
            this.f40445a.f40427a.b();
            goto L9
        L12:
            if (this.f40445a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.q}) == true) goto L19;
            if (this.f40445a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.i}) == false) goto L18;
            org.c.a.d.f r1 = new org.c.a.d.f(r6, this.f40445a.f40427a.b().f(), true, r0.a(), r0.b());
            b.a(this.f40445a).a(new k(this.f40445a, r2));
            b.a(this.f40445a, new j(this.f40445a, r2));
            return r1;
        L18:
            throw new org.c.a.g.a(null, null, "expected '<document start>', but found '" + this.f40445a.f40427a.a().b() + "'", this.f40445a.f40427a.a().e());
        L19:
            org.c.a.l.r r3 = (org.c.a.l.r) ZeusTransformUtils.preCheckCast(this.f40445a.f40427a.b(), org.c.a.l.r.class, "com.obric.aiagent.plugin");
            org.c.a.d.o r4 = new org.c.a.d.o(r3.e(), r3.f());
            if (b.a(this.f40445a).b() == false) goto L28;
            if (b.c(this.f40445a).b() == false) goto L26;
            b.a(this.f40445a, null);
            return r4;
        L26:
            throw new org.c.a.c.c("Unexpected end of stream. Marks left: " + b.c(this.f40445a));
        L28:
            throw new org.c.a.c.c("Unexpected end of stream. States left: " + b.a(this.f40445a));
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class m implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40446a;

        private m(b r1) {
            this.f40446a = r1;
        }

        /* synthetic */ m(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            b r0 = this.f40446a;
            org.c.a.d.d r1 = b.a(r0, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r0.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
            if (this.f40446a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == true) goto L5;
            b r6 = this.f40446a;
            b.a(r6, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r6).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
        L5:
            return r1;
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class n implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40447a;

        private n(b r1) {
            this.f40447a = r1;
        }

        /* synthetic */ n(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            b.a(this.f40447a, new p(this.f40447a, false));
            b r4 = this.f40447a;
            return b.a(r4, r4.f40427a.a().e());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class o implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40448a;

        private o(b r1) {
            this.f40448a = r1;
        }

        /* synthetic */ o(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.l.v r0 = this.f40448a.f40427a.b();
            b.c(this.f40448a).a(r0.e());
            return new p(this.f40448a, true).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class p implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40450b;

        public p(b r1, boolean r2) {
            this.f40449a = r1;
            this.f40450b = r2;
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L6;
            b.a(this.f40449a, new p(this.f40449a, this.f40450b));
            b r7 = this.f40449a;
            return b.a(r7, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r7.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L6:
            AnonymousClass1 r3 = null;
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.k}) == false) goto L9;
        L30:
            org.c.a.l.v r0 = this.f40449a.f40427a.b();
            org.c.a.d.i r5 = new org.c.a.d.i(r0.e(), r0.f());
            b.c(this.f40449a).a();
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == true) goto L33;
            b r8 = this.f40449a;
            b.a(r8, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r8).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
        L34:
            return r5;
        L33:
            b.a(this.f40449a, new m(this.f40449a, r3));
            goto L34
        L9:
            if (this.f40450b == true) goto L19;
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.j}) == false) goto L16;
            this.f40449a.f40427a.b();
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L19;
            b.a(this.f40449a, new p(this.f40449a, true));
            b r9 = this.f40449a;
            return b.a(r9, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r9.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L16:
            org.c.a.l.v r1 = this.f40449a.f40427a.a();
            throw new org.c.a.g.a("while parsing a flow mapping", (org.c.a.c.a) ZeusTransformUtils.preCheckCast(b.c(this.f40449a).a(), org.c.a.c.a.class, "com.obric.aiagent.plugin"), "expected ',' or '}', but got " + r1.b(), r1.e());
        L19:
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.o}) == false) goto L27;
            org.c.a.l.v r2 = this.f40449a.f40427a.b();
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.t, org.c.a.l.v.a.j, org.c.a.l.v.a.k}) == true) goto L24;
            b.a(this.f40449a).a(new q(this.f40449a, r3));
            return b.f(this.f40449a);
        L24:
            b.a(this.f40449a, new q(this.f40449a, r3));
            return b.a(this.f40449a, r2.f());
        L27:
            if (this.f40449a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.k}) == true) goto L30;
            b.a(this.f40449a).a(new n(this.f40449a, r3));
            return b.f(this.f40449a);
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class q implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40451a;

        private q(b r1) {
            this.f40451a = r1;
        }

        /* synthetic */ q(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40451a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.t}) == false) goto L10;
            org.c.a.l.v r0 = this.f40451a.f40427a.b();
            if (this.f40451a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.j, org.c.a.l.v.a.k}) == true) goto L8;
            b.a(this.f40451a).a(new p(this.f40451a, false));
            return b.f(this.f40451a);
        L8:
            b.a(this.f40451a, new p(this.f40451a, false));
            return b.a(this.f40451a, r0.f());
        L10:
            b.a(this.f40451a, new p(this.f40451a, false));
            return b.a(this.f40451a, this.f40451a.f40427a.a().e());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class r implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40453b;

        public r(b r1, boolean r2) {
            this.f40452a = r1;
            this.f40453b = r2;
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L6;
            b.a(this.f40452a, new r(this.f40452a, this.f40453b));
            b r11 = this.f40452a;
            return b.a(r11, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r11.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L6:
            AnonymousClass1 r3 = null;
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.m}) == false) goto L9;
        L26:
            org.c.a.l.v r0 = this.f40452a.f40427a.b();
            org.c.a.d.m r5 = new org.c.a.d.m(r0.e(), r0.f());
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == true) goto L29;
            b r1 = this.f40452a;
            b.a(r1, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r1).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
        L30:
            b.c(this.f40452a).a();
            return r5;
        L29:
            b.a(this.f40452a, new m(this.f40452a, r3));
            goto L30
        L9:
            if (this.f40453b == true) goto L19;
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.j}) == false) goto L16;
            this.f40452a.f40427a.b();
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L19;
            b.a(this.f40452a, new r(this.f40452a, true));
            b r12 = this.f40452a;
            return b.a(r12, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r12.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L16:
            org.c.a.l.v r2 = this.f40452a.f40427a.a();
            throw new org.c.a.g.a("while parsing a flow sequence", (org.c.a.c.a) ZeusTransformUtils.preCheckCast(b.c(this.f40452a).a(), org.c.a.c.a.class, "com.obric.aiagent.plugin"), "expected ',' or ']', but got " + r2.b(), r2.e());
        L19:
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.o}) == false) goto L23;
            org.c.a.l.v r4 = this.f40452a.f40427a.a();
            org.c.a.d.j r6 = new org.c.a.d.j(null, null, true, r4.e(), r4.f(), org.c.a.a.EnumC1093a.f40311a);
            b.a(this.f40452a, new t(this.f40452a, r3));
            return r6;
        L23:
            if (this.f40452a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.m}) == true) goto L26;
            b.a(this.f40452a).a(new r(this.f40452a, false));
            return b.f(this.f40452a);
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class s implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40454a;

        private s(b r1) {
            this.f40454a = r1;
        }

        /* synthetic */ s(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            b.a(this.f40454a, new r(this.f40454a, false));
            org.c.a.l.v r4 = this.f40454a.f40427a.a();
            return new org.c.a.d.i(r4.e(), r4.f());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class t implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40455a;

        private t(b r1) {
            this.f40455a = r1;
        }

        /* synthetic */ t(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.l.v r0 = this.f40455a.f40427a.b();
            AnonymousClass1 r2 = null;
            if (this.f40455a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.t, org.c.a.l.v.a.j, org.c.a.l.v.a.m}) == true) goto L6;
            b.a(this.f40455a).a(new u(this.f40455a, r2));
            return b.f(this.f40455a);
        L6:
            b.a(this.f40455a, new u(this.f40455a, r2));
            return b.a(this.f40455a, r0.f());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class u implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40456a;

        private u(b r1) {
            this.f40456a = r1;
        }

        /* synthetic */ u(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            AnonymousClass1 r2 = null;
            if (this.f40456a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.t}) == false) goto L10;
            org.c.a.l.v r0 = this.f40456a.f40427a.b();
            if (this.f40456a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.j, org.c.a.l.v.a.m}) == true) goto L8;
            b.a(this.f40456a).a(new s(this.f40456a, r2));
            return b.f(this.f40456a);
        L8:
            b.a(this.f40456a, new s(this.f40456a, r2));
            return b.a(this.f40456a, r0.f());
        L10:
            b.a(this.f40456a, new s(this.f40456a, r2));
            return b.a(this.f40456a, this.f40456a.f40427a.a().e());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class v implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40457a;

        private v(b r1) {
            this.f40457a = r1;
        }

        /* synthetic */ v(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.l.v r0 = this.f40457a.f40427a.b();
            b.c(this.f40457a).a(r0.e());
            return new r(this.f40457a, true).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class w implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40458a;

        private w(b r1) {
            this.f40458a = r1;
        }

        /* synthetic */ w(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40458a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L6;
            b.a(this.f40458a, new w(this.f40458a));
            b r8 = this.f40458a;
            return b.a(r8, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r8.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L6:
            AnonymousClass1 r1 = null;
            if (this.f40458a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.g, org.c.a.l.v.a.i, org.c.a.l.v.a.q}) == true) goto L11;
            org.c.a.c.a r4 = this.f40458a.f40427a.a().e();
            org.c.a.d.f r0 = new org.c.a.d.f(r4, r4, false, null, null);
            b.a(this.f40458a).a(new k(this.f40458a, r1));
            b.a(this.f40458a, new f(this.f40458a, r1));
            return r0;
        L11:
            return new l(this.f40458a, r1).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class x implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40459a;

        private x(b r1) {
            this.f40459a = r1;
        }

        /* synthetic */ x(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40459a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L7;
            b.a(this.f40459a, new x(this.f40459a));
            b r5 = this.f40459a;
            return b.a(r5, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r5.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L7:
            if (this.f40459a.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40517d}) == true) goto L9;
            org.c.a.l.v r0 = this.f40459a.f40427a.a();
            org.c.a.d.m r1 = new org.c.a.d.m(r0.e(), r0.f());
            b r6 = this.f40459a;
            b.a(r6, (org.c.a.g.c) ZeusTransformUtils.preCheckCast(b.a(r6).a(), org.c.a.g.c.class, "com.obric.aiagent.plugin"));
            return r1;
        L9:
            return new y(this.f40459a, (org.c.a.l.d) ZeusTransformUtils.preCheckCast(this.f40459a.f40427a.b(), org.c.a.l.d.class, "com.obric.aiagent.plugin")).a();
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class y implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        org.c.a.l.d f40460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f40461b;

        public y(b r1, org.c.a.l.d r2) {
            this.f40461b = r1;
            this.f40460a = r2;
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            if (this.f40461b.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.v}) == false) goto L6;
            b.a(this.f40461b, new y(this.f40461b, this.f40460a));
            b r5 = this.f40461b;
            return b.a(r5, (org.c.a.l.g) ZeusTransformUtils.preCheckCast(r5.f40427a.b(), org.c.a.l.g.class, "com.obric.aiagent.plugin"));
        L6:
            AnonymousClass1 r1 = null;
            if (this.f40461b.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40517d, org.c.a.l.v.a.o, org.c.a.l.v.a.t, org.c.a.l.v.a.f40516c}) == true) goto L10;
            b.a(this.f40461b).a(new x(this.f40461b, r1));
            return new f(this.f40461b, r1).a();
        L10:
            b.a(this.f40461b, new x(this.f40461b, r1));
            return b.a(this.f40461b, this.f40460a.f());
        }
    }

    /* JADX INFO: compiled from: ParserImpl.java */
    private class z implements org.c.a.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f40462a;

        private z(b r1) {
            this.f40462a = r1;
        }

        /* synthetic */ z(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.c.a.g.c
        public org.c.a.d.g a() {
            org.c.a.l.s r0 = (org.c.a.l.s) ZeusTransformUtils.preCheckCast(this.f40462a.f40427a.b(), org.c.a.l.s.class, "com.obric.aiagent.plugin");
            org.c.a.d.p r1 = new org.c.a.d.p(r0.e(), r0.f());
            b.a(this.f40462a, new w(this.f40462a, null));
            return r1;
        }
    }

    static /* synthetic */ org.c.a.d.d a(b r0, org.c.a.l.g r1) {
        return r0.a(r1);
    }

    static /* synthetic */ org.c.a.d.g a(b r0, org.c.a.c.a r1) {
        return r0.a(r1);
    }

    static /* synthetic */ org.c.a.d.g a(b r0, boolean r1, boolean r2) {
        return r0.a(r1, r2);
    }

    static /* synthetic */ org.c.a.g.c a(b r2, org.c.a.g.c r3) {
        org.c.a.g.c r4 = (org.c.a.g.c) ZeusTransformUtils.wrapperContextForParams(r3, org.c.a.g.c.class, "com.obric.aiagent.plugin");
        r2.f = r4;
        return r4;
    }

    static /* synthetic */ org.c.a.m.a a(b r0) {
        return r0.f40429d;
    }

    static /* synthetic */ org.c.a.g.d b(b r0) {
        return r0.c();
    }

    static /* synthetic */ org.c.a.m.a c(b r0) {
        return r0.f40430e;
    }

    static /* synthetic */ org.c.a.d.g d(b r0) {
        return r0.e();
    }

    static /* synthetic */ org.c.a.g.c e(b r0) {
        return r0.f;
    }

    static /* synthetic */ org.c.a.d.g f(b r0) {
        return r0.d();
    }

    static {
        HashMap r0 = new HashMap();
        f40426b = r0;
        r0.put("!", "!");
        r0.put("!!", "tag:yaml.org,2002:");
    }

    public b(org.c.a.h.b r2) {
        this(new org.c.a.j.d(r2));
    }

    public b(org.c.a.j.b r4) {
        this.f40427a = (org.c.a.j.b) ZeusTransformUtils.wrapperContextForParams(r4, org.c.a.j.b.class, "com.obric.aiagent.plugin");
        this.f40428c = null;
        this.g = new org.c.a.g.d(null, new HashMap(f40426b));
        this.f40429d = new org.c.a.m.a(100);
        this.f40430e = new org.c.a.m.a(10);
        this.f = new z(this, null);
    }

    public org.c.a.d.g a() {
        if (this.f40428c != null) goto L8;
        org.c.a.g.c r0 = this.f;
        if (r0 == null) goto L8;
        this.f40428c = r0.a();
    L8:
        return this.f40428c;
    }

    public org.c.a.d.g b() {
        a();
        org.c.a.d.g r0 = this.f40428c;
        this.f40428c = null;
        return r0;
    }

    private org.c.a.d.d a(org.c.a.l.g r4) {
        org.c.a.c.a r3 = r4.e();
        org.c.a.c.a r0 = r4.f();
        String r1 = r4.c();
        return new org.c.a.d.d(r4.a(), r1, r3, r0);
    }

    private org.c.a.g.d c() {
        HashMap r0 = new HashMap(this.g.b());
        Iterator<String> r1 = f40426b.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.remove((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        this.g = new org.c.a.g.d(null, r0);
    L8:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.g}) == false) goto L30;
        org.c.a.l.h r2 = (org.c.a.l.h) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.h.class, "com.obric.aiagent.plugin");
        if (r2.a().equals("YAML") == true) goto L12;
        if (r2.a().equals("TAG") == false) goto L8;
        List r5 = r2.c();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r5.get(1), String.class, "com.obric.aiagent.plugin");
        if (r0.containsKey(r6) == true) goto L29;
        r0.put(r6, r4);
        goto L8
    L29:
        throw new org.c.a.g.a(null, null, "duplicate tag handle " + r6, r2.e());
    L12:
        if (this.g.a() != null) goto L22;
        List r7 = r2.c();
        if (((Integer) ZeusTransformUtils.preCheckCast(r7.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L20;
        if (((Integer) ZeusTransformUtils.preCheckCast(r7.get(1), Integer.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L17;
        this.g = new org.c.a.g.d(org.c.a.a.e.f40329a, r0);
        goto L8
    L17:
        this.g = new org.c.a.g.d(org.c.a.a.e.f40330b, r0);
        goto L8
    L20:
        throw new org.c.a.g.a(null, null, "found incompatible YAML document (version 1.* is required)", r2.e());
    L22:
        throw new org.c.a.g.a(null, null, "found duplicate YAML directive", r2.e());
    L30:
        HashMap r3 = new HashMap();
        if (r0.isEmpty() == true) goto L33;
        r3 = new HashMap(r0);
    L33:
        Iterator<String> r8 = f40426b.keySet().iterator();
    L35:
        if (r8.hasNext() == false) goto L40;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r0.containsKey(r9) == true) goto L35;
        r0.put(r9, f40426b.get(r9));
        goto L35
    L40:
        return new org.c.a.g.d(this.g.a(), r3);
    }

    private org.c.a.d.g d() {
        return a(false, false);
    }

    private org.c.a.d.g e() {
        return a(true, true);
    }

    private org.c.a.d.g a(boolean r19, boolean r20) {
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40514a}) == false) goto L5;
        org.c.a.l.a r1 = (org.c.a.l.a) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.a.class, "com.obric.aiagent.plugin");
        org.c.a.d.a r2 = new org.c.a.d.a(r1.a(), r1.e(), r1.f());
        this.f = (org.c.a.g.c) ZeusTransformUtils.preCheckCast(this.f40429d.a(), org.c.a.g.c.class, "com.obric.aiagent.plugin");
        return r2;
    L5:
        AnonymousClass1 r4 = null;
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40515b}) == false) goto L13;
        org.c.a.l.b r3 = (org.c.a.l.b) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.b.class, "com.obric.aiagent.plugin");
        org.c.a.c.a r6 = r3.e();
        org.c.a.c.a r7 = r3.f();
        String r5 = r3.a();
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.s}) == false) goto L10;
        org.c.a.l.t r8 = (org.c.a.l.t) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.t.class, "com.obric.aiagent.plugin");
        org.c.a.c.a r9 = r8.e();
        org.c.a.c.a r10 = r8.f();
        org.c.a.l.u r11 = r8.a();
    L11:
        String r12 = r5;
    L20:
        if (r11 == null) goto L29;
        String r13 = r11.a();
        String r14 = r11.b();
        if (r13 != null) goto L24;
        String r15 = r14;
    L30:
        if (r6 != null) goto L32;
        org.c.a.c.a r16 = this.f40427a.a().e();
        org.c.a.c.a r17 = r16;
    L34:
        if (r15 != null) goto L36;
    L39:
        boolean r18 = true;
    L40:
        if (r20 == false) goto L45;
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40517d}) == false) goto L45;
        org.c.a.d.n r21 = new org.c.a.d.n(r12, r15, r18, r16, this.f40427a.a().f(), org.c.a.a.EnumC1093a.f40312b);
        this.f = new x(this, r4);
        return r21;
    L45:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.p}) == false) goto L58;
        org.c.a.l.q r22 = (org.c.a.l.q) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.q.class, "com.obric.aiagent.plugin");
        org.c.a.c.a r110 = r22.f();
        if (r22.a() == false) goto L50;
        if (r15 != null) goto L50;
    L51:
        org.c.a.d.h r23 = new org.c.a.d.h(true, false);
    L56:
        org.c.a.d.l r24 = new org.c.a.d.l(r12, r15, r23, r22.c(), r16, r110, r22.d());
        this.f = (org.c.a.g.c) ZeusTransformUtils.preCheckCast(this.f40429d.a(), org.c.a.g.c.class, "com.obric.aiagent.plugin");
        return r24;
    L50:
        if ("!".equals(r15) == true) goto L51;
        if (r15 != null) goto L55;
        r23 = new org.c.a.d.h(false, true);
        goto L56
    L55:
        r23 = new org.c.a.d.h(false, false);
        goto L56
    L58:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.n}) == false) goto L61;
        org.c.a.d.n r25 = new org.c.a.d.n(r12, r15, r18, r16, this.f40427a.a().f(), org.c.a.a.EnumC1093a.f40311a);
        this.f = new v(this, r4);
        return r25;
    L61:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.l}) == false) goto L63;
        org.c.a.d.j r26 = new org.c.a.d.j(r12, r15, r18, r16, this.f40427a.a().f(), org.c.a.a.EnumC1093a.f40311a);
        this.f = new o(this, r4);
        return r26;
    L63:
        if (r19 == true) goto L65;
    L67:
        if (r19 == true) goto L69;
    L71:
        if (r12 != null) goto L80;
        if (r15 != null) goto L80;
        org.c.a.l.v r0 = this.f40427a.a();
        StringBuilder r27 = new StringBuilder().append("while parsing a ");
        if (r19 == false) goto L77;
        String r28 = "block";
    L79:
        throw new org.c.a.g.a(r27.append(r28).append(" node").toString(), r16, "expected the node content, but found '" + r0.b() + "'", r0.e());
    L77:
        r28 = "flow";
    L80:
        org.c.a.d.l r29 = new org.c.a.d.l(r12, r15, new org.c.a.d.h(r18, false), "", r16, r17, org.c.a.a.d.f40328e);
        this.f = (org.c.a.g.c) ZeusTransformUtils.preCheckCast(this.f40429d.a(), org.c.a.g.c.class, "com.obric.aiagent.plugin");
        return r29;
    L69:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40518e}) == false) goto L71;
        org.c.a.d.j r30 = new org.c.a.d.j(r12, r15, r18, r16, this.f40427a.a().e(), org.c.a.a.EnumC1093a.f40312b);
        this.f = new a(this, r4);
        return r30;
    L65:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f}) == false) goto L67;
        org.c.a.d.n r31 = new org.c.a.d.n(r12, r15, r18, r16, this.f40427a.a().e(), org.c.a.a.EnumC1093a.f40312b);
        this.f = new i(this, r4);
        return r31;
    L36:
        if (r15.equals("!") == true) goto L39;
        r18 = false;
        goto L40
    L32:
        r16 = r6;
        r17 = r10;
        goto L34
    L24:
        if (this.g.b().containsKey(r13) == false) goto L27;
        r15 = ((String) ZeusTransformUtils.preCheckCast(this.g.b().get(r13), String.class, "com.obric.aiagent.plugin")) + r14;
        goto L30
    L27:
        throw new org.c.a.g.a("while parsing a node", r6, "found undefined tag handle " + r13, r9);
    L29:
        r15 = null;
        goto L30
    L10:
        r9 = null;
        r10 = r7;
        r11 = null;
        goto L11
    L13:
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.s}) == false) goto L19;
        org.c.a.l.t r32 = (org.c.a.l.t) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.t.class, "com.obric.aiagent.plugin");
        r6 = r32.e();
        r10 = r32.f();
        r11 = r32.a();
        if (this.f40427a.a(new org.c.a.l.v.a[]{org.c.a.l.v.a.f40515b}) == false) goto L17;
        org.c.a.l.b r33 = (org.c.a.l.b) ZeusTransformUtils.preCheckCast(this.f40427a.b(), org.c.a.l.b.class, "com.obric.aiagent.plugin");
        r10 = r33.f();
        r12 = r33.a();
    L18:
        r9 = r6;
        goto L20
    L17:
        r12 = null;
        goto L18
    L19:
        r6 = null;
        r11 = null;
        r9 = null;
        r10 = null;
        r12 = null;
        goto L20
    }

    private org.c.a.d.g a(org.c.a.c.a r9) {
        return new org.c.a.d.l(null, null, new org.c.a.d.h(true, false), "", r9, r9, org.c.a.a.d.f40328e);
    }
}
