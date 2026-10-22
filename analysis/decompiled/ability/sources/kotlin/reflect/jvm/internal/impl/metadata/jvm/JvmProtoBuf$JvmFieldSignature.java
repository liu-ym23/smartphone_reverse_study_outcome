package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import A0.d;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import H8.j;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class JvmProtoBuf$JvmFieldSignature extends GeneratedMessageLite {
    public static final JvmProtoBuf$JvmFieldSignature g;
    public static final B8.a h = new B8.a(20);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5086a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public int f;

    static {
        JvmProtoBuf$JvmFieldSignature jvmProtoBuf$JvmFieldSignature = new JvmProtoBuf$JvmFieldSignature();
        g = jvmProtoBuf$JvmFieldSignature;
        jvmProtoBuf$JvmFieldSignature.c = 0;
        jvmProtoBuf$JvmFieldSignature.d = 0;
    }

    public JvmProtoBuf$JvmFieldSignature(E8.a aVar) {
        this.e = (byte) -1;
        this.f = -1;
        this.f5086a = aVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iF = (this.b & 1) == 1 ? d.f(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iF += d.f(2, this.d);
        }
        int size = this.f5086a.size() + iF;
        this.f = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final j b() {
        return new E8.a(0);
    }

    @Override // H8.AbstractC0241b
    public final j c() {
        E8.a aVar = new E8.a(0);
        aVar.f(this);
        return aVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(d dVar) throws IOException {
        a();
        if ((this.b & 1) == 1) {
            dVar.q(1, this.c);
        }
        if ((this.b & 2) == 2) {
            dVar.q(2, this.d);
        }
        dVar.v(this.f5086a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.e;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.e = (byte) 1;
        return true;
    }

    public JvmProtoBuf$JvmFieldSignature() {
        this.e = (byte) -1;
        this.f = -1;
        this.f5086a = AbstractC0244e.f769a;
    }

    public JvmProtoBuf$JvmFieldSignature(C0245f c0245f) {
        this.e = (byte) -1;
        this.f = -1;
        boolean z10 = false;
        this.c = 0;
        this.d = 0;
        C0243d c0243d = new C0243d();
        d dVarN = d.n(c0243d, 1);
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.b |= 1;
                            this.c = c0245f.k();
                        } else if (iN != 16) {
                            if (!c0245f.q(iN, dVarN)) {
                            }
                        } else {
                            this.b |= 2;
                            this.d = c0245f.k();
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
                    this.f5086a = c0243d.f();
                    throw th2;
                }
                this.f5086a = c0243d.f();
                throw th;
            }
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5086a = c0243d.f();
            throw th3;
        }
        this.f5086a = c0243d.f();
    }
}
