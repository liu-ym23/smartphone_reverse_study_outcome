package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements com.bytedance.android.scope.o, vr1.p {
    public s() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.p
    public final Context a(Context r100) {
        if ((r100 instanceof LynxContext) == true) goto L5;
        r100 = null;
    L5:
        LynxContext r101 = (LynxContext) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getBaseContext();
    }
}
