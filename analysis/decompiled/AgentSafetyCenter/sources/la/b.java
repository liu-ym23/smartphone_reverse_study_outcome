package la;

import android.content.Context;
import android.content.IntentFilter;
import h.a0;
import java.util.ArrayList;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static b f7817d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f7818e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7821c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final a f7819a = new a(this, 0);

    /* renamed from: b, reason: collision with root package name */
    public final a f7820b = new a(this, 1);

    public b(Context context) {
        a0 a0Var = new a0(this, 1);
        try {
            context.unregisterReceiver(a0Var);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(a0Var, intentFilter);
        } catch (Exception e10) {
            c.f("EnvironmentReceiver", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
        }
    }
}
