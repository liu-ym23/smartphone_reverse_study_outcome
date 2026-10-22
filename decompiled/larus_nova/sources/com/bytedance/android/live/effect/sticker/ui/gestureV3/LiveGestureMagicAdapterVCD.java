package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class LiveGestureMagicAdapterVCD extends RecyclerView.Adapter<a> implements k.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f68545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveGestureMagicPageAdapter.b f68547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Sticker f68548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Sticker> f68549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EffectCategoryResponse f68550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Sticker f68551g;

    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f68552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f68553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f68554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ProgressBar f68555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f68556e;

        public a(View r100) {
            super(r100);
            this.f68552a = (ImageView) r100.findViewById(R.id.image);
            this.f68553b = r100.findViewById(R.id.background);
            this.f68554c = r100.findViewById(R.id.download_icon);
            this.f68555d = (ProgressBar) r100.findViewById(R.id.loading);
            this.f68556e = r100.findViewById(R.id.red_point);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (Lists.isEmpty(this.f68549e) == false) goto L7;
        return 0;
    L7:
        return ((ArrayList) this.f68549e).size();
    }

    public LiveGestureMagicAdapterVCD(LiveEffectContextFactoryDelegate$Type r100) {
        this.f68546b = r100;
        List<String> r101 = LiveEffectContext.f66734h;
        this.f68545a = LiveEffectContext.a.a(r100).b().r();
        this.f68549e = new ArrayList();
    }

    public final int z2(Sticker r100) {
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f68549e).size()) goto L10;
        if (Sticker.equals(r100, (Sticker) ListProtector.get(this.f68549e, r101)) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        ListProtector.set(this.f68549e, r101, r100);
        return r101;
    L10:
        return -1;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r100, Sticker r101) {
        Logger.d("LiveGestureMagicAdapterVCD", "download success response: " + this.f68550f.getId() + " sticker: " + r101.getId() + " path: " + r101.getUnzipPath());
        if (r101.getId() != this.f68551g.getId()) goto L8;
        LiveGestureMagicPageAdapter.b r102 = this.f68547c;
        if (r102 == null) goto L8;
        r102.a(Boolean.FALSE, this.f68548d);
        this.f68548d = r101;
        this.f68547c.a(Boolean.TRUE, r101);
    L8:
        if (z2(r101) < 0) goto L11;
        notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r100, Sticker r101) {
        Logger.d("LiveGestureMagicAdapterVCD", "download start response: " + this.f68550f.getId() + " sticker: " + r101.getId() + " path: " + r101.getUnzipPath());
        if (z2(r101) < 0) goto L6;
        notifyDataSetChanged();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final a r102 = (a) r100;
        final Sticker r103 = (Sticker) ListProtector.get(this.f68549e, r101);
        int r104 = 0;
        ImageUtil.loadImage(r102.f68552a, r103.getIcon().toImgModel(), 0);
        Sticker r105 = this.f68548d;
        if (r105 != null) goto L5;
    L7:
        r102.f68553b.setVisibility(8);
    L8:
        ProgressBar r106 = r102.f68555d;
        if (r103.isDownloading() == false) goto L11;
        int r107 = 0;
    L12:
        r106.setVisibility(r107);
        View r108 = r102.f68554c;
        if (r103.isDownloaded() == false) goto L15;
    L16:
        r104 = 8;
    L17:
        r108.setVisibility(r104);
        y2(r103, new c(r102));
        StringBuilder r109 = new StringBuilder();
        Sticker r110 = this.f68548d;
        if (r110 != null) goto L20;
    L22:
        r109.append("未选中 ");
    L23:
        r109.append(r103.getName());
        r102.itemView.setContentDescription(r109);
        r102.itemView.setOnClickListener(new com.bytedance.android.live.effect.sticker.ui.gestureV3.a(this, r103, r102));
        return;
    L20:
        if (Sticker.equals(r110, r103) == false) goto L22;
        r109.append("已选中 ");
        goto L23
    L15:
        if (r103.isDownloading() == false) goto L17;
    L11:
        r107 = 8;
        goto L12
    L5:
        if (Sticker.equals(r105, r103) == false) goto L7;
        r102.f68553b.setVisibility(0);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new a(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_item_live_gesture_magic_composer_vcd, r100, false));
    }

    public final void y2(Sticker r100, IIsTagNeedUpdatedListener r101) {
        if (r100 != null) goto L4;
    L10:
        r101.onTagNeedNotUpdate();
        return;
    L4:
        if (Lists.isEmpty(r100.getTags()) == true) goto L10;
        if (r100.getTags().contains("new") == false) goto L10;
        this.f68545a.b(r100.getRealId(), r100.getTagsUpdatedAt(), r101);
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r100, Sticker r101, ExceptionResult r102) {
        f2.b(R.string.ttlive_effect_live_download_fail_tip, 0);
        Logger.d("LiveGestureMagicAdapterVCD", "download fail response: " + this.f68550f.getId() + " sticker: " + r101.getId() + " path: " + r101.getUnzipPath());
        if (z2(r101) < 0) goto L6;
        notifyDataSetChanged();
        return;
    }
}
