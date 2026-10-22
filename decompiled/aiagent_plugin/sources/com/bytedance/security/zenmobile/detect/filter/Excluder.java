package com.bytedance.security.zenmobile.detect.filter;

/* JADX INFO: loaded from: classes.dex */
public abstract class Excluder {
    static final String CONTAIN = "contain";
    static final String EQUAL = "equal";
    static final String REGEXP = "regexp";
    static final String SUFFIX_OF = "suffix_of";
    String mode;

    public abstract boolean exclude(byte[] r1, int r2, int r3);

    public Excluder() {
    }

    public String getMode() {
        return this.mode;
    }
}
