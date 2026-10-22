package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.graphics.drawable.NinePatchDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.RankListAwardMessage;
import com.bytedance.android.livesdk.message.model.hm;
import com.bytedance.android.livesdk.message.model.ii;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.s5;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.CommonBubbleConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;
import py.m;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoPopupPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "Lvlc/l;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoPopupPresenter extends BaseElementPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f100082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yo2.e f100083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f100084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f100085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f100086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f100087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f100088l;

    public static final class a implements a3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoPopupPresenter f100089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f100090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CommonBubbleConfig f100091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageView f100092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f100093e;

        /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoPopupPresenter$a$a, reason: collision with other inner class name */
        public static final class C1529a implements yo2.e.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f100094a;

            /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoPopupPresenter$a$a$a, reason: collision with other inner class name */
            public static final class ViewOnClickListenerC1530a implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C1529a f100095a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ yo2.e f100096b;

                public ViewOnClickListenerC1530a(C1529a r100, yo2.e r101) {
                    this.f100095a = r100;
                    this.f100096b = r101;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r100) {
                    if (StringUtils.isEmpty(this.f100095a.f100094a.f100091c.schemeUrl) == true) goto L5;
                    ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(this.f100095a.f100094a.f100089a.f100070e.getContext(), this.f100095a.f100094a.f100091c.schemeUrl);
                L5:
                    a r101 = this.f100095a.f100094a;
                    UserInfoPopupPresenter r102 = r101.f100089a;
                    if (StringUtils.isEmpty(r101.f100091c.eventName) == false) goto L8;
                    String r103 = "livesdk_top_bubble_guide_click";
                L9:
                    Map<String, String> r104 = this.f100095a.f100094a.f100091c.extra;
                    r102.getClass();
                    UserInfoPopupPresenter.h(r103, r104);
                    this.f100096b.d();
                    return;
                L8:
                    r103 = this.f100095a.f100094a.f100091c.eventName;
                    goto L9
                }
            }

            public C1529a(a r100) {
                this.f100094a = r100;
            }

            @Override // yo2.e.a
            public final void a(View r100, yo2.e r101) {
                Intrinsics.checkNotNullParameter(r100, "view");
                Intrinsics.checkNotNullParameter(r101, "popup");
                r100.setOnClickListener(new ViewOnClickListenerC1530a(this, r101));
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
        public final void onFail() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
        public final void a(NinePatchDrawable r100) {
            Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
            this.f100090b.setText(sb2.a.f(this.f100091c.richText, null).f545238a);
            ImageUtil.loadImage(this.f100092d, this.f100091c.arrowImage, 0);
            ViewGroup.LayoutParams r101 = this.f100092d.getLayoutParams();
            if (r101 == null) goto L10;
            FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
            r102.leftMargin = CommonBubbleConfig.getPositionDip(this.f100091c.arrowPosition, this.f100089a.f100070e.getContext());
            r102.setMarginStart(CommonBubbleConfig.getPositionDip(this.f100091c.arrowPosition, this.f100089a.f100070e.getContext()));
            this.f100092d.setLayoutParams(r102);
            UserInfoPopupPresenter r103 = this.f100089a;
            yo2.e r104 = new yo2.e(r103.f100070e.getContext());
            r104.f568642d = this.f100093e;
            r104.f568643e = 0;
            r104.f568651m = this.f100091c.duration;
            r104.f568662x = new C1529a(this);
            r104.f568650l = true;
            r104.a();
            r103.f100083g = r104;
            UserInfoPopupPresenter r105 = this.f100089a;
            yo2.e r106 = r105.f100083g;
            if (r106 == null) goto L7;
            r106.i(r105.f100088l, 2, 0, 0, 0);
        L7:
            UserInfoPopupPresenter r107 = this.f100089a;
            Map<String, String> r108 = this.f100091c.extra;
            r107.getClass();
            UserInfoPopupPresenter.h("livesdk_top_bubble_guide_show", r108);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }

        public a(UserInfoPopupPresenter r100, TextView r101, CommonBubbleConfig r102, ImageView r103, View r104) {
            this.f100089a = r100;
            this.f100090b = r101;
            this.f100091c = r102;
            this.f100092d = r103;
            this.f100093e = r104;
        }
    }

    public static final class b implements yo2.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserInfoPopupPresenter f100097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonBubbleConfig f100098b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f100099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ yo2.e f100100b;

            public a(b r100, yo2.e r101) {
                this.f100099a = r100;
                this.f100100b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                if (StringUtils.isEmpty(this.f100099a.f100098b.schemeUrl) == true) goto L5;
                ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(this.f100099a.f100097a.f100070e.getContext(), this.f100099a.f100098b.schemeUrl);
            L5:
                b r101 = this.f100099a;
                UserInfoPopupPresenter r102 = r101.f100097a;
                if (StringUtils.isEmpty(r101.f100098b.eventName) == false) goto L8;
                String r103 = "livesdk_top_bubble_guide_click";
            L9:
                Map<String, String> r104 = this.f100099a.f100098b.extra;
                r102.getClass();
                UserInfoPopupPresenter.h(r103, r104);
                this.f100100b.d();
                return;
            L8:
                r103 = this.f100099a.f100098b.eventName;
                goto L9
            }
        }

        public b(UserInfoPopupPresenter r100, CommonBubbleConfig r101) {
            this.f100097a = r100;
            this.f100098b = r101;
        }

        @Override // yo2.e.a
        public final void a(View r100, yo2.e r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "popup");
            r100.setOnClickListener(new a(this, r101));
        }
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void e() {
        super.e();
        CompositeDisposable r100 = this.f100082f;
        if ((!r100.isDisposed()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        yo2.e r101 = this.f100083g;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.h() != true) goto L18;
        yo2.e r102 = this.f100083g;
        if (r102 == null) goto L15;
        r102.d();
    L15:
        this.f100083g = null;
        return;
    }

    public final void i(CommonBubbleConfig r110) {
        if (this.f100070e.a() == true) goto L5;
        return;
    L5:
        if (this.f100070e.getContext() == null) goto L11;
        if (r110 == null) goto L12;
        View r100 = LayoutInflater.from(this.f100070e.getContext()).inflate(R.layout.ttlive_user_info_popup_view, null);
        TextView r101 = (TextView) r100.findViewById(R.id.popup_text);
        ImageView r102 = (ImageView) r100.findViewById(R.id.popup_arrow);
        int r103 = a3.f114402d;
        a3.a.a(r101, r110.getBackgroundImageModel(), new a(this, r101, r110, r102, r100), 0.0f);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter, vlc.l
    public final void onMessage(tlc.d r110) {
        a5 r100 = null;
        CompositeDisposable r101 = null;
        if ((r110 instanceof o0) == true) goto L5;
        tlc.d r102 = null;
    L6:
        o0 r103 = (o0) r102;
        if (r103 != null) goto L9;
        return;
    L9:
        m r104 = r103.getMessageType();
        if (r104 != MessageType.GRADE_BUFF_ANCHOR_SHARE_MESSAGE) goto L52;
        if (r110 == null) goto L50;
        s5 r111 = (s5) r110;
        if (r111.E() != null) goto L16;
        return;
    L16:
        if (this.f100070e.a() == true) goto L18;
        return;
    L18:
        if (this.f100068c == false) goto L172;
        CompositeDisposable r105 = this.f100082f;
        if ((!r105.isDisposed()) == false) goto L23;
        r101 = r105;
    L23:
        if (r101 == null) goto L25;
        r101.dispose();
    L25:
        yo2.e r106 = this.f100083g;
        if (r106 != null) goto L28;
    L32:
        a5 r107 = r111.E();
        if (r107 != null) goto L36;
        r107 = (a5) vh7.f.c(a5.class);
    L36:
        j(R.layout.ttlive_popup_open_buff_view, new CommonBubbleConfig(r107, r111.getSchemeUrl(), this.f100084h, "livesdk_privilege_buff_moneysplit_click"));
        int r112 = r111.getScore();
        if (r112 > 0) goto L39;
        return;
    L39:
        if (r112 < 10000) goto L41;
        String r113 = Marker.ANY_NON_NULL_MARKER + new BigDecimal((((double) r112) * 1.0d) / ((double) this.f100085i)).setScale(2, RoundingMode.DOWN).toString() + "万";
    L42:
        a5 r108 = (a5) vh7.f.c(a5.class);
        r108.setDefaultPattern(r113);
        UserInfoVM.Companion.getClass();
        aa1.a r114 = UserInfoVM.b.b();
        if (r114 == null) goto L152;
        ElementMiddleVM r115 = r114.getMiddleVm();
        if (r115 == null) goto L153;
        com.bytedance.live.datacontext.k<y91.a> r116 = r115.getShowProfileViewAnim();
        if (r116 == null) goto L154;
        r116.post(new y91.a(this.f100086j, this.f100087k, r108, null));
        return;
    L154:
        return;
    L153:
        return;
    L152:
        return;
    L41:
        r113 = "+ " + r112;
        goto L42
    L28:
        if (r106.h() != true) goto L32;
        yo2.e r109 = this.f100083g;
        if (r109 == null) goto L32;
        r109.d();
        goto L32
    L172:
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.GradeBuffAnchorShareMessage");
    L52:
        if (r104 != MessageType.TOP_LEFT_BUBBLE_MESSAGE) goto L97;
        if (r110 == null) goto L95;
        hm r117 = (hm) r110;
        if (r117.G() != null) goto L57;
        return;
    L57:
        if (this.f100070e.a() == false) goto L173;
        CommonBubbleConfig r118 = r117.G();
        if (r118 == null) goto L69;
        if (r118.messageType != 1) goto L69;
        yo2.e r119 = this.f100083g;
        if (r119 == null) goto L69;
        if (r119.h() != true) goto L69;
        return;
    L69:
        if (this.f100082f.isDisposed() == true) goto L71;
        this.f100082f.dispose();
    L71:
        yo2.e r120 = this.f100083g;
        if (r120 != null) goto L74;
    L78:
        CommonBubbleConfig r121 = r117.G();
        if (r121 == null) goto L82;
        r121.extra = r117.getExtra();
    L82:
        if (r117.E() == false) goto L93;
        CommonBubbleConfig r122 = r117.G();
        if (r122 == null) goto L87;
        r100 = r122.richText;
    L87:
        if (ListUtils.isEmpty(sb2.a.d(r100)) == true) goto L92;
        CommonBubbleConfig r123 = r117.G();
        if (r123 == null) goto L175;
        new com.bytedance.android.live.core.utils.o0().a(sb2.a.d(r123.richText), new com.bytedance.android.live.room.navi.userinfo_p.presenter.a(this, r123));
        return;
    L175:
        return;
    L92:
        i(r117.G());
        return;
    L93:
        j(R.layout.ttlive_user_info_popup_view, r117.G());
        return;
    L74:
        if (r120.h() != true) goto L78;
        yo2.e r124 = this.f100083g;
        if (r124 == null) goto L78;
        r124.d();
        goto L78
    L173:
        return;
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.TopLeftBubbleMessage");
    L97:
        if (r104 != MessageType.PROFILE_VIEW_MESSAGE) goto L127;
        if (r110 == null) goto L125;
        ii r125 = (ii) r110;
        if (this.f100070e.a() == false) goto L105;
        if (r125.getSource() != 2) goto L105;
        this.f100070e.b().getMiddleVm().getAppointmentMessage().setValue(r125);
        return;
    L105:
        if (r125.G() != null) goto L107;
        return;
    L107:
        if (this.f100070e.a() == false) goto L176;
        UserInfoVM.Companion.getClass();
        aa1.a r126 = UserInfoVM.b.b();
        if (r126 == null) goto L120;
        ElementMiddleVM r127 = r126.getMiddleVm();
        if (r127 == null) goto L120;
        com.bytedance.live.datacontext.k<y91.a> r128 = r127.getShowProfileViewAnim();
        if (r128 == null) goto L120;
        long r129 = this.f100086j;
        if (r125.getDuration() != null) goto L118;
        long r130 = 0;
    L119:
        r128.post(new y91.a(r129, r130, r125.G(), r125.E()));
        goto L120
    L118:
        r130 = r125.getDuration().longValue() * ((long) 1000);
    L120:
        DataCenter r131 = a();
        if (r131 == null) goto L123;
        r131.put("fans_rank_list_lottie", Boolean.TRUE);
    L123:
        Disposable r132 = Observable.timer(r125.getDuration().longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.navi.userinfo_p.presenter.b(this));
        Intrinsics.checkNotNullParameter(r132, "disposables");
        this.f100066a.add(r132);
        return;
    L176:
        return;
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.ProfileViewMessage");
    L127:
        if (r104 != MessageType.DAILY_RANK_AWARD) goto L163;
        if (r110 == null) goto L149;
        RankListAwardMessage r133 = (RankListAwardMessage) r110;
        if (r133.getRankType() == 100) goto L134;
        if (r133.getRankType() == 101) goto L134;
        return;
    L134:
        if (this.f100070e.a() == true) goto L136;
        return;
    L136:
        if (this.f100069d == true) goto L139;
        return;
    L139:
        if (r133.getRankType() != 100) goto L144;
        DataCenter r134 = a();
        if (r134 == null) goto L166;
        r134.put("fans_rank_list_award_anim", r133);
        return;
    L166:
        return;
    L144:
        if (r133.getRankType() != 101) goto L168;
        DataCenter r135 = a();
        if (r135 == null) goto L169;
        r135.put("pk_activity_award_anim", r133);
        return;
    L169:
        return;
    L168:
        return;
    L149:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.RankListAwardMessage");
    L163:
        return;
    L5:
        r102 = r110;
        goto L6
    }

    public UserInfoPopupPresenter(m91.c r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r101, "mUserHead");
        super(r100);
        this.f100088l = r101;
        this.f100082f = new CompositeDisposable();
        this.f100084h = 5;
        this.f100085i = 10000;
        this.f100086j = 700;
        this.f100087k = 3100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(String r100, Map r101) {
        if (r101 != null) goto L4;
        r101 = new HashMap();
    L4:
        r101.put("user_id", ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n().toString());
        j0.l().sendLog(r100, r101, new Object[]{IRoom.class});
    }

    public final void j(int r100, CommonBubbleConfig r101) {
        if (this.f100070e.a() == true) goto L5;
        return;
    L5:
        if (this.f100070e.getContext() == null) goto L11;
        if (r101 == null) goto L12;
        View r102 = LayoutInflater.from(this.f100070e.getContext()).inflate(r100, null);
        ((TextView) r102.findViewById(R.id.popup_text)).setText(sb2.a.f(r101.richText, null).f545238a);
        yo2.e r103 = new yo2.e(this.f100070e.getContext());
        r103.f568642d = r102;
        r103.f568643e = 0;
        r103.f568651m = r101.duration;
        r103.f568662x = new b(this, r101);
        r103.f568650l = true;
        r103.a();
        this.f100083g = r103;
        r103.i(this.f100088l, 2, 0, 0, 0);
        h("livesdk_top_bubble_guide_show", r101.extra);
        return;
    L12:
        return;
    }
}
