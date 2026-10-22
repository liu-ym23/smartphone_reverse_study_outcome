package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.list.DefaultContactListAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = null;
    private final ModuleDescriptor module;
    private final Set<KotlinType> possibleTypes;
    private final Lazy supertypes$delegate;
    private final SimpleType type;
    private final long value;

    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
        private static final enum Mode extends Enum<Mode> {
            private static final /* synthetic */ Mode[] $VALUES = null;
            public static final Mode COMMON_SUPER_TYPE = null;
            public static final Mode INTERSECTION_TYPE = null;

            private static final /* synthetic */ Mode[] $values() {
                return new Mode[]{COMMON_SUPER_TYPE, INTERSECTION_TYPE};
            }

            public static Mode valueOf(String r1) {
                return (Mode) Enum.valueOf(Mode.class, r1);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }

            private Mode(String r1, int r2) {
                super(r1, r2);
            }

            static {
                COMMON_SUPER_TYPE = new Mode("COMMON_SUPER_TYPE", 0);
                INTERSECTION_TYPE = new Mode("INTERSECTION_TYPE", 1);
                $VALUES = $values();
            }
        }

        /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[Mode.values().length];
                r0[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Mode.INTERSECTION_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final SimpleType findIntersectionType(Collection<? extends SimpleType> r2) {
            Intrinsics.checkNotNullParameter(r2, GloableSearchConfig.KEY_CONFIGS);
            return findCommonSuperTypeOrIntersectionType(r2, Mode.INTERSECTION_TYPE);
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> r3, Mode r4) {
            if (r3.isEmpty() == false) goto L6;
            return null;
        L6:
            Iterator<T> r2 = r3.iterator();
            if (r2.hasNext() == false) goto L15;
            Object r5 = r2.next();
        L10:
            if (r2.hasNext() == false) goto L13;
            SimpleType r0 = (SimpleType) r2.next();
            Companion r1 = IntegerLiteralTypeConstructor.Companion;
            r5 = r1.fold((SimpleType) r5, r0, r4);
            goto L10
        L13:
            return (SimpleType) r5;
        L15:
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(SimpleType r6, SimpleType r7, Mode r8) {
            if (r6 == null) goto L17;
            if (r7 == null) goto L21;
            TypeConstructor r1 = r6.getConstructor();
            TypeConstructor r2 = r7.getConstructor();
            boolean r3 = r1 instanceof IntegerLiteralTypeConstructor;
            if (r3 == true) goto L9;
        L11:
            if (r3 == false) goto L14;
            return fold((IntegerLiteralTypeConstructor) r1, r7);
        L14:
            if ((r2 instanceof IntegerLiteralTypeConstructor) == true) goto L16;
            return null;
        L16:
            return fold((IntegerLiteralTypeConstructor) r2, r6);
        L9:
            if ((r2 instanceof IntegerLiteralTypeConstructor) == false) goto L11;
            return fold((IntegerLiteralTypeConstructor) r1, (IntegerLiteralTypeConstructor) r2, r8);
        L21:
            return null;
        L17:
            return null;
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor r7, IntegerLiteralTypeConstructor r8, Mode r9) {
            int r6 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
            if (r6 != 1) goto L5;
            Set r10 = CollectionsKt.intersect(r7.getPossibleTypes(), r8.getPossibleTypes());
        L10:
            long r1 = IntegerLiteralTypeConstructor.access$getValue$p(r7);
            ModuleDescriptor r3 = IntegerLiteralTypeConstructor.access$getModule$p(r7);
            IntegerLiteralTypeConstructor r11 = new IntegerLiteralTypeConstructor(r1, r3, r10, null);
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), r11, false);
        L5:
            if (r6 != 2) goto L8;
            r10 = CollectionsKt.union(r7.getPossibleTypes(), r8.getPossibleTypes());
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor r1, SimpleType r2) {
            if (r1.getPossibleTypes().contains(r2) == true) goto L7;
            return null;
        L7:
            return r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long r1, ModuleDescriptor r3, Set r4, DefaultConstructorMarker r5) {
        this(r1, r3, r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2083getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public static final /* synthetic */ ModuleDescriptor access$getModule$p(IntegerLiteralTypeConstructor r0) {
        return r0.module;
    }

    public static final /* synthetic */ SimpleType access$getType$p(IntegerLiteralTypeConstructor r0) {
        return r0.type;
    }

    public static final /* synthetic */ long access$getValue$p(IntegerLiteralTypeConstructor r2) {
        return r2.value;
    }

    public static final /* synthetic */ boolean access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor r0) {
        return r0.isContainsOnlyUnsignedTypes();
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long r3, ModuleDescriptor r5, Set<? extends KotlinType> r6) {
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        this.supertypes$delegate = LazyKt.lazy(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.value = r3;
        this.module = r5;
        this.possibleTypes = r6;
    }

    private final boolean isContainsOnlyUnsignedTypes() {
        Collection<KotlinType> r0 = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if ((!this.possibleTypes.contains((KotlinType) r1.next())) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return true;
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes, reason: collision with other method in class */
    public Collection<KotlinType> mo2084getSupertypes() {
        return getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }

    private final String valueToString() {
        return "[" + CollectionsKt.joinToString$default(this.possibleTypes, SimContactsConstants.EMAIL_SEP, null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + DefaultContactListAdapter.SNIPPET_END_MATCH;
    }
}
