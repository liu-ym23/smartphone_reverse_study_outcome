package com.bytedance.android.alog;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pattern f38368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Alog f38369b;

    public a(Alog r100, Pattern r101) {
        this.f38369b = r100;
        this.f38368a = r101;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return this.f38368a.matcher(r101).find();
    }
}
