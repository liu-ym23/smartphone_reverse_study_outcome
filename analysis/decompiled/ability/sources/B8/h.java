package B8;

import H8.AbstractC0241b;
import H8.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class h extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public ProtoBuf$StringTable e;
    public ProtoBuf$QualifiedNameTable f;
    public ProtoBuf$Package g;
    public List h;

    public static h f() {
        h hVar = new h();
        hVar.e = ProtoBuf$StringTable.e;
        hVar.f = ProtoBuf$QualifiedNameTable.e;
        hVar.g = ProtoBuf$Package.k;
        hVar.h = Collections.EMPTY_LIST;
        return hVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$PackageFragment protoBuf$PackageFragmentE = e();
        if (protoBuf$PackageFragmentE.isInitialized()) {
            return protoBuf$PackageFragmentE;
        }
        throw new UninitializedMessageException();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r3, H8.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.h(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: B8.h.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$PackageFragment) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        h hVarF = f();
        hVarF.h(e());
        return hVarF;
    }

    public final ProtoBuf$PackageFragment e() {
        ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(this);
        int i = this.d;
        int i6 = (i & 1) != 1 ? 0 : 1;
        protoBuf$PackageFragment.d = this.e;
        if ((i & 2) == 2) {
            i6 |= 2;
        }
        protoBuf$PackageFragment.e = this.f;
        if ((i & 4) == 4) {
            i6 |= 4;
        }
        protoBuf$PackageFragment.f = this.g;
        if ((i & 8) == 8) {
            this.h = Collections.unmodifiableList(this.h);
            this.d &= -9;
        }
        protoBuf$PackageFragment.g = this.h;
        protoBuf$PackageFragment.c = i6;
        return protoBuf$PackageFragment;
    }

    public final void h(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
        ProtoBuf$Package protoBuf$Package;
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable;
        ProtoBuf$StringTable protoBuf$StringTable;
        if (protoBuf$PackageFragment == ProtoBuf$PackageFragment.f5056j) {
            return;
        }
        if ((protoBuf$PackageFragment.c & 1) == 1) {
            ProtoBuf$StringTable protoBuf$StringTable2 = protoBuf$PackageFragment.d;
            if ((this.d & 1) != 1 || (protoBuf$StringTable = this.e) == ProtoBuf$StringTable.e) {
                this.e = protoBuf$StringTable2;
            } else {
                d dVar = new d(2);
                dVar.d = o.b;
                dVar.j(protoBuf$StringTable);
                dVar.j(protoBuf$StringTable2);
                this.e = dVar.e();
            }
            this.d |= 1;
        }
        if ((protoBuf$PackageFragment.c & 2) == 2) {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable2 = protoBuf$PackageFragment.e;
            if ((this.d & 2) != 2 || (protoBuf$QualifiedNameTable = this.f) == ProtoBuf$QualifiedNameTable.e) {
                this.f = protoBuf$QualifiedNameTable2;
            } else {
                kotlin.reflect.jvm.internal.impl.metadata.h hVar = new kotlin.reflect.jvm.internal.impl.metadata.h();
                hVar.c = Collections.EMPTY_LIST;
                hVar.e(protoBuf$QualifiedNameTable);
                hVar.e(protoBuf$QualifiedNameTable2);
                this.f = hVar.d();
            }
            this.d |= 2;
        }
        if ((protoBuf$PackageFragment.c & 4) == 4) {
            ProtoBuf$Package protoBuf$Package2 = protoBuf$PackageFragment.f;
            if ((this.d & 4) != 4 || (protoBuf$Package = this.g) == ProtoBuf$Package.k) {
                this.g = protoBuf$Package2;
            } else {
                g gVarF = g.f();
                gVarF.h(protoBuf$Package);
                gVarF.h(protoBuf$Package2);
                this.g = gVarF.e();
            }
            this.d |= 4;
        }
        if (!protoBuf$PackageFragment.g.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = protoBuf$PackageFragment.g;
                this.d &= -9;
            } else {
                if ((this.d & 8) != 8) {
                    this.h = new ArrayList(this.h);
                    this.d |= 8;
                }
                this.h.addAll(protoBuf$PackageFragment.g);
            }
        }
        d(protoBuf$PackageFragment);
        this.f774a = this.f774a.c(protoBuf$PackageFragment.b);
    }
}
