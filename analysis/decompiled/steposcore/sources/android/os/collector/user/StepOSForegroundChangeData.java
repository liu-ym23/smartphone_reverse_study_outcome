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
public final class StepOSForegroundChangeData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSForegroundChangeData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda10
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSForegroundChangeData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda11
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSForegroundChangeData.lambda$static$10(i);
        }
    });
    public long mEnterTimeMs;
    public String mPackageName;
    public long mPrevDurationMs;
    public String mPrevPackageName;
    public int mUid;

    public StepOSForegroundChangeData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_FOREGROUND_CHANGE);
    }

    public StepOSForegroundChangeData(String packageName, int uid, String prevPackageName, long enterTimeMs, long prevDurationMs) {
        this();
        this.mPackageName = packageName;
        this.mUid = uid;
        this.mPrevPackageName = prevPackageName;
        this.mEnterTimeMs = enterTimeMs;
        this.mPrevDurationMs = prevDurationMs;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("uid", new IntSupplier() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofString("prev_package_name", new Supplier() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofLong("enter_time_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda7
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofLong("prev_duration_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda8
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSForegroundChangeData$$ExternalSyntheticLambda9
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
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
    public /* synthetic */ String lambda$fields$4() {
        return this.mPrevPackageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mPrevPackageName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mEnterTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mEnterTimeMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mPrevDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mPrevDurationMs = v;
    }

    static /* synthetic */ StepOSForegroundChangeData[] lambda$static$10(int x$0) {
        return new StepOSForegroundChangeData[x$0];
    }
}
