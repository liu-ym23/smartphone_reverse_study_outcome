package com.bytedance.android.livesdk.feed.squarefeed.viewholder;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder;
import com.bytedance.android.livesdk.feed.openui.view.SimpleLiveView;
import com.bytedance.android.livesdk.g;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public class SimpleLiveViewHolder extends CommonLiveViewHolder {
    public final View D;
    public final SimpleLiveView E;

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String V3() {
        if (this.f124106m.getFeedType() != FeedType.FOLLOW_FEED) goto L7;
        return "homepage_follow";
    L7:
        if (this.f124106m.getFeedType() != FeedType.HOT_FEED) goto L10;
        return "live_search_section";
    L10:
        return "live_channel";
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void c4(FeedItem r100) {
        Bundle r101 = new Bundle();
        Bundle r102 = new Bundle();
        r102.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, "live_big_picture");
        String r103 = this.f124096c.f124004b;
        if (r103.contains("live") == false) goto L9;
        e r104 = this.f124101h;
        if (r104 == null) goto L9;
        r103 = r104.e();
        if (TextUtils.isEmpty(r103) == false) goto L9;
        r103 = "live_merge_null";
    L9:
        r102.putString("subtab", r103);
        r101.putString("source", r103);
        r101.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_EXTRA_V1, r102);
        r101.putString("log_pb", r100.logPb);
        r101.putString("request_id", r100.resId);
        e r105 = this.f124101h;
        if (r105 == null) goto L12;
        r101.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_FROM, r105.l());
    L12:
        r101.putString("enter_from", "live");
        r101.putString("enter_from_merge", r103);
        if (r100.isRecommendCard == false) goto L16;
        r101.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "pop_card");
    L16:
        if (TextUtils.isEmpty(r100.liveReason) == true) goto L18;
        r101.putString("live_reason", r100.liveReason);
    L18:
        r101.putString("enter_method", "live_cover");
        Y3(r100, true, a.VALUE_BIG_PICTURE, r101);
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r100, Room r110, int r111) {
        super.U3(r100, r110, r111);
        UIUtils.setViewVisibility(this.f124112t, 8);
        UIUtils.setViewVisibility(this.D, 8);
        UIUtils.setViewVisibility(this.f124111s, 8);
        this.E.setVisibility(0);
        k r112 = null;
        this.itemView.setOnLongClickListener(null);
        g.f125376a.getValue().booleanValue();
        SimpleLiveView r101 = this.E;
        String r102 = this.f124106m.d40();
        String r103 = V3();
        LiveCoverConfig r104 = this.f124106m.kG();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "room");
        Intrinsics.checkNotNullParameter(r102, "feedUrl");
        r101.f124257a = r110;
        r101.f124261e = r102;
        r101.f124258b = r103;
        User r105 = r110.mo8271getOwner();
        if (r110.isMediaRoom() == false) goto L8;
        User r106 = r110.mo8271getOwner();
        if (r106 == null) goto L7;
        String r107 = r106.getRealNickName();
    L9:
        String r108 = r107;
    L10:
        String r109 = p1.b(r110);
        k r113 = r110.getContentLabel();
        if ((r113 instanceof ImageModel) == false) goto L14;
        r112 = r113;
    L14:
        r101.c(r105, (ImageModel) r112, r108, 0, r109, r104);
        return;
    L7:
        r108 = null;
        goto L10
    L8:
        r107 = r110.getTitle();
        goto L9
    }

    public SimpleLiveViewHolder(View r110, FeedDataKey r111, PublishSubject<Boolean> r112, h r113, IFeedActionCallback r114) {
        super(r110, null, null, r111, null, null, null, r112, r113);
        this.D = r110.findViewById(R.id.content_container);
        this.E = (SimpleLiveView) r110.findViewById(R.id.live_card);
    }
}
