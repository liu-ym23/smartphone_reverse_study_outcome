package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$Type extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Type> {

    /* renamed from: t, reason: collision with root package name */
    public static final ProtoBuf$Type f5067t;
    public static final B8.a u = new B8.a(13);
    public final AbstractC0244e b;
    public int c;
    public List d;
    public boolean e;
    public int f;
    public ProtoBuf$Type g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f5068j;
    public int k;
    public int l;
    public ProtoBuf$Type m;
    public int n;
    public ProtoBuf$Type o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f5069q;

    /* renamed from: r, reason: collision with root package name */
    public byte f5070r;

    /* renamed from: s, reason: collision with root package name */
    public int f5071s;

    static {
        ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type();
        f5067t = protoBuf$Type;
        protoBuf$Type.n();
    }

    public ProtoBuf$Type(m mVar) {
        super(mVar);
        this.f5070r = (byte) -1;
        this.f5071s = -1;
        this.b = mVar.f774a;
    }

    public static m o(ProtoBuf$Type protoBuf$Type) {
        m mVarF = m.f();
        mVarF.h(protoBuf$Type);
        return mVarF;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f5071s;
        if (i != -1) {
            return i;
        }
        int iF = (this.c & 4096) == 4096 ? A0.d.f(1, this.f5069q) : 0;
        for (int i6 = 0; i6 < this.d.size(); i6++) {
            iF += A0.d.h(2, (AbstractC0241b) this.d.get(i6));
        }
        if ((this.c & 1) == 1) {
            iF += A0.d.l(3) + 1;
        }
        if ((this.c & 2) == 2) {
            iF += A0.d.f(4, this.f);
        }
        if ((this.c & 4) == 4) {
            iF += A0.d.h(5, this.g);
        }
        if ((this.c & 16) == 16) {
            iF += A0.d.f(6, this.i);
        }
        if ((this.c & 32) == 32) {
            iF += A0.d.f(7, this.f5068j);
        }
        if ((this.c & 8) == 8) {
            iF += A0.d.f(8, this.h);
        }
        if ((this.c & 64) == 64) {
            iF += A0.d.f(9, this.k);
        }
        if ((this.c & 256) == 256) {
            iF += A0.d.h(10, this.m);
        }
        if ((this.c & 512) == 512) {
            iF += A0.d.f(11, this.n);
        }
        if ((this.c & 128) == 128) {
            iF += A0.d.f(12, this.l);
        }
        if ((this.c & 1024) == 1024) {
            iF += A0.d.h(13, this.o);
        }
        if ((this.c & 2048) == 2048) {
            iF += A0.d.f(14, this.p);
        }
        int size = this.b.size() + h() + iF;
        this.f5071s = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return m.f();
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 4096) == 4096) {
            dVar.q(1, this.f5069q);
        }
        for (int i = 0; i < this.d.size(); i++) {
            dVar.s(2, (AbstractC0241b) this.d.get(i));
        }
        if ((this.c & 1) == 1) {
            boolean z10 = this.e;
            dVar.B(3, 0);
            dVar.u(z10 ? 1 : 0);
        }
        if ((this.c & 2) == 2) {
            dVar.q(4, this.f);
        }
        if ((this.c & 4) == 4) {
            dVar.s(5, this.g);
        }
        if ((this.c & 16) == 16) {
            dVar.q(6, this.i);
        }
        if ((this.c & 32) == 32) {
            dVar.q(7, this.f5068j);
        }
        if ((this.c & 8) == 8) {
            dVar.q(8, this.h);
        }
        if ((this.c & 64) == 64) {
            dVar.q(9, this.k);
        }
        if ((this.c & 256) == 256) {
            dVar.s(10, this.m);
        }
        if ((this.c & 512) == 512) {
            dVar.q(11, this.n);
        }
        if ((this.c & 128) == 128) {
            dVar.q(12, this.l);
        }
        if ((this.c & 1024) == 1024) {
            dVar.s(13, this.o);
        }
        if ((this.c & 2048) == 2048) {
            dVar.q(14, this.p);
        }
        bVar.a(200, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return f5067t;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.f5070r;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((Argument) this.d.get(i)).isInitialized()) {
                this.f5070r = (byte) 0;
                return false;
            }
        }
        if ((this.c & 4) == 4 && !this.g.isInitialized()) {
            this.f5070r = (byte) 0;
            return false;
        }
        if ((this.c & 256) == 256 && !this.m.isInitialized()) {
            this.f5070r = (byte) 0;
            return false;
        }
        if ((this.c & 1024) == 1024 && !this.o.isInitialized()) {
            this.f5070r = (byte) 0;
            return false;
        }
        if (g()) {
            this.f5070r = (byte) 1;
            return true;
        }
        this.f5070r = (byte) 0;
        return false;
    }

    public final void n() {
        this.d = Collections.EMPTY_LIST;
        this.e = false;
        this.f = 0;
        ProtoBuf$Type protoBuf$Type = f5067t;
        this.g = protoBuf$Type;
        this.h = 0;
        this.i = 0;
        this.f5068j = 0;
        this.k = 0;
        this.l = 0;
        this.m = protoBuf$Type;
        this.n = 0;
        this.o = protoBuf$Type;
        this.p = 0;
        this.f5069q = 0;
    }

    @Override // H8.AbstractC0241b
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final m c() {
        return o(this);
    }

    public static final class Argument extends GeneratedMessageLite {
        public static final Argument h;
        public static final k i = new k();

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC0244e f5072a;
        public int b;
        public Projection c;
        public ProtoBuf$Type d;
        public int e;
        public byte f;
        public int g;

        public enum Projection implements H8.m {
            IN(0),
            OUT(1),
            INV(2),
            STAR(3);


            /* renamed from: a, reason: collision with root package name */
            public final int f5073a;

            Projection(int i) {
                this.f5073a = i;
            }

            @Override // H8.m
            public final int getNumber() {
                return this.f5073a;
            }
        }

        static {
            Argument argument = new Argument();
            h = argument;
            argument.c = Projection.INV;
            argument.d = ProtoBuf$Type.f5067t;
            argument.e = 0;
        }

        public Argument(l lVar) {
            this.f = (byte) -1;
            this.g = -1;
            this.f5072a = lVar.f774a;
        }

        @Override // H8.AbstractC0241b
        public final int a() {
            int i6 = this.g;
            if (i6 != -1) {
                return i6;
            }
            int iE = (this.b & 1) == 1 ? A0.d.e(1, this.c.f5073a) : 0;
            if ((this.b & 2) == 2) {
                iE += A0.d.h(2, this.d);
            }
            if ((this.b & 4) == 4) {
                iE += A0.d.f(3, this.e);
            }
            int size = this.f5072a.size() + iE;
            this.g = size;
            return size;
        }

        @Override // H8.AbstractC0241b
        public final H8.j b() {
            return l.e();
        }

        @Override // H8.AbstractC0241b
        public final H8.j c() {
            l lVarE = l.e();
            lVarE.f(this);
            return lVarE;
        }

        @Override // H8.AbstractC0241b
        public final void d(A0.d dVar) throws IOException {
            a();
            if ((this.b & 1) == 1) {
                dVar.p(1, this.c.f5073a);
            }
            if ((this.b & 2) == 2) {
                dVar.s(2, this.d);
            }
            if ((this.b & 4) == 4) {
                dVar.q(3, this.e);
            }
            dVar.v(this.f5072a);
        }

        @Override // H8.s
        public final boolean isInitialized() {
            byte b = this.f;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            if ((this.b & 2) != 2 || this.d.isInitialized()) {
                this.f = (byte) 1;
                return true;
            }
            this.f = (byte) 0;
            return false;
        }

        public Argument() {
            this.f = (byte) -1;
            this.g = -1;
            this.f5072a = AbstractC0244e.f769a;
        }

        public Argument(C0245f c0245f, H8.h hVar) {
            this.f = (byte) -1;
            this.g = -1;
            Projection projection = Projection.INV;
            this.c = projection;
            this.d = ProtoBuf$Type.f5067t;
            boolean z10 = false;
            this.e = 0;
            C0243d c0243d = new C0243d();
            A0.d dVarN = A0.d.n(c0243d, 1);
            while (!z10) {
                try {
                    try {
                        int iN = c0245f.n();
                        if (iN != 0) {
                            m mVarO = null;
                            Projection projection2 = null;
                            if (iN == 8) {
                                int iK = c0245f.k();
                                if (iK == 0) {
                                    projection2 = Projection.IN;
                                } else if (iK == 1) {
                                    projection2 = Projection.OUT;
                                } else if (iK == 2) {
                                    projection2 = projection;
                                } else if (iK == 3) {
                                    projection2 = Projection.STAR;
                                }
                                if (projection2 == null) {
                                    dVarN.z(iN);
                                    dVarN.z(iK);
                                } else {
                                    this.b |= 1;
                                    this.c = projection2;
                                }
                            } else if (iN == 18) {
                                if ((this.b & 2) == 2) {
                                    ProtoBuf$Type protoBuf$Type = this.d;
                                    protoBuf$Type.getClass();
                                    mVarO = ProtoBuf$Type.o(protoBuf$Type);
                                }
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                this.d = protoBuf$Type2;
                                if (mVarO != null) {
                                    mVarO.h(protoBuf$Type2);
                                    this.d = mVarO.e();
                                }
                                this.b |= 2;
                            } else if (iN != 24) {
                                if (!c0245f.q(iN, dVarN)) {
                                }
                            } else {
                                this.b |= 4;
                                this.e = c0245f.k();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            dVarN.m();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f5072a = c0243d.f();
                            throw th2;
                        }
                        this.f5072a = c0243d.f();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.f5100a = this;
                    throw e;
                } catch (IOException e6) {
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                    invalidProtocolBufferException.f5100a = this;
                    throw invalidProtocolBufferException;
                }
            }
            try {
                dVarN.m();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f5072a = c0243d.f();
                throw th3;
            }
            this.f5072a = c0243d.f();
        }
    }

    public ProtoBuf$Type() {
        this.f5070r = (byte) -1;
        this.f5071s = -1;
        this.b = AbstractC0244e.f769a;
    }

    public ProtoBuf$Type(C0245f c0245f, H8.h hVar) {
        this.f5070r = (byte) -1;
        this.f5071s = -1;
        n();
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    B8.a aVar = u;
                    m mVarO = null;
                    switch (iN) {
                        case 0:
                            break;
                        case 8:
                            this.c |= 4096;
                            this.f5069q = c0245f.k();
                            continue;
                        case 18:
                            if (!z11) {
                                this.d = new ArrayList();
                                z11 = true;
                            }
                            this.d.add(c0245f.g(Argument.i, hVar));
                            continue;
                        case 24:
                            this.c |= 1;
                            this.e = c0245f.l() != 0;
                            continue;
                        case 32:
                            this.c |= 2;
                            this.f = c0245f.k();
                            continue;
                        case 42:
                            if ((this.c & 4) == 4) {
                                ProtoBuf$Type protoBuf$Type = this.g;
                                protoBuf$Type.getClass();
                                mVarO = o(protoBuf$Type);
                            }
                            ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) c0245f.g(aVar, hVar);
                            this.g = protoBuf$Type2;
                            if (mVarO != null) {
                                mVarO.h(protoBuf$Type2);
                                this.g = mVarO.e();
                            }
                            this.c |= 4;
                            continue;
                        case 48:
                            this.c |= 16;
                            this.i = c0245f.k();
                            continue;
                        case 56:
                            this.c |= 32;
                            this.f5068j = c0245f.k();
                            continue;
                        case 64:
                            this.c |= 8;
                            this.h = c0245f.k();
                            continue;
                        case 72:
                            this.c |= 64;
                            this.k = c0245f.k();
                            continue;
                        case 82:
                            if ((this.c & 256) == 256) {
                                ProtoBuf$Type protoBuf$Type3 = this.m;
                                protoBuf$Type3.getClass();
                                mVarO = o(protoBuf$Type3);
                            }
                            ProtoBuf$Type protoBuf$Type4 = (ProtoBuf$Type) c0245f.g(aVar, hVar);
                            this.m = protoBuf$Type4;
                            if (mVarO != null) {
                                mVarO.h(protoBuf$Type4);
                                this.m = mVarO.e();
                            }
                            this.c |= 256;
                            continue;
                        case 88:
                            this.c |= 512;
                            this.n = c0245f.k();
                            continue;
                        case 96:
                            this.c |= 128;
                            this.l = c0245f.k();
                            continue;
                        case 106:
                            if ((this.c & 1024) == 1024) {
                                ProtoBuf$Type protoBuf$Type5 = this.o;
                                protoBuf$Type5.getClass();
                                mVarO = o(protoBuf$Type5);
                            }
                            ProtoBuf$Type protoBuf$Type6 = (ProtoBuf$Type) c0245f.g(aVar, hVar);
                            this.o = protoBuf$Type6;
                            if (mVarO != null) {
                                mVarO.h(protoBuf$Type6);
                                this.o = mVarO.e();
                            }
                            this.c |= 1024;
                            continue;
                        case 112:
                            this.c |= 2048;
                            this.p = c0245f.k();
                            continue;
                        default:
                            if (!l(c0245f, dVarN, hVar, iN)) {
                                break;
                            }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (z11) {
                        this.d = Collections.unmodifiableList(this.d);
                    }
                    try {
                        dVarN.m();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = c0243d.f();
                        throw th2;
                    }
                    this.b = c0243d.f();
                    k();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                e.f5100a = this;
                throw e;
            } catch (IOException e6) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                invalidProtocolBufferException.f5100a = this;
                throw invalidProtocolBufferException;
            }
        }
        if (z11) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.b = c0243d.f();
            throw th3;
        }
        this.b = c0243d.f();
        k();
    }
}
