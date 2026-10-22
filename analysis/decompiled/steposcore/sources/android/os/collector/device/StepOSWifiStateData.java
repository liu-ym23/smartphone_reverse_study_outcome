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
public final class StepOSWifiStateData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSWifiStateData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda12
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSWifiStateData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda13
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSWifiStateData.lambda$static$12(i);
        }
    });
    public String mBssid;
    public boolean mConnected;
    public boolean mIsDefaultNetwork;
    public String mSsid;
    public long mTimestampMs;
    public boolean mWifiEnabled;

    public StepOSWifiStateData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_WIFI_STATE);
    }

    public StepOSWifiStateData(boolean wifiEnabled, boolean connected, String ssid, boolean isDefaultNetwork, long timestampMs, String bssid) {
        this();
        this.mWifiEnabled = wifiEnabled;
        this.mConnected = connected;
        this.mSsid = ssid;
        this.mIsDefaultNetwork = isDefaultNetwork;
        this.mTimestampMs = timestampMs;
        this.mBssid = bssid;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofBool("wifi_enabled", new BooleanSupplier() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((Boolean) obj);
            }
        }), Field.ofBool("connected", new BooleanSupplier() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda4
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((Boolean) obj);
            }
        }), Field.ofString("ssid", new Supplier() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofBool("is_default_network", new BooleanSupplier() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda8
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Boolean) obj);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda10
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda11
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
            }
        }), Field.ofString("bssid", new Supplier() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSWifiStateData$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$0() {
        return this.mWifiEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(Boolean v) {
        this.mWifiEnabled = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$2() {
        return this.mConnected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(Boolean v) {
        this.mConnected = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mSsid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mSsid = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mIsDefaultNetwork;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mIsDefaultNetwork = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mTimestampMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$10() {
        return this.mBssid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(String v) {
        this.mBssid = v;
    }

    static /* synthetic */ StepOSWifiStateData[] lambda$static$12(int x$0) {
        return new StepOSWifiStateData[x$0];
    }
}
