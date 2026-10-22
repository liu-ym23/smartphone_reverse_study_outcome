package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerBannerViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f124525a;

    public u() {
        this.f124525a = o.f124172a;
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r110, Object[] r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "payloads");
        View r100 = LayoutInflater.from(r110.getContext()).inflate(R.layout.ttlive_feed_view_drawer_banner, r110, false);
        if (r111.length != 0) goto L5;
        boolean r101 = true;
    L7:
        if ((!r101) == false) goto L14;
        Object r102 = r111[0];
        if ((r102 instanceof mv1.l) == false) goto L14;
        if (r102 == null) goto L13;
        mv1.l r103 = (mv1.l) r102;
        FeedDataKey r104 = r103.a();
        BannerSwipeRefreshLayout.a r105 = r103.b();
        FeedDataKey r106 = r104;
    L16:
        if (r111.length <= 2) goto L23;
        Object r107 = r111[2];
        if ((r107 instanceof PublishSubject) == false) goto L23;
        if (r107 == null) goto L22;
        PublishSubject r108 = (PublishSubject) r107;
    L25:
        if (r111.length <= 3) goto L32;
        Object r109 = r111[3];
        if ((r109 instanceof PublishSubject) == false) goto L32;
        if (r109 == null) goto L31;
        PublishSubject r112 = (PublishSubject) r109;
    L34:
        if (r111.length <= 4) goto L41;
        Object r113 = r111[4];
        if ((r113 instanceof PublishSubject) == false) goto L41;
        if (r113 == null) goto L40;
        PublishSubject r114 = (PublishSubject) r113;
    L43:
        return new DrawerBannerViewHolder(r100, r105, r106, r108, r112, r114, this.f124525a, r110);
    L40:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L41:
        r114 = null;
        goto L43
    L31:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L32:
        r112 = null;
        goto L34
    L22:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L23:
        r108 = null;
        goto L25
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r105 = null;
        r106 = null;
        goto L16
    L5:
        r101 = false;
        goto L7
    }
}
