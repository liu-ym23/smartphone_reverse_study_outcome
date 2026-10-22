package w;

import android.util.Log;
import o0.RunnableC1754a;

/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static A0.b f6804a = null;
    public static boolean b = false;
    public static final int c;

    static {
        if (String.valueOf(10290).charAt(0) >= '4') {
            c = 10009889;
        } else {
            c = 10290;
        }
    }

    public static void a(String str, Throwable th) {
        A0.b bVar = f6804a;
        if (bVar != null) {
            if (((RunnableC1754a) bVar.b).b.isDebug()) {
                Log.i("AppLog", str, th);
            }
        } else if (b) {
            Log.d("AppLog", str, th);
        }
    }

    public static void b(Throwable th) {
        a("U SHALL NOT PASS!", th);
    }
}
