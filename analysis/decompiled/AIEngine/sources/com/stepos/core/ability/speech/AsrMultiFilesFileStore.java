package com.stepos.core.ability.speech;

import android.content.Context;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import fc.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrMultiFilesFileStore {
    private static final String DEFAULT_EXT = "wav";
    private static final String ROOT_DIR_NAME = "asr_multi_files";
    private static final long SIZE_CAP_BYTES = 536870912;
    private static final long SOFT_TTL_MS = 86400000;
    private static final long SWEEP_MIN_INTERVAL_MS = 60000;
    private static final String TAG = "AsrMultiFilesFileStore";
    private static final Set<String> activeDirs;
    private static final CoroutineScope janitorScope;
    private static final AtomicLong lastSweepAt;
    private static final AtomicBoolean sweeping;
    public static final AsrMultiFilesFileStore INSTANCE = new AsrMultiFilesFileStore();
    private static final ConcurrentHashMap<String, Set<String>> pendingByRequest = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.AsrMultiFilesFileStore$sweepIfDue$1", f = "AsrMultiFilesFileStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.speech.AsrMultiFilesFileStore$sweepIfDue$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass1(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            AsrMultiFilesFileStore.INSTANCE.sweep();
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    static {
        Set<String> setSynchronizedSet = Collections.synchronizedSet(new HashSet());
        kotlin.jvm.internal.g.e(setSynchronizedSet, "synchronizedSet(...)");
        activeDirs = setSynchronizedSet;
        lastSweepAt = new AtomicLong(-1L);
        sweeping = new AtomicBoolean(false);
        janitorScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    private AsrMultiFilesFileStore() {
    }

    private final boolean deleteDir(File file) {
        Object objA;
        activeDirs.remove(file.getAbsolutePath());
        try {
            objA = Boolean.valueOf(wb.d.T(file));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final long dirSize(File file) {
        Object objA;
        try {
            f.a aVar = new f.a(new fc.f(wb.d.b0(file), new v(1)));
            long length = 0;
            while (aVar.hasNext()) {
                length += ((File) aVar.next()).length();
            }
            objA = Long.valueOf(length);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        return ((Number) objA).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dirSize$lambda$20$lambda$18(File it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.isFile();
    }

    private final void doSweep() {
        int i10;
        File[] fileArrListFiles = rootDir().listFiles();
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            int i11 = 0;
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                File file2 = (File) obj;
                if (activeDirs.contains(file2.getAbsolutePath()) || jCurrentTimeMillis - file2.lastModified() <= SOFT_TTL_MS) {
                    arrayList2.add(file2);
                } else if (deleteDir(file2)) {
                    i11++;
                }
            }
            int iA0 = mb.v.a0(mb.m.Z(arrayList2, 10));
            if (iA0 < 16) {
                iA0 = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
            int size2 = arrayList2.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayList2.get(i13);
                i13++;
                linkedHashMap.put(obj2, Long.valueOf(INSTANCE.dirSize((File) obj2)));
            }
            Collection collectionValues = linkedHashMap.values();
            kotlin.jvm.internal.g.f(collectionValues, "<this>");
            Iterator it = collectionValues.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                jLongValue += ((Number) it.next()).longValue();
            }
            if (jLongValue > 536870912) {
                ArrayList arrayList3 = new ArrayList();
                int size3 = arrayList2.size();
                int i14 = 0;
                while (i14 < size3) {
                    Object obj3 = arrayList2.get(i14);
                    i14++;
                    if (!activeDirs.contains(((File) obj3).getAbsolutePath())) {
                        arrayList3.add(obj3);
                    }
                }
                i10 = 0;
                for (File file3 : kotlin.collections.a.I0(arrayList3, new Comparator() { // from class: com.stepos.core.ability.speech.AsrMultiFilesFileStore$doSweep$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t8, T t10) {
                        return ob.b.a(Long.valueOf(((File) t8).lastModified()), Long.valueOf(((File) t10).lastModified()));
                    }
                })) {
                    if (jLongValue <= 536870912) {
                        break;
                    }
                    if (deleteDir(file3)) {
                        Long l10 = (Long) linkedHashMap.get(file3);
                        jLongValue -= l10 != null ? l10.longValue() : 0L;
                        i10++;
                    }
                }
            } else {
                i10 = 0;
            }
            if (i11 > 0 || i10 > 0) {
                LogModule logModule = LogModule.ABILITY;
                int size4 = arrayList2.size() - i10;
                StringBuilder sbD = h0.e.d(i11, "[ASR-FILE] stage=SWEEP deletedByAge=", i10, " deletedBySize=", " remainBytes=");
                sbD.append(jLongValue);
                sbD.append(" remainDirs=");
                sbD.append(size4);
                AIEngineLogger.i(logModule, TAG, sbD.toString());
            }
        }
    }

    private final boolean isWithinRoot(File file) {
        Object objA;
        try {
            File canonicalFile = rootDir().getCanonicalFile();
            File canonicalFile2 = file.getCanonicalFile();
            boolean z = false;
            if (!kotlin.jvm.internal.g.b(canonicalFile2, canonicalFile)) {
                String path = canonicalFile2.getPath();
                kotlin.jvm.internal.g.e(path, "getPath(...)");
                if (gc.o.k0(path, canonicalFile.getPath() + File.separator, false)) {
                    z = true;
                }
            }
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List materializeFiles$default(AsrMultiFilesFileStore asrMultiFilesFileStore, List list, long[] jArr, String str, List list2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = "";
        }
        if ((i10 & 8) != 0) {
            list2 = null;
        }
        return asrMultiFilesFileStore.materializeFiles(list, jArr, str, list2);
    }

    private final String normalizeExt(String str) {
        String string;
        if (str == null || (string = gc.q.L0(str).toString()) == null) {
            return null;
        }
        String lowerCase = gc.q.z0(string, ".").toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        if (lowerCase.length() <= 0 || lowerCase.length() > 5) {
            return null;
        }
        for (int i10 = 0; i10 < lowerCase.length(); i10++) {
            if (!Character.isLetterOrDigit(lowerCase.charAt(i10))) {
                return null;
            }
        }
        return lowerCase;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.stepos.core.ability.speech.j] */
    private final void register(String str, final File file) {
        if (gc.q.t0(str)) {
            return;
        }
        activeDirs.add(file.getAbsolutePath());
        ConcurrentHashMap<String, Set<String>> concurrentHashMap = pendingByRequest;
        final ?? r02 = new zb.p() { // from class: com.stepos.core.ability.speech.j
            @Override // zb.p
            public final Object invoke(Object obj, Object obj2) {
                return AsrMultiFilesFileStore.register$lambda$9(file, (String) obj, (Set) obj2);
            }
        };
        concurrentHashMap.compute(str, new BiFunction() { // from class: com.stepos.core.ability.speech.k
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AsrMultiFilesFileStore.register$lambda$10(r02, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set register$lambda$10(zb.p pVar, Object obj, Object obj2) {
        return (Set) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set register$lambda$9(File file, String str, Set set) {
        kotlin.jvm.internal.g.f(str, "<unused var>");
        if (set == null) {
            set = Collections.synchronizedSet(new HashSet());
        }
        set.add(file.getAbsolutePath());
        return set;
    }

    private final File rootDir() {
        Context context = l7.a.f10344a;
        if (context != null) {
            return new File(context.getCacheDir(), ROOT_DIR_NAME);
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<v6.c.b> materializeFiles(java.util.List<? extends android.os.ParcelFileDescriptor> r17, long[] r18, java.lang.String r19, java.util.List<java.lang.String> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrMultiFilesFileStore.materializeFiles(java.util.List, long[], java.lang.String, java.util.List):java.util.List");
    }

    public final void releaseByRequestId(String requestId) {
        Set<String> setRemove;
        Object objA;
        kotlin.jvm.internal.g.f(requestId, "requestId");
        if (gc.q.t0(requestId) || (setRemove = pendingByRequest.remove(requestId)) == null) {
            return;
        }
        String strConcat = "[ASR-FILE] inferId=".concat(requestId);
        for (String str : kotlin.collections.a.O0(setRemove)) {
            activeDirs.remove(str);
            File file = new File(str);
            if (isWithinRoot(file)) {
                try {
                    long jDirSize = dirSize(file);
                    if (wb.d.T(file)) {
                        AIEngineLogger.i(LogModule.ABILITY, TAG, strConcat + " stage=CLEANUP dir=" + file.getName() + " freedBytes=" + jDirSize);
                    }
                    objA = lb.n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.ABILITY, TAG, com.stepos.core.ota.d.i(strConcat, " stage=CLEANUP failed dir=", file.getName()), thB);
                }
            }
        }
    }

    public final void sweep() {
        AtomicBoolean atomicBoolean = sweeping;
        try {
            if (atomicBoolean.compareAndSet(false, true)) {
                try {
                    doSweep();
                    atomicBoolean.set(false);
                } catch (Exception e10) {
                    AIEngineLogger.w(LogModule.ABILITY, TAG, "[ASR-FILE] stage=SWEEP failed (non-fatal)", e10);
                    sweeping.set(false);
                }
            }
        } catch (Throwable th) {
            sweeping.set(false);
            throw th;
        }
    }

    public final void sweepIfDue() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = lastSweepAt;
        long j10 = atomicLong.get();
        if ((j10 < 0 || jElapsedRealtime - j10 >= 60000) && atomicLong.compareAndSet(j10, jElapsedRealtime)) {
            BuildersKt__Builders_commonKt.launch$default(janitorScope, null, null, new AnonymousClass1(null), 3, null);
        }
    }
}
