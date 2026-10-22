package com.bytedance.apm.agent.instrumentation.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes14.dex */
public final class CInputStream extends CInputStreamParent {
    public CInputStream(InputStream r100) {
        this(r100, false);
    }

    public CInputStream(InputStream r100, boolean r101) {
        super(r100, r101);
    }
}
