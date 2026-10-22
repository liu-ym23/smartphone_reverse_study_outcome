package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkTabTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "SpaceItemDecoration", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkTabTitleViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f93737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultiTypeAdapter f93738b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkTabTitleViewHolder$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f93739a;

        public SpaceItemDecoration(int r100) {
            this.f93739a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            int r104 = this.f93739a / 2;
            r100.left = r104;
            r100.right = r104;
            RecyclerView.Adapter r105 = r102.getAdapter();
            if (r105 != null) goto L6;
            return;
        L6:
            if (r102.getChildAdapterPosition(r101) != 0) goto L9;
            r100.left = 0;
        L9:
            if (r102.getChildAdapterPosition(r101) != (r105.getItemCount() - 1)) goto L12;
            r100.right = 0;
            return;
        }
    }

    public AnchorLinkTabTitleViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        Context r101 = r100.getContext();
        this.f93737a = r100.findViewById(R.id.content);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.recycler_view);
        r102.setLayoutManager(new LinearLayoutManager(r101, 0, false));
        r102.addItemDecoration(new SpaceItemDecoration(com.bytedance.android.live.revenue.common.i.b(12)));
        MultiTypeAdapter r103 = new MultiTypeAdapter();
        r103.z2(q21.l.a.class, new q21.l());
        Unit r104 = Unit.INSTANCE;
        this.f93738b = r103;
        r102.setAdapter(r103);
    }
}
