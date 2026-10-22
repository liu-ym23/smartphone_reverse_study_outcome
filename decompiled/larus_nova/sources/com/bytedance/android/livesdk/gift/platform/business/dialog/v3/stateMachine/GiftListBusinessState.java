package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vz1.e;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "Lcom/bytedance/android/anya/r;", "<init>", "()V", "GiftCombo", "GiftSelected", "Idle", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftListBusinessState implements r {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftCombo;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "", "selectedPagePosition", "I", "getSelectedPagePosition", "()I", "position", "getPosition", "comboNum", "getComboNum", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "currentStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "getCurrentStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "selectCounterPosition", "getSelectCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "<init>", "(IIILcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ComboState;Lvz1/e;II)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftCombo extends GiftListBusinessState {
        private final int comboNum;
        private final ComboState currentStatus;
        private final e iconModel;
        private final int position;
        private final int selectCounterPosition;
        private final int selectedPagePosition;
        private final int topicPagerPosition;

        public final int getComboNum() {
            return this.comboNum;
        }

        public final ComboState getCurrentStatus() {
            return this.currentStatus;
        }

        public final e getIconModel() {
            return this.iconModel;
        }

        public final int getPosition() {
            return this.position;
        }

        public final int getSelectCounterPosition() {
            return this.selectCounterPosition;
        }

        public final int getSelectedPagePosition() {
            return this.selectedPagePosition;
        }

        public final int getTopicPagerPosition() {
            return this.topicPagerPosition;
        }

        public GiftCombo(int r100, int r101, int r102, ComboState r103, e r104, int r105, int r106) {
            Intrinsics.checkNotNullParameter(r103, "currentStatus");
            super(null);
            this.selectedPagePosition = r100;
            this.position = r101;
            this.comboNum = r102;
            this.currentStatus = r103;
            this.iconModel = r104;
            this.selectCounterPosition = r105;
            this.topicPagerPosition = r106;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$GiftSelected;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "", "selectedPagePosition", "I", "getSelectedPagePosition", "()I", "selectedPosition", "getSelectedPosition", "Lvz1/e;", "iconModel", "Lvz1/e;", "getIconModel", "()Lvz1/e;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectedStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "getSelectedStatus", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectCounterPosition", "getSelectCounterPosition", "topicPagerPosition", "getTopicPagerPosition", "", "selectedTopicId", "J", "getSelectedTopicId", "()J", "visualStatus", "getVisualStatus", "<init>", "(IILvz1/e;Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;IIJI)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GiftSelected extends GiftListBusinessState {
        private final e iconModel;
        private final int selectCounterPosition;
        private final int selectedPagePosition;
        private final int selectedPosition;
        private final SelectedStatus selectedStatus;
        private final long selectedTopicId;
        private final int topicPagerPosition;
        private final int visualStatus;

        public final e getIconModel() {
            return this.iconModel;
        }

        public final int getSelectCounterPosition() {
            return this.selectCounterPosition;
        }

        public final int getSelectedPagePosition() {
            return this.selectedPagePosition;
        }

        public final int getSelectedPosition() {
            return this.selectedPosition;
        }

        public final SelectedStatus getSelectedStatus() {
            return this.selectedStatus;
        }

        public final long getSelectedTopicId() {
            return this.selectedTopicId;
        }

        public final int getTopicPagerPosition() {
            return this.topicPagerPosition;
        }

        public final int getVisualStatus() {
            return this.visualStatus;
        }

        public GiftSelected(int r100, int r101, e r102, SelectedStatus r103, int r104, int r105, long r106, int r110) {
            Intrinsics.checkNotNullParameter(r103, "selectedStatus");
            super(null);
            this.selectedPagePosition = r100;
            this.selectedPosition = r101;
            this.iconModel = r102;
            this.selectedStatus = r103;
            this.selectCounterPosition = r104;
            this.topicPagerPosition = r105;
            this.selectedTopicId = r106;
            this.visualStatus = r110;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState$Idle;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftListBusinessState;", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Idle extends GiftListBusinessState {
        public Idle() {
            super(null);
        }
    }

    private GiftListBusinessState() {
    }

    public /* synthetic */ GiftListBusinessState(DefaultConstructorMarker r100) {
        this();
    }
}
