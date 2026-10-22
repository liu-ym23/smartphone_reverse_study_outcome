package com.bytedance.android.shopping.api.mall;

import android.util.SparseArray;
import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends IntIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f170213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SparseArray f170214b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f170213a >= this.f170214b.size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        if (hasNext() == false) goto L7;
        SparseArray r100 = this.f170214b;
        int r101 = this.f170213a;
        this.f170213a = r101 + 1;
        return r100.keyAt(r101);
    L7:
        throw new NoSuchElementException();
    }

    public a(SparseArray<Object> r100) {
        this.f170214b = r100;
    }
}
