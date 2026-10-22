package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f1926j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile d f1927k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f1928a;

    /* renamed from: b, reason: collision with root package name */
    public final p.b f1929b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f1930c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f1931d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1932e;

    /* renamed from: f, reason: collision with root package name */
    public final h f1933f;

    /* renamed from: g, reason: collision with root package name */
    public final C0014d f1934g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.emoji2.text.b f1935i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f1936b;

        /* renamed from: c, reason: collision with root package name */
        public volatile androidx.emoji2.text.h f1937c;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final d f1938a;

        public b(d dVar) {
            this.f1938a = dVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final h f1939a;

        /* renamed from: b, reason: collision with root package name */
        public int f1940b = 0;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.emoji2.text.b f1941c = new androidx.emoji2.text.b();

        public c(h hVar) {
            this.f1939a = hVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    public static class C0014d implements j {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f1942a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1943b;

        public g(List list, int i10, Throwable th) {
            y.n(list, "initCallbacks cannot be null");
            this.f1942a = new ArrayList(list);
            this.f1943b = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = this.f1942a;
            int size = arrayList.size();
            int i10 = 0;
            if (this.f1943b != 1) {
                while (i10 < size) {
                    ((f) arrayList.get(i10)).a();
                    i10++;
                }
            } else {
                while (i10 < size) {
                    ((f) arrayList.get(i10)).b();
                    i10++;
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface h {
        void a(i iVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(androidx.emoji2.text.h hVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface j {
    }

    public d(EmojiCompatInitializer.a aVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1928a = reentrantReadWriteLock;
        this.f1930c = 3;
        h hVar = aVar.f1939a;
        this.f1933f = hVar;
        int i10 = aVar.f1940b;
        this.h = i10;
        this.f1935i = aVar.f1941c;
        this.f1931d = new Handler(Looper.getMainLooper());
        this.f1929b = new p.b(null);
        this.f1934g = new C0014d();
        a aVar2 = new a(this);
        this.f1932e = aVar2;
        reentrantReadWriteLock.writeLock().lock();
        if (i10 == 0) {
            try {
                this.f1930c = 0;
            } catch (Throwable th) {
                this.f1928a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                hVar.a(new androidx.emoji2.text.c(aVar2));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static d a() {
        d dVar;
        synchronized (f1926j) {
            try {
                dVar = f1927k;
                if (!(dVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return dVar;
    }

    public final int b() {
        this.f1928a.readLock().lock();
        try {
            return this.f1930c;
        } finally {
            this.f1928a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f1928a.writeLock().lock();
        try {
            if (this.f1930c == 0) {
                return;
            }
            this.f1930c = 0;
            this.f1928a.writeLock().unlock();
            a aVar = this.f1932e;
            d dVar = aVar.f1938a;
            try {
                dVar.f1933f.a(new androidx.emoji2.text.c(aVar));
            } catch (Throwable th) {
                dVar.d(th);
            }
        } finally {
            this.f1928a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1928a.writeLock().lock();
        try {
            this.f1930c = 2;
            arrayList.addAll(this.f1929b);
            this.f1929b.clear();
            this.f1928a.writeLock().unlock();
            this.f1931d.post(new g(arrayList, this.f1930c, th));
        } catch (Throwable th2) {
            this.f1928a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008f A[Catch: all -> 0x0082, TRY_ENTER, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:89:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:89:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1 A[Catch: all -> 0x00f4, TRY_ENTER, TryCatch #1 {all -> 0x00f4, blocks: (B:59:0x00c1, B:62:0x00c9, B:44:0x0085), top: B:91:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r10, int r11, int r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.d.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(f fVar) {
        y.n(fVar, "initCallback cannot be null");
        this.f1928a.writeLock().lock();
        try {
            if (this.f1930c == 1 || this.f1930c == 2) {
                this.f1931d.post(new g(Arrays.asList(fVar), this.f1930c, null));
            } else {
                this.f1929b.add(fVar);
            }
            this.f1928a.writeLock().unlock();
        } catch (Throwable th) {
            this.f1928a.writeLock().unlock();
            throw th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class f {
        public void a() {
        }

        public void b() {
        }
    }
}
