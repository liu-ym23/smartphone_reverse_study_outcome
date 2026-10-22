package m5;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f22110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f22111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConnectivityManager f22113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f22114g;

    public b(Context r10) {
        this.f22108a = 0;
        this.f22109b = false;
        this.f22111d = new Object();
        this.f22112e = false;
        this.f22113f = null;
        this.f22114g = null;
        this.f22110c = r10;
        this.f22114g = a.s(r10);
    }

    public String a() {
        return this.f22114g.t();
    }

    public int b() {
        return this.f22114g.f22086a;
    }

    public boolean c() {
        return this.f22114g.w();
    }
}
