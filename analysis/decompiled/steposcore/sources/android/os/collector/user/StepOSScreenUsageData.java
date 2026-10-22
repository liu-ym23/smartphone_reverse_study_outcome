package android.os.collector.user;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;

/* loaded from: classes.dex */
public final class StepOSScreenUsageData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSScreenUsageData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda6
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSScreenUsageData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda7
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSScreenUsageData.lambda$static$6(i);
        }
    });
    public boolean mInteractive;
    public long mPrevStateDurationMs;
    public long mTimestampMs;

    public StepOSScreenUsageData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_SCREEN_USAGE);
    }

    public StepOSScreenUsageData(boolean interactive, long prevStateDurationMs, long timestampMs) {
        this();
        this.mInteractive = interactive;
        this.mPrevStateDurationMs = prevStateDurationMs;
        this.mTimestampMs = timestampMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofBool("interactive", new BooleanSupplier() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((Boolean) obj);
            }
        }), Field.ofLong("prev_state_duration_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$2();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$3(j);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda4
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSScreenUsageData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$0() {
        return this.mInteractive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(Boolean v) {
        this.mInteractive = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$2() {
        return this.mPrevStateDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(long v) {
        this.mPrevStateDurationMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mTimestampMs = v;
    }

    static /* synthetic */ StepOSScreenUsageData[] lambda$static$6(int x$0) {
        return new StepOSScreenUsageData[x$0];
    }
}
