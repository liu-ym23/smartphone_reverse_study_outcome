package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;

/* JADX INFO: loaded from: classes4.dex */
public class NativeCronetEngineBuilderWithLibraryLoaderImpl extends NativeCronetEngineBuilderImpl {
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
        return setLibraryLoader(r1);
    }

    public NativeCronetEngineBuilderWithLibraryLoaderImpl(Context r1, boolean r2) {
        super(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r2) {
        this.mLibraryLoader = new VersionSafeCallbacks.LibraryLoader(r2);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }
}
