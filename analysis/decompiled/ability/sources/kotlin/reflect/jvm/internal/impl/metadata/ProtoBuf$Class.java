package kotlin.reflect.jvm.internal.impl.metadata;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes4.dex */
public final class ProtoBuf$Class extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Class> {

    /* renamed from: N, reason: collision with root package name */
    public static final ProtoBuf$Class f5018N;

    /* renamed from: O, reason: collision with root package name */
    public static final B8.a f5019O = new B8.a(1);

    /* renamed from: A, reason: collision with root package name */
    public int f5020A;

    /* renamed from: B, reason: collision with root package name */
    public List f5021B;

    /* renamed from: C, reason: collision with root package name */
    public List f5022C;

    /* renamed from: D, reason: collision with root package name */
    public int f5023D;
    public ProtoBuf$TypeTable E;

    /* renamed from: F, reason: collision with root package name */
    public List f5024F;

    /* renamed from: G, reason: collision with root package name */
    public ProtoBuf$VersionRequirementTable f5025G;

    /* renamed from: L, reason: collision with root package name */
    public byte f5026L;

    /* renamed from: M, reason: collision with root package name */
    public int f5027M;
    public final AbstractC0244e b;
    public int c;
    public int d;
    public int e;
    public int f;
    public List g;
    public List h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public int f5028j;
    public List k;
    public int l;
    public List m;
    public List n;
    public int o;
    public List p;

    /* renamed from: q, reason: collision with root package name */
    public List f5029q;

    /* renamed from: r, reason: collision with root package name */
    public List f5030r;

    /* renamed from: s, reason: collision with root package name */
    public List f5031s;

    /* renamed from: t, reason: collision with root package name */
    public List f5032t;
    public List u;

    /* renamed from: v, reason: collision with root package name */
    public int f5033v;

    /* renamed from: w, reason: collision with root package name */
    public int f5034w;

    /* renamed from: x, reason: collision with root package name */
    public ProtoBuf$Type f5035x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public List f5036z;

    public enum Kind implements H8.m {
        CLASS(0),
        INTERFACE(1),
        ENUM_CLASS(2),
        /* JADX INFO: Fake field, exist only in values array */
        ENUM_ENTRY(3),
        ANNOTATION_CLASS(4),
        /* JADX INFO: Fake field, exist only in values array */
        OBJECT(5),
        COMPANION_OBJECT(6);


        /* renamed from: a, reason: collision with root package name */
        public final int f5037a;

        Kind(int i) {
            this.f5037a = i;
        }

        @Override // H8.m
        public final int getNumber() {
            return this.f5037a;
        }
    }

    static {
        ProtoBuf$Class protoBuf$Class = new ProtoBuf$Class();
        f5018N = protoBuf$Class;
        protoBuf$Class.n();
    }

    public ProtoBuf$Class(B8.b bVar) {
        super(bVar);
        this.f5028j = -1;
        this.l = -1;
        this.o = -1;
        this.f5033v = -1;
        this.f5020A = -1;
        this.f5023D = -1;
        this.f5026L = (byte) -1;
        this.f5027M = -1;
        this.b = bVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f5027M;
        if (i != -1) {
            return i;
        }
        int iF = (this.c & 1) == 1 ? A0.d.f(1, this.d) : 0;
        int iG = 0;
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            iG += A0.d.g(((Integer) this.i.get(i6)).intValue());
        }
        int iH = iF + iG;
        if (!this.i.isEmpty()) {
            iH = iH + 1 + A0.d.g(iG);
        }
        this.f5028j = iG;
        if ((this.c & 2) == 2) {
            iH += A0.d.f(3, this.e);
        }
        if ((this.c & 4) == 4) {
            iH += A0.d.f(4, this.f);
        }
        for (int i10 = 0; i10 < this.g.size(); i10++) {
            iH += A0.d.h(5, (AbstractC0241b) this.g.get(i10));
        }
        for (int i11 = 0; i11 < this.h.size(); i11++) {
            iH += A0.d.h(6, (AbstractC0241b) this.h.get(i11));
        }
        int iG2 = 0;
        for (int i12 = 0; i12 < this.k.size(); i12++) {
            iG2 += A0.d.g(((Integer) this.k.get(i12)).intValue());
        }
        int iH2 = iH + iG2;
        if (!this.k.isEmpty()) {
            iH2 = iH2 + 1 + A0.d.g(iG2);
        }
        this.l = iG2;
        for (int i13 = 0; i13 < this.p.size(); i13++) {
            iH2 += A0.d.h(8, (AbstractC0241b) this.p.get(i13));
        }
        for (int i14 = 0; i14 < this.f5029q.size(); i14++) {
            iH2 += A0.d.h(9, (AbstractC0241b) this.f5029q.get(i14));
        }
        for (int i15 = 0; i15 < this.f5030r.size(); i15++) {
            iH2 += A0.d.h(10, (AbstractC0241b) this.f5030r.get(i15));
        }
        for (int i16 = 0; i16 < this.f5031s.size(); i16++) {
            iH2 += A0.d.h(11, (AbstractC0241b) this.f5031s.get(i16));
        }
        for (int i17 = 0; i17 < this.f5032t.size(); i17++) {
            iH2 += A0.d.h(13, (AbstractC0241b) this.f5032t.get(i17));
        }
        int iG3 = 0;
        for (int i18 = 0; i18 < this.u.size(); i18++) {
            iG3 += A0.d.g(((Integer) this.u.get(i18)).intValue());
        }
        int iH3 = iH2 + iG3;
        if (!this.u.isEmpty()) {
            iH3 = iH3 + 2 + A0.d.g(iG3);
        }
        this.f5033v = iG3;
        if ((this.c & 8) == 8) {
            iH3 += A0.d.f(17, this.f5034w);
        }
        if ((this.c & 16) == 16) {
            iH3 += A0.d.h(18, this.f5035x);
        }
        if ((this.c & 32) == 32) {
            iH3 += A0.d.f(19, this.y);
        }
        for (int i19 = 0; i19 < this.m.size(); i19++) {
            iH3 += A0.d.h(20, (AbstractC0241b) this.m.get(i19));
        }
        int iG4 = 0;
        for (int i20 = 0; i20 < this.n.size(); i20++) {
            iG4 += A0.d.g(((Integer) this.n.get(i20)).intValue());
        }
        int iG5 = iH3 + iG4;
        if (!this.n.isEmpty()) {
            iG5 = iG5 + 2 + A0.d.g(iG4);
        }
        this.o = iG4;
        int iG6 = 0;
        for (int i21 = 0; i21 < this.f5036z.size(); i21++) {
            iG6 += A0.d.g(((Integer) this.f5036z.get(i21)).intValue());
        }
        int iH4 = iG5 + iG6;
        if (!this.f5036z.isEmpty()) {
            iH4 = iH4 + 2 + A0.d.g(iG6);
        }
        this.f5020A = iG6;
        for (int i22 = 0; i22 < this.f5021B.size(); i22++) {
            iH4 += A0.d.h(23, (AbstractC0241b) this.f5021B.get(i22));
        }
        int iG7 = 0;
        for (int i23 = 0; i23 < this.f5022C.size(); i23++) {
            iG7 += A0.d.g(((Integer) this.f5022C.get(i23)).intValue());
        }
        int iH5 = iH4 + iG7;
        if (!this.f5022C.isEmpty()) {
            iH5 = iH5 + 2 + A0.d.g(iG7);
        }
        this.f5023D = iG7;
        if ((this.c & 64) == 64) {
            iH5 += A0.d.h(30, this.E);
        }
        int iG8 = 0;
        for (int i24 = 0; i24 < this.f5024F.size(); i24++) {
            iG8 += A0.d.g(((Integer) this.f5024F.get(i24)).intValue());
        }
        int size = (this.f5024F.size() * 2) + iH5 + iG8;
        if ((this.c & 128) == 128) {
            size += A0.d.h(32, this.f5025G);
        }
        int size2 = this.b.size() + h() + size;
        this.f5027M = size2;
        return size2;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.b.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.b bVarF = B8.b.f();
        bVarF.h(this);
        return bVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 1) == 1) {
            dVar.q(1, this.d);
        }
        if (this.i.size() > 0) {
            dVar.z(18);
            dVar.z(this.f5028j);
        }
        for (int i = 0; i < this.i.size(); i++) {
            dVar.r(((Integer) this.i.get(i)).intValue());
        }
        if ((this.c & 2) == 2) {
            dVar.q(3, this.e);
        }
        if ((this.c & 4) == 4) {
            dVar.q(4, this.f);
        }
        for (int i6 = 0; i6 < this.g.size(); i6++) {
            dVar.s(5, (AbstractC0241b) this.g.get(i6));
        }
        for (int i10 = 0; i10 < this.h.size(); i10++) {
            dVar.s(6, (AbstractC0241b) this.h.get(i10));
        }
        if (this.k.size() > 0) {
            dVar.z(58);
            dVar.z(this.l);
        }
        for (int i11 = 0; i11 < this.k.size(); i11++) {
            dVar.r(((Integer) this.k.get(i11)).intValue());
        }
        for (int i12 = 0; i12 < this.p.size(); i12++) {
            dVar.s(8, (AbstractC0241b) this.p.get(i12));
        }
        for (int i13 = 0; i13 < this.f5029q.size(); i13++) {
            dVar.s(9, (AbstractC0241b) this.f5029q.get(i13));
        }
        for (int i14 = 0; i14 < this.f5030r.size(); i14++) {
            dVar.s(10, (AbstractC0241b) this.f5030r.get(i14));
        }
        for (int i15 = 0; i15 < this.f5031s.size(); i15++) {
            dVar.s(11, (AbstractC0241b) this.f5031s.get(i15));
        }
        for (int i16 = 0; i16 < this.f5032t.size(); i16++) {
            dVar.s(13, (AbstractC0241b) this.f5032t.get(i16));
        }
        if (this.u.size() > 0) {
            dVar.z(130);
            dVar.z(this.f5033v);
        }
        for (int i17 = 0; i17 < this.u.size(); i17++) {
            dVar.r(((Integer) this.u.get(i17)).intValue());
        }
        if ((this.c & 8) == 8) {
            dVar.q(17, this.f5034w);
        }
        if ((this.c & 16) == 16) {
            dVar.s(18, this.f5035x);
        }
        if ((this.c & 32) == 32) {
            dVar.q(19, this.y);
        }
        for (int i18 = 0; i18 < this.m.size(); i18++) {
            dVar.s(20, (AbstractC0241b) this.m.get(i18));
        }
        if (this.n.size() > 0) {
            dVar.z(170);
            dVar.z(this.o);
        }
        for (int i19 = 0; i19 < this.n.size(); i19++) {
            dVar.r(((Integer) this.n.get(i19)).intValue());
        }
        if (this.f5036z.size() > 0) {
            dVar.z(178);
            dVar.z(this.f5020A);
        }
        for (int i20 = 0; i20 < this.f5036z.size(); i20++) {
            dVar.r(((Integer) this.f5036z.get(i20)).intValue());
        }
        for (int i21 = 0; i21 < this.f5021B.size(); i21++) {
            dVar.s(23, (AbstractC0241b) this.f5021B.get(i21));
        }
        if (this.f5022C.size() > 0) {
            dVar.z(194);
            dVar.z(this.f5023D);
        }
        for (int i22 = 0; i22 < this.f5022C.size(); i22++) {
            dVar.r(((Integer) this.f5022C.get(i22)).intValue());
        }
        if ((this.c & 64) == 64) {
            dVar.s(30, this.E);
        }
        for (int i23 = 0; i23 < this.f5024F.size(); i23++) {
            dVar.q(31, ((Integer) this.f5024F.get(i23)).intValue());
        }
        if ((this.c & 128) == 128) {
            dVar.s(32, this.f5025G);
        }
        bVar.a(19000, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return f5018N;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.f5026L;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.c & 2) != 2) {
            this.f5026L = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (!((ProtoBuf$TypeParameter) this.g.get(i)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.h.size(); i6++) {
            if (!((ProtoBuf$Type) this.h.get(i6)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.m.size(); i10++) {
            if (!((ProtoBuf$Type) this.m.get(i10)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < this.p.size(); i11++) {
            if (!((ProtoBuf$Constructor) this.p.get(i11)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < this.f5029q.size(); i12++) {
            if (!((ProtoBuf$Function) this.f5029q.get(i12)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < this.f5030r.size(); i13++) {
            if (!((ProtoBuf$Property) this.f5030r.get(i13)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < this.f5031s.size(); i14++) {
            if (!((ProtoBuf$TypeAlias) this.f5031s.get(i14)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < this.f5032t.size(); i15++) {
            if (!((ProtoBuf$EnumEntry) this.f5032t.get(i15)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        if ((this.c & 16) == 16 && !this.f5035x.isInitialized()) {
            this.f5026L = (byte) 0;
            return false;
        }
        for (int i16 = 0; i16 < this.f5021B.size(); i16++) {
            if (!((ProtoBuf$Type) this.f5021B.get(i16)).isInitialized()) {
                this.f5026L = (byte) 0;
                return false;
            }
        }
        if ((this.c & 64) == 64 && !this.E.isInitialized()) {
            this.f5026L = (byte) 0;
            return false;
        }
        if (g()) {
            this.f5026L = (byte) 1;
            return true;
        }
        this.f5026L = (byte) 0;
        return false;
    }

    public final void n() {
        this.d = 6;
        this.e = 0;
        this.f = 0;
        List list = Collections.EMPTY_LIST;
        this.g = list;
        this.h = list;
        this.i = list;
        this.k = list;
        this.m = list;
        this.n = list;
        this.p = list;
        this.f5029q = list;
        this.f5030r = list;
        this.f5031s = list;
        this.f5032t = list;
        this.u = list;
        this.f5034w = 0;
        this.f5035x = ProtoBuf$Type.f5067t;
        this.y = 0;
        this.f5036z = list;
        this.f5021B = list;
        this.f5022C = list;
        this.E = ProtoBuf$TypeTable.g;
        this.f5024F = list;
        this.f5025G = ProtoBuf$VersionRequirementTable.e;
    }

    public ProtoBuf$Class() {
        this.f5028j = -1;
        this.l = -1;
        this.o = -1;
        this.f5033v = -1;
        this.f5020A = -1;
        this.f5023D = -1;
        this.f5026L = (byte) -1;
        this.f5027M = -1;
        this.b = AbstractC0244e.f769a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ProtoBuf$Class(H8.C0245f r22, H8.h r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.<init>(H8.f, H8.h):void");
    }
}
