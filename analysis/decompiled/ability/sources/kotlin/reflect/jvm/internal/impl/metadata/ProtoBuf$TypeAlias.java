package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeAlias> {
    public static final ProtoBuf$TypeAlias o;
    public static final B8.a p = new B8.a(14);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public int e;
    public List f;
    public ProtoBuf$Type g;
    public int h;
    public ProtoBuf$Type i;

    /* renamed from: j, reason: collision with root package name */
    public int f5074j;
    public List k;
    public List l;
    public byte m;
    public int n;

    static {
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias();
        o = protoBuf$TypeAlias;
        protoBuf$TypeAlias.d = 6;
        protoBuf$TypeAlias.e = 0;
        List list = Collections.EMPTY_LIST;
        protoBuf$TypeAlias.f = list;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        protoBuf$TypeAlias.g = protoBuf$Type;
        protoBuf$TypeAlias.h = 0;
        protoBuf$TypeAlias.i = protoBuf$Type;
        protoBuf$TypeAlias.f5074j = 0;
        protoBuf$TypeAlias.k = list;
        protoBuf$TypeAlias.l = list;
    }

    public ProtoBuf$TypeAlias(B8.j jVar) {
        super(jVar);
        this.m = (byte) -1;
        this.n = -1;
        this.b = jVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.n;
        if (i != -1) {
            return i;
        }
        int iF = (this.c & 1) == 1 ? A0.d.f(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iF += A0.d.f(2, this.e);
        }
        for (int i6 = 0; i6 < this.f.size(); i6++) {
            iF += A0.d.h(3, (AbstractC0241b) this.f.get(i6));
        }
        if ((this.c & 4) == 4) {
            iF += A0.d.h(4, this.g);
        }
        if ((this.c & 8) == 8) {
            iF += A0.d.f(5, this.h);
        }
        if ((this.c & 16) == 16) {
            iF += A0.d.h(6, this.i);
        }
        if ((this.c & 32) == 32) {
            iF += A0.d.f(7, this.f5074j);
        }
        for (int i10 = 0; i10 < this.k.size(); i10++) {
            iF += A0.d.h(8, (AbstractC0241b) this.k.get(i10));
        }
        int iG = 0;
        for (int i11 = 0; i11 < this.l.size(); i11++) {
            iG += A0.d.g(((Integer) this.l.get(i11)).intValue());
        }
        int size = this.b.size() + h() + (this.l.size() * 2) + iF + iG;
        this.n = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.j.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.j jVarF = B8.j.f();
        jVarF.h(this);
        return jVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 1) == 1) {
            dVar.q(1, this.d);
        }
        if ((this.c & 2) == 2) {
            dVar.q(2, this.e);
        }
        for (int i = 0; i < this.f.size(); i++) {
            dVar.s(3, (AbstractC0241b) this.f.get(i));
        }
        if ((this.c & 4) == 4) {
            dVar.s(4, this.g);
        }
        if ((this.c & 8) == 8) {
            dVar.q(5, this.h);
        }
        if ((this.c & 16) == 16) {
            dVar.s(6, this.i);
        }
        if ((this.c & 32) == 32) {
            dVar.q(7, this.f5074j);
        }
        for (int i6 = 0; i6 < this.k.size(); i6++) {
            dVar.s(8, (AbstractC0241b) this.k.get(i6));
        }
        for (int i10 = 0; i10 < this.l.size(); i10++) {
            dVar.q(31, ((Integer) this.l.get(i10)).intValue());
        }
        bVar.a(200, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return o;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.m;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.c & 2) != 2) {
            this.m = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!((ProtoBuf$TypeParameter) this.f.get(i)).isInitialized()) {
                this.m = (byte) 0;
                return false;
            }
        }
        if ((this.c & 4) == 4 && !this.g.isInitialized()) {
            this.m = (byte) 0;
            return false;
        }
        if ((this.c & 16) == 16 && !this.i.isInitialized()) {
            this.m = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < this.k.size(); i6++) {
            if (!((ProtoBuf$Annotation) this.k.get(i6)).isInitialized()) {
                this.m = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.m = (byte) 1;
            return true;
        }
        this.m = (byte) 0;
        return false;
    }

    public ProtoBuf$TypeAlias() {
        this.m = (byte) -1;
        this.n = -1;
        this.b = AbstractC0244e.f769a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public ProtoBuf$TypeAlias(C0245f c0245f, H8.h hVar) {
        this.m = (byte) -1;
        this.n = -1;
        this.d = 6;
        boolean z10 = false;
        this.e = 0;
        List list = Collections.EMPTY_LIST;
        this.f = list;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        this.g = protoBuf$Type;
        this.h = 0;
        this.i = protoBuf$Type;
        this.f5074j = 0;
        this.k = list;
        this.l = list;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        int i = 0;
        while (true) {
            ?? L4 = 128;
            if (!z10) {
                try {
                    try {
                        int iN = c0245f.n();
                        m mVarO = null;
                        switch (iN) {
                            case 0:
                                z10 = true;
                            case 8:
                                this.c |= 1;
                                this.d = c0245f.k();
                            case 16:
                                this.c |= 2;
                                this.e = c0245f.k();
                            case 26:
                                if ((i & 4) != 4) {
                                    this.f = new ArrayList();
                                    i |= 4;
                                }
                                this.f.add(c0245f.g(ProtoBuf$TypeParameter.n, hVar));
                            case 34:
                                if ((this.c & 4) == 4) {
                                    ProtoBuf$Type protoBuf$Type2 = this.g;
                                    protoBuf$Type2.getClass();
                                    mVarO = ProtoBuf$Type.o(protoBuf$Type2);
                                }
                                ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                this.g = protoBuf$Type3;
                                if (mVarO != null) {
                                    mVarO.h(protoBuf$Type3);
                                    this.g = mVarO.e();
                                }
                                this.c |= 4;
                            case 40:
                                this.c |= 8;
                                this.h = c0245f.k();
                            case 50:
                                if ((this.c & 16) == 16) {
                                    ProtoBuf$Type protoBuf$Type4 = this.i;
                                    protoBuf$Type4.getClass();
                                    mVarO = ProtoBuf$Type.o(protoBuf$Type4);
                                }
                                ProtoBuf$Type protoBuf$Type5 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                this.i = protoBuf$Type5;
                                if (mVarO != null) {
                                    mVarO.h(protoBuf$Type5);
                                    this.i = mVarO.e();
                                }
                                this.c |= 16;
                            case 56:
                                this.c |= 32;
                                this.f5074j = c0245f.k();
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if ((i & 128) != 128) {
                                    this.k = new ArrayList();
                                    i |= 128;
                                }
                                this.k.add(c0245f.g(ProtoBuf$Annotation.h, hVar));
                            case 248:
                                if ((i & 256) != 256) {
                                    this.l = new ArrayList();
                                    i |= 256;
                                }
                                this.l.add(Integer.valueOf(c0245f.k()));
                            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                int iD = c0245f.d(c0245f.k());
                                if ((i & 256) != 256 && c0245f.b() > 0) {
                                    this.l = new ArrayList();
                                    i |= 256;
                                }
                                while (c0245f.b() > 0) {
                                    this.l.add(Integer.valueOf(c0245f.k()));
                                }
                                c0245f.c(iD);
                                break;
                            default:
                                L4 = l(c0245f, dVarN, hVar, iN);
                                if (L4 == 0) {
                                    z10 = true;
                                }
                        }
                    } catch (Throwable th) {
                        if ((i & 4) == 4) {
                            this.f = Collections.unmodifiableList(this.f);
                        }
                        if ((i & 128) == L4) {
                            this.k = Collections.unmodifiableList(this.k);
                        }
                        if ((i & 256) == 256) {
                            this.l = Collections.unmodifiableList(this.l);
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
            } else {
                if ((i & 4) == 4) {
                    this.f = Collections.unmodifiableList(this.f);
                }
                if ((i & 128) == 128) {
                    this.k = Collections.unmodifiableList(this.k);
                }
                if ((i & 256) == 256) {
                    this.l = Collections.unmodifiableList(this.l);
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
                return;
            }
        }
    }
}
