package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState;", "Lcom/bytedance/android/anya/r;", "<init>", "()V", "GroupCombo", "Idle", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState$GroupCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState$Idle;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftGroupItemBusinessState implements r {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState$GroupCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState;", "position", "", "comboCount", "(II)V", "getComboCount", "()I", "getPosition", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GroupCombo extends GiftGroupItemBusinessState {
        private final int comboCount;
        private final int position;

        public final int getComboCount() {
            return this.comboCount;
        }

        public final int getPosition() {
            return this.position;
        }

        public GroupCombo(int r100, int r101) {
            super(null);
            this.position = r100;
            this.comboCount = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState$Idle;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupItemBusinessState;", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends GiftGroupItemBusinessState {
        public static final Idle INSTANCE = null;

        private Idle() {
            super(null);
        }

        static {
            INSTANCE = new Idle();
        }
    }

    private GiftGroupItemBusinessState() {
    }

    public /* synthetic */ GiftGroupItemBusinessState(DefaultConstructorMarker r100) {
        this();
    }
}
