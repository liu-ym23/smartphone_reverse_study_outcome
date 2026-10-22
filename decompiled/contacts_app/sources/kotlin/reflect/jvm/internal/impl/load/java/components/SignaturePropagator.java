package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = null;

    public static class PropagatedSignature {
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<String> signatureErrors;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 4) goto L8;
            if (r10 == 5) goto L8;
            if (r10 == 6) goto L8;
            if (r10 == 7) goto L8;
            String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L10:
            if (r10 == 4) goto L15;
            if (r10 == 5) goto L15;
            if (r10 == 6) goto L15;
            if (r10 == 7) goto L15;
            int r6 = 3;
        L16:
            Object[] r7 = new Object[r6];
            switch(r10) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L19;
                case 6: goto L19;
                case 7: goto L19;
                default: goto L18;
            };
        L18:
            r7[0] = "returnType";
        L24:
            if (r10 == 4) goto L32;
            if (r10 == 5) goto L31;
            if (r10 == 6) goto L30;
            if (r10 == 7) goto L29;
            r7[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
        L33:
            if (r10 == 4) goto L38;
            if (r10 == 5) goto L38;
            if (r10 == 6) goto L38;
            if (r10 == 7) goto L38;
            r7[2] = "<init>";
        L38:
            String r5 = String.format(r4, r7);
            if (r10 == 4) goto L45;
            if (r10 == 5) goto L45;
            if (r10 == 6) goto L45;
            if (r10 == 7) goto L45;
            throw new IllegalArgumentException(r5);
        L45:
            throw new IllegalStateException(r5);
        L29:
            r7[1] = "getErrors";
            goto L33
        L30:
            r7[1] = "getTypeParameters";
            goto L33
        L31:
            r7[1] = "getValueParameters";
            goto L33
        L32:
            r7[1] = "getReturnType";
            goto L33
        L19:
            r7[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            goto L24
        L20:
            r7[0] = "signatureErrors";
            goto L24
        L21:
            r7[0] = "typeParameters";
            goto L24
        L22:
            r7[0] = "valueParameters";
        L15:
            r6 = 2;
        L8:
            r4 = "@NotNull method %s.%s must not return null";
            goto L10
        }

        public PropagatedSignature(KotlinType r2, KotlinType r3, List<ValueParameterDescriptor> r4, List<TypeParameterDescriptor> r5, List<String> r6, boolean r7) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r4 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            if (r5 != null) goto L8;
            $$$reportNull$$$0(2);
        L8:
            if (r6 != null) goto L10;
            $$$reportNull$$$0(3);
        L10:
            this.returnType = r2;
            this.receiverType = r3;
            this.valueParameters = r4;
            this.typeParameters = r5;
            this.signatureErrors = r6;
            this.hasStableParameterNames = r7;
        }

        public KotlinType getReturnType() {
            KotlinType r1 = this.returnType;
            if (r1 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r1;
        }

        public KotlinType getReceiverType() {
            return this.receiverType;
        }

        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> r1 = this.valueParameters;
            if (r1 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r1;
        }

        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> r1 = this.typeParameters;
            if (r1 != null) goto L5;
            $$$reportNull$$$0(6);
        L5:
            return r1;
        }

        public boolean hasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public List<String> getErrors() {
            List<String> r1 = this.signatureErrors;
            if (r1 != null) goto L5;
            $$$reportNull$$$0(7);
        L5:
            return r1;
        }
    }

    void reportSignatureErrors(CallableMemberDescriptor r1, List<String> r2);

    PropagatedSignature resolvePropagatedSignature(JavaMethod r1, ClassDescriptor r2, KotlinType r3, KotlinType r4, List<ValueParameterDescriptor> r5, List<TypeParameterDescriptor> r6);

    static {
        DO_NOTHING = new AnonymousClass1();
    }
}
