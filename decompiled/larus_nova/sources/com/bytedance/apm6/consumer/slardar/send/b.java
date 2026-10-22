package com.bytedance.apm6.consumer.slardar.send;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Comparator<File> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(File r100, File r101) {
        return String.CASE_INSENSITIVE_ORDER.compare(r100.getName(), r101.getName());
    }
}
