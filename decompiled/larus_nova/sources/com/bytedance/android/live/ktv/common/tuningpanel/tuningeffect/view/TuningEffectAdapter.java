package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectViewHolder;", "DiffCallback", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningEffectAdapter extends RecyclerView.Adapter<TuningEffectViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f70525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f70526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cc0.a f70527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f70528d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f70529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Object> f70530b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f70530b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f70529a.size();
        }

        public DiffCallback(List<? extends Object> r100, List<? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            Intrinsics.checkNotNullParameter(r101, "newList");
            this.f70529a = r100;
            this.f70530b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            if (r100 == r101) goto L5;
            return false;
        L5:
            Object r102 = ListProtector.get(this.f70529a, r100);
            Object r103 = ListProtector.get(this.f70530b, r101);
            if ((!Intrinsics.areEqual(r102.getClass(), r103.getClass())) == false) goto L9;
            return false;
        L9:
            if ((r102 instanceof h) == true) goto L11;
        L14:
            return false;
        L11:
            if ((r103 instanceof h) == false) goto L14;
            return ((h) r102).h((h) r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            return areContentsTheSame(r100, r101);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f70525a).size();
    }

    public final int y2(h r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator r101 = ((ArrayList) this.f70525a).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((h) r101.next()).d(), r100.d()) == true) goto L13;
        r102 = r102 + 1;
        goto L4
    L13:
        return r102;
    L9:
        return -1;
    }

    public TuningEffectAdapter(TuningEffectListView$tuningEffectCallback$2.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tuningEffectCallback");
        this.f70527c = r100;
        this.f70528d = r101;
        this.f70525a = new ArrayList();
        this.f70526b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TuningEffectViewHolder r102 = (TuningEffectViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        h r103 = (h) ListProtector.get(this.f70525a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f70540e = r103;
        TextView r104 = (TextView) r102.f70539d.getValue();
        if (r104 == null) goto L6;
        r104.setText(r103.e());
    L6:
        if (r103.f69999a == false) goto L13;
        View r105 = (View) r102.f70537b.getValue();
        if (r105 == null) goto L10;
        r105.setVisibility(0);
    L10:
        HSImageView r106 = r102.T3();
        if (r106 == null) goto L25;
        r106.setAlpha(1.0f);
    L25:
        HSImageView r107 = r102.T3();
        if (r107 == null) goto L29;
        r107.setAlpha(1.0f);
    L29:
        if (r103.g() == false) goto L31;
        ImageLoader.bindDrawableResource(r102.T3(), KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70212u));
    L32:
        HSImageView r108 = r102.T3();
        if (r108 == null) goto L35;
        r108.setContentDescription(r103.e());
    L35:
        View r109 = (View) r102.f70537b.getValue();
        if (r109 == null) goto L38;
        r109.setContentDescription(r103.e());
    L38:
        FrameLayout r110 = (FrameLayout) r102.f70536a.getValue();
        if (r110 == null) goto L42;
        r110.setContentDescription(r103.e());
        return;
    L42:
        return;
    L31:
        ImageLoader.bindImage(r102.T3(), r103.c());
        goto L32
    L13:
        View r111 = (View) r102.f70537b.getValue();
        if (r111 == null) goto L16;
        r111.setVisibility(8);
    L16:
        HSImageView r112 = r102.T3();
        if (r112 == null) goto L25;
        h r113 = r102.f70540e;
        if (r113 != null) goto L21;
    L23:
        float r114 = 0.5f;
    L24:
        r112.setAlpha(r114);
        goto L25
    L21:
        if (r113.g() != true) goto L23;
        r114 = 1.0f;
        goto L24
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_ktv_adjust_tuning, r100, false);
        if (this.f70528d == false) goto L7;
        TextView r103 = (TextView) r102.findViewById(R.id.tuning_title);
        if (r103 == null) goto L7;
        r103.setTextSize(14.0f);
    L7:
        Unit r104 = Unit.INSTANCE;
        return new TuningEffectViewHolder(r102, this.f70527c);
    }
}
