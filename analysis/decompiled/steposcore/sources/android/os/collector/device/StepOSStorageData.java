package android.os.collector.device;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
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
public final class StepOSStorageData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSStorageData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSStorageData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSStorageData.lambda$static$14(i);
        }
    });
    public long mAppAvailableStorage;
    public long mExternalAvailableStorage;
    public String mExternalStorageMountState;
    public long mExternalTotalStorage;
    public long mInternalAvailableStorage;
    public int mInternalStorageUsageRate;
    public long mInternalTotalStorage;

    public StepOSStorageData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_STORAGE);
    }

    public StepOSStorageData(long internalTotalStorage, long internalAvailableStorage, int internalStorageUsageRate, long externalTotalStorage, long externalAvailableStorage, String externalStorageMountState, long appAvailableStorage) {
        this();
        this.mInternalTotalStorage = internalTotalStorage;
        this.mInternalAvailableStorage = internalAvailableStorage;
        this.mInternalStorageUsageRate = internalStorageUsageRate;
        this.mExternalTotalStorage = externalTotalStorage;
        this.mExternalAvailableStorage = externalAvailableStorage;
        this.mExternalStorageMountState = externalStorageMountState;
        this.mAppAvailableStorage = appAvailableStorage;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofLong("internal_total_storage", new LongSupplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$0();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda7
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$1(j);
            }
        }), Field.ofLong("internal_available_storage", new LongSupplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda8
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$2();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$3(j);
            }
        }), Field.ofInt("internal_storage_usage_rate", new IntSupplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofLong("external_total_storage", new LongSupplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda12
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda13
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofLong("external_available_storage", new LongSupplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda14
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda15
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
            }
        }), Field.ofString("external_storage_mount_state", new Supplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((String) obj);
            }
        }), Field.ofLong("app_available_storage", new LongSupplier() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$12();
            }
        }, new LongConsumer() { // from class: android.os.collector.device.StepOSStorageData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$13(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$0() {
        return this.mInternalTotalStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(long v) {
        this.mInternalTotalStorage = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$2() {
        return this.mInternalAvailableStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(long v) {
        this.mInternalAvailableStorage = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mInternalStorageUsageRate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mInternalStorageUsageRate = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mExternalTotalStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mExternalTotalStorage = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mExternalAvailableStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mExternalAvailableStorage = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$10() {
        return this.mExternalStorageMountState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(String v) {
        this.mExternalStorageMountState = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$12() {
        return this.mAppAvailableStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(long v) {
        this.mAppAvailableStorage = v;
    }

    static /* synthetic */ StepOSStorageData[] lambda$static$14(int x$0) {
        return new StepOSStorageData[x$0];
    }
}
