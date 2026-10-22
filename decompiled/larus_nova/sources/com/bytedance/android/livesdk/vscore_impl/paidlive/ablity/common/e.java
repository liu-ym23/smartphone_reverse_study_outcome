package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveRefreshStreamListener;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f160173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f160174b;

    public e(a r100, int r101) {
        this.f160173a = r100;
        this.f160174b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f160173a.i(r101.getMessage(), this.f160174b);
        Iterator r102 = ((ArrayList) this.f160173a.f160127c).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        IPaidLiveRefreshStreamListener r103 = (IPaidLiveRefreshStreamListener) r102.next();
        r103.requestStreamFail(r101.getMessage(), this.f160174b);
        this.f160173a.a("paidlive_refresh_request_fail", "listener " + r103 + " notify request room stream url fail, reason " + r101.getMessage(), null);
        goto L4
    L6:
        this.f160173a.a(null, "requestFullRightStream: request stream url fail, reason " + r101.getMessage() + ", isPreview=" + (this.f160173a instanceof com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.preview.a), null);
    }
}
