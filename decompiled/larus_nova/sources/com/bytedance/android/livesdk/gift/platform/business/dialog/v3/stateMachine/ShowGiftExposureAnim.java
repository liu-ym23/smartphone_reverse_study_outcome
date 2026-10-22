package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowGiftExposureAnim;", "Lcom/bytedance/android/anya/a0;", "", "pagerPosition", "I", "getPagerPosition", "()I", "position", "getPosition", "Lpy/k;", "anim", "Lpy/k;", "getAnim", "()Lpy/k;", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "<init>", "(IILpy/k;II)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowGiftExposureAnim implements a0 {
    private final k anim;
    private final int counterPosition;
    private final int pagerPosition;
    private final int position;
    private final int topicPagerPosition;

    public final k getAnim() {
        return this.anim;
    }

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

    public ShowGiftExposureAnim(int r100, int r101, k r102, int r103, int r104) {
        this.pagerPosition = r100;
        this.position = r101;
        this.anim = r102;
        this.counterPosition = r103;
        this.topicPagerPosition = r104;
    }

    public /* synthetic */ ShowGiftExposureAnim(int r100, int r101, k r110, int r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        int r102 = -1;
    L7:
        if ((r113 & 16) == 0) goto L9;
        int r103 = -1;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
