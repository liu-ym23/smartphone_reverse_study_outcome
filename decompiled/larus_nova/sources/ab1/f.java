package ab1;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f2465b;

    public f(long r100, Function1 r101) {
        this.f2464a = r100;
        this.f2465b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.c.a.b(ya1.a.f567014a, LinkMonitorData.ApiSoloKtvSyncPersonalKaraokeTabList, System.currentTimeMillis() - this.f2464a, r101.logId);
        this.f2465b.invoke(r101);
    }
}
