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
public final class ProtoBuf$PackageFragment extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$PackageFragment> {

    /* renamed from: j, reason: collision with root package name */
    public static final ProtoBuf$PackageFragment f5056j;
    public static final B8.a k = new B8.a(9);
    public final AbstractC0244e b;
    public int c;
    public ProtoBuf$StringTable d;
    public ProtoBuf$QualifiedNameTable e;
    public ProtoBuf$Package f;
    public List g;
    public byte h;
    public int i;

    static {
        ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment();
        f5056j = protoBuf$PackageFragment;
        protoBuf$PackageFragment.d = ProtoBuf$StringTable.e;
        protoBuf$PackageFragment.e = ProtoBuf$QualifiedNameTable.e;
        protoBuf$PackageFragment.f = ProtoBuf$Package.k;
        protoBuf$PackageFragment.g = Collections.EMPTY_LIST;
    }

    public ProtoBuf$PackageFragment(B8.h hVar) {
        super(hVar);
        this.h = (byte) -1;
        this.i = -1;
        this.b = hVar.f774a;
    }

    @Override // H8.AbstractC0241b
    public final int a() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iH = (this.c & 1) == 1 ? A0.d.h(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iH += A0.d.h(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iH += A0.d.h(3, this.f);
        }
        for (int i6 = 0; i6 < this.g.size(); i6++) {
            iH += A0.d.h(4, (AbstractC0241b) this.g.get(i6));
        }
        int size = this.b.size() + h() + iH;
        this.i = size;
        return size;
    }

    @Override // H8.AbstractC0241b
    public final H8.j b() {
        return B8.h.f();
    }

    @Override // H8.AbstractC0241b
    public final H8.j c() {
        B8.h hVarF = B8.h.f();
        hVarF.h(this);
        return hVarF;
    }

    @Override // H8.AbstractC0241b
    public final void d(A0.d dVar) throws IOException {
        a();
        kotlin.reflect.jvm.internal.impl.protobuf.b bVar = new kotlin.reflect.jvm.internal.impl.protobuf.b(this);
        if ((this.c & 1) == 1) {
            dVar.s(1, this.d);
        }
        if ((this.c & 2) == 2) {
            dVar.s(2, this.e);
        }
        if ((this.c & 4) == 4) {
            dVar.s(3, this.f);
        }
        for (int i = 0; i < this.g.size(); i++) {
            dVar.s(4, (AbstractC0241b) this.g.get(i));
        }
        bVar.a(200, dVar);
        dVar.v(this.b);
    }

    @Override // H8.s
    public final AbstractC0241b getDefaultInstanceForType() {
        return f5056j;
    }

    @Override // H8.s
    public final boolean isInitialized() {
        byte b = this.h;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.c & 2) == 2 && !this.e.isInitialized()) {
            this.h = (byte) 0;
            return false;
        }
        if ((this.c & 4) == 4 && !this.f.isInitialized()) {
            this.h = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (!((ProtoBuf$Class) this.g.get(i)).isInitialized()) {
                this.h = (byte) 0;
                return false;
            }
        }
        if (g()) {
            this.h = (byte) 1;
            return true;
        }
        this.h = (byte) 0;
        return false;
    }

    public ProtoBuf$PackageFragment() {
        this.h = (byte) -1;
        this.i = -1;
        this.b = AbstractC0244e.f769a;
    }

    public ProtoBuf$PackageFragment(C0245f c0245f, H8.h hVar) {
        this.h = (byte) -1;
        this.i = -1;
        this.d = ProtoBuf$StringTable.e;
        this.e = ProtoBuf$QualifiedNameTable.e;
        this.f = ProtoBuf$Package.k;
        this.g = Collections.EMPTY_LIST;
        C0243d c0243d = new C0243d();
        A0.d dVarN = A0.d.n(c0243d, 1);
        boolean z10 = false;
        char c = 0;
        while (!z10) {
            try {
                try {
                    int iN = c0245f.n();
                    if (iN != 0) {
                        B8.g gVarF = null;
                        B8.d dVar = null;
                        h hVar2 = null;
                        if (iN == 10) {
                            if ((this.c & 1) == 1) {
                                ProtoBuf$StringTable protoBuf$StringTable = this.d;
                                protoBuf$StringTable.getClass();
                                dVar = new B8.d(2);
                                dVar.d = H8.o.b;
                                dVar.j(protoBuf$StringTable);
                            }
                            ProtoBuf$StringTable protoBuf$StringTable2 = (ProtoBuf$StringTable) c0245f.g(ProtoBuf$StringTable.f, hVar);
                            this.d = protoBuf$StringTable2;
                            if (dVar != null) {
                                dVar.j(protoBuf$StringTable2);
                                this.d = dVar.e();
                            }
                            this.c |= 1;
                        } else if (iN == 18) {
                            if ((this.c & 2) == 2) {
                                ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = this.e;
                                protoBuf$QualifiedNameTable.getClass();
                                hVar2 = new h();
                                hVar2.c = Collections.EMPTY_LIST;
                                hVar2.e(protoBuf$QualifiedNameTable);
                            }
                            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable2 = (ProtoBuf$QualifiedNameTable) c0245f.g(ProtoBuf$QualifiedNameTable.f, hVar);
                            this.e = protoBuf$QualifiedNameTable2;
                            if (hVar2 != null) {
                                hVar2.e(protoBuf$QualifiedNameTable2);
                                this.e = hVar2.d();
                            }
                            this.c |= 2;
                        } else if (iN == 26) {
                            if ((this.c & 4) == 4) {
                                ProtoBuf$Package protoBuf$Package = this.f;
                                protoBuf$Package.getClass();
                                gVarF = B8.g.f();
                                gVarF.h(protoBuf$Package);
                            }
                            ProtoBuf$Package protoBuf$Package2 = (ProtoBuf$Package) c0245f.g(ProtoBuf$Package.l, hVar);
                            this.f = protoBuf$Package2;
                            if (gVarF != null) {
                                gVarF.h(protoBuf$Package2);
                                this.f = gVarF.e();
                            }
                            this.c |= 4;
                        } else if (iN != 34) {
                            if (!l(c0245f, dVarN, hVar, iN)) {
                            }
                        } else {
                            int i = (c == true ? 1 : 0) & '\b';
                            c = c;
                            if (i != 8) {
                                this.g = new ArrayList();
                                c = '\b';
                            }
                            this.g.add(c0245f.g(ProtoBuf$Class.f5019O, hVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & '\b') == 8) {
                        this.g = Collections.unmodifiableList(this.g);
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
        if (((c == true ? 1 : 0) & '\b') == 8) {
            this.g = Collections.unmodifiableList(this.g);
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
