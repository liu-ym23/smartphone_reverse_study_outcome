package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: EmojiCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f1617e = null;
    private static final Object f = null;
    private static volatile d g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f1618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f1619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f1620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f1621d;
    private final ReadWriteLock h;
    private final Set<e> i;
    private volatile int j;
    private final Handler k;
    private final a l;
    private final boolean m;
    private final int n;
    private final int o;
    private final InterfaceC0051d p;

    /* JADX INFO: compiled from: EmojiCompat.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f1622a;

        CharSequence a(CharSequence r1, int r2, int r3, int r4, boolean r5) {
            return (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        }

        void a(EditorInfo r1) {
        }

        a(d r1) {
            this.f1622a = r1;
        }

        void a() {
            this.f1622a.d();
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    private static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.f f1623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile androidx.emoji2.text.i f1624c;

        b(d r1) {
            super(r1);
        }

        @Override // androidx.emoji2.text.d.a
        void a() {
            h r0 = new AnonymousClass1(this);     // Catch: Throwable -> L4
            this.f1622a.f1618a.a(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.f1622a.a(th);
        }

        void a(androidx.emoji2.text.i r8) {
            if (r8 != null) goto L5;
            this.f1622a.a(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.f1624c = r8;
            this.f1623b = new androidx.emoji2.text.f(this.f1624c, new i(), d.a(this.f1622a), this.f1622a.f1620c, this.f1622a.f1621d);
            this.f1622a.d();
        }

        @Override // androidx.emoji2.text.d.a
        CharSequence a(CharSequence r7, int r8, int r9, int r10, boolean r11) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
            return this.f1623b.a(r1, r8, r9, r10, r11);
        }

        @Override // androidx.emoji2.text.d.a
        void a(EditorInfo r4) {
            r4.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f1624c.b());
            r4.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f1622a.f1619b);
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g f1626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f1629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Set<e> f1630e;
        boolean f;
        int g;
        int h;
        InterfaceC0051d i;

        public c(g r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
            this.g = -16711936;
            this.h = 0;
            this.i = new androidx.emoji2.text.c();
            androidx.core.util.g.a(r4, "metadataLoader cannot be null.");
            this.f1626a = r4;
        }

        public c a(int r1) {
            this.h = r1;
            return this;
        }

        public final g a() {
            return this.f1626a;
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EmojiCompat.java */
    public interface InterfaceC0051d {
        boolean a(CharSequence r1, int r2, int r3, int r4);
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static abstract class e {
        public void a() {
        }

        public void a(Throwable r1) {
        }

        public e() {
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    private static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<e> f1631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f1632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1633c;

        f(e r4, int r5) {
            this(Arrays.asList(new e[]{(e) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r4, "initCallback cannot be null"), e.class, "com.obric.aiagent.plugin")}), r5, null);
        }

        f(Collection<e> r3, int r4) {
            this((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), r4, null);
        }

        f(Collection<e> r3, int r4, Throwable r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            androidx.core.util.g.a(r6, "initCallbacks cannot be null");
            this.f1631a = new ArrayList(r6);
            this.f1633c = r4;
            this.f1632b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = this.f1631a.size();
            int r3 = 0;
            if (this.f1633c == 1) goto L6;
        L4:
            if (r3 >= r0) goto L8;
            ((e) ZeusTransformUtils.preCheckCast(this.f1631a.get(r3), e.class, "com.obric.aiagent.plugin")).a(this.f1632b);
            r3 = r3 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r3 >= r0) goto L11;
            ((e) ZeusTransformUtils.preCheckCast(this.f1631a.get(r3), e.class, "com.obric.aiagent.plugin")).a();
            r3 = r3 + 1;
            goto L6
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public interface g {
        void a(h r1);
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static abstract class h {
        public abstract void a(androidx.emoji2.text.i r1);

        public abstract void a(Throwable r1);

        public h() {
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    static class i {
        i() {
        }

        EmojiSpan a(androidx.emoji2.text.e r1) {
            return new TypefaceEmojiSpan(r1);
        }
    }

    static /* synthetic */ InterfaceC0051d a(d r0) {
        return r0.p;
    }

    static {
        f1617e = new Object();
        f = new Object();
    }

    private d(c r3) {
        this.h = new ReentrantReadWriteLock();
        this.j = 3;
        this.f1619b = r3.f1627b;
        this.f1620c = r3.f1628c;
        this.f1621d = r3.f1629d;
        this.m = r3.f;
        this.n = r3.g;
        this.f1618a = r3.f1626a;
        this.o = r3.h;
        this.p = r3.i;
        this.k = new Handler(Looper.getMainLooper());
        androidx.b.b r0 = new androidx.b.b();
        this.i = r0;
        if (r3.f1630e == null) goto L8;
        if (r3.f1630e.isEmpty() == true) goto L8;
        r0.addAll(r3.f1630e);
    L8:
        if (Build.VERSION.SDK_INT >= 19) goto L10;
        a r4 = new a(this);
    L11:
        this.l = r4;
        h();
        return;
    L10:
        r4 = new b(this);
        goto L11
    }

    public static d a(c r2) {
        d r0 = g;
        if (r0 != null) goto L14;
        Object r1 = f1617e;
        monitor-enter(r1);
        r0 = g;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new d(r2);     // Catch: Throwable -> L11
        g = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    public static boolean a() {
        if (g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static d b() {
        Object r0 = f1617e;
        monitor-enter(r0);
        d r1 = g;     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        boolean r2 = true;
    L8:
        androidx.core.util.g.a(r2, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        r2 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public void c() {
        boolean r2 = true;
        if (this.o == 1) goto L6;
        r2 = false;
    L6:
        androidx.core.util.g.a(r2, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (i() == false) goto L9;
        return;
    L9:
        this.h.writeLock().lock();
    L17:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    L11:
        if (this.j != 0) goto L14;
        this.h.writeLock().unlock();
        return;
    L14:
        this.j = 0;     // Catch: Throwable -> L17
        this.h.writeLock().unlock();
        this.l.a();
    }

    private void h() {
        this.h.writeLock().lock();
    L10:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    L4:
        if (this.o != 0) goto L6;
        this.j = 0;     // Catch: Throwable -> L10
    L6:
        this.h.writeLock().unlock();
        if (e() != 0) goto L15;
        this.l.a();
        return;
    }

    void d() {
        ArrayList r0 = new ArrayList();
        this.h.writeLock().lock();
        this.j = 1;     // Catch: Throwable -> L6
        r0.addAll(this.i);     // Catch: Throwable -> L6
        this.i.clear();     // Catch: Throwable -> L6
        this.h.writeLock().unlock();
        this.k.post(new f(r0, this.j));
        return;
    L6:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    }

    void a(Throwable r4) {
        ArrayList r0 = new ArrayList();
        this.h.writeLock().lock();
        this.j = 2;     // Catch: Throwable -> L6
        r0.addAll(this.i);     // Catch: Throwable -> L6
        this.i.clear();     // Catch: Throwable -> L6
        this.h.writeLock().unlock();
        this.k.post(new f(r0, this.j, r4));
        return;
    L6:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    }

    public void a(e r4) {
        androidx.core.util.g.a(r4, "initCallback cannot be null");
        this.h.writeLock().lock();
    L12:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    L4:
        if (this.j != 1) goto L6;
    L9:
        this.k.post(new f(r4, this.j));     // Catch: Throwable -> L12
    L10:
        this.h.writeLock().unlock();
        return;
    L6:
        if (this.j == 2) goto L9;
        this.i.add(r4);     // Catch: Throwable -> L12
        goto L10
    }

    public void b(e r2) {
        androidx.core.util.g.a(r2, "initCallback cannot be null");
        this.h.writeLock().lock();
        this.i.remove(r2);     // Catch: Throwable -> L6
        this.h.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.h.writeLock().unlock();
        throw th;
    }

    public int e() {
        this.h.readLock().lock();
        int r0 = this.j;     // Catch: Throwable -> L6
        this.h.readLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.h.readLock().unlock();
        throw th;
    }

    private boolean i() {
        if (e() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean f() {
        return this.m;
    }

    public int g() {
        return this.n;
    }

    public static boolean a(Editable r2, int r3, KeyEvent r4) {
        Editable r5 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return androidx.emoji2.text.f.a(r5, r3, r4);
    }

    public static boolean a(InputConnection r2, Editable r3, int r4, int r5, boolean r6) {
        InputConnection r7 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r2, InputConnection.class, "com.obric.aiagent.plugin");
        Editable r8 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return androidx.emoji2.text.f.a(r7, r8, r4, r5, r6);
    }

    public CharSequence a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        int r1 = 0;
    L7:
        return a(r4, 0, r1);
    L5:
        r1 = r4.length();
        goto L7
    }

    public CharSequence a(CharSequence r3, int r4, int r5) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5, Integer.MAX_VALUE);
    }

    public CharSequence a(CharSequence r7, int r8, int r9, int r10) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin"), r8, r9, r10, 0);
    }

    public CharSequence a(CharSequence r7, int r8, int r9, int r10, int r11) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        androidx.core.util.g.a(i(), "Not initialized yet");
        androidx.core.util.g.a(r8, "start cannot be negative");
        androidx.core.util.g.a(r9, "end cannot be negative");
        androidx.core.util.g.a(r10, "maxEmojiCount cannot be negative");
        boolean r12 = false;
        if (r8 > r9) goto L5;
        boolean r2 = true;
    L6:
        androidx.core.util.g.a(r2, "start should be <= than end");
        if (r1 != null) goto L11;
        return null;
    L11:
        if (r8 > r1.length()) goto L13;
        boolean r3 = true;
    L14:
        androidx.core.util.g.a(r3, "start should be < than charSequence length");
        if (r9 > r1.length()) goto L17;
        boolean r4 = true;
    L18:
        androidx.core.util.g.a(r4, "end should be < than charSequence length");
        if (r1.length() == 0) goto L30;
        if (r8 == r9) goto L30;
        if (r11 != 1) goto L24;
        boolean r5 = true;
    L29:
        return this.l.a(r1, r8, r9, r10, r5);
    L24:
        if (r11 == 2) goto L26;
        r12 = this.f1619b;
    L26:
        r5 = r12;
    L30:
        return r1;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    public void a(EditorInfo r2) {
        if (i() == false) goto L11;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.extras != null) goto L9;
        r2.extras = new Bundle();
    L9:
        this.l.a(r2);
        return;
    }
}
