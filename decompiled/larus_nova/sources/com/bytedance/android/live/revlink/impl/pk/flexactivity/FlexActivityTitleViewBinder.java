package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FlexActivityTitleViewBinder extends me.drakeet.multitype.b<a, FlexTitleViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/FlexActivityTitleViewBinder$FlexTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FlexTitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f96693a;

        public FlexTitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f96693a = r100;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f96694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f96695b;

        public a() {
            this.f96695b = "";
        }
    }

    public FlexActivityTitleViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        FlexTitleViewHolder r102 = (FlexTitleViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "itemData");
        boolean r104 = false;
        ((TextView) r102.f96693a.findViewById(R.id.title)).setVisibility(0);
        ((TextView) r102.f96693a.findViewById(R.id.title)).setText(r103.f96694a);
        String r105 = r103.f96695b;
        if (r105 != null) goto L5;
        return;
    L5:
        if (r105.length() <= 0) goto L7;
        r104 = true;
    L7:
        if (r104 == true) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L14;
        ((TextView) r102.f96693a.findViewById(R.id.title)).setTextColor(ColorProtector.parseColor(r105));
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new FlexTitleViewHolder(r100.inflate(R.layout.ttlive_item_flex_activity_title, r101, false));
    }
}
