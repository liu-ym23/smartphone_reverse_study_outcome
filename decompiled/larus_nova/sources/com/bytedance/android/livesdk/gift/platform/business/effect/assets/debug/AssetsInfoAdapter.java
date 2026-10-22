package com.bytedance.android.livesdk.gift.platform.business.effect.assets.debug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/debug/AssetsInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/debug/AssetsInfoAdapter$VH;", "VH", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AssetsInfoAdapter extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<e, Boolean>> f129087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f129088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f129089c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/debug/AssetsInfoAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VH extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f129090a;

        public VH(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f129090a = (TextView) r100.findViewById(R.id.asset_name);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f129087a).size();
    }

    public AssetsInfoAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f129087a = new ArrayList();
        this.f129088b = LayoutInflater.from(r100);
        this.f129089c = "";
    }

    public final void y2(List<? extends Pair<? extends e, Boolean>> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L35;
        ((ArrayList) this.f129087a).clear();
        ((ArrayList) this.f129087a).addAll(r100);
        Iterator r101 = ((ArrayList) this.f129087a).iterator();
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r101.hasNext() == false) goto L21;
        Pair r104 = (Pair) r101.next();
        int r105 = ((e) r104.getFirst()).getResourceType();
        if (r105 == 4) goto L17;
        if (r105 == 5) goto L17;
        if (r105 != 8) goto L8;
    L17:
        if (((e) r104.getFirst()).getDownloadType() == 2) goto L8;
        r103 = r103 + 1;
        if (((Boolean) r104.getSecond()).booleanValue() == false) goto L8;
        r102 = r102 + 1;
        goto L8
    L21:
        this.f129089c = "M,L,S:(" + r102 + '/' + r103 + ") All: " + ((ArrayList) this.f129087a).size();
        notifyDataSetChanged();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VH r102 = (VH) r100;
        Intrinsics.checkNotNullParameter(r102, "vh");
        Pair r103 = (Pair) ListProtector.get(this.f129087a, r101);
        switch(((e) r103.getFirst()).getResourceType()) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L4;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        Object r104 = Integer.valueOf(((e) r103.getFirst()).getResourceType());
    L10:
        r102.f129090a.setText(r101 + "-[" + ((e) r103.getFirst()).getId() + "]-{" + r104 + "} " + ((e) r103.getFirst()).getMD5());
        return;
    L5:
        r104 = "LOKI";
        goto L10
    L6:
        r104 = "STICKER";
        goto L10
    L7:
        r104 = "MP4";
        goto L10
    L8:
        r104 = "LOTTIE";
        goto L10
    L9:
        r104 = "WEBP";
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return new VH(this.f129088b.inflate(R.layout.ttlive_debug_assets_viewholder, r100, false));
    }
}
