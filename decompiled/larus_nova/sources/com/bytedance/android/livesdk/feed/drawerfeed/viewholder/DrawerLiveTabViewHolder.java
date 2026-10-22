package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.widget.LiveTabIndicator;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class DrawerLiveTabViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f123907c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IFeedActionCallback f123908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTabIndicator f123909b;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final boolean fullSpan() {
        return true;
    }

    public DrawerLiveTabViewHolder(View r100, IFeedActionCallback r101) {
        super(r100);
        this.f123909b = (LiveTabIndicator) r100.findViewById(R.id.ttlive_tab_indicator);
        this.f123908a = r101;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        com.bytedance.android.livesdk.feed.feed.h r102 = (com.bytedance.android.livesdk.feed.feed.h) r100.getItem();
        this.f123909b.setTitles(r102.f124014a);
        this.f123909b.setOnTabClickListener(new u(this));
        HashMap r103 = new HashMap();
        r103.put("event_belong", "live");
        r103.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live");
        r103.put("event_type", "show");
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r104 = r102.f124014a.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.feed.feed.e r105 = r104.next();
        if (r105.f124012a == false) goto L4;
        this.f123909b.c(r105);
        String r106 = r105.e();
        if (r106 == null) goto L4;
        r103.put("enter_from_merge", "live_".concat(r106));
        goto L4
    L10:
        kw1.c.d("subtab_show", r103);
    }
}
