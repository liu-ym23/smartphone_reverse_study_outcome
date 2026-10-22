package android.os.collector.sensor;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSSensorData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSSensorData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda16
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSSensorData();
        }
    }, new IntFunction() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda17
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSSensorData.lambda$static$16(i);
        }
    });
    public int mAccuracy;
    public int mDataId;
    public boolean mIsActive;
    public float[] mRawValues;
    public int mSampleRate;
    public String mSensorType;
    public String mSensorVersion;
    public long mTs;

    public StepOSSensorData() {
        super(4, StepOSCollectAtomID.SENSOR_DOMAIN_TAG_SENSOR);
    }

    public StepOSSensorData(int dataId, String sensorType, String sensorVersion, long ts, int accuracy, int sampleRate, boolean isActive, float[] rawValues) {
        this();
        this.mDataId = dataId;
        this.mSensorType = sensorType;
        this.mSensorVersion = sensorVersion;
        this.mTs = ts;
        this.mAccuracy = accuracy;
        this.mSampleRate = sampleRate;
        this.mIsActive = isActive;
        this.mRawValues = rawValues;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("data_id", new IntSupplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda0
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofString("sensor_type", new Supplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofString("sensor_version", new Supplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofLong("ts", new LongSupplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda12
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda13
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofInt("accuracy", new IntSupplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofInt("sample_rate", new IntSupplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofBool("is_active", new BooleanSupplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda3
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((Boolean) obj);
            }
        }), Field.ofFloatArray("raw_values", new Supplier() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.sensor.StepOSSensorData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((float[]) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mDataId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mDataId = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mSensorType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mSensorType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mSensorVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mSensorVersion = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mTs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mTs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mAccuracy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mAccuracy = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mSampleRate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mSampleRate = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$12() {
        return this.mIsActive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(Boolean v) {
        this.mIsActive = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ float[] lambda$fields$14() {
        return this.mRawValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(float[] v) {
        this.mRawValues = v;
    }

    static /* synthetic */ StepOSSensorData[] lambda$static$16(int x$0) {
        return new StepOSSensorData[x$0];
    }
}
