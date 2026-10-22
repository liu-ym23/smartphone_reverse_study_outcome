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
import androidx.b.g;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final String TAG = "MotionSpec";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<String, d> f13147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<String, PropertyValuesHolder[]> f13148b;

    public c() {
        this.f13147a = new g();
        this.f13148b = new g();
    }

    public boolean a(String r1) {
        if (this.f13147a.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public d b(String r2) {
        if (a(r2) == false) goto L7;
        return (d) ZeusTransformUtils.preCheckCast(this.f13147a.get(r2), d.class, "com.obric.aiagent.plugin");
    L7:
        throw new IllegalArgumentException();
    }

    public void a(String r1, d r2) {
        this.f13147a.put(r1, r2);
    }

    public boolean c(String r1) {
        if (this.f13148b.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public PropertyValuesHolder[] d(String r3) {
        if (c(r3) == false) goto L7;
        return a((PropertyValuesHolder[]) ZeusTransformUtils.preCheckCast(this.f13148b.get(r3), PropertyValuesHolder[].class, "com.obric.aiagent.plugin"));
    L7:
        throw new IllegalArgumentException();
    }

    public void a(String r1, PropertyValuesHolder[] r2) {
        this.f13148b.put(r1, r2);
    }

    private PropertyValuesHolder[] a(PropertyValuesHolder[] r3) {
        PropertyValuesHolder[] r2 = new PropertyValuesHolder[r3.length];
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r2[r0] = r3[r0].clone();
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    public <T> ObjectAnimator a(String r2, T r3, Property<T, ?> r4) {
        ObjectAnimator r5 = ObjectAnimator.ofPropertyValuesHolder(r3, d(r2));
        r5.setProperty(r4);
        b(r2).a(r5);
        return r5;
    }

    public long a() {
        int r0 = this.f13147a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        d r4 = (d) ZeusTransformUtils.preCheckCast(this.f13147a.c(r3), d.class, "com.obric.aiagent.plugin");
        r1 = Math.max(r1, r4.a() + r4.b());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static c a(Context r2, TypedArray r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.hasValue(r4) == false) goto L8;
        int r6 = r3.getResourceId(r4, 0);
        if (r6 != 0) goto L7;
        return null;
    L7:
        return a(r5, r6);
    L8:
        return null;
    }

    public static c a(Context r3, int r4) {
        Animator r5 = AnimatorInflater.loadAnimator((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r5, AnimatorSet.class) == true) goto L6;
        if (r5 == null) goto L10;
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L11
        r1.add(r5);     // Catch: Exception -> L11
        return a(r1);
    L10:
        return null;
    L6:
        return a(((AnimatorSet) ZeusTransformUtils.preCheckCast(r5, AnimatorSet.class, "com.obric.aiagent.plugin")).getChildAnimations());
    L11:
        e = move-exception;
        a(TAG, "Can't load animation resource ID #0x" + Integer.toHexString(r4), e);
        return null;
    }

    private static c a(List<Animator> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        c r0 = new c();
        int r2 = r7.size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        a(r0, (Animator) ZeusTransformUtils.preCheckCast(r7.get(r3), Animator.class, "com.obric.aiagent.plugin"));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private static void a(c r2, Animator r3) {
        if (ZeusTransformUtils.instanceOf(r3, ObjectAnimator.class) == false) goto L7;
        ObjectAnimator r4 = (ObjectAnimator) ZeusTransformUtils.preCheckCast(r3, ObjectAnimator.class, "com.obric.aiagent.plugin");
        r2.a(r4.getPropertyName(), r4.getValues());
        r2.a(r4.getPropertyName(), d.a(r4));
        return;
    L7:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L10;
        return false;
    L10:
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        return this.f13147a.equals(r4.f13147a);
    }

    public int hashCode() {
        return this.f13147a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f13147a + "}\n";
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
