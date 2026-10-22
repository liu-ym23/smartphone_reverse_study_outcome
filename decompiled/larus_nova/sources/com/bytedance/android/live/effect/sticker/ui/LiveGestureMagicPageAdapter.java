package com.bytedance.android.live.effect.sticker.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class LiveGestureMagicPageAdapter extends RecyclerView.Adapter<a> {

    public class a extends RecyclerView.ViewHolder {
        public a(View r100) {
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.image);
            RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.recycler_view);
            r102.setLayoutManager(new LinearLayoutManager(r100.getContext(), 0, false));
            r102.addItemDecoration(new LiveGestureListItemDecoration());
        }
    }

    public interface b {
        void a(Boolean r100, Sticker r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (Lists.isEmpty(null) == false) goto L6;
        return 0;
    L6:
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
        new ArrayList();
        EffectCategoryResponse r103 = (EffectCategoryResponse) ListProtector.get(null, r101);
        new ImageModel();
        new ArrayList();
        r103.getId();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new a(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_item_live_gesture_magic_composer_page, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        a r103 = (a) r100;
        EffectCategoryResponse r104 = (EffectCategoryResponse) ListProtector.get(null, r101);
        new ImageModel();
        new ArrayList();
        r104.getId();
        throw null;
    }
}
