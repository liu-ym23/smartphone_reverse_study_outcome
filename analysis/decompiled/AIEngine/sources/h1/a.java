package h1;

import android.os.Looper;
import android.view.Choreographer;
import androidx.appcompat.widget.z0;
import java.util.ArrayList;
import p.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final ThreadLocal<a> f9205i = new ThreadLocal<>();

    /* renamed from: e, reason: collision with root package name */
    public final d f9210e;
    public c h;

    /* renamed from: a, reason: collision with root package name */
    public final o<b, Long> f9206a = new o<>();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f9207b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final C0087a f9208c = new C0087a();

    /* renamed from: d, reason: collision with root package name */
    public final z0 f9209d = new z0(this, 13);

    /* renamed from: f, reason: collision with root package name */
    public boolean f9211f = false;

    /* renamed from: g, reason: collision with root package name */
    public float f9212g = 1.0f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: h1.a$a, reason: collision with other inner class name */
    public class C0087a {
        public C0087a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        boolean doAnimationFrame(long j10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public h1.b f9214a;

        public c() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Choreographer f9216a = Choreographer.getInstance();

        /* renamed from: b, reason: collision with root package name */
        public final Looper f9217b = Looper.myLooper();
    }

    public a(d dVar) {
        this.f9210e = dVar;
    }

    public final boolean a() {
        d dVar = this.f9210e;
        dVar.getClass();
        return Thread.currentThread() == dVar.f9217b.getThread();
    }
}
