package a4;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements IWsChannelClient {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f19h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f20i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f22b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f24d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IWsChannelClient f26f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IMessageHandler f27g;

    static {
    }

    public a(int r10, IMessageHandler r11, Handler r12) {
        this.f23c = false;
        this.f25e = true;
        this.f21a = r10;
        this.f27g = r11;
        this.f22b = r12;
        if (e() == false) goto L14;
        d();     // Catch: Throwable -> L7 ClassNotFoundException -> L12
        if (this.f25e == false) goto L9;
        Logger.d("WsChannelClient", "使用cronet建立长链接");     // Catch: Throwable -> L7 ClassNotFoundException -> L12
    L17:
    L9:
        Logger.d("WsChannelClient", "使用PushManager建立长链接");     // Catch: Throwable -> L7 ClassNotFoundException -> L12
        f20i = false;     // Catch: Throwable -> L7 ClassNotFoundException -> L12
    L12:
        Logger.d("WsChannelClient", "未检测到插件或者插件下载失败");
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.d("WsChannelClient", "未检测到插件或者插件下载失败");
    L14:
        if (this.f26f != null) goto L20;
        Logger.d("WsChannelClient", "使用okhttp建立长链接");
        this.f26f = new com.bytedance.common.wschannel.channel.impl.ok.a(r10, r12);
        return;
    }

    public static a b(int r10, IMessageHandler r11, Handler r12) {
        return new a(r10, r11, r12);
    }

    public final Class a(String r10) {
        return Class.forName(r10);
    L4:
        return null;
    }

    public final void c(JSONObject r10) {
        IMessageHandler r11 = this.f27g;
        if (r11 == null) goto L6;
        r11.onConnection(this, this.f21a, r10);
        return;
    }

    public final void d() {
        if (this.f26f == null) goto L5;
        return;
    L5:
        if (e.b(f19h) == true) goto L7;
        Class r10 = a(f19h);
    L8:
        if (r10 != null) goto L10;
        r10 = a("org.chromium.wschannel.MySelfChannelImpl");
        this.f25e = true;
    L10:
        if (r10 != null) goto L12;
        r10 = a("com.b.c.ws.MySelfChannelImpl");
        this.f25e = false;
    L12:
        if (r10 == null) goto L17;
        Object r11 = r10.newInstance();
        if ((r11 instanceof IWsChannelClient) == false) goto L19;
        this.f26f = (IWsChannelClient) r11;
        return;
    L19:
        return;
    L17:
        throw new ClassNotFoundException("plugin class not found");
    L7:
        r10 = null;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        monitor-enter(this);
        this.f23c = true;     // Catch: Throwable -> L13
        IWsChannelClient r10 = this.f26f;     // Catch: Throwable -> L13
        if (r10 == null) goto L20;
        r10.destroy();     // Catch: Throwable -> L13
        if ((this.f26f instanceof com.bytedance.common.wschannel.channel.impl.ok.a) == true) goto L20;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L13
        List r12 = this.f24d;     // Catch: Throwable -> L13
        if (r12 != null) goto L11;
    L15:
        String r13 = "";
    L24:
        r11.put("type", 0);     // Catch: Throwable -> L13 Exception -> L18
        r11.put(WsConstants.KEY_CONNECTION_STATE, 3);     // Catch: Throwable -> L13 Exception -> L18
        r11.put("url", r13);     // Catch: Throwable -> L13 Exception -> L18
        r11.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Throwable -> L13 Exception -> L18
        c(r11);     // Catch: Throwable -> L13 Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L20
    L11:
        if (r12.size() < 1) goto L15;
        r13 = (String) this.f24d.get(0);     // Catch: Throwable -> L13
    L20:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean e() {
        return f20i;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r10, IWsChannelClient r11) {
        IWsChannelClient r12 = this.f26f;
        if (r12 != null) goto L12;
        return;
    L12:
        r12.init(r10, r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.f26f instanceof com.bytedance.common.wschannel.channel.impl.ok.a) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet长连接初始化失败，用ok实现");
        com.bytedance.common.wschannel.channel.impl.ok.a r13 = new com.bytedance.common.wschannel.channel.impl.ok.a(this.f21a, this.f22b);
        this.f26f = r13;
        r13.init(r10, r11);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient r10 = this.f26f;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r10) {
        IWsChannelClient r11 = this.f26f;
        if (r11 == null) goto L6;
        r11.onAppStateChanged(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f23c == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        c(r10);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r10) {
        IMessageHandler r11 = this.f27g;
        if (r11 == null) goto L6;
        r11.onMessage(this.f21a, r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r10) {
        IWsChannelClient r11 = this.f26f;
        if (r11 == null) goto L6;
        r11.onNetworkStateChanged(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map r10, List r11) {
        IWsChannelClient r12 = this.f26f;
        if (r12 == null) goto L5;
        r12.onParameterChange(r10, r11);
    L5:
        this.f24d = r11;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map r10, List r11) {
        IWsChannelClient r12 = this.f26f;
        if (r12 == null) goto L5;
        r12.openConnection(r10, r11);
    L5:
        this.f24d = r11;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r10) {
        IWsChannelClient r11 = this.f26f;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.sendMessage(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient r10 = this.f26f;
        if (r10 == null) goto L6;
        r10.stopConnection();
        return;
    }
}
