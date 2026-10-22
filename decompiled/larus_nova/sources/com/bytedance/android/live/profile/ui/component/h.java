package com.bytedance.android.live.profile.ui.component;

import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileCommonComponent f86726a;

    public h(ProfileCommonComponent r100) {
        this.f86726a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = s1.h(R.color.ttlive_new_profile_black);     // Catch: Throwable -> L5
        ProfileCommonComponent r101 = this.f86726a;     // Catch: Throwable -> L5
        ProfileCommonComponent.a(r101, r101.i(), r100, r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
