package android.os.collector.device;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSLocationServiceData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSLocationServiceData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSLocationServiceData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSLocationServiceData.lambda$static$18(i);
        }
    });
    public float mAccuracyM;
    public boolean mIsGpsEnabled;
    public boolean mIsLocationEnabled;
    public boolean mIsNetworkLocationEnabled;
    public double mLatitude;
    public String mLocationMode;
    public String mLocationProvider;
    public long mLocationTimeMs;
    public double mLongitude;

    public StepOSLocationServiceData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_LOCATION_SERVICE);
    }

    public StepOSLocationServiceData(boolean isLocationEnabled, String locationMode, boolean isGpsEnabled, boolean isNetworkLocationEnabled, double latitude, double longitude, float accuracyM, String locationProvider, long locationTimeMs) {
        this();
        this.mIsLocationEnabled = isLocationEnabled;
        this.mLocationMode = locationMode;
        this.mIsGpsEnabled = isGpsEnabled;
        this.mIsNetworkLocationEnabled = isNetworkLocationEnabled;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mAccuracyM = accuracyM;
        this.mLocationProvider = locationProvider;
        this.mLocationTimeMs = locationTimeMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofBool("is_location_enabled", new BooleanSupplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda2
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((Boolean) obj);
            }
        }), Field.ofString("location_mode", new Supplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofBool("is_gps_enabled", new BooleanSupplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda14
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((Boolean) obj);
            }
        }), Field.ofBool("is_network_location_enabled", new BooleanSupplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda16
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Boolean) obj);
            }
        }), Field.ofDouble("latitude", new Supplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda18
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda19
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Double) obj);
            }
        }), Field.ofDouble("longitude", new Supplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((Double) obj);
            }
        }), Field.ofFloat("accuracy_m", new Supplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((Float) obj);
            }
        }), Field.ofString("location_provider", new Supplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((String) obj);
            }
        }), Field.ofLong("location_time_ms", new LongSupplier() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$16();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSLocationServiceData$$ExternalSyntheticLambda10
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$17(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$0() {
        return this.mIsLocationEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(Boolean v) {
        this.mIsLocationEnabled = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mLocationMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mLocationMode = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$4() {
        return this.mIsGpsEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(Boolean v) {
        this.mIsGpsEnabled = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mIsNetworkLocationEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mIsNetworkLocationEnabled = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$fields$8() {
        return Double.valueOf(this.mLatitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Double v) {
        this.mLatitude = v.doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$fields$10() {
        return Double.valueOf(this.mLongitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(Double v) {
        this.mLongitude = v.doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Float lambda$fields$12() {
        return Float.valueOf(this.mAccuracyM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(Float v) {
        this.mAccuracyM = v.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$14() {
        return this.mLocationProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(String v) {
        this.mLocationProvider = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$16() {
        return this.mLocationTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(long v) {
        this.mLocationTimeMs = v;
    }

    static /* synthetic */ StepOSLocationServiceData[] lambda$static$18(int x$0) {
        return new StepOSLocationServiceData[x$0];
    }
}
