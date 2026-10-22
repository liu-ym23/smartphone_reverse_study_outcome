package com.bytedance.android.livesdk.feed.tab.repository;

import com.bytedance.android.live.core.setting.l3;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.tab.api.FeedTabApi;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;

/* JADX INFO: loaded from: classes8.dex */
public final class p extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static l f124519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f124520e = false;

    static {
        f124520e = l3.f65349a.getValue().booleanValue();
    }

    public static l f() {
        if (f124519d != null) goto L9;
        if (f124520e == true) goto L7;
        f124519d = new p(new s(new xw1.a(), new xw1.d(), LiveFeedContext.appContext().getApplicationContext(), new com.bytedance.android.livesdk.feed.n()), new t((FeedTabApi) com.bytedance.android.live.network.c.b().e(FeedTabApi.class)));
        goto L9
    L7:
        f124519d = (NewTabRepository) NewTabRepository.f124511d.getValue();
    L9:
        return f124519d;
    }

    public p(s r100, t r101) {
        super(r100, r101);
    }
}
