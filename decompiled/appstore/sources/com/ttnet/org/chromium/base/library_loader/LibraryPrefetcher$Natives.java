package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
interface LibraryPrefetcher$Natives {
    void forkAndPrefetchNativeLibrary();

    int percentageOfResidentNativeLibraryCode();

    void periodicallyCollectResidency();
}
