package androidx.camera.camera2.pipe.graph;

import Y8.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class GraphLoop$processingQueue$1 extends FunctionReferenceImpl implements InterfaceC5074l<List<? extends b>, t> {
    public GraphLoop$processingQueue$1(Object obj) {
        super(1, obj, GraphLoop.class, "finalizeUnprocessedCommands", "finalizeUnprocessedCommands(Ljava/util/List;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ t invoke(List<? extends b> list) {
        l(list);
        return t.f7040a;
    }

    public final void l(List<? extends b> p02) {
        p.i(p02, "p0");
        ((GraphLoop) this.receiver).A(p02);
    }
}
