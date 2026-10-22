package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$EnumEntry extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$EnumEntry> {
    public static final ProtoBuf$EnumEntry g;
    public static final B8.a h = new B8.a(5);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public byte e;
    public int f;

    static {
        ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry();
        g = protoBuf$EnumEntry;
        protoBuf$EnumEntry.d = 0;
    }

    public ProtoBuf$EnumEntry(B8.e eVar) {
        super(eVar);
        this.e = (byte) -1;
        this.f = -1;
        this.b = eVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int size = this.b.size() + h() + ((this.c & 1) == 1 ? A0.d.f(1, this.d) : 0);
        this.f = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return new B8.e();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.e eVar = new B8.e();
        eVar.e(this);
        return eVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 1) == 1) {
            dVar.q(1, this.d);
        }
        bVar.a(200, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return g;
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
        if (g()) {
            this.e = (byte) 1;
            return true;
        }
        this.e = (byte) 0;
        return false;
    }

    public ProtoBuf$EnumEntry() {
        this.e = (byte) -1;
        this.f = -1;
        this.b = AbstractC0244e.f769a;
    }

    public ProtoBuf$EnumEntry(C0245f c0245f, H8.h hVar) {
        this.e = (byte) -1;
        this.f = -1;
        boolean z10 = false;
        this.d = 0;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        while (!z10) {
            try {
                try {
                    try {
                        int iN = c0245f.n();
                        if (iN != 0) {
                            if (iN != 8) {
                                if (!l(c0245f, dVarN, hVar, iN)) {
                                }
                            } else {
                                this.c |= 1;
                                this.d = c0245f.k();
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e) {
                        e.f5100a = this;
                        throw e;
                    }
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
                    this.b = c0243d.f();
                    throw th2;
                }
                this.b = c0243d.f();
                k();
                throw th;
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
