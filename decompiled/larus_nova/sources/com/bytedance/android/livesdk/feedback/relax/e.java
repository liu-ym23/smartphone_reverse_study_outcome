package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLightFeedbackRelaxWidget f124796a;

    public e(LiveLightFeedbackRelaxWidget r100) {
        this.f124796a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        LiveLightFeedbackRelaxWidget.wq(this.f124796a, FeedbackCard.FeedbackStatus.COMPLETE);
        com.bytedance.android.livesdk.feedback.light.context.a r102 = this.f124796a.f124757a;
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.i<ix1.a> r103 = r102.getFeedbackConfigService();
        if (r103 == null) goto L11;
        ix1.a r104 = r103.getValue();
        if (r104 == null) goto L12;
        r104.b();
        return;
    L12:
        return;
    L11:
        return;
    }
}
