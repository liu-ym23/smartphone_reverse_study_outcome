package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1", f = "Delay.kt", l = {204}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36429a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36430b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1<T> f36431c;

    /* renamed from: d, reason: collision with root package name */
    public int f36432d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1<? super T> anonymousClass1, InterfaceC4014c<? super FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36431c = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36430b = obj;
        this.f36432d |= Integer.MIN_VALUE;
        return this.f36431c.emit(null, this);
    }
}
