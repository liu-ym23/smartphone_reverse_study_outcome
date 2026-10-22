package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractVoteThemeBinder.a f97355a;

    public g(InteractVoteThemeBinder.a r100) {
        this.f97355a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        InteractVoteThemeBinder.a r101 = this.f97355a;
        InteractVoteThemeBinder.b r102 = r101.f97338d;
        if (r102 == null) goto L9;
        long r103 = r101.f97335a;
        String r104 = r101.f97336b;
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r102.s80(new InteractVoteStartDialog.b(r103, r104));
        return;
    }
}
