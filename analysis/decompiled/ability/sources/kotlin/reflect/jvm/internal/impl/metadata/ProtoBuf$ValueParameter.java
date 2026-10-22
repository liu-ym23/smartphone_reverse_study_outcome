package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$ValueParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$ValueParameter> {
    public static final ProtoBuf$ValueParameter l;
    public static final B8.a m = new B8.a(17);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public int e;
    public ProtoBuf$Type f;
    public int g;
    public ProtoBuf$Type h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public byte f5078j;
    public int k;

    static {
        ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter();
        l = protoBuf$ValueParameter;
        protoBuf$ValueParameter.d = 0;
        protoBuf$ValueParameter.e = 0;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        protoBuf$ValueParameter.f = protoBuf$Type;
        protoBuf$ValueParameter.g = 0;
        protoBuf$ValueParameter.h = protoBuf$Type;
        protoBuf$ValueParameter.i = 0;
    }

    public ProtoBuf$ValueParameter(B8.l lVar) {
        super(lVar);
        this.f5078j = (byte) -1;
        this.k = -1;
        this.b = lVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.k;
        if (i != -1) {
            return i;
        }
        int iF = (this.c & 1) == 1 ? A0.d.f(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iF += A0.d.f(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iF += A0.d.h(3, this.f);
        }
        if ((this.c & 16) == 16) {
            iF += A0.d.h(4, this.h);
        }
        if ((this.c & 8) == 8) {
            iF += A0.d.f(5, this.g);
        }
        if ((this.c & 32) == 32) {
            iF += A0.d.f(6, this.i);
        }
        int size = this.b.size() + h() + iF;
        this.k = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        B8.l lVar = new B8.l();
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        lVar.g = protoBuf$Type;
        lVar.i = protoBuf$Type;
        return lVar;
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.l lVar = new B8.l();
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        lVar.g = protoBuf$Type;
        lVar.i = protoBuf$Type;
        lVar.f(this);
        return lVar;
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
            dVar.s(3, this.f);
        }
        if ((this.c & 16) == 16) {
            dVar.s(4, this.h);
        }
        if ((this.c & 8) == 8) {
            dVar.q(5, this.g);
        }
        if ((this.c & 32) == 32) {
            dVar.q(6, this.i);
        }
        bVar.a(200, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return l;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.f5078j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 2) != 2) {
            this.f5078j = (byte) 0;
            return false;
        }
        if ((i & 4) == 4 && !this.f.isInitialized()) {
            this.f5078j = (byte) 0;
            return false;
        }
        if ((this.c & 16) == 16 && !this.h.isInitialized()) {
            this.f5078j = (byte) 0;
            return false;
        }
        if (g()) {
            this.f5078j = (byte) 1;
            return true;
        }
        this.f5078j = (byte) 0;
        return false;
    }

    public ProtoBuf$ValueParameter() {
        this.f5078j = (byte) -1;
        this.k = -1;
        this.b = AbstractC0244e.f769a;
    }

    public ProtoBuf$ValueParameter(C0245f c0245f, H8.h hVar) {
        this.f5078j = (byte) -1;
        this.k = -1;
        boolean z10 = false;
        this.d = 0;
        this.e = 0;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        this.f = protoBuf$Type;
        this.g = 0;
        this.h = protoBuf$Type;
        this.i = 0;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = c0245f.k();
                        } else if (iN != 16) {
                            m mVarO = null;
                            if (iN == 26) {
                                if ((this.c & 4) == 4) {
                                    ProtoBuf$Type protoBuf$Type2 = this.f;
                                    protoBuf$Type2.getClass();
                                    mVarO = ProtoBuf$Type.o(protoBuf$Type2);
                                }
                                ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                this.f = protoBuf$Type3;
                                if (mVarO != null) {
                                    mVarO.h(protoBuf$Type3);
                                    this.f = mVarO.e();
                                }
                                this.c |= 4;
                            } else if (iN == 34) {
                                if ((this.c & 16) == 16) {
                                    ProtoBuf$Type protoBuf$Type4 = this.h;
                                    protoBuf$Type4.getClass();
                                    mVarO = ProtoBuf$Type.o(protoBuf$Type4);
                                }
                                ProtoBuf$Type protoBuf$Type5 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                this.h = protoBuf$Type5;
                                if (mVarO != null) {
                                    mVarO.h(protoBuf$Type5);
                                    this.h = mVarO.e();
                                }
                                this.c |= 16;
                            } else if (iN == 40) {
                                this.c |= 8;
                                this.g = c0245f.k();
                            } else if (iN != 48) {
                                if (!l(c0245f, dVarN, hVar, iN)) {
                                }
                            } else {
                                this.c |= 32;
                                this.i = c0245f.k();
                            }
                        } else {
                            this.c |= 2;
                            this.e = c0245f.k();
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
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
