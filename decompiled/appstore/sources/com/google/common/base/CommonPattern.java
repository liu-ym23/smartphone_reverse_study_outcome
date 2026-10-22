package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class CommonPattern {
    public CommonPattern() {
    }

    public static CommonPattern compile(String r10) {
        return Platform.compilePattern(r10);
    }

    public static boolean isPcreLike() {
        return Platform.patternCompilerIsPcreLike();
    }

    public abstract int flags();

    public abstract CommonMatcher matcher(CharSequence r10);

    public abstract String pattern();

    public abstract String toString();
}
