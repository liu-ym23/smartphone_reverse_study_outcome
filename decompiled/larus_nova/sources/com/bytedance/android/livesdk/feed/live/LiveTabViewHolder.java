package com.bytedance.android.livesdk.feed.live;

import android.view.View;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.feed.h;
import com.bytedance.android.livesdk.feed.widget.LiveTabIndicator;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import jw1.f0;
import jw1.x;
import kw1.c;

/* JADX INFO: loaded from: classes8.dex */
public class LiveTabViewHolder extends BaseViewHolder<FeedItem> implements x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f124162d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IFeedActionCallback f124163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTabIndicator f124164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f124165c;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final boolean fullSpan() {
        return true;
    }

    public final void T3(e r100) {
        HashMap r101 = new HashMap();
        r101.put("event_belong", "live");
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live");
        r101.put("event_type", "click");
        r101.put("event_module", "live_" + r100.e());
        c.d("subtab_click", r101);
        this.f124163a.WS(IFeedActionCallback.FeedAction.TAB_CLICK, r100);
    }

    @Override // jw1.x
    public final void f0(int r100) {
        h r101 = this.f124165c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f124164b == null) goto L19;
        Iterator<e> r102 = r101.f124014a.iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        e r103 = r102.next();
        if (r103.f() != r100) goto L9;
        this.f124164b.c(r103);
        T3(r103);
        goto L9
    L20:
        return;
    }

    public LiveTabViewHolder(View r100, IFeedActionCallback r101) {
        super(r100);
        this.f124164b = (LiveTabIndicator) r100.findViewById(R.id.ttlive_tab_indicator);
        this.f124163a = r101;
        r101.WS(IFeedActionCallback.FeedAction.SET_SWITCH_TAB_LISTENER, this);
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        h r102 = (h) r100.getItem();
        this.f124165c = r102;
        this.f124164b.setTitles(r102.f124014a);
        this.f124164b.setOnTabClickListener(new f0(this));
        HashMap r103 = new HashMap();
        r103.put("event_belong", "live");
        r103.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live");
        r103.put("event_type", "show");
        Iterator<e> r104 = r102.f124014a.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        e r105 = r104.next();
        if (r105.f124012a == false) goto L4;
        this.f124164b.c(r105);
        String r106 = r105.e();
        if (r106 == null) goto L4;
        r103.put("enter_from_merge", "live_".concat(r106));
        goto L4
    L10:
        c.d("subtab_show", r103);
    }
}
