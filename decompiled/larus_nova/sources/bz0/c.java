package bz0;

import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends d implements yy0.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.lynx.jsbridge.f> f21815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.lynx.tasm.behavior.a> f21816f;

    public c() {
        this.f21815e = new ArrayList();
        this.f21816f = new ArrayList();
    }

    @Override // yy0.b
    public final void f(com.lynx.tasm.behavior.a r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        ((ArrayList) this.f21816f).add(r100);
    }

    @Override // yy0.b
    public final void c(Class r100, NativeHostServiceImpl.a r101) {
        Intrinsics.checkNotNullParameter("aiolink-message", "name");
        Intrinsics.checkNotNullParameter(r100, "clz");
        List<com.lynx.jsbridge.f> r102 = this.f21815e;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new b(r100, r101));
    }
}
