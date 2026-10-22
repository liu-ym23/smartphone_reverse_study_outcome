package androidx.camera.camera2.pipe.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock", f = "GraphSessionLock.kt", l = {98}, m = "use", v = 1)
/* loaded from: classes.dex */
public final class GraphSessionLock$use$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10995a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10996b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GraphSessionLock f10997c;

    /* renamed from: d, reason: collision with root package name */
    public int f10998d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphSessionLock$use$1(GraphSessionLock graphSessionLock, InterfaceC4014c<? super GraphSessionLock$use$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10997c = graphSessionLock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10996b = obj;
        this.f10998d |= Integer.MIN_VALUE;
        return this.f10997c.g(null, null, this);
    }
}
