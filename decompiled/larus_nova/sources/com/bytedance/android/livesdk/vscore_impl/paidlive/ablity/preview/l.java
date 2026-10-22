package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.s;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.live.datacontext.m;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import df6.q;
import df6.u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements com.bytedance.android.livesdk.vscore_api.paidlive.ability.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f160392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f160393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f160394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f160395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f160396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f160397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f160398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f160399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SmartImageView f160400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f160401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SmartImageView f160402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f160403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public GridLayout f160404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f160405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f160406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f160407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s f160408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FragmentActivity f160409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f160410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1<? super Map<String, String>, Unit> f160411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super Bundle, Unit> f160412u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public HSImageView f160413v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HSImageView f160414w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f160415x;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f160416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f160417b;

        public a(l r100, Bundle r101) {
            this.f160416a = r100;
            this.f160417b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super Bundle, Unit> r101 = this.f160416a.f160412u;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f160417b);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f160418a;

        public b(l r100) {
            this.f160418a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f160418a.getClass();
            Function1<? super Map<String, String>, Unit> r101 = this.f160418a.f160411t;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(new LinkedHashMap());
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void n1(int r100, int r101, int r102) {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void onEnter() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void z2() {
    }

    public final Room a() {
        com.bytedance.android.livesdk.vscore_api.paidlive.d r100 = this.f160415x.D().getRoomContext();
        if (r100 == null) goto L7;
        m<Room> r101 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.b(r100);
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void dc() {
        ViewGroup r100 = this.f160410s;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final View getView() {
        ViewGroup r100 = this.f160410s;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new FrameLayout(this.f160415x.D().b());
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void logTempMaskShow() {
        this.f160415x.l().getMTempWatchEndTime().setValue(Long.valueOf(System.currentTimeMillis()));
        com.bytedance.android.livesdk.vscore_api.paidlive.ability.i r100 = com.bytedance.android.livesdk.vscore_impl.paidlive.f.h(this.f160415x);
        if (r100 == null) goto L6;
        r100.Jo();
        return;
    }

    public l(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160415x = r100;
        this.f160392a = "SubScribeRoomPreviewMaskView[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
        this.f160408q = new s();
        this.f160409r = r100.D().b();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void setUIInfo(s r100) {
        Intrinsics.checkNotNullParameter(r100, "uiInfo");
        if (this.f160406o == true) goto L74;
        TextView r101 = null;
        View r102 = LayoutInflater.from(this.f160409r).inflate(R.layout.ttlive_subscribe_room_preview_feed_mask_view, null, true);
        if ((r102 instanceof ViewGroup) == true) goto L7;
        r102 = null;
    L7:
        ViewGroup r103 = (ViewGroup) r102;
        this.f160410s = r103;
        if (r103 == null) goto L10;
        HSImageView r104 = (HSImageView) r103.findViewById(R.id.blur_cover);
    L11:
        this.f160413v = r104;
        ViewGroup r105 = this.f160410s;
        if (r105 == null) goto L14;
        HSImageView r106 = (HSImageView) r105.findViewById(R.id.blur_background);
    L15:
        this.f160414w = r106;
        ViewGroup r107 = this.f160410s;
        if (r107 == null) goto L18;
        TextView r108 = (TextView) r107.findViewById(R.id.pre_price);
    L19:
        this.f160393b = r108;
        ViewGroup r109 = this.f160410s;
        if (r109 == null) goto L22;
        TextView r110 = (TextView) r109.findViewById(R.id.price);
    L23:
        this.f160394c = r110;
        ViewGroup r111 = this.f160410s;
        if (r111 == null) goto L26;
        TextView r112 = (TextView) r111.findViewById(R.id.origin_price);
    L26:
        ViewGroup r113 = this.f160410s;
        if (r113 == null) goto L29;
        ViewGroup r114 = (ViewGroup) r113.findViewById(R.id.guide_info_container);
    L30:
        this.f160395d = r114;
        ViewGroup r115 = this.f160410s;
        if (r115 == null) goto L33;
        TextView r116 = (TextView) r115.findViewById(R.id.guide_title);
    L34:
        this.f160396e = r116;
        ViewGroup r117 = this.f160410s;
        if (r117 == null) goto L37;
        TextView r118 = (TextView) r117.findViewById(R.id.guide_sub_title);
    L38:
        this.f160397f = r118;
        ViewGroup r119 = this.f160410s;
        if (r119 == null) goto L41;
        ViewGroup r120 = (ViewGroup) r119.findViewById(R.id.ticket_container);
    L42:
        this.f160398g = r120;
        ViewGroup r121 = this.f160410s;
        if (r121 == null) goto L45;
        TextView r122 = (TextView) r121.findViewById(R.id.nick_name);
    L46:
        this.f160399h = r122;
        ViewGroup r123 = this.f160410s;
        if (r123 == null) goto L49;
        SmartImageView r124 = (SmartImageView) r123.findViewById(R.id.avatar);
    L50:
        this.f160400i = r124;
        ViewGroup r125 = this.f160410s;
        if (r125 == null) goto L53;
        TextView r126 = (TextView) r125.findViewById(R.id.ticket_title);
    L54:
        this.f160401j = r126;
        ViewGroup r127 = this.f160410s;
        if (r127 == null) goto L57;
        TextView r128 = (TextView) r127.findViewById(R.id.ticket_live_tag);
    L58:
        this.f160403l = r128;
        ViewGroup r129 = this.f160410s;
        if (r129 == null) goto L61;
        SmartImageView r130 = (SmartImageView) r129.findViewById(R.id.lav_live_playing);
    L62:
        this.f160402k = r130;
        ViewGroup r131 = this.f160410s;
        if (r131 == null) goto L65;
        GridLayout r132 = (GridLayout) r131.findViewById(R.id.right_container);
    L66:
        this.f160404m = r132;
        ViewGroup r133 = this.f160410s;
        if (r133 == null) goto L69;
        r101 = (TextView) r133.findViewById(R.id.pay_button);
    L69:
        this.f160405n = r101;
        ViewGroup r134 = this.f160410s;
        if (r134 == null) goto L72;
        SmartImageView r135 = (SmartImageView) r134.findViewById(R.id.pay_share_ticket_button);
    L72:
        this.f160406o = true;
        goto L74
    L65:
        r132 = null;
        goto L66
    L61:
        r130 = null;
        goto L62
    L57:
        r128 = null;
        goto L58
    L53:
        r126 = null;
        goto L54
    L49:
        r124 = null;
        goto L50
    L45:
        r122 = null;
        goto L46
    L41:
        r120 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L22:
        r110 = null;
        goto L23
    L18:
        r108 = null;
        goto L19
    L14:
        r106 = null;
        goto L15
    L10:
        r104 = null;
    L74:
        if ((!Intrinsics.areEqual(this.f160408q, r100)) == false) goto L76;
        this.f160407p = false;
    L76:
        this.f160408q = r100;
        this.f160412u = r100.f159438l;
        this.f160411t = r100.f159436j;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void Kb(IRenderView r100, boolean r101) {
        if (this.f160407p == false) goto L13;
        ViewGroup r102 = this.f160410s;
        if (r102 != null) goto L7;
    L8:
        ViewGroup r103 = this.f160410s;
        if (r103 == null) goto L11;
        r103.setVisibility(0);
    L11:
        ALogger.d(this.f160392a, "render has rendered, skip");
        return;
    L7:
        if (r102.getVisibility() == 0) goto L11;
    L13:
        ViewGroup r104 = this.f160410s;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        Bundle r105 = new Bundle();
        r105.putString("enter_method", "paidlive_window_tryend");
        HSImageView r106 = this.f160413v;
        if (r106 == null) goto L19;
        r106.setAlpha(0.98f);
    L19:
        Room r107 = a();
        List<String> r108 = null;
        if (r107 == null) goto L26;
        py.k r109 = r107.getCover();
        if (r109 == null) goto L26;
        List<String> r110 = r109.getUrls();
        if (r110 == null) goto L26;
        ImageLoader.bindImage(this.f160413v, new ImageModel(null, r110), new l3(5, 1.0f, null));
    L26:
        HSImageView r111 = this.f160414w;
        if (r111 == null) goto L29;
        r111.setAlpha(0.98f);
    L29:
        HSImageView r112 = this.f160414w;
        if (r112 == null) goto L32;
        r112.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-foundation-service/pay_perform_temp_watch_portrait.webp").setAutoPlayAnimations(true).build());
    L32:
        HSImageView r113 = this.f160414w;
        if (r113 == null) goto L35;
        UtilityKotlinExtentionsKt.w(r113);
    L35:
        HSImageView r114 = this.f160413v;
        if (r114 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r114);
    L38:
        ViewGroup r115 = this.f160410s;
        if (r115 == null) goto L41;
        r115.setOnClickListener(new a(this, r105));
    L41:
        ViewGroup r116 = this.f160398g;
        if (r116 == null) goto L44;
        r116.setOnClickListener(new b(this));
    L44:
        TextView r117 = this.f160393b;
        if (r117 == null) goto L47;
        r117.setVisibility(0);
    L47:
        TextView r118 = this.f160394c;
        if (r118 == null) goto L50;
        r118.setVisibility(0);
    L50:
        TextView r119 = this.f160396e;
        if (r119 == null) goto L53;
        r119.setText(this.f160408q.f159431e);
    L53:
        TextView r120 = this.f160397f;
        if (r120 == null) goto L56;
        r120.setText(this.f160408q.f159432f);
    L56:
        TextView r121 = this.f160405n;
        if (r121 == null) goto L59;
        r121.setText(this.f160408q.f159434h);
    L59:
        TextView r122 = this.f160405n;
        if (r122 == null) goto L62;
        UtilityKotlinExtentionsKt.w(r122);
    L62:
        TextView r123 = this.f160401j;
        if (r123 == null) goto L65;
        r123.setText(this.f160408q.f159428b);
    L65:
        TextView r124 = this.f160399h;
        if (r124 == null) goto L76;
        Room r125 = a();
        if (r125 == null) goto L74;
        User r126 = r125.mo8271getOwner();
        if (r126 == null) goto L74;
        String r127 = "@" + r126.getRemarkNameOrRealNickName();
        if (r127 == null) goto L74;
    L75:
        r124.setText(r127);
    L74:
        r127 = "";
    L76:
        TextView r128 = this.f160403l;
        if (r128 == null) goto L79;
        r128.setText(this.f160408q.f159429c);
    L79:
        SmartImageView r129 = this.f160402k;
        if (r129 == null) goto L82;
        r129.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/ic_pay_live.webp").setAutoPlayAnimations(true).build());
    L82:
        SmartImageView r130 = this.f160400i;
        if (r130 == null) goto L92;
        Room r131 = a();
        if (r131 == null) goto L91;
        User r132 = r131.mo8271getOwner();
        if (r132 == null) goto L91;
        py.k r133 = r132._avatarMedium;
        if (r133 == null) goto L91;
        r108 = r133.getUrls();
    L91:
        u r134 = q.c(new ef6.a(r108));
        r134.f468294t = r130;
        r134.c();
    L92:
        GridLayout r135 = this.f160404m;
        if (r135 == null) goto L95;
        r135.removeAllViews();
    L95:
        String[] r136 = this.f160408q.f159430d;
        int r137 = r136.length;
        int r138 = 0;
    L96:
        if (r138 >= r137) goto L106;
        String r139 = r136[r138];
        if (this.f160409r == null) goto L105;
        GridLayout r140 = this.f160404m;
        if (r140 == null) goto L105;
        FragmentActivity r141 = this.f160409r;
        Intrinsics.checkNotNull(r141);
        RightView r142 = new RightView(r141);
        Intrinsics.checkNotNullParameter(r139, "tagName");
        TextView r143 = (TextView) r142.findViewById(R.id.tag_name);
        if (r143 == null) goto L104;
        r143.setText(r139);
    L104:
        r140.addView(r142);
    L105:
        r138 = r138 + 1;
        goto L96
    L106:
        ViewGroup r144 = this.f160410s;
        if (r144 == null) goto L111;
        if (r144.getVisibility() != 0) goto L111;
    L132:
        logTempMaskShow();
        this.f160407p = true;
        return;
    L111:
        if (this.f160398g == null) goto L132;
        if (this.f160395d == null) goto L132;
        ArrayList r145 = new ArrayList();
        HSImageView r146 = this.f160413v;
        if (r146 == null) goto L119;
        r145.add(ObjectAnimator.ofFloat(r146, "alpha", new float[]{0.0f, 0.98f}));
    L119:
        HSImageView r147 = this.f160414w;
        if (r147 == null) goto L122;
        r145.add(ObjectAnimator.ofFloat(r147, "alpha", new float[]{0.0f, 0.98f}));
    L122:
        ViewGroup r148 = this.f160398g;
        if (r148 == null) goto L125;
        r145.add(ObjectAnimator.ofFloat(r148, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{UtilityKotlinExtentionsKt.h(50), 0.0f}));
    L125:
        ViewGroup r149 = this.f160398g;
        if (r149 == null) goto L128;
        r145.add(ObjectAnimator.ofFloat(r149, "alpha", new float[]{0.0f, 1.0f}));
    L128:
        ViewGroup r150 = this.f160395d;
        if (r150 == null) goto L131;
        r145.add(ObjectAnimator.ofFloat(r150, "alpha", new float[]{0.0f, 1.0f}));
    L131:
        AnimatorSet r151 = new AnimatorSet();
        r151.setDuration(300);
        r151.playTogether(r145);
        r151.addListener(new k(this, r145));
        r151.start();
        goto L132
    }
}
