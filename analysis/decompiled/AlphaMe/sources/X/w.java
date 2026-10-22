package X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Trace;
import androidx.appcompat.app.C0186l;
import java.nio.MappedByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class w implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2093a;

    /* renamed from: b, reason: collision with root package name */
    public final H.d f2094b;

    /* renamed from: c, reason: collision with root package name */
    public final y1.f f2095c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2096d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f2097e;

    /* renamed from: f, reason: collision with root package name */
    public Executor f2098f;

    /* renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f2099g;

    /* renamed from: h, reason: collision with root package name */
    public B0.f f2100h;

    /* renamed from: i, reason: collision with root package name */
    public v f2101i;

    public w(Context context, H.d dVar) {
        y1.f fVar = x.f2102d;
        this.f2096d = new Object();
        com.airbnb.lottie.h.h(context, "Context cannot be null");
        this.f2093a = context.getApplicationContext();
        this.f2094b = dVar;
        this.f2095c = fVar;
    }

    @Override // X.i
    public final void a(B0.f fVar) {
        synchronized (this.f2096d) {
            this.f2100h = fVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f2096d) {
            try {
                this.f2100h = null;
                v vVar = this.f2101i;
                if (vVar != null) {
                    y1.f fVar = this.f2095c;
                    Context context = this.f2093a;
                    fVar.getClass();
                    context.getContentResolver().unregisterContentObserver(vVar);
                    this.f2101i = null;
                }
                Handler handler = this.f2097e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f2097e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2099g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2098f = null;
                this.f2099g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.f2096d) {
            try {
                if (this.f2100h == null) {
                    return;
                }
                if (this.f2098f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0110a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f2099g = threadPoolExecutor;
                    this.f2098f = threadPoolExecutor;
                }
                final int i4 = 0;
                this.f2098f.execute(new Runnable(this) { // from class: X.u

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ w f2090b;

                    {
                        this.f2090b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i5 = i4;
                        w wVar = this.f2090b;
                        switch (i5) {
                            case 0:
                                synchronized (wVar.f2096d) {
                                    try {
                                        if (wVar.f2100h == null) {
                                            return;
                                        }
                                        try {
                                            H.i iVarD = wVar.d();
                                            int i6 = iVarD.f683e;
                                            if (i6 == 2) {
                                                synchronized (wVar.f2096d) {
                                                }
                                            }
                                            if (i6 != 0) {
                                                throw new RuntimeException("fetchFonts result is not OK. (" + i6 + ")");
                                            }
                                            try {
                                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                                y1.f fVar = wVar.f2095c;
                                                Context context = wVar.f2093a;
                                                fVar.getClass();
                                                Typeface typefaceH = D.g.f364a.H(context, new H.i[]{iVarD}, 0);
                                                MappedByteBuffer mappedByteBufferS = B0.f.S(wVar.f2093a, iVarD.f679a);
                                                if (mappedByteBufferS == null || typefaceH == null) {
                                                    throw new RuntimeException("Unable to open file.");
                                                }
                                                try {
                                                    Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                                    t.d dVar = new t.d(typefaceH, com.airbnb.lottie.h.B(mappedByteBufferS));
                                                    Trace.endSection();
                                                    synchronized (wVar.f2096d) {
                                                        try {
                                                            B0.f fVar2 = wVar.f2100h;
                                                            if (fVar2 != null) {
                                                                fVar2.V(dVar);
                                                            }
                                                        } finally {
                                                        }
                                                    }
                                                    wVar.b();
                                                    return;
                                                } finally {
                                                    Trace.endSection();
                                                }
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            synchronized (wVar.f2096d) {
                                                try {
                                                    B0.f fVar3 = wVar.f2100h;
                                                    if (fVar3 != null) {
                                                        fVar3.U(th2);
                                                    }
                                                    wVar.b();
                                                    return;
                                                } finally {
                                                }
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            default:
                                wVar.c();
                                return;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final H.i d() throws Throwable {
        try {
            y1.f fVar = this.f2095c;
            Context context = this.f2093a;
            H.d dVar = this.f2094b;
            fVar.getClass();
            C0186l c0186lA = H.c.a(context, dVar);
            if (c0186lA.f2660b != 0) {
                throw new RuntimeException(AbstractC0831a.d(new StringBuilder("fetchFonts failed ("), c0186lA.f2660b, ")"));
            }
            H.i[] iVarArr = (H.i[]) c0186lA.f2661c;
            if (iVarArr == null || iVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return iVarArr[0];
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("provider not found", e4);
        }
    }
}
