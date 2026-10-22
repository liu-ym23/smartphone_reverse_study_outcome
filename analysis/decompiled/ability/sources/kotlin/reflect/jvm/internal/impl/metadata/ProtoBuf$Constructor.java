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
public final class ProtoBuf$Constructor extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Constructor> {
    public static final ProtoBuf$Constructor i;

    /* renamed from: j, reason: collision with root package name */
    public static final B8.a f5038j = new B8.a(2);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public List e;
    public List f;
    public byte g;
    public int h;

    static {
        ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor();
        i = protoBuf$Constructor;
        protoBuf$Constructor.d = 6;
        List list = Collections.EMPTY_LIST;
        protoBuf$Constructor.e = list;
        protoBuf$Constructor.f = list;
    }

    public ProtoBuf$Constructor(B8.c cVar) {
        super(cVar);
        this.g = (byte) -1;
        this.h = -1;
        this.b = cVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i6 = this.h;
        if (i6 != -1) {
            return i6;
        }
        int iF = (this.c & 1) == 1 ? A0.d.f(1, this.d) : 0;
        for (int i10 = 0; i10 < this.e.size(); i10++) {
            iF += A0.d.h(2, (AbstractC0241b) this.e.get(i10));
        }
        int iG = 0;
        for (int i11 = 0; i11 < this.f.size(); i11++) {
            iG += A0.d.g(((Integer) this.f.get(i11)).intValue());
        }
        int size = this.b.size() + h() + (this.f.size() * 2) + iF + iG;
        this.h = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.c.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.c cVarF = B8.c.f();
        cVarF.h(this);
        return cVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 1) == 1) {
            dVar.q(1, this.d);
        }
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            dVar.s(2, (AbstractC0241b) this.e.get(i6));
        }
        for (int i10 = 0; i10 < this.f.size(); i10++) {
            dVar.q(31, ((Integer) this.f.get(i10)).intValue());
        }
        bVar.a(19000, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return i;
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
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            if (!((ProtoBuf$ValueParameter) this.e.get(i6)).isInitialized()) {
                this.g = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.g = (byte) 1;
            return true;
        }
        this.g = (byte) 0;
        return false;
    }

    public ProtoBuf$Constructor() {
        this.g = (byte) -1;
        this.h = -1;
        this.b = AbstractC0244e.f769a;
    }

    public ProtoBuf$Constructor(C0245f c0245f, H8.h hVar) {
        this.g = (byte) -1;
        this.h = -1;
        this.d = 6;
        List list = Collections.EMPTY_LIST;
        this.e = list;
        this.f = list;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        int i6 = 0;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = c0245f.k();
                        } else if (iN == 18) {
                            if ((i6 & 2) != 2) {
                                this.e = new ArrayList();
                                i6 |= 2;
                            }
                            this.e.add(c0245f.g(ProtoBuf$ValueParameter.m, hVar));
                        } else if (iN == 248) {
                            if ((i6 & 4) != 4) {
                                this.f = new ArrayList();
                                i6 |= 4;
                            }
                            this.f.add(Integer.valueOf(c0245f.k()));
                        } else if (iN != 250) {
                            if (!l(c0245f, dVarN, hVar, iN)) {
                            }
                        } else {
                            int iD = c0245f.d(c0245f.k());
                            if ((i6 & 4) != 4 && c0245f.b() > 0) {
                                this.f = new ArrayList();
                                i6 |= 4;
                            }
                            while (c0245f.b() > 0) {
                                this.f.add(Integer.valueOf(c0245f.k()));
                            }
                            c0245f.c(iD);
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i6 & 2) == 2) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    if ((i6 & 4) == 4) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
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
        if ((i6 & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        if ((i6 & 4) == 4) {
            this.f = Collections.unmodifiableList(this.f);
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
