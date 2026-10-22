package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isActual;
    private boolean isExpect;
    private boolean isExternal;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isInfix;
    private boolean isInline;
    private boolean isOperator;
    private boolean isSuspend;
    private boolean isTailrec;
    private final CallableMemberDescriptor.Kind kind;
    private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private Modality modality;
    private final FunctionDescriptor original;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private List<TypeParameterDescriptor> typeParameters;
    private KotlinType unsubstitutedReturnType;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;
    private DescriptorVisibility visibility;

    public class CopyConfiguration implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        private Annotations additionalAnnotations;
        protected boolean copyOverrides;
        protected ReceiverParameterDescriptor dispatchReceiverParameter;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private boolean isHiddenToOvercomeSignatureClash;
        protected boolean justForTypeSubstitution;
        protected CallableMemberDescriptor.Kind kind;
        protected Name name;
        protected List<ReceiverParameterDescriptor> newContextReceiverParameters;
        protected ReceiverParameterDescriptor newExtensionReceiverParameter;
        private Boolean newHasSynthesizedParameterNames;
        protected Modality newModality;
        protected DeclarationDescriptor newOwner;
        protected KotlinType newReturnType;
        private List<TypeParameterDescriptor> newTypeParameters;
        protected List<ValueParameterDescriptor> newValueParameterDescriptors;
        protected DescriptorVisibility newVisibility;
        protected FunctionDescriptor original;
        protected boolean preserveSourceElement;
        protected boolean signatureChange;
        protected TypeSubstitution substitution;
        final /* synthetic */ FunctionDescriptorImpl this$0;
        private Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;

        private static /* synthetic */ void $$$reportNull$$$0(int r17) {
            switch(r17) {
                case 9: goto L4;
                case 10: goto L3;
                case 11: goto L4;
                case 12: goto L3;
                case 13: goto L4;
                case 14: goto L3;
                case 15: goto L4;
                case 16: goto L4;
                case 17: goto L3;
                case 18: goto L4;
                case 19: goto L3;
                case 20: goto L4;
                case 21: goto L3;
                case 22: goto L4;
                case 23: goto L3;
                case 24: goto L4;
                case 25: goto L3;
                case 26: goto L4;
                case 27: goto L4;
                case 28: goto L4;
                case 29: goto L4;
                case 30: goto L4;
                case 31: goto L4;
                case 32: goto L4;
                case 33: goto L4;
                case 34: goto L4;
                case 35: goto L3;
                case 36: goto L4;
                case 37: goto L3;
                case 38: goto L4;
                case 39: goto L3;
                case 40: goto L4;
                case 41: goto L4;
                case 42: goto L4;
                default: goto L3;
            };
        L3:
            String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            switch(r17) {
                case 9: goto L8;
                case 10: goto L7;
                case 11: goto L8;
                case 12: goto L7;
                case 13: goto L8;
                case 14: goto L7;
                case 15: goto L8;
                case 16: goto L8;
                case 17: goto L7;
                case 18: goto L8;
                case 19: goto L7;
                case 20: goto L8;
                case 21: goto L7;
                case 22: goto L8;
                case 23: goto L7;
                case 24: goto L8;
                case 25: goto L7;
                case 26: goto L8;
                case 27: goto L8;
                case 28: goto L8;
                case 29: goto L8;
                case 30: goto L8;
                case 31: goto L8;
                case 32: goto L8;
                case 33: goto L8;
                case 34: goto L8;
                case 35: goto L7;
                case 36: goto L8;
                case 37: goto L7;
                case 38: goto L8;
                case 39: goto L7;
                case 40: goto L8;
                case 41: goto L8;
                case 42: goto L8;
                default: goto L7;
            };
        L7:
            int r2 = 3;
        L9:
            Object[] r3 = new Object[r2];
            switch(r17) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L20;
                case 14: goto L25;
                case 15: goto L20;
                case 16: goto L20;
                case 17: goto L17;
                case 18: goto L20;
                case 19: goto L16;
                case 20: goto L20;
                case 21: goto L16;
                case 22: goto L20;
                case 23: goto L15;
                case 24: goto L20;
                case 25: goto L14;
                case 26: goto L20;
                case 27: goto L20;
                case 28: goto L20;
                case 29: goto L20;
                case 30: goto L20;
                case 31: goto L20;
                case 32: goto L20;
                case 33: goto L20;
                case 34: goto L20;
                case 35: goto L13;
                case 36: goto L20;
                case 37: goto L11;
                case 38: goto L20;
                case 39: goto L12;
                case 40: goto L20;
                case 41: goto L20;
                case 42: goto L20;
                default: goto L11;
            };
        L11:
            r3[0] = "substitution";
        L30:
            switch(r17) {
                case 9: goto L54;
                case 10: goto L31;
                case 11: goto L53;
                case 12: goto L31;
                case 13: goto L52;
                case 14: goto L31;
                case 15: goto L51;
                case 16: goto L50;
                case 17: goto L31;
                case 18: goto L49;
                case 19: goto L31;
                case 20: goto L48;
                case 21: goto L31;
                case 22: goto L47;
                case 23: goto L31;
                case 24: goto L46;
                case 25: goto L31;
                case 26: goto L45;
                case 27: goto L44;
                case 28: goto L43;
                case 29: goto L42;
                case 30: goto L41;
                case 31: goto L40;
                case 32: goto L39;
                case 33: goto L38;
                case 34: goto L37;
                case 35: goto L31;
                case 36: goto L36;
                case 37: goto L31;
                case 38: goto L35;
                case 39: goto L31;
                case 40: goto L34;
                case 41: goto L33;
                case 42: goto L32;
                default: goto L31;
            };
        L31:
            r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
        L55:
            switch(r17) {
                case 8: goto L68;
                case 9: goto L69;
                case 10: goto L67;
                case 11: goto L69;
                case 12: goto L66;
                case 13: goto L69;
                case 14: goto L65;
                case 15: goto L69;
                case 16: goto L69;
                case 17: goto L64;
                case 18: goto L69;
                case 19: goto L63;
                case 20: goto L69;
                case 21: goto L62;
                case 22: goto L69;
                case 23: goto L61;
                case 24: goto L69;
                case 25: goto L60;
                case 26: goto L69;
                case 27: goto L69;
                case 28: goto L69;
                case 29: goto L69;
                case 30: goto L69;
                case 31: goto L69;
                case 32: goto L69;
                case 33: goto L69;
                case 34: goto L69;
                case 35: goto L59;
                case 36: goto L69;
                case 37: goto L58;
                case 38: goto L69;
                case 39: goto L57;
                case 40: goto L69;
                case 41: goto L69;
                case 42: goto L69;
                default: goto L56;
            };
        L56:
            r3[2] = "<init>";
            goto L69
        L57:
            r3[2] = "putUserData";
            goto L69
        L58:
            r3[2] = "setSubstitution";
            goto L69
        L59:
            r3[2] = "setAdditionalAnnotations";
            goto L69
        L60:
            r3[2] = "setContextReceiverParameters";
            goto L69
        L61:
            r3[2] = "setReturnType";
            goto L69
        L62:
            r3[2] = "setTypeParameters";
            goto L69
        L63:
            r3[2] = "setValueParameters";
            goto L69
        L64:
            r3[2] = "setName";
            goto L69
        L65:
            r3[2] = "setKind";
            goto L69
        L66:
            r3[2] = "setVisibility";
            goto L69
        L67:
            r3[2] = "setModality";
            goto L69
        L68:
            r3[2] = "setOwner";
        L69:
            String r1 = String.format(r0, r3);
            switch(r17) {
                case 9: goto L73;
                case 10: goto L74;
                case 11: goto L73;
                case 12: goto L74;
                case 13: goto L73;
                case 14: goto L74;
                case 15: goto L73;
                case 16: goto L73;
                case 17: goto L74;
                case 18: goto L73;
                case 19: goto L74;
                case 20: goto L73;
                case 21: goto L74;
                case 22: goto L73;
                case 23: goto L74;
                case 24: goto L73;
                case 25: goto L74;
                case 26: goto L73;
                case 27: goto L73;
                case 28: goto L73;
                case 29: goto L73;
                case 30: goto L73;
                case 31: goto L73;
                case 32: goto L73;
                case 33: goto L73;
                case 34: goto L73;
                case 35: goto L74;
                case 36: goto L73;
                case 37: goto L74;
                case 38: goto L73;
                case 39: goto L74;
                case 40: goto L73;
                case 41: goto L73;
                case 42: goto L73;
                default: goto L74;
            };
        L74:
            throw new IllegalArgumentException(r1);
        L73:
            throw new IllegalStateException(r1);
        L32:
            r3[1] = "setJustForTypeSubstitution";
            goto L55
        L33:
            r3[1] = "getSubstitution";
            goto L55
        L34:
            r3[1] = "putUserData";
            goto L55
        L35:
            r3[1] = "setSubstitution";
            goto L55
        L36:
            r3[1] = "setAdditionalAnnotations";
            goto L55
        L37:
            r3[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
            goto L55
        L38:
            r3[1] = "setHiddenToOvercomeSignatureClash";
            goto L55
        L39:
            r3[1] = "setDropOriginalInContainingParts";
            goto L55
        L40:
            r3[1] = "setPreserveSourceElement";
            goto L55
        L41:
            r3[1] = "setSignatureChange";
            goto L55
        L42:
            r3[1] = "setOriginal";
            goto L55
        L43:
            r3[1] = "setDispatchReceiverParameter";
            goto L55
        L44:
            r3[1] = "setExtensionReceiverParameter";
            goto L55
        L45:
            r3[1] = "setContextReceiverParameters";
            goto L55
        L46:
            r3[1] = "setReturnType";
            goto L55
        L47:
            r3[1] = "setTypeParameters";
            goto L55
        L48:
            r3[1] = "setValueParameters";
            goto L55
        L49:
            r3[1] = "setName";
            goto L55
        L50:
            r3[1] = "setCopyOverrides";
            goto L55
        L51:
            r3[1] = "setKind";
            goto L55
        L52:
            r3[1] = "setVisibility";
            goto L55
        L53:
            r3[1] = "setModality";
            goto L55
        L54:
            r3[1] = "setOwner";
            goto L55
        L12:
            r3[0] = "userDataKey";
            goto L30
        L13:
            r3[0] = "additionalAnnotations";
            goto L30
        L14:
            r3[0] = "contextReceiverParameters";
            goto L30
        L15:
            r3[0] = "type";
            goto L30
        L16:
            r3[0] = "parameters";
            goto L30
        L17:
            r3[0] = "name";
            goto L30
        L18:
            r3[0] = "visibility";
            goto L30
        L19:
            r3[0] = "modality";
            goto L30
        L20:
            r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
            goto L30
        L21:
            r3[0] = "owner";
            goto L30
        L22:
            r3[0] = "newReturnType";
            goto L30
        L23:
            r3[0] = "newContextReceiverParameters";
            goto L30
        L24:
            r3[0] = "newValueParameterDescriptors";
            goto L30
        L25:
            r3[0] = "kind";
            goto L30
        L26:
            r3[0] = "newVisibility";
            goto L30
        L27:
            r3[0] = "newModality";
            goto L30
        L28:
            r3[0] = "newOwner";
            goto L30
        L8:
            r2 = 2;
            goto L9
        L4:
            r0 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        static /* synthetic */ Annotations access$100(CopyConfiguration r0) {
            return r0.additionalAnnotations;
        }

        static /* synthetic */ List access$200(CopyConfiguration r0) {
            return r0.newTypeParameters;
        }

        static /* synthetic */ boolean access$300(CopyConfiguration r0) {
            return r0.isHiddenToOvercomeSignatureClash;
        }

        static /* synthetic */ boolean access$400(CopyConfiguration r0) {
            return r0.isHiddenForResolutionEverywhereBesideSupercalls;
        }

        static /* synthetic */ Boolean access$500(CopyConfiguration r0) {
            return r0.newHasSynthesizedParameterNames;
        }

        static /* synthetic */ Map access$600(CopyConfiguration r0) {
            return r0.userDataMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setAdditionalAnnotations(Annotations r1) {
            return setAdditionalAnnotations(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setCopyOverrides(boolean r1) {
            return setCopyOverrides(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setDispatchReceiverParameter(ReceiverParameterDescriptor r1) {
            return setDispatchReceiverParameter(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setDropOriginalInContainingParts() {
            return setDropOriginalInContainingParts();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setExtensionReceiverParameter(ReceiverParameterDescriptor r1) {
            return setExtensionReceiverParameter(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setHiddenForResolutionEverywhereBesideSupercalls() {
            return setHiddenForResolutionEverywhereBesideSupercalls();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setHiddenToOvercomeSignatureClash() {
            return setHiddenToOvercomeSignatureClash();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setKind(CallableMemberDescriptor.Kind r1) {
            return setKind(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setModality(Modality r1) {
            return setModality(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setName(Name r1) {
            return setName(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setOriginal(CallableMemberDescriptor r1) {
            return setOriginal(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setOwner(DeclarationDescriptor r1) {
            return setOwner(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setPreserveSourceElement() {
            return setPreserveSourceElement();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setReturnType(KotlinType r1) {
            return setReturnType(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setSignatureChange() {
            return setSignatureChange();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setSubstitution(TypeSubstitution r1) {
            return setSubstitution(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setTypeParameters(List r1) {
            return setTypeParameters(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setValueParameters(List r1) {
            return setValueParameters(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder setVisibility(DescriptorVisibility r1) {
            return setVisibility(r1);
        }

        public CopyConfiguration(FunctionDescriptorImpl r5, TypeSubstitution r6, DeclarationDescriptor r7, Modality r8, DescriptorVisibility r9, CallableMemberDescriptor.Kind r10, List<ValueParameterDescriptor> r11, List<ReceiverParameterDescriptor> r12, ReceiverParameterDescriptor r13, KotlinType r14, Name r15) {
            if (r6 != null) goto L6;
            $$$reportNull$$$0(0);
        L6:
            if (r7 != null) goto L8;
            $$$reportNull$$$0(1);
        L8:
            if (r8 != null) goto L10;
            $$$reportNull$$$0(2);
        L10:
            if (r9 != null) goto L12;
            $$$reportNull$$$0(3);
        L12:
            if (r10 != null) goto L14;
            $$$reportNull$$$0(4);
        L14:
            if (r11 != null) goto L16;
            $$$reportNull$$$0(5);
        L16:
            if (r12 != null) goto L18;
            $$$reportNull$$$0(6);
        L18:
            if (r14 != null) goto L20;
            $$$reportNull$$$0(7);
        L20:
            this.this$0 = r5;
            this.original = null;
            this.dispatchReceiverParameter = FunctionDescriptorImpl.access$000(r5);
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = r5.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = r5.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = r6;
            this.newOwner = r7;
            this.newModality = r8;
            this.newVisibility = r9;
            this.kind = r10;
            this.newValueParameterDescriptors = r11;
            this.newContextReceiverParameters = r12;
            this.newExtensionReceiverParameter = r13;
            this.newReturnType = r14;
            this.name = r15;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setOwner(DeclarationDescriptor r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(8);
        L4:
            this.newOwner = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setModality(Modality r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(10);
        L4:
            this.newModality = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setVisibility(DescriptorVisibility r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(12);
        L4:
            this.newVisibility = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setKind(CallableMemberDescriptor.Kind r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(14);
        L4:
            this.kind = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setCopyOverrides(boolean r1) {
            this.copyOverrides = r1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setName(Name r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(17);
        L4:
            this.name = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setValueParameters(List<ValueParameterDescriptor> r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(19);
        L4:
            this.newValueParameterDescriptors = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setTypeParameters(List<TypeParameterDescriptor> r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(21);
        L4:
            this.newTypeParameters = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setReturnType(KotlinType r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(23);
        L4:
            this.newReturnType = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setExtensionReceiverParameter(ReceiverParameterDescriptor r1) {
            this.newExtensionReceiverParameter = r1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setDispatchReceiverParameter(ReceiverParameterDescriptor r1) {
            this.dispatchReceiverParameter = r1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setOriginal(CallableMemberDescriptor r1) {
            this.original = (FunctionDescriptor) r1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setAdditionalAnnotations(Annotations r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(35);
        L4:
            this.additionalAnnotations = r2;
            return this;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean r1) {
            this.newHasSynthesizedParameterNames = Boolean.valueOf(r1);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public CopyConfiguration setSubstitution(TypeSubstitution r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(37);
        L4:
            this.substitution = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(CallableDescriptor.UserDataKey<V> r2, V r3) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(39);
        L4:
            this.userDataMap.put(r2, r3);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        public CopyConfiguration setJustForTypeSubstitution(boolean r1) {
            this.justForTypeSubstitution = r1;
            return this;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        switch(r7) {
            case 9: goto L4;
            case 10: goto L3;
            case 11: goto L3;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L3;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L3;
            case 23: goto L4;
            case 24: goto L3;
            case 25: goto L3;
            case 26: goto L4;
            case 27: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r7) {
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L7;
            case 23: goto L8;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L8;
            case 27: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r7) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L18;
            case 14: goto L18;
            case 15: goto L18;
            case 16: goto L18;
            case 17: goto L15;
            case 18: goto L18;
            case 19: goto L18;
            case 20: goto L18;
            case 21: goto L18;
            case 22: goto L14;
            case 23: goto L18;
            case 24: goto L13;
            case 25: goto L12;
            case 26: goto L18;
            case 27: goto L18;
            case 28: goto L20;
            case 29: goto L13;
            case 30: goto L20;
            case 31: goto L13;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L28:
        switch(r7) {
            case 9: goto L41;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            case 13: goto L40;
            case 14: goto L39;
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L29;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L34;
            case 21: goto L33;
            case 22: goto L29;
            case 23: goto L32;
            case 24: goto L29;
            case 25: goto L29;
            case 26: goto L31;
            case 27: goto L30;
            default: goto L29;
        };
    L29:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
    L42:
        switch(r7) {
            case 5: goto L52;
            case 6: goto L52;
            case 7: goto L52;
            case 8: goto L52;
            case 9: goto L53;
            case 10: goto L51;
            case 11: goto L50;
            case 12: goto L49;
            case 13: goto L53;
            case 14: goto L53;
            case 15: goto L53;
            case 16: goto L53;
            case 17: goto L48;
            case 18: goto L53;
            case 19: goto L53;
            case 20: goto L53;
            case 21: goto L53;
            case 22: goto L47;
            case 23: goto L53;
            case 24: goto L46;
            case 25: goto L45;
            case 26: goto L53;
            case 27: goto L53;
            case 28: goto L44;
            case 29: goto L44;
            case 30: goto L44;
            case 31: goto L44;
            default: goto L43;
        };
    L43:
        r3[2] = "<init>";
        goto L53
    L44:
        r3[2] = "getSubstitutedValueParameters";
        goto L53
    L45:
        r3[2] = "doSubstitute";
        goto L53
    L46:
        r3[2] = "newCopyBuilder";
        goto L53
    L47:
        r3[2] = "substitute";
        goto L53
    L48:
        r3[2] = "setOverriddenDescriptors";
        goto L53
    L49:
        r3[2] = "setExtensionReceiverParameter";
        goto L53
    L50:
        r3[2] = "setReturnType";
        goto L53
    L51:
        r3[2] = "setVisibility";
        goto L53
    L52:
        r3[2] = "initialize";
    L53:
        String r1 = String.format(r0, r3);
        switch(r7) {
            case 9: goto L57;
            case 10: goto L58;
            case 11: goto L58;
            case 12: goto L58;
            case 13: goto L57;
            case 14: goto L57;
            case 15: goto L57;
            case 16: goto L57;
            case 17: goto L58;
            case 18: goto L57;
            case 19: goto L57;
            case 20: goto L57;
            case 21: goto L57;
            case 22: goto L58;
            case 23: goto L57;
            case 24: goto L58;
            case 25: goto L58;
            case 26: goto L57;
            case 27: goto L57;
            default: goto L58;
        };
    L58:
        throw new IllegalArgumentException(r1);
    L57:
        throw new IllegalStateException(r1);
    L30:
        r3[1] = "getSourceToUseForCopy";
        goto L42
    L31:
        r3[1] = "copy";
        goto L42
    L32:
        r3[1] = "newCopyBuilder";
        goto L42
    L33:
        r3[1] = "getKind";
        goto L42
    L34:
        r3[1] = "getOriginal";
        goto L42
    L35:
        r3[1] = "getValueParameters";
        goto L42
    L36:
        r3[1] = "getTypeParameters";
        goto L42
    L37:
        r3[1] = "getVisibility";
        goto L42
    L38:
        r3[1] = "getModality";
        goto L42
    L39:
        r3[1] = "getOverriddenDescriptors";
        goto L42
    L40:
        r3[1] = "getContextReceiverParameters";
        goto L42
    L41:
        r3[1] = "initialize";
        goto L42
    L12:
        r3[0] = "configuration";
        goto L28
    L13:
        r3[0] = "substitutor";
        goto L28
    L14:
        r3[0] = "originalSubstitutor";
        goto L28
    L15:
        r3[0] = "overriddenDescriptors";
        goto L28
    L16:
        r3[0] = "extensionReceiverParameter";
        goto L28
    L17:
        r3[0] = "unsubstitutedReturnType";
        goto L28
    L18:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
        goto L28
    L19:
        r3[0] = "visibility";
        goto L28
    L20:
        r3[0] = "unsubstitutedValueParameters";
        goto L28
    L21:
        r3[0] = "typeParameters";
        goto L28
    L22:
        r3[0] = "contextReceiverParameters";
        goto L28
    L23:
        r3[0] = "source";
        goto L28
    L24:
        r3[0] = "kind";
        goto L28
    L25:
        r3[0] = "name";
        goto L28
    L26:
        r3[0] = "annotations";
        goto L28
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    protected abstract FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6);

    static /* synthetic */ ReceiverParameterDescriptor access$000(FunctionDescriptorImpl r0) {
        return r0.dispatchReceiverParameter;
    }

    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    protected FunctionDescriptorImpl(DeclarationDescriptor r4, FunctionDescriptor r5, Annotations r6, Name r7, CallableMemberDescriptor.Kind r8, SourceElement r9) {
        if (r4 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(1);
    L8:
        if (r7 != null) goto L10;
        $$$reportNull$$$0(2);
    L10:
        if (r8 != null) goto L12;
        $$$reportNull$$$0(3);
    L12:
        if (r9 != null) goto L14;
        $$$reportNull$$$0(4);
    L14:
        super(r4, r6, r7, r9);
        this.visibility = DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        if (r5 != null) goto L17;
        r5 = this;
    L17:
        this.original = r5;
        this.kind = r8;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor r2, ReceiverParameterDescriptor r3, List<ReceiverParameterDescriptor> r4, List<? extends TypeParameterDescriptor> r5, List<ValueParameterDescriptor> r6, KotlinType r7, Modality r8, DescriptorVisibility r9) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r5 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        if (r9 != null) goto L10;
        $$$reportNull$$$0(8);
    L10:
        this.typeParameters = CollectionsKt.toList(r5);
        this.unsubstitutedValueParameters = CollectionsKt.toList(r6);
        this.unsubstitutedReturnType = r7;
        this.modality = r8;
        this.visibility = r9;
        this.extensionReceiverParameter = r2;
        this.dispatchReceiverParameter = r3;
        this.contextReceiverParameters = r4;
        int r10 = 0;
        int r11 = 0;
    L12:
        if (r11 >= r5.size()) goto L19;
        TypeParameterDescriptor r12 = r5.get(r11);
        if (r12.getIndex() != r11) goto L17;
        r11 = r11 + 1;
        goto L12
    L17:
        throw new IllegalStateException(r12 + " index is " + r12.getIndex() + " but position is " + r11);
    L19:
        if (r10 >= r6.size()) goto L25;
        ValueParameterDescriptor r13 = r6.get(r10);
        if (r13.getIndex() != (r10 + 0)) goto L24;
        r10 = r10 + 1;
        goto L19
    L24:
        throw new IllegalStateException(r13 + "index is " + r13.getIndex() + " but position is " + r10);
    L25:
        return this;
    }

    public void setVisibility(DescriptorVisibility r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        this.visibility = r2;
    }

    public void setOperator(boolean r1) {
        this.isOperator = r1;
    }

    public void setInfix(boolean r1) {
        this.isInfix = r1;
    }

    public void setExternal(boolean r1) {
        this.isExternal = r1;
    }

    public void setInline(boolean r1) {
        this.isInline = r1;
    }

    public void setTailrec(boolean r1) {
        this.isTailrec = r1;
    }

    public void setExpect(boolean r1) {
        this.isExpect = r1;
    }

    public void setActual(boolean r1) {
        this.isActual = r1;
    }

    private void setHiddenToOvercomeSignatureClash(boolean r1) {
        this.isHiddenToOvercomeSignatureClash = r1;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean r1) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = r1;
    }

    public void setSuspend(boolean r1) {
        this.isSuspend = r1;
    }

    public void setReturnType(KotlinType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        this.unsubstitutedReturnType = r2;
    }

    public void setHasStableParameterNames(boolean r1) {
        this.hasStableParameterNames = r1;
    }

    public void setHasSynthesizedParameterNames(boolean r1) {
        this.hasSynthesizedParameterNames = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r1 = this.contextReceiverParameters;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        Collection<? extends FunctionDescriptor> r1 = this.overriddenFunctions;
        if (r1 != null) goto L6;
        r1 = Collections.emptyList();
    L6:
        if (r1 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r1;
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> r0 = this.lazyOverriddenFunctionsTask;
        if (r0 == null) goto L6;
        this.overriddenFunctions = r0.invoke();
        this.lazyOverriddenFunctionsTask = null;
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r1 = this.modality;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r1 = this.visibility;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.isOperator == false) goto L5;
        return true;
    L5:
        Iterator<? extends FunctionDescriptor> r2 = getOriginal().getOverriddenDescriptors().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().isOperator() == false) goto L7;
        return true;
    L11:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.isInfix == false) goto L5;
        return true;
    L5:
        Iterator<? extends FunctionDescriptor> r2 = getOriginal().getOverriddenDescriptors().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().isInfix() == false) goto L7;
        return true;
    L11:
        return false;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isInline() {
        return this.isInline;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.isSuspend;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r1) {
        Map<CallableDescriptor.UserDataKey<?>, Object> r0 = this.userDataMap;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (V) r0.get(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r2) {
        if (r2 != 0) goto L4;
        $$$reportNull$$$0(17);
    L4:
        this.overriddenFunctions = r2;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L14;
        if (((FunctionDescriptor) r3.next()).isHiddenForResolutionEverywhereBesideSupercalls() == false) goto L6;
        this.isHiddenForResolutionEverywhereBesideSupercalls = true;
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r0 = this.typeParameters;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        $$$reportNull$$$0(18);
    L6:
        return r0;
    L8:
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r1 = this.unsubstitutedValueParameters;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r1;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor r0 = this.original;
        ?? r1 = this;
        if (r0 == this) goto L6;
        r1 = r0.getOriginal();
    L6:
        if (r1 != 0) goto L8;
        $$$reportNull$$$0(20);
    L8:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r1 = this.kind;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r1;
    }

    public FunctionDescriptor substitute(TypeSubstitutor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        if (r2.isEmpty() == false) goto L8;
        return this;
    L8:
        return newCopyBuilder(r2).setOriginal(getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration r1 = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (r1 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        return r1;
    }

    protected CopyConfiguration newCopyBuilder(TypeSubstitutor r14) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return new CopyConfiguration(this, r14.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    protected FunctionDescriptor doSubstitute(CopyConfiguration r21) {
        if (r21 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        boolean[] r10 = new boolean[1];
        if (CopyConfiguration.access$100(r21) == null) goto L8;
        Annotations r0 = AnnotationsKt.composeAnnotations(getAnnotations(), CopyConfiguration.access$100(r21));
    L9:
        FunctionDescriptorImpl r6 = createSubstitutedCopy(r21.newOwner, r21.original, r21.kind, r21.name, r0, getSourceToUseForCopy(r21.preserveSourceElement, r21.original));
        if (CopyConfiguration.access$200(r21) != null) goto L12;
        List<TypeParameterDescriptor> r1 = getTypeParameters();
    L13:
        r10[0] = r10[0] | (!r1.isEmpty());
        ArrayList r15 = new ArrayList(r1.size());
        final TypeSubstitutor r14 = DescriptorSubstitutor.substituteTypeParameters(r1, r21.substitution, r6, r15, r10);
        if (r14 != null) goto L16;
        return null;
    L16:
        ArrayList r13 = new ArrayList();
        if (r21.newContextReceiverParameters.isEmpty() == true) goto L30;
        Iterator<ReceiverParameterDescriptor> r2 = r21.newContextReceiverParameters.iterator();
    L20:
        if (r2.hasNext() == false) goto L30;
        ReceiverParameterDescriptor r3 = r2.next();
        KotlinType r4 = r14.substitute(r3.getType(), Variance.IN_VARIANCE);
        if (r4 == null) goto L23;
        r13.add(DescriptorFactory.createContextReceiverParameterForCallable(r6, r4, r3.getAnnotations()));
        boolean r5 = r10[0];
        if (r4 == r3.getType()) goto L27;
        boolean r7 = true;
    L28:
        r10[0] = r7 | r5;
        goto L20
    L27:
        r7 = false;
        goto L28
    L23:
        return null;
    L30:
        if (r21.newExtensionReceiverParameter == null) goto L39;
        KotlinType r8 = r14.substitute(r21.newExtensionReceiverParameter.getType(), Variance.IN_VARIANCE);
        if (r8 != null) goto L34;
        return null;
    L34:
        ReceiverParameterDescriptorImpl r9 = new ReceiverParameterDescriptorImpl(r6, new ExtensionReceiver(r6, r8, r21.newExtensionReceiverParameter.getValue()), r21.newExtensionReceiverParameter.getAnnotations());
        boolean r11 = r10[0];
        if (r8 == r21.newExtensionReceiverParameter.getType()) goto L37;
        boolean r12 = true;
    L38:
        r10[0] = r12 | r11;
        ReceiverParameterDescriptorImpl r16 = r9;
    L41:
        if (r21.dispatchReceiverParameter == null) goto L50;
        ReceiverParameterDescriptor r17 = r21.dispatchReceiverParameter.substitute(r14);
        if (r17 != null) goto L45;
        return null;
    L45:
        boolean r18 = r10[0];
        if (r17 == r21.dispatchReceiverParameter) goto L48;
        boolean r19 = true;
    L49:
        r10[0] = r18 | r19;
        ReceiverParameterDescriptor r110 = r17;
    L51:
        List<ValueParameterDescriptor> r20 = getSubstitutedValueParameters(r6, r21.newValueParameterDescriptors, r14, r21.dropOriginalInContainingParts, r21.preserveSourceElement, r10);
        if (r20 != null) goto L54;
        return null;
    L54:
        KotlinType r22 = r14.substitute(r21.newReturnType, Variance.OUT_VARIANCE);
        if (r22 != null) goto L57;
        return null;
    L57:
        boolean r23 = r10[0];
        if (r22 == r21.newReturnType) goto L60;
        boolean r24 = true;
    L61:
        boolean r25 = r23 | r24;
        r10[0] = r25;
        if (r25 == false) goto L64;
    L66:
        r6.initialize(r16, r110, r13, r15, r20, r22, r21.newModality, r21.newVisibility);
        r6.setOperator(this.isOperator);
        r6.setInfix(this.isInfix);
        r6.setExternal(this.isExternal);
        r6.setInline(this.isInline);
        r6.setTailrec(this.isTailrec);
        r6.setSuspend(this.isSuspend);
        r6.setExpect(this.isExpect);
        r6.setActual(this.isActual);
        r6.setHasStableParameterNames(this.hasStableParameterNames);
        r6.setHiddenToOvercomeSignatureClash(CopyConfiguration.access$300(r21));
        r6.setHiddenForResolutionEverywhereBesideSupercalls(CopyConfiguration.access$400(r21));
        if (CopyConfiguration.access$500(r21) == null) goto L69;
        boolean r26 = CopyConfiguration.access$500(r21).booleanValue();
    L70:
        r6.setHasSynthesizedParameterNames(r26);
        if (CopyConfiguration.access$600(r21).isEmpty() == true) goto L73;
    L74:
        Map<CallableDescriptor.UserDataKey<?>, Object> r27 = CopyConfiguration.access$600(r21);
        Map<CallableDescriptor.UserDataKey<?>, Object> r28 = this.userDataMap;
        if (r28 == null) goto L83;
        Iterator<Map.Entry<CallableDescriptor.UserDataKey<?>, Object>> r29 = r28.entrySet().iterator();
    L78:
        if (r29.hasNext() == false) goto L83;
        Map.Entry<CallableDescriptor.UserDataKey<?>, Object> r30 = r29.next();
        if (r27.containsKey(r30.getKey()) == true) goto L78;
        r27.put(r30.getKey(), r30.getValue());
    L83:
        if (r27.size() != 1) goto L85;
        r6.userDataMap = Collections.singletonMap(r27.keySet().iterator().next(), r27.values().iterator().next());
    L87:
        if (r21.signatureChange == true) goto L91;
        if (getInitialSignatureDescriptor() != null) goto L91;
    L96:
        if (r21.copyOverrides == true) goto L98;
    L106:
        return r6;
    L98:
        if (getOriginal().getOverriddenDescriptors().isEmpty() == true) goto L106;
        if (r21.substitution.isEmpty() == false) goto L105;
        Function0<Collection<FunctionDescriptor>> r31 = this.lazyOverriddenFunctionsTask;
        if (r31 == null) goto L104;
        r6.lazyOverriddenFunctionsTask = r31;
        goto L106
    L104:
        r6.setOverriddenDescriptors(getOverriddenDescriptors());
        goto L106
    L105:
        r6.lazyOverriddenFunctionsTask = new AnonymousClass1(this, r14);
    L91:
        if (getInitialSignatureDescriptor() == null) goto L93;
        FunctionDescriptor r32 = getInitialSignatureDescriptor();
    L94:
        r6.setInitialSignatureDescriptor(r32.substitute(r14));
        goto L96
    L93:
        r32 = this;
        goto L94
    L85:
        r6.userDataMap = r27;
        goto L87
    L73:
        if (this.userDataMap == null) goto L87;
    L69:
        r26 = this.hasSynthesizedParameterNames;
        goto L70
    L64:
        if (r21.justForTypeSubstitution == false) goto L66;
        return this;
    L60:
        r24 = false;
        goto L61
    L48:
        r19 = false;
        goto L49
    L50:
        r110 = null;
        goto L51
    L37:
        r12 = false;
        goto L38
    L39:
        r16 = null;
        goto L41
    L12:
        r1 = CopyConfiguration.access$200(r21);
        goto L13
    L8:
        r0 = getAnnotations();
        goto L9
    }

    public FunctionDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        FunctionDescriptor r0 = newCopyBuilder().setOwner(r1).setModality(r2).setVisibility(r3).setKind(r4).setCopyOverrides(r5).build();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(26);
    L5:
        return r0;
    }

    private SourceElement getSourceToUseForCopy(boolean r1, FunctionDescriptor r2) {
        if (r1 == false) goto L7;
        if (r2 != null) goto L6;
        r2 = getOriginal();
    L6:
        SourceElement r0 = r2.getSource();
    L8:
        if (r0 != null) goto L10;
        $$$reportNull$$$0(27);
    L10:
        return r0;
    L7:
        r0 = SourceElement.NO_SOURCE;
        goto L8
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return r1.visitFunctionDescriptor(this, r2);
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor r7, List<ValueParameterDescriptor> r8, TypeSubstitutor r9) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(28);
    L4:
        if (r9 != null) goto L7;
        $$$reportNull$$$0(29);
    L7:
        return getSubstitutedValueParameters(r7, r8, r9, false, false, null);
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor r18, List<ValueParameterDescriptor> r19, TypeSubstitutor r20, boolean r21, boolean r22, boolean[] r23) {
        if (r19 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        if (r20 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        ArrayList r1 = new ArrayList(r19.size());
        Iterator<ValueParameterDescriptor> r2 = r19.iterator();
    L9:
        if (r2.hasNext() == false) goto L33;
        ValueParameterDescriptor r3 = r2.next();
        KotlinType r11 = r20.substitute(r3.getType(), Variance.IN_VARIANCE);
        KotlinType r4 = r3.getVarargElementType();
        if (r4 != null) goto L13;
        KotlinType r15 = null;
    L14:
        if (r11 == null) goto L15;
        if (r11 != r3.getType()) goto L19;
        if (r4 != r15) goto L19;
    L22:
        if ((r3 instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration) == false) goto L24;
        final List<VariableDescriptor> r5 = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration) r3).getDestructuringVariables();
        Function0<List<VariableDescriptor>> r17 = new AnonymousClass2(r5);
    L25:
        if (r21 == false) goto L27;
        ValueParameterDescriptor r7 = null;
    L28:
        int r8 = r3.getIndex();
        Annotations r9 = r3.getAnnotations();
        Name r10 = r3.getName();
        boolean r12 = r3.declaresDefaultValue();
        boolean r13 = r3.isCrossinline();
        boolean r14 = r3.isNoinline();
        if (r22 == false) goto L31;
        SourceElement r6 = r3.getSource();
    L32:
        r1.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(r18, r7, r8, r9, r10, r11, r12, r13, r14, r15, r6, r17));
        goto L9
    L31:
        r6 = SourceElement.NO_SOURCE;
        goto L32
    L27:
        r7 = r3;
        goto L28
    L24:
        r17 = null;
    L19:
        if (r23 == null) goto L22;
        r23[0] = true;
        goto L22
    L15:
        return null;
    L13:
        r15 = r20.substitute(r4, Variance.IN_VARIANCE);
        goto L14
    L33:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    private void setInitialSignatureDescriptor(FunctionDescriptor r1) {
        this.initialSignatureDescriptor = r1;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> r2, Object r3) {
        if (this.userDataMap != null) goto L5;
        this.userDataMap = new LinkedHashMap();
    L5:
        this.userDataMap.put(r2, r3);
    }
}
