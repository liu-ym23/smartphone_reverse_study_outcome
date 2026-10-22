package com.bytedance.android.shopping.utils.gallery;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f187117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f187118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f187119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f187120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f187121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f187122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f187123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f187124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f187125i;

    public e(ECGalleryActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f187125i = r100;
        int r101 = com.bytedance.android.shopping.extensions.b.b(32);
        this.f187123g = r101;
        int r102 = k1.n(r100);
        this.f187124h = r102;
        this.f187122f = (r102 - (r101 * 2)) / 2;
    }
}
