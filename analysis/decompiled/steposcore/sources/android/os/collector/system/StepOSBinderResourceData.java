package android.os.collector.system;

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
public final class StepOSBinderResourceData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSBinderResourceData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSBinderResourceData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSBinderResourceData.lambda$static$10(i);
        }
    });
    public int mCurrentBinderThreadCount;
    public int mFailedTransactionCount;
    public int mMaxBinderThreadLimit;
    public float mTransactionAverageLatency;
    public int mTransactionCount;

    public StepOSBinderResourceData() {
        super(1, StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_BINDER_RESOURCE);
    }

    public StepOSBinderResourceData(int transactionCount, int failedTransactionCount, int currentBinderThreadCount, float transactionAverageLatency, int maxBinderThreadLimit) {
        this();
        this.mTransactionCount = transactionCount;
        this.mFailedTransactionCount = failedTransactionCount;
        this.mCurrentBinderThreadCount = currentBinderThreadCount;
        this.mTransactionAverageLatency = transactionAverageLatency;
        this.mMaxBinderThreadLimit = maxBinderThreadLimit;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("transaction_count", new IntSupplier() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofInt("failed_transaction_count", new IntSupplier() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("current_binder_thread_count", new IntSupplier() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofFloat("transaction_average_latency", new Supplier() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Float) obj);
            }
        }), Field.ofInt("max_binder_thread_limit", new IntSupplier() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSBinderResourceData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mTransactionCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mTransactionCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mFailedTransactionCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mFailedTransactionCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mCurrentBinderThreadCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mCurrentBinderThreadCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Float lambda$fields$6() {
        return Float.valueOf(this.mTransactionAverageLatency);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Float v) {
        this.mTransactionAverageLatency = v.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mMaxBinderThreadLimit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mMaxBinderThreadLimit = v;
    }

    static /* synthetic */ StepOSBinderResourceData[] lambda$static$10(int x$0) {
        return new StepOSBinderResourceData[x$0];
    }
}
