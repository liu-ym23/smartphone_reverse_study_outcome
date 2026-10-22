package X;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f2053j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile j f2054k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f2055a;

    /* renamed from: b, reason: collision with root package name */
    public final q.g f2056b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2057c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f2058d;

    /* renamed from: e, reason: collision with root package name */
    public final e f2059e;

    /* renamed from: f, reason: collision with root package name */
    public final i f2060f;

    /* renamed from: g, reason: collision with root package name */
    public final y1.f f2061g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2062h;

    /* renamed from: i, reason: collision with root package name */
    public final C0112c f2063i;

    public j(x xVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2055a = reentrantReadWriteLock;
        this.f2057c = 3;
        this.f2060f = xVar.f2050a;
        int i4 = xVar.f2051b;
        this.f2062h = i4;
        this.f2063i = xVar.f2052c;
        this.f2058d = new Handler(Looper.getMainLooper());
        this.f2056b = new q.g(0);
        this.f2061g = new y1.f();
        e eVar = new e(25, this);
        this.f2059e = eVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i4 == 0) {
            try {
                this.f2057c = 0;
            } catch (Throwable th) {
                this.f2055a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            eVar.H();
        }
    }

    public static j a() {
        j jVar;
        synchronized (f2053j) {
            try {
                jVar = f2054k;
                if (!(jVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return jVar;
    }

    public final int b() {
        this.f2055a.readLock().lock();
        try {
            return this.f2057c;
        } finally {
            this.f2055a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f2062h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f2055a.writeLock().lock();
        try {
            if (this.f2057c == 0) {
                return;
            }
            this.f2057c = 0;
            this.f2055a.writeLock().unlock();
            this.f2059e.H();
        } finally {
            this.f2055a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f2055a.writeLock().lock();
        try {
            this.f2057c = 2;
            arrayList.addAll(this.f2056b);
            this.f2056b.clear();
            this.f2055a.writeLock().unlock();
            this.f2058d.post(new android.support.v4.os.a(arrayList, this.f2057c, th));
        } catch (Throwable th2) {
            this.f2055a.writeLock().unlock();
            throw th2;
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f2055a.writeLock().lock();
        try {
            this.f2057c = 1;
            arrayList.addAll(this.f2056b);
            this.f2056b.clear();
            this.f2055a.writeLock().unlock();
            this.f2058d.post(new android.support.v4.os.a(arrayList, this.f2057c));
        } catch (Throwable th) {
            this.f2055a.writeLock().unlock();
            throw th;
        }
    }

    public final CharSequence f(int i4, int i5, CharSequence charSequence) {
        if (!(b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        com.airbnb.lottie.h.f("start should be <= than end", i4 <= i5);
        if (charSequence == null) {
            return null;
        }
        com.airbnb.lottie.h.f("start should be < than charSequence length", i4 <= charSequence.length());
        com.airbnb.lottie.h.f("end should be < than charSequence length", i5 <= charSequence.length());
        return (charSequence.length() == 0 || i4 == i5) ? charSequence : this.f2059e.I(charSequence, i4, i5, false);
    }

    public final void g(h hVar) {
        com.airbnb.lottie.h.h(hVar, "initCallback cannot be null");
        this.f2055a.writeLock().lock();
        try {
            if (this.f2057c == 1 || this.f2057c == 2) {
                this.f2058d.post(new android.support.v4.os.a(hVar, this.f2057c));
            } else {
                this.f2056b.add(hVar);
            }
            this.f2055a.writeLock().unlock();
        } catch (Throwable th) {
            this.f2055a.writeLock().unlock();
            throw th;
        }
    }
}
