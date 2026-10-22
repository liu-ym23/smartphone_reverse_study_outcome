package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class TalkRoomSearchFootViewBinder extends me.drakeet.multitype.b<b, FootViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/TalkRoomSearchFootViewBinder$FootViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FootViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f75094a;

        public FootViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f75094a = (TextView) r100.findViewById(R.id.tv_tip);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f75095a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.f75095a == ((b) r100).f75095a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f75095a;
        }

        public final String toString() {
            return "FootViewBinderData(type=" + this.f75095a + ")";
        }

        public final int getType() {
            return this.f75095a;
        }

        public b(int r100) {
            this.f75095a = r100;
        }
    }

    static {
    }

    public TalkRoomSearchFootViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, b r101) {
        FootViewHolder r102 = (FootViewHolder) r100;
        b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        int r104 = r103.getType();
        if (r104 != 0) goto L6;
        r102.f75094a.setText(R.string.ttlive_link_room_fight_search_result_load_more);
        return;
    L6:
        if (r104 != 1) goto L8;
        r102.f75094a.setText(R.string.ttlive_link_room_search_result_bottom);
        return;
    L8:
        r102.getClass();
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new FootViewHolder(r100.inflate(R.layout.ttlive_item_talk_room_search_result_foot, r101, false));
    }
}
