package B;

import Ua.M;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"LB/d;", "", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "sessionLock", "LA/f;", "graphProcessor", "LUa/M;", "graphScope", "<init>", "(Landroidx/camera/camera2/pipe/internal/GraphSessionLock;LA/f;LUa/M;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", Const.INTENT_KEY_PKGNAME, "LA/f;", "c", "LUa/M;", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "lock", "", "e", "Ljava/util/Map;", "parameters", "", "f", "Z", "dirty", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final GraphSessionLock sessionLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final A.f graphProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final M graphScope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<Object, Object> parameters;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean dirty;

    public d(GraphSessionLock sessionLock, A.f graphProcessor, M graphScope) {
        p.i(sessionLock, "sessionLock");
        p.i(graphProcessor, "graphProcessor");
        p.i(graphScope, "graphScope");
        this.sessionLock = sessionLock;
        this.graphProcessor = graphProcessor;
        this.graphScope = graphScope;
        this.lock = new Object();
        this.parameters = new LinkedHashMap();
    }

    public final void a() {
        synchronized (this.lock) {
            if (this.dirty) {
                this.dirty = false;
                this.graphProcessor.p(new HashMap(this.parameters));
            }
        }
    }
}
