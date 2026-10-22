package com.autonavi.aps.protocol.aps.impl.v57.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.autonavi.aps.protocol.aps.common.b.b {

    /* renamed from: a, reason: collision with root package name */
    public int f18796a;

    /* renamed from: b, reason: collision with root package name */
    public String f18797b;

    /* renamed from: d, reason: collision with root package name */
    public e f18799d;

    /* renamed from: e, reason: collision with root package name */
    public c f18800e;

    /* renamed from: f, reason: collision with root package name */
    public a f18801f;

    /* renamed from: g, reason: collision with root package name */
    public C0211b f18802g;

    /* renamed from: h, reason: collision with root package name */
    public List<f> f18803h;

    /* renamed from: c, reason: collision with root package name */
    public List<d> f18798c = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public byte[] f18804i = new byte[0];

    public static class a extends com.autonavi.aps.protocol.aps.common.b.b {

        /* renamed from: a, reason: collision with root package name */
        public int f18805a;

        /* renamed from: b, reason: collision with root package name */
        public int f18806b;

        /* renamed from: c, reason: collision with root package name */
        public int f18807c;

        /* renamed from: d, reason: collision with root package name */
        public int f18808d;

        /* renamed from: e, reason: collision with root package name */
        public String f18809e;

        /* renamed from: f, reason: collision with root package name */
        public int f18810f;

        /* renamed from: g, reason: collision with root package name */
        public long f18811g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f18812h;

        @Override // com.autonavi.aps.protocol.aps.common.b.b
        public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
            if (i10 == 8) {
                this.f18805a = aVar.j();
            } else if (i10 == 16) {
                this.f18806b = aVar.j();
            } else if (i10 == 24) {
                this.f18807c = aVar.j();
            } else if (i10 == 32) {
                this.f18808d = aVar.j();
            } else if (i10 == 42) {
                this.f18809e = aVar.h();
            } else if (i10 == 48) {
                this.f18810f = aVar.l();
            } else if (i10 == 56) {
                this.f18811g = aVar.k();
            } else {
                if (i10 != 98) {
                    aVar.g(i10);
                    return true;
                }
                this.f18812h = aVar.g();
            }
            return true;
        }
    }

    /* renamed from: com.autonavi.aps.protocol.aps.impl.v57.a.b$b, reason: collision with other inner class name */
    public static class C0211b extends com.autonavi.aps.protocol.aps.common.b.b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18813a;

        /* renamed from: b, reason: collision with root package name */
        public String f18814b;

        @Override // com.autonavi.aps.protocol.aps.common.b.b
        public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
            if (i10 == 8) {
                this.f18813a = aVar.i();
            } else {
                if (i10 != 18) {
                    aVar.g(i10);
                    return true;
                }
                this.f18814b = aVar.h();
            }
            return true;
        }
    }

    public static class c extends com.autonavi.aps.protocol.aps.common.b.b {

        /* renamed from: a, reason: collision with root package name */
        public String f18815a;

        /* renamed from: b, reason: collision with root package name */
        public String f18816b;

        @Override // com.autonavi.aps.protocol.aps.common.b.b
        public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
            if (i10 == 10) {
                this.f18815a = aVar.h();
            } else {
                if (i10 != 18) {
                    aVar.g(i10);
                    return true;
                }
                this.f18816b = aVar.h();
            }
            return true;
        }
    }

    public static class d extends com.autonavi.aps.protocol.aps.common.b.b {

        /* renamed from: a, reason: collision with root package name */
        public long f18817a = 1;

        /* renamed from: b, reason: collision with root package name */
        public long f18818b = 2;

        /* renamed from: c, reason: collision with root package name */
        public int f18819c = 3;

        @Override // com.autonavi.aps.protocol.aps.common.b.b
        public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
            if (i10 == 8) {
                this.f18817a = aVar.j();
            } else if (i10 == 16) {
                this.f18818b = aVar.j();
            } else {
                if (i10 != 24) {
                    aVar.g(i10);
                    return true;
                }
                this.f18819c = aVar.j();
            }
            return true;
        }
    }

    public static class e extends com.autonavi.aps.protocol.aps.common.b.b {

        /* renamed from: a, reason: collision with root package name */
        public String f18820a;

        /* renamed from: b, reason: collision with root package name */
        public String f18821b;

        /* renamed from: c, reason: collision with root package name */
        public String f18822c;

        /* renamed from: d, reason: collision with root package name */
        public String f18823d;

        /* renamed from: e, reason: collision with root package name */
        public String f18824e;

        /* renamed from: f, reason: collision with root package name */
        public String f18825f;

        /* renamed from: g, reason: collision with root package name */
        public String f18826g;

        /* renamed from: h, reason: collision with root package name */
        public String f18827h;

        /* renamed from: i, reason: collision with root package name */
        public String f18828i;

        /* renamed from: j, reason: collision with root package name */
        public List<a> f18829j = new ArrayList();

        /* renamed from: k, reason: collision with root package name */
        public String f18830k;

        /* renamed from: l, reason: collision with root package name */
        public String f18831l;

        /* renamed from: m, reason: collision with root package name */
        public String f18832m;

        /* renamed from: n, reason: collision with root package name */
        public String f18833n;

        public static class a extends com.autonavi.aps.protocol.aps.common.b.b {

            /* renamed from: a, reason: collision with root package name */
            public String f18834a;

            /* renamed from: b, reason: collision with root package name */
            public String f18835b;

            /* renamed from: c, reason: collision with root package name */
            public String f18836c;

            /* renamed from: d, reason: collision with root package name */
            public int f18837d;

            /* renamed from: e, reason: collision with root package name */
            public int f18838e;

            /* renamed from: f, reason: collision with root package name */
            public int f18839f;

            /* renamed from: g, reason: collision with root package name */
            public String f18840g;

            /* renamed from: h, reason: collision with root package name */
            public String f18841h;

            /* renamed from: i, reason: collision with root package name */
            public String f18842i;

            /* renamed from: j, reason: collision with root package name */
            public String f18843j;

            /* renamed from: k, reason: collision with root package name */
            public byte[] f18844k;

            @Override // com.autonavi.aps.protocol.aps.common.b.b
            public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
                switch (i10) {
                    case 10:
                        this.f18834a = aVar.h();
                        return true;
                    case 18:
                        this.f18835b = aVar.h();
                        return true;
                    case 26:
                        this.f18836c = aVar.h();
                        return true;
                    case 32:
                        this.f18837d = aVar.j();
                        return true;
                    case 40:
                        this.f18838e = aVar.j();
                        return true;
                    case 48:
                        this.f18839f = aVar.j();
                        return true;
                    case 58:
                        this.f18840g = aVar.h();
                        return true;
                    case 66:
                        this.f18841h = aVar.h();
                        return true;
                    case 74:
                        this.f18842i = aVar.h();
                        return true;
                    case 82:
                        this.f18843j = aVar.h();
                        return true;
                    case 122:
                        this.f18844k = aVar.g();
                        return true;
                    default:
                        return false;
                }
            }
        }

        @Override // com.autonavi.aps.protocol.aps.common.b.b
        public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) throws IOException {
            switch (i10) {
                case 10:
                    this.f18820a = aVar.h();
                    return true;
                case 18:
                    this.f18821b = aVar.h();
                    return true;
                case 26:
                    this.f18822c = aVar.h();
                    return true;
                case 34:
                    this.f18823d = aVar.h();
                    return true;
                case 42:
                    this.f18824e = aVar.h();
                    return true;
                case 50:
                    this.f18825f = aVar.h();
                    return true;
                case 58:
                    this.f18826g = aVar.h();
                    return true;
                case 66:
                    this.f18827h = aVar.h();
                    return true;
                case 74:
                    this.f18828i = aVar.h();
                    return true;
                case 82:
                    if (this.f18829j == null) {
                        this.f18829j = new ArrayList();
                    }
                    int iB = b(aVar);
                    this.f18829j.add((a) new a().a(aVar));
                    a(aVar, iB);
                    return true;
                case 90:
                    this.f18830k = aVar.h();
                    return true;
                case 98:
                    this.f18831l = aVar.h();
                    return true;
                case 106:
                    this.f18832m = aVar.h();
                    return true;
                case 114:
                    this.f18833n = aVar.h();
                    return true;
                default:
                    aVar.g(i10);
                    return true;
            }
        }
    }

    public static class f extends com.autonavi.aps.protocol.aps.common.b.b {

        /* renamed from: a, reason: collision with root package name */
        public double f18845a;

        /* renamed from: b, reason: collision with root package name */
        public double f18846b;

        /* renamed from: c, reason: collision with root package name */
        public double f18847c;

        /* renamed from: d, reason: collision with root package name */
        public String f18848d;

        /* renamed from: e, reason: collision with root package name */
        public C0212b f18849e;

        /* renamed from: f, reason: collision with root package name */
        public C0212b f18850f;

        /* renamed from: g, reason: collision with root package name */
        public a f18851g;

        /* renamed from: h, reason: collision with root package name */
        public a f18852h;

        /* renamed from: i, reason: collision with root package name */
        public int f18853i;

        public static class a extends com.autonavi.aps.protocol.aps.common.b.b {

            /* renamed from: a, reason: collision with root package name */
            public String f18854a;

            /* renamed from: b, reason: collision with root package name */
            public String f18855b;

            /* renamed from: c, reason: collision with root package name */
            public double f18856c;

            /* renamed from: d, reason: collision with root package name */
            public double f18857d;

            /* renamed from: e, reason: collision with root package name */
            public String f18858e;

            /* renamed from: f, reason: collision with root package name */
            public int f18859f;

            @Override // com.autonavi.aps.protocol.aps.common.b.b
            public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
                if (i10 == 10) {
                    this.f18854a = aVar.h();
                    return true;
                }
                if (i10 == 18) {
                    this.f18855b = aVar.h();
                    return true;
                }
                if (i10 == 24) {
                    this.f18856c = aVar.n();
                    return true;
                }
                if (i10 == 32) {
                    this.f18857d = aVar.n();
                    return true;
                }
                if (i10 == 42) {
                    this.f18858e = aVar.h();
                    return true;
                }
                if (i10 != 48) {
                    return false;
                }
                this.f18859f = aVar.j();
                return true;
            }
        }

        /* renamed from: com.autonavi.aps.protocol.aps.impl.v57.a.b$f$b, reason: collision with other inner class name */
        public static class C0212b extends a {

            /* renamed from: g, reason: collision with root package name */
            public int f18860g;

            @Override // com.autonavi.aps.protocol.aps.impl.v57.a.b.f.a, com.autonavi.aps.protocol.aps.common.b.b
            public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) {
                if (i10 == 10) {
                    this.f18854a = aVar.h();
                    return true;
                }
                if (i10 == 18) {
                    this.f18855b = aVar.h();
                    return true;
                }
                if (i10 == 24) {
                    this.f18856c = aVar.n();
                    return true;
                }
                if (i10 == 32) {
                    this.f18857d = aVar.n();
                    return true;
                }
                if (i10 == 42) {
                    this.f18858e = aVar.h();
                    return true;
                }
                if (i10 == 48) {
                    this.f18859f = aVar.j();
                    return true;
                }
                if (i10 != 56) {
                    return false;
                }
                this.f18860g = aVar.j();
                return true;
            }
        }

        @Override // com.autonavi.aps.protocol.aps.common.b.b
        public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) throws IOException {
            if (i10 == 8) {
                this.f18845a = aVar.n();
                return true;
            }
            if (i10 == 16) {
                this.f18846b = aVar.n();
                return true;
            }
            if (i10 == 24) {
                this.f18847c = aVar.n();
                return true;
            }
            if (i10 == 34) {
                this.f18848d = aVar.h();
                return true;
            }
            if (i10 == 42) {
                int iB = b(aVar);
                this.f18849e = (C0212b) new C0212b().a(aVar);
                a(aVar, iB);
                return true;
            }
            if (i10 == 50) {
                int iB2 = b(aVar);
                this.f18850f = (C0212b) new C0212b().a(aVar);
                a(aVar, iB2);
                return true;
            }
            if (i10 == 58) {
                int iB3 = b(aVar);
                this.f18851g = (a) new a().a(aVar);
                a(aVar, iB3);
                return true;
            }
            if (i10 != 66) {
                if (i10 != 72) {
                    return false;
                }
                this.f18853i = aVar.j();
                return true;
            }
            int iB4 = b(aVar);
            this.f18852h = (a) new a().a(aVar);
            a(aVar, iB4);
            return true;
        }
    }

    @Override // com.autonavi.aps.protocol.aps.common.b.b
    public boolean a(int i10, com.autonavi.aps.protocol.aps.common.b.a aVar) throws IOException {
        if (i10 == 8) {
            this.f18796a = aVar.j();
        } else if (i10 == 18) {
            this.f18797b = aVar.h();
        } else if (i10 == 26) {
            if (this.f18798c == null) {
                this.f18798c = new ArrayList();
            }
            int iB = b(aVar);
            this.f18798c.add((d) new d().a(aVar));
            a(aVar, iB);
        } else if (i10 == 34) {
            int iB2 = b(aVar);
            this.f18799d = (e) new e().a(aVar);
            a(aVar, iB2);
        } else if (i10 == 42) {
            int iB3 = b(aVar);
            this.f18800e = (c) new c().a(aVar);
            a(aVar, iB3);
        } else if (i10 == 50) {
            int iB4 = b(aVar);
            this.f18801f = (a) new a().a(aVar);
            a(aVar, iB4);
        } else if (i10 == 58) {
            int iB5 = b(aVar);
            this.f18802g = (C0211b) new C0211b().a(aVar);
            a(aVar, iB5);
        } else if (i10 == 66) {
            if (this.f18803h == null) {
                this.f18803h = new ArrayList();
            }
            int iB6 = b(aVar);
            this.f18803h.add((f) new f().a(aVar));
            a(aVar, iB6);
        } else {
            if (i10 != 122) {
                aVar.g(i10);
                return true;
            }
            this.f18804i = aVar.g();
        }
        return true;
    }
}
