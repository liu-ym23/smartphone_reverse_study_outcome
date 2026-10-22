package com.bytedance.android.anniex.worker;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IDLXBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSWorkerBDXBridge f41497a;

    public a(JSWorkerBDXBridge r100) {
        this.f41497a = r100;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod.b
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f41497a.a(r100, r101);
    }
}
