package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.graph.GraphLoop;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.K;
import w.w;
import w.x;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/camera/camera2/pipe/graph/c;", "Landroidx/camera/camera2/pipe/t$a;", "Landroidx/camera/camera2/pipe/graph/GraphLoop$b;", "<init>", "()V", "Lw/K;", "requestMetadata", "LY8/t;", "k0", "(Lw/K;)V", "Lw/y;", "frameNumber", "Lw/x;", "captureResult", "D0", "(Lw/K;JLw/x;)V", "Lw/w;", "totalCaptureResult", "N0", "(Lw/K;JLw/w;)V", "Landroidx/camera/camera2/pipe/graph/d;", "listener", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/camera/camera2/pipe/graph/d;)V", "k", "f", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lw/L;", "requestNumber", "metadata", "o", "(JLw/x;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c implements t.a, GraphLoop.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<d> listeners = new CopyOnWriteArrayList<>();

    @Override // androidx.camera.camera2.pipe.t.a
    public void D0(K requestMetadata, long frameNumber, x captureResult) {
        p.i(requestMetadata, "requestMetadata");
        p.i(captureResult, "captureResult");
        o(requestMetadata.getRequestNumber(), captureResult);
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void N0(K requestMetadata, long frameNumber, w totalCaptureResult) {
        p.i(requestMetadata, "requestMetadata");
        p.i(totalCaptureResult, "totalCaptureResult");
        o(requestMetadata.getRequestNumber(), totalCaptureResult.getMetadata());
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void d() {
        Iterator<d> it = this.listeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void f() {
        Iterator<d> it = this.listeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void h() {
        Iterator<d> it = this.listeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public final void j(d listener) {
        p.i(listener, "listener");
        this.listeners.add(listener);
    }

    public final void k(d listener) {
        p.i(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void k0(K requestMetadata) {
        p.i(requestMetadata, "requestMetadata");
        Iterator<d> it = this.listeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().c(requestMetadata.getRequestNumber());
        }
    }

    public final void o(long requestNumber, x metadata) {
        Iterator<d> it = this.listeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            d next = it.next();
            if (next.a(requestNumber, metadata)) {
                this.listeners.remove(next);
            }
        }
    }
}
