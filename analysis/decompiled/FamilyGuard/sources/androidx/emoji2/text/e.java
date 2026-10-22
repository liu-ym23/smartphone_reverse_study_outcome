package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import q.C0934b;

/* loaded from: classes.dex */
public class e {

    /* renamed from: o, reason: collision with root package name */
    private static final Object f10294o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private static final Object f10295p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static volatile e f10296q;

    /* renamed from: b, reason: collision with root package name */
    private final Set<f> f10298b;

    /* renamed from: e, reason: collision with root package name */
    private final b f10301e;

    /* renamed from: f, reason: collision with root package name */
    final h f10302f;

    /* renamed from: g, reason: collision with root package name */
    private final j f10303g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f10304h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f10305i;

    /* renamed from: j, reason: collision with root package name */
    final int[] f10306j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f10307k;

    /* renamed from: l, reason: collision with root package name */
    private final int f10308l;

    /* renamed from: m, reason: collision with root package name */
    private final int f10309m;

    /* renamed from: n, reason: collision with root package name */
    private final InterfaceC0131e f10310n;

    /* renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f10297a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private volatile int f10299c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f10300d = new Handler(Looper.getMainLooper());

    private static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.h f10311b;

        /* renamed from: c, reason: collision with root package name */
        private volatile m f10312c;

        /* renamed from: androidx.emoji2.text.e$a$a, reason: collision with other inner class name */
        class C0130a extends i {
            C0130a() {
            }

            @Override // androidx.emoji2.text.e.i
            public void a(Throwable th) {
                a.this.f10314a.n(th);
            }

            @Override // androidx.emoji2.text.e.i
            public void b(m mVar) {
                a.this.d(mVar);
            }
        }

        a(e eVar) {
            super(eVar);
        }

        @Override // androidx.emoji2.text.e.b
        void a() {
            try {
                this.f10314a.f10302f.a(new C0130a());
            } catch (Throwable th) {
                this.f10314a.n(th);
            }
        }

        @Override // androidx.emoji2.text.e.b
        CharSequence b(CharSequence charSequence, int i5, int i6, int i7, boolean z5) {
            return this.f10311b.h(charSequence, i5, i6, i7, z5);
        }

        @Override // androidx.emoji2.text.e.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f10312c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f10314a.f10304h);
        }

        void d(m mVar) {
            if (mVar == null) {
                this.f10314a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f10312c = mVar;
            m mVar2 = this.f10312c;
            j jVar = this.f10314a.f10303g;
            InterfaceC0131e interfaceC0131e = this.f10314a.f10310n;
            e eVar = this.f10314a;
            this.f10311b = new androidx.emoji2.text.h(mVar2, jVar, interfaceC0131e, eVar.f10305i, eVar.f10306j, androidx.emoji2.text.g.a());
            this.f10314a.o();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final e f10314a;

        b(e eVar) {
            this.f10314a = eVar;
        }

        void a() {
            throw null;
        }

        CharSequence b(CharSequence charSequence, int i5, int i6, int i7, boolean z5) {
            throw null;
        }

        void c(EditorInfo editorInfo) {
            throw null;
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final h f10315a;

        /* renamed from: b, reason: collision with root package name */
        j f10316b;

        /* renamed from: c, reason: collision with root package name */
        boolean f10317c;

        /* renamed from: d, reason: collision with root package name */
        boolean f10318d;

        /* renamed from: e, reason: collision with root package name */
        int[] f10319e;

        /* renamed from: f, reason: collision with root package name */
        Set<f> f10320f;

        /* renamed from: g, reason: collision with root package name */
        boolean f10321g;

        /* renamed from: h, reason: collision with root package name */
        int f10322h = -16711936;

        /* renamed from: i, reason: collision with root package name */
        int f10323i = 0;

        /* renamed from: j, reason: collision with root package name */
        InterfaceC0131e f10324j = new androidx.emoji2.text.d();

        protected c(h hVar) {
            D.h.f(hVar, "metadataLoader cannot be null.");
            this.f10315a = hVar;
        }

        protected final h a() {
            return this.f10315a;
        }

        public c b(int i5) {
            this.f10323i = i5;
            return this;
        }
    }

    public static class d implements j {
        @Override // androidx.emoji2.text.e.j
        public androidx.emoji2.text.i a(o oVar) {
            return new p(oVar);
        }
    }

    /* renamed from: androidx.emoji2.text.e$e, reason: collision with other inner class name */
    public interface InterfaceC0131e {
        boolean a(CharSequence charSequence, int i5, int i6, int i7);
    }

    public static abstract class f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    private static class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<f> f10325a;

        /* renamed from: b, reason: collision with root package name */
        private final Throwable f10326b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10327c;

        g(f fVar, int i5) {
            this(Arrays.asList((f) D.h.f(fVar, "initCallback cannot be null")), i5, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f10325a.size();
            int i5 = 0;
            if (this.f10327c != 1) {
                while (i5 < size) {
                    this.f10325a.get(i5).a(this.f10326b);
                    i5++;
                }
            } else {
                while (i5 < size) {
                    this.f10325a.get(i5).b();
                    i5++;
                }
            }
        }

        g(Collection<f> collection, int i5) {
            this(collection, i5, null);
        }

        g(Collection<f> collection, int i5, Throwable th) {
            D.h.f(collection, "initCallbacks cannot be null");
            this.f10325a = new ArrayList(collection);
            this.f10327c = i5;
            this.f10326b = th;
        }
    }

    public interface h {
        void a(i iVar);
    }

    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(m mVar);
    }

    public interface j {
        androidx.emoji2.text.i a(o oVar);
    }

    private e(c cVar) {
        this.f10304h = cVar.f10317c;
        this.f10305i = cVar.f10318d;
        this.f10306j = cVar.f10319e;
        this.f10307k = cVar.f10321g;
        this.f10308l = cVar.f10322h;
        this.f10302f = cVar.f10315a;
        this.f10309m = cVar.f10323i;
        this.f10310n = cVar.f10324j;
        C0934b c0934b = new C0934b();
        this.f10298b = c0934b;
        j jVar = cVar.f10316b;
        this.f10303g = jVar == null ? new d() : jVar;
        Set<f> set = cVar.f10320f;
        if (set != null && !set.isEmpty()) {
            c0934b.addAll(cVar.f10320f);
        }
        this.f10301e = new a(this);
        m();
    }

    public static e c() {
        e eVar;
        synchronized (f10294o) {
            eVar = f10296q;
            D.h.g(eVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i5, int i6, boolean z5) {
        return androidx.emoji2.text.h.b(inputConnection, editable, i5, i6, z5);
    }

    public static boolean g(Editable editable, int i5, KeyEvent keyEvent) {
        return androidx.emoji2.text.h.c(editable, i5, keyEvent);
    }

    public static e h(c cVar) {
        e eVar;
        e eVar2 = f10296q;
        if (eVar2 != null) {
            return eVar2;
        }
        synchronized (f10294o) {
            try {
                eVar = f10296q;
                if (eVar == null) {
                    eVar = new e(cVar);
                    f10296q = eVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public static boolean i() {
        return f10296q != null;
    }

    private boolean k() {
        return e() == 1;
    }

    private void m() {
        this.f10297a.writeLock().lock();
        try {
            if (this.f10309m == 0) {
                this.f10299c = 0;
            }
            this.f10297a.writeLock().unlock();
            if (e() == 0) {
                this.f10301e.a();
            }
        } catch (Throwable th) {
            this.f10297a.writeLock().unlock();
            throw th;
        }
    }

    public int d() {
        return this.f10308l;
    }

    public int e() {
        this.f10297a.readLock().lock();
        try {
            return this.f10299c;
        } finally {
            this.f10297a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f10307k;
    }

    public void l() {
        D.h.g(this.f10309m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f10297a.writeLock().lock();
        try {
            if (this.f10299c == 0) {
                return;
            }
            this.f10299c = 0;
            this.f10297a.writeLock().unlock();
            this.f10301e.a();
        } finally {
            this.f10297a.writeLock().unlock();
        }
    }

    void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f10297a.writeLock().lock();
        try {
            this.f10299c = 2;
            arrayList.addAll(this.f10298b);
            this.f10298b.clear();
            this.f10297a.writeLock().unlock();
            this.f10300d.post(new g(arrayList, this.f10299c, th));
        } catch (Throwable th2) {
            this.f10297a.writeLock().unlock();
            throw th2;
        }
    }

    void o() {
        ArrayList arrayList = new ArrayList();
        this.f10297a.writeLock().lock();
        try {
            this.f10299c = 1;
            arrayList.addAll(this.f10298b);
            this.f10298b.clear();
            this.f10297a.writeLock().unlock();
            this.f10300d.post(new g(arrayList, this.f10299c));
        } catch (Throwable th) {
            this.f10297a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i5, int i6) {
        return r(charSequence, i5, i6, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i5, int i6, int i7) {
        return s(charSequence, i5, i6, i7, 0);
    }

    public CharSequence s(CharSequence charSequence, int i5, int i6, int i7, int i8) {
        boolean z5;
        D.h.g(k(), "Not initialized yet");
        D.h.d(i5, "start cannot be negative");
        D.h.d(i6, "end cannot be negative");
        D.h.d(i7, "maxEmojiCount cannot be negative");
        D.h.b(i5 <= i6, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        D.h.b(i5 <= charSequence.length(), "start should be < than charSequence length");
        D.h.b(i6 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i5 == i6) {
            return charSequence;
        }
        if (i8 != 1) {
            z5 = i8 != 2 ? this.f10304h : false;
        } else {
            z5 = true;
        }
        return this.f10301e.b(charSequence, i5, i6, i7, z5);
    }

    public void t(f fVar) {
        D.h.f(fVar, "initCallback cannot be null");
        this.f10297a.writeLock().lock();
        try {
            if (this.f10299c == 1 || this.f10299c == 2) {
                this.f10300d.post(new g(fVar, this.f10299c));
            } else {
                this.f10298b.add(fVar);
            }
            this.f10297a.writeLock().unlock();
        } catch (Throwable th) {
            this.f10297a.writeLock().unlock();
            throw th;
        }
    }

    public void u(f fVar) {
        D.h.f(fVar, "initCallback cannot be null");
        this.f10297a.writeLock().lock();
        try {
            this.f10298b.remove(fVar);
        } finally {
            this.f10297a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f10301e.c(editorInfo);
    }
}
