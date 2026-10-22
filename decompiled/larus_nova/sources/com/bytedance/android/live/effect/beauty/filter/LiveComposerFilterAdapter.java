package com.bytedance.android.live.effect.beauty.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.makeups.LiveMakeupsBeautyAdapter;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterAdapter$ComposerFilterViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", ce.f26391f, "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "ComposerFilterViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveComposerFilterAdapter extends RecyclerView.Adapter<ComposerFilterViewHolder> implements ILiveEffectComposerManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f67221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f67222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f67223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f67224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.effect.beauty.filter.a f67225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f67226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f67228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LiveMakeupsBeautyAdapter.a f67229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f67230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f67231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f67232l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterAdapter$ComposerFilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ComposerFilterViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f67233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SimpleDraweeView f67234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f67235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f67236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f67237e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f67238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f67239g;

        public ComposerFilterViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f67233a = r100.findViewById(R.id.border);
            this.f67234b = (SimpleDraweeView) r100.findViewById(R.id.iv_bg);
            this.f67235c = (TextView) r100.findViewById(R.id.tv_name);
            this.f67236d = r100.findViewById(R.id.iv_loading);
            this.f67237e = r100.findViewById(R.id.item_filter_dot);
            this.f67238f = r100.findViewById(R.id.cl_tag);
            this.f67239g = r100.findViewById(R.id.use_status_indicator);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveComposerFilterAdapter f67240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f67241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f67242c;

        public a(LiveComposerFilterAdapter r100, Sticker r101, int r102) {
            this.f67240a = r100;
            this.f67241b = r101;
            this.f67242c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveComposerFilterAdapter r101 = this.f67240a;
            if (r101.f67223c == false) goto L6;
            r101.f67229i.a(this.f67241b);
            LiveComposerFilterAdapter r102 = this.f67240a;
            r102.notifyItemChanged(r102.f67224d);
            this.f67240a.notifyItemChanged(this.f67242c);
            LiveComposerFilterAdapter r103 = this.f67240a;
            r103.f67224d = this.f67242c;
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f67221a).size();
    }

    public final Context getContext() {
        return this.f67226f;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67227g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((ComposerFilterViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ComposerFilterViewHolder(LayoutInflater.from(this.f67226f).inflate(this.f67228h, r100, false));
    }

    public final void y2(final ComposerFilterViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        Sticker r100 = (Sticker) ListProtector.get(this.f67221a, r111);
        List<String> r101 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r102 = LiveEffectContext.a.a(this.f67227g).a();
        String r103 = d0.f66751a;
        Sticker r104 = (Sticker) CollectionsKt.firstOrNull(r102.o(r103));
        if (r104 == null) goto L6;
        String r105 = r104.getResourceId();
        if (r105 == null) goto L6;
    L7:
        final boolean r106 = Intrinsics.areEqual(r105, r100.getResourceId());
        if (r106 == false) goto L19;
        r110.f67233a.setVisibility(0);
        if (this.f67232l == false) goto L12;
        int r107 = R.color.ttlive_effect_broadcast_preview_beauty_item_text_color_red;
    L13:
        r110.f67235c.setTextColor(s1.h(r107));
        if (this.f67231k == false) goto L18;
        View r108 = r110.f67239g;
        if (r108 == null) goto L18;
        r108.setSelected(true);
    L18:
        this.f67224d = r111;
    L25:
        if (r100.getEffect() != null) goto L31;
        r110.f67236d.setVisibility(4);
        r110.f67235c.setText(s1.B(R.string.ttlive_effect_makeups_none));
        r110.f67234b.setImageResource(R.drawable.ttlive_effect_ic_start_live_no_select);
        r110.f67237e.setVisibility(4);
        r110.f67238f.setVisibility(4);
        if (this.f67231k == false) goto L68;
        View r109 = r110.f67239g;
        if (r109 == null) goto L68;
        r109.setVisibility(4);
    L68:
        r110.itemView.setOnClickListener(new a(this, r100, r111));
        r3.e(r110.itemView, new AnonymousClass3(r106, r110));
        return;
    L31:
        UrlModel r112 = r100.getIcon();
        if (r112 != null) goto L34;
    L37:
        r110.f67235c.setText(r100.getName());
        if (LiveEffectContext.a.a(this.f67227g).b().r().q(r100) == false) goto L40;
        r110.f67236d.setVisibility(4);
    L47:
        List<String> r113 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67227g).b().h().c() == false) goto L54;
        List<String> r114 = r100.getTags();
        if (r114 == null) goto L54;
        if (r114.contains("outer_test") != true) goto L54;
        r110.f67238f.setVisibility(0);
    L56:
        if (this.f67231k == true) goto L58;
        View r115 = r110.f67239g;
        if (r115 == null) goto L68;
        r115.setVisibility(4);
        goto L68
    L58:
        if (LiveEffectContext.a.a(this.f67227g).a().E(r100) == false) goto L62;
        View r116 = r110.f67239g;
        if (r116 == null) goto L68;
        r116.setVisibility(0);
        goto L68
    L62:
        View r117 = r110.f67239g;
        if (r117 == null) goto L68;
        r117.setVisibility(4);
    L54:
        r110.f67238f.setVisibility(4);
        goto L56
    L40:
        r110.f67236d.setVisibility(0);
        LiveComposerFilterHelper r118 = LiveEffectContext.a.a(this.f67227g).b().m();
        String r119 = this.f67230j;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r119, "page");
        if (LiveEffectContext.a.a(r118.f67272d).b().r().q(r100) == false) goto L46;
        Iterator r120 = ((ArrayList) r118.f67271c).iterator();
    L44:
        if (r120.hasNext() == false) goto L47;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r120.next()).a(r100);
        goto L44
    L46:
        LiveEffectContext.a.a(r118.f67272d).b().r().g(r103, r100, new i(r118));
        goto L47
    L34:
        if (this.f67231k == false) goto L36;
        ImageUtil.loadRoundImageWithRadius(r110.f67234b, new ImageModel(r112.getUri(), r112.getUrlList()), s1.f(8.0f));
        goto L37
    L36:
        ImageUtil.loadRoundImage(r110.f67234b, new ImageModel(r112.getUri(), r112.getUrlList()));
        goto L37
    L12:
        r107 = R.color.ttlive_effect_broadcast_preview_beauty_item_text_color;
        goto L13
    L19:
        r110.f67233a.setVisibility(4);
        r110.f67235c.setTextColor(s1.h(R.color.ttlive_effect_broadcast_beauty_new_style_unselected));
        if (this.f67231k == false) goto L25;
        View r121 = r110.f67239g;
        if (r121 == null) goto L25;
        r121.setSelected(false);
    L6:
        r105 = "";
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        ComposerFilterViewHolder r103 = (ComposerFilterViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        y2(r103, r101);
        return;
    L5:
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r101 >= ((ArrayList) this.f67221a).size()) goto L23;
        List<String> r104 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67227g).a().E((Sticker) ListProtector.get(this.f67221a, r101)) == false) goto L14;
        View r105 = r103.f67239g;
        if (r105 == null) goto L20;
        r105.setVisibility(0);
        return;
    L20:
        return;
    L14:
        View r106 = r103.f67239g;
        if (r106 == null) goto L22;
        r106.setVisibility(4);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r100, Sticker r101, String r102, float r103) {
        ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r100, Sticker r101, String r102, float r103, HashMap<String, String> r104) {
        if (Intrinsics.areEqual(r100, d0.f66751a) == false) goto L14;
        List<String> r105 = this.f67222b;
        if (r101 == null) goto L7;
        String r106 = r101.getEffectId();
    L8:
        int r107 = CollectionsKt.indexOf(r105, r106);
        if (r107 >= 0) goto L11;
        return;
    L11:
        if (r107 >= ((ArrayList) this.f67222b).size()) goto L16;
        notifyItemChanged(r107, "tagValueChangeListener");
        return;
    L16:
        return;
    L7:
        r106 = null;
        goto L8
    }

    public LiveComposerFilterAdapter(Context r100, LiveEffectContextFactoryDelegate$Type r101, int r102, LiveComposerFilterFragment$filterAdapter$2.a r103, String r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "selectItemChangeListener");
        Intrinsics.checkNotNullParameter(r104, "page");
        this.f67226f = r100;
        this.f67227g = r101;
        this.f67228h = r102;
        this.f67229i = r103;
        this.f67230j = r104;
        this.f67231k = r105;
        this.f67232l = r106;
        if (r102 != (-1)) goto L8;
        if (r106 == false) goto L6;
        int r107 = R.layout.ttlive_effect_item_live_filter_c_v2;
    L7:
        this.f67228h = r107;
        goto L8
    L6:
        r107 = R.layout.ttlive_effect_item_live_filter_c;
    L8:
        this.f67221a = new ArrayList();
        this.f67222b = new ArrayList();
        this.f67223c = true;
        this.f67225e = new com.bytedance.android.live.effect.beauty.filter.a(this);
    }
}
