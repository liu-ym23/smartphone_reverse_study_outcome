package com.bytedance.android.live.liveinteract.videotalk.ui;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseEqualGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f79761a;

    public BaseEqualGridItemDecoration() {
        this(null);
    }

    public BaseEqualGridItemDecoration(Drawable r100) {
        this.f79761a = r100;
    }
}
