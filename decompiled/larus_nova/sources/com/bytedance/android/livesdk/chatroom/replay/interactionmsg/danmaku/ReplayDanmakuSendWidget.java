package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livesdk.chatroom.replay.input.ReplayEmojiInputDialogFragment;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.ReplayMessageTracer;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentPresenter;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentStatisticLog;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.dialog.ReplayDanmakuInputDialogFrom;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.dialog.ReplayDanmakuInputPortraitDialog;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.PortraitVideoDanmakuSend, type = PlayerViewControl.Type.BOTTOM)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/ReplayDanmakuSendWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/comment/ReplayCommentPresenter$IView;", "Lmq1/h$b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayDanmakuSendWidget extends LiveRecyclableWidget implements ReplayCommentPresenter.IView, mq1.h.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f108899l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplayCommentPresenter f108900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f108901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c f108902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ll1.a f108903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplayDataContext f108904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f108905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f108906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f108907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Activity f108908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f108909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f108910k;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuSendWidget f108911a;

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.a
        public final void a() {
            DataCenter r100 = this.f108911a.dataCenter;
            if (r100 == null) goto L6;
            r100.put("data_pre_show_keyboard", Boolean.FALSE);
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.a
        public final boolean isPortrait() {
            DataCenter r100 = this.f108911a.dataCenter;
            if (r100 != null) goto L7;
            return true;
        L7:
            return ((Boolean) r100.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        }

        public b(ReplayDanmakuSendWidget r100) {
            this.f108911a = r100;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuSendWidget f108912a;

        public c(ReplayDanmakuSendWidget r100) {
            this.f108912a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.b
        public final void b(ll1.a r100) {
            Intrinsics.checkNotNullParameter(r100, "newAttrs");
            ReplayDanmakuSendWidget r101 = this.f108912a;
            r101.f108903d.getClass();
            r101.f108902c = null;
            r101.f108903d = r100;
            com.bytedance.android.livesdk.chatroom.replay.util.f.e(r101.dataCenter);
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.b
        public final void a(String r110, Map r111) {
            ReplayDanmakuSendWidget r100 = this.f108912a;
            if (r110 != null) goto L5;
            r110 = "";
        L5:
            int r101 = ReplayDanmakuSendWidget.f108899l;
            r100.getClass();
            if (fq1.t.a().isLogin() == true) goto L9;
            com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m.a.a(fq1.t.a(), r100.context, s1.B(R.string.ttlive_replay_core_login_dialog_message), "comment_live", null, null, -1, null, 88).compose(r100.getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L9:
            if (fq1.t.a().o() == true) goto L25;
            ReplayCommentPresenter r102 = r100.f108900a;
            if (r102 == null) goto L24;
            SendReplayTextEvent.Sender r103 = SendReplayTextEvent.Sender.CommentWidget;
            String r104 = r100.f108901b;
            r100.f108903d.getClass();
            if (r103 == null) goto L26;
            HashMap r105 = new HashMap();
            r105.put(VSConstants.EXTRA_ENTER_LIVE_SOURCE, r104);
            if (r111 == null) goto L21;
            Object r112 = ((HashMap) r111).get("emoji_count");
            if ((r112 instanceof Integer) == false) goto L21;
            r105.put("liveEmojiCountInt", r112);
        L21:
            r105.put("vs_welcome_comment", Boolean.FALSE);
            SendReplayTextEvent r113 = new SendReplayTextEvent();
            Intrinsics.checkNotNullParameter(r110, "<set-?>");
            r113.f118382a = r110;
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r113.f118383b = r103;
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r113.f118384c = r105;
            r102.h(r113);
            return;
        L26:
            return;
        L24:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuSendWidget f108913a;

        public d(ReplayDanmakuSendWidget r100) {
            this.f108913a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            this.f108913a.M3();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuSendWidget f108914a;

        public e(ReplayDanmakuSendWidget r100) {
            this.f108914a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IFollowPair r101 = (IFollowPair) r100;
            ReplayDanmakuSendWidget r102 = this.f108914a;
            int r103 = ReplayDanmakuSendWidget.f108899l;
            DataCenter r104 = r102.dataCenter;
            String r105 = null;
            if (r104 == null) goto L5;
            Episode r106 = (Episode) r104.get("data_vs_episode_data");
        L6:
            if (r106 == null) goto L10;
            IBaseUser r107 = r106.getOwner();
            if (r107 == null) goto L10;
            String r108 = r107.getIdString();
        L12:
            if (TextUtils.isEmpty(r108) == true) goto L25;
            String r109 = r101.getUserIdString();
            if (r106 == null) goto L19;
            IBaseUser r110 = r106.getOwner();
            if (r110 == null) goto L19;
            r105 = r110.getIdString();
        L19:
            if (TextUtils.equals(r109, r105) == false) goto L26;
            if (r106 == null) goto L27;
            IBaseUser r111 = r106.getOwner();
            if (r111 == null) goto L28;
            r111.setFollowStatus(r101.getFollowStatus());
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L10:
            r108 = null;
            goto L12
        L5:
            r106 = null;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuSendWidget f108915a;

        public f(ReplayDanmakuSendWidget r100) {
            this.f108915a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            ReplayDanmakuSendWidget r102 = this.f108915a;
            int r103 = ReplayDanmakuSendWidget.f108899l;
            r102.yq(r102.wq());
        }
    }

    public static final class g implements OnBindPhoneListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuSendWidget f108916a;

        public g(ReplayDanmakuSendWidget r100) {
            this.f108916a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener
        public final void onBindPhone(boolean r100) {
            if (this.f108916a.isViewValid() == true) goto L5;
            return;
        L5:
            if (r100 == false) goto L8;
            ReplayDanmakuSendWidget r101 = this.f108916a;
            int r102 = ReplayDanmakuSendWidget.f108899l;
            r101.xq(0);
            return;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f108917a = null;

        static {
            f108917a = new h();
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = r100.getContext();
            fq1.f.a().c(r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.ReplayDanmakuSendWidget$onLoad$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Object, Unit> {
        public AnonymousClass3(ReplayDanmakuSendWidget r100) {
            super(1, r100, ReplayDanmakuSendWidget.class, "wannaSendMessage", "wannaSendMessage(Ljava/lang/Object;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object r100) {
            ReplayDanmakuSendWidget r101 = (ReplayDanmakuSendWidget) this.receiver;
            int r102 = ReplayDanmakuSendWidget.f108899l;
            View r103 = r101.contentView;
            if (r103 != null) goto L5;
        L7:
            if (r100 != null) goto L10;
            return;
        L10:
            if (r101.f108910k == r100) goto L16;
            r101.f108910k = r100;
            r101.xq(0);
            return;
        L16:
            return;
        L5:
            if (r103.getVisibility() != 8) goto L7;
            com.bytedance.android.livesdk.chatroom.vs_base.util.y.a(R.string.ttlive_vs_danmaku_off);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_video_danmaku_send;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentPresenter.IView
    public final void M3() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        Episode r101 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.g(r100);
    L6:
        if (r101 == null) goto L15;
        IRoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 == null) goto L16;
        boolean r103 = r102.getEnableChat();
        ViewGroup r104 = this.containerView;
        if (r103 == false) goto L12;
        int r105 = 0;
    L13:
        UIUtils.setViewVisibility(r104, r105);
        this.dataCenter.put("data_room_comment_status", Boolean.valueOf(r102.getEnableChat()));
        ReplayMessageTracer.b("ReplayDanmakuSendWidget canCommentStatusChanged: " + r103);
        return;
    L12:
        r105 = 8;
        goto L13
    L16:
        return;
    L15:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ReplayCommentPresenter r100 = this.f108900a;
        if (r100 == null) goto L5;
        r100.f();
    L5:
        mq1.h r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.a();
        if (r101 == null) goto L8;
        r101.c(this);
    L8:
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r102 = this.f108902c;
        if (r102 == null) goto L11;
        Intrinsics.checkNotNull(r102);
        r102.dismissAllowingStateLoss();
        this.f108902c = null;
    L11:
        this.f108909j.clear();
        this.f108904e = null;
    }

    public final boolean wq() {
        if (com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.d.a(this.dataCenter) == true) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r100 = nq1.d.f520092a;
        return nq1.d.f520099h.getValue().booleanValue();
    L5:
        if (com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.d.b(this.dataCenter) == true) goto L7;
        return true;
    L7:
        return false;
    }

    public ReplayDanmakuSendWidget() {
        this.f108901b = "";
        this.f108903d = new ll1.a();
        this.f108905f = new c(this);
        this.f108906g = new b(this);
        this.f108909j = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentPresenter.IView
    public final Context getViewContext() {
        return this.context;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentPresenter.IView
    public final void h8(Exception r100) {
        if ((r100 instanceof ApiServerException) == false) goto L40;
        ApiServerException r101 = (ApiServerException) r100;
        int r102 = r101.getErrorCode();
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().c() != r102) goto L15;
        if (isViewValid() == false) goto L13;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r103 = this.f108902c;
        if (r103 == null) goto L12;
        r103.jS();
        goto L13
    L12:
        this.f108903d.f509669c = true;
    L13:
        IESUIUtils.displayToast(this.f108908i, r101.getPrompt());
    L38:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.j.b(r101) == false) goto L41;
        fq1.d.a().g(this.f108908i, new ReplayDanmakuSendWidget$handleException$1(this));
    L41:
        ReplayMessageTracer.b("ReplayDanmakuSendWidget send danmaku failed with error code: " + r102);
        return;
    L15:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().g() != r102) goto L27;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r104 = this.f108902c;
        if (r104 == null) goto L19;
        r104.updateInput("");
    L21:
        if (this.f108902c != null) goto L23;
    L25:
        IESUIUtils.displayToast(this.f108908i, r101.getPrompt());
        goto L38
    L23:
        if (isViewValid() == false) goto L25;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r105 = this.f108902c;
        Intrinsics.checkNotNull(r105);
        r105.dismissInputDialog();
        this.dataCenter.put("data_pre_show_keyboard", Boolean.FALSE);
        goto L25
    L19:
        this.f108903d.f509672f = "";
        goto L21
    L27:
        if (r102 == com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().h()) goto L29;
        IESUIUtils.displayToast(this.f108908i, r101.getPrompt());
        goto L38
    L29:
        if (this.f108902c != null) goto L31;
    L33:
        Activity r106 = this.f108908i;
        if (r106 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.vs_base.util.g.a(r106, new g(this), h.f108917a);
        goto L38
    L31:
        if (isViewValid() == false) goto L33;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r107 = this.f108902c;
        Intrinsics.checkNotNull(r107);
        r107.dismissInputDialog();
        this.dataCenter.put("data_pre_show_keyboard", Boolean.FALSE);
        goto L33
    L40:
        com.bytedance.android.livesdk.chatroom.vs_base.util.y.a(R.string.ttlive_replay_chat_send_failed);
        ReplayMessageTracer.b("ReplayDanmakuSendWidget unknown exception ".concat(String.valueOf(r100)));
        r102 = -1;
        goto L41
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        Context r101 = this.context;
        if (r101 == null) goto L23;
        this.f108908i = (Activity) r101;
        this.f108900a = new ReplayCommentPresenter();
        this.f108901b = (String) this.dataCenter.get("log_enter_live_source", "");
        View r102 = this.contentView;
        if (r102 == null) goto L7;
        View r103 = r102.findViewById(R.id.iv_send_danmaku);
    L8:
        this.f108907h = r103;
        ViewGroup r104 = this.containerView;
        if (r104 == null) goto L24;
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L19;
        Episode r106 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r105);
        if (r106 == null) goto L19;
        IRoomAuthStatus r107 = r106.getRoomAuthStatus();
        if (r107 == null) goto L19;
        boolean r108 = true;
        if (r107.getEnableChat() != true) goto L19;
    L20:
        UtilityKotlinExtentionsKt.k(r104, r108);
        return;
    L19:
        r108 = false;
        goto L20
    L24:
        return;
    L7:
        r103 = null;
        goto L8
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ReplayCommentPresenter r101 = this.f108900a;
        if (r101 == null) goto L5;
        r101.g(this);
    L5:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r102 = ReplayRoomFragmentScopeUtil.f117917a;
        com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f r103 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.f.class);
        View r104 = this.f108907h;
        r103.getClass();
        if (r104 == null) goto L9;
        r104.setBackgroundResource(R.drawable.ttlive_replay_danmaku_icon);
    L9:
        ReplayDataContext.a r105 = ReplayDataContext.Companion;
        DataCenter r106 = this.dataCenter;
        r105.getClass();
        this.f108904e = ReplayDataContext.a.b(r106);
        View r107 = this.f108907h;
        if (r107 == null) goto L12;
        r107.setOnClickListener(com.bytedance.android.livesdk.chatroom.vs_base.base.view.d.a(new AnonymousClass1(this)));
    L12:
        M3();
        yq(wq());
        ReplayDataContext r108 = this.f108904e;
        if (r108 == null) goto L21;
        com.bytedance.live.datacontext.n<Episode> r109 = r108.getVsInteractionDataPrepared();
        if (r109 == null) goto L21;
        Observable<sh6.b<Episode>> r110 = r109.a();
        if (r110 == null) goto L21;
        ObservableSubscribeProxy r111 = (ObservableSubscribeProxy) r110.as(autoDispose());
        if (r111 == null) goto L21;
        r111.subscribe(new d(this));
    L21:
        ReplayCommentStatisticLog.c(this.dataCenter);
        mq1.h r112 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.a();
        if (r112 == null) goto L24;
        r112.d(this);
    L24:
        Disposable r113 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.f().E(new AnonymousClass3(this));
        if (r113 == null) goto L27;
        RxUtilKt.c(r113, this.f108909j);
    L27:
        ((ObservableSubscribeProxy) fq1.t.a().followStateChanged().as(autoDispose())).subscribe(new e(this));
        com.bytedance.live.datacontext.m<Boolean> r114 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().c(this.dataCenter);
        if (r114 == null) goto L35;
        Observable<Boolean> r115 = r114.a();
        if (r115 == null) goto L36;
        Disposable r116 = r115.subscribe(new f(this));
        if (r116 == null) goto L37;
        RxUtilKt.c(r116, this.f108909j);
        return;
    L37:
        return;
    L36:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentPresenter.IView
    public final void x80(q5 r100) {
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r101 = this.f108902c;
        if (r101 == null) goto L5;
        r101.updateInput("");
    L6:
        ReplayDataContext r102 = this.f108904e;
        if (r102 == null) goto L11;
        com.bytedance.live.datacontext.n<vlc.d> r103 = r102.getSeekMessageManager();
        if (r103 == null) goto L11;
        vlc.d r104 = r103.getValue();
    L12:
        if (r104 == null) goto L15;
        r104.j(r100, true);
        return;
    L15:
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        this.f108903d.f509672f = "";
        goto L6
    }

    public final boolean xq(@ReplayDanmakuInputDialogFrom final int r110) {
        yq1.a r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.c();
        if (r100 != null) goto L5;
    L7:
        ReplayDataContext r101 = this.f108904e;
        final boolean r102 = true;
        if (r101 == null) goto L16;
        com.bytedance.live.datacontext.j<kq1.a> r103 = r101.getPaidManager();
        if (r103 == null) goto L16;
        kq1.a r104 = r103.getValue();
        if (r104 == null) goto L16;
        Boolean r105 = Boolean.TRUE;
        if (r104.e(true, r105, r105) != true) goto L16;
        return false;
    L16:
        DataCenter r106 = this.dataCenter;
        int r107 = pl1.a.f529750a;
        if (r110 == 1) goto L20;
        if (r110 == 2) goto L20;
        String r108 = "unknown";
    L21:
        ReplayCommentStatisticLog.b(r106, r108);
        ll1.a r109 = this.f108903d;
        if (r109.f509669c == false) goto L25;
        IESUIUtils.displayToast(this.f108908i, R.string.ttlive_replay_live_user_text_banned);
        return false;
    L25:
        r109.f509670d = false;
        if (r110 != 2) goto L28;
        boolean r111 = true;
    L30:
        if (r111 == false) goto L35;
        final ReplayDanmakuInputPortraitDialog r112 = new ReplayDanmakuInputPortraitDialog();
        Episode r113 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.g(this.dataCenter);
        if (r113 == null) goto L34;
        ol1.d r114 = ol1.c.a(r110, r113, this.dataCenter, this.f108903d, true, new ReplayDanmakuSendWidget$showInputDialog$$inlined$apply$lambda$1(r112, this, r110, r102), new ReplayDanmakuSendWidget$showInputDialog$$inlined$apply$lambda$2(r112, this, r110, r102));
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r112.f109085i = r114;
    L34:
        Unit r115 = Unit.INSTANCE;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r116 = r112;
    L40:
        this.f108902c = r116;
        r116.iM(this.f108905f);
        com.bytedance.android.livesdk.chatroom.replay.util.f.d(this.dataCenter);
        com.bytedance.android.livesdk.chatroom.replay.util.f.b(this.dataCenter);
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c r117 = this.f108902c;     // Catch: IllegalStateException -> L45
        if (r117 == null) goto L46;
        r117.show(this.f108908i, "INPUT");     // Catch: IllegalStateException -> L45
    L46:
        return true;
    L45:
        this.f108902c = null;
        goto L46
    L35:
        b r118 = this.f108906g;
        DataCenter r119 = this.dataCenter;
        ReplayEmojiInputDialogFragment r120 = new ReplayEmojiInputDialogFragment();
        Bundle r121 = new Bundle();
        r121.putBoolean("live.intent.extra.DANMU_OPEN", r109.f509667a);
        r121.putBoolean("live.intent.extra.IS_BROADCASTER", r109.f509668b);
        r121.putBoolean("live.intent.extra.USER_BANNED", r109.f509669c);
        CharSequence r122 = r109.f509672f;
        if (r122 != null) goto L38;
        String r123 = null;
    L39:
        r121.putString("live.intent.extra.INPUT", r123);
        r121.putBoolean("live.inter.extra.CAN_DANMU", r109.f509670d);
        r121.putBoolean("live.inter.extra.IS_OFFICIAL", false);
        r121.putString("live.intent.extra.COMMENT_HINT", r109.f509671e);
        r121.putString("live.intent.extra.OFF_ALLOW_GIFT", null);
        r121.putBoolean("live.intent.extra.CAN_SEND_EMOJI", true);
        r120.setArguments(r121);
        r120.A = r118;
        r120.f108769g = r119;
        r116 = r120;
        goto L40
    L38:
        r123 = r122.toString();
        goto L39
    L28:
        r111 = false;
    L20:
        r108 = "send_barrage";
        goto L21
    L5:
        if (r100.n(this.dataCenter, PaidInteractEntry.CONTROL_ENTRY_DANMAKU) == true) goto L7;
        return false;
    }

    public final void yq(boolean r100) {
        if (r100 == false) goto L6;
        View r101 = this.contentView;
        if (r101 == null) goto L10;
        r101.setVisibility(8);
        return;
    L10:
        return;
    L6:
        View r102 = this.contentView;
        if (r102 == null) goto L12;
        r102.setVisibility(0);
        return;
    }

    @Override // mq1.h.b
    public final void p8(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        yq(r100);
    }
}
