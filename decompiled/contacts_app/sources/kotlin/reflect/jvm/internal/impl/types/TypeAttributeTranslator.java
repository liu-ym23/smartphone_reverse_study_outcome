package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: compiled from: TypeAttributeTranslator.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeAttributeTranslator {

    /* JADX INFO: compiled from: TypeAttributeTranslator.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ TypeAttributes toAttributes$default(TypeAttributeTranslator r1, Annotations r2, TypeConstructor r3, DeclarationDescriptor r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = null;
        L7:
            if ((r5 & 4) == 0) goto L10;
            r4 = null;
        L10:
            return r1.toAttributes(r2, r3, r4);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
        }
    }

    TypeAttributes toAttributes(Annotations r1, TypeConstructor r2, DeclarationDescriptor r3);
}
