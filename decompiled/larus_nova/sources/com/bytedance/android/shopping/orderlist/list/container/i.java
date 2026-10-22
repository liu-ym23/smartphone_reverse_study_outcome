package com.bytedance.android.shopping.orderlist.list.container;

import android.widget.LinearLayout;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f180198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OrderListLinkedScrollView f180199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f180200c;

    public i(OrderListLinkedScrollView r100, LinearLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r101, "stickyContainer");
        this.f180199b = r100;
        this.f180200c = r101;
        this.f180198a = new int[2];
        new WeakReference(null);
    }
}
