package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import A0.d;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import H8.h;
import H8.j;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class JvmProtoBuf$JvmPropertySignature extends GeneratedMessageLite {

    /* renamed from: j, reason: collision with root package name */
    public static final JvmProtoBuf$JvmPropertySignature f5088j;
    public static final B8.a k = new B8.a(22);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5089a;
    public int b;
    public JvmProtoBuf$JvmFieldSignature c;
    public JvmProtoBuf$JvmMethodSignature d;
    public JvmProtoBuf$JvmMethodSignature e;
    public JvmProtoBuf$JvmMethodSignature f;
    public JvmProtoBuf$JvmMethodSignature g;
    public byte h;
    public int i;

    static {
        JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature = new JvmProtoBuf$JvmPropertySignature();
        f5088j = jvmProtoBuf$JvmPropertySignature;
        jvmProtoBuf$JvmPropertySignature.c = JvmProtoBuf$JvmFieldSignature.g;
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = JvmProtoBuf$JvmMethodSignature.g;
        jvmProtoBuf$JvmPropertySignature.d = jvmProtoBuf$JvmMethodSignature;
        jvmProtoBuf$JvmPropertySignature.e = jvmProtoBuf$JvmMethodSignature;
        jvmProtoBuf$JvmPropertySignature.f = jvmProtoBuf$JvmMethodSignature;
        jvmProtoBuf$JvmPropertySignature.g = jvmProtoBuf$JvmMethodSignature;
    }

    public JvmProtoBuf$JvmPropertySignature(E8.b bVar) {
        this.h = (byte) -1;
        this.i = -1;
        this.f5089a = bVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iH = (this.b & 1) == 1 ? d.h(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iH += d.h(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iH += d.h(3, this.e);
        }
        if ((this.b & 8) == 8) {
            iH += d.h(4, this.f);
        }
        if ((this.b & 16) == 16) {
            iH += d.h(5, this.g);
        }
        int size = this.f5089a.size() + iH;
        this.i = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final j b() {
        return E8.b.e();
    }

    @Override // H8.AbstractC0241b
    public final j c() {
        E8.b bVarE = E8.b.e();
        bVarE.f(this);
        return bVarE;
    }

    @Override // H8.AbstractC0241b
    public final void d(d dVar) throws IOException {
        a();
        if ((this.b & 1) == 1) {
            dVar.s(1, this.c);
        }
        if ((this.b & 2) == 2) {
            dVar.s(2, this.d);
        }
        if ((this.b & 4) == 4) {
            dVar.s(3, this.e);
        }
        if ((this.b & 8) == 8) {
            dVar.s(4, this.f);
        }
        if ((this.b & 16) == 16) {
            dVar.s(5, this.g);
        }
        dVar.v(this.f5089a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.h;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.h = (byte) 1;
        return true;
    }

    public JvmProtoBuf$JvmPropertySignature() {
        this.h = (byte) -1;
        this.i = -1;
        this.f5089a = AbstractC0244e.f769a;
    }

    public JvmProtoBuf$JvmPropertySignature(C0245f c0245f, h hVar) {
        this.h = (byte) -1;
        this.i = -1;
        this.c = JvmProtoBuf$JvmFieldSignature.g;
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = JvmProtoBuf$JvmMethodSignature.g;
        this.d = jvmProtoBuf$JvmMethodSignature;
        this.e = jvmProtoBuf$JvmMethodSignature;
        this.f = jvmProtoBuf$JvmMethodSignature;
        this.g = jvmProtoBuf$JvmMethodSignature;
        C0243d c0243d = new C0243d();
        d dVarN = d.n(c0243d, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        E8.a aVarG = null;
                        if (iN == 10) {
                            if ((this.b & 1) == 1) {
                                JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature = this.c;
                                jvmProtoBuf$JvmFieldSignature.getClass();
                                aVarG = new E8.a(0);
                                aVarG.f(jvmProtoBuf$JvmFieldSignature);
                            }
                            JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature2 = (JvmProtoBuf$JvmFieldSignature) c0245f.g(JvmProtoBuf$JvmFieldSignature.h, hVar);
                            this.c = jvmProtoBuf$JvmFieldSignature2;
                            if (aVarG != null) {
                                aVarG.f(jvmProtoBuf$JvmFieldSignature2);
                                this.c = aVarG.d();
                            }
                            this.b |= 1;
                        } else if (iN == 18) {
                            if ((this.b & 2) == 2) {
                                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature2 = this.d;
                                jvmProtoBuf$JvmMethodSignature2.getClass();
                                aVarG = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature2);
                            }
                            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature3 = (JvmProtoBuf$JvmMethodSignature) c0245f.g(JvmProtoBuf$JvmMethodSignature.h, hVar);
                            this.d = jvmProtoBuf$JvmMethodSignature3;
                            if (aVarG != null) {
                                aVarG.h(jvmProtoBuf$JvmMethodSignature3);
                                this.d = aVarG.e();
                            }
                            this.b |= 2;
                        } else if (iN == 26) {
                            if ((this.b & 4) == 4) {
                                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature4 = this.e;
                                jvmProtoBuf$JvmMethodSignature4.getClass();
                                aVarG = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature4);
                            }
                            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature5 = (JvmProtoBuf$JvmMethodSignature) c0245f.g(JvmProtoBuf$JvmMethodSignature.h, hVar);
                            this.e = jvmProtoBuf$JvmMethodSignature5;
                            if (aVarG != null) {
                                aVarG.h(jvmProtoBuf$JvmMethodSignature5);
                                this.e = aVarG.e();
                            }
                            this.b |= 4;
                        } else if (iN == 34) {
                            if ((this.b & 8) == 8) {
                                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature6 = this.f;
                                jvmProtoBuf$JvmMethodSignature6.getClass();
                                aVarG = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature6);
                            }
                            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature7 = (JvmProtoBuf$JvmMethodSignature) c0245f.g(JvmProtoBuf$JvmMethodSignature.h, hVar);
                            this.f = jvmProtoBuf$JvmMethodSignature7;
                            if (aVarG != null) {
                                aVarG.h(jvmProtoBuf$JvmMethodSignature7);
                                this.f = aVarG.e();
                            }
                            this.b |= 8;
                        } else if (iN != 42) {
                            if (!c0245f.q(iN, dVarN)) {
                            }
                        } else {
                            if ((this.b & 16) == 16) {
                                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature8 = this.g;
                                jvmProtoBuf$JvmMethodSignature8.getClass();
                                aVarG = JvmProtoBuf$JvmMethodSignature.g(jvmProtoBuf$JvmMethodSignature8);
                            }
                            JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature9 = (JvmProtoBuf$JvmMethodSignature) c0245f.g(JvmProtoBuf$JvmMethodSignature.h, hVar);
                            this.g = jvmProtoBuf$JvmMethodSignature9;
                            if (aVarG != null) {
                                aVarG.h(jvmProtoBuf$JvmMethodSignature9);
                                this.g = aVarG.e();
                            }
                            this.b |= 16;
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
                try {
                    dVarN.m();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f5089a = c0243d.f();
                    throw th2;
                }
                this.f5089a = c0243d.f();
                throw th;
            }
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5089a = c0243d.f();
            throw th3;
        }
        this.f5089a = c0243d.f();
    }
}
