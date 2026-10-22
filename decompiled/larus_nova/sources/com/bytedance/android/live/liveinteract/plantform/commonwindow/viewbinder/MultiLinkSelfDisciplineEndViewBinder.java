package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.SelfDisciplineEndView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkSelfDisciplineEndViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkSelfDisciplineEndViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f75978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SelfDisciplineEndView f75979b;

        public ItemViewHolder(View r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "parentView");
            super(r100);
            this.f75979b = (SelfDisciplineEndView) this.itemView.findViewById(R.id.ttlive_self_discipline_end_view);
            this.f75978a = r101;
        }
    }

    public static final class a extends tf0.e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ILinkPlayerInfoBridge f75980k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f75981l;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f75980k, r101.f75980k) == true) goto L8;
            return false;
        L8:
            if (this.f75981l == r101.f75981l) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ILinkPlayerInfoBridge r100 = this.f75980k;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f75981l;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "SelfDisciplineEndItemData(linkPlayerInfo=" + this.f75980k + ", position=" + this.f75981l + ")";
        }

        public a(ILinkPlayerInfoBridge r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "linkPlayerInfo");
            this.f75980k = r100;
            this.f75981l = r101;
        }
    }

    public MultiLinkSelfDisciplineEndViewBinder() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r110, a r111) {
        ItemViewHolder r112 = (ItemViewHolder) r110;
        a r113 = r111;
        Intrinsics.checkNotNullParameter(r112, "holder");
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        ILinkPlayerInfoBridge r114 = r113.f75980k;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r114, "linkPlayInfo");
        ALogger.d("MultiLinkSelfDisciplineEndViewBinder", "bind viewHolder: " + r112.hashCode());
        SelfDisciplineEndView r115 = r112.f75979b;
        if (r115 == null) goto L37;
        SelfDisciplineContext.a r100 = SelfDisciplineContext.Companion;
        SelfDisciplineContext r101 = r100.getContext();
        if (r101 == null) goto L11;
        ConcurrentHashMap<String, Long> r102 = r101.getDurationHolder();
        if (r102 == null) goto L11;
        Long r103 = r102.get(je0.d.b0());
        if (r103 == null) goto L11;
        long r104 = r103.longValue();
    L12:
        Intrinsics.checkNotNullParameter(r114, "info");
        ConstraintLayout r105 = (ConstraintLayout) r115.a(R.id.container);
        if (r105 == null) goto L15;
        r105.setVisibility(0);
    L15:
        TextView r106 = (TextView) r115.a(R.id.tv_record);
        long r107 = 60;
        long r108 = r104 % r107;
        TimeUnit r109 = TimeUnit.SECONDS;
        long r116 = r109.toMinutes(r104) % r107;
        r106.setText(SelfDisciplineEndView.b(r109.toHours(r104)) + ':' + SelfDisciplineEndView.b(r116) + ':' + SelfDisciplineEndView.b(r108));
        int r117 = SelfDisciplineContext.a.a();
        if (r117 != 2) goto L19;
        ((HSImageView) r115.a(R.id.end_view_iv)).setVisibility(8);
    L31:
        HSImageView r118 = (HSImageView) r115.a(R.id.iv_bg);
        IBaseUser r119 = r114.getUser();
        if (r119 == null) goto L34;
        k r120 = r119.getAvatarMedium();
    L35:
        ImageLoader.bindImage(r118, r120, new l3(5));
        return;
    L34:
        r120 = null;
        goto L35
    L19:
        if (r117 != 1) goto L31;
        ((HSImageView) r115.a(R.id.end_view_iv)).setVisibility(0);
        if (r104 >= r114.getSelfDisciplineTargetDuration()) goto L30;
        SelfDisciplineContext r121 = r100.getContext();
        if (r121 == null) goto L29;
        m<Integer> r122 = r121.getLastPunchStatus();
        if (r122 == null) goto L29;
        if (r122.getValue().intValue() == 2) goto L30;
    L29:
        ((HSImageView) r115.a(R.id.end_view_iv)).setImageResource(R.drawable.ttlive_bg_self_discipline_complete_falied);
        ((TextView) r115.a(R.id.tv_hint)).setText(r115.getContext().getResources().getString(R.string.ttlive_self_discipline_punch_uncompleted));
    L30:
        ((HSImageView) r115.a(R.id.end_view_iv)).setImageResource(R.drawable.ttlive_bg_self_discipline_complete_success);
        ((TextView) r115.a(R.id.tv_hint)).setText(r115.getContext().getResources().getString(R.string.ttlive_self_discipline_punch_completed));
    L11:
        r104 = 0;
        goto L12
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ItemViewHolder(LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_item_multi_link_selfdiscipline_end_stub, r101, false), r101);
    }
}
