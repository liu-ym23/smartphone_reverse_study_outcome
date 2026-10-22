package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {154}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36465a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36466b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowKt__ErrorsKt$catchImpl$2<T> f36467c;

    /* renamed from: d, reason: collision with root package name */
    public int f36468d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2$emit$1(FlowKt__ErrorsKt$catchImpl$2<? super T> flowKt__ErrorsKt$catchImpl$2, InterfaceC4014c<? super FlowKt__ErrorsKt$catchImpl$2$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36467c = flowKt__ErrorsKt$catchImpl$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36466b = obj;
        this.f36468d |= Integer.MIN_VALUE;
        return this.f36467c.emit(null, this);
    }
}
