package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures;

    /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
        public final class FunctionEnhancementBuilder {
            private final String functionName;
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            private Pair<String, TypeEnhancementInfo> returnType;
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "functionName");
                this.this$0 = r2;
                this.functionName = r3;
                this.parameters = new ArrayList();
                this.returnType = TuplesKt.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final void parameter(String r4, JavaTypeQualifiers... r5) {
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> r3 = this.parameters;
                if (r5.length != 0) goto L5;
                boolean r0 = true;
            L6:
                if (r0 == false) goto L8;
                TypeEnhancementInfo r6 = null;
            L13:
                r3.add(TuplesKt.to(r4, r6));
                return;
            L8:
                Iterable r7 = ArraysKt.withIndex(r5);
                LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
                Iterator r8 = r7.iterator();
            L10:
                if (r8.hasNext() == false) goto L12;
                IndexedValue r2 = (IndexedValue) r8.next();
                r1.put(Integer.valueOf(r2.getIndex()), (JavaTypeQualifiers) r2.getValue());
                goto L10
            L12:
                r6 = new TypeEnhancementInfo(r1);
                goto L13
            L5:
                r0 = false;
                goto L6
            }

            public final void returns(String r4, JavaTypeQualifiers... r5) {
                Intrinsics.checkNotNullParameter(r4, "type");
                Intrinsics.checkNotNullParameter(r5, "qualifiers");
                Iterable r6 = ArraysKt.withIndex(r5);
                LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
                Iterator r7 = r6.iterator();
            L4:
                if (r7.hasNext() == false) goto L6;
                IndexedValue r0 = (IndexedValue) r7.next();
                r1.put(Integer.valueOf(r0.getIndex()), (JavaTypeQualifiers) r0.getValue());
                goto L4
            L6:
                this.returnType = TuplesKt.to(r4, new TypeEnhancementInfo(r1));
            }

            public final void returns(JvmPrimitiveType r2) {
                Intrinsics.checkNotNullParameter(r2, "type");
                String r3 = r2.getDesc();
                Intrinsics.checkNotNullExpressionValue(r3, "type.desc");
                this.returnType = TuplesKt.to(r3, null);
            }

            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents r0 = SignatureBuildingComponents.INSTANCE;
                String r1 = this.this$0.getClassName();
                String r2 = this.functionName;
                List<Pair<String, TypeEnhancementInfo>> r3 = this.parameters;
                ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
                Iterator<T> r5 = r3.iterator();
            L4:
                if (r5.hasNext() == false) goto L6;
                r4.add((String) ((Pair) r5.next()).getFirst());
                goto L4
            L6:
                String r6 = r0.signature(r1, r0.jvmDescriptor(r2, r4, this.returnType.getFirst()));
                TypeEnhancementInfo r7 = this.returnType.getSecond();
                List<Pair<String, TypeEnhancementInfo>> r8 = this.parameters;
                ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
                Iterator<T> r10 = r8.iterator();
            L8:
                if (r10.hasNext() == false) goto L11;
                r9.add((TypeEnhancementInfo) ((Pair) r10.next()).getSecond());
                goto L8
            L11:
                return TuplesKt.to(r6, new PredefinedFunctionEnhancementInfo(r7, r9));
            }
        }

        public ClassEnhancementBuilder(SignatureEnhancementBuilder r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "className");
            this.this$0 = r2;
            this.className = r3;
        }

        public final String getClassName() {
            return this.className;
        }

        public final void function(String r3, Function1<? super FunctionEnhancementBuilder, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "block");
            Map r0 = SignatureEnhancementBuilder.access$getSignatures$p(this.this$0);
            FunctionEnhancementBuilder r1 = new FunctionEnhancementBuilder(this, r3);
            r4.invoke(r1);
            Pair<String, PredefinedFunctionEnhancementInfo> r2 = r1.build();
            r0.put(r2.getFirst(), r2.getSecond());
        }
    }

    public SignatureEnhancementBuilder() {
        this.signatures = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getSignatures$p(SignatureEnhancementBuilder r0) {
        return r0.signatures;
    }

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }
}
