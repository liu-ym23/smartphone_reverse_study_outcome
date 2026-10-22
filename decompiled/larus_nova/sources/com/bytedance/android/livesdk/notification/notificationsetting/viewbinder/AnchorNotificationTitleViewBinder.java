package com.bytedance.android.livesdk.notification.notificationsetting.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: classes11.dex */
public final class AnchorNotificationTitleViewBinder extends b<fz.b, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f154111b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/notification/notificationsetting/viewbinder/AnchorNotificationTitleViewBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f154112a;

        public ViewHolder(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            TextView r102 = (TextView) r100.findViewById(R.id.notify_title);
            this.f154112a = r102;
            if (r101 == false) goto L5;
            int r103 = R.color.ttlive_douyin_light_TextTertiary;
        L6:
            r102.setTextColor(s1.h(r103));
            return;
        L5:
            r103 = R.color.ttlive_douyin_dark_TextTertiary;
            goto L6
        }
    }

    public AnchorNotificationTitleViewBinder(boolean r100) {
        this.f154111b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, fz.b r101) {
        ViewHolder r102 = (ViewHolder) r100;
        fz.b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.f154112a.setText(r103.f479344a);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new ViewHolder(r100.inflate(R.layout.ttlive_notification_setting_title, r101, false), this.f154111b);
    }
}
