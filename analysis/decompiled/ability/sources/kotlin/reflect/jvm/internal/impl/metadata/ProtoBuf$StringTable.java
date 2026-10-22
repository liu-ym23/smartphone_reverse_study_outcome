package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import H8.p;
import H8.r;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$StringTable extends GeneratedMessageLite {
    public static final ProtoBuf$StringTable e;
    public static final B8.a f = new B8.a(12);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5066a;
    public p b;
    public byte c;
    public int d;

    static {
        ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable();
        e = protoBuf$StringTable;
        protoBuf$StringTable.b = H8.o.b;
    }

    public ProtoBuf$StringTable(B8.d dVar) {
        this.c = (byte) -1;
        this.d = -1;
        this.f5066a = dVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int size = 0;
        for (int i6 = 0; i6 < this.b.size(); i6++) {
            AbstractC0244e byteString = this.b.getByteString(i6);
            size += byteString.size() + A0.d.j(byteString.size());
        }
        int size2 = this.f5066a.size() + this.b.size() + size;
        this.d = size2;
        return size2;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        B8.d dVar = new B8.d(2);
        dVar.d = H8.o.b;
        return dVar;
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.d dVar = new B8.d(2);
        dVar.d = H8.o.b;
        dVar.j(this);
        return dVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        for (int i = 0; i < this.b.size(); i++) {
            AbstractC0244e byteString = this.b.getByteString(i);
            dVar.B(1, 2);
            dVar.z(byteString.size());
            dVar.v(byteString);
        }
        dVar.v(this.f5066a);
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.c;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.c = (byte) 1;
        return true;
    }

    public ProtoBuf$StringTable() {
        this.c = (byte) -1;
        this.d = -1;
        this.f5066a = AbstractC0244e.f769a;
    }

    public ProtoBuf$StringTable(C0245f c0245f) {
        this.c = (byte) -1;
        this.d = -1;
        this.b = H8.o.b;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN != 10) {
                            if (!c0245f.q(iN, dVarN)) {
                            }
                        } else {
                            r rVarE = c0245f.e();
                            if (!z11) {
                                this.b = new H8.o();
                                z11 = true;
                            }
                            this.b.d(rVarE);
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (z11) {
                        this.b = this.b.getUnmodifiableView();
                    }
                    try {
                        dVarN.m();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f5066a = c0243d.f();
                        throw th2;
                    }
                    this.f5066a = c0243d.f();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e6) {
                e6.f5100a = this;
                throw e6;
            } catch (IOException e9) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e9.getMessage());
                invalidProtocolBufferException.f5100a = this;
                throw invalidProtocolBufferException;
            }
        }
        if (z11) {
            this.b = this.b.getUnmodifiableView();
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5066a = c0243d.f();
            throw th3;
        }
        this.f5066a = c0243d.f();
    }
}
