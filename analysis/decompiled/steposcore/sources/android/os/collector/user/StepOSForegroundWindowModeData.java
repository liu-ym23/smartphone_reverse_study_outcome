package android.os.collector.user;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSForegroundWindowModeData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSForegroundWindowModeData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda12
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSForegroundWindowModeData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda13
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSForegroundWindowModeData.lambda$static$12(i);
        }
    });
    public int mActivityType;
    public int mAppType;
    public boolean mFocusable;
    public String mPackageName;
    public long mTimestampMs;
    public int mUid;

    public StepOSForegroundWindowModeData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_FOREGROUND_WINDOW_MODE);
    }

    public StepOSForegroundWindowModeData(String packageName, int uid, int appType, int activityType, boolean focusable, long timestampMs) {
        this();
        this.mPackageName = packageName;
        this.mUid = uid;
        this.mAppType = appType;
        this.mActivityType = activityType;
        this.mFocusable = focusable;
        this.mTimestampMs = timestampMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("uid", new IntSupplier() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("app_type", new IntSupplier() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofInt("activity_type", new IntSupplier() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda8
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofBool("focusable", new BooleanSupplier() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda10
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Boolean) obj);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda1
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$10();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSForegroundWindowModeData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$11(j);
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
    public /* synthetic */ int lambda$fields$4() {
        return this.mAppType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mAppType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mActivityType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mActivityType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$8() {
        return this.mFocusable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Boolean v) {
        this.mFocusable = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$10() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(long v) {
        this.mTimestampMs = v;
    }

    static /* synthetic */ StepOSForegroundWindowModeData[] lambda$static$12(int x$0) {
        return new StepOSForegroundWindowModeData[x$0];
    }
}
