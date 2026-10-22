package c3;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Function3 f4514a;

    static {
        p pVar = p.f4513a;
        Intrinsics.checkNotNull(pVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f4514a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(pVar, 3);
    }
}
