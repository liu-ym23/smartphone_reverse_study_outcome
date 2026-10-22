package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.HonorWallUi;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.d;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.utils.u5;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import ut0.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00018\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020!8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/e;", "Lcom/bytedance/android/live/base/model/user/HonorWallUi$HonorWallBg;", "bgUi", "", "setBgUi", "", "getWallBgUiIndex", "Landroid/view/ViewGroup;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "rootView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "c", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", KtvSubElement.CONTAINER, "Lcom/bytedance/android/live/core/widget/HSImageView;", "d", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getImageIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "imageIcon", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "getArrowIcon", "()Landroid/widget/ImageView;", "arrowIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileHonourCardView extends FrameLayout implements e<st0.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f86807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f86808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f86809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f86810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f86811e;

    public ProfileHonourCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileHonourCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getWallBgUiIndex() {
        return 0;
    }

    public final ImageView getArrowIcon() {
        return this.f86811e;
    }

    public final FrameLayout getContainer() {
        return this.f86809c;
    }

    public final HSImageView getImageIcon() {
        return this.f86810d;
    }

    @Override // android.view.View
    public final ViewGroup getRootView() {
        return this.f86807a;
    }

    public final TextView getTitleView() {
        return this.f86808b;
    }

    private final void setBgUi(HonorWallUi.HonorWallBg r100) {
        if (r100 == null) goto L12;
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setGradientType(1);
        r101.setCornerRadius(UtilityKotlinExtentionsKt.h(4));
        r101.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r101.setGradientCenter(0.0f, 0.0f);
        int r102 = u5.f159182a;
        if (TextUtils.isEmpty(r100.gradientStart) == false) goto L6;
    L8:
        int r103 = d.f86940a;
        HSImageView r104 = this.f86810d;
        k r105 = r100.icon;
        if (r104 == null) goto L13;
        r104.post(new com.bytedance.android.live.profile.ui.util.c(r104, r105));
        return;
    L13:
        return;
    L6:
        if (TextUtils.isEmpty(r100.gradientEnd) == true) goto L8;
        r101.setColors(new int[]{ColorProtector.parseColor(r100.gradientStart), ColorProtector.parseColor(r100.gradientEnd)});
        this.f86807a.setBackground(r101);
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(st0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void b(st0.e r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        HonorWallUi r102 = r101.honorWallUi;
        if (r102 != null) goto L5;
    L7:
        ImageView r103 = this.f86811e;
        if (r100.f543541c == false) goto L10;
        int r104 = 0;
    L11:
        r103.setVisibility(r104);
        this.f86808b.setText(r100.f543540b);
        return;
    L10:
        r104 = 4;
        goto L11
    L5:
        if ((!r102.bgs.isEmpty()) == false) goto L7;
        setBgUi(r102.bgs.get(Integer.valueOf(getWallBgUiIndex())));
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void c(st0.e r100, NewProfileUser r101) {
        b(r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void d(st0.e r100, ProfileSkin r101) {
        f(r100, r101);
    }

    public void f(st0.e r100, ProfileSkin r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "skin");
        ProfileCustomSkin r102 = r101.skin;
        if (r102 == null) goto L8;
        ProfileCustomSkin.HonorWallUI r103 = r102.honorWallSkin;
        if (r103 == null) goto L9;
        String r104 = r103.titleColor;
        String r105 = r103.contentColor;
        int r106 = m.f86955a;
        m.e(this.f86808b, r104);
        m.e(this.f86811e, r104);
        m.e(this.f86809c, r105);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(st0.e r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        e.a.update(this, r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(st0.e r100, NewProfileUser r101) {
        update2(r100, r101);
    }

    public ProfileHonourCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_profile_v3_honour_card_layout, this, true);
        this.f86807a = (ViewGroup) findViewById(R.id.new_profile_honour_card_view);
        this.f86808b = (TextView) findViewById(R.id.new_profile_honour_card_title);
        this.f86809c = (FrameLayout) findViewById(R.id.new_profile_honour_card_content);
        this.f86810d = (HSImageView) findViewById(R.id.new_profile_honour_card_image);
        this.f86811e = (ImageView) findViewById(R.id.new_profile_honour_card_title_arrow);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(st0.e r100, NewProfileUser r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "logUseCase");
        e.a.a(r101, r102);
    }

    public /* synthetic */ ProfileHonourCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
