package g5;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f19916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f19917c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f19918a;

    static {
    }

    public a() {
        this.f19918a = false;
    }

    public void a(String r10) {
    }

    public void b(String r10, Message r11) {
        this.f19918a = false;
        a(r10);
    }

    public void c(String r10) {
        this.f19918a = true;
    }

    public abstract boolean d();
}
