package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicPageAdapterVCD;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicPageAdapterVCD$LiveGesturePageViewHolder;", "LiveGesturePageViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGestureMagicPageAdapterVCD extends RecyclerView.Adapter<LiveGesturePageViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveGestureMagicPageAdapter.b f68566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<EffectCategoryResponse> f68567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f68568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<LiveGestureMagicAdapterVCD> f68569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, RecyclerView> f68570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<Integer, Integer[]> f68571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68572g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicPageAdapterVCD$LiveGesturePageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class LiveGesturePageViewHolder extends RecyclerView.ViewHolder {
        public LiveGesturePageViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (Lists.isEmpty(this.f68567b) == false) goto L5;
        return 0;
    L5:
        List<EffectCategoryResponse> r100 = this.f68567b;
        if (r100 != null) goto L8;
        return 0;
    L8:
        return r100.size();
    }

    public LiveGestureMagicPageAdapterVCD(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f68572g = r100;
        this.f68569d = new SparseArray();
        this.f68570e = new HashMap();
        this.f68571f = new HashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final LiveGesturePageViewHolder r101 = (LiveGesturePageViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        List<EffectCategoryResponse> r111 = this.f68567b;
        if (r111 == null) goto L56;
        EffectCategoryResponse r112 = (EffectCategoryResponse) ListProtector.get(r111, r101.getAdapterPosition());
        if (r112 == null) goto L64;
        ImageModel r102 = new ImageModel();
        ArrayList r103 = new ArrayList();
        String r104 = r112.getIcon_selected_url();
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        r103.add(r104);
    L16:
        if (Lists.isEmpty(r103) == false) goto L18;
        ((ImageView) r101.itemView.findViewById(R.id.image)).setImageResource(R.drawable.ttlive_effect_ic_gesture_yeah);
    L19:
        ((RecyclerView) r101.itemView.findViewById(R.id.recycler_view)).setLayoutManager(new LinearLayoutManager(this.f68568c, 0, false));
        if (this.f68569d.get(r101.getAdapterPosition()) != null) goto L22;
        LiveGestureMagicAdapterVCD r106 = new LiveGestureMagicAdapterVCD(this.f68572g);
        r106.f68547c = new f(this);
        ((RecyclerView) r101.itemView.findViewById(R.id.recycler_view)).addOnScrollListener(new LiveGestureMagicPageAdapterVCD$onBindViewHolder$$inlined$let$lambda$2(this, r101));
        this.f68569d.put(r101.getAdapterPosition(), r106);
    L22:
        LiveGestureMagicAdapterVCD r107 = this.f68569d.get(r101.getAdapterPosition());
        if (((RecyclerView) r101.itemView.findViewById(R.id.recycler_view)).getAdapter() != null) goto L65;
        ((RecyclerView) r101.itemView.findViewById(R.id.recycler_view)).setAdapter(r107);
        RecyclerView.Adapter r108 = ((RecyclerView) r101.itemView.findViewById(R.id.recycler_view)).getAdapter();
        if (r108 == null) goto L55;
        LiveGestureMagicAdapterVCD r109 = (LiveGestureMagicAdapterVCD) r108;
        if (Lists.isEmpty(r112.getTotalEffects()) == true) goto L44;
        r109.f68550f = r112;
        ((ArrayList) r109.f68549e).clear();
        boolean r113 = "heartb".equals(r112.getKey());
        Iterator<Effect> r114 = r112.getTotalEffects().iterator();
    L30:
        if (r114.hasNext() == false) goto L33;
        Sticker r115 = com.bytedance.android.live.effect.sticker.d.b(r114.next());
        r115.setDownloaded(r109.f68545a.q(r115));
        r115.setDoubleHandGesture(r113);
        ((ArrayList) r109.f68549e).add(r115);
        goto L30
    L33:
        if (r109.f68548d != null) goto L43;
        LiveEffectContextFactoryDelegate$Type r116 = r109.f68546b;
        List<String> r117 = LiveEffectContext.f66734h;
        Iterator<Sticker> r118 = LiveEffectContext.a.a(r116).a().o(d0.f66752b).iterator();
    L36:
        if (r118.hasNext() == false) goto L43;
        Sticker r119 = r118.next();
        Iterator r120 = ((ArrayList) r109.f68549e).iterator();
    L39:
        if (r120.hasNext() == false) goto L36;
        Sticker r121 = (Sticker) r120.next();
        if (Sticker.equals(r119, r121) == false) goto L39;
        r109.f68548d = r121;
    L43:
        r109.notifyDataSetChanged();
    L44:
        Map<Integer, RecyclerView> r122 = this.f68570e;
        HashMap r123 = (HashMap) r122;
        r123.put(Integer.valueOf(r101.getAdapterPosition()), r101.itemView.findViewById(R.id.recycler_view));
        Integer[] r124 = this.f68571f.get(Integer.valueOf(r101.getAdapterPosition()));
        if (r124 != null) goto L47;
        return;
    L47:
        if (r124.length != 2) goto L67;
        RecyclerView.LayoutManager r125 = ((RecyclerView) r101.itemView.findViewById(R.id.recycler_view)).getLayoutManager();
        if ((r125 instanceof LinearLayoutManager) == true) goto L51;
        r125 = null;
    L51:
        LinearLayoutManager r126 = (LinearLayoutManager) r125;
        if (r126 == null) goto L68;
        r126.scrollToPositionWithOffset(r124[0].intValue(), r124[1].intValue());
        return;
    L68:
        return;
    L67:
        return;
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.sticker.ui.gestureV3.LiveGestureMagicAdapterVCD");
    L65:
        return;
    L18:
        r102.setUrls(r103);
        ImageUtil.loadImage((ImageView) r101.itemView.findViewById(R.id.image), r102, 0);
        goto L19
    L9:
        if (StringsKt.isBlank(r104) == true) goto L12;
        r105 = false;
        goto L13
    L64:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f68568c = r100.getContext();
        return new LiveGesturePageViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_item_live_gesture_magic_composer_page_vcd, r100, false));
    }
}
