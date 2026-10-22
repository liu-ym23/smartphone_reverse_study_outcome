package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class PatternFilenameFilter implements FilenameFilter {
    private final Pattern pattern;

    public PatternFilenameFilter(String r10) {
        this(Pattern.compile(r10));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(@NullableDecl File r10, String r11) {
        return this.pattern.matcher(r11).matches();
    }

    public PatternFilenameFilter(Pattern r10) {
        this.pattern = (Pattern) Preconditions.checkNotNull(r10);
    }
}
