package com.bytedance.android.livesdk.notification.notificationsetting.viewbinder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bn2.e;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.larus.nova.R;
import j40.k;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: classes11.dex */
public final class AnchorNotifyViewBinder extends b<cn2.a, ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f154113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f154114c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/notification/notificationsetting/viewbinder/AnchorNotifyViewBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f154115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f154116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f154117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f154118d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f154119e;

        public ViewHolder(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f154119e = r101;
            this.f154115a = (HSImageView) r100.findViewById(R.id.user_avatar);
            TextView r102 = (TextView) r100.findViewById(R.id.user_name);
            this.f154116b = r102;
            this.f154117c = (ImageView) r100.findViewById(R.id.notification_image);
            if (r101 == false) goto L5;
            int r103 = R.color.ttlive_douyin_light_TextSecondary;
        L6:
            r102.setTextColor(s1.h(r103));
            return;
        L5:
            r103 = R.color.ttlive_douyin_dark_TextSecondary;
            goto L6
        }
    }

    public interface a {
        void a(String r100, long r101, String r102, ImageModel r103);
    }

    public AnchorNotifyViewBinder(boolean r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "callBack");
        this.f154113b = r100;
        this.f154114c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, cn2.a r101) {
        ViewHolder r102 = (ViewHolder) r100;
        cn2.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        TextView r104 = r102.f154116b;
        FollowInfo r105 = r103.b();
        Long r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.getRemarkName();
    L7:
        if (TextUtils.isEmpty(r107) == true) goto L12;
        FollowInfo r108 = r103.b();
        if (r108 == null) goto L11;
        String r109 = r108.getRemarkName();
    L13:
        r104.setText(r109);
        ImageModel r110 = r103.a();
        if (r110 == null) goto L19;
        HSImageView r111 = r102.f154115a;
        if (k.f497248a.getValue().booleanValue() == false) goto L18;
        ImageLoader.bindImage(r111, r110, R.drawable.ttlive_img_avatar_empty);
        goto L19
    L18:
        a1.v(r111, r110, R.drawable.ttlive_img_avatar_empty);
    L19:
        FollowInfo r112 = r103.b();
        if (r112 == null) goto L22;
        long r113 = r112.getPushStatus();
    L24:
        if (r113 != 1) goto L31;
        ImageView r114 = r102.f154117c;
        if (r102.f154119e == false) goto L28;
        int r115 = R.drawable.ttlive_notification_setting_push_all_push_icon_light;
    L29:
        r114.setImageResource(r115);
    L44:
        r102.itemView.setOnClickListener(new com.bytedance.android.livesdk.notification.notificationsetting.viewbinder.a(r102, r103));
        HashMap<String, String> r116 = bn2.k.f19730a;
        FollowInfo r117 = r103.b();
        if (r117 == null) goto L47;
        r106 = Long.valueOf(r117.getPushStatus());
    L47:
        bn2.k.c(r106, r103.d(), "setting", false);
        return;
    L28:
        r115 = R.drawable.ttlive_notification_setting_push_all_push_icon;
        goto L29
    L31:
        if (r113 != 2) goto L38;
        ImageView r118 = r102.f154117c;
        if (r102.f154119e == false) goto L35;
        int r119 = R.drawable.ttlive_notification_setting_personalise_push_icon_light;
    L36:
        r118.setImageResource(r119);
        goto L44
    L35:
        r119 = R.drawable.ttlive_notification_setting_personalise_push_icon;
        goto L36
    L38:
        if (r113 != 3) goto L44;
        ImageView r120 = r102.f154117c;
        if (r102.f154119e == false) goto L42;
        int r121 = R.drawable.ttlive_notification_setting_push_no_push_icon_light;
    L43:
        r120.setImageResource(r121);
        goto L44
    L42:
        r121 = R.drawable.ttlive_notification_setting_push_no_push_icon;
        goto L43
    L22:
        r113 = 0;
        goto L24
    L11:
        r109 = null;
        goto L13
    L12:
        r109 = r103.c();
        goto L13
    L5:
        r107 = null;
        goto L7
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        ViewHolder r102 = new ViewHolder(r100.inflate(R.layout.ttlive_notify_setting_anchor, r101, false), this.f154113b);
        r102.f154118d = this.f154114c;
        return r102;
    }
}
