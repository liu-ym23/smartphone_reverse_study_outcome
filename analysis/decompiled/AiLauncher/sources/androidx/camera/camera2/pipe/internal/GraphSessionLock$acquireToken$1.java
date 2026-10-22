package androidx.camera.camera2.pipe.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock", f = "GraphSessionLock.kt", l = {105}, m = "acquireToken$camera_camera2_pipe", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphSessionLock$acquireToken$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10988a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10989b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GraphSessionLock f10990c;

    /* renamed from: d, reason: collision with root package name */
    public int f10991d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphSessionLock$acquireToken$1(GraphSessionLock graphSessionLock, InterfaceC4014c<? super GraphSessionLock$acquireToken$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10990c = graphSessionLock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10989b = obj;
        this.f10991d |= Integer.MIN_VALUE;
        return this.f10990c.d(this);
    }
}
