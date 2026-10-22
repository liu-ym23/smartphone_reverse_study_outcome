package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState;", "Lcom/bytedance/android/anya/r;", "<init>", "()V", "BuffSelected", "Idle", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState$BuffSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState$Idle;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftBuffCardBusinessState implements r {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState$BuffSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState;", "buffCard", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardItem;", "position", "", "(Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardItem;I)V", "getBuffCard", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardItem;", "getPosition", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BuffSelected extends GiftBuffCardBusinessState {
        private final GiftBuffCardItem buffCard;
        private final int position;

        public final GiftBuffCardItem getBuffCard() {
            return this.buffCard;
        }

        public final int getPosition() {
            return this.position;
        }

        public BuffSelected(GiftBuffCardItem r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "buffCard");
            super(null);
            this.buffCard = r100;
            this.position = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState$Idle;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardBusinessState;", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends GiftBuffCardBusinessState {
        public static final Idle INSTANCE = null;

        private Idle() {
            super(null);
        }

        static {
            INSTANCE = new Idle();
        }
    }

    private GiftBuffCardBusinessState() {
    }

    public /* synthetic */ GiftBuffCardBusinessState(DefaultConstructorMarker r100) {
        this();
    }
}
