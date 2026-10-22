package android.os.collector.user;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSAppUsageStateData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSAppUsageStateData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSAppUsageStateData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSAppUsageStateData.lambda$static$12(i);
        }
    });
    public long mLastUsedMs;
    public int mLaunchCount;
    public String mPackageName;
    public int mPkgType;
    public long mTotalDurationMs;
    public String mWindowType;

    public StepOSAppUsageStateData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_APP_USAGE_STATE);
    }

    public StepOSAppUsageStateData(String packageName, int pkgType, long totalDurationMs, long lastUsedMs, int launchCount, String windowType) {
        this();
        this.mPackageName = packageName;
        this.mPkgType = pkgType;
        this.mTotalDurationMs = totalDurationMs;
        this.mLastUsedMs = lastUsedMs;
        this.mLaunchCount = launchCount;
        this.mWindowType = windowType;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("pkg_type", new IntSupplier() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofLong("total_duration_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda8
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        }), Field.ofLong("last_used_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda10
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda11
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofInt("launch_count", new IntSupplier() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofString("window_type", new Supplier() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSAppUsageStateData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((String) obj);
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
        return this.mPkgType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mPkgType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mTotalDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mTotalDurationMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mLastUsedMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mLastUsedMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mLaunchCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mLaunchCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$10() {
        return this.mWindowType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(String v) {
        this.mWindowType = v;
    }

    static /* synthetic */ StepOSAppUsageStateData[] lambda$static$12(int x$0) {
        return new StepOSAppUsageStateData[x$0];
    }
}
