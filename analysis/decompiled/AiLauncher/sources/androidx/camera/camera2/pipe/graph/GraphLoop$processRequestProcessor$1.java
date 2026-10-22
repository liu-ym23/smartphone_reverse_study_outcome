package androidx.camera.camera2.pipe.graph;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.GraphLoop", f = "GraphLoop.kt", l = {479, 480, 488}, m = "processRequestProcessor", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphLoop$processRequestProcessor$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10876a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10877b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10878c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10879d;

    /* renamed from: e, reason: collision with root package name */
    public Object f10880e;

    /* renamed from: f, reason: collision with root package name */
    public int f10881f;

    /* renamed from: g, reason: collision with root package name */
    public int f10882g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10883h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ GraphLoop f10884i;

    /* renamed from: j, reason: collision with root package name */
    public int f10885j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphLoop$processRequestProcessor$1(GraphLoop graphLoop, InterfaceC4014c<? super GraphLoop$processRequestProcessor$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10884i = graphLoop;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10883h = obj;
        this.f10885j |= Integer.MIN_VALUE;
        return this.f10884i.N0(null, 0, null, this);
    }
}
