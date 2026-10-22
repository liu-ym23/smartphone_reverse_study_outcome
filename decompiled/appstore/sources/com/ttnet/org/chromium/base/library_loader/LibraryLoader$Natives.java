package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
interface LibraryLoader$Natives {
    String getVersionNumber();

    boolean libraryLoaded(int r10);

    void recordRendererLibraryLoadTime(long r10);

    void registerNonMainDexJni();
}
