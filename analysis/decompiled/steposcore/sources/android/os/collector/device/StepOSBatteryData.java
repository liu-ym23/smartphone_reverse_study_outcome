package android.os.collector.device;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSBatteryData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSBatteryData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda14
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSBatteryData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda15
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSBatteryData.lambda$static$14(i);
        }
    });
    public int mBatteryHealth;
    public int mBatteryLevel;
    public float mBatteryTemperature;
    public String mChargeState;
    public String mChargeType;
    public boolean mIsLowPowerModeEnabled;
    public int mRemainingBatteryDuration;

    public StepOSBatteryData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_BATTERY);
    }

    public StepOSBatteryData(int batteryLevel, String chargeState, String chargeType, float batteryTemperature, int batteryHealth, int remainingBatteryDuration, boolean isLowPowerModeEnabled) {
        this();
        this.mBatteryLevel = batteryLevel;
        this.mChargeState = chargeState;
        this.mChargeType = chargeType;
        this.mBatteryTemperature = batteryTemperature;
        this.mBatteryHealth = batteryHealth;
        this.mRemainingBatteryDuration = remainingBatteryDuration;
        this.mIsLowPowerModeEnabled = isLowPowerModeEnabled;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("battery_level", new IntSupplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda0
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofString("charge_state", new Supplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofString("charge_type", new Supplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofFloat("battery_temperature", new Supplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Float) obj);
            }
        }), Field.ofInt("battery_health", new IntSupplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofInt("remaining_battery_duration", new IntSupplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofBool("is_low_power_mode_enabled", new BooleanSupplier() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda3
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSBatteryData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((Boolean) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mBatteryLevel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mBatteryLevel = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mChargeState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mChargeState = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mChargeType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mChargeType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Float lambda$fields$6() {
        return Float.valueOf(this.mBatteryTemperature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Float v) {
        this.mBatteryTemperature = v.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mBatteryHealth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mBatteryHealth = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mRemainingBatteryDuration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mRemainingBatteryDuration = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$12() {
        return this.mIsLowPowerModeEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(Boolean v) {
        this.mIsLowPowerModeEnabled = v.booleanValue();
    }

    static /* synthetic */ StepOSBatteryData[] lambda$static$14(int x$0) {
        return new StepOSBatteryData[x$0];
    }
}
