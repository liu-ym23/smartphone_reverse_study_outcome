package androidx.camera.camera2.pipe.graph;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.GraphLoop", f = "GraphLoop.kt", l = {566, 572, 573}, m = "processShutdown", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphLoop$processShutdown$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10886a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10887b;

    /* renamed from: c, reason: collision with root package name */
    public int f10888c;

    /* renamed from: d, reason: collision with root package name */
    public int f10889d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f10890e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ GraphLoop f10891f;

    /* renamed from: g, reason: collision with root package name */
    public int f10892g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphLoop$processShutdown$1(GraphLoop graphLoop, InterfaceC4014c<? super GraphLoop$processShutdown$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10891f = graphLoop;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10890e = obj;
        this.f10892g |= Integer.MIN_VALUE;
        return this.f10891f.R0(null, this);
    }
}
