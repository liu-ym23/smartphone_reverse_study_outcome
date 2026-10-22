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

/* loaded from: classes.dex */
public final class StepOSWifiApData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSWifiApData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSWifiApData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSWifiApData.lambda$static$10(i);
        }
    });
    public int mFailureReason;
    public boolean mIsHotspotSupported;
    public int mNumConnectedDevices;
    public int mState;
    public boolean mWaitingForTerminalState;

    public StepOSWifiApData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_WIFI_AP);
    }

    public StepOSWifiApData(int state, boolean isHotspotSupported, boolean waitingForTerminalState, int numConnectedDevices, int failureReason) {
        this();
        this.mState = state;
        this.mIsHotspotSupported = isHotspotSupported;
        this.mWaitingForTerminalState = waitingForTerminalState;
        this.mNumConnectedDevices = numConnectedDevices;
        this.mFailureReason = failureReason;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("state", new IntSupplier() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofBool("is_hotspot_supported", new BooleanSupplier() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda4
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((Boolean) obj);
            }
        }), Field.ofBool("waiting_for_terminal_state", new BooleanSupplier() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda6
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((Boolean) obj);
            }
        }), Field.ofInt("num_connected_devices", new IntSupplier() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda8
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofInt("failure_reason", new IntSupplier() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSWifiApData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mState = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$2() {
        return this.mIsHotspotSupported;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(Boolean v) {
        this.mIsHotspotSupported = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$4() {
        return this.mWaitingForTerminalState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(Boolean v) {
        this.mWaitingForTerminalState = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mNumConnectedDevices;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mNumConnectedDevices = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mFailureReason;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mFailureReason = v;
    }

    static /* synthetic */ StepOSWifiApData[] lambda$static$10(int x$0) {
        return new StepOSWifiApData[x$0];
    }
}
