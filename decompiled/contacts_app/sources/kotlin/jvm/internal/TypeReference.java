package kotlin.jvm.internal;

import com.android.contacts.ContactsUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* JADX INFO: compiled from: TypeReference.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0002J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\f\u0010\"\u001a\u00020\u001e*\u00020\u0006H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "platformTypeUpperBound", "flags", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getFlags$kotlin_stdlib$annotations", "()V", "getFlags$kotlin_stdlib", "()I", "()Z", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "convertPrimitiveToWrapper", "equals", "other", "", "hashCode", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypeReference implements KType {
    public static final Companion Companion = null;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    /* JADX INFO: compiled from: TypeReference.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeReference$Companion;", "", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: TypeReference.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public TypeReference(KClassifier r2, List<KTypeProjection> r3, KType r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "classifier");
        Intrinsics.checkNotNullParameter(r3, "arguments");
        this.classifier = r2;
        this.arguments = r3;
        this.platformTypeUpperBound = r4;
        this.flags = r5;
    }

    public static final /* synthetic */ String access$asString(TypeReference r0, KTypeProjection r1) {
        return r0.asString(r1);
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    public TypeReference(KClassifier r2, List<KTypeProjection> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "classifier");
        Intrinsics.checkNotNullParameter(r3, "arguments");
        this(r2, r3, null, r4 ? 1 : 0);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        if ((this.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof TypeReference) == false) goto L13;
        TypeReference r4 = (TypeReference) r3;
        if (Intrinsics.areEqual(getClassifier(), r4.getClassifier()) == false) goto L13;
        if (Intrinsics.areEqual(getArguments(), r4.getArguments()) == false) goto L13;
        if (Intrinsics.areEqual(this.platformTypeUpperBound, r4.platformTypeUpperBound) == false) goto L13;
        if (this.flags != r4.flags) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.hashCode(this.flags);
    }

    public String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }

    private final String asString(boolean r12) {
        KClassifier r0 = getClassifier();
        Class<?> r2 = null;
        if ((r0 instanceof KClass) == false) goto L5;
        KClass r1 = (KClass) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = JvmClassMappingKt.getJavaClass(r1);
    L8:
        if (r2 != null) goto L11;
        String r13 = getClassifier().toString();
    L21:
        String r3 = "";
        if (getArguments().isEmpty() == false) goto L24;
        String r4 = "";
    L26:
        if (isMarkedNullable() == false) goto L28;
        r3 = "?";
    L28:
        String r14 = r13 + r4 + r3;
        KType r11 = this.platformTypeUpperBound;
        if ((r11 instanceof TypeReference) == false) goto L38;
        String r15 = ((TypeReference) r11).asString(true);
        if (Intrinsics.areEqual(r15, r14) == false) goto L34;
        return r14;
    L34:
        if (Intrinsics.areEqual(r15, r14 + '?') == false) goto L37;
        return r14 + '!';
    L37:
        return "(" + r14 + ".." + r15 + ')';
    L38:
        return r14;
    L24:
        r4 = CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new TypeReference$asString$args$1(this), 24, null);
        goto L26
    L11:
        if ((this.flags & 4) == 0) goto L14;
        r13 = "kotlin.Nothing";
        goto L21
    L14:
        if (r2.isArray() == false) goto L16;
        r13 = getArrayClassName(r2);
        goto L21
    L16:
        if (r12 == true) goto L18;
    L20:
        r13 = r2.getName();
        goto L21
    L18:
        if (r2.isPrimitive() == false) goto L20;
        KClassifier r16 = getClassifier();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        r13 = JvmClassMappingKt.getJavaObjectType((KClass) r16).getName();
        goto L21
    L5:
        r1 = null;
        goto L6
    }

    private final String getArrayClassName(Class<?> r1) {
        if (Intrinsics.areEqual(r1, boolean[].class) == false) goto L6;
        return "kotlin.BooleanArray";
    L6:
        if (Intrinsics.areEqual(r1, char[].class) == false) goto L9;
        return "kotlin.CharArray";
    L9:
        if (Intrinsics.areEqual(r1, byte[].class) == false) goto L12;
        return "kotlin.ByteArray";
    L12:
        if (Intrinsics.areEqual(r1, short[].class) == false) goto L15;
        return "kotlin.ShortArray";
    L15:
        if (Intrinsics.areEqual(r1, int[].class) == false) goto L18;
        return "kotlin.IntArray";
    L18:
        if (Intrinsics.areEqual(r1, float[].class) == false) goto L21;
        return "kotlin.FloatArray";
    L21:
        if (Intrinsics.areEqual(r1, long[].class) == false) goto L24;
        return "kotlin.LongArray";
    L24:
        if (Intrinsics.areEqual(r1, double[].class) == false) goto L26;
        return "kotlin.DoubleArray";
    L26:
        return "kotlin.Array";
    }

    private final String asString(KTypeProjection r3) {
        if (r3.getVariance() != null) goto L6;
        return ContactsUtils.CHAR_STAR;
    L6:
        KType r2 = r3.getType();
        if ((r2 instanceof TypeReference) == false) goto L9;
        TypeReference r4 = (TypeReference) r2;
    L11:
        if (r4 == null) goto L14;
        String r5 = r4.asString(true);
        if (r5 == null) goto L14;
    L15:
        int r6 = WhenMappings.$EnumSwitchMapping$0[r3.getVariance().ordinal()];
        if (r6 != 1) goto L18;
        return r5;
    L18:
        if (r6 == 2) goto L25;
        if (r6 != 3) goto L23;
        return "out " + r5;
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        return "in " + r5;
    L14:
        r5 = String.valueOf(r3.getType());
        goto L15
    L9:
        r4 = null;
        goto L11
    }
}
