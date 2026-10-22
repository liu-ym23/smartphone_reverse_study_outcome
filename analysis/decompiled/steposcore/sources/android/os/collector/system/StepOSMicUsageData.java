package android.os.collector.system;

import android.os.Parcelable;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSMicUsageData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSMicUsageData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda8
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSMicUsageData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda9
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSMicUsageData.lambda$static$8(i);
        }
    });
    public int mAudioSource;
    public int mEvent;
    public boolean mIsSilenced;
    public String mPackageName;

    public StepOSMicUsageData() {
        super(1, 17);
    }

    public StepOSMicUsageData(String packageName, int event, int audioSource, boolean isSilenced) {
        this();
        this.mPackageName = packageName;
        this.mEvent = event;
        this.mAudioSource = audioSource;
        this.mIsSilenced = isSilenced;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("event", new IntSupplier() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("audio_source", new IntSupplier() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofBool("is_silenced", new BooleanSupplier() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda6
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSMicUsageData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Boolean) obj);
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
        return this.mEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mEvent = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mAudioSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mAudioSource = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mIsSilenced;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mIsSilenced = v.booleanValue();
    }

    static /* synthetic */ StepOSMicUsageData[] lambda$static$8(int x$0) {
        return new StepOSMicUsageData[x$0];
    }
}
