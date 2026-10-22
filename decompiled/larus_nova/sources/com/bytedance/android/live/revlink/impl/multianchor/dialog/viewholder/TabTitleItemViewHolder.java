package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/TabTitleItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TabTitleItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f93815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f93816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f93817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<Integer> f93818d;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabTitleItemViewHolder f93819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f93820b;

        public a(TabTitleItemViewHolder r100, View r101) {
            this.f93819a = r100;
            this.f93820b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            this.f93820b.setSelected(Intrinsics.areEqual((Integer) r100, this.f93819a.f93817c));
        }
    }

    public TabTitleItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f93815a = (TextView) r100.findViewById(R.id.tv_item);
        this.f93816b = new a(this, r100);
    }
}
