package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.AuthorReputation;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.HeartDiamondInfo;
import com.bytedance.android.live.base.model.user.HonorWallUi;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ShopHeaderIcon;
import com.bytedance.android.live.base.model.user.ShopHeaderInfo;
import com.bytedance.android.live.base.model.user.WindowHeaderInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;

/* JADX INFO: loaded from: classes47.dex */
public final class s implements com.bytedance.android.live.profile.ui.base.g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f86765t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.profile.a f86766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f86767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f86768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f86769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f86770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f86771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f86772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f86773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f86774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HSImageView f86775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f86776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f86777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f86778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f86779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f86780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f86781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f86782q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f86783r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.l f86784s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r100) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public final void a() {
        TextView r100 = this.f86770e;
        if (r100 == null) goto L11;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L11;
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L11;
    L15:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L30;
        TextView r104 = this.f86771f;
        if (r104 == null) goto L30;
        CharSequence r105 = r104.getText();
        if (r105 == null) goto L30;
        if (r105.length() <= 0) goto L25;
        boolean r106 = true;
    L26:
        if (r106 != true) goto L30;
        View r107 = this.f86772g;
        if (r107 == null) goto L34;
        r107.setVisibility(0);
        return;
    L34:
        return;
    L25:
        r106 = false;
    L30:
        View r108 = this.f86772g;
        if (r108 == null) goto L36;
        r108.setVisibility(8);
        return;
    L36:
        return;
    L9:
        r102 = false;
    L11:
        HSImageView r109 = this.f86775j;
        if (r109 != null) goto L14;
    L16:
        r103 = false;
        goto L17
    L14:
        if (r109.getVisibility() != 0) goto L16;
        goto L15
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        View r100 = this.f86784s.getHostFragment().getView();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L8;
        r101.removeView(this.f86768c);
    L8:
        View r102 = this.f86768c;
        if (r102 == null) goto L12;
        UtilityKotlinExtentionsKt.q(r102);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.ShopComponent.INSTANCE;
    }

    public s(com.bytedance.android.live.profile.ui.base.l r100) {
        Intrinsics.checkNotNullParameter(r100, "hostBehavior");
        this.f86784s = r100;
        this.f86766a = r100.a();
        this.f86767b = r100.getHostFragment();
        this.f86776k = new AtomicBoolean(false);
        this.f86777l = new AtomicBoolean(false);
        this.f86778m = new AtomicBoolean(false);
        long r101 = SystemClock.uptimeMillis();
        Fragment r102 = r100.getHostFragment();
        LinearLayout r103 = null;
        if (r102 == null) goto L7;
        View r104 = r102.getView();
        if (r104 == null) goto L7;
        ViewStub r105 = (ViewStub) r104.findViewById(R.id.new_profile_shop);
    L8:
        if (r105 == null) goto L10;
        View r106 = r105.inflate();
    L11:
        this.f86768c = r106;
        if (r106 == null) goto L14;
        TextView r107 = (TextView) r106.findViewById(R.id.tv_sale_name);
    L15:
        this.f86769d = r107;
        if (r106 == null) goto L18;
        HSImageView r108 = (HSImageView) r106.findViewById(R.id.xzg_icon);
    L19:
        this.f86775j = r108;
        if (r106 == null) goto L22;
        TextView r109 = (TextView) r106.findViewById(R.id.tv_sale_1);
    L23:
        this.f86770e = r109;
        if (r106 == null) goto L26;
        TextView r110 = (TextView) r106.findViewById(R.id.tv_sale_2);
    L27:
        this.f86771f = r110;
        if (r106 == null) goto L30;
        View r111 = r106.findViewById(R.id.shop_divider_view_1);
    L31:
        this.f86772g = r111;
        if (r106 == null) goto L34;
        LinearLayout r112 = (LinearLayout) r106.findViewById(R.id.layout_sale_entrance);
    L35:
        this.f86773h = r112;
        if (r106 == null) goto L38;
        r103 = (LinearLayout) r106.findViewById(R.id.layout_sale_label);
    L38:
        this.f86774i = r103;
        if (r106 == null) goto L41;
        ConstraintLayout r113 = (ConstraintLayout) r106.findViewById(R.id.layout_sale_first_line);
    L41:
        if (r106 == null) goto L43;
        ConstraintLayout r114 = (ConstraintLayout) r106.findViewById(R.id.layout_sale_detail);
    L43:
        long r115 = SystemClock.uptimeMillis();
        StringBuilder r116 = new StringBuilder("native shop init view cost = ");
        long r117 = r115 - r101;
        r116.append(r117);
        ALogger.i("TriangleManager", r116.toString());
        this.f86783r = r117;
        return;
    L34:
        r112 = null;
        goto L35
    L30:
        r111 = null;
        goto L31
    L26:
        r110 = null;
        goto L27
    L22:
        r109 = null;
        goto L23
    L18:
        r108 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L10:
        r106 = null;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        EcomInfo r101 = r100.ecomInfo;
        if (r101 == null) goto L5;
        int r102 = r101.getEcomType();
        this.f86784s.a().showShopEntrance(r102, "live_personal_button");
    L5:
        this.f86784s.b().recordBusinessShow(TrackArea.BottomOperatingArea, "shop");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r110) {
        Intrinsics.checkNotNullParameter(r110, "user");
        com.bytedance.android.live.profile.profilecontext.a r100 = this.f86784s.b();
        if (r100 == null) goto L7;
        ProfileMonitor r101 = r100.getProfileMonitor();
        if (r101 == null) goto L7;
        r101.d(DataType.IsShopDSL, "0");
    L7:
        long r102 = SystemClock.uptimeMillis();
        com.bytedance.android.live.profile.ui.base.l r103 = this.f86784s;
        if (r103 != null) goto L10;
    L16:
        boolean r104 = false;
    L17:
        EcomInfo r111 = r110.ecomInfo;
        if (r111 != null) goto L232;
    L222:
        long r105 = (SystemClock.uptimeMillis() - r102) + this.f86783r;
        ALogger.i("TriangleManager", "native shop all cost = " + r105);
        j0.l().sendLog("livesdk_dsl_load_component_card", MapsKt.mapOf(new Pair[]{TuplesKt.to("id", "shop_card_slice"), TuplesKt.to(ChameleonOpenTracker.ParamKey.COST, String.valueOf(r105)), TuplesKt.to("useCache", "0"), TuplesKt.to("is_dsl", "0")}), new Object[]{IRoom.class, am2.x.class});
        EcomInfo r106 = r110.ecomInfo;
        if (r106 == null) goto L225;
        final Integer r112 = Integer.valueOf(r106.getEcomType());
    L226:
        if (r112 == null) goto L246;
        View r107 = this.f86768c;
        if (r107 == null) goto L245;
        r107.setOnClickListener(new w0(new ProfileShopComponent$bindClick$1(this, r112), 500));
        return;
    L245:
        return;
    L246:
        return;
    L225:
        r112 = null;
        goto L226
    L232:
        View r108 = this.f86768c;     // Catch: Exception -> L52
        if (r108 == null) goto L22;
        Drawable r109 = r108.getBackground();     // Catch: Exception -> L52
    L24:
        if ((r109 instanceof GradientDrawable) == true) goto L26;
        r109 = null;
    L26:
        GradientDrawable r113 = (GradientDrawable) r109;     // Catch: Exception -> L52
        if (r113 == null) goto L29;
        r113.setShape(0);     // Catch: Exception -> L52
    L29:
        if (r113 == null) goto L31;
        r113.setGradientType(0);     // Catch: Exception -> L52
    L31:
        if (r113 == null) goto L33;
        r113.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Exception -> L52
    L33:
        Map<Integer, HonorWallUi.HonorWallBg> r114 = r111.ecomWallBgs;     // Catch: Exception -> L52
        if (r114 == null) goto L38;
        HonorWallUi.HonorWallBg r115 = r114.get(Integer.valueOf(r111.getEcomType()));     // Catch: Exception -> L52
        if (r115 == null) goto L38;
        String r116 = r115.gradientStart;     // Catch: Exception -> L52
    L39:
        int r117 = Color.parseColor(r116);     // Catch: Exception -> L52
        Map<Integer, HonorWallUi.HonorWallBg> r118 = r111.ecomWallBgs;     // Catch: Exception -> L52
        if (r118 == null) goto L44;
        HonorWallUi.HonorWallBg r119 = r118.get(Integer.valueOf(r111.getEcomType()));     // Catch: Exception -> L52
        if (r119 == null) goto L44;
        String r120 = r119.gradientEnd;     // Catch: Exception -> L52
    L45:
        int r121 = Color.parseColor(r120);     // Catch: Exception -> L52
        if (r113 == null) goto L48;
        r113.setColors(new int[]{r117, r121});     // Catch: Exception -> L52
    L48:
        View r122 = this.f86768c;     // Catch: Exception -> L52
        if (r122 == null) goto L54;
        r122.setBackground(r113);     // Catch: Exception -> L52
    L54:
        View r123 = this.f86768c;
        if (r123 == null) goto L67;
        HSImageView r124 = (HSImageView) r123.findViewById(R.id.right_car_icon);
        if (r124 == null) goto L67;
        Map<Integer, HonorWallUi.HonorWallBg> r125 = r111.ecomWallBgs;
        if (r125 == null) goto L67;
        HonorWallUi.HonorWallBg r126 = r125.get(Integer.valueOf(r111.getEcomType()));
        if (r126 == null) goto L67;
        py.k r127 = r126.icon;
        if (r127 == null) goto L67;
        r124.setVisibility(0);
        a1.p(r124, UtilityKotlinExtentionsKt.i(r127.getWidth()));
        a1.k(r124, UtilityKotlinExtentionsKt.i(r127.getHeight()));
        ImageLoader.bindImage(r124, r127);
    L67:
        if (r111.isShopType() == false) goto L78;
        ShopHeaderInfo r128 = r111.getShopHeaderInfo();
        if (r128 == null) goto L71;
        ProfileText r129 = r128.getJumpGuideInfo();
    L72:
        this.f86782q = 0;
        if (r129 == null) goto L75;
        int r130 = r129.imagePiecesCount();
    L76:
        this.f86781p = r130;
        zs0.a r131 = zs0.c.f573457a;
        zs0.c.a(this.f86773h, r129, new u(this), null);
    L89:
        if (r111.isWindowType() == false) goto L103;
        if (r104 == false) goto L94;
        TextView r132 = this.f86769d;
        if (r132 == null) goto L116;
        r132.setText(s1.B(R.string.ttlive_profile_window));
    L116:
        ShopHeaderInfo r133 = r111.getShopHeaderInfo();
        if (r133 == null) goto L140;
        List<ShopHeaderIcon> r134 = r133.getShopHeaderIconList();
        if (r134 == null) goto L140;
        this.f86780o = 0;
        this.f86779n = r134.size();
        Iterator<T> r135 = r134.iterator();
    L123:
        if (r135.hasNext() == false) goto L140;
        ShopHeaderIcon r136 = (ShopHeaderIcon) r135.next();
        if (r136 == null) goto L123;
        py.k r137 = r136.getUrl();
        if (r137 == null) goto L123;
        View r138 = this.f86768c;
        if (r138 == null) goto L123;
        Context r139 = r138.getContext();
        if (r139 == null) goto L123;
        HSImageView r140 = new HSImageView(r139);
        LinearLayout r141 = this.f86774i;
        if (r141 == null) goto L138;
        LinearLayout.LayoutParams r142 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r137.getWidth()), UtilityKotlinExtentionsKt.i(r137.getHeight()));
        r142.gravity = 16;
        r142.leftMargin = UtilityKotlinExtentionsKt.i(4);
        Unit r143 = Unit.INSTANCE;
        r141.addView(r140, r142);
    L138:
        ImageUtil.loadImage(r140, r137, new t(this));
    L140:
        if (r111.isWindowType() == false) goto L159;
        WindowHeaderInfo r144 = r111.getWindowHeaderInfo();
        if (r144 == null) goto L144;
        AuthorReputation r145 = r144.getReputation();
    L145:
        TextView r146 = this.f86770e;
        if (r146 == null) goto L151;
        if (r145 == null) goto L149;
        String r147 = r145.getText();
    L150:
        r146.setText(r147);
        goto L151
    L149:
        r147 = null;
    L151:
        TextView r148 = this.f86771f;
        if (r148 == null) goto L157;
        if (r145 == null) goto L155;
        String r149 = r145.getRecommendCount();
    L156:
        r148.setText(r149);
        goto L157
    L155:
        r149 = null;
    L157:
        a();
        this.f86777l.set(true);
    L210:
        int r150 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        if (b0.f539045a.getValue().l() == false) goto L222;
        int r151 = com.bytedance.android.live.profile.ui.util.m.f86955a;
        com.bytedance.android.live.profile.ui.util.m.e(this.f86769d, r111.titleColor);
        View r152 = this.f86768c;
        if (r152 == null) goto L216;
        View r153 = r152.findViewById(R.id.layout_sale_entrance);
    L217:
        com.bytedance.android.live.profile.ui.util.m.e(r153, r111.titleColor);
        View r154 = this.f86768c;
        if (r154 == null) goto L220;
        View r155 = r154.findViewById(R.id.layout_sale_detail);
    L221:
        com.bytedance.android.live.profile.ui.util.m.e(r155, r111.contentColor);
        goto L222
    L220:
        r155 = null;
        goto L221
    L216:
        r153 = null;
        goto L217
    L144:
        r145 = null;
        goto L145
    L159:
        if (r111.isShopType() == false) goto L210;
        ShopHeaderInfo r156 = r111.getShopHeaderInfo();
        if (r156 == null) goto L163;
        HeartDiamondInfo r157 = r156.getHeartDiamondInfo();
    L164:
        if (r157 == null) goto L187;
        TextView r158 = this.f86770e;
        if (r158 == null) goto L168;
        UtilityKotlinExtentionsKt.u(r158);
    L168:
        HSImageView r159 = this.f86775j;
        if (r159 == null) goto L171;
        UtilityKotlinExtentionsKt.w(r159);
    L171:
        HSImageView r160 = this.f86775j;
        ShopHeaderInfo r161 = r111.getShopHeaderInfo();
        if (r161 == null) goto L176;
        HeartDiamondInfo r162 = r161.getHeartDiamondInfo();
        if (r162 == null) goto L176;
        py.k r163 = r162.getHeartDiamondIcon();
    L177:
        ImageLoader.bindImage(r160, r163, new v(this));
        TextView r164 = this.f86771f;
        if (r164 == null) goto L186;
        ShopHeaderInfo r165 = r111.getShopHeaderInfo();
        if (r165 == null) goto L184;
        AuthorReputation r166 = r165.getShopReputation();
        if (r166 == null) goto L184;
        String r167 = r166.getSales();
    L185:
        r164.setText(r167);
    L184:
        r167 = null;
    L186:
        a();
    L176:
        r163 = null;
        goto L177
    L187:
        HSImageView r168 = this.f86775j;
        if (r168 == null) goto L190;
        UtilityKotlinExtentionsKt.u(r168);
    L190:
        TextView r169 = this.f86770e;
        if (r169 == null) goto L193;
        UtilityKotlinExtentionsKt.w(r169);
    L193:
        ShopHeaderInfo r170 = r111.getShopHeaderInfo();
        if (r170 == null) goto L196;
        AuthorReputation r171 = r170.getShopReputation();
    L197:
        TextView r172 = this.f86770e;
        if (r172 == null) goto L203;
        if (r171 == null) goto L201;
        String r173 = r171.getText();
    L202:
        r172.setText(r173);
        goto L203
    L201:
        r173 = null;
    L203:
        TextView r174 = this.f86771f;
        if (r174 == null) goto L209;
        if (r171 == null) goto L207;
        String r175 = r171.getSales();
    L208:
        r174.setText(r175);
        goto L209
    L207:
        r175 = null;
    L209:
        a();
        this.f86777l.set(true);
        goto L210
    L196:
        r171 = null;
        goto L197
    L163:
        r157 = null;
        goto L164
    L94:
        TextView r176 = this.f86769d;
        if (r176 == null) goto L116;
        WindowHeaderInfo r177 = r111.getWindowHeaderInfo();
        if (r177 == null) goto L100;
        String r178 = r177.getWindowName();
        if (r178 == null) goto L100;
    L101:
        r176.setText(r178);
    L100:
        r178 = "推荐橱窗";
        goto L101
    L103:
        if (r111.isShopType() == false) goto L116;
        if (r104 == false) goto L108;
        TextView r179 = this.f86769d;
        if (r179 == null) goto L116;
        r179.setText(s1.B(R.string.ttlive_profile_shop_see_self));
        goto L116
    L108:
        TextView r180 = this.f86769d;
        if (r180 == null) goto L116;
        ShopHeaderInfo r181 = r111.getShopHeaderInfo();
        if (r181 == null) goto L114;
        String r182 = r181.getShopName();
        if (r182 == null) goto L114;
    L115:
        r180.setText(r182);
    L114:
        r182 = "推荐店铺";
        goto L115
    L75:
        r130 = 0;
        goto L76
    L71:
        r129 = null;
        goto L72
    L78:
        if (r111.isWindowType() == false) goto L89;
        WindowHeaderInfo r183 = r111.getWindowHeaderInfo();
        if (r183 == null) goto L82;
        ProfileText r184 = r183.getJumpGuideInfo();
    L83:
        this.f86782q = 0;
        if (r184 == null) goto L86;
        int r185 = r184.imagePiecesCount();
    L87:
        this.f86781p = r185;
        zs0.a r186 = zs0.c.f573457a;
        zs0.c.a(this.f86773h, r184, new u(this), null);
        goto L89
    L86:
        r185 = 0;
        goto L87
    L82:
        r184 = null;
    L44:
        r120 = null;
    L38:
        r116 = null;
        goto L39
    L22:
        r109 = null;
    L52:
        e = move-exception;
        ALogger.e("ProfileShopComponent", "parse background error: " + e.getMessage());
        goto L54
    L10:
        if (r103.c() != 1) goto L16;
        com.bytedance.android.live.profile.ui.base.l r187 = this.f86784s;
        if (r187 == null) goto L16;
        if (r187.getTargetType() != 2) goto L16;
        r104 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileShopComponent update");
        LinearLayout r101 = this.f86773h;
        if (r101 == null) goto L5;
        r101.removeAllViews();
    L5:
        LinearLayout r102 = this.f86774i;
        if (r102 == null) goto L8;
        r102.removeAllViews();
    L8:
        TextView r103 = this.f86770e;
        if (r103 == null) goto L11;
        r103.setVisibility(0);
    L11:
        TextView r104 = this.f86771f;
        if (r104 == null) goto L14;
        r104.setVisibility(0);
    L14:
        HSImageView r105 = this.f86775j;
        if (r105 == null) goto L17;
        r105.setVisibility(0);
    L17:
        this.f86776k.set(false);
        this.f86777l.set(false);
        this.f86778m.set(false);
        this.f86779n = 0;
        this.f86780o = 0;
        this.f86781p = 0;
        this.f86782q = 0;
        TextView r106 = this.f86769d;
        if (r106 == null) goto L20;
        r106.setTextColor(-16777216);
    L20:
        int r107 = com.bytedance.android.live.profile.ui.util.m.f86955a;
        View[] r108 = new View[2];
        View r109 = this.f86768c;
        View r110 = null;
        if (r109 == null) goto L23;
        View r111 = r109.findViewById(R.id.tv_sale_1);
    L24:
        r108[0] = r111;
        View r112 = this.f86768c;
        if (r112 == null) goto L27;
        r110 = r112.findViewById(R.id.tv_sale_2);
    L27:
        r108[1] = r110;
        com.bytedance.android.live.profile.ui.util.m.g(CollectionsKt.listOf(r108), s1.h(R.color.ttlive_shop_component_info));
        g(r100);
        return;
    L23:
        r111 = null;
        goto L24
    }
}
