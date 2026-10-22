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
public final class StepOSKeyguardChangeData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSKeyguardChangeData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda6
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSKeyguardChangeData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda7
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSKeyguardChangeData.lambda$static$6(i);
        }
    });
    public boolean mKeyguardShown;
    public long mPrevStateDurationMs;
    public long mTimestampMs;

    public StepOSKeyguardChangeData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_KEYGUARD_CHANGE);
    }

    public StepOSKeyguardChangeData(boolean keyguardShown, long prevStateDurationMs, long timestampMs) {
        this();
        this.mKeyguardShown = keyguardShown;
        this.mPrevStateDurationMs = prevStateDurationMs;
        this.mTimestampMs = timestampMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofBool("keyguard_shown", new BooleanSupplier() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((Boolean) obj);
            }
        }), Field.ofLong("prev_state_duration_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$2();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$3(j);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda4
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSKeyguardChangeData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$0() {
        return this.mKeyguardShown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(Boolean v) {
        this.mKeyguardShown = v.booleanValue();
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

    static /* synthetic */ StepOSKeyguardChangeData[] lambda$static$6(int x$0) {
        return new StepOSKeyguardChangeData[x$0];
    }
}
