package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.b1;
import com.bytedance.android.livesdkapi.service.MessageHub;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageHub f146719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f146720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f146721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f146722d;

    public h(MessageHub r100, Function2 r101, String r102, Map r103) {
        this.f146719a = r100;
        this.f146720b = r101;
        this.f146721c = r102;
        this.f146722d = r103;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new b1(this.f146719a, this.f146720b, this.f146721c, this.f146722d);
    }
}
