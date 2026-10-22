package android.os.collector.scene;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;

/* loaded from: classes.dex */
public final class StepOSSceneData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSSceneData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.scene.StepOSSceneData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSSceneData();
        }
    }, new IntFunction() { // from class: android.os.collector.scene.StepOSSceneData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSSceneData.lambda$static$4(i);
        }
    });
    public int mSceneId;
    public int mStatus;

    public StepOSSceneData() {
        super(5, StepOSCollectAtomID.SCENE_DOMAIN_TAG_SCENE);
    }

    public StepOSSceneData(int status, int sceneId) {
        this();
        this.mStatus = status;
        this.mSceneId = sceneId;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("status", new IntSupplier() { // from class: android.os.collector.scene.StepOSSceneData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.scene.StepOSSceneData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofInt("scene_id", new IntSupplier() { // from class: android.os.collector.scene.StepOSSceneData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.scene.StepOSSceneData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mStatus = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mSceneId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mSceneId = v;
    }

    static /* synthetic */ StepOSSceneData[] lambda$static$4(int x$0) {
        return new StepOSSceneData[x$0];
    }
}
