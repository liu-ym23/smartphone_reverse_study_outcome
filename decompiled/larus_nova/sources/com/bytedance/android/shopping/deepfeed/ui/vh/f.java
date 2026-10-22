package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductBannerCommentVH f173832a;

    public f(DeepFeedProductBannerCommentVH r100) {
        this.f173832a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super DeepFeedCommentClickArea, Unit> r101 = this.f173832a.f173787o;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(DeepFeedCommentClickArea.Container);
        return;
    }
}
