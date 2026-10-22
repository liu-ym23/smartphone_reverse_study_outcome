package com.bytedance.android.shopping.collect.custom_view;

import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f172217c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f172218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f172219b;

    public static final class a {
    }

    static {
    }

    public final float a() {
        OverScroller r100 = this.f172218a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.getStartY();
    L6:
        OverScroller r103 = this.f172218a;
        if (r103 == null) goto L10;
        r101 = r103.getFinalY();
    L10:
        if ((r102 - r101) <= 0) goto L12;
        int r104 = -1;
    L13:
        OverScroller r105 = this.f172218a;
        if (r105 == null) goto L16;
        float r106 = r105.getCurrVelocity();
    L18:
        return (r106 * r104) * 0.7f;
    L16:
        r106 = 0.0f;
        goto L18
    L12:
        r104 = 1;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public f(RecyclerView r100) {
        this.f172219b = r100;
        Field r101 = RecyclerView.class.getDeclaredField("mViewFlinger");     // Catch: Throwable -> L15
        r101.setAccessible(true);     // Catch: Throwable -> L15
        Object r102 = r101.get(r100);     // Catch: Throwable -> L15
        Field[] r103 = r102.getClass().getDeclaredFields();     // Catch: Throwable -> L15
        int r104 = r103.length;     // Catch: Throwable -> L15
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L13;
        Field r106 = r103[r105];     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r106.getType(), OverScroller.class) == true) goto L7;
        r105 = r105 + 1;     // Catch: Throwable -> L15
        goto L4
    L7:
        r106.setAccessible(true);     // Catch: Throwable -> L15
        Object r107 = r106.get(r102);     // Catch: Throwable -> L15
        if ((r107 instanceof OverScroller) == true) goto L10;
        r107 = null;
    L10:
        this.f172218a = (OverScroller) r107;     // Catch: Throwable -> L15
        return;
    L13:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L15
    }
}
