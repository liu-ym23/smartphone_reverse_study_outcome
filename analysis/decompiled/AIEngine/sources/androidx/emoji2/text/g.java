package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.appcompat.widget.z0;
import androidx.emoji2.text.d;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mb.y;
import s0.k;
import s0.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends d.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1958d = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements d.h {

        /* renamed from: a, reason: collision with root package name */
        public final Context f1959a;

        /* renamed from: b, reason: collision with root package name */
        public final s0.e f1960b;

        /* renamed from: c, reason: collision with root package name */
        public final a f1961c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f1962d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Handler f1963e;

        /* renamed from: f, reason: collision with root package name */
        public ThreadPoolExecutor f1964f;

        /* renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f1965g;
        public d.i h;

        public b(Context context, s0.e eVar) {
            y.n(context, "Context cannot be null");
            this.f1959a = context.getApplicationContext();
            this.f1960b = eVar;
            this.f1961c = g.f1958d;
        }

        @Override // androidx.emoji2.text.d.h
        public final void a(d.i iVar) {
            synchronized (this.f1962d) {
                this.h = iVar;
            }
            synchronized (this.f1962d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    if (this.f1964f == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new android.llama.cpp.a("emojiCompat", 2));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        this.f1965g = threadPoolExecutor;
                        this.f1964f = threadPoolExecutor;
                    }
                    this.f1964f.execute(new z0(this, 16));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void b() {
            synchronized (this.f1962d) {
                try {
                    this.h = null;
                    Handler handler = this.f1963e;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                    }
                    this.f1963e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f1965g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f1964f = null;
                    this.f1965g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final l c() {
            try {
                a aVar = this.f1961c;
                Context context = this.f1959a;
                s0.e eVar = this.f1960b;
                aVar.getClass();
                k kVarA = s0.d.a(context, List.of(eVar));
                int i10 = kVarA.f11859a;
                if (i10 != 0) {
                    throw new RuntimeException(ai.onnxruntime.a.g(i10, "fetchFonts failed (", ")"));
                }
                l[] lVarArr = kVarA.f11860b.get(0);
                if (lVarArr == null || lVarArr.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return lVarArr[0];
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }
    }
}
