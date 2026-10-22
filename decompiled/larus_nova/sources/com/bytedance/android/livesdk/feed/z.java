package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.live.HotsoonLiveAdViewHolder;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f124602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f124603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ILiveRoomListDataSource f124604c;

    public z(tv1.c r100, f r101, NewTabRepository r102, LiveRoomListDataSource r103) {
        this.f124602a = r101;
        this.f124603b = r102;
        this.f124604c = r103;
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r110, Object[] r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "payloads");
        View r100 = LayoutInflater.from(r110.getContext()).inflate(R.layout.ttlive_item_feed_ad, r110, false);
        if (r111.length != 0) goto L5;
        boolean r112 = true;
    L7:
        if ((!r112) == false) goto L14;
        Object r113 = r111[0];
        if ((r113 instanceof mv1.l) == false) goto L14;
        if (r113 == null) goto L13;
        FeedDataKey r101 = ((mv1.l) r113).a();
    L16:
        if (r111.length <= 1) goto L24;
        Object r114 = r111[1];
        if ((r114 instanceof PublishSubject) == false) goto L24;
        if (r114 == null) goto L22;
        PublishSubject r115 = (PublishSubject) r114;
        goto L24
    L22:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<com.bytedance.android.live.base.model.feed.FeedItem?>");
    L24:
        if (r111.length <= 2) goto L31;
        Object r116 = r111[2];
        if ((r116 instanceof PublishSubject) == false) goto L31;
        if (r116 == null) goto L30;
        PublishSubject r102 = (PublishSubject) r116;
    L33:
        if (r111.length <= 3) goto L40;
        Object r117 = r111[3];
        if ((r117 instanceof PublishSubject) == false) goto L40;
        if (r117 == null) goto L39;
        PublishSubject r103 = (PublishSubject) r117;
    L42:
        if (r111.length <= 4) goto L50;
        Object r118 = r111[4];
        if ((r118 instanceof PublishSubject) == false) goto L50;
        if (r118 == null) goto L48;
        PublishSubject r119 = (PublishSubject) r118;
        goto L50
    L48:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L50:
        return new HotsoonLiveAdViewHolder(r100, this.f124602a, r101, this.f124603b, r102, r103);
    L39:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L40:
        r103 = null;
        goto L42
    L30:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L31:
        r102 = null;
        goto L33
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r101 = null;
        goto L16
    L5:
        r112 = false;
        goto L7
    }
}
