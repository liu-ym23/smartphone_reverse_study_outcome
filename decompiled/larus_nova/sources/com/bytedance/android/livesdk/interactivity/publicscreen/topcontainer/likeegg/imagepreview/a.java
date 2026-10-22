package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f139971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LikeEggTemplatePreviewDialog f139972b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f139971a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LikeEggTemplatePreviewDialog r100 = this.f139972b;
        int r101 = LikeEggTemplatePreviewDialog.W;
        r100.W0().p();
    }

    public a(RecyclerView r100, LikeEggTemplatePreviewDialog r101) {
        this.f139971a = r100;
        this.f139972b = r101;
    }
}
