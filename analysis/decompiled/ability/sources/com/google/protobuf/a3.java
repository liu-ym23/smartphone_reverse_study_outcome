package com.google.protobuf;

import c0.C0868b;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class a3 extends AbstractC0926c1 implements b3 {
    public int e;
    public Object f;
    public C0986r2 g;
    public C0986r2 h;

    public a3() {
        super(null);
        this.e = 0;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = A2.e;
        c0868b.g(Value.class, a3.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final Value m() {
        C0986r2 c0986r2;
        C0986r2 c0986r22;
        Value value = new Value(this);
        value.e = (byte) -1;
        int i = this.e;
        value.c = i;
        value.d = this.f;
        if (i == 5 && (c0986r22 = this.g) != null) {
            value.d = c0986r22.a();
        }
        if (this.e == 6 && (c0986r2 = this.h) != null) {
            value.d = c0986r2.a();
        }
        K();
        return value;
    }

    public final C0986r2 O() {
        if (this.h == null) {
            if (this.e != 6) {
                this.f = ListValue.e;
            }
            this.h = new C0986r2((ListValue) this.f, E(), this.c);
            this.f = null;
        }
        this.e = 6;
        L();
        return this.h;
    }

    public final C0986r2 P() {
        if (this.g == null) {
            if (this.e != 5) {
                this.f = Struct.e;
            }
            this.g = new C0986r2((Struct) this.f, E(), this.c);
            this.f = null;
        }
        this.e = 5;
        L();
        return this.g;
    }

    public final void Q(Value value) {
        Object obj;
        Object obj2;
        ListValue listValue;
        if (value == Value.f) {
            return;
        }
        int iOrdinal = value.F().ordinal();
        if (iOrdinal == 0) {
            int iH = value.H();
            this.e = 1;
            this.f = Integer.valueOf(iH);
            L();
        } else if (iOrdinal == 1) {
            double dI = value.I();
            this.e = 2;
            this.f = Double.valueOf(dI);
            L();
        } else if (iOrdinal == 2) {
            this.e = 3;
            this.f = value.d;
            L();
        } else if (iOrdinal == 3) {
            boolean zE = value.E();
            this.e = 4;
            this.f = Boolean.valueOf(zE);
            L();
        } else if (iOrdinal == 4) {
            Struct structK = value.K();
            C0986r2 c0986r2 = this.g;
            if (c0986r2 == null) {
                if (this.e != 5 || (obj = this.f) == Struct.e) {
                    this.f = structK;
                } else {
                    C1014y2 c1014y2F = Struct.F((Struct) obj);
                    c1014y2F.P(structK);
                    this.f = c1014y2F.m();
                }
                L();
            } else if (this.e == 5) {
                c0986r2.d(structK);
            } else {
                Charset charset = AbstractC0989s1.f2940a;
                structK.getClass();
                c0986r2.c = structK;
                AbstractC0916a abstractC0916a = c0986r2.b;
                if (abstractC0916a != null) {
                    abstractC0916a.n();
                    c0986r2.b = null;
                }
                c0986r2.e();
            }
            this.e = 5;
        } else if (iOrdinal == 5) {
            ListValue listValueG = value.G();
            C0986r2 c0986r22 = this.h;
            if (c0986r22 == null) {
                if (this.e != 6 || (obj2 = this.f) == (listValue = ListValue.e)) {
                    this.f = listValueG;
                } else {
                    C1 builder = listValue.toBuilder();
                    builder.O((ListValue) obj2);
                    builder.O(listValueG);
                    this.f = builder.m();
                }
                L();
            } else if (this.e == 6) {
                c0986r22.d(listValueG);
            } else {
                Charset charset2 = AbstractC0989s1.f2940a;
                listValueG.getClass();
                c0986r22.c = listValueG;
                AbstractC0916a abstractC0916a2 = c0986r22.b;
                if (abstractC0916a2 != null) {
                    abstractC0916a2.n();
                    c0986r22.b = null;
                }
                c0986r22.e();
            }
            this.e = 6;
        }
        I(value.b);
        L();
    }

    public final void R(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 8) {
                            int iN = abstractC0972o.n();
                            this.e = 1;
                            this.f = Integer.valueOf(iN);
                        } else if (iD == 17) {
                            this.f = Double.valueOf(abstractC0972o.m());
                            this.e = 2;
                        } else if (iD == 26) {
                            String strC = abstractC0972o.C();
                            this.e = 3;
                            this.f = strC;
                        } else if (iD == 32) {
                            this.f = Boolean.valueOf(abstractC0972o.k());
                            this.e = 4;
                        } else if (iD == 42) {
                            abstractC0972o.v(P().b(), r02);
                            this.e = 5;
                        } else if (iD == 50) {
                            abstractC0972o.v(O().b(), r02);
                            this.e = 6;
                        } else if (!p().m(iD, abstractC0972o)) {
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.h();
                }
            } catch (Throwable th) {
                L();
                throw th;
            }
        }
        L();
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        Value valueM = m();
        if (valueM.isInitialized()) {
            return valueM;
        }
        throw AbstractC0916a.x(valueM);
    }

    public final Object clone() {
        return (a3) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return A2.d;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return Value.f;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        Value valueM = m();
        if (valueM.isInitialized()) {
            return valueM;
        }
        throw AbstractC0916a.x(valueM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        R(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof Value) {
            Q((Value) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        R(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof Value) {
            Q((Value) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void v(M2 m2) {
        I(m2);
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a y(D0 d02, Object obj) {
        M(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return Value.f;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        R(abstractC0972o, r02);
        return this;
    }
}
