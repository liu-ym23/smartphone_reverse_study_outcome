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
public final class StepOSInputCommitData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSInputCommitData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSInputCommitData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSInputCommitData.lambda$static$18(i);
        }
    });
    public int mFullTextLength;
    public String mHint;
    public int mInputType;
    public boolean mIsPaste;
    public String mPackageName;
    public String mSegmentHead;
    public int mSegmentLength;
    public long mTimestampMs;
    public int mUid;

    public StepOSInputCommitData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_INPUT_COMMIT);
    }

    public StepOSInputCommitData(String packageName, int uid, int inputType, long timestampMs, int segmentLength, int fullTextLength, String segmentHead, boolean isPaste, String hint) {
        this();
        this.mPackageName = packageName;
        this.mUid = uid;
        this.mInputType = inputType;
        this.mTimestampMs = timestampMs;
        this.mSegmentLength = segmentLength;
        this.mFullTextLength = fullTextLength;
        this.mSegmentHead = segmentHead;
        this.mIsPaste = isPaste;
        this.mHint = hint;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("uid", new IntSupplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofInt("input_type", new IntSupplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofLong("timestamp_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda16
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda17
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofInt("segment_length", new IntSupplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda18
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda19
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofInt("full_text_length", new IntSupplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofString("segment_head", new Supplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((String) obj);
            }
        }), Field.ofBool("is_paste", new BooleanSupplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda7
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((Boolean) obj);
            }
        }), Field.ofString("hint", new Supplier() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$16();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSInputCommitData$$ExternalSyntheticLambda10
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$17((String) obj);
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
        return this.mInputType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mInputType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mTimestampMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mTimestampMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mSegmentLength;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mSegmentLength = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mFullTextLength;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mFullTextLength = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$12() {
        return this.mSegmentHead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(String v) {
        this.mSegmentHead = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$14() {
        return this.mIsPaste;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(Boolean v) {
        this.mIsPaste = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$16() {
        return this.mHint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(String v) {
        this.mHint = v;
    }

    static /* synthetic */ StepOSInputCommitData[] lambda$static$18(int x$0) {
        return new StepOSInputCommitData[x$0];
    }
}
