package com.bytedance.android.livesdk.feedback.view.feedback;

import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomQuestionFeedback f124981a;

    public f(RoomQuestionFeedback r100) {
        this.f124981a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L10;
        HSImageView r101 = this.f124981a.f124929d;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        return;
    L9:
        return;
    }
}
