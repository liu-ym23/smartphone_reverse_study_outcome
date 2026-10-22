package bz0;

import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import com.lynx.jsbridge.LynxModule;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends com.lynx.jsbridge.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f21812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Class f21813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f21814f;

    @Override // com.lynx.jsbridge.f
    public final Class<? extends LynxModule> a() {
        return this.f21813e;
    }

    @Override // com.lynx.jsbridge.f
    public final String b() {
        return this.f21812d;
    }

    @Override // com.lynx.jsbridge.f
    public final Object c() {
        return this.f21814f;
    }

    public b(Class r100, NativeHostServiceImpl.a r101) {
        this.f21812d = "aiolink-message";
        this.f21813e = r100;
        this.f21814f = r101;
    }
}
