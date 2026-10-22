package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.k;
import com.bytedance.common.wschannel.m;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: OkChannelImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements WeakHandler.IHandler, IWsChannelClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f6819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f6822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f6823e;
    private boolean f;
    private Map<String, Object> g;
    private List<String> h;
    private ContentObserver i;

    static {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r1, boolean r2, String r3) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r1) {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
    }

    static /* synthetic */ Context a(a r0) {
        return r0.f6821c;
    }

    static /* synthetic */ boolean a(a r2, Context r3) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Map b(a r0) {
        return r0.g;
    }

    static /* synthetic */ List c(a r0) {
        return r0.h;
    }

    public a(int r2, Handler r3) {
        this.g = new HashMap();
        this.f6820b = r2;
        this.f6822d = r3;
        final Handler r4 = this.f6822d;
        this.i = new OkChannelImpl$1(this, r4);
    }

    private boolean a(Context r2) {
        return m.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).e();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r5, IWsChannelClient r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        IWsChannelClient r8 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r6, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        a("WsChannelSdk_ok", "init() , channelId = " + this.f6820b);
        this.f6821c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        b(r7);
        c r0 = new c.a(r7).a(new com.bytedance.common.wschannel.channel.impl.ok.a.c(r7)).a(k.a(this.f6820b)).a();
        this.f6823e = r0;
        r0.a(new e(this.f6821c, this.f6823e, r8));
        c(r7);
    }

    private void b(Context r11) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        long r1 = System.currentTimeMillis();
        Class r0 = ZeusTransformUtils.forName("com.bytedance.mobsec.metasec.ov.MSB", "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r0 != null) goto L16;
        return;
    L16:
        r0.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r0, new Object[]{r10, 2, null});     // Catch: Throwable -> L10
    L12:
        f6819a = System.currentTimeMillis() - r1;
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L5:
        a("WsChannelSdk_ok", "MSSdk Class -com.bytedance.mobsec.metasec.ov.MSB- not found, init fail.");
        f6819a = -1;
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        a("WsChannelSdk_ok", "destroy() , channelId = " + this.f6820b);
        this.f6823e.d();
        a();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r3) {
        if (a(this.f6821c) == true) goto L5;
        return;
    L5:
        a("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f6820b);
        c r2 = this.f6823e;
        boolean r0 = true;
        if (r3 == 1) goto L9;
        r0 = false;
    L9:
        r2.a(r0);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r3) {
        if (a(this.f6821c) == true) goto L5;
        return;
    L5:
        a("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f6820b);
        this.f6823e.a(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.f6823e.c();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        this.g.putAll(r5);
    L5:
        this.h = r6;
        if (a(this.f6821c) == true) goto L8;
        return;
    L8:
        this.f6823e.a(r5, r6);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        a("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f6820b);
        this.f6823e.a();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        this.g.putAll(r5);
    L5:
        this.h = r6;
        if (a(this.f6821c) == true) goto L8;
        return;
    L8:
        a("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f6820b);
        this.f6823e.b(r5, r6);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r3) {
        if (a(this.f6821c) == true) goto L6;
        return false;
    L6:
        a("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f6820b);
        return this.f6823e.a(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        a("WsChannelSdk_ok", "onMessage(),channel = " + this.f6820b);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        a("WsChannelSdk_ok", "onConnection()");
    }

    private void c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        ZeusProviderTransform.registerContentObserver(r6.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(r6, WsConstants.KEY_OK_IMPL_ENABLE, WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE), true, this.i, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    private void a() {
        Context r0 = this.f6821c;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        ZeusProviderTransform.unregisterContentObserver(r0.getContentResolver(), this.i, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
