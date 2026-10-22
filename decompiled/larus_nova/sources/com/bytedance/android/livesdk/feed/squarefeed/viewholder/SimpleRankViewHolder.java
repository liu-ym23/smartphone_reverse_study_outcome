package com.bytedance.android.livesdk.feed.squarefeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.rank.a;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.openui.view.SimpleLiveView;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kw1.c;
import ww1.l;
import ww1.m;

/* JADX INFO: loaded from: classes8.dex */
public class SimpleRankViewHolder extends BaseViewHolder<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f124472d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleLiveView f124473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f124474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<Boolean> f124475c;

    public final void T3() {
        SimpleLiveView r100 = this.f124473a;
        r100.getClass();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("enter_from_merge", r100.f124258b);
        r101.put("enter_method", "main_tab");
        Room r102 = r100.f124257a;
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.getOwnerUserIdString();
        if (r104 == null) goto L6;
    L7:
        r101.put("anchor_id", r104);
        Room r105 = r100.f124257a;
        Long r106 = null;
        if (r105 == null) goto L10;
        Long r107 = Long.valueOf(r105.f162599id);
    L11:
        r101.put("room_id", String.valueOf(r107));
        r101.put("action_type", "click");
        Room r108 = r100.f124257a;
        if (r108 == null) goto L15;
        String r109 = r108.getRequestId();
        if (r109 == null) goto L15;
    L16:
        r101.put("request_id", r109);
        Room r110 = r100.f124257a;
        if (r110 == null) goto L22;
        String r111 = r110.getLog_pb();
        if (r111 == null) goto L22;
        r103 = r111;
    L22:
        r101.put("log_pb", r103);
        Room r112 = r100.f124257a;
        if (r112 == null) goto L25;
        RoomExtra r113 = r112.getExtra();
    L27:
        if (r113 == null) goto L41;
        Room r114 = r100.f124257a;
        if (r114 == null) goto L34;
        RoomExtra r115 = r114.getExtra();
        if (r115 == null) goto L34;
        if (r115.getXiguaUid() == 0) goto L41;
    L34:
        Room r116 = r100.f124257a;
        if (r116 == null) goto L39;
        RoomExtra r117 = r116.getExtra();
        if (r117 == null) goto L39;
        Long r118 = Long.valueOf(r117.getXiguaUid());
    L40:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, String.valueOf(r118));
    L39:
        r118 = null;
    L41:
        Room r119 = r100.f124257a;
        if (r119 != null) goto L44;
    L45:
        if (r119 == null) goto L47;
        r106 = Long.valueOf(r119.appId);
    L47:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, String.valueOf(r106));
    L48:
        c.d("livesdk_live_show", r101);
        return;
    L44:
        if (r119.appId == 0) goto L48;
    L25:
        r113 = null;
    L15:
        r109 = "";
        goto L16
    L10:
        r107 = null;
    L6:
        r104 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        T3();
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(a r110, int r111) {
        a r112 = r110;
        SimpleLiveView r100 = this.f124473a;
        String r113 = this.f124474b.d40();
        if (this.f124474b.getFeedType() != FeedType.FOLLOW_FEED) goto L6;
        String r101 = "homepage_follow";
    L9:
        LiveCoverConfig r102 = this.f124474b.kG();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r112, "rankItem");
        Intrinsics.checkNotNullParameter(r113, "feedUrl");
        User r103 = r112.d();
        r100.f124261e = r113;
        r100.f124257a = r112.a();
        com.bytedance.android.live.base.model.rank.c r114 = r112.c();
        if (r114 == null) goto L12;
        long r104 = r114.d();
    L14:
        if (r104 >= 10000) goto L16;
        String r115 = String.valueOf(r104);
    L17:
        String r105 = r115;
        r100.f124258b = r101;
        com.bytedance.android.live.base.model.rank.c r116 = r112.c();
        String r106 = null;
        if (r116 == null) goto L20;
        ImageModel r117 = r116.a();
    L21:
        com.bytedance.android.live.base.model.rank.c r107 = r112.c();
        if (r107 == null) goto L24;
        r106 = r107.c();
    L24:
        r100.c(r103, r117, r106, r112.b(), r105, r102);
        PublishSubject<Boolean> r118 = this.f124475c;
        if (r118 == null) goto L28;
        register(r118.subscribe(new l(this), new m()));
        return;
    L28:
        return;
    L20:
        r117 = null;
        goto L21
    L16:
        r115 = FormatUtils.format("%.1f", new Object[]{Double.valueOf((r104 * 1.0d) / 10000.0d)}) + "w";
        goto L17
    L12:
        r104 = 0;
        goto L14
    L6:
        if (this.f124474b.getFeedType() != FeedType.HOT_FEED) goto L8;
        r101 = "live_search_section";
        goto L9
    L8:
        r101 = UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT;
        goto L9
    }

    public SimpleRankViewHolder(View r100, PublishSubject r101, h r102, IFeedActionCallback r103) {
        super(r100);
        this.f124473a = (SimpleLiveView) r100.findViewById(R.id.live_card);
        this.f124475c = r101;
        this.f124474b = r102;
    }
}
