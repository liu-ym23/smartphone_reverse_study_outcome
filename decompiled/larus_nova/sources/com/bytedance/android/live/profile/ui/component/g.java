package com.bytedance.android.live.profile.ui.component;

import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileCustomSkin.GradientColor f86724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProfileCommonComponent f86725b;

    public g(ProfileCustomSkin.GradientColor r100, ProfileCommonComponent r101) {
        this.f86724a = r100;
        this.f86725b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProfileCommonComponent r100 = this.f86725b;     // Catch: Throwable -> L4
        ProfileCommonComponent.a(r100, r100.i(), ColorProtector.parseColor(this.f86724a.from), ColorProtector.parseColor(this.f86724a.f58938to));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
