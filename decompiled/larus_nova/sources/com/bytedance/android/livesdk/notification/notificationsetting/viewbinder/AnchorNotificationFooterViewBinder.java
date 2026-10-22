package com.bytedance.android.livesdk.notification.notificationsetting.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class AnchorNotificationFooterViewBinder extends me.drakeet.multitype.b<a, ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/notification/notificationsetting/viewbinder/AnchorNotificationFooterViewBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveDoubleColorBallAnimationView f154110a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            TextView r101 = (TextView) r100.findViewById(R.id.tv_title);
            this.f154110a = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.loading_anim_view);
            r101.setVisibility(8);
        }
    }

    public static final class a extends fz.a {
    }

    public static final class b {
    }

    static {
    }

    public AnchorNotificationFooterViewBinder(boolean r100) {
    }

    @Override // me.drakeet.multitype.b
    public final void f(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.f154110a.setVisibility(8);
        r101.f154110a.c();
    }

    @Override // me.drakeet.multitype.b
    public final void g(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.f154110a.setVisibility(8);
        r101.f154110a.c();
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        ViewHolder r102 = (ViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "anchorFooter");
        r103.getClass();
        r102.f154110a.setVisibility(8);
        r102.f154110a.c();
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_dynamic_item_no_more, r101, false));
    }
}
