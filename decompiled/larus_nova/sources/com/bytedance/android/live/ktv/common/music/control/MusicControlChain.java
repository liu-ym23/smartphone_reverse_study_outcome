package com.bytedance.android.live.ktv.common.music.control;

import android.os.Looper;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class MusicControlChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f70010d;

    public final CopyOnWriteArrayList<IMusicControlNode> c() {
        return (CopyOnWriteArrayList) this.f70008b.getValue();
    }

    public final CopyOnWriteArrayList<IMusicControlNode> d() {
        return (CopyOnWriteArrayList) this.f70007a.getValue();
    }

    public MusicControlChain(g r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f70010d = r100;
        this.f70007a = LazyKt.lazy(MusicControlChain$waitingList$2.INSTANCE);
        this.f70008b = LazyKt.lazy(MusicControlChain$runningList$2.INSTANCE);
        this.f70009c = LazyKt.lazy(MusicControlChain$interceptors$2.INSTANCE);
    }

    public final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        d().add(r100);
        e("addNode");
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L6:
        com.bytedance.android.live.ktv.common.util.g.a("MusicControlChain#loop, source: " + r100 + ", waitingList size: " + d().size() + ",running size:" + c().size());
        if (d().isEmpty() == false) goto L9;
        return;
    L9:
        Iterator<IMusicControlNode> r101 = d().iterator();
    L11:
        if (r101.hasNext() == false) goto L18;
        IMusicControlNode r102 = r101.next();
        h r103 = (h) ((Map) this.f70009c.getValue()).get(r102.getType());
        if (r103 == null) goto L17;
        if (r103.a(r102, d(), c()) == true) goto L17;
        d().remove(r102);
        c().add(r102);
        r102.b(this.f70010d);
    L17:
        com.bytedance.android.live.ktv.common.util.g.a("intercept node, ".concat(r100));
        goto L11
    }

    public final void f(IMusicControlNode r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        c().remove(r100);
        e("removeNode");
    }

    public final void a(IMusicControlNode.OperationType r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "interceptor");
        ((Map) this.f70009c.getValue()).put(r100, r101);
    }
}
