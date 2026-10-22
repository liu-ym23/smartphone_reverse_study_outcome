package com.obric.matrix.sdk.network;

import android.app.Application;
import android.content.Context;
import com.GlobalProxyLancet;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkSDKInit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/sdk/network/NetworkSDKInit;", "", "()V", "TAG", "", "config", "Lcom/obric/matrix/sdk/network/NetworkConfig;", "getConfig", "()Lcom/obric/matrix/sdk/network/NetworkConfig;", "setConfig", "(Lcom/obric/matrix/sdk/network/NetworkConfig;)V", "init", "", "context", "Landroid/content/Context;", "application", "Landroid/app/Application;", "host", "interceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "requestListener", "Lcom/obric/matrix/sdk/network/InterfaceRequestListener;", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkSDKInit {
    public static final NetworkSDKInit INSTANCE = null;
    public static final String TAG = "NetworkSDKInit";
    public static NetworkConfig config;

    static {
        INSTANCE = new NetworkSDKInit();
    }

    private NetworkSDKInit() {
    }

    public final NetworkConfig getConfig() {
        NetworkConfig r0 = config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(NetworkConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        config = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NetworkSDKInit r7, Context r8, Application r9, String r10, NetworkConfig r11, List r12, InterfaceRequestListener r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = null;
    L5:
        r7.init(r8, r9, r10, r11, r12, r13);
    }

    public final void init(Context r7, Application r8, String r9, NetworkConfig r10, List<? extends Interceptor> r11, InterfaceRequestListener r12) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "application");
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r10, "config");
        long r1 = System.currentTimeMillis();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "init start, startTime: " + r1);
        INSTANCE.setConfig(r10);     // Catch: Throwable -> L5
        TTNetHelper.INSTANCE.initTTNet(r7, r8, r10.getNeedSetCookieHandler(), r10.getApiProcessHook());     // Catch: Throwable -> L5
        TTNetHelper.INSTANCE.setRequestListener(r12);     // Catch: Throwable -> L5
        OceanHttpUtil.INSTANCE.setParam$sdk_network_release(r9, r11);     // Catch: Throwable -> L5
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "init success, 初始化耗时: " + (System.currentTimeMillis() - r1) + " ms");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "init failed, 初始化耗时: " + (System.currentTimeMillis() - r1) + " ms", th);
    }
}
