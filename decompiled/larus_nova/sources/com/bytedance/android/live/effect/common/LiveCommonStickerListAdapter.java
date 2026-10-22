package com.bytedance.android.live.effect.common;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter$StickerViewHolder;", "", "StickerViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerListAdapter extends RecyclerView.Adapter<StickerViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f67814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f67815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Sticker> f67816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Long> f67817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f67818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f67819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveEffectScene f67821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f67822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f67823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.c f67824k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerListAdapter$StickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StickerViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f67825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f67826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f67827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f67828d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f67829e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f67830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final MarqueeTextView f67831g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f67832h;

        public StickerViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f67825a = r100.findViewById(R.id.icon_cover);
            this.f67826b = (ImageView) r100.findViewById(R.id.image);
            this.f67827c = r100.findViewById(R.id.select_border);
            this.f67828d = r100.findViewById(R.id.download_icon);
            this.f67829e = r100.findViewById(R.id.loading);
            this.f67830f = r100.findViewById(R.id.dot);
            this.f67831g = (MarqueeTextView) r100.findViewById(R.id.title);
            this.f67832h = (TextView) r100.findViewById(R.id.sticker_item_view_tips);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f67816c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        StickerViewHolder r101 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.itemView.post(new k(this, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        StickerViewHolder r101 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        r101.itemView.post(new l(this, r101));
    }

    public final void z2(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        List<Long> r101 = this.f67817d;
        ArrayList r102 = (ArrayList) r101;
        int r103 = r102.indexOf(Long.valueOf(r100.getId()));
        if (r103 < 0) goto L6;
        ListProtector.set(this.f67816c, r103, r100);
        notifyItemChanged(r103, WsConstants.KEY_PAYLOAD);
        return;
    }

    public static void E2(Sticker r100, StickerViewHolder r101) {
        if (r100.getTopTips().length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        TextView r103 = r101.f67832h;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
        r101.f67832h.setText(r100.getTopTips());
        return;
    L14:
        return;
    L10:
        TextView r104 = r101.f67832h;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
        return;
    L16:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void A2(Sticker r100, StickerViewHolder r101) {
        if (this.f67819f == true) goto L16;
        boolean r102 = true;
        if (r100.isAigcSticker() == true) goto L8;
    L17:
        if (r102 == false) goto L24;
        View r103 = r101.f67825a;
        if (r103 == null) goto L21;
        r103.setVisibility(4);
    L21:
        MarqueeTextView r104 = r101.f67831g;
        if (r104 == null) goto L31;
        r104.setTextColor(-1);
        return;
    L31:
        return;
    L24:
        View r105 = r101.f67825a;
        if (r105 == null) goto L27;
        r105.setVisibility(0);
    L27:
        MarqueeTextView r106 = r101.f67831g;
        if (r106 == null) goto L33;
        r106.setTextColor(s1.h(R.color.ttlive_effect_sticker_item_unavailable_title_color));
        return;
    L33:
        return;
    L8:
        if ((!((com.bytedance.android.live.effect.sticker.presenter.s) this.f67815b.getValue()).i(r100.getId()).isEmpty()) == true) goto L10;
    L12:
        boolean r107 = false;
    L14:
        if (this.f67821h != LiveEffectScene.Live) goto L17;
        if (r107 == true) goto L17;
    L10:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.f67815b.getValue()).g(r100.getId()) == false) goto L12;
        r107 = true;
    L16:
        r102 = false;
        goto L17
    }

    public final void B2(Sticker r100, StickerViewHolder r101) {
        int r102 = 0;
        if (r100.isAigcSticker() == true) goto L5;
    L7:
        View r103 = r101.f67829e;
        if (r103 != null) goto L10;
    L14:
        View r104 = r101.f67828d;
        if (r104 != null) goto L17;
        return;
    L17:
        if (r100.isDownloaded() == false) goto L19;
        r102 = 8;
    L19:
        r104.setVisibility(r102);
        return;
    L10:
        if (r100.isDownloading() == false) goto L12;
        int r105 = 0;
    L13:
        r103.setVisibility(r105);
        goto L14
    L12:
        r105 = 8;
        goto L13
    L5:
        if (((com.bytedance.android.live.effect.sticker.presenter.s) this.f67815b.getValue()).f68379k == true) goto L7;
        r100.setDownloaded(false);
        goto L7
    }

    public final void C2(MarqueeTextView r100, boolean r101) {
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

    public final void D2(Sticker r100, StickerViewHolder r101) {
        if (this.f67818e != r100.getId()) goto L5;
        boolean r102 = true;
    L6:
        String r103 = "";
        if (r102 == false) goto L23;
        View r104 = r101.f67827c;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        r100.setDownloaded(true);
        View r105 = r101.f67828d;
        if (r105 == null) goto L15;
        r105.setVisibility(4);
    L15:
        if (r100.getName() == null) goto L22;
        String r106 = r100.getName();
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        if (r106.length() <= 5) goto L22;
        C2(r101.f67831g, true);
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
        C2(r101.f67831g, false);
        goto L27
    L23:
        View r110 = r101.f67827c;
        if (r110 == null) goto L26;
        r110.setVisibility(4);
    L26:
        C2(r101.f67831g, false);
        goto L27
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((StickerViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new StickerViewHolder(this.f67823j.f67868a.a(r100.getContext()));
    }

    public final void y2(StickerViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Sticker r102 = (Sticker) ListProtector.get(this.f67816c, r101);
        if ((r100.f67826b instanceof SimpleDraweeView) == false) goto L11;
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder();
        UrlModel r104 = r102.getIcon();
        if (r104 == null) goto L9;
        List<String> r105 = r104.getUrlList();
        if (r105 == null) goto L9;
        String r106 = (String) CollectionsKt.firstOrNull(r105);
    L10:
        AbstractDraweeController r107 = r103.setUri(r106).setAutoPlayAnimations(true).build();
        ((SimpleDraweeView) r100.f67826b).setController(r107);
    L16:
        MarqueeTextView r108 = r100.f67831g;
        if (r108 == null) goto L19;
        r108.setText(r102.getName());
    L19:
        A2(r102, r100);
        ((com.bytedance.android.live.effect.api.l) this.f67814a.getValue()).a(r102.getEffect(), true, new m(this, r102, r100));
        D2(r102, r100);
        E2(r102, r100);
        r100.itemView.setOnClickListener(new n(this, r102));
        return;
    L9:
        r106 = null;
        goto L10
    L11:
        UrlModel r109 = r102.getIcon();
        if (r109 == null) goto L16;
        py.k r110 = r109.toImgModel();
        if (r110 == null) goto L16;
        ImageUtil.loadImage(r100.f67826b, r110, 0);
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        StickerViewHolder r103 = (StickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        y2(r103, r101);
        return;
    L5:
        Sticker r104 = (Sticker) ListProtector.get(this.f67816c, r101);
        A2(r104, r103);
        B2(r104, r103);
        D2(r104, r103);
        E2(r104, r103);
        r103.itemView.setOnClickListener(new n(this, r104));
    }

    public LiveCommonStickerListAdapter(LiveEffectContextFactoryDelegate$Type r100, LiveEffectScene r101, String r102, o r103, LiveCommonStickerListView$stickerListAdapterListener$2.a r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "tabKey");
        Intrinsics.checkNotNullParameter(r103, "styleConfig");
        Intrinsics.checkNotNullParameter(r104, "liveStickerListAdapterListener");
        this.f67820g = r100;
        this.f67821h = r101;
        this.f67822i = r102;
        this.f67823j = r103;
        this.f67824k = r104;
        this.f67814a = LazyKt.lazy(new LiveCommonStickerListAdapter$liveStickerDownloadHelper$2(this));
        this.f67815b = LazyKt.lazy(new LiveCommonStickerListAdapter$aigcTaskManager$2(this));
        this.f67816c = new ArrayList();
        this.f67817d = new ArrayList();
    }
}
