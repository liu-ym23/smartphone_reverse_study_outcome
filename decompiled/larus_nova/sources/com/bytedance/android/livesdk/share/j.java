package com.bytedance.android.livesdk.share;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareTicketFragment f158097a;

    public j(ShareTicketFragment r100) {
        this.f158097a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (r101 == null) goto L5;
        LivePosterApiService.PaidLiveShareTicketDataResponse r102 = (LivePosterApiService.PaidLiveShareTicketDataResponse) r101.data;
    L6:
        if (r102 != null) goto L8;
        ShareTicketFragment r103 = this.f158097a;
        r103.I = false;
        ShareTicketFragment.U90(r103);
        return;
    L8:
        ShareTicketFragment r104 = this.f158097a;
        String r105 = ((LivePosterApiService.PaidLiveShareTicketDataResponse) r101.data).getTitle();
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r104.L = r105;
        ShareTicketFragment r106 = this.f158097a;
        r106.M = ((LivePosterApiService.PaidLiveShareTicketDataResponse) r101.data).getReleaseTime();
        ShareTicketFragment r107 = this.f158097a;
        r107.N = ((LivePosterApiService.PaidLiveShareTicketDataResponse) r101.data).getAvatar();
        ShareTicketFragment r108 = this.f158097a;
        r108.I = true;
        ShareTicketFragment.U90(r108);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
