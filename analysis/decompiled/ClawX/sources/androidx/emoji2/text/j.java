package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f607j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile j f608k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f609a;

    /* renamed from: b, reason: collision with root package name */
    public final j.f f610b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f611c;
    public final Handler d;

    /* renamed from: e, reason: collision with root package name */
    public final e f612e;

    /* renamed from: f, reason: collision with root package name */
    public final i f613f;

    /* renamed from: g, reason: collision with root package name */
    public final t1.f f614g;

    /* renamed from: h, reason: collision with root package name */
    public final int f615h;

    /* renamed from: i, reason: collision with root package name */
    public final c f616i;

    public j(v vVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f609a = reentrantReadWriteLock;
        this.f611c = 3;
        i iVar = vVar.f641a;
        this.f613f = iVar;
        int i8 = vVar.f642b;
        this.f615h = i8;
        this.f616i = vVar.f643c;
        this.d = new Handler(Looper.getMainLooper());
        this.f610b = new j.f();
        this.f614g = new t1.f(2);
        e eVar = new e(this);
        this.f612e = eVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i8 == 0) {
            try {
                this.f611c = 0;
            } catch (Throwable th) {
                this.f609a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                iVar.e(new d(eVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static j a() {
        j jVar;
        synchronized (f607j) {
            try {
                jVar = f608k;
                if (!(jVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return jVar;
    }

    public final int b() {
        this.f609a.readLock().lock();
        try {
            return this.f611c;
        } finally {
            this.f609a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f615h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f609a.writeLock().lock();
        try {
            if (this.f611c == 0) {
                return;
            }
            this.f611c = 0;
            this.f609a.writeLock().unlock();
            e eVar = this.f612e;
            j jVar = eVar.f601a;
            try {
                jVar.f613f.e(new d(eVar));
            } catch (Throwable th) {
                jVar.d(th);
            }
        } finally {
            this.f609a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f609a.writeLock().lock();
        try {
            this.f611c = 2;
            arrayList.addAll(this.f610b);
            this.f610b.clear();
            this.f609a.writeLock().unlock();
            this.d.post(new h(arrayList, this.f611c, th));
        } catch (Throwable th2) {
            this.f609a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f A[Catch: all -> 0x0082, TRY_ENTER, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:94:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:94:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1 A[Catch: all -> 0x00f7, TRY_ENTER, TryCatch #1 {all -> 0x00f7, blocks: (B:59:0x00c1, B:62:0x00c9, B:65:0x00d0, B:44:0x0085), top: B:96:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r10, int r11, int r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.j.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(g gVar) {
        a.a.j(gVar, "initCallback cannot be null");
        this.f609a.writeLock().lock();
        try {
            if (this.f611c == 1 || this.f611c == 2) {
                this.d.post(new h(Arrays.asList(gVar), this.f611c, null));
            } else {
                this.f610b.add(gVar);
            }
            this.f609a.writeLock().unlock();
        } catch (Throwable th) {
            this.f609a.writeLock().unlock();
            throw th;
        }
    }
}
