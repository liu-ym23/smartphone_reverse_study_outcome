package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.live.effect.sticker.ui.StickerItemView;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter$StickerViewHolder;", "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerDialogListAdapter extends RecyclerView.Adapter<StickerViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f68597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Sticker> f68598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Long> f68599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f68600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveEffectScene f68602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f68603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f68604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakReference<RecyclerView> f68605k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogListAdapter$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f68606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f68607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f68608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f68609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f68610e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f68611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final MarqueeTextView f68612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f68613h;

        public StickerViewHolder(StickerItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f68606a = r100.findViewById(R.id.icon_cover);
            this.f68607b = (ImageView) r100.findViewById(R.id.image);
            this.f68608c = r100.findViewById(R.id.select_border);
            this.f68609d = r100.findViewById(R.id.download_icon);
            this.f68610e = r100.findViewById(R.id.loading);
            this.f68611f = r100.findViewById(R.id.dot);
            this.f68612g = (MarqueeTextView) r100.findViewById(R.id.title);
            this.f68613h = (TextView) r100.findViewById(R.id.sticker_item_view_tips);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f68598d).size();
    }

    public final StickerDialogUIViewModel z2() {
        StickerBaseViewModel.a r100 = StickerBaseViewModel.Companion;
        LiveEffectScene r101 = this.f68602h;
        r100.getClass();
        return (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r101, StickerDialogUIViewModel.class);
    }

    public final void C2() {
        StickerDialogUIViewModel r100 = z2();
        if (r100 == null) goto L7;
        LiveData<Sticker> r101 = r100.getCurrentSelectStickerData();
        if (r101 == null) goto L7;
        Sticker r102 = r101.getValue();
    L8:
        if (r102 == null) goto L10;
        long r103 = r102.getId();
    L11:
        long r104 = this.f68600f;
        this.f68600f = r103;
        List<Long> r105 = this.f68599e;
        ArrayList r106 = (ArrayList) r105;
        int r107 = r106.indexOf(Long.valueOf(r103));
        if (r102 == null) goto L17;
        if (r107 < 0) goto L17;
        if (r107 >= ((ArrayList) this.f68598d).size()) goto L17;
        ListProtector.set(this.f68598d, r107, r102);
    L17:
        List<Long> r108 = this.f68599e;
        ArrayList r109 = (ArrayList) r108;
        if (r109.contains(Long.valueOf(r104)) == true) goto L20;
    L22:
        List<Long> r110 = this.f68599e;
        ArrayList r111 = (ArrayList) r110;
        if (r111.contains(Long.valueOf(this.f68600f)) == true) goto L25;
        return;
    L25:
        if (r104 == this.f68600f) goto L29;
        notifyItemChanged(r107, WsConstants.KEY_PAYLOAD);
        return;
    L29:
        return;
    L20:
        if (r104 == this.f68600f) goto L22;
        List<Long> r112 = this.f68599e;
        ArrayList r113 = (ArrayList) r112;
        notifyItemChanged(r113.indexOf(Long.valueOf(r104)), WsConstants.KEY_PAYLOAD);
        goto L22
    L10:
        r103 = 0;
    L7:
        r102 = null;
        goto L8
    }

    public final void B2(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        List<Long> r101 = this.f68599e;
        ArrayList r102 = (ArrayList) r101;
        int r103 = r102.indexOf(Long.valueOf(r100.getId()));
        if (r103 < 0) goto L6;
        ListProtector.set(this.f68598d, r103, r100);
        notifyItemChanged(r103, WsConstants.KEY_PAYLOAD);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        StickerViewHolder r101 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.itemView.post(new e(this, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        StickerViewHolder r101 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        Sticker r102 = (Sticker) CollectionsKt.getOrNull(this.f68598d, r101.getAdapterPosition());
        if (r102 == null) goto L8;
        StickerDialogUIViewModel r103 = z2();
        if (r103 == null) goto L9;
        r103.onStickerViewDetached(this.f68603i, r102);
        return;
    L9:
        return;
    }

    public final void y2(List<Sticker> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        StickerDialogUIViewModel r101 = z2();
        if (r101 == null) goto L7;
        LiveData<Sticker> r102 = r101.getCurrentSelectStickerData();
        if (r102 == null) goto L7;
        Sticker r103 = r102.getValue();
    L8:
        if (r103 == null) goto L10;
        long r104 = r103.getId();
    L11:
        this.f68600f = r104;
        ((ArrayList) this.f68598d).clear();
        ArrayList r105 = (ArrayList) this.f68598d;
        r105.addAll(r100);
        ((ArrayList) this.f68599e).clear();
        List<Long> r106 = this.f68599e;
        List<Sticker> r107 = this.f68598d;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = ((ArrayList) r107).iterator();
    L13:
        if (r109.hasNext() == false) goto L15;
        r108.add(Long.valueOf(((Sticker) r109.next()).getId()));
        goto L13
    L15:
        ((ArrayList) r106).addAll(r108);
        notifyDataSetChanged();
        return;
    L10:
        r104 = 0;
    L7:
        r103 = null;
        goto L8
    }

    public static void D2(Sticker r100, StickerViewHolder r101) {
        View r102 = r101.f68610e;
        int r103 = 8;
        if (r102 != null) goto L5;
    L9:
        View r104 = r101.f68609d;
        if (r104 != null) goto L12;
        return;
    L12:
        if (r100.isDownloaded() == true) goto L15;
        r103 = 0;
    L15:
        r104.setVisibility(r103);
        return;
    L5:
        if (r100.isDownloading() == false) goto L7;
        int r105 = 0;
    L8:
        r102.setVisibility(r105);
        goto L9
    L7:
        r105 = 8;
        goto L8
    }

    public static void G2(Sticker r100, StickerViewHolder r101) {
        if (r100.getTopTips().length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        TextView r103 = r101.f68613h;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
        r101.f68613h.setText(r100.getTopTips());
        return;
    L14:
        return;
    L10:
        TextView r104 = r101.f68613h;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
        return;
    L16:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void A2(StickerViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Sticker r102 = (Sticker) ListProtector.get(this.f68598d, r101);
        UrlModel r103 = r102.getIcon();
        if (r103 == null) goto L7;
        py.k r104 = r103.toImgModel();
        if (r104 == null) goto L7;
        ImageUtil.loadImage(r100.f68607b, r104, 0);
    L7:
        MarqueeTextView r105 = r100.f68612g;
        if (r105 == null) goto L11;
        r105.setText(r102.getName());
    L11:
        if (r102.isAigcSticker() == true) goto L13;
        View r106 = r100.f68606a;
        if (r106 == null) goto L40;
        r106.setVisibility(4);
    L40:
        MarqueeTextView r107 = r100.f68612g;
        if (r107 == null) goto L43;
        r107.setTextColor(-1);
    L43:
        ((com.bytedance.android.live.effect.sticker.presenter.o) this.f68595a.getValue()).g(r102, true, new f(this, r102, r100));
        F2(r102, r100);
        G2(r102, r100);
        r100.itemView.setOnClickListener(new g(this, r102));
        return;
    L13:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.f68596b.getValue()).f68379k == true) goto L16;
        r102.setDownloaded(false);
    L16:
        if ((!((com.bytedance.android.live.effect.sticker.presenter.s) this.f68596b.getValue()).i(r102.getId()).isEmpty()) == true) goto L18;
    L20:
        boolean r108 = false;
    L22:
        if (d.f68729a[this.f68602h.ordinal()] != 1) goto L43;
        if (r108 == true) goto L31;
        View r109 = r100.f68606a;
        if (r109 == null) goto L28;
        r109.setVisibility(0);
    L28:
        MarqueeTextView r110 = r100.f68612g;
        if (r110 == null) goto L43;
        r110.setTextColor(s1.h(R.color.ttlive_effect_sticker_item_unavailable_title_color));
        goto L43
    L31:
        View r111 = r100.f68606a;
        if (r111 == null) goto L34;
        r111.setVisibility(4);
    L34:
        MarqueeTextView r112 = r100.f68612g;
        if (r112 == null) goto L43;
        r112.setTextColor(-1);
        goto L43
    L18:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.f68596b.getValue()).g(r102.getId()) == false) goto L20;
        r108 = true;
        goto L22
    }

    public final void E2(MarqueeTextView r100, boolean r101) {
        if (r100 == null) goto L4;
        r100.setMarqueeEnable(r101);
    L4:
        if (r100 == null) goto L6;
        r100.setSelected(r101);
    L6:
        if (r100 == null) goto L11;
        if (r101 == false) goto L9;
        TextUtils.TruncateAt r102 = TextUtils.TruncateAt.MARQUEE;
    L10:
        r100.setEllipsize(r102);
        goto L11
    L9:
        r102 = null;
    L11:
        if (r100 == null) goto L17;
        if (r101 == false) goto L14;
        int r103 = GravityCompat.START;
    L15:
        r100.setGravity(r103);
        return;
    L14:
        r103 = 17;
        goto L15
    }

    public final void F2(Sticker r100, StickerViewHolder r101) {
        if (this.f68600f != r100.getId()) goto L5;
        boolean r102 = true;
    L6:
        String r103 = "";
        if (r102 == false) goto L23;
        View r104 = r101.f68608c;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        r100.setDownloaded(true);
        View r105 = r101.f68609d;
        if (r105 == null) goto L15;
        r105.setVisibility(4);
    L15:
        if (r100.getName() == null) goto L22;
        String r106 = r100.getName();
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        if (r106.length() <= 5) goto L22;
        E2(r101.f68612g, true);
    L27:
        r101.itemView.setFocusable(true);
        r101.itemView.setImportantForAccessibility(1);
        View r107 = r101.itemView;
        String r108 = r100.getName();
        if (r108 == null) goto L31;
        r103 = r108;
    L31:
        if (r102 == false) goto L33;
        String r109 = " 已选中";
    L34:
        r107.setContentDescription(r103.concat(r109));
        return;
    L33:
        r109 = " 未选中";
    L22:
        E2(r101.f68612g, false);
        goto L27
    L23:
        View r110 = r101.f68608c;
        if (r110 == null) goto L26;
        r110.setVisibility(4);
    L26:
        E2(r101.f68612g, false);
        goto L27
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        A2((StickerViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new StickerViewHolder(new StickerItemView(r100.getContext(), null, 6, 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        StickerViewHolder r103 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        A2(r103, r101);
        return;
    L5:
        Sticker r104 = (Sticker) ListProtector.get(this.f68598d, r101);
        D2(r104, r103);
        F2(r104, r103);
        G2(r104, r103);
        r103.itemView.setOnClickListener(new g(this, r104));
    }

    public LiveStickerDialogListAdapter(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102, String r103, WeakReference<RecyclerView> r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "tabKey");
        Intrinsics.checkNotNullParameter(r103, "parentTabKey");
        Intrinsics.checkNotNullParameter(r104, "recyclerViewWeakReference");
        this.f68601g = r100;
        this.f68602h = r101;
        this.f68603i = r102;
        this.f68604j = r103;
        this.f68605k = r104;
        this.f68595a = LazyKt.lazy(new LiveStickerDialogListAdapter$stickerDataManager$2(this));
        this.f68596b = LazyKt.lazy(new LiveStickerDialogListAdapter$aigcTaskManager$2(this));
        this.f68597c = LazyKt.lazy(new LiveStickerDialogListAdapter$stickerPresenter$2(this));
        this.f68598d = new ArrayList();
        this.f68599e = new ArrayList();
    }
}
