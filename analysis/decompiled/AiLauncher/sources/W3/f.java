package W3;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.screenops.internal.EventBroadcastManager;
import com.stepos.ability.screenops.internal.ServiceConnector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010!¨\u0006#"}, d2 = {"LW3/f;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "", "LW3/c;", "rules", "LW3/e;", "listener", "c", "(Ljava/util/List;LW3/e;)V", "e", "(LW3/e;)V", "LW3/h;", "targets", "LW3/g;", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Ljava/util/List;", "", "packageName", "LW3/b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)LW3/b;", "Landroid/content/Context;", "Lcom/stepos/ability/screenops/internal/EventBroadcastManager;", "Lcom/stepos/ability/screenops/internal/EventBroadcastManager;", "broadcastManager", "Lcom/stepos/ability/screenops/internal/ServiceConnector;", "Lcom/stepos/ability/screenops/internal/ServiceConnector;", "serviceConnector", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6652a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static EventBroadcastManager broadcastManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static ServiceConnector serviceConnector;

    public final b a(String packageName) {
        ServiceConnector serviceConnector2 = serviceConnector;
        if (serviceConnector2 != null) {
            return serviceConnector2.l(packageName);
        }
        throw new IllegalStateException("ScreenOpsSDK.init() not called");
    }

    public final void b(Context context2) {
        p.i(context2, "context");
        if (context != null) {
            return;
        }
        Context applicationContext = context2.getApplicationContext();
        context = applicationContext;
        p.f(applicationContext);
        broadcastManager = new EventBroadcastManager(applicationContext);
        serviceConnector = new ServiceConnector(applicationContext);
    }

    public final void c(List<MonitorRule> rules, e listener) {
        p.i(rules, "rules");
        p.i(listener, "listener");
        EventBroadcastManager eventBroadcastManager = broadcastManager;
        if (eventBroadcastManager == null) {
            throw new IllegalStateException("ScreenOpsSDK.init() not called");
        }
        eventBroadcastManager.g(rules, listener);
    }

    public final List<g> d(List<SetTextTarget> targets) {
        p.i(targets, "targets");
        ServiceConnector serviceConnector2 = serviceConnector;
        if (serviceConnector2 != null) {
            return serviceConnector2.o(targets);
        }
        throw new IllegalStateException("ScreenOpsSDK.init() not called");
    }

    public final void e(e listener) {
        p.i(listener, "listener");
        EventBroadcastManager eventBroadcastManager = broadcastManager;
        if (eventBroadcastManager == null) {
            return;
        }
        eventBroadcastManager.j(listener);
    }
}
