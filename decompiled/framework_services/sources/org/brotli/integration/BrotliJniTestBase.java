package org.brotli.integration;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliJniTestBase {
    public BrotliJniTestBase() {
    }

    static {
        String jniLibrary = System.getProperty("BROTLI_JNI_LIBRARY");
        if (jniLibrary == null) goto L6;
        System.load(new File(jniLibrary).getAbsolutePath());
        return;
    }
}
