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
public final class StepOSMemoryPressureData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSMemoryPressureData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda20
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSMemoryPressureData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda21
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSMemoryPressureData.lambda$static$20(i);
        }
    });
    public int mFullAvg10Us;
    public int mFullAvg300Us;
    public int mFullAvg60Us;
    public long mFullTotalUs;
    public int mSomeAvg10Us;
    public int mSomeAvg300Us;
    public int mSomeAvg60Us;
    public long mSomeTotalUs;
    public String mStep;
    public String mTriggerReason;

    public StepOSMemoryPressureData() {
        super(1, 16);
    }

    public StepOSMemoryPressureData(String step, int someAvg10Us, int someAvg60Us, int someAvg300Us, long someTotalUs, int fullAvg10Us, int fullAvg60Us, int fullAvg300Us, long fullTotalUs, String triggerReason) {
        this();
        this.mStep = step;
        this.mSomeAvg10Us = someAvg10Us;
        this.mSomeAvg60Us = someAvg60Us;
        this.mSomeAvg300Us = someAvg300Us;
        this.mSomeTotalUs = someTotalUs;
        this.mFullAvg10Us = fullAvg10Us;
        this.mFullAvg60Us = fullAvg60Us;
        this.mFullAvg300Us = fullAvg300Us;
        this.mFullTotalUs = fullTotalUs;
        this.mTriggerReason = triggerReason;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("step", new Supplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("some_avg10_us", new IntSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("some_avg60_us", new IntSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofInt("some_avg300_us", new IntSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda16
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda17
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofLong("some_total_us", new LongSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda18
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda19
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
            }
        }), Field.ofInt("full_avg10_us", new IntSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofInt("full_avg60_us", new IntSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$12();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$13(i);
            }
        }), Field.ofInt("full_avg300_us", new IntSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$14();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$15(i);
            }
        }), Field.ofLong("full_total_us", new LongSupplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda7
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$16();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda8
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$17(j);
            }
        }), Field.ofString("trigger_reason", new Supplier() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$18();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSMemoryPressureData$$ExternalSyntheticLambda10
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$19((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mStep;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mStep = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mSomeAvg10Us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mSomeAvg10Us = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mSomeAvg60Us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mSomeAvg60Us = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mSomeAvg300Us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mSomeAvg300Us = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mSomeTotalUs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mSomeTotalUs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mFullAvg10Us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mFullAvg10Us = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$12() {
        return this.mFullAvg60Us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(int v) {
        this.mFullAvg60Us = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$14() {
        return this.mFullAvg300Us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(int v) {
        this.mFullAvg300Us = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$16() {
        return this.mFullTotalUs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(long v) {
        this.mFullTotalUs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$18() {
        return this.mTriggerReason;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$19(String v) {
        this.mTriggerReason = v;
    }

    static /* synthetic */ StepOSMemoryPressureData[] lambda$static$20(int x$0) {
        return new StepOSMemoryPressureData[x$0];
    }
}
