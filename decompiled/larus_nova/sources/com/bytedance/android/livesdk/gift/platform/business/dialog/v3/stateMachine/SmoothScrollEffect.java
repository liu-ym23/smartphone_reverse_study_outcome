package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SmoothScrollEffect;", "Lcom/bytedance/android/anya/a0;", "", "pagerPosition", "I", "getPagerPosition", "()I", "position", "getPosition", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "<init>", "(IIII)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothScrollEffect implements a0 {
    private final int counterPosition;
    private final int pagerPosition;
    private final int position;
    private final int topicPagerPosition;

    public final int getCounterPosition() {
        return this.counterPosition;
    }

    public final int getPagerPosition() {
        return this.pagerPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public SmoothScrollEffect(int r100, int r101, int r102, int r103) {
        this.pagerPosition = r100;
        this.position = r101;
        this.counterPosition = r102;
        this.topicPagerPosition = r103;
    }

    public /* synthetic */ SmoothScrollEffect(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = -1;
    L5:
        this(r100, r101, r102, r103);
    }
}
