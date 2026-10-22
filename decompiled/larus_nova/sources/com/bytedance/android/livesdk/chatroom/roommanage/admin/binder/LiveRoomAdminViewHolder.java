package com.bytedance.android.livesdk.chatroom.roommanage.admin.binder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.LiveRoomAdminManageListPresenter;
import com.bytedance.android.livesdk.chatroom.roommanage.common.RoomManageButton;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.search.dto.UserGroupScene;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/admin/binder/LiveRoomAdminViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomAdminViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f111243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VHeadView f111244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f111245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f111246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f111247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f111248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoomManageButton f111249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f111250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f111251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LiveRoomAdminManageListPresenter f111252j;

    public static final class a {
    }

    static {
    }

    public LiveRoomAdminViewHolder(View r100, LiveRoomAdminManageListPresenter r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "presenter");
        super(r100);
        this.f111252j = r101;
        RoomPermissionContext r102 = null;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L7;
        n<RoomPermissionContext> r104 = r103.getPermissionContext();
        if (r104 == null) goto L7;
        r102 = r104.getValue();
    L7:
        if (r102 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        this.f111243a = r105;
        this.f111244b = (VHeadView) r100.findViewById(R.id.iv_user_head);
        this.f111245c = (TextView) r100.findViewById(R.id.tv_user_name);
        this.f111246d = (HSImageView) r100.findViewById(R.id.iv_user_level);
        this.f111247e = (TextView) r100.findViewById(R.id.tv_visit_stat);
        this.f111248f = (TextView) r100.findViewById(R.id.tv_contribute_stat);
        RoomManageButton r106 = (RoomManageButton) r100.findViewById(R.id.btn_handle);
        this.f111249g = r106;
        this.f111250h = (LinearLayout) r100.findViewById(R.id.fans_club_icon_layout);
        this.f111251i = (TextView) r100.findViewById(R.id.tv_user_fan_club_name);
        if (r105 == false) goto L15;
        String r107 = s1.B(R.string.ttlive_live_profile_live_room_permission_setup);
    L16:
        r106.setConfig(new RoomManageButton.b(r107, r100.getContext().getString(R.string.ttlive_live_room_manage_admin_re_handle)));
        return;
    L15:
        r107 = s1.B(R.string.ttlive_live_room_manage_setting);
        goto L16
    L9:
        if (r102.getShouldRefinePermission().getValue().booleanValue() == false) goto L11;
        r105 = true;
        goto L12
    }

    public static final void T3(LiveRoomAdminViewHolder r110, td1.d r111) {
        r110.getClass();
        String r100 = r111.mUser.getIdStr();
        if (r111.f545503a == false) goto L5;
        LiveRoomManageAppLogger.i(r110.f111252j.e(), r100, "cancel");
        r110.f111252j.c(r111, null);
        return;
    L5:
        LiveRoomManageAppLogger.i(r110.f111252j.e(), r100, UserGroupScene.DEFAULT_NAME_SPACE);
        LiveRoomAdminManageListPresenter r112 = r110.f111252j;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r111, "adminUser");
        Intrinsics.checkNotNullParameter("admin_list", "enterMethod");
        if (r112.f111190e == true) goto L25;
        Room r101 = r112.f111195j;
        if (r101 == null) goto L24;
        String r102 = r101.getOwnerUserIdString();
        if (r102 == null) goto L26;
        Room r103 = r112.f111195j;
        long r104 = r103.f162599id;
        User r105 = r103.mo8271getOwner();
        if (r105 == null) goto L17;
        Intrinsics.checkNotNullParameter(r105, "$this$secUidExt");
        String r106 = r105.getCastSecUid();
        if (r106 == null) goto L17;
    L18:
        String r107 = r106;
        User r108 = r111.mUser;
        if (r108 == null) goto L27;
        r112.f111190e = true;
        Disposable r113 = r112.f111186a.updateAdmin(3, r108.getIdStr(), r108.getCastSecUid(), r102, r107, r104, "room", "admin_list").compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.roommanage.admin.d(r112, r111), new com.bytedance.android.livesdk.chatroom.roommanage.admin.e(r112));
        r112.f111188c.add(r113);
        return;
    L27:
        return;
    L17:
        r106 = "";
        goto L18
    L26:
        return;
    L24:
        return;
    }
}
