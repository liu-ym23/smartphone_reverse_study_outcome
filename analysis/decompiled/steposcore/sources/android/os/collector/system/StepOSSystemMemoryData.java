package android.os.collector.system;

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

/* loaded from: classes.dex */
public final class StepOSSystemMemoryData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSSystemMemoryData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda54
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSSystemMemoryData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda55
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSSystemMemoryData.lambda$static$54(i);
        }
    });
    public int mActiveAnonKb;
    public int mActiveFileKb;
    public int mActiveKb;
    public int mAvailableKb;
    public long mCachedMemory;
    public int mCmaFreeKb;
    public int mCmaTotalKb;
    public int mDmaBufTotalExportedKb;
    public int mFreeKb;
    public int mGpuPrivateAllocationsKb;
    public int mGpuTotalUsageKb;
    public int mInactiveAnonKb;
    public int mInactiveFileKb;
    public int mInactiveKb;
    public boolean mIsLowMemory;
    public int mKernelStackKb;
    public long mLowMemoryThreshold;
    public int mMemoryUsageRate;
    public int mPageTablesKb;
    public int mShmemKb;
    public int mSwapFreeKb;
    public int mSwapTotalKb;
    public int mTotalIonKb;
    public int mTotalKb;
    public int mUnaccountedKb;
    public int mUnreclaimableSlabKb;
    public int mVmallocUsedKb;

    public StepOSSystemMemoryData() {
        super(1, StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_SYSTEM_MEMORY);
    }

    public StepOSSystemMemoryData(long cachedMemory, int memoryUsageRate, long lowMemoryThreshold, boolean isLowMemory, int totalKb, int freeKb, int availableKb, int activeKb, int inactiveKb, int activeAnonKb, int inactiveAnonKb, int activeFileKb, int inactiveFileKb, int unreclaimableSlabKb, int vmallocUsedKb, int pageTablesKb, int kernelStackKb, int shmemKb, int swapTotalKb, int swapFreeKb, int cmaTotalKb, int cmaFreeKb, int totalIonKb, int gpuTotalUsageKb, int gpuPrivateAllocationsKb, int dmaBufTotalExportedKb, int unaccountedKb) {
        this();
        this.mCachedMemory = cachedMemory;
        this.mMemoryUsageRate = memoryUsageRate;
        this.mLowMemoryThreshold = lowMemoryThreshold;
        this.mIsLowMemory = isLowMemory;
        this.mTotalKb = totalKb;
        this.mFreeKb = freeKb;
        this.mAvailableKb = availableKb;
        this.mActiveKb = activeKb;
        this.mInactiveKb = inactiveKb;
        this.mActiveAnonKb = activeAnonKb;
        this.mInactiveAnonKb = inactiveAnonKb;
        this.mActiveFileKb = activeFileKb;
        this.mInactiveFileKb = inactiveFileKb;
        this.mUnreclaimableSlabKb = unreclaimableSlabKb;
        this.mVmallocUsedKb = vmallocUsedKb;
        this.mPageTablesKb = pageTablesKb;
        this.mKernelStackKb = kernelStackKb;
        this.mShmemKb = shmemKb;
        this.mSwapTotalKb = swapTotalKb;
        this.mSwapFreeKb = swapFreeKb;
        this.mCmaTotalKb = cmaTotalKb;
        this.mCmaFreeKb = cmaFreeKb;
        this.mTotalIonKb = totalIonKb;
        this.mGpuTotalUsageKb = gpuTotalUsageKb;
        this.mGpuPrivateAllocationsKb = gpuPrivateAllocationsKb;
        this.mDmaBufTotalExportedKb = dmaBufTotalExportedKb;
        this.mUnaccountedKb = unaccountedKb;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofLong("cached_memory", new LongSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda0
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$0();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda11
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$1(j);
            }
        }), Field.ofInt("memory_usage_rate", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda22
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda33
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofLong("low_memory_threshold", new LongSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda44
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$4();
            }
        }, new LongConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda49
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$5(j);
            }
        }), Field.ofBool("is_low_memory", new BooleanSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda50
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda51
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Boolean) obj);
            }
        }), Field.ofInt("total_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda52
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda53
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofInt("free_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofInt("available_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$12();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$13(i);
            }
        }), Field.ofInt("active_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$14();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$15(i);
            }
        }), Field.ofInt("inactive_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda7
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$16();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda8
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$17(i);
            }
        }), Field.ofInt("active_anon_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$18();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$19(i);
            }
        }), Field.ofInt("inactive_anon_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$20();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$21(i);
            }
        }), Field.ofInt("active_file_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$22();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$23(i);
            }
        }), Field.ofInt("inactive_file_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda16
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$24();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda17
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$25(i);
            }
        }), Field.ofInt("unreclaimable_slab_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda18
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$26();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda19
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$27(i);
            }
        }), Field.ofInt("vmalloc_used_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda20
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$28();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda21
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$29(i);
            }
        }), Field.ofInt("page_tables_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda23
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$30();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda24
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$31(i);
            }
        }), Field.ofInt("kernel_stack_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda25
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$32();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda26
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$33(i);
            }
        }), Field.ofInt("shmem_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda27
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$34();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda28
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$35(i);
            }
        }), Field.ofInt("swap_total_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda29
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$36();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda30
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$37(i);
            }
        }), Field.ofInt("swap_free_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda31
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$38();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda32
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$39(i);
            }
        }), Field.ofInt("cma_total_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda34
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$40();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda35
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$41(i);
            }
        }), Field.ofInt("cma_free_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda36
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$42();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda37
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$43(i);
            }
        }), Field.ofInt("total_ion_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda38
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$44();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda39
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$45(i);
            }
        }), Field.ofInt("gpu_total_usage_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda40
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$46();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda41
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$47(i);
            }
        }), Field.ofInt("gpu_private_allocations_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda42
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$48();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda43
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$49(i);
            }
        }), Field.ofInt("dma_buf_total_exported_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda45
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$50();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda46
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$51(i);
            }
        }), Field.ofInt("unaccounted_kb", new IntSupplier() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda47
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$52();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSSystemMemoryData$$ExternalSyntheticLambda48
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$53(i);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$0() {
        return this.mCachedMemory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(long v) {
        this.mCachedMemory = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mMemoryUsageRate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mMemoryUsageRate = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$4() {
        return this.mLowMemoryThreshold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(long v) {
        this.mLowMemoryThreshold = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mIsLowMemory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mIsLowMemory = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mTotalKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mTotalKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mFreeKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mFreeKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$12() {
        return this.mAvailableKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(int v) {
        this.mAvailableKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$14() {
        return this.mActiveKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(int v) {
        this.mActiveKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$16() {
        return this.mInactiveKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(int v) {
        this.mInactiveKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$18() {
        return this.mActiveAnonKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$19(int v) {
        this.mActiveAnonKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$20() {
        return this.mInactiveAnonKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$21(int v) {
        this.mInactiveAnonKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$22() {
        return this.mActiveFileKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$23(int v) {
        this.mActiveFileKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$24() {
        return this.mInactiveFileKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$25(int v) {
        this.mInactiveFileKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$26() {
        return this.mUnreclaimableSlabKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$27(int v) {
        this.mUnreclaimableSlabKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$28() {
        return this.mVmallocUsedKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$29(int v) {
        this.mVmallocUsedKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$30() {
        return this.mPageTablesKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$31(int v) {
        this.mPageTablesKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$32() {
        return this.mKernelStackKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$33(int v) {
        this.mKernelStackKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$34() {
        return this.mShmemKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$35(int v) {
        this.mShmemKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$36() {
        return this.mSwapTotalKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$37(int v) {
        this.mSwapTotalKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$38() {
        return this.mSwapFreeKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$39(int v) {
        this.mSwapFreeKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$40() {
        return this.mCmaTotalKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$41(int v) {
        this.mCmaTotalKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$42() {
        return this.mCmaFreeKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$43(int v) {
        this.mCmaFreeKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$44() {
        return this.mTotalIonKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$45(int v) {
        this.mTotalIonKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$46() {
        return this.mGpuTotalUsageKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$47(int v) {
        this.mGpuTotalUsageKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$48() {
        return this.mGpuPrivateAllocationsKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$49(int v) {
        this.mGpuPrivateAllocationsKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$50() {
        return this.mDmaBufTotalExportedKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$51(int v) {
        this.mDmaBufTotalExportedKb = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$52() {
        return this.mUnaccountedKb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$53(int v) {
        this.mUnaccountedKb = v;
    }

    static /* synthetic */ StepOSSystemMemoryData[] lambda$static$54(int x$0) {
        return new StepOSSystemMemoryData[x$0];
    }
}
