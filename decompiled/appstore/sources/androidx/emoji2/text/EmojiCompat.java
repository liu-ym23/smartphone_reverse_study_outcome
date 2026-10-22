package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f3010n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f3011o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile EmojiCompat f3012p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReadWriteLock f3013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f3014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f3015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f3016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f3017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MetadataRepoLoader f3018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f3021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f3022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GlyphChecker f3025m;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CodepointSequenceMatchResult {
    }

    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(@NonNull f r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReplaceStrategy {
    }

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.f f3026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile j f3027c;

        /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompat$a$a, reason: collision with other inner class name */
        public class C0027a extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f3028a;

            public C0027a(a r10) {
                this.f3028a = r10;
            }

            @Override // androidx.emoji2.text.EmojiCompat.f
            public void a(Throwable r10) {
                this.f3028a.f3029a.m(r10);
            }

            @Override // androidx.emoji2.text.EmojiCompat.f
            public void b(j r10) {
                this.f3028a.d(r10);
            }
        }

        public a(EmojiCompat r10) {
            super(r10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        public void a() {
            C0027a r10 = new C0027a(this);     // Catch: Throwable -> L4
            this.f3029a.f3018f.load(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.f3029a.m(th);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        public CharSequence b(CharSequence r10, int r11, int r12, int r13, boolean r14) {
            return this.f3026b.h(r10, r11, r12, r13, r14);
        }

        @Override // androidx.emoji2.text.EmojiCompat.b
        public void c(EditorInfo r10) {
            r10.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f3027c.e());
            r10.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f3029a.f3019g);
        }

        public void d(j r10) {
            if (r10 != null) goto L5;
            this.f3029a.m(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.f3027c = r10;
            j r11 = this.f3027c;
            g r12 = new g();
            GlyphChecker r13 = EmojiCompat.a(this.f3029a);
            EmojiCompat r14 = this.f3029a;
            this.f3026b = new androidx.emoji2.text.f(r11, r12, r13, r14.f3020h, r14.f3021i);
            this.f3029a.n();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EmojiCompat f3029a;

        public b(EmojiCompat r10) {
            this.f3029a = r10;
        }

        public abstract void a();

        public abstract CharSequence b(CharSequence r10, int r11, int r12, int r13, boolean r14);

        public abstract void c(EditorInfo r10);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MetadataRepoLoader f3030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f3033d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f3034e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3035f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3036g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3037h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public GlyphChecker f3038i;

        public c(MetadataRepoLoader r10) {
            this.f3036g = -16711936;
            this.f3037h = 0;
            this.f3038i = new androidx.emoji2.text.d();
            androidx.core.util.e.h(r10, "metadataLoader cannot be null.");
            this.f3030a = r10;
        }

        public final MetadataRepoLoader a() {
            return this.f3030a;
        }

        public c b(int r10) {
            this.f3037h = r10;
            return this;
        }
    }

    public static abstract class d {
        public d() {
        }

        public void a(Throwable r10) {
        }

        public void b() {
        }
    }

    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f3040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3041c;

        public e(d r10, int r11) {
            this(Arrays.asList(new d[]{(d) androidx.core.util.e.h(r10, "initCallback cannot be null")}), r11, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.f3039a.size();
            int r11 = 0;
            if (this.f3041c == 1) goto L6;
        L4:
            if (r11 >= r10) goto L8;
            ((d) this.f3039a.get(r11)).a(this.f3040b);
            r11 = r11 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r11 >= r10) goto L11;
            ((d) this.f3039a.get(r11)).b();
            r11 = r11 + 1;
            goto L6
        }

        public e(Collection r10, int r11) {
            this(r10, r11, null);
        }

        public e(Collection r10, int r11, Throwable r12) {
            androidx.core.util.e.h(r10, "initCallbacks cannot be null");
            this.f3039a = new ArrayList(r10);
            this.f3041c = r11;
            this.f3040b = r12;
        }
    }

    public static abstract class f {
        public f() {
        }

        public abstract void a(Throwable r10);

        public abstract void b(j r10);
    }

    public static class g {
        public g() {
        }

        public androidx.emoji2.text.g a(EmojiMetadata r10) {
            return new l(r10);
        }
    }

    static {
        f3010n = new Object();
        f3011o = new Object();
    }

    public EmojiCompat(c r10) {
        this.f3013a = new ReentrantReadWriteLock();
        this.f3015c = 3;
        this.f3019g = r10.f3031b;
        this.f3020h = r10.f3032c;
        this.f3021i = r10.f3033d;
        this.f3022j = r10.f3035f;
        this.f3023k = r10.f3036g;
        this.f3018f = r10.f3030a;
        this.f3024l = r10.f3037h;
        this.f3025m = r10.f3038i;
        this.f3016d = new Handler(Looper.getMainLooper());
        androidx.collection.a r11 = new androidx.collection.a();
        this.f3014b = r11;
        Set r12 = r10.f3034e;
        if (r12 != null) goto L5;
    L7:
        this.f3017e = new a(this);
        l();
        return;
    L5:
        if (r12.isEmpty() == true) goto L7;
        r11.addAll(r10.f3034e);
        goto L7
    }

    public static /* synthetic */ GlyphChecker a(EmojiCompat r10) {
        return r10.f3025m;
    }

    public static EmojiCompat b() {
        Object r10 = f3010n;
        monitor-enter(r10);
        EmojiCompat r11 = f3012p;     // Catch: Throwable -> L11
        if (r11 == null) goto L7;
        boolean r12 = true;
    L8:
        androidx.core.util.e.i(r12, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L7:
        r12 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean e(InputConnection r10, Editable r11, int r12, int r13, boolean r14) {
        return androidx.emoji2.text.f.c(r10, r11, r12, r13, r14);
    }

    public static boolean f(Editable r10, int r11, KeyEvent r12) {
        return androidx.emoji2.text.f.d(r10, r11, r12);
    }

    public static EmojiCompat g(c r10) {
        EmojiCompat r11 = f3012p;
        if (r11 != null) goto L15;
        Object r12 = f3010n;
        monitor-enter(r12);
        r11 = f3012p;     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        r11 = new EmojiCompat(r10);     // Catch: Throwable -> L9
        f3012p = r11;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        return r11;
    }

    public static boolean h() {
        if (f3012p == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int c() {
        return this.f3023k;
    }

    public int d() {
        this.f3013a.readLock().lock();
        int r10 = this.f3015c;     // Catch: Throwable -> L6
        this.f3013a.readLock().unlock();
        return r10;
    L6:
        th = move-exception;
        this.f3013a.readLock().unlock();
        throw th;
    }

    public boolean i() {
        return this.f3022j;
    }

    public final boolean j() {
        if (d() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void k() {
        boolean r10 = true;
        if (this.f3024l == 1) goto L6;
        r10 = false;
    L6:
        androidx.core.util.e.i(r10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j() == false) goto L9;
        return;
    L9:
        this.f3013a.writeLock().lock();
    L17:
        th = move-exception;
        this.f3013a.writeLock().unlock();
        throw th;
    L11:
        if (this.f3015c != 0) goto L14;
        this.f3013a.writeLock().unlock();
        return;
    L14:
        this.f3015c = 0;     // Catch: Throwable -> L17
        this.f3013a.writeLock().unlock();
        this.f3017e.a();
    }

    public final void l() {
        this.f3013a.writeLock().lock();
    L7:
        th = move-exception;
        this.f3013a.writeLock().unlock();
        throw th;
    L4:
        if (this.f3024l != 0) goto L9;
        this.f3015c = 0;     // Catch: Throwable -> L7
    L9:
        this.f3013a.writeLock().unlock();
        if (d() != 0) goto L17;
        this.f3017e.a();
        return;
    }

    public void m(Throwable r10) {
        ArrayList r11 = new ArrayList();
        this.f3013a.writeLock().lock();
        this.f3015c = 2;     // Catch: Throwable -> L6
        r11.addAll(this.f3014b);     // Catch: Throwable -> L6
        this.f3014b.clear();     // Catch: Throwable -> L6
        this.f3013a.writeLock().unlock();
        this.f3016d.post(new e(r11, this.f3015c, r10));
        return;
    L6:
        th = move-exception;
        this.f3013a.writeLock().unlock();
        throw th;
    }

    public void n() {
        ArrayList r10 = new ArrayList();
        this.f3013a.writeLock().lock();
        this.f3015c = 1;     // Catch: Throwable -> L6
        r10.addAll(this.f3014b);     // Catch: Throwable -> L6
        this.f3014b.clear();     // Catch: Throwable -> L6
        this.f3013a.writeLock().unlock();
        this.f3016d.post(new e(r10, this.f3015c));
        return;
    L6:
        th = move-exception;
        this.f3013a.writeLock().unlock();
        throw th;
    }

    public CharSequence o(CharSequence r10) {
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return p(r10, 0, r11);
    L5:
        r11 = r10.length();
        goto L7
    }

    public CharSequence p(CharSequence r10, int r11, int r12) {
        return q(r10, r11, r12, Channel.UNLIMITED);
    }

    public CharSequence q(CharSequence r10, int r11, int r12, int r13) {
        return r(r10, r11, r12, r13, 0);
    }

    public CharSequence r(CharSequence r10, int r11, int r12, int r13, int r14) {
        androidx.core.util.e.i(j(), "Not initialized yet");
        androidx.core.util.e.e(r11, "start cannot be negative");
        androidx.core.util.e.e(r12, "end cannot be negative");
        androidx.core.util.e.e(r13, "maxEmojiCount cannot be negative");
        boolean r15 = false;
        if (r11 > r12) goto L5;
        boolean r16 = true;
    L6:
        androidx.core.util.e.b(r16, "start should be <= than end");
        if (r10 != null) goto L11;
        return null;
    L11:
        if (r11 > r10.length()) goto L13;
        boolean r17 = true;
    L14:
        androidx.core.util.e.b(r17, "start should be < than charSequence length");
        if (r12 > r10.length()) goto L17;
        boolean r18 = true;
    L18:
        androidx.core.util.e.b(r18, "end should be < than charSequence length");
        if (r10.length() == 0) goto L30;
        if (r11 == r12) goto L30;
        if (r14 != 1) goto L24;
        boolean r19 = true;
    L29:
        return this.f3017e.b(r10, r11, r12, r13, r19);
    L24:
        if (r14 == 2) goto L26;
        r15 = this.f3019g;
    L26:
        r19 = r15;
    L30:
        return r10;
    L17:
        r18 = false;
        goto L18
    L13:
        r17 = false;
        goto L14
    L5:
        r16 = false;
        goto L6
    }

    public void s(d r10) {
        androidx.core.util.e.h(r10, "initCallback cannot be null");
        this.f3013a.writeLock().lock();
    L9:
        th = move-exception;
        this.f3013a.writeLock().unlock();
        throw th;
    L4:
        if (this.f3015c != 1) goto L6;
    L11:
        this.f3016d.post(new e(r10, this.f3015c));     // Catch: Throwable -> L9
    L12:
        this.f3013a.writeLock().unlock();
        return;
    L6:
        if (this.f3015c == 2) goto L11;
        this.f3014b.add(r10);     // Catch: Throwable -> L9
        goto L12
    }

    public void t(d r10) {
        androidx.core.util.e.h(r10, "initCallback cannot be null");
        this.f3013a.writeLock().lock();
        this.f3014b.remove(r10);     // Catch: Throwable -> L6
        this.f3013a.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.f3013a.writeLock().unlock();
        throw th;
    }

    public void u(EditorInfo r10) {
        if (j() == false) goto L11;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.extras != null) goto L9;
        r10.extras = new Bundle();
    L9:
        this.f3017e.c(r10);
        return;
    }
}
