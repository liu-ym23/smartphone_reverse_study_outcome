package com.bytedance.applet.aibridge;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsAIBridgePreloadMediaResourceMethodIDL.a f191175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> f191176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z3 f191177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f191178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f191179e;

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        if (Intrinsics.areEqual(this.f191175a.getResource(), r100) == false) goto L8;
        if (r101 == null) goto L8;
        z3.a.a(this.f191177c, r101, this.f191178d, this.f191179e, new AIBridgePreloadMediaResourceMethod.b(this.f191176b), 8);
        return;
    L8:
        f3.h.a.a(this.f191176b, "getVideoModel fails", null, null, 14);
    }

    public k(AbsAIBridgePreloadMediaResourceMethodIDL.a r100, f3.h<AbsAIBridgePreloadMediaResourceMethodIDL.b> r101, z3 r102, String r103, long r104) {
        this.f191175a = r100;
        this.f191176b = r101;
        this.f191177c = r102;
        this.f191178d = r103;
        this.f191179e = r104;
    }
}
