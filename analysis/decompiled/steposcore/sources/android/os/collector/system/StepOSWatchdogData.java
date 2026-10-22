package android.os.collector.system;

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
public final class StepOSWatchdogData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSWatchdogData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda10
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSWatchdogData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda11
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSWatchdogData.lambda$static$10(i);
        }
    });
    public long mBlockedDurationMs;
    public String mLogPath;
    public String mStackSummary;
    public String mSubject;
    public long mTimestampMs;

    public StepOSWatchdogData() {
        super(1, StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_WATCHDOG);
    }

    public StepOSWatchdogData(String subject, long blockedDurationMs, String stackSummary, String logPath, long timestampMs) {
        this();
        this.mSubject = subject;
        this.mBlockedDurationMs = blockedDurationMs;
        this.mStackSummary = stackSummary;
        this.mLogPath = logPath;
        this.mTimestampMs = timestampMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("subject", new Supplier() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofLong("blocked_duration_ms", new LongSupplier() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$2();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$3(j);
            }
        }), Field.ofString("stack_summary", new Supplier() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofString("log_path", new Supplier() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((String) obj);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda8
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSWatchdogData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mSubject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mSubject = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$2() {
        return this.mBlockedDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(long v) {
        this.mBlockedDurationMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mStackSummary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mStackSummary = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$6() {
        return this.mLogPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(String v) {
        this.mLogPath = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mTimestampMs = v;
    }

    static /* synthetic */ StepOSWatchdogData[] lambda$static$10(int x$0) {
        return new StepOSWatchdogData[x$0];
    }
}
