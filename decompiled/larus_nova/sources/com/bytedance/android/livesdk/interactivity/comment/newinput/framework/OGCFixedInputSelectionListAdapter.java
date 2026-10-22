package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/OGCFixedInputSelectionListAdapter;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OGCFixedPageSelectionViewHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedInputSelectionListAdapter extends SelectionListAdapter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f135469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f135470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f135471j;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/OGCFixedInputSelectionListAdapter$OGCFixedPageSelectionViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter$PageSelectionViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class OGCFixedPageSelectionViewHolder extends SelectionListAdapter.PageSelectionViewHolder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OGCFixedInputSelectionListAdapter f135472c;

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter.PageSelectionViewHolder
        public final void T3(boolean r100) {
            if (r100 == false) goto L5;
            ((TextView) this.itemView.findViewById(R.id.section_title)).setTextColor(((Number) this.f135472c.f135469h.getValue()).intValue());
            ((TextView) this.itemView.findViewById(R.id.section_title)).setAlpha(1.0f);
            this.itemView.setBackground((GradientDrawable) this.f135472c.f135470i.getValue());
            return;
        L5:
            ((TextView) this.itemView.findViewById(R.id.section_title)).setTextColor(((Number) this.f135472c.f135469h.getValue()).intValue());
            ((TextView) this.itemView.findViewById(R.id.section_title)).setAlpha(0.75f);
            this.itemView.setBackground(null);
        }

        public OGCFixedPageSelectionViewHolder(OGCFixedInputSelectionListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f135472c = r100;
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter
    public final SelectionListAdapter.PageSelectionViewHolder z2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new OGCFixedPageSelectionViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_ogc_fixed_item_section, r100, false));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100);
    }

    public OGCFixedInputSelectionListAdapter(String r100, RecyclerView r101, List<? extends com.bytedance.android.livesdk.interactivity.api.input.viewpager.c> r102) {
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "data");
        super(r101, r102);
        this.f135471j = r100;
        this.f135469h = LazyKt.lazy(new OGCFixedInputSelectionListAdapter$ogcSelectedColor$2(this));
        this.f135470i = LazyKt.lazy(new OGCFixedInputSelectionListAdapter$ogcSelectedDrawable$2(this));
    }
}
