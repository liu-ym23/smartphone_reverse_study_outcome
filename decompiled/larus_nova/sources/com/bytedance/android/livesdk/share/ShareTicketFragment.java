package com.bytedance.android.livesdk.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/share/ShareTicketFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareTicketFragment extends BaseFragment {
    public static final /* synthetic */ int R = 0;
    public HSImageView A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final CompositeDisposable F;
    public int G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f158043J;
    public User K;
    public String L;
    public long M;
    public ImageModel N;
    public Map<String, String> O;
    public boolean P;
    public String Q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f158044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f158045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f158046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f158047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f158048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f158049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f158050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f158051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HSImageView f158052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f158053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f158054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f158055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f158056p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f158057q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HSImageView f158058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f158059s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f158060t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ConstraintLayout f158061u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ConstraintLayout f158062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ConstraintLayout f158063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ConstraintLayout f158064x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HSImageView f158065y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ConstraintLayout f158066z;

    public static final class a {
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareTicketFragment f158067a;

        public b(ShareTicketFragment r100) {
            this.f158067a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final String call() {
            ConstraintLayout r100 = this.f158067a.f158061u;
            int r101 = s1.h(R.color.ttlive_paid_live_share_ticket_bg);
            Rect r102 = new Rect((int) s1.e(80.0f), (int) s1.e(96.0f), (int) s1.e(80.0f), (int) s1.e(96.0f));
            int r103 = s1.k(R.dimen.ttlive_poster_title_size_290);
            String r104 = g.f158092a;
            Intrinsics.checkNotNullParameter(r102, "position");
            if (r100 != null) goto L17;
        L8:
            Bitmap r105 = null;
        L9:
            Context r106 = this.f158067a.getContext();
            User r107 = this.f158067a.K;
            if (r107 == null) goto L13;
            String r108 = r107.getNickName();
            if (r108 == null) goto L13;
        L15:
            return g.d(r106, r105, r108);
        L13:
            r108 = "";
            goto L15
        L17:
            r100.measure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L16
            r105 = g.b(r100, r101, r102);     // Catch: Throwable -> L16
            goto L9
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareTicketFragment f158068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f158069b;

        public c(ShareTicketFragment r100, Function0 r101) {
            this.f158068a = r100;
            this.f158069b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f158068a.B = false;
            if (((String) r100).length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            Function0 r102 = this.f158069b;
            if (r102 == null) goto L11;
            Unit r103 = (Unit) r102.invoke();
        L11:
            this.f158068a.F.clear();
            return;
        L10:
            f2.b(R.string.ttlive_poster_save_fail, 0);
            goto L11
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareTicketFragment f158070a;

        public d(ShareTicketFragment r100) {
            this.f158070a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ShareTicketFragment r101 = this.f158070a;
            int r102 = ShareTicketFragment.R;
            r101.getClass();
            int r103 = com.bytedance.android.livesdk.chatroom.paidlive.d.f107573a;
            com.bytedance.android.livesdk.chatroom.paidlive.d.a("livesdk_paidlive_get_free_ticket_return_click", r101.O);
            x0.b r104 = new x0.b(r101.getContext(), 4);
            r104.l(R.string.ttlive_withdraw_dialog_msg);
            r104.i(1, R.string.ttlive_withdraw_dialog_no, new y(r101));
            r104.i(0, R.string.ttlive_withdraw_dialog_sure, new z(r101));
            r104.k(0, true);
            r104.n();
            com.bytedance.android.livesdk.chatroom.paidlive.d.a("livesdk_paidlive_get_free_ticket_return_pop_show", r101.O);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareTicketFragment f158071a;

        public e(ShareTicketFragment r100) {
            this.f158071a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ShareTicketFragment.S90(this.f158071a);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareTicketFragment f158072a;

        public f(ShareTicketFragment r100) {
            this.f158072a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ShareTicketFragment.S90(this.f158072a);
        }
    }

    static {
    }

    public final String X90() {
        StringBuilder r100 = new StringBuilder("sslocal://webcast_redirect?entry=paid_live_ticket&need_login=true");
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("secUid");
    L6:
        String r104 = Y90();
        Bundle r105 = getArguments();
        String r106 = "";
        if (r105 == null) goto L10;
        String r107 = r105.getString("roomId");
        if (r107 == null) goto L10;
    L12:
        if (r107.length() <= 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == true) goto L17;
        r107 = "0";
    L17:
        StringBuilder r109 = new StringBuilder("&ticket_id=");
        Bundle r110 = getArguments();
        if (r110 == null) goto L21;
        String r111 = r110.getString("ticketId");
        if (r111 == null) goto L21;
    L22:
        r109.append(r111);
        r109.append("&room_id=");
        r109.append(r107);
        r109.append("&share_from_user_id=");
        r109.append(r103);
        r109.append("&share_from_type=");
        r109.append(r104);
        r109.append("&enter_from_merge=");
        r109.append(W90());
        r109.append("&enter_method=");
        Bundle r112 = getArguments();
        if (r112 == null) goto L26;
        r102 = r112.getString("source");
    L26:
        if (Intrinsics.areEqual(r102, "share_alert") == false) goto L28;
        r106 = "token";
    L28:
        r109.append(r106);
        r109.append("&ticket_entrance=");
        if (this.P == false) goto L31;
        String r113 = "get_friend_ticket_suc_page";
    L32:
        r109.append(r113);
        r100.append(r109.toString());
        return r100.toString();
    L31:
        r113 = "get_friend_ticket_page";
    L21:
        r111 = "";
        goto L22
    L14:
        r108 = false;
    L10:
        r107 = "";
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public final String Y90() {
        int r100 = this.f158043J;
        if (r100 != 3) goto L5;
        return "friend_ticket";
    L5:
        if (r100 == 4) goto L16;
        String r101 = this.Q;
        int r102 = r101.hashCode();
        if (r102 != 52) goto L9;
        r101.equals("4");
        return "friend_ticket";
    L9:
        if (r102 == 53) goto L12;
        return "friend_ticket";
    L12:
        if (r101.equals("5") == true) goto L16;
        return "friend_ticket";
    L16:
        return "boost_ticket";
    }

    public final String Z90() {
        int r100 = this.f158043J;
        if (r100 != 3) goto L5;
        return "4";
    L5:
        if (r100 != 4) goto L10;
        return "5";
    L10:
        return this.Q;
    }

    public final void ca0() {
        this.P = true;
        ConstraintLayout r100 = this.f158063w;
        if (r100 != null) goto L5;
        return;
    L5:
        HSImageView r101 = this.f158046f;
        if (r101 != null) goto L8;
        return;
    L8:
        ConstraintLayout r102 = this.f158062v;
        if (r102 != null) goto L11;
        return;
    L11:
        TextView r103 = this.f158049i;
        if (r103 != null) goto L14;
        return;
    L14:
        TextView r104 = this.f158051k;
        if (r104 != null) goto L17;
        return;
    L17:
        TextView r105 = this.f158047g;
        if (r105 != null) goto L20;
        return;
    L20:
        ConstraintLayout r106 = this.f158066z;
        if (r106 != null) goto L23;
        return;
    L23:
        da0(r101);
        da0(r104);
        da0(r103);
        da0(this.f158050j);
        ConstraintSet r107 = new ConstraintSet();
        r107.clone(r100);
        r107.connect(r102.getId(), 3, r105.getId(), 4, (int) s1.e(35.0f));
        r107.applyTo(r100);
        r106.setVisibility(0);
        r106.addView(this.f158046f, new ConstraintLayout.LayoutParams((int) s1.e(44.0f), (int) s1.e(44.0f)));
        r106.addView(r103, new ConstraintLayout.LayoutParams(-2, -2));
        r106.addView(r104, new ConstraintLayout.LayoutParams(-2, -2));
        r103.setTextSize(0, s1.k(R.dimen.ttlive_poster_title_size_15));
        r103.setTextColor(-1);
        r104.setTextSize(0, s1.k(R.dimen.ttlive_poster_title_size_14));
        r104.setTextColor(-1);
        ConstraintSet r108 = new ConstraintSet();
        r108.clone(r106);
        r108.connect(r101.getId(), 1, r106.getId(), 1, (int) s1.e(16.0f));
        r108.connect(r101.getId(), 3, r106.getId(), 3, (int) s1.e(12.0f));
        r108.applyTo(r106);
        ConstraintSet r109 = new ConstraintSet();
        r109.clone(r106);
        r109.connect(r103.getId(), 1, r101.getId(), 2, (int) s1.e(10.0f));
        r109.connect(r103.getId(), 3, r101.getId(), 3);
        r109.applyTo(r106);
        TextView r110 = this.f158051k;
        if (r110 == null) goto L26;
        r110.setText(s1.B(R.string.ttlive_send_ticket2));
    L26:
        ConstraintSet r111 = new ConstraintSet();
        r111.clone(r106);
        r111.connect(r104.getId(), 1, r101.getId(), 2, (int) s1.e(10.0f));
        r111.connect(r104.getId(), 4, r101.getId(), 4);
        r111.applyTo(r106);
        if (this.C == true) goto L32;
        String r112 = X90();
        ILiveShareService r113 = (ILiveShareService) jc1.k.n(ILiveShareService.class);
        Charset r114 = Charsets.UTF_8;
        if (r112 == null) goto L61;
        r113.getQrCodeFromUrl(11, Base64.encodeToString(r112.getBytes(r114), 2), "", new ShareTicketFragment$renderQrCodeFromUrl$1(this));
        goto L32
    L61:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L32:
        ConstraintLayout r115 = this.f158064x;
        if (r115 == null) goto L35;
        r115.setVisibility(0);
    L35:
        TextView r116 = this.f158055o;
        if (r116 == null) goto L50;
        da0(r116);
        r100.addView(r116, new ConstraintLayout.LayoutParams((int) s1.e(240.0f), (int) s1.e(44.0f)));
        ConstraintSet r117 = new ConstraintSet();
        r117.clone(r100);
        r117.connect(r116.getId(), 3, r102.getId(), 4, (int) s1.e(8.0f));
        r117.centerHorizontallyRtl(r116.getId(), 0);
        r117.applyTo(r100);
        r116.setText(s1.B(R.string.ttlive_save_ticket_pic));
        r116.setOnClickListener(new ShareTicketFragment$onTicketTaken$$inlined$apply$lambda$1(this));
        ImageView r118 = this.f158057q;
        if (r118 == null) goto L40;
        r118.setVisibility(8);
    L40:
        View r119 = this.f158059s;
        if (r119 == null) goto L43;
        r119.setVisibility(0);
    L43:
        TextView r120 = this.f158060t;
        if (r120 == null) goto L46;
        r120.setVisibility(0);
        r120.setOnClickListener(new d(this));
    L46:
        LinearLayout r121 = this.f158056p;
        if (r121 == null) goto L50;
        ConstraintSet r122 = new ConstraintSet();
        r122.clone(r100);
        r122.connect(r121.getId(), 3, r116.getId(), 4);
        r122.centerHorizontallyRtl(r121.getId(), 0);
        r122.applyTo(r100);
    L50:
        TextView r123 = this.f158047g;
        if (r123 == null) goto L53;
        r123.setText(s1.B(R.string.ttlive_take_ticket_success));
    L53:
        HSImageView r124 = this.f158046f;
        if (r124 == null) goto L56;
        r124.setOnClickListener(new f(this));
    L56:
        TextView r125 = this.f158049i;
        if (r125 == null) goto L62;
        r125.setOnClickListener(new e(this));
        return;
    }

    public ShareTicketFragment() {
        this.F = new CompositeDisposable();
        this.L = "";
        this.Q = "4";
    }

    public final String W90() {
        Bundle r100 = getArguments();
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("source");
    L7:
        if (Intrinsics.areEqual(r102, "share_alert") == true) goto L21;
        Bundle r103 = getArguments();
        if (r103 == null) goto L12;
        String r104 = r103.getString("source");
    L14:
        if (Intrinsics.areEqual(r104, "ticket_panel") == true) goto L22;
        Bundle r105 = getArguments();
        if (r105 == null) goto L19;
        r101 = r105.getString("source");
    L19:
        Intrinsics.areEqual(r101, "chat");
        return "chat";
    L22:
        return "ticket_panel";
    L12:
        r104 = null;
        goto L14
    L21:
        return "share_alert";
    L5:
        r102 = null;
        goto L7
    }

    public static final void S90(ShareTicketFragment r100) {
        r100.getClass();
        HashMap r101 = new HashMap(2);
        Bundle r102 = r100.getArguments();
        if (r102 == null) goto L6;
        String r103 = r102.getString("secUid");
        if (r103 == null) goto L6;
    L7:
        r101.put("sec_user_id", r103);
        com.bytedance.android.livesdk.service.l.d().a().showUserProfile("0", null, r101);
        return;
    L6:
        r103 = "";
        goto L7
    }

    public static final void T90(ShareTicketFragment r100) {
        r100.getClass();
        com.bytedance.android.livesdk.service.l.d().getClass();
        LivePosterApiService r101 = (LivePosterApiService) com.bytedance.android.live.network.c.b().e(LivePosterApiService.class);
        if (r101 == null) goto L24;
        r100.ea0(true);
        int r102 = com.bytedance.android.livesdk.chatroom.paidlive.d.f107573a;
        Map<String, String> r103 = r100.O;
        if (r103 == null) goto L10;
        Map r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L10;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "get_ticket");
        Unit r105 = Unit.INSTANCE;
    L11:
        com.bytedance.android.livesdk.chatroom.paidlive.d.a("livesdk_paidlive_get_friend_ticket_page_button_click", r104);
        HashMap<String, String> r106 = new HashMap();
        Bundle r107 = r100.getArguments();
        String r108 = "";
        if (r107 == null) goto L15;
        String r109 = r107.getString("ticketId");
        if (r109 == null) goto L15;
    L16:
        r106.put("id", r109);
        r106.put("id_type", "1");
        r106.put("grab_type", r100.Z90());
        r106.put("from_user_id", "0");
        Bundle r110 = r100.getArguments();
        if (r110 == null) goto L22;
        String r111 = r110.getString("secUid");
        if (r111 == null) goto L22;
        r108 = r111;
    L22:
        r106.put("from_user_sec_id", r108);
        Unit r112 = Unit.INSTANCE;
        ((ObservableSubscribeProxy) r101.grabPaidLiveTicket(r106).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).as(AutoDispose.bind(r100))).subscribe(new s(r100), new t(r100));
        return;
    L15:
        r109 = "";
    L10:
        r104 = null;
        goto L11
    }

    public static final void U90(ShareTicketFragment r110) {
        int r100 = r110.G + 1;
        r110.G = r100;
        if (r100 < 2) goto L107;
        r110.G = 0;
        r110.ea0(false);
        if (r110.I == true) goto L8;
    L12:
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e, "paidlive_ticket_user_info_pull_error", null, null, null, null, 30, null);
        f2.c(s1.B(R.string.ttlive_share_ticket_request_error), 0);
    L13:
        Pair[] r101 = new Pair[10];
        Bundle r102 = r110.getArguments();
        String r103 = "";
        if (r102 == null) goto L17;
        String r104 = r102.getString("secUid");
        if (r104 == null) goto L17;
    L18:
        r101[0] = TuplesKt.to("share_from_user_id", r104);
        r101[1] = TuplesKt.to("ticket_sku_id", r110.Z90());
        r101[2] = TuplesKt.to("enter_from_merge", r110.W90());
        Bundle r105 = r110.getArguments();
        if (r105 == null) goto L21;
        String r106 = r105.getString("source");
    L23:
        if (Intrinsics.areEqual(r106, "share_alert") == false) goto L25;
        String r107 = "token";
    L26:
        r101[3] = TuplesKt.to("enter_method", r107);
        Bundle r108 = r110.getArguments();
        if (r108 == null) goto L30;
        String r109 = r108.getString("ticketStatus");
        if (r109 == null) goto L30;
    L31:
        r101[4] = TuplesKt.to("ticket_status", r109);
        Bundle r111 = r110.getArguments();
        if (r111 == null) goto L35;
        String r112 = r111.getString("ticketId");
        if (r112 == null) goto L35;
    L36:
        r101[5] = TuplesKt.to("ticket_id", r112);
        Bundle r113 = r110.getArguments();
        if (r113 == null) goto L40;
        String r114 = r113.getString("ticketType");
        if (r114 == null) goto L40;
    L41:
        r101[6] = TuplesKt.to("ticket_type", r114);
        Bundle r115 = r110.getArguments();
        if (r115 == null) goto L45;
        String r116 = r115.getString("roomStatus");
        if (r116 == null) goto L45;
    L46:
        r101[7] = TuplesKt.to("paid_liveshow_room_status", r116);
        Bundle r117 = r110.getArguments();
        if (r117 == null) goto L50;
        String r118 = r117.getString("roomId");
        if (r118 == null) goto L50;
    L51:
        r101[8] = TuplesKt.to("paid_liveshow_room_id", r118);
        r101[9] = TuplesKt.to("share_from_type", r110.Y90());
        r110.O = MapsKt.mapOf(r101);
        User r119 = r110.K;
        if (r119 == null) goto L99;
        TextView r120 = r110.f158049i;
        if (r120 == null) goto L57;
        r120.setText("@" + r119.getNickName());
    L57:
        HSImageView r121 = r110.f158046f;
        ImageModel r122 = new ImageModel();
        ArrayList r123 = new ArrayList();
        py.k r124 = r119._avatarMedium;
        if (r124 == null) goto L63;
        List<String> r125 = r124.getUrls();
        if (r125 == null) goto L63;
        String r126 = (String) CollectionsKt.firstOrNull(r125);
        if (r126 == null) goto L63;
    L64:
        r123.add(r126);
        Unit r127 = Unit.INSTANCE;
        r122.mUrls = r123;
        py.k r128 = r119._avatarMedium;
        if (r128 == null) goto L72;
        List<String> r129 = r128.getUrls();
        if (r129 == null) goto L72;
        String r130 = (String) CollectionsKt.firstOrNull(r129);
        if (r130 == null) goto L72;
        r103 = r130;
    L72:
        r122.setUri(r103);
        ImageLoader.bindImage(r121, r122, -1, -1, new o(r110));
        ImageLoader.bindImage(r110.f158052l, r110.N, s1.k(R.dimen.ttlive_poster_title_size_280), s1.k(R.dimen.ttlive_poster_title_size_350), new p(r110));
        ImageLoader.bindDrawableResource(r110.f158058r, R.drawable.ttlive_bg_real_ticket);
        ImageLoader.bindDrawableResource(r110.A, R.drawable.ttlive_bg_ticket_shadow);
        TextView r131 = r110.f158053m;
        if (r131 == null) goto L75;
        r131.setText(r110.L);
    L75:
        TextView r132 = r110.f158054n;
        if (r132 == null) goto L78;
        StringBuilder r133 = new StringBuilder();
        r133.append(new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA).format(new Date(r110.M * ((long) 1000))));
        r133.append(" 直播");
        r132.setText(r133.toString());
    L78:
        TextView r134 = r110.f158051k;
        if (r134 == null) goto L81;
        r134.setText(s1.B(R.string.ttlive_send_ticket1));
    L81:
        TextView r135 = r110.f158047g;
        if (r135 == null) goto L84;
        r135.setText(s1.B(R.string.ttlive_take_ticket));
    L84:
        TextView r136 = r110.f158055o;
        if (r136 == null) goto L87;
        r136.setText(s1.B(R.string.ttlive_take_soon));
        r136.setOnClickListener(new n(r110));
    L87:
        ImageView r137 = r110.f158048h;
        if (r137 == null) goto L90;
        r137.setOnClickListener(new q(r110));
    L90:
        Context r138 = r110.getContext();
        if (r138 == null) goto L99;
        LinearLayout r139 = r110.f158056p;
        if (r139 == null) goto L96;
        r139.setOnClickListener(new r(r110, r138));
    L96:
        ConstraintLayout r140 = r110.f158066z;
        if (r140 == null) goto L99;
        r140.setVisibility(8);
    L63:
        r126 = "";
    L99:
        int r141 = r110.f158043J;
        if (r141 == 4) goto L104;
        if (r141 == 3) goto L104;
        int r142 = com.bytedance.android.livesdk.chatroom.paidlive.d.f107573a;
        com.bytedance.android.livesdk.chatroom.paidlive.d.a("livesdk_paidlive_get_friend_ticket_page_show", r110.O);
        return;
    L104:
        r110.ca0();
        return;
    L50:
        r118 = "";
    L45:
        r116 = "";
    L40:
        r114 = "";
    L35:
        r112 = "";
    L30:
        r109 = PromotionDepositPresaleActivity.SALE;
        goto L31
    L25:
        r107 = "";
        goto L26
    L21:
        r106 = null;
    L17:
        r104 = "";
        goto L18
    L8:
        if (r110.H == false) goto L12;
        ConstraintLayout r143 = r110.f158063w;
        if (r143 == null) goto L13;
        r143.setVisibility(0);
        goto L13
    }

    public final void V90(Function0<Unit> r100) {
        ea0(true);
        UtilityKotlinExtentionsKt.s(4000, false, false, new ShareTicketFragment$doSavePicAfterGrant$1(this), 6);
        this.B = true;
        this.F.add(Single.fromCallable(new b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r100)));
    }

    public final void da0(View r100) {
        ViewParent r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L10;
        r101 = r102;
    L10:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L14;
        r103.removeView(r100);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void ea0(boolean r100) {
        ViewGroup r101 = this.f158044d;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r103 = 0;
    L7:
        r101.setVisibility(r103);
        goto L8
    L6:
        r103 = 8;
    L8:
        View r104 = this.f158045e;
        if (r104 == null) goto L15;
        if (r100 == true) goto L13;
        r102 = 8;
    L13:
        r104.setVisibility(r102);
        return;
    }

    public static /* synthetic */ void ba0(ShareTicketFragment r100, boolean r101) {
        r100.aa0(r101, s1.B(R.string.ttlive_share_ticket_request_error));
    }

    public final void aa0(boolean r100, String r101) {
        if (r100 == false) goto L5;
        f2.c(r101, 0);
    L5:
        ea0(false);
        ConstraintLayout r102 = this.f158063w;
        if (r102 != null) goto L8;
    L9:
        ConstraintLayout r103 = this.f158063w;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
        return;
    L14:
        return;
    L8:
        if (r102.getVisibility() != 0) goto L9;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f158044d = (ViewGroup) r110.findViewById(R.id.l_loading);
        this.f158045e = r110.findViewById(R.id.ticket_double_loading_view);
        this.f158063w = (ConstraintLayout) r110.findViewById(R.id.cl_container);
        this.f158046f = (HSImageView) r110.findViewById(R.id.iv_avatar);
        this.f158047g = (TextView) r110.findViewById(R.id.tv_title);
        this.f158048h = (ImageView) r110.findViewById(R.id.iv_back);
        this.f158049i = (TextView) r110.findViewById(R.id.tv_sender);
        this.f158050j = (ImageView) r110.findViewById(R.id.iv_tip_bg);
        this.f158051k = (TextView) r110.findViewById(R.id.tv_send_tip);
        this.f158052l = (HSImageView) r110.findViewById(R.id.iv_ticket);
        this.f158053m = (TextView) r110.findViewById(R.id.tv_ticket_title);
        this.f158054n = (TextView) r110.findViewById(R.id.tv_ticket_time);
        this.f158055o = (TextView) r110.findViewById(R.id.tv_take);
        this.f158056p = (LinearLayout) r110.findViewById(R.id.ll_bottom_parent);
        TextView r112 = (TextView) r110.findViewById(R.id.tv_introduction);
        this.f158057q = (ImageView) r110.findViewById(R.id.iv_introduction);
        this.f158058r = (HSImageView) r110.findViewById(R.id.iv_real_ticket);
        this.f158059s = r110.findViewById(R.id.v_divider);
        this.f158060t = (TextView) r110.findViewById(R.id.tv_withdraw);
        this.f158061u = (ConstraintLayout) r110.findViewById(R.id.cl_ticket_parent);
        this.f158062v = (ConstraintLayout) r110.findViewById(R.id.cl_ticket_parent_parent);
        this.f158064x = (ConstraintLayout) r110.findViewById(R.id.cl_qrcode);
        this.f158065y = (HSImageView) r110.findViewById(R.id.iv_qrcode);
        this.f158066z = (ConstraintLayout) r110.findViewById(R.id.cl_ticket_top);
        this.A = (HSImageView) r110.findViewById(R.id.iv_shadow);
        View r113 = r110.findViewById(R.id.sv_root);
        if (r113 == null) goto L5;
        r113.setBackgroundResource(0);
        r113.setBackgroundResource(R.drawable.ttlive_bg_share_ticket);
    L5:
        ViewGroup r114 = this.f158044d;
        if (r114 == null) goto L8;
        a1.k(r114, s1.w());
        a1.p(r114, s1.y());
        r114.setOnClickListener(i.f158096a);
    L8:
        com.bytedance.android.livesdk.service.l.d().getClass();
        LivePosterApiService r115 = (LivePosterApiService) com.bytedance.android.live.network.c.b().e(LivePosterApiService.class);
        if (r115 == null) goto L31;
        ea0(true);
        ConstraintLayout r100 = this.f158063w;
        if (r100 == null) goto L14;
        r100.setVisibility(8);
    L14:
        HashMap<String, String> r101 = new HashMap();
        Bundle r102 = getArguments();
        String r103 = "";
        if (r102 == null) goto L18;
        String r104 = r102.getString("ticketId");
        if (r104 == null) goto L18;
    L19:
        r101.put("id", r104);
        r101.put("id_type", "1");
        Bundle r105 = getArguments();
        if (r105 == null) goto L23;
        String r106 = r105.getString("secUid");
        if (r106 == null) goto L23;
    L24:
        r101.put("from_user_sec_id", r106);
        Unit r107 = Unit.INSTANCE;
        ((ObservableSubscribeProxy) r115.queryPaidLiveViewRight(r101).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).as(AutoDispose.bind(this))).subscribe(new l(this), new m(this));
        HashMap<String, String> r108 = new HashMap();
        Bundle r109 = getArguments();
        if (r109 == null) goto L30;
        String r116 = r109.getString("ticketId");
        if (r116 == null) goto L30;
        r103 = r116;
    L30:
        r108.put("ticket_id", r103);
        ((ObservableSubscribeProxy) r115.queryShareTicketData(r108).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).as(AutoDispose.bind(this))).subscribe(new j(this), new k(this));
    L23:
        r106 = "";
    L18:
        r104 = "";
    L31:
        Bundle r117 = getArguments();
        String r118 = null;
        if (r117 == null) goto L34;
        String r119 = r117.getString("ticketId");
    L35:
        Bundle r120 = getArguments();
        if (r120 == null) goto L38;
        r118 = r120.getString("secUid");
    L38:
        com.bytedance.android.livesdk.vscore_api.paidlive.g r121 = com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e;
        com.bytedance.android.livesdk.share.f r122 = new com.bytedance.android.livesdk.share.f();
        if (r119 != null) goto L60;
    L44:
        long r123 = 0;
    L45:
        r122.f158090a = r123;
        Bundle r124 = getArguments();
        if (r124 == null) goto L49;
        String r125 = r124.getString("roomId");
        if (r125 == null) goto L49;
    L50:
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r122.f158091b = r125;
        Unit r126 = Unit.INSTANCE;
        r121.initTrace(r122);
        com.bytedance.android.livesdk.vscore_api.paidlive.g r127 = com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e;
        Pair[] r128 = new Pair[2];
        String r129 = "true";
        if (r119 != null) goto L53;
        Object r130 = "true";
    L54:
        r128[0] = TuplesKt.to("is_ticket_id_null", r130);
        if (r118 == null) goto L58;
        r129 = "false";
    L58:
        r128[1] = TuplesKt.to("is_sec_uid_null", r129);
        IPaidLiveTraceMonitor.DefaultImpls.trace$default(r127, "paidlive_ticket_receive_ticket_page_show", MapsKt.mutableMapOf(r128), null, null, null, 28, null);
        return;
    L53:
        r130 = "false";
    L49:
        r125 = "0";
        goto L50
    L60:
        r123 = CastLongProtector.parseLong(r119);     // Catch: NumberFormatException -> L42
    L42:
        e = move-exception;
        ALogger.e("ShareTicketFragment", e);
        goto L44
    L34:
        r119 = null;
        goto L35
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_fragment_share_ticket, r101, false);
    }
}
