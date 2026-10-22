package com.android.server.cpu;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CpuInfoReader$$ExternalSyntheticLambda2 implements FileFilter {
    public /* synthetic */ CpuInfoReader$$ExternalSyntheticLambda2() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r1) {
        return r1.isDirectory();
    }
}
