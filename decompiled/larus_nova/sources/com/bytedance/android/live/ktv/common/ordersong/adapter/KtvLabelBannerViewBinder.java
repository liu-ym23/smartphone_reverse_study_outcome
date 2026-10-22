package com.bytedance.android.live.ktv.common.ordersong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment$getCustomItemViewBinderAction$1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: classes45.dex */
public final class KtvLabelBannerViewBinder extends me.drakeet.multitype.b<LabelBannerUrl, VH> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VH f70121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f70122c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/adapter/KtvLabelBannerViewBinder$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class VH extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f70123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.android.live.ktv.common.ordersong.adapter.a f70124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LabelBannerUrl f70125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f70126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f70127e;

        public final void release() {
            ALogger.d("KtvLabelBannerViewBinder", "release");
            com.bytedance.android.live.ktv.common.ordersong.adapter.a r100 = this.f70124b;
            if (r100 == null) goto L5;
            r100.release();
        L5:
            this.f70124b = null;
            this.f70127e = false;
            this.f70126d = false;
            ViewGroup r101 = this.f70123a;
            if (r101 == null) goto L9;
            r101.removeAllViews();
            return;
        }

        public VH(View r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "listener");
            super(r100);
            this.f70123a = (ViewGroup) r100.findViewById(R.id.lynx_dynamic_banner);
        }
    }

    public static final class a {
    }

    public interface b {
        void a();

        boolean getForceUpdateBannerState();
    }

    static {
    }

    public KtvLabelBannerViewBinder(MusicListSecondLevelTabFragment$getCustomItemViewBinderAction$1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f70122c = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, LabelBannerUrl r101) {
        VH r102 = (VH) r100;
        LabelBannerUrl r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        this.f70121b = r102;
        StringBuilder r104 = new StringBuilder("onBindViewHolder, isLoading=");
        r104.append(r102.f70127e);
        r104.append(", isLoadSuccess=");
        r104.append(r102.f70127e);
        r104.append(", holderUrl=");
        LabelBannerUrl r105 = r102.f70125c;
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.getUrl();
    L6:
        r104.append(r107);
        r104.append(", itemUrl=");
        r104.append(r103.getUrl());
        ALogger.d("KtvLabelBannerViewBinder", r104.toString());
        if (r102.f70127e == true) goto L11;
        if (r102.f70126d == true) goto L11;
    L19:
        Intrinsics.checkNotNullParameter(r103, "labelBanner");
        r102.release();
        r102.f70125c = r103;
        r102.f70127e = true;
        Context r108 = r102.itemView.getContext();
        String r109 = r103.getUrl();
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        com.bytedance.android.live.ktv.common.ordersong.adapter.a r110 = new com.bytedance.android.live.ktv.common.ordersong.adapter.a(r102, r108, x6.a.d(r109), s1.y());
        r102.f70124b = r110;
        r110.loadUrl(r103.getUrl());
        this.f70122c.a();
        return;
    L11:
        if (((Boolean) h.J0.getValue(null, h.f556082a[86])).booleanValue() == true) goto L13;
        return;
    L13:
        if (this.f70122c.getForceUpdateBannerState() == false) goto L25;
        LabelBannerUrl r111 = r102.f70125c;
        if (r111 == null) goto L18;
        r106 = r111.getUrl();
    L18:
        if ((!Intrinsics.areEqual(r106, r103.getUrl())) == true) goto L19;
        return;
    L25:
        return;
    L5:
        r107 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new VH(r100.inflate(R.layout.ttlive_ktv_music_list_view_holder_label_banner, r101, false), this.f70122c);
    }
}
