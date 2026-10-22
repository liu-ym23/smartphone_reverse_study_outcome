package com.bytedance.android.live.search.impl.search.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/SearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f100810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<? super Integer, ? super Integer, ? super View, Unit> f100811b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchViewHolder f100812a;

        public a(SearchViewHolder r100) {
            this.f100812a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function3<? super Integer, ? super Integer, ? super View, Unit> r101 = this.f100812a.f100811b;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(1, Integer.valueOf(this.f100812a.getAdapterPosition()), r100);
            return;
        }
    }

    public SearchViewHolder(ViewGroup r100, Function3<? super Integer, ? super Integer, ? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_search_user_head_item, r100, false));
        this.f100811b = r101;
        View r102 = this.itemView;
        if ((r102 instanceof HSImageView) == true) goto L5;
        r102 = null;
    L5:
        HSImageView r103 = (HSImageView) r102;
        this.f100810a = r103;
        if (r103 == null) goto L9;
        r103.setOnClickListener(new a(this));
        return;
    }
}
