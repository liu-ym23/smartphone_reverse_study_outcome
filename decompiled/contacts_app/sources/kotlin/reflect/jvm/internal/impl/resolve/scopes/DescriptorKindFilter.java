package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL = null;
    private static final int ALL_KINDS_MASK = 0;
    public static final DescriptorKindFilter CALLABLES = null;
    private static final int CALLABLES_MASK = 0;
    public static final DescriptorKindFilter CLASSIFIERS = null;
    private static final int CLASSIFIERS_MASK = 0;
    public static final Companion Companion = null;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES = null;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES = null;
    public static final DescriptorKindFilter FUNCTIONS = null;
    private static final int FUNCTIONS_MASK = 0;
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS = null;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK = 0;
    public static final DescriptorKindFilter PACKAGES = null;
    private static final int PACKAGES_MASK = 0;
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS = null;
    private static final int SINGLETON_CLASSIFIERS_MASK = 0;
    public static final DescriptorKindFilter TYPE_ALIASES = null;
    private static final int TYPE_ALIASES_MASK = 0;
    public static final DescriptorKindFilter VALUES = null;
    private static final int VALUES_MASK = 0;
    public static final DescriptorKindFilter VARIABLES = null;
    private static final int VARIABLES_MASK = 0;
    private static int nextMaskValue;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: MemberScope.kt */
        private static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "name");
                this.mask = r2;
                this.name = r3;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ int access$nextMask(Companion r0) {
            return r0.nextMask();
        }

        private final int nextMask() {
            int r1 = DescriptorKindFilter.access$getNextMaskValue$cp();
            Companion r0 = DescriptorKindFilter.Companion;
            DescriptorKindFilter.access$setNextMaskValue$cp(DescriptorKindFilter.access$getNextMaskValue$cp() << 1);
            return r1;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getSINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.access$getTYPE_ALIASES_MASK$cp();
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.access$getPACKAGES_MASK$cp();
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.access$getFUNCTIONS_MASK$cp();
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.access$getVARIABLES_MASK$cp();
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.access$getALL_KINDS_MASK$cp();
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getCLASSIFIERS_MASK$cp();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int r2, List<? extends DescriptorKindExclude> r3) {
        Intrinsics.checkNotNullParameter(r3, "excludes");
        this.excludes = r3;
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r2 = r2 & (~((DescriptorKindExclude) r4.next()).getFullyExcludedDescriptorKinds());
        goto L4
    L6:
        this.kindMask = r2;
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return ALL_KINDS_MASK;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return FUNCTIONS_MASK;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return NON_SINGLETON_CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return nextMaskValue;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return PACKAGES_MASK;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return SINGLETON_CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return TYPE_ALIASES_MASK;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return VARIABLES_MASK;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int r0) {
        nextMaskValue = r0;
    }

    public /* synthetic */ DescriptorKindFilter(int r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        this(r1, r2);
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final boolean acceptsKinds(int r1) {
        if ((this.kindMask & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int r2) {
        int r3 = r2 & this.kindMask;
        if (r3 != 0) goto L7;
        return null;
    L7:
        return new DescriptorKindFilter(r3, this.excludes);
    }

    public String toString() {
        Iterator<T> r0 = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((Companion.MaskToName) r1).getMask() != this.kindMask) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        Companion.MaskToName r2 = (Companion.MaskToName) r1;
        if (r2 == null) goto L15;
        String r4 = r2.getName();
    L16:
        if (r4 != null) goto L28;
        List<Companion.MaskToName> r5 = DEBUG_MASK_BIT_NAMES;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L26;
        Companion.MaskToName r8 = (Companion.MaskToName) r7.next();
        if (acceptsKinds(r8.getMask()) == false) goto L23;
        String r9 = r8.getName();
    L24:
        if (r9 == null) goto L19;
        r6.add(r9);
        goto L19
    L23:
        r9 = null;
        goto L24
    L26:
        r4 = CollectionsKt.joinToString$default(r6, " | ", null, null, 0, null, null, 62, null);
    L28:
        return "DescriptorKindFilter(" + r4 + ", " + this.excludes + ')';
    L15:
        r4 = null;
        goto L16
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter r6 = (DescriptorKindFilter) r5;
        if (Intrinsics.areEqual(this.excludes, r6.excludes) == true) goto L16;
        return false;
    L16:
        if (this.kindMask == r6.kindMask) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        nextMaskValue = 1;
        int r3 = Companion.access$nextMask(r0);
        NON_SINGLETON_CLASSIFIERS_MASK = r3;
        int r4 = Companion.access$nextMask(r0);
        SINGLETON_CLASSIFIERS_MASK = r4;
        int r5 = Companion.access$nextMask(r0);
        TYPE_ALIASES_MASK = r5;
        int r6 = Companion.access$nextMask(r0);
        PACKAGES_MASK = r6;
        int r7 = Companion.access$nextMask(r0);
        FUNCTIONS_MASK = r7;
        int r8 = Companion.access$nextMask(r0);
        VARIABLES_MASK = r8;
        int r1 = Companion.access$nextMask(r0) - 1;
        ALL_KINDS_MASK = r1;
        int r9 = (r3 | r4) | r5;
        CLASSIFIERS_MASK = r9;
        int r10 = (r4 | r7) | r8;
        VALUES_MASK = r10;
        int r11 = r7 | r8;
        CALLABLES_MASK = r11;
        int r13 = 2;
        ALL = new DescriptorKindFilter(r1, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        CALLABLES = new DescriptorKindFilter(r11, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r3, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r4, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        TYPE_ALIASES = new DescriptorKindFilter(r5, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        CLASSIFIERS = new DescriptorKindFilter(r9, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        PACKAGES = new DescriptorKindFilter(r6, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        FUNCTIONS = new DescriptorKindFilter(r7, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        VARIABLES = new DescriptorKindFilter(r8, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        VALUES = new DescriptorKindFilter(r10, 0 == true ? 1 : 0, r13, 0 == true ? 1 : 0);
        Field[] r12 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(r12, "T::class.java.fields");
        Field[] r14 = r12;
        ArrayList r15 = new ArrayList();
        int r16 = r14.length;
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L8;
        Field r18 = r14[r17];
        if (Modifier.isStatic(r18.getModifiers()) == false) goto L7;
        r15.add(r18);
    L7:
        r17 = r17 + 1;
        goto L3
    L8:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r15.iterator();
    L10:
        if (r20.hasNext() == false) goto L20;
        Field r21 = (Field) r20.next();
        Object r22 = r21.get(null);
        if ((r22 instanceof DescriptorKindFilter) == false) goto L14;
        DescriptorKindFilter r23 = (DescriptorKindFilter) r22;
    L15:
        if (r23 == null) goto L17;
        int r24 = r23.kindMask;
        String r25 = r21.getName();
        Intrinsics.checkNotNullExpressionValue(r25, "field.name");
        Companion.MaskToName r110 = new Companion.MaskToName(r24, r25);
    L18:
        if (r110 == null) goto L10;
        r19.add(r110);
        goto L10
    L17:
        r110 = null;
        goto L18
    L14:
        r23 = null;
        goto L15
    L20:
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = r19;
        Field[] r2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(r2, "T::class.java.fields");
        Field[] r26 = r2;
        ArrayList r27 = new ArrayList();
        int r28 = r26.length;
        int r29 = 0;
    L21:
        if (r29 >= r28) goto L26;
        Field r30 = r26[r29];
        if (Modifier.isStatic(r30.getModifiers()) == false) goto L25;
        r27.add(r30);
    L25:
        r29 = r29 + 1;
        goto L21
    L26:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r27.iterator();
    L28:
        if (r32.hasNext() == false) goto L32;
        Object r33 = r32.next();
        if (Intrinsics.areEqual(((Field) r33).getType(), Integer.TYPE) == false) goto L28;
        r31.add(r33);
        goto L28
    L32:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r31.iterator();
    L34:
        if (r35.hasNext() == false) goto L44;
        Field r36 = (Field) r35.next();
        Object r37 = r36.get(null);
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type kotlin.Int");
        int r38 = ((Integer) r37).intValue();
        if (r38 != ((-r38) & r38)) goto L38;
        Object[] r39 = true;
    L39:
        if (r39 == false) goto L41;
        String r40 = r36.getName();
        Intrinsics.checkNotNullExpressionValue(r40, "field.name");
        Companion.MaskToName r41 = new Companion.MaskToName(r38, r40);
    L42:
        if (r41 == null) goto L34;
        r34.add(r41);
        goto L34
    L41:
        r41 = null;
        goto L42
    L38:
        r39 = false;
        goto L39
    L44:
        DEBUG_MASK_BIT_NAMES = r34;
    }
}
