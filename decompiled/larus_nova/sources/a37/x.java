package a37;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class x implements e37.h {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f1643z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile float f1644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f1645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f1646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f1647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f1648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f1649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f1650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f1651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f1652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextToSpeech f1653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AudioManager f1654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l f1655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f1656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f1657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f1658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.navigation.kmp.listener.q> f1659p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f1660q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f1661r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f1662s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AudioFocusRequest f1663t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1664u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1665v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f1666w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConcurrentLinkedQueue<com.bytedance.navigation.kmp.listener.r> f1667x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f1668y;

    public static final class a {
        public a() {
        }

        public static final String a(Locale r100) {
            int r101 = x.f1643z;
            if (r100 != null) goto L5;
            return "null";
        L5:
            String r102 = r100.getVariant();
            String r103 = r100.getLanguage();
            String r104 = r100.getCountry();
            if (TextUtils.isEmpty(r102) == false) goto L8;
            String r105 = "";
        L10:
            return r103 + "-" + r104 + r105;
        L8:
            r105 = "-" + r102;
            goto L10
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.navigation.kmp.listener.q f1671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f1672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f1673e;

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "id");
            this.f1669a = r100;
            this.f1670b = 1;
            this.f1671c = null;
            this.f1672d = r101;
            this.f1673e = false;
        }
    }

    public static final class c extends UtteranceProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f1674a;

        public c(x r100) {
            this.f1674a = r100;
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onDone(final String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            final x r101 = this.f1674a;
            r101.i(new e0(r100, r101));
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onError(final String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            final x r101 = this.f1674a;
            r101.i(new c0(r100, r101));
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onStart(final String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            final x r101 = this.f1674a;
            r101.i(new d0(r100, r101));
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onAudioAvailable(final String r100, final byte[] r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            final x r102 = this.f1674a;
            r102.i(new b0(r100, r101, r102));
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onBeginSynthesis(final String r100, final int r110, final int r111, final int r112) {
            Intrinsics.checkNotNullParameter(r100, "id");
            final x r101 = this.f1674a;
            r101.i(new f0(r100, r110, r112, r111, r101));
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onRangeStart(final String r100, final int r110, final int r111, final int r112) {
            Intrinsics.checkNotNullParameter(r100, "id");
            final x r101 = this.f1674a;
            r101.i(new y(r100, r110, r111, r112, r101));
        }
    }

    static {
        new a();
    }

    public final void h() {
        int r100 = 0;
    L3:
        com.bytedance.navigation.kmp.listener.r r101 = this.f1667x.poll();
        com.bytedance.navigation.kmp.listener.r r102 = r101;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L7
        r102.a(this.f1651h);     // Catch: Throwable -> L7
    L9:
        r100 = r100 + 1;
    L7:
        th = move-exception;
        d37.i r103 = d37.i.f466749a;
        d37.i.e("InitListener callback error", th);
        goto L9
    L10:
        d37.i r104 = d37.i.f466749a;
        d37.i.g("notifyInitListeners: callbackCount=" + r100 + " initialized=" + this.f1651h);
    }

    @Override // e37.h
    public final void b() {
        d37.i r100 = d37.i.f466749a;
        d37.i.g("stopAndClear()");
        i(new v(this));
    }

    public final void e() {
        boolean r100 = this.f1664u;
        if (r100 == false) goto L19;
        AudioManager r101 = this.f1654k;
        if (r101 == null) goto L19;
    L15:
        th = move-exception;
        d37.i r102 = d37.i.f466749a;
        d37.i.e("abandonAudioFocusIfHeld: fail", th);
    L17:
        this.f1664u = false;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        AudioFocusRequest r103 = this.f1663t;     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L15
        r101.abandonAudioFocusRequest(r103);     // Catch: Throwable -> L15
        this.f1663t = null;     // Catch: Throwable -> L15
    L13:
        d37.i r104 = d37.i.f466749a;     // Catch: Throwable -> L15
        d37.i.g("abandonAudioFocusIfHeld: done");     // Catch: Throwable -> L15
    L12:
        r101.abandonAudioFocus(this.f1655l);     // Catch: Throwable -> L15
    L19:
        d37.i r105 = d37.i.f466749a;
        d37.i.g("abandonAudioFocusIfHeld: skip (held=" + r100 + ")");
    }

    public final void j() {
        Locale r100 = Locale.SIMPLIFIED_CHINESE;     // Catch: Throwable -> L21
        Voice r101 = this.f1653j.getVoice();     // Catch: Throwable -> L21
        if (r101 != null) goto L6;
    L8:
        int r102 = this.f1653j.isLanguageAvailable(r100);     // Catch: Throwable -> L21
        if (r102 == (-1)) goto L12;
        if (r102 == (-2)) goto L12;
    L14:
        if (r102 == (-2)) goto L18;
        if (r102 == (-1)) goto L17;
        String r103 = null;
    L19:
        this.f1652i = r103;     // Catch: Throwable -> L21
        d37.i r104 = d37.i.f466749a;     // Catch: Throwable -> L21
        d37.i.g("revalidateLanguageAvailability: check=" + a.a(r100) + " avail=" + r102 + " reason=" + this.f1652i);     // Catch: Throwable -> L21
        return;
    L17:
        r103 = "lang_missing";
        goto L19
    L18:
        r103 = "lang_unsupported";
    L12:
        if (StringsKt.equals("chn", r100.getLanguage(), true) == false) goto L14;
        r102 = this.f1653j.isLanguageAvailable(Locale.SIMPLIFIED_CHINESE);     // Catch: Throwable -> L21
        goto L14
    L6:
        if (r101.getLocale() == null) goto L8;
        r100 = r101.getLocale();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        d37.i r105 = d37.i.f466749a;
        d37.i.e("revalidateLanguageAvailability: fail", th);
        this.f1652i = null;
    }

    public final void m() {
    L3:
        if (this.f1662s == true) goto L4;
        final b r100 = this.f1661r.poll();
        if (r100 == null) goto L8;
        final String r101 = this.f1652i;
        if (r101 != null) goto L12;
        if (this.f1647d == false) goto L45;
        boolean r102 = this.f1664u;
        if (r102 == true) goto L33;
        AudioManager r103 = this.f1654k;
        if (r103 == null) goto L33;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 26) goto L28;
        AudioAttributes.Builder r105 = new AudioAttributes.Builder().setContentType(1).setUsage(1);
        if (r104 < 29) goto L27;
        r105.setAllowedCapturePolicy(1);
    L27:
        AudioFocusRequest r106 = new AudioFocusRequest.Builder(this.f1648e).setAudioAttributes(r105.build()).setOnAudioFocusChangeListener(this.f1655l).setWillPauseWhenDucked(false).build();
        this.f1663t = r106;
        AudioManager r107 = this.f1654k;
        Intrinsics.checkNotNull(r106);
        int r108 = r107.requestAudioFocus(r106);
    L29:
        if (r108 != 1) goto L31;
        boolean r109 = true;
    L32:
        this.f1664u = r109;
        d37.i r110 = d37.i.f466749a;
        d37.i.g("requestAudioFocus: result=" + r108 + " held=" + r109);
        boolean r111 = this.f1664u;
    L38:
        d37.i r112 = d37.i.f466749a;
        d37.i.g("startNext: audioFocus requested -> " + r111);
        if (r111 == true) goto L45;
        if (this.f1649f == false) goto L45;
        d37.i.g("startNext: suppressed by no_focus id=" + r100.f1672d);
        final com.bytedance.navigation.kmp.listener.q r113 = this.f1659p.remove(r100.f1672d);
        if (r113 == null) goto L3;
        f(new k(r113, r100));
        goto L3
    L31:
        r109 = false;
        goto L32
    L28:
        r108 = r103.requestAudioFocus(this.f1655l, this.f1646c, this.f1648e);
    L33:
        d37.i r114 = d37.i.f466749a;
        if (this.f1654k == null) goto L36;
        boolean r115 = true;
    L37:
        d37.i.g("requestAudioFocusIfNeeded: skip (held=" + r102 + " audioManager=" + r115 + ")");
        r111 = true;
        goto L38
    L36:
        r115 = false;
    L45:
        boolean r116 = this.f1665v;
        float r117 = this.f1645b;
        if (r116 == false) goto L48;
        float r118 = this.f1666w;
    L49:
        float r119 = r117 * r118;
        Bundle r120 = new Bundle();
        r120.putInt("streamType", this.f1646c);
        r120.putFloat(ITTVideoEngineEventSource.KEY_VOLUME, r119);
        this.f1662s = true;
        d37.i r121 = d37.i.f466749a;     // Catch: Throwable -> L61
        d37.i.g("speak: id=" + r100.f1672d + " qMode=" + r100.f1670b + " vol=" + r119);     // Catch: Throwable -> L61
        int r122 = this.f1653j.speak(r100.f1669a, r100.f1670b, r120, r100.f1672d);     // Catch: Throwable -> L61
        if (r122 == 0) goto L60;
        d37.i.c("speak: failed immediately id=" + r100.f1672d + " result=" + r122);     // Catch: Throwable -> L61
        final com.bytedance.navigation.kmp.listener.q r123 = this.f1659p.remove(r100.f1672d);     // Catch: Throwable -> L61
        if (r123 == null) goto L56;
        f(new m(r123, r100));     // Catch: Throwable -> L61
    L56:
        if (this.f1647d == false) goto L58;
        e();     // Catch: Throwable -> L61
    L58:
        this.f1662s = false;     // Catch: Throwable -> L61
        goto L3
    L60:
        return;
    L61:
        th = move-exception;
        d37.i r124 = d37.i.f466749a;
        d37.i.e("speak: failed id=" + r100.f1672d, th);
        final com.bytedance.navigation.kmp.listener.q r125 = this.f1659p.remove(r100.f1672d);
        if (r125 == null) goto L66;
        f(new n(r125, r100));
    L66:
        if (this.f1647d == false) goto L68;
        e();
    L68:
        this.f1662s = false;
        goto L3
    L48:
        r118 = 1.0f;
        goto L49
    L12:
        d37.i r126 = d37.i.f466749a;
        d37.i.g("startNext: suppressed by language reason=" + r101 + " id=" + r100.f1672d);
        final com.bytedance.navigation.kmp.listener.q r127 = this.f1659p.remove(r100.f1672d);
        if (r127 == null) goto L3;
        f(new j(r127, r100, r101));
        goto L3
    L8:
        d37.i r128 = d37.i.f466749a;
        d37.i.g("startNext: queue empty");
        return;
    L4:
        d37.i r129 = d37.i.f466749a;
        d37.i.g("startNext: speaking=true, return");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [a37.l] */
    public x() {
        this.f1644a = 1.0f;
        this.f1645b = 1.0f;
        this.f1646c = 3;
        this.f1647d = true;
        this.f1648e = 3;
        this.f1649f = true;
        this.f1650g = true;
        this.f1658o = new Handler(Looper.getMainLooper());
        this.f1659p = new ConcurrentHashMap();
        this.f1660q = new ConcurrentLinkedQueue();
        this.f1661r = new ConcurrentLinkedQueue();
        this.f1666w = 0.6f;
        this.f1667x = new ConcurrentLinkedQueue();
        Context r100 = defpackage.m.f511444a.getContext();
        this.f1654k = (AudioManager) r100.getSystemService("audio");
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("TTSPlayerOptWorker");
        this.f1656m = r101;
        ThreadMethodProxy.start(r101);
        this.f1657n = new Handler(r101.getLooper());
        final AtomicReference r102 = new AtomicReference();
        this.f1655l = new l(this);
        TextToSpeech r103 = new TextToSpeech(r100, new p(this, r102));
        d37.i r104 = d37.i.f466749a;
        d37.i.g("TextToSpeech: created with default engine");
        r102.set(r103);
        this.f1653j = r103;
    }

    @Override // e37.h
    public final void a(final boolean r100) {
        d37.i r101 = d37.i.f466749a;
        d37.i.g("shutdown()");
        i(new q(r100, this));
    }

    @Override // e37.h
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        d37.i r101 = d37.i.f466749a;
        d37.i.g("enqueueSpeak: len=" + r100.length());
        if (this.f1651h == true) goto L6;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L12;
        return "";
    L12:
        final String r103 = UUID.randomUUID().toString();
        final b r104 = new b(r100, r103);
        i(new i(this, r103, r104));
        return r103;
    L6:
        if (this.f1652i != null) goto L7;
        r102 = true;
        goto L9
    }

    @Override // e37.h
    public final void d(final com.bytedance.navigation.kmp.listener.r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f1651h == false) goto L10;
        d37.i.f466749a.h("TTSPlayerOpt", "addOnInitListener: initialized=" + this.f1651h);
        r100.a(true);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        d37.i r101 = d37.i.f466749a;
        d37.i.e("InitListener immediate callback error", th);
        return;
    L10:
        i(new a37.a(this, r100));
    }

    public final void f(final Runnable r100) {
        if (this.f1650g == true) goto L5;
    L21:
        r100.run();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        d37.i r101 = d37.i.f466749a;
        d37.i.e("callback deliver run error", th);
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L21;
        this.f1658o.post(new w(r100));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        d37.i r102 = d37.i.f466749a;
        d37.i.e("callback deliver post error", th);
        r100.run();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        d37.i r103 = d37.i.f466749a;
        d37.i.e("callback deliver fallback run error", th);
    }

    public final void g(b r100) {
        if (r100.f1673e == false) goto L7;
        d37.i r101 = d37.i.f466749a;
        d37.i.g("enqueueToDispatch: immediate -> clear & stop current");
        this.f1661r.clear();
        this.f1653j.stop();     // Catch: Throwable -> L9
    L6:
        this.f1662s = false;
    L7:
        this.f1661r.offer(r100);
        d37.i r102 = d37.i.f466749a;
        d37.i.g("enqueueToDispatch: id=" + r100.f1672d + " size=" + this.f1661r.size());
    }

    public final void i(Runnable r100) {
    L7:
        th = move-exception;
        d37.i r101 = d37.i.f466749a;
        d37.i.e("TTSPlayerOpt.postToWorker error, discard runnable: " + r100, th);
        return;
    L3:
        if (ThreadMethodProxy.isAlive(this.f1656m) == false) goto L5;
        this.f1657n.post(r100);     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        d37.i r102 = d37.i.f466749a;     // Catch: Throwable -> L7
        d37.i.c("TTSPlayerOpt.postToWorker but worker thread already quited.");     // Catch: Throwable -> L7
        goto L10
    }

    public final void l(float r100) {
        this.f1653j.setSpeechRate(r100);     // Catch: Throwable -> L5
        d37.i r101 = d37.i.f466749a;     // Catch: Throwable -> L5
        d37.i.g("setSpeechRate: " + r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d37.i r102 = d37.i.f466749a;
        d37.i.e("setSpeechRate failed", th);
    }

    public final <T> T k(final Callable<T> r100, T r101) {
        if (Intrinsics.areEqual(Looper.myLooper(), this.f1657n.getLooper()) == true) goto L31;
        final CountDownLatch r102 = new CountDownLatch(1);
        final AtomicReference r103 = new AtomicReference(r101);
        boolean r104 = this.f1657n.post(new o(r103, r100, r102));     // Catch: Throwable -> L11
    L12:
        if (r104 == true) goto L30;
        d37.i r105 = d37.i.f466749a;
        d37.i.c("runOnWorkerSync post failed: worker looper may be quitting.");
        Intrinsics.checkNotNull(r101);
        return r101;
    L30:
    L24:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        d37.i r106 = d37.i.f466749a;
        d37.i.c("runOnWorkerSync InterruptedException: " + e);
    L26:
        Intrinsics.checkNotNull(r101);
        return r101;
    L16:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        d37.i r107 = d37.i.f466749a;     // Catch: InterruptedException -> L24
        d37.i.e("runOnWorkerSync is blocking on MAIN thread; ensure this call is lightweight to avoid ANR", new Exception());     // Catch: InterruptedException -> L24
    L19:
        if (r102.await(5, TimeUnit.SECONDS) == false) goto L22;
        T r108 = (T) r103.get();
        Intrinsics.checkNotNull(r108);     // Catch: InterruptedException -> L24
        return r108;
    L22:
        d37.i r109 = d37.i.f466749a;     // Catch: InterruptedException -> L24
        d37.i.c("runOnWorkerSync timeout: worker not responding");     // Catch: InterruptedException -> L24
    L11:
        r104 = false;
        goto L12
    L31:
        return r100.call();
    L6:
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
