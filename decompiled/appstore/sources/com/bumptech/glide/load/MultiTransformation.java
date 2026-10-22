package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(@NonNull Transformation<T>... r10) {
        if (r10.length == 0) goto L7;
        this.transformations = Arrays.asList(r10);
        return;
    L7:
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof MultiTransformation) == true) goto L5;
        return false;
    L5:
        return this.transformations.equals(((MultiTransformation) r10).transformations);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<T> transform(@NonNull Context r10, @NonNull Resource<T> r11, int r12, int r13) {
        Iterator<? extends Transformation<T>> r14 = this.transformations.iterator();
        Resource<T> r15 = r11;
    L4:
        if (r14.hasNext() == false) goto L13;
        Resource<T> r16 = r14.next().transform(r10, r15, r12, r13);
        if (r15 == null) goto L12;
        if (r15.equals(r11) == true) goto L12;
        if (r15.equals(r16) == true) goto L12;
        r15.recycle();
    L12:
        r15 = r16;
        goto L4
    L13:
        return r15;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        Iterator<? extends Transformation<T>> r11 = this.transformations.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().updateDiskCacheKey(r10);
        goto L4
    }

    public MultiTransformation(@NonNull Collection<? extends Transformation<T>> r10) {
        if (r10.isEmpty() == true) goto L7;
        this.transformations = r10;
        return;
    L7:
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
