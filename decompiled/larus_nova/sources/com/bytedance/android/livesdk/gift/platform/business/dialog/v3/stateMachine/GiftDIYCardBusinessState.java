package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState;", "Lcom/bytedance/android/anya/r;", "<init>", "()V", "DIYSelected", "Idle", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState$DIYSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState$Idle;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftDIYCardBusinessState implements r {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState$DIYSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState;", "diyCard", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardItem;", "position", "", "originId", "", "(Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardItem;IJ)V", "getDiyCard", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardItem;", "getOriginId", "()J", "getPosition", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DIYSelected extends GiftDIYCardBusinessState {
        private final GiftDIYCardItem diyCard;
        private final long originId;
        private final int position;

        public final GiftDIYCardItem getDiyCard() {
            return this.diyCard;
        }

        public final long getOriginId() {
            return this.originId;
        }

        public final int getPosition() {
            return this.position;
        }

        public DIYSelected(GiftDIYCardItem r100, int r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "diyCard");
            super(null);
            this.diyCard = r100;
            this.position = r101;
            this.originId = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState$Idle;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardBusinessState;", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends GiftDIYCardBusinessState {
        public static final Idle INSTANCE = null;

        private Idle() {
            super(null);
        }

        static {
            INSTANCE = new Idle();
        }
    }

    private GiftDIYCardBusinessState() {
    }

    public /* synthetic */ GiftDIYCardBusinessState(DefaultConstructorMarker r100) {
        this();
    }
}
