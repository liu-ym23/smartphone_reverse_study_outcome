package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.message.model.n4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/ReceiveFeedbackMsgTrigger;", "Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/FeedbackMsgTrigger;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReceiveFeedbackMsgTrigger extends FeedbackMsgTrigger {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Integer> f124662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TriggerId f124663g;

    @Override // fx1.e
    public final TriggerId getId() {
        return this.f124663g;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final List<Integer> h() {
        return this.f124662f;
    }

    public ReceiveFeedbackMsgTrigger(DataCenter r100) {
        super(r100);
        this.f124662f = CollectionsKt.listOf(Integer.valueOf(MessageType.FEEDBACK_ACTION_MESSAGE.getIntType()));
        this.f124663g = TriggerId.RECEIVE_FEEDBACK_MSG;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final void i(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof n4) == false) goto L6;
        d("on action：receive feedback msg", new Pair[0]);
        ALogger.d(this.f479099a, "on action：receive feedback msg");
        e(r100);
        return;
    }
}
