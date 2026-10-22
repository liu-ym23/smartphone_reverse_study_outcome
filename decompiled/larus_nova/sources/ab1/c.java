package ab1;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f2459b;

    public c(long r100, Function1 r101) {
        this.f2458a = r100;
        this.f2459b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        mb0.c.a.a(ya1.a.f567014a, LinkMonitorData.ApiSoloKtvAnchorGetSongInfo, System.currentTimeMillis() - this.f2458a, r101);
        ExceptionUtils.handleException(s1.getContext(), r101);
        this.f2459b.invoke(r101);
    }
}
