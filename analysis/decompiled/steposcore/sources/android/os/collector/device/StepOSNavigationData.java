package android.os.collector.device;

import android.media.alwayson.AlwaysOnVoiceManager;
import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSNavigationData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSNavigationData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSNavigationData();
        }
    }, new IntFunction() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSNavigationData.lambda$static$10(i);
        }
    });
    public boolean mActive;
    public boolean mIsForeground;
    public boolean mIsMockLocation;
    public String mPackageName;
    public int mUid;

    public StepOSNavigationData() {
        super(0, StepOSCollectAtomID.DEVICE_DOMAIN_TAG_NAVIGATION);
    }

    public StepOSNavigationData(String packageName, int uid, boolean active, boolean isForeground, boolean isMockLocation) {
        this();
        this.mPackageName = packageName;
        this.mUid = uid;
        this.mActive = active;
        this.mIsForeground = isForeground;
        this.mIsMockLocation = isMockLocation;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("uid", new IntSupplier() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofBool(AlwaysOnVoiceManager.SCENE_SUBTAG_ACTIVE, new BooleanSupplier() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda6
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((Boolean) obj);
            }
        }), Field.ofBool("is_foreground", new BooleanSupplier() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda8
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Boolean) obj);
            }
        }), Field.ofBool("is_mock_location", new BooleanSupplier() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda10
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.device.StepOSNavigationData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Boolean) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mPackageName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mUid = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$4() {
        return this.mActive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(Boolean v) {
        this.mActive = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mIsForeground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mIsForeground = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$8() {
        return this.mIsMockLocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Boolean v) {
        this.mIsMockLocation = v.booleanValue();
    }

    static /* synthetic */ StepOSNavigationData[] lambda$static$10(int x$0) {
        return new StepOSNavigationData[x$0];
    }
}
