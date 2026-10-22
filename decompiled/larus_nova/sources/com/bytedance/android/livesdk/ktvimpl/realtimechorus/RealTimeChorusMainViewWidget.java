package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.business.container.AnnieXLiveCard;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.CommonOrderSongViewModel;
import com.bytedance.android.live.ktv.common.search.viewmodel.CommonSearchViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.universalwidget.MultiLinkUniversalAnimWidget;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.soloktv.model.EnterRtChorusRoomSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongHandler;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.viewmodel.KtvModeOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvMvLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.KtvDressViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.FragmentManagerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.dialog.RTChorusFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.RealTimeChorusMicHybridCardManager$registerMethods$2;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.RealTimeChorusMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.RealTimeChorusMidiWidget;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RealTimeChorusStage;
import com.bytedance.android.livesdk.message.model.aj;
import com.bytedance.android.livesdk.message.model.jd;
import com.bytedance.android.livesdk.message.model.kd;
import com.bytedance.android.livesdk.message.model.q2;
import com.bytedance.android.livesdk.message.model.t2;
import com.bytedance.android.livesdk.message.model.u2;
import com.bytedance.android.livesdk.message.model.w2;
import com.bytedance.android.livesdk.message.model.x2;
import com.bytedance.android.livesdk.message.model.z2;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.KtvDressDataKt;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\b2\u00020\t2\u00020\n:\u0001\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusMainViewWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvRoomSceneBaseWidget;", "Lvlc/l;", "Ltb0/a;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationController$d;", "Lcom/bytedance/android/live/ktv/common/util/c;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusMainViewWidget extends KtvRoomSceneBaseWidget implements vlc.l, tb0.a, ViewModelStoreOwnerCompat, com.bytedance.android.livesdk.ktvimpl.base.sei.c, Observer<KVData>, InteractAnimationController.d, com.bytedance.android.live.ktv.common.util.c, l1 {
    public static final /* synthetic */ int Q2 = 0;
    public KtvPreviewSongsWidget A;
    public KtvPreviewSongsViewModel B;
    public FrameLayout C;
    public Pair<KtvPreviewSongsViewModel, ? extends Disposable> D;
    public MvLyricWidget E;
    public com.bytedance.android.livesdk.ktvimpl.base.sei.w E2;
    public FrameLayout F;
    public n1 F2;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b G;
    public RealTimeChorusBusinessLifecycleOwner G1;
    public long G2;
    public FrameLayout H;
    public final CompositeDisposable H0;
    public long H1;
    public final j0 H2;
    public FrameLayout I;
    public final k0 I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public RealTimeChorusMidiWidget f146332J;
    public final ViewModelStore J2;
    public boolean K;
    public Function2<? super Boolean, ? super Long, Unit> K2;
    public boolean L;
    public final CompositeDisposable L0;
    public boolean L1;
    public final String L2;
    public KtvCoreViewModel M;
    public MusicPanel M1;
    public final int M2;
    public RealTimeChorusFeedBackView N;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d N2;
    public boolean O;
    public hh1.w0 O2;
    public ConstraintLayout P;
    public Pair<? extends DataContext, ? extends Disposable> P0;
    public double P1;
    public com.bytedance.android.livesdk.chatroom.widget.j1 P2;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c Q;
    public double Q1;
    public MessageHub R;
    public FrameLayout S;
    public boolean S1;
    public FrameLayout T;
    public final Set<Long> T1;
    public final List<UserChorusInfo> U;
    public final d1 V;
    public Pair<? extends DataContext, ? extends Disposable> V0;
    public List<ch0.e> V1;
    public int W;
    public final KtvContext X;
    public Disposable Y;
    public Disposable Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public Pair<? extends OrderedSongDataContext, ? extends Disposable> f146333b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public Map<String, Boolean> f146334b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f146335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f146336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f146337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f146338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public aj f146339g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public Disposable f146340g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public List<tf0.e> f146341g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f146342h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public Pair<KtvRoomContext, ? extends Disposable> f146343h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f146344h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f146345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f146346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f146347k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final sb0.b f146348k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public KSongOrderSongDialog f146349k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f146350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f146351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f146352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f146353o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f146354p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final sb0.a f146355p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public KtvSingerViewModel f146356p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public boolean f146357p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f146358q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RealTimeChorusSingerInfoView f146359r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RTChorusMusicInfoView f146360s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RealTimeChorusOperateView f146361t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Guideline f146362u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f146363v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public RecyclableWidgetManager f146364v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f146365v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Guideline f146366w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RTChorusLogView f146367x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c f146368x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public MiddlewareRoomWidget f146369x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HSImageView f146370y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.util.e f146371y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public boolean f146372y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f146373z;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMainViewWidget f146374a;

        public b(RealTimeChorusMainViewWidget r100) {
            this.f146374a = r100;
        }

        public final void a() {
            RealTimeChorusMainViewWidget r100 = this.f146374a;
            int r101 = RealTimeChorusMainViewWidget.Q2;
            View r102 = r100.Iq();
            if (r102 == null) goto L5;
            int r103 = r102.getWidth();
        L6:
            r100.f146335c = r103;
            RealTimeChorusMainViewWidget r104 = this.f146374a;
            View r105 = r104.Iq();
            if (r105 == null) goto L9;
            int r106 = r105.getHeight();
        L10:
            r104.f146336d = r106;
            boolean r107 = StatusBarUtil.isStatusBarTransparent();
            int r108 = x1.e(this.f146374a.context);
            int r109 = x1.k();
            ALogger.i("RealTimeChorusMainViewWidget", "adapterFold screenHeight = " + r108 + " , parentHeightPx = " + this.f146374a.f146336d + " , statusBarTransparent = " + r107 + ", statusBarHeight = " + r109);
            int r110 = r108 - this.f146374a.f146336d;
            int r111 = r110 + 10;
            boolean r112 = false;
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L20;
            int r113 = x1.k();
            boolean r114 = StatusBarUtil.isStatusBarTransparent();
            if (r113 <= r110) goto L16;
            boolean r115 = true;
        L17:
            if (r114 == false) goto L20;
            if (r115 == false) goto L20;
            r112 = true;
            goto L20
        L16:
            r115 = false;
        L20:
            if (r112 == false) goto L22;
            int r116 = r109 + r111;
        L23:
            int r117 = s1.f(118.0f) + r116;
            int r118 = s1.f(96.0f) + r116;
            int r119 = s1.f(438.0f) + r116;
            Guideline r120 = this.f146374a.f146362u;
            if (r120 == null) goto L26;
            r120.setGuidelineBegin(r117);
        L26:
            UIUtils.updateLayoutMargin(this.f146374a.f146363v, -3, r118, -3, -3);
            Guideline r121 = this.f146374a.f146366w;
            if (r121 == null) goto L29;
            r121.setGuidelineBegin(r119);
        L29:
            RealTimeChorusMainViewWidget r122 = this.f146374a;
            boolean r123 = r122.f146365v2;
            ViewGroup r124 = r122.containerView;
            if (r124 == null) goto L32;
            r124.post(new q0(r122, r123));
        L32:
            RealTimeChorusMainViewWidget r125 = this.f146374a;
            ViewGroup r126 = r125.containerView;
            int r127 = -1;
            if (r126 == null) goto L36;
            ViewGroup.LayoutParams r128 = r126.getLayoutParams();
            if (r128 == null) goto L36;
        L38:
            if (s1.y() <= s1.w()) goto L40;
        L43:
            int r129 = (int) ((s1.w() * 9.0f) / 16.0f);
            int r130 = r125.f146335c;
            if (r130 <= 0) goto L47;
            if (r130 > r129) goto L47;
        L46:
            int r131 = -1;
            float r132 = 0.0f;
        L48:
            r128.width = r127;
            r128.height = r131;
            ViewGroup r133 = r125.containerView;
            if (r133 == null) goto L51;
            r133.setTranslationX(r132);
        L51:
            ViewGroup r134 = r125.containerView;
            if (r134 == null) goto L54;
            r134.setLayoutParams(r128);
        L54:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r135 = r125.Q;
            if (r135 == null) goto L60;
            int r136 = r125.zq();
            JSONObject r137 = new JSONObject();
            r137.put("eventName", "event_party_ktv_stage_size_update");
            JSONObject r138 = new JSONObject();
            r138.put("screen_width", String.valueOf(r136));
            r138.put("screen_height", String.valueOf(260));
            Unit r139 = Unit.INSTANCE;
            r137.put("data", r138);
            HybridCard r140 = r135.f146698a;
            if (r140 == null) goto L61;
            r140.sendJsEvent("event_party_ktv_stage_size_update", r137);
            return;
        L61:
            return;
        L60:
            return;
        L47:
            int r141 = s1.w();
            r132 = (s1.y() - r129) / 2.0f;
            r131 = r141;
            r127 = r129;
            goto L48
        L40:
            if (FoldScreenUtils.e() == true) goto L43;
            if (PadConfigUtils.c() == false) goto L46;
        L36:
            r128 = new FrameLayout.LayoutParams(-1, -1);
            goto L38
        L22:
            r116 = 10;
            goto L23
        L9:
            r106 = s1.w();
            goto L10
        L5:
            r103 = s1.y();
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMainViewWidget f146375a;

        public c(RealTimeChorusMainViewWidget r100) {
            this.f146375a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RealTimeChorusMainViewWidget r100 = this.f146375a;     // Catch: Throwable -> L6
            RealTimeChorusOperateView r101 = r100.f146361t;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.U5(r100.Cq());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMainViewWidget f146376a;

        public d(RealTimeChorusMainViewWidget r100) {
            this.f146376a = r100;
        }

        public final void a() {
            String r100 = "sslocal://webcast_lynxview?hybrid_type=lynx&url=";
            if (vm2.d.V() == false) goto L24;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r101 = this.f146376a.Q;
            if (r101 == null) goto L24;
            if (r101.f146699b != null) goto L24;
            String r102 = (String) vm2.d.Z4.getValue(null, vm2.d.f555776a[309(0x135, float:4.33E-43)]);
            u6 r103 = new u6("sslocal://webcast_lynxview?hybrid_type=lynx&url=");
            r103.b("url", r102);
            Uri r104 = r103.c();
            ALogger.i("RealTimeChorusMicHybridCardManager", "guest lynx uri: " + r104);
            IBaseBrowserService r105 = (IBaseBrowserService) jc1.k.f(IBaseBrowserService.class);
            if (r105 == null) goto L12;
            HybridCard r106 = r105.getHybridCard(r101.f146707j, r104, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.m(r101));
        L13:
            r101.f146699b = r106;
            if (r106 == null) goto L16;
            a7.a.a(r106, null, null, 3);
        L16:
            HybridCard r107 = r101.f146699b;
            if (r107 == null) goto L24;
            Map<String, Map<String, List<Object>>> r108 = r101.f146702e;
            Intrinsics.checkNotNull(r107);
            r108.put(String.valueOf(r107.hashCode()), new LinkedHashMap());
            FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
            HybridCard r110 = r101.f146699b;
            if (r110 == null) goto L21;
            r110.setLayoutParams(r109);
        L21:
            ViewGroup r111 = r101.f146706i;
            if (r111 == null) goto L24;
            r111.addView(r101.f146699b);
            goto L24
        L12:
            r106 = null;
        L24:
            RealTimeChorusMainViewWidget r112 = this.f146376a;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r113 = r112.Q;
            if (r113 == null) goto L43;
            int r114 = r112.zq();
            if (r113.f146698a != null) goto L43;
            ReadOnlyProperty r115 = vm2.h.f556181m2;
            KProperty<?>[] r116 = vm2.h.f556082a;
            String r117 = (String) r115.getValue(null, r116[167(0xa7, float:2.34E-43)]);
            if (((Boolean) vm2.h.f556173l2.getValue(null, r116[166(0xa6, float:2.33E-43)])).booleanValue() == false) goto L32;
            r100 = "sslocal://webcast_lynxview?hybrid_type=lynx&mix_container_type=annie&url=";
        L32:
            u6 r118 = new u6(r100);
            r118.b("url", r117);
            u6 r119 = r118.d("url");
            r119.b("screen_width", String.valueOf(r114));
            r119.b("screen_height", String.valueOf(260));
            r119.b("seat_top", "20");
            r119.b("seat_bottom", BDLocationException.ERROR_MULTI_THREAD_LOCATE);
            Uri r120 = r118.c();
            ALogger.i("RealTimeChorusMicHybridCardManager", "main lynx uri: " + r120);
            r113.f146698a = ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).getHybridCard(r113.f146707j, r120, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.l(r113));
            w.a("RealTimeChorusMicHybridCardManager", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
            HybridCard r121 = r113.f146698a;
            if (r121 == null) goto L35;
            a7.a.a(r121, null, null, 3);
        L35:
            HybridCard r122 = r113.f146698a;
            if (r122 == null) goto L43;
            Map<String, Map<String, List<Object>>> r123 = r113.f146702e;
            Intrinsics.checkNotNull(r122);
            r123.put(String.valueOf(r122.hashCode()), new LinkedHashMap());
            FrameLayout.LayoutParams r124 = new FrameLayout.LayoutParams(-1, -1);
            HybridCard r125 = r113.f146698a;
            if (r125 == null) goto L40;
            r125.setLayoutParams(r124);
        L40:
            ViewGroup r126 = r113.f146705h;
            if (r126 == null) goto L43;
            r126.addView(r113.f146698a);
        L43:
            this.f146376a.Yq("loadChorusMicSeat");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMainViewWidget f146377a;

        public e(RealTimeChorusMainViewWidget r100) {
            this.f146377a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v10, types: [com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1] */
        @Override // h80.a
        public final void accept(Object r100) {
            IRoom r101 = (IRoom) r100;
            if (KtvSettingHelper.w() == false) goto L5;
            this.f146377a.f146371y1.d(new tb0.b.a());
        L5:
            ALogger.i("logKtvMainPath", "onBizEnterKtvRoom, invoke class :RealTimeChorusMainViewWidget");
            MessageHub r102 = this.f146377a.R;
            if (r102 == null) goto L8;
            r102.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this.f146377a);
        L8:
            RealTimeChorusMainViewWidget r103 = this.f146377a;
            r103.getClass();
            if (((Boolean) KtvSettingHelper.f70610c.getValue()).booleanValue() == false) goto L14;
            RealTimeChorusOperateView r104 = r103.f146361t;
            if (r104 == null) goto L14;
            r104.setVisibility(0);
        L14:
            this.f146377a.hr(false);
            RealTimeChorusMainViewWidget r105 = this.f146377a;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r106 = r105.N2;
            if (r106 == null) goto L23;
            BehaviorSubject<ch0.m> r107 = r106.P0();
            if (r107 == null) goto L23;
            Observable r108 = RxUtilKt.h(r107);
            if (r108 == null) goto L23;
            Disposable r109 = r108.subscribe(c0.f146517a);
            if (r109 == null) goto L23;
            RxUtilKt.c(r109, r105.H0);
        L23:
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r110 = r105.N2;
            if (r110 == null) goto L30;
            BehaviorSubject<List<ch0.e>> r111 = r110.f();
            if (r111 == null) goto L30;
            Disposable r112 = r111.subscribe(new d0(r105));
            if (r112 == null) goto L30;
            RxUtilKt.c(r112, r105.H0);
        L30:
            int r113 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.f76654a;
            if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r105.M2) == false) goto L40;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r114 = r105.N2;
            if (r114 == null) goto L40;
            BehaviorSubject<Map<String, Boolean>> r115 = r114.j1();
            if (r115 == null) goto L40;
            Disposable r116 = r115.subscribe(new e0(r105));
            if (r116 == null) goto L40;
            RxUtilKt.c(r116, r105.H0);
        L40:
            if (vm2.d.V() == false) goto L50;
            LinkMicRoomDataSyncModel r117 = LinkWRDSHelper.b();
            if (r117 == null) goto L50;
            dc2.c<IRoomLinkMicSyncData> r118 = r117.getTalkRoomListUserInfoPb();
            if (r118 == null) goto L50;
            Observable<dc2.c.b<IRoomLinkMicSyncData>> r119 = r118.f467853e;
            if (r119 == null) goto L50;
            Disposable r120 = r119.subscribe(new f0(r105));
            if (r120 == null) goto L50;
            RxUtilKt.c(r120, r105.H0);
        L50:
            this.f146377a.Mq(false);
            RxUtilKt.c(xs2.b.a().b(jd0.r.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new l0(this)), this.f146377a.H0);
            RxUtilKt.c(xs2.b.a().b(jd0.q.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new m0(this)), this.f146377a.H0);
            RxUtilKt.c(xs2.b.a().b(jd0.p.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new n0(this)), this.f146377a.H0);
            RealTimeChorusMainViewWidget r121 = this.f146377a;
            r121.f146344h2 = 0;
            r121.f146357p2 = false;
            com.bytedance.android.livesdk.chatroom.o r122 = o3.f();
            IVoiceLiveTheme r123 = null;
            if (r122 == null) goto L55;
            com.bytedance.live.datacontext.j<vlc.d> r124 = r122.getMessageManager();
            if (r124 == null) goto L55;
            vlc.d r125 = r124.getValue();
        L57:
            if ((r125 instanceof xlc.a) == true) goto L59;
            r125 = null;
        L59:
            xlc.a r126 = (xlc.a) r125;
            if (r126 == null) goto L62;
            MessageType r127 = MessageType.REAL_TIME_CHORUS_MESSAGE;
            r126.y(r127.getIntType(), r121);
            r121.onMessage(r126.u(r127.getIntType()));
        L62:
            com.bytedance.android.livesdk.chatroom.o r128 = o3.f();
            if (r128 == null) goto L69;
            com.bytedance.live.datacontext.j<vlc.d> r129 = r128.getMessageManager();
            if (r129 == null) goto L69;
            vlc.d r130 = r129.getValue();
            if (r130 == null) goto L69;
            r130.addMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getWsMethod(), r121);
        L69:
            com.bytedance.android.livesdk.chatroom.o r131 = o3.f();
            if (r131 == null) goto L76;
            com.bytedance.live.datacontext.j<vlc.d> r132 = r131.getMessageManager();
            if (r132 == null) goto L76;
            vlc.d r133 = r132.getValue();
            if (r133 == null) goto L76;
            r133.addMessageListener(MessageType.LINK_MIC_BIG_EVENT.getWsMethod(), r121);
        L76:
            final RealTimeChorusMainViewWidget r134 = this.f146377a;
            LifecycleOwner r135 = r134.getLifecycleOwner();
            if (r135 == null) goto L82;
            RealTimeChorusBusinessContext.a r136 = RealTimeChorusBusinessContext.Companion;
            r136.o(r135, new RealTimeChorusMainViewWidget$initChorusRoleObserver$$inlined$let$lambda$1(r134));
            if (KtvSettingHelper.b().booleanValue() == true) goto L82;
            r136.n(r135, new RealTimeChorusMainViewWidget$initChorusRoleObserver$$inlined$let$lambda$2(r134));
        L82:
            if (((Boolean) KtvSettingHelper.f70636k1.getValue()).booleanValue() == false) goto L84;
            RxUtilKt.c(r134.X.getHasBgm().a().subscribe(new a0(r134)), r134.H0);
        L84:
            final RealTimeChorusMainViewWidget r137 = this.f146377a;
            LifecycleOwner r138 = r137.getLifecycleOwner();
            if (r138 == null) goto L89;
            fd2.s r139 = RealTimeChorusBusinessContext.Companion.c();
            if (r139 == 0) goto L89;
            r139.y9((RealTimeChorusBusinessLifecycleOwner) r138, new RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1(r137));
        L89:
            RealTimeChorusMainViewWidget r140 = this.f146377a;
            LifecycleOwner r141 = r140.getLifecycleOwner();
            if (r141 == null) goto L100;
            RealTimeChorusOperateView r142 = r140.f146361t;
            if (r142 == null) goto L100;
            Intrinsics.checkNotNullParameter(r141, "lifecycleOwner");
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L100;
            r142.b6();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r143 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
            if (r143 == null) goto L100;
            com.bytedance.android.live.liveinteract.voicechat.b r144 = r143.muteManager();
            if (r144 == null) goto L100;
            r144.c(r141, new z0(r142));
        L100:
            RealTimeChorusOperateView r145 = this.f146377a.f146361t;
            if (r145 != null) goto L103;
        L107:
            RealTimeChorusMainViewWidget r146 = this.f146377a;
            r146.Jq();
            KtvModeOrderedSongDataContext r147 = r146.Eq();
            if (r147 == null) goto L112;
            Disposable r148 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r147, null, new h0(r146), 3);
            if (r148 == null) goto L112;
            RxUtilKt.c(r148, r146.H0);
        L112:
            sb0.b r149 = r146.f146348k0;
            if (r149 == null) goto L115;
            sb0.e r150 = r149.b();
        L116:
            if (r150 != null) goto L118;
        L128:
            RealTimeChorusMainViewWidget r151 = this.f146377a;
            DataCenter r152 = r151.dataCenter;
            if (r152 == null) goto L131;
            r152.observe("data_dynamic_show_emoji_panel", r151);
        L131:
            RealTimeChorusMainViewWidget r153 = this.f146377a;
            Disposable r154 = r153.X.getOpenKtvRoomDialogEvent().onEvent().subscribe(new r0(r153));
            if (r154 == null) goto L134;
            RxUtilKt.c(r154, r153.H0);
        L134:
            com.bytedance.live.datacontext.n<Pair<Integer, String>> r155 = o3.e(r153).C();
            if (r155 == null) goto L141;
            Observable<sh6.b<Pair<Integer, String>>> r156 = r155.a();
            if (r156 == null) goto L141;
            ObservableSubscribeProxy r157 = (ObservableSubscribeProxy) r156.as(r153.autoDispose());
            if (r157 == null) goto L141;
            r157.subscribe(new s0(r153));
        L141:
            com.bytedance.live.datacontext.n<Pair<Integer, String>> r158 = o3.e(r153).C();
            if (r158 == null) goto L151;
            Pair<Integer, String> r159 = r158.getValue();
            if (r159 == null) goto L151;
            if (TextUtils.isEmpty(r159.getSecond()) == true) goto L151;
            String r160 = o3.e(r153).w();
            if (r160 != null) goto L150;
            r160 = "ktv_convenient";
        L150:
            r153.br(r160, false, r159.getSecond(), r159.getFirst());
        L151:
            com.bytedance.live.datacontext.m<String> r161 = o3.e(r153).K();
            if (r161 == null) goto L158;
            String r162 = r161.getValue();
            if (r162 == null) goto L158;
            if (TextUtils.isEmpty(r162) == true) goto L158;
            r153.br("ktv_convenient", false, null, null);
        L158:
            this.f146377a.X.getKtvRoomStrategy().setValue(new i1());
            RealTimeChorusMainViewWidget r163 = this.f146377a;
            r163.S1 = false;
            r163.Sq();
            FrameLayout r164 = this.f146377a.S;
            if (r164 == null) goto L161;
            r164.post(new o0(this));
        L161:
            this.f146377a.Rq();
            RealTimeChorusMainViewWidget r165 = this.f146377a;
            KtvCoreViewModel r166 = r165.M;
            KtvSingerViewModel r167 = r165.f146356p1;
            KtvContext r168 = r165.X;
            if (r166 == null) goto L173;
            if (r167 == null) goto L173;
            if (r168 == null) goto L173;
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r169 = KtvModeOrderSongDataContext.Companion.a();
            if (r169 == null) goto L168;
            r169.getOrderedSongList(true);
        L168:
            LifecycleOwner r170 = r165.getLifecycleOwner();
            if (r170 == null) goto L173;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r171 = KtvModeOrderSongDataContext.Companion.b();
            if (r171 == null) goto L173;
            r171.observeSongListDataChange(r170, new b0(r165));
        L173:
            RealTimeChorusMainViewWidget r172 = this.f146377a;
            r172.getClass();
            IInteractService r173 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r173 == null) goto L176;
            x00.a r174 = r173.getThemeManager(je0.d.r(), r172.dataCenter);
        L177:
            if (r174 == null) goto L179;
            r123 = r174.q(100);
        L179:
            com.bytedance.android.live.liveinteract.plantform.base.g r175 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
            if (r175 == null) goto L185;
            com.bytedance.android.live.ui.c r176 = r175.y4();
            if (r176 == null) goto L185;
            r176.b(r123);
        L185:
            if (KtvSettingHelper.w() == true) goto L187;
            this.f146377a.f146371y1.d(new tb0.b.a());
        L187:
            this.f146377a.cr();
            RealTimeChorusOperateView r177 = this.f146377a.f146361t;
            if (r177 != null) goto L190;
        L196:
            RealTimeChorusMainViewWidget r178 = this.f146377a;
            if (r178.f146368x1 != null) goto L203;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c r179 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c(r178.f146337e);
            r178.f146368x1 = r179;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r180 = r178.Q;
            Intrinsics.checkNotNullParameter(r178, "singInfoProvider");
            r179.f146789c = r180;
            cg6.a r181 = (cg6.a) r179.f146791e.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r181 == null) goto L203;
            hg6.g r182 = r181.getRtcManager();
            if (r182 == null) goto L203;
            r182.p(r179.f146790d);
        L203:
            RealTimeChorusMainViewWidget r183 = this.f146377a;
            RealTimeChorusOperateView r184 = r183.f146361t;
            if (r184 == null) goto L206;
            r184.postDelayed(new x0(r183), ((Number) KtvSettingHelper.f70634k.getValue()).longValue());
        L206:
            RealTimeChorusMainViewWidget r185 = this.f146377a;
            aj r186 = r185.f146339g;
            if (r186 == null) goto L209;
            r185.nr(r186, true);
        L209:
            KtvCoreViewModel r187 = this.f146377a.M;
            if (r187 == null) goto L214;
            StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r188 = r187.getCurrentTransition();
            if (r188 == null) goto L214;
            this.f146377a.Kq(r188);
        L214:
            this.f146377a.yq();
            return;
        L190:
            if (KtvSettingHelper.C() == false) goto L196;
            if (com.bytedance.android.livesdk.sharedpref.c.W.getValue().booleanValue() == true) goto L196;
            ConstraintLayout r189 = r177.f146398f;
            if (r189 == null) goto L196;
            r189.postDelayed(new b1(r177), 5000);
            goto L196
        L176:
            r174 = null;
            goto L177
        L118:
            if (r146.f146348k0.isAnchor() == false) goto L128;
            KtvModeOrderedSongDataContext r190 = r146.Eq();
            if (r190 == null) goto L124;
            List<SongUniqueInfo> r191 = r190.getKtvPublicSongUniqueInfoList();
            if (r191 == null) goto L124;
            int r192 = r191.size();
        L125:
            RealTimeChorusOperateView r193 = r146.f146361t;
            if (r193 == null) goto L128;
            r193.c6(r192);
        L124:
            r192 = 0;
            goto L125
        L115:
            r150 = null;
            goto L116
        L103:
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L107;
            Disposable r194 = xs2.b.a().b(ye2.a.class).subscribe(new a1(r145));
            if (r194 == null) goto L107;
            RxUtilKt.c(r194, r145.f146393a);
        L55:
            r125 = null;
            goto L57
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f146378a = null;

        static {
            f146378a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f146379a = null;

        static {
            f146379a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ub0.d f146380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMainViewWidget f146381b;

        public h(ub0.d r100, RealTimeChorusMainViewWidget r101) {
            this.f146380a = r100;
            this.f146381b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvCoreViewModel r100 = this.f146381b.M;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.sendEvent(new KtvRoomLyricsStateMachineConfig.a.f(this.f146380a.f549330c), "RealTimeChorusMainViewWidget");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class i implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealTimeChorusMainViewWidget f146382a;

        public i(RealTimeChorusMainViewWidget r100) {
            this.f146382a = r100;
        }

        @Override // fd0.b
        public final void onStop() {
            RealTimeChorusMainViewWidget r100 = this.f146382a;
            if (r100.L == false) goto L15;
            FrameLayout r101 = r100.I;
            if (r101 == null) goto L7;
            r101.setVisibility(8);
        L7:
            RecyclableWidgetManager r102 = this.f146382a.Bq();
            if (r102 == null) goto L10;
            r102.unload(this.f146382a.f146332J);
        L10:
            RealTimeChorusMainViewWidget r103 = this.f146382a;
            r103.f146332J = null;
            RealTimeChorusSingerInfoView r104 = r103.f146359r;
            if (r104 == null) goto L13;
            r104.setGetCurUserChorusDataCB(null);
        L13:
            this.f146382a.L = false;
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Bn(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Ed(int r100) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.InteractAnimationController.d
    public final EmojiSoundManager I8(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fromUid");
        Intrinsics.checkNotNullParameter(r101, "toUid");
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList Ka(int r100, float r101) {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Pf(int r100) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList dm(int r100) {
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_realtime_chorus_main_layout;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final q50.b jq() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean lo(int r100) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int ma(int r100, int r101) {
        return -1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int qq(int r100) {
        return -1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean si() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean wc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int zl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return -1;
    }

    public final void Aq() {
        Disposable r100 = this.P0.getSecond();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        r100.dispose();
        this.P0 = new Pair(null, null);
        return;
    }

    public final RecyclableWidgetManager Bq() {
        RecyclableWidgetManager r100 = this.f146364v1;
        if (r100 != null) goto L62;
        Object r101 = null;
        if (KtvSettingHelper.i() == false) goto L45;
        Context r102 = this.context;
        if ((r102 instanceof FragmentActivity) == true) goto L9;
        r102 = null;
    L9:
        Context r103 = (FragmentActivity) r102;
        if (r103 != null) goto L14;
        r103 = com.bytedance.android.live.core.utils.a.d();
    L14:
        if ((r103 instanceof FragmentActivity) == true) goto L16;
        r103 = null;
    L16:
        FragmentActivity r104 = (FragmentActivity) r103;
        Fragment r105 = com.bytedance.android.livesdk.ktvimpl.base.util.d.a(r104);
        if (r105 != null) goto L19;
    L21:
        if (r104 != null) goto L23;
    L25:
        if (r105 == null) goto L38;
        FragmentManager r106 = r105.getChildFragmentManager();
        if (r106 == null) goto L38;
        List<Fragment> r107 = r106.getFragments();
        if (r107 == null) goto L38;
        Iterator<T> r108 = r107.iterator();
    L32:
        if (r108.hasNext() == false) goto L36;
        Object r109 = r108.next();
        if ((((Fragment) r109) instanceof RecyclableWidgetManager) == false) goto L32;
    L37:
        Fragment r110 = (Fragment) r109;
    L40:
        if ((r110 instanceof RecyclableWidgetManager) == false) goto L43;
        r101 = r110;
    L43:
        RecyclableWidgetManager r111 = (RecyclableWidgetManager) r101;
    L44:
        this.f146364v1 = r111;
    L58:
        return this.f146364v1;
    L36:
        r109 = null;
    L38:
        r110 = null;
        goto L40
    L23:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r104.getSupportFragmentManager()) == true) goto L25;
        r111 = RecyclableWidgetManager.ha0(r104, this.contentView);
        goto L44
    L19:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r105.getChildFragmentManager()) == true) goto L21;
        r111 = RecyclableWidgetManager.ga0(r105, this.contentView);
        goto L44
    L45:
        Context r112 = this.context;
        if ((r112 instanceof FragmentActivity) == true) goto L48;
        r112 = null;
    L48:
        Object r113 = (FragmentActivity) r112;
        if (r113 != null) goto L53;
        r113 = com.bytedance.android.live.core.utils.a.d();
    L53:
        if ((r113 instanceof FragmentActivity) == false) goto L56;
        r101 = r113;
    L56:
        this.f146364v1 = RecyclableWidgetManager.ha0((FragmentActivity) r101, this.contentView);
        goto L58
    L62:
        return r100;
    }

    public final String Cq() {
        com.bytedance.android.live.profit.dress.t r100 = this.X.getLinkmicRealTimeChorusDress().getValue();
        int r101 = 0;
        if (r100 == null) goto L16;
        List<com.bytedance.android.live.profit.dress.config.n> r102 = r100.f87173c;
        if (r102 == null) goto L16;
        Integer r103 = this.f146347k;
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        com.bytedance.android.live.profit.dress.config.n r105 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r102, r104);
        if (r105 == null) goto L16;
        py.k r106 = r105.getEnterBtnImage();
        if (r106 == null) goto L16;
        String r107 = KtvUtilsKt.g(r106);
        if (r107 == null) goto L16;
        return r107;
    L9:
        r104 = 0;
    L16:
        Integer r108 = this.f146347k;
        if (r108 == null) goto L19;
        r101 = r108.intValue();
    L19:
        if (r101 != 0) goto L22;
        return com.bytedance.android.live.ktv.common.midi.h.f69849a;
    L22:
        if (r101 != 1) goto L25;
        return com.bytedance.android.live.ktv.common.midi.h.f69850b;
    L25:
        if (r101 != 2) goto L28;
        return com.bytedance.android.live.ktv.common.midi.h.f69851c;
    L28:
        return com.bytedance.android.live.ktv.common.midi.h.f69849a;
    }

    public final KtvModeOrderedSongDataContext Eq() {
        return KtvModeOrderedSongDataContext.Companion.getContext();
    }

    public final String Fq() {
        com.bytedance.android.live.profit.dress.t r100 = this.X.getLinkmicRealTimeChorusDress().getValue();
        if (r100 == null) goto L14;
        List<com.bytedance.android.live.profit.dress.config.n> r101 = r100.f87173c;
        if (r101 == null) goto L14;
        Integer r102 = this.f146347k;
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        com.bytedance.android.live.profit.dress.config.n r104 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r101, r103);
        if (r104 == null) goto L14;
        String r105 = r104.getThemeColor();
        if (r105 == null) goto L14;
        return r105;
    L9:
        r103 = 0;
    L14:
        return "#00FFE0";
    }

    public final double Gq() {
        RealTimeChorusMidiWidget r100 = this.f146332J;
        if (r100 == null) goto L9;
        RealTimeChorusMidiViewModel r101 = r100.f146768b;
        if (r101 != null) goto L10;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L10:
        return r101.getTotalScore();
    L9:
        return this.Q1;
    }

    public final View Iq() {
        ViewGroup r100 = this.containerView;
        Object r101 = null;
        if (r100 == null) goto L7;
        ViewParent r102 = r100.getParent();
        if (r102 == null) goto L7;
        ViewParent r103 = r102.getParent();
    L9:
        if ((r103 instanceof View) == false) goto L13;
        r101 = r103;
    L13:
        return (View) r101;
    L7:
        r103 = null;
        goto L9
    }

    public final void Jq() {
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100 = KtvModeOrderSongDataContext.Companion.a();
        Long r101 = null;
        if ((r100 instanceof BaseOrderSongViewModel) == true) goto L5;
        r100 = null;
    L5:
        BaseOrderSongViewModel r102 = (BaseOrderSongViewModel) r100;
        if (r102 == null) goto L8;
        Boolean r103 = Boolean.valueOf(r102.hasReceiveSongListChangeMessage());
    L9:
        boolean r104 = true;
        if ((!Intrinsics.areEqual(r103, Boolean.TRUE)) == false) goto L13;
        ALogger.i("RealTimeChorusMainViewWidget", "handleSongListChange: hasReceiveSongListChangeMessage == false");
        return;
    L13:
        KtvModeOrderedSongDataContext r105 = Eq();
        if (r105 == null) goto L18;
        List<MusicPanel> r106 = r105.m8257getKtvSingSongList();
        if (r106 == null) goto L18;
        MusicPanel r107 = (MusicPanel) KtvUtilsKt.K(r106, 0);
    L19:
        if (r107 == null) goto L21;
        Long r108 = Long.valueOf(r107.c());
    L22:
        MusicPanel r109 = this.M1;
        if (r109 == null) goto L26;
        r101 = Long.valueOf(r109.c());
    L26:
        if ((!Intrinsics.areEqual(r108, r101)) == true) goto L28;
    L30:
        KtvModeOrderedSongDataContext r110 = Eq();
        if (r110 == null) goto L35;
        List<SongUniqueInfo> r111 = r110.getKtvPublicSongUniqueInfoList();
        if (r111 == null) goto L35;
        int r112 = r111.size();
    L36:
        RealTimeChorusOperateView r113 = this.f146361t;
        if (r113 == null) goto L39;
        r113.c6(r112);
    L39:
        if (r112 != 0) goto L43;
        RealTimeChorusOperateView r114 = this.f146361t;
        if (r114 == null) goto L43;
        r114.setJoiningChorus(false);
    L43:
        if (r112 != 0) goto L45;
        Lq();
        ar("song list change");
    L45:
        KtvModeOrderedSongDataContext r115 = Eq();
        if (r115 == null) goto L74;
        MusicPanel r116 = r115.getKtvPublicFirstOrderedSong();
        if (r116 == null) goto L75;
        String r117 = s1.C(R.string.ttlive_rt_chorus_sing_music_info, new Object[]{r116.f153577a.getMTitle()});
        String r118 = r116.g();
        if (r118 != null) goto L53;
        r118 = "";
    L53:
        long r119 = r116.c();
        if (r119 == this.f146352n) goto L56;
    L58:
        r104 = false;
    L59:
        if (r104 == true) goto L72;
        this.P1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.Q1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        RealTimeChorusOperateView r120 = this.f146361t;
        if (r120 == null) goto L63;
        r120.setJoiningChorus(false);
    L63:
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        xe2.h.f563362f = r117;
        this.f146352n = r119;
        String r121 = String.valueOf(r119);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        xe2.h.f563363g = r121;
        this.f146353o = r118;
        RTChorusMusicInfoView r122 = this.f146360s;
        if (r122 == null) goto L66;
        r122.T5(r117);
    L66:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r123 = this.Q;
        if (r123 == null) goto L69;
        r123.g(r117, String.valueOf(r119));
    L69:
        RealTimeChorusOperateView r124 = this.f146361t;
        if (r124 == null) goto L72;
        r124.postDelayed(new c(this), ((Number) KtvSettingHelper.f70634k.getValue()).longValue() + 5000);
    L72:
        cr();
        return;
    L56:
        if (Intrinsics.areEqual(this.f146353o, r118) == false) goto L58;
    L75:
        return;
    L74:
        return;
    L35:
        r112 = 0;
        goto L36
    L28:
        if (this.L1 == false) goto L30;
        this.M1 = r107;
        goto L30
    L21:
        r108 = null;
    L18:
        r107 = null;
        goto L19
    L8:
        r103 = null;
        goto L9
    }

    public final void Lq() {
        RealTimeChorusSingerInfoView r100 = this.f146359r;
        if (r100 != null) goto L5;
    L7:
        RealTimeChorusSingerInfoView r101 = this.f146359r;
        if (r101 == null) goto L11;
        r101.setSelfVisibility(4);
        return;
    L11:
        return;
    L5:
        if (r100.getVisibility() != 4) goto L7;
    }

    public final void Nq() {
        if (this.V0.getFirst() == null) goto L5;
        return;
    L5:
        if (((Boolean) KtvSettingHelper.f70654q1.getValue()).booleanValue() == false) goto L7;
        ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this).clear();
    L7:
        Pair<? extends DataContext, ? extends Disposable> r100 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$1.INSTANCE);
        this.V0 = r100;
        DataContext r101 = r100.getFirst();
        if ((r101 instanceof KtvModeOrderSongDataContext) == true) goto L10;
        r101 = null;
    L10:
        KtvModeOrderSongDataContext r102 = (KtvModeOrderSongDataContext) r101;
        if (r102 == null) goto L13;
        com.bytedance.live.datacontext.b.a(r102, RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$2.INSTANCE);
    L13:
        KSongOrderSongHandler r103 = new KSongOrderSongHandler();
        if (r102 == null) goto L18;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b> r104 = r102.m8253getCommonOrderSongViewModel();
        if (r104 == null) goto L18;
        CommonOrderSongViewModel.Companion.getClass();
        r104.d(CommonOrderSongViewModel.a.a(this, r103));
    L18:
        if (r102 == null) goto L22;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r105 = r102.m8254getCommonSearchViewModel();
        if (r105 == null) goto L22;
        CommonSearchViewModel.Companion.getClass();
        r105.d(CommonSearchViewModel.a.a(this, r103));
    L22:
        if (r102 == null) goto L26;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r106 = r102.m8252getBusinessOrderSongViewModel();
        if (r106 == null) goto L26;
        KtvModeOrderSongViewModel.a r107 = KtvModeOrderSongViewModel.Companion;
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r108 = KtvModeOrderSongDataContext.Companion.b();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r109 = KtvModeOrderSongDataContext.Companion.c();
        KtvModeOrderedSongDataContext r110 = KtvModeOrderedSongDataContext.Companion.getContext();
        r107.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r111 = KtvModeOrderSongViewModel.a.a(this, r108, r109, r110);
        r111.initData();
        Unit r112 = Unit.INSTANCE;
        r106.d(r111);
    L26:
        KtvModeOrderSongDataContext.Companion.getClass();
        r103.f142590a = KtvModeOrderSongDataContext.Companion.a();
        r103.f142591b = KtvModeOrderSongDataContext.Companion.b();
        if (r102 == null) goto L33;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r113 = r102.m8255getKtvDressViewModel();
        if (r113 == null) goto L34;
        KtvDressViewModel.Companion.getClass();
        r113.d(KtvDressViewModel.a.a(this));
        return;
    L34:
        return;
    }

    public final void Pq() {
        if (this.P0.getFirst() != null) goto L6;
        w.a("RealTimeChorusMainViewWidget", "initKSongTuningDataContext");
        this.P0 = KSongTuningPanelHelperKt.b(true, this.V.h(this.f146348k0.isAnchor()), new WeakReference(this.context));
        return;
    L6:
        if (KSongTuningPanelHelperKt.d() != null) goto L12;
        DataContext r100 = this.P0.getFirst();
        if (r100 == null) goto L13;
        com.bytedance.live.datacontext.b.a(r100, KtvModeTuningDataContext.class);
        return;
    L13:
        return;
    }

    public final boolean Qq() {
        com.bytedance.android.livesdk.ktvimpl.base.sei.w r100 = this.E2;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r102 = r100.f143344b;
    L7:
        if ((r102 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L10;
        r101 = r102;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r103 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r101;
        if (r103 != null) goto L24;
        w.a("RealTimeChorusMainViewWidget", "lastSeiResult == null");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r104 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r104 == null) goto L17;
        if (r104.isEngineOn() != true) goto L17;
    L19:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.X) != null) goto L22;
        w.a("RealTimeChorusMainViewWidget", "singer show preview song");
        return true;
    L22:
        return false;
    L17:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L22;
    L24:
        if (r103.d() != 1) goto L29;
        if (r103.C() != 0) goto L29;
        return true;
    L29:
        if (r103.d() != 2) goto L31;
    L56:
        return true;
    L31:
        if (r103.d() == 6) goto L56;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r105 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r105 == null) goto L38;
        if (r105.isEngineOn() != true) goto L38;
    L40:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.X) != null) goto L44;
        w.a("RealTimeChorusMainViewWidget", "singer show preview song, ignore sei");
        return true;
    L44:
        if (((Boolean) KtvSettingHelper.f70648o1.getValue()).booleanValue() == false) goto L55;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r106 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r106 == null) goto L50;
        if (r106.isEngineOn() != true) goto L50;
    L52:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.X) != null) goto L55;
        w.a("RealTimeChorusMainViewWidget", "singer show preview song, ignore sei");
        return true;
    L50:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L52;
    L55:
        return false;
    L38:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L44;
    L5:
        r102 = null;
        goto L7
    }

    public final void Rq() {
        if (this.f146369x2 != null) goto L10;
        xh0.d r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getPlayModeService();
        if (r100 == null) goto L7;
        MultiLinkUniversalAnimWidget r101 = r100.e(this, SceneType.SCENE_KTV, this.containerView);
    L8:
        this.f146369x2 = r101;
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void Sq() {
        if (((Boolean) KtvSettingHelper.f70628i.getValue()).booleanValue() == false) goto L13;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r100 = this.Q;
        if (r100 != null) goto L7;
    L11:
        this.f146354p = false;
        w.a("RealTimeChorusMainViewWidget", "has not main stage");
        goto L13
    L7:
        if (r100.f146698a == null) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L13;
    L9:
        r101 = false;
    L13:
        if (this.f146354p == true) goto L18;
        this.f146354p = true;
        FrameLayout r102 = this.S;
        if (r102 == null) goto L19;
        r102.post(new d(this));
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1
    public final double Uc() {
        RealTimeChorusMidiWidget r100 = this.f146332J;
        if (r100 == null) goto L6;
        return r100.wq();
    L6:
        return this.P1;
    }

    public final void Zq() {
        ALogger.i("RealTimeChorusMainViewWidget", "releaseLiveRoomResource");
        this.S1 = true;
        if (KtvSettingHelper.b().booleanValue() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r100 = this.Q;     // Catch: Exception -> L104
        if (r100 == null) goto L8;
        r100.h(false, false);     // Catch: Exception -> L104
    L8:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c r101 = this.f146368x1;     // Catch: Exception -> L104
        if (r101 == null) goto L21;
        cg6.a r102 = (cg6.a) r101.f146791e.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);     // Catch: Exception -> L104
        if (r102 == null) goto L15;
        hg6.g r103 = r102.getRtcManager();     // Catch: Exception -> L104
        if (r103 == null) goto L15;
        r103.Z(r101.f146790d);     // Catch: Exception -> L104
    L15:
        ((ArrayList) r101.f146788b).clear();     // Catch: Exception -> L104
        r101.f146789c = null;     // Catch: Exception -> L104
        Disposable r104 = r101.f146787a;     // Catch: Exception -> L104
        if (r104 == null) goto L21;
        if (r104.isDisposed() == true) goto L20;
        r104.dispose();     // Catch: Exception -> L104
    L20:
        r101.f146787a = null;     // Catch: Exception -> L104
    L21:
        this.f146368x1 = null;     // Catch: Exception -> L104
        this.f146349k1 = null;     // Catch: Exception -> L104
        this.N2 = null;     // Catch: Exception -> L104
        RealTimeChorusOperateView r105 = this.f146361t;     // Catch: Exception -> L104
        if (r105 == null) goto L24;
        r105.f146393a.clear();     // Catch: Exception -> L104
    L24:
        RealTimeChorusOperateView r106 = this.f146361t;     // Catch: Exception -> L104
        if (r106 == null) goto L27;
        r106.setVisibility(4);     // Catch: Exception -> L104
    L27:
        hr(true);     // Catch: Exception -> L104
        RealTimeChorusOperateView r107 = this.f146361t;     // Catch: Exception -> L104
        if (r107 == null) goto L30;
        r107.setJoiningChorus(false);     // Catch: Exception -> L104
    L30:
        sb0.b r108 = this.f146348k0;     // Catch: Exception -> L104
        if (r108 == null) goto L33;
        sb0.e r109 = r108.b();     // Catch: Exception -> L104
    L34:
        if (r109 != null) goto L36;
    L40:
        DataCenter r110 = this.dataCenter;     // Catch: Exception -> L104
        if (r110 == null) goto L44;
        r110.removeObserver(this);     // Catch: Exception -> L104
    L44:
        if (((Boolean) KtvSettingHelper.f70619f.getValue()).booleanValue() == false) goto L50;
        KtvSingerViewModel r111 = this.f146356p1;     // Catch: Exception -> L104
        if ((r111 instanceof KtvSingerViewModel) == true) goto L48;
        r111 = null;
    L48:
        if (r111 == null) goto L50;
        r111.clearData();     // Catch: Exception -> L104
    L50:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r112 = this.X.getKtvSingerViewModel();     // Catch: Exception -> L104
        if (r112 == null) goto L53;
        r112.setValue(null);     // Catch: Exception -> L104
    L53:
        this.f146356p1 = null;     // Catch: Exception -> L104
        KtvCoreViewModel r113 = this.M;     // Catch: Exception -> L104
        if (r113 == null) goto L58;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.k r114 = r113.getAnchorController();     // Catch: Exception -> L104
        if (r114 == null) goto L58;
        r114.i();     // Catch: Exception -> L104
    L58:
        KtvCoreViewModel r115 = this.M;     // Catch: Exception -> L104
        if (r115 == null) goto L61;
        r115.setAnchorController(null);     // Catch: Exception -> L104
    L61:
        Tq(false);     // Catch: Exception -> L104
        Widget.WidgetCallback r116 = this.widgetCallback;     // Catch: Exception -> L104
        if (r116 == null) goto L66;
        WidgetManager r117 = r116.getWidgetManager();     // Catch: Exception -> L104
        if (r117 == null) goto L66;
        r117.dataCenter = null;     // Catch: Exception -> L104
    L66:
        RecyclableWidgetManager r118 = this.f146364v1;     // Catch: Exception -> L104
        if (r118 == null) goto L69;
        r118.dataCenter = null;     // Catch: Exception -> L104
    L69:
        Disposable r119 = this.Y;     // Catch: Exception -> L104
        if (r119 != null) goto L72;
    L74:
        RTChorusLogView r120 = this.f146367x;     // Catch: Exception -> L104
        if (r120 == null) goto L77;
        r120.f146223e.dispose();     // Catch: Exception -> L104
    L77:
        this.O = false;     // Catch: Exception -> L104
        if (((Boolean) KtvSettingHelper.f70667v.getValue()).booleanValue() == false) goto L84;
        KtvCoreViewModel r121 = this.M;     // Catch: Exception -> L104
        if (r121 == null) goto L84;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r122 = r121.getCurrentTransition();     // Catch: Exception -> L104
        if (r122 == null) goto L84;
        Kq(r122);     // Catch: Exception -> L104
    L84:
        gr();     // Catch: Exception -> L104
        WidgetManager r123 = this.subWidgetManager;     // Catch: Exception -> L104
        if (r123 == null) goto L87;
        r123.unload(this.f146369x2);     // Catch: Exception -> L104
    L87:
        this.f146369x2 = null;     // Catch: Exception -> L104
        Aq();     // Catch: Exception -> L104
        Disposable r124 = this.V0.getSecond();     // Catch: Exception -> L104
        if (r124 != null) goto L90;
    L92:
        Disposable r125 = this.f146333b1.getSecond();     // Catch: Exception -> L104
        if (r125 != null) goto L95;
    L97:
        Disposable r126 = this.f146340g1;     // Catch: Exception -> L104
        if (r126 != null) goto L100;
    L102:
        this.H0.clear();     // Catch: Exception -> L104
        return;
    L100:
        if (r126.isDisposed() == true) goto L102;
        r126.dispose();     // Catch: Exception -> L104
        this.f146340g1 = null;     // Catch: Exception -> L104
        goto L102
    L95:
        if (r125.isDisposed() == true) goto L97;
        r125.dispose();     // Catch: Exception -> L104
        this.f146333b1 = new Pair(null, null);     // Catch: Exception -> L104
        goto L97
    L90:
        if (r124.isDisposed() == true) goto L92;
        r124.dispose();     // Catch: Exception -> L104
        this.V0 = new Pair(null, null);     // Catch: Exception -> L104
        goto L92
    L72:
        if (r119.isDisposed() == true) goto L74;
        r119.dispose();     // Catch: Exception -> L104
        goto L74
    L36:
        if (this.f146348k0.isAnchor() == true) goto L40;
        if (this.X.isCurrentUserIsSinger() == false) goto L40;
        this.X.updateCurrentUserIsSinger(false);     // Catch: Exception -> L104
        goto L40
    L33:
        r109 = null;
    }

    public final void cr() {
        KtvModeOrderedSongDataContext r100 = KtvModeOrderedSongDataContext.Companion.getContext();
        com.bytedance.android.livesdk.log.filter.o r101 = null;
        if (r100 == null) goto L5;
        MusicPanel r102 = r100.getKtvPublicFirstOrderedSong();
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r103 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L11;
        r103 = null;
    L11:
        com.bytedance.android.livesdk.log.filter.t r104 = (com.bytedance.android.livesdk.log.filter.t) r103;
        if (r104 == null) goto L14;
        Map<String, String> r105 = r104.getMap();
    L16:
        if (r105 == null) goto L19;
        String r106 = r105.get("enter_from_merge");
        if (r106 == null) goto L19;
    L20:
        if (r105 == null) goto L23;
        String r107 = r105.get("enter_method");
        if (r107 == null) goto L23;
    L24:
        EnterRtChorusRoomSource r108 = EnterRtChorusRoomSource.CHORUS_PAGE;
        boolean r109 = true;
        if (Intrinsics.areEqual(r106, r108.getPair().getFirst()) == true) goto L27;
    L29:
        boolean r110 = false;
    L30:
        EnterRtChorusRoomSource r111 = EnterRtChorusRoomSource.SOLO_KTV_PAGE;
        if (Intrinsics.areEqual(r106, r111.getPair().getFirst()) == true) goto L33;
    L35:
        boolean r112 = false;
    L36:
        EnterRtChorusRoomSource r113 = EnterRtChorusRoomSource.ANCHOR_KSONG;
        if (Intrinsics.areEqual(r106, r113.getPair().getFirst()) == true) goto L39;
    L41:
        r109 = false;
    L42:
        com.bytedance.android.livesdk.log.filter.o r114 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r114 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L45;
        r114 = null;
    L45:
        com.bytedance.android.livesdk.log.filter.t r115 = (com.bytedance.android.livesdk.log.filter.t) r114;
        if (r115 == null) goto L49;
        String r116 = r115.l();
        if (r116 == null) goto L49;
    L50:
        com.bytedance.android.livesdk.log.filter.o r117 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r117 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L53;
        r117 = null;
    L53:
        com.bytedance.android.livesdk.log.filter.t r118 = (com.bytedance.android.livesdk.log.filter.t) r117;
        if (r118 == null) goto L57;
        String r119 = r118.e();
        if (r119 == null) goto L57;
    L58:
        if (r110 == true) goto L62;
        if (r112 == true) goto L62;
        if (r109 == true) goto L62;
        return;
    L62:
        if (Intrinsics.areEqual(r116, "true") == true) goto L64;
        return;
    L64:
        if (Intrinsics.areEqual(r119, com.bytedance.android.livesdk.chatroom.model.interact.e1.REPLY_ACTION_JOIN_CHORUS) == false) goto L78;
        RealTimeChorusOperateView r120 = this.f146361t;
        if (r120 == null) goto L68;
        r120.V5("enter room auto join");
    L68:
        com.bytedance.android.livesdk.log.filter.o r121 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r121 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L72;
        r101 = r121;
    L72:
        com.bytedance.android.livesdk.log.filter.t r122 = (com.bytedance.android.livesdk.log.filter.t) r101;
        if (r122 == null) goto L79;
        r122.F("");
        r122.t("");
        return;
    L79:
        return;
    L78:
        return;
    L57:
        r119 = "";
    L49:
        r116 = "";
        goto L50
    L39:
        if (Intrinsics.areEqual(r107, r113.getPair().getSecond()) == false) goto L41;
    L33:
        if (Intrinsics.areEqual(r107, r111.getPair().getSecond()) == false) goto L35;
        r112 = true;
        goto L36
    L27:
        if (Intrinsics.areEqual(r107, r108.getPair().getSecond()) == false) goto L29;
        r110 = true;
    L23:
        r107 = "";
    L19:
        r106 = "";
        goto L20
    L14:
        r105 = null;
        goto L16
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1
    public final py.k dp() {
        KtvContext r100 = this.X;
        if (r100 == null) goto L18;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.profit.dress.t> r101 = r100.getLinkmicRealTimeChorusDress();
        if (r101 == null) goto L18;
        com.bytedance.android.live.profit.dress.t r102 = r101.getValue();
        if (r102 == null) goto L18;
        List<com.bytedance.android.live.profit.dress.config.n> r103 = r102.f87173c;
        if (r103 == null) goto L18;
        Integer r104 = this.f146347k;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        com.bytedance.android.live.profit.dress.config.n r106 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r103, r105);
        if (r106 == null) goto L18;
        py.k r107 = r106.getJoinChorusBtnImage();
        if (r107 == null) goto L18;
        return r107;
    L13:
        r105 = 0;
    L18:
        int r108 = qy.a.f535172a;
        return qy.a.a(com.bytedance.android.live.ktv.common.midi.i.f69852a);
    }

    public final void fr() {
        if (this.A != null) goto L5;
    L10:
        Disposable r100 = this.D.getSecond();
        if (r100 != null) goto L13;
        return;
    L13:
        if (r100.isDisposed() == true) goto L17;
        r100.dispose();
        this.D = new Pair(null, null);
        return;
    L17:
        return;
    L5:
        if (Bq() == null) goto L10;
        RecyclableWidgetManager r101 = Bq();
        if (r101 == null) goto L9;
        r101.unload(this.A);
    L9:
        this.A = null;
        this.B = null;
        goto L10
    }

    public final LifecycleOwner getLifecycleOwner() {
        RealTimeChorusBusinessLifecycleOwner r100 = this.G1;
        if ((r100 instanceof LifecycleOwner) == true) goto L6;
        return null;
    L6:
        return r100;
    }

    public final void lr() {
        KtvCoreViewModel r100 = this.M;
        KtvMusic r101 = null;
        if (r100 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r102 = r100.getCurState();
    L6:
        int r103 = RealTimeChorusBusinessContext.Companion.b();
        if (r102 == null) goto L11;
        MusicPanel r104 = r102.b();
        if (r104 == null) goto L11;
        boolean r105 = KtvUtilsKt.C(r104);
    L13:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L15;
    L24:
        if (r105 == false) goto L43;
        if (r103 == 1) goto L29;
        if (r103 != 2) goto L43;
    L29:
        if (this.L == false) goto L34;
        this.L = false;
        FrameLayout r106 = this.I;
        if (r106 == null) goto L49;
        fd0.f r107 = LiveAnimator.a(new View[]{r106});
        r107.a();
        LiveAnimator r108 = r107.f476453a;
        r108.f71418b = 200;
        r108.f71424h = new i0(this);
        r107.e();
        return;
    L49:
        return;
    L34:
        if (this.f146332J == null) goto L36;
        return;
    L36:
        if (this.K == true) goto L52;
        this.K = true;
        RealTimeChorusMidiWidget r109 = new RealTimeChorusMidiWidget(this.X, this.f146368x1, this);
        r109.f146772f = new RealTimeChorusMainViewWidget$loadMidiWidget$$inlined$apply$lambda$1(this);
        Unit r110 = Unit.INSTANCE;
        this.f146332J = r109;
        RecyclableWidgetManager r111 = Bq();
        if (r111 == null) goto L40;
        r111.load(R.id.chorus_midi_container, this.f146332J, true);
    L40:
        RealTimeChorusSingerInfoView r112 = this.f146359r;
        if (r112 == null) goto L53;
        r112.setGetCurUserChorusDataCB(new RealTimeChorusMainViewWidget$loadMidiWidget$3(this));
        return;
    L53:
        return;
    L52:
        return;
    L43:
        MusicPanel r113 = r102.b();
        if (r113 == null) goto L46;
        r101 = r113.f153577a;
    L46:
        er(r101);
        return;
    L15:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L24;
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d) == true) goto L24;
        if (r102 == null) goto L23;
        MusicPanel r114 = r102.b();
        if (r114 == null) goto L23;
        r101 = r114.f153577a;
    L23:
        er(r101);
        return;
    L11:
        r105 = true;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // tb0.a
    public final void onBizDestory() {
        if (((Boolean) KtvSettingHelper.f70604a.getValue()).booleanValue() == false) goto L8;
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L8;
        r100.put(IKtvService.KEY_OF_CHORUS_SCENE_WIDGET_FOR_DATACENTER, null);
    L8:
        if (this.f146358q == true) goto L73;
        boolean r101 = true;
        this.f146358q = true;
        ALogger.i("RealTimeChorusMainViewWidget", "onBizDestory");
        this.f146371y1.d(new tb0.b.e());
        StringBuilder r102 = new StringBuilder("releaseAllResource ");     // Catch: Exception -> L70
        if (this.dataCenter == null) goto L14;
        r101 = false;
    L14:
        r102.append(r101);     // Catch: Exception -> L70
        ALogger.i("RealTimeChorusMainViewWidget", r102.toString());     // Catch: Exception -> L70
        RealTimeChorusBusinessLifecycleOwner r103 = this.G1;     // Catch: Exception -> L70
        if (r103 == null) goto L18;
        r103.f146255a.setCurrentState(Lifecycle.State.DESTROYED);     // Catch: Exception -> L70
    L18:
        if (((Boolean) KtvSettingHelper.f70628i.getValue()).booleanValue() == false) goto L20;
        this.G1 = null;     // Catch: Exception -> L70
        this.f146354p = false;     // Catch: Exception -> L70
    L20:
        Zq();     // Catch: Exception -> L70
        Disposable r104 = this.Z;     // Catch: Exception -> L70
        if (r104 != null) goto L23;
    L25:
        Tq(false);     // Catch: Exception -> L70
        fr();     // Catch: Exception -> L70
        IKtvService r105 = (IKtvService) jc1.k.f(IKtvService.class);     // Catch: Exception -> L70
        if (r105 == null) goto L28;
        r105.setKtvContext(null);     // Catch: Exception -> L70
    L28:
        this.X.clearKtvCoreAndSingerViewModel();     // Catch: Exception -> L70
        KtvCoreViewModel r106 = this.M;     // Catch: Exception -> L70
        if (r106 == null) goto L31;
        r106.clearData();     // Catch: Exception -> L70
    L31:
        KtvCoreViewModel r107 = this.M;     // Catch: Exception -> L70
        if (r107 == null) goto L34;
        r107.unregisterKtvCoreListener(this.I2);     // Catch: Exception -> L70
    L34:
        this.M = null;     // Catch: Exception -> L70
        com.bytedance.android.live.ktv.common.util.k r108 = this.X.getStatisticHelper();     // Catch: Exception -> L70
        r108.f70692b.clear();     // Catch: Exception -> L70
        r108.f70691a = null;     // Catch: Exception -> L70
        this.H0.clear();     // Catch: Exception -> L70
        this.L0.clear();     // Catch: Exception -> L70
        this.J2.clear();     // Catch: Exception -> L70
        RTChorusMusicInfoView r109 = this.f146360s;     // Catch: Exception -> L70
        if (r109 == null) goto L37;
        r109.R5();     // Catch: Exception -> L70
        r109.f146238o = null;     // Catch: Exception -> L70
        r109.f146237n.clear();     // Catch: Exception -> L70
    L37:
        FrameLayout r110 = this.F;     // Catch: Exception -> L70
        if (r110 == null) goto L40;
        r110.removeAllViews();     // Catch: Exception -> L70
    L40:
        MvLyricWidget r111 = this.E;     // Catch: Exception -> L70
        if (r111 == null) goto L43;
        r111.i();     // Catch: Exception -> L70
    L43:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r112 = this.Q;     // Catch: Exception -> L70
        if (r112 == null) goto L55;
        HybridCard r113 = r112.f146698a;     // Catch: Exception -> L70
        if (r113 == null) goto L50;
        r113.release();     // Catch: Exception -> L70
        ViewGroup r114 = r112.f146705h;     // Catch: Exception -> L70
        if (r114 == null) goto L50;
        r114.removeView(r113);     // Catch: Exception -> L70
    L50:
        HybridCard r115 = r112.f146699b;     // Catch: Exception -> L70
        if (r115 == null) goto L55;
        r115.release();     // Catch: Exception -> L70
        ViewGroup r116 = r112.f146706i;     // Catch: Exception -> L70
        if (r116 == null) goto L55;
        r116.removeView(r115);     // Catch: Exception -> L70
    L55:
        this.X.getSeiProcessor().getValue().g(this);     // Catch: Exception -> L70
        MessageHub r117 = this.R;     // Catch: Exception -> L70
        if (r117 == null) goto L58;
        r117.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);     // Catch: Exception -> L70
    L58:
        this.R = null;     // Catch: Exception -> L70
        k r118 = this.f146351m;     // Catch: Exception -> L70
        Disposable r119 = r118.f146682a;     // Catch: Exception -> L70
        if (r119 != null) goto L61;
    L63:
        r118.f146682a = null;     // Catch: Exception -> L70
        if (KtvSettingHelper.r().booleanValue() == false) goto L74;
        RecyclableWidgetManager r120 = this.f146364v1;     // Catch: Exception -> L70
        if (r120 == null) goto L68;
        r120.contentView = null;     // Catch: Exception -> L70
    L68:
        this.f146364v1 = null;     // Catch: Exception -> L70
        this.contentView = null;     // Catch: Exception -> L70
        return;
    L74:
        return;
    L61:
        if (r119.isDisposed() == false) goto L63;
        r119.dispose();     // Catch: Exception -> L70
        goto L63
    L23:
        if (r104.isDisposed() == true) goto L25;
        r104.dispose();     // Catch: Exception -> L70
    L75:
        return;
    }

    @Override // tb0.a
    public final void onBizEnterRoom() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizEnterRoom");
        if (jc0.a.b(this.f145733a, this.f145734b) == true) goto L6;
        ALogger.i("RealTimeChorusMainViewWidget", "onBizEnterKtvRoom but scene is not ktv or curUILayout is not 61");
        return;
    L6:
        this.X.getStatisticHelper().a();
        runWithRoomEntered(new e(this));
    }

    @Override // tb0.a
    public final void onBizHide() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizHide");
        this.f146371y1.d(new tb0.b.c());
    }

    @Override // tb0.a
    public final void onBizLeaveRoom() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizLeaveRoom");
        Yq("onBizLeaveRoom");
        this.f146371y1.d(new tb0.b.C7706b());
        Zq();
    }

    @Override // tb0.a
    public final void onBizShow() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizShow");
        this.f146371y1.d(new tb0.b.d());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        ALogger.i("RealTimeChorusMainViewWidget", LiveCommonConstants.REASON_ON_DEDTROY);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final FrameLayout vj() {
        FrameLayout r100 = this.H;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public final void gr() {
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L9;
        vlc.d r102 = r101.getValue();
        if (r102 == null) goto L9;
        r102.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);
    L9:
        com.bytedance.android.livesdk.chatroom.o r103 = o3.f();
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.j<vlc.d> r104 = r103.getMessageManager();
        if (r104 == null) goto L16;
        vlc.d r105 = r104.getValue();
        if (r105 == null) goto L16;
        r105.removeMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getWsMethod(), this);
    L16:
        com.bytedance.android.livesdk.chatroom.o r106 = o3.f();
        if (r106 == null) goto L24;
        com.bytedance.live.datacontext.j<vlc.d> r107 = r106.getMessageManager();
        if (r107 == null) goto L25;
        vlc.d r108 = r107.getValue();
        if (r108 == null) goto L26;
        r108.removeMessageListener(MessageType.LINK_MIC_BIG_EVENT.getWsMethod(), this);
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        MvLyricWidget r100 = this.E;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    public final void yq() {
        View r100 = Iq();
        if (r100 == null) goto L6;
        r100.post(new b(this));
        return;
    }

    public final int zq() {
        if (PadConfigUtils.c() == false) goto L5;
    L10:
        int r100 = (int) ((s1.w() * 9.0f) / 16.0f);
        int r101 = this.f146335c;
        if (r101 <= 0) goto L13;
        float r102 = s1.G(Math.min(r100, r101));
    L15:
        return (int) r102;
    L13:
        r102 = s1.G(r100);
        goto L15
    L5:
        if (FoldScreenUtils.e() == true) goto L10;
        if (s1.y() > s1.w()) goto L10;
        r102 = s1.G(s1.y());
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1
    public final List<UserChorusInfo> Ol() {
        return this.U;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.K2;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public final String getTypeName() {
        return this.L2;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return this.J2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Kq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r110) {
        KtvRoomLyricsStateMachineConfig.d r100 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        RealTimeChorusBusinessContext.a r101 = RealTimeChorusBusinessContext.Companion;
        mr(r100, r101.b());
        KtvRoomLyricsStateMachineConfig.d r102 = (KtvRoomLyricsStateMachineConfig.d) r110.f66101c;
        boolean r103 = false;
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L18;
        if (this.f146372y2 == true) goto L10;
        if ((this.f146371y1.f70685a instanceof tb0.c.b) == true) goto L10;
        w.a("RealTimeChorusMainViewWidget", "in feed onKtvStateIdle but not receivered sei");
        return;
    L10:
        if (KtvSettingHelper.w() == false) goto L15;
        if (Qq() == true) goto L15;
        w.a("RealTimeChorusMainViewWidget", "isMusicStopped false");
        return;
    L15:
        if (this.O == true) goto L97;
        pr(0, "onKtvStateIdle");
        mr((KtvRoomLyricsStateMachineConfig.d) r110.f66101c, r101.b());
        return;
    L97:
        return;
    L18:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L55;
        pr(1, "onKtvStatePreparing");
        RealTimeChorusSingerInfoView r104 = this.f146359r;
        if (r104 == null) goto L25;
        String r105 = this.f146345i;
        if (r105 != null) goto L24;
        r105 = "1";
    L24:
        r104.R5(r105, "#00FFE0");
    L25:
        MusicPanel r106 = ((KtvRoomLyricsStateMachineConfig.d) r110.f66101c).b();
        if (r106 == null) goto L48;
        RTChorusMusicInfoView r107 = this.f146360s;
        if (r107 == null) goto L48;
        Object[] r108 = new Object[1];
        KtvMusic r109 = r106.f153577a;
        if (r109 == null) goto L33;
        String r111 = r109.getMTitle();
        if (r111 == null) goto L33;
    L34:
        r108[0] = r111;
        r107.T5(s1.C(R.string.ttlive_rt_chorus_sing_music_info, r108));
        KtvMusic.a r112 = KtvMusic.Companion;
        KtvMusic r113 = r106.f153577a;
        r112.getClass();
        r107.U5(KtvMusic.a.a(r113) * ((long) 1000.0f));
        com.bytedance.android.livesdk.ktvimpl.base.util.j r114 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        KtvMusic r115 = r106.f153577a;
        r114.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r115) == true) goto L38;
        int r116 = 3;
    L47:
        r107.S5(r116);
        goto L48
    L38:
        if (r101.b() != 1) goto L40;
    L42:
        if (r103 == false) goto L44;
    L46:
        r116 = 1;
        goto L47
    L44:
        if (KtvUtilsKt.C(r106) != true) goto L46;
        r116 = 2;
        goto L47
    L40:
        if (r101.b() == 2) goto L42;
        r103 = true;
    L33:
        r111 = "";
    L48:
        this.M1 = ((KtvRoomLyricsStateMachineConfig.d) r110.f66101c).b();
        this.L1 = true;
        Disposable r117 = this.Z;
        if (r117 != null) goto L51;
    L53:
        this.Z = Observable.timer(this.H1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p0(this));
        return;
    L51:
        if (r117.isDisposed() == true) goto L53;
        r117.dispose();
        goto L53
    L55:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.C2274d) == false) goto L71;
        RTChorusMusicInfoView r118 = this.f146360s;
        if (r118 == null) goto L61;
        if (r118.getCurShowMode() != 0) goto L61;
    L65:
        pr(1, "onKtvStatePaused");
        STATE r119 = r110.f66101c;
        if (r119 == 0) goto L69;
        lr();
        or(((KtvRoomLyricsStateMachineConfig.d.C2274d) r119).f145409b);
        return;
    L69:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Paused");
    L61:
        if ((r110.f66099a instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L65;
        if ((r110.f66101c instanceof KtvRoomLyricsStateMachineConfig.d.C2274d) == false) goto L65;
        return;
    L71:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L87;
        pr(1, "onKtvStateSinging");
        RTChorusMusicInfoView r120 = this.f146360s;
        if (r120 == null) goto L77;
        if (r120.getCurShowMode() != 0) goto L77;
    L81:
        STATE r121 = r110.f66101c;
        if (r121 == 0) goto L85;
        lr();
        or(((KtvRoomLyricsStateMachineConfig.d.f) r121).f145409b);
        return;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L77:
        if ((r110.f66099a instanceof KtvRoomLyricsStateMachineConfig.d.C2274d) == false) goto L81;
        if ((r110.f66101c instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L81;
        return;
    L87:
        if ((r102 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L89;
        return;
    L89:
        if (KtvSettingHelper.w() == true) goto L91;
    L93:
        pr(0, "onKtvStateClosed");
        return;
    L91:
        if (Qq() == true) goto L93;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Mj(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return new EPointF(-1.0f, -1.0f);
    }

    public final void Mq(boolean r100) {
        IKtvService r101 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r101 == null) goto L6;
        r101.setKtvContext(this.X);
    L6:
        if (r100 == true) goto L31;
        DataCenter r102 = this.f146348k0.getDataCenter();
        com.bytedance.android.live.pushstream.d r103 = null;
        if (r102 == null) goto L23;
        Widget.WidgetCallback r104 = this.widgetCallback;
        if (r104 != null) goto L13;
    L15:
        RecyclableWidgetManager r105 = Bq();
        if (r105 == null) goto L18;
        DataCenter r106 = r105.dataCenter;
    L19:
        if (r106 != null) goto L23;
        RecyclableWidgetManager r107 = Bq();
        if (r107 == null) goto L23;
        r107.dataCenter = r102;
        goto L23
    L18:
        r106 = null;
        goto L19
    L13:
        if (r104.getWidgetManager().dataCenter != null) goto L15;
        this.widgetCallback.getWidgetManager().dataCenter = r102;
    L23:
        Tq(true);
        if (this.f146348k0.isAnchor() == false) goto L31;
        com.bytedance.android.livesdk.chatroom.o r108 = o3.f();
        if (r108 == null) goto L30;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r109 = r108.getLiveStream();
        if (r109 == null) goto L30;
        r103 = r109.getValue();
    L30:
        this.V.f146557d = r103;
    L31:
        this.X.getKtvRoomProvider().setValue(this.V);
        if (r100 == true) goto L49;
        if (this.f146333b1.getFirst() != null) goto L41;
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r110 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$initKtvRoomOrderedSongDataContextIfNeed$1.INSTANCE);
        this.f146333b1 = r110;
        OrderedSongDataContext r111 = r110.getFirst();
        if (r111 == null) goto L39;
        com.bytedance.live.datacontext.b.a(r111, KtvModeOrderedSongDataContext.class);
    L39:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L41;
        this.f146340g1 = du2.a.b(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g0(this));
    L41:
        Nq();
        Pq();
        RealTimeChorusBusinessContext r112 = RealTimeChorusBusinessContext.Companion.getContext();
        if (r112 == null) goto L49;
        com.bytedance.live.datacontext.j<fd2.s> r113 = r112.m8262getService();
        if (r113 == null) goto L49;
        fd2.s r114 = r113.getValue();
        if (r114 == null) goto L49;
        r114.Pa();
    L49:
        if (this.M != null) goto L51;
        ALogger.i("RealTimeChorusMainViewWidget", "initKtvCoreViewModel");
        KtvCoreViewModel r115 = new KtvCoreViewModel(this.V, this.f146348k0, this.X);
        r115.getKtvContext().getKtvCoreViewModel().setValue(r115);
        Unit r116 = Unit.INSTANCE;
        this.M = r115;
        r115.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{"state"}), this.I2, true);
    L51:
        if (r100 == true) goto L59;
        if (this.f146356p1 != null) goto L59;
        ALogger.i("RealTimeChorusMainViewWidget", "initKtvSingerViewModel");
        KtvCoreViewModel r117 = this.M;
        if (r117 == null) goto L57;
        this.f146356p1 = new KtvSingerViewModel(this.V, this.f146348k0, r117);
    L57:
        this.X.getKtvSingerViewModel().setValue(this.f146356p1);
    L59:
        if (this.f146346j == true) goto L62;
        this.f146346j = true;
        RxUtilKt.c(this.X.getLinkmicRealTimeChorusDress().a().subscribe(new z(this)), this.L0);
        return;
    }

    public final void Tq(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        if (this.f146343h1 == null) goto L23;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r101 = KtvRoomContext.a.a();
        if (r101 == null) goto L14;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r102 = r101.getPreviewViewModel();
        if (r102 == null) goto L14;
        r102.setValue(null);
    L14:
        Pair<KtvRoomContext, ? extends Disposable> r103 = this.f146343h1;
        if (r103 == null) goto L19;
        Disposable r104 = r103.getSecond();
        if (r104 == null) goto L19;
        r104.dispose();
    L19:
        this.f146343h1 = null;
        this.X.isKtvRoomContextInit().setValue(Boolean.FALSE);
        return;
    L23:
        return;
    L4:
        if (this.f146343h1 != null) goto L6;
        this.f146343h1 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$loadKtvRoomContext$1.INSTANCE);
        this.X.isKtvRoomContextInit().setValue(Boolean.TRUE);
    }

    public final void Yq(final String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        MessageHub r100 = this.R;
        if (r100 == null) goto L55;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r101 = this.Q;
        if (r101 == null) goto L55;
        Function2<String, Object, Unit> r102 = new RealTimeChorusMainViewWidget$registerMethods$$inlined$let$lambda$1(this, r110);
        Intrinsics.checkNotNullParameter(r100, "hub");
        Intrinsics.checkNotNullParameter(r110, "source");
        ALogger.i("RealTimeChorusMicHybridCardManager", "registerMethods ;; source == " + r110 + ", " + r101.f146699b);
        r101.d(r100);
        r101.e();
        r101.f146701d.dispose();
        r101.f146700c.dispose();
        r101.f146700c = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c.b(r101.f146698a);
        r101.f146701d = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c.b(r101.f146699b);
        Map<String, Map<String, List<Object>>> r111 = r101.f146702e;
        HybridCard r103 = r101.f146698a;
        if (r103 == null) goto L9;
        Integer r104 = Integer.valueOf(r103.hashCode());
    L10:
        Map r112 = (Map) ((LinkedHashMap) r111).get(String.valueOf(r104));
        if (r112 == null) goto L15;
        Set r113 = r112.keySet();
        if (r113 == null) goto L15;
        r113.clear();
    L15:
        Map<String, Map<String, List<Object>>> r114 = r101.f146702e;
        HybridCard r105 = r101.f146699b;
        if (r105 == null) goto L18;
        Integer r106 = Integer.valueOf(r105.hashCode());
    L19:
        Map r115 = (Map) ((LinkedHashMap) r114).get(String.valueOf(r106));
        if (r115 == null) goto L24;
        Set r116 = r115.keySet();
        if (r116 == null) goto L24;
        r116.clear();
    L24:
        JSONObject r117 = new JSONObject();
        r117.put("eventName", "event_party_ktv_register_wrds");
        HybridCard r107 = r101.f146698a;
        if (r107 == null) goto L27;
        r107.sendJsEvent("event_party_ktv_register_wrds", r117);
    L27:
        HybridCard r108 = r101.f146699b;
        if (r108 == null) goto L30;
        r108.sendJsEvent("event_party_ktv_register_wrds", r117);
    L30:
        r101.c();
        HybridCard r118 = r101.f146698a;
        if (r118 == null) goto L33;
        r118.registerMethod("registerWrds", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.h(r100, r102, String.valueOf(Integer.valueOf(r118.hashCode())), r101.f146702e));
    L33:
        HybridCard r119 = r101.f146698a;
        if (r119 == null) goto L36;
        r119.registerMethod("updateLinkmicStatus", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.j(r101, true));
    L36:
        HybridCard r120 = r101.f146698a;
        if (r120 == null) goto L39;
        r120.registerMethod("reportAggregateALog", com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.i.f146723a);
    L39:
        HybridCard r121 = r101.f146698a;
        if (r121 != null) goto L42;
    L44:
        if (r121 == null) goto L46;
        r121.registerMethod("registerMessage", new RealTimeChorusMicHybridCardManager$registerMethods$2(r101, r100));
    L46:
        HybridCard r122 = r101.f146698a;
        if (r122 == null) goto L49;
        r122.registerMethod("registerMessageLatch", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.e(new DataCenter()));
    L49:
        HybridCard r123 = r101.f146699b;
        if (r123 == null) goto L52;
        r123.registerMethod("registerWrds", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.h(r100, null, String.valueOf(Integer.valueOf(r123.hashCode())), r101.f146702e));
    L52:
        HybridCard r124 = r101.f146699b;
        if (r124 == null) goto L55;
        r124.registerMethod("updateLinkmicStatus", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.j(r101, true));
        goto L55
    L42:
        if ((r121 instanceof AnnieXLiveCard) == false) goto L44;
        r121.registerMethod("registerMessage", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.n(r101, r100));
        goto L46
    L18:
        r106 = null;
        goto L19
    L9:
        r104 = null;
    L55:
        MessageHub r125 = this.R;
        if (r125 == null) goto L59;
        r125.addMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r100, "result");
        return true;
    }

    public final void ar(String r100) {
        ALogger.i("RealTimeChorusMainViewWidget", "resetChorusDress source: ".concat(r100));
        this.X.getMidiSkinContext().setValue(null);
        this.X.getLinkmicRealTimeChorusDress().setValue(null);
    }

    public final void dr(MusicPanel r100) {
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.f143193a.getClass();
        ub0.d r101 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.b(r100);
        w.a("RealTimeChorusMainViewWidget", "sendSingerBeginSing, LyricsReaderHelper.parse");
        pd2.d.f528658n.N(r100);
        View r102 = this.contentView;
        if (r102 == null) goto L6;
        r102.postDelayed(new h(r101, this), 100);
        return;
    }

    public final void er(KtvMusic r100) {
        RealTimeChorusMidiWidget r101 = this.f146332J;
        if (r101 == null) goto L48;
        String r102 = null;
        r101.f146772f = null;
        int r103 = 0;
        this.K = false;
        this.L = true;
        KtvModeOrderedSongDataContext r104 = Eq();
        if (r104 == null) goto L13;
        List<MusicPanel> r105 = r104.m8257getKtvSingSongList();
        if (r105 == null) goto L13;
        MusicPanel r106 = (MusicPanel) KtvUtilsKt.K(r105, 0);
        if (r106 == null) goto L13;
        RealTimeChorusInfo r107 = r106.C;
        if (r107 == null) goto L13;
        Long r108 = Long.valueOf(r107.getChorusID());
    L14:
        RealTimeChorusMidiWidget r109 = this.f146332J;
        if (r109 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a r110 = r109.f146776j;
        if (r110 == null) goto L19;
        r102 = r110.f146784b;
    L19:
        long r111 = d5.c(r102);
        if (r108 != null) goto L23;
    L34:
        FrameLayout r112 = this.I;
        if (r112 == null) goto L37;
        fd0.f r113 = LiveAnimator.a(new View[]{r112});
        r113.b();
        LiveAnimator r114 = r113.f476453a;
        r114.f71418b = 200;
        r114.f71425i = new i(this);
        r113.e();
    L37:
        RTChorusMusicInfoView r115 = this.f146360s;
        if (r115 == null) goto L49;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r100) == true) goto L43;
        r103 = 3;
    L46:
        r115.S5(r103);
        return;
    L43:
        if (this.W == 0) goto L46;
        r103 = 1;
        goto L46
    L49:
        return;
    L23:
        if (r111 != r108.longValue()) goto L34;
        RealTimeChorusMidiWidget r116 = this.f146332J;
        double r117 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r116 == null) goto L27;
        double r118 = r116.wq();
    L28:
        this.P1 = r118;
        RealTimeChorusMidiWidget r119 = this.f146332J;
        if (r119 == null) goto L33;
        RealTimeChorusMidiViewModel r120 = r119.f146768b;
        if (r120 == null) goto L33;
        r117 = r120.getTotalScore();
    L33:
        this.Q1 = r117;
        goto L34
    L27:
        r118 = 0.0d;
    L13:
        r108 = null;
        goto L14
    }

    public final void hr(boolean r100) {
        RealTimeChorusSingerInfoView r101 = this.f146359r;
        int r102 = 0;
        if (r101 == null) goto L23;
        if (r100 == false) goto L14;
        ImageView r103 = r101.f146421i;
        if (r103 == null) goto L8;
        r103.setVisibility(8);
    L8:
        View r104 = r101.f146419g;
        if (r104 == null) goto L11;
        r104.setVisibility(8);
    L11:
        TextView r105 = r101.f146420h;
        if (r105 == null) goto L23;
        r105.setVisibility(8);
        goto L23
    L14:
        ImageView r106 = r101.f146421i;
        if (r106 == null) goto L17;
        r106.setVisibility(0);
    L17:
        View r107 = r101.f146419g;
        if (r107 == null) goto L20;
        r107.setVisibility(0);
    L20:
        TextView r108 = r101.f146420h;
        if (r108 == null) goto L23;
        r108.setVisibility(0);
    L23:
        RTChorusMusicInfoView r109 = this.f146360s;
        if (r109 == null) goto L31;
        TextView r110 = r109.f146231h;
        if (r110 == null) goto L32;
        if (r100 == false) goto L29;
        r102 = 4;
    L29:
        r110.setVisibility(r102);
        return;
    L32:
        return;
    }

    public final void jr(sb0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        ALogger.i("logKtvMainPath", ("updateDataEntity:" + r100) + ", invoke class :RealTimeChorusMainViewWidget");
        sb0.a r101 = this.f146355p0;
        r101.getClass();
        ALogger.i("DataEntityInvocationHandler", "dataEntity change:" + r100);
        r101.f541205a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == 135538046) goto L12;
        return;
    L12:
        if (r102.equals("data_dynamic_show_emoji_panel") == false) goto L20;
        String r103 = (String) r101.getData();
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r104 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r104 == null) goto L21;
        r104.openEmojiDialog(r103, "dynamic");
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (FoldScreenUtils.f() == true) goto L5;
    L9:
        yq();
        return;
    L5:
        if (FoldScreenUtils.c(r100) == 0) goto L9;
        View r101 = Iq();
        if (r101 == null) goto L9;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = -1;
        r102.width = -1;
        r101.setTranslationX(0.0f);
        r101.setLayoutParams(r102);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        ALogger.i("RealTimeChorusMainViewWidget", WidgetCostModule.TYPE_ON_LOAD);
        Function2<? super Boolean, ? super Long, Unit> r101 = this.K2;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L5:
        RecyclableWidgetManager r103 = this.f146364v1;
        if (r103 != null) goto L8;
    L9:
        Object r104 = null;
        if (KtvSettingHelper.i() == false) goto L50;
        Context r105 = this.context;
        if ((r105 instanceof FragmentActivity) == true) goto L14;
        r105 = null;
    L14:
        Context r106 = (FragmentActivity) r105;
        if (r106 != null) goto L19;
        r106 = com.bytedance.android.live.core.utils.a.d();
    L19:
        if ((r106 instanceof FragmentActivity) == true) goto L21;
        r106 = null;
    L21:
        FragmentActivity r107 = (FragmentActivity) r106;
        Fragment r108 = com.bytedance.android.livesdk.ktvimpl.base.util.d.a(r107);
        if (r108 != null) goto L24;
    L26:
        if (r107 != null) goto L28;
    L30:
        if (r108 == null) goto L43;
        FragmentManager r109 = r108.getChildFragmentManager();
        if (r109 == null) goto L43;
        List<Fragment> r110 = r109.getFragments();
        if (r110 == null) goto L43;
        Iterator<T> r111 = r110.iterator();
    L37:
        if (r111.hasNext() == false) goto L41;
        Object r112 = r111.next();
        if ((((Fragment) r112) instanceof RecyclableWidgetManager) == false) goto L37;
    L42:
        Fragment r113 = (Fragment) r112;
    L45:
        if ((r113 instanceof RecyclableWidgetManager) == false) goto L48;
        r104 = r113;
    L48:
        RecyclableWidgetManager r114 = (RecyclableWidgetManager) r104;
    L49:
        this.f146364v1 = r114;
    L62:
        Rq();
        Pair r115 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r116 = (AdminInviteAndApplyViewModel) r115.component1();
        Disposable r117 = (Disposable) r115.component2();
        com.bytedance.live.datacontext.b.a(r116, AdminInviteAndApplyViewModel.TAG);
        this.H0.add(r117);
        return;
    L41:
        r112 = null;
    L43:
        r113 = null;
        goto L45
    L28:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r107.getSupportFragmentManager()) == true) goto L30;
        r114 = RecyclableWidgetManager.ha0(r107, this.contentView);
        goto L49
    L24:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r108.getChildFragmentManager()) == true) goto L26;
        r114 = RecyclableWidgetManager.ga0(r108, this.contentView);
        goto L49
    L50:
        Context r118 = this.context;
        if ((r118 instanceof FragmentActivity) == true) goto L53;
        r118 = null;
    L53:
        Object r119 = (FragmentActivity) r118;
        if (r119 != null) goto L58;
        r119 = com.bytedance.android.live.core.utils.a.d();
    L58:
        if ((r119 instanceof FragmentActivity) == false) goto L61;
        r104 = r119;
    L61:
        this.f146364v1 = RecyclableWidgetManager.ha0((FragmentActivity) r104, this.contentView);
        goto L62
    L8:
        if (r103.isDetached() != true) goto L62;
        goto L9
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r310) {
        String r100 = "0";
        boolean r110 = false;
        if ((r310 instanceof jd) == false) goto L71;
        jd r101 = (jd) r310;
        Integer r102 = r101.getMsgType();
        if (r102 != null) goto L8;
    L49:
        if (r102 != null) goto L52;
        return;
    L52:
        if (r102.intValue() != 6) goto L491;
        StringBuilder r103 = new StringBuilder("KtvChorusActionMessage ;; onMessage messageType = ");
        r103.append(r101.getMsgType());
        r103.append(" ;; messageId = ");
        r103.append(r101.getMessageId());
        r103.append(" ;; stage = ");
        q2 r104 = r101.getInitContent();
        if (r104 == null) goto L58;
        aj r105 = r104.a();
        if (r105 == null) goto L58;
        Integer r106 = r105.c();
    L59:
        r103.append(r106);
        ALogger.i("RealTimeChorusMainViewWidget", r103.toString());
        q2 r107 = r101.getInitContent();
        if (r107 == null) goto L492;
        aj r108 = r107.a();
        if (r108 == null) goto L493;
        this.f146345i = "1";
        RealTimeChorusSingerInfoView r109 = this.f146359r;
        if (r109 == null) goto L66;
        r109.R5("1", "#00FFE0");
    L66:
        RealTimeChorusSingerInfoView r111 = this.f146359r;
        if (r111 == null) goto L69;
        r111.S5("0");
    L69:
        nr(r108, false);
        return;
    L493:
        return;
    L492:
        return;
    L58:
        r106 = null;
        goto L59
    L491:
        return;
    L8:
        if (r102.intValue() != 3) goto L49;
        StringBuilder r112 = new StringBuilder("KtvChorusActionMessage ;; onMessage messageType = ");
        r112.append(r101.getMsgType());
        r112.append(" ;; messageId = ");
        r112.append(r101.getMessageId());
        r112.append(" ;; stage = ");
        x2 r113 = r101.getStageUpdateContent();
        if (r113 == null) goto L14;
        aj r114 = r113.a();
        if (r114 == null) goto L14;
        Integer r115 = r114.c();
    L15:
        r112.append(r115);
        ALogger.i("RealTimeChorusMainViewWidget", r112.toString());
        x2 r116 = r101.getStageUpdateContent();
        if (r116 == null) goto L486;
        aj r117 = r116.a();
        if (r117 == null) goto L487;
        nr(r117, false);
        x2 r118 = r101.getStageUpdateContent();
        if (r118 == null) goto L22;
        List<User> r119 = r118.b();
    L23:
        JSONObject r120 = new JSONObject();
        r120.put("stage", r117.c());
        Long r121 = r117.a();
        if (r121 == null) goto L26;
        r120.put("chorus_id", String.valueOf(r121.longValue()));
    L26:
        List<User> r122 = r119;
        if (r122 != null) goto L29;
    L30:
        r110 = true;
    L31:
        if (r110 == true) goto L44;
        JSONArray r123 = new JSONArray();
        Iterator<T> r124 = r119.iterator();
    L34:
        if (r124.hasNext() == false) goto L43;
        User r125 = (User) r124.next();
        JSONObject r126 = new JSONObject();
        r126.put("uid", r125.getIdStr());
        if (r125.getAvatarThumb() == null) goto L42;
        ImageModel r127 = r125.getAvatarThumb();
        if (r127 == null) goto L40;
        String r128 = KtvUtilsKt.g(r127);
    L41:
        r126.put("avatar_url", r128);
        goto L42
    L40:
        r128 = null;
    L42:
        r123.put(r126);
        goto L34
    L43:
        r120.put("user_list", r123);
    L44:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r129 = this.Q;
        if (r129 == null) goto L488;
        Intrinsics.checkNotNullParameter(r120, "jsonObject");
        HybridCard r130 = r129.f146698a;
        if (r130 == null) goto L489;
        r130.sendJsEvent("event_ktv_chorus_effect_change", r120);
        return;
    L489:
        return;
    L488:
        return;
    L29:
        if (r122.isEmpty() == false) goto L31;
    L22:
        r119 = null;
        goto L23
    L487:
        return;
    L486:
        return;
    L14:
        r115 = null;
        goto L15
    L71:
        if ((r310 instanceof kd) == false) goto L409;
        if (this.f146344h2 != 0) goto L84;
        sb0.b r131 = this.f146348k0;
        if (r131 == null) goto L77;
        sb0.e r132 = r131.b();
    L78:
        if (r132 == null) goto L84;
        if (this.f146348k0.isAnchor() == true) goto L84;
        this.f146344h2++;
        if (((kd) r310).getMsgType() != 1) goto L84;
        return;
    L77:
        r132 = null;
    L84:
        kd r133 = (kd) r310;
        if (r133.getMsgType() == 1) goto L91;
        aj r134 = r133.E();
        if (r134 == null) goto L89;
        Long r135 = r134.a();
    L90:
        this.f146342h = r135;
        goto L91
    L89:
        r135 = null;
    L91:
        long r136 = r133.getMsgType();
        if (r136 != 1) goto L362;
        u2 r137 = r133.H();
        if (r137 == null) goto L96;
        List<t2> r138 = r137.c();
    L98:
        if (((Boolean) KtvSettingHelper.f70667v.getValue()).booleanValue() == false) goto L109;
        aj r139 = r133.E();
        if (r139 == null) goto L102;
        Long r140 = r139.a();
    L104:
        if (Intrinsics.areEqual(r140, this.f146342h) == false) goto L113;
        if (r138 == null) goto L113;
        if ((!r138.isEmpty()) != true) goto L113;
    L112:
        boolean r141 = true;
    L114:
        if (r141 == false) goto L348;
        u2 r142 = r133.H();
        KtvCoreViewModel r143 = this.M;
        if (r143 == null) goto L121;
        KtvRoomLyricsStateMachineConfig.d r144 = r143.getCurState();
        if (r144 == null) goto L121;
        MusicPanel r145 = r144.b();
        if (r145 == null) goto L121;
    L127:
        if (r145 == null) goto L129;
    L131:
        if (r142 == null) goto L133;
        long r146 = r142.b();
    L134:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r147 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        if (r142 == null) goto L139;
        Long r148 = r142.d();
        if (r148 == null) goto L139;
        long r149 = r148.longValue();
    L140:
        Long r150 = Long.valueOf(r149);
        r147.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.e(r150) == false) goto L348;
        RealTimeChorusFeedBackView r151 = this.N;
        if (r151 == null) goto L341;
        double r152 = Gq();
        if (r142 == null) goto L341;
        List<t2> r153 = r142.c();
        if (r153 == null) goto L341;
        if (r153.isEmpty() == true) goto L341;
        com.bytedance.android.livesdk.user.e r154 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user();
        Iterator<T> r155 = r153.iterator();
    L155:
        if (r155.hasNext() == false) goto L164;
        Object r156 = r155.next();
        w2 r210 = ((t2) r156).c();
        if (r210 == null) goto L159;
        String r157 = r210.b();
    L161:
        if (Intrinsics.areEqual(r157, r154.n()) == false) goto L155;
    L165:
        t2 r158 = (t2) r156;
        long r311 = r146;
        if (r152 <= 0) goto L172;
        if (r158 != null) goto L172;
        final t2 r159 = new t2();
        w2 r160 = new w2();
        r160.d(r154.n());
        r160.c(r154.b().getAvatarThumbKt());
        Unit r161 = Unit.INSTANCE;
        r159.f(r160);
        r159.d(String.valueOf(r152));
        int r162 = CollectionsKt.binarySearch$default(r153, 0, 0, new RealTimeChorusFeedBackView$insertAndGetRank$index$1(r159), 3, null);
        if (r162 >= 0) goto L171;
        r162 = (-r162) - 1;
    L171:
        ListProtector.add(r153, r162, r159);
        int r163 = 1;
        r159.e(r162 + 1);
        r158 = r159;
    L173:
        TextView r164 = r151.f146330o;
        if (r164 == null) goto L176;
        Object[] r165 = new Object[r163];
        r165[0] = r142.e();
        r164.setText(s1.C(R.string.ttlive_rt_chorus_feedback_song_name, r165));
    L176:
        TextView r166 = r151.f146331p;
        if (r166 == null) goto L190;
        if (r158 == null) goto L184;
        Object[] r167 = new Object[2];
        r167[0] = Long.valueOf(r158.b());
        Long r168 = r142.f();
        if (r168 == null) goto L182;
        long r169 = r168.longValue();
    L183:
        r167[1] = Long.valueOf(r169);
        String r170 = s1.C(R.string.ttlive_real_time_chorus_singer_number_and_rank, r167);
    L189:
        r166.setText(r170);
        goto L190
    L182:
        r169 = 0;
        goto L183
    L184:
        Object[] r171 = new Object[1];
        Long r172 = r142.f();
        if (r172 == null) goto L187;
        long r173 = r172.longValue();
    L188:
        r171[0] = Long.valueOf(r173);
        r170 = s1.C(R.string.ttlive_real_time_chorus_singer_number, r171);
        goto L189
    L187:
        r173 = 0;
    L190:
        TextView r174 = r151.f146329n;
        if (r174 == null) goto L196;
        String r175 = r142.a();
        if (r175 == null) goto L195;
        r100 = r175;
    L195:
        r174.setText(r100);
    L196:
        TextView r176 = r151.f146329n;
        if (r176 == null) goto L199;
        CharSequence r177 = r176.getText();
    L200:
        String r178 = String.valueOf(r177);
        Intrinsics.checkNotNullParameter(r178, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        HashMap r179 = new HashMap();
        xe2.h.a(r179);
        xe2.h.c(r179);
        r179.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, r178);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chorus_end_info_show", r179, new Object[]{IRoom.class, am2.x.class});
        HSImageView r180 = r151.f146316a;
        if (r180 == null) goto L203;
        r180.setVisibility(8);
    L203:
        HSImageView r181 = r151.f146317b;
        if (r181 == null) goto L206;
        r181.setVisibility(8);
    L206:
        HSImageView r182 = r151.f146318c;
        if (r182 == null) goto L209;
        r182.setVisibility(8);
    L209:
        HSImageView r183 = r151.f146319d;
        if (r183 == null) goto L212;
        r183.setVisibility(8);
    L212:
        HSImageView r184 = r151.f146320e;
        if (r184 == null) goto L215;
        r184.setVisibility(8);
    L215:
        HSImageView r185 = r151.f146321f;
        if (r185 == null) goto L218;
        r185.setVisibility(8);
    L218:
        HSImageView r186 = r151.f146322g;
        if (r186 == null) goto L221;
        r186.setVisibility(8);
    L221:
        ImageView r187 = r151.f146323h;
        if (r187 == null) goto L224;
        r187.setVisibility(8);
    L224:
        ImageView r188 = r151.f146324i;
        if (r188 == null) goto L227;
        r188.setVisibility(8);
    L227:
        ImageView r189 = r151.f146325j;
        if (r189 == null) goto L230;
        r189.setVisibility(8);
    L230:
        TextView r190 = r151.f146326k;
        if (r190 == null) goto L233;
        r190.setVisibility(8);
    L233:
        TextView r191 = r151.f146327l;
        if (r191 == null) goto L236;
        r191.setVisibility(8);
    L236:
        TextView r192 = r151.f146328m;
        if (r192 == null) goto L239;
        r192.setVisibility(8);
    L239:
        t2 r193 = (t2) KtvUtilsKt.K(r153, 0);
        if (r193 == null) goto L251;
        w2 r194 = r193.c();
        if (r194 == null) goto L251;
        py.k r195 = r194.a();
        if (r195 == null) goto L251;
        ImageUtil.loadRoundImage(r151.f146316a, r195);
        HSImageView r196 = r151.f146316a;
        if (r196 == null) goto L248;
        r196.setVisibility(0);
    L248:
        ImageView r197 = r151.f146323h;
        if (r197 == null) goto L251;
        r197.setVisibility(0);
    L251:
        t2 r198 = (t2) KtvUtilsKt.K(r153, 1);
        if (r198 == null) goto L263;
        w2 r199 = r198.c();
        if (r199 == null) goto L263;
        py.k r200 = r199.a();
        if (r200 == null) goto L263;
        ImageUtil.loadRoundImage(r151.f146317b, r200);
        HSImageView r201 = r151.f146317b;
        if (r201 == null) goto L260;
        r201.setVisibility(0);
    L260:
        ImageView r202 = r151.f146324i;
        if (r202 == null) goto L263;
        r202.setVisibility(0);
    L263:
        t2 r203 = (t2) KtvUtilsKt.K(r153, 2);
        if (r203 == null) goto L275;
        w2 r204 = r203.c();
        if (r204 == null) goto L275;
        py.k r205 = r204.a();
        if (r205 == null) goto L275;
        ImageUtil.loadRoundImage(r151.f146318c, r205);
        HSImageView r206 = r151.f146318c;
        if (r206 == null) goto L272;
        r206.setVisibility(0);
    L272:
        ImageView r207 = r151.f146325j;
        if (r207 == null) goto L275;
        r207.setVisibility(0);
    L275:
        t2 r208 = (t2) KtvUtilsKt.K(r153, 3);
        if (r208 == null) goto L284;
        w2 r209 = r208.c();
        if (r209 == null) goto L284;
        py.k r211 = r209.a();
        if (r211 == null) goto L284;
        ImageUtil.loadRoundImage(r151.f146319d, r211);
        HSImageView r212 = r151.f146319d;
        if (r212 == null) goto L284;
        r212.setVisibility(0);
    L284:
        t2 r213 = (t2) KtvUtilsKt.K(r153, 4);
        if (r213 == null) goto L293;
        w2 r214 = r213.c();
        if (r214 == null) goto L293;
        py.k r215 = r214.a();
        if (r215 == null) goto L293;
        ImageUtil.loadRoundImage(r151.f146320e, r215);
        HSImageView r216 = r151.f146320e;
        if (r216 == null) goto L293;
        r216.setVisibility(0);
    L293:
        t2 r217 = (t2) KtvUtilsKt.K(r153, 5);
        if (r217 == null) goto L302;
        w2 r218 = r217.c();
        if (r218 == null) goto L302;
        py.k r219 = r218.a();
        if (r219 == null) goto L302;
        ImageUtil.loadRoundImage(r151.f146321f, r219);
        HSImageView r220 = r151.f146321f;
        if (r220 == null) goto L302;
        r220.setVisibility(0);
    L302:
        t2 r221 = (t2) KtvUtilsKt.K(r153, 6);
        if (r221 == null) goto L311;
        w2 r222 = r221.c();
        if (r222 == null) goto L311;
        py.k r223 = r222.a();
        if (r223 == null) goto L311;
        ImageUtil.loadRoundImage(r151.f146322g, r223);
        HSImageView r224 = r151.f146322g;
        if (r224 == null) goto L311;
        r224.setVisibility(0);
    L311:
        t2 r225 = (t2) KtvUtilsKt.K(r153, 0);
        if (r225 == null) goto L321;
        String r226 = r225.a();
        if (r226 == null) goto L321;
        TextView r1100 = r151.f146326k;
        if (r1100 == null) goto L318;
        r1100.setText(s1.C(R.string.ttlive_real_time_chorus_score, new Object[]{r226}));
    L318:
        TextView r227 = r151.f146326k;
        if (r227 == null) goto L321;
        r227.setVisibility(0);
    L321:
        t2 r228 = (t2) KtvUtilsKt.K(r153, 1);
        if (r228 == null) goto L331;
        String r1101 = r228.a();
        if (r1101 == null) goto L331;
        TextView r1102 = r151.f146327l;
        if (r1102 == null) goto L328;
        r1102.setText(s1.C(R.string.ttlive_real_time_chorus_score, new Object[]{r1101}));
    L328:
        TextView r229 = r151.f146327l;
        if (r229 == null) goto L331;
        r229.setVisibility(0);
    L331:
        t2 r230 = (t2) KtvUtilsKt.K(r153, 2);
        if (r230 == null) goto L342;
        String r231 = r230.a();
        if (r231 == null) goto L342;
        TextView r232 = r151.f146328m;
        if (r232 == null) goto L338;
        r232.setText(s1.C(R.string.ttlive_real_time_chorus_score, new Object[]{r231}));
    L338:
        TextView r233 = r151.f146328m;
        if (r233 == null) goto L342;
        r233.setVisibility(0);
    L342:
        StringBuilder r234 = new StringBuilder("showFeedBackView duration ");
        long r1103 = r311;
        r234.append(r1103);
        pr(2, r234.toString());
        Disposable r235 = this.Y;
        if (r235 != null) goto L345;
    L347:
        w.a("RealTimeChorusMainViewWidget", "showFeedBackView start timer");
        this.Y = Observable.timer(r1103, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new u0(this), new v0(this), w0.f146967a);
        goto L348
    L345:
        if (r235.isDisposed() == true) goto L347;
        r235.dispose();
        goto L347
    L199:
        r177 = null;
    L172:
        r163 = 1;
        goto L173
    L159:
        r157 = null;
        goto L161
    L164:
        r156 = null;
    L341:
        r311 = r146;
    L139:
        r149 = 0;
        goto L140
    L133:
        r146 = 5;
        goto L134
    L129:
        if (this.f146352n != 0) goto L131;
        w.a("RealTimeChorusMainViewWidget", "showFeedBackView music is null so return");
    L121:
        KtvModeOrderedSongDataContext r236 = Eq();
        if (r236 == null) goto L126;
        List<MusicPanel> r237 = r236.m8257getKtvSingSongList();
        if (r237 == null) goto L126;
        r145 = (MusicPanel) KtvUtilsKt.K(r237, 0);
    L126:
        r145 = null;
    L348:
        StringBuilder r238 = new StringBuilder("show feedback view : rank count = ");
        u2 r239 = r133.H();
        if (r239 == null) goto L353;
        List<t2> r240 = r239.c();
        if (r240 == null) goto L353;
        Integer r241 = Integer.valueOf(r240.size());
    L354:
        r238.append(r241);
        r238.append(" ;; lastChorusId = ");
        r238.append(this.f146342h);
        r238.append(" ;; chorusId = ");
        aj r242 = r133.E();
        if (r242 == null) goto L357;
        Long r243 = r242.a();
    L358:
        r238.append(r243);
        w.a("RealTimeChorusMainViewWidget", r238.toString());
        u2 r244 = r133.H();
        if (r244 == null) goto L387;
        this.H1 = r244.b() * ((long) 1000);
    L387:
        Intrinsics.checkNotNullParameter(r133, "message");
        if (this.T1.contains(Long.valueOf(r133.getMsgType())) == true) goto L390;
    L394:
        boolean r245 = false;
    L395:
        if (r245 == false) goto L495;
        this.f146357p2 = true;
        if (r133.getMsgType() != 2) goto L401;
        aj r246 = r133.E();
        if (r246 == null) goto L401;
        r246.d(Integer.valueOf(RealTimeChorusStage.RealTimeChorusStage_Normal.getValue()));
    L401:
        StringBuilder r247 = new StringBuilder("KtvChorusMessage ;; onMessage messageType = ");
        r247.append(r133.getMsgType());
        r247.append(" ;; messageId = ");
        r247.append(r133.getMessageId());
        r247.append(" ;; stage = ");
        aj r248 = r133.E();
        if (r248 == null) goto L404;
        Integer r249 = r248.c();
    L405:
        r247.append(r249);
        ALogger.i("RealTimeChorusMainViewWidget", r247.toString());
        aj r250 = r133.E();
        if (r250 == null) goto L496;
        nr(r250, false);
        return;
    L496:
        return;
    L404:
        r249 = null;
        goto L405
    L495:
        return;
    L390:
        if (this.dataCenter != null) goto L392;
    L393:
        r245 = true;
        goto L395
    L392:
        if (this.f146357p2 == true) goto L394;
    L357:
        r243 = null;
    L353:
        r241 = null;
    L113:
        r141 = false;
        goto L114
    L102:
        r140 = null;
        goto L104
    L109:
        if (r138 == null) goto L113;
        if ((!r138.isEmpty()) != true) goto L113;
    L96:
        r138 = null;
        goto L98
    L362:
        if (r136 != 3) goto L387;
        z2 r251 = r133.G();
        if (r251 == null) goto L380;
        String r252 = r251.d();
        if (r252 == null) goto L380;
        if (this.W == 0) goto L377;
        RealTimeChorusSingerInfoView r253 = this.f146359r;
        if (r253 != null) goto L372;
    L374:
        RealTimeChorusSingerInfoView r254 = this.f146359r;
        if (r254 == null) goto L377;
        r254.setSelfVisibility(0);
        goto L377
    L372:
        if (r253.getVisibility() != 0) goto L374;
    L377:
        this.f146345i = r252;
        RealTimeChorusSingerInfoView r255 = this.f146359r;
        if (r255 == null) goto L380;
        r255.R5(r252, Fq());
    L380:
        z2 r256 = r133.G();
        if (r256 == null) goto L387;
        String r257 = r256.b();
        if (r257 == null) goto L387;
        RealTimeChorusSingerInfoView r258 = this.f146359r;
        if (r258 == null) goto L387;
        r258.S5(r257);
        goto L387
    L409:
        if ((r310 instanceof LinkMicBigEventMessage) == false) goto L498;
        LinkMicBigEventMessage r259 = (LinkMicBigEventMessage) r310;
        int r260 = 100;
        switch(r259.msgType) {
            case 7: goto L473;
            case 8: goto L470;
            case 9: goto L445;
            case 10: goto L435;
            case 11: goto L512;
            case 12: goto L413;
            default: goto L512;
        };
    L413:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r261 = KSongTuningPanelHelperKt.d();
        if (r261 == null) goto L499;
        com.bytedance.live.datacontext.m<IRoom> r262 = o3.f().getRoom();
        if (r262 == null) goto L420;
        IRoom r263 = r262.getValue();
        if (r263 == null) goto L420;
        long r264 = r263.getRoomId();
    L421:
        float r265 = 100;
        float r266 = (r261.X() / r261.M()) * r265;
        float r267 = (r261.V() / r261.D()) * r265;
        float r268 = (r261.e() / r261.w()) * r265;
        if (r261.R() == false) goto L424;
        long r312 = 1;
    L426:
        if ((r261 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L428;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r269 = null;
    L429:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r270 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r269;
        if (r270 == null) goto L433;
        String r271 = r270.T();
        if (r271 == null) goto L433;
    L434:
        RxUtilKt.c(((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).reportTunningInfo(r264, (long) r268, (long) r266, (long) r267, 2, r312, r271).compose(RxUtil.rxSchedulerHelper()).subscribe(f.f146378a, g.f146379a), this.H0);
        return;
    L433:
        r271 = "none";
        goto L434
    L428:
        r269 = r261;
        goto L429
    L424:
        r312 = 2;
    L420:
        r264 = 0;
        goto L421
    L499:
        return;
    L435:
        RealTimeChorusOperateView r272 = this.f146361t;
        if (r272 != null) goto L438;
        return;
    L438:
        if (r272.getJoinBtnStatus() != 1) goto L502;
        RealTimeChorusOperateView r273 = this.f146361t;
        if (r273 == null) goto L503;
        RealtimeChorusProgressImageView r274 = r273.getChorusContainer();
        if (r274 == null) goto L504;
        r274.performClick();
        return;
    L504:
        return;
    L503:
        return;
    L502:
        return;
    L470:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r275 = KSongTuningPanelHelperKt.d();
        if (r275 == null) goto L508;
        r275.setTuningEffect(r259.getSwitch_tuning_effect_content().to_effect_name);
        return;
    L508:
        return;
    L473:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r276 = KSongTuningPanelHelperKt.d();
        if (r276 != null) goto L476;
        return;
    L476:
        if (r259.getSwitch_full_song_status_content().to_status != 1) goto L478;
        boolean r1104 = true;
    L479:
        r276.q(r1104, false);
        return;
    L478:
        r1104 = false;
        goto L479
    L512:
        return;
    L445:
        if (this.F2 == null) goto L447;
    L450:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r277 = KSongTuningPanelHelperKt.d();
        if (r277 == null) goto L453;
        int r278 = r277.M();
    L454:
        float r279 = 100;
        float r280 = (r278 * r259.switch_song_volume_content.accompaniment_volume()) / r279;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r281 = KSongTuningPanelHelperKt.d();
        if (r281 == null) goto L457;
        r281.e0(r280);
    L457:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r282 = KSongTuningPanelHelperKt.d();
        if (r282 == null) goto L460;
        int r283 = r282.w();
    L461:
        float r284 = (r283 * r259.switch_song_volume_content.singer_volume()) / r279;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r285 = KSongTuningPanelHelperKt.d();
        if (r285 == null) goto L464;
        r285.m(r284, false, true);
    L464:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r286 = KSongTuningPanelHelperKt.d();
        if (r286 == null) goto L467;
        r260 = r286.D();
    L467:
        float r287 = (r260 * r259.switch_song_volume_content.chorus_singers_volume()) / r279;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r288 = KSongTuningPanelHelperKt.d();
        if (r288 == null) goto L506;
        r288.j(r287);
        return;
    L506:
        return;
    L460:
        r283 = 100;
        goto L461
    L453:
        r278 = 100;
        goto L454
    L447:
        if (KSongTuningPanelHelperKt.d() == null) goto L450;
        n1 r289 = new n1();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r290 = KSongTuningPanelHelperKt.d();
        Intrinsics.checkNotNull(r290);
        r289.f146834a = r290.e();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r291 = KSongTuningPanelHelperKt.d();
        Intrinsics.checkNotNull(r291);
        r289.f146835b = r291.X();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r292 = KSongTuningPanelHelperKt.d();
        Intrinsics.checkNotNull(r292);
        r289.f146836c = r292.V();
        Unit r293 = Unit.INSTANCE;
        this.F2 = r289;
        goto L450
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        this.E2 = r110;
        KtvRoomLyricsStateMachineConfig.d r100 = null;
        if ((r110.f143344b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.r) == true) goto L81;
    L27:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r101 = r110.f143344b;
        if ((r101 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L65;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r102 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r101).w();
        String r103 = "";
        if (r102 == null) goto L33;
        String r104 = r102.g();
        if (r104 == null) goto L33;
    L34:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r105 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r110.f143344b).w();
        if (r105 == null) goto L38;
        String r106 = r105.h();
        if (r106 == null) goto L38;
    L39:
        long r107 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r110.f143344b).j();
        if (StringUtils.isEmpty(r104) == true) goto L55;
        Object[] r108 = new Object[1];
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r109 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r110.f143344b).w();
        if (r109 == null) goto L47;
        String r111 = r109.g();
        if (r111 == null) goto L47;
        r103 = r111;
    L47:
        r108[0] = r103;
        String r112 = s1.C(R.string.ttlive_rt_chorus_sing_music_info, r108);
        RTChorusMusicInfoView r113 = this.f146360s;
        if (r113 == null) goto L51;
        r113.T5(r112);
    L51:
        if (r107 == 0) goto L53;
        String r114 = String.valueOf(r107);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        xe2.h.f563363g = r114;
    L53:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        xe2.h.f563362f = r104;
    L55:
        if (this.f146352n == r107) goto L57;
    L59:
        boolean r115 = false;
    L60:
        if (r115 == true) goto L65;
        this.f146352n = r107;
        this.f146353o = r106;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r116 = this.Q;
        if (r116 == null) goto L65;
        r116.g(r104, String.valueOf(r107));
        goto L65
    L57:
        if (Intrinsics.areEqual(this.f146353o, r106) == false) goto L59;
        r115 = true;
    L38:
        r106 = "";
    L33:
        r104 = "";
    L65:
        if (this.f146372y2 == true) goto L67;
        this.f146372y2 = true;
    L67:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r117 = this.G;
        if (r117 == null) goto L71;
        r117.onSeiResult(r110);
    L71:
        if (KtvSettingHelper.w() == true) goto L73;
        return;
    L73:
        if (Qq() == false) goto L87;
        KtvCoreViewModel r118 = this.M;
        if (r118 == null) goto L78;
        r100 = r118.getCurState();
    L78:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L88;
        pr(0, "onKtvStateIdle");
        return;
    L88:
        return;
    L87:
        return;
    L81:
        sb0.b r119 = this.f146348k0;     // Catch: Exception -> L26
        if (r119 == null) goto L7;
        String r120 = r119.f();     // Catch: Exception -> L26
    L9:
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.r) r110.f143344b).b() == null) goto L27;
        Iterator r121 = ((ArrayList) this.U).iterator();     // Catch: Exception -> L26
    L12:
        if (r121.hasNext() == false) goto L16;
        Object r122 = r121.next();     // Catch: Exception -> L26
        if (Intrinsics.areEqual(String.valueOf(((UserChorusInfo) r122).getUserId()), r120) == false) goto L12;
    L17:
        if (r122 != null) goto L27;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r123 = this.Q;     // Catch: Exception -> L26
        if (r123 == null) goto L27;
        ArrayList r124 = new ArrayList();     // Catch: Exception -> L26
        JSONObject r125 = new JSONObject();     // Catch: Exception -> L26
        r125.put("midiUsers", new JSONArray(String.valueOf(((com.bytedance.android.livesdk.ktvimpl.base.sei.r) r110.f143344b).b())));     // Catch: Exception -> L26
        Unit r126 = Unit.INSTANCE;     // Catch: Exception -> L26
        RealTimeChorusMidiWidget r127 = this.f146332J;     // Catch: Exception -> L26
        if (r127 == null) goto L23;
        Float r128 = Float.valueOf((float) r127.wq());     // Catch: Exception -> L26
    L24:
        r123.a(r124, r125, r128);     // Catch: Exception -> L26
        goto L27
    L23:
        r128 = null;
        goto L24
    L16:
        r122 = null;
        goto L17
    L7:
        r120 = null;
        goto L9
    }

    public final void or(MusicPanel r110) {
        KtvModeOrderedSongDataContext r100 = Eq();
        int r101 = 1;
        KtvMusic r102 = null;
        if (r100 == null) goto L17;
        List<MusicPanel> r103 = r100.m8257getKtvSingSongList();
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if (((MusicPanel) r105).c() != r110.c()) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L8;
    L16:
        MusicPanel r107 = (MusicPanel) r105;
    L18:
        String r108 = "";
        if (StringUtils.isEmpty(r110.e()) == false) goto L27;
        Object[] r109 = new Object[1];
        if (r107 == null) goto L26;
        String r111 = r107.e();
        if (r111 == null) goto L26;
        r108 = r111;
    L26:
        r109[0] = r108;
        String r112 = s1.C(R.string.ttlive_rt_chorus_sing_music_info, r109);
    L33:
        if (r110.f153577a.getMDuration() != 0) goto L38;
        KtvMusic.a r113 = KtvMusic.Companion;
        if (r107 == null) goto L37;
        r102 = r107.f153577a;
    L37:
        r113.getClass();
        long r114 = KtvMusic.a.a(r102);
    L39:
        Pair r115 = new Pair(r112, Long.valueOf(r114));
        String r116 = (String) r115.component1();
        long r117 = ((Number) r115.component2()).longValue();
        RTChorusMusicInfoView r118 = this.f146360s;
        if (r118 == null) goto L42;
        Intrinsics.checkNotNullParameter(r116, "musicTitle");
        w.a("RTChorusMusicInfoView", "showSongInfo " + r116);
        r118.T5(r116);
        r118.U5(r117 * ((long) 1000.0f));
    L42:
        RTChorusMusicInfoView r119 = this.f146360s;
        if (r119 == null) goto L60;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r120 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        KtvMusic r121 = r110.f153577a;
        r120.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r121) == true) goto L48;
        r101 = 3;
    L53:
        r119.S5(r101);
        return;
    L48:
        if (this.f146332J == null) goto L53;
        if (this.S1 == true) goto L53;
        r101 = 2;
        goto L53
    L60:
        return;
    L38:
        KtvMusic.a r122 = KtvMusic.Companion;
        KtvMusic r123 = r110.f153577a;
        r122.getClass();
        r114 = KtvMusic.a.a(r123);
        goto L39
    L27:
        Object[] r124 = new Object[1];
        String r125 = r110.e();
        if (r125 == null) goto L31;
        r108 = r125;
    L31:
        r124[0] = r108;
        r112 = s1.C(R.string.ttlive_rt_chorus_sing_music_info, r124);
        goto L33
    L12:
        r106 = false;
        goto L13
    L15:
        r105 = null;
    L17:
        r107 = null;
        goto L18
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
        this.K2 = r100;
    }

    public static void wq(KSongOrderSongDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "KSongOrderSongDialog", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.showNow(r101, "KSongOrderSongDialog");
    }

    public static final int xq(RealTimeChorusMainViewWidget r100, boolean r101) {
        r100.getClass();
        if (vm2.d.V() == false) goto L10;
        ALogger.i("RealTimeChorusMainViewWidget", "guestMicSeatPublicScreenHeight, hasFixedGuest: " + r101);
        if (r101 == true) goto L8;
        return 0;
    L8:
        return UtilityKotlinExtentionsKt.i(((Number) vm2.d.f555782a5.getValue(null, vm2.d.f555776a[310(0x136, float:4.34E-43)])).intValue());
    L10:
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF C7(int r100, int r101) {
        return new EPointF(-1.0f, -1.0f);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean K5(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fromUserId");
        Intrinsics.checkNotNullParameter(r101, "toUSerId");
        Intrinsics.checkNotNullParameter(r100, "fromUserId");
        Intrinsics.checkNotNullParameter(r101, "toUSerId");
        Intrinsics.checkNotNullParameter(r100, "fromUserId");
        Intrinsics.checkNotNullParameter(r101, "toUSerId");
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Kl(int r100, int r101) {
        return new EPointF(-1.0f, -1.0f);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean W7(EPointF r100, EPointF r101) {
        Intrinsics.checkNotNullParameter(r100, "startPoint");
        Intrinsics.checkNotNullParameter(r101, "endPoint");
        Intrinsics.checkNotNullParameter(r100, "startPoint");
        Intrinsics.checkNotNullParameter(r101, "endPoint");
        Intrinsics.checkNotNullParameter(r100, "startPoint");
        Intrinsics.checkNotNullParameter(r101, "endPoint");
        return true;
    }

    public final void Wq(com.bytedance.android.livesdk.chatroom.viewmodel.i r110, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "switchSceneEvent");
        ALogger.i("RealTimeChorusMainViewWidget", "onSceneChange");
        int r100 = r110.f114792a;
        int r101 = r110.f114793b;
        boolean r102 = false;
        if (r100 == this.f145733a) goto L5;
        boolean r103 = true;
    L6:
        List r104 = CollectionsKt.listOf(new Integer[]{61, 0});
        if (r101 != this.f145734b) goto L9;
    L13:
        boolean r105 = false;
    L14:
        ALogger.i("RealTimeChorusMainViewWidget", "onSceneChange:---" + r103 + "---" + this.f145733a + HttpClient.ENDFLAG + r100 + " ;; uiLayoutChange == " + r105 + " ;; " + this.f145734b + " -- " + r101 + ' ');
        this.f145733a = r100;
        this.f145734b = r101;
        this.X.updateKtvAllStateValue(KtvUtilsKt.I(r100, r101));
        if (jc0.a.b(this.f145733a, this.f145734b) == true) goto L17;
        clearAfterDestroyed();
        return;
    L17:
        if (r103 == true) goto L19;
        if (r105 == true) goto L19;
        return;
    L19:
        this.S1 = r210;
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a(this.X.getSeiProcessor().getValue(), this);
        if (this.G1 != null) goto L23;
        RealTimeChorusBusinessLifecycleOwner r106 = new RealTimeChorusBusinessLifecycleOwner();
        this.G1 = r106;
        r106.f146255a.setCurrentState(Lifecycle.State.STARTED);
    L36:
        if (this.A != null) goto L54;
        if (Bq() == null) goto L54;
        if (this.D.getFirst() != null) goto L46;
        this.D = com.bytedance.live.datacontext.d.a(new RealTimeChorusMainViewWidget$initPreviewSongDataContext$1(this));
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r107 = KtvRoomContext.a.a();
        if (r107 == null) goto L46;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r108 = r107.getPreviewViewModel();
        if (r108 == null) goto L46;
        r108.setValue(this.D.getFirst());
    L46:
        KtvPreviewSongsViewModel r109 = this.D.getFirst();
        this.B = r109;
        if (r109 == null) goto L49;
        KtvPreviewSongsWidget r111 = new KtvPreviewSongsWidget(r109, this.X, true, false);
    L50:
        this.A = r111;
        RecyclableWidgetManager r112 = Bq();
        if (r112 == null) goto L54;
        r112.load(R.id.preview_song_container, this.A, false);
        goto L54
    L49:
        r111 = null;
    L54:
        if (this.contentView == null) goto L109;
        this.f146362u = (Guideline) findViewById(R.id.top_guide_line);
        this.f146363v = (FrameLayout) findViewById(R.id.chorus_midi_root);
        this.f146366w = (Guideline) findViewById(R.id.bottom_guide_line);
        this.f146361t = (RealTimeChorusOperateView) findViewById(R.id.chorus_operator_view);
        this.f146370y = (HSImageView) findViewById(R.id.chorus_dress_theme);
        RealTimeChorusOperateView r113 = this.f146361t;
        if (r113 == null) goto L60;
        r113.setSingInfoProvider(this);
    L60:
        if (r210 == false) goto L65;
        RealTimeChorusOperateView r114 = this.f146361t;
        if (r114 == null) goto L70;
        r114.setVisibility(4);
    L70:
        RTChorusMusicInfoView r115 = (RTChorusMusicInfoView) findViewById(R.id.rt_chorus_music_info_view);
        this.f146360s = r115;
        if (r115 != null) goto L73;
    L75:
        this.f146359r = (RealTimeChorusSingerInfoView) findViewById(R.id.chorus_info_view);
        Lq();
        hr(r210);
        RTChorusMusicInfoView r116 = this.f146360s;
        if (r116 == null) goto L81;
        TextView r117 = r116.f146233j;
        if (r117 == null) goto L80;
        r117.setText(s1.B(R.string.ttlive_rt_chorus_join_chorus_tips));
    L80:
        r116.S5(0);
    L81:
        this.N = (RealTimeChorusFeedBackView) findViewById(R.id.chorus_feed_back);
        this.F = (FrameLayout) findViewById(R.id.lyric_container);
        this.H = (FrameLayout) findViewById(R.id.chorus_interact_emoji_container);
        this.P = (ConstraintLayout) findViewById(R.id.song_area_container);
        this.S = (FrameLayout) findViewById(R.id.mic_layout_container);
        this.T = (FrameLayout) findViewById(R.id.chorus_guest_mic_seat_container);
        this.I = (FrameLayout) findViewById(R.id.chorus_midi_container);
        this.C = (FrameLayout) findViewById(R.id.preview_song_container);
        this.f146367x = (RTChorusLogView) findViewById(R.id.chorus_singer_info_view);
        if (((Boolean) vm2.h.W.getValue(null, vm2.h.f556082a[47])).booleanValue() == false) goto L108;
        RTChorusLogView r118 = this.f146367x;
        if (r118 == null) goto L86;
        r118.setVisibility(0);
    L86:
        RTChorusLogView r119 = this.f146367x;
        if (r119 == null) goto L108;
        y r120 = this.f146337e;
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r120, "outerScopeProvider");
        RealTimeChorusBusinessContext.a r121 = RealTimeChorusBusinessContext.Companion;
        r121.o(this, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.f(r119));
        r121.m(this, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.g(r119));
        com.bytedance.android.livesdk.chatroom.o r122 = o3.f();
        com.bytedance.live.datacontext.j<LinkMicRoomDataSyncModel> r123 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        if (r123 == null) goto L91;
        LinkMicRoomDataSyncModel r124 = r123.getValue();
    L92:
        if (r124 != null) goto L102;
        com.bytedance.live.datacontext.j<ylc.e> r125 = r122.w1();
        if (r125 == null) goto L98;
        ylc.e r126 = r125.getValue();
        if (r126 == null) goto L98;
        r124 = (LinkMicRoomDataSyncModel) dc2.b.a(r126, RTChorusLogView$attach$3$1.INSTANCE);
    L99:
        com.bytedance.live.datacontext.j<LinkMicRoomDataSyncModel> r127 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        if (r127 == null) goto L102;
        r127.d(r124);
    L98:
        r124 = null;
    L102:
        if (r124 == null) goto L108;
        dc2.c<IRoomLinkMicSyncData> r128 = r124.getTalkRoomListUserInfoPb();
        if (r128 == null) goto L108;
        Observable<dc2.c.b<IRoomLinkMicSyncData>> r129 = r128.f467853e;
        if (r129 == null) goto L108;
        r129.subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.e(r119, r122, r120));
        goto L108
    L91:
        r124 = null;
    L108:
        this.Q = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c(this.S, this.T, this.context, this.X, this.dataCenter, new RealTimeChorusMainViewWidget$initView$1(this));
        Sq();
        yq();
        goto L109
    L73:
        if (r115.getVisibility() == 4) goto L75;
        UtilityKotlinExtentionsKt.u(r115);
        goto L75
    L65:
        if (((Boolean) KtvSettingHelper.f70610c.getValue()).booleanValue() == false) goto L70;
        RealTimeChorusOperateView r130 = this.f146361t;
        if (r130 == null) goto L70;
        r130.setVisibility(0);
    L109:
        Mq(r210);
        bb0.a r131 = bb0.b.f18525a;
        com.bytedance.android.livesdk.ktvimpl.base.n r132 = com.bytedance.android.livesdk.ktvimpl.base.n.f143275a;
        Intrinsics.checkNotNullParameter(r132, "ktvCommonInject");
        bb0.b.f18525a = r132;
        pb0.a r133 = pb0.b.f528406a;
        KtvLoggerHelper r134 = KtvLoggerHelper.f142997d;
        Intrinsics.checkNotNullParameter(r134, "ktvLogger");
        pb0.b.f528406a = r134;
        mb0.c r135 = mb0.d.f512759a;
        pd2.d r136 = pd2.d.f528658n;
        r136.getClass();
        Intrinsics.checkNotNullParameter(r136, "monitor");
        mb0.d.f512759a = r136;
        if (((Boolean) KtvSettingHelper.f70619f.getValue()).booleanValue() == false) goto L118;
        FrameLayout r137 = this.F;
        if (r137 == null) goto L114;
        r137.removeAllViews();
    L114:
        MvLyricWidget r138 = this.E;
        if (r138 == null) goto L117;
        r138.i();
    L117:
        this.E = null;
    L118:
        LifecycleOwner r139 = getLifecycleOwner();
        FrameLayout r140 = this.F;
        if (r139 == null) goto L166;
        if (r140 == null) goto L166;
        if (KtvSettingHelper.w() == true) goto L124;
    L126:
        final RealTimeChorusBusinessLifecycleOwner r141 = (RealTimeChorusBusinessLifecycleOwner) r139;
        MvLyricWidget r142 = new MvLyricWidget(r139, r140, new RealTimeChorusMainViewWidget$initLyricView$$inlined$lets$lambda$1(r141, this), null);
        this.E = r142;
        r142.f143213r = new RealTimeChorusMainViewWidget$initLyricView$$inlined$lets$lambda$2(this);
        MvLyricWidget r143 = this.E;
        if (r143 == null) goto L129;
        r143.f143204i.setLyricOneLineMaxWidth(s1.y() - s1.f(25.0f));
    L129:
        MvLyricWidget r144 = this.E;
        if (r144 == null) goto L152;
        k r145 = this.f146351m;
        KtvContext r146 = this.X;
        r145.getClass();
        Intrinsics.checkNotNullParameter(r146, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        MidiSkinDressInfo r147 = r146.getMidiSkinContext().getValue();
        if (r147 != null) goto L134;
    L146:
        String r148 = null;
    L147:
        if (r148 != null) goto L149;
        r148 = "#2AF2C9";
    L149:
        KtvMvLyricPresenter r149 = r144.f143206k;
        if (r149 == null) goto L152;
        r149.h(r148);
        goto L152
    L134:
        if (KtvDressDataKt.isAvailableMidiSkin(r147) != true) goto L146;
        MidiSkinMaterial r150 = r147.getMaterial();
        if (r150 == null) goto L146;
        String r151 = r150.getLyricColorValue();
        if (r151 == null) goto L146;
        if (r151.length() <= 0) goto L142;
        r102 = true;
    L142:
        if (r102 != true) goto L146;
        MidiSkinMaterial r152 = r147.getMaterial();
        if (r152 == null) goto L146;
        r148 = r152.getLyricColorValue();
    L152:
        MvLyricWidget r153 = this.E;
        if (r153 == null) goto L163;
        float r154 = s1.f(17.0f);
        KtvMvLyricPresenter r155 = r153.f143206k;
        if (r155 == null) goto L163;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r156 = r155.f143093a;
        if ((r156 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyrics.a) == true) goto L159;
        r156 = null;
    L159:
        if (r156 == null) goto L163;
        LyricsDisplayConfig r157 = r156.getDisplayConfig();
        if (r157 == null) goto L163;
        r157.i(r154, r154);
    L163:
        MvLyricWidget r158 = this.E;
        if (r158 == null) goto L166;
        r158.g(null);
        goto L166
    L124:
        if (this.E == null) goto L126;
    L166:
        if (r210 == true) goto L168;
        yq();
    L168:
        LifecycleOwner r159 = getLifecycleOwner();
        if (r159 == null) goto L178;
        RTChorusMusicInfoView r160 = this.f146360s;
        if (r160 == null) goto L179;
        KtvContext r161 = this.X;
        Intrinsics.checkNotNullParameter(r159, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r161, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        r160.f146238o = r161.getKtvCoreViewModel().getValue();
        RxUtilKt.c(((ObservableSubscribeProxy) r161.getCountDownEvent().onEvent().as(AutoDispose.bind(r159))).subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.h(r160)), r160.f146237n);
        Disposable r162 = r161.getMidiSkinContext().a().subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.i(r160));
        if (r162 == null) goto L180;
        RxUtilKt.c(r162, r160.f146237n);
        return;
    L180:
        return;
    L179:
        return;
    L178:
        return;
    L23:
        if (((Boolean) KtvSettingHelper.f70628i.getValue()).booleanValue() == false) goto L36;
        RealTimeChorusBusinessLifecycleOwner r163 = this.G1;
        if (r163 == null) goto L29;
        Lifecycle r164 = LifecycleOwnerCompat.CC.$default$getLifecycle(r163);
        if (r164 == null) goto L29;
        Lifecycle.State r165 = r164.getCurrentState();
    L31:
        if (r165 != Lifecycle.State.DESTROYED) goto L36;
        RealTimeChorusBusinessLifecycleOwner r166 = this.G1;
        if (r166 == null) goto L36;
        r166.f146255a.setCurrentState(Lifecycle.State.STARTED);
    L29:
        r165 = null;
        goto L31
    L9:
        if (r104.contains(Integer.valueOf(r101)) == false) goto L13;
        if (r104.contains(Integer.valueOf(this.f145734b)) == false) goto L13;
        r105 = true;
        goto L14
    L5:
        r103 = false;
        goto L6
    }

    public final void kr(MessageHub r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        ALogger.i("RealTimeChorusMainViewWidget", "updateMessageHub ;; source == ".concat(r101));
        this.R = r100;
    }

    public final void mr(KtvRoomLyricsStateMachineConfig.d r100, int r101) {
        w.a("RealTimeChorusMainViewWidget", "updateOperateStatus chorusRole : " + r101 + " curState: " + r100);
        if (this.O == false) goto L12;
        w.a("RealTimeChorusMainViewWidget", "updateOperateStatus feedbackShowing so disable");
        RealTimeChorusOperateView r102 = this.f146361t;
        if (r102 == null) goto L7;
        r102.Y5(2);
    L7:
        RealTimeChorusOperateView r103 = this.f146361t;
        if (r103 == null) goto L44;
        r103.i6(false);
        return;
    L44:
        return;
    L12:
        if ((r100 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L14;
    L37:
        RealTimeChorusOperateView r104 = this.f146361t;
        if (r104 == null) goto L40;
        r104.Y5(2);
    L40:
        RealTimeChorusOperateView r105 = this.f146361t;
        if (r105 == null) goto L51;
        r105.i6(false);
        return;
    L51:
        return;
    L14:
        if (Intrinsics.areEqual(r100, KtvRoomLyricsStateMachineConfig.d.a.f145407b) == true) goto L37;
        if (r101 != 1) goto L24;
        RealTimeChorusOperateView r106 = this.f146361t;
        if (r106 == null) goto L21;
        r106.Y5(5);
    L21:
        RealTimeChorusOperateView r107 = this.f146361t;
        if (r107 == null) goto L45;
        r107.i6(true);
        return;
    L45:
        return;
    L24:
        if (r101 != 2) goto L31;
        RealTimeChorusOperateView r108 = this.f146361t;
        if (r108 == null) goto L28;
        r108.Y5(4);
    L28:
        RealTimeChorusOperateView r109 = this.f146361t;
        if (r109 == null) goto L47;
        r109.i6(true);
        return;
    L47:
        return;
    L31:
        RealTimeChorusOperateView r110 = this.f146361t;
        if (r110 == null) goto L34;
        r110.Y5(1);
    L34:
        RealTimeChorusOperateView r111 = this.f146361t;
        if (r111 == null) goto L49;
        r111.i6(false);
        return;
    }

    public final void nr(aj r100, boolean r101) {
        if (((Boolean) KtvSettingHelper.f70640m.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
    L11:
        this.f146350l = true;
        Integer r102 = r100.c();
        xe2.h.f563361e = r102;
        this.f146347k = r102;
        this.f146339g = r100;
        k r103 = this.f146351m;
        Long r104 = r100.b();
        if (r104 == null) goto L15;
        String r105 = String.valueOf(r104.longValue());
        if (r105 == null) goto L15;
    L16:
        sb0.b r106 = this.f146348k0;
        if (r106 == null) goto L21;
        sb0.e r107 = r106.b();
        if (r107 == null) goto L21;
        Long r108 = Long.valueOf(r107.getRoomId());
    L22:
        long r109 = r108.longValue();
        Function1<com.bytedance.android.live.profit.dress.t, Unit> r110 = new RealTimeChorusMainViewWidget$updateRTChorusDressInfo$1(this);
        Function1<Throwable, Unit> r111 = new RealTimeChorusMainViewWidget$updateRTChorusDressInfo$2(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter("rt_chorus", "function");
        Intrinsics.checkNotNullParameter(r110, "successFb");
        Intrinsics.checkNotNullParameter(r111, "failFb");
        Disposable r112 = r103.f146682a;
        if (r112 != null) goto L25;
    L27:
        r103.f146682a = null;
        r103.f146682a = Observable.create(new l(r103, r105, r109)).retryWhen(RxUtil.rxRetryHelper(3, 500)).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r110), new n(r111), o.f146837a);
        return;
    L25:
        if (r112.isDisposed() == false) goto L27;
        r112.dispose();
    L21:
        r108 = null;
    L15:
        r105 = "";
        goto L16
    L8:
        if ((!Intrinsics.areEqual(this.f146347k, r100.c())) == true) goto L11;
        if (this.f146350l == false) goto L11;
    }

    public final void pr(int r100, String r101) {
        if (r100 != this.W) goto L6;
        return;
    L6:
        if (this.O == false) goto L8;
        return;
    L8:
        w.a("RealTimeChorusMainViewWidget", "updateStageMode " + r100 + ' ' + r101);
        this.W = r100;
        RTChorusMusicInfoView r102 = this.f146360s;
        float r103 = 1.0f;
        if (r102 == null) goto L14;
        if (r100 != 2) goto L12;
        float r104 = 0.0f;
    L13:
        r102.setAlpha(r104);
        goto L14
    L12:
        r104 = 1.0f;
    L14:
        RealTimeChorusSingerInfoView r105 = this.f146359r;
        if (r105 == null) goto L20;
        if (r100 != 2) goto L18;
        r103 = 0.0f;
    L18:
        r105.setAlpha(r103);
    L20:
        if (r100 == 0) goto L69;
        if (r100 == 1) goto L46;
        if (r100 == 2) goto L25;
        return;
    L25:
        if (KtvSettingHelper.b().booleanValue() == false) goto L29;
        FrameLayout r106 = this.I;
        if (r106 == null) goto L29;
        r106.setVisibility(8);
    L29:
        KtvPreviewSongsViewModel r107 = this.B;
        if (r107 == null) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r108 = r107.getNeedDelayToShow();
        if (r108 == null) goto L34;
        r108.setValue(Boolean.TRUE);
    L34:
        ConstraintLayout r109 = this.P;
        if (r109 == null) goto L37;
        r109.setVisibility(8);
    L37:
        RealTimeChorusFeedBackView r110 = this.N;
        if (r110 == null) goto L40;
        r110.setVisibility(0);
    L40:
        this.O = true;
        RealTimeChorusOperateView r111 = this.f146361t;
        if (r111 == null) goto L43;
        r111.Y5(2);
    L43:
        RealTimeChorusOperateView r112 = this.f146361t;
        if (r112 == null) goto L115;
        r112.i6(false);
        return;
    L115:
        return;
    L46:
        ConstraintLayout r113 = this.P;
        if (r113 == null) goto L49;
        r113.setVisibility(0);
    L49:
        RealTimeChorusFeedBackView r114 = this.N;
        if (r114 == null) goto L52;
        r114.setVisibility(8);
    L52:
        FrameLayout r115 = this.C;
        if (r115 == null) goto L55;
        r115.setVisibility(8);
    L55:
        lr();
        KtvPreviewSongsViewModel r116 = this.B;
        if (r116 == null) goto L59;
        r116.setShowPreviewCard(false, "start sing");
    L59:
        if (this.W == 0) goto L117;
        RealTimeChorusSingerInfoView r117 = this.f146359r;
        if (r117 != null) goto L63;
    L65:
        RealTimeChorusSingerInfoView r118 = this.f146359r;
        if (r118 == null) goto L118;
        r118.setSelfVisibility(0);
        return;
    L118:
        return;
    L63:
        if (r117.getVisibility() != 0) goto L65;
        return;
    L117:
        return;
    L69:
        if (KtvSettingHelper.b().booleanValue() == false) goto L73;
        FrameLayout r119 = this.I;
        if (r119 == null) goto L73;
        r119.setVisibility(8);
    L73:
        ConstraintLayout r120 = this.P;
        if (r120 == null) goto L76;
        r120.setVisibility(8);
    L76:
        FrameLayout r121 = this.C;
        if (r121 == null) goto L79;
        r121.setVisibility(0);
    L79:
        RealTimeChorusFeedBackView r122 = this.N;
        if (r122 == null) goto L82;
        r122.setVisibility(8);
    L82:
        KtvPreviewSongsViewModel r123 = this.B;
        if (r123 == null) goto L93;
        com.bytedance.live.datacontext.m<Boolean> r124 = r123.getNeedDelayToShow();
        if (r124 == null) goto L93;
        if (r124.getValue().booleanValue() != true) goto L93;
        KtvPreviewSongsViewModel r125 = this.B;
        if (r125 == null) goto L93;
        com.bytedance.live.datacontext.m<Boolean> r126 = r125.getNeedDelayToShow();
        if (r126 == null) goto L93;
        r126.setValue(Boolean.FALSE);
    L93:
        KtvPreviewSongsViewModel r127 = this.B;
        if (r127 == null) goto L96;
        r127.setShowPreviewCard(true, "show preview");
    L96:
        RTChorusMusicInfoView r128 = this.f146360s;
        if (r128 == null) goto L102;
        TextView r129 = r128.f146233j;
        if (r129 == null) goto L101;
        r129.setText(s1.B(R.string.ttlive_rt_chorus_join_chorus_tips));
    L101:
        r128.S5(0);
    L102:
        RTChorusMusicInfoView r130 = this.f146360s;
        if (r130 != null) goto L105;
    L107:
        ar("show preview");
        RealTimeChorusSingerInfoView r131 = this.f146359r;
        if (r131 == null) goto L110;
        r131.R5("0", "#00FFE0");
    L110:
        RealTimeChorusSingerInfoView r132 = this.f146359r;
        if (r132 == null) goto L113;
        r132.S5("0");
    L113:
        Lq();
        return;
    L105:
        if (r130.getVisibility() == 0) goto L107;
        UtilityKotlinExtentionsKt.w(r130);
        goto L107
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Mb(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "url");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Mk(EPointF r100, EPointF r101, EPointF r102) {
        Intrinsics.checkNotNullParameter(r100, "currentPoint");
        Intrinsics.checkNotNullParameter(r101, "startPoint");
        Intrinsics.checkNotNullParameter(r102, "endPoint");
        InteractAnimationController.d.a.a(r100, r101, r102);
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean ha(EPointF r100, EPointF r101, EPointF r102) {
        Intrinsics.checkNotNullParameter(r100, "currentPoint");
        Intrinsics.checkNotNullParameter(r101, "startPoint");
        Intrinsics.checkNotNullParameter(r102, "endPoint");
        InteractAnimationController.d.a.b(r100, r101, r102);
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Se(int r100, int r101, EPointF r102, EPointF r103) {
        Intrinsics.checkNotNullParameter(r102, "startPoint");
        Intrinsics.checkNotNullParameter(r103, "endPoint");
        return new EPointF(-1.0f, -1.0f);
    }

    public final void br(String r110, boolean r111, String r112, Integer r113) {
        if (KtvSettingHelper.n().booleanValue() == true) goto L6;
        f2.b(R.string.ttlive_ktv_not_support_audience_order_song, 0);
        return;
    L6:
        KtvContext r100 = this.X;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.n<oe2.b> r101 = r100.getKtvRoomProvider();
        if (r101 == null) goto L11;
        oe2.b r102 = r101.getValue();
    L13:
        if ((r102 instanceof d1) == true) goto L15;
        r102 = null;
    L15:
        d1 r103 = (d1) r102;
        if (r103 == null) goto L18;
        r103.f146554a = r110;
    L18:
        String r104 = bb0.b.b();
        ALogger.i(r104, ("showKtvRoomOrAdjustDialog, isAdjust:" + r111) + ", invoke class :RealTimeChorusMainViewWidget");
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isLogin() == true) goto L22;
        ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().login(this.context, new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L22:
        if (r111 == false) goto L30;
        if (this.X.getKtvCoreController().getValue() != null) goto L28;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r114 = this.X.getKtvSingerViewModel().getValue();
        if (r114 == null) goto L28;
        r114.lazyInitKtvCoreController();
    L28:
        KSongTuningPanelHelperKt.a(this.context, "chorus");
        pb0.a.C7174a.b(KtvLoggerHelper.f142997d, "tone_tuning", null, "tone_tuning", null, null, 26);
        return;
    L30:
        if (this.isDestroyed == true) goto L55;
        KtvCoreViewModel r115 = this.M;
        KtvSingerViewModel r105 = this.f146356p1;
        Context r106 = this.context;
        if (r115 == null) goto L56;
        if (r105 == null) goto L57;
        if (r106 == null) goto L58;
        Nq();
        com.bytedance.android.livesdk.ktvimpl.base.util.q.e();
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r116 = KtvModeOrderSongDataContext.Companion.a();
        if (r116 == null) goto L38;
        r116.updateOrderSongExtraInfo(new td2.b(r110, new WeakReference(r106)));
    L38:
        FragmentManager r117 = ((FragmentActivity) r106).getSupportFragmentManager();
        Fragment r118 = r117.findFragmentByTag("KSongOrderSongDialog");
        if ((r118 instanceof KSongOrderSongDialog) == true) goto L41;
        r118 = null;
    L41:
        KSongOrderSongDialog r119 = (KSongOrderSongDialog) r118;
        if (r119 != null) goto L44;
    L52:
        KSongOrderSongUtilKt.b(r106, CloseOrderSongDialogSource.AUTO);
        int r120 = KSongOrderSongDialog.f142573p;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r121 = KtvModeOrderSongDataContext.Companion.a();
        int r107 = RTChorusFirstLevelTabManager.f146559r;
        RTChorusFirstLevelTabManager r108 = new RTChorusFirstLevelTabManager(r113, r112, this.context, KtvModeOrderSongDataContext.Companion.b(), KtvModeOrderSongDataContext.Companion.c(), KtvModeOrderSongDataContext.Companion.a(), KtvModeOrderSongDataContext.Companion.e());
        r108.s();
        KSongOrderSongDialog r122 = KSongOrderSongDialog.a.a(r121, r108, null, 12);
        wq(r122, r117);
        Unit r123 = Unit.INSTANCE;
        this.f146349k1 = r122;
        return;
    L44:
        if (this.f146349k1 == null) goto L52;
        if (r119.isAdded() == true) goto L48;
        wq(r119, r117);
        return;
    L48:
        r119.f142580m.c(r113, r112);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e.a.a(r119.f142580m);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r124 = KtvModeOrderSongDataContext.Companion.a();
        if (r124 == null) goto L51;
        r124.updateCurrentTabData();
    L51:
        KSongOrderSongDialog.aa0(r119, false, null, 3);
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L11:
        r102 = null;
        goto L13
    }

    public RealTimeChorusMainViewWidget(int r100, com.bytedance.android.live.liveinteract.plantform.datamerge.d r101, hh1.w0 r102, KtvContext r103, com.bytedance.android.livesdk.chatroom.widget.j1 r104) {
        this.M2 = r100;
        this.N2 = r101;
        this.O2 = r102;
        this.P2 = r104;
        this.f146335c = -1;
        this.f146336d = -1;
        this.f146337e = new y(this);
        this.f146351m = new k();
        this.f146353o = "";
        this.D = new Pair(null, null);
        this.U = new ArrayList();
        this.V = new d1(this.P2);
        this.W = -1;
        if (r103 != null) goto L5;
        r103 = new KtvContext();
    L5:
        this.X = r103;
        sb0.b.f541206a.getClass();
        Pair r105 = sb0.b.a.a();
        sb0.b r106 = (sb0.b) r105.getFirst();
        r103.getDataEntity().d(r106);
        Unit r107 = Unit.INSTANCE;
        this.f146348k0 = r106;
        this.f146355p0 = (sb0.a) r105.getSecond();
        this.H0 = new CompositeDisposable();
        this.L0 = new CompositeDisposable();
        this.P0 = new Pair(null, null);
        this.V0 = new Pair(null, null);
        this.f146333b1 = new Pair(null, null);
        this.f146371y1 = r103.getBizLcMager();
        this.H1 = 3000;
        this.T1 = SetsKt.setOf(new Long[]{3L, 2L});
        this.V1 = new ArrayList();
        this.f146334b2 = new LinkedHashMap();
        this.H2 = new j0(this);
        this.I2 = new k0(this);
        this.J2 = new ViewModelStore();
        this.L2 = KtvSubElement.MAIN_WIDGET;
    }
}
