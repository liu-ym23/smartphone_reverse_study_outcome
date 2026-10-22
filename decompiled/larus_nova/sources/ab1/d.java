package ab1;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f2461b;

    public d(long r100, Function1 r101) {
        this.f2460a = r100;
        this.f2461b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        mb0.c.a.b(ya1.a.f567014a, LinkMonitorData.ApiSoloKtvGetPersonalKaraokeData, System.currentTimeMillis() - this.f2460a, r101.logId);
        this.f2461b.invoke(r101);
    }
}
