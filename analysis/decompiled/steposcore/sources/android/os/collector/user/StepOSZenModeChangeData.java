package android.os.collector.user;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSZenModeChangeData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSZenModeChangeData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSZenModeChangeData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSZenModeChangeData.lambda$static$10(i);
        }
    });
    public long mPrevDurationMs;
    public int mPrevZenMode;
    public String mReason;
    public long mTimestampMs;
    public int mZenMode;

    public StepOSZenModeChangeData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_ZEN_MODE_CHANGE);
    }

    public StepOSZenModeChangeData(int zenMode, int prevZenMode, long prevDurationMs, long timestampMs, String reason) {
        this();
        this.mZenMode = zenMode;
        this.mPrevZenMode = prevZenMode;
        this.mPrevDurationMs = prevDurationMs;
        this.mTimestampMs = timestampMs;
        this.mReason = reason;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("zen_mode", new IntSupplier() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofInt("prev_zen_mode", new IntSupplier() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofLong("prev_duration_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda7
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda8
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofString("reason", new Supplier() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSZenModeChangeData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mZenMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mZenMode = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mPrevZenMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mPrevZenMode = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mPrevDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mPrevDurationMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mTimestampMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$8() {
        return this.mReason;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(String v) {
        this.mReason = v;
    }

    static /* synthetic */ StepOSZenModeChangeData[] lambda$static$10(int x$0) {
        return new StepOSZenModeChangeData[x$0];
    }
}
