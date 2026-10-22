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
public final class ProtoBuf$TypeParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeParameter> {
    public static final ProtoBuf$TypeParameter m;
    public static final B8.a n = new B8.a(15);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public Variance g;
    public List h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public int f5075j;
    public byte k;
    public int l;

    public enum Variance implements H8.m {
        IN(0),
        OUT(1),
        INV(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f5076a;

        Variance(int i) {
            this.f5076a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5076a;
        }
    }

    static {
        ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter();
        m = protoBuf$TypeParameter;
        protoBuf$TypeParameter.d = 0;
        protoBuf$TypeParameter.e = 0;
        protoBuf$TypeParameter.f = false;
        protoBuf$TypeParameter.g = Variance.INV;
        List list = Collections.EMPTY_LIST;
        protoBuf$TypeParameter.h = list;
        protoBuf$TypeParameter.i = list;
    }

    public ProtoBuf$TypeParameter(n nVar) {
        super(nVar);
        this.f5075j = -1;
        this.k = (byte) -1;
        this.l = -1;
        this.b = nVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.l;
        if (i != -1) {
            return i;
        }
        int iF = (this.c & 1) == 1 ? A0.d.f(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iF += A0.d.f(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iF += A0.d.l(3) + 1;
        }
        if ((this.c & 8) == 8) {
            iF += A0.d.e(4, this.g.f5076a);
        }
        for (int i6 = 0; i6 < this.h.size(); i6++) {
            iF += A0.d.h(5, (AbstractC0241b) this.h.get(i6));
        }
        int iG = 0;
        for (int i10 = 0; i10 < this.i.size(); i10++) {
            iG += A0.d.g(((Integer) this.i.get(i10)).intValue());
        }
        int iG2 = iF + iG;
        if (!this.i.isEmpty()) {
            iG2 = iG2 + 1 + A0.d.g(iG);
        }
        this.f5075j = iG;
        int size = this.b.size() + h() + iG2;
        this.l = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return n.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        n nVarF = n.f();
        nVarF.h(this);
        return nVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 1) == 1) {
            dVar.q(1, this.d);
        }
        if ((this.c & 2) == 2) {
            dVar.q(2, this.e);
        }
        if ((this.c & 4) == 4) {
            boolean z10 = this.f;
            dVar.B(3, 0);
            dVar.u(z10 ? 1 : 0);
        }
        if ((this.c & 8) == 8) {
            dVar.p(4, this.g.f5076a);
        }
        for (int i = 0; i < this.h.size(); i++) {
            dVar.s(5, (AbstractC0241b) this.h.get(i));
        }
        if (this.i.size() > 0) {
            dVar.z(50);
            dVar.z(this.f5075j);
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            dVar.r(((Integer) this.i.get(i6)).intValue());
        }
        bVar.a(1000, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return m;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.k;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 1) != 1) {
            this.k = (byte) 0;
            return false;
        }
        if ((i & 2) != 2) {
            this.k = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < this.h.size(); i6++) {
            if (!((ProtoBuf$Type) this.h.get(i6)).isInitialized()) {
                this.k = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.k = (byte) 1;
            return true;
        }
        this.k = (byte) 0;
        return false;
    }

    public ProtoBuf$TypeParameter() {
        this.f5075j = -1;
        this.k = (byte) -1;
        this.l = -1;
        this.b = AbstractC0244e.f769a;
    }

    public ProtoBuf$TypeParameter(C0245f c0245f, H8.h hVar) {
        Variance variance;
        this.f5075j = -1;
        this.k = (byte) -1;
        this.l = -1;
        this.d = 0;
        this.e = 0;
        this.f = false;
        Variance variance2 = Variance.INV;
        this.g = variance2;
        List list = Collections.EMPTY_LIST;
        this.h = list;
        this.i = list;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        int i = 0;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = c0245f.k();
                        } else if (iN == 16) {
                            this.c |= 2;
                            this.e = c0245f.k();
                        } else if (iN == 24) {
                            this.c |= 4;
                            this.f = c0245f.l() != 0;
                        } else if (iN == 32) {
                            int iK = c0245f.k();
                            if (iK == 0) {
                                variance = Variance.IN;
                            } else if (iK != 1) {
                                variance = iK != 2 ? null : variance2;
                            } else {
                                variance = Variance.OUT;
                            }
                            if (variance == null) {
                                dVarN.z(iN);
                                dVarN.z(iK);
                            } else {
                                this.c |= 8;
                                this.g = variance;
                            }
                        } else if (iN == 42) {
                            if ((i & 16) != 16) {
                                this.h = new ArrayList();
                                i |= 16;
                            }
                            this.h.add(c0245f.g(ProtoBuf$Type.u, hVar));
                        } else if (iN == 48) {
                            if ((i & 32) != 32) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            this.i.add(Integer.valueOf(c0245f.k()));
                        } else if (iN != 50) {
                            if (!l(c0245f, dVarN, hVar, iN)) {
                            }
                        } else {
                            int iD = c0245f.d(c0245f.k());
                            if ((i & 32) != 32 && c0245f.b() > 0) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            while (c0245f.b() > 0) {
                                this.i.add(Integer.valueOf(c0245f.k()));
                            }
                            c0245f.c(iD);
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i & 16) == 16) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    if ((i & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
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
        if ((i & 16) == 16) {
            this.h = Collections.unmodifiableList(this.h);
        }
        if ((i & 32) == 32) {
            this.i = Collections.unmodifiableList(this.i);
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
