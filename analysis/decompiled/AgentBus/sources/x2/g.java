package x2;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f11111j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile g f11112k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f11113a;

    /* renamed from: b, reason: collision with root package name */
    public final k.f f11114b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f11115c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f11116d;

    /* renamed from: e, reason: collision with root package name */
    public final u4.l f11117e;

    /* renamed from: f, reason: collision with root package name */
    public final f f11118f;

    /* renamed from: g, reason: collision with root package name */
    public final w4.a f11119g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11120h;

    /* renamed from: i, reason: collision with root package name */
    public final b f11121i;

    public g(o oVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f11113a = reentrantReadWriteLock;
        this.f11115c = 3;
        f fVar = oVar.f11140a;
        this.f11118f = fVar;
        int i2 = oVar.f11141b;
        this.f11120h = i2;
        this.f11121i = oVar.f11142c;
        this.f11116d = new Handler(Looper.getMainLooper());
        this.f11114b = new k.f(0);
        this.f11119g = new w4.a();
        u4.l lVar = new u4.l(this);
        this.f11117e = lVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i2 == 0) {
            try {
                this.f11115c = 0;
            } catch (Throwable th) {
                this.f11113a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                fVar.B(new c(lVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static g a() {
        g gVar;
        synchronized (f11111j) {
            try {
                gVar = f11112k;
                if (!(gVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return gVar;
    }

    public final int b() {
        this.f11113a.readLock().lock();
        try {
            return this.f11115c;
        } finally {
            this.f11113a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f11120h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f11113a.writeLock().lock();
        try {
            if (this.f11115c == 0) {
                return;
            }
            this.f11115c = 0;
            this.f11113a.writeLock().unlock();
            u4.l lVar = this.f11117e;
            g gVar = (g) lVar.f10090a;
            try {
                gVar.f11118f.B(new c(lVar));
            } catch (Throwable th) {
                gVar.d(th);
            }
        } finally {
            this.f11113a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f11113a.writeLock().lock();
        try {
            this.f11115c = 2;
            arrayList.addAll(this.f11114b);
            this.f11114b.clear();
            this.f11113a.writeLock().unlock();
            this.f11116d.post(new e(arrayList, this.f11115c, th));
        } catch (Throwable th2) {
            this.f11113a.writeLock().unlock();
            throw th2;
        }
    }
}
