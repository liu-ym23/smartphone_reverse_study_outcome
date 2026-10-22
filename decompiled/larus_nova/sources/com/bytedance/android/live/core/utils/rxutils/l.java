package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements Function<Observable<Throwable>, ObservableSource<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f66358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f66361d;

    public static class a {
        public a() {
        }

        public boolean a(Throwable r100, int r101) {
            ALogger.w("ObservableRetryFunction", "exception=" + r100.getMessage() + " retryCount=" + r101);
            if ((r100 instanceof NetworkErrorException) == false) goto L10;
            NetworkErrorException r102 = (NetworkErrorException) r100;
            if (r102.getStatusCode() >= 500) goto L7;
            return false;
        L7:
            if (r102.getStatusCode() > 599) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    @Override // io.reactivex.functions.Function
    public final ObservableSource<?> apply(Observable<Throwable> r100) throws Exception {
        return r100.flatMap(new k(this));
    }

    public l(int r100, long r101) {
        this(r100, r101, new a());
    }

    public l(int r100, long r101, a r102) {
        this.f66360c = 0;
        if (r100 > 0) goto L6;
        r100 = 1;
    L6:
        this.f66358a = r100;
        if (r101 > 0) goto L10;
        r101 = 500;
    L10:
        this.f66359b = r101;
        this.f66361d = r102;
    }
}
