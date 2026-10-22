package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentItemView f173930a;

    public c(CommentItemView r100) {
        this.f173930a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super DeepFeedCommentClickArea, Unit> r101 = this.f173930a.f173885i;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(DeepFeedCommentClickArea.Avatar);
        return;
    }
}
