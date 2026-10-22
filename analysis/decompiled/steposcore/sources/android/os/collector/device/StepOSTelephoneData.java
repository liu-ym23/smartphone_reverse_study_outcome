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
public final class StepOSTelephoneData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSTelephoneData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSTelephoneData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSTelephoneData.lambda$static$16(i);
        }
    });
    public String mCallState;
    public String mCarrierName;
    public boolean mIsAirplaneModeOn;
    public boolean mIsDataConnected;
    public boolean mIsRoaming;
    public String mNetworkType;
    public int mSignalStrength;
    public String mSimState;

    public StepOSTelephoneData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_TELEPHONE);
    }

    public StepOSTelephoneData(String networkType, String simState, String carrierName, int signalStrength, boolean isRoaming, boolean isDataConnected, boolean isAirplaneModeOn, String callState) {
        this();
        this.mNetworkType = networkType;
        this.mSimState = simState;
        this.mCarrierName = carrierName;
        this.mSignalStrength = signalStrength;
        this.mIsRoaming = isRoaming;
        this.mIsDataConnected = isDataConnected;
        this.mIsAirplaneModeOn = isAirplaneModeOn;
        this.mCallState = callState;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("network_type", new Supplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofString("sim_state", new Supplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofString("carrier_name", new Supplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofInt("signal_strength", new IntSupplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofBool("is_roaming", new BooleanSupplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda16
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Boolean) obj);
            }
        }), Field.ofBool("is_data_connected", new BooleanSupplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda3
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((Boolean) obj);
            }
        }), Field.ofBool("is_airplane_mode_on", new BooleanSupplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda5
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((Boolean) obj);
            }
        }), Field.ofString("call_state", new Supplier() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSTelephoneData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mNetworkType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mNetworkType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mSimState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mSimState = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mCarrierName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mCarrierName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mSignalStrength;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mSignalStrength = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$8() {
        return this.mIsRoaming;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Boolean v) {
        this.mIsRoaming = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$10() {
        return this.mIsDataConnected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(Boolean v) {
        this.mIsDataConnected = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$12() {
        return this.mIsAirplaneModeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(Boolean v) {
        this.mIsAirplaneModeOn = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$14() {
        return this.mCallState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(String v) {
        this.mCallState = v;
    }

    static /* synthetic */ StepOSTelephoneData[] lambda$static$16(int x$0) {
        return new StepOSTelephoneData[x$0];
    }
}
