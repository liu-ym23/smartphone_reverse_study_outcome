package com.bytedance.android.live.emoji.online;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f68930a;

    public d(List r100) {
        this.f68930a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return this.f68930a.contains(r101);
    }
}
