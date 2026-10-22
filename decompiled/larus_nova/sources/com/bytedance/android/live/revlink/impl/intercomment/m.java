package com.bytedance.android.live.revlink.impl.intercomment;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractCommentWidget f92545a;

    public m(InteractCommentWidget r100) {
        this.f92545a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        q11.b r101 = (q11.b) r100;
        InteractCommentWidget r102 = this.f92545a;
        int r103 = InteractCommentWidget.f92519n;
        r102.yq(false);
    }
}
