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
public final class ProtoBuf$Expression extends GeneratedMessageLite {
    public static final ProtoBuf$Expression l;
    public static final B8.a m = new B8.a(6);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5044a;
    public int b;
    public int c;
    public int d;
    public ConstantValue e;
    public ProtoBuf$Type f;
    public int g;
    public List h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public byte f5045j;
    public int k;

    public enum ConstantValue implements H8.m {
        TRUE(0),
        FALSE(1),
        NULL(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f5046a;

        ConstantValue(int i) {
            this.f5046a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5046a;
        }
    }

    static {
        ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression();
        l = protoBuf$Expression;
        protoBuf$Expression.c = 0;
        protoBuf$Expression.d = 0;
        protoBuf$Expression.e = ConstantValue.TRUE;
        protoBuf$Expression.f = ProtoBuf$Type.f5067t;
        protoBuf$Expression.g = 0;
        List list = Collections.EMPTY_LIST;
        protoBuf$Expression.h = list;
        protoBuf$Expression.i = list;
    }

    public ProtoBuf$Expression(g gVar) {
        this.f5045j = (byte) -1;
        this.k = -1;
        this.f5044a = gVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.k;
        if (i != -1) {
            return i;
        }
        int iF = (this.b & 1) == 1 ? A0.d.f(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iF += A0.d.f(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iF += A0.d.e(3, this.e.f5046a);
        }
        if ((this.b & 8) == 8) {
            iF += A0.d.h(4, this.f);
        }
        if ((this.b & 16) == 16) {
            iF += A0.d.f(5, this.g);
        }
        for (int i6 = 0; i6 < this.h.size(); i6++) {
            iF += A0.d.h(6, (AbstractC0241b) this.h.get(i6));
        }
        for (int i10 = 0; i10 < this.i.size(); i10++) {
            iF += A0.d.h(7, (AbstractC0241b) this.i.get(i10));
        }
        int size = this.f5044a.size() + iF;
        this.k = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return g.e();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        g gVarE = g.e();
        gVarE.f(this);
        return gVarE;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        if ((this.b & 1) == 1) {
            dVar.q(1, this.c);
        }
        if ((this.b & 2) == 2) {
            dVar.q(2, this.d);
        }
        if ((this.b & 4) == 4) {
            dVar.p(3, this.e.f5046a);
        }
        if ((this.b & 8) == 8) {
            dVar.s(4, this.f);
        }
        if ((this.b & 16) == 16) {
            dVar.q(5, this.g);
        }
        for (int i = 0; i < this.h.size(); i++) {
            dVar.s(6, (AbstractC0241b) this.h.get(i));
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            dVar.s(7, (AbstractC0241b) this.i.get(i6));
        }
        dVar.v(this.f5044a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.f5045j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 8) == 8 && !this.f.isInitialized()) {
            this.f5045j = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.h.size(); i++) {
            if (!((ProtoBuf$Expression) this.h.get(i)).isInitialized()) {
                this.f5045j = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            if (!((ProtoBuf$Expression) this.i.get(i6)).isInitialized()) {
                this.f5045j = (byte) 0;
                return false;
            }
        }
        this.f5045j = (byte) 1;
        return true;
    }

    public ProtoBuf$Expression() {
        this.f5045j = (byte) -1;
        this.k = -1;
        this.f5044a = AbstractC0244e.f769a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public ProtoBuf$Expression(C0245f c0245f, H8.h hVar) {
        ConstantValue constantValue;
        this.f5045j = (byte) -1;
        this.k = -1;
        boolean z10 = false;
        this.c = 0;
        this.d = 0;
        ConstantValue constantValue2 = ConstantValue.TRUE;
        this.e = constantValue2;
        this.f = ProtoBuf$Type.f5067t;
        this.g = 0;
        List list = Collections.EMPTY_LIST;
        this.h = list;
        this.i = list;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        char c = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int iN = c0245f.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.b |= 1;
                                this.c = c0245f.k();
                            } else if (iN != 16) {
                                m mVarO = null;
                                ConstantValue constantValue3 = null;
                                if (iN == 24) {
                                    int iK = c0245f.k();
                                    if (iK != 0) {
                                        if (iK == 1) {
                                            constantValue3 = ConstantValue.FALSE;
                                        } else if (iK == 2) {
                                            constantValue3 = ConstantValue.NULL;
                                        }
                                        constantValue = constantValue3;
                                    } else {
                                        constantValue = constantValue2;
                                    }
                                    if (constantValue == null) {
                                        dVarN.z(iN);
                                        dVarN.z(iK);
                                    } else {
                                        this.b |= 4;
                                        this.e = constantValue;
                                    }
                                } else if (iN == 34) {
                                    if ((this.b & 8) == 8) {
                                        ProtoBuf$Type protoBuf$Type = this.f;
                                        protoBuf$Type.getClass();
                                        mVarO = ProtoBuf$Type.o(protoBuf$Type);
                                    }
                                    m mVar = mVarO;
                                    ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                    this.f = protoBuf$Type2;
                                    if (mVar != null) {
                                        mVar.h(protoBuf$Type2);
                                        this.f = mVar.e();
                                    }
                                    this.b |= 8;
                                } else if (iN != 40) {
                                    B8.a aVar = m;
                                    if (iN == 50) {
                                        int i = (c == true ? 1 : 0) & 32;
                                        c = c;
                                        if (i != 32) {
                                            this.h = new ArrayList();
                                            c = (c == true ? 1 : 0) | ' ';
                                        }
                                        this.h.add(c0245f.g(aVar, hVar));
                                    } else if (iN != 58) {
                                        if (!c0245f.q(iN, dVarN)) {
                                        }
                                    } else {
                                        int i6 = (c == true ? 1 : 0) & 64;
                                        c = c;
                                        if (i6 != 64) {
                                            this.i = new ArrayList();
                                            c = (c == true ? 1 : 0) | '@';
                                        }
                                        this.i.add(c0245f.g(aVar, hVar));
                                    }
                                } else {
                                    this.b |= 16;
                                    this.g = c0245f.k();
                                }
                            } else {
                                this.b |= 2;
                                this.d = c0245f.k();
                            }
                        }
                        z10 = true;
                    } catch (IOException e) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e.getMessage());
                        invalidProtocolBufferException.f5100a = this;
                        throw invalidProtocolBufferException;
                    }
                } catch (InvalidProtocolBufferException e6) {
                    e6.f5100a = this;
                    throw e6;
                }
            } catch (Throwable th) {
                if (((c == true ? 1 : 0) & 32) == 32) {
                    this.h = Collections.unmodifiableList(this.h);
                }
                if (((c == true ? 1 : 0) & 64) == 64) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                try {
                    dVarN.m();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f5044a = c0243d.f();
                    throw th2;
                }
                this.f5044a = c0243d.f();
                throw th;
            }
        }
        if (((c == true ? 1 : 0) & 32) == 32) {
            this.h = Collections.unmodifiableList(this.h);
        }
        if (((c == true ? 1 : 0) & 64) == 64) {
            this.i = Collections.unmodifiableList(this.i);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5044a = c0243d.f();
            throw th3;
        }
        this.f5044a = c0243d.f();
    }
}
