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
public final class StepOSCameraLightData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSCameraLightData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSCameraLightData$$ExternalSyntheticLambda4
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSCameraLightData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSCameraLightData$$ExternalSyntheticLambda5
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSCameraLightData.lambda$static$4(i);
        }
    });
    public String mCameraId;
    public int mLightStatus;

    public StepOSCameraLightData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_CAMERA_LIGHT);
    }

    public StepOSCameraLightData(String cameraId, int lightStatus) {
        this();
        this.mCameraId = cameraId;
        this.mLightStatus = lightStatus;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("camera_id", new Supplier() { // from class: android.os.collector.device.StepOSCameraLightData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSCameraLightData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("light_status", new IntSupplier() { // from class: android.os.collector.device.StepOSCameraLightData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSCameraLightData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
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
        return this.mLightStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mLightStatus = v;
    }

    static /* synthetic */ StepOSCameraLightData[] lambda$static$4(int x$0) {
        return new StepOSCameraLightData[x$0];
    }
}
