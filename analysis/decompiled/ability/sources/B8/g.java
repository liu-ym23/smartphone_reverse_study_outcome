package B8;

import H8.AbstractC0241b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.protobuf.a {
    public int d;
    public List e;
    public List f;
    public List g;
    public ProtoBuf$TypeTable h;
    public ProtoBuf$VersionRequirementTable i;

    public static g f() {
        g gVar = new g();
        List list = Collections.EMPTY_LIST;
        gVar.e = list;
        gVar.f = list;
        gVar.g = list;
        gVar.h = ProtoBuf$TypeTable.g;
        gVar.i = ProtoBuf$VersionRequirementTable.e;
        return gVar;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        ProtoBuf$Package protoBuf$PackageE = e();
        if (protoBuf$PackageE.isInitialized()) {
            return protoBuf$PackageE;
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
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
            r2.h(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> Lf
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: B8.g.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        h((ProtoBuf$Package) generatedMessageLite);
        return this;
    }

    public final Object clone() {
        g gVarF = f();
        gVarF.h(e());
        return gVarF;
    }

    public final ProtoBuf$Package e() {
        ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(this);
        int i = this.d;
        if ((i & 1) == 1) {
            this.e = Collections.unmodifiableList(this.e);
            this.d &= -2;
        }
        protoBuf$Package.d = this.e;
        if ((this.d & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
            this.d &= -3;
        }
        protoBuf$Package.e = this.f;
        if ((this.d & 4) == 4) {
            this.g = Collections.unmodifiableList(this.g);
            this.d &= -5;
        }
        protoBuf$Package.f = this.g;
        int i6 = (i & 8) != 8 ? 0 : 1;
        protoBuf$Package.g = this.h;
        if ((i & 16) == 16) {
            i6 |= 2;
        }
        protoBuf$Package.h = this.i;
        protoBuf$Package.c = i6;
        return protoBuf$Package;
    }

    public final void h(ProtoBuf$Package protoBuf$Package) {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable;
        ProtoBuf$TypeTable protoBuf$TypeTable;
        if (protoBuf$Package == ProtoBuf$Package.k) {
            return;
        }
        if (!protoBuf$Package.d.isEmpty()) {
            if (this.e.isEmpty()) {
                this.e = protoBuf$Package.d;
                this.d &= -2;
            } else {
                if ((this.d & 1) != 1) {
                    this.e = new ArrayList(this.e);
                    this.d |= 1;
                }
                this.e.addAll(protoBuf$Package.d);
            }
        }
        if (!protoBuf$Package.e.isEmpty()) {
            if (this.f.isEmpty()) {
                this.f = protoBuf$Package.e;
                this.d &= -3;
            } else {
                if ((this.d & 2) != 2) {
                    this.f = new ArrayList(this.f);
                    this.d |= 2;
                }
                this.f.addAll(protoBuf$Package.e);
            }
        }
        if (!protoBuf$Package.f.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = protoBuf$Package.f;
                this.d &= -5;
            } else {
                if ((this.d & 4) != 4) {
                    this.g = new ArrayList(this.g);
                    this.d |= 4;
                }
                this.g.addAll(protoBuf$Package.f);
            }
        }
        if ((protoBuf$Package.c & 1) == 1) {
            ProtoBuf$TypeTable protoBuf$TypeTable2 = protoBuf$Package.g;
            if ((this.d & 8) != 8 || (protoBuf$TypeTable = this.h) == ProtoBuf$TypeTable.g) {
                this.h = protoBuf$TypeTable2;
            } else {
                k kVarG = ProtoBuf$TypeTable.g(protoBuf$TypeTable);
                kVarG.f(protoBuf$TypeTable2);
                this.h = kVarG.d();
            }
            this.d |= 8;
        }
        if ((protoBuf$Package.c & 2) == 2) {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = protoBuf$Package.h;
            if ((this.d & 16) != 16 || (protoBuf$VersionRequirementTable = this.i) == ProtoBuf$VersionRequirementTable.e) {
                this.i = protoBuf$VersionRequirementTable2;
            } else {
                d dVar = new d(1);
                dVar.d = Collections.EMPTY_LIST;
                dVar.k(protoBuf$VersionRequirementTable);
                dVar.k(protoBuf$VersionRequirementTable2);
                this.i = dVar.f();
            }
            this.d |= 16;
        }
        d(protoBuf$Package);
        this.f774a = this.f774a.c(protoBuf$Package.b);
    }
}
