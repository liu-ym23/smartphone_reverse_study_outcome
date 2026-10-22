package com.bytedance.bdtracker;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class w0 extends RecyclerView.OnScrollListener {
    public int a;
    public int b;
    public final int c;
    public final Function3<Float, Float, Integer, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public w0(int i, Function3<? super Float, ? super Float, ? super Integer, Unit> sendScrollObserveCallback) {
        Intrinsics.checkParameterIsNotNull(sendScrollObserveCallback, "sendScrollObserveCallback");
        this.c = i;
        this.d = sendScrollObserveCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            super.onScrollStateChanged(r6, r7)
            if (r7 != 0) goto L72
            int r7 = r5.a
            int r7 = java.lang.Math.abs(r7)
            int r0 = r5.c
            if (r7 >= r0) goto L1e
            int r7 = r5.b
            int r7 = java.lang.Math.abs(r7)
            int r0 = r5.c
            if (r7 < r0) goto L72
        L1e:
            kotlin.jvm.functions.Function3<java.lang.Float, java.lang.Float, java.lang.Integer, kotlin.Unit> r7 = r5.d
            int r0 = r5.a
            float r0 = (float) r0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            int r1 = r5.b
            float r1 = (float) r1
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r6.getLayoutManager()
            boolean r3 = r2 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r4 = 1
            if (r3 == 0) goto L5d
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r6.getLayoutManager()
            if (r6 == 0) goto L55
            androidx.recyclerview.widget.LinearLayoutManager r6 = (androidx.recyclerview.widget.LinearLayoutManager) r6
            int r6 = r6.getOrientation()
            if (r6 == 0) goto L4d
            if (r6 == r4) goto L48
            goto L65
        L48:
            int r6 = r5.b
            if (r6 <= 0) goto L66
            goto L65
        L4d:
            int r6 = r5.a
            if (r6 <= 0) goto L53
            r4 = 4
            goto L66
        L53:
            r4 = 3
            goto L66
        L55:
            kotlin.TypeCastException r5 = new kotlin.TypeCastException
            java.lang.String r6 = "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager"
            r5.<init>(r6)
            throw r5
        L5d:
            boolean r6 = r2 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r6 == 0) goto L65
            int r6 = r5.b
            if (r6 <= 0) goto L66
        L65:
            r4 = 2
        L66:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r7.invoke(r0, r1, r6)
            r6 = 0
            r5.a = r6
            r5.b = r6
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w0.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (Math.abs(i) > this.c || Math.abs(i2) > this.c) {
            int i3 = this.a;
            this.a = i > 0 ? Math.max(i3, i) : Math.min(i3, i);
            int i4 = this.b;
            this.b = i2 > 0 ? Math.max(i4, i2) : Math.min(i4, i2);
        }
    }
}
