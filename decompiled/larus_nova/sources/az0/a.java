package az0;

import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;
import wy0.e;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y6.c f16783a;

    public a(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "originalManager");
        this.f16783a = r100;
    }

    @Override // wy0.e
    public final void registerMethod(String r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "methodProvider");
        this.f16783a.registerMethod(r100, r101);
    }

    @Override // wy0.e
    public final void sendJsEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter("rpcChannelMessage", "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f16783a.sendJSEvent("rpcChannelMessage", r101);
    }

    @Override // wy0.e
    public final void registerMethod(String r100, g<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f16783a.registerMethod(r100, r101);
    }
}
