package aw3;

import androidx.camera.video.AudioStats;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.audioplayer.api.news.UrlAudioLoadState;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.audioplayer.api.news.UrlAudioPlayerDelegate;
import com.larus.platform.api.k4;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class p0 implements b88.a, b88.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f16468g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f16469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f16472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m0 f16473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b88.b f16474f;

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
            return r100;
        L5:
            if (Double.isNaN(r100) == true) goto L7;
            r101 = true;
            goto L8
        }
    }

    public interface b {
        void a(p0 r100);

        void b(p0 r100);

        void c(p0 r100);

        void d(p0 r100);

        void e(p0 r100, String r101);

        void f(p0 r100, m0 r101);

        void g(p0 r100);

        void h(p0 r100);

        void i(p0 r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16475a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16476b = null;

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
            f16475a = r100;
            int[] r101 = new int[UrlAudioLoadState.values().length];
            r101[UrlAudioLoadState.PLAYABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r101[UrlAudioLoadState.STALLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r101[UrlAudioLoadState.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r101[UrlAudioLoadState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            f16476b = r101;
        }
    }

    public static final class d implements com.larus.platform.api.l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f16477a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Boolean, Unit> r100) {
            this.f16477a = r100;
        }

        @Override // com.larus.platform.api.l0
        public final void onCompletion(boolean r100) {
            this.f16477a.invoke(Boolean.valueOf(r100));
        }
    }

    static {
    }

    @Override // b88.c
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    public final void f(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        double r101 = a.a(r100.f16490l);
        if (r101 != this.f16472d) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        this.f16472d = r101;
        this.f16474f.d((float) r101);
        FLogger.f375446a.i("BackgroundAudioPlayer", "playback rate updated. rate: " + this.f16472d + ", hasUrl: " + (true ^ StringsKt.isBlank(this.f16470b)));
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [aw3.o0] */
    public p0(q0 r110, b r111) {
        Intrinsics.checkNotNullParameter(r110, "initialState");
        Intrinsics.checkNotNullParameter(r111, "listener");
        this.f16469a = r111;
        String r112 = r110.f16479a;
        if (r112 != null) goto L5;
        r112 = "";
    L5:
        this.f16470b = r112;
        this.f16472d = a.a(r110.f16490l);
        JSONObject r100 = new JSONObject();
        r100.put("scene", "plugin_background_audio");
        UrlAudioPlayerDelegate r113 = UrlAudioPlayerDelegate.f290189b;
        int r101 = SOURCE_TYPE.URL.getValue();
        String r102 = r110.f16480b;
        if (r102 != null) goto L8;
        String r103 = "";
    L9:
        String r114 = r110.f16482d;
        if (r114 != null) goto L12;
        String r104 = "";
    L13:
        String r105 = r112;
        b88.b r115 = r113.a(new b88.f(r105, r101, new k4("plugin_background_audio", r103, r104, r112, "", ""), r100, "plugin_background_audio", "plugin_background_audio", new o0(this), 256), this, this);
        r115.d((float) this.f16472d);
        this.f16474f = r115;
        return;
    L12:
        r104 = r114;
        goto L13
    L8:
        r103 = r102;
        goto L9
    }

    @Override // b88.c
    public final void a(String r100, UrlAudioLoadState r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (Intrinsics.areEqual(r100, this.f16470b) == true) goto L5;
        return;
    L5:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("load state changed. state: ");
        r103.append(r101);
        r103.append(", hasUrl: ");
        r103.append(!StringsKt.isBlank(this.f16470b));
        r102.i("BackgroundAudioPlayer", r103.toString());
        int r104 = c.f16476b[r101.ordinal()];
        if (r104 != 1) goto L8;
        this.f16469a.b(this);
        return;
    L8:
        if (r104 != 2) goto L10;
        this.f16469a.c(this);
        return;
    L10:
        if (r104 != 3) goto L12;
        b r105 = this.f16469a;
        m0 r106 = m0.f16448c;
        r105.f(this, m0.f16449d);
        return;
    L12:
        if (r104 != 4) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // b88.c
    public final void c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, this.f16470b) == true) goto L5;
        return;
    L5:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("audio status changed. status: ");
        r103.append(r101);
        r103.append(", hasUrl: ");
        r103.append(!StringsKt.isBlank(this.f16470b));
        r102.i("BackgroundAudioPlayer", r103.toString());
    }

    public final boolean e(double r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        boolean r102 = false;
        if (this.f16471c == false) goto L5;
        return false;
    L5:
        b88.b r103 = this.f16474f;
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
        if (Intrinsics.areEqual(r100, this.f16470b) == true) goto L5;
        return;
    L5:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("player status changed. status: ");
        r105.append(r103.getValue());
        r105.append(", hasUrl: ");
        r105.append(!StringsKt.isBlank(this.f16470b));
        r104.i("BackgroundAudioPlayer", r105.toString());
        switch(c.f16475a[r103.ordinal()]) {
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
        this.f16469a.i(this);
        return;
    L10:
        b r106 = this.f16469a;
        m0 r107 = m0.f16448c;
        r106.f(this, m0.f16449d);
        return;
    L11:
        this.f16469a.g(this);
        return;
    L12:
        this.f16469a.a(this);
        return;
    L13:
        this.f16469a.d(this);
        return;
    L14:
        this.f16469a.h(this);
        return;
    L16:
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
