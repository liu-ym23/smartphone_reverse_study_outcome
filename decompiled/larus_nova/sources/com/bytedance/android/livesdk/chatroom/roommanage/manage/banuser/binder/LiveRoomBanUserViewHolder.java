package com.bytedance.android.livesdk.chatroom.roommanage.manage.banuser.binder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.roommanage.common.RoomManageButton;
import com.bytedance.android.livesdk.chatroom.roommanage.manage.banuser.f;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/manage/banuser/binder/LiveRoomBanUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomBanUserViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VHeadView f111452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f111453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f111454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoomManageButton f111455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f111456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f111457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f111458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f111459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f111460i;

    public LiveRoomBanUserViewHolder(View r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "presenter");
        super(r100);
        this.f111460i = r101;
        this.f111452a = (VHeadView) r100.findViewById(R.id.iv_user_head);
        this.f111453b = (TextView) r100.findViewById(R.id.tv_user_name);
        this.f111454c = (HSImageView) r100.findViewById(R.id.iv_user_level);
        RoomManageButton r102 = (RoomManageButton) r100.findViewById(R.id.btn_handle);
        this.f111455d = r102;
        this.f111456e = (TextView) r100.findViewById(R.id.tv_op_time);
        this.f111457f = (TextView) r100.findViewById(R.id.tv_op_user_name);
        this.f111458g = (LinearLayout) r100.findViewById(R.id.fans_club_icon_layout);
        this.f111459h = (TextView) r100.findViewById(R.id.tv_user_fan_club_name);
        r102.setConfig(new RoomManageButton.b(r100.getContext().getString(R.string.ttlive_live_room_manage_ban_user_handle), r100.getContext().getString(R.string.ttlive_live_room_manage_ban_user_re_handle)));
    }
}
