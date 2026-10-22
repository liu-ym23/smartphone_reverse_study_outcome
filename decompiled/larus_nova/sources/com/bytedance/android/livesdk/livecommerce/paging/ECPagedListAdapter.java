package com.bytedance.android.livesdk.livecommerce.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/paging/ECPagedListAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/PagedListAdapter;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECPagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<T, VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super PagedList<T>, Unit> f149779a;

    public ECPagedListAdapter(DiffUtil.ItemCallback<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "diffCallback");
        super(r100);
    }

    @Override // androidx.paging.PagedListAdapter
    public final void onCurrentListChanged(PagedList<T> r100) {
        super.onCurrentListChanged(r100);
        Function1<? super PagedList<T>, Unit> r101 = this.f149779a;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        this.f149779a = null;
    }

    @Override // androidx.paging.PagedListAdapter
    public final void submitList(PagedList<T> r100) {
        this.f149779a = null;
        super.submitList(r100);
    }

    public final void y2(PagedList<T> r100, Function1<? super PagedList<T>, Unit> r101) {
        this.f149779a = r101;
        super.submitList(r100);
    }
}
