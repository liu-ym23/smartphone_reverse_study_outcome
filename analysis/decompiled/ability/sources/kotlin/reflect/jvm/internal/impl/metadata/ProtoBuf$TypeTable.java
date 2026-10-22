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
public final class ProtoBuf$TypeTable extends GeneratedMessageLite {
    public static final ProtoBuf$TypeTable g;
    public static final B8.a h = new B8.a(16);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5077a;
    public int b;
    public List c;
    public int d;
    public byte e;
    public int f;

    static {
        ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable();
        g = protoBuf$TypeTable;
        protoBuf$TypeTable.c = Collections.EMPTY_LIST;
        protoBuf$TypeTable.d = -1;
    }

    public ProtoBuf$TypeTable(B8.k kVar) {
        this.e = (byte) -1;
        this.f = -1;
        this.f5077a = kVar.f774a;
    }

    public static B8.k g(ProtoBuf$TypeTable protoBuf$TypeTable) {
        B8.k kVarE = B8.k.e();
        kVarE.f(protoBuf$TypeTable);
        return kVarE;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i6 = 0; i6 < this.c.size(); i6++) {
            iF += A0.d.h(1, (AbstractC0241b) this.c.get(i6));
        }
        if ((this.b & 1) == 1) {
            iF += A0.d.f(2, this.d);
        }
        int size = this.f5077a.size() + iF;
        this.f = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.k.e();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        return g(this);
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        for (int i = 0; i < this.c.size(); i++) {
            dVar.s(1, (AbstractC0241b) this.c.get(i));
        }
        if ((this.b & 1) == 1) {
            dVar.q(2, this.d);
        }
        dVar.v(this.f5077a);
    }

    public final B8.k h() {
        return g(this);
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
        for (int i = 0; i < this.c.size(); i++) {
            if (!((ProtoBuf$Type) this.c.get(i)).isInitialized()) {
                this.e = (byte) 0;
                return false;
            }
        }
        this.e = (byte) 1;
        return true;
    }

    public ProtoBuf$TypeTable() {
        this.e = (byte) -1;
        this.f = -1;
        this.f5077a = AbstractC0244e.f769a;
    }

    public ProtoBuf$TypeTable(C0245f c0245f, H8.h hVar) {
        this.e = (byte) -1;
        this.f = -1;
        this.c = Collections.EMPTY_LIST;
        this.d = -1;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int iN = c0245f.n();
                        if (iN != 0) {
                            if (iN == 10) {
                                if (!z11) {
                                    this.c = new ArrayList();
                                    z11 = true;
                                }
                                this.c.add(c0245f.g(ProtoBuf$Type.u, hVar));
                            } else if (iN != 16) {
                                if (!c0245f.q(iN, dVarN)) {
                                }
                            } else {
                                this.b |= 1;
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
                if (z11) {
                    this.c = Collections.unmodifiableList(this.c);
                }
                try {
                    dVarN.m();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f5077a = c0243d.f();
                    throw th2;
                }
                this.f5077a = c0243d.f();
                throw th;
            }
        }
        if (z11) {
            this.c = Collections.unmodifiableList(this.c);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5077a = c0243d.f();
            throw th3;
        }
        this.f5077a = c0243d.f();
    }
}
