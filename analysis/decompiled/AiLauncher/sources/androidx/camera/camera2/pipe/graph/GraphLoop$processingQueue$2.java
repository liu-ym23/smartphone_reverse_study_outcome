package androidx.camera.camera2.pipe.graph;

import Y8.t;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.p;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class GraphLoop$processingQueue$2 extends FunctionReferenceImpl implements p<List<b>, InterfaceC4014c<? super t>, Object> {
    public GraphLoop$processingQueue$2(Object obj) {
        super(2, obj, GraphLoop.class, "process", "process(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // p9.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List<b> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((GraphLoop) this.receiver).V(list, interfaceC4014c);
    }
}
