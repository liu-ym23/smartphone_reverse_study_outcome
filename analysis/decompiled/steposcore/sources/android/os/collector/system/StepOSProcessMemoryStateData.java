package android.os.collector.system;

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
public final class StepOSProcessMemoryStateData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSProcessMemoryStateData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda16
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSProcessMemoryStateData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda17
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSProcessMemoryStateData.lambda$static$16(i);
        }
    });
    public long mCacheInBytes;
    public int mOomScore;
    public long mPageFault;
    public long mPageMajorFault;
    public String mProcessName;
    public long mRssInBytes;
    public long mSwapInBytes;
    public int mUid;

    public StepOSProcessMemoryStateData() {
        super(1, StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_PROCESS_MEMORY_STATE);
    }

    public StepOSProcessMemoryStateData(int uid, String processName, int oomScore, long pageFault, long pageMajorFault, long rssInBytes, long cacheInBytes, long swapInBytes) {
        this();
        this.mUid = uid;
        this.mProcessName = processName;
        this.mOomScore = oomScore;
        this.mPageFault = pageFault;
        this.mPageMajorFault = pageMajorFault;
        this.mRssInBytes = rssInBytes;
        this.mCacheInBytes = cacheInBytes;
        this.mSwapInBytes = swapInBytes;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("uid", new IntSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda0
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofString("process_name", new Supplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofInt("oom_score", new IntSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofLong("page_fault", new LongSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda12
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda13
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofLong("page_major_fault", new LongSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda14
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$8();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda15
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$9(j);
            }
        }), Field.ofLong("rss_in_bytes", new LongSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda1
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$10();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda2
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$11(j);
            }
        }), Field.ofLong("cache_in_bytes", new LongSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda3
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$12();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda4
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$13(j);
            }
        }), Field.ofLong("swap_in_bytes", new LongSupplier() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$14();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSProcessMemoryStateData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$15(j);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mUid = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mProcessName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mProcessName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mOomScore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mOomScore = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mPageFault;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mPageFault = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$8() {
        return this.mPageMajorFault;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(long v) {
        this.mPageMajorFault = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$10() {
        return this.mRssInBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(long v) {
        this.mRssInBytes = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$12() {
        return this.mCacheInBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(long v) {
        this.mCacheInBytes = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$14() {
        return this.mSwapInBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(long v) {
        this.mSwapInBytes = v;
    }

    static /* synthetic */ StepOSProcessMemoryStateData[] lambda$static$16(int x$0) {
        return new StepOSProcessMemoryStateData[x$0];
    }
}
