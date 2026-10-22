package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum FunctionClassKind extends Enum<FunctionClassKind> {
    private static final /* synthetic */ FunctionClassKind[] $VALUES = null;
    public static final Companion Companion = null;
    public static final FunctionClassKind Function = null;
    public static final FunctionClassKind KFunction = null;
    public static final FunctionClassKind KSuspendFunction = null;
    public static final FunctionClassKind SuspendFunction = null;
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    private final FqName packageFqName;

    /* JADX INFO: compiled from: FunctionClassKind.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: FunctionClassKind.kt */
        public static final class KindWithArity {
            private final int arity;
            private final FunctionClassKind kind;

            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof KindWithArity) == true) goto L8;
                return false;
            L8:
                KindWithArity r6 = (KindWithArity) r5;
                if (this.kind == r6.kind) goto L12;
                return false;
            L12:
                if (this.arity == r6.arity) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }

            public KindWithArity(FunctionClassKind r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, "kind");
                this.kind = r2;
                this.arity = r3;
            }

            public final FunctionClassKind getKind() {
                return this.kind;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final FunctionClassKind byClassNamePrefix(FqName r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "packageFqName");
            Intrinsics.checkNotNullParameter(r9, "className");
            FunctionClassKind[] r7 = FunctionClassKind.values();
            int r0 = r7.length;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L17;
            FunctionClassKind r4 = r7[r2];
            if (Intrinsics.areEqual(r4.getPackageFqName(), r8) == true) goto L8;
        L10:
            boolean r3 = false;
        L11:
            if (r3 == true) goto L14;
            r2 = r2 + 1;
            goto L4
        L14:
            return r4;
        L8:
            if (StringsKt.startsWith$default(r9, r4.getClassNamePrefix(), false, 2, null) == false) goto L10;
            r3 = true;
            goto L11
        L17:
            return null;
        }

        public final KindWithArity parseClassName(String r3, FqName r4) {
            Intrinsics.checkNotNullParameter(r3, "className");
            Intrinsics.checkNotNullParameter(r4, "packageFqName");
            FunctionClassKind r5 = byClassNamePrefix(r4, r3);
            if (r5 != null) goto L5;
            return null;
        L5:
            String r6 = r3.substring(r5.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
            Integer r2 = toInt(r6);
            if (r2 != null) goto L8;
            return null;
        L8:
            return new KindWithArity(r5, r2.intValue());
        }

        @JvmStatic
        public final FunctionClassKind getFunctionalClassKind(String r2, FqName r3) {
            Intrinsics.checkNotNullParameter(r2, "className");
            Intrinsics.checkNotNullParameter(r3, "packageFqName");
            KindWithArity r1 = parseClassName(r2, r3);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.getKind();
        }

        private final Integer toInt(String r8) {
            if (r8.length() != 0) goto L5;
            boolean r7 = true;
        L7:
            if (r7 == false) goto L9;
            return null;
        L9:
            int r9 = r8.length();
            int r3 = 0;
            int r4 = 0;
        L10:
            if (r3 >= r9) goto L21;
            int r5 = r8.charAt(r3) - '0';
            if (r5 >= 0) goto L14;
        L16:
            boolean r6 = false;
        L17:
            if (r6 == false) goto L18;
            r4 = (r4 * 10) + r5;
            r3 = r3 + 1;
            goto L10
        L18:
            return null;
        L14:
            if (r5 >= 10) goto L16;
            r6 = true;
            goto L17
        L21:
            return Integer.valueOf(r4);
        L5:
            r7 = false;
            goto L7
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    public static FunctionClassKind valueOf(String r1) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, r1);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    private FunctionClassKind(String r1, int r2, FqName r3, String r4, boolean r5, boolean r6) {
        super(r1, r2);
        this.packageFqName = r3;
        this.classNamePrefix = r4;
        this.isSuspendType = r5;
        this.isReflectType = r6;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    static {
        Function = new FunctionClassKind("Function", 0, StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, false);
        SuspendFunction = new FunctionClassKind("SuspendFunction", 1, StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", true, false);
        KFunction = new FunctionClassKind("KFunction", 2, StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", false, true);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3, StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, true);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final Name numberedClassName(int r2) {
        Name r1 = Name.identifier(this.classNamePrefix + r2);
        Intrinsics.checkNotNullExpressionValue(r1, "identifier(\"$classNamePrefix$arity\")");
        return r1;
    }
}
