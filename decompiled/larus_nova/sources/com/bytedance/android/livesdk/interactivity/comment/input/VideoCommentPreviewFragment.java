package com.bytedance.android.livesdk.interactivity.comment.input;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.interactivity.api.comment.CommentApi;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import gd0.r;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/VideoCommentPreviewFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/input/AbsLiveInputSecondaryFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCommentPreviewFragment extends AbsLiveInputSecondaryFragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f135074w = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gd0.b f135075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u62.b f135076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f135078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f135079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f135080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f135081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f135082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f135083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f135084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f135085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f135086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f135087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f135088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f135089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f135090s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f135091t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f135092u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f135093v;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135094a;

        public b(VideoCommentPreviewFragment r100) {
            this.f135094a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
        L7:
            r r102 = this.f135094a.f135078g;
            if (r102 == null) goto L12;
            r102.c();
            return;
        L12:
            return;
        L6:
            if (r101.intValue() != 2) goto L7;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f135095a = null;

        static {
            f135095a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135096a;

        public d(VideoCommentPreviewFragment r100) {
            this.f135096a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            gd0.b r101 = this.f135096a.f135075d;
            if (r101 == null) goto L7;
            Long r102 = r101.f480890a;
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
        L8:
            this.f135096a.X90(r103);
            return;
        L7:
            r103 = 0;
            goto L8
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135097a;

        public e(VideoCommentPreviewFragment r100) {
            this.f135097a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VideoCommentPreviewFragment r101 = this.f135097a;
            if (r101.f135076e == null) goto L5;
            Intrinsics.checkNotNullParameter(InputDialogFragmentSwitchType.SLIDE_RIGHT, "switchType");
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        L5:
            VideoCommentPreviewFragment r102 = this.f135097a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r103 = r102.f135077f;
            if (r103 == null) goto L9;
            r103.G(InputDialogFragmentSwitchType.SLIDE_RIGHT, r102);
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135098a;

        public f(VideoCommentPreviewFragment r100) {
            this.f135098a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VideoCommentPreviewFragment r101 = this.f135098a;
            boolean r102 = !r101.f135090s;
            r101.f135090s = r102;
            if (r102 == false) goto L7;
            ImageView r103 = r101.f135085n;
            if (r103 == null) goto L10;
            r103.setBackgroundResource(R.drawable.ttlive_video_comment_select_panel_select_bg);
        L10:
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = l42.a.f507333t;
            Boolean r105 = Boolean.valueOf(this.f135098a.f135090s);
            r104.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
            return;
        L7:
            ImageView r106 = r101.f135085n;
            if (r106 == null) goto L10;
            r106.setBackgroundResource(R.drawable.ttlive_video_comment_select_panel_unselect_bg);
            goto L10
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135099a;

        public g(VideoCommentPreviewFragment r100) {
            this.f135099a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            VideoCommentPreviewFragment r111 = this.f135099a;
            int r100 = VideoCommentPreviewFragment.f135074w;
            r111.getClass();
            IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
            long r102 = 0;
            if (r101 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r101, null, 0, 3);
            if (r103 == null) goto L11;
            com.bytedance.live.datacontext.m<IRoom> r104 = r103.getRoom();
            if (r104 == null) goto L11;
            IRoom r105 = r104.getValue();
            if (r105 == null) goto L11;
            long r106 = r105.getId();
        L12:
            gd0.b r107 = r111.f135075d;
            if (r107 == null) goto L17;
            Long r108 = r107.f480890a;
            if (r108 == null) goto L17;
            long r109 = r108.longValue();
        L18:
            gd0.b r112 = r111.f135075d;
            if (r112 == null) goto L23;
            Long r113 = r112.f480891b;
            if (r113 == null) goto L23;
            r102 = r113.longValue();
        L23:
            long r114 = r102;
            gd0.b r115 = r111.f135075d;
            if (r115 == null) goto L28;
            Integer r116 = r115.f480895f;
            if (r116 == null) goto L28;
            int r117 = r116.intValue();
        L29:
            CommentApi r118 = (CommentApi) com.bytedance.android.live.network.c.b().e(CommentApi.class);
            if (r118 == null) goto L38;
            Observable<Response<com.bytedance.android.livesdk.interactivity.api.comment.data.g>> r119 = r118.videoPinShare(r106, r109, r114, r117);
            if (r119 == null) goto L38;
            Observable<R> r120 = r119.compose(RxUtil.rxSchedulerHelper());
            if (r120 == 0) goto L38;
            Disposable r121 = r120.subscribe(new k(r111, r106), new l(r111));
            if (r121 == null) goto L38;
            RxUtilKt.c(r121, r111.f135080i);
        L38:
            VideoCommentPreviewFragment r122 = this.f135099a;
            Map<String, String> r123 = r122.V90();
            if (r122.f135090s == false) goto L41;
            String r124 = "on";
        L42:
            r123.put("pin_status", r124);
            j0.l().sendLog("livesdk_video_comment_send", r123, new Object[0]);
            return;
        L41:
            r124 = "off";
        L28:
            r117 = 0;
        L17:
            r109 = 0;
        L11:
            r106 = 0;
            goto L12
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135100a;

        public h(VideoCommentPreviewFragment r100) {
            this.f135100a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            k42.d r101 = (k42.d) r100;
            r r102 = this.f135100a.f135078g;
            if (r102 == null) goto L6;
            r102.c();
            return;
        }
    }

    public static final class i implements IMiddlewareHostBusiness.AwemeQueryCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCommentPreviewFragment f135101a;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeQueryCallBack
        public final void onBatchSuccess(HashMap<Long, Object> r100) {
        }

        public i(VideoCommentPreviewFragment r100) {
            this.f135101a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeQueryCallBack
        public final void onSuccess(Object r110, long r111) {
            if (r110 == null) goto L47;
            VideoCommentPreviewFragment r100 = this.f135101a;
            r100.f135093v = true;
            int r101 = r100.T90() - s1.f(100.0f);
            IMiddlewareHostBusiness r102 = (IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class);
            Context r103 = r100.getContext();
            IInteractService r112 = (IInteractService) jc1.k.n(IInteractService.class);
            Fragment r104 = null;
            if (r100.f135091t == false) goto L18;
            if (r112.getVideoTalkService() != null) goto L9;
        L11:
            com.bytedance.android.live.pushstream.d r105 = null;
        L13:
            if (r112.getAudioTalkService() != null) goto L15;
        L31:
            if (r105 == null) goto L35;
            d0 r113 = r105.A();
            if (r113 == null) goto L35;
            r113.h();
        L35:
            IMiddlewareHostBusiness.AwemeVideoPlayFragmentV2 r114 = r102.getLivePureVideoPlayFragmentV2(r110, r101, r103, 0);
            if (r114 == null) goto L38;
            r114.setCallback(new j(r100));
        L38:
            if (r114 == null) goto L40;
            r104 = r114.asFragment();
        L40:
            if (r104 == null) goto L46;
            FragmentTransaction r115 = r100.getChildFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r115, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "VideoCommentPreviewFragment", R.id.live_play_container) == true) goto L45;
            r115.add(R.id.live_play_container, r104, "VideoCommentPreviewFragment");
        L45:
            r115.commitAllowingStateLoss();
        L46:
            this.f135101a.W90(false, false);
            return;
        L15:
            if (r112.getAudioTalkService().getLiveStream() == null) goto L31;
            r105 = r112.getAudioTalkService().getLiveStream();
            goto L31
        L9:
            if (r112.getVideoTalkService().getLiveStream() == null) goto L11;
            r105 = r112.getVideoTalkService().getLiveStream();
            goto L13
        L18:
            if (r112.getVideoTalkService() != null) goto L20;
        L22:
            r105 = null;
        L24:
            if (r112.getAudioTalkService() == null) goto L29;
            if (r112.getAudioTalkService().getLiveStream() == null) goto L29;
            r105 = r112.getAudioTalkService().getLiveStream();
        L29:
            if (r112.getGuestRtcLiveStream() == null) goto L31;
            r105 = r112.getGuestRtcLiveStream();
            goto L31
        L20:
            if (r112.getVideoTalkService().getLiveStream() == null) goto L22;
            r105 = r112.getVideoTalkService().getLiveStream();
            goto L24
        L47:
            f2.b(R.string.ttlive_aweme_video_info_error, 0);
            VideoCommentPreviewFragment r116 = this.f135101a;
            int r106 = VideoCommentPreviewFragment.f135074w;
            r116.W90(false, true);
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeQueryCallBack
        public final void onFailure(String r100, String r101, String r102) {
            if (TextUtils.isEmpty(r101) == true) goto L6;
            f2.c(r101, 0);
        L9:
            VideoCommentPreviewFragment r103 = this.f135101a;
            int r104 = VideoCommentPreviewFragment.f135074w;
            r103.W90(false, true);
            return;
        L6:
            if (TextUtils.isEmpty(r102) == true) goto L8;
            f2.c(r102, 0);
            goto L9
        L8:
            f2.b(R.string.ttlive_aweme_video_info_error, 0);
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final int T90() {
        if (this.f135079h == false) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100 = this.f135077f;
        if (r100 == null) goto L7;
        int r101 = r100.X();
    L8:
        if (r101 <= 0) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135077f;
        if (r102 == null) goto L16;
        return r102.X();
    L16:
        return this.f135081j;
    L7:
        r101 = 0;
    L13:
        boolean r103 = this.f135079h;
        return this.f135081j;
    }

    public final Map<String, String> V90() {
        IRoomContextService r100 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        long r101 = 0;
        Boolean r102 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r100, null, 0, 3);
    L6:
        LinkedHashMap r104 = new LinkedHashMap();
        if (r103 == null) goto L13;
        com.bytedance.live.datacontext.m<IRoom> r105 = r103.getRoom();
        if (r105 == null) goto L13;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L13;
        String r107 = r106.getOwnerUserIdString();
    L14:
        if (r103 == null) goto L20;
        com.bytedance.live.datacontext.m<IRoom> r108 = r103.getRoom();
        if (r108 == null) goto L20;
        IRoom r109 = r108.getValue();
        if (r109 == null) goto L20;
        Long r110 = Long.valueOf(r109.getRoomId());
    L21:
        if (r103 == null) goto L24;
        r102 = r103.isAnchor();
    L24:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L26;
        String r111 = "anchor";
    L27:
        gd0.b r112 = this.f135075d;
        if (r112 == null) goto L32;
        Integer r113 = r112.f480895f;
        if (r113 == null) goto L32;
        int r114 = r113.intValue();
    L34:
        if (r114 != 1) goto L37;
        String r115 = IStrategyStateSupplier.KEY_INFO_LIKE;
    L42:
        gd0.b r116 = this.f135075d;
        if (r116 == null) goto L47;
        Long r117 = r116.f480890a;
        if (r117 == null) goto L47;
        r101 = r117.longValue();
    L47:
        r104.put("live_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog());
        r104.put("anchor_id", String.valueOf(r107));
        r104.put("room_id", String.valueOf(r110));
        r104.put("user_type", r111);
        r104.put("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionTypeForLog());
        r104.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionTypeForLog());
        r104.put("tab_send", r115);
        r104.put("video_id", String.valueOf(r101));
        return r104;
    L37:
        if (r114 != 2) goto L39;
        r115 = "favorite";
        goto L42
    L39:
        if (r114 != 3) goto L41;
        r115 = "create";
        goto L42
    L41:
        r115 = "watched";
    L32:
        r114 = 0;
        goto L34
    L26:
        r111 = "guest";
    L20:
        r110 = null;
    L13:
        r107 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    public VideoCommentPreviewFragment() {
        this.f135079h = true;
        this.f135080i = new CompositeDisposable();
        this.f135081j = 1400;
        this.f135090s = l42.a.f507333t.getValue().booleanValue();
        this.f135091t = true;
        this.f135092u = new b(this);
        this.f135093v = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f135080i.dispose();
        if (this.f135091t == true) goto L6;
        hd0.c.f().e(this.f135092u);
        return;
    }

    public static final void U90(VideoCommentPreviewFragment r100) {
        Map<String, String> r101 = r100.V90();
        if (r100.f135093v == false) goto L5;
        String r102 = "play";
    L6:
        r101.put("action_type", r102);
        j0.l().sendLog("livesdk_video_comment_preview_click", r101, new Object[0]);
        return;
    L5:
        r102 = "pause";
        goto L6
    }

    public final void X90(long r100) {
        if (r100 > 0) goto L11;
        f2.b(R.string.ttlive_aweme_video_info_error, 0);
        if (this.f135076e == null) goto L7;
        Intrinsics.checkNotNullParameter(InputDialogFragmentSwitchType.SLIDE_RIGHT, "switchType");
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
    L7:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f135077f;
        if (r101 == null) goto L15;
        r101.G(InputDialogFragmentSwitchType.SLIDE_RIGHT, this);
        return;
    L15:
        return;
    L11:
        W90(true, false);
        Disposable r102 = ((IMiddlewareHostBusiness) jc1.k.n(IMiddlewareHostBusiness.class)).queryAweme(r100, new i(this));
        if (r102 == null) goto L16;
        RxUtilKt.c(r102, this.f135080i);
        return;
    }

    public final void W90(boolean r100, boolean r101) {
        if (r100 == false) goto L9;
        ViewGroup r102 = this.f135086o;
        if (r102 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r102);
    L6:
        LiveDoubleColorBallAnimationView r103 = this.f135088q;
        if (r103 == null) goto L15;
        r103.b();
    L15:
        if (r101 == false) goto L19;
        ViewGroup r104 = this.f135087p;
        if (r104 == null) goto L23;
        UtilityKotlinExtentionsKt.w(r104);
        return;
    L23:
        return;
    L19:
        ViewGroup r105 = this.f135087p;
        if (r105 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r105);
        return;
    L25:
        return;
    L9:
        ViewGroup r106 = this.f135086o;
        if (r106 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r106);
    L12:
        LiveDoubleColorBallAnimationView r107 = this.f135088q;
        if (r107 == null) goto L15;
        r107.c();
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        gd0.b r102 = this.f135075d;
        if (r102 == null) goto L7;
        Long r103 = r102.f480890a;
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L8:
        X90(r104);
        Map<String, String> r105 = V90();
        j0.l().sendLog("livesdk_video_comment_preview", r105, new Object[0]);
        RxUtilKt.c(xs2.b.a().b(k42.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this)), this.f135080i);
        return;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_input_video_comment_preview_fragment, r101, false);
        IRoomContextService r104 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r106 = IRoomContextService.a.a(r104, null, 0, 3);
        if (r106 == null) goto L9;
        Boolean r107 = r106.isAnchor();
        if (r107 == null) goto L9;
        boolean r108 = r107.booleanValue();
    L10:
        this.f135091t = r108;
        ((ViewGroup) r103.findViewById(R.id.video_comment_preview_panel)).setOnClickListener(c.f135095a);
        this.f135086o = (ViewGroup) r103.findViewById(R.id.live_play_loading);
        this.f135087p = (ViewGroup) r103.findViewById(R.id.live_play_retry);
        this.f135088q = (LiveDoubleColorBallAnimationView) r103.findViewById(R.id.loading_progress);
        Button r109 = (Button) r103.findViewById(R.id.live_play_retry_btn);
        if (r109 == null) goto L13;
        r109.setOnClickListener(new d(this));
    L13:
        View r110 = r103.findViewById(R.id.preview_back);
        this.f135082k = r110;
        if (r110 == null) goto L16;
        r110.setOnClickListener(new e(this));
    L16:
        this.f135085n = (ImageView) r103.findViewById(R.id.pin_select);
        this.f135084m = (ViewGroup) r103.findViewById(R.id.video_pin_check);
        this.f135089r = (FrameLayout) r103.findViewById(R.id.live_play_container);
        if (this.f135091t == false) goto L33;
        IRoomContextService r111 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r111 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.o r112 = IRoomContextService.a.a(r111, null, 0, 3);
        if (r112 == null) goto L27;
        com.bytedance.live.datacontext.m<IRoom> r113 = r112.getRoom();
        if (r113 == null) goto L27;
        IRoom r114 = r113.getValue();
        if (r114 == null) goto L27;
        String r115 = r114.getAnchorAbValue("live_video_on_wall");
    L29:
        if (TextUtils.equals("1", r115) == false) goto L33;
        z.f133764a.getClass();
        if (z.a.b().f() == true) goto L33;
        boolean r116 = true;
    L34:
        if (r116 == false) goto L41;
        ViewGroup r117 = this.f135084m;
        if (r117 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r117);
    L38:
        ViewGroup r118 = this.f135084m;
        if (r118 == null) goto L47;
        r118.setOnClickListener(new f(this));
    L47:
        if (r116 == true) goto L49;
        this.f135090s = false;
    L49:
        ViewGroup r119 = (ViewGroup) r103.findViewById(R.id.video_pin_send);
        this.f135083l = r119;
        if (r119 == null) goto L52;
        r119.setOnClickListener(new g(this));
    L52:
        ViewGroup r120 = this.f135083l;
        if (r120 == null) goto L55;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
    L57:
        if ((r121 instanceof RelativeLayout.LayoutParams) == false) goto L60;
        r105 = r121;
    L60:
        RelativeLayout.LayoutParams r122 = (RelativeLayout.LayoutParams) r105;
        if (r122 == null) goto L69;
        if (r116 == false) goto L64;
        r122.addRule(11);
    L65:
        ViewGroup r123 = this.f135083l;
        if (r123 == null) goto L69;
        r123.setLayoutParams(r122);
        goto L69
    L64:
        r122.addRule(13);
    L69:
        if (this.f135090s == false) goto L73;
        ImageView r124 = this.f135085n;
        if (r124 == null) goto L77;
        r124.setBackgroundResource(R.drawable.ttlive_video_comment_select_panel_select_bg);
    L77:
        if (this.f135091t == true) goto L79;
        hd0.c.f().c(this.f135092u);
    L79:
        return r103;
    L73:
        ImageView r125 = this.f135085n;
        if (r125 == null) goto L77;
        r125.setBackgroundResource(R.drawable.ttlive_video_comment_select_panel_unselect_bg);
        goto L77
    L55:
        r121 = null;
        goto L57
    L41:
        ViewGroup r126 = this.f135084m;
        if (r126 == null) goto L44;
        UtilityKotlinExtentionsKt.t(r126);
    L44:
        ViewGroup r127 = this.f135084m;
        if (r127 == null) goto L47;
        r127.setOnClickListener(null);
    L27:
        r115 = null;
    L33:
        r116 = false;
    L9:
        r108 = false;
        goto L10
    }
}
