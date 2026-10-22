package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeTopicViewPagerPositionEffect;", "Lcom/bytedance/android/anya/a0;", "", "topicPagerPosition", "I", "getTopicPagerPosition", "()I", "<init>", "(I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChangeTopicViewPagerPositionEffect implements a0 {
    private final int topicPagerPosition;

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public ChangeTopicViewPagerPositionEffect(int r100) {
        this.topicPagerPosition = r100;
    }
}
