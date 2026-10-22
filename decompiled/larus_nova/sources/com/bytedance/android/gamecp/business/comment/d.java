package com.bytedance.android.gamecp.business.comment;

import android.widget.ImageView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentImageSummaryAdapter.ViewHolder f52015a;

    @Override // com.bytedance.android.gamecp.common.utils.y.a
    public final void a() {
    }

    @Override // com.bytedance.android.gamecp.common.utils.y.a
    public final void onLoadSuccess() {
    }

    @Override // com.bytedance.android.gamecp.common.utils.y.a
    public final void onLoadFailed() {
        ImageView r100 = this.f52015a.f51826b;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.j(r100);
        return;
    }

    public d(CommentImageSummaryAdapter.ViewHolder r100) {
        this.f52015a = r100;
    }
}
