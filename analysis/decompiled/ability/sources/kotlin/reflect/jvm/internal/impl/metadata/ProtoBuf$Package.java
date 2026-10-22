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
public final class ProtoBuf$Package extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Package> {
    public static final ProtoBuf$Package k;
    public static final B8.a l = new B8.a(8);
    public final AbstractC0244e b;
    public int c;
    public List d;
    public List e;
    public List f;
    public ProtoBuf$TypeTable g;
    public ProtoBuf$VersionRequirementTable h;
    public byte i;

    /* renamed from: j, reason: collision with root package name */
    public int f5055j;

    static {
        ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package();
        k = protoBuf$Package;
        List list = Collections.EMPTY_LIST;
        protoBuf$Package.d = list;
        protoBuf$Package.e = list;
        protoBuf$Package.f = list;
        protoBuf$Package.g = ProtoBuf$TypeTable.g;
        protoBuf$Package.h = ProtoBuf$VersionRequirementTable.e;
    }

    public ProtoBuf$Package(B8.g gVar) {
        super(gVar);
        this.i = (byte) -1;
        this.f5055j = -1;
        this.b = gVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.f5055j;
        if (i != -1) {
            return i;
        }
        int iH = 0;
        for (int i6 = 0; i6 < this.d.size(); i6++) {
            iH += A0.d.h(3, (AbstractC0241b) this.d.get(i6));
        }
        for (int i10 = 0; i10 < this.e.size(); i10++) {
            iH += A0.d.h(4, (AbstractC0241b) this.e.get(i10));
        }
        for (int i11 = 0; i11 < this.f.size(); i11++) {
            iH += A0.d.h(5, (AbstractC0241b) this.f.get(i11));
        }
        if ((this.c & 1) == 1) {
            iH += A0.d.h(30, this.g);
        }
        if ((this.c & 2) == 2) {
            iH += A0.d.h(32, this.h);
        }
        int size = this.b.size() + h() + iH;
        this.f5055j = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.g.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.g gVarF = B8.g.f();
        gVarF.h(this);
        return gVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        for (int i = 0; i < this.d.size(); i++) {
            dVar.s(3, (AbstractC0241b) this.d.get(i));
        }
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            dVar.s(4, (AbstractC0241b) this.e.get(i6));
        }
        for (int i10 = 0; i10 < this.f.size(); i10++) {
            dVar.s(5, (AbstractC0241b) this.f.get(i10));
        }
        if ((this.c & 1) == 1) {
            dVar.s(30, this.g);
        }
        if ((this.c & 2) == 2) {
            dVar.s(32, this.h);
        }
        bVar.a(200, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return k;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((ProtoBuf$Function) this.d.get(i)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            if (!((ProtoBuf$Property) this.e.get(i6)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < this.f.size(); i10++) {
            if (!((ProtoBuf$TypeAlias) this.f.get(i10)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        if ((this.c & 1) == 1 && !this.g.isInitialized()) {
            this.i = (byte) 0;
            return false;
        }
        if (g()) {
            this.i = (byte) 1;
            return true;
        }
        this.i = (byte) 0;
        return false;
    }

    public ProtoBuf$Package() {
        this.i = (byte) -1;
        this.f5055j = -1;
        this.b = AbstractC0244e.f769a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public ProtoBuf$Package(C0245f c0245f, H8.h hVar) {
        this.i = (byte) -1;
        this.f5055j = -1;
        List list = Collections.EMPTY_LIST;
        this.d = list;
        this.e = list;
        this.f = list;
        this.g = ProtoBuf$TypeTable.g;
        this.h = ProtoBuf$VersionRequirementTable.e;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        char c = 0;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        if (iN == 26) {
                            int i = (c == true ? 1 : 0) & 1;
                            c = c;
                            if (i != 1) {
                                this.d = new ArrayList();
                                c = (c == true ? 1 : 0) | 1;
                            }
                            this.d.add(c0245f.g(ProtoBuf$Function.f5047v, hVar));
                        } else if (iN == 34) {
                            int i6 = (c == true ? 1 : 0) & 2;
                            c = c;
                            if (i6 != 2) {
                                this.e = new ArrayList();
                                c = (c == true ? 1 : 0) | 2;
                            }
                            this.e.add(c0245f.g(ProtoBuf$Property.f5057v, hVar));
                        } else if (iN != 42) {
                            B8.d dVar = null;
                            B8.k kVarG = null;
                            if (iN == 242) {
                                if ((this.c & 1) == 1) {
                                    ProtoBuf$TypeTable protoBuf$TypeTable = this.g;
                                    protoBuf$TypeTable.getClass();
                                    kVarG = ProtoBuf$TypeTable.g(protoBuf$TypeTable);
                                }
                                ProtoBuf$TypeTable protoBuf$TypeTable2 = (ProtoBuf$TypeTable) c0245f.g(ProtoBuf$TypeTable.h, hVar);
                                this.g = protoBuf$TypeTable2;
                                if (kVarG != null) {
                                    kVarG.f(protoBuf$TypeTable2);
                                    this.g = kVarG.d();
                                }
                                this.c |= 1;
                            } else if (iN != 258) {
                                if (!l(c0245f, dVarN, hVar, iN)) {
                                }
                            } else {
                                if ((this.c & 2) == 2) {
                                    ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = this.h;
                                    protoBuf$VersionRequirementTable.getClass();
                                    dVar = new B8.d(1);
                                    dVar.d = Collections.EMPTY_LIST;
                                    dVar.k(protoBuf$VersionRequirementTable);
                                }
                                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = (ProtoBuf$VersionRequirementTable) c0245f.g(ProtoBuf$VersionRequirementTable.f, hVar);
                                this.h = protoBuf$VersionRequirementTable2;
                                if (dVar != null) {
                                    dVar.k(protoBuf$VersionRequirementTable2);
                                    this.h = dVar.f();
                                }
                                this.c |= 2;
                            }
                        } else {
                            int i10 = (c == true ? 1 : 0) & 4;
                            c = c;
                            if (i10 != 4) {
                                this.f = new ArrayList();
                                c = (c == true ? 1 : 0) | 4;
                            }
                            this.f.add(c0245f.g(ProtoBuf$TypeAlias.p, hVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & 1) == 1) {
                        this.d = Collections.unmodifiableList(this.d);
                    }
                    if (((c == true ? 1 : 0) & 2) == 2) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    if (((c == true ? 1 : 0) & 4) == 4) {
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
        if (((c == true ? 1 : 0) & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
        }
        if (((c == true ? 1 : 0) & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        if (((c == true ? 1 : 0) & 4) == 4) {
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
