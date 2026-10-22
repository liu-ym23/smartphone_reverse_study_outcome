package com.bytedance.security.zenmobile.detect.anchor.scanner;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Pattern {
    static final String CHINA_MOBILE_PREFIX = "china_mobile_prefix";
    static final String YYYY = "yyyy";
    String name;

    public abstract List<String> generateWords();

    public Pattern() {
    }

    public String getName() {
        return this.name;
    }
}
