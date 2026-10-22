package ao;

import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f15689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p014do.a f15690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bo.a f15691c;

    public a() {
        this(0);
    }

    public a(int r100) {
        GlobalScope r101 = GlobalScope.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "taskScope");
        this.f15690b = new p014do.a();
        this.f15691c = new bo.a();
        this.f15689a = r101;
    }

    public final void a(PipelineNode<?, ?> r100, PipelineNode<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "nextNode");
        p014do.a r102 = this.f15690b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "nextNode");
        Iterator<T> r103 = r102.f469398a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((co.a) r103.next()).a(r100, r101);
        goto L4
    }

    public final void b(PipelineNode<?, ?> r100, PipelineNode<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "nextNode");
        p014do.a r102 = this.f15690b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "nextNode");
        Iterator<T> r103 = r102.f469398a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((co.a) r103.next()).b(r100, r101);
        goto L4
    }
}
