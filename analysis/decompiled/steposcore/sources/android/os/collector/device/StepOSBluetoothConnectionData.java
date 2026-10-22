package android.os.collector.device;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSBluetoothConnectionData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSBluetoothConnectionData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSBluetoothConnectionData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSBluetoothConnectionData.lambda$static$8(i);
        }
    });
    public int mDeviceClass;
    public String mDeviceName;
    public int mEvent;
    public int mProfile;

    public StepOSBluetoothConnectionData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_BLUETOOTH_CONNECTION);
    }

    public StepOSBluetoothConnectionData(String deviceName, int deviceClass, int profile, int event) {
        this();
        this.mDeviceName = deviceName;
        this.mDeviceClass = deviceClass;
        this.mProfile = profile;
        this.mEvent = event;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("device_name", new Supplier() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("device_class", new IntSupplier() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("profile", new IntSupplier() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofInt("event", new IntSupplier() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda8
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSBluetoothConnectionData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mDeviceName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mDeviceName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mDeviceClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mDeviceClass = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mProfile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mProfile = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mEvent = v;
    }

    static /* synthetic */ StepOSBluetoothConnectionData[] lambda$static$8(int x$0) {
        return new StepOSBluetoothConnectionData[x$0];
    }
}
