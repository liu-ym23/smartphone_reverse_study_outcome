package bw3;

import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.bytedance.applet.audio.inner.InnerAudioPlaybackState;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f0 f21049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Double f21050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f21051f;

    public static final class a {
    }

    static {
    }

    public final h0 a() {
        this.f21048c = true;
        f(MapMonitorConst.EVENT_DESTROY);
        this.f21050e = null;
        h0 r100 = this.f21051f;
        h0.c(r100, AudioStats.AUDIO_AMPLITUDE_NONE, r100.f21086h);
        this.f21051f.d(InnerAudioPlaybackState.STOPPED);
        return h0.a(this.f21051f);
    }

    public final h0 h() {
        e(this.f21049d);
        return h0.a(this.f21051f);
    }

    public static void g(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        com.larus.utils.y.b().post(new d0(r100));
    }

    public final boolean b(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        if (this.f21049d == r100) goto L5;
    L7:
        return false;
    L5:
        if (this.f21048c == true) goto L7;
        return true;
    }

    public final w c(float r100) {
        f0 r101 = this.f21049d;
        if (r101 != null) goto L16;
        int r102 = w.f21124c;
        String r103 = this.f21051f.f21080b;
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        x r105 = x.f21129e;
    L15:
        return w.a.a(r105, this.f21051f);
    L13:
        r105 = x.f21130f;
        goto L15
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
        goto L11
    L16:
        r101.f(r100);
        this.f21051f.d(InnerAudioPlaybackState.PLAYING);
        h0 r106 = this.f21051f;
        Intrinsics.checkNotNullParameter(r106, "state");
        if (r101.f21058e == false) goto L19;
        FLogger.f375446a.e("InnerAudioPlayer", "play rejected. audioId: " + r101.f21054a + ", reason: released");
        x r107 = x.f21131g;
    L20:
        if (r107 == null) goto L23;
        this.f21051f.d(InnerAudioPlaybackState.ERROR);
        int r108 = w.f21124c;
        return w.a.a(r107, this.f21051f);
    L23:
        e(r101);
        FLogger.f375446a.i("InnerAudioInstance", "play requested. appletId: " + this.f21047b + ", audioId: " + this.f21046a + ", " + this.f21051f.b());
        int r109 = w.f21124c;
        return w.a.b(this.f21051f);
    L19:
        r101.g(r106);
        r101.f21062i.i("inner_audio");
        r107 = null;
        goto L20
    }

    public final w d(f0.b r110) {
        Intrinsics.checkNotNullParameter(r110, "listener");
        if (this.f21048c == false) goto L6;
        int r111 = w.f21124c;
        return w.a.a(x.f21128d, this.f21051f);
    L6:
        String r100 = this.f21051f.f21080b;
        Double r101 = null;
        if (r100 == null) goto L9;
        String r102 = StringsKt.trim(r100).toString();
    L10:
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        boolean r103 = true;
        if (StringsKt.isBlank(r102) == false) goto L16;
    L51:
        g0 r112 = null;
    L54:
        if (r112 != null) goto L66;
        int r113 = w.f21124c;
        String r114 = this.f21051f.f21080b;
        if (r114 != null) goto L58;
    L61:
        if (r103 == false) goto L63;
        x r115 = x.f21129e;
    L65:
        return w.a.a(r115, this.f21051f);
    L63:
        r115 = x.f21130f;
        goto L65
    L58:
        if (StringsKt.isBlank(r114) == true) goto L61;
        r103 = false;
        goto L61
    L66:
        f0 r104 = this.f21049d;
        if (r104 != null) goto L69;
    L70:
        f("new_source");
        Double r105 = Double.valueOf(this.f21051f.f21084f);
        if (r105.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L74;
        r103 = false;
    L74:
        if (r103 == false) goto L76;
        r101 = r105;
    L76:
        this.f21050e = r101;
        this.f21049d = new f0(this.f21046a, this.f21047b, r112, this.f21051f, r110);
    L77:
        FLogger.f375446a.i("InnerAudioInstance", "prepare play success. appletId: " + this.f21047b + ", audioId: " + this.f21046a + ", " + this.f21051f.b());
        int r116 = w.f21124c;
        return w.a.b(this.f21051f);
    L69:
        if (Intrinsics.areEqual(r104.f21056c.f21072b, r112.f21072b) == true) goto L77;
    L16:
        if (StringsKt.startsWith$default(r102, "http://", false, 2, null) == false) goto L18;
    L52:
        g0 r106 = new g0(r102, r102, SOURCE_TYPE.URL.getValue());
    L53:
        r112 = r106;
        goto L54
    L18:
        if (StringsKt.startsWith$default(r102, "https://", false, 2, null) == true) goto L52;
        if (StringsKt.startsWith$default(r102, "appletfile://", false, 2, null) == true) goto L79;
        r106 = null;
    L48:
        if (r106 != null) goto L53;
        FLogger.f375446a.e("InnerAudioInstance", "resolve source failed. appletId: " + this.f21047b + ", audioId: " + this.f21046a + ", src: " + r102);
        goto L51
    L79:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L39
        bw3.a r108 = bw3.a.f21022a;     // Catch: Throwable -> L39
        String r109 = this.f21047b;     // Catch: Throwable -> L39
        r108.getClass();     // Catch: Throwable -> L39
        File r117 = bw3.a.a(r109, r102);     // Catch: Throwable -> L39
        if (r117 != null) goto L26;
    L36:
        g0 r118 = null;
    L37:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L39
    L41:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L45;
        FLogger.f375446a.e("InnerAudioInstance", "resolve applet file failed. appletId: " + this.f21047b + ", audioId: " + this.f21046a + ", error: " + r120.getMessage());
    L45:
        if (Result.m9455isFailureimpl(r119) == false) goto L47;
        r119 = null;
    L47:
        r106 = (g0) r119;
        goto L48
    L26:
        if (r117.exists() == true) goto L28;
    L30:
        boolean r121 = false;
    L31:
        if (r121 == true) goto L34;
        r117 = null;
    L34:
        if (r117 == null) goto L36;
        r118 = new g0(r102, r117.getAbsolutePath(), SOURCE_TYPE.LOCAL_FILE.getValue());     // Catch: Throwable -> L39
        goto L37
    L28:
        if (r117.isFile() == false) goto L30;
        r121 = true;
    L39:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L9:
        r102 = null;
        goto L10
    }

    public final void e(f0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        h0 r101 = this.f21051f;
        int r102 = f0.f21053j;
        h0.c(r101, ((double) RangesKt.coerceAtLeast(r100.f21062i.f(), 0)) / 1000.0d, ((double) RangesKt.coerceAtLeast(r100.f21062i.getAudioDuration(), 0)) / 1000.0d);
        this.f21051f.f21090l = f0.a.a(r100.f21062i.e());
    }

    public final void f(String r100) {
        f0 r101 = this.f21049d;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f21049d = null;
        if (r101.f21058e == true) goto L9;
        r101.f21058e = true;
        r101.f21062i.release();
    L9:
        FLogger.f375446a.i("InnerAudioInstance", "player released. appletId: " + this.f21047b + ", audioId: " + this.f21046a + ", reason: " + r100);
    }

    public e0(String r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "audioId");
        Intrinsics.checkNotNullParameter(r211, IFlowAppIntentIDL.PARAM_APPLET_ID);
        this.f21046a = r210;
        this.f21047b = r211;
        this.f21051f = new h0(r210, null, false, false, true, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, true, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d, 1.0d, InnerAudioPlaybackState.STOPPED);
    }
}
