package W;

import android.os.Looper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f1940i = new ThreadLocal();

    /* renamed from: e, reason: collision with root package name */
    public final B0.c f1945e;

    /* renamed from: h, reason: collision with root package name */
    public m3.i f1948h;

    /* renamed from: a, reason: collision with root package name */
    public final q.l f1941a = new q.l(0);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1942b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final a f1943c = new a(this);

    /* renamed from: d, reason: collision with root package name */
    public final androidx.activity.d f1944d = new androidx.activity.d(5, this);

    /* renamed from: f, reason: collision with root package name */
    public boolean f1946f = false;

    /* renamed from: g, reason: collision with root package name */
    public float f1947g = 1.0f;

    public e(B0.c cVar) {
        this.f1945e = cVar;
    }

    public final boolean a() {
        B0.c cVar = this.f1945e;
        cVar.getClass();
        return Thread.currentThread() == ((Looper) cVar.f137b).getThread();
    }
}
