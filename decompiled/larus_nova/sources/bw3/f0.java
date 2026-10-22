package bw3;

import androidx.camera.video.AudioStats;
import com.larus.audioplayer.api.news.UrlAudioLoadState;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.audioplayer.api.news.UrlAudioPlayerDelegate;
import com.larus.platform.api.k4;
import com.larus.platform.api.l0;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f0 implements b88.a, b88.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f21053j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f21056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f21057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f21059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f21060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f21061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b88.b f21062i;

    public static final class a {
        public static double a(double r100) {
            if (Double.isInfinite(r100) == false) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L10;
        L12:
            return 1.0d;
        L10:
            if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
            return RangesKt.coerceIn(r100, 0.5d, 2.0d);
        L5:
            if (Double.isNaN(r100) == true) goto L7;
            r101 = true;
            goto L8
        }

        public static double b(double r100) {
            if (Double.isInfinite(r100) == false) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L12;
            return 1.0d;
        L12:
            return RangesKt.coerceIn(r100, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
        L5:
            if (Double.isNaN(r100) == true) goto L7;
            r101 = true;
            goto L8
        }
    }

    public interface b {
        void a(f0 r100);

        void b(f0 r100);

        void c(f0 r100);

        void d(f0 r100);

        void e(f0 r100);

        void f(f0 r100);

        void g(f0 r100, x r101);

        void h(f0 r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21063a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21064b = null;

        static {
            int[] r100 = new int[UrlAudioPlayStatus.values().length];
            r100[UrlAudioPlayStatus.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[UrlAudioPlayStatus.PLAYING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r100[UrlAudioPlayStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[UrlAudioPlayStatus.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[UrlAudioPlayStatus.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r100[UrlAudioPlayStatus.FINISH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r100[UrlAudioPlayStatus.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            f21063a = r100;
            int[] r101 = new int[UrlAudioLoadState.values().length];
            r101[UrlAudioLoadState.PLAYABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r101[UrlAudioLoadState.STALLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r101[UrlAudioLoadState.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r101[UrlAudioLoadState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            f21064b = r101;
        }
    }

    public static final class d implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f21065a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Boolean, Unit> r100) {
            this.f21065a = r100;
        }

        @Override // com.larus.platform.api.l0
        public final void onCompletion(boolean r100) {
            this.f21065a.invoke(Boolean.valueOf(r100));
        }
    }

    static {
    }

    @Override // b88.c
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    public final void f(float r100) {
        if (Float.isInfinite(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
        float r102 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
    L12:
        this.f21061h = r102;
        this.f21062i.c(RangesKt.coerceIn(((float) this.f21060g) * r102, 0.0f, 1.0f));
        FLogger.f375446a.i("InnerAudioPlayer", "category volume factor updated. audioId: " + this.f21054a + ", volumeFactor: " + this.f21061h);
        return;
    L11:
        r102 = 1.0f;
        goto L12
    L5:
        if (Float.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L9
    }

    public final void g(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        double r101 = a.a(r100.f21090l);
        boolean r102 = false;
        if (r101 != this.f21059f) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        this.f21059f = r101;
        this.f21062i.d((float) r101);
        FLogger.f375446a.i("InnerAudioPlayer", "playback rate updated. audioId: " + this.f21054a + ", rate: " + this.f21059f);
    L9:
        double r104 = a.b(r100.f21089k);
        if (r104 != this.f21060g) goto L12;
        r102 = true;
    L12:
        if (r102 == true) goto L14;
        this.f21060g = r104;
        this.f21062i.c(RangesKt.coerceIn(((float) r104) * this.f21061h, 0.0f, 1.0f));
        FLogger.f375446a.i("InnerAudioPlayer", "volume updated. audioId: " + this.f21054a + ", volume: " + this.f21060g);
    L14:
        this.f21062i.setLooping(r100.f21082d);
        return;
    L5:
        r103 = false;
        goto L7
    }

    @Override // b88.c
    public final void a(String r100, UrlAudioLoadState r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (Intrinsics.areEqual(r100, this.f21056c.f21072b) == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("InnerAudioPlayer", "load state changed. audioId: " + this.f21054a + ", state: " + r101);
        int r102 = c.f21064b[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.f21057d.e(this);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f21057d.b(this);
        return;
    L10:
        if (r102 != 3) goto L12;
        this.f21057d.g(this, new x(-2007, "inner audio play failed"));
        return;
    L12:
        if (r102 != 4) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // b88.c
    public final void c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, this.f21056c.f21072b) == false) goto L6;
        FLogger.f375446a.i("InnerAudioPlayer", "audio status changed. audioId: " + this.f21054a + ", status: " + r101);
        return;
    }

    public final boolean e(double r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        boolean r102 = false;
        if (this.f21058e == false) goto L5;
        return false;
    L5:
        b88.b r103 = this.f21062i;
        if (Double.isInfinite(r100) == false) goto L8;
    L10:
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r102 == false) goto L13;
        r104 = RangesKt.coerceAtLeast(r100, AudioStats.AUDIO_AMPLITUDE_NONE);
    L13:
        r103.j(MathKt.roundToInt(RangesKt.coerceAtMost(r104, 2147483.647d) * ((double) 1000)), new d(r101));
        return true;
    L8:
        if (Double.isNaN(r100) == true) goto L10;
        r102 = true;
        goto L10
    }

    @Override // b88.a
    public final void d(String r100, String r101, int r102, UrlAudioPlayStatus r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "status");
        if (Intrinsics.areEqual(r100, this.f21056c.f21072b) == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("InnerAudioPlayer", "player status changed. audioId: " + this.f21054a + ", status: " + r103.getValue());
        switch(c.f21063a[r103.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L16;
            default: goto L8;
        };
    L9:
        this.f21057d.d(this);
        return;
    L10:
        this.f21057d.g(this, new x(-2007, "inner audio play failed"));
        return;
    L11:
        this.f21057d.f(this);
        return;
    L12:
        this.f21057d.h(this);
        return;
    L13:
        this.f21057d.a(this);
        return;
    L14:
        this.f21057d.c(this);
        return;
    L16:
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public f0(String r210, String r211, g0 r212, h0 r213, b r214) {
        Intrinsics.checkNotNullParameter(r210, "audioId");
        Intrinsics.checkNotNullParameter(r211, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r212, "resolvedSource");
        Intrinsics.checkNotNullParameter(r213, "initialState");
        Intrinsics.checkNotNullParameter(r214, "listener");
        this.f21054a = r210;
        this.f21055b = r211;
        this.f21056c = r212;
        this.f21057d = r214;
        this.f21059f = a.a(r213.f21090l);
        this.f21060g = a.b(r213.f21089k);
        this.f21061h = 1.0f;
        JSONObject r110 = new JSONObject();
        r110.put("scene", "plugin_inner_audio");
        r110.put("audio_id", r210);
        b88.b r100 = UrlAudioPlayerDelegate.f290189b.a(new b88.f(r212.f21072b, r212.f21073c, new k4("plugin_inner_audio", "", "", r210, "", ""), r110, "plugin_inner_audio", "plugin_inner_audio", null, 512), this, this);
        r100.setLooping(r213.f21082d);
        r100.d((float) this.f21059f);
        r100.c(RangesKt.coerceIn(((float) this.f21060g) * this.f21061h, 0.0f, 1.0f));
        this.f21062i = r100;
    }
}
