package a40;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1716b;

    public c(d40.a.b r100, long r101) {
        this.f1715a = r100;
        this.f1716b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        o r102 = this.f1715a;
        if (r102 == null) goto L6;
        dc6.a.a(this.f1716b);
        r102.onPingSuccess();
        return;
    }
}
