package B;

import Ua.M;
import Z8.F;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"LB/e;", "", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "sessionLock", "LA/f;", "graphProcessor", "LUa/M;", "graphScope", "<init>", "(Landroidx/camera/camera2/pipe/internal/GraphSessionLock;LA/f;LUa/M;)V", "", "Landroidx/camera/camera2/pipe/t$a;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", Const.INTENT_KEY_PKGNAME, "LA/f;", "c", "LUa/M;", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "lock", "", "e", "Ljava/util/Set;", "listeners", "", "f", "Z", "dirty", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final GraphSessionLock sessionLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final A.f graphProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final M graphScope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Set<t.a> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean dirty;

    public e(GraphSessionLock sessionLock, A.f graphProcessor, M graphScope) {
        p.i(sessionLock, "sessionLock");
        p.i(graphProcessor, "graphProcessor");
        p.i(graphScope, "graphScope");
        this.sessionLock = sessionLock;
        this.graphProcessor = graphProcessor;
        this.graphScope = graphScope;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    public final List<t.a> a() {
        synchronized (this.lock) {
            if (!this.dirty) {
                return null;
            }
            this.dirty = false;
            return F.m1(this.listeners);
        }
    }
}
