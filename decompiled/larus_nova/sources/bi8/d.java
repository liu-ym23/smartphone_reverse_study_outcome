package bi8;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f19157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f19158b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f19159c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f19160d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f19161e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19166e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19167f;

        public a() {
            this.f19164c = "";
        }
    }

    public d() {
    }

    static {
        f19157a = new d();
        f19158b = LazyKt.lazy(new bi8.a());
        f19159c = LazyKt.lazy(new b());
        f19160d = LazyKt.lazy(new c());
    }

    public static final void a(String r100) {
        d r101 = f19157a;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f19161e == false) goto L9;
        monitor-exit(r101);
        return;
    L9:
        f19161e = true;     // Catch: Throwable -> L13
        com.larus.platform.service.g r102 = com.larus.platform.service.g.f365738a;     // Catch: Throwable -> L16
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L16
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, "get_message_list");     // Catch: Throwable -> L16
        r103.put("event_type", "high_request_frequency");     // Catch: Throwable -> L16
        r103.put("extra", r100);     // Catch: Throwable -> L16
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r102.monitorEventForSlardar("chat_message_list_monitor", r103, null, null);     // Catch: Throwable -> L16
    L11:
        monitor-exit(r101);
    }
}
