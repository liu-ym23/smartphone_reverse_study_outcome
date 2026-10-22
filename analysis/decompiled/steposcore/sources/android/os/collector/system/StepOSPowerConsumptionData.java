package android.os.collector.system;

import android.os.Parcelable;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSPowerConsumptionData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSPowerConsumptionData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSPowerConsumptionData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSPowerConsumptionData.lambda$static$16(i);
        }
    });
    public int mCpuPowerConsumption;
    public String mPowerLevel;
    public int mRadioPowerConsumption;
    public int mScreenOnDuration;
    public int mScreenPowerConsumption;
    public int mSensorPowerConsumption;
    public int mTotalPowerConsumption;
    public int mWakeLockCount;

    public StepOSPowerConsumptionData() {
        super(1, 8);
    }

    public StepOSPowerConsumptionData(int totalPowerConsumption, int screenPowerConsumption, int cpuPowerConsumption, int radioPowerConsumption, int sensorPowerConsumption, int wakeLockCount, int screenOnDuration, String powerLevel) {
        this();
        this.mTotalPowerConsumption = totalPowerConsumption;
        this.mScreenPowerConsumption = screenPowerConsumption;
        this.mCpuPowerConsumption = cpuPowerConsumption;
        this.mRadioPowerConsumption = radioPowerConsumption;
        this.mSensorPowerConsumption = sensorPowerConsumption;
        this.mWakeLockCount = wakeLockCount;
        this.mScreenOnDuration = screenOnDuration;
        this.mPowerLevel = powerLevel;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("total_power_consumption", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofInt("screen_power_consumption", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("cpu_power_consumption", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofInt("radio_power_consumption", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofInt("sensor_power_consumption", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda16
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda17
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofInt("wake_lock_count", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofInt("screen_on_duration", new IntSupplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$12();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$13(i);
            }
        }), Field.ofString("power_level", new Supplier() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerConsumptionData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mTotalPowerConsumption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mTotalPowerConsumption = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mScreenPowerConsumption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mScreenPowerConsumption = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mCpuPowerConsumption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mCpuPowerConsumption = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mRadioPowerConsumption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mRadioPowerConsumption = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mSensorPowerConsumption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mSensorPowerConsumption = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mWakeLockCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mWakeLockCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$12() {
        return this.mScreenOnDuration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(int v) {
        this.mScreenOnDuration = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$14() {
        return this.mPowerLevel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(String v) {
        this.mPowerLevel = v;
    }

    static /* synthetic */ StepOSPowerConsumptionData[] lambda$static$16(int x$0) {
        return new StepOSPowerConsumptionData[x$0];
    }
}
