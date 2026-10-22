package com.bytedance.android.livesdk.feedback.view.feedback;

import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomQuestionFeedback f124982a;

    public g(RoomQuestionFeedback r100) {
        this.f124982a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        HSImageView r102 = this.f124982a.f124929d;
        if (r102 == null) goto L6;
        r102.setVisibility(0);
        return;
    }
}
