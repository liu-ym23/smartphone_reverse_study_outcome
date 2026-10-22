package B8;

import H8.AbstractC0241b;
import H8.o;
import H8.p;
import H8.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class d extends H8.j implements s {
    public final /* synthetic */ int b;
    public int c;
    public List d;

    public /* synthetic */ d(int i) {
        this.b = i;
    }

    @Override // H8.j
    public final AbstractC0241b a() {
        switch (this.b) {
            case 0:
                ProtoBuf$Contract protoBuf$ContractD = d();
                if (protoBuf$ContractD.isInitialized()) {
                    return protoBuf$ContractD;
                }
                throw new UninitializedMessageException();
            case 1:
                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTableF = f();
                if (protoBuf$VersionRequirementTableF.isInitialized()) {
                    return protoBuf$VersionRequirementTableF;
                }
                throw new UninitializedMessageException();
            default:
                ProtoBuf$StringTable protoBuf$StringTableE = e();
                if (protoBuf$StringTableE.isInitialized()) {
                    return protoBuf$StringTableE;
                }
                throw new UninitializedMessageException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005e  */
    @Override // H8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final H8.j b(H8.C0245f r3, H8.h r4) throws java.lang.Throwable {
        /*
            r2 = this;
            int r0 = r2.b
            switch(r0) {
                case 0: goto L43;
                case 1: goto L24;
                default: goto L5;
            }
        L5:
            r4 = 0
            B8.a r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.f     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            r0.getClass()     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r0 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L14 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L16
            r2.j(r0)
            return r2
        L14:
            r3 = move-exception
            goto L1e
        L16:
            r3 = move-exception
            H8.b r0 = r3.f5100a     // Catch: java.lang.Throwable -> L14
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable) r0     // Catch: java.lang.Throwable -> L14
            throw r3     // Catch: java.lang.Throwable -> L1c
        L1c:
            r3 = move-exception
            r4 = r0
        L1e:
            if (r4 == 0) goto L23
            r2.j(r4)
        L23:
            throw r3
        L24:
            r0 = 0
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.f     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            r1.getClass()     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L33 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L35
            r2.k(r1)
            return r2
        L33:
            r3 = move-exception
            goto L3d
        L35:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> L33
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable) r4     // Catch: java.lang.Throwable -> L33
            throw r3     // Catch: java.lang.Throwable -> L3b
        L3b:
            r3 = move-exception
            r0 = r4
        L3d:
            if (r0 == 0) goto L42
            r2.k(r0)
        L42:
            throw r3
        L43:
            r0 = 0
            B8.a r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.f     // Catch: java.lang.Throwable -> L52 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L54
            r1.getClass()     // Catch: java.lang.Throwable -> L52 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L54
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r1 = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract     // Catch: java.lang.Throwable -> L52 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L54
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L52 kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L54
            r2.h(r1)
            return r2
        L52:
            r3 = move-exception
            goto L5c
        L54:
            r3 = move-exception
            H8.b r4 = r3.f5100a     // Catch: java.lang.Throwable -> L52
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract) r4     // Catch: java.lang.Throwable -> L52
            throw r3     // Catch: java.lang.Throwable -> L5a
        L5a:
            r3 = move-exception
            r0 = r4
        L5c:
            if (r0 == 0) goto L61
            r2.h(r0)
        L61:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: B8.d.b(H8.f, H8.h):H8.j");
    }

    @Override // H8.j
    public final /* bridge */ /* synthetic */ H8.j c(GeneratedMessageLite generatedMessageLite) {
        switch (this.b) {
            case 0:
                h((ProtoBuf$Contract) generatedMessageLite);
                break;
            case 1:
                k((ProtoBuf$VersionRequirementTable) generatedMessageLite);
                break;
            default:
                j((ProtoBuf$StringTable) generatedMessageLite);
                break;
        }
        return this;
    }

    public final Object clone() {
        switch (this.b) {
            case 0:
                d dVar = new d(0);
                dVar.d = Collections.EMPTY_LIST;
                dVar.h(d());
                return dVar;
            case 1:
                d dVar2 = new d(1);
                dVar2.d = Collections.EMPTY_LIST;
                dVar2.k(f());
                return dVar2;
            default:
                d dVar3 = new d(2);
                dVar3.d = o.b;
                dVar3.j(e());
                return dVar3;
        }
    }

    public ProtoBuf$Contract d() {
        ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(this);
        if ((this.c & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -2;
        }
        protoBuf$Contract.b = this.d;
        return protoBuf$Contract;
    }

    public ProtoBuf$StringTable e() {
        ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable(this);
        if ((this.c & 1) == 1) {
            this.d = ((p) this.d).getUnmodifiableView();
            this.c &= -2;
        }
        protoBuf$StringTable.b = (p) this.d;
        return protoBuf$StringTable;
    }

    public ProtoBuf$VersionRequirementTable f() {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(this);
        if ((this.c & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -2;
        }
        protoBuf$VersionRequirementTable.b = this.d;
        return protoBuf$VersionRequirementTable;
    }

    public void h(ProtoBuf$Contract protoBuf$Contract) {
        if (protoBuf$Contract == ProtoBuf$Contract.e) {
            return;
        }
        if (!protoBuf$Contract.b.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = protoBuf$Contract.b;
                this.c &= -2;
            } else {
                if ((this.c & 1) != 1) {
                    this.d = new ArrayList(this.d);
                    this.c |= 1;
                }
                this.d.addAll(protoBuf$Contract.b);
            }
        }
        this.f774a = this.f774a.c(protoBuf$Contract.f5039a);
    }

    public void j(ProtoBuf$StringTable protoBuf$StringTable) {
        if (protoBuf$StringTable == ProtoBuf$StringTable.e) {
            return;
        }
        if (!protoBuf$StringTable.b.isEmpty()) {
            if (((p) this.d).isEmpty()) {
                this.d = protoBuf$StringTable.b;
                this.c &= -2;
            } else {
                if ((this.c & 1) != 1) {
                    this.d = new o((p) this.d);
                    this.c |= 1;
                }
                ((p) this.d).addAll(protoBuf$StringTable.b);
            }
        }
        this.f774a = this.f774a.c(protoBuf$StringTable.f5066a);
    }

    public void k(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
        if (protoBuf$VersionRequirementTable == ProtoBuf$VersionRequirementTable.e) {
            return;
        }
        if (!protoBuf$VersionRequirementTable.b.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = protoBuf$VersionRequirementTable.b;
                this.c &= -2;
            } else {
                if ((this.c & 1) != 1) {
                    this.d = new ArrayList(this.d);
                    this.c |= 1;
                }
                this.d.addAll(protoBuf$VersionRequirementTable.b);
            }
        }
        this.f774a = this.f774a.c(protoBuf$VersionRequirementTable.f5083a);
    }
}
