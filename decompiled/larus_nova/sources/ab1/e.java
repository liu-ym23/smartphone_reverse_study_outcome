package ab1;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f2463b;

    public e(long r100, Function1 r101) {
        this.f2462a = r100;
        this.f2463b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        mb0.c.a.a(ya1.a.f567014a, LinkMonitorData.ApiSoloKtvGetPersonalKaraokeData, System.currentTimeMillis() - this.f2462a, r101);
        this.f2463b.invoke(r101);
    }
}
