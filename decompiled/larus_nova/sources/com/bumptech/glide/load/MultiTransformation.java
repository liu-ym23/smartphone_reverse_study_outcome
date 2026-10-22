package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @SafeVarargs
    public MultiTransformation(Transformation<T>... r100) {
        if (r100.length == 0) goto L7;
        this.transformations = Arrays.asList(r100);
        return;
    L7:
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof MultiTransformation) == true) goto L5;
        return false;
    L5:
        return this.transformations.equals(((MultiTransformation) r100).transformations);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Iterator<? extends Transformation<T>> r101 = this.transformations.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().updateDiskCacheKey(r100);
        goto L4
    }

    public MultiTransformation(Collection<? extends Transformation<T>> r100) {
        if (r100.isEmpty() == true) goto L7;
        this.transformations = r100;
        return;
    L7:
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> transform(Context r100, Resource<T> r101, int r102, int r103) {
        Iterator<? extends Transformation<T>> r104 = this.transformations.iterator();
        Resource<T> r105 = r101;
    L4:
        if (r104.hasNext() == false) goto L13;
        Resource<T> r106 = r104.next().transform(r100, r105, r102, r103);
        if (r105 == null) goto L12;
        if (r105.equals(r101) == true) goto L12;
        if (r105.equals(r106) == true) goto L12;
        r105.recycle();
    L12:
        r105 = r106;
        goto L4
    L13:
        return r105;
    }
}
