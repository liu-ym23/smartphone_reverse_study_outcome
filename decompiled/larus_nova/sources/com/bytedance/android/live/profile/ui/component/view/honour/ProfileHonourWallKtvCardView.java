package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileHighScoreSong;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.android.live.profile.ui.util.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import st0.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileHonourWallKtvCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/view/View;", "f", "Landroid/view/View;", "getTextLayout", "()Landroid/view/View;", "setTextLayout", "(Landroid/view/View;)V", "textLayout", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileHonourWallKtvCardView extends ProfileHonourCardView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f86906f;

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 8;
    }

    public final View getTextLayout() {
        return this.f86906f;
    }

    public final void setTextLayout(View r100) {
        this.f86906f = r100;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        super.b(r100, r101);
        View r102 = this.f86906f;
        String r103 = null;
        if (r102 == null) goto L5;
        TextView r104 = (TextView) r102.findViewById(R.id.content);
    L6:
        View r105 = this.f86906f;
        if (r105 == null) goto L9;
        TextView r106 = (TextView) r105.findViewById(R.id.sub_content);
    L10:
        m.a(r104);
        if (r104 == null) goto L17;
        ProfileHighScoreSong r107 = r101.highScoreSong;
        if (r107 == null) goto L15;
        String r108 = r107.getCountStr();
    L16:
        r104.setText(r108);
        goto L17
    L15:
        r108 = null;
    L17:
        if (r106 == null) goto L23;
        ProfileHighScoreSong r109 = r101.highScoreSong;
        if (r109 == null) goto L21;
        r103 = r109.getCountSubStr();
    L21:
        r106.setText(r103);
        return;
    L23:
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
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
        super.f(r100, r101);
    }

    public ProfileHonourWallKtvCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f86906f = LayoutInflater.from(getContainer().getContext()).inflate(R.layout.ttlive_profile_v3_honour_ktv_card_layout, getContainer(), true);
    }
}
