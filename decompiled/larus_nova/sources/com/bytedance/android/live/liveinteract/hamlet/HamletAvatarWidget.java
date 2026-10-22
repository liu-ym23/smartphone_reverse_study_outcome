package com.bytedance.android.live.liveinteract.hamlet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.d2;
import com.bytedance.android.live.base.model.message.e1;
import com.bytedance.android.live.base.model.message.i3;
import com.bytedance.android.live.base.model.message.w5;
import com.bytedance.android.live.base.model.message.x5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.hamlet.api.HamletAvatarApi;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.multicamera.api.MultiCameraApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.x0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.xplay.basic.api.XplayBasicMessageType;
import com.bytedance.android.live.xplay.basic.api.XplayBasicState;
import com.bytedance.android.live.xplay.basic.api.XplayException;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.config.f7;
import com.bytedance.android.livesdk.config.ig;
import com.bytedance.android.livesdk.config.jg;
import com.bytedance.android.livesdk.config.uz;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamSycnInfoConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.android.livesdk.message.model.LinkmicEcologyMessage;
import com.bytedance.android.livesdk.message.model.g9;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletExternalRenderConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletLiveMediaMockConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import j40.f4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/HamletAvatarWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lgd0/g;", "Lvlc/l;", "Lgd1/b$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HamletAvatarWidget extends PlatformMultiLinkWidget implements gd0.g, vlc.l, gd1.b.a {
    public static final /* synthetic */ int T = 0;
    public boolean A;
    public MixStreamType B;
    public boolean C;
    public long D;
    public boolean E;
    public String F;
    public x0 G;
    public final Map<String, df0.a> H;
    public final y I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final x f73437J;
    public final g0 K;
    public long L;
    public long M;
    public long N;
    public final w O;
    public final h0 P;
    public final ViewGroup Q;
    public final Function0<hg6.g> R;
    public final Function0<he0.b.a> S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f73438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.xplay.f f73439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gd1.a f73440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gd1.b f73441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f73442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HamletAvatarContext f73443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> f73444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ef0.c f73445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gf0.d f73446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f73447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public cf0.b f73448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f73449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f73450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f73451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.xplay.basic.c f73452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Handler f73453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final r f73454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c0 f73455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g f73456s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public x5 f73457t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.model.multicamera.a> f73458u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f73459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LinkedList<String> f73460w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Disposable f73461x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LiveWrappedStreamSycnInfoConfig f73462y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Disposable f73463z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f73466a = null;

        static {
            f73466a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            ff0.d r102 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(2, "deleteAllExtraCamera successed", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("log_id", String.valueOf(r101.logId)), TuplesKt.to(VSConstants.VS_CAMERA_ID, String.valueOf(r101))}), 12);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f73467a = null;

        static {
            f73467a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ff0.d r102 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(2, "deleteAllExtraCamera failed", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("log_id", String.valueOf(ff0.c.a(r101))), TuplesKt.to(VSConstants.VS_CAMERA_ID, String.valueOf(r101))}), 12);
        }
    }

    public static final class d implements gf0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HamletAvatarWidget f73468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x5 f73469b;

        @Override // gf0.a
        public final boolean a() {
            return HamletAvatarWidget.wq(this.f73468a);
        }

        @Override // gf0.a
        public final void b() {
            HamletAvatarWidget.xq(this.f73468a);
        }

        @Override // gf0.a
        public final void c(long r100) {
            cf0.b r101 = this.f73468a.f73448k;
            if (r101 == null) goto L17;
            cf0.a<Long> r102 = r101.f23499a;
            Long r103 = Long.valueOf(r100);
        L6:
            if (r102.f23497b.get() < r102.f23498c) goto L10;
            if (r102.f23496a.poll() == null) goto L6;
            r102.f23497b.decrementAndGet();
            goto L6
        L10:
            r102.f23496a.offer(r103);
            r102.f23497b.incrementAndGet();
            return;
        }

        public d(HamletAvatarWidget r100, x5 r101) {
            this.f73468a = r100;
            this.f73469b = r101;
        }
    }

    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f73470a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.f73470a.getHeight() <= 0) goto L27;
            this.f73470a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int r100 = this.f73470a.getHeight();
            boolean r101 = ff0.c.f476645a;
            int r102 = Math.max((int) ((r100 * 9.0f) / 16), s1.y());
            ViewGroup r103 = this.f73470a;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            ViewGroup.LayoutParams r105 = null;
            if (r104 == null) goto L24;
            r104.height = r100;
            r104.width = r102;
            if (MultiLinkLoadWidgetUtils.g() == false) goto L23;
            ViewGroup r106 = this.f73470a;
            if (r106 == null) goto L13;
            ViewGroup r107 = UtilityKotlinExtentionsKt.p(r106);
            if (r107 == null) goto L13;
            int r108 = r107.getWidth();
        L14:
            if (r108 <= 0) goto L23;
            if (r102 <= r108) goto L23;
            if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
            r105 = r104;
        L20:
            ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r105;
            if (r109 == null) goto L23;
            r109.leftMargin = (r108 - r102) / 2;
        L13:
            r108 = 0;
        L23:
            Unit r110 = Unit.INSTANCE;
        L25:
            r103.setLayoutParams(r104);
            return;
        L24:
            r104 = null;
            goto L25
        }

        public e(ViewGroup r100) {
            this.f73470a = r100;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f73471a;

        public f(int r100) {
            this.f73471a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            ff0.d r102 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "xplay_init_callback_result", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("init_status", String.valueOf(this.f73471a))}), 12);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f73472a;

        public g(int r100) {
            this.f73472a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ff0.d r101 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "xplay_init_callback_result", -1, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("init_status", String.valueOf(this.f73472a)), TuplesKt.to("log_id", ff0.c.a((Throwable) r100))}), 8);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f73473a;

        public h(long r100) {
            this.f73473a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            ff0.d r102 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "notifyAvatarChange", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "success"), TuplesKt.to("avtID", String.valueOf(this.f73473a))}), 12);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f73474a = null;

        static {
            f73474a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ff0.d r101 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "notifyAvatarChange", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "failed"), TuplesKt.to("logId", String.valueOf(ff0.c.a((Throwable) r100)))}), 12);
        }
    }

    public static final class j implements gd1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HamletAvatarWidget f73475a;

        public j(HamletAvatarWidget r100) {
            this.f73475a = r100;
        }

        @Override // gd1.c
        public final void onCloudPlayerList(List<String> r110) {
            Intrinsics.checkNotNullParameter(r110, "players");
            ff0.d r100 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "onCloudPlayerList ", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("players", String.valueOf(GsonProtectorUtils.toJson(GsonHelper.get(), r110)))}), 12);
            Iterator<T> r111 = r110.iterator();
        L4:
            if (r111.hasNext() == false) goto L12;
            String r101 = (String) r111.next();
            HamletAvatarContext r102 = this.f73475a.f73443f;
            if (r102 == null) goto L8;
            boolean r103 = r102.isXplayAudioEnable();
        L9:
            gd1.a r104 = this.f73475a.f73440c;
            if (r104 == null) goto L4;
            r104.enableAudio(r101, r103);
            goto L4
        L8:
            r103 = false;
            goto L9
        }

        @Override // gd1.c
        public final void a(String r100, String r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(this.f73475a.f73459v, r100) == false) goto L10;
            gf0.d r102 = this.f73475a.f73446i;
            if (r102 == null) goto L11;
            r102.a(r101);
            return;
        L11:
            return;
        }

        @Override // gd1.c
        public final void b(String r100, com.bytedance.android.live.broadcastgame.api.xplay.b r101) {
            ff0.d r102 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "onFirstFrame ", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("playerName", String.valueOf(r100)), TuplesKt.to("cloudRtcInfo", String.valueOf(GsonProtectorUtils.toJson(GsonHelper.get(), r101)))}), 12);
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HamletAvatarWidget f73476a;

        public k(HamletAvatarWidget r100) {
            this.f73476a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            XplayException r111 = (XplayException) r110;
            HamletAvatarContext r100 = this.f73476a.f73443f;
            if (r100 == null) goto L5;
            int r101 = r100.getXplayRetryCount();
        L6:
            ff0.d r102 = ff0.d.f476647a;
            Pair[] r103 = new Pair[3];
            if (r111 == null) goto L9;
            boolean r104 = r111.getRetryable();
        L10:
            r103[0] = TuplesKt.to("retryable", String.valueOf(r104));
            r103[1] = TuplesKt.to("retry_count", String.valueOf(r101));
            if (r111 == null) goto L15;
            gd1.d r105 = r111.getErrorInfo();
            if (r105 == null) goto L15;
            int r106 = r105.a();
        L16:
            r103[2] = TuplesKt.to("error_code", String.valueOf(r106));
            com.bytedance.android.live.liveinteract.utils.j.a(1, "game_exception", 0, null, MapsKt.mutableMapOf(r103), 12);
            if (r111 != null) goto L19;
            return;
        L19:
            if (r111.getRetryable() != true) goto L36;
            HamletAvatarWidget r112 = this.f73476a;
            HamletAvatarContext r107 = r112.f73443f;
            if (r107 == null) goto L23;
            int r108 = r107.getXplayRetryCount();
        L24:
            StringBuilder r109 = new StringBuilder("retryStartXplayIfCan, currentRetryCount=");
            r109.append(r108);
            r109.append(", maxCount=");
            boolean r113 = ff0.c.f476645a;
            r109.append(vm2.d.I().getXplayMaxRetryCount());
            ALogger.i("HamletAvatar", r109.toString());
            if (r108 >= vm2.d.I().getXplayMaxRetryCount()) goto L30;
            HamletAvatarContext r114 = r112.f73443f;
            if (r114 == null) goto L29;
            r114.setXplayRetryCount(r108 + 1);
        L29:
            r112.f73453p.removeCallbacks(r112.f73455r);
            r112.f73453p.postDelayed(r112.f73455r, ((long) (r108 + 1)) * 1000);
            return;
        L30:
            HamletAvatarContext r115 = r112.f73443f;
            if (r115 == null) goto L33;
            r115.setXplayRetryCount(0);
        L33:
            r112.Yq(1);
            return;
        L23:
            r108 = 0;
            goto L24
        L36:
            return;
        L15:
            r106 = 0;
            goto L16
        L9:
            r104 = false;
            goto L10
        L5:
            r101 = 0;
            goto L6
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HamletAvatarWidget f73477a;

        public l(HamletAvatarWidget r100) {
            this.f73477a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            XplayBasicState r101 = (XplayBasicState) r100;
            ALogger.i("HamletAvatar", "xplayStateChange, xplayState=" + r101);
            if (r101 == null) goto L43;
            int r102 = com.bytedance.android.live.liveinteract.hamlet.b.f73492a[r101.ordinal()];
            if (r102 != 1) goto L8;
            HamletAvatarWidget r103 = this.f73477a;
            int r104 = HamletAvatarWidget.T;
            r103.getClass();
            ff0.d r105 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "game_loading", 0, null, null, 28);
            HamletAvatarContext r106 = r103.f73443f;
            if (r106 == null) goto L41;
            com.bytedance.live.datacontext.n<Integer> r107 = r106.getCurrentState();
            if (r107 == null) goto L42;
            r107.setValue(1);
            return;
        L42:
            return;
        L41:
            return;
        L8:
            if (r102 != 2) goto L10;
            HamletAvatarWidget r108 = this.f73477a;
            int r109 = HamletAvatarWidget.T;
            r108.getClass();
            ff0.d r110 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "game_loaded", 0, null, null, 28);
            HamletAvatarContext r111 = r108.f73443f;
            if (r111 == null) goto L38;
            com.bytedance.live.datacontext.n<Integer> r112 = r111.getCurrentState();
            if (r112 == null) goto L39;
            r112.setValue(2);
            return;
        L39:
            return;
        L38:
            return;
        L10:
            if (r102 != 3) goto L12;
            HamletAvatarWidget r113 = this.f73477a;
            int r114 = HamletAvatarWidget.T;
            r113.br();
            return;
        L12:
            if (r102 != 4) goto L44;
            HamletAvatarWidget r115 = this.f73477a;
            int r116 = HamletAvatarWidget.T;
            r115.getClass();
            ff0.d r117 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(2, "game_stopped", 0, null, null, 28);
            HamletAvatarContext r118 = r115.f73443f;
            if (r118 == null) goto L19;
            com.bytedance.live.datacontext.n<Integer> r119 = r118.getCurrentState();
            if (r119 == null) goto L19;
            r119.setValue(4);
        L19:
            HamletAvatarContext r120 = r115.f73443f;
            if (r120 == null) goto L22;
            boolean r121 = r120.getAudienceMultiCamera();
        L23:
            r115.Tq(r121);
            return;
        L22:
            r121 = false;
            goto L23
        L44:
            return;
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HamletAvatarWidget f73478a;

        public m(HamletAvatarWidget r100) {
            this.f73478a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.live.broadcastgame.api.xplay.g r111 = (com.bytedance.android.live.broadcastgame.api.xplay.g) r110;
            HamletAvatarWidget r100 = this.f73478a;
            HamletAvatarContext r101 = r100.f73443f;
            if (r101 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r102 = r101.isStreamRending();
            if (r102 == null) goto L9;
            Boolean r103 = r102.getValue();
            if (r103 == null) goto L9;
            boolean r104 = r103.booleanValue();
        L11:
            if (r100.f73450m == true) goto L18;
            boolean r105 = ff0.c.f476645a;
            if (vm2.d.J().getEnable() == false) goto L18;
            r100.f73450m = true;
            HamletExternalRenderConfig r106 = vm2.d.J();
            ff0.d r107 = ff0.d.f476647a;
            com.bytedance.android.live.liveinteract.utils.j.a(1, "set_video_exteral_config", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sharpness", String.valueOf(r106.getSharpness())), TuplesKt.to("contrast", String.valueOf(r106.getContrast())), TuplesKt.to("brightness", String.valueOf(r106.getBrightness()))}), 12);
            gd1.a r108 = r100.f73440c;
            if (r108 == null) goto L18;
            r108.f(r106.getSharpness(), r106.getContrast(), r106.getBrightness());
        L18:
            if (gh0.a.d() == false) goto L27;
            if (r104 == false) goto L27;
            HamletAvatarContext r109 = r100.f73443f;
            if (r109 == null) goto L26;
            com.bytedance.live.datacontext.m<Boolean> r112 = r109.isMultiAvatarMode();
            if (r112 == null) goto L26;
            if (r112.getValue().booleanValue() == true) goto L27;
        L26:
            ef0.c r113 = r100.f73445h;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r111, "frame");
            r113.f472414a.a(r111);
        L27:
            String r114 = r111.b().getSEIInfo();
            if (r114 == null) goto L38;
            gf0.d r115 = r100.f73446i;     // Catch: Exception -> L33
            if (r115 == null) goto L39;
            r115.a(r114);     // Catch: Exception -> L33
            return;
        L39:
            return;
        L33:
            e = move-exception;
            ALogger.e("HamletAvatar", "onXplaySeiProcess parse exception=" + Log.getStackTraceString(e));
            return;
        L38:
            return;
        L9:
            r104 = false;
            goto L11
        }
    }

    public static final class n<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f73479a = null;

        static {
            f73479a = new n();
        }

        public n() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("HamletAvatar", "onXplayVideoFrame Error, " + Log.getStackTraceString((Throwable) r100));
        }
    }

    public static final class o<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HamletAvatarWidget f73480a;

        public o(HamletAvatarWidget r100) {
            this.f73480a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            LinkmicEcologyMessage.XPlayInitContent r101 = ((com.bytedance.android.live.liveinteract.hamlet.model.j) ((com.bytedance.android.live.network.response.e) r100).data).a();
            if (r101 == null) goto L6;
            boolean r102 = !hd0.c.f().h();
            HamletAvatarWidget r103 = this.f73480a;
            int r104 = HamletAvatarWidget.T;
            r103.Kq(r101, true, false, r102);
            return;
        }
    }

    public static final class p<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f73481a = null;

        static {
            f73481a = new p();
        }

        public p() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    public final void Bq() {
        List<com.bytedance.android.livesdk.chatroom.model.multicamera.a> r100 = this.f73458u;
        if (r100 == null) goto L12;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L20;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r102 = (com.bytedance.android.livesdk.chatroom.model.multicamera.a) r101.next();
        if (r102 == null) goto L6;
        Long r103 = r102.getCameraId();
        if (r103 == null) goto L6;
        Cq(Long.valueOf(r103.longValue()));
        goto L6
    L20:
        return;
    }

    public final cg6.a Eq() {
        return (cg6.a) getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // gd0.g
    public final boolean I6() {
        HamletAvatarContext r100 = HamletAvatarContext.Companion.getContext();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isMultiAvatarMode();
        if (r101 == null) goto L9;
        if (r101.getValue().booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // gd0.g
    public final Long Ue() {
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.n<Long> r101 = r100.getCurrentSelectAvatarID();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // gd0.g
    public final int W3() {
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isStreamRending();
        if (r101 == null) goto L12;
        if (r101.getValue().booleanValue() != true) goto L12;
        LinkedList<String> r102 = this.f73460w;
        if (r102 != null) goto L11;
        return 0;
    L11:
        return CollectionsKt.indexOf(r102, this.f73459v);
    L12:
        dq1.a r103 = pm1.f.a();
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.W3();
    }

    public final void br() {
        af0.a r100 = af0.a.f3134a;
        long r101 = System.currentTimeMillis() - this.N;
        r100.getClass();
        LinkMonitorData r102 = LinkMonitorData.HamletAvatarFirstFrameDuration;     // Catch: Exception -> L5
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        r103.put("duration", r101);     // Catch: Exception -> L5
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L5
        af0.a.l(r102, r103);     // Catch: Exception -> L5
    L6:
        ff0.d r105 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "game_running", 0, null, null, 28);
        HamletAvatarContext r106 = this.f73443f;
        if (r106 != null) goto L9;
    L13:
        gd1.a r107 = this.f73440c;
        if (r107 == null) goto L16;
        List<com.bytedance.android.live.broadcastgame.api.xplay.b> r108 = r107.getAllCloudPlayerRtcInfo();
    L18:
        if (r108 == null) goto L20;
        int r109 = r108.size();
    L21:
        if (r109 <= 1) goto L23;
        boolean r110 = true;
    L24:
        HamletAvatarContext r111 = this.f73443f;
        if (r111 == null) goto L27;
        r111.setPlayerHasMultiCamera(r110);
    L27:
        Tq(r110);
        HamletAvatarContext r112 = this.f73443f;
        if (r112 == null) goto L30;
        r112.setXplayRetryCount(0);
    L30:
        HamletAvatarContext r113 = this.f73443f;
        if (r113 == null) goto L35;
        com.bytedance.live.datacontext.n<Integer> r114 = r113.getCurrentState();
        if (r114 == null) goto L35;
        r114.setValue(3);
    L35:
        HamletAvatarContext r115 = this.f73443f;
        if (r115 == null) goto L40;
        com.bytedance.live.datacontext.m<Boolean> r116 = r115.isStreamRending();
        if (r116 == null) goto L40;
        r116.setValue(Boolean.TRUE);
    L40:
        HamletAvatarContext r117 = this.f73443f;
        if (r117 == null) goto L47;
        Map<Long, Float> r118 = r117.getDownloadAvatarProgressRecord();
        if (r118 == null) goto L47;
        Set<Long> r119 = r118.keySet();
        if (r119 == null) goto L47;
        List<Long> r120 = CollectionsKt.toList(r119);
    L48:
        StringBuilder r121 = new StringBuilder("preloadAllAvatar, avatarIds is empty : ");
        if (r120 != null) goto L51;
    L53:
        boolean r122 = false;
    L54:
        r121.append(r122);
        ALogger.i("HamletAvatar", r121.toString());
        if (r120 != null) goto L57;
    L59:
        gd1.a r123 = this.f73440c;
        if (r123 == null) goto L69;
        View r124 = r123.K();
        if (r124 == null) goto L69;
        ViewGroup r125 = this.Q;
        if (r125 == null) goto L66;
        r125.removeAllViews();
    L66:
        ViewGroup r126 = this.Q;
        if (r126 == null) goto L69;
        r126.addView(r124, new ViewGroup.LayoutParams(-1, -1));
    L69:
        int r127 = vd0.a.f554147g;
        vd0.a.C7981a.a(this.dataCenter).c();
        if (gh0.a.d() == false) goto L133;
        HamletAvatarContext r128 = this.f73443f;
        if (r128 == null) goto L76;
        com.bytedance.live.datacontext.n<JSONArray> r129 = r128.getVideoSimulcastJSONArray();
        if (r129 == null) goto L76;
        JSONArray r130 = r129.getValue();
    L77:
        HamletAvatarContext r131 = this.f73443f;
        if (r131 == null) goto L82;
        com.bytedance.live.datacontext.m<Long> r132 = r131.getVideoSimulcastIndex();
        if (r132 == null) goto L82;
        Long r133 = r132.getValue();
    L83:
        Integer r134 = -1;
        if (r130 == null) goto L94;
        if (r133 == null) goto L94;
        if (r133.longValue() < 0) goto L94;
        if (r133.longValue() >= r130.length()) goto L94;
        gd1.a r135 = this.f73440c;
        if (r135 == null) goto L93;
        r134 = Integer.valueOf(r135.switchRemoteSimulcastStreamType((int) r133.longValue()));
        goto L94
    L93:
        r134 = null;
    L94:
        StringBuilder r136 = new StringBuilder("onXplayStart videoSimulcastJsonArray.length=");
        if (r130 == null) goto L97;
        Integer r137 = Integer.valueOf(r130.length());
    L98:
        r136.append(r137);
        r136.append(" videoSimulcastIndex=");
        r136.append(r133);
        r136.append(" switchRemoteSimulcastResult=");
        r136.append(r134);
        ALogger.i("HamletAvatar", r136.toString());
        HamletAvatarContext r138 = this.f73443f;
        if (r138 == null) goto L131;
        com.bytedance.live.datacontext.m<Boolean> r139 = r138.isMultiAvatarMode();
        if (r139 == null) goto L131;
        if (r139.getValue().booleanValue() != true) goto L131;
        ArrayList r140 = new ArrayList();
        if (r108 == null) goto L124;
        Iterator<T> r141 = r108.iterator();
    L109:
        if (r141.hasNext() == false) goto L124;
        com.bytedance.android.live.broadcastgame.api.xplay.b r142 = (com.bytedance.android.live.broadcastgame.api.xplay.b) r141.next();
        x0 r143 = new x0(0);
        r143.d(r142.f59440b);
        r143.e(r142.f59441c);
        int r144 = bg0.a.f18855a;
        String r145 = r142.f59439a;
        if (r145 != null) goto L113;
    L115:
        boolean r146 = false;
    L116:
        r143.c(!r146);
        r140.add(r143);
        String r147 = r142.f59439a;
        if (r147 != null) goto L119;
    L121:
        boolean r148 = false;
    L122:
        if (r148 == true) goto L109;
        this.G = r143;
        goto L109
    L119:
        if (StringsKt.endsWith$default(r147, "_main", false, 2, null) != true) goto L121;
        r148 = true;
        goto L122
    L113:
        if (StringsKt.endsWith$default(r145, "_main", false, 2, null) != true) goto L115;
        r146 = true;
    L124:
        long r149 = je0.d.a0();
        String r150 = GsonProtectorUtils.toJson(GsonHelper.get(), r140);
        ff0.d r151 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "genOrderSingStreamInfo start", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("rtcInfosParam", String.valueOf(r150))}), 12);
        af0.a.f3134a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarMainPublicStreamCreateStart);
        if (r140.size() <= 1) goto L127;
        af0.a.m(LinkMonitorData.HamletAvatarSubPublicStreamCreateStart);
    L127:
        Disposable r152 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).orderSingGenStreamInfo(Long.valueOf(r149), r150).compose(RxUtil.rxSchedulerHelper()).subscribe(u.f73526a, v.f73527a);
        if (r152 == null) goto L130;
        RxUtilKt.c(r152, this.f73438a);
    L130:
        com.bytedance.android.live.liveinteract.utils.j.a(1, "startAudienceSeiSendTask", 0, null, null, 28);
        boolean r153 = ff0.c.f476645a;
        this.f73463z = du2.a.b(0, vm2.d.I().getAudienceSeiSendInterval(), TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new e0(this));
    L132:
        Yq(0);
    L131:
        Nq("onXplayHamletRunning");
        goto L132
    L97:
        r137 = null;
    L82:
        r133 = null;
    L76:
        r130 = null;
    L133:
        Wq(true);
        return;
    L57:
        if ((!r120.isEmpty()) == false) goto L59;
        int r154 = ff0.e.f476648a;
        Intrinsics.checkNotNullParameter(r120, "allAvatarIds");
        com.bytedance.android.live.liveinteract.hamlet.model.u r155 = new com.bytedance.android.live.liveinteract.hamlet.model.u();
        r155.b(r120);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r155), null);
        goto L59
    L51:
        if ((!r120.isEmpty()) == false) goto L53;
        r122 = true;
    L47:
        r120 = null;
        goto L48
    L23:
        r110 = false;
        goto L24
    L20:
        r109 = 0;
        goto L21
    L16:
        r108 = null;
        goto L18
    L9:
        if (r106.isXplayAudioEnable() != true) goto L13;
        ILivePlayerClient r156 = hs0.a.f486938b.getCurrentClient();
        if (r156 == null) goto L13;
        r156.mute("HamletAvatarWidget.onXplayHamletRunning");
        goto L13
    }

    public final void cr() {
        com.bytedance.android.live.broadcastgame.api.xplay.f r100 = this.f73439b;
        Disposable r101 = null;
        if (r100 == null) goto L5;
        gd1.a r102 = (gd1.a) r100.getService(gd1.a.class);
    L6:
        this.f73440c = r102;
        if (r102 == null) goto L9;
        r102.d(new j(this));
    L9:
        gd1.a r103 = this.f73440c;
        if (r103 == null) goto L16;
        Observable<XplayException> r104 = r103.h();
        if (r104 == null) goto L16;
        Disposable r105 = r104.subscribe(new k(this));
        if (r105 == null) goto L16;
        RxUtilKt.c(r105, this.f73438a);
    L16:
        gd1.a r106 = this.f73440c;
        if (r106 == null) goto L23;
        Observable<XplayBasicState> r107 = r106.g();
        if (r107 == null) goto L23;
        Disposable r108 = r107.subscribe(new l(this));
        if (r108 == null) goto L23;
        RxUtilKt.c(r108, this.f73438a);
    L23:
        com.bytedance.android.live.broadcastgame.api.xplay.f r109 = this.f73439b;
        if (r109 == null) goto L26;
        gd1.b r110 = (gd1.b) r109.getService(gd1.b.class);
    L27:
        this.f73441d = r110;
        if (r110 == null) goto L30;
        r110.a(XplayBasicMessageType.Orser_Song_Message, this);
    L30:
        gd1.a r111 = this.f73440c;
        if (r111 == null) goto L37;
        Observable<com.bytedance.android.live.broadcastgame.api.xplay.g> r112 = r111.c();
        if (r112 == null) goto L37;
        Disposable r113 = r112.subscribe(new m(this), n.f73479a);
        if (r113 == null) goto L37;
        RxUtilKt.c(r113, this.f73438a);
        r101 = r113;
    L37:
        this.f73442e = r101;
        return;
    L26:
        r110 = null;
        goto L27
    L5:
        r102 = null;
        goto L6
    }

    public final void dr() {
        if (this.B != MixStreamType.SERVER_MIX) goto L5;
    L35:
        StringBuilder r100 = new StringBuilder();
        Iterator r101 = ((LinkedHashMap) this.H).keySet().iterator();
    L37:
        if (r101.hasNext() == false) goto L48;
        String r102 = (String) r101.next();
        Function0<hg6.g> r103 = this.R;
        if (r103 == null) goto L47;
        hg6.g r104 = r103.invoke();
        if (r104 == null) goto L47;
        ei6.a r105 = r104.V0();
        if (r105 == null) goto L47;
        ti6.d r106 = r105.p();
        if (r106 == null) goto L47;
        r106.b(r102, this + " stopAllExtraMixerTask");
    L47:
        r100.append("," + r102);
        goto L37
    L48:
        ff0.d r107 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "stopAllExtraMixerTask", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("all_tasks", String.valueOf(r100))}), 12);
        Map<String, df0.a> r108 = this.H;
        if (r108 == null) goto L51;
        ((LinkedHashMap) r108).clear();
    L51:
        Bq();
        return;
    L5:
        if (this.E == false) goto L15;
        Function0<hg6.g> r109 = this.R;
        if (r109 == null) goto L15;
        hg6.g r110 = r109.invoke();
        if (r110 == null) goto L15;
        ei6.a r111 = r110.V0();
        if (r111 == null) goto L15;
        fi6.a r112 = r111.g();
        if (r112 == null) goto L15;
        r112.f477400p = false;
    L15:
        MixStreamType r113 = this.B;
        if (r113 == null) goto L26;
        Function0<hg6.g> r114 = this.R;
        if (r114 == null) goto L26;
        hg6.g r115 = r114.invoke();
        if (r115 == null) goto L26;
        ei6.a r116 = r115.V0();
        if (r116 == null) goto L26;
        ti6.d r117 = r116.p();
        if (r117 == null) goto L26;
        r117.m(r113);
    L26:
        Function0<hg6.g> r118 = this.R;
        if (r118 == null) goto L35;
        hg6.g r119 = r118.invoke();
        if (r119 == null) goto L35;
        ei6.a r120 = r119.V0();
        if (r120 == null) goto L35;
        vi6.a r121 = r120.v();
        if (r121 == null) goto L35;
        r121.f();
        goto L35
    }

    public final void gr() {
        ALogger.i("HamletAvatar", "stopCheckAudioDelay");
        cf0.b r100 = this.f73448k;
        if (r100 == null) goto L5;
        cf0.a<Long> r101 = r100.f23499a;
        r101.f23496a.clear();
        r101.f23497b.set(0);
    L5:
        this.f73447j = false;
        this.f73453p.removeCallbacks(this.f73454q);
        hr(-1);
    }

    @Override // gd0.g
    public final boolean ib() {
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isStreamRending();
        if (r101 == null) goto L11;
        if (r101.getValue().booleanValue() != true) goto L11;
        HamletAvatarContext r102 = this.f73443f;
        if (r102 != null) goto L16;
        return false;
    L16:
        return r102.getPlayerHasMultiCamera();
    L11:
        HamletAvatarContext r103 = this.f73443f;
        if (r103 != null) goto L14;
        return false;
    L14:
        return r103.getAudienceMultiCamera();
    }

    @Override // gd0.g
    public final boolean kl() {
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isAvatarRending();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        boolean r101 = false;
        if (r100 == null) goto L9;
        gd0.i r102 = r100.getInteractFloatWindowService();
        if (r102 == null) goto L9;
        if (((com.bytedance.android.live.liveinteract.service.g) r102).b() != true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L18;
        cg6.a r104 = Eq();
        if (r104 == null) goto L18;
        hg6.g r105 = r104.getRtcManager();
        if (r105 == null) goto L18;
        if (r105.A() != true) goto L18;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L54;
        HamletAvatarContext r107 = this.f73443f;
        if (r107 == null) goto L32;
        com.bytedance.live.datacontext.n<Long> r108 = r107.getCurrentSelectAvatarID();
        if (r108 == null) goto L32;
        Long r109 = r108.getValue();
        if (r109 == null) goto L32;
        long r110 = r109.longValue();
        x5 r111 = this.f73457t;
        if (r111 == null) goto L32;
        w5 r112 = r111.getHamletAvatarInit();
        if (r112 == null) goto L32;
        r112.setAvatarId(r110);
    L32:
        String r113 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().F = this.f73457t;
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a r114 = new com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a();
        r114.f73400b = this.f73439b;
        HamletAvatarContext r115 = this.f73443f;
        if (r115 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r116 = r115.isMultiAvatarMode();
        if (r116 == null) goto L37;
        Boolean r117 = r116.getValue();
    L38:
        r114.f73399a = r117;
        HamletAvatarContext r118 = this.f73443f;
        if (r118 == null) goto L43;
        com.bytedance.live.datacontext.n<Long> r119 = r118.getCurrentSelectAnimationIndex();
        if (r119 == null) goto L43;
        Long r120 = r119.getValue();
    L44:
        r114.f73401c = r120;
        LinkmicOnlineFloatWindowManager.c.a().G = r114;
        gd1.a r121 = this.f73440c;
        if (r121 == null) goto L55;
        View r122 = r121.K();
        if (r122 == null) goto L55;
        ViewParent r123 = r122.getParent();
        if ((r123 instanceof ViewGroup) == true) goto L51;
        r123 = null;
    L51:
        ViewGroup r124 = (ViewGroup) r123;
        if (r124 == null) goto L55;
        r124.removeView(r122);
    L55:
        HamletAvatarContext r125 = this.f73443f;
        if (r125 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r126 = r125.isMultiAvatarMode();
        if (r126 == null) goto L62;
        if (r126.getValue().booleanValue() != true) goto L62;
        boolean r127 = true;
    L63:
        this.f73443f = null;
        if (r106 == false) goto L66;
        if (r127 == false) goto L66;
    L67:
        Aq("widget destroy", r101);
        super.onDestroy();
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r128 = this.f73456s;
        if (r128 == null) goto L72;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r129 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, this.dataCenter);
        if (r129 == null) goto L72;
        r129.d1(r128);
    L72:
        com.bytedance.android.livesdk.chatroom.t r130 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r130 == null) goto L77;
        com.bytedance.live.datacontext.j<vlc.d> r131 = r130.getMessageManager();
        if (r131 == null) goto L77;
        r131.c(new AnonymousClass3(this));
    L77:
        cg6.a r132 = Eq();
        if (r132 == null) goto L82;
        vb6.g r133 = r132.O5();
        if (r133 == null) goto L82;
        r133.a1(this.O);
    L82:
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.f59443b.f(this.P);
        this.f73438a.dispose();
        gr();
        this.f73453p.removeCallbacksAndMessages(null);
        cg6.a r134 = Eq();
        if (r134 == null) goto L88;
        vb6.g r135 = r134.O5();
        if (r135 == null) goto L89;
        r135.a1(this.O);
        return;
    L89:
        return;
    L88:
        return;
    L66:
        r101 = true;
    L62:
        r127 = false;
    L43:
        r120 = null;
    L37:
        r117 = null;
        goto L38
    L54:
        String r136 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().F = null;
        LinkmicOnlineFloatWindowManager.c.a().G = null;
    L18:
        r106 = false;
    L9:
        r103 = false;
        goto L10
    }

    @Override // gd0.g
    public final void switchCamera() {
        ALogger.i("HamletAvatar", "switchCamera");
        ff0.d r100 = ff0.d.f476647a;
        boolean r101 = false;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "switchCamera", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("current_camera_index", String.valueOf(W3()))}), 12);
        long r102 = System.currentTimeMillis();
        long r103 = this.D;
        if (r103 > 0) goto L5;
    L8:
        this.D = r102;
        af0.a.f3134a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarSwitchCameraStart);
        final long r104 = System.currentTimeMillis();
        HamletAvatarContext r105 = this.f73443f;
        if (r105 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.isStreamRending();
        if (r106 == null) goto L15;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L15;
        r101 = r107.booleanValue();
    L15:
        if (r101 == false) goto L19;
        gd1.a r108 = this.f73440c;
        if (r108 == null) goto L24;
        r108.a(new AnonymousClass1(this, r104));
        return;
    L24:
        return;
    L19:
        dq1.a r109 = pm1.f.a();
        if (r109 == null) goto L22;
        dq1.a.C5698a.a(r109, null, null, false, null, Boolean.FALSE, 15);
    L22:
        ar();
        return;
    L5:
        if ((r102 - r103) >= 1000) goto L8;
        f2.b(R.string.ttlive_hamlet_avatart_switch_camera_frequent_tips, 0);
    }

    @Override // gd0.g
    public final boolean yd() {
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isStreamRending();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return false;
    }

    public final void zq() {
        cf0.b r100 = this.f73448k;
        if (r100 == null) goto L17;
        int r101 = r100.f23499a.f23497b.get();
        if (r101 <= 0) goto L11;
        Iterator<Long> r102 = r100.f23499a.f23496a.iterator();
        long r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L10;
        r103 = r103 + r102.next().longValue();
        goto L8
    L10:
        long r104 = r103 / ((long) r101);
    L13:
        if (r104 <= 0) goto L18;
        hr(r104);
        return;
    L18:
        return;
    L11:
        r104 = 0;
        goto L13
    }

    @Override // gd0.g
    public final void a7() {
        Disposable r100 = ((HamletAvatarApi) com.bytedance.android.live.network.c.b().e(HamletAvatarApi.class)).getXplayInitInfo(lu2.c.f(this.dataCenter).getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this), p.f73481a);
        if (r100 == null) goto L6;
        RxUtilKt.c(r100, this.f73438a);
        return;
    }

    public final void ar() {
        if (W3() <= 0) goto L5;
        Sq(false, false);
        return;
    L5:
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isAvatarRending();
        if (r101 == null) goto L12;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L12;
        boolean r103 = r102.booleanValue();
    L13:
        HamletAvatarContext r104 = this.f73443f;
        if (r104 == null) goto L20;
        com.bytedance.live.datacontext.m<Integer> r105 = r104.getDirecting();
        if (r105 == null) goto L20;
        Integer r106 = r105.getValue();
        if (r106 == null) goto L20;
        int r107 = r106.intValue();
    L21:
        boolean r108 = true;
        if (r107 <= 0) goto L24;
        boolean r109 = true;
    L25:
        if (r103 == true) goto L28;
        if (r109 == true) goto L28;
    L29:
        Sq(r108, mg(0));
        return;
    L28:
        r108 = false;
        goto L29
    L24:
        r109 = false;
    L20:
        r107 = 0;
    L12:
        r103 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    public final void jr() {
        this.L = System.currentTimeMillis();
        Function0<hg6.g> r100 = this.R;
        fi6.a r101 = null;
        if (r100 == null) goto L11;
        hg6.g r102 = r100.invoke();
        if (r102 == null) goto L11;
        ei6.a r103 = r102.V0();
        if (r103 == null) goto L11;
        fi6.a r104 = r103.g();
        if (r104 == null) goto L11;
        MixStreamType r105 = r104.U;
    L12:
        this.B = r105;
        ff0.d r106 = ff0.d.f476647a;
        Pair[] r107 = new Pair[2];
        r107[0] = TuplesKt.to("lastMixType", String.valueOf(r105));
        Function0<hg6.g> r108 = this.R;
        if (r108 == null) goto L17;
        hg6.g r109 = r108.invoke();
        if (r109 == null) goto L17;
        ei6.a r110 = r109.V0();
    L18:
        r107[1] = TuplesKt.to("client", String.valueOf(r110));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "switchMainToServerMix", 0, null, MapsKt.mutableMapOf(r107), 12);
        MixStreamType r111 = this.B;
        MixStreamType r112 = MixStreamType.SERVER_MIX;
        if (r111 == r112) goto L53;
        af0.a.f3134a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarMainMixerSwitchStart);
        if (f7.f120179a.getValue().booleanValue() == false) goto L34;
        Function0<hg6.g> r113 = this.R;
        if (r113 == null) goto L29;
        hg6.g r114 = r113.invoke();
        if (r114 == null) goto L29;
        ei6.a r115 = r114.V0();
        if (r115 == null) goto L29;
        r101 = r115.g();
    L29:
        if (r101 == null) goto L31;
        r101.f477400p = true;
    L31:
        if (r101 == null) goto L33;
        LiveWrappedMixedStreamPushMode r116 = LiveWrappedMixedStreamPushMode.ON_START_REQUEST;
        Intrinsics.checkNotNullParameter(r116, "mTargetPushStreamMode");
        r101.f477401q = r116;
    L33:
        this.E = true;
    L34:
        Function0<hg6.g> r117 = this.R;
        if (r117 == null) goto L43;
        hg6.g r118 = r117.invoke();
        if (r118 == null) goto L43;
        ei6.a r119 = r118.V0();
        if (r119 == null) goto L43;
        ti6.d r120 = r119.p();
        if (r120 == null) goto L43;
        r120.m(r112);
    L43:
        Function0<hg6.g> r121 = this.R;
        if (r121 == null) goto L54;
        hg6.g r122 = r121.invoke();
        if (r122 == null) goto L55;
        ei6.a r123 = r122.V0();
        if (r123 == null) goto L56;
        vi6.a r124 = r123.v();
        if (r124 == null) goto L57;
        r124.f();
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L17:
        r110 = null;
    L11:
        r105 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r6v71 */
    /* JADX WARN: Type inference failed for: r7v25, types: [com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget$addDataChangeObserver$$inlined$let$lambda$10] */
    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.t r100 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        r101.c(new HamletAvatarWidget$listerMsg$1(this));
    L7:
        this.f73448k = new cf0.b();
        LinkUserDataMergeContext.a r102 = LinkUserDataMergeContext.Companion;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r103 = LinkUserDataMergeContext.a.b(r102, this.dataCenter);
        if (r103 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r104 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g();
        this.f73456s = r104;
        Intrinsics.checkNotNull(r104);
        r103.M0(r104);
    L10:
        Pair r105 = com.bytedance.live.datacontext.d.a(HamletAvatarWidget$initContext$pair$1.INSTANCE);
        HamletAvatarContext r106 = (HamletAvatarContext) r105.getFirst();
        this.f73443f = r106;
        r106.getHamletAvatarService().d(this);
        com.bytedance.live.datacontext.b.a(r106, i0.class);
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        Boolean r108 = null;
        if (r107 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r109 = r107.getLinkUserInfoCenter();
    L14:
        this.f73444g = r109;
        if (r109 == null) goto L17;
        r109.Q4(this.K);
    L17:
        this.f73438a.add((Disposable) r105.getSecond());
        cg6.a r110 = Eq();
        if (r110 == null) goto L22;
        vb6.g r111 = r110.O5();
        if (r111 == null) goto L22;
        r111.X0(this.O, true);
    L22:
        final HamletAvatarContext r112 = this.f73443f;
        Object r113 = "";
        if (r112 == null) goto L133;
        RxUtilKt.c(Observable.combineLatest(r112.isStreamRending().a(), r112.isRtcClientInitialized().a(), r112.isMultiAvatarMode().a(), com.bytedance.android.live.liveinteract.hamlet.o.f73518a).subscribe(new com.bytedance.android.live.liveinteract.hamlet.e(this)), this.f73438a);
        RxUtilKt.c(Observable.combineLatest(r112.isStreamRending().a(), r112.isRtcClientInitialized().a(), r112.isSelfCPosition().a(), com.bytedance.android.live.liveinteract.hamlet.p.f73519a).subscribe(new com.bytedance.android.live.liveinteract.hamlet.f(this)), this.f73438a);
        if (gh0.a.d() == false) goto L33;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.hamlet.model.l> r114 = r112.getChestPosition();
        if (r114 == null) goto L33;
        Observable<sh6.b<com.bytedance.android.live.liveinteract.hamlet.model.l>> r115 = r114.a();
        if (r115 == null) goto L33;
        Disposable r116 = r115.subscribe(new com.bytedance.android.live.liveinteract.hamlet.g(this));
        if (r116 == null) goto L33;
        RxUtilKt.c(r116, this.f73438a);
    L33:
        Observable<R> r117 = r112.getChestPosition().a().compose(RxUtil.rxSchedulerHelper());
        if (r117 == 0) goto L38;
        Disposable r118 = r117.subscribe(new com.bytedance.android.live.liveinteract.hamlet.h(this));
        if (r118 == null) goto L38;
        RxUtilKt.c(r118, this.f73438a);
    L38:
        Observable<R> r119 = r112.isAvatarRending().a().compose(RxUtil.rxSchedulerHelper());
        if (r119 == 0) goto L43;
        Disposable r120 = r119.subscribe(new com.bytedance.android.live.liveinteract.hamlet.i(this));
        if (r120 == null) goto L43;
        RxUtilKt.c(r120, this.f73438a);
    L43:
        com.bytedance.live.datacontext.m<Integer> r121 = r112.getDirecting();
        if (r121 == null) goto L52;
        Observable<Integer> r122 = r121.a();
        if (r122 == null) goto L52;
        Observable<R> r123 = r122.compose(RxUtil.rxSchedulerHelper());
        if (r123 == 0) goto L52;
        Disposable r124 = r123.subscribe(new com.bytedance.android.live.liveinteract.hamlet.j(this));
        if (r124 == null) goto L52;
        RxUtilKt.c(r124, this.f73438a);
    L52:
        InteractiveSongContext.a r125 = InteractiveSongContext.Companion;
        InteractiveSongContext r126 = r125.getContext();
        if (r126 == null) goto L61;
        com.bytedance.live.datacontext.m<Boolean> r127 = r126.m8177isOpenInteractiveSong();
        if (r127 == null) goto L61;
        if (r127.getValue().booleanValue() != true) goto L61;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r128 = this.f73456s;
        if (r128 == null) goto L61;
        r128.f76435d = Boolean.TRUE;
        r128.c();
    L61:
        InteractiveSongContext r129 = r125.getContext();
        if (r129 == null) goto L70;
        com.bytedance.live.datacontext.m<Boolean> r130 = r129.m8177isOpenInteractiveSong();
        if (r130 == null) goto L70;
        Observable<Boolean> r131 = r130.a();
        if (r131 == null) goto L70;
        Disposable r132 = r131.subscribe(new com.bytedance.android.live.liveinteract.hamlet.k(this));
        if (r132 == null) goto L70;
        RxUtilKt.c(r132, this.f73438a);
    L70:
        com.bytedance.android.livesdk.chatroom.u r133 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r134 = r133.s();
        if (r134 == null) goto L77;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r135 = r134.getValue();
        if (r135 == null) goto L77;
        ObservableSource r136 = r135.b();
        if (r136 == null) goto L77;
    L78:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r137 = r133.s();
        if (r137 == null) goto L85;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r138 = r137.getValue();
        if (r138 == null) goto L85;
        ObservableSource r139 = r138.a();
        if (r139 == null) goto L85;
    L86:
        Observable r140 = Observable.combineLatest(r136, r139, com.bytedance.android.live.liveinteract.hamlet.n.f73517a);
        if (r140 == null) goto L92;
        Disposable r141 = r140.subscribe(new com.bytedance.android.live.liveinteract.hamlet.l(this));
        if (r141 == null) goto L92;
        RxUtilKt.c(r141, this.f73438a);
    L92:
        if (gh0.a.d() == false) goto L101;
        com.bytedance.live.datacontext.n<Pair<Set<String>, Set<String>>> r142 = r112.getCPositionList();
        if (r142 == null) goto L101;
        Observable<sh6.b<Pair<Set<String>, Set<String>>>> r143 = r142.a();
        if (r143 == null) goto L101;
        Disposable r144 = r143.subscribe(new com.bytedance.android.live.liveinteract.hamlet.m(this));
        if (r144 == null) goto L101;
        RxUtilKt.c(r144, this.f73438a);
    L101:
        if (gh0.a.d() == true) goto L106;
        dq1.a r145 = pm1.f.a();
        if (r145 == 0) goto L106;
        r145.c4(this, new HamletAvatarWidget$addDataChangeObserver$$inlined$let$lambda$10(r112, this));
    L106:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L120;
        LinkUserDataMergeContext r146 = r102.getContext(this.dataCenter, "");
        if (r146 == null) goto L133;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r147 = r146.getDataMergeCenter();
        if (r147 == null) goto L133;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r148 = r147.getValue();
        if (r148 == null) goto L133;
        BehaviorSubject<Map<String, Boolean>> r149 = r148.j1();
        if (r149 == null) goto L133;
        Observable<Map<String, Boolean>> r150 = r149.observeOn(Schedulers.io());
        if (r150 == null) goto L133;
        Disposable r151 = r150.subscribe(new com.bytedance.android.live.liveinteract.hamlet.c(this));
        if (r151 == null) goto L133;
        RxUtilKt.c(r151, this.f73438a);
        goto L133
    L120:
        LinkUserDataMergeContext r152 = r102.getContext(this.dataCenter, "");
        if (r152 == null) goto L133;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.d> r153 = r152.getDataMergeCenter();
        if (r153 == null) goto L133;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r154 = r153.getValue();
        if (r154 == null) goto L133;
        BehaviorSubject<List<ch0.e>> r155 = r154.f();
        if (r155 == null) goto L133;
        Observable<List<ch0.e>> r156 = r155.observeOn(Schedulers.io());
        if (r156 == null) goto L133;
        Disposable r157 = r156.subscribe(new com.bytedance.android.live.liveinteract.hamlet.d(this));
        if (r157 == null) goto L133;
        RxUtilKt.c(r157, this.f73438a);
    L85:
        r139 = Observable.empty();
    L77:
        r136 = Observable.empty();
    L133:
        ILivePlayerClient r158 = hs0.a.f486938b.getCurrentClient();
        if (r158 == null) goto L140;
        IRoomEventHub r159 = r158.getEventHub();
        if (r159 == null) goto L140;
        MutableLiveData<Boolean> r160 = r159.getFirstFrame();
        if (r160 == null) goto L140;
        r160.observe(this, new q(this));
    L140:
        z5 r161 = com.bytedance.android.live.ktv.common.util.a.a().getLinkerDetail();
        if (r161 == null) goto L147;
        List<Long> r162 = r161.getFeatureList();
        if (r162 == null) goto L147;
        if (r162.contains(1L) != true) goto L147;
        boolean r163 = true;
    L148:
        z5 r164 = com.bytedance.android.live.ktv.common.util.a.a().getLinkerDetail();
        if (r164 == null) goto L155;
        List<Long> r165 = r164.getFeatureList();
        if (r165 == null) goto L155;
        if (r165.contains(2L) != true) goto L155;
        boolean r166 = true;
    L156:
        ALogger.i("HamletAvatar", "init featureListContainHamletAvatar:" + r163);
        ff0.d r167 = ff0.d.f476647a;
        Pair[] r168 = new Pair[1];
        Gson r169 = GsonHelper.get();
        z5 r170 = com.bytedance.android.live.ktv.common.util.a.a().getLinkerDetail();
        if (r170 == null) goto L159;
        List<Long> r171 = r170.getFeatureList();
    L160:
        r168[0] = TuplesKt.to("feature_list", GsonProtectorUtils.toJson(r169, r171));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "room enter", 0, null, MapsKt.mutableMapOf(r168), 12);
        this.dataCenter.put("data_hamlet_avatar_status", Boolean.valueOf(r163));
        HamletAvatarContext r172 = this.f73443f;
        if (r172 == null) goto L165;
        com.bytedance.live.datacontext.m<Boolean> r173 = r172.isMultiAvatarMode();
        if (r173 == null) goto L165;
        r173.setValue(Boolean.valueOf(r166));
    L165:
        HamletAvatarContext r174 = this.f73443f;
        if (r174 == null) goto L168;
        r174.setMultiAvatarModeForReport(r166);
    L168:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r175 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.f77445m = Boolean.valueOf(r166);
        if (r166 == false) goto L173;
        ViewGroup r176 = this.Q;
        if (r176 == null) goto L173;
        r176.setVisibility(0);
    L173:
        this.f73449l = gh0.a.d();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b r177 = com.bytedance.android.live.broadcastgame.api.xplay.basic.b.f59443b;
        r177.c();
        r177.a(this.P);
        HamletAvatarContext r178 = this.f73443f;
        if (r178 == null) goto L176;
        RxUtilKt.c(Observable.combineLatest(r178.getXplyStartMessageRecived().a(), r178.isRtcClientInitialized().a(), b0.f73493a).subscribe(new a0(this)), this.f73438a);
    L176:
        String r179 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r180 = LinkmicOnlineFloatWindowManager.c.a();
        if (r180 == null) goto L240;
        this.f73457t = r180.F;
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a r181 = r180.G;
        HamletAvatarContext r182 = this.f73443f;
        if (r182 == null) goto L186;
        com.bytedance.live.datacontext.n<Long> r183 = r182.getCurrentSelectAnimationIndex();
        if (r183 == null) goto L186;
        if (r181 == null) goto L184;
        Long r184 = r181.f73401c;
    L185:
        r183.setValue(r184);
        goto L186
    L184:
        r184 = null;
    L186:
        String r185 = je0.d.b0();
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r186 = IVoiceChatGuestService.a.a();
        if (r186 == null) goto L206;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r187 = r186.getLinkUserInfoCenter();
        if (r187 == null) goto L206;
        Iterable r188 = r187.getOnlineUserList();
        if (r188 == null) goto L206;
        Iterator r189 = r188.iterator();
    L194:
        if (r189.hasNext() == false) goto L202;
        Object r190 = r189.next();
        IBaseUser r191 = ((ILinkPlayerInfoBridge) r190).getUser();
        if (r191 == null) goto L198;
        String r192 = r191.getIdString();
    L200:
        if (Intrinsics.areEqual(r192, r185) == false) goto L194;
    L203:
        ILinkPlayerInfoBridge r193 = (ILinkPlayerInfoBridge) r190;
        if (r193 == null) goto L206;
        boolean r194 = r193.isEnlarged();
    L207:
        if (r194 == false) goto L219;
        Ref.ObjectRef r195 = new Ref.ObjectRef();
        r195.element = null;
        HamletAvatarContext r196 = this.f73443f;
        if (r196 == null) goto L215;
        com.bytedance.live.datacontext.n<Integer> r197 = r196.getCurrentState();
        if (r197 == null) goto L215;
        Observable<sh6.b<Integer>> r198 = r197.a();
        if (r198 == null) goto L215;
        ?? r199 = r198.subscribe(new d0(r181, r195, this));
    L216:
        r195.element = r199;
        if (r199 == 0) goto L219;
        RxUtilKt.c(r199, this.f73438a);
    L215:
        r199 = 0;
    L219:
        x5 r200 = this.f73457t;
        if (r200 == null) goto L241;
        if (r181 == null) goto L223;
        r108 = r181.f73399a;
    L223:
        Boolean r201 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r201) == false) goto L231;
        this.f73439b = r181.f73400b;
        HamletAvatarContext r202 = this.f73443f;
        if (r202 == null) goto L230;
        com.bytedance.live.datacontext.m<Boolean> r203 = r202.getXplyStartMessageRecived();
        if (r203 == null) goto L230;
        r203.setValue(r201);
    L230:
        cr();
        Kq(r200, false, false, false);
        br();
    L232:
        ff0.d r204 = ff0.d.f476647a;
        Pair[] r205 = new Pair[5];
        r205[0] = TuplesKt.to("init_type", String.valueOf(r200.getInitType()));
        r205[1] = TuplesKt.to("init_param", String.valueOf(r200.getInitParam()));
        r205[2] = TuplesKt.to("channel", String.valueOf(r200.getChannel()));
        r205[3] = TuplesKt.to("game_id", String.valueOf(r200.getGameId()));
        w5 r206 = r200.getHamletAvatarInit();
        if (r206 == null) goto L235;
        r113 = Long.valueOf(r206.getAvatarId());
    L235:
        r205[4] = TuplesKt.to("avatar_id", String.valueOf(r113));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "resume_from_float_window", 0, null, MapsKt.mutableMapOf(r205), 12);
        return;
    L231:
        Kq(r200, true, true, false);
        goto L232
    L241:
        return;
    L198:
        r192 = null;
        goto L200
    L202:
        r190 = null;
    L206:
        r194 = false;
        goto L207
    L240:
        return;
    L159:
        r171 = null;
    L155:
        r166 = false;
    L147:
        r163 = false;
        goto L148
    L13:
        r109 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.f59443b.b(true);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.f59443b.b(false);
    }

    @Override // gd0.g
    public final boolean wp() {
        Integer r100 = je0.d.h();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 28) goto L8;
        return true;
    }

    @Override // gd0.g
    public final String Ac() {
        return this.F;
    }

    public static void Fq(String r100) {
        com.bytedance.android.live.liveinteract.hamlet.model.a r101 = (com.bytedance.android.live.liveinteract.hamlet.model.a) GsonHelper.get().fromJson(r100, com.bytedance.android.live.liveinteract.hamlet.model.a.class);     // Catch: Exception -> L16
        Integer r102 = r101.b();     // Catch: Exception -> L16
        String r103 = r101.c();     // Catch: Exception -> L16
        if (r102 != null) goto L6;
    L8:
        if (r103 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L22;
        f2.c(r103, 0);     // Catch: Exception -> L16
        return;
    L22:
        return;
    L10:
        if (r103.length() <= 0) goto L12;
        r104 = true;
        goto L13
    L6:
        if (r102.intValue() != 0) goto L8;
        return;
    L16:
        e = move-exception;
        ALogger.e("HamletAvatar", "handleActionRspMessage exception=" + Log.getStackTraceString(e));
    }

    public static void Gq(String r100) {
        boolean r101 = ff0.c.f476645a;
        if (vm2.d.I().getHamletAppLogEnable() == true) goto L22;
        return;
    L22:
        com.bytedance.android.live.liveinteract.hamlet.model.b r102 = (com.bytedance.android.live.liveinteract.hamlet.model.b) GsonHelper.get().fromJson(r100, com.bytedance.android.live.liveinteract.hamlet.model.b.class);     // Catch: Exception -> L19
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Exception -> L19
        String r104 = r102.c();     // Catch: Exception -> L19
        if (r104 == null) goto L12;
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L19
        Iterator<String> r106 = r105.keys();     // Catch: Exception -> L19
        if (r106 == null) goto L12;
    L10:
        if (r106.hasNext() == false) goto L12;
        String r107 = r106.next();     // Catch: Exception -> L19
        r103.put(r107, r105.get(r107).toString());     // Catch: Exception -> L19
    L12:
        IRoom r108 = je0.d.e(null);     // Catch: Exception -> L19
        if (r108 == null) goto L16;
        String r109 = r108.getOwnerUserIdString();     // Catch: Exception -> L19
        if (r109 == null) goto L16;
    L17:
        r103.put("anchor_id", r109);     // Catch: Exception -> L19
        r103.put("live_type", "voice_live");     // Catch: Exception -> L19
        j0.l().sendLog(r102.b(), r103, new Object[]{IRoom.class, am2.x.class});     // Catch: Exception -> L19
        return;
    L16:
        r109 = "";
    L19:
        e = move-exception;
        ALogger.e("HamletAvatar", "handleAppLogMessage exception=" + Log.getStackTraceString(e));
    }

    public static final boolean wq(HamletAvatarWidget r100) {
        HamletAvatarContext r101 = r100.f73443f;
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.isMultiAvatarMode();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        boolean r105 = ff0.c.f476645a;
        if (vm2.d.I().getAudioCheckDelayEnable() == true) goto L13;
        return false;
    L13:
        if (r100.f73447j == true) goto L25;
        cf0.b r106 = r100.f73448k;
        if (r106 == null) goto L26;
        cf0.a<Long> r107 = r106.f23499a;
        if (r107.f23497b.get() < r107.f23498c) goto L19;
        boolean r108 = true;
    L20:
        if (r108 != true) goto L27;
        if (r104 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L19:
        r108 = false;
        goto L20
    L26:
        return false;
    L25:
        return false;
    L9:
        r104 = false;
        goto L10
    }

    public static final void xq(HamletAvatarWidget r100) {
        r100.getClass();
        StringBuilder r101 = new StringBuilder("startCheckAudioDelay, interval=");
        boolean r102 = ff0.c.f476645a;
        r101.append(vm2.d.I().getAudioDelayCheckInterval());
        ALogger.i("HamletAvatar", r101.toString());
        r100.f73447j = true;
        r100.f73453p.removeCallbacks(r100.f73454q);
        r100.zq();
        r100.f73453p.postDelayed(r100.f73454q, vm2.d.I().getAudioDelayCheckInterval());
    }

    public final void Cq(Long r100) {
        RxUtilKt.c(((MultiCameraApi) com.bytedance.android.live.network.c.b().e(MultiCameraApi.class)).updateCameraInfo(Long.valueOf(je0.d.a0()), r100, 4, 2).subscribe(b.f73466a, c.f73467a), this.f73438a);
    }

    @Override // gd0.g
    public final void E7(long r100) {
        ALogger.i("HamletAvatar", "playAnimation, animationId:" + r100);
        int r101 = ff0.e.f476648a;
        com.bytedance.android.live.liveinteract.hamlet.model.s r102 = new com.bytedance.android.live.liveinteract.hamlet.model.s();
        r102.b(Long.valueOf(r100));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r102), null);
    }

    public final void Iq(Long r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, Ue()) == false) goto L7;
        ff0.d r101 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "current_avatar_download_failed", 0, null, null, 28);
    L8:
        HamletAvatarContext r102 = this.f73443f;
        if (r102 == null) goto L13;
        Map<Long, Float> r103 = r102.getDownloadAvatarProgressRecord();
        if (r103 == null) goto L13;
        Float r104 = r103.put(r100, Float.valueOf(0.0f));
    L13:
        ALogger.i("HamletAvatar", "retryStartXplayIfCan, avatarId=" + r100 + ", currentSelectAvatarID=" + Ue());
        if (Intrinsics.areEqual(r100, Ue()) == false) goto L30;
        HamletAvatarContext r105 = this.f73443f;
        if (r105 == null) goto L18;
        int r106 = r105.getAvatarLoadRetryCount();
    L19:
        boolean r107 = ff0.c.f476645a;
        if (r106 >= vm2.d.I().getAvatarLoadRetryCount()) goto L25;
        HamletAvatarContext r108 = this.f73443f;
        if (r108 == null) goto L24;
        r108.setAvatarLoadRetryCount(r106 + 1);
    L24:
        uc(r100.longValue());
        return;
    L25:
        HamletAvatarContext r109 = this.f73443f;
        if (r109 == null) goto L28;
        r109.setAvatarLoadRetryCount(0);
    L28:
        f2.b(R.string.ttlive_voice_link_hamlet_avatar_download_fail_toast, 0);
        return;
    L18:
        r106 = 0;
        goto L19
    L30:
        return;
    L7:
        ALogger.i("HamletAvatar", "handleAvatarDownloadFailed, avatarId=" + r100);
        goto L8
    }

    @Override // gd0.g
    public final void Jf(long r100) {
        ALogger.i("HamletAvatar", "changeAnimation, animationId:" + r100);
        HamletAvatarContext r101 = this.f73443f;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.n<Long> r102 = r101.getCurrentSelectAnimationIndex();
        if (r102 == null) goto L7;
        r102.setValue(Long.valueOf(r100));
    L7:
        int r103 = ff0.e.f476648a;
        com.bytedance.android.live.liveinteract.hamlet.model.f r104 = new com.bytedance.android.live.liveinteract.hamlet.model.f();
        r104.b(Long.valueOf(r100));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r104), null);
    }

    public final void Jq(String r100) {
        com.bytedance.android.live.liveinteract.hamlet.model.i r101 = (com.bytedance.android.live.liveinteract.hamlet.model.i) GsonHelper.get().fromJson(r100, com.bytedance.android.live.liveinteract.hamlet.model.i.class);     // Catch: Exception -> L53
        Integer r102 = r101.a();     // Catch: Exception -> L53
        if (r102 != null) goto L6;
    L16:
        if (r102 != null) goto L19;
    L30:
        if (r102 != null) goto L33;
    L47:
        if (r102 != null) goto L50;
        return;
    L50:
        if (r102.intValue() != 10) goto L67;
        Iq(r101.b());     // Catch: Exception -> L53
        return;
    L67:
        return;
    L33:
        if (r102.intValue() != 9) goto L47;
        Long r103 = r101.b();     // Catch: Exception -> L53
        if (r103 == null) goto L62;
        HamletAvatarContext r104 = this.f73443f;     // Catch: Exception -> L53
        if (r104 == null) goto L42;
        Map<Long, Float> r105 = r104.getDownloadAvatarProgressRecord();     // Catch: Exception -> L53
        if (r105 == null) goto L42;
        Float r106 = r105.put(r103, Float.valueOf(1.0f));     // Catch: Exception -> L53
    L42:
        Pq(r103.longValue(), 1.0f);     // Catch: Exception -> L53
        if (Intrinsics.areEqual(r103, Ue()) == false) goto L63;
        HamletAvatarContext r107 = this.f73443f;     // Catch: Exception -> L53
        if (r107 == null) goto L64;
        r107.setAvatarLoadRetryCount(0);     // Catch: Exception -> L53
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L19:
        if (r102.intValue() != 8) goto L30;
        Long r108 = r101.b();     // Catch: Exception -> L53
        Float r109 = r101.c();     // Catch: Exception -> L53
        if (r108 == null) goto L59;
        if (r109 == null) goto L60;
        HamletAvatarContext r110 = this.f73443f;     // Catch: Exception -> L53
        if (r110 == null) goto L29;
        Map<Long, Float> r111 = r110.getDownloadAvatarProgressRecord();     // Catch: Exception -> L53
        if (r111 == null) goto L29;
        Float r112 = r111.put(r108, r109);     // Catch: Exception -> L53
    L29:
        Pq(r108.longValue(), r109.floatValue());     // Catch: Exception -> L53
        return;
    L60:
        return;
    L59:
        return;
    L6:
        if (r102.intValue() != 7) goto L16;
        Long r113 = r101.b();     // Catch: Exception -> L53
        if (r113 == null) goto L57;
        HamletAvatarContext r114 = this.f73443f;     // Catch: Exception -> L53
        if (r114 == null) goto L15;
        Map<Long, Float> r115 = r114.getDownloadAvatarProgressRecord();     // Catch: Exception -> L53
        if (r115 == null) goto L15;
        Float r116 = r115.put(r113, Float.valueOf(0.0f));     // Catch: Exception -> L53
    L15:
        Pq(r113.longValue(), 0.0f);     // Catch: Exception -> L53
        return;
    L57:
        return;
    L53:
        e = move-exception;
        ALogger.e("HamletAvatar", "handleAvatarDownloadMessage exception=" + Log.getStackTraceString(e));
    }

    @Override // gd1.b.a
    public final void Ln(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ALogger.e("HamletAvatar", "onXplayMessage, msg=" + r100);     // Catch: Exception -> L46
        int r101 = JSONObjectProtectorUtils.getInt(new JSONObject(r100), com.heytap.mcssdk.constant.b.f276353c);     // Catch: Exception -> L46
        boolean r102 = true;
        if (r101 != 7) goto L6;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        Jq(r100);     // Catch: Exception -> L46
    L22:
        int r104 = ff0.e.f476648a;     // Catch: Exception -> L46
        if (r101 != 2001) goto L25;
    L32:
        boolean r105 = true;
    L33:
        if (r105 == false) goto L36;
        fr(r100);     // Catch: Exception -> L46
    L36:
        if (r101 != 2021) goto L38;
    L43:
        if (r102 == false) goto L51;
        Fq(r100);     // Catch: Exception -> L46
        return;
    L51:
        return;
    L38:
        if (r101 == 2022) goto L43;
        if (r101 == 2003) goto L43;
        r102 = false;
        goto L43
    L25:
        if (r101 == 2002) goto L32;
        if (r101 == 2011) goto L32;
        if (r101 == 2012) goto L32;
        r105 = false;
        goto L33
    L17:
        if (r101 != 11) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        Gq(r100);     // Catch: Exception -> L46
        goto L22
    L19:
        r106 = false;
        goto L20
    L6:
        if (r101 == 8) goto L13;
        if (r101 == 9) goto L13;
        if (r101 == 10) goto L13;
        r103 = false;
    L46:
        e = move-exception;
        ALogger.e("HamletAvatar", "onXplayMessage exception=" + Log.getStackTraceString(e));
    }

    public final boolean Lq(i3 r100) {
        String r101 = r100.getRtcRoomId();
        x0 r102 = this.G;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.a();
    L7:
        if (Intrinsics.areEqual(r101, r104) == false) goto L14;
        String r105 = r100.getRtcUserId();
        x0 r106 = this.G;
        if (r106 == null) goto L12;
        r103 = r106.b();
    L12:
        if (Intrinsics.areEqual(r105, r103) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r104 = null;
        goto L7
    }

    public final void Nq(String r100) {
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L54;
        rj0.d r102 = r101.getCommonService();
        if (r102 == null) goto L55;
        com.bytedance.android.live.pushstream.d r103 = r102.getLiveStream();
        if (r103 == null) goto L60;
        HamletAvatarContext r104 = this.f73443f;
        boolean r105 = false;
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r106 = r104.isRtcClientInitialized();
        if (r106 == null) goto L16;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L16;
        boolean r108 = r107.booleanValue();
    L17:
        HamletAvatarContext r109 = this.f73443f;
        if (r109 == null) goto L25;
        com.bytedance.live.datacontext.m<Boolean> r110 = r109.isStreamRending();
        if (r110 == null) goto L25;
        Boolean r111 = r110.getValue();
        if (r111 == null) goto L25;
        r105 = r111.booleanValue();
    L25:
        if (gh0.a.d() == false) goto L56;
        ALogger.i("HamletAvatar", "notifyAnchorVideoPush, from=" + r100 + " isHamletStreamRending=" + r105 + ", isRtcClientInited=" + r108);
        ei6.a r112 = null;
        if (r105 == false) goto L32;
        boolean r113 = ff0.c.f476645a;
        if (vm2.d.I().getSetLiveCoreSurfaceViewNull() == false) goto L31;
        this.f73451n = r103.getSurfaceView();
        r103.K0(null);
    L31:
        r103.Z0(4, new uv0.a(LiveRequestSourceRole.Business, "HamletAvatarWidget.switchExtern", null));
        r103.D();
        ff0.d r114 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "switch_extern_video_capture", 0, null, null, 28);
    L38:
        if (r108 == false) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.a.f75481g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r115 = com.bytedance.android.live.liveinteract.plantform.base.a.C1183a.a();
        if (r115 == null) goto L44;
        hg6.g r116 = r115.R1();
        if (r116 == null) goto L44;
        r116.e0("hamlet avatar video frame push");
    L44:
        com.bytedance.android.live.liveinteract.plantform.base.a r117 = com.bytedance.android.live.liveinteract.plantform.base.a.C1183a.a();
        if (r117 == null) goto L49;
        hg6.g r118 = r117.R1();
        if (r118 == null) goto L49;
        r112 = r118.V0();
    L49:
        if (r112 == null) goto L58;
        vi6.a r119 = r112.v();
        if (r119 == null) goto L59;
        r119.f();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L32:
        boolean r120 = ff0.c.f476645a;
        if (vm2.d.I().getSetLiveCoreSurfaceViewNull() == false) goto L37;
        View r121 = this.f73451n;
        if (r121 == null) goto L37;
        r103.K0(r121);
    L37:
        r103.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "HamletAvatarWidget.switchRadio", null));
        r103.D();
        ff0.d r122 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "switch_radio_video_capture", 0, null, null, 28);
        goto L38
    L56:
        return;
    L16:
        r108 = false;
        goto L17
    L60:
        return;
    L55:
        return;
    }

    @Override // gd0.g
    public final void Ph(long r100) {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r101 == null) goto L12;
        Iterable r102 = r101.getOnlineUserList();
        if (r102 == null) goto L12;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (((ILinkPlayerInfoBridge) r105).isEnlarged() == false) goto L8;
        r103.add(r105);
    L13:
        ALogger.e("wuzhixin", "playInteractiveAnimation, animationIndex=" + r100 + ", enlargeUserList.size=" + r103.size());
        if (r103.size() >= 2) goto L16;
        f2.b(R.string.ttlive_audio_hamlet_double_action_in_single_enlarge_toast, 0);
    L16:
        int r106 = ff0.e.f476648a;
        com.bytedance.android.live.liveinteract.hamlet.model.t r107 = new com.bytedance.android.live.liveinteract.hamlet.model.t();
        r107.b(r100);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r107), null);
        return;
    L12:
        r103 = new ArrayList();
        goto L13
    }

    public final void Qq(int r100) {
        JsonObject r101 = new JsonObject();
        r101.addProperty("type", "action_index_change");
        JsonObject r102 = new JsonObject();
        r102.addProperty("index", Integer.valueOf(r100));
        Unit r103 = Unit.INSTANCE;
        r101.add("data", r102);
        ih0.b r104 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r104 == null) goto L6;
        r104.Dk("avatar", "avatar_event", r101, false);
        return;
    }

    public final void Rq(boolean r100) {
        JsonObject r101 = new JsonObject();
        HamletAvatarContext r102 = HamletAvatarContext.Companion.getContext();
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.isStreamRending();
        if (r103 == null) goto L9;
        int r104 = 1;
        if (r103.getValue().booleanValue() != true) goto L9;
    L10:
        r101.addProperty("type", ChameleonOpenTracker.Stage.RENDER);
        JsonObject r105 = new JsonObject();
        r105.addProperty("is_render", Boolean.valueOf(r100));
        HamletAvatarContext r106 = this.f73443f;
        if (r106 == null) goto L18;
        com.bytedance.live.datacontext.n<Long> r107 = r106.getCurrentSelectAvatarID();
        if (r107 == null) goto L18;
        Long r108 = r107.getValue();
        if (r108 == null) goto L18;
        String r109 = String.valueOf(r108.longValue());
        if (r109 == null) goto L18;
    L19:
        r105.addProperty("avatar_id", r109);
        r105.addProperty("is_xplay_running", Integer.valueOf(r104));
        Unit r110 = Unit.INSTANCE;
        r101.add("data", r105);
        ih0.b r111 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r111 == null) goto L23;
        r111.Dk("avatar", "avatar_event", r101, false);
        return;
    L23:
        return;
    L18:
        r109 = "0";
    L9:
        r104 = 0;
        goto L10
    }

    public final void Tq(boolean r100) {
        ALogger.e("HamletAvatar", "notifyLynxMultiCameraStatus, multiCamera=" + r100 + ", trace=" + Log.getStackTraceString(new Throwable()));
        JsonObject r101 = new JsonObject();
        r101.addProperty("type", "multi_camera_status");
        JsonObject r102 = new JsonObject();
        r102.addProperty("multi_camera_status", Integer.valueOf(r100 ? 1 : 0));
        Unit r103 = Unit.INSTANCE;
        r101.add("data", r102);
        ih0.b r104 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r104 == null) goto L6;
        r104.Dk("avatar", "avatar_event", r101, false);
        return;
    }

    public final void Wq(boolean r100) {
        JsonObject r101 = new JsonObject();
        r101.addProperty("type", "xplay_first_frame_state");
        JsonObject r102 = new JsonObject();
        r102.addProperty("state", Integer.valueOf(r100 ? 1 : 0));
        Unit r103 = Unit.INSTANCE;
        r101.add("data", r102);
        ih0.b r104 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r104 == null) goto L6;
        r104.Dk("avatar", "avatar_event", r101, false);
        return;
    }

    @Override // gd0.g
    public final void Yc(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "avatarIds");
        int r101 = ff0.e.f476648a;
        Intrinsics.checkNotNullParameter(r100, "allAvatarIds");
        com.bytedance.android.live.liveinteract.hamlet.model.u r102 = new com.bytedance.android.live.liveinteract.hamlet.model.u();
        r102.b(r100);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r102), null);
    }

    public final void Yq(int r100) {
        long r101 = je0.d.a0();
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).xplayInitCallback(r101, r100).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r100), new g(r100)), this.f73438a);
    }

    public final void Zq(Integer r100) {
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        HamletAvatarContext r102 = this.f73443f;
        if (r102 == null) goto L14;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.isAvatarRending();
        if (r103 == null) goto L14;
        Boolean r104 = r103.getValue();
    L16:
        if ((true ^ Intrinsics.areEqual(r104, Boolean.valueOf(r101))) == false) goto L23;
        HamletAvatarContext r105 = this.f73443f;
        if (r105 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.isAvatarRending();
        if (r106 == null) goto L25;
        r106.setValue(Boolean.valueOf(r101));
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L14:
        r104 = null;
        goto L16
    L6:
        if (r100.intValue() != 1) goto L8;
        r101 = true;
        goto L9
    }

    @Override // gd0.g
    public final void eh(boolean r100) {
        ALogger.i("HamletAvatar", "changeFullBody, isFullBody:" + r100);
        int r101 = ff0.e.f476648a;
        com.bytedance.android.live.liveinteract.hamlet.model.h r102 = new com.bytedance.android.live.liveinteract.hamlet.model.h();
        r102.b(Integer.valueOf(r100 ? 1 : 0));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r102), null);
    }

    public final void fr(String r100) {
        JsonObject r101 = new JsonObject();
        r101.addProperty("type", "receive_xplay_msg");
        JsonObject r102 = new JsonObject();
        r102.addProperty("msg", r100);
        Unit r103 = Unit.INSTANCE;
        r101.add("data", r102);
        ih0.b r104 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r104 == null) goto L6;
        r104.Dk("avatar", "avatar_event", r101, false);
        return;
    }

    public final void hr(long r110) {
        if (r110 <= 0) goto L5;
        int r100 = 1;
    L6:
        ff0.d r101 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(r100, "delay_send_audio", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("delay_time", String.valueOf(r110))}), 12);
        Function0<hg6.g> r102 = this.R;
        if (r102 == null) goto L12;
        hg6.g r103 = r102.invoke();
        if (r103 == null) goto L13;
        r103.g0(r110);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r100 = 2;
        goto L6
    }

    @Override // gd0.g
    public final boolean mg(int r100) {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r101 == null) goto L12;
        Iterable r102 = r101.getOnlineUserList();
        if (r102 == null) goto L12;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if (((ILinkPlayerInfoBridge) r105).isEnlarged() == false) goto L8;
        r103.add(r105);
    L14:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r100) == false) goto L28;
        ILinkPlayerInfoBridge r106 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r103);
        Boolean r107 = null;
        if (r106 == null) goto L18;
        String r108 = r106.getInteractId();
    L19:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r109 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, this.dataCenter);
        if (r109 == null) goto L27;
        BehaviorSubject<Map<String, Boolean>> r110 = r109.j1();
        if (r110 == null) goto L27;
        Map<String, Boolean> r111 = r110.getValue();
        if (r111 == null) goto L27;
        r107 = r111.get(r108);
    L27:
        return Intrinsics.areEqual(r107, Boolean.TRUE);
    L18:
        r108 = null;
        goto L19
    L28:
        ILinkPlayerInfoBridge r112 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r103);
        if (r112 != null) goto L38;
        return false;
    L38:
        return com.bytedance.android.live.liveinteract.plantform.model.n.h(r112);
    L12:
        r103 = new ArrayList();
        goto L14
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r310) {
        boolean r110 = false;
        if ((r310 instanceof g9) == false) goto L213;
        g9 r100 = (g9) r310;
        int r111 = r100.getMsg_type();
        String r112 = null;
        if (r111 == 3) goto L137;
        if (r111 == 4) goto L112;
        if (r111 != 5) goto L9;
        i3 r101 = r100.getNotifyMultiAvatarPublicStream();
        if (r101 == null) goto L274;
        HamletAvatarContext.a r102 = HamletAvatarContext.Companion;
        HamletAvatarContext r103 = r102.getContext();
        if (r103 == null) goto L43;
        com.bytedance.live.datacontext.n<Integer> r104 = r103.getCurrentState();
        if (r104 == null) goto L43;
        Integer r105 = r104.getValue();
    L45:
        if (gh0.a.d() == false) goto L274;
        if (r105 == null) goto L274;
        if (r105.intValue() != 3) goto L274;
        String r106 = r101.getPrompt();
        if (r106 != null) goto L53;
    L55:
        boolean r107 = false;
    L56:
        if (r107 == false) goto L59;
        f2.c(r106, 0);
    L59:
        if (r101.getStatus() != 0) goto L106;
        if (TextUtils.isEmpty(r101.getMixStreamTaskId()) == false) goto L84;
        this.F = r101.getPublicStreamId();
        HamletAvatarContext r108 = this.f73443f;
        if (r108 == null) goto L65;
        r108.setMainStreamPublicStreamReady(true);
    L65:
        Function0<hg6.g> r109 = this.R;
        if (r109 == null) goto L74;
        hg6.g r113 = r109.invoke();
        if (r113 == null) goto L74;
        ei6.a r114 = r113.V0();
        if (r114 == null) goto L74;
        vi6.a r115 = r114.v();
        if (r115 == null) goto L74;
        r115.f();
    L74:
        HamletAvatarContext r116 = r102.getContext();
        if (r116 == null) goto L77;
        long r117 = r116.getPlayModeStartTs();
    L78:
        af0.a.f3134a.getClass();
        long r118 = System.currentTimeMillis() - r117;
        LinkMonitorData r119 = LinkMonitorData.HamletAvatarOpenSuccess;     // Catch: Exception -> L266
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L266
        r120.put("duration", r118);     // Catch: Exception -> L266
        Unit r121 = Unit.INSTANCE;     // Catch: Exception -> L266
        af0.a.l(r119, r120);     // Catch: Exception -> L266
    L80:
        af0.a.f3134a.getClass();
        long r122 = System.currentTimeMillis() - 0;
        LinkMonitorData r123 = LinkMonitorData.HamletAvatarMainPublicStreamCreateSuccess;     // Catch: Exception -> L83
        JSONObject r124 = new JSONObject();     // Catch: Exception -> L83
        r124.put("duration", r122);     // Catch: Exception -> L83
        Unit r125 = Unit.INSTANCE;     // Catch: Exception -> L83
        af0.a.l(r123, r124);     // Catch: Exception -> L83
    L97:
        ff0.d r126 = ff0.d.f476647a;
        Pair[] r127 = new Pair[4];
        r127[0] = TuplesKt.to("targetStreamInfo_roomId", String.valueOf(r101.getRtcRoomId()));
        r127[1] = TuplesKt.to("targetStreamInfo_uid", String.valueOf(r101.getRtcUserId()));
        x0 r128 = this.G;
        if (r128 == null) goto L100;
        String r129 = r128.a();
    L101:
        r127[2] = TuplesKt.to("currentStreamInfo_roomId", String.valueOf(r129));
        x0 r130 = this.G;
        if (r130 == null) goto L104;
        r112 = r130.b();
    L104:
        r127[3] = TuplesKt.to("currentStreamInfo_uid", String.valueOf(r112));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "onMultiAvatarPublicStreamMessageRev", 0, null, MapsKt.mutableMapOf(r127), 12);
        goto L274
    L100:
        r129 = null;
        goto L101
    L77:
        r117 = 0;
        goto L78
    L84:
        af0.a.f3134a.getClass();
        long r131 = System.currentTimeMillis() - 0;
        LinkMonitorData r132 = LinkMonitorData.HamletAvatarSubPublicStreamCreateSuccess;     // Catch: Exception -> L87
        JSONObject r133 = new JSONObject();     // Catch: Exception -> L87
        r133.put("duration", r131);     // Catch: Exception -> L87
        Unit r134 = Unit.INSTANCE;     // Catch: Exception -> L87
        af0.a.l(r132, r133);     // Catch: Exception -> L87
    L89:
        if (Lq(r101) == false) goto L97;
        Bq();
        ff0.d r135 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "createNewCamera start", 0, null, new LinkedHashMap(), 12);
        af0.a.f3134a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarCameraCreateStart);
        long r136 = System.currentTimeMillis();
        MultiCameraApi r137 = (MultiCameraApi) com.bytedance.android.live.network.c.b().e(MultiCameraApi.class);
        IRoom r138 = je0.d.e(null);
        if (r138 == null) goto L93;
        Long r139 = Long.valueOf(r138.getRoomId());
    L94:
        Disposable r140 = r137.createCameraInfo(r139, null, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new s(this, r136, r101), t.f73525a);
        if (r140 == null) goto L97;
        RxUtilKt.c(r140, this.f73438a);
        goto L97
    L93:
        r139 = null;
        goto L94
    L106:
        if (TextUtils.isEmpty(r101.getMixStreamTaskId()) == false) goto L108;
        af0.a.f3134a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarMainPublicStreamCreateFail);
        goto L274
    L108:
        af0.a.f3134a.getClass();
        LinkMonitorData r141 = LinkMonitorData.HamletAvatarSubPublicStreamCreateFail;     // Catch: Exception -> L267
        JSONObject r142 = new JSONObject();     // Catch: Exception -> L267
        r142.put("error_code", 0);     // Catch: Exception -> L267
        Unit r143 = Unit.INSTANCE;     // Catch: Exception -> L267
        af0.a.l(r141, r142);     // Catch: Exception -> L267
        goto L274
    L53:
        if (r106.length() <= 0) goto L55;
        r107 = true;
    L43:
        r105 = null;
    L274:
        ff0.d r144 = ff0.d.f476647a;     // Catch: Exception -> L265
        com.bytedance.android.live.liveinteract.utils.j.a(1, "notify_multiAvatar_public_stream_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("content", GsonHelper.get().toJson(r310))}), 12);     // Catch: Exception -> L265
        return;
    L310:
        return;
    L9:
        if (r111 != 100) goto L11;
        DataCenter r145 = this.dataCenter;
        Boolean r146 = Boolean.TRUE;
        r145.put("data_hamlet_avatar_status", r146);
        e1 r147 = r100.getHamletAvatarStartContent();
        if (r147 != null) goto L24;
        return;
    L24:
        if (r147.getMultiAvatarMode() != true) goto L283;
        HamletAvatarContext r148 = this.f73443f;
        if (r148 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r149 = r148.isMultiAvatarMode();
        if (r149 == null) goto L30;
        r149.setValue(r146);
    L30:
        HamletAvatarContext r150 = this.f73443f;
        if (r150 == null) goto L33;
        r150.setMultiAvatarModeForReport(true);
    L33:
        TalkRoomLogUtils.f77445m = r146;
        ViewGroup r151 = this.Q;
        if (r151 == null) goto L284;
        r151.setVisibility(0);
        return;
    L284:
        return;
    L283:
        return;
    L11:
        if (r111 != 101) goto L307;
        DataCenter r152 = this.dataCenter;
        Boolean r153 = Boolean.FALSE;
        r152.put("data_hamlet_avatar_status", r153);
        ViewGroup r154 = this.Q;
        if (r154 == null) goto L16;
        r154.setVisibility(8);
    L16:
        HamletAvatarContext r155 = this.f73443f;
        if (r155 == null) goto L279;
        com.bytedance.live.datacontext.m<Boolean> r156 = r155.isMultiAvatarMode();
        if (r156 == null) goto L280;
        r156.setValue(r153);
        return;
    L280:
        return;
    L279:
        return;
    L307:
        return;
    L112:
        Aq("IM from server", true);
        ff0.d r157 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "Xplay close message recieved", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_id", String.valueOf(r310.getMessageId()))}), 12);
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r158 = this.f73456s;
        if (r158 == null) goto L116;
        r158.f76433b = null;
        r158.f76434c = null;
        r158.f76435d = null;
        r158.c();
    L116:
        if (ff0.c.b() == false) goto L127;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "disable_audio_vad_report", 0, null, null, 28);
        Function0<hg6.g> r159 = this.R;
        if (r159 == null) goto L127;
        hg6.g r160 = r159.invoke();
        if (r160 == null) goto L127;
        ei6.a r161 = r160.V0();
        if (r161 == null) goto L127;
        ri6.b r162 = r161.r();
        if (r162 == null) goto L127;
        r162.q();
    L127:
        if (vm2.d.I().getAedEnable() == false) goto L286;
        com.bytedance.android.live.liveinteract.utils.j.a(2, "disable_audio_aed_report", 0, null, null, 28);
        Function0<hg6.g> r163 = this.R;
        if (r163 == null) goto L287;
        hg6.g r164 = r163.invoke();
        if (r164 == null) goto L288;
        ei6.a r165 = r164.V0();
        if (r165 == null) goto L289;
        ri6.b r166 = r165.r();
        if (r166 == null) goto L290;
        r166.x();
        return;
    L290:
        return;
    L289:
        return;
    L288:
        return;
    L287:
        return;
    L286:
        return;
    L137:
        HamletAvatarContext r167 = HamletAvatarContext.Companion.getContext();
        if (r167 == null) goto L142;
        com.bytedance.live.datacontext.n<Integer> r168 = r167.getCurrentState();
        if (r168 == null) goto L142;
        Integer r169 = r168.getValue();
    L143:
        ff0.d r170 = ff0.d.f476647a;
        Pair[] r171 = new Pair[11];
        x5 r210 = r100.getXplayINitContent();
        Object r211 = "";
        if (r210 == null) goto L146;
        Object r212 = Long.valueOf(r210.getInitType());
    L147:
        r171[0] = TuplesKt.to("init_type", String.valueOf(r212));
        if (r169 != null) goto L150;
        Object r172 = "";
    L151:
        r171[1] = TuplesKt.to("xplay_state", String.valueOf(r172));
        x5 r173 = r100.getXplayINitContent();
        if (r173 == null) goto L155;
        String r174 = r173.getInitParam();
        if (r174 == null) goto L155;
    L156:
        r171[2] = TuplesKt.to("init_param", r174);
        x5 r175 = r100.getXplayINitContent();
        if (r175 == null) goto L160;
        String r176 = r175.getChannel();
        if (r176 == null) goto L160;
    L161:
        r171[3] = TuplesKt.to("channel", r176);
        x5 r177 = r100.getXplayINitContent();
        if (r177 == null) goto L165;
        String r178 = r177.getGameId();
        if (r178 == null) goto L165;
    L166:
        r171[4] = TuplesKt.to("game_id", r178);
        x5 r179 = r100.getXplayINitContent();
        if (r179 == null) goto L171;
        w5 r180 = r179.getHamletAvatarInit();
        if (r180 == null) goto L171;
        Object r181 = Long.valueOf(r180.getAvatarId());
    L172:
        r171[5] = TuplesKt.to("avatar_id", String.valueOf(r181));
        x5 r182 = r100.getXplayINitContent();
        if (r182 == null) goto L177;
        w5 r183 = r182.getHamletAvatarInit();
        if (r183 == null) goto L177;
        Boolean r184 = Boolean.valueOf(r183.getMultiAvatarMode());
    L178:
        r171[6] = TuplesKt.to("multi_avatar_mode", String.valueOf(r184));
        HamletAvatarContext r185 = this.f73443f;
        if (r185 == null) goto L183;
        com.bytedance.live.datacontext.m<Boolean> r186 = r185.isRtcClientInitialized();
        if (r186 == null) goto L183;
        Boolean r187 = r186.getValue();
    L184:
        r171[7] = TuplesKt.to("rtc_client_inited", String.valueOf(r187));
        r171[8] = TuplesKt.to("msg_id", String.valueOf(r310.getMessageId()));
        g9 r188 = (g9) r310;
        x5 r189 = r188.getXplayINitContent();
        if (r189 == null) goto L188;
        String r190 = r189.getVideoSimulcast();
        if (r190 == null) goto L188;
    L189:
        r171[9] = TuplesKt.to("video_simulcast", r190);
        x5 r191 = r188.getXplayINitContent();
        if (r191 == null) goto L192;
        r211 = Long.valueOf(r191.getVideoSimulcastIndex());
    L192:
        r171[10] = TuplesKt.to("video_simulcast_index", String.valueOf(r211));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "init_xplay_message_receive", 0, null, MapsKt.mutableMapOf(r171), 12);
        if (ig.f120450a.getValue().getEnableBlockInitMsg() == false) goto L199;
        if (r169 == null) goto L199;
        if (r169.intValue() != 3) goto L199;
        return;
    L199:
        x5 r192 = r188.getXplayINitContent();
        if (r192 != null) goto L202;
        return;
    L202:
        if (r192.getInitType() != 0) goto L278;
        x5 r193 = r188.getXplayINitContent();
        if (r193 == null) goto L292;
        this.f73457t = r193;
        Kq(r193, true, true, false);
        w5 r194 = r193.getHamletAvatarInit();
        if (r194 == null) goto L293;
        long r195 = r194.getAvatarId();
        if (r195 <= 0) goto L294;
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).notifyAvatarChange(je0.d.a0(), r195).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(r195), i.f73474a), this.f73438a);
        return;
    L294:
        return;
    L293:
        return;
    L292:
        return;
    L278:
        return;
    L188:
        r190 = "";
    L183:
        r187 = null;
    L177:
        r184 = null;
    L171:
        r181 = "";
    L165:
        r178 = "";
    L160:
        r176 = "";
    L155:
        r174 = "";
        goto L156
    L150:
        r172 = r169;
        goto L151
    L146:
        r212 = "";
    L142:
        r169 = null;
        goto L143
    L213:
        if ((r310 instanceof d2) == true) goto L215;
        return;
    L215:
        if (jg.f120523a.getValue().booleanValue() == true) goto L218;
        ALogger.i("HamletAvatar", "LIVE_BIG_EVENT_ENABLE_LOCAl=false messageType=" + ((d2) r310).getMsgType());
        return;
    L218:
        d2 r196 = (d2) r310;
        switch(r196.getMsgType()) {
            case 14: goto L251;
            case 15: goto L231;
            case 16: goto L221;
            default: goto L309;
        };
    L221:
        boolean r197 = ff0.c.b();
        int r198 = r196.getSwitch_avatar_vad_mode_content().getAvatarVADMode();
        ff0.d r199 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "receive_big_event_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "switch_vad_status"), TuplesKt.to("vad_enable_before", String.valueOf(r197)), TuplesKt.to("to_vad_status", String.valueOf(r198))}), 12);
        if (r198 == LinkMicBigEventMessage.SwitchAvatarVADModeContent.AvatarVADMode.VADModeOn.getValue()) goto L226;
        if (r198 == LinkMicBigEventMessage.SwitchAvatarVADModeContent.AvatarVADMode.VADModeOff.getValue()) goto L226;
        return;
    L226:
        if (r198 != LinkMicBigEventMessage.SwitchAvatarVADModeContent.AvatarVADMode.VADModeOff.getValue()) goto L228;
        r110 = true;
    L228:
        ff0.c.f476645a = r110;
        boolean r200 = ff0.c.b();
        ALogger.i("HamletAvatar", "LinkMicBigEventMessage.SwitchAvatarVADMode, vadModeByServer=" + r198 + " isVadEnableBefore=" + r197 + " isVadEnableNow=" + r200);
        if (r197 == r200) goto L298;
        int r201 = ze0.a.f571504a;
        ff0.c.b();
        return;
    L298:
        return;
    L231:
        HamletAvatarContext r202 = this.f73443f;
        if (r202 == null) goto L238;
        com.bytedance.live.datacontext.n<Long> r203 = r202.getCurrentSelectAvatarID();
        if (r203 == null) goto L238;
        Long r204 = r203.getValue();
        if (r204 == null) goto L238;
        long r1100 = r204.longValue();
    L239:
        int r205 = r196.getSwitch_avatar_action_content().getAvatarActionType();
        long r206 = r196.getSwitch_avatar_action_content().getAvatarId();
        long r1101 = r196.getSwitch_avatar_action_content().getLoopActionIndex();
        long r207 = r196.getSwitch_avatar_action_content().getSingleActionId();
        ALogger.i("HamletAvatar", "LinkMicBigEventMessage.SwitchAvatarAction, currentAvatarId:" + r1100 + " toChangeActionAvatarId:" + r206 + " avatarActionType=" + r205 + " toChangeLoopActionIndex=" + r1101 + " toChangeSingeActionId=" + r207);
        ff0.d r208 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "receive_big_event_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "switch_avatar_act"), TuplesKt.to("avatar_id", String.valueOf(r1100)), TuplesKt.to("to_avatar_id", String.valueOf(r206)), TuplesKt.to("act_type", String.valueOf(r205)), TuplesKt.to("singe_act_id", String.valueOf(r207)), TuplesKt.to("loop_act_index", String.valueOf(r1101))}), 12);
        if (r1100 == r206) goto L242;
        return;
    L242:
        if (r205 != LinkMicBigEventMessage.SwitchAvatarActionContent.AvatarActionType.ActionTypeLoop.getValue()) goto L247;
        if (r1101 < 0) goto L247;
        Jf(r1101);
        Qq((int) r1101);
        return;
    L247:
        if (r205 == LinkMicBigEventMessage.SwitchAvatarActionContent.AvatarActionType.ActionTypeSingle.getValue()) goto L249;
        return;
    L249:
        if (r207 < 0) goto L303;
        E7(r207);
        return;
    L303:
        return;
    L238:
        r1100 = 0;
        goto L239
    L251:
        long r209 = r196.getSwitch_avatar_content().getAvatarId();
        HamletAvatarContext r213 = this.f73443f;
        if (r213 == null) goto L258;
        com.bytedance.live.datacontext.n<Long> r214 = r213.getCurrentSelectAvatarID();
        if (r214 == null) goto L258;
        Long r215 = r214.getValue();
        if (r215 == null) goto L258;
        long r216 = r215.longValue();
    L259:
        ALogger.i("HamletAvatar", "LinkMicBigEventMessage.SwitchAvatar, fromAvatarId:" + r216 + " toAvatarId:" + r209);
        ff0.d r217 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "receive_big_event_msg", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "switch_avatar_act"), TuplesKt.to("from_id", String.valueOf(r216)), TuplesKt.to("to_id", String.valueOf(r209))}), 12);
        if (r216 != r209) goto L262;
        return;
    L262:
        if (r209 <= 0) goto L306;
        uc(r209);
        return;
    L306:
        return;
    L258:
        r216 = 0;
        goto L259
    }

    @Override // gd0.g
    public final void tg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: Exception -> L11
        if (r101 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r102 = r101.getLinkUserInfoCenter();     // Catch: Exception -> L11
        if (r102 == null) goto L8;
        long r103 = r102.getLastVersion();     // Catch: Exception -> L11
    L9:
        JSONObject r104 = new JSONObject(r100);     // Catch: Exception -> L11
        r104.put("linkVersion", r103);     // Catch: Exception -> L11
        String r105 = r104.toString();     // Catch: Exception -> L11
        ALogger.e("HamletAvatar", "sendXplayMessage, msg=" + r105);     // Catch: Exception -> L11
        er(r105, null);     // Catch: Exception -> L11
        return;
    L8:
        r103 = 0;
    L11:
        e = move-exception;
        ALogger.e("HamletAvatar", "sendXplayMessage exception=" + Log.getStackTraceString(e));
    }

    @Override // gd0.g
    public final void uc(long r100) {
        ALogger.i("HamletAvatar", "changeAvatar, avatarId:" + r100);
        HamletAvatarContext r101 = this.f73443f;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.n<Long> r102 = r101.getCurrentSelectAvatarID();
        if (r102 == null) goto L7;
        r102.setValue(Long.valueOf(r100));
    L7:
        int r103 = ff0.e.f476648a;
        com.bytedance.android.live.liveinteract.hamlet.model.g r104 = new com.bytedance.android.live.liveinteract.hamlet.model.g();
        r104.b(Long.valueOf(r100));
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r104), this.f73437J);
    }

    @Override // gd0.g
    public final void zi(boolean r100) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (hd0.c.f().h() == true) goto L14;
        HamletAvatarContext r101 = this.f73443f;
        if (r101 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.isStreamRending();
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.getValue().booleanValue() != true) goto L17;
        Aq("admin changed", true);
        return;
    L17:
        return;
    L15:
        return;
    }

    public static final void yq(HamletAvatarWidget r100, boolean r101) {
        if (r100.A != r101) goto L5;
        return;
    L5:
        if (r100.W3() <= 0) goto L7;
        return;
    L7:
        if (r100.kl() == true) goto L37;
        Boolean r102 = (Boolean) r100.dataCenter.get("data_hamlet_avatar_status", Boolean.FALSE);
        HamletAvatarContext r103 = r100.f73443f;
        boolean r104 = false;
        if (r103 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r105 = r103.isAvatarRending();
        if (r105 == null) goto L15;
        Boolean r106 = r105.getValue();
        if (r106 == null) goto L15;
        boolean r107 = r106.booleanValue();
    L16:
        HamletAvatarContext r108 = HamletAvatarContext.Companion.getContext();
        if (r108 == null) goto L23;
        com.bytedance.live.datacontext.m<Integer> r109 = r108.getDirecting();
        if (r109 == null) goto L23;
        Integer r110 = r109.getValue();
        if (r110 == null) goto L23;
        int r111 = r110.intValue();
    L25:
        if (r111 <= 0) goto L27;
        boolean r112 = true;
    L29:
        if (r102.booleanValue() == false) goto L33;
        if (r107 == true) goto L33;
        if (r112 == true) goto L33;
        r104 = true;
    L33:
        r100.Sq(r104, r101);
        r100.A = r101;
        return;
    L27:
        r112 = false;
    L23:
        r111 = 0;
    L15:
        r107 = false;
        goto L16
    }

    public final void Aq(String r100, boolean r101) {
        HamletAvatarContext.a r102 = HamletAvatarContext.Companion;
        HamletAvatarContext r103 = r102.getContext();
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.isMultiAvatarMode();
        if (r104 == null) goto L9;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        ALogger.i("HamletAvatar", "closeXPlay reason=" + r100 + ", isMultiAvatarMode=" + r106);
        HamletAvatarContext r107 = this.f73443f;
        boolean r108 = true;
        if (r107 != null) goto L13;
    L17:
        this.f73450m = false;
        gd1.b r109 = this.f73441d;
        if (r109 == null) goto L20;
        r109.c(XplayBasicMessageType.Orser_Song_Message);
    L20:
        if (r101 == false) goto L22;
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.f59443b.e(r100);
    L22:
        HamletAvatarContext r110 = this.f73443f;
        if (r110 == null) goto L25;
        r110.resetXplayState();
    L25:
        int r111 = vd0.a.f554147g;
        vd0.a.C7981a.a(this.dataCenter).c();
        if (r106 == true) goto L28;
        Nq("closeXPlay, reason=".concat(r100));
    L28:
        gf0.d r112 = this.f73446i;
        if (r112 == null) goto L31;
        r112.release();
    L31:
        Disposable r113 = this.f73461x;
        if (r113 == null) goto L34;
        r113.dispose();
    L34:
        Disposable r114 = this.f73463z;
        if (r114 == null) goto L37;
        r114.dispose();
    L37:
        this.C = false;
        if (gh0.a.d() == false) goto L41;
        if (r106 != true) goto L71;
        dr();
        return;
    L71:
        return;
    L41:
        dq1.a r115 = pm1.f.a();
        if (r115 == null) goto L44;
        int r116 = r115.W3();
    L45:
        HamletAvatarContext r117 = r102.getContext();
        if (r117 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r118 = r117.isAvatarRending();
        if (r118 == null) goto L52;
        Boolean r119 = r118.getValue();
        if (r119 == null) goto L52;
        boolean r120 = r119.booleanValue();
    L53:
        HamletAvatarContext r121 = r102.getContext();
        if (r121 == null) goto L60;
        com.bytedance.live.datacontext.m<Integer> r122 = r121.getDirecting();
        if (r122 == null) goto L60;
        Integer r123 = r122.getValue();
        if (r123 == null) goto L60;
        int r124 = r123.intValue();
    L61:
        if (r124 <= 0) goto L63;
        boolean r125 = true;
    L64:
        if (r116 > 0) goto L68;
        if (r120 == true) goto L68;
        if (r125 == true) goto L68;
    L69:
        Sq(r108, mg(0));
        return;
    L68:
        r108 = false;
        goto L69
    L63:
        r125 = false;
    L60:
        r124 = 0;
    L52:
        r120 = false;
        goto L53
    L44:
        r116 = 0;
        goto L45
    L13:
        if (r107.isXplayAudioEnable() != true) goto L17;
        ILivePlayerClient r126 = hs0.a.f486938b.getCurrentClient();
        if (r126 == null) goto L17;
        r126.unmute("HamletAvatarWidget.closeXPlay");
    L9:
        r106 = false;
        goto L10
    }

    public final void Pq(long r100, float r101) {
        JsonObject r102 = new JsonObject();
        r102.addProperty("avatar_id", Long.valueOf(r100));
        r102.addProperty("progress", Float.valueOf(r101));
        JsonObject r103 = new JsonObject();
        r103.addProperty("type", "avatar_progress");
        JsonObject r104 = new JsonObject();
        r104.add("avatar_progress", r102);
        Unit r105 = Unit.INSTANCE;
        r103.add("data", r104);
        ih0.b r106 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r106 == null) goto L6;
        r106.Dk("avatar", "avatar_event", r103, false);
        return;
    }

    public final void Sq(boolean r100, boolean r101) {
        JsonObject r102 = new JsonObject();
        r102.addProperty("type", "big_head");
        JsonObject r103 = new JsonObject();
        r103.addProperty("display", Boolean.valueOf(r100));
        r103.addProperty("talking", Boolean.valueOf(r101));
        Unit r104 = Unit.INSTANCE;
        r102.add("data", r103);
        ih0.b r105 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.dataCenter);
        if (r105 == null) goto L6;
        r105.Dk("avatar", "avatar_event", r102, false);
        return;
    }

    @Override // gd0.g
    public final void Zf(boolean r100, int r101) {
        Rq(r100);
        if (r100 == true) goto L6;
        if (r101 > 0) goto L6;
        boolean r102 = true;
    L7:
        Sq(r102, mg(0));
        af0.a r103 = af0.a.f3134a;
        long r104 = System.currentTimeMillis() - this.N;
        r103.getClass();
        LinkMonitorData r105 = LinkMonitorData.HamletAvatarFirstSeiDuration;     // Catch: Exception -> L10
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L10
        r106.put("duration", r104);     // Catch: Exception -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L10
        af0.a.l(r105, r106);     // Catch: Exception -> L10
        return;
    L13:
        return;
    L6:
        r102 = false;
        goto L7
    }

    public final void er(String r100, gd1.b.InterfaceC6009b r101) {
        gd1.b r102 = this.f73441d;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = this.I;
    L6:
        r102.d(r100, r101);
        return;
    }

    public HamletAvatarWidget(HamletInterceptTouchFrameLayout r100, Function0 r101, Function0 r102) {
        this.Q = r100;
        this.R = r101;
        this.S = r102;
        this.f73438a = new CompositeDisposable();
        this.f73445h = new ef0.c();
        this.f73453p = new Handler(Looper.getMainLooper());
        this.f73454q = new r(this);
        this.f73455r = new c0(this);
        this.f73458u = new ArrayList();
        this.f73462y = new LiveWrappedStreamSycnInfoConfig(LiveWrappedStreamIndex.STREAM_INDEX_MAIN, LiveWrappedStreamSycnInfoConfig.LiveWrappedSyncInfoStreamType.SYNC_INFO_STREAM_TYPE_AUDIO);
        this.B = MixStreamType.NONE;
        this.H = new LinkedHashMap();
        this.I = new y();
        this.f73437J = new x(this);
        this.K = new g0(this);
        this.O = new w(this);
        this.P = new h0(this);
    }

    public final void Mq(long r100, long r110, Long r111) {
        if (f4.f497200c.getValue().booleanValue() == false) goto L5;
    L19:
        ALogger.i("HamletAvatar", "joinCPosition, avatarId:" + r100 + "， version:" + r110 + ", position=" + r111);
        int r101 = ff0.e.f476648a;
        com.bytedance.android.live.liveinteract.hamlet.model.r r102 = new com.bytedance.android.live.liveinteract.hamlet.model.r();
        r102.b(r100);
        r102.d(r110);
        r102.c(r111);
        er(GsonProtectorUtils.toJson(GsonHelper.get(), r102), null);
        return;
    L5:
        if (r100 <= 0) goto L19;
        boolean r103 = ff0.c.f476645a;
        Function1<String, Unit> r104 = new HamletAvatarWidget$joinCPosition$1(this);
        Intrinsics.checkNotNullParameter(r104, "listener");
        Context r105 = s1.getContext();     // Catch: Exception -> L21
        if (r105 == null) goto L19;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105.getExternalCacheDir(), "live_hamlet_avatar");     // Catch: Exception -> L21
        if (r106.exists() == true) goto L13;
        r106.mkdirs();     // Catch: Exception -> L21
    L13:
        String r107 = (String) vm2.d.N6.getValue(null, vm2.d.f555776a[401(0x191, float:5.62E-43)]);     // Catch: Exception -> L21
        String r108 = UriProtector.parse(r107).getLastPathSegment();     // Catch: Exception -> L21
        if (r108 == null) goto L19;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r106, r108);     // Catch: Exception -> L21
        if (r109.exists() == false) goto L18;
        r104.invoke(r109.getAbsolutePath());     // Catch: Exception -> L21
        goto L19
    L18:
        Single.create(new ff0.a(Downloader.with(r105).url(r107).name(r108).monitorScene("hamlet_guide_image_download").savePath(r106.getAbsolutePath()).onlyWifi(false).retryCount(2).mainThreadListener(new ff0.b(r104)))).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());     // Catch: Exception -> L21
        goto L19
    }

    public final void Kq(x5 r310, boolean r311, boolean r312, boolean r313) {
        ALogger.i("HamletAvatar", "initXPlay, initXplayContent=" + r310.toString());
        HamletAvatarContext r100 = this.f73443f;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.n<Long> r101 = r100.getCurrentSelectAvatarID();
        if (r101 == null) goto L11;
        w5 r102 = r310.getHamletAvatarInit();
        if (r102 == null) goto L9;
        Long r103 = Long.valueOf(r102.getAvatarId());
    L10:
        r101.setValue(r103);
        goto L11
    L9:
        r103 = null;
    L11:
        HamletAvatarContext r104 = this.f73443f;
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.getXplyStartMessageRecived();
        if (r105 == null) goto L16;
        r105.setValue(Boolean.TRUE);
    L16:
        HamletAvatarContext r106 = this.f73443f;
        if (r106 == null) goto L19;
        r106.setXplayAudioEnable(r313);
    L19:
        Function0<hg6.g> r107 = this.R;
        if (r107 == null) goto L22;
        hg6.g r108 = r107.invoke();
    L24:
        if (r108 == null) goto L26;
        boolean r109 = r108.isEngineOn();
    L28:
        if (gh0.a.d() == false) goto L35;
        if (r109 == true) goto L35;
        ff0.d r110 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "join_channel", 0, null, null, 28);
        cg6.a r111 = Eq();
        if (r111 == null) goto L35;
        com.bytedance.live.bizlink.impl.platform.manager.a r112 = r111.A0();
        if (r112 == null) goto L35;
        r112.g();
    L35:
        ViewGroup r113 = this.Q;
        if (r113 == null) goto L293;
        r113.setVisibility(0);
        r113.getViewTreeObserver().addOnGlobalLayoutListener(new e(r113));
        w5 r114 = r310.getHamletAvatarInit();
        if (r114 == null) goto L49;
        List<Long> r115 = r114.getAllAvatarIds();
        if (r115 == null) goto L49;
        Iterator<T> r116 = r115.iterator();
    L43:
        if (r116.hasNext() == false) goto L49;
        long r117 = ((Number) r116.next()).longValue();
        HamletAvatarContext r118 = this.f73443f;
        if (r118 == null) goto L43;
        Map<Long, Float> r119 = r118.getDownloadAvatarProgressRecord();
        if (r119 == null) goto L43;
        Float r120 = r119.put(Long.valueOf(r117), Float.valueOf(0.0f));
    L49:
        LinkmicEcologyMessage.XPlayInitContent.a r121 = LinkmicEcologyMessage.XPlayInitContent.Companion;
        String r122 = r310.getVideoSimulcast();
        r121.getClass();
        Intrinsics.checkNotNullParameter(r122, "videoSimulcast");
        JSONArray r123 = new JSONArray(r122);     // Catch: Exception -> L52
    L54:
        if (r123 != null) goto L56;
    L69:
        HamletAvatarContext r124 = this.f73443f;
        if (r124 == null) goto L78;
        com.bytedance.live.datacontext.m<Boolean> r125 = r124.isMultiAvatarMode();
        if (r125 == null) goto L78;
        w5 r126 = r310.getHamletAvatarInit();
        if (r126 == null) goto L76;
        boolean r127 = r126.getMultiAvatarMode();
    L77:
        r125.setValue(Boolean.valueOf(r127));
        goto L78
    L76:
        r127 = false;
    L78:
        HamletAvatarContext r128 = this.f73443f;
        if (r128 == null) goto L85;
        w5 r129 = r310.getHamletAvatarInit();
        if (r129 == null) goto L83;
        boolean r130 = r129.getMultiAvatarMode();
    L84:
        r128.setMultiAvatarModeForReport(r130);
        goto L85
    L83:
        r130 = false;
    L85:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r131 = TalkRoomLogUtils.f77433a;
        w5 r132 = r310.getHamletAvatarInit();
        if (r132 == null) goto L88;
        boolean r133 = r132.getMultiAvatarMode();
    L89:
        TalkRoomLogUtils.f77445m = Boolean.valueOf(r133);
        HamletAvatarContext r134 = this.f73443f;
        if (r134 == null) goto L106;
        com.bytedance.live.datacontext.m<Boolean> r135 = r134.isMultiAvatarMode();
        if (r135 == null) goto L106;
        if (r135.getValue().booleanValue() != true) goto L106;
        if (gh0.a.d() == false) goto L105;
        HamletAvatarContext r136 = this.f73443f;
        if (r136 == null) goto L104;
        com.bytedance.live.datacontext.m<Boolean> r137 = r136.isRtcClientInitialized();
        if (r137 == null) goto L104;
        if (r137.getValue().booleanValue() != true) goto L104;
        jr();
    L104:
        this.C = true;
    L105:
        this.f73446i = new gf0.c(this.f73443f);
    L107:
        LinkedList<String> r138 = new LinkedList();
        HamletAvatarContext r139 = this.f73443f;
        if (r139 == null) goto L114;
        com.bytedance.live.datacontext.m<Boolean> r140 = r139.isMultiAvatarMode();
        if (r140 == null) goto L114;
        Boolean r141 = r140.getValue();
        if (r141 == null) goto L114;
        boolean r142 = r141.booleanValue();
    L116:
        if (r142 == false) goto L124;
        boolean r143 = ff0.c.f476645a;
        int r144 = 0;
    L119:
        if (r144 >= 2) goto L124;
        int r145 = bg0.a.f18855a;
        String r146 = je0.d.a0() + "_Android_" + r144;
        if (r144 != 0) goto L123;
        r146 = r146 + "_main";
    L123:
        r138.add(r146);
        r144 = r144 + 1;
    L124:
        this.f73460w = r138;
        uz r147 = uz.f121411a;
        String r148 = r147.getValue().getMockChannel();
        if (r148 != null) goto L127;
    L130:
        boolean r149 = true;
    L131:
        if (r149 == false) goto L133;
        r148 = r310.getChannel();
    L133:
        String r150 = r147.getValue().getMockGameId();
        if (r150 != null) goto L136;
    L143:
        r150 = r310.getGameId();
    L144:
        boolean r151 = ff0.c.f476645a;
        int r152 = Math.max((int) ((s1.w() * 9.0f) / 16), s1.y());
        int r153 = s1.w();
        LinkedHashMap r154 = new LinkedHashMap();
        JSONObject r155 = new JSONObject(r310.getInitParam());     // Catch: Exception -> L150
        if (r147.getValue().getMockAvatarId() < 0) goto L148;
        r155.put("avatarID", r147.getValue().getMockAvatarId());     // Catch: Exception -> L150
    L148:
        r154.putAll(ff0.f.a(r155));     // Catch: Exception -> L150
    L152:
        ALogger.i("HamletAvatar", "makeExtraToXplayServer: init_param=" + r310.getInitParam());
        HamletAvatarContext r156 = this.f73443f;
        if (r156 == null) goto L159;
        com.bytedance.live.datacontext.m<Boolean> r157 = r156.isMultiAvatarMode();
        if (r157 == null) goto L159;
        Boolean r158 = r157.getValue();
        if (r158 == null) goto L159;
        boolean r159 = r158.booleanValue();
    L160:
        boolean r160 = ff0.c.f476645a;
        HamletAvatarContext r161 = this.f73443f;
        if (r161 == null) goto L165;
        com.bytedance.live.datacontext.n<JSONArray> r162 = r161.getVideoSimulcastJSONArray();
        if (r162 == null) goto L165;
        JSONArray r163 = r162.getValue();
    L166:
        HamletAvatarContext r164 = this.f73443f;
        if (r164 == null) goto L171;
        com.bytedance.live.datacontext.m<Long> r165 = r164.getVideoSimulcastIndex();
        if (r165 == null) goto L171;
        Long r166 = r165.getValue();
    L172:
        if (r163 == null) goto L186;
        if (r166 == null) goto L186;
        if (r166.longValue() < 0) goto L186;
        if (r166.longValue() >= r163.length()) goto L186;
        Object r167 = r163.get((int) r166.longValue());     // Catch: Exception -> L184
        if ((r167 instanceof String) == false) goto L186;
        LinkedHashMap r168 = r154;
        if (StringsKt.contains$default((CharSequence) r167, vm2.d.K().getResolution1080Config(), false, 2, null) == false) goto L187;
        boolean r169 = true;
    L188:
        LinkedHashMap r170 = new LinkedHashMap();
        r170.put("enter_from", "live_app");
        IRoomContextService r171 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r171 == null) goto L197;
        LinkedList<String> r172 = r138;
        com.bytedance.android.livesdk.chatroom.o r173 = IRoomContextService.a.a(r171, null, 0, 3);
        if (r173 == null) goto L198;
        Room r174 = r173.getCurrentRoom();
        if (r174 == null) goto L198;
        String r175 = String.valueOf(r174.getRoomId());
        if (r175 == null) goto L198;
    L199:
        r170.put(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, r175);
        r170.put(IPerformanceManager.Params.is_anchor, String.valueOf(gh0.a.d()));
        uz r176 = uz.f121411a;
        if (r176.getValue().getMockAvatarId() < 0) goto L202;
        JSONObject r177 = new JSONObject(r310.getInitParam());
        r177.put("avatarID", r176.getValue().getMockAvatarId());
        r170.put("init_param", r177.toString());
    L203:
        boolean r178 = ff0.c.f476645a;
        if (r159 == true) goto L208;
        if (r169 == true) goto L208;
        HamletLiveMediaMockConfig r179 = (HamletLiveMediaMockConfig) vm2.d.H6.getValue(null, vm2.d.f555776a[395(0x18b, float:5.54E-43)]);
    L210:
        if (r179.getEnable() == true) goto L212;
        String r180 = String.valueOf(30);
    L213:
        r170.put("expect_fps", r180);
        if (r159 == true) goto L218;
        if (r169 == true) goto L218;
        HamletLiveMediaMockConfig r181 = (HamletLiveMediaMockConfig) vm2.d.H6.getValue(null, vm2.d.f555776a[395(0x18b, float:5.54E-43)]);
    L220:
        if (r181.getEnable() == true) goto L226;
        if (r159 == true) goto L225;
        if (r169 == true) goto L225;
        String r182 = "720P";
    L227:
        r170.put("expect_resolution", r182);
        if (r159 == true) goto L232;
        if (r169 == true) goto L232;
        HamletLiveMediaMockConfig r183 = (HamletLiveMediaMockConfig) vm2.d.H6.getValue(null, vm2.d.f555776a[395(0x18b, float:5.54E-43)]);
    L234:
        if (r183.getEnable() == true) goto L240;
        if (r159 == true) goto L239;
        if (r169 == true) goto L239;
        String r184 = "1600";
    L241:
        r170.put("expect_kbps", r184);
        HamletAvatarContext r185 = HamletAvatarContext.Companion.getContext();
        if (r185 == null) goto L250;
        com.bytedance.live.datacontext.m<Boolean> r186 = r185.isMultiAvatarMode();
        if (r186 == null) goto L250;
        if (r186.getValue().booleanValue() != true) goto L250;
        String r187 = r310.getRtcAppId();
        if (r187 == null) goto L250;
        r170.put("rtc_app_id", r187);
    L250:
        boolean r188 = !r313;
        boolean r210 = vm2.d.I().getUseSurfaceView();
        boolean r211 = vm2.d.J().getEnable();
        w5 r189 = r310.getHamletAvatarInit();
        if (r189 == null) goto L256;
        if (r189.getMultiAvatarMode() != true) goto L256;
        boolean r212 = true;
    L257:
        String r190 = r148;
        LinkedList<String> r191 = r172;
        com.bytedance.android.live.broadcastgame.api.xplay.basic.e r213 = new com.bytedance.android.live.broadcastgame.api.xplay.basic.e(r150, r190, r152, r153, 9, 16, r168, r170, true, r188, true, r210, true, r211, r191, r212, jc1.a.b(), r123, 29401344);
        if ((!r191.isEmpty()) == false) goto L260;
        this.f73459v = r191.get(0);
    L260:
        Context r192 = this.context;
        String r193 = lu2.c.f(this.dataCenter).getAnchorId();
        if (r193 != null) goto L263;
        String r194 = "";
    L264:
        boolean r195 = gb2.a.a(this.dataCenter, false);
        IMiddlewareUserService r196 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r196 == null) goto L272;
        com.bytedance.android.livesdk.user.e r197 = r196.user();
        if (r197 == null) goto L272;
        String r198 = r197.n();
        if (r198 == null) goto L272;
        String r214 = r198;
    L273:
        com.bytedance.android.live.broadcastgame.api.xplay.basic.c r199 = new com.bytedance.android.live.broadcastgame.api.xplay.basic.c(r192, r194, r195, r214, r213);
        this.f73452o = r199;
        if (r311 == false) goto L294;
        this.N = System.currentTimeMillis();
        com.bytedance.android.live.broadcastgame.api.xplay.basic.b.f59443b.d(r199, true, r312);
        return;
    L294:
        return;
    L272:
        r214 = "";
        goto L273
    L263:
        r194 = r193;
    L256:
        r212 = false;
    L239:
        r184 = "3600";
        goto L241
    L240:
        r184 = String.valueOf(r183.getDefaultBitrate() / 1000);
    L232:
        r183 = vm2.d.K();
    L225:
        r182 = "1080P";
        goto L227
    L226:
        StringBuilder r200 = new StringBuilder();
        r200.append(r181.getResolution());
        r200.append('P');
        r182 = r200.toString();
    L218:
        r181 = vm2.d.K();
        goto L220
    L212:
        r180 = String.valueOf(r179.getFps());
    L208:
        r179 = vm2.d.K();
        goto L210
    L202:
        r170.put("init_param", r310.getInitParam());
    L198:
        r175 = "";
        goto L199
    L197:
        r172 = r138;
    L187:
        r169 = false;
    L184:
        e = move-exception;
        r168 = r154;
        ALogger.e("HamletAvatar", "isAvatarQualityImprove exception:" + e.getMessage());
    L186:
        r168 = r154;
    L171:
        r166 = null;
    L165:
        r163 = null;
    L159:
        r159 = false;
    L150:
        e = move-exception;
        ALogger.e("HamletAvatar", "makeExtraToHamlet exception=" + Log.getStackTraceString(e));
        goto L152
    L136:
        if (r150.length() <= 0) goto L138;
        boolean r1100 = true;
    L139:
        if (r1100 == true) goto L142;
        r150 = null;
    L142:
        if (r150 != null) goto L144;
    L138:
        r1100 = false;
        goto L139
    L127:
        if (r148.length() == 0) goto L130;
        r149 = false;
    L114:
        r142 = false;
    L106:
        this.f73446i = new gf0.b(this.f73443f, new d(this, r310));
        goto L107
    L88:
        r133 = false;
        goto L89
    L56:
        if (r310.getVideoSimulcastIndex() < 0) goto L69;
        if (r310.getVideoSimulcastIndex() >= r123.length()) goto L69;
        HamletAvatarContext r201 = this.f73443f;
        if (r201 == null) goto L64;
        com.bytedance.live.datacontext.m<Long> r202 = r201.getVideoSimulcastIndex();
        if (r202 == null) goto L64;
        r202.setValue(Long.valueOf(r310.getVideoSimulcastIndex()));
    L64:
        HamletAvatarContext r203 = this.f73443f;
        if (r203 == null) goto L69;
        com.bytedance.live.datacontext.n<JSONArray> r204 = r203.getVideoSimulcastJSONArray();
        if (r204 == null) goto L69;
        r204.setValue(r123);
    L52:
        r123 = null;
        goto L54
    L293:
        return;
    L26:
        r109 = false;
        goto L28
    L22:
        r108 = null;
        goto L24
    }
}
