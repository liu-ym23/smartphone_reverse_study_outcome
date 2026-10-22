package Q0;

import Q0.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* loaded from: classes.dex */
final class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4870a;

    /* renamed from: b, reason: collision with root package name */
    final c.a f4871b;

    /* renamed from: c, reason: collision with root package name */
    boolean f4872c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4873d;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f4874e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z5 = eVar.f4872c;
            eVar.f4872c = eVar.h(context);
            if (z5 != e.this.f4872c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f4872c);
                }
                e eVar2 = e.this;
                eVar2.f4871b.a(eVar2.f4872c);
            }
        }
    }

    e(Context context, c.a aVar) {
        this.f4870a = context.getApplicationContext();
        this.f4871b = aVar;
    }

    private void i() {
        if (this.f4873d) {
            return;
        }
        this.f4872c = h(this.f4870a);
        try {
            this.f4870a.registerReceiver(this.f4874e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4873d = true;
        } catch (SecurityException e6) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e6);
            }
        }
    }

    private void n() {
        if (this.f4873d) {
            this.f4870a.unregisterReceiver(this.f4874e);
            this.f4873d = false;
        }
    }

    @Override // Q0.i
    public void a() {
        i();
    }

    @Override // Q0.i
    public void d() {
    }

    @Override // Q0.i
    public void g() {
        n();
    }

    boolean h(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) X0.j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e6) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e6);
            }
            return true;
        }
    }
}
