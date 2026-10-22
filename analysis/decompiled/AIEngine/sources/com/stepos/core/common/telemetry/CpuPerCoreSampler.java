package com.stepos.core.common.telemetry;

import com.stepos.core.common.utils.SysfsReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuPerCoreSampler {
    private static final String CAPACITY_SUFFIX = "/cpu_capacity";
    private static final String CPU_DIR = "/sys/devices/system/cpu/cpu";
    public static final int DEFAULT_JIFFY_MS = 10;
    private static final String FREQ_SUFFIX = "/cpufreq/scaling_cur_freq";
    private static final int IDX_IRQ = 6;
    private static final int IDX_NICE = 2;
    private static final int IDX_SOFTIRQ = 7;
    private static final int IDX_SYSTEM = 3;
    private static final int IDX_USER = 1;
    private static final double PRIME_WEIGHT = 2.0d;
    private static final String PROC_STAT = "/proc/stat";
    private static final byte[] P_CPU;
    public static final CpuPerCoreSampler INSTANCE = new CpuPerCoreSampler();
    private static final lb.d cachedCoreClasses$delegate = kotlin.b.b(new a9.b(14));

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CoreClass {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ CoreClass[] $VALUES;
        public static final CoreClass LITTLE = new CoreClass("LITTLE", 0);
        public static final CoreClass BIG = new CoreClass("BIG", 1);
        public static final CoreClass PRIME = new CoreClass("PRIME", 2);
        public static final CoreClass UNKNOWN = new CoreClass(FailStage.UNKNOWN, 3);

        private static final /* synthetic */ CoreClass[] $values() {
            return new CoreClass[]{LITTLE, BIG, PRIME, UNKNOWN};
        }

        static {
            CoreClass[] coreClassArr$values = $values();
            $VALUES = coreClassArr$values;
            $ENTRIES = kotlin.enums.a.a(coreClassArr$values);
        }

        private CoreClass(String str, int i10) {
        }

        public static sb.a<CoreClass> getEntries() {
            return $ENTRIES;
        }

        public static CoreClass valueOf(String str) {
            return (CoreClass) Enum.valueOf(CoreClass.class, str);
        }

        public static CoreClass[] values() {
            return (CoreClass[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Snapshot {
        private final long[] activeJiffies;
        private final int[] freqKhz;

        public Snapshot(long[] activeJiffies, int[] freqKhz) {
            kotlin.jvm.internal.g.f(activeJiffies, "activeJiffies");
            kotlin.jvm.internal.g.f(freqKhz, "freqKhz");
            this.activeJiffies = activeJiffies;
            this.freqKhz = freqKhz;
        }

        public static /* synthetic */ Snapshot copy$default(Snapshot snapshot, long[] jArr, int[] iArr, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                jArr = snapshot.activeJiffies;
            }
            if ((i10 & 2) != 0) {
                iArr = snapshot.freqKhz;
            }
            return snapshot.copy(jArr, iArr);
        }

        public final long[] component1() {
            return this.activeJiffies;
        }

        public final int[] component2() {
            return this.freqKhz;
        }

        public final Snapshot copy(long[] activeJiffies, int[] freqKhz) {
            kotlin.jvm.internal.g.f(activeJiffies, "activeJiffies");
            kotlin.jvm.internal.g.f(freqKhz, "freqKhz");
            return new Snapshot(activeJiffies, freqKhz);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) obj;
            return kotlin.jvm.internal.g.b(this.activeJiffies, snapshot.activeJiffies) && kotlin.jvm.internal.g.b(this.freqKhz, snapshot.freqKhz);
        }

        public final long[] getActiveJiffies() {
            return this.activeJiffies;
        }

        public final int[] getFreqKhz() {
            return this.freqKhz;
        }

        public final int getNCores() {
            return this.activeJiffies.length;
        }

        public final boolean hasAnyValid() {
            int nCores = getNCores();
            for (int i10 = 0; i10 < nCores; i10++) {
                if (this.activeJiffies[i10] > 0 && this.freqKhz[i10] > 0) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.freqKhz) + (Arrays.hashCode(this.activeJiffies) * 31);
        }

        public String toString() {
            return h0.e.c("Snapshot(activeJiffies=", Arrays.toString(this.activeJiffies), ", freqKhz=", Arrays.toString(this.freqKhz), ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoreClass.values().length];
            try {
                iArr[CoreClass.PRIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
        P_CPU = l7.d.a("cpu");
    }

    private CpuPerCoreSampler() {
    }

    private final long activeFromCpuLine(byte[] bArr, int i10, int i11) {
        ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
        return l7.d.c(bArr, i10, i11, 1, 0L) + l7.d.c(bArr, i10, i11, 2, 0L) + l7.d.c(bArr, i10, i11, 3, 0L) + l7.d.c(bArr, i10, i11, 6, 0L) + l7.d.c(bArr, i10, i11, 7, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoreClass[] cachedCoreClasses_delegate$lambda$1() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CpuPerCoreSampler cpuPerCoreSampler = INSTANCE;
        int[] iArr = new int[iAvailableProcessors];
        for (int i10 = 0; i10 < iAvailableProcessors; i10++) {
            iArr[i10] = INSTANCE.readCapacity(i10);
        }
        return cpuPerCoreSampler.classifyCapacities$common_release(iArr);
    }

    private final CoreClass[] getCachedCoreClasses() {
        return (CoreClass[]) cachedCoreClasses$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, long[]] */
    private final long[] parseProcStat() {
        Object objA;
        try {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            int i10 = 1;
            if (iAvailableProcessors < 1) {
                iAvailableProcessors = 1;
            }
            ref$ObjectRef.f10076a = new long[iAvailableProcessors];
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
            l7.d.f(new File(PROC_STAT), new b7.g(ref$IntRef, ref$ObjectRef, this, i10));
            int i11 = ref$IntRef.f10074a;
            Object obj = ref$ObjectRef.f10076a;
            if (i11 == ((long[]) obj).length) {
                objA = (long[]) obj;
            } else {
                objA = Arrays.copyOf((long[]) obj, i11);
                kotlin.jvm.internal.g.e(objA, "copyOf(...)");
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj2 = new long[0];
        if (objA instanceof Result.Failure) {
            objA = obj2;
        }
        return (long[]) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.Object, long[]] */
    public static final n parseProcStat$lambda$3$lambda$2(Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef, CpuPerCoreSampler cpuPerCoreSampler, byte[] b10, int i10, int i11) {
        int i12;
        byte b11;
        kotlin.jvm.internal.g.f(b10, "b");
        ThreadLocal<byte[]> threadLocal = l7.d.f10346a;
        if (l7.d.g(b10, i10, i11, P_CPU) && (i12 = i10 + 3) < i11 && 48 <= (b11 = b10[i12]) && b11 < 58) {
            int i13 = ref$IntRef.f10074a;
            long[] jArr = (long[]) ref$ObjectRef.f10076a;
            if (i13 == jArr.length) {
                ?? CopyOf = Arrays.copyOf(jArr, jArr.length * 2);
                kotlin.jvm.internal.g.e(CopyOf, "copyOf(...)");
                ref$ObjectRef.f10076a = CopyOf;
            }
            long[] jArr2 = (long[]) ref$ObjectRef.f10076a;
            int i14 = ref$IntRef.f10074a;
            ref$IntRef.f10074a = i14 + 1;
            jArr2[i14] = cpuPerCoreSampler.activeFromCpuLine(b10, i10, i11);
        }
        return n.f10413a;
    }

    private final int readCapacity(int i10) {
        Integer num = SysfsReader.INSTANCE.readInt(CPU_DIR + i10 + CAPACITY_SUFFIX);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private final int readCoreFreqKhz(int i10) {
        Integer num = SysfsReader.INSTANCE.readInt(CPU_DIR + i10 + FREQ_SUFFIX);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static /* synthetic */ Pair weightedAverage$default(CpuPerCoreSampler cpuPerCoreSampler, Snapshot snapshot, Snapshot snapshot2, int i10, CoreClass[] coreClassArr, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 10;
        }
        if ((i11 & 8) != 0) {
            coreClassArr = null;
        }
        return cpuPerCoreSampler.weightedAverage(snapshot, snapshot2, i10, coreClassArr);
    }

    public final CoreClass[] classifyCapacities$common_release(int[] caps) {
        CoreClass coreClass;
        kotlin.jvm.internal.g.f(caps, "caps");
        ArrayList arrayList = new ArrayList();
        for (int i10 : caps) {
            if (i10 > 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        TreeSet treeSet = new TreeSet();
        kotlin.collections.a.L0(arrayList, treeSet);
        int[] iArrN0 = kotlin.collections.a.N0(treeSet);
        int length = caps.length;
        CoreClass[] coreClassArr = new CoreClass[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = caps[i11];
            if (i12 <= 0) {
                coreClass = CoreClass.UNKNOWN;
            } else if (iArrN0.length <= 1) {
                coreClass = CoreClass.BIG;
            } else if (iArrN0.length == 2) {
                if (iArrN0.length == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                coreClass = i12 == iArrN0[iArrN0.length - 1] ? CoreClass.BIG : CoreClass.LITTLE;
            } else {
                if (iArrN0.length == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                if (i12 == iArrN0[iArrN0.length - 1]) {
                    coreClass = CoreClass.PRIME;
                } else {
                    if (iArrN0.length == 0) {
                        throw new NoSuchElementException("Array is empty.");
                    }
                    coreClass = i12 == iArrN0[0] ? CoreClass.LITTLE : CoreClass.BIG;
                }
            }
            coreClassArr[i11] = coreClass;
        }
        return coreClassArr;
    }

    public final Snapshot snapshot() {
        long[] procStat = parseProcStat();
        int i10 = 0;
        int length = !(procStat.length == 0) ? procStat.length : Runtime.getRuntime().availableProcessors();
        long[] jArr = new long[length];
        int[] iArr = new int[length];
        while (i10 < length) {
            jArr[i10] = i10 < procStat.length ? procStat[i10] : 0L;
            iArr[i10] = readCoreFreqKhz(i10);
            i10++;
        }
        return new Snapshot(jArr, iArr);
    }

    public final double weightOf$common_release(CoreClass cls) {
        kotlin.jvm.internal.g.f(cls, "cls");
        if (WhenMappings.$EnumSwitchMapping$0[cls.ordinal()] == 1) {
            return PRIME_WEIGHT;
        }
        return 1.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<java.lang.Integer, java.lang.Long> weightedAverage(com.stepos.core.common.telemetry.CpuPerCoreSampler.Snapshot r24, com.stepos.core.common.telemetry.CpuPerCoreSampler.Snapshot r25, int r26, com.stepos.core.common.telemetry.CpuPerCoreSampler.CoreClass[] r27) {
        /*
            r23 = this;
            java.lang.String r0 = "entry"
            r1 = r24
            kotlin.jvm.internal.g.f(r1, r0)
            java.lang.String r0 = "exit"
            r2 = r25
            kotlin.jvm.internal.g.f(r2, r0)
            int r0 = r1.getNCores()
            int r3 = r2.getNCores()
            int r0 = java.lang.Math.min(r0, r3)
            if (r27 != 0) goto L21
            com.stepos.core.common.telemetry.CpuPerCoreSampler$CoreClass[] r3 = r23.getCachedCoreClasses()
            goto L23
        L21:
            r3 = r27
        L23:
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
        L2a:
            if (r8 >= r0) goto L8a
            long[] r15 = r2.getActiveJiffies()
            r15 = r15[r8]
            long[] r17 = r1.getActiveJiffies()
            r17 = r17[r8]
            r19 = 0
            long r4 = r15 - r17
            int r15 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r15 <= 0) goto L51
            int[] r15 = r1.getFreqKhz()
            r15 = r15[r8]
            int[] r16 = r2.getFreqKhz()
            r16 = r16[r8]
            if (r15 > 0) goto L57
            if (r16 <= 0) goto L51
            goto L57
        L51:
            r7 = r23
            r6 = r0
            r17 = 0
            goto L84
        L57:
            if (r15 > 0) goto L5c
            r15 = r16
            goto L63
        L5c:
            if (r16 > 0) goto L5f
            goto L63
        L5f:
            int r15 = r15 + r16
            int r15 = r15 / 2
        L63:
            java.lang.Object r16 = mb.l.g0(r3, r8)
            com.stepos.core.common.telemetry.CpuPerCoreSampler$CoreClass r16 = (com.stepos.core.common.telemetry.CpuPerCoreSampler.CoreClass) r16
            if (r16 != 0) goto L6d
            com.stepos.core.common.telemetry.CpuPerCoreSampler$CoreClass r16 = com.stepos.core.common.telemetry.CpuPerCoreSampler.CoreClass.UNKNOWN
        L6d:
            r7 = r23
            r6 = r16
            r17 = 0
            double r21 = r7.weightOf$common_release(r6)
            r6 = r0
            double r0 = (double) r4
            double r0 = r0 * r21
            r21 = r0
            double r0 = (double) r15
            double r0 = r0 * r21
            double r11 = r11 + r0
            double r9 = r9 + r21
            long r13 = r13 + r4
        L84:
            int r8 = r8 + 1
            r1 = r24
            r0 = r6
            goto L2a
        L8a:
            r17 = 0
            r19 = 0
            int r0 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r0 > 0) goto La1
            r0 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Long r1 = java.lang.Long.valueOf(r19)
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r0, r1)
            return r2
        La1:
            double r11 = r11 / r9
            int r0 = (int) r11
            r1 = r26
            long r1 = (long) r1
            long r13 = r13 * r1
            int r0 = r0 / 1000
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Long r1 = java.lang.Long.valueOf(r13)
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.telemetry.CpuPerCoreSampler.weightedAverage(com.stepos.core.common.telemetry.CpuPerCoreSampler$Snapshot, com.stepos.core.common.telemetry.CpuPerCoreSampler$Snapshot, int, com.stepos.core.common.telemetry.CpuPerCoreSampler$CoreClass[]):kotlin.Pair");
    }
}
