package an0;

import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.revenue.platform.api.core.c;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends tz0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4492a = null;

    @Override // tz0.a
    public final List<com.bytedance.android.livesdk.revenue.network.a> a() {
        return c.a(new a[]{new a()});
    }

    static {
        f4492a = new b();
    }

    public b() {
    }

    @Override // tz0.a
    public final INetworkService.Biz b() {
        return INetworkService.Biz.MultiLink;
    }
}
