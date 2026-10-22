package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.config.u4;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class RoomQuestionFeedback implements dx1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f124926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f124927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f124928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f124929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SimpleDraweeView f124930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SimpleDraweeView f124931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SimpleMediaView f124932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f124933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f124934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f124935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FeedbackCard f124936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Question f124937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LivePlayerView f124938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ILivePlayerClient f124939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public nx1.b f124940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f124941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f124942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f124943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f124944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f124945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function0<Unit> f124946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f124947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f124948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FeedbackContext f124949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Function0<Unit> f124950y;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomQuestionFeedback f124951a;

        public a(RoomQuestionFeedback r100) {
            this.f124951a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f124951a.f124946u.invoke();
        }
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // dx1.a
    public final void startRoom() {
        ViewParent r100 = null;
        SimpleMediaView r101 = this.f124932g;     // Catch: Exception -> L17
        if (r101 != null) goto L6;
    L18:
        FeedbackCard r102 = this.f124936k;
        if (r102 == null) goto L49;
        final Room r103 = r102.room;
        if (r103 == null) goto L52;
        FrameLayout r104 = this.f124927b;     // Catch: Exception -> L44
        if (r104 == null) goto L50;
        d(this.f124948w, r103);     // Catch: Exception -> L44
        if (r104.indexOfChild(this.f124938m) >= 0) goto L40;
        LivePlayerView r105 = this.f124938m;     // Catch: Exception -> L44
        if (r105 == null) goto L36;
        r105.setVisibility(8);     // Catch: Exception -> L44
        ViewParent r106 = r105.getParent();     // Catch: Exception -> L44
        if ((r106 instanceof ViewGroup) == false) goto L33;
        r100 = r106;
    L33:
        ViewGroup r107 = (ViewGroup) r100;     // Catch: Exception -> L44
        if (r107 == null) goto L36;
        r107.removeView(this.f124938m);     // Catch: Exception -> L44
    L36:
        LivePlayerView r108 = this.f124938m;     // Catch: Exception -> L44
        if (r108 == null) goto L39;
        r108.setVisibility(0);     // Catch: Exception -> L44
    L39:
        r104.addView(this.f124938m);     // Catch: Exception -> L44
    L40:
        LiveRequest r109 = new LiveRequest.Builder().streamData(r103.getMultiStreamData()).resolution(ResolutionManager.getMultiStreamDefaultQualitySdkKey$default(ResolutionManager.INSTANCE, r103, false, true, 2, null)).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r103.getStreamType())).preview(true).mute(true).build();     // Catch: Exception -> L44
        ILivePlayerClient r110 = this.f124939n;     // Catch: Exception -> L44
        if (r110 == null) goto L51;
        r110.stream(r109, new RoomQuestionFeedback$innerPlay$$inlined$let$lambda$1(this, r103));     // Catch: Exception -> L44
        return;
    L51:
        return;
    L50:
        return;
    L53:
        return;
    L52:
        return;
    L49:
        return;
    L6:
        if (r101.h() == false) goto L8;
    L10:
        boolean r111 = false;
    L11:
        if (r111 == true) goto L14;
        r101 = null;
    L14:
        if (r101 == null) goto L18;
        r101.setPlayEntity((tic.a) this.f124944s.getValue());     // Catch: Exception -> L17
        r101.k();     // Catch: Exception -> L17
        r101.setLoop(true);     // Catch: Exception -> L17
        goto L18
    L8:
        if (((tic.a) this.f124944s.getValue()) == null) goto L10;
        r111 = true;
    L17:
        ALogger.d("FeedbackMediaPlayError", "RoomQuestion");
        goto L18
    }

    public final boolean e() {
        Integer r100 = u4.f121344a.getValue().disableSubmitButton;
        if (r100 != null) goto L6;
    L16:
        return false;
    L6:
        if (r100.intValue() != 1) goto L16;
        Question r101 = this.f124937l;
        if (r101 == null) goto L10;
        Long r102 = r101.type;
    L11:
        if (r102 == null) goto L16;
        if (r102.longValue() != 1) goto L16;
        return true;
    L10:
        r102 = null;
        goto L11
    }

    @Override // dx1.a
    public final void onSlide() {
        nx1.b r100 = this.f124940o;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        this.f124940o = null;
        f(false);
    }

    @Override // dx1.a
    public final void stopRoom() {
        ILivePlayerClient r100 = this.f124939n;
        if (r100 != null) goto L5;
    L12:
        SimpleMediaView r101 = this.f124932g;
        if (r101 == null) goto L16;
        r101.m();
        return;
    L16:
        return;
    L5:
        if (r100.isPlaying() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.stopAndRelease(this.f124948w);
        HSImageView r102 = this.f124929d;
        if (r102 == null) goto L12;
        r102.setVisibility(0);
        goto L12
    }

    @Override // dx1.a
    public final void c(FeedbackCard r110) {
        if (r110 == null) goto L128;
        List<Question> r100 = r110.question;
        if (r100 == null) goto L129;
        Integer r101 = null;
        if ((!r100.isEmpty()) == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L130;
        Question r102 = (Question) ListProtector.get(r100, 0);
        if (r102 == null) goto L133;
        TextView r103 = this.f124933h;
        if (r103 == null) goto L20;
        String r104 = r110.title;
        if (r104 != null) goto L19;
        r104 = s1.B(R.string.ttlive_live_feedback_preview_title);
    L19:
        r103.setText(r104);
    L20:
        this.f124936k = r110;
        this.f124937l = r102;
        Object r105 = (nx1.b) this.f124941p.getValue();
        if ((r105 instanceof View) == true) goto L23;
        r105 = null;
    L23:
        View r106 = (View) r105;
        if (r106 == null) goto L31;
        ViewGroup r107 = this.f124926a;
        if (r107 == null) goto L28;
        r107.removeAllViews();
    L28:
        ViewGroup r108 = this.f124926a;
        if (r108 == null) goto L31;
        r108.addView(r106);
    L31:
        HSImageView r109 = this.f124929d;
        FeedbackCard r111 = this.f124936k;
        if (r111 == null) goto L36;
        Room r112 = r111.room;
        if (r112 == null) goto L36;
        py.k r113 = r112.getCover();
    L37:
        ImageLoader.bindImage(r109, r113);
        SimpleDraweeView r114 = this.f124930e;
        if (r114 == null) goto L40;
        r114.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L40:
        SimpleDraweeView r115 = this.f124931f;
        if (r115 == null) goto L43;
        r115.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
    L43:
        f(false);
        TextView r116 = this.f124928c;
        if (r116 != null) goto L46;
    L50:
        Room r117 = r110.room;
        if (r117 == null) goto L131;
        long r118 = r117.f162599id;
        Long r119 = this.f124949x.getMPreRoomId();
        if (r119 != null) goto L56;
    L57:
        boolean r120 = true;
    L59:
        if (r120 == false) goto L61;
        Room r121 = r117;
    L62:
        if (r121 == null) goto L132;
        LinkedHashMap r122 = new LinkedHashMap();
        FeedbackContext.a r123 = FeedbackContext.Companion;
        int r124 = hashCode();
        r123.getClass();
        FeedbackContext r125 = FeedbackContext.a.a(r124);
        String r126 = "";
        if (r125 == null) goto L67;
        String r127 = r125.getEnterFromMerge();
        if (r127 == null) goto L67;
    L68:
        r122.put("enter_from_merge", r127);
        FeedbackContext r128 = FeedbackContext.a.a(hashCode());
        if (r128 == null) goto L72;
        String r129 = r128.getEnterMethod();
        if (r129 == null) goto L72;
    L73:
        r122.put("enter_method", r129);
        String r130 = String.valueOf(r117.f162599id);
        if (r130 != null) goto L76;
        r130 = "";
    L76:
        r122.put("room_id", r130);
        User r131 = r117.mo8271getOwner();
        if (r131 == null) goto L80;
        String r132 = r131.getIdString();
        if (r132 == null) goto L80;
    L81:
        r122.put("anchor_id", r132);
        String r133 = this.f124949x.getReqId();
        if (r133 != null) goto L84;
        r133 = "";
    L84:
        r122.put("request_id", r133);
        FeedbackCard r134 = this.f124949x.getMFeedbackCard();
        if (r134 == null) goto L90;
        Long r135 = r134.feedbackId;
        if (r135 == null) goto L90;
        String r136 = String.valueOf(r135.longValue());
        if (r136 == null) goto L90;
    L91:
        r122.put("feedback_id", r136);
        FeedbackCard r137 = this.f124949x.getMFeedbackCard();
        if (r137 == null) goto L97;
        Integer r138 = r137.getIndex();
        if (r138 == null) goto L97;
        String r139 = String.valueOf(r138.intValue());
        if (r139 == null) goto L97;
    L98:
        r122.put(ILiveRoomPlayFragmentConstant.ORDER_CENTER_DRAW_INDEX, r139);
        r122.put("flow_type", "internal_flow");
        FeedbackCard r140 = this.f124949x.getMFeedbackCard();
        if (r140 == null) goto L102;
        String r141 = r140.getLogInfo();
        if (r141 == null) goto L102;
    L103:
        r122.put("question_text", r141);
        r122.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "questionnaire");
        FeedbackCard r142 = this.f124936k;
        if (r142 == null) goto L106;
        r101 = r142.feedbackType;
    L106:
        if (r101 != null) goto L109;
    L111:
        if (r101 != null) goto L114;
    L116:
        if (r101 != null) goto L119;
    L121:
        if (r101 != null) goto L124;
    L126:
        r122.put("question_type", r126);
        LiveMode r143 = r117.getStreamType();
        int r144 = h1.f66189a;
        r122.put("live_type", i1.a(r143));
        r122.put("error_type", "bind_room_no_show");
        u.l().sendLog("livesdk_live_feedback_card_show_error", r122, new Object[0]);
        return;
    L124:
        if (r101.intValue() != 3) goto L126;
    L125:
        r126 = BdpAppEventConstant.MULTIPLE;
        goto L126
    L119:
        if (r101.intValue() != 4) goto L121;
    L114:
        if (r101.intValue() != 2) goto L116;
        r126 = "whole";
        goto L126
    L109:
        if (r101.intValue() != 1) goto L111;
        r126 = "single";
    L102:
        r141 = "";
    L97:
        r139 = "";
    L90:
        r136 = "";
    L80:
        r132 = "";
    L72:
        r129 = "";
    L67:
        r127 = "";
        goto L68
    L132:
        return;
    L61:
        r121 = null;
        goto L62
    L56:
        if (r118 != r119.longValue()) goto L57;
        r120 = false;
        goto L59
    L131:
        return;
    L46:
        if (e() == false) goto L48;
        int r145 = 4;
    L49:
        r116.setVisibility(r145);
        goto L50
    L48:
        r145 = 0;
    L36:
        r113 = null;
        goto L37
    L133:
        return;
    L130:
        return;
    L129:
        return;
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L12;
        TextView r101 = this.f124928c;
        if (r101 == null) goto L6;
        r101.setClickable(true);
    L6:
        TextView r102 = this.f124928c;
        if (r102 == null) goto L9;
        r102.setTextColor(s1.h(R.color.ttlive_feedback_submit_clickable));
    L9:
        TextView r103 = this.f124928c;
        if (r103 == null) goto L22;
        r103.setBackgroundResource(R.drawable.ttlive_bg_feedback_submit_enable);
        return;
    L22:
        return;
    L12:
        TextView r104 = this.f124928c;
        if (r104 == null) goto L15;
        r104.setClickable(false);
    L15:
        TextView r105 = this.f124928c;
        if (r105 == null) goto L18;
        r105.setTextColor(s1.h(R.color.ttlive_feedback_submit_un_clickable));
    L18:
        TextView r106 = this.f124928c;
        if (r106 == null) goto L24;
        r106.setBackgroundResource(R.drawable.ttlive_bg_feedback_submit_disable);
        return;
    }

    @Override // dx1.a
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f124926a = (ViewGroup) r100.findViewById(R.id.question_container);
        this.f124927b = (FrameLayout) r100.findViewById(R.id.preview_container);
        this.f124928c = (TextView) r100.findViewById(R.id.submit_button);
        this.f124929d = (HSImageView) r100.findViewById(R.id.preview_cover);
        this.f124930e = (SimpleDraweeView) r100.findViewById(R.id.bg_anim);
        this.f124931f = (SimpleDraweeView) r100.findViewById(R.id.guide_layout);
        TextView r101 = this.f124928c;
        if (r101 == null) goto L5;
        r101.setOnClickListener(this.f124947v);
    L5:
        this.f124932g = (SimpleMediaView) r100.findViewById(R.id.media_play);
        this.f124933h = (TextView) r100.findViewById(R.id.feedback_title);
        this.f124934i = (TextView) r100.findViewById(R.id.slide_tag);
        this.f124935j = (ViewGroup) r100.findViewById(R.id.question_tag);
        TextView r102 = this.f124934i;
        int r103 = 0;
        Integer r104 = null;
        if (r102 == null) goto L18;
        j5 r105 = (j5) this.f124942q.getValue();
        if (r105 == null) goto L10;
        Integer r106 = r105.guideVisible;
    L11:
        if (r106 != null) goto L14;
    L16:
        int r107 = 8;
    L17:
        r102.setVisibility(r107);
        goto L18
    L14:
        if (r106.intValue() != 1) goto L16;
        r107 = 0;
        goto L17
    L10:
        r106 = null;
    L18:
        ViewGroup r108 = this.f124935j;
        if (r108 == null) goto L31;
        j5 r109 = (j5) this.f124942q.getValue();
        if (r109 == null) goto L23;
        r104 = r109.titleVisible;
    L23:
        if (r104 != null) goto L26;
    L28:
        r103 = 4;
    L29:
        r108.setVisibility(r103);
        return;
    L26:
        if (r104.intValue() != 1) goto L28;
    }

    @Override // dx1.a
    public final View a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_layout_room_feedback_fragment, r101, false);
    }

    public final void d(Context r100, Room r101) {
        LivePlayerView r102 = this.f124938m;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == true) goto L7;
        r103 = null;
    L7:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L10;
        r104.removeView(this.f124938m);
    L10:
        LivePlayerView r105 = new LivePlayerView(r100, LivePlayerConfig.Companion.buildWith(LivePlayerScene.INSTANCE.getFEEDBACK_PREVIEW(), r101.getIdStr()));
        this.f124938m = r105;
        this.f124939n = r105.getClient();
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -1);
        r106.gravity = 17;
        LivePlayerView r107 = this.f124938m;
        if (r107 == null) goto L13;
        r107.setLayoutParams(r106);
    L13:
        LivePlayerView r108 = this.f124938m;
        if (r108 == null) goto L18;
        IRenderView r109 = r108.getRenderView();
        if (r109 == null) goto L18;
        r109.setLayoutParams(r106);
    L18:
        LivePlayerView r110 = this.f124938m;
        if (r110 == null) goto L21;
        r110.setVisibility(0);
    L21:
        LivePlayerView r111 = this.f124938m;
        if (r111 == null) goto L25;
        r111.setScaleType(2);
        return;
    }

    public RoomQuestionFeedback(Context r100, FeedbackContext r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedbackContext");
        Intrinsics.checkNotNullParameter(r102, "onSubmit");
        this.f124948w = r100;
        this.f124949x = r101;
        this.f124950y = r102;
        this.f124941p = LazyKt.lazy(new RoomQuestionFeedback$questionView$2(this));
        this.f124942q = LazyKt.lazy(RoomQuestionFeedback$mFeedbackConfig$2.INSTANCE);
        this.f124943r = LazyKt.lazy(new RoomQuestionFeedback$questionSelectListener$2(this));
        this.f124944s = LazyKt.lazy(new RoomQuestionFeedback$musicEntity$2(this));
        this.f124945t = LazyKt.lazy(RoomQuestionFeedback$feedbackService$2.INSTANCE);
        this.f124946u = new RoomQuestionFeedback$submitAction$1(this);
        this.f124947v = new a(this);
    }
}
