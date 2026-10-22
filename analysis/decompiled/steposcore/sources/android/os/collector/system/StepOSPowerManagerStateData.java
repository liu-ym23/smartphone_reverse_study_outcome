package android.os.collector.system;

import android.os.Parcelable;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSPowerManagerStateData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSPowerManagerStateData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda14
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSPowerManagerStateData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda15
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSPowerManagerStateData.lambda$static$14(i);
        }
    });
    public String mBackgroundWakeRestriction;
    public String mDozeModeType;
    public long mDozeRemainTime;
    public boolean mIsAppStandbyBucketsEnabled;
    public boolean mIsInAppStandby;
    public boolean mIsInDozeMode;
    public boolean mIsScreenOn;

    public StepOSPowerManagerStateData() {
        super(1, 6);
    }

    public StepOSPowerManagerStateData(boolean isInDozeMode, boolean isInAppStandby, String dozeModeType, long dozeRemainTime, String backgroundWakeRestriction, boolean isAppStandbyBucketsEnabled, boolean isScreenOn) {
        this();
        this.mIsInDozeMode = isInDozeMode;
        this.mIsInAppStandby = isInAppStandby;
        this.mDozeModeType = dozeModeType;
        this.mDozeRemainTime = dozeRemainTime;
        this.mBackgroundWakeRestriction = backgroundWakeRestriction;
        this.mIsAppStandbyBucketsEnabled = isAppStandbyBucketsEnabled;
        this.mIsScreenOn = isScreenOn;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofBool("is_in_doze_mode", new BooleanSupplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((Boolean) obj);
            }
        }), Field.ofBool("is_in_app_standby", new BooleanSupplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda6
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((Boolean) obj);
            }
        }), Field.ofString("doze_mode_type", new Supplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofLong("doze_remain_time", new LongSupplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda10
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda11
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofString("background_wake_restriction", new Supplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((String) obj);
            }
        }), Field.ofBool("is_app_standby_buckets_enabled", new BooleanSupplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda1
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((Boolean) obj);
            }
        }), Field.ofBool("is_screen_on", new BooleanSupplier() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda3
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSPowerManagerStateData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((Boolean) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$0() {
        return this.mIsInDozeMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(Boolean v) {
        this.mIsInDozeMode = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$2() {
        return this.mIsInAppStandby;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(Boolean v) {
        this.mIsInAppStandby = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mDozeModeType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mDozeModeType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mDozeRemainTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mDozeRemainTime = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$8() {
        return this.mBackgroundWakeRestriction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(String v) {
        this.mBackgroundWakeRestriction = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$10() {
        return this.mIsAppStandbyBucketsEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(Boolean v) {
        this.mIsAppStandbyBucketsEnabled = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$12() {
        return this.mIsScreenOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(Boolean v) {
        this.mIsScreenOn = v.booleanValue();
    }

    static /* synthetic */ StepOSPowerManagerStateData[] lambda$static$14(int x$0) {
        return new StepOSPowerManagerStateData[x$0];
    }
}
