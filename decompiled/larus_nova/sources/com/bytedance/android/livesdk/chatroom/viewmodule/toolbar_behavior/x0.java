package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f117489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yo2.e f117490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public yo2.e f117491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yo2.e f117492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public yo2.e f117493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public yo2.d<?> f117494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yo2.e f117495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public yo2.e f117496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f117497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f117498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f117499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataCenter f117500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CompositeDisposable f117501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f117502n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0 f117503a;

        public b(x0 r100) {
            this.f117503a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            x0 r101 = this.f117503a;
            yo2.e r102 = r101.f117495g;
            if (r102 == null) goto L5;
            r102.d();
        L5:
            r101.f117495g = null;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0 f117504a;

        public c(x0 r100) {
            this.f117504a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (this.f117504a.c() == false) goto L6;
            this.f117504a.d(r101, true);
            return;
        }
    }

    static {
    }

    public final View b() {
        if (this.f117497i == true) goto L7;
        return null;
    L7:
        return this.f117499k;
    }

    public final boolean c() {
        if (this.f117497i == true) goto L5;
        return false;
    L5:
        if (this.f117498j == true) goto L47;
        yo2.e r100 = this.f117492d;
        if (r100 != null) goto L10;
        boolean r101 = false;
    L11:
        if (r101 == false) goto L13;
        return false;
    L13:
        DataCenter r102 = this.f117500l;
        if (r102 == null) goto L18;
        Boolean r103 = (Boolean) r102.get("data_is_portrait", Boolean.FALSE);
        if (r103 == null) goto L18;
        boolean r104 = r103.booleanValue();
    L19:
        if (r104 == true) goto L22;
        return false;
    L22:
        if (this.f117489a == false) goto L24;
        return false;
    L24:
        Integer r105 = com.bytedance.android.livesdk.sharedpref.b.K1.getValue();
        if (r105 != null) goto L28;
    L29:
        if (r105 != null) goto L32;
    L34:
        long r106 = ((Long) new com.bytedance.android.livesdk.sharedpref.e("last_dou_plus_coupon_show_time_" + com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b()), 0L).getValue()).longValue();
        if (r106 != 0) goto L37;
        int r107 = Integer.MAX_VALUE;
    L38:
        JSONObject r108 = ((ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class)).getClientDouPlusPopupSettings();
        int r109 = 14;
        if (r108 == null) goto L41;
        r109 = r108.optInt("douplus_live_bubble_coupon_interval_days", 14);
    L41:
        if (r107 < r109) goto L46;
        return true;
    L46:
        return false;
    L37:
        r107 = (int) ((System.currentTimeMillis() - r106) / 86400000);
        goto L38
    L32:
        if (r105.intValue() != 2) goto L34;
        return false;
    L28:
        if (r105.intValue() != 1) goto L29;
        return false;
    L18:
        r104 = false;
        goto L19
    L10:
        r101 = r100.h();
        goto L11
    L47:
        return false;
    }

    public final void e() {
        View r100 = this.f117499k;
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b());
        int r102 = com.bytedance.android.livesdk.chatroom.utils.k0.f114530a;
        Intrinsics.checkNotNullParameter(r101, "key");
        String r103 = "transform_widget_fold_pop_up_shown_" + r101;
        Boolean r104 = Boolean.FALSE;
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e(r103, r104).getValue()).booleanValue() == false) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("transform_widget_fold_pop_up_shown_".concat(r101), r104), Boolean.TRUE);
        View r105 = LayoutInflater.from(this.f117502n).inflate(R.layout.ttlive_view_transform_widget_tip, null);
        View r106 = r105.findViewById(R.id.tv_content);
        if (r106 == null) goto L13;
        ((TextView) r106).setText(R.string.ttlive_transform_widget_tip);
        r105.setOnClickListener(new b(this));
        yo2.e r107 = new yo2.e(this.f117502n);
        r107.f568642d = r105;
        r107.f568643e = 0;
        r107.f568651m = 5;
        r107.f568652n = true;
        r107.f568650l = true;
        r107.f568645g = true;
        r107.a();
        this.f117495g = r107;
        Intrinsics.checkNotNull(r107);
        r107.i(r100, 1, 4, 0, -4);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public x0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f117502n = r100;
        this.f117497i = true;
        this.f117501m = new CompositeDisposable();
    }

    public final void f(boolean r100) {
        if (r100 == true) goto L4;
    L7:
        if (r100 == true) goto L50;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 != null) goto L12;
    L42:
        boolean r102 = false;
    L43:
        if (r102 == false) goto L51;
        JSONObject r103 = ((ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class)).getClientDouPlusPopupSettings();
        String r104 = "DOU+助你上热门";
        if (r103 == null) goto L48;
        r104 = r103.optString("douplus_live_bubble_text", "DOU+助你上热门");
    L48:
        d(r104, false);
        return;
    L51:
        return;
    L12:
        if (this.f117497i == false) goto L42;
        if (this.f117498j == true) goto L42;
        JSONObject r105 = ((ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class)).getClientDouPlusPopupSettings();
        int r106 = 5;
        if (r105 == null) goto L19;
        r106 = r105.optInt("douplus_live_bubble_delay_mins", 5);
    L19:
        if (r106 == (-1)) goto L42;
        yo2.e r107 = this.f117492d;
        if (r107 != null) goto L24;
        boolean r108 = false;
    L25:
        if (r108 == true) goto L42;
        if (r101.isPortraitInteraction().getValue().booleanValue() == false) goto L42;
        if (this.f117489a == true) goto L42;
        IUser r109 = ((IUserService) jc1.k.n(IUserService.class)).user().b();
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_dou_plus_popup_show_" + com.bytedance.android.live.base.model.user.o.a(r109), Boolean.FALSE).getValue()).booleanValue() == true) goto L42;
        IUser r110 = TTLiveSDK.hostService().user().getCurUser();
        r102 = true;
        if (r109.getEnableShowCommerceSale() == true) goto L43;
        if (r110.getEnterprise() < 1) goto L42;
    L24:
        r108 = r107.h();
        goto L25
    L50:
        return;
    L4:
        if (c() == false) goto L7;
        ((ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class)).fetchDouLiveCouponToast(new c(this));
    }

    public static void a(String r100, Map r101) {
        com.bytedance.android.livesdk.log.g r102 = com.bytedance.android.livesdk.log.u.l();
        am2.x r103 = new am2.x();
        r103.f4350b = "live_take_detail";
        r103.f4349a = "live_take";
        r102.sendLog(r100, r101, new Object[]{r103, Room.class});
    }

    public final void d(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        View r102 = b();
        if (r102 != null) goto L8;
        return;
    L8:
        View r103 = LayoutInflater.from(this.f117502n).inflate(R.layout.ttlive_douplus_tip, null);
        ((TextView) r103.findViewById(R.id.tv_content)).setText(r100);
        yo2.e r104 = new yo2.e(this.f117502n);
        r104.f568642d = r103;
        r104.f568643e = 0;
        r104.f568651m = 3;
        r104.f568652n = true;
        r104.f568650l = true;
        r104.a();
        Intrinsics.checkNotNull(r104);
        r104.i(r102, 1, 4, 0, -8);
        this.f117497i = false;
        if (r101 == false) goto L11;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("last_dou_plus_coupon_show_time_" + com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b()), 0L), Long.valueOf(System.currentTimeMillis()));
        ILiveDouPlusService r105 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        HashMap r106 = new HashMap();
        r106.put("toast_type", AnchorBenefitToast.TYPE_COUPON);
        r105.logEvent(false, "show_dou_live_toast", "", r106);
        return;
    L11:
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("has_dou_plus_popup_show_" + com.bytedance.android.live.base.model.user.o.a(((IUserService) jc1.k.n(IUserService.class)).user().b()), Boolean.FALSE), Boolean.TRUE);
        ILiveDouPlusService r107 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        HashMap r108 = new HashMap();
        r108.put("bubble_type", "remind_position");
        r107.logEvent(false, "show_dou_live_bubble", "", r108);
    }
}
