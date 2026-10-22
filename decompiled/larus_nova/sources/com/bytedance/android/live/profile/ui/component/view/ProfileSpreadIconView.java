package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import st0.g;
import ut0.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileSpreadIconView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/g;", "data", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileSpreadIconView extends FrameLayout implements e<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f86840a;

    public static final class a {
    }

    static {
    }

    public ProfileSpreadIconView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileSpreadIconView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void c(g r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(g r100, ProfileSkin r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "skin");
        ProfileCustomSkin r102 = r101.skin;
        if (r102 == null) goto L13;
        int r103 = Color.parseColor(r102.followInfoColor);     // Catch: Exception -> L8
        ImageView r104 = this.f86840a;     // Catch: Exception -> L8
        if (r104 == null) goto L14;
        r104.setColorFilter(Color.argb(51, Color.red(r103), Color.green(r103), Color.blue(r103)));     // Catch: Exception -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        ALogger.e("ProfileSpreadIconView", "loadSkin error: " + e.getMessage());
        Unit r106 = Unit.INSTANCE;
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(g r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        e.a.update(this, r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(g r100, NewProfileUser r101) {
        update2(r100, r101);
    }

    public ProfileSpreadIconView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_profile_spread_icon_layout, this, true);
        this.f86840a = (ImageView) findViewById(R.id.my_live_spread_icon);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(g r100, NewProfileUser r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "logUseCase");
        e.a.a(r101, r102);
    }

    public /* synthetic */ ProfileSpreadIconView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
