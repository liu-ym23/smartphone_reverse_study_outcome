package v9;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.monitor.cloudmessage.broadcast_receiver.NetworkBroadcastReceiver;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import i6.d;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import w0.c;
import w0.e;

/* JADX INFO: loaded from: classes3.dex */
public class b extends e implements IResponseConfigListener, IMonitorLogConsumer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f25118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public NetworkBroadcastReceiver f25119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f25121j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25122a;

        public a(b r10) {
            this.f25122a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            v9.a.k().e();
        }
    }

    /* JADX INFO: renamed from: v9.b$b, reason: collision with other inner class name */
    public class RunnableC0394b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25123a;

        public RunnableC0394b(b r10) {
            this.f25123a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            v9.a.k().e();
        }
    }

    public b() {
        this.f25120i = false;
        this.f25121j = Arrays.asList(new String[]{"timer", "count", "disk", "memory", "cpu", "fps", "traffic", "start", "page_load", "image_monitor", "api_all", "api_error", "common_log", "service_monitor", "performance_monitor", "ui_action"});
    }

    @Override // w0.e, com.bytedance.services.apm.api.IWidget
    public void destroy() {
        super.destroy();
        NetworkBroadcastReceiver r10 = this.f25119h;     // Catch: Exception -> L7
        if (r10 == null) goto L10;
        this.f25118g.unregisterReceiver(r10);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public String getTag() {
        return b.class.getSimpleName();
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public void handleLogData(long r10, long r11, String r12, IMonitorLogQueryCallback r13) {
        ((IMonitorLogManager) n5.b.a(IMonitorLogManager.class)).getLegacyLog(r10 * 1000, r11 * 1000, r12, r13);
    }

    @Override // w0.e, com.bytedance.services.apm.api.IWidget
    public void init(Context r10) {
        super.init(r10);
        this.f25118g = r10;
        v9.a.r(r10);
        ((IConfigManager) n5.b.a(IConfigManager.class)).registerResponseConfigListener(this);
        v9.a.x(this);
        ActivityLifeObserver.getInstance().register(this);
        c();
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public boolean isOnlyMainProcess() {
        return true;
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public void notifyLogDataConsumed(String r10, String r11) {
        ((IMonitorLogManager) n5.b.a(IMonitorLogManager.class)).deleteLegacyLogByIds(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void notifyParams(d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (com.bytedance.common.utility.collection.b.a(r10.a()) == false) goto L11;
        return;
    L11:
        URL r11 = new URL((String) r10.a().get(0));     // Catch: MalformedURLException -> L8
        ea.a.f19329a = String.format("%s://%s/%s", new Object[]{r11.getProtocol(), r11.getHost(), "monitor/collect/c/cloudcontrol/file"});     // Catch: MalformedURLException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // w0.e, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        if (b("close_cloud_request") == false) goto L5;
        return;
    L5:
        if (c.F() == false) goto L9;
        AsyncEventManager.e().j(new RunnableC0394b(this), AnimationConstants.DURATION_2000L);
        return;
    }

    @Override // w0.e, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        if (this.f25120i == false) goto L5;
        return;
    L5:
        this.f25120i = true;
        if (b("close_cloud_request") == false) goto L8;
        return;
    L8:
        if (c.F() == false) goto L12;
        this.f25119h = new NetworkBroadcastReceiver();
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f25118g.registerReceiver(this.f25119h, r10);
        AsyncEventManager.e().h(new a(this));
        return;
    }

    @Override // com.bytedance.services.slardar.config.IResponseConfigListener
    public void onResponse(JSONObject r10) {
        if (v9.a.s() == true) goto L10;
        JSONArray r11 = r10.optJSONArray("cloud_commands");
        if (r11 == null) goto L12;
        int r12 = 0;
    L8:
        if (r12 >= r11.length()) goto L13;
        String r13 = r11.optString(r12);
        v9.a.k().p(r13);
        r12 = r12 + 1;
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public String[] parseLogType(JSONObject r10) {
        JSONArray r11 = r10.optJSONArray("upload_type");
        int r12 = 0;
        if (r11 != null) goto L9;
        String[] r13 = new String[this.f25121j.size()];
    L6:
        if (r12 >= this.f25121j.size()) goto L8;
        r13[r12] = (String) this.f25121j.get(r12);
        r12 = r12 + 1;
        goto L6
    L8:
        return r13;
    L9:
        String[] r14 = new String[r11.length()];
    L11:
        if (r12 >= r11.length()) goto L13;
        r14[r12] = r11.optString(r12);
        r12 = r12 + 1;
        goto L11
    L13:
        return r14;
    }

    @Override // w0.e, com.bytedance.services.apm.api.IWidget
    public void start() {
        super.start();
    }

    @Override // w0.e, com.bytedance.services.apm.api.IWidget
    public void stop() {
        super.stop();
    }
}
