package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdk.feedback.view.preview.LargeCardReplaceViewGroup;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class LargeCardPreviewFeedback implements dx1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LargeCardReplaceViewGroup f124898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SimpleDraweeView f124899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleDraweeView f124900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimpleMediaView f124901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GridLayout f124902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f124903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f124904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f124905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f124906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f124907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FeedbackCard f124908k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Question f124909l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f124910m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f124911n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f124912o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f124913p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f124914q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f124915r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Context f124916s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FeedbackContext f124917t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function0<Unit> f124918u;

    public static final class a {
    }

    public static final class b implements kx1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LargeCardPreviewFeedback f124919a;

        public b(LargeCardPreviewFeedback r100) {
            this.f124919a = r100;
        }

        @Override // kx1.d
        public final void a(Option r210) {
            Intrinsics.checkNotNullParameter(r210, "option");
            LargeCardPreviewFeedback r100 = this.f124919a;
            r100.getClass();
            StringBuilder r101 = new StringBuilder();
            Question r102 = r100.f124909l;
            String r103 = "";
            if (r102 == null) goto L6;
            String r104 = r102.questionKey;
            if (r104 == null) goto L6;
        L7:
            r101.append(r104);
            r101.append('-');
            r101.append(r210.key);
            String r110 = r101.toString();
            IFeedbackApi r105 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
            FeedbackCard r106 = r100.f124908k;
            long r107 = 0;
            if (r106 == null) goto L12;
            Long r108 = r106.feedbackId;
            if (r108 == null) goto L12;
            long r109 = r108.longValue();
        L13:
            LargeCardReplaceViewGroup r111 = r100.f124898a;
            if (r111 == null) goto L20;
            RoomCardStruct r112 = r111.getCurRoom();
            if (r112 == null) goto L20;
            Room r113 = r112.room;
            if (r113 == null) goto L20;
            r107 = r113.f162599id;
        L20:
            long r114 = r107;
            String r115 = r100.f124917t.getReqId();
            if (r115 != null) goto L23;
            String r116 = "";
        L24:
            String r117 = r100.f124917t.getEnterFromMerge();
            if (r117 != null) goto L27;
            String r118 = "";
        L28:
            String r119 = r100.f124917t.getEnterMethod();
            if (r119 != null) goto L31;
            String r120 = "";
        L32:
            String r121 = r100.f124917t.getReqId();
            if (r121 != null) goto L35;
            String r122 = "";
        L36:
            ILiveFeedbackService r123 = (ILiveFeedbackService) r100.f124915r.getValue();
            if (r123 == null) goto L42;
            String r124 = r123.getRecentRoomIds();
            if (r124 == null) goto L42;
            String r125 = r124;
        L43:
            r100.f124910m = IFeedbackApi.CC.feedbackRequest$default(r105, r109, r114, r110, r116, r118, r120, r122, null, r125, 128, null).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(c.f124978a, d.f124979a);
            LargeCardPreviewFeedback r126 = this.f124919a;
            if (Intrinsics.areEqual(r210.negative, Boolean.TRUE) == false) goto L46;
            String r127 = AppConstants.BUNDLE_DISLIKE;
        L47:
            r126.getClass();
            LinkedHashMap r128 = new LinkedHashMap();
            FeedbackContext.a r129 = FeedbackContext.Companion;
            int r130 = r126.hashCode();
            r129.getClass();
            FeedbackContext r131 = FeedbackContext.a.a(r130);
            if (r131 == null) goto L51;
            String r132 = r131.getEnterFromMerge();
            if (r132 == null) goto L51;
        L52:
            r128.put("enter_from_merge", r132);
            FeedbackContext r133 = FeedbackContext.a.a(r126.hashCode());
            if (r133 == null) goto L56;
            String r134 = r133.getEnterMethod();
            if (r134 == null) goto L56;
        L57:
            r128.put("enter_method", r134);
            FeedbackCard r135 = r126.f124908k;
            if (r135 == null) goto L63;
            Room r136 = r135.room;
            if (r136 == null) goto L63;
            String r137 = String.valueOf(r136.f162599id);
            if (r137 == null) goto L63;
        L64:
            r128.put("room_id", r137);
            FeedbackCard r138 = r126.f124908k;
            if (r138 == null) goto L72;
            Room r139 = r138.room;
            if (r139 == null) goto L72;
            User r140 = r139.mo8271getOwner();
            if (r140 == null) goto L72;
            String r141 = r140.getIdString();
            if (r141 == null) goto L72;
        L73:
            r128.put("anchor_id", r141);
            FeedbackContext r142 = FeedbackContext.a.a(r126.hashCode());
            if (r142 == null) goto L77;
            String r143 = r142.getReqId();
            if (r143 == null) goto L77;
        L78:
            r128.put("request_id", r143);
            FeedbackCard r144 = r126.f124908k;
            if (r144 == null) goto L84;
            Long r145 = r144.feedbackId;
            if (r145 == null) goto L84;
            String r146 = String.valueOf(r145.longValue());
            if (r146 == null) goto L84;
        L85:
            r128.put("feedback_id", r146);
            FeedbackCard r147 = r126.f124908k;
            if (r147 == null) goto L91;
            Integer r148 = r147.getIndex();
            if (r148 == null) goto L91;
            String r149 = String.valueOf(r148.intValue());
            if (r149 == null) goto L91;
        L92:
            r128.put(ILiveRoomPlayFragmentConstant.ORDER_CENTER_DRAW_INDEX, r149);
            r128.put("flow_type", "internal_flow");
            FeedbackCard r150 = r126.f124908k;
            if (r150 == null) goto L98;
            String r151 = r150.getLogInfo();
            if (r151 == null) goto L98;
            r103 = r151;
        L98:
            r128.put("question_text", r103);
            r128.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "big_card");
            r128.put("question_type", BdpAppEventConstant.MULTIPLE);
            r128.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r127);
            u.l().sendLog("livesdk_live_feedback_card_click", r128, new Object[0]);
            LargeCardReplaceViewGroup r152 = this.f124919a.f124898a;
            if (r152 == null) goto L110;
            com.bytedance.android.livesdk.feedback.view.preview.j r153 = r152.c();
            if (r153 != null) goto L104;
            return;
        L104:
            if (Intrinsics.areEqual(r153, com.bytedance.android.livesdk.feedback.view.preview.j.a.f125020a) == false) goto L111;
            this.f124919a.f124918u.invoke();
            String r154 = r210.toastText;
            if (r154 != null) goto L108;
            r154 = s1.B(R.string.ttlive_live_feedback_submit_positive_toast);
        L108:
            f2.c(r154, 0);
            return;
        L111:
            return;
        L110:
            return;
        L91:
            r149 = "";
        L84:
            r146 = "";
        L77:
            r143 = "";
        L72:
            r141 = "";
        L63:
            r137 = "";
        L56:
            r134 = "";
        L51:
            r132 = "";
            goto L52
        L46:
            r127 = IStrategyStateSupplier.KEY_INFO_LIKE;
        L42:
            r125 = "";
            goto L43
        L35:
            r122 = r121;
            goto L36
        L31:
            r120 = r119;
            goto L32
        L27:
            r118 = r117;
            goto L28
        L23:
            r116 = r115;
        L12:
            r109 = 0;
        L6:
            r104 = "";
            goto L7
        }
    }

    static {
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onSlide() {
    }

    @Override // dx1.a
    public final void onDestroy() {
        Disposable r100 = this.f124910m;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // dx1.a
    public final void startRoom() {
        LargeCardReplaceViewGroup r100 = this.f124898a;
        if (r100 == null) goto L26;
        com.bytedance.android.livesdk.feedback.view.preview.b r101 = r100.f125001b;
        if (r101 == null) goto L7;
        r101.startPreview();
    L7:
        com.bytedance.android.livesdk.feedback.view.preview.b r102 = r100.f125002c;
        if (r102 == null) goto L26;
        r102.startPreview();
    L26:
        SimpleMediaView r103 = this.f124901d;     // Catch: Exception -> L24
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.h() == false) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L21;
        r103 = null;
    L21:
        if (r103 == null) goto L29;
        r103.setPlayEntity((tic.a) this.f124911n.getValue());     // Catch: Exception -> L24
        r103.k();     // Catch: Exception -> L24
        r103.setLoop(true);     // Catch: Exception -> L24
        return;
    L29:
        return;
    L15:
        if (((tic.a) this.f124911n.getValue()) == null) goto L17;
        r104 = true;
    L24:
        ALogger.d("FeedbackMediaPlayError", "LargePreviewQuestion");
    }

    @Override // dx1.a
    public final void stopRoom() {
        LargeCardReplaceViewGroup r100 = this.f124898a;
        if (r100 == null) goto L10;
        com.bytedance.android.livesdk.feedback.view.preview.b r101 = r100.f125001b;
        if (r101 == null) goto L7;
        r101.stopPreview();
    L7:
        com.bytedance.android.livesdk.feedback.view.preview.b r102 = r100.f125002c;
        if (r102 == null) goto L10;
        r102.stopPreview();
    L10:
        SimpleMediaView r103 = this.f124901d;
        if (r103 == null) goto L14;
        r103.m();
        return;
    }

    @Override // dx1.a
    public final void c(FeedbackCard r100) {
        this.f124908k = r100;
        List<Option> r101 = null;
        if (r100 == null) goto L7;
        List<Question> r102 = r100.question;
        if (r102 == null) goto L7;
        Question r103 = (Question) ListProtector.get(r102, 0);
    L8:
        this.f124909l = r103;
        TextView r104 = this.f124905h;
        if (r104 == null) goto L16;
        if (r103 == null) goto L14;
        String r105 = r103.questionText;
        if (r105 == null) goto L14;
    L15:
        r104.setText(r105);
    L14:
        r105 = "";
    L16:
        TextView r106 = this.f124903f;
        if (r106 == null) goto L24;
        if (r100 == null) goto L22;
        String r107 = r100.title;
        if (r107 == null) goto L22;
    L23:
        r106.setText(r107);
    L22:
        r107 = s1.B(R.string.ttlive_live_feedback_preview_title);
    L24:
        LargeCardReplaceViewGroup r108 = this.f124898a;
        if (r108 == null) goto L31;
        Question r109 = this.f124909l;
        if (r109 == null) goto L29;
        List<RoomCardStruct> r110 = r109.rooms;
    L30:
        r108.b(r110, this.f124917t);
        goto L31
    L29:
        r110 = null;
    L31:
        GridLayout r111 = this.f124902e;
        if (r111 == null) goto L34;
        r111.removeAllViews();
    L34:
        lx1.d r112 = (lx1.d) this.f124913p.getValue();
        Question r113 = this.f124909l;
        if (r113 == null) goto L37;
        r101 = r113.options;
    L37:
        List<kx1.g> r114 = r112.a(r101);
        if (r114 == null) goto L45;
        Iterator<T> r115 = r114.iterator();
    L41:
        if (r115.hasNext() == false) goto L45;
        kx1.g r116 = (kx1.g) r115.next();
        GridLayout r117 = this.f124902e;
        if (r117 == null) goto L41;
        r117.addView(r116);
    L45:
        SimpleDraweeView r118 = this.f124899b;
        if (r118 == null) goto L48;
        r118.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L48:
        SimpleDraweeView r119 = this.f124900c;
        if (r119 == null) goto L57;
        r119.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
        return;
    L57:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // dx1.a
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f124898a = (LargeCardReplaceViewGroup) r100.findViewById(R.id.preview_card);
        this.f124899b = (SimpleDraweeView) r100.findViewById(R.id.bg_anim);
        this.f124900c = (SimpleDraweeView) r100.findViewById(R.id.guide_layout);
        this.f124901d = (SimpleMediaView) r100.findViewById(R.id.media_play);
        this.f124902e = (GridLayout) r100.findViewById(R.id.options_container);
        this.f124906i = (ViewGroup) r100.findViewById(R.id.preview_area);
        this.f124905h = (TextView) r100.findViewById(R.id.question_title);
        this.f124903f = (TextView) r100.findViewById(R.id.feedback_title);
        this.f124904g = (ViewGroup) r100.findViewById(R.id.question_tag);
        this.f124907j = (TextView) r100.findViewById(R.id.slide_tag);
        Pair<Float, Float> r101 = com.bytedance.android.livesdk.feedback.c.a(0.57391304f, UtilityKotlinExtentionsKt.h(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN), UtilityKotlinExtentionsKt.h(100));
        ViewGroup r102 = this.f124906i;
        Integer r103 = null;
        if (r102 == null) goto L5;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
    L6:
        if (r104 == null) goto L10;
        r104.width = (int) r101.getFirst().floatValue();
        r104.height = (int) r101.getSecond().floatValue();
        ViewGroup r105 = this.f124906i;
        if (r105 == null) goto L10;
        r105.setLayoutParams(r104);
    L10:
        TextView r106 = this.f124907j;
        int r107 = 8;
        if (r106 == null) goto L23;
        j5 r108 = (j5) this.f124914q.getValue();
        if (r108 == null) goto L15;
        Integer r109 = r108.guideVisible;
    L16:
        if (r109 != null) goto L19;
    L21:
        int r110 = 8;
    L22:
        r106.setVisibility(r110);
        goto L23
    L19:
        if (r109.intValue() != 1) goto L21;
        r110 = 0;
        goto L22
    L15:
        r109 = null;
    L23:
        ViewGroup r111 = this.f124904g;
        if (r111 == null) goto L35;
        j5 r112 = (j5) this.f124914q.getValue();
        if (r112 == null) goto L28;
        r103 = r112.titleVisible;
    L28:
        if (r103 != null) goto L31;
    L33:
        r111.setVisibility(r107);
        return;
    L31:
        if (r103.intValue() != 1) goto L33;
        r107 = 0;
        goto L33
    L35:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // dx1.a
    public final View a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_layout_preview_large_feedback_fragment, r101, false);
    }

    public LargeCardPreviewFeedback(Context r100, FeedbackContext r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedbackContext");
        Intrinsics.checkNotNullParameter(r102, "onSubmit");
        this.f124916s = r100;
        this.f124917t = r101;
        this.f124918u = r102;
        this.f124911n = LazyKt.lazy(new LargeCardPreviewFeedback$musicEntity$2(this));
        this.f124912o = new b(this);
        this.f124913p = LazyKt.lazy(new LargeCardPreviewFeedback$optionFactory$2(this));
        this.f124914q = LazyKt.lazy(LargeCardPreviewFeedback$mFeedbackConfig$2.INSTANCE);
        this.f124915r = LazyKt.lazy(LargeCardPreviewFeedback$feedbackService$2.INSTANCE);
    }
}
