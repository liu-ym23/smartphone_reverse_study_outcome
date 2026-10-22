package com.bytedance.android.live.profile.standard.honour.items.standardv3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bt0.b;
import bt0.e;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.HonorWallBg;
import com.bytedance.android.live.base.model.user.HonorWallContent;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/standardv3/StandardHonourCardViewV3;", "Lbt0/e;", "Landroid/widget/FrameLayout;", "Lbt0/a;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/live/base/model/user/HonorWallElement;", "elementInfo", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "profileUser", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "", "update", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/profile/ui/base/h;", "getProfileContext", "()Lcom/bytedance/android/live/profile/ui/base/h;", "setProfileContext", "(Lcom/bytedance/android/live/profile/ui/base/h;)V", "Lbt0/b;", "f", "Lbt0/b;", "getTitleViewHolder", "()Lbt0/b;", "setTitleViewHolder", "(Lbt0/b;)V", "titleViewHolder", ce.f26391f, "getBusinessViewHolder", "setBusinessViewHolder", "businessViewHolder", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StandardHonourCardViewV3 extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f86248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f86249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f86250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveViewStub f86251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveViewStub f86252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f86253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f86254g;

    public static final class a {
    }

    static {
    }

    public StandardHonourCardViewV3(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StandardHonourCardViewV3(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // bt0.c
    public final void f() {
        this.f86253f.f();
        this.f86254g.f();
    }

    @Override // bt0.c
    public final void g() {
        this.f86253f.g();
        this.f86254g.g();
    }

    @Override // bt0.c
    public final void onViewShow() {
        this.f86253f.onViewShow();
        this.f86254g.onViewShow();
    }

    @Override // bt0.c
    public final void c() {
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_HONOUR_CARD_NEW, getContext(), LayoutInflater.from(getContext()), this, true);
    L6:
        this.f86249b = (ViewGroup) findViewById(R.id.new_profile_standard_honour_card_view);
        this.f86250c = (HSImageView) findViewById(R.id.new_profile_honour_card_image);
        this.f86251d = (LiveViewStub) findViewById(R.id.standard_honour_card_title_container);
        this.f86252e = (LiveViewStub) findViewById(R.id.standard_honour_card_business_container);
        LiveViewStub r100 = this.f86251d;
        if (r100 == null) goto L9;
        this.f86253f.p(r100);
    L9:
        LiveViewStub r101 = this.f86252e;
        if (r101 == null) goto L13;
        this.f86254g.p(r101);
        return;
    L13:
        return;
    L5:
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_profile_standard_honour_card_view_v3, this, true);
        goto L6
    }

    public final b getBusinessViewHolder() {
        return this.f86254g;
    }

    public h getProfileContext() {
        return this.f86248a;
    }

    public final b getTitleViewHolder() {
        return this.f86253f;
    }

    public final void r(HonorWallElement r100) {
        HonorWallContent r101 = r100.getHonorWallContent();
        if (r101 == null) goto L71;
        HonorWallBg r102 = r101.getHonorWallBg();
        if (r102 == null) goto L72;
        GradientDrawable r103 = new GradientDrawable();
        int r104 = 0;
        r103.setShape(0);
        boolean r105 = true;
        r103.setGradientType(1);
        r103.setCornerRadius(UtilityKotlinExtentionsKt.h(8));
        r103.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r103.setGradientCenter(0.0f, 0.0f);
        String r106 = r102.getColorStart();
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L29;
        String r108 = r102.getColorEnd();
        if (r108 != null) goto L19;
    L22:
        boolean r109 = true;
    L23:
        if (r109 == true) goto L29;
        r103.setColors(new int[]{Color.parseColor(r102.getColorStart()), Color.parseColor(r102.getColorEnd())});     // Catch: Exception -> L27
    L27:
        e = move-exception;
        ALogger.e("StandardHonourCardViewV3", "parse background color error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L29
    L19:
        if (r108.length() == 0) goto L22;
        r109 = false;
    L29:
        String r110 = r102.getBorderColor();
        if (r110 != null) goto L32;
    L35:
        if (r105 == false) goto L69;
    L41:
        ViewGroup r111 = this.f86249b;
        if (r111 == null) goto L44;
        r111.setBackground(r103);
    L44:
        HSImageView r112 = this.f86250c;
        if (r112 == null) goto L51;
        k r113 = r102.getIcon();
        if (r113 == null) goto L49;
        int r114 = UtilityKotlinExtentionsKt.i(r113.getWidth());
    L50:
        a1.p(r112, r114);
        goto L51
    L49:
        r114 = 0;
    L51:
        HSImageView r115 = this.f86250c;
        if (r115 == null) goto L58;
        k r116 = r102.getIcon();
        if (r116 == null) goto L56;
        int r117 = UtilityKotlinExtentionsKt.i(r116.getHeight());
    L57:
        a1.k(r115, r117);
        goto L58
    L56:
        r117 = 0;
    L58:
        HSImageView r118 = this.f86250c;
        k r119 = r102.getIcon();
        k r120 = r102.getIcon();
        if (r120 == null) goto L61;
        int r121 = UtilityKotlinExtentionsKt.i(r120.getWidth());
    L62:
        k r122 = r102.getIcon();
        if (r122 == null) goto L65;
        r104 = UtilityKotlinExtentionsKt.i(r122.getHeight());
    L65:
        ImageLoader.bindImage(r118, r119, r121, r104);
        return;
    L61:
        r121 = 0;
        goto L62
    L69:
        r103.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r102.getBorderColor()));     // Catch: Exception -> L39
    L39:
        e = move-exception;
        ALogger.e("StandardHonourCardViewV3", "parse background border error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
        goto L41
    L32:
        if (r110.length() == 0) goto L35;
        r105 = false;
        goto L35
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
        goto L15
    L72:
        return;
    }

    public final void setBusinessViewHolder(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f86254g = r100;
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public void setProfileContext(h r100) {
        this.f86248a = r100;
    }

    public final void setTitleViewHolder(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f86253f = r100;
    }

    @Override // bt0.e
    public final void q(b r100, b r101) {
        if (r100 == null) goto L4;
        this.f86253f = r100;
    L4:
        if (r101 == null) goto L7;
        this.f86254g = r101;
        return;
    }

    public StandardHonourCardViewV3(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f86253f = new ct0.b();
        this.f86254g = new ct0.b();
    }

    public /* synthetic */ StandardHonourCardViewV3(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // bt0.c
    public final void l(bt0.a r100, HonorWallElement r101, NewProfileUser r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "elementInfo");
        Intrinsics.checkNotNullParameter(r102, "profileUser");
        Intrinsics.checkNotNullParameter(r103, "profileContext");
        r(r101);
        b r104 = this.f86253f;
        HonorWallContent r105 = r101.getHonorWallContent();
        ProfileText r106 = null;
        if (r105 == null) goto L5;
        ProfileText r107 = r105.getHonorWallTopDisplay();
    L6:
        r104.h(r107, r101, r102, r103);
        b r108 = this.f86254g;
        HonorWallContent r109 = r101.getHonorWallContent();
        if (r109 == null) goto L9;
        r106 = r109.getHonorWallBottomDisplay();
    L9:
        r108.h(r106, r101, r102, r103);
        return;
    L5:
        r107 = null;
        goto L6
    }

    @Override // bt0.e, bt0.c
    public void update(bt0.a r100, HonorWallElement r101, NewProfileUser r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "elementInfo");
        Intrinsics.checkNotNullParameter(r102, "profileUser");
        Intrinsics.checkNotNullParameter(r103, "profileContext");
        ViewGroup r104 = this.f86249b;
        if (r104 == null) goto L5;
        r104.setBackgroundResource(R.drawable.ttlive_profile_v3_honour_card_bg_v3);
    L5:
        HSImageView r105 = this.f86250c;
        if (r105 == null) goto L8;
        a1.p(r105, -2);
    L8:
        HSImageView r106 = this.f86250c;
        if (r106 == null) goto L11;
        a1.k(r106, -2);
    L11:
        HSImageView r107 = this.f86250c;
        if (r107 == null) goto L14;
        m.b(r107);
    L14:
        r(r101);
        b r108 = this.f86253f;
        HonorWallContent r109 = r101.getHonorWallContent();
        ProfileText r110 = null;
        if (r109 == null) goto L17;
        ProfileText r111 = r109.getHonorWallTopDisplay();
    L18:
        r108.update(r111, r101, r102, r103);
        b r112 = this.f86254g;
        HonorWallContent r113 = r101.getHonorWallContent();
        if (r113 == null) goto L21;
        r110 = r113.getHonorWallBottomDisplay();
    L21:
        r112.update(r110, r101, r102, r103);
        return;
    L17:
        r111 = null;
        goto L18
    }
}
