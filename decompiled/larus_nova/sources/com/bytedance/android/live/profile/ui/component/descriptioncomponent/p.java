package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.ExtraInfo;
import com.bytedance.android.live.base.model.user.HonorWallBg;
import com.bytedance.android.live.base.model.user.HonorWallContent;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBusinessArea;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.base.model.user.ProfileFansClubData;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ProfileTextPiece;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.profile.customview.TrapezoidConstraintLayout;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p extends com.bytedance.android.live.profile.ui.base.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f86666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f86667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f86668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f86669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f86670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatTextView f86671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TrapezoidConstraintLayout f86672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f86673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f86674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f86675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppCompatTextView f86676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f86677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TrapezoidConstraintLayout f86678n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f86679o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f86680p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f86681q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f86682r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.h f86683s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.FansClubVip.INSTANCE;
    }

    public p(com.bytedance.android.live.profile.profilecontext.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        this.f86683s = r100;
        this.f86682r = LazyKt.lazy(new ProfileFansClubVipComponent$trapezoidWidth$2(this));
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
        LinearLayout r101 = null;
        if (ProfilePreInflateUtil.a() == false) goto L7;
        View r102 = ((com.bytedance.android.live.profile.ui.base.e) r100).b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_FANS_VIP, true);
        if (r102 == null) goto L10;
        ViewGroup r103 = (ViewGroup) r102.findViewById(R.id.root);
    L11:
        this.f86666b = r103;
        if (r103 == null) goto L14;
        ViewGroup r104 = (ViewGroup) r103.findViewById(R.id.fans_club_vip_single_line);
    L15:
        this.f86667c = r104;
        ViewGroup r105 = this.f86666b;
        if (r105 == null) goto L18;
        HSImageView r106 = (HSImageView) r105.findViewById(R.id.single_line_icon);
    L19:
        this.f86668d = r106;
        ViewGroup r107 = this.f86666b;
        if (r107 == null) goto L22;
        LinearLayout r108 = (LinearLayout) r107.findViewById(R.id.single_line_left_container);
    L23:
        this.f86669e = r108;
        ViewGroup r109 = this.f86666b;
        if (r109 == null) goto L26;
        LinearLayout r110 = (LinearLayout) r109.findViewById(R.id.single_line_right_container);
    L27:
        this.f86670f = r110;
        ViewGroup r111 = this.f86666b;
        if (r111 == null) goto L30;
        AppCompatTextView r112 = (AppCompatTextView) r111.findViewById(R.id.single_line_left_fans_level);
    L31:
        this.f86671g = r112;
        ViewGroup r113 = this.f86666b;
        if (r113 == null) goto L34;
        TrapezoidConstraintLayout r114 = (TrapezoidConstraintLayout) r113.findViewById(R.id.trapezoid_left);
    L35:
        this.f86672h = r114;
        ViewGroup r115 = this.f86666b;
        if (r115 == null) goto L38;
        HSImageView r116 = (HSImageView) r115.findViewById(R.id.trapeoid_left_icon);
    L39:
        this.f86673i = r116;
        ViewGroup r117 = this.f86666b;
        if (r117 == null) goto L42;
        LinearLayout r118 = (LinearLayout) r117.findViewById(R.id.trapeoid_left_left_container);
    L43:
        this.f86674j = r118;
        ViewGroup r119 = this.f86666b;
        if (r119 == null) goto L46;
        LinearLayout r120 = (LinearLayout) r119.findViewById(R.id.trapeoid_left_right_container);
    L47:
        this.f86675k = r120;
        ViewGroup r121 = this.f86666b;
        if (r121 == null) goto L50;
        AppCompatTextView r122 = (AppCompatTextView) r121.findViewById(R.id.trapeoid_left_right_fans_level);
    L51:
        this.f86676l = r122;
        ViewGroup r123 = this.f86666b;
        if (r123 == null) goto L54;
        TrapezoidConstraintLayout r124 = (TrapezoidConstraintLayout) r123.findViewById(R.id.trapezoid_right);
    L55:
        this.f86678n = r124;
        ViewGroup r125 = this.f86666b;
        if (r125 == null) goto L58;
        HSImageView r126 = (HSImageView) r125.findViewById(R.id.trapeoid_right_icon);
    L59:
        this.f86679o = r126;
        ViewGroup r127 = this.f86666b;
        if (r127 == null) goto L62;
        LinearLayout r128 = (LinearLayout) r127.findViewById(R.id.trapeoid_right_left_container);
    L63:
        this.f86680p = r128;
        ViewGroup r129 = this.f86666b;
        if (r129 == null) goto L66;
        r101 = (LinearLayout) r129.findViewById(R.id.trapeoid_right_right_container);
    L66:
        this.f86681q = r101;
        return;
    L62:
        r128 = null;
        goto L63
    L58:
        r126 = null;
        goto L59
    L54:
        r124 = null;
        goto L55
    L50:
        r122 = null;
        goto L51
    L46:
        r120 = null;
        goto L47
    L42:
        r118 = null;
        goto L43
    L38:
        r116 = null;
        goto L39
    L34:
        r114 = null;
        goto L35
    L30:
        r112 = null;
        goto L31
    L26:
        r110 = null;
        goto L27
    L22:
        r108 = null;
        goto L23
    L18:
        r106 = null;
        goto L19
    L14:
        r104 = null;
    L10:
        r103 = null;
        goto L11
    L7:
        View r130 = ((com.bytedance.android.live.profile.ui.base.e) r100).f(R.layout.ttlive_profile_fans_club_vip_layout, true);
        if (r130 == null) goto L10;
        r103 = (ViewGroup) r130.findViewById(R.id.root);
        goto L11
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        ProfileOpenArea r101 = r100.openArea;
        if (r101 == null) goto L61;
        ProfileBusinessArea r102 = r101.businessAreaV3;
        if (r102 == null) goto L74;
        List<HonorWallElement> r103 = r102.topElementList;
        if (r103 == null) goto L75;
        List r104 = CollectionsKt.filterNotNull(r103);
        if (r104 == null) goto L76;
        List r105 = CollectionsKt.take(r104, 2);
        if (r105 == null) goto L77;
        Iterator r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L78;
        HonorWallElement r107 = (HonorWallElement) r106.next();
        String r108 = r107.getName();
        if (r108 == null) goto L19;
        this.f86683s.recordBusinessShow(TrackArea.BottomOperatingArea, r108);
    L19:
        if (rs0.y.f539090a.getValue().c() == false) goto L48;
        ExtraInfo r109 = r107.getExtraInfo();
        if (r109 == null) goto L48;
        Map<String, String> r110 = r109.getShowEventParams();
        if (r110 == null) goto L48;
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r112 = r110.entrySet().iterator();
    L26:
        if (r112.hasNext() == false) goto L47;
        Map.Entry<String, String> r113 = r112.next();
        String r114 = r113.getKey();
        boolean r115 = true;
        if (r114 != null) goto L30;
    L33:
        boolean r116 = true;
    L34:
        if (r116 == true) goto L44;
        String r117 = r113.getValue();
        if (r117 != null) goto L38;
    L41:
        boolean r118 = true;
    L42:
        if (r118 == true) goto L44;
    L45:
        if (r115 == false) goto L26;
        r111.put(r113.getKey(), r113.getValue());
        goto L26
    L38:
        if (r117.length() == 0) goto L41;
        r118 = false;
    L44:
        r115 = false;
        goto L45
    L30:
        if (r114.length() == 0) goto L33;
        r116 = false;
        goto L34
    L47:
        this.f86683s.recordShowMap(r111);
    L48:
        ExtraInfo r119 = r107.getExtraInfo();
        if (r119 == null) goto L14;
        String r120 = r119.getShowEvent();
        if (r120 == null) goto L14;
        ExtraInfo r121 = r107.getExtraInfo();
        if (r121 == null) goto L56;
        Map<String, String> r122 = r121.getShowEventParams();
    L57:
        LinkedHashMap r123 = new LinkedHashMap();
        if (r122 == null) goto L60;
        r123.putAll(r122);
    L60:
        this.f86683s.sendLog(r120, r123, new Object[0]);
        goto L14
    L56:
        r122 = null;
        goto L57
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r110) {
        Intrinsics.checkNotNullParameter(r110, "user");
        ProfileOpenArea r100 = r110.openArea;
        if (r100 == null) goto L281;
        ProfileBusinessArea r101 = r100.businessAreaV3;
        if (r101 == null) goto L297;
        List<HonorWallElement> r102 = r101.topElementList;
        if (r102 == null) goto L298;
        List r103 = CollectionsKt.filterNotNull(r102);
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.isEmpty() == false) goto L15;
        return;
    L15:
        if (r103.size() != 1) goto L85;
        HonorWallElement r111 = (HonorWallElement) ListProtector.get(r103, 0);
        ViewGroup r104 = this.f86667c;
        if (r104 == null) goto L19;
        r104.setVisibility(0);
    L19:
        ExtraInfo r105 = r111.getExtraInfo();
        if (r105 != null) goto L22;
    L26:
        HonorWallContent r106 = r111.getHonorWallContent();
        if (r106 == null) goto L29;
        HonorWallBg r112 = r106.getHonorWallBg();
    L30:
        if (r112 == null) goto L75;
        GradientDrawable r113 = new GradientDrawable();
        r113.setShape(0);
        r113.setGradientType(0);
        r113.setOrientation(GradientDrawable.Orientation.BL_TR);
        r113.setCornerRadius(UtilityKotlinExtentionsKt.h(8));
        String r107 = r112.getColorStart();
        String r114 = r112.getColorEnd();
        if (r107 != null) goto L35;
    L38:
        boolean r115 = true;
    L39:
        if (r115 == true) goto L51;
        if (r114 != null) goto L42;
    L45:
        boolean r116 = true;
    L46:
        if (r116 == true) goto L51;
        r113.setColors(new int[]{Color.parseColor(r107), Color.parseColor(r114)});     // Catch: Exception -> L49
    L49:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgOneElement bg color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L51
    L42:
        if (r114.length() == 0) goto L45;
        r116 = false;
    L51:
        String r108 = r112.getBorderColor();
        if (r108 != null) goto L54;
    L57:
        boolean r109 = true;
    L58:
        if (r109 == false) goto L290;
    L63:
        ViewGroup r117 = this.f86667c;
        if (r117 == null) goto L66;
        r117.setBackground(r113);
    L66:
        py.k r118 = r112.getIcon();
        if (r118 == null) goto L75;
        HSImageView r119 = this.f86668d;
        if (r119 == null) goto L71;
        a1.p(r119, UtilityKotlinExtentionsKt.i(r118.getWidth()));
    L71:
        HSImageView r120 = this.f86668d;
        if (r120 == null) goto L74;
        a1.k(r120, UtilityKotlinExtentionsKt.i(r118.getHeight()));
    L74:
        ImageLoader.bindImage(this.f86668d, r118, UtilityKotlinExtentionsKt.i(r118.getWidth()), UtilityKotlinExtentionsKt.i(r118.getHeight()));
        goto L75
    L290:
        r113.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r108));     // Catch: Exception -> L61
    L61:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgOneElement stroke error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L63
    L54:
        if (r108.length() == 0) goto L57;
        r109 = false;
        goto L58
    L35:
        if (r107.length() == 0) goto L38;
        r115 = false;
    L75:
        zs0.a r121 = zs0.c.f573457a;
        LinearLayout r122 = this.f86669e;
        HonorWallContent r123 = r111.getHonorWallContent();
        if (r123 == null) goto L78;
        ProfileText r124 = r123.getHonorWallTopDisplay();
    L79:
        zs0.c.a(r122, r124, null, null);
        LinearLayout r125 = this.f86670f;
        HonorWallContent r126 = r111.getHonorWallContent();
        if (r126 == null) goto L82;
        ProfileText r127 = r126.getHonorWallBottomDisplay();
    L83:
        zs0.c.a(r125, r127, null, null);
        List<ProfileTextPiece> r128 = null;
    L229:
        HonorWallElement r129 = (HonorWallElement) ListProtector.get(r103, 0);
        if (r103.size() != 1) goto L232;
        boolean r130 = true;
    L233:
        ProfileFansClub r131 = r110.fansClub;
        if (r131 == null) goto L238;
        ProfileFansClubData r132 = r131.getData();
        if (r132 == null) goto L238;
        int r133 = r132.level;
    L239:
        int r134 = UtilityKotlinExtentionsKt.i(48);
        HonorWallContent r135 = r129.getHonorWallContent();
        if (r135 == null) goto L295;
        ProfileText r136 = r135.getHonorWallTopDisplay();
        if (r136 == null) goto L245;
        List<ProfileTextPiece> r137 = r136.getPieces();
    L246:
        if (r137 != null) goto L248;
        r137 = CollectionsKt.emptyList();
    L248:
        ProfileText r138 = r135.getHonorWallBottomDisplay();
        if (r138 == null) goto L251;
        List<ProfileTextPiece> r139 = r138.getPieces();
    L252:
        if (r139 != null) goto L255;
        r139 = CollectionsKt.emptyList();
    L255:
        if (r137.size() <= 1) goto L257;
        boolean r140 = true;
    L258:
        if (r140 == false) goto L262;
        ViewGroup r141 = this.f86666b;
        if (r141 == null) goto L262;
        a1.k(r141, r134);
    L262:
        if (r130 != true) goto L264;
        AppCompatTextView r142 = this.f86671g;
    L266:
        if (r142 == null) goto L296;
        ProfileTextPiece r143 = (ProfileTextPiece) CollectionsKt.firstOrNull(r139);
        if (r143 != null) goto L271;
    L273:
        boolean r144 = false;
    L274:
        if (r144 == false) goto L277;
        if (r133 <= 0) goto L277;
        r142.setText(String.valueOf(r133));
        r142.setVisibility(0);
        this.f86677m = true;
        return;
    L277:
        r142.setVisibility(8);
        return;
    L271:
        if (r143.getType() != ProfileTextPiece.PIECE_TYPE_IMAGE) goto L273;
        r144 = true;
        goto L274
    L296:
        return;
    L264:
        if (r130 == true) goto L280;
        r142 = this.f86676l;
        goto L266
    L280:
        throw new NoWhenBranchMatchedException();
    L257:
        r140 = false;
        goto L258
    L251:
        r139 = r128;
        goto L252
    L245:
        r137 = r128;
        goto L246
    L295:
        return;
    L238:
        r133 = 0;
        goto L239
    L232:
        r130 = false;
        goto L233
    L82:
        r127 = null;
        goto L83
    L78:
        r124 = null;
        goto L79
    L29:
        r112 = null;
        goto L30
    L22:
        if (r105.isCanClick() != true) goto L26;
        ViewGroup r145 = this.f86667c;
        if (r145 == null) goto L26;
        r145.setOnClickListener(new q(this, r111));
        goto L26
    L85:
        HonorWallElement r146 = (HonorWallElement) ListProtector.get(r103, 0);
        HonorWallElement r147 = (HonorWallElement) ListProtector.get(r103, 1);
        TrapezoidConstraintLayout r148 = this.f86672h;
        if (r148 == null) goto L88;
        r148.setVisibility(0);
    L88:
        TrapezoidConstraintLayout r149 = this.f86678n;
        if (r149 == null) goto L91;
        r149.setVisibility(0);
    L91:
        TrapezoidConstraintLayout r150 = this.f86672h;
        if (r150 == null) goto L94;
        a1.p(r150, ((Number) this.f86682r.getValue()).intValue());
    L94:
        ExtraInfo r151 = r146.getExtraInfo();
        if (r151 != null) goto L97;
    L101:
        HonorWallContent r152 = r146.getHonorWallContent();
        if (r152 == null) goto L104;
        HonorWallBg r153 = r152.getHonorWallBg();
    L106:
        if (r153 == null) goto L152;
        TrapezoidConstraintLayout r154 = this.f86672h;
        if (r154 == null) goto L152;
        r154.setAcuteAnglePosition(1);
        r154.setAcuteAngleDegree(60.0f);
        r154.setLeftCornerRadius(UtilityKotlinExtentionsKt.h(8));
        r154.setRightCornerRadius(UtilityKotlinExtentionsKt.h(2));
        String r155 = r153.getColorStart();
        if (r155 != null) goto L113;
    L116:
        boolean r156 = true;
    L117:
        if (r156 == true) goto L130;
        String r157 = r153.getColorEnd();
        if (r157 != null) goto L121;
    L124:
        boolean r158 = true;
    L125:
        if (r158 == true) goto L130;
        r154.setGradientOrientation(GradientDrawable.Orientation.BL_TR);     // Catch: Exception -> L128
        r154.setColors(new int[]{Color.parseColor(r153.getColorStart()), Color.parseColor(r153.getColorEnd())});     // Catch: Exception -> L128
    L128:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft bg color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L130
    L121:
        if (r157.length() == 0) goto L124;
        r158 = false;
    L130:
        String r159 = r153.getBorderColor();
        if (r159 != null) goto L133;
    L136:
        boolean r160 = true;
    L137:
        if (r160 == false) goto L284;
    L143:
        py.k r161 = r153.getIcon();
        if (r161 == null) goto L152;
        HSImageView r162 = this.f86673i;
        if (r162 == null) goto L148;
        a1.p(r162, UtilityKotlinExtentionsKt.i(r161.getWidth()));
    L148:
        HSImageView r163 = this.f86673i;
        if (r163 == null) goto L151;
        a1.k(r163, UtilityKotlinExtentionsKt.i(r161.getHeight()));
    L151:
        ImageLoader.bindImage(this.f86673i, r161, UtilityKotlinExtentionsKt.i(r161.getWidth()), UtilityKotlinExtentionsKt.i(r161.getHeight()));
        goto L152
    L284:
        r154.setStrokeWidth(UtilityKotlinExtentionsKt.h(0.5f));     // Catch: Exception -> L141
        r154.setStrokeColor(Color.parseColor(r153.getBorderColor()));     // Catch: Exception -> L141
    L141:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft stroke error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L143
    L133:
        if (r159.length() == 0) goto L136;
        r160 = false;
        goto L137
    L113:
        if (r155.length() == 0) goto L116;
        r156 = false;
    L152:
        zs0.a r164 = zs0.c.f573457a;
        LinearLayout r165 = this.f86674j;
        HonorWallContent r166 = r146.getHonorWallContent();
        if (r166 == null) goto L155;
        ProfileText r167 = r166.getHonorWallTopDisplay();
    L156:
        zs0.c.a(r165, r167, null, null);
        LinearLayout r168 = this.f86675k;
        HonorWallContent r169 = r146.getHonorWallContent();
        if (r169 == null) goto L159;
        ProfileText r170 = r169.getHonorWallBottomDisplay();
    L160:
        zs0.c.a(r168, r170, null, null);
        TrapezoidConstraintLayout r171 = this.f86678n;
        if (r171 == null) goto L163;
        a1.p(r171, ((Number) this.f86682r.getValue()).intValue());
    L163:
        ExtraInfo r172 = r147.getExtraInfo();
        if (r172 != null) goto L166;
    L170:
        HonorWallContent r173 = r147.getHonorWallContent();
        if (r173 == null) goto L173;
        HonorWallBg r174 = r173.getHonorWallBg();
    L174:
        if (r174 == null) goto L220;
        TrapezoidConstraintLayout r175 = this.f86678n;
        if (r175 == null) goto L220;
        r175.setAcuteAnglePosition(3);
        r175.setAcuteAngleDegree(60.0f);
        r175.setLeftCornerRadius(UtilityKotlinExtentionsKt.h(2));
        r175.setRightCornerRadius(UtilityKotlinExtentionsKt.h(8));
        String r176 = r174.getColorStart();
        if (r176 != null) goto L181;
    L184:
        boolean r177 = true;
    L185:
        if (r177 == true) goto L198;
        String r178 = r174.getColorEnd();
        if (r178 != null) goto L189;
    L192:
        boolean r179 = true;
    L193:
        if (r179 == true) goto L198;
        r175.setGradientOrientation(GradientDrawable.Orientation.BL_TR);     // Catch: Exception -> L196
        r175.setColors(new int[]{Color.parseColor(r174.getColorStart()), Color.parseColor(r174.getColorEnd())});     // Catch: Exception -> L196
    L196:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft bg color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L198
    L189:
        if (r178.length() == 0) goto L192;
        r179 = false;
    L198:
        String r180 = r174.getBorderColor();
        if (r180 != null) goto L201;
    L204:
        boolean r181 = true;
    L205:
        if (r181 == false) goto L292;
    L211:
        py.k r182 = r174.getIcon();
        if (r182 == null) goto L220;
        HSImageView r183 = this.f86679o;
        if (r183 == null) goto L216;
        a1.p(r183, UtilityKotlinExtentionsKt.i(r182.getWidth()));
    L216:
        HSImageView r184 = this.f86679o;
        if (r184 == null) goto L219;
        a1.k(r184, UtilityKotlinExtentionsKt.i(r182.getHeight()));
    L219:
        ImageLoader.bindImage(this.f86679o, r182, UtilityKotlinExtentionsKt.i(r182.getWidth()), UtilityKotlinExtentionsKt.i(r182.getHeight()));
        goto L220
    L292:
        r175.setStrokeWidth(UtilityKotlinExtentionsKt.h(0.5f));     // Catch: Exception -> L209
        r175.setStrokeColor(Color.parseColor(r174.getBorderColor()));     // Catch: Exception -> L209
    L209:
        e = move-exception;
        ALogger.e("ProfileFansClubVipComponent", "renderBgTwoElementLeft stroke error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L211
    L201:
        if (r180.length() == 0) goto L204;
        r181 = false;
        goto L205
    L181:
        if (r176.length() == 0) goto L184;
        r177 = false;
    L220:
        zs0.a r185 = zs0.c.f573457a;
        LinearLayout r186 = this.f86680p;
        HonorWallContent r187 = r147.getHonorWallContent();
        if (r187 == null) goto L223;
        ProfileText r188 = r187.getHonorWallTopDisplay();
    L224:
        r128 = null;
        zs0.c.a(r186, r188, null, null);
        LinearLayout r189 = this.f86681q;
        HonorWallContent r190 = r147.getHonorWallContent();
        if (r190 == null) goto L227;
        ProfileText r191 = r190.getHonorWallBottomDisplay();
    L228:
        zs0.c.a(r189, r191, null, null);
        goto L229
    L227:
        r191 = null;
        goto L228
    L223:
        r188 = null;
        goto L224
    L173:
        r174 = null;
        goto L174
    L166:
        if (r172.isCanClick() != true) goto L170;
        TrapezoidConstraintLayout r192 = this.f86678n;
        if (r192 == null) goto L170;
        r192.setOnClickListener(new s(this, r147));
        goto L170
    L159:
        r170 = null;
        goto L160
    L155:
        r167 = null;
        goto L156
    L104:
        r153 = null;
        goto L106
    L97:
        if (r151.isCanClick() != true) goto L101;
        TrapezoidConstraintLayout r193 = this.f86672h;
        if (r193 == null) goto L101;
        r193.setOnClickListener(new r(this, r146));
        goto L101
    L298:
        return;
    L297:
        return;
    }

    public final void k(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L22;
        com.bytedance.android.live.profile.ui.base.d r102 = this.f86336a;
        if (r102 == null) goto L16;
        Context r103 = r102.getContext();
        if (r103 == null) goto L16;
        IBaseLiveActionHandler r104 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
        if (r104 == null) goto L16;
        r104.handle(r103, r100);
    L16:
        this.f86683s.getLogUseCase().v(this.f86677m);
        IGiftServiceExternal r105 = (IGiftServiceExternal) jc1.k.f(IGiftServiceExternal.class);
        if (r105 == null) goto L23;
        ca0.o r106 = r105.getRevenueEventCenter();
        if (r106 == null) goto L24;
        r106.c();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
        ViewGroup r101 = this.f86667c;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        TrapezoidConstraintLayout r102 = this.f86672h;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        TrapezoidConstraintLayout r103 = this.f86678n;
        if (r103 == null) goto L11;
        r103.setVisibility(8);
    L11:
        AppCompatTextView r104 = this.f86676l;
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        AppCompatTextView r105 = this.f86671g;
        if (r105 == null) goto L17;
        r105.setVisibility(8);
    L17:
        this.f86677m = false;
        ViewGroup r106 = this.f86667c;
        if (r106 == null) goto L20;
        r106.setBackground(null);
    L20:
        ViewGroup r107 = this.f86667c;
        if (r107 == null) goto L23;
        r107.setOnClickListener(null);
    L23:
        HSImageView r108 = this.f86668d;
        if (r108 == null) goto L26;
        int r109 = com.bytedance.android.live.profile.ui.util.m.f86955a;
        Intrinsics.checkNotNullParameter(r108, "$this$clear");
        com.bytedance.android.live.profile.ui.util.m.b(r108);
        a1.p(r108, -2);
        a1.k(r108, -2);
    L26:
        LinearLayout r110 = this.f86669e;
        if (r110 == null) goto L29;
        r110.removeAllViews();
    L29:
        LinearLayout r111 = this.f86670f;
        if (r111 == null) goto L32;
        r111.removeAllViews();
    L32:
        TrapezoidConstraintLayout r112 = this.f86672h;
        if (r112 == null) goto L35;
        r112.reset();
    L35:
        TrapezoidConstraintLayout r113 = this.f86672h;
        if (r113 == null) goto L38;
        r113.setOnClickListener(null);
    L38:
        TrapezoidConstraintLayout r114 = this.f86672h;
        if (r114 == null) goto L41;
        a1.p(r114, -1);
    L41:
        HSImageView r115 = this.f86673i;
        if (r115 == null) goto L44;
        int r116 = com.bytedance.android.live.profile.ui.util.m.f86955a;
        Intrinsics.checkNotNullParameter(r115, "$this$clear");
        com.bytedance.android.live.profile.ui.util.m.b(r115);
        a1.p(r115, -2);
        a1.k(r115, -2);
    L44:
        LinearLayout r117 = this.f86674j;
        if (r117 == null) goto L47;
        r117.removeAllViews();
    L47:
        LinearLayout r118 = this.f86675k;
        if (r118 == null) goto L50;
        r118.removeAllViews();
    L50:
        TrapezoidConstraintLayout r119 = this.f86678n;
        if (r119 == null) goto L53;
        r119.reset();
    L53:
        TrapezoidConstraintLayout r120 = this.f86678n;
        if (r120 == null) goto L56;
        r120.setOnClickListener(null);
    L56:
        TrapezoidConstraintLayout r121 = this.f86678n;
        if (r121 == null) goto L59;
        a1.p(r121, -1);
    L59:
        HSImageView r122 = this.f86679o;
        if (r122 == null) goto L62;
        int r123 = com.bytedance.android.live.profile.ui.util.m.f86955a;
        Intrinsics.checkNotNullParameter(r122, "$this$clear");
        com.bytedance.android.live.profile.ui.util.m.b(r122);
        a1.p(r122, -2);
        a1.k(r122, -2);
    L62:
        LinearLayout r124 = this.f86680p;
        if (r124 == null) goto L65;
        r124.removeAllViews();
    L65:
        LinearLayout r125 = this.f86681q;
        if (r125 == null) goto L68;
        r125.removeAllViews();
    L68:
        g(r100);
    }

    public static final void j(p r100, HonorWallElement r110) {
        boolean r101 = com.bytedance.android.live.profile.ui.base.i.l(r100.f86683s);
        boolean r102 = com.bytedance.android.live.profile.ui.base.i.m(r100.f86683s);
        com.bytedance.android.live.profile.ui.base.h r103 = r100.f86683s;
        Intrinsics.checkNotNullParameter(r103, "$this$selfIsGuest");
        Intrinsics.checkNotNullParameter(r103, "$this$selfUserId");
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        Map<String, String> r105 = null;
        if (r104 == null) goto L7;
        com.bytedance.android.livesdk.user.e r106 = r104.user();
        if (r106 == null) goto L7;
        String r107 = r106.n();
    L8:
        String r108 = String.valueOf(r107);
        Intrinsics.checkNotNullParameter(r103, "$this$isTargetGuest");
        Intrinsics.checkNotNullParameter(r108, "uid");
        boolean r109 = vt0.h.b(r108);
        boolean r111 = true;
        if (r101 == true) goto L14;
        if (r102 == false) goto L13;
        if (r109 == false) goto L14;
    L13:
        boolean r112 = false;
    L15:
        ALogger.i("ProfileFansClubVipComponent", "click type: " + r110.getId() + ", isTargetAnchor: " + r101 + ", isTargetSelf: " + r102 + ", isSelfGuest: " + r109 + ", showCurrentAnchorPage: " + r112);
        if (r110.getId() != HonorWallElement.TYPE_FANS_CLUB) goto L53;
        if (r112 == false) goto L53;
        int r113 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        if (rs0.l.f539064a.getValue().booleanValue() == false) goto L36;
        ExtraInfo r114 = r110.getExtraInfo();
        if (r114 == null) goto L23;
        String r115 = r114.getScheme();
    L24:
        if (r115 != null) goto L26;
    L29:
        boolean r116 = true;
    L30:
        if (r116 == true) goto L36;
        ExtraInfo r117 = r110.getExtraInfo();
        if (r117 == null) goto L34;
        String r118 = r117.getScheme();
    L35:
        r100.k(r118);
    L86:
        ExtraInfo r119 = r110.getExtraInfo();
        if (r119 == null) goto L89;
        r119.isDismissAfterClick();
    L89:
        ExtraInfo r120 = r110.getExtraInfo();
        if (r120 == null) goto L102;
        String r121 = r120.getClickEvent();
        if (r121 == null) goto L102;
        ExtraInfo r122 = r110.getExtraInfo();
        if (r122 == null) goto L97;
        Map<String, String> r123 = r122.getClickEventParams();
    L98:
        LinkedHashMap r124 = new LinkedHashMap();
        if (r123 == null) goto L101;
        r124.putAll(r123);
    L101:
        r100.f86683s.sendLog(r121, r124, new Object[0]);
        goto L102
    L97:
        r123 = null;
    L102:
        String r125 = r110.getName();
        if (r125 != null) goto L105;
        return;
    L105:
        if (rs0.y.f539090a.getValue().b() == false) goto L109;
        ExtraInfo r126 = r110.getExtraInfo();
        if (r126 == null) goto L109;
        r105 = r126.getClickEventParams();
    L109:
        r100.f86683s.recordBusinessClick(r125, r105);
        return;
    L34:
        r118 = null;
        goto L35
    L26:
        if (r115.length() == 0) goto L29;
        r116 = false;
        goto L30
    L23:
        r115 = null;
    L36:
        com.bytedance.android.live.profile.ui.base.d r127 = r100.f86336a;
        if (r127 == null) goto L39;
        Context r128 = r127.getContext();
    L40:
        FragmentActivity r129 = ContextUtil.contextToFragmentActivity(r128);
        if (r129 == null) goto L86;
        com.bytedance.android.live.profile.ui.base.h r130 = r100.f86683s;
        SubscribeInfo r131 = r130.getTargetUser().subscribeInfo;
        if (r131 == null) goto L45;
        boolean r132 = r131.isMember;
    L46:
        if (r132 == true) goto L48;
    L50:
        r111 = false;
    L51:
        r130.showFansClub(r129, "mini_card", r111);
        goto L86
    L48:
        if (com.bytedance.android.live.profile.ui.base.i.l(r100.f86683s) == true) goto L50;
    L45:
        r132 = false;
        goto L46
    L39:
        r128 = null;
    L53:
        if (r110.getId() != HonorWallElement.TYPE_SHOP_FANS_CLUB) goto L72;
        if (r112 == false) goto L72;
        com.bytedance.android.live.profile.ui.base.d r133 = r100.f86336a;
        if (r133 == null) goto L58;
        Context r134 = r133.getContext();
    L59:
        FragmentActivity r135 = ContextUtil.contextToFragmentActivity(r134);
        if (r135 == null) goto L86;
        com.bytedance.android.live.profile.ui.base.h r136 = r100.f86683s;
        SubscribeInfo r137 = r136.getTargetUser().subscribeInfo;
        if (r137 == null) goto L64;
        boolean r138 = r137.isMember;
    L65:
        if (r138 == true) goto L67;
    L69:
        r111 = false;
    L70:
        r136.showFansClub(r135, "mini_card", r111);
        goto L86
    L67:
        if (com.bytedance.android.live.profile.ui.base.i.l(r100.f86683s) == true) goto L69;
    L64:
        r138 = false;
        goto L65
    L58:
        r134 = null;
    L72:
        if (r110.getId() != HonorWallElement.TYPE_VIP) goto L81;
        if (r112 == false) goto L81;
        com.bytedance.android.live.profile.ui.base.d r139 = r100.f86336a;
        if (r139 == null) goto L77;
        Context r140 = r139.getContext();
    L78:
        FragmentActivity r141 = ContextUtil.contextToFragmentActivity(r140);
        if (r141 == null) goto L86;
        r100.f86683s.showSubscribePanel(r141, false);
        goto L86
    L77:
        r140 = null;
    L81:
        ExtraInfo r142 = r110.getExtraInfo();
        if (r142 == null) goto L84;
        String r143 = r142.getScheme();
    L85:
        r100.k(r143);
        goto L86
    L84:
        r143 = null;
    L14:
        r112 = true;
    L7:
        r107 = null;
        goto L8
    }
}
