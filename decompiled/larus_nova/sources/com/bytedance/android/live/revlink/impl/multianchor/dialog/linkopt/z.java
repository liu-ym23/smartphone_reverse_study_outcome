package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes47.dex */
public final class z<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiAnchorPkLaunchDialogNew f93623a;

    public z(MultiAnchorPkLaunchDialogNew r100) {
        this.f93623a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        MultiAnchorPkLaunchDialogNew r101 = this.f93623a;
        int r102 = MultiAnchorPkLaunchDialogNew.f93555q;
        r101.Y90((Integer) r100);
    }
}
