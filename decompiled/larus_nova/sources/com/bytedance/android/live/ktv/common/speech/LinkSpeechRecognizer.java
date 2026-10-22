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
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import com.ss.android.lark.utils.statistics.PerfLog;
import fd2.t;
import fd2.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class LinkSpeechRecognizer implements v {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpeechLyricsView f70342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f70343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f70344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ei6.a f70345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f70346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpeechEngine f70347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f70348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpeechEngine f70349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f70350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f70351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f70352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f70353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LyricComponentImplManager f70354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t f70355n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f70356o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayBlockingQueue<byte[]> f70357p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f70358q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f70359r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f70360s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f70361t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, String> f70362u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f70363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f70364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f70365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Disposable f70366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AudienceLyricsRecognizer f70367z;

    public static final class a {
    }

    public static final class b implements ri6.c {
        public b() {
        }
    }

    static {
    }

    public final void a() {
        ALogger.i("LinkSpeechRecognizer", "anchor hideLyrics");
        LyricComponentImplManager r100 = this.f70354m;
        if (r100 == null) goto L7;
        jg4.f r101 = r100.f202972g.f202991d;
        if (r101 == null) goto L7;
        r101.reset();
    L7:
        t r102 = this.f70355n;
        if (r102 == null) goto L10;
        r102.a();
    L10:
        SpeechLyricsView r103 = this.f70342a;
        if (r103 == null) goto L15;
        TextView r104 = r103.getAiTipsTextView();
        if (r104 == null) goto L15;
        r104.setVisibility(8);
    L15:
        SpeechLyricsView r105 = this.f70342a;
        if (r105 == null) goto L20;
        ImageView r106 = r105.getAiTagView();
        if (r106 == null) goto L20;
        r106.setVisibility(8);
    L20:
        b(null, 0, 0);
    }

    public final void d() {
        Disposable r100 = this.f70366y;
        if (r100 != null) goto L5;
    L9:
        this.f70366y = null;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r101 = this.f70366y;
        if (r101 == null) goto L9;
        r101.dispose();
        goto L9
    }

    @Override // fd2.v
    public final void destroyEngine() {
        ALogger.i("LinkSpeechRecognizer", "destroyEngine");
        ((LinkedHashMap) this.f70362u).clear();
        a();
        AudienceLyricsRecognizer r100 = this.f70367z;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f70343b = false;
        this.f70342a = null;
        SpeechEngine r101 = this.f70347f;
        if (r101 == null) goto L8;
        r101.destroyEngine();
    L8:
        this.f70348g = -1;
        this.f70347f = null;
        SpeechEngine r102 = this.f70349h;
        if (r102 == null) goto L11;
        r102.destroyEngine();
    L11:
        this.f70350i = -1;
        this.f70349h = null;
        this.f70344c = null;
        this.f70345d = null;
        this.f70346e = null;
        this.f70351j.clear();
        Disposable r103 = this.f70352k;
        if (r103 != null) goto L14;
    L18:
        Disposable r104 = this.f70353l;
        if (r104 != null) goto L21;
    L25:
        this.f70355n = null;
        d();
        return;
    L21:
        if (r104.isDisposed() == true) goto L25;
        Disposable r105 = this.f70353l;
        if (r105 == null) goto L25;
        r105.dispose();
        goto L25
    L14:
        if (r103.isDisposed() == true) goto L18;
        Disposable r106 = this.f70352k;
        if (r106 == null) goto L18;
        r106.dispose();
        goto L18
    }

    @Override // fd2.v
    public final void i() {
        ALogger.i("LinkSpeechRecognizer", "stopRecognize");
        int r100 = mb0.h.f512763a;
        boolean r101 = true;
        if (this.f70361t == true) goto L6;
        r101 = false;
    L6:
        mb0.h.b(r101, "", "", 0);
        this.f70361t = false;
        a();
        Disposable r102 = this.f70353l;
        if (r102 != null) goto L9;
    L13:
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = 10;
        this.f70353l = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r103));
        ALogger.i("LinkSpeechRecognizer", "onStop");
        d();
        ((LinkedHashMap) this.f70362u).clear();
        return;
    L9:
        if (r102.isDisposed() == true) goto L13;
        Disposable r104 = this.f70353l;
        if (r104 == null) goto L13;
        r104.dispose();
        goto L13
    }

    @Override // fd2.v
    public final void initEngine() {
        if (this.f70343b == true) goto L56;
        this.f70343b = true;
        SpeechEngine r100 = SpeechEngineGenerator.getInstance();
        Integer r101 = null;
        if (r100 == null) goto L30;
        this.f70347f = r100;
        this.f70348g = r100.createEngine();
        SpeechEngine r102 = this.f70347f;
        if (r102 == null) goto L10;
        r102.setOptionString("log_level", "TRACE");
    L10:
        SpeechEngine r103 = this.f70347f;
        if (r103 == null) goto L13;
        r103.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, "");
    L13:
        SpeechEngine r104 = this.f70347f;
        if (r104 == null) goto L16;
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, SpeechEngineDefines.AFP_ENGINE);
    L16:
        SpeechEngine r105 = this.f70347f;
        if (r105 == null) goto L19;
        Integer r106 = Integer.valueOf(r105.initEngine());
    L20:
        if (r106 != null) goto L23;
    L24:
        ALogger.i("LinkSpeechRecognizer", "init fp engine error, ret = " + r106);
        goto L30
    L23:
        if (r106.intValue() != 0) goto L24;
        SpeechEngine r107 = this.f70347f;
        if (r107 == null) goto L28;
        Integer r108 = Integer.valueOf(r107.resetEngine(this.f70348g));
    L29:
        ALogger.i("LinkSpeechRecognizer", "reset fp engine, ret = " + r108);
        goto L30
    L28:
        r108 = null;
        goto L29
    L19:
        r106 = null;
    L30:
        SpeechEngine r109 = SpeechEngineGenerator.getInstance();
        if (r109 == null) goto L58;
        this.f70349h = r109;
        this.f70350i = r109.createEngine();
        SpeechEngine r110 = this.f70349h;
        if (r110 == null) goto L36;
        r110.setOptionString("log_level", "TRACE");
    L36:
        SpeechEngine r111 = this.f70349h;
        if (r111 == null) goto L39;
        r111.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, "");
    L39:
        SpeechEngine r112 = this.f70349h;
        if (r112 == null) goto L42;
        r112.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, SpeechEngineDefines.COVERSONG_ENGINE);
    L42:
        SpeechEngine r113 = this.f70349h;
        if (r113 == null) goto L45;
        Integer r114 = Integer.valueOf(r113.initEngine());
    L46:
        if (r114 != null) goto L49;
    L50:
        ALogger.i("LinkSpeechRecognizer", "init cover engine error, ret = " + r114);
        return;
    L49:
        if (r114.intValue() != 0) goto L50;
        SpeechEngine r115 = this.f70349h;
        if (r115 == null) goto L54;
        r101 = Integer.valueOf(r115.resetEngine(this.f70350i));
    L54:
        ALogger.i("LinkSpeechRecognizer", "reset cover engine, ret = " + r101);
        return;
    L45:
        r114 = null;
        goto L46
    L58:
        return;
    }

    public LinkSpeechRecognizer() {
        this.f70351j = new CompositeDisposable();
        this.f70356o = LazyKt.lazy(LinkSpeechRecognizer$maxBufferSize$2.INSTANCE);
        this.f70357p = new ArrayBlockingQueue(3072);
        this.f70358q = new AtomicInteger(0);
        this.f70359r = new AtomicBoolean(true);
        this.f70360s = new AtomicBoolean(true);
        this.f70362u = new LinkedHashMap();
        this.f70363v = LazyKt.lazy(LinkSpeechRecognizer$enableGuestStream$2.INSTANCE);
        this.f70364w = LazyKt.lazy(new LinkSpeechRecognizer$halfMaxBufferSize$2(this));
        this.f70365x = LazyKt.lazy(LinkSpeechRecognizer$enableResultCheck$2.INSTANCE);
    }

    @Override // fd2.v
    public final boolean c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L13;
        AudienceLyricsRecognizer r100 = this.f70367z;
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
        return this.f70361t;
    }

    @Override // fd2.v
    public final void f(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ALogger.i("LinkSpeechRecognizer", "detachLyricsView");
        r100.removeView(this.f70342a);
    }

    @Override // fd2.v
    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ALogger.i("LinkSpeechRecognizer", "setRecognizeResultListener");
        this.f70355n = r100;
        AudienceLyricsRecognizer r101 = this.f70367z;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f70330j = r100;
        return;
    }

    @Override // fd2.v
    public final void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        AudienceLyricsRecognizer r101 = this.f70367z;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void b(k r100, long r101, int r110) {
        JSONObject r102 = new JSONObject();
        r102.put("state", 0);
        com.bytedance.android.live.pushstream.d r103 = this.f70344c;
        if (r103 == null) goto L6;
        r103.c1("music_recognition_result", r102, 1, false, false);
        return;
    }

    @Override // fd2.v
    public final void j(ei6.a r100, com.bytedance.android.live.pushstream.d r101, kd2.a r102) {
        Intrinsics.checkNotNullParameter(r102, "recognitionParams");
        ALogger.i("LinkSpeechRecognizer", "startRecognize, maxBufferSize: " + ((Number) this.f70356o.getValue()).intValue() + ", isRetry: " + r102.f502713c + ", interactId: " + r102.f502715e);
        int r103 = mb0.h.f512763a;
        mb0.h.a(((Number) this.f70356o.getValue()).intValue(), r102.f502713c, r102.f502715e, r102.f502714d);
        this.f70361t = true;
        this.f70359r.set(true);
        this.f70360s.set(true);
        this.f70358q.set(0);
        this.f70357p.clear();
        this.f70344c = r101;
        this.f70345d = r100;
        ((LinkedHashMap) this.f70362u).clear();
        this.f70346e = new b();
        if (((Boolean) this.f70363v.getValue()).booleanValue() == false) goto L8;
        if (r102.f502714d == false) goto L8;
        LiveWrappedAudioFrameCallbackMethod r104 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_RECORD;
    L11:
        if (r100 == null) goto L16;
        ri6.b r105 = r100.r();
        if (r105 == null) goto L16;
        r105.i(r104, LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_8000, LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO, this.f70346e);
    L16:
        if (r102.f502713c == true) goto L19;
        ALogger.i("LinkSpeechRecognizer", WidgetCostModule.TYPE_ON_START);
        d();
        this.f70366y = Observable.interval(KtvSettingHelper.A().o(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.ktv.common.speech.b(this, r102), c.f70442a);
        return;
    L19:
        return;
    L8:
        if (((Boolean) this.f70363v.getValue()).booleanValue() == false) goto L10;
        r104 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_REMOTE_USER;
        goto L11
    L10:
        r104 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_MIXED;
        goto L11
    }

    @Override // fd2.v
    public final void o(Context r110, ConstraintLayout r111, boolean r112, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "parent");
        ALogger.i("LinkSpeechRecognizer", "attachLyricsView, lyricsContainerView=" + this.f70342a);
        SpeechLyricsView r100 = this.f70342a;
        Object r101 = null;
        if (r100 == null) goto L13;
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L8;
        r101 = r102;
    L8:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L11;
        r103.removeView(this.f70342a);
    L11:
        r111.addView(this.f70342a);
        return;
    L13:
        this.f70342a = new SpeechLyricsView(r110, null, 6, 0);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-1, -1);
        r111.addView(this.f70342a);
        r104.topToTop = 0;
        r104.leftToLeft = 0;
        r104.rightToRight = 0;
        r104.bottomToBottom = 0;
        SpeechLyricsView r105 = this.f70342a;
        if (r105 == null) goto L16;
        r105.setLayoutParams(r104);
    L16:
        SpeechLyricsView r106 = this.f70342a;
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
        this.f70354m = new LyricComponentImplManager(r110, r114, new com.bytedance.component.lyric.a(r110, r107));
    L28:
        if (r113 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = UtilityKotlinExtentionsKt.i(4);
    L30:
        r107.setLayoutParams(r113);
    L33:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L43;
        this.f70367z = new AudienceLyricsRecognizer(this.f70354m, this.f70355n, this.f70342a, r112, false);
        Disposable r119 = this.f70352k;
        if (r119 != null) goto L37;
    L41:
        this.f70352k = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.ktv.common.speech.a(this));
        return;
    L37:
        if (r119.isDisposed() == true) goto L41;
        Disposable r120 = this.f70352k;
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
