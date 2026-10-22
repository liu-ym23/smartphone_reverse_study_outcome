package androidx.emoji2.text;

import C.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.e;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class j extends e.c {

    /* renamed from: k, reason: collision with root package name */
    private static final a f10352k = new a();

    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return C.g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, C.e eVar) {
            return C.g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements e.h {

        /* renamed from: a, reason: collision with root package name */
        private final Context f10353a;

        /* renamed from: b, reason: collision with root package name */
        private final C.e f10354b;

        /* renamed from: c, reason: collision with root package name */
        private final a f10355c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f10356d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private Handler f10357e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f10358f;

        /* renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f10359g;

        /* renamed from: h, reason: collision with root package name */
        e.i f10360h;

        /* renamed from: i, reason: collision with root package name */
        private ContentObserver f10361i;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f10362j;

        b(Context context, C.e eVar, a aVar) {
            D.h.f(context, "Context cannot be null");
            D.h.f(eVar, "FontRequest cannot be null");
            this.f10353a = context.getApplicationContext();
            this.f10354b = eVar;
            this.f10355c = aVar;
        }

        private void b() {
            synchronized (this.f10356d) {
                try {
                    this.f10360h = null;
                    ContentObserver contentObserver = this.f10361i;
                    if (contentObserver != null) {
                        this.f10355c.c(this.f10353a, contentObserver);
                        this.f10361i = null;
                    }
                    Handler handler = this.f10357e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f10362j);
                    }
                    this.f10357e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f10359g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f10358f = null;
                    this.f10359g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private g.b e() {
            try {
                g.a aVarB = this.f10355c.b(this.f10353a, this.f10354b);
                if (aVarB.c() == 0) {
                    g.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e6) {
                throw new RuntimeException("provider not found", e6);
            }
        }

        @Override // androidx.emoji2.text.e.h
        public void a(e.i iVar) {
            D.h.f(iVar, "LoaderCallback cannot be null");
            synchronized (this.f10356d) {
                this.f10360h = iVar;
            }
            d();
        }

        void c() {
            synchronized (this.f10356d) {
                try {
                    if (this.f10360h == null) {
                        return;
                    }
                    try {
                        g.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f10356d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            androidx.core.os.i.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f10355c.a(this.f10353a, bVarE);
                            ByteBuffer byteBufferA = androidx.core.graphics.h.a(this.f10353a, null, bVarE.d());
                            if (byteBufferA == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            m mVarB = m.b(typefaceA, byteBufferA);
                            androidx.core.os.i.b();
                            synchronized (this.f10356d) {
                                try {
                                    e.i iVar = this.f10360h;
                                    if (iVar != null) {
                                        iVar.b(mVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            androidx.core.os.i.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f10356d) {
                            try {
                                e.i iVar2 = this.f10360h;
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

        void d() {
            synchronized (this.f10356d) {
                try {
                    if (this.f10360h == null) {
                        return;
                    }
                    if (this.f10358f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("emojiCompat");
                        this.f10359g = threadPoolExecutorB;
                        this.f10358f = threadPoolExecutorB;
                    }
                    this.f10358f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f10363a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f10356d) {
                this.f10358f = executor;
            }
        }
    }

    public j(Context context, C.e eVar) {
        super(new b(context, eVar, f10352k));
    }

    public j c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
