package com.bytedance.ai.debugscene;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class h0 implements com.bytedance.ai.debug.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f36376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0.b f36377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.debug.i f36378c;

    public /* synthetic */ h0(AtomicBoolean r100, f0.b r101, com.bytedance.ai.debug.i r102) {
        this.f36376a = r100;
        this.f36377b = r101;
        this.f36378c = r102;
    }

    @Override // com.bytedance.ai.debug.i
    public final void a(int r100, String r101, String r102) {
        AtomicBoolean r103 = this.f36376a;
        f0.b r104 = this.f36377b;
        com.bytedance.ai.debug.i r105 = this.f36378c;
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r103.compareAndSet(false, true) == true) goto L6;
        com.bytedance.ai.utils.g.f37637a.w("AIDebugPanelCoordinator", "ignore duplicated panel reply, code:" + r100);
        return;
    L6:
        if (r104.f36355b.get() == true) goto L8;
        com.bytedance.ai.utils.g.f37637a.w("AIDebugPanelCoordinator", "drop panel reply because session is unavailable, code:" + r100);
        return;
    L8:
        r104.b(r105, r100, r101, r102);
    }
}
