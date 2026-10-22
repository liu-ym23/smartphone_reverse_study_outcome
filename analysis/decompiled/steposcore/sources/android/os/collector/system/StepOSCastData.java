package android.os.collector.system;

import android.os.Parcelable;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSCastData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSCastData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSCastData$$ExternalSyntheticLambda4
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSCastData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSCastData$$ExternalSyntheticLambda5
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSCastData.lambda$static$4(i);
        }
    });
    public boolean mIsCasting;
    public String mName;

    public StepOSCastData() {
        super(1, 9);
    }

    public StepOSCastData(boolean isCasting, String name) {
        this();
        this.mIsCasting = isCasting;
        this.mName = name;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofBool("is_casting", new BooleanSupplier() { // from class: android.os.collector.system.StepOSCastData$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSCastData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((Boolean) obj);
            }
        }), Field.ofString("name", new Supplier() { // from class: android.os.collector.system.StepOSCastData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSCastData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$0() {
        return this.mIsCasting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(Boolean v) {
        this.mIsCasting = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mName = v;
    }

    static /* synthetic */ StepOSCastData[] lambda$static$4(int x$0) {
        return new StepOSCastData[x$0];
    }
}
