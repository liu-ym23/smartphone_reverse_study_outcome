package com.bytedance.android.live.effect.beauty.smallitem;

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
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallItemBeautyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f67578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f67580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<Boolean> f67581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<Integer> f67582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f67583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f67584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f67585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f67586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f67587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f67589l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f67590m;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LiveSmallSubItemBeautyAdapter f67591a;

        public AbsSmallItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter$AbsSmallItemViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveSmallItemViewHolder extends AbsSmallItemViewHolder {

        public static final class a {
        }

        static {
        }

        public LiveSmallItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public interface a {
        void a(Sticker r100);

        void b(boolean r100);
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

    public final boolean z2() {
        LiveEffectContextFactoryDelegate$Type r100 = this.f67588k;
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
        return ((ArrayList) this.f67578a).size();
    L6:
        if (((ArrayList) this.f67578a).size() > 0) goto L11;
        return 0;
    L11:
        return ((ArrayList) this.f67578a).size() + 1;
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
        Integer r101 = this.f67582e.get(r110, -1);
        List<Sticker> r111 = ((Sticker) ListProtector.get(this.f67578a, r110)).getSubStickers();
        Integer r102 = null;
        if (r111 == null) goto L21;
        Iterator<Sticker> r112 = r111.iterator();
        int r103 = 0;
    L6:
        if (r112.hasNext() == false) goto L20;
        Sticker r104 = r112.next();
        List<String> r105 = LiveEffectContext.f66734h;
        Iterator<T> r106 = LiveEffectContext.a.a(this.f67588k).a().o(com.bytedance.android.live.effect.api.d0.f66759i).iterator();
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

    public final void A2(View r100, int r101) {
        if (this.f67585h == false) goto L15;
        List<String> r102 = LiveEffectContext.f66734h;
        View r103 = null;
        if (LiveEffectContext.a.a(this.f67588k).a().B((Sticker) ListProtector.get(this.f67578a, r101)) == false) goto L10;
        if (r100 == null) goto L8;
        r103 = r100.findViewById(R.id.item_change_tips);
    L8:
        if (r103 == null) goto L16;
        r103.setVisibility(0);
        return;
    L16:
        return;
    L10:
        if (r100 == null) goto L12;
        r103 = r100.findViewById(R.id.item_change_tips);
    L12:
        if (r103 == null) goto L18;
        r103.setVisibility(4);
        return;
    L18:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        if ((r110 instanceof AbsSmallItemViewHolder) == false) goto L98;
        if (z2() == false) goto L7;
        final int r100 = r111 - 1;
    L8:
        final AbsSmallItemViewHolder r101 = (AbsSmallItemViewHolder) r110;
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r103 = AnonymousClass2.INSTANCE;
        if (this.f67579b != r100) goto L19;
        r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.border).setVisibility(0);
        if (this.f67585h == false) goto L13;
        int r104 = R.color.ttlive_effect_broadcast_preview_beauty_item_text_color_red;
    L14:
        ((TextView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.tv_name)).setTextColor(r101.itemView.getContext().getResources().getColor(r104));
        if (this.f67590m == false) goto L24;
        View r105 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r105 == null) goto L24;
        r105.setSelected(true);
    L24:
        UrlModel r106 = ((Sticker) ListProtector.get(this.f67578a, r100)).getIcon();
        if (r106 == null) goto L27;
        ImageUtil.loadRoundImage((ImageView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.iv_bg), new ImageModel(r106.getUri(), r106.getUrlList()));
    L27:
        ((TextView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.tv_name)).setText(((Sticker) ListProtector.get(this.f67578a, r100)).getName());
        Effect r107 = ((Sticker) ListProtector.get(this.f67578a, r100)).getEffect();
        if (r107 != null) goto L30;
    L34:
        boolean r108 = false;
    L35:
        List<String> r109 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67588k).b().r().q((Sticker) ListProtector.get(this.f67578a, r100)) == true) goto L40;
        if (r108 == true) goto L40;
        ((ImageView) r101.itemView.findViewById(R.id.iv_loading)).setVisibility(0);
        LiveSmallItemBeautyHelper.g(LiveEffectContext.a.a(this.f67588k).b().g(), (Sticker) ListProtector.get(this.f67578a, r100), true, this.f67590m, 4);
    L41:
        if (r108 == true) goto L43;
    L68:
        r101.itemView.findViewById(R.id.expanded_layout).setVisibility(8);
        r101.itemView.findViewById(R.id.fold_layout).setVisibility(0);
        if (this.f67590m == true) goto L71;
        View r112 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r112 == null) goto L81;
        r112.setVisibility(4);
    L81:
        A2(r101.itemView.findViewById(R.id.fold_layout), r100);
        r102.invoke(r101, ListProtector.get(this.f67578a, r100));
        r101.itemView.setOnClickListener(new u(this, r101, r108, r103));
        if (LiveEffectContext.a.a(this.f67588k).b().h().c() == false) goto L93;
        List<String> r113 = ((Sticker) ListProtector.get(this.f67578a, r100)).getTags();
        if (r113 == null) goto L93;
        if (r113.contains("outer_test") != true) goto L93;
        ConstraintLayout r114 = (ConstraintLayout) r101.itemView.findViewById(R.id.cl_tag);
        if (r114 == null) goto L90;
        r114.setVisibility(0);
    L90:
        View r115 = r101.itemView.findViewById(R.id.item_filter_dot);
        if (r115 == null) goto L96;
        r115.setVisibility(4);
    L96:
        r3.e(r101.itemView, new LiveSmallItemBeautyAdapter$onBindBeautyItemViewHolder$6(this, r100, r101));
        return;
    L93:
        ConstraintLayout r116 = (ConstraintLayout) r101.itemView.findViewById(R.id.cl_tag);
        if (r116 == null) goto L96;
        r116.setVisibility(4);
        goto L96
    L71:
        if (LiveEffectContext.a.a(this.f67588k).a().E((Sticker) ListProtector.get(this.f67578a, r100)) == false) goto L75;
        View r117 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r117 == null) goto L81;
        r117.setVisibility(0);
        goto L81
    L75:
        View r118 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r118 == null) goto L81;
        r118.setVisibility(4);
        goto L81
    L43:
        if (this.f67581d.get(r100, Boolean.FALSE).booleanValue() == false) goto L68;
        r101.itemView.findViewById(R.id.expanded_layout).setVisibility(0);
        r101.itemView.findViewById(R.id.fold_layout).setVisibility(8);
        r101.f67591a = new LiveSmallSubItemBeautyAdapter(this.f67585h, this.f67587j, this.f67588k, this.f67590m);
        ((RecyclerView) r101.itemView.findViewById(R.id.sub_beauty_list)).setLayoutManager(new LinearLayoutManager(r101.itemView.getContext(), 0, false));
        ((RecyclerView) r101.itemView.findViewById(R.id.sub_beauty_list)).setAdapter(r101.f67591a);
        int r119 = y2(r100);
        if (r119 < 0) goto L49;
        LiveSmallSubItemBeautyAdapter r120 = r101.f67591a;
        if (r120 == null) goto L49;
        r120.f67649d = r119;
    L49:
        LiveSmallSubItemBeautyAdapter r121 = r101.f67591a;
        if (r121 == null) goto L55;
        List<Sticker> r122 = ((Sticker) ListProtector.get(this.f67578a, r100)).getSubStickers();
        if (r122 != null) goto L54;
        r122 = new ArrayList();
    L54:
        r121.setData(r122);
    L55:
        LiveSmallSubItemBeautyAdapter r123 = r101.f67591a;
        if (r123 == null) goto L58;
        s r124 = new s(this, r100);
        Intrinsics.checkNotNullParameter(r124, "listener");
        r123.f67650e = r124;
    L58:
        ((TextView) r101.itemView.findViewById(R.id.expanded_layout).findViewById(R.id.sub_beauty_title)).setText(((Sticker) ListProtector.get(this.f67578a, r100)).getName());
        ((ImageView) r101.itemView.findViewById(R.id.expanded_layout).findViewById(R.id.sub_beauty_item_back)).setOnClickListener(new t(this, r100, r101));
        List<Sticker> r125 = ((Sticker) ListProtector.get(this.f67578a, r100)).getSubStickers();
        if (r125 == null) goto L81;
        if (r119 > 0) goto L63;
        r119 = 0;
    L63:
        Sticker r126 = (Sticker) ListProtector.get(r125, r119);
        if (r126 == null) goto L81;
        a r127 = this.f67580c;
        if (r127 == null) goto L81;
        r127.a(r126);
    L40:
        ((ImageView) r101.itemView.findViewById(R.id.iv_loading)).setVisibility(8);
        goto L41
    L30:
        if (r107.getEffectType() != 1) goto L34;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(this.f67578a, r100)).getSubStickers()) == true) goto L34;
        r108 = true;
        goto L35
    L13:
        r104 = R.color.ttlive_effect_broadcast_preview_beauty_item_text_color;
        goto L14
    L19:
        r101.itemView.findViewById(R.id.expanded_layout).setVisibility(8);
        r101.itemView.findViewById(R.id.fold_layout).setVisibility(0);
        this.f67581d.put(r100, Boolean.FALSE);
        r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.border).setVisibility(4);
        ((TextView) r101.itemView.findViewById(R.id.fold_layout).findViewById(R.id.tv_name)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        if (this.f67590m == false) goto L24;
        View r128 = r101.itemView.findViewById(R.id.use_status_indicator);
        if (r128 == null) goto L24;
        r128.setSelected(false);
        goto L24
    L7:
        r100 = r111;
        goto L8
    L98:
        if ((r110 instanceof b) == false) goto L108;
        b r129 = (b) r110;
        ((LiveSwitchButton) r129.itemView.findViewById(R.id.switch_button)).setChecked(this.f67589l);
        TextView r130 = (TextView) r129.itemView.findViewById(R.id.switch_text);
        if (this.f67589l == false) goto L102;
        int r131 = R.string.ttlive_effect_switch_button_open;
    L103:
        r130.setText(s1.B(r131));
        ((LiveSwitchButton) r129.itemView.findViewById(R.id.switch_button)).setAccessibilityDelegate(new v(r129));
        ((LiveSwitchButton) r129.itemView.findViewById(R.id.switch_button)).setOnCheckedChangeListener(new w(this, r129));
        if (LiveEffectSettings.LIVE_EFFECT_BEAUTY_FIX_TALKBACK_2025_07.getValue().booleanValue() == false) goto L109;
        r129.itemView.post(new x(r129));
        return;
    L109:
        return;
    L102:
        r131 = R.string.ttlive_effect_switch_button_close;
        goto L103
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 1) goto L10;
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (this.f67585h == false) goto L7;
        int r103 = R.layout.ttlive_effect_item_preview_beauty_switch_button_v2;
    L11:
        return new b(r102.inflate(r103, r100, false));
    L7:
        r103 = R.layout.ttlive_effect_item_preview_beauty_switch_button;
        goto L11
    L10:
        return new LiveSmallItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(this.f67586i, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
    L16:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((r100 instanceof b) == true) goto L16;
        if (z2() == false) goto L10;
        r101 = r101 - 1;
    L10:
        if (r101 >= 0) goto L12;
        return;
    L12:
        if (r101 >= ((ArrayList) this.f67578a).size()) goto L18;
        A2(r100.itemView.findViewById(R.id.fold_layout), r101);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r100, Sticker r101, String r102, float r103) {
        ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
    }

    public LiveSmallItemBeautyAdapter(boolean r100, int r101, int r102, LiveEffectContextFactoryDelegate$Type r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f67585h = r100;
        this.f67586i = r101;
        this.f67587j = r102;
        this.f67588k = r103;
        this.f67589l = r104;
        this.f67590m = false;
        this.f67578a = new ArrayList();
        this.f67581d = new SparseArray();
        this.f67582e = new SparseArray();
        this.f67583f = LazyKt.lazy(LiveSmallItemBeautyAdapter$handler$2.INSTANCE);
        if (this.f67589l == true) goto L5;
        this.f67579b = -1;
    L5:
        this.f67584g = new r(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r100, Sticker r101, String r102, float r103, HashMap<String, String> r104) {
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.effect.api.d0.f66759i) == false) goto L55;
        Iterator r105 = ((ArrayList) this.f67578a).iterator();
        int r106 = 0;
    L6:
        if (r105.hasNext() == false) goto L41;
        Sticker r107 = (Sticker) r105.next();
        String r108 = r107.getEffectId();
        if (r101 == null) goto L10;
        String r109 = r101.getEffectId();
    L11:
        boolean r110 = Intrinsics.areEqual(r108, r109);
        boolean r111 = true;
        if (r110 == true) goto L38;
        Effect r112 = r107.getEffect();
        if (r112 != null) goto L16;
    L37:
        r111 = false;
        goto L38
    L16:
        if (r112.getEffectType() != 1) goto L37;
        List<Sticker> r113 = r107.getSubStickers();
        if (r113 == null) goto L37;
        List<Sticker> r114 = r113;
        if ((r114 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r115 = r114.iterator();
    L26:
        if (r115.hasNext() == false) goto L34;
        String r116 = ((Sticker) r115.next()).getEffectId();
        if (r101 == null) goto L30;
        String r117 = r101.getEffectId();
    L32:
        if (Intrinsics.areEqual(r116, r117) == false) goto L26;
        boolean r118 = true;
    L35:
        if (r118 != true) goto L37;
    L30:
        r117 = null;
    L34:
        r118 = false;
        goto L35
    L22:
        if (r114.isEmpty() == false) goto L24;
    L38:
        if (r111 == true) goto L42;
        r106 = r106 + 1;
    L42:
        if (r106 >= 0) goto L44;
        return;
    L44:
        if (r106 < ((ArrayList) this.f67578a).size()) goto L46;
        return;
    L46:
        if (z2() == false) goto L48;
        r106 = r106 + 1;
    L48:
        notifyItemChanged(r106, "tagValueChangeListener");
        return;
    L10:
        r109 = null;
        goto L11
    L41:
        r106 = -1;
        goto L42
    }
}
