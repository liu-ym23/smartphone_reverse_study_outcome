package com.bytedance.android.live.profile.standard.honour.items;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/profile/standard/honour/items/StandardHonourCardView;", "Lbt0/e;", "Landroid/widget/FrameLayout;", "Lbt0/a;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/live/base/model/user/HonorWallElement;", "elementInfo", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "profileUser", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "", "update", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/profile/ui/base/h;", "getProfileContext", "()Lcom/bytedance/android/live/profile/ui/base/h;", "setProfileContext", "(Lcom/bytedance/android/live/profile/ui/base/h;)V", "Lbt0/b;", ce.f26391f, "Lbt0/b;", "getTitleViewHolder", "()Lbt0/b;", "setTitleViewHolder", "(Lbt0/b;)V", "titleViewHolder", "h", "getBusinessViewHolder", "setBusinessViewHolder", "businessViewHolder", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StandardHonourCardView extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f86235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f86236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f86237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveViewStub f86238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveViewStub f86239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f86240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f86241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f86242h;

    public static final class a {
    }

    static {
    }

    public StandardHonourCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StandardHonourCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // bt0.c
    public final void f() {
        this.f86241g.f();
        this.f86242h.f();
    }

    @Override // bt0.c
    public final void g() {
        this.f86241g.g();
        this.f86242h.g();
    }

    @Override // bt0.c
    public final void onViewShow() {
        this.f86241g.onViewShow();
        this.f86242h.onViewShow();
    }

    @Override // bt0.c
    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_profile_standard_honour_card_view, this, true);
        this.f86236b = (ViewGroup) findViewById(R.id.new_profile_standard_honour_card_view);
        this.f86237c = (HSImageView) findViewById(R.id.new_profile_honour_card_image);
        this.f86238d = (LiveViewStub) findViewById(R.id.standard_honour_card_title_container);
        this.f86239e = (LiveViewStub) findViewById(R.id.standard_honour_card_business_container);
        this.f86240f = findViewById(R.id.standard_honour_card_talkback_suffix);
        LiveViewStub r100 = this.f86238d;
        if (r100 == null) goto L5;
        this.f86241g.p(r100);
    L5:
        LiveViewStub r101 = this.f86239e;
        if (r101 == null) goto L9;
        this.f86242h.p(r101);
        return;
    }

    public final b getBusinessViewHolder() {
        return this.f86242h;
    }

    public h getProfileContext() {
        return this.f86235a;
    }

    public final b getTitleViewHolder() {
        return this.f86241g;
    }

    public final void r(HonorWallElement r100) {
        HonorWallContent r101 = r100.getHonorWallContent();
        if (r101 == null) goto L35;
        HonorWallBg r102 = r101.getHonorWallBg();
        if (r102 == null) goto L36;
        GradientDrawable r103 = new GradientDrawable();
        int r104 = 0;
        r103.setShape(0);
        r103.setGradientType(1);
        r103.setCornerRadius(UtilityKotlinExtentionsKt.h(4));
        r103.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r103.setGradientCenter(0.0f, 0.0f);
    L16:
        e = move-exception;
        ALogger.e("StandardHonourCardView", "parse background error: " + e.getMessage());
        SafetyGuard.a(null, e, null);
    L18:
        HSImageView r105 = this.f86237c;
        if (r105 == null) goto L25;
        k r106 = r102.getIcon();
        if (r106 == null) goto L23;
        int r107 = UtilityKotlinExtentionsKt.i(r106.getWidth());
    L24:
        a1.p(r105, r107);
        goto L25
    L23:
        r107 = 0;
    L25:
        HSImageView r108 = this.f86237c;
        if (r108 == null) goto L31;
        k r109 = r102.getIcon();
        if (r109 == null) goto L30;
        r104 = UtilityKotlinExtentionsKt.i(r109.getHeight());
    L30:
        a1.k(r108, r104);
    L31:
        ImageLoader.bindImage(this.f86237c, r102.getIcon());
        return;
    L9:
        if (TextUtils.isEmpty(r102.getColorStart()) == true) goto L18;
        if (TextUtils.isEmpty(r102.getColorEnd()) == true) goto L18;
        r103.setColors(new int[]{Color.parseColor(r102.getColorStart()), Color.parseColor(r102.getColorEnd())});     // Catch: Exception -> L16
        ViewGroup r110 = this.f86236b;     // Catch: Exception -> L16
        if (r110 == null) goto L18;
        r110.setBackground(r103);     // Catch: Exception -> L16
        goto L18
    L36:
        return;
    }

    public final void setBusinessViewHolder(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f86242h = r100;
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public void setProfileContext(h r100) {
        this.f86235a = r100;
    }

    public final void setTitleViewHolder(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f86241g = r100;
    }

    @Override // bt0.e
    public final void q(b r100, b r101) {
        if (r100 == null) goto L4;
        this.f86241g = r100;
    L4:
        if (r101 == null) goto L7;
        this.f86242h = r101;
        return;
    }

    public StandardHonourCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f86241g = new ct0.b();
        this.f86242h = new ct0.b();
    }

    public /* synthetic */ StandardHonourCardView(Context r100, AttributeSet r101, int r102, int r103) {
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
        if (r100.n(r101, r102, r103) == false) goto L7;
        View r104 = this.f86240f;
        if (r104 == null) goto L10;
        r104.setVisibility(0);
    L10:
        r(r101);
        b r105 = this.f86241g;
        HonorWallContent r106 = r101.getHonorWallContent();
        ProfileText r107 = null;
        if (r106 == null) goto L13;
        ProfileText r108 = r106.getHonorWallTopDisplay();
    L14:
        r105.h(r108, r101, r102, r103);
        b r109 = this.f86242h;
        HonorWallContent r110 = r101.getHonorWallContent();
        if (r110 == null) goto L17;
        r107 = r110.getHonorWallBottomDisplay();
    L17:
        r109.h(r107, r101, r102, r103);
        return;
    L13:
        r108 = null;
        goto L14
    L7:
        View r111 = this.f86240f;
        if (r111 == null) goto L10;
        r111.setVisibility(8);
        goto L10
    }

    @Override // bt0.e, bt0.c
    public void update(bt0.a r100, HonorWallElement r101, NewProfileUser r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "elementInfo");
        Intrinsics.checkNotNullParameter(r102, "profileUser");
        Intrinsics.checkNotNullParameter(r103, "profileContext");
        if (r100.n(r101, r102, r103) == false) goto L7;
        View r104 = this.f86240f;
        if (r104 == null) goto L10;
        r104.setVisibility(0);
    L10:
        ViewGroup r105 = this.f86236b;
        if (r105 == null) goto L13;
        r105.setBackgroundResource(R.drawable.ttlive_profile_v3_honour_card_bg);
    L13:
        HSImageView r106 = this.f86237c;
        if (r106 == null) goto L16;
        a1.p(r106, -2);
    L16:
        HSImageView r107 = this.f86237c;
        if (r107 == null) goto L19;
        a1.k(r107, -2);
    L19:
        HSImageView r108 = this.f86237c;
        if (r108 == null) goto L22;
        m.b(r108);
    L22:
        r(r101);
        b r109 = this.f86241g;
        HonorWallContent r110 = r101.getHonorWallContent();
        ProfileText r111 = null;
        if (r110 == null) goto L25;
        ProfileText r112 = r110.getHonorWallTopDisplay();
    L26:
        r109.update(r112, r101, r102, r103);
        b r113 = this.f86242h;
        HonorWallContent r114 = r101.getHonorWallContent();
        if (r114 == null) goto L29;
        r111 = r114.getHonorWallBottomDisplay();
    L29:
        r113.update(r111, r101, r102, r103);
        return;
    L25:
        r112 = null;
        goto L26
    L7:
        View r115 = this.f86240f;
        if (r115 == null) goto L10;
        r115.setVisibility(8);
        goto L10
    }
}
