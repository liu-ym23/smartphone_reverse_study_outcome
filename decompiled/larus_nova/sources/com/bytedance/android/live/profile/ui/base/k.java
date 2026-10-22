package com.bytedance.android.live.profile.ui.base;

import android.view.View;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f86336a;

    public k() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void b(d r100) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r100) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public abstract /* synthetic */ void update(NewProfileUser r100);

    public void h() {
        d r100 = this.f86336a;
        if (r100 == null) goto L6;
        r100.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    public final <T extends View> T i(int r100) {
        d r101 = this.f86336a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.a(r100);
    }
}
