package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;

/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ReflectLambdaKt {
    public static final <R> KFunction<R> reflect(Function<? extends R> r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Metadata r0 = (Metadata) r13.getClass().getAnnotation(Metadata.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        String[] r2 = r0.d1();
        boolean r4 = true;
        if (r2.length != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L14;
        return null;
    L14:
        Pair<JvmNameResolver, ProtoBuf.Function> r1 = JvmProtoBufUtil.readFunctionDataFrom(r2, r0.d2());
        JvmNameResolver r5 = r1.component1();
        ProtoBuf.Function r6 = r1.component2();
        int[] r7 = r0.mv();
        if ((r0.xi() & 8) != 0) goto L18;
        r4 = false;
    L18:
        JvmMetadataVersion r8 = new JvmMetadataVersion(r7, r4);
        ProtoBuf.TypeTable r14 = r6.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r14, "proto.typeTable");
        return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, (SimpleFunctionDescriptor) UtilKt.deserializeToDescriptor(r13.getClass(), r6, r5, new TypeTable(r14), r8, ReflectLambdaKt$reflect$descriptor$1.INSTANCE));
    L8:
        r3 = false;
        goto L9
    }
}
