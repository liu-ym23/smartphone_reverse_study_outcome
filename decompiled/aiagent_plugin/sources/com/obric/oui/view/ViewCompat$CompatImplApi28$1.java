package com.obric.oui.view;

import android.view.KeyEvent;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class ViewCompat$CompatImplApi28$1 implements View.OnUnhandledKeyEventListener {
    final /* synthetic */ ViewCompat.e val$listener;

    ViewCompat$CompatImplApi28$1(ViewCompat.e r3) {
        this.val$listener = (ViewCompat.e) ZeusTransformUtils.wrapperContextForParams(r3, ViewCompat.e.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View.OnUnhandledKeyEventListener
    public boolean onUnhandledKeyEvent(View r1, KeyEvent r2) {
        return this.val$listener.a(r1, r2);
    }
}
