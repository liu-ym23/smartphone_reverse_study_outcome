package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Path;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Path> f79794a;

    public abstract Path b(int r100, int r101, int r102);

    public abstract Path c(int r100, float r101, float r102);

    public c() {
        this.f79794a = new SparseArray();
    }

    public final Path a(int r100, float r101, float r102) {
        if (this.f79794a.get(r100) != null) goto L5;
        this.f79794a.put(r100, c(r100, r101, r102));
    L5:
        Path r103 = this.f79794a.get(r100);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return new Path();
    }
}
