package com.bytedance.android.livesdk.interactivity.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.SendPrivilegeBarrageException;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.live.status.api.IAggregateService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.p7;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputDraftType;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputPanelComponentSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.comment.datacontext.CommentContext;
import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.comment.event.QuickCommentTypeEnum;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentEntry;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentScene;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.expression.MentionSpan;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputConstantNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PanelPopupFailed;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.mylive.MyLiveEntranceManager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LiveLandscapeInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.OGCFixedInputDialog;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.utils.CommentUtils;
import com.bytedance.android.livesdk.interactivity.comment.view.CommentWidgetAnimator;
import com.bytedance.android.livesdk.interactivity.model.INPUT_PARAM_KEY;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.n4;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.u4;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.k6;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.v4;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.InputDefaultConfig;
import com.bytedance.android.livesdkapi.depend.model.live.LowPcuGuideData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.UserWorldChatInfo;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.service.ICurrentInteractionUiAction;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.jato.views.JatoOptDrawableCache;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r52.i4;
import zg1.e3;
import zg1.x2;

/* JADX INFO: loaded from: classes9.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeDanmakuSend, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
public class CommentWidget extends MiddlewareRoomRecyclableWidget implements CommentPresenter.IView, View.OnClickListener, Observer<KVData>, t22.b, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, y22.d, s22.c.a {
    public static final int V1 = 0;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final int f134726b2 = 0;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final int f134727g2 = 0;
    public int A;
    public x22.b B;
    public final x22.c C;
    public String D;
    public String E;
    public String F;
    public String G;
    public final e G1;
    public Boolean H;
    public WeakReference<ViewTreeObserver> H0;
    public final j H1;
    public u22.m.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CompositeDisposable f134728J;
    public boolean K;
    public CommentWidgetAnimator L;
    public final boolean L0;
    public final k L1;
    public m0 M;
    public b M1;
    public f0 N;
    public final HashMap<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> O;
    public String P;
    public s62.a P0;
    public final m P1;
    public String Q;
    public final o Q1;
    public x22.a R;
    public x22.a S;
    public final q S1;
    public String T;
    public u22.m T1;
    public boolean U;
    public Long V;
    public final boolean V0;
    public String W;
    public s22.c X;
    public g0 Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f134729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f134730b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final boolean f134731b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f134732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f134733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RedDotView f134734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f134735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f134736g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final boolean f134737g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f134738h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final Set<y22.e> f134739h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f134740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f134741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f134742k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f134743k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final Set<t22.a> f134744k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f134745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f134746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f134747n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LottieAnimationView f134748o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f134749p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public MyLiveEntranceManager f134750p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final x22.d f134751p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f134752q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IRoom f134753r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Activity f134754s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f134755t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f134756u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f134757v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.t f134758v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f134759w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f134760x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f134761x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CommentPresenter f134762y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f134763y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f134764z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134765a;

        @Override // java.lang.Runnable
        public final void run() {
            CommentWidget.xq(this.f134765a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(CommentWidget r100) {
            this.f134765a = r100;
        }
    }

    public class b extends com.bytedance.android.live.core.tetris.task.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134766c;

        @Override // java.lang.Runnable
        public final void run() {
            CommentWidget.yq(this.f134766c);
            b(true);
        }

        public b(CommentWidget r100) {
            this.f134766c = r100;
            super("comment_widget_load");
        }
    }

    public class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134767a;

        public c(CommentWidget r100) {
            this.f134767a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            DataCenter r102 = this.f134767a.dataCenter;
            if (r102 != null) goto L5;
        L7:
            r101.setContentDescription(this.f134767a.P);
            r101.setClassName(EditText.class.getName());
            return;
        L5:
            if (((Boolean) r102.get("data_is_scroll", Boolean.FALSE)).booleanValue() == false) goto L7;
            r101.setContentDescription(null);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 64) goto L11;
            DataCenter r103 = this.f134767a.dataCenter;
            if (r103 == null) goto L11;
            if (((Boolean) r103.get("data_is_scroll", Boolean.FALSE)).booleanValue() == false) goto L11;
            return true;
        L11:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public class d implements com.bytedance.android.livesdk.chatroom.utils.a1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134768a;

        public d(CommentWidget r100) {
            this.f134768a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a1.b
        public final void a(Bitmap r100) {
            Matrix r101 = new Matrix();
            if (s1.getResources() == null) goto L5;
            Resources r102 = s1.getResources();
            float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density / 3.0f;
        L6:
            r101.postScale(r103, r103);
            Bitmap r104 = Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r101, true);
            if (r100.getNinePatchChunk() != null) goto L9;
            return;
        L9:
            if (this.f134768a.L == null) goto L13;
            byte[] r105 = com.bytedance.android.livesdk.chatroom.utils.a1.f(r100.getNinePatchChunk(), r103, false, false);
            Rect r106 = com.bytedance.android.livesdk.chatroom.utils.a1.i(r105);
            CommentWidgetAnimator r107 = this.f134768a.L;
            r107.f136279d = 1;
            com.bytedance.android.livesdk.interactivity.comment.view.b r108 = new com.bytedance.android.livesdk.interactivity.comment.view.b(r104, r105, r106);
            r107.getClass();
            Intrinsics.checkNotNullParameter(r108, "<set-?>");
            r107.f136278c = r108;
            ALogger.d("CommentWidget", "room set CommentWidgetAnimator ninePatch drawable Success");
            return;
        L13:
            return;
        L5:
            r103 = 1.0f;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a1.b
        public final void onFail(Exception r100) {
            ALogger.e("CommentWidget", "room set CommentWidgetAnimator ninePatch drawable failed", r100);
        }
    }

    public class e implements x22.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134769a;

        public e(CommentWidget r100) {
            this.f134769a = r100;
        }

        public final void a(String r110, boolean r111, int r112, boolean r113, Map<String, Object> r114, com.bytedance.android.livesdk.event.m r210, com.bytedance.android.livesdk.event.q r211) {
            g92.b r115 = new g92.b();
            long r100 = -1;
            boolean r101 = false;
            if (r114 == null) goto L45;
            Object r102 = r114.get("danmu_money");
            if ((r102 instanceof Long) == false) goto L7;
            r100 = ((Long) r102).longValue();
        L7:
            Object r103 = r114.get("is_from_comment_operate_copy");
            if ((r103 instanceof Boolean) == false) goto L10;
            r101 = ((Boolean) r103).booleanValue();
        L10:
            Object r104 = r114.get("start_send_time");
            if ((r104 instanceof Long) == false) goto L13;
            r115.f480491e = ((Long) r104).longValue();
        L13:
            Object r105 = r114.get("user_send_duration");
            if ((r105 instanceof Long) == false) goto L16;
            r115.f480487a = ((Long) r105).longValue();
        L16:
            Object r106 = r114.get("associate_show_send_duration");
            if ((r106 instanceof Long) == false) goto L19;
            r115.f480489c = ((Long) r106).longValue();
        L19:
            Object r107 = r114.get("is_from_click_event");
            if ((r107 instanceof Boolean) == false) goto L22;
            r115.f480490d = ((Boolean) r107).booleanValue();
        L22:
            Object r108 = r114.get("interest_kp_id");
            if ((r108 instanceof String) == false) goto L25;
            r115.f480495i = (String) r108;
        L25:
            Object r109 = r114.get("interest_kp_text");
            if ((r109 instanceof String) == false) goto L28;
            r115.f480494h = (String) r109;
        L28:
            Object r116 = r114.get("truth_question_id");
            Object r117 = r114.get("truth_question_text");
            if ((r116 instanceof Long) == false) goto L36;
            if ((r117 instanceof String) == false) goto L36;
            String r118 = (String) r117;
            if (r118.isEmpty() == true) goto L36;
            r115.f480493g = ((Long) r116).longValue();
            Intrinsics.checkNotNullParameter(r118, "<set-?>");
            r115.f480492f = r118;
        L36:
            if ("lottery".equals(this.f134769a.F) == false) goto L42;
            if (r110 == null) goto L42;
            if (r110.equals(this.f134769a.G) == false) goto L42;
            r115.f480488b = this.f134769a.F;
        L42:
            if ("lottery".equals(this.f134769a.F) == true) goto L44;
            r115.f480488b = this.f134769a.F;
        L44:
            CommentWidget r119 = this.f134769a;
            r119.F = null;
            r119.G = null;
            boolean r120 = r101;
            long r121 = r100;
        L46:
            CommentWidget r122 = this.f134769a;
            QuickCommentTypeEnum r123 = QuickCommentTypeEnum.DEFAULT;
            int r124 = CommentWidget.V1;
            r122.fr(r110, r111, r112, r113, r123, r121, r210, r211, r120, r115, r114);
            return;
        L45:
            r121 = -1;
            r120 = false;
            goto L46
        }
    }

    public class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f134770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134771b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r100 = this.f134771b.contentView.getWidth();
            CommentWidget r101 = this.f134771b;
            if (r101.f134760x == false) goto L8;
            int r102 = CommentWidget.f134726b2;
            if (r100 <= r102) goto L21;
            this.f134770a.width = r102;
        L21:
            this.f134771b.contentView.setLayoutParams(this.f134770a);
            this.f134771b.contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L8:
            if (r101.A <= 0) goto L15;
            ViewGroup r103 = r101.containerView;
            if (r103 == null) goto L15;
            if (r103.getVisibility() == 0) goto L15;
            ViewGroup.LayoutParams r104 = this.f134770a;
            r104.width = this.f134771b.A;
        L17:
            ViewGroup.LayoutParams r105 = this.f134770a;
            if (r105.width > 0) goto L20;
            r105.width = this.f134771b.Kq();
        L20:
            CommentWidget r106 = this.f134771b;
            r106.A = this.f134770a.width;
        L15:
            if (r100 <= this.f134771b.Kq()) goto L17;
            ViewGroup.LayoutParams r107 = this.f134770a;
            r107.width = this.f134771b.Kq();
            goto L17
        }

        public f(CommentWidget r100, ViewGroup.LayoutParams r101) {
            this.f134771b = r100;
            this.f134770a = r101;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u22.m f134772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f134773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommentEntry f134774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134775d;

        public final void a() {
            if (this.f134775d.isViewValid() == true) goto L5;
            return;
        L5:
            String r100 = this.f134772a.f548431b;
            boolean r101 = false;
            if (r100 != null) goto L8;
        L25:
            String r102 = r1.b("@%s ", new Object[]{r100});
            CommentWidget r103 = this.f134775d;
            x22.b r104 = r103.B;
            if (r104 == null) goto L36;
            LiveInputDialogV3 r105 = (LiveInputDialogV3) r104;
            if (r102 == null) goto L34;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r106 = r105.f135448g;
            if (r106 == null) goto L34;
            EditText r107 = r106.f135496a;
            if (r107 == null) goto L34;
            r107.setText(r102);
        L34:
            CommentWidget.zq(this.f134775d, this.f134772a.f548434e);
            return;
        L36:
            if (this.f134773b == false) goto L38;
            boolean r108 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.f132985d;
        L39:
            long r109 = 0;
            if (r108 == false) goto L57;
            IRoomAuthStatus r110 = r103.f134753r.getRoomAuthStatus();
            if (r110 == null) goto L50;
            com.bytedance.android.livesdk.interactivity.service.model.c r111 = (com.bytedance.android.livesdk.interactivity.service.model.c) r110.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
            if (r111 == null) goto L50;
            long r112 = r111.getEnableChatMention();
            if (r112 != 1) goto L48;
        L49:
            boolean r113 = true;
        L51:
            if (r113 == false) goto L57;
            IBaseUser r114 = this.f134772a.f548434e.f548453j;
            if (r114 == null) goto L57;
            if (r114.isMysteryMan() == true) goto L57;
            r101 = true;
            goto L57
        L48:
            if (r112 == 0) goto L49;
        L50:
            r113 = false;
        L57:
            if (r101 == false) goto L59;
            this.f134775d.f134751p1.a(this.f134772a.f548443n).f133036a = "";
        L60:
            u22.m r115 = this.f134772a;
            u22.m.a r116 = r115.f548434e;
            String r117 = null;
            if (r116 == null) goto L67;
            r116.f548448e = r100;
            CommentWidget r118 = this.f134775d;
            r118.D = r116.f548444a;
            if (this.f134773b == false) goto L65;
            r109 = r115.f548443n;
        L65:
            r118.f134751p1.a(r109).f133037b = r116;
            CommentWidget r119 = this.f134775d;
            r119.I = this.f134772a.f548434e;
            r119.E = null;
        L67:
            if (this.f134772a.f548433d == false) goto L69;
            r117 = DefaultLandingPanel.Emoji.getPanel();
        L69:
            HashMap r120 = new HashMap();
            r120.put(INPUT_PARAM_KEY.TargetUser, this.f134772a.f548439j);
            u22.m r121 = this.f134772a;
            if (this.f134775d.hr(this.f134774c, new g92.f(r121.f548441l, r121.f548438i, r117, r120)).booleanValue() == false) goto L74;
            CommentWidget.zq(this.f134775d, this.f134772a.f548434e);
            return;
        L74:
            return;
        L59:
            this.f134775d.f134751p1.a(this.f134772a.f548443n).f133036a = r102;
            goto L60
        L38:
            r108 = true;
            goto L39
        L8:
            if (r100.length() <= 1) goto L25;
            u22.m.a r122 = this.f134772a.f548434e;
            if (r122 != null) goto L12;
        L14:
            boolean r123 = false;
        L15:
            if (r123 == true) goto L25;
            CommentWidget r124 = this.f134775d;
            IRoom r125 = r124.f134753r;
            if (r125 != null) goto L19;
        L22:
            boolean r126 = true;
        L23:
            if (r126 == true) goto L25;
            r100 = r100.charAt(0) + s1.B(R.string.ttlive_user_info_secret);
            goto L25
        L19:
            if (r125.getRoomAuthStatus() == null) goto L22;
            r126 = r124.f134753r.getRoomAuthStatus().getEnableUserCard();
            goto L23
        L12:
            if (r122.f548446c == false) goto L14;
            r123 = true;
            goto L15
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

        public g(CommentWidget r100, u22.m r101, boolean r102, CommentEntry r103) {
            this.f134775d = r100;
            this.f134772a = r101;
            this.f134773b = r102;
            this.f134774c = r103;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u22.m f134776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentEntry f134777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134778c;

        public final void a() {
            if (this.f134778c.isViewValid() == true) goto L5;
            return;
        L5:
            CommentWidget r100 = this.f134778c;
            x22.b r101 = r100.B;
            if (r101 == null) goto L8;
            boolean r102 = this.f134776a.f548432c;
            r101.getClass();
            return;
        L8:
            x22.c r103 = r100.C;
            boolean r104 = this.f134776a.f548432c;
            r103.getClass();
            if (this.f134776a.f548433d == false) goto L11;
            String r105 = DefaultLandingPanel.Emoji.getPanel();
        L12:
            String r106 = r105;
            HashMap r107 = new HashMap();
            r107.put(INPUT_PARAM_KEY.TargetUser, this.f134776a.f548439j);
            u22.m r108 = this.f134776a;
            g92.f r109 = new g92.f(r108.f548441l, r108.f548438i, r106, r107);
            this.f134778c.hr(this.f134777b, r109);
            return;
        L11:
            r105 = null;
            goto L12
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

        public h(CommentWidget r100, u22.m r101, CommentEntry r102) {
            this.f134778c = r100;
            this.f134776a = r101;
            this.f134777b = r102;
        }
    }

    public static /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f134779a = null;

        static {
            int[] r100 = new int[QuickCommentTypeEnum.values().length];
            f134779a = r100;
            r100[QuickCommentTypeEnum.QUICK_COMMENT_MATCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f134779a[QuickCommentTypeEnum.QUICK_COMMENT_OGC_FIXED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134780a;

        public final void a() {
            if (this.f134780a.isViewValid() == false) goto L15;
            TextView r100 = this.f134780a.f134729a;
            if (r100 == null) goto L16;
            float r101 = r100.getMeasuredWidth();
            TextPaint r102 = this.f134780a.f134729a.getPaint();
            if (r101 <= 0.0f) goto L12;
            if (r102 == null) goto L12;
            if (r102.measureText(this.f134780a.P) <= r101) goto L12;
            boolean r103 = true;
        L13:
            this.f134780a.P1.e(cc2.h.f.f23185c, r103);
            return;
        L12:
            r103 = false;
            goto L13
        L16:
            return;
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

        public j(CommentWidget r100) {
            this.f134780a = r100;
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134781a;

        public final void a() {
            CommentWidget r100 = this.f134781a;
            if (r100.context != null) goto L5;
            return;
        L5:
            if (r100.f134753r != null) goto L7;
            return;
        L7:
            if (r100.f134741j == null) goto L34;
            CommentWidget r101 = this.f134781a;
            r100.f134750p0 = new MyLiveEntranceManager(r101.context, r101.f134753r, r101.f134741j, CommentWidget.wq(r101), this.f134781a.dataCenter);
            MyLiveEntranceManager r102 = this.f134781a.f134750p0;
            r102.getClass();
            ALogger.i("MyLive", "load my live container,timestamp = " + System.currentTimeMillis());
            r102.f135316a = (HSImageView) r102.f135323h.findViewById(R.id.my_live_avatar);
            r102.f135317b = (HSImageView) r102.f135323h.findViewById(R.id.my_live_avatar_border);
            r102.f135318c = new CompositeDisposable();
            DataCenter r103 = r102.f135325j;
            if (r103 == null) goto L11;
            r103.observe("data_user_in_room", r102);
        L11:
            IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
            if (r104 == null) goto L14;
            boolean r105 = r104.user().isLogin();
        L15:
            if (r105 == true) goto L17;
            r102.f135323h.setOnClickListener(new y62.d(r102));
        L26:
            TextView r106 = this.f134781a.f134729a;
            if (r106 == null) goto L35;
            com.bytedance.android.live.core.utils.a1.m(r106, s1.f(5.0f));
            com.bytedance.android.live.core.utils.a1.n(this.f134781a.f134729a, s1.f(4.0f));
            if (this.f134781a.ur() == false) goto L36;
            MainThreadPostUtils.d(this.f134781a.H1);
            MainThreadPostUtils.b(this.f134781a.H1);
            return;
        L36:
            return;
        L35:
            return;
        L17:
            ALogger.i("MyLive", "bind fake user avatar");
            if (r102.f135316a == null) goto L26;
            if (r102.f135317b == null) goto L26;
            UIUtils.setViewVisibility(r102.f135323h, 0);
            IBaseUser r107 = r102.b();
            if (r107 != null) goto L24;
            r107 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().y();
            ALogger.i("MyLive", "use IUserService User data");
        L24:
            if (r107 == null) goto L26;
            HSImageView r108 = r102.f135316a;
            py.k r109 = r107.getAvatarThumbKt();
            int r110 = r102.f135319d;
            ImageLoader.bindAvatar(r108, r109, r110, r110);
            ALogger.i("MyLive", "bind IUserService User data");
            r102.f135323h.setOnClickListener(new y62.b(r107, r102));
            goto L26
        L14:
            r105 = false;
            goto L15
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

        public k(CommentWidget r100) {
            this.f134781a = r100;
        }
    }

    public class l implements cc2.n<cc2.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134782a;

        public l(CommentWidget r100) {
            this.f134782a = r100;
        }

        @Override // cc2.n
        public final void a(cc2.h r100, Boolean r101) {
            CommentWidget r102 = this.f134782a;
            int r103 = CommentWidget.V1;
            if (r102.ur() == false) goto L6;
            UIUtils.setViewVisibility(this.f134782a.f134738h, 0);
            return;
        }

        @Override // cc2.n
        public final void b(cc2.h r100, Boolean r101) {
            UIUtils.setViewVisibility(this.f134782a.f134738h, 8);
        }
    }

    public class m extends cc2.p<cc2.h> {
        @Override // cc2.p
        public final Set<cc2.h> b() {
            HashSet r100 = new HashSet();
            r100.add(cc2.h.b.f23177c);
            r100.add(cc2.h.f.f23185c);
            r100.add(cc2.h.a.f23175c);
            r100.add(cc2.h.d.f23181c);
            r100.add(cc2.h.c.f23179c);
            r100.add(cc2.h.e.f23183c);
            return r100;
        }

        @Override // cc2.p
        public final Set<cc2.h> c() {
            return new HashSet();
        }

        public m(l r100) {
            super(true, r100);
        }
    }

    public class n implements cc2.n<cc2.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134783a;

        public n(CommentWidget r100) {
            this.f134783a = r100;
        }

        @Override // cc2.n
        public final void a(cc2.a r100, Boolean r101) {
            UIUtils.setViewVisibility(this.f134783a.f134740i, 0);
            this.f134783a.P1.e(cc2.h.a.f23175c, true);
            s62.a r102 = this.f134783a.P0;
            if (r102 == null) goto L6;
            r102.f540780b = true;
            return;
        }

        @Override // cc2.n
        public final void b(cc2.a r100, Boolean r101) {
            UIUtils.setViewVisibility(this.f134783a.f134740i, 8);
            this.f134783a.P1.e(cc2.h.a.f23175c, false);
            s62.a r102 = this.f134783a.P0;
            if (r102 == null) goto L8;
            r102.f540780b = false;
            yo2.e r103 = r102.f540782d;
            if (r103 == null) goto L9;
            r103.d();
            return;
        L9:
            return;
        }
    }

    public class o extends cc2.p<cc2.a> {
        @Override // cc2.p
        public final Set<cc2.a> b() {
            HashSet r100 = new HashSet();
            r100.add(cc2.a.C0427a.f23135c);
            r100.add(cc2.a.b.f23137c);
            return r100;
        }

        @Override // cc2.p
        public final Set<cc2.a> c() {
            HashSet r100 = new HashSet();
            r100.add(cc2.a.c.f23139c);
            return r100;
        }

        public o(n r100) {
            super(false, r100);
        }
    }

    public class p implements cc2.n<cc2.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentWidget f134784a;

        public p(CommentWidget r100) {
            this.f134784a = r100;
        }

        @Override // cc2.n
        public final void a(cc2.j r100, Boolean r101) {
            UIUtils.setViewVisibility(this.f134784a.f134742k, 0);
            this.f134784a.P1.e(cc2.h.b.f23177c, true);
        }

        @Override // cc2.n
        public final void b(cc2.j r100, Boolean r101) {
            UIUtils.setViewVisibility(this.f134784a.f134742k, 8);
            this.f134784a.P1.e(cc2.h.b.f23177c, false);
        }
    }

    public class q extends cc2.p<cc2.j> {
        @Override // cc2.p
        public final Set<cc2.j> b() {
            HashSet r100 = new HashSet();
            r100.add(cc2.j.a.f23195c);
            return r100;
        }

        @Override // cc2.p
        public final Set<cc2.j> c() {
            HashSet r100 = new HashSet();
            r100.add(cc2.j.b.f23197c);
            return r100;
        }

        public q(p r100) {
            super(false, r100);
        }
    }

    public static class r {
        public r() {
        }

        public r(int r100) {
        }
    }

    public class s implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.base.model.message.v0 f134785a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final o1 getLandscapeAreaCommon() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final long getChatId() {
            com.bytedance.android.live.base.model.message.v0 r100 = this.f134785a;
            if (r100 == null) goto L5;
            Long r101 = Long.valueOf(r100.getPinBaseMessageId());
        L7:
            return r101.longValue();
        L5:
            r101 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final String getContent() {
            com.bytedance.android.live.base.model.message.v0 r100 = this.f134785a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getChatContent();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final Boolean a() {
            return Boolean.FALSE;
        }

        public s(com.bytedance.android.live.base.model.message.v0 r100) {
            this.f134785a = r100;
        }
    }

    public interface t {
        Boolean a();

        long getChatId();

        String getContent();

        o1 getLandscapeAreaCommon();
    }

    public class u implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.base.model.message.k0 f134786a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final long getChatId() {
            com.bytedance.android.live.base.model.message.k0 r100 = this.f134786a;
            if (r100 == null) goto L5;
            Long r101 = Long.valueOf(r100.getChatId());
        L7:
            return r101.longValue();
        L5:
            r101 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final String getContent() {
            com.bytedance.android.live.base.model.message.k0 r100 = this.f134786a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getContent();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final o1 getLandscapeAreaCommon() {
            com.bytedance.android.live.base.model.message.k0 r100 = this.f134786a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getLandscapeAreaCommon();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.CommentWidget.t
        public final Boolean a() {
            return Boolean.FALSE;
        }

        public u(com.bytedance.android.live.base.model.message.k0 r100) {
            this.f134786a = r100;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public String getSpm() {
        return "a100.a100.a166";
    }

    public final void nr() {
        this.D = null;
        this.I = null;
        this.E = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final int supportClearScene() {
        return 54;
    }

    static {
        V1 = s1.f(200.0f);
        f134726b2 = s1.f(128.0f);
        f134727g2 = s1.f(100.0f);
    }

    public static boolean Yq() {
        return ev1.q.f474230d.getValue().booleanValue();
    }

    public Boolean Cq() {
        com.bytedance.android.livesdk.sharedpref.e<l42.b> r100 = l42.a.f507331r;
        l42.b r101 = r100.getValue();
        if (r101 != null) goto L7;
        return Boolean.FALSE;
    L7:
        if (r101.f507340a == true) goto L9;
        long r102 = System.currentTimeMillis();
        long r103 = r101.f507341b;
        if (r103 <= 0) goto L17;
        if ((r102 - r103) >= 2592000000L) goto L17;
        r101.f507341b = r102;
        r100.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r100, r101);
        return Boolean.FALSE;
    L17:
        return Boolean.TRUE;
    L9:
        return Boolean.FALSE;
    }

    public final void Dr() {
        CommentWidgetAnimator r100 = this.L;
        if (r100 != null) goto L5;
    L10:
        this.f134738h.setImageResource(R.drawable.ttlive_comment_emoji_entry);
        this.P1.e(cc2.h.c.f23179c, false);
        return;
    L5:
        if (r100.f136280e == false) goto L10;
        if (Tq() == false) goto L9;
        this.P1.e(cc2.h.c.f23179c, false);
        this.f134738h.setImageResource(R.drawable.ttlive_comment_emoji_entry_gray);
        return;
    L9:
        this.P1.e(cc2.h.c.f23179c, true);
    }

    public int Kq() {
        int r100 = V1;
        View r101 = this.f134733d;
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.getVisibility() != 0) goto L11;
        int r102 = s1.f(250.0f);
        if (j40.a1.f497165a.getValue().d() == true) goto L9;
        return r102;
    L9:
        return s1.f(268.0f);
    L11:
        return r100;
    }

    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.f Lq() {
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter) != null) goto L6;
        return null;
    L6:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).getQuickCommentManager() != null) goto L9;
        return null;
    L9:
        return com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).getQuickCommentManager().getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void M3() {
        IRoom r100 = this.f134753r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getRoomAuthStatus() != null) goto L7;
        return;
    L7:
        if (isScreenPortrait() == true) goto L9;
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("comment can not show due to room auth");
        int r101 = 8;
        if (isScreenPortrait() == true) goto L20;
        this.contentView.setAlpha(1.0f);
        xr();
        View r102 = this.contentView;
        if (this.f134753r.getRoomAuthStatus().getEnableChat() == true) goto L17;
    L19:
        UIUtils.setViewVisibility(r102, r101);
    L24:
        this.dataCenter.put("data_room_comment_status", Boolean.valueOf(this.f134753r.getRoomAuthStatus().getEnableChat()));
        return;
    L17:
        if (this.f134753r.getRoomAuthStatus().isEnableLandscapeChat() == false) goto L19;
        r101 = 0;
        goto L19
    L20:
        View r103 = this.contentView;
        if (this.f134753r.getRoomAuthStatus().getEnableChat() == false) goto L23;
        r101 = 0;
    L23:
        UIUtils.setViewVisibility(r103, r101);
        goto L24
    L9:
        if (this.f134753r.getRoomAuthStatus().getEnableChat() == false) goto L11;
        sr();
        goto L24
    L11:
        rr();
        goto L24
    }

    public final void Nq() {
        if (TextUtils.isEmpty(this.P) == false) goto L7;
        TextView r100 = this.f134729a;
        if (r100 == null) goto L7;
        this.P = Jq(r100.getMeasuredWidth(), this.f134729a.getPaint(), true).f562221a;
    L7:
        r3.e(this.f134729a, new c(this));
    }

    public final void Rq() {
        ALogger.i("CommentWidget", "start initCommentEditView");
        IRoom r100 = this.f134753r;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.f134753r, true) == true) goto L12;
        Eq(Boolean.FALSE);
        ALogger.i("CommentWidget", "skip handle onOGCFixedChatSyncDataChange cuz Chat disable");
        return;
    L12:
        IRoom r102 = this.f134753r;
        if (r102 == null) goto L17;
        IRoomAuthStatus r103 = r102.getRoomAuthStatus();
        if (r103 == null) goto L17;
        r101 = com.bytedance.android.livesdk.interactivity.service.model.b.b(r103);
    L17:
        if (r101 == true) goto L20;
        Eq(Boolean.FALSE);
        ALogger.i("CommentWidget", "skip handle onOGCFixedChatSyncDataChange cuz FixedChat disable");
        return;
    L20:
        IRoom r104 = this.f134753r;
        if (r104 == null) goto L25;
        IRoomAuthStatus r105 = r104.getRoomAuthStatus();
        if (r105 == null) goto L25;
        boolean r106 = com.bytedance.android.livesdk.interactivity.service.model.b.b(r105);
    L26:
        if (r106 == false) goto L32;
        Eq(Boolean.TRUE);
        TextView r107 = this.f134747n;
        if (r107 == null) goto L30;
        r107.setText(s1.B(R.string.ttlive_fix_hot_comment_hint));
    L30:
        dr();
        return;
    L32:
        return;
    L25:
        r106 = false;
        goto L26
    L5:
        if (r100.isMergeVSRoom() == true) goto L8;
        Eq(Boolean.FALSE);
    }

    public void Sq() {
        this.f134729a = (TextView) this.contentView.findViewById(R.id.edit_btn_audience);
        this.f134730b = this.contentView.findViewById(R.id.edit_btn_audience_container);
        this.f134736g = this.contentView.findViewById(R.id.edit_btn_audience_container_sub_root);
        this.f134747n = (TextView) this.contentView.findViewById(R.id.ogc_fixed_comment_hint);
        this.f134732c = this.contentView.findViewById(R.id.comment_interact_container);
        this.f134741j = (FrameLayout) this.contentView.findViewById(R.id.my_live_container);
        ImageView r100 = (ImageView) findViewById(R.id.iv_danmaku_setting);
        this.f134733d = findViewById(R.id.setting_container);
        this.f134734e = (RedDotView) findViewById(R.id.red_dot_danmu_setting);
        int r101 = g2.f116309a;
        if (g2.b(Boolean.valueOf(this.f134752q)) == false) goto L17;
        View r102 = this.f134730b;
        if (r102 == null) goto L8;
        UIUtils.setLayoutParams(r102, Integer.MIN_VALUE, s1.f(38.0f));
    L8:
        if (this.f134729a != null) goto L10;
    L12:
        View r103 = this.contentView.findViewById(R.id.voice_emoji_container);
        if (r103 == null) goto L17;
        if (isScreenPortrait() == false) goto L17;
        com.bytedance.android.live.core.utils.a1.o(r103, s1.f(2.0f));
        com.bytedance.android.live.core.utils.a1.k(r103, s1.f(36.0f));
        goto L17
    L10:
        if (isScreenPortrait() == false) goto L12;
        UIUtils.setLayoutParams(this.f134729a, Integer.MIN_VALUE, s1.f(38.0f));
    L17:
        this.f134738h = (HSImageView) this.contentView.findViewById(R.id.emoji_entry);
        this.f134740i = (HSImageView) this.contentView.findViewById(R.id.ai_entry);
        this.f134742k = (ViewGroup) this.contentView.findViewById(R.id.imemoji_contaienr);
        if (this.f134760x == false) goto L20;
    L58:
        LottieAnimationView r104 = this.f134748o;
        if (r104 != null) goto L61;
    L67:
        TextView r105 = this.f134729a;
        if (r105 == null) goto L70;
        r105.setOnClickListener(this);
    L70:
        TextView r106 = this.f134747n;
        if (r106 == null) goto L73;
        r106.setOnClickListener(this);
    L73:
        this.C.getClass();
        if (this.f134754s.getSharedPreferences("feed_live_span", 0).getInt("span_count", 0) <= 1) goto L76;
        String r107 = "live_small_picture";
    L77:
        this.f134755t = r107;
        kr();
        if (PadConfigUtils.c() == false) goto L81;
        int r108 = s1.j(R.dimen.ttlive_pad_left_right_margin);
        UIUtils.updateLayoutMargin(this.contentView, r108, -3, -3, r108);
        return;
    L81:
        return;
    L76:
        r107 = "live_big_picture";
        goto L77
    L61:
        if (r104.getVisibility() != 0) goto L67;
        if (this.f134733d == null) goto L67;
        if (Wq() == false) goto L67;
        this.f134733d.setVisibility(0);
        goto L67
    L20:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter) == false) goto L58;
        this.f134749p = this.contentView.findViewById(R.id.divider);
        LottieAnimationView r109 = (LottieAnimationView) this.contentView.findViewById(R.id.iv_danmaku_switch);
        this.f134748o = r109;
        DataContext r110 = null;
        if (r109 != null) goto L24;
        SafetyGuard.a(null, null, "mIvDanmakuSwitch error");
        ALogger.e("CommentWidget", "mIvDanmakuSwitch is null, mOrientationPortrait is " + this.f134760x + ", room is " + this.f134753r.getId() + " newLandscape is " + com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter));
    L29:
        this.L = Iq();
        if (((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).canShowCastDanmakuBtn(this.dataCenter) == false) goto L39;
        LottieAnimationView r111 = this.f134748o;
        if (r111 == null) goto L39;
        if (((Boolean) this.dataCenter.get("byte_cast_danmaku_mode", Boolean.FALSE)).booleanValue() == false) goto L36;
        int r112 = 8;
    L37:
        r111.setVisibility(r112);
        goto L39
    L36:
        r112 = 0;
    L39:
        if (jc1.k.f(IRoomContextService.class) == null) goto L58;
        if (((IRoomContextService) jc1.k.f(IRoomContextService.class)).getRoomDataContext(this.dataContext) == null) goto L58;
        if (((IRoomContextService) jc1.k.f(IRoomContextService.class)).getRoomDataContext(this.dataContext).H2() == false) goto L58;
        DataCenter r113 = this.dataCenter;
        int r114 = CommentUtils.f136249a;
        IInteractivityInjectService r115 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r115 == null) goto L47;
        DataContext r116 = r115.getLiveVisibilityControlContext(r113);
    L49:
        if ((r116 instanceof LiveVisibilityControlContext) == false) goto L52;
        r110 = r116;
    L52:
        LiveVisibilityControlContext r117 = (LiveVisibilityControlContext) r110;
        if (r117 == null) goto L58;
        if (r117.enablePlayBackAbility() == true) goto L57;
        UIUtils.updateLayoutMargin(this.contentView, s1.f(0.0f), -3, -3, -3);
    L57:
        ((ObservableSubscribeProxy) r117.getPlayBackAbilityInMsgMutable().a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.comment.u(this));
        goto L58
    L47:
        r116 = null;
        goto L49
    L24:
        if (Wq() == false) goto L26;
        String r118 = "vs_danmaku/images_landscape_opt";
    L27:
        r109.setImageAssetsFolder(r118);
        this.f134748o.setOnClickListener(this);
        goto L29
    L26:
        r118 = "comment/images";
        goto L27
    }

    public final boolean Tq() {
        if (j40.a1.f497165a.getValue().b() == false) goto L11;
        IRoom r100 = this.f134753r;
        if (r100 == null) goto L11;
        if (r100.isMergeVSRoom() == true) goto L11;
        if (this.f134753r.isMediaRoom() == true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // s22.c.a
    public final int U9() {
        View r100 = this.f134736g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWidth() - f134727g2;
    }

    public boolean Wq() {
        j40.a1 r100 = j40.a1.f497165a;
        if (r100.getValue().c() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.getValue().d() == true) goto L8;
        return false;
    }

    @Override // t22.b
    public final void dismissInputDialog() {
        if (this.B != null) goto L5;
        return;
    L5:
        if (isViewValid() == false) goto L9;
        ((LiveInputDialogV3) this.B).dismissInputDialog();
        this.dataCenter.put("data_pre_show_keyboard", Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter) == false) goto L8;
        this.f134760x = gb2.a.c(this.dataCenter, true);
        ALogger.i("Comment_preload", "getLayoutId::::  isPortrait " + this.f134760x + "   dataCenter" + this.dataCenter.hashCode() + " widget : " + hashCode());
        if (this.f134760x == true) goto L8;
        return R.layout.ttlive_view_comment_input_land;
    L8:
        return R.layout.ttlive_view_comment_input;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final boolean isRecyclableOnRotation() {
        return !com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter);
    }

    public final void jr() {
        CommentWidgetAnimator r100 = this.L;
        q4.b r101 = r100.f136276a;
        boolean r102 = true;
        boolean r103 = false;
        if (r101 != null) goto L5;
    L6:
        q4.b r104 = r100.f136277b;
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L16;
        boolean r106 = !r100.f136280e;
        r100.f136280e = r106;
        r100.c(r106, true);
        xs2.b.a().post(new e3(r100.f136280e, 0, "comment_animator"));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r107 = l42.a.f507320g;
        Boolean r108 = Boolean.valueOf(r100.f136280e);
        r107.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r107, r108);
        r100.b(r100.f136280e);
    L16:
        if (ur() == false) goto L19;
        Dr();
    L19:
        if (Wq() == true) goto L21;
    L25:
        r102 = false;
    L26:
        View r109 = this.f134733d;
        if (r109 == null) goto L32;
        if (r102 == false) goto L30;
        int r110 = 0;
    L31:
        r109.setVisibility(r110);
        goto L32
    L30:
        r110 = 8;
    L32:
        CommentWidgetAnimator r111 = this.L;
        if (r111 == null) goto L35;
        r103 = r111.f136280e;
    L35:
        yr(r103);
        if (Tq() == false) goto L39;
        xr();
        return;
    L39:
        return;
    L21:
        if (this.L.f136280e == false) goto L26;
        if (Tq() == false) goto L25;
    L9:
        if (r104.b() != true) goto L11;
    L10:
        r105 = true;
        goto L12
    L5:
        if (r101.b() == true) goto L10;
        goto L6
    }

    public void kr() {
        ViewGroup.LayoutParams r100 = this.contentView.getLayoutParams();
        if (this.f134760x == true) goto L5;
        r100.width = Kq();
        this.contentView.setLayoutParams(r100);
        this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(new f(this, r100));
        return;
    L5:
        r100.width = -1;
        this.contentView.setLayoutParams(r100);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onClear() {
        FileUtils.removeDir(new PolarisFileWrapper(jc1.a.b().getFilesDir().getAbsolutePath() + "/audio/"));
    }

    public final void rr() {
        this.contentView.setAlpha(0.34f);
        xr();
        String r100 = this.f134754s.getString(R.string.ttlive_cannot_comment_msg_opt);
        IRoom r101 = this.f134753r;
        if (r101 != null) goto L5;
    L7:
        y3.f(this.dataCenter).a(ToolbarButton.COMMENT, r100);
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L11;
        r102.put("data_room_comment_disable", new r());
        return;
    L11:
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.a(r101) == true) goto L7;
        r100 = com.bytedance.android.livesdk.interactivity.comment.utils.f.c(this.f134753r);
        goto L7
    }

    public final void sr() {
        this.contentView.setAlpha(1.0f);
        xr();
        y3.f(this.dataCenter).o(ToolbarButton.COMMENT);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.put("data_room_comment_disable", new r(0));
        return;
    }

    public void tr() {
        boolean r100 = this.f134760x;
        int r101 = R.drawable.ttlive_bg_edit_message_alpha_30;
        if (r100 == false) goto L12;
        View r102 = this.f134730b;
        if (r102 != null) goto L7;
    L11:
        Cr();
    L21:
        if (this.f134760x == true) goto L55;
        IRoom r103 = this.f134753r;
        if (r103 != null) goto L25;
    L27:
        boolean r104 = false;
    L28:
        View r105 = this.f134730b;
        if (r105 == null) goto L35;
        if (this.f134753r == null) goto L33;
        r105.setBackground(new e1());
        goto L35
    L33:
        r105.setBackgroundResource(R.drawable.ttlive_bg_edit_message_land_new);
    L35:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter) == false) goto L39;
        CommentWidgetAnimator r106 = this.L;
        if (r106 == null) goto L39;
        yr(r106.f136280e);
    L39:
        if (r104 == false) goto L52;
        CommentWidgetAnimator r107 = this.L;
        if (r107 == null) goto L52;
        r107.a();
        if (this.L.f136280e == true) goto L46;
        this.f134730b.setBackgroundResource(R.drawable.ttlive_bg_edit_message_land_match);
    L46:
        if (ht2.g.e(this.f134753r, 10) == false) goto L52;
        ALogger.d("CommentWidget", "room start set landNinePatch bg");
        if (this.L.f136280e == true) goto L50;
        ht2.g.b(10, this.f134753r, this.f134730b, false);
    L50:
        com.bytedance.android.livesdk.chatroom.utils.a1.u(ht2.g.a(this.f134753r, 10, false), new d(this));
    L52:
        if ((this.f134729a instanceof LiveTextView) == false) goto L55;
        Cr();
        goto L55
    L25:
        if (r103.isMergeVSRoom() == false) goto L27;
        r104 = true;
    L55:
        if (ht2.g.f(this.f134753r, 10, true) == true) goto L57;
        return;
    L57:
        if (this.f134753r.isMergeVSRoom() == true) goto L59;
        ht2.g.c(10, this.f134753r, this.f134730b);
        return;
    L59:
        if (this.f134760x == false) goto L64;
        ht2.g.b(10, this.f134753r, this.f134730b, true);
        return;
    L64:
        return;
    L7:
        if (Yq() == true) goto L10;
        r101 = R.drawable.ttlive_bg_edit_message_rename;
    L10:
        r102.setBackground(s1.m(r101));
        goto L11
    L12:
        View r108 = this.f134730b;
        if (r108 != null) goto L15;
    L19:
        this.f134729a.setTextColor(s1.h(R.color.ttlive_white));
        Cr();
        goto L21
    L15:
        if (Yq() == true) goto L18;
        r101 = R.drawable.ttlive_bg_edit_message_land;
    L18:
        r108.setBackground(s1.m(r101));
        goto L19
    }

    public final void xr() {
        TextView r100 = this.f134729a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.C == null) goto L13;
        x22.a r101 = Jq(r100.getMeasuredWidth(), this.f134729a.getPaint(), true);
        this.R = r101;
        String r102 = r101.f562221a;
        this.P = r102;
        if (this.Q.equals(r102) == true) goto L10;
        this.Q = this.P;
        com.bytedance.android.livesdk.interactivity.comment.utils.e.a(this.R);
    L10:
        this.f134729a.setText(this.P);
        Cr();
        Nq();
        return;
    }

    public final void zr() {
        IRoom r100 = this.f134753r;
        if (r100 == null) goto L9;
        if (r100.getRoomAuthStatus() == null) goto L9;
        if (this.f134753r.getRoomAuthStatus().getEnableChat() == true) goto L9;
    L16:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L21;
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("comment can not show due to room auth");
        IRoom r102 = this.f134753r;
        InteractivityMonitor.Event r103 = com.bytedance.android.livesdk.interactivity.api.monitor.a.f133313a;
        Intrinsics.checkNotNullParameter("room auth disable", "reason");
        InteractivityMonitor.c(InteractivityMonitor.Event.CommentDisable, r102, 0, "room auth disable", 16);
    L21:
        if (isScreenPortrait() == true) goto L23;
        if (r101 == false) goto L31;
        UIUtils.setViewVisibility(this.contentView, 8);
        return;
    L31:
        UIUtils.setViewVisibility(this.contentView, 0);
        return;
    L23:
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(isScreenPortrait(), this.f134753r) == true) goto L25;
    L27:
        UIUtils.setViewVisibility(this.contentView, 0);
        return;
    L25:
        if (this.f134763y1 == true) goto L27;
        UIUtils.setViewVisibility(this.contentView, 4);
        ALogger.i("CommentWidget", "ToolbarAndCommentShowCtrlSetting set contentView INVISIBLE");
        return;
    L9:
        if (isScreenPortrait() == true) goto L17;
        IRoom r104 = this.f134753r;
        if (r104 == null) goto L17;
        if (r104.getRoomAuthStatus() == null) goto L17;
        if (this.f134753r.getRoomAuthStatus().isEnableLandscapeChat() == false) goto L16;
    L17:
        r101 = false;
        goto L18
    }

    public CommentWidget() {
        Boolean r100 = Boolean.FALSE;
        this.f134745l = r100;
        this.f134746m = r100;
        this.f134759w = true;
        this.f134764z = 0;
        this.A = 0;
        this.B = null;
        this.C = new x22.c();
        this.G = null;
        this.H = r100;
        this.f134728J = new CompositeDisposable();
        this.K = false;
        this.M = null;
        this.N = null;
        this.O = new HashMap();
        this.P = "";
        this.Q = "";
        this.T = null;
        this.U = false;
        this.V = 0L;
        this.W = null;
        this.L0 = com.bytedance.android.livesdk.interactivity.api.monitor.b.f133316a.monitorKeyboard;
        this.V0 = n4.f153996a.getValue().booleanValue();
        this.f134731b1 = v4.f159242a.getValue().booleanValue();
        this.f134737g1 = u4.f158614a.getValue().booleanValue();
        this.f134739h1 = new HashSet();
        this.f134744k1 = new HashSet();
        this.f134751p1 = new x22.d();
        this.f134761x1 = false;
        this.f134763y1 = false;
        this.G1 = new e(this);
        this.H1 = new j(this);
        this.L1 = new k(this);
        this.P1 = new m(new l(this));
        this.Q1 = new o(new n(this));
        this.S1 = new q(new p(this));
        this.T1 = null;
    }

    public final void Cr() {
        s1.h(R.color.ttlive_comment_hint_text_color_inner);
        if (this.f134760x == false) goto L5;
        int r100 = s1.h(R.color.ttlive_comment_hint_text_color_inner);
    L12:
        this.f134729a.setTextColor(r100);
        return;
    L5:
        r100 = ColorProtector.parseColor("#CCFFFFFF");
        CommentWidgetAnimator r101 = this.L;
        if (r101 == null) goto L12;
        if (r101.f136280e == false) goto L12;
        if (Tq() == false) goto L12;
        r100 = s1.h(R.color.ttlive_comment_block_text_color);
        goto L12
    }

    public CommentWidgetAnimator Iq() {
        if (Wq() == false) goto L9;
        if (this.f134733d == null) goto L9;
        CommentWidgetAnimator r100 = new CommentWidgetAnimator(this.f134730b, this.f134733d, this.f134729a, this.f134748o, ColorProtector.parseColor("#00000000"), Tq());
        Intrinsics.checkNotNullParameter("vs_danmaku/vs_danmaku_close.json", "<set-?>");
        r100.f136281f = "vs_danmaku/vs_danmaku_close.json";
        Intrinsics.checkNotNullParameter("vs_danmaku/vs_danmaku_open.json", "<set-?>");
        r100.f136282g = "vs_danmaku/vs_danmaku_open.json";
        return r100;
    L9:
        return new CommentWidgetAnimator(this.f134730b, this.f134749p, this.f134729a, this.f134748o, ColorProtector.parseColor("#4D000000"), false);
    }

    public final void dr() {
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r100 = Lq();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r101 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), this.dataCenter);
        com.bytedance.android.livesdk.interactivity.api.base.d r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r103 = r101.getState();
    L6:
        if (r103 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.api.base.d r104 = r103.getValue();
    L10:
        if (r104 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r105 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), this.dataCenter);
        if (r105 == null) goto L14;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r106 = r105.getState();
    L15:
        if (r106 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.base.d r107 = r106.getValue();
    L19:
        if (r107.f132904a == PublicScreenAreaPageType.PublicScreen) goto L27;
        StringBuilder r108 = new StringBuilder("onOGCFixedChatSyncDataChange, current pageType = ");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r109 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), this.dataCenter);
        if (r109 == null) goto L23;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r110 = r109.getState();
    L24:
        if (r110 == null) goto L26;
        r102 = r110.getValue();
    L26:
        r108.append(r102.f132904a);
        ALogger.i("CommentWidget", r108.toString());
        Eq(Boolean.FALSE);
        boolean r111 = false;
    L28:
        if (r100 != null) goto L30;
        return;
    L30:
        if (r100.isOGCFixedComment() == false) goto L49;
        int r112 = r100.getQuickCommentType().getValue().intValue();
        com.bytedance.android.livesdk.interactivity.api.quickcomment.e.f133749a.getClass();
        if (r112 != 3) goto L50;
        if (r111 == true) goto L35;
        return;
    L35:
        if (this.f134747n == null) goto L52;
        ArrayList r113 = new ArrayList();
        int r114 = 22;
    L38:
        if (r114 > 25) goto L43;
        py.k r115 = ht2.g.a(this.f134753r, r114, true);
        if (r115 == null) goto L42;
        r113.add(r115);
    L42:
        r114 = r114 + 1;
        goto L38
    L43:
        ht2.k.c(r113);
        Eq(Boolean.TRUE);
        this.f134747n.setText(r100.getFixedCommentTips().getValue());
        return;
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L23:
        r110 = null;
        goto L24
    L17:
        r107 = null;
        goto L19
    L14:
        r106 = null;
    L27:
        r111 = true;
        goto L28
    L8:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onPause");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onResume");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        Iterator r100 = ((HashSet) this.f134739h1).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((y22.e) r100.next()).destroy();
        goto L4
    L6:
        ((HashSet) this.f134739h1).clear();
        Iterator r101 = ((HashSet) this.f134744k1).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((t22.a) r101.next()).onUnload();
        goto L8
    L10:
        ((HashSet) this.f134744k1).clear();
        this.contentView.setAlpha(1.0f);
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L13;
        r102.removeObserver(this);
    L13:
        this.f134729a.getViewTreeObserver().removeOnGlobalLayoutListener(this.M);
        this.f134729a.removeOnLayoutChangeListener(this.N);
        this.f134762y.detachView();
        this.f134728J.clear();
        this.f134757v = false;
        this.K = false;
        this.f134759w = true;
        x22.b r103 = this.B;
        if (r103 == null) goto L16;
        r103.dismissAllowingStateLoss();
        this.B = null;
    L16:
        x22.c r104 = this.C;
        if (r104 == null) goto L19;
        r104.f562227e = null;
        r104.f562230h.clear();
    L19:
        com.bytedance.android.livesdk.interactivity.comment.utils.e.f136258c = false;
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onUnload");
        wr("");
        s22.c r105 = this.X;
        if (r105 == null) goto L34;
        r105.b(ContainerType.PublicScreen);
        this.X = null;
        if (this.Y == null) goto L34;
        WeakReference<ViewTreeObserver> r106 = this.H0;
        if (r106 == null) goto L32;
        ViewTreeObserver r107 = r106.get();
        if (r107 != null) goto L28;
    L31:
        this.H0.clear();
        this.H0 = null;
    L33:
        this.Y = null;
        goto L34
    L28:
        if (r107.isAlive() == false) goto L30;
        r107.removeOnGlobalLayoutListener(this.Y);
        goto L31
    L30:
        this.contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.Y);
        goto L31
    L32:
        this.contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.Y);
    L34:
        this.P1.d();
        this.S1.d();
        this.Q1.d();
        this.f134763y1 = false;
        MyLiveEntranceManager r108 = this.f134750p0;
        if (r108 == null) goto L43;
        CompositeDisposable r109 = r108.f135318c;
        if (r109 == null) goto L39;
        r109.clear();
    L39:
        r108.f135318c = null;
        DataCenter r110 = r108.f135325j;
        if (r110 == null) goto L42;
        r110.removeObserver(r108);
    L42:
        this.f134750p0 = null;
        MainThreadPostUtils.d(this.H1);
    L43:
        s62.a r111 = this.P0;
        if (r111 == null) goto L46;
        r111.c();
        this.P0 = null;
    L46:
        MainThreadPostUtils.d(this.L1);
    }

    public final boolean ur() {
        if (isScreenPortrait() == true) goto L10;
        IRoom r100 = this.f134753r;
        if (r100 == null) goto L10;
        if (r100.isMergeVSRoom() == false) goto L10;
        return false;
    L10:
        if (this.f134752q == false) goto L12;
    L14:
        boolean r101 = y62.a.f566322a;
        if (y62.a.a(this.f134753r, this.f134760x) == true) goto L17;
    L21:
        boolean r102 = false;
    L22:
        IRoom r103 = this.f134753r;
        if (r103 == null) goto L42;
        IRoomAuthStatus r104 = r103.getRoomAuthStatus();
        if (r104 == null) goto L29;
        com.bytedance.android.livesdk.interactivity.service.model.c r105 = (com.bytedance.android.livesdk.interactivity.service.model.c) r104.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r105 == null) goto L29;
        long r106 = r105.getEnableEmojiExpose();
    L31:
        if (r106 == 2) goto L33;
        boolean r107 = true;
    L34:
        if (r107 == true) goto L36;
        return false;
    L36:
        if (ec2.f.f472015a.getValue().booleanValue() == true) goto L38;
        return false;
    L38:
        if (this.f134752q == true) goto L45;
        if (r102 == true) goto L46;
        return true;
    L46:
        return false;
    L45:
        return false;
    L33:
        r107 = false;
    L29:
        r106 = 2;
        goto L31
    L42:
        return false;
    L17:
        if (y62.a.f566324c.c() == false) goto L21;
        if (y62.a.f566326e > y62.a.f566325d) goto L21;
        r102 = true;
        goto L22
    L12:
        if (ev1.q.f474230d.getValue().booleanValue() == false) goto L14;
        return false;
    }

    public static void Gq(Map r100) {
        if (r100.isEmpty() == true) goto L17;
        int r101 = CastIntegerProtector.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L28;
        g92.c r103 = (g92.c) JsonUtil.parse((String) ((Map.Entry) r102.next()).getValue(), g92.c.class);     // Catch: Exception -> L15
        if (r103 == null) goto L7;
        if (r101 < (CastIntegerProtector.parseInt(r103.f480498c) + 3)) goto L7;
        r102.remove();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L7
    L28:
        return;
    }

    public static void Mq(com.bytedance.android.livesdk.event.y r100) {
        HashMap r101 = new HashMap();
        com.bytedance.android.livesdk.event.m r102 = r100.f123381e;
        if (r102 == null) goto L39;
        List<com.bytedance.android.livesdk.event.n> r103 = r102.f123350a;
        if (r103 == null) goto L40;
        Iterator<com.bytedance.android.livesdk.event.n> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        ImageSpan r105 = r104.next().f123357f;
        if ((r105 instanceof com.bytedance.android.livesdk.interactivity.comment.input.d) == false) goto L8;
        com.bytedance.android.livesdk.interactivity.comment.input.d r106 = (com.bytedance.android.livesdk.interactivity.comment.input.d) r105;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L41;
        r101.put("content_type", "quick_interaction");
        if (r106 != null) goto L17;
    L20:
        MiddlewareRoomContext r108 = MiddlewareRoomContext.getShared();
        String r109 = "0";
        if (r108 != null) goto L23;
    L27:
        r101.put(IPerformanceManager.Params.is_anchor, "0");
    L28:
        if (r108 != null) goto L30;
    L34:
        r101.put("audience_count", r109);
        com.bytedance.android.livesdk.log.j0 r110 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r111 = new am2.x();
        r111.f4349a = "live_interact";
        r110.sendLog("audience_live_message", r101, new Object[]{am2.u.class, r111, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        return;
    L30:
        if (r108.getCurStatMessage() == null) goto L34;
        if (r108.getCurStatMessage().getValue() == null) goto L34;
        r109 = String.valueOf(r108.getCurStatMessage().getValue().getTotal());
        goto L34
    L23:
        if (r108.isAnchor() == null) goto L27;
        if (r108.isAnchor().getValue().booleanValue() == false) goto L27;
        r101.put(IPerformanceManager.Params.is_anchor, "1");
        goto L28
    L17:
        if (r106.f135153h.getType() != 1) goto L19;
        r101.put("quick_interaction_type", "say_hi");
        goto L20
    L19:
        r101.put("quick_interaction_type", "location");
        goto L20
    L41:
        return;
    L12:
        r106 = null;
        r107 = false;
        goto L13
    L40:
        return;
    }

    public static /* synthetic */ DataContext wq(CommentWidget r100) {
        return r100.dataContext;
    }

    public static void xq(final CommentWidget r110) {
        r110.f134728J.add(xs2.b.a().b(u22.m.class).compose(r110.getAutoUnbindTransformer()).subscribe(new a1(r110)));
        r110.f134728J.add(xs2.b.a().b(za2.a.class).compose(r110.getAutoUnbindTransformer()).subscribe(new b1(r110)));
        r110.f134728J.add(xs2.b.a().b(u22.c.class).compose(r110.getAutoUnbindTransformer()).subscribe(new c1(r110)));
        r110.f134728J.add(xs2.b.a().b(u22.g.class).compose(r110.getAutoUnbindTransformer()).subscribe(new t0(r110)));
        r110.f134728J.add(xs2.b.a().b(e3.class).compose(r110.getAutoUnbindTransformer()).subscribe(new v(r110)));
        r110.f134728J.add(xs2.b.a().b(b30.i.class).subscribe(new w(r110)));
        r110.f134728J.add(xs2.b.a().b(b30.k.class).subscribe(new x(r110)));
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(r110.isScreenPortrait(), r110.f134753r) == true) goto L5;
    L9:
        DataCenter r100 = r110.dataCenter;
        if (r100 == null) goto L24;
        String r101 = (String) r100.get(ILiveRoomPlayFragmentConstant.PRE_ENTRY_CHAT_STRING, "");
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r110.G1.a(r101, false, 0, false, null, null, null);
        r110.dataCenter.put(ILiveRoomPlayFragmentConstant.PRE_ENTRY_CHAT_STRING, "");
    L14:
        DataCenter r102 = r110.dataCenter;
        Boolean r103 = Boolean.FALSE;
        if (((Boolean) r102.get(ILiveRoomPlayFragmentConstant.PRE_ENTRY_OPEN_CHAT, r103)).booleanValue() == false) goto L17;
        r110.hr(CommentEntry.Click, new g92.f(OpenInputSource.PreviewEntryChat, System.currentTimeMillis(), null, null));
        r110.dataCenter.put(ILiveRoomPlayFragmentConstant.PRE_ENTRY_OPEN_CHAT, r103);
    L17:
        r110.dataCenter.observe("byte_cast_danmaku_mode", r110).observe("cmd_do_send_message", r110).observe("data_screen_record_is_open", r110).observe("cmd_wanna_send_message", r110).observe("data_room_audio_comment_enable", r110).observe("data_link_state", r110).observe("data_media_introduction_showing", r110).observe("cmd_start_edit", r110).observe("cmd_widget_loaded", r110).observe("data_room_video_comment_share_enable", r110).observe("cmd_change_interactivity_component_visibility", r110).observeForever("data_keyboard_status", r110).observeForever("cmd_hide_other_toolbar", r110).observeForever("cmd_hide_in_douyin_commerce", r110).observeForever("cmd_special_dialog_show", r110).observeForever("fixed_comment_emoji_data_loaded", r110);
        final Long r104 = (Long) r110.dataCenter.get(ILiveRoomPlayFragmentConstant.PRE_ENTRY_FAST_EMOJI_ID, -1L);
        if (r104.longValue() <= 0) goto L25;
        r110.or(r104);
        if (CollectionUtils.isEmpty(yt0.c.l().getSubscribeInfo().getValue().f89133a) == false) goto L22;
        yt0.c.l().getSubscribeInfo().a().subscribe(new a0(r110, r104));
        return;
    L22:
        r110.pr(r104, yt0.c.l().getSubscribeInfo().getValue().f89133a);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(r110.dataContext, r110.dataCenter) == null) goto L9;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(r110.dataContext, r110.dataCenter).getToolbarAndCommentShowCtrlManager().getValue() == null) goto L9;
        ALogger.i("CommentWidget", "subscribe ToolbarAndCommentShowCtrlManager onTotalWidgetReady");
        Disposable r105 = com.bytedance.android.livesdk.interactivity.api.i.a(r110.dataContext, r110.dataCenter).getToolbarAndCommentShowCtrlManager().getValue().a().timeout(i4.f536198a.getValue().longValue(), TimeUnit.MILLISECONDS).doOnError(new y()).onErrorReturnItem(new u22.k()).observeOn(AndroidSchedulers.mainThread()).subscribe(new z(r110));
        r110.f134728J.add(r105);
        goto L9
    }

    public static void yq(final CommentWidget r100) {
        r100.getClass();
        long r101 = System.currentTimeMillis();
        UIUtils.setViewVisibility(r100.f134730b, 0);
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r100.dataCenter) == false) goto L8;
        CommentWidgetAnimator r102 = r100.L;
        if (r102 == null) goto L8;
        r102.a();
    L8:
        if (r100.ur() == false) goto L26;
        m r103 = r100.P1;
        cc2.h.b r104 = cc2.h.b.f23177c;
        if (r100.Z == false) goto L16;
        s22.c r105 = r100.X;
        if (r105 == null) goto L16;
        if (r105.isShowing() == false) goto L16;
        boolean r106 = true;
    L17:
        r103.e(r104, r106);
        r3.a(r100.f134738h, s1.B(R.string.ttlive_a11y_keyboard_emoji_expose));
        r100.f134738h.setOnClickListener(r100);
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L21;
        r100.runWithRoomEntered(new v0(r100));
    L24:
        if (ht2.g.f(r100.f134753r, 15, true) == false) goto L27;
        ht2.g.d(15, r100.f134753r, r100.f134738h, new w0());
    L27:
        r100.kr();
        r100.xr();
        r100.tr();
        r100.runWithRoomVisible(new z0(r100));
        int r107 = r100.f134764z + 1;
        r100.f134764z = r107;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r108 = l42.a.f507332s;
        Integer r109 = Integer.valueOf(r107);
        r108.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r108, r109);
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onLoad");
        CommentContext.a r110 = CommentContext.Companion;
        DataCenter r111 = r100.dataCenter;
        r110.getClass();
        if (CommentContext.a.a(r111) == null) goto L30;
        CommentContext.a.a(r100.dataCenter).getCommentService().d(r100);
    L30:
        UIUtils.setViewVisibility(r100.contentView, 0);
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r100.dataCenter) == true) goto L33;
    L37:
        r100.runWithRoomEntered(new j0(r100));
        z32.c.c(InputConstantNode.InputPrepareViewTime, String.valueOf(System.currentTimeMillis() - r101));
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(r100.isScreenPortrait(), r100.f134753r) == true) goto L40;
    L44:
        DataCenter r112 = r100.dataCenter;
        if (r112 == null) goto L50;
        b30.i r113 = (b30.i) r112.get("cmd_show_comment_input_dialog_from_preview", null);
        r100.dataCenter.put("cmd_show_comment_input_dialog_from_preview", null);
        if (r113 == null) goto L51;
        ALogger.i("CommentWidget", "OpenCommentPanelEvent from preview");
        r100.cr(r113);
        return;
    L51:
        return;
    L50:
        return;
    L40:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(r100.dataContext, r100.dataCenter) == null) goto L44;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(r100.dataContext, r100.dataCenter).getToolbarAndCommentShowCtrlManager().getValue() == null) goto L44;
        ALogger.i("CommentWidget", "call ToolbarAndCommentShowCtrlManager notifyCommentReady");
        com.bytedance.android.livesdk.interactivity.api.i.a(r100.dataContext, r100.dataCenter).getToolbarAndCommentShowCtrlManager().getValue().c();
        goto L44
    L33:
        if (r100.L == null) goto L37;
        if (r100.ur() == false) goto L37;
        r100.Dr();
        goto L37
    L21:
        if (r100.K == true) goto L24;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_emoji_show", null, new Object[]{am2.x.class, Room.class});
        r100.K = true;
    L16:
        r106 = false;
        goto L17
    L26:
        r100.P1.e(cc2.h.d.f23181c, true);
        goto L27
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Ae(com.bytedance.android.live.base.model.message.v0 r100) {
        r100.setLocalInsertMsg(true);
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter) == null) goto L5;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter).B(r100);
    L5:
        HashMap r101 = new HashMap();
        r101.put("is_settled", "1");
        r101.put("quickCommentType", QuickCommentTypeEnum.QUICK_COMMENT_OGC_FIXED);
        mr(new com.bytedance.android.livesdk.event.d0("", ISendCommentEvent.Sender.CommentWidget, r101, null, null, false), new s(r100));
    }

    public final void Aq(HashMap<String, String> r100) {
        if (ec2.v0.f472064a.getValue().booleanValue() == false) goto L15;
        String r101 = "";
        if (jc1.k.f(IInteractService.class) == null) goto L7;
        r100.put("ui_layout", ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentUiLayout() + "");
    L7:
        DataCenter r102 = this.dataCenter;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.get("data_online_changed_list", new ArrayList()) == null) goto L13;
        r101 = ((ArrayList) this.dataCenter.get("data_online_changed_list", new ArrayList())).size() + "";
    L13:
        r100.put("online_size", r101);
        return;
    }

    public final void Bq(HashMap<String, String> r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L12;
        Boolean r102 = Boolean.FALSE;
        if (((Boolean) r101.get("data_click_preview_comment_enter_room", r102)).booleanValue() != true) goto L12;
        r100.put("click_method", "interact_area");
        String r103 = this.W;
        if (r103 != null) goto L9;
    L11:
        this.dataCenter.put("data_click_preview_comment_enter_room", r102);
        goto L12
    L9:
        if (r103.isEmpty() == true) goto L11;
        r100.put("guide_text", this.W);
        r100.put("request_source", "preview_guide");
    L12:
        this.W = null;
    }

    public final void Eq(Boolean r100) {
        if (r100.booleanValue() == false) goto L15;
        View r101 = this.f134736g;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        TextView r102 = this.f134747n;
        if (r102 != null) goto L10;
    L14:
        ALogger.i("CommentWidget", "changeOGCFixedUIStyle to true");
        return;
    L10:
        if (r102.getVisibility() != 8) goto L12;
    L13:
        this.f134747n.setVisibility(0);
        HashMap r103 = new HashMap();
        r103.put("operate_type", "show");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_icon", r103, new Object[]{new am2.x(), IRoom.class});
        goto L14
    L12:
        if (this.f134747n.getVisibility() != 4) goto L14;
    L15:
        View r104 = this.f134736g;
        if (r104 == null) goto L18;
        r104.setVisibility(0);
    L18:
        TextView r105 = this.f134747n;
        if (r105 == null) goto L21;
        r105.setVisibility(8);
    L21:
        ALogger.i("CommentWidget", "changeOGCFixedUIStyle to false");
    }

    public final void Er(u22.m r110) {
        if (br(r110, Boolean.FALSE).booleanValue() == false) goto L6;
        return;
    L6:
        if (this.T1 != r110) goto L8;
        return;
    L8:
        this.T1 = r110;
        CommentEntry r100 = CommentEntry.WannaSendEvent;
        int r101 = r110.f548442m;
        if (r101 != 1) goto L18;
        r100 = CommentEntry.ChatChannelWannaEvent;
        if (r110.f548443n > 0) goto L17;
        int r102 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.f132962a;
        IInteractivityInjectService r103 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r103 == null) goto L15;
        long r104 = r103.getCurrentChatChannelId();
    L16:
        r110.f548443n = r104;
        goto L17
    L15:
        r104 = -1;
    L17:
        boolean r105 = true;
    L31:
        nr();
        if (r110.getType() != 1) goto L34;
        this.C.f562232j = r110.f548436g;
    L35:
        this.E = r110.f548435f;
        if (r110.getType() != 1) goto L39;
        new g(this, r110, r105, r100).run();
        return;
    L39:
        if (r110.getType() != 2) goto L42;
        this.contentView.postDelayed(new h(this, r110, r100), 500);
        return;
    L42:
        if (r110.f548433d == false) goto L44;
        String r106 = DefaultLandingPanel.Emoji.getPanel();
    L45:
        HashMap r107 = new HashMap();
        r107.put(INPUT_PARAM_KEY.TargetUser, r110.f548439j);
        r107.put(INPUT_PARAM_KEY.ReplyMsgId, Long.valueOf(r110.f548440k));
        r107.put(INPUT_PARAM_KEY.SecretClickFrom, Integer.valueOf(r110.f548437h));
        hr(r100, new g92.f(r110.f548441l, r110.f548438i, r106, r107));
        return;
    L44:
        r106 = null;
        goto L45
    L34:
        this.C.f562232j = -1;
        goto L35
    L18:
        r105 = false;
        if (r101 != 2) goto L22;
        r100 = CommentEntry.SquareChatEvent;
        goto L31
    L22:
        if (r110.getType() != 1) goto L24;
        r100 = CommentEntry.WannaSendAtEvent;
        goto L31
    L24:
        OpenInputSource r108 = r110.f548441l;
        if (r108 != OpenInputSource.SecretChat) goto L27;
    L30:
        r100 = CommentEntry.SecretChat;
        goto L31
    L27:
        if (r108 == OpenInputSource.ReplySecretChat) goto L30;
        if (r108 != OpenInputSource.ReplyHeartSecretChat) goto L31;
        goto L30
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Oy(boolean r100) {
        this.C.f562224b = r100;
    }

    public void Pq(KVData r100) {
        if (((Boolean) r100.getData(Boolean.FALSE)).booleanValue() == false) goto L8;
        LottieAnimationView r101 = this.f134748o;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        xs2.b.a().post(new e3(true, 2, NewBroadcastMonitor.STAGE.CAST));
        return;
    L8:
        LottieAnimationView r102 = this.f134748o;
        if (r102 == null) goto L11;
        r102.setVisibility(0);
    L11:
        xs2.b.a().post(new e3(l42.a.f507320g.getValue().booleanValue(), 2, NewBroadcastMonitor.STAGE.CAST));
    }

    public final void Qq(ApiServerException r100) {
        if (ExceptionUtils.shouldShowBindPhone(r100) == true) goto L5;
        return;
    L5:
        if (r52.a.f536145a.getValue().booleanValue() == true) goto L7;
        return;
    L7:
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L12;
        ((IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class)).startBindPhoneDialogFragment(this.f134754s, "live_detail", "live_detail", new h0(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void R00(com.bytedance.android.live.base.model.message.r r100) {
        CommentUtils.a(r100, this.dataCenter);
    }

    @Override // t22.b
    public final void Xp(boolean r100) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.f134752q == true) goto L19;
        x22.b r101 = this.B;
        if (r101 == null) goto L10;
        r101.getClass();
    L13:
        this.C.f562223a = r100;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter) == null) goto L18;
        com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).isUserBannedTalk().setValue(Boolean.valueOf(r100));
        return;
    L18:
        return;
    L10:
        this.C.f562223a = r100;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter) == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).isUserBannedTalk().setValue(Boolean.valueOf(r100));
        goto L13
    }

    public final void Zq(int r100) {
        HashMap r101 = new HashMap();
        IBaseUser r102 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b();
        r101.put("user_id", r102.getIdString());
        py.d r103 = r102.getUserHonor();
        if (r103 == null) goto L5;
        r101.put("privilege_level", String.valueOf(r103.getLevel()));
    L5:
        r101.put("danmu_level", String.valueOf(r100));
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L8;
        String r104 = "portrait";
    L9:
        r101.put("screen_layout", r104);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_send_barrage_fail", r101, new Object[]{am2.x.class, IRoom.class});
        return;
    L8:
        r104 = "landscape";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        DataCenter r101 = this.dataCenter;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r101.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L7;
        return true;
    }

    public final void cr(b30.i r100) {
        ALogger.i("CommentWidget", "receive an OpenCommentPanelEvent");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L10:
        String r101 = r100.f17136b;
        if (r101 == null) goto L13;
        this.f134751p1.a(0).f133036a = r101;
        this.G = r100.f17136b;
    L13:
        this.D = r100.f17137c;
        this.E = r100.f17138d;
        this.F = r100.f17141g;
        String r102 = r100.f17148n;
        if (r102 == null) goto L26;
        if (r102.isEmpty() == true) goto L26;
        String r103 = r100.f17148n;
        String r104 = this.F;
        int r105 = CommentUtils.f136249a;
        Intrinsics.checkNotNullParameter(r103, "hint");
        if (Intrinsics.areEqual("anchor_custom_topic_btn", r104) == false) goto L21;
        x22.a r106 = new x22.a(r103, HintType.ANCHOR_CUSTOM_TOPIC);
    L24:
        this.S = r106;
        goto L26
    L21:
        if (Intrinsics.areEqual("comment_topic_btn", r104) == false) goto L23;
        r106 = new x22.a(r103, HintType.COMMENT_TOPIC);
        goto L24
    L23:
        r106 = new x22.a(r103, HintType.NORMAL);
    L26:
        if ("lottery".equals(this.F) == false) goto L28;
        this.C.f562231i = 9;
    L28:
        OpenInputSource r107 = OpenInputSource.OpenPanelEvent;
        if (r100.f17135a == false) goto L31;
        r107 = OpenInputSource.Preview;
        this.W = r100.f17146l;
    L31:
        g92.f r108 = new g92.f(r107, r100.f17143i, r100.f17142h, null);
        r108.f480501a = r100.f17145k;
        hr(CommentEntry.OpenPanelEvent, r108);
        r100.f17139e.onCommentSuccess("", null, null);
        this.C.f562228f = null;
        return;
    L5:
        if (r100.f17144j == false) goto L10;
        if (com.bytedance.android.livesdk.interactivity.comment.utils.b.a(r100.f17141g) == false) goto L10;
        com.bytedance.android.livesdk.interactivity.comment.utils.b.b("openCommentPanel", this.f134754s);
    }

    public final void er(com.bytedance.android.livesdk.interactivity.api.base.d r100) {
        PublicScreenAreaPageType r101 = r100.f132904a;
        boolean r102 = false;
        if (r101 != PublicScreenAreaPageType.ChatChannel) goto L5;
        boolean r103 = true;
    L6:
        this.Z = r103;
        if (r101 != PublicScreenAreaPageType.Square) goto L9;
        r102 = true;
    L9:
        this.f134743k0 = r102;
        xr();
        dr();
        this.Q1.e(cc2.a.C0427a.f23135c, this.Z);
        this.P1.e(cc2.h.e.f23183c, this.f134743k0);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void gr(String r100) {
        if (this.f134752q == false) goto L5;
    L30:
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_1");
        return;
    L5:
        if (isScreenPortrait() == false) goto L30;
        if (this.f134753r.isMediaRoom() == true) goto L30;
        if (this.f134753r.isScreenshot() == true) goto L30;
        if (gd0.v.a(((Integer) this.dataCenter.get("data_link_state", 0)).intValue(), 8) == false) goto L16;
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_2");
        return;
    L16:
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.f134753r, true) == true) goto L19;
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_3");
        return;
    L19:
        IRoom r101 = this.f134753r;
        if (r101 == null) goto L26;
        if (com.bytedance.android.livesdk.interactivity.service.model.b.a(r101.getRoomAuthStatus()) == false) goto L26;
        ALogger.i("AudioCommentTag", "audio_v3_invisiable_reason_4");
        return;
    L26:
        if (TextUtils.isEmpty(r100) == true) goto L28;
        f2.c(r100, 0);
    L28:
        this.f134746m = Boolean.TRUE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void h8(Exception r100) {
        if ((r100 instanceof ApiServerException) == false) goto L23;
        ApiServerException r101 = (ApiServerException) r100;
        int r102 = r101.getErrorCode();
        if (50001 != r102) goto L8;
        Xp(true);
        IESUIUtils.displayToast(this.f134754s, r101.getPrompt());
    L22:
        Qq(r101);
        int r103 = r102;
    L24:
        HashMap r104 = new HashMap();
        r104.put("error_code", String.valueOf(r102));
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.d(EventName.ChatApiTrigger, r104);
        com.bytedance.android.livesdk.interactivity.api.monitor.a.b(r100, r103);     // Catch: Exception -> L27
        return;
    L30:
        return;
    L8:
        if (50004 != r102) goto L19;
        x22.b r105 = this.B;
        if (r105 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r106 = ((LiveInputDialogV3) r105).f135448g;
        if (r106 == null) goto L17;
        EditText r107 = r106.f135496a;
        if (r107 == null) goto L17;
        r107.setText("");
    L17:
        dismissInputDialog();
        IESUIUtils.displayToast(this.f134754s, r101.getPrompt());
        goto L22
    L16:
        this.f134751p1.a(0).f133036a = "";
        goto L17
    L19:
        if (r102 != 50019) goto L21;
        dismissInputDialog();
        b32.a.a(this.f134754s, "send_message", new d0(this), new e0(this));
        goto L22
    L21:
        IESUIUtils.displayToast(this.f134754s, r101.getPrompt());
        goto L22
    L23:
        f2.b(R.string.ttlive_live_chat_send_failed, 0);
        Logger.e("CommentWidget", "unknown exception " + r100.toString());
        r103 = -1;
        r102 = 12345;
        goto L24
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        KVData r111 = (KVData) r110;
        if (isViewValid() == false) goto L196;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.getKey() != null) goto L8;
        return;
    L8:
        if (r111.getData() == null) goto L230;
        String r100 = r111.getKey();
        r100.getClass();
        boolean r101 = true;
        int r102 = 4;
        switch(r100.hashCode()) {
            case -1836833765: goto L82;
            case -1755796428: goto L78;
            case -1679741667: goto L74;
            case -1598618410: goto L70;
            case -1548871708: goto L66;
            case -888767508: goto L62;
            case -826138222: goto L58;
            case -657921921: goto L54;
            case -526943249: goto L50;
            case 309908432: goto L46;
            case 741568604: goto L42;
            case 872172481: goto L38;
            case 912007817: goto L34;
            case 1060055221: goto L30;
            case 1723690875: goto L26;
            case 1887208196: goto L22;
            case 1939188655: goto L18;
            case 2143275606: goto L14;
            default: goto L85;
        };
    L85:
        byte r103 = -1;
    L87:
        switch(r103) {
            case 0: goto L193;
            case 1: goto L184;
            case 2: goto L182;
            case 3: goto L178;
            case 4: goto L170;
            case 5: goto L168;
            case 6: goto L159;
            case 7: goto L155;
            case 8: goto L149;
            case 9: goto L142;
            case 10: goto L141;
            case 11: goto L135;
            case 12: goto L131;
            case 13: goto L122;
            case 14: goto L115;
            case 15: goto L112;
            case 16: goto L101;
            case 17: goto L90;
            default: goto L231;
        };
    L141:
        Pq(r111);
        return;
    L142:
        boolean r112 = ((Boolean) r111.getData()).booleanValue();
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.f134753r, false) == false) goto L214;
        View r104 = this.contentView;
        if (r112 == true) goto L148;
        r102 = 0;
    L148:
        UIUtils.setViewVisibility(r104, r102);
        return;
    L214:
        return;
    L149:
        String r105 = (String) r111.getData();
        if (TextUtils.isEmpty(r105) == true) goto L235;
        e r106 = this.G1;
        if (r106 == null) goto L216;
        r106.a(r105, false, 0, false, null, null, null);
        return;
    L216:
        return;
    L235:
        return;
    L155:
        o42.f r113 = (o42.f) r111.getData();
        if (r113 == null) goto L218;
        HashMap r114 = new HashMap();
        fr(r113.f521951a, false, 0, false, r113.f521952b, -1, null, null, false, new g92.b(), r114);
        return;
    L218:
        return;
    L168:
        this.D = "live";
        this.E = null;
        hr(CommentEntry.GuideEvent, new g92.f(OpenInputSource.GuideEvent, System.currentTimeMillis(), null, null));
        return;
    L178:
        Long r115 = (Long) this.dataCenter.get(ILiveRoomPlayFragmentConstant.PRE_ENTRY_FAST_EMOJI_ID, -1L);
        if (r115.longValue() <= 0) goto L236;
        or(r115);
        return;
    L236:
        return;
    L182:
        Er((u22.m) r111.getData());
        return;
    L231:
        return;
    L90:
        if (this.f134752q == true) goto L232;
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r107 != null) goto L95;
        return;
    L95:
        if (r107.canShowCommentShareVideoOpenCloseToast() == true) goto L97;
        return;
    L97:
        if (((Boolean) r111.getData(Boolean.TRUE)).booleanValue() == false) goto L99;
        f2.c(this.context.getString(R.string.ttlive_video_comment_enable_guest), 0);
        return;
    L99:
        f2.c(this.context.getString(R.string.ttlive_video_comment_disable_guest), 0);
        return;
    L232:
        return;
    L101:
        if (((Boolean) r111.getData()).booleanValue() == false) goto L103;
    L106:
        this.contentView.setVisibility(r102);
        com.bytedance.android.livesdk.log.b0 r116 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r108 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (this.contentView.getVisibility() == 0) goto L110;
        r101 = false;
    L110:
        r108.append(r101);
        r108.append(", reason: DATA_SCREEN_RECORD_IS_OPEN");
        String r109 = r108.toString();
        r116.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r109);
        return;
    L103:
        if (this.f134757v == true) goto L106;
        r102 = 0;
        goto L106
    L112:
        if (((Boolean) r111.getData()).booleanValue() == false) goto L204;
        hr(CommentEntry.Click, new g92.f(OpenInputSource.PreviewEntryChat, System.currentTimeMillis(), null, null));
        return;
    L204:
        return;
    L115:
        if (this.f134752q == false) goto L118;
        return;
    L118:
        if (((Boolean) r111.getData(Boolean.TRUE)).booleanValue() == false) goto L120;
        gr(this.context.getString(R.string.ttlive_audio_comment_enable_audience));
        return;
    L120:
        wr(this.context.getString(R.string.ttlive_audio_comment_disable_audience));
        return;
    L122:
        if (((Boolean) r111.getData()).booleanValue() == false) goto L124;
        this.contentView.setVisibility(4);
    L125:
        com.bytedance.android.livesdk.log.b0 r117 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r118 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (this.contentView.getVisibility() == 0) goto L129;
        r101 = false;
    L129:
        r118.append(r101);
        r118.append(", reason: DATA_KEYBOARD_STATUS");
        String r119 = r118.toString();
        r117.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r119);
        return;
    L124:
        this.contentView.setVisibility(0);
        this.f134757v = false;
        goto L125
    L131:
        if (((Boolean) r111.getData()).booleanValue() == false) goto L133;
        this.contentView.setAlpha(0.5f);
        return;
    L133:
        this.contentView.setAlpha(1.0f);
        return;
    L135:
        if (this.f134753r.isLiveTypeAudio() == true) goto L138;
        return;
    L138:
        if (gd0.v.a(((Integer) r111.getData(0)).intValue(), 8) == false) goto L140;
        wr("");
        return;
    L140:
        gr("");
        return;
    L159:
        if (r111.getData() != null) goto L161;
        return;
    L161:
        if ((r111.getData() instanceof cc2.e) == false) goto L221;
        cc2.f r120 = ((cc2.e) r111.getData()).b(cc2.a.class);
        if (r120 == null) goto L165;
        this.Q1.e((cc2.a) r120.f23160a, r120.f23161b);
    L165:
        cc2.f r121 = ((cc2.e) r111.getData()).b(cc2.h.class);
        if (r121 == null) goto L222;
        this.P1.e((cc2.h) r121.f23160a, r121.f23161b);
        return;
    L222:
        return;
    L221:
        return;
    L170:
        if (((Boolean) r111.getData()).booleanValue() == false) goto L172;
        this.contentView.setVisibility(4);
    L173:
        com.bytedance.android.livesdk.log.b0 r122 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r123 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (this.contentView.getVisibility() == 0) goto L177;
        r101 = false;
    L177:
        r123.append(r101);
        r123.append(", reason: CMD_VISIBILITY_IN_DOUYIN_COMMERCE");
        String r124 = r123.toString();
        r122.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r124);
        return;
    L172:
        this.contentView.setVisibility(0);
        goto L173
    L184:
        if (((Boolean) r111.getData(Boolean.FALSE)).booleanValue() == false) goto L186;
        this.contentView.setVisibility(4);
    L187:
        com.bytedance.android.livesdk.log.b0 r125 = com.bytedance.android.livesdk.log.b0.o();
        StringBuilder r126 = new StringBuilder("CommentWidget contentView status changed, visible:");
        if (this.contentView.getVisibility() == 0) goto L191;
        r101 = false;
    L191:
        r126.append(r101);
        r126.append(", reason: CMD_HIDE_OTHER_TOOLBARBUTTON");
        String r127 = r126.toString();
        r125.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r127);
        return;
    L186:
        this.contentView.setVisibility(0);
        goto L187
    L193:
        if (this.V0 == true) goto L229;
        gr("");
        return;
    L229:
        return;
    L14:
        if (r100.equals("data_room_video_comment_share_enable") == false) goto L85;
        r103 = 17;
        goto L87
    L18:
        if (r100.equals("data_screen_record_is_open") == false) goto L85;
        r103 = 16;
        goto L87
    L22:
        if (r100.equals(ILiveRoomPlayFragmentConstant.PRE_ENTRY_OPEN_CHAT) == false) goto L85;
        r103 = 15;
        goto L87
    L26:
        if (r100.equals("data_room_audio_comment_enable") == false) goto L85;
        r103 = 14;
        goto L87
    L30:
        if (r100.equals("data_keyboard_status") == false) goto L85;
        r103 = HTTP.CR;
        goto L87
    L34:
        if (r100.equals("cmd_special_dialog_show") == false) goto L85;
        r103 = 12;
        goto L87
    L38:
        if (r100.equals("data_link_state") == false) goto L85;
        r103 = 11;
        goto L87
    L42:
        if (r100.equals("byte_cast_danmaku_mode") == false) goto L85;
        r103 = 10;
        goto L87
    L46:
        if (r100.equals("data_media_introduction_showing") == false) goto L85;
        r103 = 9;
        goto L87
    L50:
        if (r100.equals(ILiveRoomPlayFragmentConstant.PRE_ENTRY_CHAT_STRING) == false) goto L85;
        r103 = 8;
        goto L87
    L54:
        if (r100.equals("cmd_do_send_message") == false) goto L85;
        r103 = 7;
        goto L87
    L58:
        if (r100.equals("cmd_change_interactivity_component_visibility") == false) goto L85;
        r103 = 6;
        goto L87
    L62:
        if (r100.equals("cmd_start_edit") == false) goto L85;
        r103 = 5;
        goto L87
    L66:
        if (r100.equals("cmd_hide_in_douyin_commerce") == false) goto L85;
        r103 = 4;
        goto L87
    L70:
        if (r100.equals("fixed_comment_emoji_data_loaded") == false) goto L85;
        r103 = 3;
        goto L87
    L74:
        if (r100.equals("cmd_wanna_send_message") == false) goto L85;
        r103 = 2;
        goto L87
    L78:
        if (r100.equals("cmd_hide_other_toolbar") == false) goto L85;
        r103 = 1;
        goto L87
    L82:
        if (r100.equals("cmd_widget_loaded") == false) goto L85;
        r103 = 0;
        goto L87
    L230:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        long r100 = System.currentTimeMillis();
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.f134753r, true) == true) goto L26;
        IRoom r101 = this.f134753r;
        if (r101 == null) goto L22;
        IRoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 == null) goto L22;
        IRoomAuthStatus.IRoomAuthSpecialStyle r103 = r102.getRoomAuthSpecialStyle();
        if (r103 == null) goto L22;
        IRoomAuthStatusStyle r104 = r103.getChatStyle();
        if (r104 == null) goto L22;
        if (r104.getUnableStyle() != 1) goto L22;
        String r105 = r104.getContent();
        if (r105 == null) goto L22;
        if (r105.length() <= 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 != true) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L26;
        f2.c(com.bytedance.android.livesdk.interactivity.comment.utils.f.c(this.f134753r), 0);
        return;
    L19:
        r106 = false;
    L22:
        r107 = false;
    L26:
        int r111 = r110.getId();
        if (r111 == R.id.edit_btn_audience) goto L36;
        if (r111 == R.id.ogc_fixed_comment_hint) goto L36;
        if (r111 != R.id.iv_danmaku_switch) goto L34;
        jr();
        return;
    L34:
        if (r111 != R.id.emoji_entry) goto L41;
        this.V = Long.valueOf(System.currentTimeMillis());
        nr();
        hr(CommentEntry.Click, new g92.f(OpenInputSource.EmojiExpose, r100, DefaultLandingPanel.Emoji.getPanel(), null));
        return;
    L41:
        return;
    L36:
        this.V = Long.valueOf(System.currentTimeMillis());
        nr();
        this.D = "live";
        hr(CommentEntry.Click, new g92.f(OpenInputSource.ClickCommentBox, r100, null, null));
        if (r111 != R.id.ogc_fixed_comment_hint) goto L43;
        HashMap r112 = new HashMap();
        r112.put("operate_type", "click");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_shortcut_message_icon", r112, new Object[]{new am2.x(), IRoom.class});
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onEnterClear(int r100) {
        if (r100 != 4) goto L5;
    L8:
        View r101 = this.contentView;
        if (r101 == null) goto L11;
        r101.setVisibility(8);
    L11:
        p7 r102 = com.bytedance.android.livesdk.performance.p.f154756a;
        if (r102.enable == true) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L20;
        return;
    L20:
        if (r100 != 2) goto L27;
        View r104 = this.contentView;
        if (r104 != null) goto L24;
        return;
    L24:
        if (2 == r104.getLayerType()) goto L29;
        this.contentView.setLayerType(2, null);
        ALogger.i(LiveRecyclableWidget.ALOG_TAG_WIDGET, "CommentWidget Set LAYER_TYPE_HARDWARE");
        return;
    L29:
        return;
    L27:
        return;
    L14:
        if (r102.commentWidgetEnable == false) goto L16;
        r103 = true;
        goto L17
    L5:
        if (r100 == 16) goto L8;
        if (r100 != 32) goto L11;
        goto L8
    }

    public void onEvent(u22.g r110) {
        if (r110.f548419a != 0) goto L62;
        IBaseUser r100 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().y();
        IRoom r101 = this.f134753r;
        if (r101 == null) goto L8;
        long r102 = r101.getId();
    L9:
        Intrinsics.checkNotNullParameter(r110, "event");
        com.bytedance.android.live.base.model.message.k0 r103 = (com.bytedance.android.live.base.model.message.k0) vh7.f.c(com.bytedance.android.live.base.model.message.k0.class);
        long r104 = new Random().nextInt(10000000);
        com.bytedance.android.live.base.model.message.m0 r105 = (com.bytedance.android.live.base.model.message.m0) vh7.f.c(com.bytedance.android.live.base.model.message.m0.class);
        r105.setRoomId(r102);
        r105.setShowMsg(true);
        r105.setMessageId(r104);
        r105.setMethod("WebcastChatMessage");
        Unit r106 = Unit.INSTANCE;
        r103.setBaseMessage(r105);
        r103.setGiftImage(r110.f548422d);
        a5 r107 = r110.f548421c;
        IBaseUser r108 = null;
        if (r107 == null) goto L47;
        List<c5> r109 = r107.getPieces();
        if (r109 == null) goto L47;
        if ((!r109.isEmpty()) == true) goto L17;
        r109 = null;
    L17:
        if (r109 == null) goto L47;
        Iterator<T> r111 = r109.iterator();
    L20:
        if (r111.hasNext() == false) goto L41;
        Object r112 = r111.next();
        i5 r113 = ((c5) r112).getUserValue();
        if (r113 == null) goto L24;
        IBaseUser r114 = r113.getUser();
    L25:
        IMiddlewareUserService r115 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r115 == null) goto L30;
        com.bytedance.android.livesdk.user.e r116 = r115.user();
        if (r116 == null) goto L30;
        String r117 = r116.n();
    L31:
        if (r114 == null) goto L38;
        if (r117 == null) goto L38;
        if ((!Intrinsics.areEqual(r117, "0")) == false) goto L38;
        if (TextUtils.equals(r114.getIdString(), r117) == false) goto L38;
        boolean r118 = true;
    L39:
        if (r118 == false) goto L20;
    L42:
        c5 r119 = (c5) r112;
        if (r119 == null) goto L47;
        i5 r120 = r119.getUserValue();
        if (r120 == null) goto L47;
        r108 = r120.getUser();
    L38:
        r118 = false;
    L30:
        r117 = null;
        goto L31
    L24:
        r114 = null;
        goto L25
    L41:
        r112 = null;
    L47:
        r103.setContent(r110.f548420b);
        if (r108 == null) goto L51;
        r100 = r108;
    L51:
        r103.setUserInfo(r100);
        r103.setMessageMethod("WebcastChatMessage");
        r103.setChatId(r104);
        HashMap r121 = new HashMap();
        r121.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE, this.f134756u);
        String r122 = r110.f548420b;
        if (r122 != null) goto L55;
        r122 = "";
    L55:
        A20(new com.bytedance.android.livesdk.event.d0(r122, ISendCommentEvent.Sender.CommentWidget, r121, null, null, false), r103);
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onExitClear(int r100) {
        if (r100 != 4) goto L5;
    L8:
        View r101 = this.contentView;
        if (r101 == null) goto L11;
        r101.setVisibility(0);
    L11:
        p7 r102 = com.bytedance.android.livesdk.performance.p.f154756a;
        if (r102.enable == true) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L20;
        return;
    L20:
        if (r100 != 2) goto L27;
        View r104 = this.contentView;
        if (r104 != null) goto L24;
        return;
    L24:
        if (2 != r104.getLayerType()) goto L29;
        this.contentView.setLayerType(0, null);
        ALogger.i(LiveRecyclableWidget.ALOG_TAG_WIDGET, "CommentWidget Set LAYER_TYPE_NONE");
        return;
    L29:
        return;
    L27:
        return;
    L14:
        if (r102.commentWidgetEnable == false) goto L16;
        r103 = true;
        goto L17
    L5:
        if (r100 == 16) goto L8;
        if (r100 != 32) goto L11;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object... r100) {
        this.f134752q = ((Boolean) this.dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.f134753r = (IRoom) this.dataCenter.get("data_room", null);
        this.f134760x = gb2.a.c(this.dataCenter, true);
        this.f134756u = (String) this.dataCenter.get("log_enter_live_source");
        this.f134754s = (Activity) this.context;
        this.f134762y = new CommentPresenter();
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = l42.a.f507332s;
        Integer r102 = Integer.valueOf(this.f134764z);
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        Sq();
        Rq();
        if (LiveInfraSettingKeys.LIVE_XML_AND_DRAWABLE_CACHE_CONFIG.getValue().a() == true) goto L9;
    L6:
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget onInit");
        return;
    L9:
        JatoOptDrawableCache.preloadDrawableCache(this.context.getResources(), new int[]{R.drawable.ttlive_comment_emoji_entry});     // Catch: Exception -> L8
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v49, types: [com.bytedance.android.livesdk.interactivity.comment.m0] */
    /* JADX WARN: Type inference failed for: r3v51, types: [android.view.View$OnLayoutChangeListener, com.bytedance.android.livesdk.interactivity.comment.f0] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.android.livesdk.interactivity.comment.i0] */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object... r110) {
        if (this.f134753r != null) goto L5;
        return;
    L5:
        if (this.contentView == null) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f134760x = gb2.a.c(this.dataCenter, true);
        long r100 = System.currentTimeMillis();
        this.contentView.setAlpha(1.0f);
        String r111 = s1.B(R.string.ttlive_say_something_big_size);
        this.f134729a.setText(r111);
        x22.c r101 = this.C;
        r101.getClass();
        r101.f562225c = new x22.a(r111, HintType.NORMAL);
        IRoom r112 = (IRoom) this.dataCenter.get("data_room");
        this.f134753r = r112;
        if (this.f134737g1 == false) goto L21;
        Room r113 = (Room) r112;
        if (r113 == null) goto L21;
        if (r113.getRoomInteractData() == null) goto L21;
        if (r113.getRoomInteractData().getLowPcuGuideData() == null) goto L21;
        LowPcuGuideData r114 = r113.getRoomInteractData().getLowPcuGuideData();
        int r102 = r114.status;
        if (r102 != 1) goto L19;
        this.T = r114.guideText;
        this.U = true;
        goto L21
    L19:
        if (r102 != 2) goto L21;
        this.U = false;
    L21:
        Rq();
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).changeDrawCleanScreen(this.dataCenter, this.containerView, this.f134753r);
        CommentUtils.c(this.f134753r, this.dataCenter);
        ((HashSet) this.f134744k1).add(this.f134751p1);
        com.bytedance.android.livesdk.interactivity.comment.t r115 = new com.bytedance.android.livesdk.interactivity.comment.t(new i0(this), this.dataCenter);
        this.f134758v1 = r115;
        ((HashSet) this.f134744k1).add(r115);
        Iterator r116 = ((HashSet) this.f134744k1).iterator();
    L23:
        if (r116.hasNext() == false) goto L25;
        ((t22.a) r116.next()).onLoad();
        goto L23
    L25:
        this.f134752q = ((Boolean) this.dataCenter.get("data_is_anchor")).booleanValue();
        this.f134756u = (String) this.dataCenter.get("log_enter_live_source");
        this.f134754s = (Activity) this.context;
        this.f134762y.g0(this);
        TextView r117 = this.f134729a;
        if (r117 != 0) goto L28;
    L31:
        runWithRoomVisible(new a(this));
        this.M1 = new b(this);
        if (getRoomContextService() == null) goto L37;
        if (getRoomContextService().getRoomDataContext(this.dataCenter, 0).B2() == null) goto L37;
        getRoomContextService().getRoomDataContext(this.dataCenter, 0).B2().c(new n0(this));
    L37:
        if (this.f134742k != null) goto L39;
    L52:
        this.Z = false;
        this.f134743k0 = false;
    L53:
        xr();
        if (this.f134760x == true) goto L63;
        if (this.L == null) goto L63;
        if (ur() == false) goto L63;
        if (this.L.f136280e == l42.a.f507320g.getValue().booleanValue()) goto L63;
        this.L.a();
        Dr();
    L63:
        if (Lq() == null) goto L65;
        xr();
        dr();
        this.f134728J.add(Lq().getFixedCommentTips().subscribe(new q0(this)));
        this.f134728J.add(Lq().getQuickComment().subscribe(new r0(this)));
    L65:
        Nq();
        this.f134735f = (RelativeLayout) findViewById(R.id.fl_danmaku_container);
        ALogger.i("Comment_preload", "loadDanmukuSetting::::  isPortrait " + this.f134760x + "   dataCenter" + this.dataCenter.hashCode() + this.f134735f + " widget : " + hashCode());
        if (this.f134760x == false) goto L72;
        RelativeLayout r118 = this.f134735f;
        if (r118 == null) goto L72;
        r118.setVisibility(8);
        View r119 = this.f134749p;
        if (r119 == null) goto L72;
        r119.setVisibility(8);
    L72:
        View r120 = this.f134733d;
        if (r120 == null) goto L80;
        r3.c(r120, s1.B(R.string.ttlive_a11y_barrage_setting_btn), true);
        this.f134733d.setOnClickListener(new d1(this));
        if (Cq().booleanValue() == false) goto L79;
        RedDotView r121 = this.f134734e;
        if (r121 == null) goto L79;
        r121.setVisibility(0);
    L79:
        this.f134734e.setVisibility(8);
    L80:
        long r103 = System.currentTimeMillis();
        z32.c.c(InputConstantNode.InputLoadTime, String.valueOf(r103 - r100));
        long r104 = ((Long) this.dataCenter.get("user_enter_room_start_time", -1L)).longValue();
        if (r104 <= 0) goto L83;
        z32.c.c(InputConstantNode.InputShowCostTime, String.valueOf(r103 - r104));
    L83:
        IRoom r122 = this.f134753r;
        if (r122 != null) goto L86;
    L93:
        TextView r123 = this.f134729a;
        if (r123 == null) goto L96;
        com.bytedance.android.live.core.utils.a1.m(r123, s1.f(12.0f));
        com.bytedance.android.live.core.utils.a1.n(this.f134729a, s1.f(10.0f));
    L96:
        UIUtils.setViewVisibility(this.f134741j, 8);
    L97:
        Boolean r124 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.f133632a;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a(this.f134753r) == false) goto L105;
        if (this.f134760x == false) goto L105;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter) == null) goto L105;
        ALogger.i("AICloneTag", "wait for manager init");
        com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).getAiCloneManager().c(new s0(this));
    L105:
        if (this.V0 == false) goto L110;
        gr("");
        return;
    L110:
        return;
    L86:
        if (this.f134741j == null) goto L93;
        boolean r105 = y62.a.f566322a;
        if (y62.a.a(r122, this.f134760x) == false) goto L93;
        UIUtils.setViewVisibility(this.f134741j, 0);
        if (y62.a.f566324c.b() == false) goto L92;
        MainThreadPostUtils.c(this.L1, y62.a.f566327f);
        goto L97
    L92:
        this.L1.run();
        goto L97
    L39:
        if (this.dataContext == null) goto L52;
        if (isScreenPortrait() == false) goto L52;
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L45;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getChannelGreetingManager(this.dataContext, new o0(this));
    L45:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r125 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a(getRoomContext(), this.dataCenter);
        if (r125 == null) goto L48;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r126 = r125.getState();
    L49:
        if (r126 == null) goto L51;
        this.Z = r126.getValue().f132904a.equals(PublicScreenAreaPageType.ChatChannel);
        this.f134743k0 = r126.getValue().f132904a.equals(PublicScreenAreaPageType.Square);
        this.f134728J.add(r126.a().subscribe(new p0(this)));
        er(r126.getValue());
        goto L53
    L51:
        this.Z = false;
        this.f134743k0 = false;
        goto L53
    L48:
        r126 = null;
        goto L49
    L28:
        if (this.f134731b1 == false) goto L30;
        ?? r106 = new f0(this);
        this.N = r106;
        r117.addOnLayoutChangeListener(r106);
        goto L31
    L30:
        this.M = new m0(this);
        r117.getViewTreeObserver().addOnGlobalLayoutListener(this.M);
        goto L31
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget
    public final void onRoomVisible(boolean r100) {
        super.onRoomVisible(r100);
    }

    public final void or(Long r110) {
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.f134753r, false) == true) goto L12;
        String r100 = ec2.n.f472039a.getValue().e();
        if (r100 != null) goto L7;
    L8:
        r100 = s1.B(R.string.ttlive_cannot_comment_msg_opt);
    L9:
        f2.c(r100, 0);
        this.dataCenter.put(ILiveRoomPlayFragmentConstant.PRE_ENTRY_FAST_EMOJI_ID, -1L);
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
    L12:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter) != null) goto L14;
        return;
    L14:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).getQuickCommentManager() != null) goto L16;
        return;
    L16:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).getQuickCommentManager().getValue() == null) goto L61;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r101 = com.bytedance.android.livesdk.interactivity.api.i.a(this.dataContext, this.dataCenter).getQuickCommentManager().getValue().getOGCFixedChatInfo();
        if (r101 != null) goto L20;
        return;
    L20:
        if (CollectionUtils.isEmpty(r101.fixedEmojiList) == true) goto L63;
        Iterator<com.bytedance.android.livesdk.interactivity.api.quickcomment.a> r102 = r101.fixedEmojiList.iterator();
    L23:
        if (r102.hasNext() == false) goto L64;
        if (r102.next().f133748id != r110.longValue()) goto L23;
        this.dataCenter.put(ILiveRoomPlayFragmentConstant.PRE_ENTRY_FAST_EMOJI_ID, -1L);
        Iterator r103 = ((HashSet) this.f134739h1).iterator();
        CommentFlowContext r104 = null;
    L28:
        if (r103.hasNext() == false) goto L32;
        r104 = ((y22.e) r103.next()).b(CommentEntry.GuideEvent, null);
        if (r104 == null) goto L28;
    L32:
        if (this.C.f562223a == false) goto L40;
        if (r104 == null) goto L37;
        CommentInputConfig r105 = r104.f133051d;
        if (r105 == null) goto L37;
        boolean r106 = r105.f133074m;
    L38:
        if (r106 == true) goto L40;
        return;
    L37:
        r106 = false;
    L40:
        long r107 = r110.longValue();
        ISendCommentEvent.Sender r108 = ISendCommentEvent.Sender.CommentWidget;
        if (y22.b.b(new com.bytedance.android.livesdk.event.c0(r107, 0, false, r108, new HashMap(), r104, null)) == true) goto L42;
        CommentPresenter r109 = this.f134762y;
        if (r109 == null) goto L23;
        r109.o0(new com.bytedance.android.livesdk.event.b0(r110.longValue(), r108, new HashMap(), r104));
        return;
    L42:
        ALogger.i("CommentWidget", "sendEmojiMessage true by flowContext:" + r104.toString());
        return;
    L64:
        return;
    L63:
        return;
    }

    @Override // s22.c.a
    public final void q7(boolean r100) {
        if (r100 == false) goto L4;
        this.S1.e(cc2.j.b.f23197c, true);
    L5:
        xr();
        return;
    L4:
        this.S1.e(cc2.j.b.f23197c, false);
        goto L5
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void rI(Exception r100) {
        if ((r100 instanceof ApiServerException) == false) goto L12;
        ApiServerException r101 = (ApiServerException) r100;
        int r102 = r101.getErrorCode();
        if (50001 != r102) goto L8;
        Xp(true);
        IESUIUtils.displayToast(this.f134754s, r101.getPrompt());
    L11:
        Qq(r101);
        return;
    L8:
        if (50005 != r102) goto L10;
        f2.c(r101.getPrompt(), 0);
        goto L11
    L10:
        IESUIUtils.displayToast(this.f134754s, r101.getPrompt());
        goto L11
    L12:
        f2.b(R.string.ttlive_live_chat_send_failed, 0);
        Logger.e("CommentWidget", "unknown exception " + r100.toString());
    }

    public final void vr(g92.f r100) {
        if (r100.f480502b != OpenInputSource.Preview) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        IMiddlewareLiveService r102 = (IMiddlewareLiveService) jc1.k.f(IMiddlewareLiveService.class);
        if (r102 == null) goto L16;
        ICurrentInteractionUiAction r103 = r102.getCurrentInteractionUiAction();
        if (r103 == null) goto L17;
        IRoom r104 = this.f134753r;
        if (r104 == null) goto L18;
        r103.showInteractionAndEnterRoom(r104.getIdStr());
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void wr(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        f2.c(r100, 0);
    L5:
        Boolean r101 = Boolean.FALSE;
        this.f134745l = r101;
        this.f134746m = r101;
        x22.c r102 = this.C;
        if (r102 == null) goto L9;
        r102.getClass();
        return;
    }

    public void yr(boolean r100) {
        if (this.f134730b == null) goto L70;
        boolean r101 = Tq();
        j40.a1 r102 = j40.a1.f497165a;
        boolean r103 = r102.getValue().c();
        int r104 = R.drawable.ttlive_bg_edit_message_land_new;
        int r105 = 8;
        Drawable r106 = null;
        if (r103 == false) goto L27;
        if (this.f134760x == true) goto L27;
        View r107 = this.f134730b;
        if (r100 == false) goto L13;
        if (r101 == true) goto L13;
        Drawable r108 = null;
    L16:
        r107.setBackground(r108);
        View r109 = this.f134749p;
        if (r109 == null) goto L23;
        if (r100 == false) goto L21;
        if (r101 == true) goto L21;
    L22:
        r109.setVisibility(r105);
    L21:
        r105 = 0;
    L23:
        View r110 = this.f134732c;
        if (r110 == null) goto L71;
        r110.setBackground(null);
        return;
    L71:
        return;
    L13:
        if (Yq() == false) goto L15;
        r104 = R.drawable.ttlive_bg_edit_message_alpha_30;
    L15:
        r108 = s1.m(r104);
    L27:
        if (r102.getValue().d() == true) goto L29;
    L50:
        View r111 = this.f134733d;
        if (r111 == null) goto L53;
        r111.setVisibility(8);
    L53:
        View r112 = this.f134730b;
        if (r100 == false) goto L57;
        Drawable r113 = null;
    L60:
        r112.setBackground(r113);
        View r114 = this.f134749p;
        if (r114 == null) goto L66;
        if (r100 == true) goto L65;
        r105 = 0;
    L65:
        r114.setVisibility(r105);
    L66:
        View r115 = this.f134732c;
        if (r115 == null) goto L75;
        r115.setBackground(null);
        return;
    L75:
        return;
    L57:
        if (Yq() == false) goto L59;
        r104 = R.drawable.ttlive_bg_edit_message_alpha_30;
    L59:
        r113 = s1.m(r104);
        goto L60
    L29:
        if (this.f134760x == true) goto L50;
        this.f134730b.setBackground(null);
        View r116 = this.f134733d;
        if (r116 != null) goto L33;
    L37:
        View r117 = this.f134732c;
        if (r117 == null) goto L47;
        if (r100 == false) goto L43;
        if (r101 == true) goto L43;
    L46:
        r117.setBackground(r106);
    L43:
        if (Yq() == false) goto L45;
        r104 = R.drawable.ttlive_bg_edit_message_alpha_30;
    L45:
        r106 = s1.m(r104);
    L47:
        View r118 = this.f134749p;
        if (r118 == null) goto L73;
        r118.setVisibility(8);
        return;
    L73:
        return;
    L33:
        if ((r116.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L37;
        RelativeLayout.LayoutParams r119 = (RelativeLayout.LayoutParams) this.f134733d.getLayoutParams();
        if (r119 == null) goto L37;
        r119.leftMargin = s1.f(10.0f);
        goto L37
    }

    public void onEvent(e3 r100) {
        CommentWidgetAnimator r101 = this.L;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.f571822c != 2) goto L7;
        return;
    L7:
        if (r101.f136280e != l42.a.f507320g.getValue().booleanValue()) goto L9;
        return;
    L9:
        jr();
    }

    public void onEvent(u22.m r100) {
        Er(r100);
    }

    public static void ar(g92.f r100, String r101) {
        com.bytedance.android.livesdk.interactivity.api.monitor.b.c(r100.f480502b.getSource(), false, r101, null, null, null);
    }

    public static void zq(CommentWidget r110, u22.m.a r111) {
        r110.getClass();
        if (r111 == null) goto L34;
        int r100 = r111.f548445b;
        String r101 = "1";
        if (r100 != 2) goto L17;
        HashMap r112 = new HashMap(1);
        r112.put("user_id", ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n());
        r112.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r111.f548447d));
        if (r111.f548446c == false) goto L10;
        Object r102 = "1";
    L11:
        r112.put(IPerformanceManager.Params.is_anchor, r102);
        if (r111.f548455l == true) goto L15;
        r101 = "0";
    L15:
        r112.put("vs_is_official_comment", r101);
        r112.putAll(r111.f548451h);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_long_press_message", r112, new Object[]{IRoom.class, am2.x.class});
        r112.put("trigger_type", com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_at_reply", r112, new Object[]{IRoom.class, am2.x.class});
        return;
    L10:
        r102 = "0";
        goto L11
    L17:
        if (r100 == 3) goto L19;
        return;
    L19:
        if ("0".equals(com.bytedance.android.live.core.utils.a0.n(r110.dataCenter).getOwnerUserIdString()) == false) goto L21;
        String r113 = "";
    L22:
        boolean r114 = TextUtils.equals(r113, r111.f548447d);
        HashMap r103 = new HashMap(1);
        r103.put("user_id", ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n());
        r103.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r111.f548447d));
        if (r114 == false) goto L25;
        String r115 = "anchor";
    L26:
        r103.put("user_type", r115);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_card_click_at", r103, new Object[]{IRoom.class, am2.x.class});
        r103.put("trigger_type", "profile_at");
        if (r114 == true) goto L30;
        r101 = "0";
    L30:
        r103.put(IPerformanceManager.Params.is_anchor, r101);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_at_reply", r103, new Object[]{IRoom.class, am2.x.class});
        return;
    L25:
        r115 = SourceType.DEFAULT;
        goto L26
    L21:
        r113 = com.bytedance.android.live.core.utils.a0.n(r110.dataCenter).getOwnerUserIdString();
        goto L22
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void A20(com.bytedance.android.livesdk.event.d0 r100, com.bytedance.android.live.base.model.message.k0 r101) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.U == false) goto L8;
        this.U = false;
        xr();
    L8:
        x22.b r102 = this.B;
        if (r102 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r103 = ((LiveInputDialogV3) r102).f135448g;
        if (r103 == null) goto L17;
        EditText r104 = r103.f135496a;
        if (r104 == null) goto L17;
        r104.setText("");
    L17:
        if ((this.f134754s instanceof FragmentActivity) == false) goto L22;
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L22;
        ((IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class)).checkBindHelpShow((FragmentActivity) this.f134754s, "live_comment");
    L22:
        if (r101.getContentSelfSeeStatus() != 0) goto L24;
        CommentUtils.a(r101, this.dataCenter);
    L24:
        xs2.b.a().post(new u22.i(r101));
        mr(r100, new u(r101));
        IInteractivityInjectService r105 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r105 == null) goto L28;
        r105.onMessageSendSuccess((Room) this.dataCenter.get("data_room", null));
        return;
    L28:
        return;
    L15:
        this.f134751p1.a(0).f133036a = "";
        goto L17
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void EH(String r100, int r101) {
        if (r101 != 1) goto L6;
        this.T = r100;
        this.U = true;
    L8:
        xr();
        return;
    L6:
        if (r101 != 2) goto L8;
        this.U = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void R10(com.bytedance.android.livesdk.event.c0 r100, com.bytedance.android.live.base.model.message.v0 r101) {
        r101.setLocalInsertMsg(true);
        if (this.U == false) goto L6;
        this.U = false;
        xr();
    L6:
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter) == null) goto L8;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter).B(r101);
    L8:
        HashMap<String, String> r102 = new HashMap();
        if (r101.mo8266getEmojiId() == null) goto L24;
        r102.put("emoji_id", r101.mo8266getEmojiId().toString());
        if (r100.f123330c != 0) goto L13;
        String r103 = "4:3";
    L14:
        r102.put("emoji_scale", r103);
        String r104 = "1";
        if (r100.f123331d == false) goto L17;
        String r105 = "1";
    L18:
        r102.put("is_new", r105);
        if (this.f134752q == true) goto L22;
        r104 = "0";
    L22:
        r102.put(IPerformanceManager.Params.is_anchor, r104);
        goto L24
    L17:
        r105 = "0";
        goto L18
    L13:
        r103 = "3:1";
    L24:
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L26;
        String r106 = "horizontal";
    L27:
        r102.put("room_orientation", r106);
        if (l42.a.f507334u.getValue().booleanValue() == false) goto L30;
        String r107 = "vip_page";
    L31:
        r102.put("request_page", r107);
        Map<String, String> r108 = r100.f123335h;
        if (r108 == null) goto L34;
        r102.putAll(r108);
    L34:
        r102.put("livevip_status", k6.a());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_livevip_emoji_send", r102, new Object[]{IRoom.class, am2.x.class});
        HashMap<String, String> r109 = new HashMap();
        Map<String, String> r110 = r100.f123335h;
        if (r110 == null) goto L38;
        r109.putAll(r110);
    L38:
        if (this.f134753r == null) goto L40;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(this.dataCenter, r102);
    L40:
        x22.a r111 = this.C.f562225c;
        if (r111 == null) goto L43;
        r109.put("default_text", r111.f562221a);
        r109.put("default_text_type", this.C.f562225c.getType().getTypeName());
    L43:
        Aq(r109);
        r109.put("content_type", "member_emoji");
        Bq(r102);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_live_message", r109, new Object[]{IRoom.class, am2.x.class});
        return;
    L30:
        r107 = "comment";
        goto L31
    L26:
        r106 = "vertical";
        goto L27
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Vh(Exception r110, com.bytedance.android.livesdk.event.y r111) {
        int r100 = r111.f123378b;
        if ((r110 instanceof ApiServerException) == false) goto L40;
        ApiServerException r112 = (ApiServerException) r110;
        int r101 = r112.getErrorCode();
        if (50001 != r101) goto L8;
        Xp(true);
        IESUIUtils.displayToast(this.f134754s, r112.getPrompt());
    L38:
        Qq(r112);
    L45:
        Zq(r100);
        return;
    L8:
        if (50004 != r101) goto L10;
    L29:
        x22.b r113 = this.B;
        if (r113 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r114 = ((LiveInputDialogV3) r113).f135448g;
        if (r114 == null) goto L37;
        EditText r115 = r114.f135496a;
        if (r115 == null) goto L37;
        r115.setText("");
    L37:
        dismissInputDialog();
        IESUIUtils.displayToast(this.f134754s, r112.getPrompt());
        goto L38
    L36:
        this.f134751p1.a(0).f133036a = "";
        goto L37
    L10:
        if (50014 == r101) goto L29;
        if (80074 == r101) goto L29;
        if (40001 != r101) goto L26;
        String r102 = r112.getPrompt();
        Object r116 = r111.f123380d.get("money");     // Catch: Throwable -> L21
        Objects.requireNonNull(r116);     // Catch: Throwable -> L21
        long r103 = ((Long) r116).longValue();     // Catch: Throwable -> L21
        boolean r117 = com.bytedance.android.live.revenue.core.util.h.f91037a;     // Catch: Throwable -> L21
        long r104 = r103 - ((com.bytedance.android.live.recharge.k) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class)).rechargeCenter().getAvailableDiamonds();
        if (r104 > 0) goto L24;
    L23:
        r104 = 1;
    L24:
        f2.c(r102, 0);
        x2.a r118 = new x2.a();
        r118.f572017a = 1;
        Intrinsics.checkNotNullParameter("live_detail", "<set-?>");
        r118.f572018b = "live_detail";
        r118.f572021e = r104;
        Intrinsics.checkNotNullParameter("danmu", "<set-?>");
        r118.f572019c = "danmu";
        xs2.b.a().post(r118.a());
    L21:
        th = move-exception;
        ALogger.e("CommentWidget", "failed to calculate lackDiamond in handleMoneyNotEnough", th);
        goto L23
    L26:
        if (r101 != 50019) goto L28;
        dismissInputDialog();
        b32.a.a(this.f134754s, "send_barrage", new b0(this), new c0(this));
        goto L38
    L28:
        ExceptionUtils.handleException(getContext(), r112);
        goto L38
    L40:
        if ((r110 instanceof SendPrivilegeBarrageException) == true) goto L42;
        f2.h(this.context, R.string.ttlive_live_danmaku_send_failed, 0);
        Logger.d("CommentWidget", "unknown exception " + r110.toString());
        goto L45
    L42:
        if (((SendPrivilegeBarrageException) r110).getReason() != 1) goto L45;
        xs2.b.a().post(new u22.m());
        goto L45
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Y30(CommentFlowContext r100, tlc.d r101) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        long r102 = r100.f133059l;
        x22.b r103 = this.B;
        if (r103 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r104 = ((LiveInputDialogV3) r103).f135448g;
        if (r104 == null) goto L13;
        EditText r105 = r104.f135496a;
        if (r105 == null) goto L13;
        r105.setText("");
    L13:
        Intrinsics.checkNotNullParameter(r101, "result");
        r100.f133048a = CommentFlowContext.State.Success;
        r100.f133056i = r101;
        y22.e r106 = r100.f133049b;
        if (r106 == null) goto L16;
        r106.c(r100);
    L16:
        int r107 = y22.c.f565704a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r108 = new StringBuilder("[");
        r108.append(r100.hashCode());
        r108.append("] success, type is ");
        Object r109 = r100.f133056i;
        String r110 = null;
        if ((r109 instanceof tlc.d) == true) goto L19;
        r109 = null;
    L19:
        tlc.d r111 = (tlc.d) r109;
        if (r111 == null) goto L22;
        r110 = r111.getMessageMethod();
    L22:
        r108.append(r110);
        ALogger.i("CommentFlowContext", r108.toString());
        return;
    L12:
        this.f134751p1.a(r102).f133036a = "";
        goto L13
    }

    public final Boolean br(u22.m r100, Boolean r101) {
        if (isScreenPortrait() == true) goto L14;
        if (l42.a.f507320g.getValue().booleanValue() == false) goto L14;
        if (r100.f548442m != 0) goto L14;
        if (r101.booleanValue() == false) goto L12;
        f2.b(R.string.ttlive_at_in_landscape_block_tip, 0);
    L12:
        return Boolean.TRUE;
    L14:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void cI(CommentFlowContext r100, Exception r101) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        r100.getClass();
        r100.f133048a = CommentFlowContext.State.Failed;
        r100.f133057j = r101;
        y22.e r102 = r100.f133049b;
        if (r102 == null) goto L8;
        r102.d(r100);
    L8:
        int r103 = y22.c.f565704a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("CommentFlowContext", "[" + r100.hashCode() + "] failed ");
        if ((r101 instanceof ApiServerException) == false) goto L11;
        String r104 = ((ApiServerException) r101).getPrompt();
    L12:
        if (r104 != null) goto L15;
        r104 = s1.B(R.string.ttlive_live_chat_send_failed);
    L15:
        f2.c(r104, 0);
        if ((r101 instanceof ApiServerException) == false) goto L19;
        int r105 = ((ApiServerException) r101).getErrorCode();     // Catch: Exception -> L22
    L20:
        com.bytedance.android.livesdk.interactivity.api.monitor.a.b(r101, r105);     // Catch: Exception -> L22
        return;
    L19:
        r105 = -1;
    L25:
        return;
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void cT(com.bytedance.android.livesdk.event.x r100, kc2.a r101) {
        CommentUtils.a(r101, this.dataCenter);
        if (this.U == false) goto L5;
        this.U = false;
        xr();
    L5:
        HashMap<String, String> r102 = new HashMap();
        String r103 = "1";
        if (this.f134752q == false) goto L8;
        String r104 = "1";
    L9:
        r102.put(IPerformanceManager.Params.is_anchor, r104);
        r102.put("is_voice", String.valueOf(1));
        if (r101.isResend == false) goto L12;
        String r105 = "resend";
    L13:
        r102.put("send_type", r105);
        r102.put("duration", String.valueOf(r101.audioDuration));
        r102.put(EventConstant.Key.RETAIN_PROMPT, r101.content);
        r102.put("comment_id", r101.msgId);
        if (b6.X.getValue().booleanValue() == false) goto L16;
        String r106 = "1";
    L17:
        r102.put("is_screen_clear", r106);
        r102.put("connection_type", ((IInteractService) jc1.k.f(IInteractService.class)).getLinkConnectionType());
        boolean r107 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        r102.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getLinkAnchorCount());
        if (com.bytedance.android.livesdk.utils.landscape.e.b(this.f134752q, this.f134753r) == true) goto L20;
        String r108 = "1";
    L21:
        r102.put("if_danmu", r108);
        if (com.bytedance.android.livesdk.interactivity.api.p.a() == true) goto L25;
        r103 = "0";
    L25:
        r102.put("is_comment_inter_flow", r103);
        IInteractivityInjectService r109 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r109 == null) goto L28;
        r102.put("is_vr_machine", r109.getVrMachineLogStr(this.dataCenter));
        r109.appendCastSDKLogCommonParams(r102);
    L28:
        r3.m(r102, this.context);
        r102.put("content_length", "0");
        r102.put("at_user_id", "null");
        if (this.f134753r == null) goto L32;
        if (r109 == null) goto L32;
        r109.buildVsRoomLog(this.dataCenter, r102);
    L32:
        Aq(r102);
        Bq(r102);
        x22.a r110 = this.C.f562225c;
        if (r110 == null) goto L35;
        r102.put("default_text", r110.f562221a);
        r102.put("default_text_type", this.C.f562225c.getType().getTypeName());
    L35:
        com.bytedance.android.livesdk.log.j0 r111 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r112 = new am2.x();
        r112.f4349a = "live_interact";
        r111.sendLog("audience_live_message", r102, new Object[]{am2.u.class, r112, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        Boolean r113 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r100, "is_from_click_event", r113)).booleanValue() == false) goto L38;
        z32.c.b(InputValueNode.SendAudioSuccess);
    L38:
        if (r109 == null) goto L41;
        r109.onMessageSendSuccess((Room) this.dataCenter.get("data_room", null));
        return;
    L41:
        return;
    L20:
        r108 = "0";
        goto L21
    L16:
        r106 = "0";
        goto L17
    L12:
        r105 = "success";
        goto L13
    L8:
        r104 = "0";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void f30(Exception r100, kc2.a r101) {
        if ((r100 instanceof ApiServerException) == false) goto L13;
        ApiServerException r102 = (ApiServerException) r100;
        int r103 = r102.getErrorCode();
        if (r103 != 50005) goto L10;
        if (TextUtils.isEmpty(r102.getPrompt()) == true) goto L10;
        f2.c(r102.getPrompt(), 0);
    L10:
        if (50001 != r103) goto L12;
        Xp(true);
        IESUIUtils.displayToast(this.f134754s, r102.getPrompt());
        goto L13
    L12:
        IESUIUtils.displayToast(this.f134754s, r102.getPrompt());
    L13:
        CommentUtils.a(r101, this.dataCenter);
        HashMap<String, String> r104 = new HashMap();
        String r105 = "1";
        if (this.f134752q == false) goto L16;
        String r106 = "1";
    L17:
        r104.put(IPerformanceManager.Params.is_anchor, r106);
        r104.put("is_voice", String.valueOf(1));
        if (r101.isResend == false) goto L20;
        String r107 = "resend";
    L21:
        r104.put("send_type", r107);
        r104.put("duration", String.valueOf(r101.audioDuration));
        if (b6.X.getValue().booleanValue() == false) goto L24;
        String r108 = "1";
    L25:
        r104.put("is_screen_clear", r108);
        r104.put("connection_type", ((IInteractService) jc1.k.f(IInteractService.class)).getLinkConnectionType());
        boolean r109 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        r104.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getLinkAnchorCount());
        if (com.bytedance.android.livesdk.utils.landscape.e.b(this.f134752q, this.f134753r) == false) goto L29;
        r105 = "0";
    L29:
        r104.put("if_danmu", r105);
        r104.put("is_vr_machine", ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getVrMachineLogStr(this.dataCenter));
        r104.put("content_length", "0");
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L32;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r104);
    L32:
        r3.m(r104, this.context);
        r104.put("at_user_id", "null");
        if (this.f134753r == null) goto L35;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(this.dataCenter, r104);
    L35:
        Aq(r104);
        Bq(r104);
        com.bytedance.android.livesdk.log.j0 r110 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r111 = new am2.x();
        r111.f4349a = "live_interact";
        r110.sendLog("audience_live_message", r104, new Object[]{am2.u.class, r111, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        return;
    L24:
        r108 = "0";
        goto L25
    L20:
        r107 = "fail";
        goto L21
    L16:
        r106 = "0";
        goto L17
    }

    public final Boolean hr(CommentEntry r110, g92.f r111) {
        OpenInputSource r100 = r111.f480502b;
        if (r100 == null) goto L8;
        String r101 = r100.getSource();
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r102 = com.bytedance.android.livesdk.interactivity.api.monitor.b.f133316a;
        Intrinsics.checkNotNullParameter(r101, "source");
        if (com.bytedance.android.livesdk.interactivity.api.monitor.b.f133316a.monitorTryShow == false) goto L8;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("source", r101);
        Unit r104 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r105 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r103, 7);
        r105.a(InteractivityMonitor.Event.InputPanelRequestShow);
        r105.b(InteractivityTraceMonitor.Event.InputPanelRequestShow);
    L8:
        Iterator r106 = ((HashSet) this.f134739h1).iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        CommentFlowContext r107 = ((y22.e) r106.next()).b(r110, r111.f480505e);
        if (r107 == null) goto L10;
    L15:
        if (r107 == null) goto L32;
        Iterator r108 = ((HashSet) this.f134739h1).iterator();
    L18:
        if (r108.hasNext() == false) goto L23;
        if (((y22.e) r108.next()).e(r107) == false) goto L18;
        return Boolean.FALSE;
    L23:
        r107.f133048a = CommentFlowContext.State.Input;
        y22.e r109 = r107.f133049b;
        if (r109 == null) goto L26;
        CommentInputConfig r112 = r109.a(r107);
    L27:
        r107.f133051d = r112;
        int r113 = y22.c.f565704a;
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r114 = new StringBuilder("[");
        r114.append(r107.hashCode());
        r114.append("] input, config is ");
        CommentInputConfig r115 = r107.f133051d;
        if (r115 == null) goto L30;
        String r116 = r115.toString();
    L31:
        r114.append(r116);
        ALogger.i("CommentFlowContext", r114.toString());
        goto L32
    L30:
        r116 = null;
        goto L31
    L26:
        r112 = null;
    L32:
        OpenInputSource r117 = r111.f480502b;
        OpenInputSource r118 = OpenInputSource.EmojiExpose;
        boolean r119 = true;
        boolean r120 = false;
        if (r117 != r118) goto L35;
        boolean r121 = true;
    L36:
        this.f134761x1 = r121;
        if (CommentEntry.Click != r110) goto L39;
        boolean r122 = true;
    L40:
        Boolean r123 = Boolean.valueOf(r122);
        this.H = r123;
        if (r123.booleanValue() == false) goto L43;
        z32.c.b(InputValueNode.ClickComment);
    L43:
        boolean r124 = this.H.booleanValue();
        if (this.B == null) goto L46;
    L307:
        vr(r111);
        ar(r111, "view invalid");
    L308:
        r119 = false;
    L310:
        return Boolean.valueOf(r119);
    L46:
        if (this.isViewValid == false) goto L307;
        if (this.f134753r.isMergeVSRoom() == true) goto L51;
    L57:
        IRoom r125 = this.f134753r;
        if (r125 != null) goto L60;
    L69:
        IMiddlewareUserService r126 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r126 == null) goto L78;
        if (r126.user().isLogin() == true) goto L75;
        Bundle r127 = new Bundle();
        com.bytedance.android.livesdk.user.e r128 = r126.user();
        Context r129 = this.context;
        com.bytedance.android.livesdk.user.l.a r130 = new com.bytedance.android.livesdk.user.l.a();
        r130.f158685a = s1.B(R.string.ttlive_core_login_dialog_message);
        r130.f158688d = "comment_live";
        r130.f158687c = -1;
        r130.f158692h = r127;
        r130.f158689e = "";
        r128.login(r129, new com.bytedance.android.livesdk.user.l(r130)).compose(getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.NotLogin.getReason());
        vr(r111);
        ar(r111, "not login");
        goto L308
    L75:
        if (r126.user().g(LiveInteractFunction.COMMENT) == false) goto L78;
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.UserCenterIntercept.getReason());
        vr(r111);
        ar(r111, "user center intercept");
    L78:
        if (this.f134752q == true) goto L153;
        IRoom r131 = this.f134753r;
        if (r131 == null) goto L86;
        IRoomAuthStatus r132 = r131.getRoomAuthStatus();
        if (r132 == null) goto L86;
        IRoomAuthStatus.IRoomAuthSpecialStyle r133 = r132.getRoomAuthSpecialStyle();
        if (r133 == null) goto L86;
        IRoomAuthStatusStyle r134 = r133.getChatStyle();
    L87:
        if (r134 == null) goto L89;
        boolean r135 = true;
    L90:
        if (r135 == false) goto L153;
        IRoomAuthStatusStyle r136 = this.f134753r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle();
        IRoom r137 = this.f134753r;
        if (r137 != null) goto L94;
    L98:
        long r138 = -1;
    L99:
        com.bytedance.android.livesdk.log.b0 r139 = com.bytedance.android.livesdk.log.b0.o();
        String r140 = "Check Anchor Comment Switch Disable, FollowStatus:" + r138 + " AnchorSwitch:" + r136.getAnchorSwitch();
        r139.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", r140);
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.a(this.f134753r) == true) goto L125;
        IBaseUser r141 = (IBaseUser) this.dataCenter.get("data_user_in_room", null);
        if (r141 != null) goto L106;
        r141 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b();
    L106:
        if (r141.getIdString().equals(this.f134753r.getAnchorId()) == true) goto L125;
        if (r136.getAnchorSwitch() != 1) goto L112;
    L124:
        boolean r142 = true;
    L126:
        if (r142 == false) goto L135;
        if (r107 == null) goto L131;
        CommentInputConfig r143 = r107.f133051d;
        if (r143 == null) goto L131;
        boolean r144 = r143.f133075n;
    L132:
        if (r144 == true) goto L135;
        IESUIUtils.displayToast(this.f134754s, com.bytedance.android.livesdk.interactivity.comment.utils.f.c(this.f134753r));
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.SpecialStyle.getReason());
        vr(r111);
        ar(r111, "special style intercept");
    L131:
        r144 = false;
    L135:
        if (this.f134753r.isMergeVSRoom() == false) goto L137;
    L139:
        boolean r145 = false;
    L141:
        if (this.f134753r.isMergeVSRoom() == true) goto L143;
    L145:
        if (r145 == false) goto L153;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r146 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter);
        PaidSceneEnum r147 = PaidSceneEnum.PAID_ROOM;
        if (r146.e1(r147) == true) goto L153;
        String r148 = this.f134753r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().getContentForPaidLive();
        if (TextUtils.isEmpty(r148) == false) goto L151;
        r148 = s1.B(R.string.ttlive_paid_live_buy_ticket_tips);
    L151:
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).k2(r147, new HashMap(), true, null);
        f2.c(r148, 0);
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.NotPaid.getReason());
        vr(r111);
        ar(r111, "vs paid live intercept");
        goto L308
    L143:
        if (this.f134753r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().getAnchorSwitchForPaidLive() != 2) goto L145;
        r145 = true;
        goto L145
    L137:
        if (this.f134753r.getRoomAuthStatus().getRoomAuthSpecialStyle().getChatStyle().getAnchorSwitchForPaidLive() == 1) goto L139;
        r145 = true;
        goto L141
    L112:
        if (r136.getAnchorSwitch() != 3) goto L119;
        if (r138 == 2) goto L119;
        if (r138 != 3) goto L124;
    L119:
        if (r136.getAnchorSwitch() != 5) goto L125;
        if (r138 == 2) goto L125;
        if (r138 != 1) goto L124;
    L125:
        r142 = false;
        goto L126
    L94:
        if (r137.getOwner() == null) goto L98;
        if (this.f134753r.getOwner().getFollowInfo() == null) goto L98;
        r138 = this.f134753r.getOwner().getFollowInfo().getFollowStatus();
        goto L99
    L89:
        r135 = false;
    L86:
        r134 = null;
    L153:
        if (this.C.f562223a == false) goto L161;
        if (r107 == null) goto L158;
        CommentInputConfig r149 = r107.f133051d;
        if (r149 == null) goto L158;
        boolean r150 = r149.f133074m;
    L159:
        if (r150 == true) goto L161;
        IESUIUtils.displayToast(this.f134754s, R.string.ttlive_live_user_text_banned);
        ALogger.i("CommentWidget", "user ban");
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.UserBan.getReason());
        vr(r111);
        ar(r111, "user banned");
    L158:
        r150 = false;
    L161:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r151 = Lq();
        if (r151 == null) goto L199;
        IRoom r152 = this.f134753r;
        if (r152 == null) goto L199;
        if (r152.isMergeVSRoom() == false) goto L168;
    L170:
        boolean r153 = false;
    L172:
        if (this.f134753r.isMergeVSRoom() == false) goto L179;
        if (r151.isFixedComment() == false) goto L179;
        if (r151.isOGCFixedComment() == true) goto L179;
        r153 = true;
    L179:
        if (this.f134753r.isMergeVSRoom() == true) goto L181;
    L185:
        boolean r154 = false;
    L187:
        if (this.f134753r.isMergeVSRoom() == true) goto L189;
    L193:
        boolean r155 = false;
    L195:
        if (this.f134753r.isMergeVSRoom() == true) goto L197;
    L201:
        boolean r156 = this.f134760x;
        if (r156 == false) goto L205;
        if (r154 == false) goto L205;
        IESUIUtils.displayToast(this.f134754s, s1.B(R.string.ttlive_fix_hot_comment_empty_toast));
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.VS.getReason());
        vr(r111);
        ar(r111, "fix comment empty");
    L205:
        if (r156 == false) goto L211;
        if (r153 == false) goto L211;
        if (y22.b.a(r107) == true) goto L211;
        IESUIUtils.displayToast(this.f134754s, r151.getFixCommentToast());
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.VS.getReason());
        vr(r111);
        ar(r111, "fix comment intercept");
    L211:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).F0(PaidInteractEntry.CONTROL_ENTRY_COMMENT) == true) goto L214;
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.NotPaid.getReason());
        vr(r111);
        ar(r111, "not paid");
        goto L308
    L214:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter) == true) goto L216;
    L226:
        this.f134757v = true;
        this.dataCenter.put("data_pre_show_keyboard", Boolean.TRUE);
        IRoom r157 = this.f134753r;
        if (r157 != null) goto L229;
    L231:
        IRoom r158 = this.f134753r;
        if (r158 != null) goto L234;
    L241:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r159 = Lq();
        this.C.f562227e = null;
        if (r159 == null) goto L257;
        List<IQuickCommentShowWord> r160 = r159.getCurrentQuickComment(this.f134760x);
        if (CollectionUtils.isEmpty(r160) == true) goto L257;
        if (r107 == null) goto L249;
        CommentInputConfig r161 = r107.f133051d;
        if (r161 == null) goto L249;
        CommentInputConfig.State r162 = r161.f133078q;
    L251:
        if (r162 == CommentInputConfig.State.ForeClose) goto L253;
        boolean r163 = true;
    L254:
        if (r163 == false) goto L257;
        this.C.f562227e = new LinkedList();
        this.C.f562227e.addAll(r160);
        goto L257
    L253:
        r163 = false;
    L249:
        r162 = null;
    L257:
        if (this.C == null) goto L266;
        this.f134745l.booleanValue();
        x22.c r164 = this.C;
        r164.f562228f = r111.f480504d;
        DataContext r165 = getRoomContext();
        int r166 = CommentUtils.f136249a;
        if (r165 == null) goto L264;
        IInteractService r167 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r167 == null) goto L264;
        boolean r168 = r167.canShowCommentShareVideoButton();
    L265:
        r164.f562229g = r168;
    L264:
        r168 = false;
    L266:
        x22.a r169 = this.S;
        if (r169 == null) goto L269;
        this.C.f562225c = r169;
    L270:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r170 = Fq(this.C, r107, r111);
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r171 = r170.f135419g;
        if (r111.f480502b != r118) goto L273;
        boolean r172 = true;
    L274:
        r171.f135381q = r172;
        if (r124 == false) goto L277;
        r171.f135377m = this.V;
    L277:
        r171.f135383s = r124;
        if (isScreenPortrait() == false) goto L280;
        int r173 = LivePortraitInputDialogV3.L;
        Intrinsics.checkNotNullParameter(r170, "attrs");
        LivePortraitInputDialogV3 r174 = new LivePortraitInputDialogV3();
        r174.f135445d = r170;
        r174.f135449h = r107;
        this.B = r174;
    L281:
        ((LiveInputDialogV3) this.B).f135451j = this.dataCenter;
        if (r155 == false) goto L284;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r175 = Fq(this.C, r107, r111);
        int r176 = OGCFixedInputDialog.D;
        Intrinsics.checkNotNullParameter(r175, "attrs");
        OGCFixedInputDialog r177 = new OGCFixedInputDialog();
        r177.f135445d = r175;
        r177.f135449h = r107;
        this.B = r177;
        r177.f135451j = this.dataCenter;
    L284:
        x22.b r178 = this.B;
        ((LiveInputDialogV3) r178).f135446e = this.G1;
        Activity r179 = this.f134754s;     // Catch: IllegalStateException -> L306
        LiveInputDialogV3 r180 = (LiveInputDialogV3) r178;     // Catch: IllegalStateException -> L306
        r180.getClass();     // Catch: IllegalStateException -> L306
        if (r179 == null) goto L305;
        FragmentManager r181 = ((FragmentActivity) r179).getSupportFragmentManager();     // Catch: IllegalStateException -> L306
        LandscapeRestrictionOperation r182 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L306
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r180, "INPUT", r182);     // Catch: IllegalStateException -> L306
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r181, r180, r182) == false) goto L312;
    L292:
        if (r124 == false) goto L294;
        z32.c.b(InputValueNode.DialogPopup);     // Catch: IllegalStateException -> L306
    L294:
        IVSPlayerService r183 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);     // Catch: IllegalStateException -> L306
        if (r183 == null) goto L299;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r184 = r183.provideVSPlayerViewControlService(this.dataCenter);     // Catch: IllegalStateException -> L306
        if (r184 == null) goto L299;
        r184.setVisibilityStatus(false);     // Catch: IllegalStateException -> L306
    L299:
        lr(r111, r107);     // Catch: IllegalStateException -> L306
        if (r111.f480502b != OpenInputSource.Preview) goto L302;
        r120 = true;
    L302:
        if (r120 == false) goto L310;
        ((IMiddlewareLiveService) jc1.k.f(IMiddlewareLiveService.class)).getCurrentInteractionUiAction().showInteractionMask(this.f134753r.getIdStr());     // Catch: IllegalStateException -> L306
        goto L310
    L312:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L311
    L291:
        r180.show(r181, "INPUT");     // Catch: IllegalStateException -> L306
        goto L292
    L305:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");     // Catch: IllegalStateException -> L306
    L306:
        this.B = null;
        ar(r111, "state loss exception");
        goto L310
    L280:
        int r185 = LiveLandscapeInputDialogV3.A;
        Intrinsics.checkNotNullParameter(r170, "attrs");
        LiveLandscapeInputDialogV3 r186 = new LiveLandscapeInputDialogV3();
        r186.f135445d = r170;
        r186.f135449h = r107;
        this.B = r186;
        goto L281
    L273:
        r172 = false;
        goto L274
    L269:
        x22.a r187 = Jq(this.f134729a.getMeasuredWidth(), this.f134729a.getPaint(), false);
        this.S = r187;
        this.C.f562225c = r187;
        goto L270
    L234:
        if (r158.allowGift() == true) goto L241;
        String r188 = s1.B(R.string.ttlive_broadcast_disable_send_gift_msg);
        if (this.f134753r.getRoomAuthStatus().getOffReason() != null) goto L238;
    L240:
        this.C.f562226d = r188;
        goto L241
    L238:
        if (TextUtils.isEmpty(this.f134753r.getRoomAuthStatus().getOffReason().getGift()) == true) goto L240;
        r188 = this.f134753r.getRoomAuthStatus().getOffReason().getGift();
        goto L240
    L229:
        if (r157.getRoomAuthStatus() == null) goto L231;
        this.C.f562224b = this.f134753r.getRoomAuthStatus().getEnableDanmaku();
        goto L231
    L216:
        if (this.f134760x == true) goto L226;
        if (l42.a.f507320g.getValue().booleanValue() == false) goto L226;
        if (r107 == null) goto L223;
        CommentInputConfig r189 = r107.f133051d;
        if (r189 == null) goto L223;
        boolean r190 = r189.f133077p;
    L224:
        if (r190 == true) goto L226;
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.LandscapeBlock.getReason());
        vr(r111);
        ar(r111, "landscape block");
    L223:
        r190 = false;
        goto L224
    L197:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(this.f134753r.getRoomAuthStatus()) == true) goto L201;
    L200:
        r155 = false;
        goto L201
    L189:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(this.f134753r.getRoomAuthStatus()) == false) goto L193;
        if (y22.b.a(r107) == true) goto L193;
        r155 = true;
        goto L195
    L181:
        if (com.bytedance.android.livesdk.interactivity.service.model.b.b(this.f134753r.getRoomAuthStatus()) == false) goto L185;
        if (r151.isOGCFixedCommentEmpty() == false) goto L185;
        r154 = true;
        goto L187
    L168:
        if (r151.isFixedComment() == false) goto L170;
        r153 = true;
    L199:
        r153 = false;
        r154 = false;
        goto L200
    L60:
        if (r125.getRoomAuthStatus() == null) goto L69;
        if (this.f134753r.getRoomAuthStatus().getEnableChat() == true) goto L69;
        String r191 = ec2.n.f472039a.getValue().e();
        if (r191 != null) goto L66;
    L67:
        r191 = s1.B(R.string.ttlive_cannot_comment_msg_opt);
    L68:
        f2.c(r191, 0);
        z32.c.a(InputDescNode.CommentInterceptReason, PanelPopupFailed.CommentClose.getReason());
        vr(r111);
        ar(r111, "room auth close");
        goto L308
    L66:
        if (r191.isEmpty() == false) goto L68;
    L51:
        if (isScreenPortrait() == false) goto L57;
        IVSPlayerService r192 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r192 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r193 = r192.provideVSPlayerViewControlService(this.dataCenter);
        if (r193 == null) goto L57;
        r193.setVisibilityStatus(false);
        goto L57
    L39:
        r122 = false;
        goto L40
    L35:
        r121 = false;
        goto L36
    L14:
        r107 = null;
        goto L15
    }

    public final void lr(g92.f r110, CommentFlowContext r111) {
        HashMap r100 = new HashMap();
        r100.put("request_page", this.D);
        u22.m.a r101 = this.I;
        if (r101 != null) goto L5;
    L14:
        String r102 = this.E;
        if (r102 == null) goto L20;
        if (r102.equals(IPerformanceManager.MODULE_BARRAGE) == false) goto L20;
        r100.put("comment_carnival_trigger_type", this.D);
    L20:
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L23;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r100);
    L23:
        if (this.f134752q == false) goto L25;
        r100.put("user_type", "anchor");
        r100.put(IPerformanceManager.Params.is_anchor, "1");
    L33:
        IRoom r103 = this.f134753r;
        if (r103 == null) goto L36;
        r100.put("audience_type", r103.getAudienceType());
    L36:
        x22.a r104 = this.C.f562225c;
        if (r104 == null) goto L40;
        r100.put("default_text", r104.f562221a);
        r100.put("default_text_type", this.C.f562225c.getType().getTypeName());
    L40:
        if (r110.f480502b != OpenInputSource.Preview) goto L42;
        boolean r112 = true;
    L43:
        if (r112 == false) goto L50;
        String r113 = this.W;
        if (r113 == null) goto L50;
        if (r113.isEmpty() == true) goto L50;
        r100.put("guide_text", this.W);
        r100.put("request_source", "preview_guide");
    L50:
        if (r111 != null) goto L53;
        r100.put(ShareConstants.KEY_PANEL_TYPE, "default");
    L55:
        com.bytedance.android.livesdk.log.j0.l().sendLog("comment_pannel_show", r100, new Object[]{new am2.x(), IRoom.class});
        return;
    L53:
        if (r111.f133050c != CommentScene.SquareChat) goto L55;
        r100.put(ShareConstants.KEY_PANEL_TYPE, "square");
        goto L55
    L42:
        r112 = false;
        goto L43
    L25:
        r100.put(IPerformanceManager.Params.is_anchor, "0");
        if (jc1.k.f(IMiddlewareUserService.class) == null) goto L33;
        if (((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().q() == null) goto L33;
        if (((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().q().isAdmin() == false) goto L32;
        r100.put("user_type", UserGroupScene.DEFAULT_NAME_SPACE);
        goto L33
    L32:
        r100.put("user_type", "user");
        goto L33
    L5:
        if (r101.f548446c == false) goto L7;
        Object r105 = "1";
    L8:
        r100.put(IPerformanceManager.Params.is_anchor, r105);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(this.I.f548447d));
        long r106 = this.I.f548449f;
        if (r106 <= 0) goto L12;
        r100.put("from_comment_id", String.valueOf(r106));
    L12:
        if (((HashMap) this.I.f548450g).isEmpty() == true) goto L14;
        r100.putAll(this.I.f548450g);
        goto L14
    L7:
        r105 = "0";
        goto L8
    }

    public final void mr(com.bytedance.android.livesdk.event.d0 r210, t r310) {
        HashMap<String, String> r100 = new HashMap();
        String r101 = "0";
        if (this.f134752q == false) goto L5;
        String r102 = "1";
    L6:
        r100.put(IPerformanceManager.Params.is_anchor, r102);
        com.bytedance.android.live.profit.lottery.i r103 = yt0.c.f();
        if (r103 == null) goto L13;
        com.bytedance.android.live.profit.lottery.g r104 = r103.getCurrentLottery().getValue();
        if (r104 == null) goto L13;
        if ((r104.getState() instanceof LotteryState.g) == false) goto L13;
        r100.put("lottery_id", String.valueOf(((LotteryState.g) r104.getState()).f88032a.f88194a));
    L13:
        String r105 = this.E;
        if (r105 == null) goto L19;
        if (r105.equals(IPerformanceManager.MODULE_BARRAGE) == false) goto L19;
        r100.put("comment_carnival_trigger_type", this.D);
    L19:
        if (TextUtils.isEmpty(this.E) == true) goto L21;
        r100.put("message_source", this.E);
        this.E = null;
    L21:
        IRoom r106 = this.f134753r;
        if (r106 == null) goto L413;
        int r107 = com.bytedance.android.live.core.utils.h1.f66189a;
        r100.put("live_type", i1.a(r106.getStreamType()));
        r100.putAll(com.bytedance.android.live.core.utils.h1.a(this.f134753r));
    L413:
        r100.put("comment_id", String.valueOf(r310.getChatId()));     // Catch: Exception -> L28
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, this.f134755t);     // Catch: Exception -> L28
        if (TextUtils.isEmpty(this.f134753r.getSourceType()) == true) goto L30;
        r100.put("moment_room_source", this.f134753r.getSourceType());     // Catch: Exception -> L28
    L30:
        boolean r108 = !Lists.isEmpty(ab2.a.d(r310.getContent()));
        if (r108 == false) goto L33;
        String r110 = "1";
    L34:
        r100.put("with_emoji", r110);
        if (r108 == false) goto L41;
        if (this.f134761x1 == false) goto L39;
        r100.put("emoji_send_entrance_pattern", "live_emoji");
        goto L41
    L39:
        r100.put("emoji_send_entrance_pattern", "comment_keyboard_emoji");
    L41:
        if (r210.f123338b.equals(ISendCommentEvent.Sender.Lottery) == false) goto L43;
        String r109 = "lottery";
    L44:
        r100.put("request_page", r109);
        Iterator<Map.Entry<String, Object>> r111 = r210.f123339c.entrySet().iterator();
    L46:
        if (r111.hasNext() == false) goto L51;
        Map.Entry<String, Object> r112 = r111.next();
        if ((r112.getValue() instanceof String) == false) goto L46;
        r100.put(r112.getKey(), (String) r112.getValue());
        goto L46
    L51:
        if (r100.containsKey("is_shortcut_message") == true) goto L53;
        r100.put("is_shortcut_message", "0");
    L53:
        String r113 = this.D;
        if (r113 == null) goto L75;
        if (this.I == null) goto L75;
        r100.put("request_page", r113);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(this.I.f548447d));
        if (TextUtils.isEmpty(this.I.f548452i) == true) goto L60;
        r100.put("webcast_to_user_id", this.I.f548452i);
    L60:
        String r114 = r210.f123337a;
        String r115 = this.I.f548448e;
        if (TextUtils.isEmpty(r114) == false) goto L63;
    L67:
        boolean r116 = false;
    L68:
        if (r116 == false) goto L70;
        String r117 = "0";
    L71:
        r100.put("is_modify", r117);
        long r118 = this.I.f548449f;
        if (r118 <= 0) goto L75;
        r100.put("from_comment_id", String.valueOf(r118));
        goto L75
    L70:
        r117 = "1";
        goto L71
    L63:
        if (TextUtils.isEmpty(r115) == true) goto L67;
        if (r114.contains(r115) == false) goto L67;
        r116 = true;
    L75:
        if (InteractGameContext.isAnchorPlayingGame() == false) goto L77;
        String r119 = "1";
    L78:
        r100.put("is_gaming", r119);
        if (b6.X.getValue().booleanValue() == false) goto L81;
        String r120 = "1";
    L82:
        r100.put("is_screen_clear", r120);
        Long r121 = com.bytedance.android.livesdk.interactivity.comment.utils.e.f136256a;
        Intrinsics.checkNotNullParameter(r210, "event");
        Intrinsics.checkNotNullParameter(r100, "map");
        com.bytedance.android.livesdk.event.m r122 = r210.f123340d;
        if (r122 == null) goto L96;
        List<com.bytedance.android.livesdk.event.n> r123 = r122.f123350a;
        if (r123 == null) goto L96;
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r123.iterator();
    L88:
        if (r125.hasNext() == false) goto L97;
        ImageSpan r126 = ((com.bytedance.android.livesdk.event.n) r125.next()).f123357f;
        if ((r126 instanceof com.bytedance.android.livesdk.interactivity.comment.input.a) == true) goto L92;
        r126 = null;
    L92:
        com.bytedance.android.livesdk.interactivity.comment.input.a r127 = (com.bytedance.android.livesdk.interactivity.comment.input.a) r126;
        if (r127 == null) goto L88;
        r124.add(r127);
    L97:
        if (r124 != null) goto L99;
    L102:
        boolean r128 = true;
    L103:
        if (r128 == true) goto L105;
        String r129 = "activity_emoji";
    L106:
        com.bytedance.android.livesdk.event.m r130 = r210.f123340d;
        if (r130 == null) goto L124;
        List<com.bytedance.android.livesdk.event.n> r131 = r130.f123350a;
        if (r131 == null) goto L124;
        List<com.bytedance.android.livesdk.event.n> r132 = r131;
        if ((r132 instanceof Collection) == true) goto L113;
    L115:
        Iterator<T> r133 = r132.iterator();
    L117:
        if (r133.hasNext() == false) goto L121;
        if ((((com.bytedance.android.livesdk.event.n) r133.next()).f123357f instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == false) goto L117;
        boolean r134 = true;
    L122:
        if (r134 != true) goto L124;
        r129 = r129.concat("|fusion");
    L121:
        r134 = false;
        goto L122
    L113:
        if (r132.isEmpty() == false) goto L115;
    L124:
        com.bytedance.android.livesdk.event.m r135 = r210.f123340d;
        if (r135 == null) goto L142;
        List<com.bytedance.android.livesdk.event.n> r136 = r135.f123350a;
        if (r136 == null) goto L142;
        List<com.bytedance.android.livesdk.event.n> r137 = r136;
        if ((r137 instanceof Collection) == true) goto L131;
    L133:
        Iterator<T> r138 = r137.iterator();
    L135:
        if (r138.hasNext() == false) goto L139;
        if ((((com.bytedance.android.livesdk.event.n) r138.next()).f123357f instanceof com.bytedance.android.livesdk.interactivity.comment.input.d) == false) goto L135;
        boolean r139 = true;
    L140:
        if (r139 != true) goto L142;
        r129 = r129 + "|quick_interaction";
    L139:
        r139 = false;
        goto L140
    L131:
        if (r137.isEmpty() == false) goto L133;
    L142:
        if (r124 == null) goto L146;
        com.bytedance.android.livesdk.interactivity.comment.input.a r140 = (com.bytedance.android.livesdk.interactivity.comment.input.a) CollectionsKt.firstOrNull(r124);
        if (r140 == null) goto L146;
        r100.put("emoji_group_id", String.valueOf(r140.f135143f.getActivityEmojiGroupId()));
    L146:
        r100.put("content_type", r129);
        MiddlewareRoomContext r141 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r141 == null) goto L153;
        com.bytedance.live.datacontext.i<Boolean> r142 = r141.isAnchor();
        if (r142 == null) goto L153;
        if (r142.getValue().booleanValue() != true) goto L153;
        String r143 = "1";
    L154:
        r100.put(IPerformanceManager.Params.is_anchor, r143);
        com.bytedance.android.livesdk.event.m r144 = r210.f123340d;
        if (r144 == null) goto L168;
        List<com.bytedance.android.livesdk.event.n> r145 = r144.f123350a;
        if (r145 == null) goto L168;
        ArrayList r146 = new ArrayList();
        Iterator<T> r147 = r145.iterator();
    L160:
        if (r147.hasNext() == false) goto L167;
        ImageSpan r148 = ((com.bytedance.android.livesdk.event.n) r147.next()).f123357f;
        if ((r148 instanceof com.bytedance.android.livesdk.interactivity.comment.input.d) == true) goto L164;
        r148 = null;
    L164:
        com.bytedance.android.livesdk.interactivity.comment.input.d r149 = (com.bytedance.android.livesdk.interactivity.comment.input.d) r148;
        if (r149 == null) goto L160;
        r146.add(r149);
        goto L160
    L167:
        com.bytedance.android.livesdk.interactivity.comment.input.d r150 = (com.bytedance.android.livesdk.interactivity.comment.input.d) CollectionsKt.firstOrNull(r146);
    L170:
        if (r150 != null) goto L172;
    L176:
        MiddlewareRoomContext r151 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r151 == null) goto L183;
        com.bytedance.live.datacontext.n<mk> r152 = r151.getCurStatMessage();
        if (r152 == null) goto L183;
        mk r153 = r152.getValue();
        if (r153 == null) goto L183;
        Long r154 = Long.valueOf(r153.getTotal());
    L184:
        r100.put("audience_count", String.valueOf(r154));
        ArrayList r155 = new ArrayList();
        ArrayList r156 = new ArrayList();
        com.bytedance.android.livesdk.event.m r157 = r210.f123340d;
        if (r157 == null) goto L212;
        List<com.bytedance.android.livesdk.event.n> r158 = r157.f123350a;
        if (r158 == null) goto L212;
        ArrayList r159 = new ArrayList();
        Iterator<T> r160 = r158.iterator();
    L190:
        if (r160.hasNext() == false) goto L195;
        Object r161 = r160.next();
        if ((((com.bytedance.android.livesdk.event.n) r161).f123357f instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == false) goto L190;
        r159.add(r161);
        goto L190
    L195:
        Iterator r162 = r159.iterator();
    L197:
        if (r162.hasNext() == false) goto L212;
        ImageSpan r163 = ((com.bytedance.android.livesdk.event.n) r162.next()).f123357f;
        if ((r163 instanceof com.bytedance.android.livesdk.interactivity.comment.input.c) == true) goto L201;
        r163 = null;
    L201:
        com.bytedance.android.livesdk.interactivity.comment.input.c r164 = (com.bytedance.android.livesdk.interactivity.comment.input.c) r163;
        if (r164 == null) goto L197;
        com.bytedance.android.livesdk.interactivity.api.emoji.a r165 = r164.f135150g;
        if (r165 == null) goto L197;
        String r166 = r165.c();
        if (r166 != null) goto L208;
        r166 = "";
    L208:
        r155.add(r166);
        List<String> r167 = r165.e();
        if (r167 == null) goto L197;
        r156.addAll(r167);
    L212:
        if ((!r155.isEmpty()) == false) goto L215;
        r100.put("fusion", CollectionsKt.joinToString$default(r155, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
        r100.put("original_emoji_list", CollectionsKt.joinToString$default(r156, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
    L215:
        if (this.f134753r.getAutoCover() != 0) goto L217;
    L221:
        int[] r168 = i.f134779a;
        HashMap<String, List<String>> r169 = u22.f.f548418a;
        Intrinsics.checkNotNullParameter(r210, "event");
        Object r170 = r210.f123339c.get("quickCommentType");
        if ((r170 instanceof QuickCommentTypeEnum) == true) goto L224;
        r170 = null;
    L224:
        QuickCommentTypeEnum r171 = (QuickCommentTypeEnum) r170;
        if (r171 != null) goto L227;
        r171 = QuickCommentTypeEnum.DEFAULT;
    L227:
        int r172 = r168[r171.ordinal()];
        if (r172 == 1) goto L232;
        if (r172 == 2) goto L231;
        r100.put(EventConstant.Key.RETAIN_PROMPT, r210.f123337a);
    L233:
        int r173 = x22.f.f562235a;
        Map<String, Object> r174 = r210.f123339c;
        if (r174 == null) goto L239;
        Object r175 = r174.get("paste_edit_method");
        if (r175 == null) goto L239;
        String r176 = r175.toString();
        if (r176 == null) goto L239;
    L240:
        r100.put("paste_edit_method", r176);
        r100.put("is_voice", "0");
        if (u22.f.f(r210) == false) goto L243;
        String r177 = "1";
    L244:
        r100.put("is_from_voice_pannel", r177);
        r100.put("connection_type", ((IInteractService) jc1.k.f(IInteractService.class)).getLinkConnectionType());
        boolean r178 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        r100.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getLinkAnchorCount());
        String r179 = r310.getContent();
        int r180 = CommentUtils.f136249a;
        if (r179 != null) goto L411;
    L265:
        boolean r181 = false;
    L266:
        if (r181 == false) goto L268;
        String r182 = "1";
    L269:
        r100.put("is_only_emoji", r182);
        if (r310.getLandscapeAreaCommon() != null) goto L272;
    L274:
        IRoom r183 = this.f134753r;
        if (r183 != null) goto L277;
    L279:
        com.bytedance.android.livesdk.event.m r184 = r210.f123340d;
        if (r184 == null) goto L282;
        r100.put("related_emoji_type", r184.f123351b);
    L282:
        Object r185 = r210.f123339c.get("comment_send_params");
        if ((r185 instanceof g92.b) == false) goto L305;
        g92.b r186 = (g92.b) r185;
        long r187 = r186.f480487a;
        if (r187 <= 0) goto L287;
        r100.put("send_duration", String.valueOf(r187));
    L287:
        long r188 = r186.f480489c;
        if (r188 <= 0) goto L291;
        r100.put("association_show_send_duration", String.valueOf(r188));
    L291:
        if (r186.f480490d == false) goto L293;
        z32.c.b(InputValueNode.SendChatSuccess);
    L293:
        String r189 = r186.f480495i;
        if (r189 == null) goto L296;
        r100.put("tag_id", r189);
    L296:
        String r190 = r186.f480494h;
        if (r190 == null) goto L300;
        r100.put("tag_text", r190);
    L300:
        if (r186.f480493g <= 0) goto L305;
        if (TextUtils.isEmpty(r186.f480492f) == true) goto L305;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, String.valueOf(r186.f480493g));
        r100.put("question_text", r186.f480492f);
    L305:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(this.f134752q, this.f134753r) == true) goto L307;
        String r191 = "1";
    L308:
        r100.put("if_danmu", r191);
        if (com.bytedance.android.livesdk.interactivity.api.p.a() == false) goto L311;
        String r192 = "1";
    L312:
        r100.put("is_comment_inter_flow", r192);
        if (r310.a().booleanValue() == false) goto L315;
        String r193 = "1";
    L316:
        r100.put("is_chat_channel", r193);
        String r194 = r210.f123337a;
        if (r194 == null) goto L319;
        r100.put("content_length", String.valueOf(r194.length()));
    L319:
        r100.put("is_vr_machine", ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getVrMachineLogStr(this.dataCenter));
        if (u22.f.c(r210) == false) goto L322;
        r100.put("is_comment_feedback_copy", "1");
    L322:
        IAggregateService r195 = (IAggregateService) jc1.k.f(IAggregateService.class);
        if (r195 == null) goto L327;
        JSONObject r196 = r195.getPlayerStatsLog();
        if (r196 == null) goto L327;
        r100.put(IPerformanceManager.Stream.stream_cdn_ip, r196.optString("cdn_ip:"));
        r100.put(IPerformanceManager.Stream.stream_cdn_play_url, r196.optString("url:"));
    L327:
        JSONObject r197 = new JSONObject();
        JSONObject r198 = new JSONObject();     // Catch: JSONException -> L330
        String r199 = com.bytedance.android.live.core.utils.a0.n(this.dataCenter).getOwnerUserIdString();     // Catch: JSONException -> L330
        int r1100 = com.bytedance.android.live.base.model.user.n0.f58945a;     // Catch: JSONException -> L330
        com.bytedance.android.live.base.model.user.o0.f58946a.getClass();     // Catch: JSONException -> L330
        r197.put("int64_features", r198.put("event_author_id", com.bytedance.android.live.base.model.user.o0.a.f(r199)));     // Catch: JSONException -> L330
    L332:
        r100.put("__need_pass_other_fields__", r197.toString());
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L336;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).appendCastSDKLogCommonParams(r100);
    L336:
        if (r210.f123339c.containsKey("at_user_id") == false) goto L339;
        r100.put("at_user_id", String.valueOf(r210.f123339c.get("at_user_id")));
    L339:
        if (r210.f123339c.containsKey("message_type") == false) goto L342;
        r100.put("message_type", String.valueOf(r210.f123339c.get("message_type")));
    L342:
        if (u22.f.b(r210) == false) goto L344;
        r100.put("is_common_comment", "1");
    L345:
        com.bytedance.android.livesdk.event.q r200 = r210.f123341e;
        if (r200 != null) goto L348;
    L360:
        r100.put("at_user_id", "null");
    L362:
        if (this.f134753r == null) goto L364;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(this.dataCenter, r100);
    L364:
        Aq(r100);
        r3.m(r100, this.context);
        Bq(r100);
        x22.a r201 = this.C.f562225c;
        if (r201 == null) goto L367;
        r100.put("default_text", r201.f562221a);
        r100.put("default_text_type", this.C.f562225c.getType().getTypeName());
    L367:
        com.bytedance.android.livesdk.log.j0 r202 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r203 = new am2.x();
        r203.f4349a = "live_interact";
        r202.sendLog("audience_live_message", r100, new Object[]{am2.u.class, r203, IRoom.class, new am2.z(), am2.y.class, am2.n.f()});
        DataCenter r204 = this.dataCenter;
        if (r204 != null) goto L371;
        return;
    L371:
        if (com.bytedance.android.livesdk.utils.c1.b(r204) == false) goto L389;
        IRoom r205 = this.f134753r;
        if (r205 == null) goto L389;
        if (r205.getOwner() == null) goto L389;
        JSONObject r206 = new JSONObject();
        r206.put("anchor_id", this.f134753r.getOwner().getIdString());     // Catch: JSONException -> L379
        r206.put("room_id", String.valueOf(this.f134753r.getId()));     // Catch: JSONException -> L379
    L381:
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).handleLiveAdExtraData(r206);
        ILiveDouPlusService r207 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        HashMap r208 = new HashMap();
        r208.put("ad_extra_data", r206.toString());
        Map<String, String> r209 = com.bytedance.android.livesdk.utils.c1.e(this.dataCenter);
        if (r209 != null) goto L384;
    L387:
        r207.logEvent(true, "live_ad", "live_comment", r208);
        goto L389
    L384:
        if (r209.isEmpty() == true) goto L387;
        r208.putAll(r209);
    L379:
        e = move-exception;
        ALogger.e("CommentWidget", e);
    L389:
        if (com.bytedance.android.livesdk.utils.c1.c(this.dataCenter) == false) goto L454;
        IRoom r211 = this.f134753r;
        if (r211 != null) goto L393;
        return;
    L393:
        if (r211.getOwner() == null) goto L456;
        JSONObject r212 = new JSONObject();
        r212.put("anchor_id", this.f134753r.getOwner().getIdString());     // Catch: JSONException -> L397
        r212.put("room_id", String.valueOf(this.f134753r.getId()));     // Catch: JSONException -> L397
    L399:
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).handleLiveAdExtraData(r212);
        ILiveDouPlusService r213 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        HashMap r214 = new HashMap();
        r214.put("ad_extra_data", r212.toString());
        Map<String, String> r215 = com.bytedance.android.livesdk.utils.c1.f(this.dataCenter);
        if (r215.isEmpty() == true) goto L403;
        r214.putAll(r215);
    L403:
        r213.logEvent(true, "live_ad", "live_comment", r214);
        b3.a(this.dataCenter, r212);
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).reportAdEvent(this.dataCenter, "draw_ad", "click", this.f134753r.getOwnerUserIdString(), this.f134753r.getId());
        return;
    L397:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L399
    L456:
        return;
    L454:
        return;
    L348:
        if (CollectionUtils.isEmpty(r200.f123363a) == true) goto L360;
        StringBuilder r216 = new StringBuilder();
        Iterator<com.bytedance.android.livesdk.event.r> r217 = r210.f123341e.f123363a.iterator();
    L351:
        if (r217.hasNext() == false) goto L359;
        com.bytedance.android.livesdk.event.r r218 = r217.next();
        IBaseUser r1101 = r218.f123368e;
        if (r1101 == null) goto L351;
        if (r218.f123369f == false) goto L358;
        r101 = "1";
    L358:
        r216.append(r1101.getIdString());
        r216.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        goto L351
    L359:
        r216.deleteCharAt(r216.length() - 1);
        r100.put("at_user_id", r216.toString());
        r100.put("is_mention_list", r101);
        goto L362
    L344:
        r100.put("is_common_comment", "0");
    L330:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L332
    L315:
        r193 = "0";
        goto L316
    L311:
        r192 = "0";
        goto L312
    L307:
        r191 = "0";
        goto L308
    L277:
        if (r183.isMergeVSRoom() == false) goto L279;
        r100.put("vs_is_star_comment", "0");
        goto L279
    L272:
        if (r310.getLandscapeAreaCommon().isStarMessage() == false) goto L274;
        r100.put("vs_is_star_comment", "1");
        goto L279
    L268:
        r182 = "0";
        goto L269
    L411:
    L263:
        e = move-exception;
        i40.h.a("recommend_emoji matcher error-" + e.toString());
        goto L265
    L247:
        if (r179.length() <= 0) goto L249;
        boolean r219 = true;
    L251:
        if (r219 != true) goto L265;
        Matcher r220 = PatternProtector.compile("\\[.+?\\]").matcher(r179);     // Catch: Exception -> L263
        int r221 = 0;
    L254:
        if (r220.find() == false) goto L260;
        String r1102 = r220.group();     // Catch: Exception -> L263
        if (r1102 == null) goto L258;
        int r1103 = r1102.length();     // Catch: Exception -> L263
    L259:
        r221 = r221 + r1103;     // Catch: Exception -> L263
        goto L254
    L258:
        r1103 = 0;
        goto L259
    L260:
        if (r221 != r179.length()) goto L265;
        r181 = true;
        goto L266
    L249:
        r219 = false;
        goto L251
    L243:
        r177 = "0";
    L239:
        r176 = "unknown";
        goto L240
    L231:
        r100.put("is_settled", "0");
        r100.put("is_shortcut_message", "1");
        r100.put(EventConstant.Key.RETAIN_PROMPT, r210.f123337a);
        goto L233
    L232:
        r100.put("is_hot_sample_message", "1");
        r100.put(EventConstant.Key.RETAIN_PROMPT, r210.f123337a);
        goto L233
    L217:
        if (this.f134753r.getAutoCover() != 1) goto L219;
        String r222 = "autocover";
    L220:
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, r222);
        goto L221
    L219:
        r222 = "other";
    L183:
        r154 = null;
        goto L184
    L172:
        if (r150.f135153h.getType() != 1) goto L174;
        String r1104 = "say_hi";
    L175:
        r100.put("quick_interaction_type", r1104);
        goto L176
    L174:
        r1104 = "location";
    L168:
        r150 = null;
    L153:
        r143 = "0";
        goto L154
    L105:
        r129 = "comment";
        goto L106
    L99:
        if (r124.isEmpty() == true) goto L102;
        r128 = false;
    L96:
        r124 = null;
        goto L97
    L81:
        r120 = "0";
        goto L82
    L77:
        r119 = "0";
        goto L78
    L43:
        r109 = "normal";
        goto L44
    L33:
        r110 = "0";
    L28:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L30
    L5:
        r102 = "0";
        goto L6
    }

    public final void pr(final Long r110, List r111) {
        boolean r100 = false;
        if (com.bytedance.android.livesdk.interactivity.comment.utils.f.b(this.f134753r, false) == true) goto L11;
        String r112 = ec2.n.f472039a.getValue().e();
        if (r112 != null) goto L7;
    L8:
        r112 = s1.B(R.string.ttlive_cannot_comment_msg_opt);
    L9:
        f2.c(r112, 0);
        this.dataCenter.put(ILiveRoomPlayFragmentConstant.PRE_ENTRY_FAST_EMOJI_ID, -1L);
        return;
    L7:
        if (r112.isEmpty() == false) goto L9;
    L11:
        Iterator r113 = r111.iterator();
    L13:
        if (r113.hasNext() == false) goto L45;
        final com.bytedance.android.live.profit.vip.l r101 = (com.bytedance.android.live.profit.vip.l) r113.next();
        if (Long.valueOf(r101.f89147a).equals(r110) == false) goto L13;
        this.dataCenter.put(ILiveRoomPlayFragmentConstant.PRE_ENTRY_FAST_EMOJI_ID, -1L);
        Iterator r114 = ((HashSet) this.f134739h1).iterator();
        CommentFlowContext r102 = null;
    L18:
        if (r114.hasNext() == false) goto L21;
        r102 = ((y22.e) r114.next()).b(CommentEntry.GuideEvent, null);
        if (r102 == null) goto L18;
    L21:
        final CommentFlowContext r115 = r102;
        if (this.C.f562223a == false) goto L30;
        if (r115 == null) goto L27;
        CommentInputConfig r116 = r115.f133051d;
        if (r116 == null) goto L27;
        r100 = r116.f133074m;
    L27:
        if (r100 == true) goto L30;
        return;
    L30:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, this.dataCenter) != null) goto L32;
        qr(r110.longValue(), (int) r101.f89149c, r101.f89152f, ISendCommentEvent.Sender.CommentWidget, new HashMap(), r115, new HashMap());
        return;
    L32:
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, this.dataCenter).isFirstMessageConsumed().getValue().booleanValue() != true) goto L34;
        qr(r110.longValue(), (int) r101.f89149c, r101.f89152f, ISendCommentEvent.Sender.CommentWidget, new HashMap(), r115, new HashMap());
        return;
    L34:
        com.bytedance.android.livesdk.interactivity.api.i.a(null, this.dataCenter).isFirstMessageConsumed().a().subscribe(new k0(this, r110, r101, r115), new l0());
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void Ej(long r110, com.bytedance.android.livesdk.event.y r111, com.bytedance.android.livesdk.interactivity.api.comment.data.c r112) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        x22.b r100 = this.B;
        if (r100 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = ((LiveInputDialogV3) r100).f135448g;
        if (r101 == null) goto L14;
        EditText r102 = r101.f135496a;
        if (r102 == null) goto L14;
        r102.setText("");
    L14:
        if (TextUtils.isEmpty(r112.c()) == false) goto L17;
        f2.b(R.string.ttlive_live_danmaku_send_failed, 0);
        Zq(r111.f123378b);
        return;
    L17:
        boolean r103 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.recharge.k) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class)).rechargeCenter().setAvailableDiamonds(r112.b());
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter) != null) goto L20;
    L48:
        boolean r113 = false;
    L49:
        Mq(r111);
        HashMap r114 = new HashMap();
        if (r113 == false) goto L52;
        String r115 = "1";
    L53:
        r114.put("with_emoji", r115);
        r114.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, this.f134755t);     // Catch: Exception -> L58
        if (TextUtils.isEmpty(this.f134753r.getSourceType()) == true) goto L61;
        r114.put("moment_room_source", this.f134753r.getSourceType());     // Catch: Exception -> L58
    L61:
        if (r111.f123379c.equals(ISendCommentEvent.Sender.Lottery) == false) goto L63;
        String r116 = "lottery";
    L64:
        r114.put("request_page", r116);
        Iterator<Map.Entry<String, Object>> r117 = r111.f123380d.entrySet().iterator();
    L66:
        if (r117.hasNext() == false) goto L70;
        Map.Entry<String, Object> r104 = r117.next();
        if ((r104.getValue() instanceof String) == false) goto L66;
        r114.put(r104.getKey(), (String) r104.getValue());
        goto L66
    L70:
        r114.put("danmu_level", "0");
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L73;
        String r118 = "portrait";
    L74:
        r114.put("screen_layout", r118);
        if (this.f134752q == false) goto L77;
        String r119 = "anchor";
    L78:
        r114.put("user_type", r119);
        if (this.f134753r == null) goto L81;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(this.dataCenter, r114);
    L81:
        com.bytedance.android.livesdk.log.j0 r120 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r105 = new am2.x();
        r105.f4349a = "live_interact";
        r120.sendLog("send_barrage", r114, new Object[]{r105, am2.u.class, IRoom.class, am2.n.f()});
        Boolean r121 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r111, "is_from_click_event", r121)).booleanValue() == false) goto L94;
        z32.c.b(InputValueNode.SendAdminDanmakuSuccess);
        return;
    L94:
        return;
    L77:
        r119 = "user";
        goto L78
    L73:
        r118 = "landscape";
        goto L74
    L63:
        r116 = "normal";
    L58:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L61
    L52:
        r115 = "0";
        goto L53
    L20:
        if (isViewValid() == false) goto L48;
        if (r112.f() == false) goto L24;
        f2.b(R.string.ttlive_barrage_is_checking, 0);
        goto L48
    L24:
        Intrinsics.checkNotNullParameter(r112, IPerformanceManager.MODULE_BARRAGE);
        Object r106 = null;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L36
        IMiddlewareNetworkService r108 = (IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class);     // Catch: Throwable -> L36
        if (r108 == null) goto L33;
        am3.c r109 = r108.getProtoDecoder(h4.class);     // Catch: Throwable -> L36
        if (r109 == null) goto L33;
        byte[] r122 = Base64.decode(r112.d(), 0);     // Catch: Throwable -> L36
        am3.g r123 = new am3.g();     // Catch: Throwable -> L36
        r123.k(new am3.b(r122));     // Catch: Throwable -> L36
        h4 r124 = (h4) r109.decode(r123);     // Catch: Throwable -> L36
        if (r124 == null) goto L33;
        r124.setHttpSendTime(r110);     // Catch: Throwable -> L36
        r124.setSelfAndMock(true);     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter("start_send_time", "key");     // Catch: Throwable -> L36
        r124.setStartSendTime(((Number) ISendCommentEvent.a.a(r111, "start_send_time", 0L)).longValue());     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter("api_success_time", "key");     // Catch: Throwable -> L36
        r124.setApiSuccessTime(((Number) ISendCommentEvent.a.a(r111, "api_success_time", 0L)).longValue());     // Catch: Throwable -> L36
    L34:
        Object r125 = Result.m9449constructorimpl(r124);     // Catch: Throwable -> L36
    L38:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L42;
        ALogger.e("ttlive_msg", r126.toString());
    L42:
        if (Result.m9455isFailureimpl(r125) == true) goto L45;
        r106 = r125;
    L45:
        h4 r127 = (h4) r106;
        if (r127 == null) goto L48;
        r127.setLocalInsertMsg(true);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r127, PSMessageAction.SYSTEM);
        r127.setHttpSendTime(r110);
        MessageIdentity r128 = new MessageIdentity();
        r128.setShowIdentity(r112.e());
        r128.setIdentityLabel(r112.a());
        r127.setMessageIdentity(r128);
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter).B(r127);
        r113 = Lists.notEmpty(ab2.a.d(r127.getChatContent()));
    L33:
        r124 = null;
    L36:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L12:
        this.f134751p1.a(0).f133036a = "";
        goto L14
    }

    public final com.bytedance.android.livesdk.interactivity.comment.newinput.c Fq(x22.c r110, CommentFlowContext r111, g92.f r112) {
        fc2.e r100 = ec2.f0.f472016a.getValue();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r101 = new com.bytedance.android.livesdk.interactivity.comment.newinput.c();
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r102 = new com.bytedance.android.livesdk.interactivity.comment.newinput.a();
        boolean r103 = r110.f562224b;
        IRoom r104 = this.f134753r;
        boolean r105 = true;
        if (r104 != null) goto L5;
    L11:
        r101.f135415c = r103;
        if (this.f134746m.booleanValue() == true) goto L14;
    L16:
        boolean r106 = false;
    L17:
        r101.f135413a = r106;
        IRoom r107 = this.f134753r;
        if (r107 == null) goto L33;
        IRoomAuthStatus r108 = r107.getRoomAuthStatus();
        if (r108 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.service.model.c r109 = (com.bytedance.android.livesdk.interactivity.service.model.c) r108.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r109 == null) goto L24;
        long r113 = r109.getAudioChatToText();
    L26:
        if (r113 == 2) goto L28;
        boolean r114 = true;
    L29:
        if (r114 == false) goto L33;
        if (r100.b() == false) goto L33;
        r101.f135414b = true;
        goto L33
    L28:
        r114 = false;
    L24:
        r113 = 2;
    L33:
        r101.f135417e = r110.f562229g;
        s62.a r115 = this.P0;
        if (r115 == null) goto L36;
        r101.f135418f = r115.d();
    L36:
        r102.f135369e = r110.f562225c;
        r102.f135370f = r110.f562226d;
        r102.f135373i = this.C.f562231i;
        r102.f135378n = Long.valueOf(r110.f562232j);
        OpenInputSource r116 = r112.f480502b;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r102.f135384t = r116;
        r102.f135385u = r112.f480503c;
        if (r112.f480502b != OpenInputSource.Preview) goto L39;
        boolean r117 = true;
    L40:
        r102.f135387w = r117;
        r102.f135388x = r112.f480501a;
        r110.f562232j = -1;
        x22.d r118 = this.f134751p1;
        if (r111 == null) goto L43;
        r118.getClass();
        long r119 = r111.f133059l;
    L44:
        u22.m.a r120 = r118.a(r119).f133037b;
        if (r120 == null) goto L51;
        IBaseUser r121 = r120.f548453j;
        if (r121 == null) goto L51;
        if (r121.isMysteryMan() != true) goto L51;
        boolean r122 = true;
    L52:
        r102.f135386v = r122;
        com.bytedance.android.livesdk.interactivity.api.q r123 = com.bytedance.android.livesdk.interactivity.api.q.f133747a;
        List<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r124 = null;
        com.bytedance.android.livesdk.interactivity.api.h r125 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r125 == null) goto L57;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> r126 = r125.getActivityEmojiManager();
        if (r126 == null) goto L57;
        com.bytedance.android.livesdk.interactivity.api.emoji.d r127 = r126.getValue();
    L58:
        if (r127 == null) goto L60;
        r102.f135375k = r127.b();
    L60:
        com.bytedance.android.livesdk.interactivity.api.emoji.e r128 = com.bytedance.android.livesdk.interactivity.api.q.d();
        if (r128 == null) goto L63;
        r102.f135376l = r128.d();
    L63:
        r102.f135382r = this.E;
        long r129 = InputDraftType.getSceneId(r111);
        if (r111 != null) goto L66;
    L68:
        boolean r130 = false;
    L69:
        CharSequence r131 = this.f134751p1.a(r129).f133036a;
        if (r111 == null) goto L74;
        if (r130 == true) goto L74;
        boolean r132 = false;
    L75:
        if (r132 == false) goto L78;
        r102.f135374j = this.f134751p1.a(r129).f133037b;
    L84:
        r102.f135371g = r131;
        r102.f135372h = false;
        r102.f135379o = r110.f562227e;
        r102.f135380p = r110.f562228f;
        if (this.f134752q == false) goto L87;
        r101.f135414b = false;
        r101.f135413a = false;
    L87:
        String r133 = "" + ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b().getIdString() + this.f134753r.getId();
        if (r110.f562224b == true) goto L90;
    L129:
        r102.f135366b = !isScreenPortrait();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f135419g = r102;
        IRoom r134 = this.f134753r;
        Lazy r135 = PublicScreenABHelper.f133581a;
        if (r134 == null) goto L135;
        IRoomAuthStatus r136 = r134.getRoomAuthStatus();
        if (r136 == null) goto L135;
        if (r136.isPanelECServiceEnable() != true) goto L135;
    L136:
        if (r105 == true) goto L138;
    L160:
        return r101;
    L138:
        if (isScreenPortrait() == false) goto L160;
        com.bytedance.android.livesdk.interactivity.api.q r137 = com.bytedance.android.livesdk.interactivity.api.q.f133747a;
        com.bytedance.android.livesdk.interactivity.api.h r138 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r138 == null) goto L144;
        com.bytedance.live.datacontext.j<InputPanelComponentSyncDataModel> r139 = r138.getInputPanelComponentSyncDataModelModel();
        if (r139 == null) goto L144;
        InputPanelComponentSyncDataModel r140 = r139.getValue();
    L145:
        if (r140 != null) goto L148;
    L151:
        if (r124 == null) goto L160;
        Iterator<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r141 = r124.iterator();
    L154:
        if (r141.hasNext() == false) goto L159;
        com.bytedance.android.livesdk.interactivity.api.comment.data.f r142 = r141.next();
        if (r142 == null) goto L154;
        this.O.put(Integer.valueOf(r142.type), r142);
        goto L154
    L159:
        HashMap<Integer, com.bytedance.android.livesdk.interactivity.api.comment.data.f> r143 = this.O;
        Intrinsics.checkNotNullParameter(r143, "<set-?>");
        r101.f135416d = r143;
        goto L160
    L148:
        if (r140.getInputPanelComponentSyncData().c() == null) goto L151;
        r124 = r140.getInputPanelComponentSyncData().c().data;
    L144:
        r140 = null;
    L135:
        r105 = false;
        goto L136
    L90:
        if (TextUtils.isEmpty(r133) == true) goto L129;
        com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r144 = l42.a.f507322i;
        Map<String, String> r145 = r144.getValue();
        if (r145 == null) goto L129;
        if (r145.get(r133) == null) goto L129;
        g92.c r146 = (g92.c) JsonUtil.parse(r145.get(r133), g92.c.class);     // Catch: Exception -> L127
        if (r146 == null) goto L129;
        com.bytedance.android.live.profit.privilege.model.danmu.b r147 = r146.f480496a;     // Catch: Exception -> L127
        if (r147 == null) goto L129;
        if (r147.getStyle() == 21) goto L129;
        boolean r148 = this.f134752q;     // Catch: Exception -> L127
        IRoom r149 = this.f134753r;     // Catch: Exception -> L127
        if (r149 != null) goto L104;
    L106:
        UserAttr r150 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().q();     // Catch: Exception -> L127
        if (r148 == true) goto L111;
        if (r150 == null) goto L111;
        r148 = r150.isAdmin();     // Catch: Exception -> L127
    L111:
        if (r146.f480496a.getStyle() != 0) goto L114;
        if (r148 == false) goto L114;
    L115:
        r102.f135368d = r146.f480496a;     // Catch: Exception -> L127
        if (TextUtils.isEmpty(r110.f562226d) == true) goto L122;
        if (this.f134751p1.a(r129).f133037b != null) goto L120;
    L125:
        Gq(r145);     // Catch: Exception -> L127
        goto L129
    L120:
        if (this.f134751p1.a(r129).f133037b.f548454k == true) goto L125;
    L122:
        if (gb2.a.c(this.dataCenter, true) == true) goto L125;
        r102.f135369e = new x22.a(r146.f480496a.getCommentToast(), HintType.NORMAL);     // Catch: Exception -> L127
    L114:
        if (r146.f480496a.getStyle() > 0) goto L115;
        com.bytedance.android.livesdk.sharedpref.f.d(r144, null);     // Catch: Exception -> L127
        goto L125
    L104:
        if (r149.getOwner() == null) goto L106;
        r148 = Objects.equals(((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n(), this.f134753r.getOwner().getIdString());     // Catch: Exception -> L127
    L127:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L129
    L78:
        if ((r131 instanceof Editable) == false) goto L84;
        Object[] r151 = ((Editable) r131).getSpans(0, r131.length(), MentionSpan.class);
        if (r151 == null) goto L84;
        int r152 = r151.length;
        int r153 = 0;
    L82:
        if (r153 >= r152) goto L84;
        ((Editable) r131).removeSpan(r151[r153]);
        r153 = r153 + 1;
    L74:
        r132 = true;
        goto L75
    L66:
        if (r111.f133050c != CommentScene.ChatChannel) goto L68;
        r130 = true;
    L57:
        r127 = null;
    L51:
        r122 = false;
        goto L52
    L43:
        r119 = 0;
        goto L44
    L39:
        r117 = false;
        goto L40
    L14:
        if (r100.c() == false) goto L16;
        r106 = true;
        goto L17
    L5:
        if (r104.getRoomAuthStatus() == null) goto L11;
        if (r103 == true) goto L8;
    L10:
        r103 = false;
        goto L11
    L8:
        if (this.f134753r.getRoomAuthStatus().isEnableLandscapeChat() == false) goto L10;
        r103 = true;
        goto L11
    }

    public final x22.a Jq(float r100, TextPaint r110, boolean r111) {
        IRoom r101 = this.f134753r;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r104 = Lq();
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        IRoom r106 = this.f134753r;
        if (r106 != null) goto L17;
    L23:
        boolean r107 = false;
    L25:
        if (this.f134760x == false) goto L27;
    L29:
        boolean r108 = false;
    L31:
        if (this.f134760x == true) goto L37;
        CommentWidgetAnimator r109 = this.L;
        if (r109 == null) goto L37;
        if (r109.f136280e == false) goto L37;
        boolean r112 = true;
    L38:
        if (r103 == true) goto L40;
        if (r112 == false) goto L47;
        if (Tq() == false) goto L47;
        return new x22.a(s1.B(R.string.ttlive_live_user_danmuku_block), HintType.NORMAL);
    L47:
        if (this.Z == false) goto L56;
        s22.c r113 = this.X;
        if (r113 == null) goto L55;
        if (r113.isShowing() == false) goto L55;
        return new x22.a(s1.B(R.string.ttlive_greeting_in_chat_channel), HintType.NORMAL);
    L55:
        return new x22.a(s1.B(R.string.ttlive_say_something_in_room_channel), HintType.NORMAL);
    L56:
        String r114 = null;
        if (this.f134743k0 == false) goto L76;
        IRoom r115 = this.f134753r;
        int r116 = CommentUtils.f136249a;
        if (r115 == null) goto L73;
        RoomInteractData r117 = r115.getRoomInteractData();
        if (r117 == null) goto L73;
        UserWorldChatInfo r118 = r117.getSquareInfo();
        if (r118 == null) goto L73;
        String r119 = r118.getInputTip();
        if (r119 == null) goto L73;
        if (r119.length() > 0) goto L70;
        r102 = false;
    L70:
        if (r102 == false) goto L72;
        r114 = r119;
    L72:
        if (r114 == null) goto L73;
    L75:
        return new x22.a(r114, HintType.NORMAL);
    L73:
        r114 = s1.B(R.string.ttlive_say_something_in_square);
        goto L75
    L76:
        if (r105 == false) goto L85;
        boolean r120 = y62.a.f566322a;
        if (y62.a.a(this.f134753r, this.f134760x) == false) goto L83;
        if (ur() == false) goto L83;
        MainThreadPostUtils.d(this.H1);
        MainThreadPostUtils.b(this.H1);
    L83:
        return new x22.a(r104.getFixedCommentTips().getValue(), HintType.NORMAL);
    L85:
        if (r107 == true) goto L87;
        if (r108 == true) goto L90;
        com.bytedance.android.livesdk.interactivity.i.Companion.getClass();
        com.bytedance.android.livesdk.interactivity.i r121 = com.bytedance.android.livesdk.interactivity.i.access$getImpl$cp();
        if (r121 != null) goto L98;
        r121 = (com.bytedance.android.livesdk.interactivity.i) jc1.k.f(com.bytedance.android.livesdk.interactivity.i.class);
        if (r121 != null) goto L97;
        r121 = new com.bytedance.android.livesdk.interactivity.i();
    L97:
        com.bytedance.android.livesdk.interactivity.i.access$setImpl$cp(r121);
    L98:
        String r122 = r121.getCommentTip(this.dataCenter);
        if (r122 != null) goto L101;
        com.bytedance.android.livesdk.interactivity.comment.t r123 = this.f134758v1;
        if (r123 == null) goto L109;
        if (r123.a() == null) goto L109;
        return this.f134758v1.a();
    L109:
        if (this.f134753r.isMergeVSRoom() == false) goto L111;
    L116:
        IRoom r124 = this.f134753r;
        if (r124 == null) goto L130;
        if (r124.getRoomInteractData() == null) goto L130;
        if (this.f134753r.getRoomInteractData().getInputDefaultConfig() == null) goto L130;
        InputDefaultConfig r125 = this.f134753r.getRoomInteractData().getInputDefaultConfig();
        if (r125 == null) goto L130;
        if (r111 == false) goto L127;
        String r126 = r125.getEntryHint();
    L128:
        r114 = r126;
        goto L130
    L127:
        r126 = r125.getDialogHint();
    L130:
        if (TextUtils.isEmpty(r114) == false) goto L132;
        r114 = s1.B(R.string.ttlive_say_something);
    L132:
        String r127 = s1.B(R.string.ttlive_say_something_big_size);
        if (r100 <= 0.0f) goto L138;
        if (r110 == null) goto L138;
        if (r110.measureText(r114) <= r100) goto L138;
    L139:
        if (r102 == false) goto L144;
        if (r111 == false) goto L144;
        return new x22.a(r127, HintType.NORMAL);
    L144:
        return new x22.a(r114, HintType.NORMAL);
    L138:
        r102 = false;
        goto L139
    L111:
        if (this.f134753r.isMediaRoom() == true) goto L116;
        if (this.U == false) goto L116;
        return new x22.a(this.T, HintType.NORMAL);
    L101:
        return new x22.a(r122, HintType.NORMAL);
    L90:
        return new x22.a(s1.B(R.string.ttlive_comment_input_widget_hint), HintType.NORMAL);
    L87:
        return new x22.a(s1.B(R.string.ttlive_comment_input_widget_hint), HintType.NORMAL);
    L40:
        return new x22.a(s1.B(R.string.ttlive_live_send_disable_hint), HintType.NORMAL);
    L37:
        r112 = false;
        goto L38
    L27:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.dataCenter) == false) goto L29;
        r108 = true;
        goto L31
    L17:
        if (r106.isMergeVSRoom() == false) goto L23;
        DataCenter r128 = this.dataCenter;
        if (r128 == null) goto L23;
        if (com.bytedance.android.live.core.utils.a0.l(r128, true) == true) goto L23;
        r107 = true;
        goto L25
    L11:
        if (r104.isFixedComment() == false) goto L13;
        r105 = true;
        goto L14
    L5:
        if (r101.isEnableChat(false) == true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.CommentPresenter.IView
    public final void vN(long r110, com.bytedance.android.livesdk.event.y r111, PrivilegeBarrageResponse r112) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        x22.b r100 = this.B;
        long r101 = 0;
        if (r100 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = ((LiveInputDialogV3) r100).f135448g;
        if (r102 == null) goto L14;
        EditText r103 = r102.f135496a;
        if (r103 == null) goto L14;
        r103.setText("");
    L14:
        if (TextUtils.isEmpty(r112.getOrderId()) == false) goto L17;
        f2.b(R.string.ttlive_live_danmaku_send_failed, 0);
        Zq(r111.f123378b);
        return;
    L17:
        boolean r104 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.recharge.k) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class)).rechargeCenter().setAvailableDiamonds(r112.getLeftDiamond());
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter) != null) goto L20;
    L37:
        boolean r113 = false;
    L38:
        f2.i(this.context, r112.getToast(), 0);
        HashMap r114 = new HashMap();
        if (r113 == false) goto L41;
        String r115 = "1";
    L42:
        r114.put("with_emoji", r115);
        r114.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, this.f134755t);     // Catch: Exception -> L47
        if (TextUtils.isEmpty(this.f134753r.getSourceType()) == true) goto L50;
        r114.put("moment_room_source", this.f134753r.getSourceType());     // Catch: Exception -> L47
    L50:
        if (r111.f123379c.equals(ISendCommentEvent.Sender.Lottery) == false) goto L52;
        String r116 = "lottery";
    L53:
        r114.put("request_page", r116);
        Iterator<Map.Entry<String, Object>> r117 = r111.f123380d.entrySet().iterator();
    L55:
        if (r117.hasNext() == false) goto L59;
        Map.Entry<String, Object> r118 = r117.next();
        if ((r118.getValue() instanceof String) == false) goto L55;
        r114.put(r118.getKey(), (String) r118.getValue());
        goto L55
    L59:
        r114.put("danmu_level", String.valueOf(r111.f123378b));
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L62;
        String r119 = "portrait";
    L63:
        r114.put("screen_layout", r119);
        if (this.f134752q == false) goto L66;
        String r120 = "anchor";
    L67:
        r114.put("user_type", r120);
        if (this.f134753r == null) goto L70;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).buildVsRoomLog(this.dataCenter, r114);
    L70:
        com.bytedance.android.livesdk.log.j0 r121 = com.bytedance.android.livesdk.log.j0.l();
        am2.x r105 = new am2.x();
        r105.f4349a = "live_interact";
        r121.sendLog("send_barrage", r114, new Object[]{r105, am2.u.class, IRoom.class, am2.n.f()});
        Boolean r122 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter("is_from_click_event", "key");
        if (((Boolean) ISendCommentEvent.a.a(r111, "is_from_click_event", r122)).booleanValue() == false) goto L73;
        z32.c.b(InputValueNode.SendPrivilegeDanmakuSuccess);
    L73:
        Mq(r111);
        return;
    L66:
        r120 = "user";
        goto L67
    L62:
        r119 = "landscape";
        goto L63
    L52:
        r116 = "normal";
    L47:
        e = move-exception;
        ALogger.e("CommentWidget", e);
        goto L50
    L41:
        r115 = "0";
        goto L42
    L20:
        if (isViewValid() == false) goto L37;
        IBaseUser r106 = (IBaseUser) this.dataCenter.get("data_user_in_room", null);
        if (r106 != null) goto L24;
        r106 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b();
    L24:
        IRoom r107 = this.f134753r;
        Intrinsics.checkNotNullParameter(r111, "ev");
        Intrinsics.checkNotNullParameter(r112, "response");
        s3 r108 = (s3) vh7.f.c(s3.class);
        r108.setMessageMethod("WebcastPrivilegeScreenChatMessage");
        IBaseUser r109 = r112.getUser();
        if (r109 == null) goto L28;
        r106 = r109;
    L28:
        r108.setUser2(r106);
        r108.setContent(r111.f123377a);
        r108.setStyle(r111.f123378b);
        r108.setSkin(r112.getSkin());
        r108.setLocalInsertMsgOld(true);
        Intrinsics.checkNotNullParameter("start_send_time", "key");
        r108.setStartSendTime(((Number) ISendCommentEvent.a.a(r111, "start_send_time", 0L)).longValue());
        Intrinsics.checkNotNullParameter("api_success_time", "key");
        r108.setApiSuccessTime(((Number) ISendCommentEvent.a.a(r111, "api_success_time", 0L)).longValue());
        r108.setHttpSendTime(r110);
        r108.setSelfAndMock(true);
        com.bytedance.android.live.base.model.message.m0 r123 = (com.bytedance.android.live.base.model.message.m0) vh7.f.c(com.bytedance.android.live.base.model.message.m0.class);
        if (r107 == null) goto L31;
        r101 = r107.getId();
    L31:
        r123.setRoomId(r101);
        r123.setMessageId(r112.getMsgId());
        r123.setMethod("WebcastPrivilegeScreenChatMessage");
        r123.setShowMsg(true);
        Unit r124 = Unit.INSTANCE;
        r108.setBaseMessage(r123);
        MessageIdentity r125 = new MessageIdentity();
        r125.setShowIdentity(r112.getShowIdentity());
        r125.setIdentityLabel(r112.getIdentityLabel());
        r108.setMessageIdentity(r125);
        if (r111.f123381e == null) goto L34;
    L35:
        com.bytedance.android.livesdk.interactivity.api.entity.o.a(r111, r108, r111.f123377a);
    L36:
        com.bytedance.android.livesdk.interactivity.textmessage.utils.j.b(this.dataCenter).j(r108, true);
        r113 = Lists.notEmpty(ab2.a.d(r108.getContent()));
        goto L38
    L34:
        if (r111.f123382f == null) goto L36;
    L12:
        this.f134751p1.a(0).f133036a = "";
        goto L14
    }

    public final void qr(long r110, int r111, boolean r112, ISendCommentEvent.Sender r113, HashMap r114, CommentFlowContext r115, Map r210) {
        CommentPresenter r100 = this.f134762y;
        if (r100 == null) goto L6;
        r100.p0(new com.bytedance.android.livesdk.event.c0(r110, r111, r112, r113, r114, r115, r210));
        return;
    }

    public final void fr(String r210, boolean r211, int r212, boolean r213, QuickCommentTypeEnum r214, long r215, com.bytedance.android.livesdk.event.m r216, com.bytedance.android.livesdk.event.q r217, boolean r218, g92.b r310, Map<String, Object> r311) {
        com.bytedance.android.livesdk.user.e r100 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isLogin() == true) goto L10;
        Context r101 = this.context;
        com.bytedance.android.livesdk.user.l.a r102 = new com.bytedance.android.livesdk.user.l.a();
        r102.f158685a = s1.B(R.string.ttlive_core_login_dialog_message);
        r102.f158688d = "comment_live";
        r102.f158687c = -1;
        r100.login(r101, new com.bytedance.android.livesdk.user.l(r102)).compose(getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "not login", null);
        return;
    L10:
        if (r100.g(LiveInteractFunction.COMMENT) == false) goto L14;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "UserCenter intercept", null);
        return;
    L14:
        if (this.f134759w == false) goto L16;
        xs2.b.a().post(new u22.j(true, 0));
        this.f134759w = false;
    L16:
        CommentPresenter r103 = this.f134762y;
        if (r103 != null) goto L21;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.e("comment", "comment presenter is null", null);
        return;
    L21:
        if (r211 == false) goto L23;
        ISendCommentEvent.Sender r110 = ISendCommentEvent.Sender.CommentWidget;
        String r104 = this.f134756u;
        HashMap r111 = new HashMap();
        r111.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE, r104);
        r111.put("money", Long.valueOf(r215));
        r111.put("is_from_click_event", Boolean.valueOf(r310.f480490d));
        r111.put("start_send_time", Long.valueOf(r310.f480491e));
        r103.k0(new com.bytedance.android.livesdk.event.y(r210, r212, r110, r111, r216, r217));
        return;
    L23:
        ISendCommentEvent.Sender r112 = ISendCommentEvent.Sender.CommentWidget;
        String r105 = this.f134756u;
        HashMap r113 = new HashMap();
        r113.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE, r105);
        r113.put("from_voice_panel", Boolean.valueOf(r213));
        r113.put("quickCommentType", r214);
        r113.put("is_from_comment_operate_copy", Boolean.valueOf(r218));
        r113.put("comment_send_params", r310);
        r113.put("request_source", r310.f480488b);
        r113.put("start_send_time", Long.valueOf(r310.f480491e));
        if (r311 != null) goto L26;
    L28:
        if (r311 != null) goto L30;
    L32:
        if (r311 != null) goto L34;
    L36:
        if (r311 != null) goto L38;
    L40:
        if (r311 != null) goto L42;
    L44:
        if (r311 != null) goto L46;
    L48:
        if (r311 != null) goto L50;
    L52:
        if (r311 != null) goto L54;
    L56:
        if (r311 != null) goto L58;
    L60:
        if (r311 != null) goto L62;
    L74:
        IMiddlewareRoomService r106 = (IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class);
        if (r106 == null) goto L80;
        String r107 = r106.getIntentRecognition();
        if (r107 == null) goto L80;
        r113.put("intent_recognition", r107);
    L80:
        if (r310.f480493g > 0) goto L82;
    L84:
        r103.l0(new com.bytedance.android.livesdk.event.d0(r210, r112, r113, r216, r217, false));
        return;
    L82:
        if (TextUtils.isEmpty(r310.f480492f) == true) goto L84;
        r113.put("truth_question_id", Long.valueOf(r310.f480493g));
        r113.put("truth_question_text", r310.f480492f);
        goto L84
    L62:
        if (r311.containsKey("jsb_track_params") == false) goto L74;
        Object r108 = r311.get("jsb_track_params");
        if ((r108 instanceof JsonObject) == false) goto L74;
        JsonObject r109 = (JsonObject) r108;
        Iterator<String> r114 = r109.keySet().iterator();
    L67:
        if (r114.hasNext() == false) goto L74;
        String r115 = r114.next();
        JsonElement r116 = r109.get(r115);
        if (r116 == null) goto L67;
        r113.put(r115, r116.getAsString());     // Catch: Exception -> L72
    L72:
        e = move-exception;
        SafetyGuard.a("CommentPresenter", e, "parse jsb track params failed");
        goto L67
    L58:
        if (r311.containsKey("default_text_type") == false) goto L60;
        r113.put("default_text_type", r311.get("default_text_type"));
        goto L60
    L54:
        if (r311.containsKey("paste_edit_method") == false) goto L56;
        r113.put("paste_edit_method", r311.get("paste_edit_method"));
        goto L56
    L50:
        if (r311.containsKey("is_self_click_send") == false) goto L52;
        r113.put("is_self_click_send", r311.get("is_self_click_send"));
        goto L52
    L46:
        if (r311.containsKey("is_from_click_event") == false) goto L48;
        r113.put("is_from_click_event", r311.get("is_from_click_event"));
        goto L48
    L42:
        if (r311.containsKey("input_comment_type") == false) goto L44;
        r113.put("input_comment_type", r311.get("input_comment_type"));
        goto L44
    L38:
        if (r311.containsKey("is_shortcut_message") == false) goto L40;
        r113.put("is_shortcut_message", r311.get("is_shortcut_message"));
        goto L40
    L34:
        if (r311.containsKey("is_settled") == false) goto L36;
        r113.put("is_settled", r311.get("is_settled"));
        goto L36
    L30:
        if (r311.containsKey("message_type") == false) goto L32;
        r113.put("message_type", r311.get("message_type"));
        goto L32
    L26:
        if (r311.containsKey("at_user_id") == false) goto L28;
        r113.put("at_user_id", r311.get("at_user_id"));
        goto L28
    }
}
