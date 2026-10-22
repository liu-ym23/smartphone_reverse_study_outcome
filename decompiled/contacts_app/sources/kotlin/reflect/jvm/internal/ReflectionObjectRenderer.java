package kotlin.reflect.jvm.internal;

import com.bytedance.librarian.LibrarianImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = null;
    private static final DescriptorRenderer renderer = null;

    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KParameter.Kind.values().length];
            r0[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KParameter.Kind.INSTANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KParameter.Kind.VALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private ReflectionObjectRenderer() {
    }

    static {
        INSTANCE = new ReflectionObjectRenderer();
        renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;
    }

    private final void appendReceiverType(StringBuilder r2, ReceiverParameterDescriptor r3) {
        if (r3 == null) goto L5;
        KotlinType r4 = r3.getType();
        Intrinsics.checkNotNullExpressionValue(r4, "receiver.type");
        r2.append(renderType(r4));
        r2.append(LibrarianImpl.Constants.DOT);
        return;
    }

    private final void appendReceivers(StringBuilder r3, CallableDescriptor r4) {
        ReceiverParameterDescriptor r0 = UtilKt.getInstanceReceiverParameter(r4);
        ReceiverParameterDescriptor r5 = r4.getExtensionReceiverParameter();
        appendReceiverType(r3, r0);
        if (r0 == null) goto L6;
        if (r5 == null) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        r3.append("(");
    L9:
        appendReceiverType(r3, r5);
        if (r1 == false) goto L13;
        r3.append(")");
        return;
    L13:
        return;
    L6:
        r1 = false;
        goto L7
    }

    private final String renderCallable(CallableDescriptor r3) {
        if ((r3 instanceof PropertyDescriptor) == false) goto L6;
        return renderProperty((PropertyDescriptor) r3);
    L6:
        if ((r3 instanceof FunctionDescriptor) == false) goto L10;
        return renderFunction((FunctionDescriptor) r3);
    L10:
        throw new IllegalStateException(("Illegal callable: " + r3).toString());
    }

    public final String renderProperty(PropertyDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        StringBuilder r4 = new StringBuilder();
        if (r5.isVar() == false) goto L5;
        String r0 = "var ";
    L6:
        r4.append(r0);
        ReflectionObjectRenderer r1 = INSTANCE;
        r1.appendReceivers(r4, r5);
        DescriptorRenderer r2 = renderer;
        Name r3 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "descriptor.name");
        r4.append(r2.renderName(r3, true));
        r4.append(": ");
        KotlinType r6 = r5.getType();
        Intrinsics.checkNotNullExpressionValue(r6, "descriptor.type");
        r4.append(r1.renderType(r6));
        String r7 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "StringBuilder().apply(builderAction).toString()");
        return r7;
    L5:
        r0 = "val ";
        goto L6
    }

    public final String renderFunction(FunctionDescriptor r14) {
        Intrinsics.checkNotNullParameter(r14, "descriptor");
        StringBuilder r13 = new StringBuilder();
        r13.append("fun ");
        ReflectionObjectRenderer r0 = INSTANCE;
        r0.appendReceivers(r13, r14);
        DescriptorRenderer r1 = renderer;
        Name r2 = r14.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "descriptor.name");
        r13.append(r1.renderName(r2, true));
        List<ValueParameterDescriptor> r3 = r14.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r3, "descriptor.valueParameters");
        CollectionsKt.joinTo$default(r3, r13, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderFunction$1$1.INSTANCE, 48, null);
        r13.append(": ");
        KotlinType r15 = r14.getReturnType();
        Intrinsics.checkNotNull(r15);
        r13.append(r0.renderType(r15));
        String r16 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    }

    public final String renderLambda(FunctionDescriptor r14) {
        Intrinsics.checkNotNullParameter(r14, "invoke");
        StringBuilder r13 = new StringBuilder();
        ReflectionObjectRenderer r0 = INSTANCE;
        r0.appendReceivers(r13, r14);
        List<ValueParameterDescriptor> r1 = r14.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "invoke.valueParameters");
        CollectionsKt.joinTo$default(r1, r13, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderLambda$1$1.INSTANCE, 48, null);
        r13.append(" -> ");
        KotlinType r15 = r14.getReturnType();
        Intrinsics.checkNotNull(r15);
        r13.append(r0.renderType(r15));
        String r16 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    }

    public final String renderParameter(KParameterImpl r3) {
        Intrinsics.checkNotNullParameter(r3, "parameter");
        StringBuilder r2 = new StringBuilder();
        int r0 = WhenMappings.$EnumSwitchMapping$0[r3.getKind().ordinal()];
        if (r0 != 1) goto L5;
        r2.append("extension receiver parameter");
    L12:
        r2.append(" of ");
        r2.append(INSTANCE.renderCallable(r3.getCallable().getDescriptor()));
        String r4 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        if (r0 != 2) goto L7;
        r2.append("instance parameter");
        goto L12
    L7:
        if (r0 != 3) goto L12;
        r2.append("parameter #" + r3.getIndex() + ' ' + r3.getName());
        goto L12
    }

    public final String renderType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
        return renderer.renderType(r1);
    }
}
