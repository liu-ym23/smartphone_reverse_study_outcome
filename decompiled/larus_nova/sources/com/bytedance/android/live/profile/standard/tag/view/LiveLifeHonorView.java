package com.bytedance.android.live.profile.standard.tag.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.LiveAnchorRankHonor;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import jt0.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lt0.b;
import py.k;
import st0.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profile/standard/tag/view/LiveLifeHonorView;", "Landroid/widget/FrameLayout;", "Ljt0/c;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/f;", "", "width", "", "setIconWidth", "Lcom/bytedance/android/live/base/model/user/ProfileTagContent;", "tagContent", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "Ljt0/b;", "tagItem", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeHonorView extends FrameLayout implements c, e<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f86283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f86284b;

    public static final class a {
    }

    static {
    }

    public LiveLifeHonorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeHonorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setIconWidth(int r100) {
        ViewGroup.LayoutParams r101 = this.f86284b.getLayoutParams();
        r101.width = r100;
        this.f86284b.setLayoutParams(r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public final void g(NewProfileUser r100) {
        LiveAnchorRankHonor r101 = r100.liveAnchorRankHonor;
        if (r101 == null) goto L36;
        LiveAnchorRankHonor.a r102 = r101.getLiveLifeHonorInfo();
        if (r102 == null) goto L37;
        String r103 = r102.lifeLiveHonorTestIconUrl;
        boolean r104 = false;
        if (r103 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L17;
        k r106 = (k) vh7.f.c(k.class);
        r106.setUrls(CollectionsKt.listOf(r103));
        ImageUtil.loadImage(this.f86284b, r106, new b(this));
    L17:
        String r107 = r102.lifeLiveHonorRank;
        String r108 = "";
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        String r109 = r102.lifeLiveHonorDate;
        if (r109 == null) goto L24;
        r108 = r109;
    L24:
        StringBuilder r110 = new StringBuilder(r107);
        if (r107.length() != 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == false) goto L30;
    L34:
        r110.append(r108);
        this.f86283a.setText(r110.toString());
        return;
    L30:
        if (r108.length() != 0) goto L32;
        r104 = true;
    L32:
        if (r104 == true) goto L34;
        r110.append("·");
        goto L34
    L27:
        r111 = false;
        goto L28
    L10:
        if (r103.length() == 0) goto L13;
        r105 = false;
        goto L14
    L37:
        return;
    }

    public static final /* synthetic */ void f(LiveLifeHonorView r100, int r101) {
        r100.setIconWidth(r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void c(f r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        g(r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(f r100, ProfileSkin r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "skin");
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(f r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        e.a.update(this, r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(f r100, NewProfileUser r101) {
        update2(r100, r101);
    }

    public LiveLifeHonorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_LIVE_HONOR_TAG, r100, LayoutInflater.from(r100), this, true);
    L6:
        this.f86283a = (TextView) findViewById(R.id.profile_tag_view_text);
        this.f86284b = (ImageView) findViewById(R.id.profile_tag_image_icon);
        return;
    L5:
        LayoutInflater.from(r100).inflate(R.layout.ttlive_profile_live_life_honor_layout, this, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(f r100, NewProfileUser r101, ut0.f r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "logUseCase");
        e.a.a(r101, r102);
    }

    public /* synthetic */ LiveLifeHonorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // jt0.c
    public final void b(ProfileTagContent r100, NewProfileUser r101, h r102, jt0.b r103) {
        Intrinsics.checkNotNullParameter(r100, "tagContent");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "profileContext");
        Intrinsics.checkNotNullParameter(r103, "tagItem");
        g(r101);
    }

    @Override // jt0.c
    public void update(ProfileTagContent r100, NewProfileUser r101, h r102, jt0.b r103) {
        Intrinsics.checkNotNullParameter(r100, "tagContent");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "profileContext");
        Intrinsics.checkNotNullParameter(r103, "tagItem");
        g(r101);
    }
}
