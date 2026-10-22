package fb;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8782a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8783b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet<a> f8784c;

    /* renamed from: d, reason: collision with root package name */
    public final ConnectivityManager f8785d;

    /* renamed from: e, reason: collision with root package name */
    public final d f8786e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8787f;

    /* renamed from: g, reason: collision with root package name */
    public final c f8788g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a();
    }

    public b(Context context) {
        g.f(context, "context");
        this.f8782a = context;
        this.f8783b = new Object();
        this.f8784c = new HashSet<>();
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        this.f8785d = connectivityManager;
        d dVar = new d(this);
        this.f8786e = dVar;
        int i10 = Build.VERSION.SDK_INT;
        if (connectivityManager != null) {
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(3).build();
            c cVar = new c(this);
            this.f8788g = cVar;
            connectivityManager.registerNetworkCallback(networkRequestBuild, cVar);
            return;
        }
        try {
            if (i10 >= 33) {
                context.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
            } else {
                context.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            this.f8787f = true;
        } catch (Exception unused) {
        }
    }

    public static final void a(b bVar) {
        synchronized (bVar.f8783b) {
            try {
                Iterator<a> it = bVar.f8784c.iterator();
                g.e(it, "iterator(...)");
                while (it.hasNext()) {
                    it.next().a();
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        return hb.b.a(this.f8782a);
    }

    public final void c() {
        c cVar;
        synchronized (this.f8783b) {
            this.f8784c.clear();
            if (this.f8787f) {
                try {
                    this.f8782a.unregisterReceiver(this.f8786e);
                } catch (Exception unused) {
                }
            }
            ConnectivityManager connectivityManager = this.f8785d;
            if (connectivityManager != null && (cVar = this.f8788g) != null) {
                connectivityManager.unregisterNetworkCallback(cVar);
            }
            n nVar = n.f10413a;
        }
    }
}
