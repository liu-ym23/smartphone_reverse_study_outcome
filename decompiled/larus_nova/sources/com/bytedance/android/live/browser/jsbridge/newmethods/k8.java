package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k8 implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f63506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w20.bc f63507b;

    public static final class a implements m00.a {
        public a() {
        }
    }

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        IBroadcastService r101 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        Context r102 = this.f63506a.getContext();
        Integer r103 = this.f63507b.a();
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        r101.showAnchorManagerInputDialog(r102, r104, this.f63507b.b(), new a());
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public k8(CallContext r100, w20.bc r101) {
        this.f63506a = r100;
        this.f63507b = r101;
    }
}
