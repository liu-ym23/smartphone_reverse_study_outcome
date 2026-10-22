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
public final class ProtoBuf$Effect extends GeneratedMessageLite {
    public static final ProtoBuf$Effect i;

    /* renamed from: j, reason: collision with root package name */
    public static final B8.a f5040j = new B8.a(4);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5041a;
    public int b;
    public EffectType c;
    public List d;
    public ProtoBuf$Expression e;
    public InvocationKind f;
    public byte g;
    public int h;

    public enum EffectType implements H8.m {
        RETURNS_CONSTANT(0),
        CALLS(1),
        RETURNS_NOT_NULL(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f5042a;

        EffectType(int i) {
            this.f5042a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5042a;
        }
    }

    public enum InvocationKind implements H8.m {
        AT_MOST_ONCE(0),
        EXACTLY_ONCE(1),
        AT_LEAST_ONCE(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f5043a;

        InvocationKind(int i) {
            this.f5043a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5043a;
        }
    }

    static {
        ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect();
        i = protoBuf$Effect;
        protoBuf$Effect.c = EffectType.RETURNS_CONSTANT;
        protoBuf$Effect.d = Collections.EMPTY_LIST;
        protoBuf$Effect.e = ProtoBuf$Expression.l;
        protoBuf$Effect.f = InvocationKind.AT_MOST_ONCE;
    }

    public ProtoBuf$Effect(f fVar) {
        this.g = (byte) -1;
        this.h = -1;
        this.f5041a = fVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i6 = this.h;
        if (i6 != -1) {
            return i6;
        }
        int iE = (this.b & 1) == 1 ? A0.d.e(1, this.c.f5042a) : 0;
        for (int i10 = 0; i10 < this.d.size(); i10++) {
            iE += A0.d.h(2, (AbstractC0241b) this.d.get(i10));
        }
        if ((this.b & 2) == 2) {
            iE += A0.d.h(3, this.e);
        }
        if ((this.b & 4) == 4) {
            iE += A0.d.e(4, this.f.f5043a);
        }
        int size = this.f5041a.size() + iE;
        this.h = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return f.e();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        f fVarE = f.e();
        fVarE.f(this);
        return fVarE;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        if ((this.b & 1) == 1) {
            dVar.p(1, this.c.f5042a);
        }
        for (int i6 = 0; i6 < this.d.size(); i6++) {
            dVar.s(2, (AbstractC0241b) this.d.get(i6));
        }
        if ((this.b & 2) == 2) {
            dVar.s(3, this.e);
        }
        if ((this.b & 4) == 4) {
            dVar.p(4, this.f.f5043a);
        }
        dVar.v(this.f5041a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.g;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i6 = 0; i6 < this.d.size(); i6++) {
            if (!((ProtoBuf$Expression) this.d.get(i6)).isInitialized()) {
                this.g = (byte) 0;
                return false;
            }
        }
        if ((this.b & 2) != 2 || this.e.isInitialized()) {
            this.g = (byte) 1;
            return true;
        }
        this.g = (byte) 0;
        return false;
    }

    public ProtoBuf$Effect() {
        this.g = (byte) -1;
        this.h = -1;
        this.f5041a = AbstractC0244e.f769a;
    }

    public ProtoBuf$Effect(C0245f c0245f, H8.h hVar) {
        this.g = (byte) -1;
        this.h = -1;
        EffectType effectType = EffectType.RETURNS_CONSTANT;
        this.c = effectType;
        this.d = Collections.EMPTY_LIST;
        this.e = ProtoBuf$Expression.l;
        InvocationKind invocationKind = InvocationKind.AT_MOST_ONCE;
        this.f = invocationKind;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        char c = 0;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        InvocationKind invocationKind2 = null;
                        EffectType effectType2 = null;
                        g gVarE = null;
                        if (iN == 8) {
                            int iK = c0245f.k();
                            if (iK == 0) {
                                effectType2 = effectType;
                            } else if (iK == 1) {
                                effectType2 = EffectType.CALLS;
                            } else if (iK == 2) {
                                effectType2 = EffectType.RETURNS_NOT_NULL;
                            }
                            if (effectType2 == null) {
                                dVarN.z(iN);
                                dVarN.z(iK);
                            } else {
                                this.b |= 1;
                                this.c = effectType2;
                            }
                        } else if (iN == 18) {
                            int i6 = (c == true ? 1 : 0) & 2;
                            c = c;
                            if (i6 != 2) {
                                this.d = new ArrayList();
                                c = 2;
                            }
                            this.d.add(c0245f.g(ProtoBuf$Expression.m, hVar));
                        } else if (iN == 26) {
                            if ((this.b & 2) == 2) {
                                ProtoBuf$Expression protoBuf$Expression = this.e;
                                protoBuf$Expression.getClass();
                                gVarE = g.e();
                                gVarE.f(protoBuf$Expression);
                            }
                            ProtoBuf$Expression protoBuf$Expression2 = (ProtoBuf$Expression) c0245f.g(ProtoBuf$Expression.m, hVar);
                            this.e = protoBuf$Expression2;
                            if (gVarE != null) {
                                gVarE.f(protoBuf$Expression2);
                                this.e = gVarE.d();
                            }
                            this.b |= 2;
                        } else if (iN != 32) {
                            if (!c0245f.q(iN, dVarN)) {
                            }
                        } else {
                            int iK2 = c0245f.k();
                            if (iK2 == 0) {
                                invocationKind2 = invocationKind;
                            } else if (iK2 == 1) {
                                invocationKind2 = InvocationKind.EXACTLY_ONCE;
                            } else if (iK2 == 2) {
                                invocationKind2 = InvocationKind.AT_LEAST_ONCE;
                            }
                            if (invocationKind2 == null) {
                                dVarN.z(iN);
                                dVarN.z(iK2);
                            } else {
                                this.b |= 4;
                                this.f = invocationKind2;
                            }
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e) {
                    e.f5100a = this;
                    throw e;
                } catch (IOException e6) {
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                    invalidProtocolBufferException.f5100a = this;
                    throw invalidProtocolBufferException;
                }
            } catch (Throwable th) {
                if (((c == true ? 1 : 0) & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
                }
                try {
                    dVarN.m();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f5041a = c0243d.f();
                    throw th2;
                }
                this.f5041a = c0243d.f();
                throw th;
            }
        }
        if (((c == true ? 1 : 0) & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5041a = c0243d.f();
            throw th3;
        }
        this.f5041a = c0243d.f();
    }
}
