package com.bytedance.android.live.soloktv.karaokestation.util;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import bb1.a;
import com.bytedance.android.live.soloktv.karaokestation.view.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/soloktv/karaokestation/util/CommonListAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/soloktv/karaokestation/util/CommonViewHolder;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonListAdapter<T> extends RecyclerView.Adapter<CommonViewHolder<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f101236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super T, ? super Integer, Unit> f101237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f101238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a<T> f101239d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f101236a.size();
    }

    public CommonListAdapter(j r100) {
        Intrinsics.checkNotNullParameter(r100, "vhProvider");
        this.f101239d = r100;
        this.f101236a = new ArrayList();
        this.f101238c = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        CommonViewHolder r102 = (CommonViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Object r103 = ListProtector.get(this.f101236a, r101);
        if (r103 == null) goto L10;
        r102.T3(r101, r103);
        if (this.f101238c.contains(r103) == true) goto L11;
        this.f101238c.add((T) r103);
        Function2<? super T, ? super Integer, Unit> r104 = this.f101237b;
        if (r104 == null) goto L12;
        Unit r105 = r104.invoke(r103, Integer.valueOf(r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f101239d.a(r100);
    }
}
