package androidx.emoji2.text;

import B0.h;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.c;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import x0.l;
import y0.g;

/* loaded from: classes.dex */
public class e extends c.AbstractC0169c {

    /* renamed from: k, reason: collision with root package name */
    public static final a f13794k = new a();

    public static class a {
        public Typeface a(Context context, g.b bVar) throws PackageManager.NameNotFoundException {
            return g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, y0.e eVar) throws PackageManager.NameNotFoundException {
            return g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class b implements c.h {

        /* renamed from: a, reason: collision with root package name */
        public final Context f13795a;

        /* renamed from: b, reason: collision with root package name */
        public final y0.e f13796b;

        /* renamed from: c, reason: collision with root package name */
        public final a f13797c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f13798d = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Handler f13799e;

        /* renamed from: f, reason: collision with root package name */
        public Executor f13800f;

        /* renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f13801g;

        /* renamed from: h, reason: collision with root package name */
        public c.i f13802h;

        /* renamed from: i, reason: collision with root package name */
        public ContentObserver f13803i;

        /* renamed from: j, reason: collision with root package name */
        public Runnable f13804j;

        public b(Context context, y0.e eVar, a aVar) {
            h.g(context, "Context cannot be null");
            h.g(eVar, "FontRequest cannot be null");
            this.f13795a = context.getApplicationContext();
            this.f13796b = eVar;
            this.f13797c = aVar;
        }

        @Override // androidx.emoji2.text.c.h
        public void a(c.i iVar) {
            h.g(iVar, "LoaderCallback cannot be null");
            synchronized (this.f13798d) {
                this.f13802h = iVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f13798d) {
                try {
                    this.f13802h = null;
                    ContentObserver contentObserver = this.f13803i;
                    if (contentObserver != null) {
                        this.f13797c.c(this.f13795a, contentObserver);
                        this.f13803i = null;
                    }
                    Handler handler = this.f13799e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f13804j);
                    }
                    this.f13799e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f13801g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f13800f = null;
                    this.f13801g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.f13798d) {
                try {
                    if (this.f13802h == null) {
                        return;
                    }
                    try {
                        g.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f13798d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            l.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f13797c.a(this.f13795a, bVarE);
                            ByteBuffer byteBufferA = t0.l.a(this.f13795a, null, bVarE.e());
                            if (byteBufferA == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            f fVarB = f.b(typefaceA, byteBufferA);
                            l.b();
                            synchronized (this.f13798d) {
                                try {
                                    c.i iVar = this.f13802h;
                                    if (iVar != null) {
                                        iVar.b(fVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            l.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f13798d) {
                            try {
                                c.i iVar2 = this.f13802h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void d() {
            synchronized (this.f13798d) {
                try {
                    if (this.f13802h == null) {
                        return;
                    }
                    if (this.f13800f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = O0.b.b("emojiCompat");
                        this.f13801g = threadPoolExecutorB;
                        this.f13800f = threadPoolExecutorB;
                    }
                    this.f13800f.execute(new Runnable() { // from class: O0.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5141a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final g.b e() {
            try {
                g.a aVarB = this.f13797c.b(this.f13795a, this.f13796b);
                if (aVarB.e() == 0) {
                    g.b[] bVarArrC = aVarB.c();
                    if (bVarArrC == null || bVarArrC.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrC[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.e() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        public void f(Executor executor) {
            synchronized (this.f13798d) {
                this.f13800f = executor;
            }
        }
    }

    public e(Context context, y0.e eVar) {
        super(new b(context, eVar, f13794k));
    }

    public e c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
