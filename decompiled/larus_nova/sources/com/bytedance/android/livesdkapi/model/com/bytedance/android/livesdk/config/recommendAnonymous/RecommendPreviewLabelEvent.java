package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous;

import com.bytedance.android.livesdkapi.depend.model.live.LabelInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/RecommendPreviewLabelEvent;", "", "roomId", "", "isRecommended", "", "label", "Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "(JZLcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;)V", "()Z", "getLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "getRoomId", "()J", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendPreviewLabelEvent {
    private final boolean isRecommended;
    private final LabelInfo label;
    private final long roomId;

    public final LabelInfo getLabel() {
        return this.label;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final boolean isRecommended() {
        return this.isRecommended;
    }

    public RecommendPreviewLabelEvent(long r100, boolean r101, LabelInfo r102) {
        Intrinsics.checkNotNullParameter(r102, "label");
        this.roomId = r100;
        this.isRecommended = r101;
        this.label = r102;
    }
}
