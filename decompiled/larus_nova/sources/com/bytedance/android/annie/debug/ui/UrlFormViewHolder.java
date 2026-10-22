package com.bytedance.android.annie.debug.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/UrlFormViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class UrlFormViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f39454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f39455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f39456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f39457d;

    public UrlFormViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f39454a = r100;
        this.f39455b = LazyKt.lazy(new UrlFormViewHolder$annieDebugParamTitle$2(this));
        this.f39456c = LazyKt.lazy(new UrlFormViewHolder$annieDebugParamValue$2(this));
        this.f39457d = LazyKt.lazy(new UrlFormViewHolder$annieDebugParamSubDialog$2(this));
    }
}
