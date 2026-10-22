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
public final class StepOSCameraData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSCameraData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSCameraData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSCameraData.lambda$static$6(i);
        }
    });
    public String mCameraId;
    public String mPackageName;
    public int mStatus;

    public StepOSCameraData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_CAMERA);
    }

    public StepOSCameraData(String cameraId, int status, String packageName) {
        this();
        this.mCameraId = cameraId;
        this.mStatus = status;
        this.mPackageName = packageName;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("camera_id", new Supplier() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("status", new IntSupplier() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofString("package_name", new Supplier() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSCameraData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mCameraId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mCameraId = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mStatus = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mPackageName = v;
    }

    static /* synthetic */ StepOSCameraData[] lambda$static$6(int x$0) {
        return new StepOSCameraData[x$0];
    }
}
