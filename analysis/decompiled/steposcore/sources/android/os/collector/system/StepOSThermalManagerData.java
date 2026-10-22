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
public final class StepOSThermalManagerData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSThermalManagerData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSThermalManagerData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSThermalManagerData.lambda$static$10(i);
        }
    });
    public int mMaxTemperatureMc;
    public int mTemperatureMc;
    public String mThermalState;
    public long mTimestampMs;
    public String mZoneName;

    public StepOSThermalManagerData() {
        super(1, 7);
    }

    public StepOSThermalManagerData(long timestampMs, String zoneName, int temperatureMc, int maxTemperatureMc, String thermalState) {
        this();
        this.mTimestampMs = timestampMs;
        this.mZoneName = zoneName;
        this.mTemperatureMc = temperatureMc;
        this.mMaxTemperatureMc = maxTemperatureMc;
        this.mThermalState = thermalState;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$0();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$1(j);
            }
        }), Field.ofString("zone_name", new Supplier() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofInt("temperature_mc", new IntSupplier() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofInt("max_temperature_mc", new IntSupplier() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda8
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofString("thermal_state", new Supplier() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSThermalManagerData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$0() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(long v) {
        this.mTimestampMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mZoneName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mZoneName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mTemperatureMc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mTemperatureMc = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mMaxTemperatureMc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mMaxTemperatureMc = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$8() {
        return this.mThermalState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(String v) {
        this.mThermalState = v;
    }

    static /* synthetic */ StepOSThermalManagerData[] lambda$static$10(int x$0) {
        return new StepOSThermalManagerData[x$0];
    }
}
