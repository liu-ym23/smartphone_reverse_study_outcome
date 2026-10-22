package com.bytedance.android.shopping.anchorv4.containers.page;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ViewGroup> f166291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f166292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f166293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f166294d;

    public final void a(boolean r100) {
        Iterator<T> r101 = this.f166291a.iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        ViewGroup r102 = (ViewGroup) r101.next();
        if (r102 == null) goto L8;
        int r103 = r102.getChildCount();
    L9:
        if (r103 <= 0) goto L4;
        if (r102 == null) goto L4;
        View r104 = r102.getChildAt(r103 - 1);
        if (r104 == null) goto L4;
        if (r100 == false) goto L15;
        float r105 = 1.0f;
    L16:
        r104.setAlpha(r105);
        goto L4
    L15:
        r105 = 0.0f;
        goto L16
    L8:
        r103 = 0;
        goto L9
    }

    public g(ViewGroup r100, ViewGroup r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f166292b = r100;
        this.f166293c = r101;
        this.f166294d = r102;
        this.f166291a = CollectionsKt.listOf(new ViewGroup[]{r100, r101, r102});
    }
}
