package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementHighlightAudienceWidgetOpt f103497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f103498b;

    public x(AnnouncementHighlightAudienceWidgetOpt r100, boolean r101) {
        this.f103497a = r100;
        this.f103498b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((AnnouncementApi.SubscribeRequestResponse) ((BaseResponse) r100).data).getResponseStatus() != 1) goto L6;
        AnnouncementHighlightAudienceWidgetOpt.Lq(this.f103497a, this.f103498b);
        return;
    }
}
