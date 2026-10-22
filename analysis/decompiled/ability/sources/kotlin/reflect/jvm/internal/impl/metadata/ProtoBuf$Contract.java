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
public final class ProtoBuf$Contract extends GeneratedMessageLite {
    public static final ProtoBuf$Contract e;
    public static final B8.a f = new B8.a(3);

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0244e f5039a;
    public List b;
    public byte c;
    public int d;

    static {
        ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract();
        e = protoBuf$Contract;
        protoBuf$Contract.b = Collections.EMPTY_LIST;
    }

    public ProtoBuf$Contract(B8.d dVar) {
        this.c = (byte) -1;
        this.d = -1;
        this.f5039a = dVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iH = 0;
        for (int i6 = 0; i6 < this.b.size(); i6++) {
            iH += A0.d.h(1, (AbstractC0241b) this.b.get(i6));
        }
        int size = this.f5039a.size() + iH;
        this.d = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        B8.d dVar = new B8.d(0);
        dVar.d = Collections.EMPTY_LIST;
        return dVar;
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.d dVar = new B8.d(0);
        dVar.d = Collections.EMPTY_LIST;
        dVar.h(this);
        return dVar;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        for (int i = 0; i < this.b.size(); i++) {
            dVar.s(1, (AbstractC0241b) this.b.get(i));
        }
        dVar.v(this.f5039a);
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
        for (int i = 0; i < this.b.size(); i++) {
            if (!((ProtoBuf$Effect) this.b.get(i)).isInitialized()) {
                this.c = (byte) 0;
                return false;
            }
        }
        this.c = (byte) 1;
        return true;
    }

    public ProtoBuf$Contract() {
        this.c = (byte) -1;
        this.d = -1;
        this.f5039a = AbstractC0244e.f769a;
    }

    public ProtoBuf$Contract(C0245f c0245f, H8.h hVar) {
        this.c = (byte) -1;
        this.d = -1;
        this.b = Collections.EMPTY_LIST;
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
                            if (!z11) {
                                this.b = new ArrayList();
                                z11 = true;
                            }
                            this.b.add(c0245f.g(ProtoBuf$Effect.f5040j, hVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (z11) {
                        this.b = Collections.unmodifiableList(this.b);
                    }
                    try {
                        dVarN.m();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f5039a = c0243d.f();
                        throw th2;
                    }
                    this.f5039a = c0243d.f();
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
            this.b = Collections.unmodifiableList(this.b);
        }
        try {
            dVarN.m();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f5039a = c0243d.f();
            throw th3;
        }
        this.f5039a = c0243d.f();
    }
}
