package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.GiftExhibitionHomeStats;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.android.live.profile.ui.util.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import st0.e;
import tt0.c;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileGiftExhibitionCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileGiftExhibitionCardView extends ProfileHonourCardView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f86900f;

    public ProfileGiftExhibitionCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileGiftExhibitionCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 3;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        super.b(r100, r101);
        GiftExhibitionHomeStats r102 = r101.giftExhibitionInfo;
        if (r102 == null) goto L19;
        c r103 = new c(getContainer());
        Intrinsics.checkNotNullParameter(r102, "exhibitionInfo");
        int r104 = r102.lightedNum;
        int r105 = r102.unlightedNum + r104;
        int r106 = m.f86955a;
        m.a(r103.f547512a);
        m.a(r103.f547514c);
        TextView r107 = r103.f547512a;
        if (r107 == null) goto L7;
        r107.setText(String.valueOf(r104));
    L7:
        TextView r108 = r103.f547514c;
        if (r108 == null) goto L10;
        r108.setText(String.valueOf(r105));
    L10:
        ImageView r109 = r103.f547515d;
        if (r109 == null) goto L17;
        if (r104 != r105) goto L15;
        if (r104 == 0) goto L15;
        int r110 = 0;
    L16:
        r109.setVisibility(r110);
    L15:
        r110 = 4;
    L17:
        this.f86900f = r103;
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(e r100, NewProfileUser r101) {
        b(r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void d(e r100, ProfileSkin r101) {
        f(r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void f(e r100, ProfileSkin r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "skin");
        ProfileCustomSkin r102 = r101.skin;
        if (r102 == null) goto L10;
        ProfileCustomSkin.HonorWallUI r103 = r102.honorWallSkin;
        if (r103 == null) goto L11;
        String r104 = r103.titleColor;
        int r105 = m.f86955a;
        m.e(getTitleView(), r104);
        m.e(getArrowIcon(), r104);
        c r106 = this.f86900f;
        if (r106 == null) goto L12;
        String r107 = r103.contentColor;
        m.e(r106.f547512a, r107);
        m.e(r106.f547513b, r107);
        m.e(r106.f547514c, r107);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ProfileGiftExhibitionCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ProfileGiftExhibitionCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
