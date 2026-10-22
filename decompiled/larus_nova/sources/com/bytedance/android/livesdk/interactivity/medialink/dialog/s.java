package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes9.dex */
public final class s<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaMultiAnchorStartDialog f138125a;

    public s(MediaMultiAnchorStartDialog r100) {
        this.f138125a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        MediaMultiAnchorStartDialog r102 = this.f138125a;
        int r103 = MediaMultiAnchorStartDialog.f138075h;
        r102.U90();
        this.f138125a.updateTitle();
    }
}
