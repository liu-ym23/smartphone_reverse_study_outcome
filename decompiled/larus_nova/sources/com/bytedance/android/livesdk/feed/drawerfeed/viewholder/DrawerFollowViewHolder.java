package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.feed.v0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerFollowViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerFollowViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f123867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f123868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f123869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f123870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FeedItem f123871e;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        FeedItem r100 = this.f123871e;
        if (r100 == null) goto L15;
        ScheduledLiveItem r101 = r100.scheduledLive;
        if (r101 == null) goto L16;
        int r102 = v0.f124550a;
        ILiveService r103 = TTLiveService.getLiveService();
        if (r103 == null) goto L12;
        ILiveOntologyInfoManager r104 = r103.getLiveOntologyRecord();
        if (r104 == null) goto L12;
        String r105 = r104.getEnterFromMerge();
        if (r105 == null) goto L12;
    L13:
        String r106 = r101.getUidStr();
        Intrinsics.checkNotNullParameter(r105, "drawerPage");
        Intrinsics.checkNotNullParameter(r106, "anchorId");
        HashMap r107 = new HashMap();
        r107.put("anchor_id", r106.toString());
        r107.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r105);
        r107.put("enter_from_merge", "drawer_follow");
        r107.put("enter_method", "drawer_cover");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_list_show", r107, new Object[0]);
        return;
    L12:
        r105 = "drawer_null";
        goto L13
    L16:
        return;
    }

    public DrawerFollowViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f123867a = (HSImageView) r100.findViewById(R.id.iv_avatar);
        this.f123868b = (TextView) r100.findViewById(R.id.txt_user_name);
        this.f123869c = (TextView) r100.findViewById(R.id.txt_follow_info);
        TextView r101 = (TextView) r100.findViewById(R.id.txt_follow_live_time);
        this.f123870d = LazyKt.lazy(DrawerFollowViewHolder$announceService$2.INSTANCE);
    }

    public static final void T3(DrawerFollowViewHolder r100, ScheduledLiveItem r101) {
        r100.getClass();
        if (r101 == null) goto L13;
        String r102 = r101.getSecUid();
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = r101.getUidStr().toString();
    L8:
        HashMap r103 = new HashMap();
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r103.put("sec_user_id", r102);
    L11:
        ((IRoomService) jc1.k.n(IRoomService.class)).actionHandler().showUserProfile(r101.getUidStr(), null, r103);
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        this.f123871e = r102;
        if (r102 == null) goto L23;
        ScheduledLiveItem r103 = r102.scheduledLive;
        if (r103 == null) goto L23;
        this.f123868b.setText(r103.getNickName());
        StringBuilder r104 = new StringBuilder();
        String r105 = r103.getScheduledText();
        boolean r106 = false;
        if (r105 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L15;
        r104.append(r103.getScheduledText() + '\n');
    L15:
        String r108 = r103.getAnnouncementContent();
        if (r108 != null) goto L18;
    L19:
        r106 = true;
    L20:
        if (r106 == true) goto L22;
        r104.append(r103.getAnnouncementContent());
        ((IAnnouncementService) this.f123870d.getValue()).logAnnouncementShow("more_anchor_list", "more_anchor_list");
    L22:
        this.f123869c.setText(r104);
        ImageUtil.loadRoundImage(this.f123867a, r103.getAvatar());
        goto L23
    L18:
        if (r108.length() != 0) goto L20;
    L9:
        if (r105.length() == 0) goto L12;
        r107 = false;
    L23:
        this.itemView.setOnClickListener(new m(this, r102));
        this.f123867a.setOnClickListener(new n(this, r102));
    }
}
