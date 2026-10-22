package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: compiled from: ClassData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassData {
    private final ProtoBuf.Class classProto;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final SourceElement sourceElement;

    public final NameResolver component1() {
        return this.nameResolver;
    }

    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClassData) == true) goto L8;
        return false;
    L8:
        ClassData r6 = (ClassData) r5;
        if (Intrinsics.areEqual(this.nameResolver, r6.nameResolver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.classProto, r6.classProto) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.metadataVersion, r6.metadataVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceElement, r6.sourceElement) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.nameResolver.hashCode() * 31) + this.classProto.hashCode()) * 31) + this.metadataVersion.hashCode()) * 31) + this.sourceElement.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ')';
    }

    public ClassData(NameResolver r2, ProtoBuf.Class r3, BinaryVersion r4, SourceElement r5) {
        Intrinsics.checkNotNullParameter(r2, "nameResolver");
        Intrinsics.checkNotNullParameter(r3, "classProto");
        Intrinsics.checkNotNullParameter(r4, "metadataVersion");
        Intrinsics.checkNotNullParameter(r5, "sourceElement");
        this.nameResolver = r2;
        this.classProto = r3;
        this.metadataVersion = r4;
        this.sourceElement = r5;
    }
}
