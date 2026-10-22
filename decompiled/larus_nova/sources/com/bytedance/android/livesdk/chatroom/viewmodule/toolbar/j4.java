package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.VSOgcDynamicLoader;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j4 implements nm1.w, com.bytedance.android.scope.o {
    public j4() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // nm1.w
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.b0 a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.b0(r100);
    }

    @Override // nm1.w
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.w c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.w(r100);
    }

    @Override // nm1.w
    public final VSOgcDynamicLoader d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        return new VSOgcDynamicLoader(r100);
    }
}
