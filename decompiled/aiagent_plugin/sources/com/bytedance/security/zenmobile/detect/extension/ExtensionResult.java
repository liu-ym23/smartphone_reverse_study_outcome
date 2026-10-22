package com.bytedance.security.zenmobile.detect.extension;

/* JADX INFO: loaded from: classes.dex */
public class ExtensionResult {
    int end;
    boolean matched;

    public ExtensionResult(boolean r1, int r2) {
        this.matched = r1;
        this.end = r2;
    }

    public boolean isMatched() {
        return this.matched;
    }

    public int getEnd() {
        return this.end;
    }
}
