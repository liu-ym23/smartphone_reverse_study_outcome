package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/PcuTrigger;", "Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/FeedbackMsgTrigger;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PcuTrigger extends FeedbackMsgTrigger {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TriggerId f124658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f124659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f124660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f124661i;

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final List<String> g() {
        return this.f124660h;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.f124658f;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final List<Integer> h() {
        return this.f124659g;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final void i(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof mk) == true) goto L5;
        r100 = null;
    L5:
        mk r101 = (mk) r100;
        if (r101 == null) goto L13;
        d("on PcuTrigger receive msg, displayType:" + r101.getDisplayType() + ", displayValue: " + r101.getDisplayValue() + ", pcuThreshold:" + this.f124661i, new Pair[0]);
        int r102 = (int) r101.getDisplayType();
        RoomViewStats.Companion.getClass();
        if (r102 == RoomViewStats.access$getDisplayTypePCU$cp()) goto L10;
        return;
    L10:
        if (r101.getDisplayValue() < this.f124661i) goto L15;
        ALogger.d(this.f479099a, "on action：pcu");
        e(null);
        return;
    L15:
        return;
    }

    public PcuTrigger(DataCenter r100, long r101) {
        super(r100);
        this.f124661i = r101;
        this.f124658f = TriggerId.Pcu;
        this.f124659g = CollectionsKt.emptyList();
        this.f124660h = CollectionsKt.listOf("WebcastRoomStatsMessage");
    }
}
