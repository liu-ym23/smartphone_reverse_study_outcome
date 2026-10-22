package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JvmPackagePartSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final JvmClassName className;
    private final JvmClassName facadeClassName;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;
    private final KotlinJvmBinaryClass knownJvmBinaryClass;
    private final String moduleName;

    public JvmPackagePartSource(JvmClassName r2, JvmClassName r3, ProtoBuf.Package r4, NameResolver r5, IncompatibleVersionErrorData<JvmMetadataVersion> r6, boolean r7, DeserializedContainerAbiStability r8, KotlinJvmBinaryClass r9) {
        Intrinsics.checkNotNullParameter(r2, "className");
        Intrinsics.checkNotNullParameter(r4, "packageProto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        Intrinsics.checkNotNullParameter(r8, "abiStability");
        this.className = r2;
        this.facadeClassName = r3;
        this.incompatibility = r6;
        this.isPreReleaseInvisible = r7;
        this.abiStability = r8;
        this.knownJvmBinaryClass = r9;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> r10 = JvmProtoBuf.packageModuleName;
        Intrinsics.checkNotNullExpressionValue(r10, "packageModuleName");
        Integer r11 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r4, r10);
        if (r11 == null) goto L6;
        String r12 = r5.getString(r11.intValue());
        if (r12 == null) goto L6;
    L7:
        this.moduleName = r12;
        return;
    L6:
        r12 = "main";
        goto L7
    }

    public JvmClassName getClassName() {
        return this.className;
    }

    public JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    public JvmPackagePartSource(KotlinJvmBinaryClass r11, ProtoBuf.Package r12, NameResolver r13, IncompatibleVersionErrorData<JvmMetadataVersion> r14, boolean r15, DeserializedContainerAbiStability r16) {
        Intrinsics.checkNotNullParameter(r11, "kotlinClass");
        Intrinsics.checkNotNullParameter(r12, "packageProto");
        Intrinsics.checkNotNullParameter(r13, "nameResolver");
        Intrinsics.checkNotNullParameter(r16, "abiStability");
        JvmClassName r2 = JvmClassName.byClassId(r11.getClassId());
        Intrinsics.checkNotNullExpressionValue(r2, "byClassId(kotlinClass.classId)");
        String r0 = r11.getClassHeader().getMultifileClassName();
        JvmClassName r1 = null;
        if (r0 != null) goto L5;
    L10:
        this(r2, r1, r12, r13, r14, r15, r16, r11);
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r1 = JvmClassName.byInternalName(r0);
        goto L10
    L7:
        r3 = false;
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    public final Name getSimpleName() {
        String r3 = getClassName().getInternalName();
        Intrinsics.checkNotNullExpressionValue(r3, "className.internalName");
        Name r4 = Name.identifier(StringsKt.substringAfterLast$default(r3, '/', null, 2, null));
        Intrinsics.checkNotNullExpressionValue(r4, "identifier(className.int….substringAfterLast('/'))");
        return r4;
    }

    public final ClassId getClassId() {
        return new ClassId(getClassName().getPackageFqName(), getSimpleName());
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + getClassName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        SourceFile r1 = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(r1, "NO_SOURCE_FILE");
        return r1;
    }
}
