package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b;", "", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_UMID, "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroidx/camera/camera2/pipe/graph/b$a;", "Landroidx/camera/camera2/pipe/graph/b$b;", "Landroidx/camera/camera2/pipe/graph/b$c;", "Landroidx/camera/camera2/pipe/graph/b$d;", "Landroidx/camera/camera2/pipe/graph/b$e;", "Landroidx/camera/camera2/pipe/graph/b$f;", "Landroidx/camera/camera2/pipe/graph/b$g;", "Landroidx/camera/camera2/pipe/graph/b$h;", "Landroidx/camera/camera2/pipe/graph/b$i;", "Landroidx/camera/camera2/pipe/graph/b$j;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface b {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$a;", "Landroidx/camera/camera2/pipe/graph/b;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10898a = new a();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$b;", "Landroidx/camera/camera2/pipe/graph/b;", "", "Landroidx/camera/camera2/pipe/t;", "requests", "<init>", "(Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.graph.b$b, reason: collision with other inner class name */
    public static final class C0138b implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<t> requests;

        public C0138b(List<t> requests) {
            p.i(requests, "requests");
            this.requests = requests;
        }

        public final List<t> a() {
            return this.requests;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$c;", "Landroidx/camera/camera2/pipe/graph/b;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f10900a = new c();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$d;", "Landroidx/camera/camera2/pipe/graph/b;", "", "Landroidx/camera/camera2/pipe/t$a;", "listeners", "<init>", "(Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<t.a> listeners;

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends t.a> listeners) {
            p.i(listeners, "listeners");
            this.listeners = listeners;
        }

        public final List<t.a> a() {
            return this.listeners;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$e;", "Landroidx/camera/camera2/pipe/graph/b;", "", "", "graphParameters", "graph3AParameters", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Map<?, Object> graphParameters;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Map<?, Object> graph3AParameters;

        public e(Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> graph3AParameters) {
            p.i(graphParameters, "graphParameters");
            p.i(graph3AParameters, "graph3AParameters");
            this.graphParameters = graphParameters;
            this.graph3AParameters = graph3AParameters;
        }

        public final Map<?, Object> a() {
            return this.graph3AParameters;
        }

        public final Map<?, Object> b() {
            return this.graphParameters;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$f;", "Landroidx/camera/camera2/pipe/graph/b;", "Landroidx/camera/camera2/pipe/t;", "request", "<init>", "(Landroidx/camera/camera2/pipe/t;)V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/t;", "()Landroidx/camera/camera2/pipe/t;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final t request;

        public f(t request) {
            p.i(request, "request");
            this.request = request;
        }

        /* renamed from: a, reason: from getter */
        public final t getRequest() {
            return this.request;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$g;", "Landroidx/camera/camera2/pipe/graph/b;", "LA/h;", ChatTracker.WORLD_OLD, Const.STR_NEW, "<init>", "(LA/h;LA/h;)V", Const.INTENT_KEY_APIKEY, "LA/h;", Const.INTENT_KEY_PKGNAME, "()LA/h;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final A.h old;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final A.h new;

        public g(A.h hVar, A.h hVar2) {
            this.old = hVar;
            this.new = hVar2;
        }

        /* renamed from: a, reason: from getter */
        public final A.h getNew() {
            return this.new;
        }

        /* renamed from: b, reason: from getter */
        public final A.h getOld() {
            return this.old;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$h;", "Landroidx/camera/camera2/pipe/graph/b;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final h f10907a = new h();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$i;", "Landroidx/camera/camera2/pipe/graph/b;", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final i f10908a = new i();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R#\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/graph/b$j;", "Landroidx/camera/camera2/pipe/graph/b;", "", "", "triggerParameters", "<init>", "(Ljava/util/Map;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "()Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Map<?, Object> triggerParameters;

        public j(Map<?, ? extends Object> triggerParameters) {
            p.i(triggerParameters, "triggerParameters");
            this.triggerParameters = triggerParameters;
        }

        public final Map<?, Object> a() {
            return this.triggerParameters;
        }
    }
}
