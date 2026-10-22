package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: UntypedObjectDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class am extends ab<Object> implements com.fasterxml.jackson.databind.b.i, com.fasterxml.jackson.databind.b.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Object[] f12402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12406e;
    protected com.fasterxml.jackson.databind.k f;
    protected com.fasterxml.jackson.databind.k g;
    protected final boolean h;

    /* JADX INFO: compiled from: UntypedObjectDeserializer.java */
    @JacksonStdImpl
    public static class a extends ab<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12407a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final boolean f12408b;

        static {
            f12407a = new a();
        }

        public a() {
            this(false);
        }

        public a(boolean r2) {
            super(Object.class);
            this.f12408b = r2;
        }

        public static a a(boolean r1) {
            if (r1 == false) goto L6;
            return new a(true);
        L6:
            return f12407a;
        }

        @Override // com.fasterxml.jackson.databind.l
        public com.fasterxml.jackson.databind.k.f b() {
            return com.fasterxml.jackson.databind.k.f.f12971e;
        }

        @Override // com.fasterxml.jackson.databind.l
        public Boolean a(com.fasterxml.jackson.databind.g r1) {
            if (this.f12408b == true) goto L7;
            return null;
        L7:
            return Boolean.FALSE;
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
            return d(r2, r3, 0);
        }

        private Object d(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7, int r8) {
            switch(r6.m()) {
                case 1: goto L48;
                case 2: goto L46;
                case 3: goto L29;
                case 4: goto L5;
                case 5: goto L51;
                case 6: goto L27;
                case 7: goto L21;
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L11;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L5;
            };
        L8:
            return null;
        L51:
            if (r8 > 1000) goto L55;
            return c(r6, r7, r8);
        L55:
            throw new com.fasterxml.jackson.a.j(r6, "JSON is too deeply nested.");
        L5:
            return r7.a(Object.class, r6);
        L7:
            return r6.N();
        L11:
            return Boolean.FALSE;
        L13:
            return Boolean.TRUE;
        L15:
            if (r7.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L19;
            return r6.M();
        L19:
            return r6.C();
        L21:
            if (r7.a(z) == false) goto L25;
            return C(r6, r7);
        L25:
            return r6.C();
        L27:
            return r6.x();
        L29:
            if (r6.g() == com.fasterxml.jackson.a.n.f12155e) goto L31;
            if (r8 > 1000) goto L44;
            if (r7.a(com.fasterxml.jackson.databind.i.f12757d) == false) goto L42;
            return b(r6, r7, r8);
        L42:
            return a(r6, r7, r8);
        L44:
            throw new com.fasterxml.jackson.a.j(r6, "JSON is too deeply nested.");
        L31:
            if (r7.a(com.fasterxml.jackson.databind.i.f12757d) == false) goto L35;
            return am.f12402a;
        L35:
            return new ArrayList(2);
        L46:
            return new LinkedHashMap(2);
        L48:
            if (r6.g() != com.fasterxml.jackson.a.n.f12153c) goto L51;
            return new LinkedHashMap(2);
        }

        @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.h.e r4) {
            int r1 = r2.m();
            if (r1 == 1) goto L32;
            if (r1 == 3) goto L32;
            switch(r1) {
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L24;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L11;
                case 12: goto L10;
                default: goto L8;
            };
        L11:
            return null;
        L8:
            return r3.a(Object.class, r2);
        L10:
            return r2.N();
        L14:
            return Boolean.FALSE;
        L16:
            return Boolean.TRUE;
        L18:
            if (r3.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L22;
            return r2.M();
        L22:
            return r2.C();
        L24:
            if (r3.a(com.fasterxml.jackson.databind.i.f12755b) == false) goto L28;
            return r2.J();
        L28:
            return r2.C();
        L30:
            return r2.x();
        L32:
            return r4.d(r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.l
        public Object a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Object r7) {
            if (this.f12408b == true) goto L5;
            int r0 = r5.m();
            if (r0 == 1) goto L27;
            if (r0 != 2) goto L11;
        L25:
            return r7;
        L11:
            if (r0 == 3) goto L18;
            if (r0 == 4) goto L25;
            if (r0 != 5) goto L42;
        L30:
            if (ZeusTransformUtils.instanceOf(r7, Map.class) == false) goto L42;
            Map r1 = (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin");
            String r2 = r5.w();
        L32:
            r5.g();
            Object r3 = r1.get(r2);
            if (r3 == null) goto L35;
            Object r4 = a(r5, r6, r3);
        L36:
            if (r4 == r3) goto L38;
            r1.put(r2, r4);
        L38:
            r2 = r5.i();
            if (r2 != null) goto L32;
            return r7;
        L35:
            r4 = a(r5, r6);
        L42:
            return a(r5, r6);
        L18:
            if (r5.g() != com.fasterxml.jackson.a.n.f12155e) goto L21;
            return r7;
        L21:
            if (ZeusTransformUtils.instanceOf(r7, Collection.class) == false) goto L42;
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin");
        L23:
            r8.add(a(r5, r6));
            if (r5.g() != com.fasterxml.jackson.a.n.f12155e) goto L23;
        L27:
            if (r5.g() != com.fasterxml.jackson.a.n.f12153c) goto L30;
            return r7;
        L5:
            return a(r5, r6);
        }

        public Object a(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, int r11) {
            int r12 = r11 + 1;
            Object r1 = d(r9, r10, r12);
            int r4 = 2;
            if (r9.g() != com.fasterxml.jackson.a.n.f12155e) goto L6;
            ArrayList r8 = new ArrayList(2);
            r8.add(r1);
            return r8;
        L6:
            Object r2 = d(r9, r10, r12);
            if (r9.g() != com.fasterxml.jackson.a.n.f12155e) goto L10;
            ArrayList r13 = new ArrayList(2);
            r13.add(r1);
            r13.add(r2);
            return r13;
        L10:
            com.fasterxml.jackson.databind.l.s r3 = r10.n();
            Object[] r5 = r3.a();
            r5[0] = r1;
            r5[1] = r2;
            int r6 = 2;
        L11:
            Object r7 = d(r9, r10, r12);
            r4 = r4 + 1;
            if (r6 < r5.length) goto L14;
            r5 = r3.a(r5);
            r6 = 0;
        L14:
            int r14 = r6 + 1;
            r5[r6] = r7;
            if (r9.g() == com.fasterxml.jackson.a.n.f12155e) goto L16;
            r6 = r14;
            goto L11
        L16:
            ArrayList r15 = new ArrayList(r4);
            r3.a(r5, r14, r15);
            return r15;
        }

        public Object[] b(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, int r9) {
            int r10 = r9 + 1;
            com.fasterxml.jackson.databind.l.s r0 = r8.n();
            Object[] r1 = r0.a();
            int r3 = 0;
        L3:
            Object r4 = d(r7, r8, r10);
            if (r3 < r1.length) goto L6;
            r1 = r0.a(r1);
            r3 = 0;
        L6:
            int r5 = r3 + 1;
            r1[r3] = r4;
            if (r7.g() == com.fasterxml.jackson.a.n.f12155e) goto L9;
            r3 = r5;
            goto L3
        L9:
            return r0.b(r1, r5);
        }

        public Object c(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, int r11) {
            int r12 = r11 + 1;
            String r4 = r9.w();
            r9.g();
            Object r5 = d(r9, r10, r12);
            String r0 = r9.i();
            if (r0 != null) goto L6;
            LinkedHashMap r8 = new LinkedHashMap(2);
            r8.put(r4, r5);
            return r8;
        L6:
            r9.g();
            Object r6 = d(r9, r10, r12);
            String r7 = r9.i();
            if (r7 != null) goto L13;
            LinkedHashMap r3 = new LinkedHashMap(4);
            r3.put(r4, r5);
            if (r3.put(r0, r6) != null) goto L11;
            return r3;
        L11:
            return a(r9, r10, r3, r4, r5, r6, r7);
        L13:
            LinkedHashMap r13 = new LinkedHashMap();
            r13.put(r4, r5);
            if (r13.put(r0, r6) != null) goto L16;
            String r14 = r7;
        L18:
            r9.g();
            Object r15 = d(r9, r10, r12);
            Object r16 = r13.put(r14, r15);
            if (r16 != null) goto L21;
            r14 = r9.i();
            if (r14 != null) goto L18;
            return r13;
        L21:
            return a(r9, r10, r13, r14, r16, r15, r9.i());
        L16:
            return a(r9, r10, r13, r4, r5, r6, r7);
        }

        public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Map<String, Object> r5, String r6, Object r7, Object r8, String r9) {
            Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            boolean r0 = r4.a(com.fasterxml.jackson.a.r.f12158a);
            if (r0 == false) goto L5;
            a(r10, r6, r7, r8);
        L5:
            if (r9 == null) goto L11;
            r3.g();
            Object r11 = a(r3, r4);
            Object r12 = r10.put(r9, r11);
            if (r12 == null) goto L10;
            if (r0 == false) goto L10;
            a(r10, r9, r12, r11);
        L10:
            r9 = r3.i();
            goto L5
        L11:
            return r10;
        }

        private void a(Map<String, Object> r2, String r3, Object r4, Object r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L5;
            ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).add(r5);
            r1.put(r3, r4);
            return;
        L5:
            ArrayList r6 = new ArrayList();
            r6.add(r4);
            r6.add(r5);
            r1.put(r3, r6);
        }
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    static {
        f12402a = new Object[0];
    }

    @Deprecated
    public am() {
        this(null, null);
    }

    public am(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.k r3) {
        super(Object.class);
        this.f = r2;
        this.g = r3;
        this.h = false;
    }

    public am(am r2, boolean r3) {
        super(Object.class);
        this.f12403b = r2.f12403b;
        this.f12404c = r2.f12404c;
        this.f12405d = r2.f12405d;
        this.f12406e = r2.f12406e;
        this.f = r2.f;
        this.g = r2.g;
        this.h = r3;
    }

    @Override // com.fasterxml.jackson.databind.b.t
    public void d(com.fasterxml.jackson.databind.h r5) {
        com.fasterxml.jackson.databind.k r0 = r5.b(Object.class);
        com.fasterxml.jackson.databind.k r1 = r5.b(String.class);
        com.fasterxml.jackson.databind.k.o r2 = r5.b();
        com.fasterxml.jackson.databind.k r3 = this.f;
        if (r3 != null) goto L5;
        this.f12404c = b(a(r5, r2.a(List.class, r0)));
    L6:
        com.fasterxml.jackson.databind.k r4 = this.g;
        if (r4 != null) goto L9;
        this.f12403b = b(a(r5, r2.a(Map.class, r1, r0)));
    L10:
        this.f12405d = b(a(r5, r1));
        this.f12406e = b(a(r5, r2.a(Number.class)));
        com.fasterxml.jackson.databind.k r6 = com.fasterxml.jackson.databind.k.o.c();
        this.f12403b = r5.b(this.f12403b, null, r6);
        this.f12404c = r5.b(this.f12404c, null, r6);
        this.f12405d = r5.b(this.f12405d, null, r6);
        this.f12406e = r5.b(this.f12406e, null, r6);
        return;
    L9:
        this.f12403b = a(r5, r4);
        goto L10
    L5:
        this.f12404c = a(r5, r3);
        goto L6
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.k r2) {
        return r1.a(r2);
    }

    public com.fasterxml.jackson.databind.l<Object> b(com.fasterxml.jackson.databind.l<Object> r1) {
        if (com.fasterxml.jackson.databind.l.h.e(r1) == false) goto L6;
        return null;
    L6:
        return r1;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
        if (((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin")) == null) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (this.f12405d != null) goto L21;
        if (this.f12406e != null) goto L21;
        if (this.f12403b != null) goto L21;
        if (this.f12404c != null) goto L21;
        if (getClass() != am.class) goto L21;
        return a.a(r5);
    L21:
        if (r5 != this.h) goto L23;
        return this;
    L23:
        return new am(this, r5);
    L5:
        if (Boolean.FALSE.equals(r3.c().h(Object.class)) == false) goto L7;
        r5 = true;
        goto L9
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12971e;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        switch(r2.m()) {
            case 1: goto L50;
            case 2: goto L50;
            case 3: goto L41;
            case 4: goto L5;
            case 5: goto L50;
            case 6: goto L34;
            case 7: goto L24;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L5;
        };
    L8:
        return null;
    L14:
        com.fasterxml.jackson.databind.l<Object> r1 = this.f12406e;
        if (r1 == null) goto L19;
        return r1.a(r2, r3);
    L19:
        if (r3.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L23;
        return r2.M();
    L23:
        return r2.C();
    L24:
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12406e;
        if (r0 == null) goto L29;
        return r0.a(r2, r3);
    L29:
        if (r3.a(z) == false) goto L33;
        return C(r2, r3);
    L33:
        return r2.C();
    L34:
        com.fasterxml.jackson.databind.l<Object> r4 = this.f12405d;
        if (r4 == null) goto L39;
        return r4.a(r2, r3);
    L39:
        return r2.x();
    L50:
        com.fasterxml.jackson.databind.l<Object> r5 = this.f12403b;
        if (r5 == null) goto L55;
        return r5.a(r2, r3);
    L55:
        return d(r2, r3);
    L5:
        return r3.a(Object.class, r2);
    L7:
        return r2.N();
    L11:
        return Boolean.FALSE;
    L13:
        return Boolean.TRUE;
    L41:
        if (r3.a(com.fasterxml.jackson.databind.i.f12757d) == true) goto L43;
        com.fasterxml.jackson.databind.l<Object> r6 = this.f12404c;
        if (r6 == null) goto L49;
        return r6.a(r2, r3);
    L49:
        return b(r2, r3);
    L43:
        return f(r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.h.e r5) {
        int r0 = r3.m();
        if (r0 == 1) goto L44;
        if (r0 == 3) goto L44;
        switch(r0) {
            case 5: goto L44;
            case 6: goto L37;
            case 7: goto L27;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L14;
            case 11: goto L11;
            case 12: goto L10;
            default: goto L8;
        };
    L11:
        return null;
    L17:
        com.fasterxml.jackson.databind.l<Object> r2 = this.f12406e;
        if (r2 == null) goto L22;
        return r2.a(r3, r4);
    L22:
        if (r4.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L26;
        return r3.M();
    L26:
        return r3.C();
    L27:
        com.fasterxml.jackson.databind.l<Object> r6 = this.f12406e;
        if (r6 == null) goto L32;
        return r6.a(r3, r4);
    L32:
        if (r4.a(z) == false) goto L36;
        return C(r3, r4);
    L36:
        return r3.C();
    L37:
        com.fasterxml.jackson.databind.l<Object> r7 = this.f12405d;
        if (r7 == null) goto L42;
        return r7.a(r3, r4);
    L42:
        return r3.x();
    L8:
        return r4.a(Object.class, r3);
    L10:
        return r3.N();
    L14:
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    L44:
        return r5.d(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (this.h == false) goto L7;
        return a(r3, r4);
    L7:
        switch(r3.m()) {
            case 1: goto L58;
            case 2: goto L58;
            case 3: goto L44;
            case 4: goto L9;
            case 5: goto L58;
            case 6: goto L38;
            case 7: goto L28;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L12;
            case 12: goto L11;
            default: goto L9;
        };
    L12:
        return null;
    L18:
        com.fasterxml.jackson.databind.l<Object> r2 = this.f12406e;
        if (r2 == null) goto L23;
        return r2.a(r3, r4, r5);
    L23:
        if (r4.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L27;
        return r3.M();
    L27:
        return r3.C();
    L28:
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12406e;
        if (r0 == null) goto L33;
        return r0.a(r3, r4, r5);
    L33:
        if (r4.a(z) == false) goto L37;
        return C(r3, r4);
    L37:
        return r3.C();
    L38:
        com.fasterxml.jackson.databind.l<Object> r6 = this.f12405d;
        if (r6 == null) goto L43;
        return r6.a(r3, r4, r5);
    L43:
        return r3.x();
    L44:
        com.fasterxml.jackson.databind.l<Object> r1 = this.f12404c;
        if (r1 == null) goto L49;
        return r1.a(r3, r4, r5);
    L49:
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == false) goto L53;
        return a(r3, r4, (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
    L53:
        if (r4.a(com.fasterxml.jackson.databind.i.f12757d) == false) goto L57;
        return f(r3, r4);
    L57:
        return b(r3, r4);
    L58:
        com.fasterxml.jackson.databind.l<Object> r7 = this.f12403b;
        if (r7 == null) goto L63;
        return r7.a(r3, r4, r5);
    L63:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == false) goto L67;
        return a(r3, r4, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"));
    L67:
        return d(r3, r4);
    L9:
        return a(r3, r4);
    L11:
        return r3.N();
    L15:
        return Boolean.FALSE;
    L17:
        return Boolean.TRUE;
    }

    public Object b(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        int r2 = 2;
        if (r9.g() == com.fasterxml.jackson.a.n.f12155e) goto L5;
        Object r0 = a(r9, r10);
        if (r9.g() != com.fasterxml.jackson.a.n.f12155e) goto L10;
        ArrayList r8 = new ArrayList(2);
        r8.add(r0);
        return r8;
    L10:
        Object r1 = a(r9, r10);
        if (r9.g() != com.fasterxml.jackson.a.n.f12155e) goto L14;
        ArrayList r11 = new ArrayList(2);
        r11.add(r0);
        r11.add(r1);
        return r11;
    L14:
        com.fasterxml.jackson.databind.l.s r3 = r10.n();
        Object[] r4 = r3.a();
        r4[0] = r0;
        r4[1] = r1;
        int r5 = 2;
    L15:
        Object r6 = a(r9, r10);
        r2 = r2 + 1;
        if (r5 < r4.length) goto L18;
        r4 = r3.a(r4);
        r5 = 0;
    L18:
        int r7 = r5 + 1;
        r4[r5] = r6;
        if (r9.g() == com.fasterxml.jackson.a.n.f12155e) goto L20;
        r5 = r7;
        goto L15
    L20:
        ArrayList r12 = new ArrayList(r2);
        r3.a(r4, r7, r12);
        return r12;
    L5:
        return new ArrayList(2);
    }

    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Collection<Object> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
    L4:
        if (r3.g() == com.fasterxml.jackson.a.n.f12155e) goto L6;
        r6.add(a(r3, r4));
        goto L4
    L6:
        return r6;
    }

    public Object d(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.a.n r0 = r10.l();
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L7;
        String r1 = r10.i();
    L5:
        String r5 = r1;
        if (r5 == null) goto L17;
        r10.g();
        Object r6 = a(r10, r11);
        String r2 = r10.i();
        if (r2 != null) goto L22;
        LinkedHashMap r9 = new LinkedHashMap(2);
        r9.put(r5, r6);
        return r9;
    L22:
        r10.g();
        Object r7 = a(r10, r11);
        String r8 = r10.i();
        if (r8 != null) goto L29;
        LinkedHashMap r4 = new LinkedHashMap(4);
        r4.put(r5, r6);
        if (r4.put(r2, r7) != null) goto L27;
        return r4;
    L27:
        return a(r10, r11, r4, r5, r6, r7, r8);
    L29:
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put(r5, r6);
        if (r12.put(r2, r7) != null) goto L32;
    L33:
        r10.g();
        Object r13 = a(r10, r11);
        Object r14 = r12.put(r8, r13);
        if (r14 != null) goto L35;
        r8 = r10.i();
        if (r8 != null) goto L33;
        return r12;
    L35:
        String r15 = r8;
        return a(r10, r11, r12, r15, r14, r13, r10.i());
    L32:
        return a(r10, r11, r12, r5, r6, r7, r8);
    L17:
        return new LinkedHashMap(2);
    L7:
        if (r0 != com.fasterxml.jackson.a.n.f) goto L10;
        r1 = r10.w();
        goto L5
    L10:
        if (r0 != com.fasterxml.jackson.a.n.f12153c) goto L12;
        r1 = null;
        goto L5
    L12:
        return r11.a(a(), r10);
    }

    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Map<String, Object> r5, String r6, Object r7, Object r8, String r9) {
        Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        boolean r0 = r4.a(com.fasterxml.jackson.a.r.f12158a);
        if (r0 == false) goto L5;
        a(r10, r6, r7, r8);
    L5:
        if (r9 == null) goto L11;
        r3.g();
        Object r11 = a(r3, r4);
        Object r12 = r10.put(r9, r11);
        if (r12 == null) goto L10;
        if (r0 == false) goto L10;
        a(r10, r6, r12, r11);
    L10:
        r9 = r3.i();
        goto L5
    L11:
        return r10;
    }

    private void a(Map<String, Object> r2, String r3, Object r4, Object r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L5;
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).add(r5);
        r1.put(r3, r4);
        return;
    L5:
        ArrayList r6 = new ArrayList();
        r6.add(r4);
        r6.add(r5);
        r1.put(r3, r6);
    }

    public Object[] f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        if (r7.g() == com.fasterxml.jackson.a.n.f12155e) goto L5;
        com.fasterxml.jackson.databind.l.s r0 = r8.n();
        Object[] r1 = r0.a();
        int r3 = 0;
    L7:
        Object r4 = a(r7, r8);
        if (r3 < r1.length) goto L10;
        r1 = r0.a(r1);
        r3 = 0;
    L10:
        int r5 = r3 + 1;
        r1[r3] = r4;
        if (r7.g() == com.fasterxml.jackson.a.n.f12155e) goto L13;
        r3 = r5;
        goto L7
    L13:
        return r0.b(r1, r5);
    L5:
        return f12402a;
    }

    public Object a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Map<Object, Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.a.n r0 = r4.l();
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L6;
        r0 = r4.g();
    L6:
        if (r0 != com.fasterxml.jackson.a.n.f12153c) goto L8;
        return r7;
    L8:
        String r1 = r4.w();
    L9:
        r4.g();
        Object r2 = r7.get(r1);
        if (r2 == null) goto L12;
        Object r3 = a(r4, r5, r2);
    L13:
        if (r3 == r2) goto L15;
        r7.put(r1, r3);
    L15:
        r1 = r4.i();
        if (r1 != null) goto L9;
        return r7;
    L12:
        r3 = a(r4, r5);
        goto L13
    }
}
