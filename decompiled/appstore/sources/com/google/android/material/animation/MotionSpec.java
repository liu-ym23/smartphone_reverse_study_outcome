package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap propertyValues;
    private final SimpleArrayMap timings;

    public MotionSpec() {
        this.timings = new SimpleArrayMap();
        this.propertyValues = new SimpleArrayMap();
    }

    private static void addInfoFromAnimator(@NonNull MotionSpec r10, Animator r11) {
        if ((r11 instanceof ObjectAnimator) == false) goto L7;
        ObjectAnimator r12 = (ObjectAnimator) r11;
        r10.setPropertyValues(r12.getPropertyName(), r12.getValues());
        r10.setTiming(r12.getPropertyName(), MotionTiming.createFromAnimator(r12));
        return;
    L7:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r11);
    }

    @NonNull
    private PropertyValuesHolder[] clonePropertyValuesHolder(@NonNull PropertyValuesHolder[] r10) {
        PropertyValuesHolder[] r11 = new PropertyValuesHolder[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].clone();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @Nullable
    public static MotionSpec createFromAttribute(@NonNull Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        if (r11.hasValue(r12) == false) goto L8;
        int r13 = r11.getResourceId(r12, 0);
        if (r13 != 0) goto L7;
        return null;
    L7:
        return createFromResource(r10, r13);
    L8:
        return null;
    }

    @Nullable
    public static MotionSpec createFromResource(@NonNull Context r10, @AnimatorRes int r11) {
        Animator r12 = AnimatorInflater.loadAnimator(r10, r11);     // Catch: Exception -> L7
        if ((r12 instanceof AnimatorSet) == true) goto L6;
        if (r12 == null) goto L12;
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L7
        r13.add(r12);     // Catch: Exception -> L7
        return createSpecFromAnimators(r13);
    L12:
        return null;
    L6:
        return createSpecFromAnimators(((AnimatorSet) r12).getChildAnimations());
    L7:
        e = move-exception;
        Log.w(TAG, "Can't load animation resource ID #0x" + Integer.toHexString(r11), e);
        return null;
    }

    @NonNull
    private static MotionSpec createSpecFromAnimators(@NonNull List<Animator> r10) {
        MotionSpec r11 = new MotionSpec();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        addInfoFromAnimator(r11, r10.get(r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MotionSpec) == true) goto L10;
        return false;
    L10:
        return this.timings.equals(((MotionSpec) r10).timings);
    }

    @NonNull
    public <T> ObjectAnimator getAnimator(@NonNull String r10, @NonNull T r11, @NonNull Property<T, ?> r12) {
        ObjectAnimator r13 = ObjectAnimator.ofPropertyValuesHolder(r11, getPropertyValues(r10));
        r13.setProperty(r12);
        getTiming(r10).apply(r13);
        return r13;
    }

    @NonNull
    public PropertyValuesHolder[] getPropertyValues(String r10) {
        if (hasPropertyValues(r10) == false) goto L7;
        return clonePropertyValuesHolder((PropertyValuesHolder[]) this.propertyValues.get(r10));
    L7:
        throw new IllegalArgumentException();
    }

    public MotionTiming getTiming(String r10) {
        if (hasTiming(r10) == false) goto L7;
        return (MotionTiming) this.timings.get(r10);
    L7:
        throw new IllegalArgumentException();
    }

    public long getTotalDuration() {
        int r10 = this.timings.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        MotionTiming r13 = (MotionTiming) this.timings.valueAt(r12);
        r11 = Math.max(r11, r13.getDelay() + r13.getDuration());
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public boolean hasPropertyValues(String r10) {
        if (this.propertyValues.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTiming(String r10) {
        if (this.timings.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setPropertyValues(String r10, PropertyValuesHolder[] r11) {
        this.propertyValues.put(r10, r11);
    }

    public void setTiming(String r10, @Nullable MotionTiming r11) {
        this.timings.put(r10, r11);
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
