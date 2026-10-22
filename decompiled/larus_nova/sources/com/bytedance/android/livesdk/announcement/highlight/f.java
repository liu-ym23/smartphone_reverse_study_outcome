package com.bytedance.android.livesdk.announcement.highlight;

import android.content.Context;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announcement.u0;
import com.bytedance.ies.utility.SharedPrefHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementHighlightAnchorServiceWidget f103475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f103476b;

    public f(AnnouncementHighlightAnchorServiceWidget r100, long r101) {
        this.f103475a = r100;
        this.f103476b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        if (r101.statusCode != 0) goto L5;
        int r102 = u0.f103594a;
        Context r103 = this.f103475a.context;
        long r104 = this.f103476b;
        SharedPrefHelper r105 = SharedPrefHelper.b(r103);
        r105.l("live.pref.PREF_ANNOUNCEMENT_ID_SHOW_IN_HIGHLIGHT", Long.valueOf(r104));
        r105.a();
        int r106 = c0.f103470a;
        c0.c(r101.statusCode);
        return;
    L5:
        int r107 = u0.f103594a;
        u0.a.a(this.f103475a.context);
        int r108 = c0.f103470a;
        c0.c(r101.statusCode);
    }
}
