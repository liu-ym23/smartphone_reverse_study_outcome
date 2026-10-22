package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NativeCronetEngineBuilderWithLibraryLoaderImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class v extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VersionSafeCallbacks.b f38240b;

    @Override // com.ttnet.org.chromium.net.impl.u, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.k
    public /* synthetic */ com.ttnet.org.chromium.net.k a(com.ttnet.org.chromium.net.d.a.AbstractC1027a r1) {
        return b(r1);
    }

    public v(Context r3, boolean r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    public CronetEngineBuilderImpl b(com.ttnet.org.chromium.net.d.a.AbstractC1027a r2) {
        this.f38240b = new VersionSafeCallbacks.b(r2);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    VersionSafeCallbacks.b f() {
        return this.f38240b;
    }
}
