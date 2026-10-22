package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = null;

    /* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r1) {
            this();
        }

        private Factory() {
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r12, "functionClass");
            List<TypeParameterDescriptor> r11 = r12.getDeclaredTypeParameters();
            FunctionInvokeDescriptor r9 = new FunctionInvokeDescriptor(r12, null, CallableMemberDescriptor.Kind.DECLARATION, r13, null);
            ReceiverParameterDescriptor r2 = r12.getThisAsReceiverParameter();
            List r3 = CollectionsKt.emptyList();
            List r4 = CollectionsKt.emptyList();
            ArrayList r14 = new ArrayList();
            Iterator<T> r15 = r11.iterator();
        L4:
            if (r15.hasNext() == false) goto L12;
            Object r0 = r15.next();
            if (((TypeParameterDescriptor) r0).getVariance() != Variance.IN_VARIANCE) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L12;
            r14.add(r0);
            goto L4
        L8:
            r5 = false;
        L12:
            Iterable r16 = CollectionsKt.withIndex(r14);
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator r18 = r16.iterator();
        L14:
            if (r18.hasNext() == false) goto L16;
            IndexedValue r1 = (IndexedValue) r18.next();
            r17.add(FunctionInvokeDescriptor.Factory.createValueParameter(r9, r1.getIndex(), (TypeParameterDescriptor) r1.getValue()));
            goto L14
        L16:
            r9.initialize(null, r2, r3, r4, r17, ((TypeParameterDescriptor) CollectionsKt.last(r11)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            r9.setHasSynthesizedParameterNames(true);
            return r9;
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor r15, int r16, TypeParameterDescriptor r17) {
            String r0 = r17.getName().asString();
            Intrinsics.checkNotNullExpressionValue(r0, "typeParameter.name.asString()");
            if (Intrinsics.areEqual(r0, ExifInterface.GPS_DIRECTION_TRUE) == false) goto L6;
            String r1 = "instance";
        L9:
            Annotations r5 = Annotations.Companion.getEMPTY();
            Name r6 = Name.identifier(r1);
            Intrinsics.checkNotNullExpressionValue(r6, "identifier(name)");
            SimpleType r2 = r17.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(r2, "typeParameter.defaultType");
            SourceElement r12 = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(r12, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(r15, null, r16, r5, r6, r2, false, false, false, null, r12);
        L6:
            if (Intrinsics.areEqual(r0, ExifInterface.LONGITUDE_EAST) == false) goto L8;
            r1 = "receiver";
            goto L9
        L8:
            r1 = r0.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            goto L9
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor r1, FunctionInvokeDescriptor r2, CallableMemberDescriptor.Kind r3, boolean r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor r8, FunctionInvokeDescriptor r9, CallableMemberDescriptor.Kind r10, boolean r11) {
        super(r8, r9, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, r10, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(r11);
        setHasStableParameterNames(false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration r6) {
        Intrinsics.checkNotNullParameter(r6, "configuration");
        FunctionInvokeDescriptor r5 = (FunctionInvokeDescriptor) super.doSubstitute(r6);
        if (r5 != null) goto L6;
        return null;
    L6:
        List<ValueParameterDescriptor> r7 = r5.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "substituted.valueParameters");
        List<ValueParameterDescriptor> r8 = r7;
        boolean r3 = true;
        if ((r8 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L20;
        KotlinType r1 = ((ValueParameterDescriptor) r9.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r1, "it.type");
        if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r1) == null) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L13;
        r3 = false;
        goto L20
    L17:
        r2 = false;
    L20:
        if (r3 == true) goto L22;
        List<ValueParameterDescriptor> r10 = r5.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r10, "substituted.valueParameters");
        List<ValueParameterDescriptor> r11 = r10;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L25:
        if (r12.hasNext() == false) goto L28;
        KotlinType r4 = ((ValueParameterDescriptor) r12.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r4, "it.type");
        r0.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r4));
        goto L25
    L28:
        return r5.replaceParameterNames(r0);
    L22:
        return r5;
    L9:
        if (r8.isEmpty() == false) goto L11;
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6) {
        Intrinsics.checkNotNullParameter(r1, "newOwner");
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Intrinsics.checkNotNullParameter(r6, "source");
        return new FunctionInvokeDescriptor(r1, (FunctionInvokeDescriptor) r2, r3, isSuspend());
    }

    private final FunctionDescriptor replaceParameterNames(List<Name> r10) {
        int r0 = getValueParameters().size() - r10.size();
        boolean r1 = true;
        if (r0 != 0) goto L18;
        List<ValueParameterDescriptor> r5 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "valueParameters");
        List r4 = CollectionsKt.zip(r10, r5);
        if ((r4 instanceof Collection) == true) goto L7;
    L9:
        Iterator r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        Pair r7 = (Pair) r6.next();
        if (Intrinsics.areEqual((Name) r7.component1(), ((ValueParameterDescriptor) r7.component2()).getName()) == true) goto L11;
        boolean r8 = false;
    L15:
        if (r8 == false) goto L18;
        return this;
    L8:
        r8 = true;
        goto L15
    L7:
        if (r4.isEmpty() == false) goto L9;
    L18:
        List<ValueParameterDescriptor> r9 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r9, "valueParameters");
        List<ValueParameterDescriptor> r11 = r9;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L27;
        ValueParameterDescriptor r13 = (ValueParameterDescriptor) r12.next();
        Name r14 = r13.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "it.name");
        int r15 = r13.getIndex();
        int r16 = r15 - r0;
        if (r16 < 0) goto L26;
        Name r17 = r10.get(r16);
        if (r17 == null) goto L26;
        r14 = r17;
    L26:
        r2.add(r13.copy(this, r14, r15));
        goto L20
    L27:
        ArrayList r3 = r2;
        FunctionDescriptorImpl.CopyConfiguration r18 = newCopyBuilder(TypeSubstitutor.EMPTY);
        List<Name> r19 = r10;
        if ((r19 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r110 = r19.iterator();
    L34:
        if (r110.hasNext() == false) goto L31;
        if (((Name) r110.next()) != null) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L34;
    L40:
        FunctionDescriptorImpl.CopyConfiguration r111 = r18.setHasSynthesizedParameterNames(r1).setValueParameters(r3).setOriginal(getOriginal());
        Intrinsics.checkNotNullExpressionValue(r111, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        FunctionDescriptor r21 = super.doSubstitute(r111);
        Intrinsics.checkNotNull(r21);
        return r21;
    L38:
        r20 = false;
    L31:
        r1 = false;
        goto L40
    L30:
        if (r19.isEmpty() == false) goto L32;
        goto L31
    }
}
