package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.SysUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.task.PostTask;
import com.ttnet.org.chromium.base.task.TaskTraits;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryPrefetcher {
    private static final String TAG = "LibraryPrefetcher";
    private static final AtomicBoolean sPrefetchLibraryHasBeenCalled = null;

    interface Natives {
        void forkAndPrefetchNativeLibrary();

        int percentageOfResidentNativeLibraryCode();

        void periodicallyCollectResidency();
    }

    public LibraryPrefetcher() {
    }

    static {
        sPrefetchLibraryHasBeenCalled = new AtomicBoolean();
    }

    public static void asyncPrefetchLibrariesToMemory() {
        SysUtils.logPageFaultCountToTracing();
        final boolean r0 = sPrefetchLibraryHasBeenCalled.compareAndSet(false, true);
        if (r0 == true) goto L5;
    L8:
        PostTask.postTask(TaskTraits.USER_BLOCKING, new LibraryPrefetcher$$ExternalSyntheticLambda1(r0));
        return;
    L5:
        if (CommandLine.getInstance().hasSwitch("log-native-library-residency") == false) goto L8;
        new Thread(new LibraryPrefetcher$$ExternalSyntheticLambda0()).start();
    }

    static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$0() {
        LibraryPrefetcherJni.get().periodicallyCollectResidency();
    }

    static /* synthetic */ void lambda$asyncPrefetchLibrariesToMemory$1(boolean r4) {
        int r1 = LibraryPrefetcherJni.get().percentageOfResidentNativeLibraryCode();
        TraceEvent r2 = TraceEvent.scoped("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(r1));
        if (r4 == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L13;
        LibraryPrefetcherJni.get().forkAndPrefetchNativeLibrary();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r2 != null) goto L29;
    L24:
        throw th;
    L29:
        r2.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
    L13:
        if (r1 == (-1)) goto L25;
        if (r4 == false) goto L16;
        String r5 = ".ColdStartup";
    L17:
        RecordHistogram.recordPercentageHistogram("LibraryLoader.PercentageOfResidentCodeBeforePrefetch".concat(r5), r1);     // Catch: Throwable -> L10
        goto L25
    L16:
        r5 = ".WarmStartup";
    L25:
        if (r2 == null) goto L27;
        r2.close();
    L27:
        ContextUtils.getAppSharedPreferences().edit().remove("dont_prefetch_libraries").apply();
        return;
    L5:
        if (r1 >= 90) goto L7;
        r3 = true;
        goto L8
    }
}
