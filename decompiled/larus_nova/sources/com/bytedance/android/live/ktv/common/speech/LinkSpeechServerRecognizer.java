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
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSampleRate;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.MusicInterval;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import fd2.h0;
import fd2.t;
import fd2.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class LinkSpeechServerRecognizer extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> implements v {
    public static final Set<String> K = null;
    public final Lazy A;
    public Disposable B;
    public AudienceLyricsRecognizer C;
    public com.bytedance.android.live.ktv.common.model.api.j D;
    public final CompositeDisposable E;
    public boolean F;
    public String G;
    public rb0.b H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final LyricFontHelper f70368J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpeechLyricsView f70369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f70370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f70371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ei6.a f70372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f70373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpeechEngine f70374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f70375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpeechEngine f70376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f70377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f70378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f70379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f70380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f70381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LyricComponentImplManager f70382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public k f70383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f70384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f70385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayBlockingQueue<byte[]> f70386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicInteger f70387s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f70388t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f70389u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f70390v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f70391w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<String, String> f70392x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f70393y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f70394z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkSpeechServerRecognizer f70395a;

        public b(LinkSpeechServerRecognizer r100) {
            this.f70395a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            if (((h0) r210).f476495a == false) goto L179;
            com.bytedance.android.live.ktv.common.model.api.j r100 = new com.bytedance.android.live.ktv.common.model.api.j();
            r100.s(6874972841490515969L);
            r100.q(6815073757028157452L);
            r100.p(202544130L);
            Boolean r101 = Boolean.FALSE;
            r100.k(r101);
            r100.t(2);
            r100.r();
            MusicInterval r102 = new MusicInterval();
            r102.setStartMs(20856);
            r102.setDurationMs(37455);
            Unit r103 = Unit.INSTANCE;
            r100.o(CollectionsKt.listOf(r102));
            r100.l();
            r100.n();
            r100.m();
            LinkSpeechServerRecognizer r104 = this.f70395a;
            r104.f70390v = true;
            com.bytedance.android.livesdk.chatroom.o r105 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r105 == null) goto L9;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r106 = r105.getLiveStream();
            if (r106 == null) goto L9;
            com.bytedance.android.live.pushstream.d r107 = r106.getValue();
        L10:
            r104.f70371c = r107;
            LinkSpeechServerRecognizer r108 = this.f70395a;
            long r110 = System.currentTimeMillis();
            r108.getClass();
            com.bytedance.android.live.ktv.common.model.api.j r111 = r108.D;     // Catch: JSONException -> L176
            String r112 = r100.a();     // Catch: JSONException -> L176
            String r113 = r100.c();     // Catch: JSONException -> L176
            Boolean r114 = r100.i();     // Catch: JSONException -> L176
            if (r114 == null) goto L14;
            boolean r109 = r114.booleanValue();     // Catch: JSONException -> L176
        L15:
            Boolean r115 = r100.j();     // Catch: JSONException -> L176
            if (r115 == null) goto L18;
            boolean r116 = r115.booleanValue();     // Catch: JSONException -> L176
        L21:
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L37;
            Long r211 = com.bytedance.android.live.liveinteract.utils.a.f78714a;     // Catch: JSONException -> L176
            StringBuilder r117 = new StringBuilder("currentSimGroupIdV3=");     // Catch: JSONException -> L176
            if (r111 == null) goto L25;
            Long r118 = r111.f();     // Catch: JSONException -> L176
        L26:
            r117.append(r118);     // Catch: JSONException -> L176
            r117.append("\nnewSimGroupIdV3=");     // Catch: JSONException -> L176
            r117.append(r100.f());     // Catch: JSONException -> L176
            r117.append(", isFilter=");     // Catch: JSONException -> L176
            r117.append(r109);     // Catch: JSONException -> L176
            r117.append(", isNonVal=");     // Catch: JSONException -> L176
            r117.append(r116);     // Catch: JSONException -> L176
            r117.append(", songID=");     // Catch: JSONException -> L176
            r117.append(r100.h());     // Catch: JSONException -> L176
            r117.append(", hasLyric=");     // Catch: JSONException -> L176
            if (r2.a(r100.c()) == true) goto L29;
        L31:
            boolean r119 = false;
        L32:
            r117.append(r119);     // Catch: JSONException -> L176
            r117.append('\n');     // Catch: JSONException -> L176
            String r120 = r117.toString();     // Catch: JSONException -> L176
            String r121 = com.bytedance.android.live.liveinteract.utils.a.f78727n;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.f78727n = r120;     // Catch: JSONException -> L176
            if (r121 == r120) goto L37;
            Function0<Unit> r122 = com.bytedance.android.live.liveinteract.utils.a.f78729p;     // Catch: JSONException -> L176
            if (r122 == null) goto L37;
            Unit r123 = r122.invoke();     // Catch: JSONException -> L176
            goto L37
        L29:
            if ((!Intrinsics.areEqual(r100.c(), "null")) == false) goto L31;
            r119 = true;
            goto L32
        L25:
            r118 = null;
        L37:
            if (r111 == null) goto L39;
            Long r124 = r111.f();     // Catch: JSONException -> L176
        L41:
            if ((!Intrinsics.areEqual(r124, r100.f())) == false) goto L73;
            Long r125 = com.bytedance.android.live.liveinteract.utils.a.f78714a;     // Catch: JSONException -> L176
            Long r126 = r100.f();     // Catch: JSONException -> L176
            Long r127 = com.bytedance.android.live.liveinteract.utils.a.f78714a;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.f78714a = r126;     // Catch: JSONException -> L176
            if (r127 == r126) goto L47;
            Function0<Unit> r128 = com.bytedance.android.live.liveinteract.utils.a.f78729p;     // Catch: JSONException -> L176
            if (r128 == null) goto L47;
            Unit r129 = r128.invoke();     // Catch: JSONException -> L176
        L47:
            Boolean r130 = Boolean.valueOf(r109);     // Catch: JSONException -> L176
            Boolean r131 = com.bytedance.android.live.liveinteract.utils.a.f78720g;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.f78720g = r130;     // Catch: JSONException -> L176
            if (r131 == r130) goto L52;
            Function0<Unit> r132 = com.bytedance.android.live.liveinteract.utils.a.f78729p;     // Catch: JSONException -> L176
            if (r132 == null) goto L52;
            Unit r133 = r132.invoke();     // Catch: JSONException -> L176
        L52:
            Boolean r134 = Boolean.valueOf(r116);     // Catch: JSONException -> L176
            Boolean r135 = com.bytedance.android.live.liveinteract.utils.a.f78722i;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.f78722i = r134;     // Catch: JSONException -> L176
            if (r135 == r134) goto L57;
            Function0<Unit> r136 = com.bytedance.android.live.liveinteract.utils.a.f78729p;     // Catch: JSONException -> L176
            if (r136 == null) goto L57;
            Unit r137 = r136.invoke();     // Catch: JSONException -> L176
        L57:
            Long r138 = r100.h();     // Catch: JSONException -> L176
            if (r138 == null) goto L60;
            String r139 = String.valueOf(r138.longValue());     // Catch: JSONException -> L176
        L61:
            com.bytedance.android.live.liveinteract.utils.a.g(r139);     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.a(r100.g());     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.d(r100.d());     // Catch: JSONException -> L176
            if (r2.a(r112) == true) goto L64;
        L65:
            if (r109 == false) goto L73;
            if (r116 == true) goto L73;
        L67:
            Long r140 = r100.h();     // Catch: JSONException -> L176
            if (r140 == null) goto L70;
            String r141 = String.valueOf(r140.longValue());     // Catch: JSONException -> L176
        L71:
            r108.r(r141, false, r100.e(), r100.f(), 0);     // Catch: JSONException -> L176
            r108.D = r100;     // Catch: JSONException -> L176
            goto L73
        L70:
            r141 = null;
            goto L71
        L64:
            if (r2.a(r113) == true) goto L67;
        L60:
            r139 = null;
        L73:
            String r142 = r100.a();     // Catch: JSONException -> L176
            String r143 = r100.c();     // Catch: JSONException -> L176
            if (r142 == null) goto L186;
            if (r143 == null) goto L186;
            if (r142.length() != 0) goto L79;
            boolean r144 = true;
        L80:
            if (r144 == false) goto L82;
        L174:
            com.bytedance.android.live.liveinteract.utils.a.c(r101);     // Catch: JSONException -> L176
            goto L186
        L82:
            if (r143.length() != 0) goto L84;
            boolean r145 = true;
        L85:
            if (r145 == true) goto L174;
            if (Intrinsics.areEqual(r142, r13) == true) goto L174;
            if (Intrinsics.areEqual(r143, r13) == true) goto L174;
            JSONObject r146 = new JSONObject(r142);     // Catch: JSONException -> L176
            double r147 = r146.optDouble("MatchEndTime");     // Catch: JSONException -> L176
            JSONObject r148 = r146.optJSONObject("SongInfo");     // Catch: JSONException -> L176
            if (r148 == null) goto L95;
            String r149 = r148.optString("ID");     // Catch: JSONException -> L176
            if (r149 == null) goto L95;
        L96:
            String r150 = r149;
            if (r148 == null) goto L100;
            String r151 = r148.optString("SongName");     // Catch: JSONException -> L176
            if (r151 == null) goto L100;
        L101:
            if (r148 == null) goto L103;
            int r152 = r148.optInt("FullDuration");     // Catch: JSONException -> L176
        L104:
            if (r148 == null) goto L107;
            String r153 = r148.optString("ArtistName");     // Catch: JSONException -> L176
            if (r153 == null) goto L107;
        L109:
            if (r2.a(r143) == false) goto L186;
            if ((!Intrinsics.areEqual(r143, "null")) == false) goto L186;
            JSONObject r154 = new JSONObject(r143);     // Catch: JSONException -> L176
            JSONObject r155 = r154.optJSONObject("LyricUrlInfo");     // Catch: JSONException -> L176
            if (r155 == null) goto L115;
            JSONArray r156 = r155.optJSONArray("Urls");     // Catch: JSONException -> L176
        L116:
            int r157 = r154.optInt("LyricType");     // Catch: JSONException -> L176
            if (r156 == null) goto L119;
            int r158 = r156.length();     // Catch: JSONException -> L176
        L120:
            if (r158 <= 0) goto L127;
            if (r156 == null) goto L126;
            Object r159 = r156.get(0);     // Catch: JSONException -> L176
            if (r159 == null) goto L126;
            String r160 = r159.toString();     // Catch: JSONException -> L176
        L128:
            ALogger.e("LinkSpeechRecognizer", "songInfo: songId=" + r150 + ", songName=" + r151 + ", matchEndTime=" + r147 + ", url=" + r160 + "， songDuration=" + r152);     // Catch: JSONException -> L176
            if (r152 <= 0) goto L186;
            if (r160 != null) goto L132;
        L135:
            boolean r161 = true;
        L136:
            if (r161 == true) goto L186;
            if (r157 == 3) goto L142;
            int r162 = 2;
            if (r157 != 2) goto L186;
        L143:
            int r163 = r100.getType();     // Catch: JSONException -> L176
            if (r163 == r162) goto L183;
            int r164 = r152;
            int r165 = JSONObjectProtectorUtils.getInt(r146, "Similarity");     // Catch: JSONException -> L153
        L155:
            IInteractService r166 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L176
            if (r166 == null) goto L158;
            boolean r167 = r166.isAIMVStage();     // Catch: JSONException -> L176
        L159:
            if (r167 == false) goto L161;
            String r212 = r100.g();     // Catch: JSONException -> L176
        L162:
            if (r167 == false) goto L164;
            List<MusicInterval> r213 = r100.d();     // Catch: JSONException -> L176
        L165:
            if (r167 == false) goto L167;
            String r214 = r100.b();     // Catch: JSONException -> L176
        L168:
            r108.q(new k(r163, r150, r160, r147, r164, r165, r110, r151, r157, r153, r212, r213, r214));     // Catch: JSONException -> L176
            Long r168 = com.bytedance.android.live.liveinteract.utils.a.f78714a;     // Catch: JSONException -> L176
            Integer r169 = Integer.valueOf(r165);     // Catch: JSONException -> L176
            Integer r170 = com.bytedance.android.live.liveinteract.utils.a.f78716c;     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.f78716c = r169;     // Catch: JSONException -> L176
            if (r170 == r169) goto L173;
            Function0<Unit> r171 = com.bytedance.android.live.liveinteract.utils.a.f78729p;     // Catch: JSONException -> L176
            if (r171 == null) goto L173;
            Unit r172 = r171.invoke();     // Catch: JSONException -> L176
        L173:
            com.bytedance.android.live.liveinteract.utils.a.c(Boolean.TRUE);     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.g(r150);     // Catch: JSONException -> L176
            com.bytedance.android.live.liveinteract.utils.a.d(r213);     // Catch: JSONException -> L176
            goto L186
        L167:
            r214 = null;
            goto L168
        L164:
            r213 = null;
            goto L165
        L161:
            r212 = null;
            goto L162
        L158:
            r167 = false;
        L153:
            e = e;
        L154:
            ALogger.e("LinkSpeechServerRecognizer", "parseSongInfo, Similarity json exception: " + e.getMessage());     // Catch: JSONException -> L176
            r165 = 0;
            goto L155
        L183:
            r164 = r152;
            r165 = (int) (JSONObjectProtectorUtils.getDouble(r146, "Similarity") * ((double) 100));
        L148:
            e = e;
            r164 = r152;
            goto L154
        L142:
            r162 = 2;
            goto L143
        L132:
            if (StringsKt.isBlank(r160) == true) goto L135;
            r161 = false;
        L126:
            r160 = null;
            goto L128
        L127:
            r160 = "";
            goto L128
        L119:
            r158 = 0;
            goto L120
        L115:
            r156 = null;
        L107:
            r153 = r9;
            goto L109
        L103:
            r152 = 0;
        L100:
            r151 = "";
        L95:
            r149 = "0";
            goto L96
        L84:
            r145 = false;
            goto L85
        L79:
            r144 = false;
        L186:
            return;
        L39:
            r124 = null;
            goto L41
        L18:
            r116 = false;
            goto L21
        L14:
            r109 = false;
        L176:
            e = move-exception;
            ALogger.e("LinkSpeechServerRecognizer", "parseSongInfo, json exception: " + e.getMessage());
        L9:
            r107 = null;
            goto L10
        L179:
            this.f70395a.i();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f70396a = null;

        static {
            f70396a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f70397a = null;

        static {
            f70397a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.e("LinkSpeechServerRecognizer", "room_song_changed api error");
        }
    }

    public static final class e implements ri6.c {
        public e() {
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkSpeechServerRecognizer f70398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f70399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f70400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f70401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f70402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f70403f;

        public f(LinkSpeechServerRecognizer r100, Ref.LongRef r101, int r102, Ref.LongRef r103, k r104, int r105) {
            this.f70398a = r100;
            this.f70399b = r101;
            this.f70400c = r102;
            this.f70401d = r103;
            this.f70402e = r104;
            this.f70403f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Ref.LongRef r102 = this.f70399b;
            long r103 = r102.element + 55;
            r102.element = r103;
            Long r104 = com.bytedance.android.live.liveinteract.utils.a.f78714a;
            Long r105 = Long.valueOf(r103);
            Long r106 = com.bytedance.android.live.liveinteract.utils.a.f78719f;
            com.bytedance.android.live.liveinteract.utils.a.f78719f = r105;
            if (r106 == r105) goto L7;
            Function0<Unit> r107 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
            if (r107 == null) goto L7;
            Unit r108 = r107.invoke();
        L7:
            LyricComponentImplManager r109 = this.f70398a.f70382n;
            if (r109 == null) goto L10;
            r109.j(this.f70399b.element);
        L10:
            long r110 = this.f70399b.element;
            if ((r110 - this.f70401d.element) <= this.f70400c) goto L14;
            this.f70398a.s(this.f70402e, r110, 1);
            this.f70401d.element = this.f70399b.element;
        L14:
            if (this.f70399b.element < this.f70403f) goto L17;
            this.f70398a.p();
            LinkSpeechServerRecognizer r111 = this.f70398a;
            r111.D = null;
            r111.s(null, 0, 0);
            return;
        }
    }

    static {
        K = SetsKt.setOf("FZSongKeBenXiuKai");
    }

    @Override // fd2.v
    public final void destroyEngine() {
        ALogger.i("LinkSpeechServerRecognizer", "destroyEngine");
        ((LinkedHashMap) this.f70392x).clear();
        p();
        s(null, 0, 0);
        AudienceLyricsRecognizer r100 = this.C;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f70370b = false;
        SpeechEngine r101 = this.f70374f;
        if (r101 == null) goto L8;
        r101.destroyEngine();
    L8:
        this.f70375g = -1;
        this.f70374f = null;
        SpeechEngine r102 = this.f70376h;
        if (r102 == null) goto L11;
        r102.destroyEngine();
    L11:
        this.f70377i = -1;
        this.f70376h = null;
        this.f70371c = null;
        this.f70372d = null;
        this.f70373e = null;
        this.f70368J.f70405b = null;
        this.f70378j.clear();
        Disposable r103 = this.f70380l;
        if (r103 != null) goto L14;
    L18:
        Disposable r104 = this.f70379k;
        if (r104 != null) goto L21;
    L25:
        Disposable r105 = this.f70381m;
        if (r105 != null) goto L28;
    L32:
        this.f70384p = null;
        v();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L40;
        this.I = false;
        IInteractService r106 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r106 == null) goto L41;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r107 = r106.getLinkUserInfoCenter();
        if (r107 == null) goto L42;
        r107.T4(this);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L28:
        if (r105.isDisposed() == true) goto L32;
        Disposable r108 = this.f70381m;
        if (r108 == null) goto L32;
        r108.dispose();
        goto L32
    L21:
        if (r104.isDisposed() == true) goto L25;
        Disposable r109 = this.f70379k;
        if (r109 == null) goto L25;
        r109.dispose();
        goto L25
    L14:
        if (r103.isDisposed() == true) goto L18;
        Disposable r110 = this.f70380l;
        if (r110 == null) goto L18;
        r110.dispose();
        goto L18
    }

    @Override // fd2.v
    public final void i() {
        ALogger.i("LinkSpeechServerRecognizer", "stopRecognize");
        int r100 = mb0.h.f512763a;
        boolean r101 = true;
        if (this.f70390v == true) goto L6;
        r101 = false;
    L6:
        k r102 = this.f70383o;
        if (r102 == null) goto L10;
        String r103 = r102.f70454b;
        if (r103 == null) goto L10;
    L11:
        if (r102 == null) goto L14;
        String r104 = r102.f70460h;
        if (r104 == null) goto L14;
    L15:
        if (r102 == null) goto L17;
        int r105 = r102.f70458f;
    L18:
        mb0.h.b(r101, r103, r104, Integer.valueOf(r105));
        this.f70390v = false;
        p();
        s(null, 0, 0);
        Disposable r106 = this.f70381m;
        if (r106 != null) goto L21;
    L25:
        Ref.IntRef r107 = new Ref.IntRef();
        r107.element = 10;
        this.f70381m = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r107));
        ALogger.i("LinkSpeechServerRecognizer", "onStop");
        v();
        this.f70383o = null;
        ((LinkedHashMap) this.f70392x).clear();
        r("0", false, 0L, 0L, 0);
        this.D = null;
        this.H = null;
        this.G = null;
        t r108 = this.f70384p;
        if (r108 == null) goto L28;
        r108.b("", 0);
    L28:
        Long r109 = com.bytedance.android.live.liveinteract.utils.a.f78714a;
        com.bytedance.android.live.liveinteract.utils.a.f78714a = null;
        if (r109 == null) goto L33;
        Function0<Unit> r110 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r110 == null) goto L33;
        Unit r111 = r110.invoke();
    L33:
        com.bytedance.android.live.liveinteract.utils.a.g(null);
        String r112 = com.bytedance.android.live.liveinteract.utils.a.f78727n;
        com.bytedance.android.live.liveinteract.utils.a.f78727n = null;
        if (r112 == null) goto L38;
        Function0<Unit> r113 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r113 == null) goto L38;
        Unit r114 = r113.invoke();
    L38:
        Integer r115 = com.bytedance.android.live.liveinteract.utils.a.f78716c;
        com.bytedance.android.live.liveinteract.utils.a.f78716c = null;
        if (r115 == null) goto L43;
        Function0<Unit> r116 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r116 == null) goto L43;
        Unit r117 = r116.invoke();
    L43:
        String r118 = com.bytedance.android.live.liveinteract.utils.a.f78717d;
        com.bytedance.android.live.liveinteract.utils.a.f78717d = null;
        if (r118 == null) goto L48;
        Function0<Unit> r119 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r119 == null) goto L48;
        Unit r120 = r119.invoke();
    L48:
        com.bytedance.android.live.liveinteract.utils.a.d(null);
        Long r121 = com.bytedance.android.live.liveinteract.utils.a.f78719f;
        com.bytedance.android.live.liveinteract.utils.a.f78719f = null;
        if (r121 == null) goto L53;
        Function0<Unit> r122 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r122 == null) goto L53;
        Unit r123 = r122.invoke();
    L53:
        Boolean r124 = com.bytedance.android.live.liveinteract.utils.a.f78720g;
        com.bytedance.android.live.liveinteract.utils.a.f78720g = null;
        if (r124 == null) goto L58;
        Function0<Unit> r125 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r125 == null) goto L58;
        Unit r126 = r125.invoke();
    L58:
        com.bytedance.android.live.liveinteract.utils.a.b(null);
        Boolean r127 = com.bytedance.android.live.liveinteract.utils.a.f78722i;
        com.bytedance.android.live.liveinteract.utils.a.f78722i = null;
        if (r127 == null) goto L63;
        Function0<Unit> r128 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r128 == null) goto L63;
        Unit r129 = r128.invoke();
    L63:
        com.bytedance.android.live.liveinteract.utils.a.a(null);
        com.bytedance.android.live.liveinteract.utils.a.c(null);
        String r130 = com.bytedance.android.live.liveinteract.utils.a.f78725l;
        com.bytedance.android.live.liveinteract.utils.a.f78725l = null;
        if (r130 == null) goto L68;
        Function0<Unit> r131 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r131 == null) goto L68;
        Unit r132 = r131.invoke();
    L68:
        com.bytedance.android.live.liveinteract.utils.a.e(null);
        com.bytedance.android.live.liveinteract.utils.a.f(null);
        Function0<Unit> r133 = com.bytedance.android.live.liveinteract.utils.a.f78729p;
        if (r133 == null) goto L72;
        Unit r134 = r133.invoke();
        return;
    L72:
        return;
    L21:
        if (r106.isDisposed() == true) goto L25;
        Disposable r135 = this.f70381m;
        if (r135 == null) goto L25;
        r135.dispose();
        goto L25
    L17:
        r105 = 0;
    L14:
        r104 = "";
    L10:
        r103 = "";
        goto L11
    }

    @Override // fd2.v
    public final void initEngine() {
        if (this.f70370b == true) goto L56;
        this.f70370b = true;
        SpeechEngine r100 = SpeechEngineGenerator.getInstance();
        Integer r101 = null;
        if (r100 == null) goto L30;
        this.f70376h = r100;
        this.f70377i = r100.createEngine();
        SpeechEngine r102 = this.f70376h;
        if (r102 == null) goto L10;
        r102.setOptionString("log_level", "TRACE");
    L10:
        SpeechEngine r103 = this.f70376h;
        if (r103 == null) goto L13;
        r103.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, "");
    L13:
        SpeechEngine r104 = this.f70376h;
        if (r104 == null) goto L16;
        r104.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, SpeechEngineDefines.COVERSONG_ENGINE);
    L16:
        SpeechEngine r105 = this.f70376h;
        if (r105 == null) goto L19;
        Integer r106 = Integer.valueOf(r105.initEngine());
    L20:
        if (r106 != null) goto L23;
    L24:
        ALogger.i("LinkSpeechServerRecognizer", "init cover engine error, ret = " + r106);
        goto L30
    L23:
        if (r106.intValue() != 0) goto L24;
        SpeechEngine r107 = this.f70376h;
        if (r107 == null) goto L28;
        Integer r108 = Integer.valueOf(r107.resetEngine(this.f70377i));
    L29:
        ALogger.i("LinkSpeechServerRecognizer", "reset cover engine, ret = " + r108);
        goto L30
    L28:
        r108 = null;
        goto L29
    L19:
        r106 = null;
    L30:
        SpeechEngine r109 = SpeechEngineGenerator.getInstance();
        if (r109 == null) goto L56;
        this.f70374f = r109;
        this.f70375g = r109.createEngine();
        SpeechEngine r110 = this.f70374f;
        if (r110 == null) goto L36;
        r110.setOptionString("log_level", "TRACE");
    L36:
        SpeechEngine r111 = this.f70374f;
        if (r111 == null) goto L39;
        r111.setOptionString(SpeechEngineDefines.PARAMS_KEY_DEBUG_PATH_STRING, "");
    L39:
        SpeechEngine r112 = this.f70374f;
        if (r112 == null) goto L42;
        r112.setOptionString(SpeechEngineDefines.PARAMS_KEY_ENGINE_NAME_STRING, SpeechEngineDefines.AFP_ENGINE);
    L42:
        SpeechEngine r113 = this.f70374f;
        if (r113 == null) goto L45;
        Integer r114 = Integer.valueOf(r113.initEngine());
    L46:
        if (r114 != null) goto L49;
    L50:
        ALogger.i("LinkSpeechServerRecognizer", "init fp engine error, ret = " + r114);
        goto L56
    L49:
        if (r114.intValue() != 0) goto L50;
        SpeechEngine r115 = this.f70374f;
        if (r115 == null) goto L54;
        r101 = Integer.valueOf(r115.resetEngine(this.f70375g));
    L54:
        ALogger.i("LinkSpeechServerRecognizer", "reset fp engine, ret = " + r101);
        goto L56
    L45:
        r114 = null;
    L56:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L62;
        IInteractService r116 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r116 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r117 = r116.getLinkUserInfoCenter();
        if (r117 == null) goto L62;
        r117.Q4(this);
    L62:
        this.E.add(xs2.b.a().b(h0.class).subscribe(new b(this)));
    }

    public final void p() {
        ALogger.i("LinkSpeechServerRecognizer", "anchor hideLyrics");
        Disposable r100 = this.f70380l;
        if (r100 != null) goto L5;
    L9:
        LyricComponentImplManager r101 = this.f70382n;
        if (r101 == null) goto L14;
        jg4.f r102 = r101.f202972g.f202991d;
        if (r102 == null) goto L14;
        r102.reset();
    L14:
        t r103 = this.f70384p;
        if (r103 == null) goto L17;
        r103.a();
    L17:
        this.f70391w = false;
        SpeechLyricsView r104 = this.f70369a;
        if (r104 == null) goto L22;
        TextView r105 = r104.getAiTipsTextView();
        if (r105 == null) goto L22;
        r105.setVisibility(8);
    L22:
        SpeechLyricsView r106 = this.f70369a;
        if (r106 == null) goto L27;
        ImageView r107 = r106.getAiTagView();
        if (r107 == null) goto L27;
        r107.setVisibility(8);
    L27:
        this.f70383o = null;
        this.f70368J.f70405b = null;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r108 = this.f70380l;
        if (r108 == null) goto L9;
        r108.dispose();
        goto L9
    }

    public final void t() {
        SpeechLyricsView r100 = this.f70369a;
        ImageView r101 = null;
        if (r100 == null) goto L5;
        TextView r102 = r100.getAiTipsTextView();
    L6:
        SpeechLyricsView r103 = this.f70369a;
        if (r103 == null) goto L9;
        r101 = r103.getAiTagView();
    L9:
        if (r102 == null) goto L11;
        r102.setVisibility(0);
    L11:
        if (r101 == null) goto L14;
        r101.setVisibility(8);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void v() {
        Disposable r100 = this.B;
        if (r100 != null) goto L5;
    L9:
        this.B = null;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r101 = this.B;
        if (r101 == null) goto L9;
        r101.dispose();
        goto L9
    }

    public LinkSpeechServerRecognizer() {
        this.f70378j = new CompositeDisposable();
        this.f70385q = LazyKt.lazy(LinkSpeechServerRecognizer$maxBufferSize$2.INSTANCE);
        this.f70386r = new ArrayBlockingQueue(3072);
        this.f70387s = new AtomicInteger(0);
        this.f70388t = new AtomicBoolean(true);
        this.f70389u = new AtomicBoolean(true);
        this.f70392x = new LinkedHashMap();
        this.f70393y = LazyKt.lazy(LinkSpeechServerRecognizer$enableGuestStream$2.INSTANCE);
        this.f70394z = LazyKt.lazy(new LinkSpeechServerRecognizer$halfMaxBufferSize$2(this));
        this.A = LazyKt.lazy(LinkSpeechServerRecognizer$enableResultCheck$2.INSTANCE);
        this.E = new CompositeDisposable();
        this.f70368J = new LyricFontHelper();
    }

    @Override // fd2.v
    public final boolean c() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L12;
        AudienceLyricsRecognizer r100 = this.C;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.f70326f != true) goto L10;
        return true;
    L12:
        return this.f70391w;
    }

    @Override // fd2.v
    public final boolean h() {
        return this.f70390v;
    }

    @Override // fd2.v
    public final void f(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ALogger.i("LinkSpeechServerRecognizer", "detachLyricsView");
        r100.removeView(this.f70369a);
    }

    @Override // fd2.v
    public final void m(com.bytedance.android.live.liveinteract.interactivesong.speech.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ALogger.i("LinkSpeechServerRecognizer", "setRecognizeResultListener");
        this.f70384p = r100;
        AudienceLyricsRecognizer r101 = this.C;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f70330j = r100;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r100) {
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getCurrentUiLayout());
    L6:
        if (r102 != null) goto L9;
    L10:
        if (r102 != null) goto L13;
    L14:
        if (r102 != null) goto L17;
        return;
    L17:
        if (r102.intValue() == 27) goto L19;
        return;
    L19:
        boolean r103 = false;
        if (r100 == null) goto L30;
        Iterator<T> r104 = r100.iterator();
    L23:
        if (r104.hasNext() == false) goto L30;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r104.next();
        if (r105.getUserPosition() != 0) goto L23;
        if (r105.getLinkType() != 1) goto L23;
        r103 = true;
    L30:
        if (this.I == r103) goto L50;
        rb0.b r106 = this.H;
        this.I = r103;
        if (r103 == false) goto L34;
        long r107 = com.bytedance.android.live.ktv.common.util.a.a().getRoomId();
        this.E.add(((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).roomSongChanged(r107, "", false, null, null, 2).subscribe(com.bytedance.android.live.ktv.common.speech.f.f70446a, g.f70447a));
        return;
    L34:
        if (r106 == null) goto L36;
        r(String.valueOf(r106.f536899a), r106.f536900b, r106.f536901c, r106.f536902d, 1);
        return;
    L36:
        IInteractService r108 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r108 != null) goto L39;
        return;
    L39:
        if (r108.isAIMVStage() != true) goto L54;
        r("0", false, null, null, 1);
        return;
    L54:
        return;
    L50:
        return;
    L13:
        if (r102.intValue() == 21) goto L19;
    L9:
        if (r102.intValue() == 30) goto L19;
    L5:
        r102 = null;
        goto L6
    }

    @Override // fd2.v
    public final void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        AudienceLyricsRecognizer r101 = this.C;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void q(k r100) {
        if (this.f70390v == true) goto L5;
        return;
    L5:
        Disposable r101 = this.f70381m;
        if (r101 != null) goto L8;
    L12:
        ALogger.i("LinkSpeechServerRecognizer", "recognizeSuccess, songName: " + r100.f70460h + ", similarity: " + r100.f70458f);
        u(r100, (System.currentTimeMillis() - r100.f70459g) + ((long) (r100.f70456d * ((double) 1000))), r100.f70457e * 1000);
        String r102 = r100.f70455c;
        String r103 = r100.f70454b;
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        String r104 = n.c(r102, r103);
        Objects.toString(this.f70382n);
        LyricComponentImplManager r105 = this.f70382n;
        if (r105 == null) goto L18;
        LyricsDisplayConfig r106 = r105.f202971f;
    L19:
        Objects.toString(r106);
        LyricComponentImplManager r107 = this.f70382n;
        if (r107 == null) goto L26;
        LyricsDisplayConfig r108 = r107.f202971f;
        if (r108 == null) goto L26;
        this.f70368J.a(r100.f70465m, r108);
        jg4.j r109 = n.a(r100.f70455c, r104, r108);
        r109.f498988d = r100.f70461i;
        LyricComponentImplManager r110 = this.f70382n;
        if (r110 == null) goto L26;
        r110.d(r109);
    L26:
        t();
        t r111 = this.f70384p;
        if (r111 == null) goto L29;
        r111.c();
    L29:
        this.f70391w = true;
        String r112 = s1.B(R.string.ttlive_ktv_ai_lyrics_recognition_success);
        if (PadConfigUtils.c() == true) goto L32;
        f2.c(r112, 0);
    L32:
        JSONObject r113 = new JSONObject();
        r113.put("toast", r112);
        JSONObject r114 = new JSONObject();
        r114.put("song_recognition_result", r113);
        ei6.a r115 = this.f70372d;
        if (r115 == null) goto L37;
        si6.b r116 = r115.b();
        if (r116 == null) goto L37;
        r116.n(bj6.a.b(this.f70372d), r114.toString());
    L37:
        String r117 = r100.f70454b;
        int r118 = r100.getType();
        HashMap r119 = new HashMap();
        r119.put("is_recognition_success", "1");
        if (r118 != 0) goto L40;
        String r120 = "fp";
    L41:
        r119.put("recognition_type", r120);
        if (r117 != null) goto L44;
    L47:
        boolean r121 = true;
    L48:
        if (r121 == true) goto L50;
        r119.put("recognition_song_id", r117);
    L50:
        r119.putAll(this.f70392x);
        j0.l().sendLog("livesdk_anchor_ai_lyric_recognition", r119, new Object[]{IRoom.class});
        this.f70383o = r100;
        if (this.F == true) goto L53;
        return;
    L53:
        if (((Boolean) this.f70393y.getValue()).booleanValue() == true) goto L55;
        return;
    L55:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L62;
        t r122 = this.f70384p;
        if (r122 == null) goto L63;
        r122.d(true);
        return;
    L63:
        return;
    L62:
        return;
    L44:
        if (r117.length() == 0) goto L47;
        r121 = false;
        goto L48
    L40:
        r120 = "cover";
        goto L41
    L18:
        r106 = null;
        goto L19
    L8:
        if (r101.isDisposed() == true) goto L12;
        Disposable r123 = this.f70381m;
        if (r123 == null) goto L12;
        r123.dispose();
        goto L12
    }

    @Override // fd2.v
    public final void j(ei6.a r100, com.bytedance.android.live.pushstream.d r101, kd2.a r102) {
        Intrinsics.checkNotNullParameter(r102, "recognitionParams");
        ALogger.i("LinkSpeechServerRecognizer", "startRecognize, maxBufferSize: " + ((Number) this.f70385q.getValue()).intValue() + ", isRetry: " + r102.f502713c + ", interactId: " + r102.f502715e);
        int r103 = mb0.h.f512763a;
        mb0.h.a(((Number) this.f70385q.getValue()).intValue(), r102.f502713c, r102.f502715e, r102.f502714d);
        this.f70390v = true;
        if (r102.f502713c == true) goto L5;
        this.f70383o = null;
    L5:
        this.f70388t.set(true);
        this.f70389u.set(true);
        this.f70387s.set(0);
        this.f70386r.clear();
        this.f70371c = r101;
        this.f70372d = r100;
        ((LinkedHashMap) this.f70392x).clear();
        this.F = r102.f502714d;
        this.G = r102.f502715e;
        this.f70373e = new e();
        if (((Boolean) this.f70393y.getValue()).booleanValue() == false) goto L11;
        if (r102.f502714d == false) goto L11;
        LiveWrappedAudioFrameCallbackMethod r104 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_RECORD;
    L14:
        if (r100 == null) goto L19;
        ri6.b r105 = r100.r();
        if (r105 == null) goto L19;
        r105.i(r104, LiveWrappedAudioSampleRate.AUDIO_SAMPLE_RATE_8000, LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO, this.f70373e);
    L19:
        if (r102.f502713c == true) goto L22;
        ALogger.i("LinkSpeechServerRecognizer", WidgetCostModule.TYPE_ON_START);
        v();
        this.B = Observable.interval(KtvSettingHelper.A().o(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r102), i.f70450a);
        return;
    L22:
        return;
    L11:
        if (((Boolean) this.f70393y.getValue()).booleanValue() == false) goto L13;
        r104 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_REMOTE_USER;
        goto L14
    L13:
        r104 = LiveWrappedAudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_MIXED;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(k r110, long r111, int r112) {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        int r101 = 0;
        if (r100 == null) goto L5;
        boolean r102 = r100.isAIMVStage();
    L6:
        final JSONObject r103 = new JSONObject();
        if (r110 == null) goto L13;
        r103.put("lyrics_url", r110.f70455c);
        r103.put("song_id", r110.f70454b);
        r103.put(HistoryTableOperate.HISTORY_PLAY_TIME, r111);
        r103.put("duration", r110.f70457e);
        r103.put("song_title", r110.f70460h);
        r103.put("lyric_type", r110.f70461i);
        if (r102 == false) goto L13;
        if (r2.a(r110.f70465m) == false) goto L13;
        r103.put("font_info", r110.f70465m);
    L13:
        r103.put("state", r112);
        String r113 = this.G;
        if (r113 == null) goto L16;
        r103.put("singer_linkmic_id", r113);
    L16:
        if (r110 == null) goto L21;
        String r114 = r110.f70463k;
        if (r114 == null) goto L21;
        if (r103.put("emo_tag", r114) == null) goto L21;
    L23:
        if (r110 == null) goto L38;
        List<MusicInterval> r104 = r110.f70464l;
        if (r104 == null) goto L38;
        Iterator<T> r105 = r104.iterator();
        String r106 = "";
        int r107 = 0;
    L28:
        if (r105.hasNext() == false) goto L36;
        MusicInterval r108 = (MusicInterval) r105.next();
        r106 = r106 + '[' + r108.getStartMs() + ',' + n8.a(r108) + "], ";
        long r109 = r108.getStartMs();
        long r115 = n8.a(r108);
        if (r109 > r111) goto L28;
        if (r115 < r111) goto L28;
        r107 = 1;
        goto L28
    L36:
        if (r103.put("refrain", r107) == null) goto L39;
    L40:
        boolean r116 = r107;
        t r117 = this.f70384p;
        if (r117 == null) goto L48;
        if (r110 == null) goto L44;
        String r118 = r110.f70463k;
    L45:
        if (r116 != 1) goto L47;
        r101 = 1;
    L47:
        r117.b(r118, Integer.valueOf(r101));
        goto L48
    L44:
        r118 = null;
    L48:
        com.bytedance.android.live.pushstream.d r119 = this.f70371c;
        if (r119 == null) goto L51;
        r119.c1("music_recognition_result", r103, 1, false, false);
    L51:
        Long r120 = com.bytedance.android.live.liveinteract.utils.a.f78714a;
        com.bytedance.android.live.liveinteract.utils.a.b(Boolean.valueOf(r116));
        return;
    L39:
        new LinkSpeechServerRecognizer$sendSei$5(r103);
    L38:
        r107 = 0;
    L21:
        new LinkSpeechServerRecognizer$sendSei$3(r103);
        goto L23
    L5:
        r102 = false;
        goto L6
    }

    public final void u(k r100, long r101, int r110) {
        Ref.LongRef r102 = new Ref.LongRef();
        r102.element = ((long) KtvSettingHelper.A().l()) + r101;
        Disposable r103 = this.f70380l;
        if (r103 != null) goto L5;
    L9:
        int r104 = KtvSettingHelper.A().m();
        Ref.LongRef r105 = new Ref.LongRef();
        r105.element = 0;
        ALogger.e("LinkSpeechServerRecognizer", "startTimer, currentProgress=" + r101 + ", progress=" + r102.element + ", songDuration=" + r110);
        this.f70380l = du2.a.b(0, 55, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r102, r104, r105, r100, r110));
        return;
    L5:
        if (r103.isDisposed() == true) goto L9;
        Disposable r106 = this.f70380l;
        if (r106 == null) goto L9;
        r106.dispose();
        goto L9
    }

    @Override // fd2.v
    public final void o(Context r210, ConstraintLayout r211, boolean r212, int r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "parent");
        ALogger.i("LinkSpeechServerRecognizer", "attachLyricsView, lyricsContainerView=" + this.f70369a);
        SpeechLyricsView r100 = this.f70369a;
        TextView r101 = null;
        if (r100 == null) goto L11;
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == true) goto L7;
        r102 = null;
    L7:
        ViewGroup r103 = (ViewGroup) r102;
        if (r103 == null) goto L10;
        r103.removeView(this.f70369a);
    L10:
        this.f70369a = null;
    L11:
        this.f70369a = new SpeechLyricsView(r210, null, 6, 0);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-1, -1);
        r211.addView(this.f70369a);
        r104.topToTop = 0;
        r104.leftToLeft = 0;
        r104.rightToRight = 0;
        r104.bottomToBottom = 0;
        SpeechLyricsView r105 = this.f70369a;
        if (r105 == null) goto L14;
        r105.setLayoutParams(r104);
    L14:
        this.f70368J.f70405b = null;
        SpeechLyricsView r106 = this.f70369a;
        if (r106 == null) goto L17;
        ViewPainter r107 = r106.getLyricsView();
    L19:
        if (r107 == null) goto L33;
        r107.setVisibility(0);
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ConstraintLayout.LayoutParams) == true) goto L23;
        r108 = null;
    L23:
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
        if (r109 == null) goto L26;
        ((ViewGroup.MarginLayoutParams) r109).height = UtilityKotlinExtentionsKt.i(48);
    L26:
        r107.setLayoutParams(r109);
        LyricsDisplayConfig r110 = new LyricsDisplayConfig();
        float r111 = UtilityKotlinExtentionsKt.h(16.0f);
        r110.a();
        r110.f203015j = Float.valueOf(0.0f);
        r110.f203017l.setTextSize(r111);
        r110.f203016k.setTextSize(r111);
        r110.f203014i.setTextSize(r111);
        r110.f203012g = 2;
        if (r213 == 30) goto L31;
        if (r213 == 26) goto L31;
        Paint.Align r112 = Paint.Align.LEFT;
    L32:
        r110.e(r112, 1);
        Paint.FontMetrics r113 = r110.f203017l.getFontMetrics();
        float r114 = (UtilityKotlinExtentionsKt.i(24) + r111) / 2.0f;
        r110.f203022q = new LinearGradient(0.0f, r114 + r113.ascent, 0.0f, r114 + r113.descent, ColorProtector.parseColor("#FFFFE267"), ColorProtector.parseColor("#FFFF994F"), Shader.TileMode.CLAMP);
        r110.f203013h.f489730b = 0.0f;
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r107, "painter");
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f70382n = new LyricComponentImplManager(r210, r110, new com.bytedance.component.lyric.a(r210, r107));
    L31:
        r112 = Paint.Align.CENTER;
    L33:
        SpeechLyricsView r115 = this.f70369a;
        if (r115 == null) goto L36;
        r101 = r115.getAiTipsTextView();
    L36:
        if (r213 == 30) goto L41;
        if (r213 == 26) goto L41;
        if (r101 == null) goto L43;
        r101.setGravity(19);
    L43:
        k r116 = this.f70383o;
        if (r116 == null) goto L58;
        u(r116, (System.currentTimeMillis() - r116.f70459g) + ((long) (r116.f70456d * ((double) 1000))), r116.f70457e * 1000);
        String r117 = r116.f70455c;
        String r118 = r116.f70454b;
        if (r118 != null) goto L49;
        r118 = "";
    L49:
        String r119 = n.c(r117, r118);
        LyricComponentImplManager r120 = this.f70382n;
        if (r120 == null) goto L56;
        LyricsDisplayConfig r121 = r120.f202971f;
        if (r121 == null) goto L56;
        this.f70368J.a(r116.f70465m, r121);
        jg4.j r122 = n.a(r116.f70455c, r119, r121);
        r122.f498988d = r116.f70461i;
        LyricComponentImplManager r123 = this.f70382n;
        if (r123 == null) goto L56;
        r123.d(r122);
    L56:
        t();
    L58:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L68;
        this.C = new AudienceLyricsRecognizer(this.f70382n, this.f70384p, this.f70369a, r212, true);
        Disposable r124 = this.f70379k;
        if (r124 != null) goto L62;
    L66:
        this.f70379k = xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.ktv.common.speech.e(this));
        return;
    L62:
        if (r124.isDisposed() == true) goto L66;
        Disposable r125 = this.f70379k;
        if (r125 == null) goto L66;
        r125.dispose();
        goto L66
    L68:
        return;
    L41:
        if (r101 == null) goto L43;
        r101.setGravity(17);
        goto L43
    L17:
        r107 = null;
        goto L19
    }

    public final void r(String r110, boolean r111, Long r112, Long r113, int r114) {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.isAIMVStage();
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        if (r110 != null) goto L10;
        return;
    L10:
        rb0.b r102 = new rb0.b();
        r102.f536899a = Long.valueOf(CastLongProtector.parseLong(r110));
        r102.f536900b = r111;
        r102.f536901c = r112;
        r102.f536902d = r113;
        this.H = r102;
        if (this.I == false) goto L13;
        return;
    L13:
        long r103 = com.bytedance.android.live.ktv.common.util.a.a().getRoomId();
        this.E.add(((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).roomSongChanged(r103, r110, r111, r112, r113, r114).subscribe(c.f70396a, d.f70397a));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
