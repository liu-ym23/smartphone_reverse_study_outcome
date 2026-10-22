package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLightFeedbackRelaxWidget f124793a;

    public b(LiveLightFeedbackRelaxWidget r100) {
        this.f124793a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        FeedItem r101 = (FeedItem) sh6.c.b((sh6.b) r100);
        if (r101 == null) goto L6;
        LiveLightFeedbackRelaxWidget r102 = this.f124793a;
        int r103 = LiveLightFeedbackRelaxWidget.f124756f;
        r102.zq(r101);
        return;
    }
}
