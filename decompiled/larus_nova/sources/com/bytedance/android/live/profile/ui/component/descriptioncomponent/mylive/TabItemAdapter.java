package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;
import com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder;
import com.bytedance.android.livesdk.dsl.recyclerview.SingleDSLViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "<init>", "()V", "ItemViewHolder", "LoadingViewHolder", "SpaceViewHolder", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TabDataHelper f86601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.dsl.recyclerview.a f86602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.dsl.recyclerview.c f86603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.dsl.recyclerview.e> f86604d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "mItemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f86605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f86606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f86607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f86608d;

        public LoadingViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "mItemView");
            super(r100);
            this.f86608d = r100;
            this.f86605a = r100.findViewById(R.id.my_tab_loading_item_container);
            this.f86606b = (TextView) r100.findViewById(R.id.my_tab_loading_item_text);
            this.f86607c = (ImageView) r100.findViewById(R.id.my_tab_loading_item_error_icon);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter$SpaceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpaceViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f86609a;

        public SpaceViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "spaceView");
            super(r100);
            this.f86609a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f86604d).size();
    }

    public TabItemAdapter() {
        this.f86602b = new com.bytedance.android.livesdk.dsl.recyclerview.a();
        this.f86604d = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = y2((com.bytedance.android.livesdk.dsl.recyclerview.e) ListProtector.get(this.f86604d, r100));
        if (r101 == (-1)) goto L6;
        return r101;
    L6:
        return ((com.bytedance.android.livesdk.dsl.recyclerview.e) ListProtector.get(this.f86604d, r100)).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewRecycled(r100);
        this.f86602b.getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof BaseDSLViewHolder) == false) goto L9;
        BaseDSLViewHolder r101 = (BaseDSLViewHolder) r100;
        com.bytedance.android.livesdk.dsl.recyclerview.b r102 = r101.f122774a;
        if (r102 == null) goto L7;
        r102.f122784a = null;
    L7:
        r101.f122774a = null;
        r101.V3();
        return;
    }

    public final void setData(List<? extends com.bytedance.android.livesdk.dsl.recyclerview.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "tabData");
        ((ArrayList) this.f86604d).clear();
        ((ArrayList) this.f86604d).addAll(r100);
    }

    public final int y2(com.bytedance.android.livesdk.dsl.recyclerview.e r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.livesdk.dsl.recyclerview.a r101 = this.f86602b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "dslItem");
        if ((r100 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.livesdk.dsl.recyclerview.b r102 = (com.bytedance.android.livesdk.dsl.recyclerview.b) r100;
        if (r102 == null) goto L10;
        Long r103 = r102.f122785b;
        if (r103 == null) goto L10;
        long r104 = r103.longValue();
    L12:
        if (r104 != (-1)) goto L14;
        return -1;
    L14:
        Integer r105 = r101.f122783b.get(Long.valueOf(r104));
        if (r105 != null) goto L18;
        r105 = Integer.valueOf(r101.f122782a.f122800a.addAndGet(1));
        r101.f122783b.put(Long.valueOf(r104), r105);
    L18:
        return r105.intValue();
    L10:
        r104 = -1;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f86603c == null) goto L24;
        com.bytedance.android.livesdk.dsl.recyclerview.a r102 = this.f86602b;
        com.bytedance.android.livesdk.dsl.recyclerview.e r103 = (com.bytedance.android.livesdk.dsl.recyclerview.e) ListProtector.get(this.f86604d, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "holder");
    L18:
        StringBuilder r104 = new StringBuilder("bind data error. ");
        if (r103 == null) goto L21;
        Object r105 = Integer.valueOf(r103.getItemType());
    L22:
        r104.append(r105);
        ALogger.e("DSLAdapterHelper", r104.toString());
        goto L24
    L21:
        r105 = "null";
        goto L22
    L6:
        if ((r100 instanceof BaseDSLViewHolder) == false) goto L24;
        if ((r103 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == true) goto L10;
        com.bytedance.android.livesdk.dsl.recyclerview.e r106 = null;
    L11:
        com.bytedance.android.livesdk.dsl.recyclerview.b r107 = (com.bytedance.android.livesdk.dsl.recyclerview.b) r106;     // Catch: Throwable -> L18
        if (r107 == null) goto L24;
        r107.f122787d = r101;     // Catch: Throwable -> L18
        BaseDSLViewHolder r108 = (BaseDSLViewHolder) r100;     // Catch: Throwable -> L18
        r108.getClass();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r107, MapController.ITEM_LAYER_TAG);     // Catch: Throwable -> L18
        com.bytedance.android.livesdk.dsl.recyclerview.b r109 = r108.f122774a;     // Catch: Throwable -> L18
        if (r109 == null) goto L16;
        r109.f122784a = null;     // Catch: Throwable -> L18
    L16:
        r108.f122774a = r107;     // Catch: Throwable -> L18
        r107.f122784a = null;     // Catch: Throwable -> L18
        r107.f122784a = new WeakReference(r108);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r107, "slice");     // Catch: Throwable -> L18
        r108.U3(r107, false);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r107, "slice");     // Catch: Throwable -> L18
        goto L24
    L10:
        r106 = r103;
    L24:
        if ((r100 instanceof LoadingViewHolder) == false) goto L47;
        LoadingViewHolder r110 = (LoadingViewHolder) r100;
        Object r111 = ListProtector.get(this.f86604d, r101);
        if ((r111 instanceof rt0.a) == true) goto L28;
        r111 = null;
    L28:
        rt0.a r112 = (rt0.a) r111;
        TabDataHelper r113 = this.f86601a;
        r110.getClass();
        if (r112 == null) goto L47;
        if (r112.f539162c == false) goto L40;
        TextView r114 = r110.f86606b;
        if (r114 == null) goto L36;
        r114.setText(s1.B(R.string.ttlive_tab_loading));
    L36:
        ImageView r115 = r110.f86607c;
        if (r115 == null) goto L39;
        r115.setVisibility(8);
    L39:
        r110.f86608d.setOnClickListener(null);
        goto L47
    L40:
        TextView r116 = r110.f86606b;
        if (r116 == null) goto L43;
        r116.setText(s1.B(R.string.ttlive_tab_loading_error));
    L43:
        ImageView r117 = r110.f86607c;
        if (r117 == null) goto L46;
        r117.setVisibility(0);
    L46:
        r110.f86608d.setOnClickListener(new l(r110, r113));
    L47:
        boolean r118 = r100 instanceof SpaceViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        com.bytedance.android.livesdk.dsl.recyclerview.c r102 = this.f86603c;
        if (r102 == null) goto L11;
        this.f86602b.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        o r103 = r102.f122797f.a(r101);
        if (r103 != null) goto L7;
        SingleDSLViewHolder r104 = null;
    L8:
        if (r104 == null) goto L11;
        return r104;
    L7:
        r104 = new SingleDSLViewHolder(r103, r102);
    L11:
        if (r101 != (-100)) goto L15;
        return new LoadingViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_profile_tabs_loading_item, r100, false));
    L15:
        if (r101 == (-101)) goto L17;
        TextView r105 = new TextView(r100.getContext());
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(50)));
        r105.setGravity(16);
        r105.setBackgroundColor(ColorProtector.parseColor("#56141567"));
        return new ItemViewHolder(r105);
    L17:
        return new SpaceViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_profile_tabs_space_item, r100, false));
    }
}
