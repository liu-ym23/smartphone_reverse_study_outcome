package z3;

import android.os.Looper;
import java.util.ArrayList;
import p.p0;
import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {
    public static final ThreadLocal i = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public p0 f16342a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f16343b;

    /* renamed from: c, reason: collision with root package name */
    public sa.c f16344c;

    /* renamed from: d, reason: collision with root package name */
    public y0.a f16345d;

    /* renamed from: e, reason: collision with root package name */
    public n6.a f16346e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16347f;

    /* renamed from: g, reason: collision with root package name */
    public float f16348g;

    /* renamed from: h, reason: collision with root package name */
    public u f16349h;

    public final boolean a() {
        n6.a aVar = this.f16346e;
        aVar.getClass();
        return Thread.currentThread() == ((Looper) aVar.f8777f).getThread();
    }
}
