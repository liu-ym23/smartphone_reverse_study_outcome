package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.android.vcard.VCardConstants;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaAnnotationTargetMapper {
    public static final JavaAnnotationTargetMapper INSTANCE = null;
    private static final Map<String, KotlinRetention> retentionNameList = null;
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists = null;

    private JavaAnnotationTargetMapper() {
    }

    static {
        INSTANCE = new JavaAnnotationTargetMapper();
        targetNameLists = MapsKt.mapOf(new Pair[]{TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to(VCardConstants.PARAM_TYPE, EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE))});
        retentionNameList = MapsKt.mapOf(new Pair[]{TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE)});
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String r1) {
        EnumSet<KotlinTarget> r0 = targetNameLists.get(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return SetsKt.emptySet();
    }

    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(List<? extends JavaAnnotationArgument> r5) {
        Intrinsics.checkNotNullParameter(r5, "arguments");
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((r0 instanceof JavaEnumValueAnnotationArgument) == false) goto L4;
        r4.add(r0);
        goto L4
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L10:
        if (r8.hasNext() == false) goto L16;
        JavaEnumValueAnnotationArgument r1 = (JavaEnumValueAnnotationArgument) r8.next();
        JavaAnnotationTargetMapper r2 = INSTANCE;
        Name r3 = r1.getEntryName();
        if (r3 == null) goto L14;
        String r9 = r3.asString();
    L15:
        CollectionsKt.addAll(r7, r2.mapJavaTargetArgumentByName(r9));
        goto L10
    L14:
        r9 = null;
        goto L15
    L16:
        ArrayList r10 = r7;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L18:
        if (r12.hasNext() == false) goto L21;
        KotlinTarget r13 = (KotlinTarget) r12.next();
        ClassId r14 = ClassId.topLevel(StandardNames.FqNames.annotationTarget);
        Intrinsics.checkNotNullExpressionValue(r14, "topLevel(StandardNames.FqNames.annotationTarget)");
        Name r15 = Name.identifier(r13.name());
        Intrinsics.checkNotNullExpressionValue(r15, "identifier(kotlinTarget.name)");
        r11.add(new EnumValue(r14, r15));
        goto L18
    L21:
        return new ArrayValue(r11, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }

    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationArgument r3) {
        EnumValue r0 = null;
        if ((r3 instanceof JavaEnumValueAnnotationArgument) == false) goto L5;
        JavaEnumValueAnnotationArgument r4 = (JavaEnumValueAnnotationArgument) r3;
    L6:
        if (r4 == null) goto L15;
        Map<String, KotlinRetention> r2 = retentionNameList;
        Name r5 = r4.getEntryName();
        if (r5 == null) goto L10;
        String r6 = r5.asString();
    L11:
        KotlinRetention r7 = r2.get(r6);
        if (r7 == null) goto L15;
        ClassId r1 = ClassId.topLevel(StandardNames.FqNames.annotationRetention);
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(StandardNames.F…ames.annotationRetention)");
        Name r8 = Name.identifier(r7.name());
        Intrinsics.checkNotNullExpressionValue(r8, "identifier(retention.name)");
        r0 = new EnumValue(r1, r8);
        goto L15
    L10:
        r6 = null;
    L15:
        return r0;
    L5:
        r4 = null;
        goto L6
    }
}
