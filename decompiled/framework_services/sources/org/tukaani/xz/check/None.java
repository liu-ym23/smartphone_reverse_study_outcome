package org.tukaani.xz.check;

import com.android.server.input.KeyboardMetricsCollector;

/* JADX INFO: loaded from: classes3.dex */
public class None extends Check {
    public None() {
        this.size = 0;
        this.name = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
    }

    @Override // org.tukaani.xz.check.Check
    public void update(byte[] buf, int off, int len) {
    }

    @Override // org.tukaani.xz.check.Check
    public byte[] finish() {
        byte[] empty = new byte[0];
        return empty;
    }
}
