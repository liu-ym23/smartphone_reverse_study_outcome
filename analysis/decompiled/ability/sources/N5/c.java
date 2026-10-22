package N5;

import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class c {
    public static c d;
    public static final Object e = new Object();
    public final ArrayList c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final a f1011a = new a(this, 0);
    public final a b = new a(this, 1);

    public c(Context context) {
        b bVar = new b(this, 0);
        try {
            context.unregisterReceiver(bVar);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(bVar, intentFilter);
        } catch (Exception e6) {
            W5.c.f("EnvironmentReceiver", "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
        }
    }
}
