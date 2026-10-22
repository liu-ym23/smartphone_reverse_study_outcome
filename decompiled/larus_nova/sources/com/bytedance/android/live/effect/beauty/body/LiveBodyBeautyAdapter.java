package com.bytedance.android.live.effect.beauty.body;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/body/LiveBodyBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBodyBeautyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f67116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f67117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f67118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f67119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<Boolean> f67120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<Integer> f67121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f67122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f67123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f67124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f67125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f67126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67127l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f67128m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f67129n;

    public interface a {
        void a(Sticker r100);

        void b(boolean r100);

        void c(Sticker r100);
    }

    public static final class b extends RecyclerView.ViewHolder {

        public static final class a {
        }

        static {
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class c implements LiveSmallItemBeautyHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBodyBeautyAdapter f67130a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f67131a;

            public a(c r100) {
                this.f67131a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f67131a.f67130a.notifyDataSetChanged();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void onError() {
        }

        public c(LiveBodyBeautyAdapter r100) {
            this.f67130a = r100;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            ((Handler) this.f67130a.f67122g.getValue()).post(new a(this));
        }
    }

    public final boolean z2() {
        LiveEffectContextFactoryDelegate$Type r100 = this.f67127l;
        if (r100 != LiveEffectContextFactoryDelegate$Type.DEFAULT) goto L5;
    L8:
        return true;
    L5:
        if (r100 == LiveEffectContextFactoryDelegate$Type.LINK) goto L8;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (z2() == true) goto L6;
        return ((ArrayList) this.f67116a).size();
    L6:
        if (((ArrayList) this.f67116a).size() > 0) goto L11;
        return 0;
    L11:
        return ((ArrayList) this.f67116a).size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (z2() == false) goto L6;
        if (r100 != 0) goto L6;
        return 1;
    L6:
        return 0;
    }

    public final int y2(int r110) {
        int r100 = -1;
        Integer r101 = this.f67121f.get(r110, -1);
        List<Sticker> r111 = ((Sticker) ListProtector.get(this.f67116a, r110)).getSubStickers();
        Integer r102 = null;
        if (r111 == null) goto L21;
        Iterator<Sticker> r112 = r111.iterator();
        int r103 = 0;
    L6:
        if (r112.hasNext() == false) goto L20;
        Sticker r104 = r112.next();
        List<String> r105 = LiveEffectContext.f66734h;
        Iterator<T> r106 = LiveEffectContext.a.a(this.f67127l).a().o(d0.f66759i).iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((Sticker) r107).getEffectId(), r104.getEffectId()) == false) goto L9;
    L14:
        if (r107 == null) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == true) goto L18;
        r103 = r103 + 1;
        goto L6
    L18:
        r100 = r103;
        goto L20
    L16:
        r108 = false;
        goto L17
    L13:
        r107 = null;
    L20:
        r102 = Integer.valueOf(r100);
    L21:
        if (r102 == null) goto L26;
        if (r102.intValue() < 0) goto L26;
        r101 = r102;
    L26:
        return r101.intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        if ((r110 instanceof LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder) == false) goto L108;
        if (z2() == false) goto L7;
        final int r100 = r111 - 1;
    L8:
        final LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r101 = (LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder) r110;
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
        if (this.f67118c != r100) goto L19;
        r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.border).setVisibility(0);
        if (this.f67124i == false) goto L13;
        int r104 = R.color.ttlive_effect_broadcast_preview_beauty_item_text_color_red;
    L14:
        ((TextView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.tv_name)).setTextColor(r101.itemView.getContext().getResources().getColor(r104));
        if (this.f67129n == false) goto L24;
        View r105 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r105 == null) goto L24;
        r105.setSelected(true);
    L24:
        UrlModel r106 = ((Sticker) ListProtector.get(this.f67116a, r100)).getIcon();
        if (r106 == null) goto L27;
        ImageUtil.loadRoundImage((ImageView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.iv_bg), new ImageModel(r106.getUri(), r106.getUrlList()));
    L27:
        ((TextView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.tv_name)).setText(((Sticker) ListProtector.get(this.f67116a, r100)).getName());
        Effect r107 = ((Sticker) ListProtector.get(this.f67116a, r100)).getEffect();
        if (r107 != null) goto L30;
    L34:
        boolean r108 = false;
    L35:
        List<String> r109 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67127l).b().r().q((Sticker) ListProtector.get(this.f67116a, r100)) == true) goto L40;
        if (r108 == true) goto L40;
        ((ImageView) r101.itemView.findViewById(R.id.iv_loading)).setVisibility(0);
        g.c(LiveEffectContext.a.a(this.f67127l).b().p(), (Sticker) ListProtector.get(this.f67116a, r100));
    L41:
        if (r108 == true) goto L43;
    L68:
        r101.itemView.findViewById(R.id.expanded_layout).setVisibility(8);
        r101.itemView.findViewById(R.id.fold_layout).setVisibility(0);
        if (this.f67129n == true) goto L71;
        View r112 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r112 == null) goto L82;
        r112.setVisibility(4);
    L82:
        if (this.f67124i == true) goto L84;
    L91:
        r102.invoke(r101, ListProtector.get(this.f67116a, r100));
        r101.itemView.setOnClickListener(new com.bytedance.android.live.effect.beauty.body.c(this, r101, r108, r103));
        if (LiveEffectContext.a.a(this.f67127l).b().h().c() == false) goto L103;
        List<String> r113 = ((Sticker) ListProtector.get(this.f67116a, r100)).getTags();
        if (r113 == null) goto L103;
        if (r113.contains("outer_test") != true) goto L103;
        ConstraintLayout r114 = (ConstraintLayout) r101.itemView.findViewById(R.id.cl_tag);
        if (r114 == null) goto L100;
        r114.setVisibility(0);
    L100:
        View r115 = r101.itemView.findViewById(R.id.item_filter_dot);
        if (r115 == null) goto L106;
        r115.setVisibility(4);
    L106:
        r3.e(r101.itemView, new LiveBodyBeautyAdapter$onBindBeautyItemViewHolder$6(this, r100, r101));
        return;
    L103:
        ConstraintLayout r116 = (ConstraintLayout) r101.itemView.findViewById(R.id.cl_tag);
        if (r116 == null) goto L106;
        r116.setVisibility(4);
        goto L106
    L84:
        if (LiveEffectContext.a.a(this.f67127l).a().B((Sticker) ListProtector.get(this.f67116a, r100)) == false) goto L88;
        View r117 = r101.itemView.findViewById(R.id.item_change_tips);
        if (r117 == null) goto L91;
        r117.setVisibility(0);
        goto L91
    L88:
        View r118 = r101.itemView.findViewById(R.id.item_change_tips);
        if (r118 == null) goto L91;
        r118.setVisibility(4);
        goto L91
    L71:
        if (LiveEffectContext.a.a(this.f67127l).a().E((Sticker) ListProtector.get(this.f67116a, r100)) == false) goto L75;
        View r119 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r119 == null) goto L82;
        r119.setVisibility(0);
        goto L82
    L75:
        View r120 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r120 == null) goto L82;
        r120.setVisibility(4);
        goto L82
    L43:
        if (this.f67120e.get(r100, Boolean.FALSE).booleanValue() == false) goto L68;
        r101.itemView.findViewById(R.id.expanded_layout).setVisibility(0);
        r101.itemView.findViewById(R.id.fold_layout).setVisibility(8);
        r101.f67591a = new LiveSmallSubItemBeautyAdapter(this.f67124i, this.f67126k, this.f67127l, this.f67129n);
        ((RecyclerView) r101.itemView.findViewById(R.id.sub_beauty_list)).setLayoutManager(new LinearLayoutManager(r101.itemView.getContext(), 0, false));
        ((RecyclerView) r101.itemView.findViewById(R.id.sub_beauty_list)).setAdapter(r101.f67591a);
        int r121 = y2(r100);
        if (r121 < 0) goto L49;
        LiveSmallSubItemBeautyAdapter r122 = r101.f67591a;
        if (r122 == null) goto L49;
        r122.f67649d = r121;
    L49:
        LiveSmallSubItemBeautyAdapter r123 = r101.f67591a;
        if (r123 == null) goto L55;
        List<Sticker> r124 = ((Sticker) ListProtector.get(this.f67116a, r100)).getSubStickers();
        if (r124 != null) goto L54;
        r124 = new ArrayList();
    L54:
        r123.setData(r124);
    L55:
        LiveSmallSubItemBeautyAdapter r125 = r101.f67591a;
        if (r125 == null) goto L58;
        com.bytedance.android.live.effect.beauty.body.a r126 = new com.bytedance.android.live.effect.beauty.body.a(this, r100);
        Intrinsics.checkNotNullParameter(r126, "listener");
        r125.f67650e = r126;
    L58:
        ((TextView) r101.itemView.findViewById(R.id.expanded_layout).findViewById(R.id.sub_beauty_title)).setText(((Sticker) ListProtector.get(this.f67116a, r100)).getName());
        ((ImageView) r101.itemView.findViewById(R.id.expanded_layout).findViewById(R.id.sub_beauty_item_back)).setOnClickListener(new com.bytedance.android.live.effect.beauty.body.b(this, r100, r101));
        List<Sticker> r127 = ((Sticker) ListProtector.get(this.f67116a, r100)).getSubStickers();
        if (r127 == null) goto L82;
        if (r121 > 0) goto L63;
        r121 = 0;
    L63:
        Sticker r128 = (Sticker) ListProtector.get(r127, r121);
        if (r128 == null) goto L82;
        a r129 = this.f67119d;
        if (r129 == null) goto L82;
        r129.a(r128);
    L40:
        ((ImageView) r101.itemView.findViewById(R.id.iv_loading)).setVisibility(8);
        goto L41
    L30:
        if (r107.getEffectType() != 1) goto L34;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(this.f67116a, r100)).getSubStickers()) == true) goto L34;
        r108 = true;
        goto L35
    L13:
        r104 = R.color.ttlive_effect_broadcast_preview_beauty_item_text_color;
        goto L14
    L19:
        r101.itemView.findViewById(R.id.expanded_layout).setVisibility(8);
        r101.itemView.findViewById(R.id.fold_layout).setVisibility(0);
        this.f67120e.put(r100, Boolean.FALSE);
        r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.border).setVisibility(4);
        ((TextView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.tv_name)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        if (this.f67129n == false) goto L24;
        View r130 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r130 == null) goto L24;
        r130.setSelected(false);
        goto L24
    L7:
        r100 = r111;
        goto L8
    L108:
        if ((r110 instanceof b) == false) goto L118;
        b r131 = (b) r110;
        ((LiveSwitchButton) r131.itemView.findViewById(R.id.switch_button)).setChecked(this.f67128m);
        TextView r132 = (TextView) r131.itemView.findViewById(R.id.switch_text);
        if (this.f67128m == false) goto L112;
        int r133 = R.string.ttlive_effect_switch_button_open;
    L113:
        r132.setText(s1.B(r133));
        ((LiveSwitchButton) r131.itemView.findViewById(R.id.switch_button)).setAccessibilityDelegate(new d(r131));
        ((LiveSwitchButton) r131.itemView.findViewById(R.id.switch_button)).setOnCheckedChangeListener(new e(this, r131));
        if (LiveEffectSettings.LIVE_EFFECT_BEAUTY_FIX_TALKBACK_2025_07.getValue().booleanValue() == false) goto L119;
        r131.itemView.post(new f(r131));
        return;
    L119:
        return;
    L112:
        r133 = R.string.ttlive_effect_switch_button_close;
        goto L113
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 1) goto L13;
        if (this.f67129n == false) goto L8;
        int r102 = R.layout.ttlive_effect_item_beauty_template_switch_button;
    L14:
        return new b(LayoutInflater.from(r100.getContext()).inflate(r102, r100, false));
    L8:
        if (this.f67124i == false) goto L10;
        r102 = R.layout.ttlive_effect_item_preview_beauty_switch_button_v2;
        goto L14
    L10:
        r102 = R.layout.ttlive_effect_item_preview_beauty_switch_button;
        goto L14
    L13:
        return new LiveSmallItemBeautyAdapter.LiveSmallItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(this.f67125j, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
    L41:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((r100 instanceof b) == true) goto L41;
        if (z2() == false) goto L10;
        r101 = r101 - 1;
    L10:
        if (r101 >= 0) goto L12;
        return;
    L12:
        if (r101 < ((ArrayList) this.f67116a).size()) goto L15;
        return;
    L15:
        if (this.f67124i == false) goto L17;
    L18:
        List<String> r103 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67127l).a().B((Sticker) ListProtector.get(this.f67116a, r101)) == false) goto L31;
        if (this.f67124i == false) goto L26;
        View r104 = r100.itemView.findViewById(R.id.item_change_tips);
        if (r104 == null) goto L26;
        r104.setVisibility(0);
    L26:
        if (this.f67129n == false) goto L45;
        View r105 = r100.itemView.findViewById(R.id.use_status_indicator);
        if (r105 == null) goto L46;
        r105.setVisibility(0);
        return;
    L46:
        return;
    L45:
        return;
    L31:
        if (this.f67124i == false) goto L36;
        View r106 = r100.itemView.findViewById(R.id.item_change_tips);
        if (r106 == null) goto L36;
        r106.setVisibility(4);
    L36:
        if (this.f67129n == false) goto L48;
        View r107 = r100.itemView.findViewById(R.id.use_status_indicator);
        if (r107 == null) goto L49;
        r107.setVisibility(4);
        return;
    L49:
        return;
    L48:
        return;
    L17:
        if (this.f67129n == true) goto L18;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r100, Sticker r101, String r102, float r103) {
        ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r100, Sticker r101, String r102, float r103, HashMap<String, String> r104) {
        if (Intrinsics.areEqual(r100, "livebody") == false) goto L14;
        List<String> r105 = this.f67117b;
        if (r101 == null) goto L7;
        String r106 = r101.getEffectId();
    L8:
        int r107 = CollectionsKt.indexOf(r105, r106);
        if (r107 >= 0) goto L11;
        return;
    L11:
        if (r107 >= ((ArrayList) this.f67117b).size()) goto L16;
        notifyItemChanged(r107 + 1, "tagValueChangeListener");
        return;
    L16:
        return;
    L7:
        r106 = null;
        goto L8
    }

    public LiveBodyBeautyAdapter(boolean r100, int r101, int r102, LiveEffectContextFactoryDelegate$Type r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f67124i = r100;
        this.f67125j = r101;
        this.f67126k = r102;
        this.f67127l = r103;
        this.f67128m = r104;
        this.f67129n = r105;
        this.f67116a = new ArrayList();
        this.f67117b = new ArrayList();
        this.f67120e = new SparseArray();
        this.f67121f = new SparseArray();
        this.f67122g = LazyKt.lazy(LiveBodyBeautyAdapter$handler$2.INSTANCE);
        if (this.f67128m == true) goto L5;
        this.f67118c = -1;
    L5:
        this.f67123h = new c(this);
    }
}
