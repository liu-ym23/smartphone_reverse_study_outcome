package com.bytedance.android.livesdk.dislike.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.c;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/adapter/ExpandItemListAdapter;", "Lcom/bytedance/android/livesdk/dislike/adapter/AbsExpandListItemAdapter;", "Lcom/bytedance/android/livesdk/dislike/adapter/ExpandItemListAdapter$ExpandItemViewHolder;", "ExpandItemViewHolder", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpandItemListAdapter extends AbsExpandListItemAdapter<ExpandItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f122101a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/adapter/ExpandItemListAdapter$ExpandItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExpandItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f122102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f122103b;

        public ExpandItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f122102a = (ImageView) r100.findViewById(R.id.icon);
            this.f122103b = (TextView) r100.findViewById(R.id.desc);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f122101a).size();
    }

    public ExpandItemListAdapter(List<j> r100) {
        ArrayList r101 = new ArrayList();
        this.f122101a = r101;
        r101.addAll(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ExpandItemViewHolder r102 = (ExpandItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        j r103 = (j) ListProtector.get(this.f122101a, r101);
        int r104 = ((ArrayList) this.f122101a).size();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        ImageView r105 = r102.f122102a;
        if (r105 == null) goto L5;
        r105.setImageResource(r103.f122118c.f520467a);
    L5:
        TextView r106 = r102.f122103b;
        if (r106 != null) goto L41;
    L12:
        c r107 = r103.f122118c;
        if (r107 == null) goto L24;
        String r108 = r107.f520469c;
        if (r108 == null) goto L24;
        if (r108.length() <= 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 != true) goto L24;
        TextView r110 = r102.f122103b;
        if (r110 == null) goto L24;
        r110.setText(r103.f122118c.f520469c);
        goto L24
    L19:
        r109 = false;
    L24:
        View r111 = r102.itemView;
        if (r111 == null) goto L27;
        r111.setOnClickListener(new a(r103));
    L27:
        OptionAction.e(r103.f122167b);
        if (r101 != 0) goto L33;
        View r112 = r102.itemView;
        if (r112 == null) goto L43;
        r112.setBackgroundResource(R.drawable.ttlive_bg_long_press_im_first);
        return;
    L43:
        return;
    L33:
        if (r101 != (r104 - 1)) goto L37;
        View r113 = r102.itemView;
        if (r113 == null) goto L45;
        r113.setBackgroundResource(R.drawable.ttlive_bg_long_press_im_last);
        return;
    L45:
        return;
    L37:
        View r114 = r102.itemView;
        if (r114 == null) goto L47;
        r114.setBackgroundColor(-1);
        return;
    L47:
        return;
    L41:
        String r115 = s1.B(r103.f122118c.f520468b);     // Catch: Exception -> L9
    L11:
        r106.setText(r115);
    L9:
        e = move-exception;
        SafetyGuard.a(null, e, "get desc text wrong!");
        r115 = "";
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new ExpandItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_dialog_long_press_expand_item, r100, false));
    }
}
