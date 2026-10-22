package com.bytedance.apm.agent.instrumentation.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class CInputStream extends CInputStreamParent {
    public CInputStream(InputStream r2) {
        this(r2, false);
    }

    public CInputStream(InputStream r1, boolean r2) {
        super(r1, r2);
    }
}
