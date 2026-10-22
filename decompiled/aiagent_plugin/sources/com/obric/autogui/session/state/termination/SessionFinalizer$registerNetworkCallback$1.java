package com.obric.autogui.session.state.termination;

import android.net.ConnectivityManager;
import android.net.Network;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SessionFinalizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SessionFinalizer$registerNetworkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ ConnectivityManager $connectivityManager;
    final /* synthetic */ b.InterfaceC0860b $onFinalizeDone;
    final /* synthetic */ b this$0;

    public static /* synthetic */ String lambda$u5CChB3RTLDqk183lrb968NBsx0(b r0) {
        return onAvailable$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$z29J3YWBGzsEXXZPpby-cwbcfds, reason: not valid java name */
    public static /* synthetic */ String m903lambda$z29J3YWBGzsEXXZPpbycwbcfds() {
        return onAvailable$lambda$1();
    }

    private static final String onAvailable$lambda$1() {
        return "Network available, retrying finalization";
    }

    SessionFinalizer$registerNetworkCallback$1(ConnectivityManager r3, b r4, b.InterfaceC0860b r5) {
        b.InterfaceC0860b r6 = (b.InterfaceC0860b) ZeusTransformUtils.wrapperContextForParams(r5, b.InterfaceC0860b.class, "com.obric.aiagent.plugin");
        this.$connectivityManager = r3;
        this.this$0 = r4;
        this.$onFinalizeDone = r6;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r4) {
        o.e(r4, "network");
        Loog r5 = Loog.INSTANCE;
        final b r0 = this.this$0;
        r5.ip("Ses-Fin", new $$Lambda$SessionFinalizer$registerNetworkCallback$1$u5CChB3RTLDqk183lrb968NBsx0(r0), $$Lambda$SessionFinalizer$registerNetworkCallback$1$z29J3YWBGzsEXXZPpbycwbcfds.INSTANCE);
        this.$connectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(this, ConnectivityManager.NetworkCallback.class, "com.obric.aiagent.plugin"));
        b.a(this.this$0, null);
        this.this$0.a(this.$onFinalizeDone);
        this.$connectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback) ZeusTransformUtils.preCheckCast(this, ConnectivityManager.NetworkCallback.class, "com.obric.aiagent.plugin"));
    }

    private static final String onAvailable$lambda$0(b r1) {
        return b.b(r1) + " Network available, retrying finalization";
    }
}
