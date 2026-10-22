package android.os.collector.system;

import android.os.Parcelable;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSWakeLockData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSWakeLockData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSWakeLockData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSWakeLockData.lambda$static$6(i);
        }
    });
    public long mHoldDuration;
    public String mHolderPackageName;
    public String mWakeLockType;

    public StepOSWakeLockData() {
        super(1, 4);
    }

    public StepOSWakeLockData(String holderPackageName, String wakeLockType, long holdDuration) {
        this();
        this.mHolderPackageName = holderPackageName;
        this.mWakeLockType = wakeLockType;
        this.mHoldDuration = holdDuration;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("holder_package_name", new Supplier() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofString("wake_lock_type", new Supplier() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofLong("hold_duration", new LongSupplier() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSWakeLockData$$ExternalSyntheticLambda7
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mHolderPackageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mHolderPackageName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mWakeLockType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mWakeLockType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mHoldDuration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mHoldDuration = v;
    }

    static /* synthetic */ StepOSWakeLockData[] lambda$static$6(int x$0) {
        return new StepOSWakeLockData[x$0];
    }
}
