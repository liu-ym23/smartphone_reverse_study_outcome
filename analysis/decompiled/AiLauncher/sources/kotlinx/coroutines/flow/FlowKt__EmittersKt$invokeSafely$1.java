package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", l = {210}, m = "invokeSafely$FlowKt__EmittersKt", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__EmittersKt$invokeSafely$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36443a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36444b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36445c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36446d;

    /* renamed from: e, reason: collision with root package name */
    public int f36447e;

    public FlowKt__EmittersKt$invokeSafely$1(InterfaceC4014c<? super FlowKt__EmittersKt$invokeSafely$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36446d = obj;
        this.f36447e |= Integer.MIN_VALUE;
        return FlowKt__EmittersKt.c(null, null, null, this);
    }
}
