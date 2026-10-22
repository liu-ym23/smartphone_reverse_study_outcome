package b74;

import android.app.Application;
import android.content.Context;
import com.bytedance.badger.Badger;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.network.b0;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.utils.C10462c;
import java.util.Collection;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f17947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f17948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f17949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f17950d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z0 f17951e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f17952f = null;

    static {
        f17952f = new e();
        f17950d = new Object();
        f17951e = new z0("BadgerCompensationManager", 1, 2);
    }

    public e() {
    }

    public static final int a(b0 r100) {
        if (r100.f199085d.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = -1;
        if (r101 == false) goto L17;
    L16:
        return r102;
    L17:
        JSONObject r103 = new JSONObject(r100.f199085d).optJSONObject("data");     // Catch: JSONException -> L14
        if (r103 == null) goto L12;
        r102 = r103.optInt("error_code");     // Catch: JSONException -> L14
    L12:
        com.bytedance.badger.e.b("CompensationManager", "onCompensate# response code=" + r102);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        com.bytedance.badger.e.c("CompensationManager", "parse response body failed", e);
        goto L16
    L5:
        r101 = false;
        goto L6
    }

    public final void b(TriggerStage r110, z64.c r111, C10462c r112) {
        if (r111 != null) goto L5;
        com.bytedance.badger.e.g("CompensationManager", "onCompensate# close compensate or request is null");
        return;
    L5:
        com.bytedance.badger.v.d.f199322f0.getClass();
        if (com.bytedance.badger.v.d.g() == false) goto L64;
        BadgerCore.Companion.getClass();
        if (j.a().isInitialized() == false) goto L71;
        com.bytedance.badger.v.j r100 = com.bytedance.badger.v.d.F;
        KProperty r101 = com.bytedance.badger.v.d.f199311a[32];
        if (((Collection) r100.a()).contains(Integer.valueOf(com.bytedance.badger.C.a.f199019c.a())) == false) goto L15;
        com.bytedance.badger.e.g("CompensationManager", "onCompensate# don't compensate for not-foreground");
        return;
    L15:
        if (f17949c == null) goto L22;
        a r102 = f17949c;
        if (r102 == null) goto L22;
        if (r102.f17938a != true) goto L22;
        com.bytedance.badger.e.f("CompensationManager", "onCompensate# has compensate,return.");
        return;
    L22:
        com.bytedance.badger.e.f("CompensationManager", "onCompensate# need compensate, triggerState=" + r110 + "...");
        int r103 = r112.c();
        if (r103 != (-1104)) goto L25;
    L27:
        Object r113 = f17950d;
        monitor-enter(r113);
        a r104 = f17949c;     // Catch: Throwable -> L61
        if (r104 == null) goto L32;
        r104.f17940c = r111;     // Catch: Throwable -> L61
        r104.f17941d = r110;     // Catch: Throwable -> L61
        if (r110 != TriggerStage.periodic_first) goto L39;
        boolean r114 = true;
    L40:
        r104.f17942e = r114;     // Catch: Throwable -> L61
        r104.f17943f = r103;     // Catch: Throwable -> L61
        r104.f17938a = false;     // Catch: Throwable -> L61
        r104.f17939b = false;     // Catch: Throwable -> L61
    L41:
        monitor-exit(r113);
        if (f17947a == true) goto L69;
        Context r115 = Badger.INSTANCE.getContext().getApplicationContext();
        if ((r115 instanceof Application) == true) goto L48;
        r115 = null;
    L48:
        Application r116 = (Application) r115;
        if (r116 == null) goto L68;
        monitor-enter(this);
    L57:
        th = move-exception;
        throw th;
    L52:
        if (f17947a == true) goto L55;
        r116.registerActivityLifecycleCallbacks(new d());     // Catch: Throwable -> L57
        f17947a = true;     // Catch: Throwable -> L57
        com.bytedance.badger.e.f("CompensationManager", "onCompensate# activityLifecycleCallbacks registered");     // Catch: Throwable -> L57
    L55:
        monitor-exit(this);
        return;
    L68:
        return;
    L69:
        return;
    L39:
        r114 = false;
        goto L40
    L32:
        if (r110 != TriggerStage.periodic_first) goto L34;
        boolean r105 = true;
    L35:
        f17949c = new a(r111, r110, r105, r103, System.currentTimeMillis());     // Catch: Throwable -> L61
        goto L41
    L34:
        r105 = false;
    L61:
        th = move-exception;
        throw th;
    L25:
        if (r103 == (-1103)) goto L27;
        com.bytedance.badger.e.g("CompensationManager", "onCompensate# ignore!");
        return;
    L71:
        return;
    }
}
