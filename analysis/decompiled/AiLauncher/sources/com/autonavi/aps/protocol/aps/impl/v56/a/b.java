package com.autonavi.aps.protocol.aps.impl.v56.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

    /* renamed from: a, reason: collision with root package name */
    public int f18620a;

    /* renamed from: b, reason: collision with root package name */
    public String f18621b;

    /* renamed from: d, reason: collision with root package name */
    public e f18623d;

    /* renamed from: e, reason: collision with root package name */
    public c f18624e;

    /* renamed from: f, reason: collision with root package name */
    public a f18625f;

    /* renamed from: g, reason: collision with root package name */
    public C0207b f18626g;

    /* renamed from: h, reason: collision with root package name */
    public List<f> f18627h;

    /* renamed from: c, reason: collision with root package name */
    public List<d> f18622c = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public byte[] f18628i = new byte[0];

    public static class a extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

        /* renamed from: a, reason: collision with root package name */
        public int f18629a;

        /* renamed from: b, reason: collision with root package name */
        public int f18630b;

        /* renamed from: c, reason: collision with root package name */
        public int f18631c;

        /* renamed from: d, reason: collision with root package name */
        public int f18632d;

        /* renamed from: e, reason: collision with root package name */
        public String f18633e;

        /* renamed from: f, reason: collision with root package name */
        public int f18634f;

        /* renamed from: g, reason: collision with root package name */
        public long f18635g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f18636h;

        @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
        public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
            if (i10 == 8) {
                this.f18629a = cVar.j();
            } else if (i10 == 16) {
                this.f18630b = cVar.j();
            } else if (i10 == 24) {
                this.f18631c = cVar.j();
            } else if (i10 == 32) {
                this.f18632d = cVar.j();
            } else if (i10 == 42) {
                this.f18633e = cVar.h();
            } else if (i10 == 48) {
                this.f18634f = cVar.l();
            } else if (i10 == 56) {
                this.f18635g = cVar.k();
            } else {
                if (i10 != 98) {
                    cVar.g(i10);
                    return true;
                }
                this.f18636h = cVar.g();
            }
            return true;
        }
    }

    /* renamed from: com.autonavi.aps.protocol.aps.impl.v56.a.b$b, reason: collision with other inner class name */
    public static class C0207b extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18637a;

        /* renamed from: b, reason: collision with root package name */
        public String f18638b;

        @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
        public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
            if (i10 == 8) {
                this.f18637a = cVar.i();
            } else {
                if (i10 != 18) {
                    cVar.g(i10);
                    return true;
                }
                this.f18638b = cVar.h();
            }
            return true;
        }
    }

    public static class c extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

        /* renamed from: a, reason: collision with root package name */
        public String f18639a;

        /* renamed from: b, reason: collision with root package name */
        public String f18640b;

        @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
        public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
            if (i10 == 10) {
                this.f18639a = cVar.h();
            } else {
                if (i10 != 18) {
                    cVar.g(i10);
                    return true;
                }
                this.f18640b = cVar.h();
            }
            return true;
        }
    }

    public static class d extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

        /* renamed from: a, reason: collision with root package name */
        public long f18641a = 1;

        /* renamed from: b, reason: collision with root package name */
        public long f18642b = 2;

        /* renamed from: c, reason: collision with root package name */
        public int f18643c = 3;

        @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
        public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
            if (i10 == 8) {
                this.f18641a = cVar.j();
            } else if (i10 == 16) {
                this.f18642b = cVar.j();
            } else {
                if (i10 != 24) {
                    cVar.g(i10);
                    return true;
                }
                this.f18643c = cVar.j();
            }
            return true;
        }
    }

    public static class e extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

        /* renamed from: a, reason: collision with root package name */
        public String f18644a;

        /* renamed from: b, reason: collision with root package name */
        public String f18645b;

        /* renamed from: c, reason: collision with root package name */
        public String f18646c;

        /* renamed from: d, reason: collision with root package name */
        public String f18647d;

        /* renamed from: e, reason: collision with root package name */
        public String f18648e;

        /* renamed from: f, reason: collision with root package name */
        public String f18649f;

        /* renamed from: g, reason: collision with root package name */
        public String f18650g;

        /* renamed from: h, reason: collision with root package name */
        public String f18651h;

        /* renamed from: i, reason: collision with root package name */
        public String f18652i;

        /* renamed from: j, reason: collision with root package name */
        public List<a> f18653j = new ArrayList();

        /* renamed from: k, reason: collision with root package name */
        public String f18654k;

        /* renamed from: l, reason: collision with root package name */
        public String f18655l;

        /* renamed from: m, reason: collision with root package name */
        public String f18656m;

        /* renamed from: n, reason: collision with root package name */
        public String f18657n;

        public static class a extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

            /* renamed from: a, reason: collision with root package name */
            public String f18658a;

            /* renamed from: b, reason: collision with root package name */
            public String f18659b;

            /* renamed from: c, reason: collision with root package name */
            public String f18660c;

            /* renamed from: d, reason: collision with root package name */
            public int f18661d;

            /* renamed from: e, reason: collision with root package name */
            public int f18662e;

            /* renamed from: f, reason: collision with root package name */
            public int f18663f;

            /* renamed from: g, reason: collision with root package name */
            public String f18664g;

            /* renamed from: h, reason: collision with root package name */
            public String f18665h;

            /* renamed from: i, reason: collision with root package name */
            public String f18666i;

            /* renamed from: j, reason: collision with root package name */
            public String f18667j;

            /* renamed from: k, reason: collision with root package name */
            public byte[] f18668k;

            @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
            public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
                switch (i10) {
                    case 10:
                        this.f18658a = cVar.h();
                        return true;
                    case 18:
                        this.f18659b = cVar.h();
                        return true;
                    case 26:
                        this.f18660c = cVar.h();
                        return true;
                    case 32:
                        this.f18661d = cVar.j();
                        return true;
                    case 40:
                        this.f18662e = cVar.j();
                        return true;
                    case 48:
                        this.f18663f = cVar.j();
                        return true;
                    case 58:
                        this.f18664g = cVar.h();
                        return true;
                    case 66:
                        this.f18665h = cVar.h();
                        return true;
                    case 74:
                        this.f18666i = cVar.h();
                        return true;
                    case 82:
                        this.f18667j = cVar.h();
                        return true;
                    case 122:
                        this.f18668k = cVar.g();
                        return true;
                    default:
                        return false;
                }
            }
        }

        @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
        public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) throws IOException {
            switch (i10) {
                case 10:
                    this.f18644a = cVar.h();
                    return true;
                case 18:
                    this.f18645b = cVar.h();
                    return true;
                case 26:
                    this.f18646c = cVar.h();
                    return true;
                case 34:
                    this.f18647d = cVar.h();
                    return true;
                case 42:
                    this.f18648e = cVar.h();
                    return true;
                case 50:
                    this.f18649f = cVar.h();
                    return true;
                case 58:
                    this.f18650g = cVar.h();
                    return true;
                case 66:
                    this.f18651h = cVar.h();
                    return true;
                case 74:
                    this.f18652i = cVar.h();
                    return true;
                case 82:
                    if (this.f18653j == null) {
                        this.f18653j = new ArrayList();
                    }
                    int iB = b(cVar);
                    this.f18653j.add((a) new a().a(cVar));
                    a(cVar, iB);
                    return true;
                case 90:
                    this.f18654k = cVar.h();
                    return true;
                case 98:
                    this.f18655l = cVar.h();
                    return true;
                case 106:
                    this.f18656m = cVar.h();
                    return true;
                case 114:
                    this.f18657n = cVar.h();
                    return true;
                default:
                    cVar.g(i10);
                    return true;
            }
        }
    }

    public static class f extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

        /* renamed from: a, reason: collision with root package name */
        public double f18669a;

        /* renamed from: b, reason: collision with root package name */
        public double f18670b;

        /* renamed from: c, reason: collision with root package name */
        public double f18671c;

        /* renamed from: d, reason: collision with root package name */
        public String f18672d;

        /* renamed from: e, reason: collision with root package name */
        public e f18673e;

        /* renamed from: f, reason: collision with root package name */
        public d f18674f;

        /* renamed from: g, reason: collision with root package name */
        public c f18675g;

        /* renamed from: h, reason: collision with root package name */
        public a f18676h;

        /* renamed from: i, reason: collision with root package name */
        public int f18677i;

        public static class a extends C0208b {
        }

        /* renamed from: com.autonavi.aps.protocol.aps.impl.v56.a.b$f$b, reason: collision with other inner class name */
        public static class C0208b extends com.autonavi.aps.protocol.aps.impl.v56.a.d {

            /* renamed from: a, reason: collision with root package name */
            public String f18678a;

            /* renamed from: b, reason: collision with root package name */
            public String f18679b;

            /* renamed from: c, reason: collision with root package name */
            public double f18680c;

            /* renamed from: d, reason: collision with root package name */
            public double f18681d;

            /* renamed from: e, reason: collision with root package name */
            public String f18682e;

            /* renamed from: f, reason: collision with root package name */
            public int f18683f;

            @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
            public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
                if (i10 == 10) {
                    this.f18678a = cVar.h();
                    return true;
                }
                if (i10 == 18) {
                    this.f18679b = cVar.h();
                    return true;
                }
                if (i10 == 24) {
                    this.f18680c = cVar.n();
                    return true;
                }
                if (i10 == 32) {
                    this.f18681d = cVar.n();
                    return true;
                }
                if (i10 == 42) {
                    this.f18682e = cVar.h();
                    return true;
                }
                if (i10 != 48) {
                    return false;
                }
                this.f18683f = cVar.j();
                return true;
            }
        }

        public static class c extends C0208b {
        }

        public static class d extends C0208b {
        }

        public static class e extends C0208b {

            /* renamed from: g, reason: collision with root package name */
            public int f18684g;

            @Override // com.autonavi.aps.protocol.aps.impl.v56.a.b.f.C0208b, com.autonavi.aps.protocol.aps.impl.v56.a.d
            public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) {
                if (i10 == 10) {
                    this.f18678a = cVar.h();
                    return true;
                }
                if (i10 == 18) {
                    this.f18679b = cVar.h();
                    return true;
                }
                if (i10 == 24) {
                    this.f18680c = cVar.n();
                    return true;
                }
                if (i10 == 32) {
                    this.f18681d = cVar.n();
                    return true;
                }
                if (i10 == 42) {
                    this.f18682e = cVar.h();
                    return true;
                }
                if (i10 == 48) {
                    this.f18683f = cVar.j();
                    return true;
                }
                if (i10 != 56) {
                    return false;
                }
                this.f18684g = cVar.j();
                return true;
            }
        }

        @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
        public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) throws IOException {
            if (i10 == 8) {
                this.f18669a = cVar.n();
                return true;
            }
            if (i10 == 16) {
                this.f18670b = cVar.n();
                return true;
            }
            if (i10 == 24) {
                this.f18671c = cVar.n();
                return true;
            }
            if (i10 == 34) {
                this.f18672d = cVar.h();
                return true;
            }
            if (i10 == 42) {
                int iB = b(cVar);
                this.f18673e = (e) new e().a(cVar);
                a(cVar, iB);
                return true;
            }
            if (i10 == 50) {
                int iB2 = b(cVar);
                this.f18674f = (d) new d().a(cVar);
                a(cVar, iB2);
                return true;
            }
            if (i10 == 58) {
                int iB3 = b(cVar);
                this.f18675g = (c) new c().a(cVar);
                a(cVar, iB3);
                return true;
            }
            if (i10 != 66) {
                if (i10 != 72) {
                    return false;
                }
                this.f18677i = cVar.j();
                return true;
            }
            int iB4 = b(cVar);
            this.f18676h = (a) new a().a(cVar);
            a(cVar, iB4);
            return true;
        }
    }

    @Override // com.autonavi.aps.protocol.aps.impl.v56.a.d
    public boolean a(int i10, com.autonavi.aps.protocol.aps.impl.v56.a.c cVar) throws IOException {
        if (i10 == 8) {
            this.f18620a = cVar.j();
        } else if (i10 == 18) {
            this.f18621b = cVar.h();
        } else if (i10 == 26) {
            if (this.f18622c == null) {
                this.f18622c = new ArrayList();
            }
            int iB = b(cVar);
            this.f18622c.add((d) new d().a(cVar));
            a(cVar, iB);
        } else if (i10 == 34) {
            int iB2 = b(cVar);
            this.f18623d = (e) new e().a(cVar);
            a(cVar, iB2);
        } else if (i10 == 42) {
            int iB3 = b(cVar);
            this.f18624e = (c) new c().a(cVar);
            a(cVar, iB3);
        } else if (i10 == 50) {
            int iB4 = b(cVar);
            this.f18625f = (a) new a().a(cVar);
            a(cVar, iB4);
        } else if (i10 == 58) {
            int iB5 = b(cVar);
            this.f18626g = (C0207b) new C0207b().a(cVar);
            a(cVar, iB5);
        } else if (i10 == 66) {
            if (this.f18627h == null) {
                this.f18627h = new ArrayList();
            }
            int iB6 = b(cVar);
            this.f18627h.add((f) new f().a(cVar));
            a(cVar, iB6);
        } else {
            if (i10 != 122) {
                cVar.g(i10);
                return true;
            }
            this.f18628i = cVar.g();
        }
        return true;
    }
}
