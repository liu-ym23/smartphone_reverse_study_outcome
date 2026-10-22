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
public final class StepOSForegroundAppStateData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSForegroundAppStateData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSForegroundAppStateData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSForegroundAppStateData.lambda$static$8(i);
        }
    });
    public int mAppType;
    public boolean mEnterForeground;
    public boolean mIsTopApp;
    public String mPackageName;

    public StepOSForegroundAppStateData() {
        super(1, 14);
    }

    public StepOSForegroundAppStateData(String packageName, boolean enterForeground, int appType, boolean isTopApp) {
        this();
        this.mPackageName = packageName;
        this.mEnterForeground = enterForeground;
        this.mAppType = appType;
        this.mIsTopApp = isTopApp;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofBool("enter_foreground", new BooleanSupplier() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda4
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((Boolean) obj);
            }
        }), Field.ofInt("app_type", new IntSupplier() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofBool("is_top_app", new BooleanSupplier() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda8
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSForegroundAppStateData$$ExternalSyntheticLambda9
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
    public /* synthetic */ boolean lambda$fields$2() {
        return this.mEnterForeground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(Boolean v) {
        this.mEnterForeground = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mAppType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mAppType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mIsTopApp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mIsTopApp = v.booleanValue();
    }

    static /* synthetic */ StepOSForegroundAppStateData[] lambda$static$8(int x$0) {
        return new StepOSForegroundAppStateData[x$0];
    }
}
