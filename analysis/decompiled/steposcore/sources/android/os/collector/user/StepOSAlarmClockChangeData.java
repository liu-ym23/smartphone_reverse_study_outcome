package android.os.collector.user;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSAlarmClockChangeData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSAlarmClockChangeData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda6
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSAlarmClockChangeData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda7
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSAlarmClockChangeData.lambda$static$6(i);
        }
    });
    public String mPackageName;
    public long mTimestampMs;
    public long mTriggerAtMs;

    public StepOSAlarmClockChangeData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_ALARM_CLOCK_CHANGE);
    }

    public StepOSAlarmClockChangeData(String packageName, long triggerAtMs, long timestampMs) {
        this();
        this.mPackageName = packageName;
        this.mTriggerAtMs = triggerAtMs;
        this.mTimestampMs = timestampMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofLong("trigger_at_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$2();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$3(j);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda4
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSAlarmClockChangeData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mPackageName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$2() {
        return this.mTriggerAtMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(long v) {
        this.mTriggerAtMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mTimestampMs = v;
    }

    static /* synthetic */ StepOSAlarmClockChangeData[] lambda$static$6(int x$0) {
        return new StepOSAlarmClockChangeData[x$0];
    }
}
