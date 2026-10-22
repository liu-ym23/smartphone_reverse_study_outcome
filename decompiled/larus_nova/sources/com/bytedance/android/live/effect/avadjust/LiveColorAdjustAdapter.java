package com.bytedance.android.live.effect.avadjust;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveColorAdjustAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Sticker> f66791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f66792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f66794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<Boolean> f66795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f66796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f66797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f66798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f66799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f66800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66801k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public AbsSmallItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter$AbsSmallItemViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public static final class c implements LiveSmallItemBeautyHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveColorAdjustAdapter f66802a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f66803a;

            public a(c r100) {
                this.f66803a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f66803a.f66802a.notifyDataSetChanged();     // Catch: Throwable -> L4
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

        public c(LiveColorAdjustAdapter r100) {
            this.f66802a = r100;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            ((Handler) this.f66802a.f66796f.getValue()).post(new a(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L4;
        return 1;
    L4:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (((ArrayList) this.f66791a).size() > 0) goto L7;
        return 0;
    L7:
        return ((ArrayList) this.f66791a).size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        if ((r110 instanceof AbsSmallItemViewHolder) == false) goto L55;
        final int r112 = r111 - 1;
        final AbsSmallItemViewHolder r113 = (AbsSmallItemViewHolder) r110;
        AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r101 = AnonymousClass2.INSTANCE;
        if (this.f66793c != r112) goto L7;
        r113.itemView.findViewById(R.id.border).setVisibility(0);
        ((TextView) r113.itemView.findViewById(R.id.tv_name)).setTextColor(r113.itemView.getContext().getResources().getColor(R.color.ttlive_effect_broadcast_preview_beauty_item_text_color_red));
    L8:
        Sticker r102 = (Sticker) ListProtector.get(this.f66791a, r112);
        List<String> r103 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r104 = LiveEffectContext.a.a(this.f66801k).a();
        String r105 = r102.getEffectId();
        String r106 = "";
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        Sticker.ComposerConfig r107 = r102.getSmallItemConfig();
        if (r107 == null) goto L17;
        String r108 = r107.getTag();
        if (r108 == null) goto L17;
        r106 = r108;
    L17:
        Float r109 = r104.G(r105, r106);
        if (r109 != null) goto L25;
        Sticker.ComposerConfig r114 = r102.getSmallItemConfig();
        if (r114 == null) goto L22;
        Integer r115 = Integer.valueOf(r114.getDefaultValue());
    L23:
        Intrinsics.checkNotNull(r115);
        r109 = Float.valueOf(com.bytedance.android.live.effect.q.d(r102, r115.intValue()));
        ALogger.i("LiveColorAdjustAdapter", "onBindBeautyItemViewHolder uivalue = " + r109);
        goto L25
    L22:
        r115 = null;
    L25:
        if ((!Intrinsics.areEqual(r109, 0.0f)) == false) goto L27;
        r113.itemView.findViewById(R.id.item_change_tips).setVisibility(0);
    L28:
        UrlModel r116 = r102.getIcon();
        if (r116 == null) goto L31;
        ImageUtil.loadRoundImage((ImageView) r113.itemView.findViewById(R.id.iv_bg), new ImageModel(r116.getUri(), r116.getUrlList()));
    L31:
        ((TextView) r113.itemView.findViewById(R.id.tv_name)).setText(r102.getName());
        HashMap r117 = new HashMap();
        r117.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, this.f66800j);
        r117.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "adjust");
        String r118 = r102.getName();
        if (r118 == null) goto L34;
        String r119 = (String) r117.put(MobConstants.EFFECT_NAME, r118);
    L34:
        r117.put("live_type", "video_live");
        r117.put(MobConstants.EFFECT_ID, r102.getEffectId());
        r117.put(TextureRenderKeys.KEY_IS_EFFECT_ORDER, String.valueOf(r112));
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_panel_item_show", r117, this.f66800j);
        if (LiveEffectContext.a.a(this.f66801k).b().r().q(r102) == false) goto L37;
        ((ImageView) r113.itemView.findViewById(R.id.iv_loading)).setVisibility(8);
    L38:
        r100.invoke(r113, r102);
        r113.itemView.setOnClickListener(new com.bytedance.android.live.effect.avadjust.b(this, r113, r101));
        if (LiveEffectContext.a.a(this.f66801k).b().h().c() == false) goto L50;
        List<String> r120 = ((Sticker) ListProtector.get(this.f66791a, r112)).getTags();
        if (r120 == null) goto L50;
        if (r120.contains("outer_test") != true) goto L50;
        ConstraintLayout r121 = (ConstraintLayout) r113.itemView.findViewById(R.id.cl_tag);
        if (r121 == null) goto L47;
        r121.setVisibility(0);
    L47:
        View r122 = r113.itemView.findViewById(R.id.item_filter_dot);
        if (r122 == null) goto L53;
        r122.setVisibility(4);
    L53:
        r3.e(r113.itemView, new LiveColorAdjustAdapter$onBindBeautyItemViewHolder$3(this, r112, r113));
        return;
    L50:
        ConstraintLayout r123 = (ConstraintLayout) r113.itemView.findViewById(R.id.cl_tag);
        if (r123 == null) goto L53;
        r123.setVisibility(4);
        goto L53
    L37:
        ((ImageView) r113.itemView.findViewById(R.id.iv_loading)).setVisibility(0);
        l.c(LiveEffectContext.a.a(this.f66801k).b().n(), r102, true);
        goto L38
    L27:
        r113.itemView.findViewById(R.id.item_change_tips).setVisibility(4);
        goto L28
    L7:
        this.f66795e.put(r112, Boolean.FALSE);
        r113.itemView.findViewById(R.id.border).setVisibility(4);
        ((TextView) r113.itemView.findViewById(R.id.tv_name)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        goto L8
    L55:
        if ((r110 instanceof b) == false) goto L63;
        b r124 = (b) r110;
        ((LiveSwitchButton) r124.itemView.findViewById(R.id.switch_button)).setChecked(this.f66799i);
        TextView r125 = (TextView) r124.itemView.findViewById(R.id.switch_text);
        if (this.f66799i == false) goto L59;
        int r126 = R.string.ttlive_effect_switch_button_open;
    L60:
        r125.setText(s1.B(r126));
        ((LiveSwitchButton) r124.itemView.findViewById(R.id.switch_button)).setAccessibilityDelegate(new com.bytedance.android.live.effect.avadjust.c(r124));
        ((LiveSwitchButton) r124.itemView.findViewById(R.id.switch_button)).setOnCheckedChangeListener(new d(this, r124));
        return;
    L59:
        r126 = R.string.ttlive_effect_switch_button_close;
        goto L60
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 != 1) goto L6;
        return new b(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_effect_item_preview_beauty_switch_button_v2, r100, false));
    L6:
        return new LiveSmallItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(this.f66798h, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
    L21:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((r100 instanceof b) == true) goto L21;
        int r103 = r101 - 1;
        if (r103 >= 0) goto L10;
        return;
    L10:
        if (r103 >= ((ArrayList) this.f66791a).size()) goto L23;
        List<String> r104 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f66801k).a().B((Sticker) ListProtector.get(this.f66791a, r103)) == false) goto L17;
        View r105 = r100.itemView.findViewById(R.id.item_change_tips);
        if (r105 == null) goto L24;
        r105.setVisibility(0);
        return;
    L24:
        return;
    L17:
        View r106 = r100.itemView.findViewById(R.id.item_change_tips);
        if (r106 == null) goto L26;
        r106.setVisibility(4);
        return;
    L26:
        return;
    }

    public LiveColorAdjustAdapter(int r100, boolean r101, String r102, LiveEffectContextFactoryDelegate$Type r103) {
        Intrinsics.checkNotNullParameter(r102, "eventPage");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f66798h = r100;
        this.f66799i = r101;
        this.f66800j = r102;
        this.f66801k = r103;
        this.f66791a = new ArrayList();
        this.f66792b = new ArrayList();
        this.f66795e = new SparseArray();
        this.f66796f = LazyKt.lazy(LiveColorAdjustAdapter$handler$2.INSTANCE);
        if (this.f66799i == true) goto L5;
        this.f66793c = -1;
    L5:
        this.f66797g = new c(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r100, Sticker r101, String r102, float r103) {
        ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r100, Sticker r101, String r102, float r103, HashMap<String, String> r104) {
        if (Intrinsics.areEqual(r100, "live_adjustment") == false) goto L15;
        List<String> r105 = this.f66792b;
        if (r101 == null) goto L7;
        String r106 = r101.getEffectId();
    L8:
        int r107 = CollectionsKt.indexOf(r105, r106);
        if (r107 >= 0) goto L11;
    L13:
        ALogger.i("LiveColorAdjustAdapter", "onChange: index = " + r107);
        return;
    L11:
        if (r107 >= ((ArrayList) this.f66792b).size()) goto L13;
        notifyItemChanged(r107 + 1);
        goto L13
    L7:
        r106 = null;
        goto L8
    }
}
