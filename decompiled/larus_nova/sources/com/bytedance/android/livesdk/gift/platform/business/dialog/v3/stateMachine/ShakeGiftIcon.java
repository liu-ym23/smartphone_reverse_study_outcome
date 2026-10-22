package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShakeGiftIcon;", "Lcom/bytedance/android/anya/a0;", "", "pagerPosition", "I", "getPagerPosition", "()I", "position", "getPosition", "", "toastText", "Ljava/lang/String;", "getToastText", "()Ljava/lang/String;", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "<init>", "(IILjava/lang/String;II)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShakeGiftIcon implements a0 {
    private final int counterPosition;
    private final int pagerPosition;
    private final int position;
    private final String toastText;
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

    public final String getToastText() {
        return this.toastText;
    }

    public final int getTopicPagerPosition() {
        return this.topicPagerPosition;
    }

    public ShakeGiftIcon(int r100, int r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r102, "toastText");
        this.pagerPosition = r100;
        this.position = r101;
        this.toastText = r102;
        this.counterPosition = r103;
        this.topicPagerPosition = r104;
    }
}
