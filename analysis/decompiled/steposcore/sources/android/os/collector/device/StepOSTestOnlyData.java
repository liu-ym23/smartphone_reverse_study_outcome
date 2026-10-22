package android.os.collector.device;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;

/* loaded from: classes.dex */
public final class StepOSTestOnlyData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSTestOnlyData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSTestOnlyData$$ExternalSyntheticLambda2
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSTestOnlyData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSTestOnlyData$$ExternalSyntheticLambda3
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSTestOnlyData.lambda$static$2(i);
        }
    });
    public int mDummy;

    public StepOSTestOnlyData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_TEST_ONLY);
    }

    public StepOSTestOnlyData(int dummy) {
        this();
        this.mDummy = dummy;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("dummy", new IntSupplier() { // from class: android.os.collector.device.StepOSTestOnlyData$$ExternalSyntheticLambda0
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSTestOnlyData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mDummy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mDummy = v;
    }

    static /* synthetic */ StepOSTestOnlyData[] lambda$static$2(int x$0) {
        return new StepOSTestOnlyData[x$0];
    }
}
