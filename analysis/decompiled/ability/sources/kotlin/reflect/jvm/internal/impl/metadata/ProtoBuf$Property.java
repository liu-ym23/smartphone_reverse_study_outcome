package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import androidx.core.location.LocationRequestCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes4.dex */
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> {
    public static final ProtoBuf$Property u;

    /* renamed from: v, reason: collision with root package name */
    public static final B8.a f5057v = new B8.a(10);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ProtoBuf$Type g;
    public int h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public ProtoBuf$Type f5058j;
    public int k;
    public List l;
    public List m;
    public int n;
    public ProtoBuf$ValueParameter o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f5059q;

    /* renamed from: r, reason: collision with root package name */
    public List f5060r;

    /* renamed from: s, reason: collision with root package name */
    public byte f5061s;

    /* renamed from: t, reason: collision with root package name */
    public int f5062t;

    static {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property();
        u = protoBuf$Property;
        protoBuf$Property.n();
    }

    public ProtoBuf$Property(B8.i iVar) {
        super(iVar);
        this.n = -1;
        this.f5061s = (byte) -1;
        this.f5062t = -1;
        this.b = iVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f5062t;
        if (i != -1) {
            return i;
        }
        int iF = (this.c & 2) == 2 ? A0.d.f(1, this.e) : 0;
        if ((this.c & 4) == 4) {
            iF += A0.d.f(2, this.f);
        }
        if ((this.c & 8) == 8) {
            iF += A0.d.h(3, this.g);
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            iF += A0.d.h(4, (AbstractC0241b) this.i.get(i6));
        }
        if ((this.c & 32) == 32) {
            iF += A0.d.h(5, this.f5058j);
        }
        if ((this.c & 128) == 128) {
            iF += A0.d.h(6, this.o);
        }
        if ((this.c & 256) == 256) {
            iF += A0.d.f(7, this.p);
        }
        if ((this.c & 512) == 512) {
            iF += A0.d.f(8, this.f5059q);
        }
        if ((this.c & 16) == 16) {
            iF += A0.d.f(9, this.h);
        }
        if ((this.c & 64) == 64) {
            iF += A0.d.f(10, this.k);
        }
        if ((this.c & 1) == 1) {
            iF += A0.d.f(11, this.d);
        }
        for (int i10 = 0; i10 < this.l.size(); i10++) {
            iF += A0.d.h(12, (AbstractC0241b) this.l.get(i10));
        }
        int iG = 0;
        for (int i11 = 0; i11 < this.m.size(); i11++) {
            iG += A0.d.g(((Integer) this.m.get(i11)).intValue());
        }
        int iG2 = iF + iG;
        if (!this.m.isEmpty()) {
            iG2 = iG2 + 1 + A0.d.g(iG);
        }
        this.n = iG;
        int iG3 = 0;
        for (int i12 = 0; i12 < this.f5060r.size(); i12++) {
            iG3 += A0.d.g(((Integer) this.f5060r.get(i12)).intValue());
        }
        int size = this.b.size() + h() + (this.f5060r.size() * 2) + iG2 + iG3;
        this.f5062t = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.i.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.i iVarF = B8.i.f();
        iVarF.h(this);
        return iVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 2) == 2) {
            dVar.q(1, this.e);
        }
        if ((this.c & 4) == 4) {
            dVar.q(2, this.f);
        }
        if ((this.c & 8) == 8) {
            dVar.s(3, this.g);
        }
        for (int i = 0; i < this.i.size(); i++) {
            dVar.s(4, (AbstractC0241b) this.i.get(i));
        }
        if ((this.c & 32) == 32) {
            dVar.s(5, this.f5058j);
        }
        if ((this.c & 128) == 128) {
            dVar.s(6, this.o);
        }
        if ((this.c & 256) == 256) {
            dVar.q(7, this.p);
        }
        if ((this.c & 512) == 512) {
            dVar.q(8, this.f5059q);
        }
        if ((this.c & 16) == 16) {
            dVar.q(9, this.h);
        }
        if ((this.c & 64) == 64) {
            dVar.q(10, this.k);
        }
        if ((this.c & 1) == 1) {
            dVar.q(11, this.d);
        }
        for (int i6 = 0; i6 < this.l.size(); i6++) {
            dVar.s(12, (AbstractC0241b) this.l.get(i6));
        }
        if (this.m.size() > 0) {
            dVar.z(106);
            dVar.z(this.n);
        }
        for (int i10 = 0; i10 < this.m.size(); i10++) {
            dVar.r(((Integer) this.m.get(i10)).intValue());
        }
        for (int i11 = 0; i11 < this.f5060r.size(); i11++) {
            dVar.q(31, ((Integer) this.f5060r.get(i11)).intValue());
        }
        bVar.a(19000, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return u;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.f5061s;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 4) != 4) {
            this.f5061s = (byte) 0;
            return false;
        }
        if ((i & 8) == 8 && !this.g.isInitialized()) {
            this.f5061s = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            if (!((ProtoBuf$TypeParameter) this.i.get(i6)).isInitialized()) {
                this.f5061s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 32) == 32 && !this.f5058j.isInitialized()) {
            this.f5061s = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.l.size(); i10++) {
            if (!((ProtoBuf$Type) this.l.get(i10)).isInitialized()) {
                this.f5061s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 128) == 128 && !this.o.isInitialized()) {
            this.f5061s = (byte) 0;
            return false;
        }
        if (g()) {
            this.f5061s = (byte) 1;
            return true;
        }
        this.f5061s = (byte) 0;
        return false;
    }

    public final void n() {
        this.d = 518;
        this.e = 2054;
        this.f = 0;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        this.g = protoBuf$Type;
        this.h = 0;
        List list = Collections.EMPTY_LIST;
        this.i = list;
        this.f5058j = protoBuf$Type;
        this.k = 0;
        this.l = list;
        this.m = list;
        this.o = ProtoBuf$ValueParameter.l;
        this.p = 0;
        this.f5059q = 0;
        this.f5060r = list;
    }

    public ProtoBuf$Property() {
        this.n = -1;
        this.f5061s = (byte) -1;
        this.f5062t = -1;
        this.b = AbstractC0244e.f769a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public ProtoBuf$Property(C0245f c0245f, H8.h hVar) {
        this.n = -1;
        this.f5061s = (byte) -1;
        this.f5062t = -1;
        n();
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        char c = 0;
        while (true) {
            ?? L4 = 256;
            if (!z10) {
                try {
                    try {
                        try {
                            int iN = c0245f.n();
                            m mVarO = null;
                            B8.l lVar = null;
                            m mVarO2 = null;
                            switch (iN) {
                                case 0:
                                    z10 = true;
                                case 8:
                                    this.c |= 2;
                                    this.e = c0245f.k();
                                case 16:
                                    this.c |= 4;
                                    this.f = c0245f.k();
                                case 26:
                                    if ((this.c & 8) == 8) {
                                        ProtoBuf$Type protoBuf$Type = this.g;
                                        protoBuf$Type.getClass();
                                        mVarO = ProtoBuf$Type.o(protoBuf$Type);
                                    }
                                    ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                    this.g = protoBuf$Type2;
                                    if (mVarO != null) {
                                        mVarO.h(protoBuf$Type2);
                                        this.g = mVarO.e();
                                    }
                                    this.c |= 8;
                                case 34:
                                    int i = (c == true ? 1 : 0) & 32;
                                    c = c;
                                    if (i != 32) {
                                        this.i = new ArrayList();
                                        c = (c == true ? 1 : 0) | ' ';
                                    }
                                    this.i.add(c0245f.g(ProtoBuf$TypeParameter.n, hVar));
                                case 42:
                                    if ((this.c & 32) == 32) {
                                        ProtoBuf$Type protoBuf$Type3 = this.f5058j;
                                        protoBuf$Type3.getClass();
                                        mVarO2 = ProtoBuf$Type.o(protoBuf$Type3);
                                    }
                                    ProtoBuf$Type protoBuf$Type4 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                    this.f5058j = protoBuf$Type4;
                                    if (mVarO2 != null) {
                                        mVarO2.h(protoBuf$Type4);
                                        this.f5058j = mVarO2.e();
                                    }
                                    this.c |= 32;
                                case 50:
                                    if ((this.c & 128) == 128) {
                                        ProtoBuf$ValueParameter protoBuf$ValueParameter = this.o;
                                        protoBuf$ValueParameter.getClass();
                                        lVar = new B8.l();
                                        ProtoBuf$Type protoBuf$Type5 = ProtoBuf$Type.f5067t;
                                        lVar.g = protoBuf$Type5;
                                        lVar.i = protoBuf$Type5;
                                        lVar.f(protoBuf$ValueParameter);
                                    }
                                    ProtoBuf$ValueParameter protoBuf$ValueParameter2 = (ProtoBuf$ValueParameter) c0245f.g(ProtoBuf$ValueParameter.m, hVar);
                                    this.o = protoBuf$ValueParameter2;
                                    if (lVar != null) {
                                        lVar.f(protoBuf$ValueParameter2);
                                        this.o = lVar.e();
                                    }
                                    this.c |= 128;
                                case 56:
                                    this.c |= 256;
                                    this.p = c0245f.k();
                                case 64:
                                    this.c |= 512;
                                    this.f5059q = c0245f.k();
                                case 72:
                                    this.c |= 16;
                                    this.h = c0245f.k();
                                case WebSocketImpl.DEFAULT_PORT /* 80 */:
                                    this.c |= 64;
                                    this.k = c0245f.k();
                                case 88:
                                    this.c |= 1;
                                    this.d = c0245f.k();
                                case 98:
                                    int i6 = (c == true ? 1 : 0) & 256;
                                    c = c;
                                    if (i6 != 256) {
                                        this.l = new ArrayList();
                                        c = (c == true ? 1 : 0) | 256;
                                    }
                                    this.l.add(c0245f.g(ProtoBuf$Type.u, hVar));
                                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                                    int i10 = (c == true ? 1 : 0) & 512;
                                    c = c;
                                    if (i10 != 512) {
                                        this.m = new ArrayList();
                                        c = (c == true ? 1 : 0) | 512;
                                    }
                                    this.m.add(Integer.valueOf(c0245f.k()));
                                case 106:
                                    int iD = c0245f.d(c0245f.k());
                                    int i11 = (c == true ? 1 : 0) & 512;
                                    c = c;
                                    if (i11 != 512) {
                                        c = c;
                                        if (c0245f.b() > 0) {
                                            this.m = new ArrayList();
                                            c = (c == true ? 1 : 0) | 512;
                                        }
                                    }
                                    while (c0245f.b() > 0) {
                                        this.m.add(Integer.valueOf(c0245f.k()));
                                    }
                                    c0245f.c(iD);
                                case 248:
                                    int i12 = (c == true ? 1 : 0) & 8192;
                                    c = c;
                                    if (i12 != 8192) {
                                        this.f5060r = new ArrayList();
                                        c = (c == true ? 1 : 0) | 8192;
                                    }
                                    this.f5060r.add(Integer.valueOf(c0245f.k()));
                                case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                    int iD2 = c0245f.d(c0245f.k());
                                    int i13 = (c == true ? 1 : 0) & 8192;
                                    c = c;
                                    if (i13 != 8192) {
                                        c = c;
                                        if (c0245f.b() > 0) {
                                            this.f5060r = new ArrayList();
                                            c = (c == true ? 1 : 0) | 8192;
                                        }
                                    }
                                    while (c0245f.b() > 0) {
                                        this.f5060r.add(Integer.valueOf(c0245f.k()));
                                    }
                                    c0245f.c(iD2);
                                default:
                                    L4 = l(c0245f, dVarN, hVar, iN);
                                    if (L4 == 0) {
                                        z10 = true;
                                    }
                            }
                        } catch (IOException e) {
                            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e.getMessage());
                            invalidProtocolBufferException.f5100a = this;
                            throw invalidProtocolBufferException;
                        }
                    } catch (InvalidProtocolBufferException e6) {
                        e6.f5100a = this;
                        throw e6;
                    }
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (((c == true ? 1 : 0) & 256) == L4) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    if (((c == true ? 1 : 0) & 512) == 512) {
                        this.m = Collections.unmodifiableList(this.m);
                    }
                    if (((c == true ? 1 : 0) & 8192) == 8192) {
                        this.f5060r = Collections.unmodifiableList(this.f5060r);
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
            } else {
                if (((c == true ? 1 : 0) & 32) == 32) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                if (((c == true ? 1 : 0) & 256) == 256) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                if (((c == true ? 1 : 0) & 512) == 512) {
                    this.m = Collections.unmodifiableList(this.m);
                }
                if (((c == true ? 1 : 0) & 8192) == 8192) {
                    this.f5060r = Collections.unmodifiableList(this.f5060r);
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
