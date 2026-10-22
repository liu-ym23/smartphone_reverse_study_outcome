package com.bytedance.android.livesdk.chatroom.replay.widget;

import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayBottomPanelManagerWidget f110374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f110375b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b7.a, b7.b
    public final void onRelease() {
        ReplayBottomPanelManagerWidget r100 = this.f110374a;
        Uri r101 = (Uri) this.f110375b.element;
        r100.getClass();
        ALogger.i("VsBottomPanelManagerWidget", "unregisterMessageListener");
        vlc.d r102 = r100.f110313b;
        if (r102 == null) goto L5;
        r102.removeMessageListener(r100);
    L5:
        r100.f110312a = null;
    }

    public h(ReplayBottomPanelManagerWidget r100, Ref.ObjectRef r101) {
        this.f110374a = r100;
        this.f110375b = r101;
    }
}
