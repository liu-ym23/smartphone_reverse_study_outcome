package com.bytedance.apm.agent.instrumentation.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class CInputStream extends CInputStreamParent {
    public CInputStream(InputStream r10) {
        this(r10, false);
    }

    public CInputStream(InputStream r10, boolean r11) {
        super(r10, r11);
    }
}
