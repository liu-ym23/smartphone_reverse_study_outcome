package com.bytedance.android.shopping.anchorv4.ai;

import com.bytedance.android.ec.base.api.ai.FloatChatWindowState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j0 implements xe.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpAIRuntime f165667a;

    public j0(PdpAIRuntime r100) {
        this.f165667a = r100;
    }

    @Override // xe.b
    public final void a(FloatChatWindowState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f165667a.f165629d = r100;
    }
}
