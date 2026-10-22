package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.android.contacts.ContactsUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RawTypeImpl extends FlexibleType implements RawType {
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r1) {
        return makeNullableAsSpecified(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r1) {
        return replaceAttributes(r1);
    }

    private RawTypeImpl(SimpleType r1, SimpleType r2, boolean r3) {
        super(r1, r2);
        if (r3 == true) goto L6;
        KotlinTypeChecker.DEFAULT.isSubtypeOf(r1, r2);
        return;
    }

    public RawTypeImpl(SimpleType r2, SimpleType r3) {
        Intrinsics.checkNotNullParameter(r2, "lowerBound");
        Intrinsics.checkNotNullParameter(r3, "upperBound");
        this(r2, r3, false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        ClassifierDescriptor r0 = getConstructor().mo2083getDeclarationDescriptor();
        TypeParameterUpperBoundEraser r2 = null;
        Object[] r3 = 0;
        if ((r0 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r1 = (ClassDescriptor) r0;
    L6:
        if (r1 == null) goto L10;
        MemberScope r4 = r1.getMemberScope(new RawSubstitution(r2, 1, r3 == true ? 1 : 0));
        Intrinsics.checkNotNullExpressionValue(r4, "classDescriptor.getMemberScope(RawSubstitution())");
        return r4;
    L10:
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().mo2083getDeclarationDescriptor()).toString());
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl replaceAttributes(TypeAttributes r3) {
        Intrinsics.checkNotNullParameter(r3, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(r3), getUpperBound().replaceAttributes(r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public RawTypeImpl makeNullableAsSpecified(boolean r3) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(r3), getUpperBound().makeNullableAsSpecified(r3));
    }

    private static final boolean render$onlyOutDiffers(String r1, String r2) {
        if (Intrinsics.areEqual(r1, StringsKt.removePrefix(r2, "out ")) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, ContactsUtils.CHAR_STAR) == true) goto L8;
        return false;
    }

    private static final List<String> render$renderArguments(DescriptorRenderer r2, KotlinType r3) {
        List<TypeProjection> r4 = r3.getArguments();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.add(r2.renderTypeProjection((TypeProjection) r5.next()));
        goto L4
    L7:
        return r0;
    }

    private static final String render$replaceArgs(String r5, String r6) {
        if (StringsKt.contains$default(r5, '<', false, 2, null) == true) goto L6;
        return r5;
    L6:
        return StringsKt.substringBefore$default(r5, '<', null, 2, null) + '<' + r6 + '>' + StringsKt.substringAfterLast$default(r5, '>', null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r13, DescriptorRendererOptions r14) {
        Intrinsics.checkNotNullParameter(r13, "renderer");
        Intrinsics.checkNotNullParameter(r14, "options");
        String r0 = r13.renderType(getLowerBound());
        String r1 = r13.renderType(getUpperBound());
        if (r14.getDebugMode() == false) goto L7;
        return "raw (" + r0 + ".." + r1 + ')';
    L7:
        if (getUpperBound().getArguments().isEmpty() == true) goto L9;
        List<String> r15 = render$renderArguments(r13, getLowerBound());
        List<String> r2 = render$renderArguments(r13, getUpperBound());
        List<String> r16 = r15;
        String r3 = CollectionsKt.joinToString$default(r16, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, null);
        List r17 = CollectionsKt.zip(r16, r2);
        boolean r4 = true;
        if ((r17 instanceof Collection) == true) goto L13;
    L15:
        Iterator r18 = r17.iterator();
    L17:
        if (r18.hasNext() == false) goto L21;
        Pair r5 = (Pair) r18.next();
        if (render$onlyOutDiffers((String) r5.getFirst(), (String) r5.getSecond()) == true) goto L17;
        r4 = false;
    L21:
        if (r4 == false) goto L23;
        r1 = render$replaceArgs(r1, r3);
    L23:
        String r19 = render$replaceArgs(r0, r3);
        if (Intrinsics.areEqual(r19, r1) == false) goto L27;
        return r19;
    L27:
        return r13.renderFlexibleType(r19, r1, TypeUtilsKt.getBuiltIns(this));
    L13:
        if (r17.isEmpty() == false) goto L15;
    L9:
        return r13.renderFlexibleType(r0, r1, TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner r4) {
        Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
        KotlinType r1 = r4.refineType(getLowerBound());
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r3 = r4.refineType(getUpperBound());
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) r1, (SimpleType) r3, true);
    }
}
