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

/* loaded from: classes.dex */
public class c {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f13744o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static final Object f13745p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static volatile c f13746q;

    /* renamed from: b, reason: collision with root package name */
    public final Set<f> f13748b;

    /* renamed from: e, reason: collision with root package name */
    public final b f13751e;

    /* renamed from: f, reason: collision with root package name */
    public final h f13752f;

    /* renamed from: g, reason: collision with root package name */
    public final j f13753g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f13754h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13755i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f13756j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f13757k;

    /* renamed from: l, reason: collision with root package name */
    public final int f13758l;

    /* renamed from: m, reason: collision with root package name */
    public final int f13759m;

    /* renamed from: n, reason: collision with root package name */
    public final e f13760n;

    /* renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f13747a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    public volatile int f13749c = 3;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f13750d = new Handler(Looper.getMainLooper());

    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.d f13761b;

        /* renamed from: c, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f13762c;

        /* renamed from: androidx.emoji2.text.c$a$a, reason: collision with other inner class name */
        public class C0168a extends i {
            public C0168a() {
            }

            @Override // androidx.emoji2.text.c.i
            public void a(Throwable th) {
                a.this.f13764a.n(th);
            }

            @Override // androidx.emoji2.text.c.i
            public void b(androidx.emoji2.text.f fVar) {
                a.this.d(fVar);
            }
        }

        public a(c cVar) {
            super(cVar);
        }

        @Override // androidx.emoji2.text.c.b
        public void a() {
            try {
                this.f13764a.f13752f.a(new C0168a());
            } catch (Throwable th) {
                this.f13764a.n(th);
            }
        }

        @Override // androidx.emoji2.text.c.b
        public CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f13761b.h(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.c.b
        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f13762c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f13764a.f13754h);
        }

        public void d(androidx.emoji2.text.f fVar) {
            if (fVar == null) {
                this.f13764a.n(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f13762c = fVar;
            androidx.emoji2.text.f fVar2 = this.f13762c;
            j jVar = this.f13764a.f13753g;
            e eVar = this.f13764a.f13760n;
            c cVar = this.f13764a;
            this.f13761b = new androidx.emoji2.text.d(fVar2, jVar, eVar, cVar.f13755i, cVar.f13756j, O0.d.a());
            this.f13764a.o();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f13764a;

        public b(c cVar) {
            this.f13764a = cVar;
        }

        public void a() {
            throw null;
        }

        public CharSequence b(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            throw null;
        }

        public void c(EditorInfo editorInfo) {
            throw null;
        }
    }

    /* renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0169c {

        /* renamed from: a, reason: collision with root package name */
        public final h f13765a;

        /* renamed from: b, reason: collision with root package name */
        public j f13766b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f13767c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f13768d;

        /* renamed from: e, reason: collision with root package name */
        public int[] f13769e;

        /* renamed from: f, reason: collision with root package name */
        public Set<f> f13770f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f13771g;

        /* renamed from: h, reason: collision with root package name */
        public int f13772h = -16711936;

        /* renamed from: i, reason: collision with root package name */
        public int f13773i = 0;

        /* renamed from: j, reason: collision with root package name */
        public e f13774j = new androidx.emoji2.text.b();

        public AbstractC0169c(h hVar) {
            B0.h.g(hVar, "metadataLoader cannot be null.");
            this.f13765a = hVar;
        }

        public final h a() {
            return this.f13765a;
        }

        public AbstractC0169c b(int i10) {
            this.f13773i = i10;
            return this;
        }
    }

    public static class d implements j {
        @Override // androidx.emoji2.text.c.j
        public O0.e a(O0.i iVar) {
            return new O0.j(iVar);
        }
    }

    public interface e {
        boolean a(CharSequence charSequence, int i10, int i11, int i12);
    }

    public static abstract class f {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final List<f> f13775a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f13776b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13777c;

        public g(f fVar, int i10) {
            this(Arrays.asList((f) B0.h.g(fVar, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f13775a.size();
            int i10 = 0;
            if (this.f13777c != 1) {
                while (i10 < size) {
                    this.f13775a.get(i10).a(this.f13776b);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    this.f13775a.get(i10).b();
                    i10++;
                }
            }
        }

        public g(Collection<f> collection, int i10) {
            this(collection, i10, null);
        }

        public g(Collection<f> collection, int i10, Throwable th) {
            B0.h.g(collection, "initCallbacks cannot be null");
            this.f13775a = new ArrayList(collection);
            this.f13777c = i10;
            this.f13776b = th;
        }
    }

    public interface h {
        void a(i iVar);
    }

    public static abstract class i {
        public abstract void a(Throwable th);

        public abstract void b(androidx.emoji2.text.f fVar);
    }

    public interface j {
        O0.e a(O0.i iVar);
    }

    public c(AbstractC0169c abstractC0169c) {
        this.f13754h = abstractC0169c.f13767c;
        this.f13755i = abstractC0169c.f13768d;
        this.f13756j = abstractC0169c.f13769e;
        this.f13757k = abstractC0169c.f13771g;
        this.f13758l = abstractC0169c.f13772h;
        this.f13752f = abstractC0169c.f13765a;
        this.f13759m = abstractC0169c.f13773i;
        this.f13760n = abstractC0169c.f13774j;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f13748b = bVar;
        j jVar = abstractC0169c.f13766b;
        this.f13753g = jVar == null ? new d() : jVar;
        Set<f> set = abstractC0169c.f13770f;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(abstractC0169c.f13770f);
        }
        this.f13751e = new a(this);
        m();
    }

    public static c c() {
        c cVar;
        synchronized (f13744o) {
            cVar = f13746q;
            B0.h.i(cVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return cVar;
    }

    public static boolean f(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        return androidx.emoji2.text.d.b(inputConnection, editable, i10, i11, z10);
    }

    public static boolean g(Editable editable, int i10, KeyEvent keyEvent) {
        return androidx.emoji2.text.d.c(editable, i10, keyEvent);
    }

    public static c h(AbstractC0169c abstractC0169c) {
        c cVar;
        c cVar2 = f13746q;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (f13744o) {
            try {
                cVar = f13746q;
                if (cVar == null) {
                    cVar = new c(abstractC0169c);
                    f13746q = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static boolean i() {
        return f13746q != null;
    }

    public int d() {
        return this.f13758l;
    }

    public int e() {
        this.f13747a.readLock().lock();
        try {
            return this.f13749c;
        } finally {
            this.f13747a.readLock().unlock();
        }
    }

    public boolean j() {
        return this.f13757k;
    }

    public final boolean k() {
        return e() == 1;
    }

    public void l() {
        B0.h.i(this.f13759m == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (k()) {
            return;
        }
        this.f13747a.writeLock().lock();
        try {
            if (this.f13749c == 0) {
                return;
            }
            this.f13749c = 0;
            this.f13747a.writeLock().unlock();
            this.f13751e.a();
        } finally {
            this.f13747a.writeLock().unlock();
        }
    }

    public final void m() {
        this.f13747a.writeLock().lock();
        try {
            if (this.f13759m == 0) {
                this.f13749c = 0;
            }
            this.f13747a.writeLock().unlock();
            if (e() == 0) {
                this.f13751e.a();
            }
        } catch (Throwable th) {
            this.f13747a.writeLock().unlock();
            throw th;
        }
    }

    public void n(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f13747a.writeLock().lock();
        try {
            this.f13749c = 2;
            arrayList.addAll(this.f13748b);
            this.f13748b.clear();
            this.f13747a.writeLock().unlock();
            this.f13750d.post(new g(arrayList, this.f13749c, th));
        } catch (Throwable th2) {
            this.f13747a.writeLock().unlock();
            throw th2;
        }
    }

    public void o() {
        ArrayList arrayList = new ArrayList();
        this.f13747a.writeLock().lock();
        try {
            this.f13749c = 1;
            arrayList.addAll(this.f13748b);
            this.f13748b.clear();
            this.f13747a.writeLock().unlock();
            this.f13750d.post(new g(arrayList, this.f13749c));
        } catch (Throwable th) {
            this.f13747a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence p(CharSequence charSequence) {
        return q(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11) {
        return r(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12) {
        return s(charSequence, i10, i11, i12, 0);
    }

    public CharSequence s(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        B0.h.i(k(), "Not initialized yet");
        B0.h.e(i10, "start cannot be negative");
        B0.h.e(i11, "end cannot be negative");
        B0.h.e(i12, "maxEmojiCount cannot be negative");
        B0.h.b(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        B0.h.b(i10 <= charSequence.length(), "start should be < than charSequence length");
        B0.h.b(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        if (i13 != 1) {
            z10 = i13 != 2 ? this.f13754h : false;
        } else {
            z10 = true;
        }
        return this.f13751e.b(charSequence, i10, i11, i12, z10);
    }

    public void t(f fVar) {
        B0.h.g(fVar, "initCallback cannot be null");
        this.f13747a.writeLock().lock();
        try {
            if (this.f13749c == 1 || this.f13749c == 2) {
                this.f13750d.post(new g(fVar, this.f13749c));
            } else {
                this.f13748b.add(fVar);
            }
            this.f13747a.writeLock().unlock();
        } catch (Throwable th) {
            this.f13747a.writeLock().unlock();
            throw th;
        }
    }

    public void u(f fVar) {
        B0.h.g(fVar, "initCallback cannot be null");
        this.f13747a.writeLock().lock();
        try {
            this.f13748b.remove(fVar);
        } finally {
            this.f13747a.writeLock().unlock();
        }
    }

    public void v(EditorInfo editorInfo) {
        if (!k() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f13751e.c(editorInfo);
    }
}
