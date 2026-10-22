package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollToPositionEffect;", "Lcom/bytedance/android/anya/a0;", "", "pagerPosition", "I", "getPagerPosition", "()I", "position", "getPosition", "counterPosition", "getCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "", "isDefault", "Z", "()Z", "isSearchLocate", "<init>", "(IIIIZZ)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollToPositionEffect implements a0 {
    private final int counterPosition;
    private final boolean isDefault;
    private final boolean isSearchLocate;
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

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final boolean isSearchLocate() {
        return this.isSearchLocate;
    }

    public ScrollToPositionEffect(int r100, int r101, int r102, int r103, boolean r104, boolean r105) {
        this.pagerPosition = r100;
        this.position = r101;
        this.counterPosition = r102;
        this.topicPagerPosition = r103;
        this.isDefault = r104;
        this.isSearchLocate = r105;
    }

    public /* synthetic */ ScrollToPositionEffect(int r100, int r101, int r110, int r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        int r102 = -1;
    L7:
        if ((r114 & 16) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 32) == 0) goto L13;
        boolean r104 = false;
    L14:
        this(r100, r101, r110, r102, r103, r104);
        return;
    L13:
        r104 = r113;
        goto L14
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r111;
        goto L7
    }
}
