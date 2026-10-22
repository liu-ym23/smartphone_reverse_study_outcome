package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import H8.C0243d;
import H8.C0245f;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* loaded from: classes4.dex */
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> {
    public static final ProtoBuf$Function u;

    /* renamed from: v, reason: collision with root package name */
    public static final B8.a f5047v = new B8.a(7);
    public final AbstractC0244e b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ProtoBuf$Type g;
    public int h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public ProtoBuf$Type f5048j;
    public int k;
    public List l;
    public List m;
    public int n;
    public List o;
    public ProtoBuf$TypeTable p;

    /* renamed from: q, reason: collision with root package name */
    public List f5049q;

    /* renamed from: r, reason: collision with root package name */
    public ProtoBuf$Contract f5050r;

    /* renamed from: s, reason: collision with root package name */
    public byte f5051s;

    /* renamed from: t, reason: collision with root package name */
    public int f5052t;

    static {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function();
        u = protoBuf$Function;
        protoBuf$Function.n();
    }

    public ProtoBuf$Function(B8.f fVar) {
        super(fVar);
        this.n = -1;
        this.f5051s = (byte) -1;
        this.f5052t = -1;
        this.b = fVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f5052t;
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
            iF += A0.d.h(5, this.f5048j);
        }
        for (int i10 = 0; i10 < this.o.size(); i10++) {
            iF += A0.d.h(6, (AbstractC0241b) this.o.get(i10));
        }
        if ((this.c & 16) == 16) {
            iF += A0.d.f(7, this.h);
        }
        if ((this.c & 64) == 64) {
            iF += A0.d.f(8, this.k);
        }
        if ((this.c & 1) == 1) {
            iF += A0.d.f(9, this.d);
        }
        for (int i11 = 0; i11 < this.l.size(); i11++) {
            iF += A0.d.h(10, (AbstractC0241b) this.l.get(i11));
        }
        int iG = 0;
        for (int i12 = 0; i12 < this.m.size(); i12++) {
            iG += A0.d.g(((Integer) this.m.get(i12)).intValue());
        }
        int iH = iF + iG;
        if (!this.m.isEmpty()) {
            iH = iH + 1 + A0.d.g(iG);
        }
        this.n = iG;
        if ((this.c & 128) == 128) {
            iH += A0.d.h(30, this.p);
        }
        int iG2 = 0;
        for (int i13 = 0; i13 < this.f5049q.size(); i13++) {
            iG2 += A0.d.g(((Integer) this.f5049q.get(i13)).intValue());
        }
        int size = (this.f5049q.size() * 2) + iH + iG2;
        if ((this.c & 256) == 256) {
            size += A0.d.h(32, this.f5050r);
        }
        int size2 = this.b.size() + h() + size;
        this.f5052t = size2;
        return size2;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.f.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.f fVarF = B8.f.f();
        fVarF.h(this);
        return fVarF;
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
            dVar.s(5, this.f5048j);
        }
        for (int i6 = 0; i6 < this.o.size(); i6++) {
            dVar.s(6, (AbstractC0241b) this.o.get(i6));
        }
        if ((this.c & 16) == 16) {
            dVar.q(7, this.h);
        }
        if ((this.c & 64) == 64) {
            dVar.q(8, this.k);
        }
        if ((this.c & 1) == 1) {
            dVar.q(9, this.d);
        }
        for (int i10 = 0; i10 < this.l.size(); i10++) {
            dVar.s(10, (AbstractC0241b) this.l.get(i10));
        }
        if (this.m.size() > 0) {
            dVar.z(90);
            dVar.z(this.n);
        }
        for (int i11 = 0; i11 < this.m.size(); i11++) {
            dVar.r(((Integer) this.m.get(i11)).intValue());
        }
        if ((this.c & 128) == 128) {
            dVar.s(30, this.p);
        }
        for (int i12 = 0; i12 < this.f5049q.size(); i12++) {
            dVar.q(31, ((Integer) this.f5049q.get(i12)).intValue());
        }
        if ((this.c & 256) == 256) {
            dVar.s(32, this.f5050r);
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
        byte b = this.f5051s;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 4) != 4) {
            this.f5051s = (byte) 0;
            return false;
        }
        if ((i & 8) == 8 && !this.g.isInitialized()) {
            this.f5051s = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            if (!((ProtoBuf$TypeParameter) this.i.get(i6)).isInitialized()) {
                this.f5051s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 32) == 32 && !this.f5048j.isInitialized()) {
            this.f5051s = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.l.size(); i10++) {
            if (!((ProtoBuf$Type) this.l.get(i10)).isInitialized()) {
                this.f5051s = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < this.o.size(); i11++) {
            if (!((ProtoBuf$ValueParameter) this.o.get(i11)).isInitialized()) {
                this.f5051s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 128) == 128 && !this.p.isInitialized()) {
            this.f5051s = (byte) 0;
            return false;
        }
        if ((this.c & 256) == 256 && !this.f5050r.isInitialized()) {
            this.f5051s = (byte) 0;
            return false;
        }
        if (g()) {
            this.f5051s = (byte) 1;
            return true;
        }
        this.f5051s = (byte) 0;
        return false;
    }

    public final void n() {
        this.d = 6;
        this.e = 6;
        this.f = 0;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.f5067t;
        this.g = protoBuf$Type;
        this.h = 0;
        List list = Collections.EMPTY_LIST;
        this.i = list;
        this.f5048j = protoBuf$Type;
        this.k = 0;
        this.l = list;
        this.m = list;
        this.o = list;
        this.p = ProtoBuf$TypeTable.g;
        this.f5049q = list;
        this.f5050r = ProtoBuf$Contract.e;
    }

    public ProtoBuf$Function() {
        this.n = -1;
        this.f5051s = (byte) -1;
        this.f5052t = -1;
        this.b = AbstractC0244e.f769a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public ProtoBuf$Function(C0245f c0245f, H8.h hVar) {
        this.n = -1;
        this.f5051s = (byte) -1;
        this.f5052t = -1;
        n();
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        char c = 0;
        while (true) {
            ?? L4 = 1024;
            if (!z10) {
                try {
                    try {
                        int iN = c0245f.n();
                        m mVarO = null;
                        B8.d dVar = null;
                        B8.k kVarG = null;
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
                                    ProtoBuf$Type protoBuf$Type3 = this.f5048j;
                                    protoBuf$Type3.getClass();
                                    mVarO2 = ProtoBuf$Type.o(protoBuf$Type3);
                                }
                                ProtoBuf$Type protoBuf$Type4 = (ProtoBuf$Type) c0245f.g(ProtoBuf$Type.u, hVar);
                                this.f5048j = protoBuf$Type4;
                                if (mVarO2 != null) {
                                    mVarO2.h(protoBuf$Type4);
                                    this.f5048j = mVarO2.e();
                                }
                                this.c |= 32;
                            case 50:
                                int i6 = (c == true ? 1 : 0) & 1024;
                                c = c;
                                if (i6 != 1024) {
                                    this.o = new ArrayList();
                                    c = (c == true ? 1 : 0) | 1024;
                                }
                                this.o.add(c0245f.g(ProtoBuf$ValueParameter.m, hVar));
                            case 56:
                                this.c |= 16;
                                this.h = c0245f.k();
                            case 64:
                                this.c |= 64;
                                this.k = c0245f.k();
                            case 72:
                                this.c |= 1;
                                this.d = c0245f.k();
                            case 82:
                                int i10 = (c == true ? 1 : 0) & 256;
                                c = c;
                                if (i10 != 256) {
                                    this.l = new ArrayList();
                                    c = (c == true ? 1 : 0) | 256;
                                }
                                this.l.add(c0245f.g(ProtoBuf$Type.u, hVar));
                            case 88:
                                int i11 = (c == true ? 1 : 0) & 512;
                                c = c;
                                if (i11 != 512) {
                                    this.m = new ArrayList();
                                    c = (c == true ? 1 : 0) | 512;
                                }
                                this.m.add(Integer.valueOf(c0245f.k()));
                            case 90:
                                int iD = c0245f.d(c0245f.k());
                                int i12 = (c == true ? 1 : 0) & 512;
                                c = c;
                                if (i12 != 512) {
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
                            case 242:
                                if ((this.c & 128) == 128) {
                                    ProtoBuf$TypeTable protoBuf$TypeTable = this.p;
                                    protoBuf$TypeTable.getClass();
                                    kVarG = ProtoBuf$TypeTable.g(protoBuf$TypeTable);
                                }
                                ProtoBuf$TypeTable protoBuf$TypeTable2 = (ProtoBuf$TypeTable) c0245f.g(ProtoBuf$TypeTable.h, hVar);
                                this.p = protoBuf$TypeTable2;
                                if (kVarG != null) {
                                    kVarG.f(protoBuf$TypeTable2);
                                    this.p = kVarG.d();
                                }
                                this.c |= 128;
                            case 248:
                                int i13 = (c == true ? 1 : 0) & 4096;
                                c = c;
                                if (i13 != 4096) {
                                    this.f5049q = new ArrayList();
                                    c = (c == true ? 1 : 0) | 4096;
                                }
                                this.f5049q.add(Integer.valueOf(c0245f.k()));
                            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                int iD2 = c0245f.d(c0245f.k());
                                int i14 = (c == true ? 1 : 0) & 4096;
                                c = c;
                                if (i14 != 4096) {
                                    c = c;
                                    if (c0245f.b() > 0) {
                                        this.f5049q = new ArrayList();
                                        c = (c == true ? 1 : 0) | 4096;
                                    }
                                }
                                while (c0245f.b() > 0) {
                                    this.f5049q.add(Integer.valueOf(c0245f.k()));
                                }
                                c0245f.c(iD2);
                            case 258:
                                if ((this.c & 256) == 256) {
                                    ProtoBuf$Contract protoBuf$Contract = this.f5050r;
                                    protoBuf$Contract.getClass();
                                    dVar = new B8.d(0);
                                    dVar.d = Collections.EMPTY_LIST;
                                    dVar.h(protoBuf$Contract);
                                }
                                ProtoBuf$Contract protoBuf$Contract2 = (ProtoBuf$Contract) c0245f.g(ProtoBuf$Contract.f, hVar);
                                this.f5050r = protoBuf$Contract2;
                                if (dVar != null) {
                                    dVar.h(protoBuf$Contract2);
                                    this.f5050r = dVar.d();
                                }
                                this.c |= 256;
                            default:
                                L4 = l(c0245f, dVarN, hVar, iN);
                                if (L4 == 0) {
                                    z10 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        e.f5100a = this;
                        throw e;
                    } catch (IOException e6) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e6.getMessage());
                        invalidProtocolBufferException.f5100a = this;
                        throw invalidProtocolBufferException;
                    }
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (((c == true ? 1 : 0) & 1024) == L4) {
                        this.o = Collections.unmodifiableList(this.o);
                    }
                    if (((c == true ? 1 : 0) & 256) == 256) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    if (((c == true ? 1 : 0) & 512) == 512) {
                        this.m = Collections.unmodifiableList(this.m);
                    }
                    if (((c == true ? 1 : 0) & 4096) == 4096) {
                        this.f5049q = Collections.unmodifiableList(this.f5049q);
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
                if (((c == true ? 1 : 0) & 1024) == 1024) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if (((c == true ? 1 : 0) & 256) == 256) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                if (((c == true ? 1 : 0) & 512) == 512) {
                    this.m = Collections.unmodifiableList(this.m);
                }
                if (((c == true ? 1 : 0) & 4096) == 4096) {
                    this.f5049q = Collections.unmodifiableList(this.f5049q);
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
