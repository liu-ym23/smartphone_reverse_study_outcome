package com.bytedance.android.livesdk.feedback.view.feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.j5;
import com.bytedance.android.livesdk.config.u4;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class GlobalQuestionFeedback implements dx1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f124871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f124872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f124873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimpleDraweeView f124874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SimpleDraweeView f124875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SimpleMediaView f124876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f124877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f124878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FeedbackCard f124879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Question> f124880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public nx1.a f124881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public nx1.a f124882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f124883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f124884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f124885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f124886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f124887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f124888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f124889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f124890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FeedbackContext f124891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Function0<Unit> f124892v;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GlobalQuestionFeedback f124893a;

        public a(GlobalQuestionFeedback r100) {
            this.f124893a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GlobalQuestionFeedback r100 = this.f124893a;     // Catch: Throwable -> L14
            ViewGroup r101 = r100.f124873c;     // Catch: Throwable -> L14
            float r102 = 0.0f;
            if (r101 == null) goto L8;
            if (r101 == null) goto L6;
            float r103 = r100.e() - r101.getY();     // Catch: Throwable -> L14
        L7:
            r101.setTranslationY(r103);     // Catch: Throwable -> L14
            goto L8
        L6:
            r103 = 0.0f;
        L8:
            GlobalQuestionFeedback r104 = this.f124893a;     // Catch: Throwable -> L14
            ViewGroup r105 = r104.f124871a;     // Catch: Throwable -> L14
            if (r105 == null) goto L17;
            if (r105 == null) goto L12;
            r102 = ((r104.e() * 2) + UtilityKotlinExtentionsKt.h(24)) - r105.getY();     // Catch: Throwable -> L14
        L12:
            r105.setTranslationY(r102);     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GlobalQuestionFeedback f124894a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f124895a = null;

            static {
                f124895a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Consumer
            public final /* bridge */ /* synthetic */ void accept(Object r100) {
                Response r101 = (Response) r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.view.feedback.GlobalQuestionFeedback$b$b, reason: collision with other inner class name */
        public static final class C2005b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2005b f124896a = null;

            static {
                f124896a = new C2005b();
            }

            public C2005b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                ALogger.d("FeedbackSubmitError", "GlobalQuestion");
            }
        }

        public b(GlobalQuestionFeedback r100) {
            this.f124894a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            ArrayList r100 = new ArrayList();
            nx1.a r101 = this.f124894a.f124881k;
            if (r101 == null) goto L5;
            r100.add(r101.getSelectResult());
        L5:
            nx1.a r102 = this.f124894a.f124882l;
            if (r102 == null) goto L8;
            r100.add(r102.getSelectResult());
        L8:
            String r110 = CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null);
            IFeedbackApi r111 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
            FeedbackCard r103 = this.f124894a.f124879i;
            if (r103 == null) goto L13;
            Long r104 = r103.feedbackId;
            if (r104 == null) goto L13;
            long r112 = r104.longValue();
        L14:
            FeedbackCard r105 = this.f124894a.f124879i;
            if (r105 == null) goto L19;
            Long r106 = r105.roomId;
            if (r106 == null) goto L19;
            long r113 = r106.longValue();
        L20:
            String r107 = this.f124894a.f124891u.getReqId();
            if (r107 != null) goto L23;
            String r114 = "";
        L24:
            String r108 = this.f124894a.f124891u.getEnterFromMerge();
            if (r108 != null) goto L27;
            String r115 = "";
        L28:
            String r109 = this.f124894a.f124891u.getEnterMethod();
            if (r109 != null) goto L31;
            String r116 = "";
        L32:
            String r117 = this.f124894a.f124891u.getReqId();
            if (r117 != null) goto L35;
            String r211 = "";
        L36:
            ILiveFeedbackService r118 = (ILiveFeedbackService) this.f124894a.f124888r.getValue();
            if (r118 == null) goto L42;
            String r119 = r118.getRecentRoomIds();
            if (r119 == null) goto L42;
            String r212 = r119;
        L43:
            IFeedbackApi.CC.feedbackRequest$default(r111, r112, r113, r110, r114, r115, r116, null, r211, r212, 64, null).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(a.f124895a, C2005b.f124896a);
            this.f124894a.f124892v.invoke();
            GlobalQuestionFeedback r120 = this.f124894a;
            nx1.a r121 = r120.f124882l;
            if (r121 != null) goto L46;
            r121 = r120.f124881k;
        L46:
            if (r121 == null) goto L49;
            String r122 = r121.getSelectToast();
            if (r122 == null) goto L49;
        L50:
            f2.c(r122, 0);
            return;
        L49:
            r122 = s1.B(R.string.ttlive_live_feedback_submit_positive_toast);
        L42:
            r212 = "";
            goto L43
        L35:
            r211 = r117;
            goto L36
        L31:
            r116 = r109;
            goto L32
        L27:
            r115 = r108;
            goto L28
        L23:
            r114 = r107;
        L19:
            r113 = 0;
        L13:
            r112 = 0;
            goto L14
        }
    }

    @Override // dx1.a
    public final /* synthetic */ void b() {
    }

    @Override // dx1.a
    public final /* synthetic */ void onDestroy() {
    }

    public final boolean d() {
        Integer r100 = u4.f121344a.getValue().disableSubmitButton;
        if (r100 != null) goto L6;
    L12:
        return false;
    L6:
        if (r100.intValue() != 1) goto L12;
        List<Question> r101 = this.f124880j;
        if (r101 == null) goto L12;
        if (r101.size() != 1) goto L12;
        return true;
    }

    public final void f() {
        if (this.f124881k != null) goto L5;
    L11:
        boolean r100 = false;
    L12:
        if (r100 == false) goto L22;
        TextView r101 = this.f124878h;
        if (r101 == null) goto L16;
        r101.setClickable(true);
    L16:
        TextView r102 = this.f124878h;
        if (r102 == null) goto L19;
        r102.setTextColor(s1.h(R.color.ttlive_feedback_submit_clickable));
    L19:
        TextView r103 = this.f124878h;
        if (r103 == null) goto L32;
        r103.setBackgroundResource(R.drawable.ttlive_bg_feedback_submit_enable);
        return;
    L32:
        return;
    L22:
        TextView r104 = this.f124878h;
        if (r104 == null) goto L25;
        r104.setClickable(false);
    L25:
        TextView r105 = this.f124878h;
        if (r105 == null) goto L28;
        r105.setTextColor(s1.h(R.color.ttlive_feedback_submit_un_clickable));
    L28:
        TextView r106 = this.f124878h;
        if (r106 == null) goto L34;
        r106.setBackgroundResource(R.drawable.ttlive_bg_feedback_submit_disable);
        return;
    L34:
        return;
    L5:
        if (this.f124883m == false) goto L11;
        if (this.f124882l != null) goto L9;
    L10:
        r100 = true;
        goto L12
    L9:
        if (this.f124884n == false) goto L11;
        goto L10
    }

    @Override // dx1.a
    public final void onSlide() {
        nx1.a r100 = this.f124881k;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        this.f124883m = false;
        nx1.a r101 = this.f124882l;
        if (r101 == null) goto L8;
        r101.reset();
    L8:
        this.f124884n = false;
        f();
    }

    @Override // dx1.a
    public final void startRoom() {
        if (((tic.a) this.f124885o.getValue()) != null) goto L21;
        return;
    L21:
        SimpleMediaView r100 = this.f124876f;     // Catch: Exception -> L19
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.h() == false) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L16;
        r100 = null;
    L16:
        if (r100 == null) goto L24;
        r100.setPlayEntity((tic.a) this.f124885o.getValue());     // Catch: Exception -> L19
        r100.k();     // Catch: Exception -> L19
        r100.setLoop(true);     // Catch: Exception -> L19
        return;
    L24:
        return;
    L10:
        if (((tic.a) this.f124885o.getValue()) == null) goto L12;
        r101 = true;
    L19:
        ALogger.d("FeedbackMediaPlayError", "GlobalQuestion");
    }

    @Override // dx1.a
    public final void stopRoom() {
        SimpleMediaView r100 = this.f124876f;
        if (r100 == null) goto L6;
        r100.m();
        return;
    }

    public final int e() {
        int r100 = s1.w() - UtilityKotlinExtentionsKt.i(104);
        ViewGroup r101 = this.f124871a;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.getHeight();
    L6:
        int r104 = r100 - r103;
        ViewGroup r105 = this.f124872b;
        if (r105 == null) goto L10;
        r102 = r105.getHeight();
    L10:
        return (r104 - r102) / 5;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // dx1.a
    public final void c(FeedbackCard r100) {
        if (r100 == null) goto L60;
        List<Question> r101 = r100.question;
        if (r101 == null) goto L61;
        nx1.a r102 = null;
        if ((!r101.isEmpty()) == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L62;
        Question r103 = (Question) ListProtector.get(r101, 0);
        if (r103 == null) goto L63;
        TextView r104 = this.f124877g;
        if (r104 == null) goto L20;
        String r105 = r100.title;
        if (r105 != null) goto L19;
        r105 = s1.B(R.string.ttlive_live_feedback_preview_title);
    L19:
        r104.setText(r105);
    L20:
        this.f124879i = r100;
        this.f124880j = r100.question;
        SimpleDraweeView r106 = this.f124874d;
        if (r106 == null) goto L23;
        r106.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_BG).setAutoPlayAnimations(true).build());
    L23:
        SimpleDraweeView r107 = this.f124875e;
        if (r107 == null) goto L26;
        r107.setController(Fresco.newDraweeControllerBuilder().setUri(FeedbackContext.FEEDBACK_FRAGMENT_SLIDE_PATH).setAutoPlayAnimations(true).build());
    L26:
        List<Question> r108 = this.f124880j;
        if (r108 != null) goto L29;
    L31:
        boolean r109 = false;
    L32:
        if (r109 == false) goto L44;
        g(true);
        nx1.a r110 = com.bytedance.android.livesdk.feedback.c.b(r103, this.f124890t, (mx1.b) this.f124887q.getValue(), false);
        this.f124881k = r110;
        if ((r110 instanceof View) == false) goto L37;
        r102 = r110;
    L37:
        if (r102 == null) goto L55;
        ViewGroup r111 = this.f124871a;
        if (r111 == null) goto L41;
        r111.removeAllViews();
    L41:
        ViewGroup r112 = this.f124871a;
        if (r112 == null) goto L55;
        r112.addView(r102);
    L55:
        ViewGroup r113 = this.f124871a;
        if (r113 == null) goto L58;
        r113.post(new a(this));
    L58:
        f();
        return;
    L44:
        g(false);
        nx1.a r114 = com.bytedance.android.livesdk.feedback.c.b(r103, this.f124890t, (mx1.b) this.f124887q.getValue(), true);
        this.f124881k = r114;
        if ((r114 instanceof View) == false) goto L48;
        r102 = r114;
    L48:
        if (r102 == null) goto L55;
        ViewGroup r115 = this.f124871a;
        if (r115 == null) goto L52;
        r115.removeAllViews();
    L52:
        ViewGroup r116 = this.f124871a;
        if (r116 == null) goto L55;
        r116.addView(r102);
        goto L55
    L29:
        if (r108.size() != 1) goto L31;
        r109 = true;
        goto L32
    L63:
        return;
    L62:
        return;
    L61:
        return;
    }

    public final void g(boolean r100) {
        int r101 = 4;
        if (d() == false) goto L8;
        TextView r102 = this.f124878h;
        if (r102 == null) goto L14;
        r102.setVisibility(4);
        return;
    L14:
        return;
    L8:
        TextView r103 = this.f124878h;
        if (r103 == null) goto L15;
        if (r100 == false) goto L12;
        r101 = 0;
    L12:
        r103.setVisibility(r101);
        return;
    }

    @Override // dx1.a
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f124878h = (TextView) r100.findViewById(R.id.submit_button);
        this.f124871a = (ViewGroup) r100.findViewById(R.id.question_container1);
        this.f124872b = (ViewGroup) r100.findViewById(R.id.question_container2);
        this.f124873c = (ViewGroup) r100.findViewById(R.id.question_tag);
        this.f124874d = (SimpleDraweeView) r100.findViewById(R.id.bg_anim);
        this.f124875e = (SimpleDraweeView) r100.findViewById(R.id.guide_layout);
        this.f124876f = (SimpleMediaView) r100.findViewById(R.id.media_play);
        this.f124877g = (TextView) r100.findViewById(R.id.feedback_title);
        TextView r101 = this.f124878h;
        if (r101 == null) goto L5;
        r101.setOnClickListener(this.f124889s);
    L5:
        TextView r102 = (TextView) r100.findViewById(R.id.slide_tag);
        int r103 = 0;
        Integer r104 = null;
        if (r102 == null) goto L18;
        j5 r105 = (j5) this.f124886p.getValue();
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
        ViewGroup r108 = this.f124873c;
        if (r108 == null) goto L31;
        j5 r109 = (j5) this.f124886p.getValue();
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
        return r100.inflate(R.layout.ttlive_layout_global_feedback_fragment, r101, false);
    }

    public GlobalQuestionFeedback(Context r100, FeedbackContext r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedbackContext");
        Intrinsics.checkNotNullParameter(r102, "onSubmit");
        this.f124890t = r100;
        this.f124891u = r101;
        this.f124892v = r102;
        this.f124885o = LazyKt.lazy(new GlobalQuestionFeedback$musicEntity$2(this));
        this.f124886p = LazyKt.lazy(GlobalQuestionFeedback$mFeedbackConfig$2.INSTANCE);
        this.f124887q = LazyKt.lazy(new GlobalQuestionFeedback$questionSelectListener$2(this));
        this.f124888r = LazyKt.lazy(GlobalQuestionFeedback$feedbackService$2.INSTANCE);
        this.f124889s = new b(this);
    }
}
