package android.os.collector.device;

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
public final class StepOSAppPowerConsumptionData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSAppPowerConsumptionData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda8
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSAppPowerConsumptionData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda9
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSAppPowerConsumptionData.lambda$static$8(i);
        }
    });
    public long mBackgroundDurationMs;
    public long mForegroundDurationMs;
    public String mPackageName;
    public double mPowerMah;

    public StepOSAppPowerConsumptionData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_APP_POWER_CONSUMPTION);
    }

    public StepOSAppPowerConsumptionData(String packageName, double powerMah, long foregroundDurationMs, long backgroundDurationMs) {
        this();
        this.mPackageName = packageName;
        this.mPowerMah = powerMah;
        this.mForegroundDurationMs = foregroundDurationMs;
        this.mBackgroundDurationMs = backgroundDurationMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofDouble("power_mah", new Supplier() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((Double) obj);
            }
        }), Field.ofLong("foreground_duration_ms", new LongSupplier() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda4
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        }), Field.ofLong("background_duration_ms", new LongSupplier() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSAppPowerConsumptionData$$ExternalSyntheticLambda7
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
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
    public /* synthetic */ Double lambda$fields$2() {
        return Double.valueOf(this.mPowerMah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(Double v) {
        this.mPowerMah = v.doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mForegroundDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mForegroundDurationMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mBackgroundDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mBackgroundDurationMs = v;
    }

    static /* synthetic */ StepOSAppPowerConsumptionData[] lambda$static$8(int x$0) {
        return new StepOSAppPowerConsumptionData[x$0];
    }
}
