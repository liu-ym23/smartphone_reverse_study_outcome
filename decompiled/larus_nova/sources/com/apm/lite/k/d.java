package com.apm.lite.k;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes39.dex */
public final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f29994a;

    public d() {
        this.f29994a = PatternProtector.compile("^cpu[\\d]+$");
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return this.f29994a.matcher(r101).matches();
    }
}
