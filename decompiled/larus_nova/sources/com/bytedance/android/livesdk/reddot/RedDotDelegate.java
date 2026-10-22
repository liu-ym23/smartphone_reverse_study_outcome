package com.bytedance.android.livesdk.reddot;

import com.bytedance.android.livesdk.sharedpref.f;
import j40.k4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RedDotDelegate implements Comparable<RedDotDelegate> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f157075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TreeSet<RedDotDelegate> f157076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TreeSet<RedDotDelegate> f157077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f157078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.sharedpref.e<Integer> f157079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f157080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Boolean> f157081g;

    public final com.bytedance.android.livesdk.sharedpref.e<Boolean> c() {
        return (com.bytedance.android.livesdk.sharedpref.e) this.f157078d.getValue();
    }

    public final void e() {
        this.f157080f = true;
        a r100 = this.f157075a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L5:
        int r101 = r100.getType();
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L9;
    L11:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = c();
        Boolean r103 = Boolean.TRUE;
        r102.getClass();
        f.d(r102, r103);
        return;
    L9:
        if (r101 == 2) goto L11;
        return;
    L12:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r104 = this.f157079e;
        int r105 = 0;
        if (r104 == null) goto L17;
        Integer r106 = r104.getValue();
        if (r106 == null) goto L17;
        int r107 = r106.intValue();
    L19:
        if (r107 <= 100) goto L21;
        return;
    L21:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r108 = this.f157079e;
        if (r108 == null) goto L30;
        if (r108 == null) goto L27;
        Integer r109 = r108.getValue();
        if (r109 == null) goto L27;
        r105 = r109.intValue();
    L27:
        f.d(r108, Integer.valueOf(r105 + 1));
        return;
    L30:
        return;
    L17:
        r107 = 0;
        goto L19
    }

    public final a b() {
        a r100 = this.f157075a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L5:
        return r100;
    }

    public final boolean d() {
        a r100 = this.f157075a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L6:
        if (r100.getType() != 3) goto L8;
        return true;
    L8:
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        a r101 = this.f157075a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L5:
        r100.append(r101.f157083a);
        r100.append("，sp-");
        r100.append(c().getValue());
        String r102 = r100.toString();
        a r103 = this.f157075a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L8:
        int r104 = 0;
        if (r103.getType() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L20;
        StringBuilder r106 = new StringBuilder();
        r106.append(r102);
        r106.append(", count-");
        com.bytedance.android.livesdk.sharedpref.e<Integer> r107 = this.f157079e;
        if (r107 == null) goto L18;
        Integer r108 = r107.getValue();
        if (r108 == null) goto L18;
        r104 = r108.intValue();
    L18:
        r106.append(r104);
        return r106.toString();
    L20:
        StringBuilder r109 = new StringBuilder();
        a r110 = this.f157075a;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L23:
        r109.append(r110.f157083a);
        r109.append("-sp-");
        r109.append(c().getValue());
        return r109.toString();
    L11:
        r105 = false;
        goto L12
    }

    public RedDotDelegate() {
        this.f157078d = LazyKt.lazy(new RedDotDelegate$spProp$2(this));
    }

    public RedDotDelegate(a r100) {
        Intrinsics.checkNotNullParameter(r100, "dot");
        this.f157078d = LazyKt.lazy(new RedDotDelegate$spProp$2(this));
        this.f157075a = r100;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L6:
        if (r100.getType() != 0) goto L12;
        StringBuilder r101 = new StringBuilder();
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L10:
        r101.append(r100.f157083a);
        r101.append("count");
        this.f157079e = new com.bytedance.android.livesdk.sharedpref.e(r101.toString(), 0);
        return;
    }

    public final boolean a(boolean r100) {
        if (k4.f497253a.getValue().booleanValue() == false) goto L17;
        Function0<Boolean> r101 = this.f157081g;
        if (r101 != null) goto L7;
    L8:
        ArrayList<d> r102 = c.f157089a;
        Intrinsics.checkNotNullParameter(this, "redDot");
        Iterator<d> r103 = c.f157089a.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (r103.next().a(this, r100) == true) goto L10;
        boolean r104 = false;
    L15:
        if (r104 == false) goto L27;
    L21:
        return true;
    L27:
        return false;
    L14:
        r104 = true;
        goto L15
    L7:
        if (r101.invoke().booleanValue() == true) goto L8;
        return false;
    L17:
        Function0<Boolean> r105 = this.f157081g;
        if (r105 == null) goto L21;
        if (r105.invoke().booleanValue() == true) goto L21;
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(RedDotDelegate r100) {
        RedDotDelegate r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        a r102 = this.f157075a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L5:
        a r103 = r101.f157075a;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("redDot");
    L9:
        return r102.a(r103);
    }
}
