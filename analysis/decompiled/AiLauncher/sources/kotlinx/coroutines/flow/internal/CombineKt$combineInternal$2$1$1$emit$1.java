package kotlinx.coroutines.flow.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", l = {29, 30}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36747a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36748b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CombineKt$combineInternal$2.AnonymousClass1.C04641<T> f36749c;

    /* renamed from: d, reason: collision with root package name */
    public int f36750d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2$1$1$emit$1(CombineKt$combineInternal$2.AnonymousClass1.C04641<? super T> c04641, InterfaceC4014c<? super CombineKt$combineInternal$2$1$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36749c = c04641;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36748b = obj;
        this.f36750d |= Integer.MIN_VALUE;
        return this.f36749c.emit(null, this);
    }
}
