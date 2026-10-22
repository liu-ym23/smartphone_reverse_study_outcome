package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers NOT_NULLABLE = null;
    private static final JavaTypeQualifiers NOT_PLATFORM = null;
    private static final JavaTypeQualifiers NULLABLE = null;
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = null;

    public static final /* synthetic */ JavaTypeQualifiers access$getNOT_NULLABLE$p() {
        return NOT_NULLABLE;
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNOT_PLATFORM$p() {
        return NOT_PLATFORM;
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNULLABLE$p() {
        return NULLABLE;
    }

    static {
        NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
        NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
        NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);
        final SignatureBuildingComponents r0 = SignatureBuildingComponents.INSTANCE;
        final String r1 = r0.javaLang("Object");
        final String r2 = r0.javaFunction("Predicate");
        final String r3 = r0.javaFunction("Function");
        final String r4 = r0.javaFunction("Consumer");
        final String r5 = r0.javaFunction("BiFunction");
        final String r6 = r0.javaFunction("BiConsumer");
        final String r7 = r0.javaFunction("UnaryOperator");
        final String r8 = r0.javaUtil("stream/Stream");
        final String r9 = r0.javaUtil("Optional");
        SignatureEnhancementBuilder r10 = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaUtil("Iterator")).function("forEachRemaining", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1(r4));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaLang("Iterable")).function("spliterator", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1(r0));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r12 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaUtil("Collection"));
        r12.function("removeIf", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1(r2));
        r12.function(CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2(r8));
        r12.function("parallelStream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3(r8));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaUtil("List")).function("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1(r7));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r11 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaUtil("Map"));
        r11.function("forEach", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1(r6));
        r11.function("putIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2(r1));
        r11.function("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3(r1));
        r11.function("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4(r1));
        r11.function("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(r5));
        r11.function("compute", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6(r1, r5));
        r11.function("computeIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7(r1, r3));
        r11.function("computeIfPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8(r1, r5));
        r11.function("merge", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9(r1, r5));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r13 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r9);
        r13.function("empty", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1(r9));
        r13.function("of", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2(r1, r9));
        r13.function("ofNullable", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3(r1, r9));
        r13.function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4(r1));
        r13.function("ifPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5(r4));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaLang("ref/Reference")).function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r2).function("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaFunction("BiPredicate")).function("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r4).function("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r6).function("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r3).function("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r5).function("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1(r1));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r10, r0.javaFunction("Supplier")).function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1(r1));
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = r10.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
