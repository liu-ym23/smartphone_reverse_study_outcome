package androidx.camera.camera2.pipe.graph;

import android.util.Log;
import androidx.camera.camera2.pipe.graph.GraphLoop;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.K;
import w.w;
import z.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Landroidx/camera/camera2/pipe/graph/a;", "Landroidx/camera/camera2/pipe/t$a;", "Landroidx/camera/camera2/pipe/graph/GraphLoop$b;", "", "requestsUntilActive", "<init>", "(J)V", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "result", "LY8/t;", "g0", "(Lw/K;JLw/w;)V", "f", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "J", "LOa/d;", Const.INTENT_KEY_PKGNAME, "LOa/d;", "frameCount", "Landroidx/camera/camera2/pipe/graph/GraphLoop;", "c", "Landroidx/camera/camera2/pipe/graph/GraphLoop;", "_graphLoop", UxipConstants.f30680s, "o", "()Landroidx/camera/camera2/pipe/graph/GraphLoop;", "p", "(Landroidx/camera/camera2/pipe/graph/GraphLoop;)V", "graphLoop", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements t.a, GraphLoop.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long requestsUntilActive;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.d frameCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public GraphLoop _graphLoop;

    public a(long j10) {
        this.requestsUntilActive = j10;
        if (j10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.frameCount = Oa.b.e(0L);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void d() {
        long value;
        Oa.d dVar = this.frameCount;
        do {
            value = dVar.getValue();
        } while (!dVar.a(value, value != -1 ? 0L : -1L));
        o().f1(false);
        if (k.f44508a.d()) {
            Log.w("CXCP", "Capture processing has been disabled for " + o() + " until " + this.requestsUntilActive + " frames have been completed.");
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void f() {
    }

    @Override // androidx.camera.camera2.pipe.t.a
    public void g0(K requestMetadata, long frameNumber, w result) {
        long value;
        long j10;
        p.i(requestMetadata, "requestMetadata");
        p.i(result, "result");
        Oa.d dVar = this.frameCount;
        do {
            value = dVar.getValue();
            j10 = value != -1 ? 1 + value : -1L;
        } while (!dVar.a(value, j10));
        if (j10 == this.requestsUntilActive) {
            if (k.f44508a.d()) {
                Log.w("CXCP", "Capture processing is now enabled for " + this._graphLoop + " after " + j10 + " frames.");
            }
            o().f1(true);
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.b
    public void h() {
        this.frameCount.d(-1L);
        o().f1(false);
    }

    public final GraphLoop o() {
        GraphLoop graphLoop = this._graphLoop;
        p.f(graphLoop);
        return graphLoop;
    }

    public final void p(GraphLoop value) {
        p.i(value, "value");
        if (this._graphLoop != null) {
            throw new IllegalStateException("GraphLoop has already been set!");
        }
        this._graphLoop = value;
        value.f1(false);
        if (k.f44508a.d()) {
            Log.w("CXCP", "Capture processing has been disabled for " + value + " until " + this.requestsUntilActive + " frames have been completed.");
        }
    }
}
