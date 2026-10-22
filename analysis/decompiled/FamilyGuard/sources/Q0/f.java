package Q0;

import Q0.c;
import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public class f implements d {
    @Override // Q0.d
    public c a(Context context, c.a aVar) {
        boolean z5 = androidx.core.content.a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z5 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z5 ? new e(context, aVar) : new j();
    }
}
