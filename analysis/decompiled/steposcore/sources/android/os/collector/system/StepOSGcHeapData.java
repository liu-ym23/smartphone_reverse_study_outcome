package android.os.collector.system;

import android.os.Parcelable;
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
public final class StepOSGcHeapData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSGcHeapData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda24
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSGcHeapData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda25
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSGcHeapData.lambda$static$24(i);
        }
    });
    public long mAvgBlockingTime;
    public int mBlockingGcCount;
    public int mGcTimeRatio;
    public long mJavaHeapMax;
    public int mJavaHeapUsage;
    public long mJavaHeapUsed;
    public long mNativeHeapAllocated;
    public long mNativeHeapTotal;
    public int mPid;
    public String mProcessName;
    public long mTimestamp;
    public long mTotalGcCount;

    public StepOSGcHeapData() {
        super(1, 13);
    }

    public StepOSGcHeapData(String processName, int pid, long timestamp, long javaHeapUsed, long javaHeapMax, int javaHeapUsage, long nativeHeapAllocated, long nativeHeapTotal, int gcTimeRatio, long avgBlockingTime, int blockingGcCount, long totalGcCount) {
        this();
        this.mProcessName = processName;
        this.mPid = pid;
        this.mTimestamp = timestamp;
        this.mJavaHeapUsed = javaHeapUsed;
        this.mJavaHeapMax = javaHeapMax;
        this.mJavaHeapUsage = javaHeapUsage;
        this.mNativeHeapAllocated = nativeHeapAllocated;
        this.mNativeHeapTotal = nativeHeapTotal;
        this.mGcTimeRatio = gcTimeRatio;
        this.mAvgBlockingTime = avgBlockingTime;
        this.mBlockingGcCount = blockingGcCount;
        this.mTotalGcCount = totalGcCount;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("process_name", new Supplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("pid", new IntSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda16
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda17
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofLong("timestamp", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda18
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda19
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        }), Field.ofLong("java_heap_used", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda20
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda21
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofLong("java_heap_max", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda22
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda23
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
            }
        }), Field.ofInt("java_heap_usage", new IntSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofLong("native_heap_allocated", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$12();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda4
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$13(j);
            }
        }), Field.ofLong("native_heap_total", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$14();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$15(j);
            }
        }), Field.ofInt("gc_time_ratio", new IntSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$16();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda8
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$17(i);
            }
        }), Field.ofLong("avg_blocking_time", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$18();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda10
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$19(j);
            }
        }), Field.ofInt("blocking_gc_count", new IntSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$20();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$21(i);
            }
        }), Field.ofLong("total_gc_count", new LongSupplier() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda14
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$22();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSGcHeapData$$ExternalSyntheticLambda15
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$23(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mProcessName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mProcessName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mPid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mPid = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mTimestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mTimestamp = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mJavaHeapUsed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mJavaHeapUsed = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mJavaHeapMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mJavaHeapMax = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mJavaHeapUsage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mJavaHeapUsage = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$12() {
        return this.mNativeHeapAllocated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(long v) {
        this.mNativeHeapAllocated = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$14() {
        return this.mNativeHeapTotal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(long v) {
        this.mNativeHeapTotal = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$16() {
        return this.mGcTimeRatio;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(int v) {
        this.mGcTimeRatio = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$18() {
        return this.mAvgBlockingTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$19(long v) {
        this.mAvgBlockingTime = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$20() {
        return this.mBlockingGcCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$21(int v) {
        this.mBlockingGcCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$22() {
        return this.mTotalGcCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$23(long v) {
        this.mTotalGcCount = v;
    }

    static /* synthetic */ StepOSGcHeapData[] lambda$static$24(int x$0) {
        return new StepOSGcHeapData[x$0];
    }
}
