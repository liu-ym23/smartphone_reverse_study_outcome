package com.bytedance.security.zenmobile.detect.anchor;

import android.content.Context;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class Finder {
    static final String EXACT_MATCH = "exact_match";
    static final String SCANNER = "scanner";
    static final String WORD = "word";
    String mode;

    public abstract void addRule(Context r1, List<String> r2, long r3, boolean r5, Map<String, Object> r6);

    public abstract Map<String, List<MatchRule>> getWordToRules();

    public Finder() {
    }

    public String getMode() {
        return this.mode;
    }
}
