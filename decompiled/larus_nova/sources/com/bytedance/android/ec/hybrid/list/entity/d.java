package com.bytedance.android.ec.hybrid.list.entity;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f47080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f47081b;

    public d(Set r100, Function2 r101) {
        this.f47080a = r100;
        this.f47081b = r101;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return this.f47080a.contains(r101);
    }
}
