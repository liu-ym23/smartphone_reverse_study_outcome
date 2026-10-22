package a4;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f173j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile j f174k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f175a;

    /* renamed from: b, reason: collision with root package name */
    public final p.f f176b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f177c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f178d;

    /* renamed from: e, reason: collision with root package name */
    public final e f179e;

    /* renamed from: f, reason: collision with root package name */
    public final i f180f;

    /* renamed from: g, reason: collision with root package name */
    public final f7.f f181g;

    /* renamed from: h, reason: collision with root package name */
    public final int f182h;
    public final c i;

    public j(v vVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f175a = reentrantReadWriteLock;
        this.f177c = 3;
        this.f180f = (i) vVar.f168b;
        int i = vVar.f167a;
        this.f182h = i;
        this.i = (c) vVar.f169c;
        this.f178d = new Handler(Looper.getMainLooper());
        this.f176b = new p.f(0);
        this.f181g = new f7.f(1);
        e eVar = new e();
        eVar.f164a = this;
        VarHandle.storeStoreFence();
        this.f179e = eVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.f177c = 0;
            } catch (Throwable th) {
                this.f175a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            eVar.a();
        }
    }

    public static j a() {
        j jVar;
        synchronized (f173j) {
            try {
                jVar = f174k;
                if (!(jVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return jVar;
    }

    public static boolean c() {
        return f174k != null;
    }

    public final int b() {
        this.f175a.readLock().lock();
        try {
            return this.f177c;
        } finally {
            this.f175a.readLock().unlock();
        }
    }

    public final void d() {
        if (!(this.f182h == 1)) {
            od.f.e("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
            return;
        }
        if (b() == 1) {
            return;
        }
        this.f175a.writeLock().lock();
        try {
            if (this.f177c == 0) {
                return;
            }
            this.f177c = 0;
            this.f175a.writeLock().unlock();
            this.f179e.a();
        } finally {
            this.f175a.writeLock().unlock();
        }
    }

    public final void e(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f175a.writeLock().lock();
        try {
            this.f177c = 2;
            arrayList.addAll(this.f176b);
            this.f176b.clear();
            this.f175a.writeLock().unlock();
            this.f178d.post(new h(arrayList, this.f177c, th));
        } catch (Throwable th2) {
            this.f175a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0095 A[Catch: all -> 0x0088, TRY_ENTER, TryCatch #2 {all -> 0x0088, blocks: (B:36:0x0060, B:39:0x0065, B:41:0x0069, B:43:0x0076, B:50:0x0095, B:52:0x009f, B:54:0x00a2, B:56:0x00a5, B:58:0x00b5, B:59:0x00b8), top: B:97:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a5 A[Catch: all -> 0x0088, TryCatch #2 {all -> 0x0088, blocks: (B:36:0x0060, B:39:0x0065, B:41:0x0069, B:43:0x0076, B:50:0x0095, B:52:0x009f, B:54:0x00a2, B:56:0x00a5, B:58:0x00b5, B:59:0x00b8), top: B:97:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7 A[Catch: all -> 0x0102, TRY_ENTER, TryCatch #0 {all -> 0x0102, blocks: (B:63:0x00c7, B:66:0x00cf, B:48:0x008b), top: B:93:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence f(int r12, int r13, int r14, java.lang.CharSequence r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.j.f(int, int, int, java.lang.CharSequence):java.lang.CharSequence");
    }

    public final void g(g gVar) {
        p5.f.k(gVar, "initCallback cannot be null");
        this.f175a.writeLock().lock();
        try {
            if (this.f177c == 1 || this.f177c == 2) {
                this.f178d.post(new h(Arrays.asList(gVar), this.f177c, null));
            } else {
                this.f176b.add(gVar);
            }
            this.f175a.writeLock().unlock();
        } catch (Throwable th) {
            this.f175a.writeLock().unlock();
            throw th;
        }
    }
}
