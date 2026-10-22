package androidx.camera.camera2.pipe.internal;

import Z8.C1174w;
import Z8.F;
import android.util.Log;
import androidx.camera.camera2.pipe.internal.FrameState;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w.G;
import w.InterfaceC5714u;
import w.Q;
import z.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/camera/camera2/pipe/internal/c;", "Lw/u;", "Landroidx/camera/camera2/pipe/internal/FrameState;", "frameState", "", "Lw/Q;", "imageStreams", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;Ljava/util/Set;)V", "LY8/t;", "close", "()V", "finalize", "Lw/u$a;", "listener", "d1", "(Lw/u$a;)V", "", "toString", "()Ljava/lang/String;", "", "e", "()Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/internal/FrameState;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Set;", "()Ljava/util/Set;", "Lw/G;", "c", "outputStreams", "LOa/a;", Const.INTENT_KEY_UMID, "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c implements InterfaceC5714u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final FrameState frameState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Set<Q> imageStreams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Set<G> outputStreams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Oa.a closed;

    public c(FrameState frameState, Set<Q> imageStreams) {
        p.i(frameState, "frameState");
        p.i(imageStreams, "imageStreams");
        this.frameState = frameState;
        this.imageStreams = imageStreams;
        List<FrameState.d> listF = frameState.f();
        ArrayList arrayList = new ArrayList(C1174w.x(listF, 10));
        Iterator<T> it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(G.a(((FrameState.d) it.next()).getOutputId()));
        }
        this.outputStreams = F.r1(arrayList);
        this.closed = Oa.b.a(false);
    }

    public Set<Q> b() {
        return this.imageStreams;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        e();
    }

    @Override // w.InterfaceC5714u
    public void d1(InterfaceC5714u.a listener) {
        p.i(listener, "listener");
        if (!this.closed.b()) {
            this.frameState.c(listener);
            return;
        }
        throw new IllegalStateException(("Cannot add Frame.Listener, " + this + " is closed!").toString());
    }

    public final boolean e() {
        if (!this.closed.a(false, true)) {
            return false;
        }
        this.frameState.getFrameInfoOutput().b();
        int size = this.frameState.f().size();
        for (int i10 = 0; i10 < size; i10++) {
            FrameState.d dVar = this.frameState.f().get(i10);
            if (b().contains(Q.a(dVar.getStreamId()))) {
                dVar.b();
            }
        }
        return true;
    }

    public final void finalize() {
        if (e() && k.f44508a.b()) {
            Log.e("CXCP", "Failed to close " + this + "! This indicates a memory leak and could cause the camera to stall, or images to be lost.");
        }
    }

    public String toString() {
        return this.frameState.toString();
    }

    public /* synthetic */ c(FrameState frameState, Set set, int i10, i iVar) {
        if ((i10 & 2) != 0) {
            List<FrameState.d> listF = frameState.f();
            ArrayList arrayList = new ArrayList(C1174w.x(listF, 10));
            Iterator<T> it = listF.iterator();
            while (it.hasNext()) {
                arrayList.add(Q.a(((FrameState.d) it.next()).getStreamId()));
            }
            set = F.r1(arrayList);
        }
        this(frameState, set);
    }
}
