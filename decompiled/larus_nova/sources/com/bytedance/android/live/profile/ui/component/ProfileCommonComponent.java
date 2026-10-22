package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileBadgeSuffix;
import com.bytedance.android.live.base.model.user.ProfileBasicArea;
import com.bytedance.android.live.base.model.user.ProfileConstant$ProfileType;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.base.model.user.ShopEntrance;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.view.ProfileBadgeSuffixView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfileCommonComponent implements com.bytedance.android.live.profile.ui.base.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f86357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f86358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f86359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f86360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f86361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f86362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f86363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f86364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.l f86365i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
    }

    public final ViewGroup c() {
        return (ViewGroup) this.f86361e.getValue();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public final ConstraintLayout h() {
        return (ConstraintLayout) this.f86360d.getValue();
    }

    public final TextView i() {
        return (TextView) this.f86359c.getValue();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.CommonComponent.INSTANCE;
    }

    public ProfileCommonComponent(com.bytedance.android.live.profile.ui.base.l r100) {
        Intrinsics.checkNotNullParameter(r100, "hostBehavior");
        this.f86365i = r100;
        this.f86357a = r100.getHostFragment();
        this.f86358b = LazyKt.lazy(new ProfileCommonComponent$mAvatarView$2(this));
        this.f86359c = LazyKt.lazy(new ProfileCommonComponent$mUserName$2(this));
        this.f86360d = LazyKt.lazy(new ProfileCommonComponent$mShopEntrance$2(this));
        this.f86361e = LazyKt.lazy(new ProfileCommonComponent$badgeScrollContainer$2(this));
        this.f86362f = LazyKt.lazy(new ProfileCommonComponent$badgeInnerContainer$2(this));
        this.f86364h = new ArrayList();
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        int r101 = this.f86363g;
        if (r101 == 0) goto L5;
        this.f86365i.a().showShopEntrance(r101, "live_personal_card");
    L5:
        Iterator r102 = ((ArrayList) this.f86364h).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();
        this.f86365i.b().recordBusinessShow(TrackArea.BasicAreaArea, r103);
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r100) {
        if ((r100 instanceof ProfileSkin) == false) goto L17;
        ProfileCustomSkin r101 = r100.skin;
        if (r101 == null) goto L18;
        ProfileCustomSkin.GradientColor r102 = r101.nickNameColor;
        if (r102 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r102.from) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r102.f58938to) == true) goto L22;
        TextView r103 = i();
        if (r103 == null) goto L21;
        r103.post(new g(r102, this));
        return;
    L21:
        return;
    L22:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r210) {
        Intrinsics.checkNotNullParameter(r210, "user");
        if (r210.isVcdContentAuthorized() == true) goto L8;
        TextView r100 = i();
        if (r100 == null) goto L223;
        r100.setText(s1.B(R.string.ttlive_new_profile_no_authorized_user_name));
        return;
    L223:
        return;
    L8:
        TextView r101 = i();
        String r102 = "";
        if (r101 == null) goto L15;
        String r103 = r210.getDisplayName();
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r101.setText(r103);
    L15:
        TextView r104 = i();
        String r105 = r210.getDisplayName();
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        boolean r106 = true;
        r3.c(r104, r105, true);
        TextView r107 = i();
        if (r107 == null) goto L21;
        r107.setOnClickListener(new f(this));
    L21:
        ((ArrayList) this.f86364h).add(ITwitterService.ResponseConstants.USER_NAME);
        BaseProfileInfo r108 = r210.baseProfileInfo;
        if (r108 == null) goto L26;
        py.k r109 = r108.avatarThumb;
        if (r109 == null) goto L26;
        ImageLoader.bindImage((HSImageView) this.f86358b.getValue(), r109, UtilityKotlinExtentionsKt.i(72), UtilityKotlinExtentionsKt.i(72));
    L26:
        HSImageView r110 = (HSImageView) this.f86358b.getValue();
        if (r110 == null) goto L29;
        r110.setOnClickListener(new c(this));
    L29:
        HSImageView r111 = (HSImageView) this.f86358b.getValue();
        if (r111 == null) goto L32;
        r111.setImportantForAccessibility(1);
    L32:
        HSImageView r112 = (HSImageView) this.f86358b.getValue();
        Object[] r113 = new Object[1];
        String r114 = r210.getDisplayName();
        if (r114 == null) goto L36;
        r102 = r114;
    L36:
        int r115 = 0;
        r113[0] = r102;
        r3.c(r112, s1.C(R.string.ttlive_profile_avatar_talkback_suffix, r113), true);
        ((ArrayList) this.f86364h).add("avatar");
        ShopEntrance r116 = r210.shopEntrance;
        if (r116 == null) goto L39;
        int r117 = r116.entranceType;
    L41:
        if (r117 == 0) goto L100;
        ProfileStyleParams r118 = r210.getProfileStyleParams();
        if (r118 != null) goto L46;
    L47:
        ProfileStyleParams r119 = r210.getProfileStyleParams();
        if (r119 != null) goto L50;
    L52:
        ConstraintLayout r120 = h();
        if (r120 == null) goto L100;
        TextView r121 = (TextView) r120.findViewById(R.id.live_user_card_commerce_entrance_text);
        if (r117 != 1) goto L57;
        String r122 = s1.B(R.string.ttlive_live_user_card_commerce_entrance_shop_text);
    L58:
        r121.setText(r122);
        r120.setVisibility(0);
        this.f86363g = r117;
        r120.setOnClickListener(new e(this, r117));
        ProfileSkin r123 = r210.mProfileSkin;
        if (r123 == null) goto L99;
        ProfileCustomSkin r124 = r123.skin;
        if (r124 == null) goto L99;
        if (r124.honorWallSkin == null) goto L99;
        int r125 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        if (b0.f539045a.getValue().g() == false) goto L99;
        Drawable r126 = s1.m(R.drawable.ttlive_bg_live_user_card_commerce_entrance_normal);     // Catch: Exception -> L97
        if ((r126 instanceof GradientDrawable) == true) goto L72;
        r126 = null;
    L72:
        GradientDrawable r127 = (GradientDrawable) r126;     // Catch: Exception -> L97
        if (r127 == null) goto L77;
        r127.mutate();     // Catch: Exception -> L97
        r127.setColor(Color.parseColor("#26FFFFFF"));     // Catch: Exception -> L97
        ConstraintLayout r128 = h();     // Catch: Exception -> L97
        if (r128 == null) goto L77;
        r128.setBackground(r127);     // Catch: Exception -> L97
    L77:
        int r129 = Color.parseColor("#E6FFFFFF");     // Catch: Exception -> L97
        ConstraintLayout r130 = h();     // Catch: Exception -> L97
        if (r130 == null) goto L84;
        ImageView r131 = (ImageView) r130.findViewById(R.id.live_user_card_commerce_entrance_image);     // Catch: Exception -> L97
        if (r131 == null) goto L84;
        Drawable r132 = r131.getBackground();     // Catch: Exception -> L97
        if (r132 == null) goto L84;
        r132.mutate();     // Catch: Exception -> L97
        r132.setColorFilter(r129, PorterDuff.Mode.SRC_ATOP);     // Catch: Exception -> L97
    L84:
        ConstraintLayout r133 = h();     // Catch: Exception -> L97
        if (r133 == null) goto L89;
        TextView r134 = (TextView) r133.findViewById(R.id.live_user_card_commerce_entrance_text);     // Catch: Exception -> L97
        if (r134 == null) goto L89;
        r134.setTextColor(r129);     // Catch: Exception -> L97
        r134.setAlpha(1.0f);     // Catch: Exception -> L97
    L89:
        ConstraintLayout r135 = h();     // Catch: Exception -> L97
        if (r135 == null) goto L99;
        ImageView r136 = (ImageView) r135.findViewById(R.id.live_user_card_commerce_entrance_arrow);     // Catch: Exception -> L97
        if (r136 == null) goto L99;
        Drawable r137 = r136.getBackground();     // Catch: Exception -> L97
        if (r137 == null) goto L99;
        r137.mutate();     // Catch: Exception -> L97
        r137.setColorFilter(r129, PorterDuff.Mode.SRC_ATOP);     // Catch: Exception -> L97
    L97:
        e = move-exception;
        ALogger.e(NewProfileInfoViewModel.TAG, "loadShopEntranceSkin error: " + e.getMessage());
    L99:
        ((ArrayList) this.f86364h).add("small_shop_entrance");
        goto L100
    L57:
        r122 = s1.B(R.string.ttlive_live_user_card_commerce_entrance_window_text);
        goto L58
    L50:
        if (((int) r119.getProfileStyle()) != ProfileConstant$ProfileType.SHOP.getType()) goto L52;
    L46:
        if (((int) r118.getProfileStyle()) != ProfileConstant$ProfileType.WINDOW.getType()) goto L47;
    L100:
        ViewGroup r138 = c();
        int r139 = 6;
        if (r138 == null) goto L175;
        Context r140 = r138.getContext();
        if (r140 == null) goto L175;
        ViewGroup r141 = (ViewGroup) this.f86362f.getValue();
        if (r141 == null) goto L108;
        r141.removeAllViews();
    L108:
        ProfileBasicArea r142 = r210.basicArea;
        if (r142 == null) goto L172;
        List<py.k> r143 = r142.badgeList;
        if (r143 == null) goto L172;
        if ((!r143.isEmpty()) == true) goto L116;
        r143 = null;
    L116:
        if (r143 == null) goto L172;
        ViewGroup r144 = c();
        if (r144 == null) goto L120;
        r144.setVisibility(0);
    L120:
        py.k r145 = (py.k) CollectionsKt.firstOrNull(r143);
        if (r145 == null) goto L125;
        Intrinsics.checkNotNullParameter(r145, "$this$heightKt");
        int r146 = r145.getHeight();
        ViewGroup r147 = c();
        if (r147 == null) goto L125;
        a1.k(r147, UtilityKotlinExtentionsKt.i(r146) + UtilityKotlinExtentionsKt.i(4));
    L125:
        ProfileBasicArea r148 = r210.basicArea;
        if (r148 == null) goto L129;
        Map<Integer, ProfileBadgeSuffix> r149 = r148.badgeSuffixMap;
        if (r149 == null) goto L129;
    L130:
        List<py.k> r150 = r143;
        Iterator<T> r151 = r150.iterator();
    L132:
        if (r151.hasNext() == false) goto L145;
        py.k r152 = (py.k) r151.next();
        Context r153 = this.f86365i.getHostFragment().getContext();
        if (r153 != null) goto L136;
        r153 = r140;
    L136:
        ProfileBadgeSuffixView r154 = new ProfileBadgeSuffixView(r153, null, r139, r115);
        ProfileBadgeSuffix r155 = r149.get(r152.getImageType());
        Intrinsics.checkNotNullParameter(r152, IAllianceService.CONTENT_TYPE_BADGE);
        ImageLoader.bindImage(r154.f86800b, r152, null, -1, -1, null, new com.bytedance.android.live.profile.ui.component.view.a(r154, r152, r155), true);
        if (com.bytedance.android.live.profile.ui.base.i.m(this.f86365i.b()) == true) goto L139;
    L141:
        ViewGroup r156 = (ViewGroup) this.f86362f.getValue();
        if (r156 == null) goto L144;
        r156.addView(r154);
    L144:
        r139 = 6;
        r115 = 0;
        goto L132
    L139:
        if (r2.a(r152.getSchema()) == false) goto L141;
        r154.setOnClickListener(new d(r152, r149, this, r140));
        goto L141
    L145:
        boolean r157 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).convertHonorImageModel((py.k) CollectionsKt.firstOrNull(r143));
        StringBuilder r158 = new StringBuilder();
        Iterator<T> r159 = r150.iterator();
        int r160 = 0;
    L147:
        if (r159.hasNext() == false) goto L160;
        Object r161 = r159.next();
        int r162 = r160 + 1;
        if (r160 >= 0) goto L151;
        CollectionsKt.throwIndexOverflow();
    L151:
        py.k.b r163 = ((py.k) r161).getImageContent();
        if (r163 == null) goto L159;
        String r164 = r163.getAccessibilityText();
        if (r164 == null) goto L159;
        if (r160 <= 0) goto L158;
        r158.append(", ");
    L158:
        r158.append(r164);
    L159:
        r160 = r162;
        goto L147
    L160:
        String r165 = r158.toString();
        if (com.bytedance.android.live.profile.ui.base.i.m(this.f86365i.b()) == false) goto L167;
        ViewGroup r166 = c();
        if (r166 == null) goto L166;
        ViewCompat.setAccessibilityDelegate(r166, null);
    L166:
        r3.c(c(), r165, true);
        goto L175
    L167:
        ViewGroup r167 = c();
        if (r167 == null) goto L171;
        ViewCompat.setAccessibilityDelegate(r167, null);
    L171:
        r3.b(c(), r165, TextView.class);
    L129:
        r149 = MapsKt.emptyMap();
    L172:
        ViewGroup r168 = c();
        if (r168 == null) goto L175;
        UtilityKotlinExtentionsKt.t(r168);
    L175:
        TextView r169 = i();
        if (r169 == null) goto L178;
        a1.n(r169, UtilityKotlinExtentionsKt.i(16));
    L178:
        ViewGroup r170 = c();
        if (r170 == null) goto L181;
        a1.m(r170, UtilityKotlinExtentionsKt.i(6));
    L181:
        ViewGroup r171 = c();
        if (r171 == null) goto L184;
        a1.n(r171, UtilityKotlinExtentionsKt.i(10));
    L184:
        ConstraintLayout r172 = h();
        if (r172 == null) goto L187;
        a1.n(r172, UtilityKotlinExtentionsKt.i(16));
    L187:
        ViewGroup r173 = c();
        if (r173 != null) goto L190;
    L192:
        boolean r174 = false;
    L193:
        ConstraintLayout r175 = h();
        if (r175 != null) goto L196;
    L198:
        r106 = false;
    L199:
        if (r174 == false) goto L205;
        if (r106 == false) goto L205;
        TextView r176 = i();
        if (r176 == null) goto L224;
        a1.n(r176, 0);
        return;
    L224:
        return;
    L205:
        if (r174 == false) goto L226;
        if (r106 == true) goto L227;
        TextView r177 = i();
        if (r177 == null) goto L210;
        a1.n(r177, 0);
    L210:
        ViewGroup r178 = c();
        if (r178 == null) goto L228;
        a1.n(r178, UtilityKotlinExtentionsKt.i(16));
        return;
    L228:
        return;
    L227:
        return;
    L226:
        return;
    L196:
        if (r175.getVisibility() != 0) goto L198;
    L190:
        if (r173.getVisibility() != 0) goto L192;
        r174 = true;
        goto L193
    L39:
        r117 = 0;
        goto L41
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileCommonComponent update");
        ConstraintLayout r101 = h();
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        ViewGroup r102 = c();
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ViewGroup r103 = (ViewGroup) this.f86362f.getValue();
        if (r103 == null) goto L11;
        r103.removeAllViews();
    L11:
        ViewGroup r104 = c();
        if (r104 == null) goto L14;
        r104.setClickable(false);
    L14:
        this.f86363g = 0;
        ((ArrayList) this.f86364h).clear();
        TextView r105 = i();
        if (r105 == null) goto L17;
        r105.post(new h(this));
    L17:
        g(r100);
        e(r100.mProfileSkin);
    }

    public static final void a(ProfileCommonComponent r100, TextView r101, int r110, int r111) {
        r100.getClass();
        if (r101 == null) goto L6;
        r101.getPaint().setShader(new LinearGradient(0.0f, r101.getHeight(), 0.0f, 0.0f, r110, r111, Shader.TileMode.CLAMP));
        r101.invalidate();
        return;
    }
}
