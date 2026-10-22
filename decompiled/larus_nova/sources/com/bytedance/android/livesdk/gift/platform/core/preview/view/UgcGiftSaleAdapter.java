package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftDialogViewModel;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleAdapter;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftAdapter;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleAdapter$InteractGiftViewHolder;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "InteractGiftViewHolder", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftSaleAdapter extends BaseUgcGiftAdapter<InteractGiftViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> f131038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Long> f131039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f131040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f131041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f131042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f131043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f131044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UgcGiftDialogViewModel f131045h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleAdapter$InteractGiftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InteractGiftViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f131046h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f131047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HSImageView f131048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f131049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f131050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Lazy f131051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f131052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ UgcGiftSaleAdapter f131053g;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InteractGiftViewHolder f131054a;

            public a(InteractGiftViewHolder r100) {
                this.f131054a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r110) {
                InteractGiftViewHolder r111 = this.f131054a;
                Iterator r100 = ((ArrayList) r111.f131053g.f131038a).iterator();
                int r101 = 0;
            L4:
                if (r100.hasNext() == false) goto L12;
                Object r102 = r100.next();
                int r103 = r101 + 1;
                if (r101 >= 0) goto L8;
                CollectionsKt.throwIndexOverflow();
            L8:
                com.bytedance.android.livesdk.gift.platform.core.preview.b r104 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) r102;
                if (r104.f130981f == false) goto L11;
                r104.f130981f = false;
                r111.f131053g.notifyItemChanged(r101);
            L11:
                r101 = r103;
                goto L4
            L12:
                com.bytedance.android.livesdk.gift.platform.core.preview.b r105 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(r111.f131053g.f131038a, r111.getAdapterPosition());
                if (r105 == null) goto L27;
                r111.T3(true, r105);
                com.bytedance.android.livesdk.gift.platform.core.preview.a r106 = com.bytedance.android.livesdk.gift.platform.core.preview.a.f130971a;
                UgcGiftSaleAdapter r107 = r111.f131053g;
                int r108 = r107.f131041d;
                String r109 = r107.f131042e;
                long r112 = r105.f130976a;
                int r113 = r111.getAdapterPosition();
                r106.getClass();
                Intrinsics.checkNotNullParameter(r109, "request_page");
                LinkedHashMap r114 = new LinkedHashMap();
                int r115 = (r113 / 4) + 1;
                int r116 = (r113 % 4) + 1;
                if (r108 != 1) goto L17;
                String r117 = "live_take_page";
            L18:
                r114.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r117);
                r114.put("request_page", r109);
                r114.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r112));
                r114.put("row_location", String.valueOf(r115));
                r114.put("column_location", String.valueOf(r116));
                yz0.k r118 = com.bytedance.android.livesdk.gift.platform.core.utils.u.h();
                if (r118 == null) goto L26;
                IRoom r119 = r118.getRoom();
                if (r119 == null) goto L26;
                String r120 = r119.getAnchorId();
                if (r120 != null) goto L25;
                r120 = "";
            L25:
                r114.put("anchor_id", r120);
                r114.put("room_id", String.valueOf(r119.getRoomId()));
                com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_panel_gift_click", r114);
            L26:
                r114.put("live_type", "video_live");
                r114.put("anchor_id", ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).getCurrentUserId());
                com.bytedance.android.livesdk.gift.platform.core.preview.a.d("livesdk_interactive_gift_panel_gift_click", r114);
                goto L27
            L17:
                r117 = "live";
            L27:
                RecyclerView.LayoutManager r121 = r111.f131053g.f131044g.getLayoutManager();
                if ((r121 instanceof LinearLayoutManager) == true) goto L30;
                return;
            L30:
                if (r111.getAdapterPosition() == (-1)) goto L37;
                r121.smoothScrollToPosition(r111.f131053g.f131044g, new RecyclerView.State(), r111.getAdapterPosition());
                return;
            }
        }

        public final t V3() {
            return (t) this.f131051e.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b U3(long r100) {
            PanelOperationState r101 = (PanelOperationState) this.f131053g.f131045h.f131120d.f64752a;
            if (h.f131094a[r101.ordinal()] == 1) goto L6;
            return new b(R.drawable.ttlive_interact_gift_remove_bg, R.string.ttlive_interact_gift_config_bottom_text, new UgcGiftSaleAdapter$InteractGiftViewHolder$getConfig$3(this));
        L6:
            if (this.f131053g.f131039b.contains(Long.valueOf(r100)) == false) goto L9;
            return new b(R.drawable.ttlive_interact_gift_remove_bg, R.string.ttlive_interact_gift_config_bottom_cancel_top_text, new UgcGiftSaleAdapter$InteractGiftViewHolder$getConfig$1(this));
        L9:
            return new b(R.drawable.ttlive_interact_gift_top_bg, R.string.ttlive_interact_gift_config_bottom_set_top_text, new UgcGiftSaleAdapter$InteractGiftViewHolder$getConfig$2(this));
        }

        public InteractGiftViewHolder(UgcGiftSaleAdapter r100, final View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f131053g = r100;
            super(r101);
            this.f131047a = r101.findViewById(R.id.container_view);
            this.f131048b = (HSImageView) r101.findViewById(R.id.gift_image);
            this.f131049c = (TextView) r101.findViewById(R.id.gift_name);
            this.f131050d = (TextView) r101.findViewById(R.id.diamond);
            this.f131051e = LazyKt.lazy(new UgcGiftSaleAdapter$InteractGiftViewHolder$selectView$2(r101));
            this.f131052f = (TextView) r101.findViewById(R.id.tag_view);
            r101.setOnClickListener(new a(this));
        }

        public final void T3(boolean r100, com.bytedance.android.livesdk.gift.platform.core.preview.b r101) {
            if (r100 == false) goto L14;
            t r102 = V3();
            if (r102.f131107a == false) goto L9;
            UgcGiftSelectView r103 = r102.f131108b;
            if (r103 == null) goto L9;
            int r104 = r103.getVisibility();
        L10:
            if (r104 == 0) goto L16;
            V3().c(0);
            V3().e();
            this.f131047a.setVisibility(8);
            r101.f130981f = true;
            V3().a(U3(r101.f130976a));
            if (this.f131053g.f131041d != 1) goto L17;
            com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();
            V3().d();
            com.bytedance.android.livesdk.gift.platform.core.preview.f.a().f(r101.f130977b, r101.f130976a, new UgcGiftSaleAdapter$InteractGiftViewHolder$applySelect$1(this));
            return;
        L17:
            return;
        L16:
            return;
        L9:
            r104 = 8;
            goto L10
        L14:
            V3().c(8);
            V3().getClass();
            this.f131047a.setVisibility(0);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void A2() {
        this.f131045h.a(this.f131039b, this.f131040c, PanelOperationState.Top);
        Iterator r100 = ((ArrayList) this.f131038a).iterator();
        boolean r101 = false;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.gift.platform.core.preview.b) r100.next()).f130981f == true) goto L10;
        r102 = r102 + 1;
    L10:
        Integer r103 = Integer.valueOf(r102);
        if (r103.intValue() < 0) goto L13;
        r101 = true;
    L13:
        RecyclerView.ViewHolder r104 = null;
        if (r101 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L32;
        int r105 = r103.intValue();
        RecyclerView.ViewHolder r106 = this.f131044g.findViewHolderForAdapterPosition(r105);
        if ((r106 instanceof InteractGiftViewHolder) == false) goto L22;
        r104 = r106;
    L22:
        InteractGiftViewHolder r107 = (InteractGiftViewHolder) r104;
        if (r107 == null) goto L33;
        com.bytedance.android.livesdk.gift.platform.core.preview.b r108 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.f131038a, r105);
        if (r108 == null) goto L27;
        long r109 = r108.f130976a;
    L28:
        r107.V3().a(r107.U3(r109));
        return;
    L27:
        r109 = 0;
        goto L28
    L33:
        return;
    L32:
        return;
    L9:
        r102 = -1;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void B2() {
        Iterator r100 = ((ArrayList) this.f131038a).iterator();
        boolean r101 = false;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.gift.platform.core.preview.b) r100.next()).f130981f == true) goto L10;
        r102 = r102 + 1;
    L10:
        Integer r103 = Integer.valueOf(r102);
        if (r103.intValue() < 0) goto L13;
        r101 = true;
    L13:
        RecyclerView.ViewHolder r104 = null;
        if (r101 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L32;
        int r105 = r103.intValue();
        RecyclerView.ViewHolder r106 = this.f131044g.findViewHolderForAdapterPosition(r105);
        if ((r106 instanceof InteractGiftViewHolder) == false) goto L22;
        r104 = r106;
    L22:
        InteractGiftViewHolder r107 = (InteractGiftViewHolder) r104;
        if (r107 == null) goto L33;
        com.bytedance.android.livesdk.gift.platform.core.preview.b r108 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.f131038a, r105);
        if (r108 == null) goto L27;
        long r109 = r108.f130976a;
    L28:
        r107.V3().a(r107.U3(r109));
        return;
    L27:
        r109 = 0;
        goto L28
    L33:
        return;
    L32:
        return;
    L9:
        r102 = -1;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f131038a).size();
    }

    public final Context getContext() {
        return this.f131043f;
    }

    public final void C2(int r100) {
        List<Long> r101 = this.f131039b;
        if (r101.size() < 4) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L11;
        ((Number) ListProtector.remove(r101, CollectionsKt.getLastIndex(r101))).longValue();
    L11:
        com.bytedance.android.livesdk.gift.platform.core.preview.b r103 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.f131038a, r100);
        if (r103 == null) goto L14;
        ListProtector.add(this.f131039b, 0, Long.valueOf(r103.f130976a));
    L14:
        com.bytedance.android.livesdk.gift.platform.core.preview.i.a(this.f131038a, r100, 0);
        notifyDataSetChanged();
        int r104 = ToastUtil.f90810a;
        ToastUtil.b(s1.B(R.string.ttlive_interact_gift_set_top_success), 0);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        InteractGiftViewHolder r102 = (InteractGiftViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        com.bytedance.android.livesdk.gift.platform.core.preview.b r103 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.f131038a, r101);
        if (r103 == null) goto L12;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, PbRequest.SwitchType.GIFT);
        r102.f131049c.setText(r103.f130978c);
        r102.f131050d.setVisibility(0);
        r102.f131050d.setText(String.valueOf(r103.f130979d) + " " + r3.c());
        r102.f131050d.requestLayout();
        py.k r104 = r103.f130980e;
        if (r104 == null) goto L7;
        ImageLoader.bindImage(r102.f131048b, r104, s1.j(R.dimen.ttlive_effect_gift_icon_size), s1.j(R.dimen.ttlive_effect_gift_icon_size));
    L7:
        r102.V3().b(r103.f130980e, r103.f130978c, String.valueOf(r103.f130979d) + " " + r3.c(), r102.U3(r103.f130976a));
        r102.T3(r103.f130981f, r103);
        if (r102.f131053g.f131039b.contains(Long.valueOf(r103.f130976a)) == false) goto L10;
        r102.f131052f.setVisibility(0);
        r102.f131052f.setText(s1.B(R.string.ttlive_interact_gift_top_tag_text));
        r102.f131052f.setTextColor(s1.h(R.color.ttlive_ugc_top_tag_text_color));
        r102.f131052f.setBackground(s1.m(R.drawable.ttlive_gift_interact_gift_top_tag_bg));
        return;
    L10:
        r102.f131052f.setVisibility(8);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new InteractGiftViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_interact_gift_view_holder, r100, false));
    }

    public UgcGiftSaleAdapter(Context r100, RecyclerView r101, UgcGiftDialogViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f131043f = r100;
        this.f131044g = r101;
        this.f131045h = r102;
        this.f131038a = new ArrayList();
        this.f131039b = new ArrayList();
        this.f131040c = new ArrayList();
        this.f131042e = "";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void y2(com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ugcGiftData");
        Intrinsics.checkNotNullParameter(r102, "clickFrom");
        this.f131041d = r101;
        this.f131042e = r102;
        ((ArrayList) this.f131040c).clear();
        this.f131039b.clear();
        this.f131039b.addAll(r100.f131129c);
        List<Long> r103 = this.f131040c;
        ArrayList r104 = (ArrayList) r103;
        r104.addAll(r100.f131130d);
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r105 = r100.f131127a;
        ((ArrayList) this.f131038a).clear();
        ArrayList r106 = (ArrayList) this.f131038a;
        r106.addAll(r105);
        notifyDataSetChanged();
    }
}
