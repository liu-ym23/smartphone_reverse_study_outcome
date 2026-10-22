package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import com.ss.android.lark.utils.statistics.PerfLog;
import fd2.t;
import fd2.v;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class SpeechRecognizer implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpeechLyricsView f70420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f70421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f70422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ei6.a f70423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f70424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpeechEngine f70425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f70426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpeechEngine f70427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f70428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f70429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f70430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f70431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LyricComponentImplManager f70432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public k f70433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public t f70434o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f70435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f70436q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f70437r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AudienceLyricsRecognizer f70438s;

    public static final class a {
    }

    public static final class b implements ri6.c {
        public b() {
        }
    }

    static {
    }

    public int a() {
        return ((Number) this.f70435p.getValue()).intValue();
    }

    public void d() {
    }

    public void e() {
    }

    public final void b() {
        ALogger.i("SpeechRecognitionAnchor", "anchor hideLyrics");
        LyricComponentImplManager r100 = this.f70432m;
        if (r100 == null) goto L7;
        jg4.f r101 = r100.f202972g.f202991d;
        if (r101 == null) goto L7;
        r101.reset();
    L7:
        t r102 = this.f70434o;
        if (r102 == null) goto L10;
        r102.a();
    L10:
        SpeechLyricsView r103 = this.f70420a;
        if (r103 == null) goto L15;
        TextView r104 = r103.getAiTipsTextView();
        if (r104 == null) goto L15;
        r104.setVisibility(8);
    L15:
        SpeechLyricsView r105 = this.f70420a;
        if (r105 == null) goto L20;
        ImageView r106 = r105.getAiTagView();
        if (r106 == null) goto L20;
        r106.setVisibility(8);
    L20:
        g(null, 0, 0);
    }

    @Override // fd2.v
    public void destroyEngine() {
        ALogger.i("SpeechRecognitionAnchor", "destroyEngine");
        ((LinkedHashMap) this.f70437r).clear();
        b();
        AudienceLyricsRecognizer r100 = this.f70438s;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f70421b = false;
        this.f70420a = null;
        SpeechEngine r101 = this.f70425f;
        if (r101 == null) goto L8;
        r101.destroyEngine();
    L8:
        this.f70426g = -1;
        this.f70425f = null;
        SpeechEngine r102 = this.f70427h;
        if (r102 == null) goto L11;
        r102.destroyEngine();
    L11:
        this.f70428i = -1;
        this.f70427h = null;
        this.f70422c = null;
        this.f70423d = null;
        this.f70424e = null;
        this.f70429j.clear();
        Disposable r103 = this.f70430k;
        if (r103 != null) goto L14;
    L18:
        Disposable r104 = this.f70431l;
        if (r104 != null) goto L21;
    L25:
        this.f70434o = null;
        return;
    L21:
        if (r104.isDisposed() == true) goto L25;
        Disposable r105 = this.f70431l;
        if (r105 == null) goto L25;
        r105.dispose();
        goto L25
    L14:
        if (r103.isDisposed() == true) goto L18;
        Disposable r106 = this.f70430k;
        if (r106 == null) goto L18;
        r106.dispose();
        goto L18
    }

    @Override // fd2.v
    public final void i() {
        ALogger.i("SpeechRecognitionAnchor", "stopRecognize");
        this.f70436q = false;
        b();
        Disposable r100 = this.f70431l;
        if (r100 != null) goto L5;
    L9:
        Ref.IntRef r101 = new Ref.IntRef();
        r101.element = 10;
        this.f70431l = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, r101));
        e();
        ((LinkedHashMap) this.f70437r).clear();
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r102 = this.f70431l;
        if (r102 == null) goto L9;
        r102.dispose();
        goto L9
    }

    @Override // fd2.v
    public final void initEngine() {
        if (this.f70421b == true) goto L56;
        this.f70421b = true;
        SpeechEngine r100 = SpeechEngineGenerator.getInstance();
        Integer r101 = null;
        if (r100 == null) goto L30;
        this.f70425f = r100;
        this.f70426g = r100.createEngine();
        SpeechEngine r102 = this.f70425f;
        if (r102 == null) goto L10;
        r102.setOptionString("log_level", "TRACE");
    L10:
        SpeechEngine r103 = this.f70425f;
        if (r103 == null) goto L13;
        r103.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, "");
    L13:
        SpeechEngine r104 = this.f70425f;
        if (r104 == null) goto L16;
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, SpeechEngineDefines.AFP_ENGINE);
    L16:
        SpeechEngine r105 = this.f70425f;
        if (r105 == null) goto L19;
        Integer r106 = Integer.valueOf(r105.initEngine());
    L20:
        if (r106 != null) goto L23;
    L24:
        ALogger.i("SpeechRecognitionAnchor", "init fp engine error, ret = " + r106);
        goto L30
    L23:
        if (r106.intValue() != 0) goto L24;
        SpeechEngine r107 = this.f70425f;
        if (r107 == null) goto L28;
        Integer r108 = Integer.valueOf(r107.resetEngine(this.f70426g));
    L29:
        ALogger.i("SpeechRecognitionAnchor", "reset fp engine, ret = " + r108);
        goto L30
    L28:
        r108 = null;
        goto L29
    L19:
        r106 = null;
    L30:
        SpeechEngine r109 = SpeechEngineGenerator.getInstance();
        if (r109 == null) goto L58;
        this.f70427h = r109;
        this.f70428i = r109.createEngine();
        SpeechEngine r110 = this.f70427h;
        if (r110 == null) goto L36;
        r110.setOptionString("log_level", "TRACE");
    L36:
        SpeechEngine r111 = this.f70427h;
        if (r111 == null) goto L39;
        r111.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, "");
    L39:
        SpeechEngine r112 = this.f70427h;
        if (r112 == null) goto L42;
        r112.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, SpeechEngineDefines.COVERSONG_ENGINE);
    L42:
        SpeechEngine r113 = this.f70427h;
        if (r113 == null) goto L45;
        Integer r114 = Integer.valueOf(r113.initEngine());
    L46:
        if (r114 != null) goto L49;
    L50:
        ALogger.i("SpeechRecognitionAnchor", "init cover engine error, ret = " + r114);
        return;
    L49:
        if (r114.intValue() != 0) goto L50;
        SpeechEngine r115 = this.f70427h;
        if (r115 == null) goto L54;
        r101 = Integer.valueOf(r115.resetEngine(this.f70428i));
    L54:
        ALogger.i("SpeechRecognitionAnchor", "reset cover engine, ret = " + r101);
        return;
    L45:
        r114 = null;
        goto L46
    L58:
        return;
    }

    public SpeechRecognizer() {
        this.f70429j = new CompositeDisposable();
        this.f70435p = LazyKt.lazy(SpeechRecognizer$maxBufferSize$2.INSTANCE);
        this.f70437r = new LinkedHashMap();
    }

    @Override // fd2.v
    public final boolean c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L13;
        AudienceLyricsRecognizer r100 = this.f70438s;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.f70326f != true) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    @Override // fd2.v
    public final boolean h() {
        return this.f70436q;
    }

    @Override // fd2.v
    public final void f(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ALogger.i("SpeechRecognitionAnchor", "detachLyricsView");
        r100.removeView(this.f70420a);
    }

    @Override // fd2.v
    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ALogger.i("SpeechRecognitionAnchor", "setRecognizeResultListener");
        this.f70434o = r100;
        AudienceLyricsRecognizer r101 = this.f70438s;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f70330j = r100;
        return;
    }

    @Override // fd2.v
    public final void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        AudienceLyricsRecognizer r101 = this.f70438s;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void g(k r100, long r101, int r110) {
        JSONObject r102 = new JSONObject();
        r102.put("state", 0);
        com.bytedance.android.live.pushstream.d r103 = this.f70422c;
        if (r103 == null) goto L6;
        r103.c1("music_recognition_result", r102, 1, false, false);
        return;
    }

    @Override // fd2.v
    public final void j(ei6.a r100, com.bytedance.android.live.pushstream.d r101, kd2.a r102) {
        Intrinsics.checkNotNullParameter(r102, "recognitionParams");
        ALogger.i("SpeechRecognitionAnchor", "startRecognize, maxBufferSize: " + a() + ", isRetry: " + r102.f502713c);
        this.f70436q = true;
        if (r102.f502713c == true) goto L5;
        this.f70433n = null;
    L5:
        this.f70422c = r101;
        this.f70423d = r100;
        ((LinkedHashMap) this.f70437r).clear();
        this.f70424e = new b();
        if (r100 == null) goto L11;
        ri6.b r103 = r100.r();
        if (r103 == null) goto L11;
        r103.i(LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_MIXED, LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_8000, LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO, this.f70424e);
    L11:
        if (r102.f502713c == true) goto L14;
        d();
        return;
    }

    @Override // fd2.v
    public final void o(Context r110, ConstraintLayout r111, boolean r112, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "parent");
        ALogger.i("SpeechRecognitionAnchor", "attachLyricsView, lyricsContainerView=" + this.f70420a);
        SpeechLyricsView r100 = this.f70420a;
        Object r101 = null;
        if (r100 == null) goto L13;
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L8;
        r101 = r102;
    L8:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L11;
        r103.removeView(this.f70420a);
    L11:
        r111.addView(this.f70420a);
        return;
    L13:
        this.f70420a = new SpeechLyricsView(r110, null, 6, 0);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-1, -1);
        r111.addView(this.f70420a);
        r104.topToTop = 0;
        r104.leftToLeft = 0;
        r104.rightToRight = 0;
        r104.bottomToBottom = 0;
        SpeechLyricsView r105 = this.f70420a;
        if (r105 == null) goto L16;
        r105.setLayoutParams(r104);
    L16:
        SpeechLyricsView r106 = this.f70420a;
        if (r106 == null) goto L19;
        ViewPainter r107 = r106.getLyricsView();
    L20:
        if (r107 == null) goto L33;
        boolean r108 = Intrinsics.areEqual(b6.F.getValue().e(), Boolean.TRUE);
        r107.setVisibility(0);
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
        if ((r109 instanceof ConstraintLayout.LayoutParams) == false) goto L25;
        r101 = r109;
    L25:
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r101;
        if (r108 == true) goto L28;
        if (r112 == true) goto L28;
    L31:
        LyricsDisplayConfig r114 = new LyricsDisplayConfig();
        int r115 = UtilityKotlinExtentionsKt.i(14);
        r114.a();
        r114.f203015j = Float.valueOf(0.0f);
        float r116 = r115;
        r114.f203017l.setTextSize(r116);
        r114.f203016k.setTextSize(r116);
        r114.f203012g = 1;
        r114.e(Paint.Align.LEFT, 1);
        Paint.FontMetrics r117 = r114.f203017l.getFontMetrics();
        float r118 = (UtilityKotlinExtentionsKt.i(18) + r115) / 2.0f;
        r114.f203022q = new LinearGradient(0.0f, r118 + r117.ascent, 0.0f, r118 + r117.descent, ColorProtector.parseColor("#FFFFE267"), ColorProtector.parseColor("#FFFF994F"), Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullParameter(r114, "config");
        Intrinsics.checkNotNullParameter(r107, "painter");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f70432m = new LyricComponentImplManager(r110, r114, new com.bytedance.component.lyric.a(r110, r107));
    L28:
        if (r113 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = UtilityKotlinExtentionsKt.i(4);
    L30:
        r107.setLayoutParams(r113);
    L33:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L43;
        this.f70438s = new AudienceLyricsRecognizer(this.f70432m, this.f70434o, this.f70420a, r112, false);
        Disposable r119 = this.f70430k;
        if (r119 != null) goto L37;
    L41:
        this.f70430k = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this));
        return;
    L37:
        if (r119.isDisposed() == true) goto L41;
        Disposable r120 = this.f70430k;
        if (r120 == null) goto L41;
        r120.dispose();
        goto L41
    L43:
        return;
    L19:
        r107 = null;
        goto L20
    }
}
