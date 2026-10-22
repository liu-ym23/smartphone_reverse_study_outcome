package androidx.work;

import androidx.datastore.preferences.protobuf.b1;
import h2.e;
import h2.k;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public final int h;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f2814a = h2.b.a(false);

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineDispatcher f2815b = Dispatchers.getDefault();

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f2816c = h2.b.a(true);

    /* renamed from: d, reason: collision with root package name */
    public final b1 f2817d = new b1(20);

    /* renamed from: e, reason: collision with root package name */
    public final e f2818e = e.f9267a;

    /* renamed from: f, reason: collision with root package name */
    public final k f2819f = k.f9275a;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.b f2820g = new androidx.lifecycle.b(7);

    /* renamed from: i, reason: collision with root package name */
    public final int f2821i = Integer.MAX_VALUE;

    /* renamed from: k, reason: collision with root package name */
    public final int f2823k = 20;

    /* renamed from: j, reason: collision with root package name */
    public final int f2822j = 8;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2824l = true;

    /* renamed from: m, reason: collision with root package name */
    public final b1 f2825m = new b1(19);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.work.a$a, reason: collision with other inner class name */
    public static final class C0021a {

        /* renamed from: a, reason: collision with root package name */
        public int f2826a = 4;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        a a();
    }

    public a(C0021a c0021a) {
        this.h = c0021a.f2826a;
    }
}
