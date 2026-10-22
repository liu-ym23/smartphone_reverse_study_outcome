package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements o60.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f77359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f77360b;

    public d(a r100, TokenCert r101) {
        this.f77359a = r100;
        this.f77360b = r101;
    }

    @Override // o60.d
    public final void a() {
        ALogger.d("ttlive_link", "skip bluetooth permission denied and go to settings");
        qh0.d<rh0.a> r100 = this.f77359a.f77352a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r100.onResult(null);
    }
}
