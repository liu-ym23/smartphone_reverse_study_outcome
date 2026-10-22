package g4;

import com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor;

/* JADX INFO: loaded from: classes.dex */
public class a implements IHeartBeatMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IHeartBeatMonitor f19914a;

    /* JADX INFO: renamed from: g4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0258a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19915a = null;

        static {
            f19915a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f19915a;
        }
    }

    public /* synthetic */ a(C0258a r10) {
        this();
    }

    public static a a() {
        return b.a();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingFail(Throwable r10) {
        IHeartBeatMonitor r11 = this.f19914a;
        if (r11 == null) goto L6;
        r11.onPingFail(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingSuccess() {
        IHeartBeatMonitor r10 = this.f19914a;
        if (r10 == null) goto L6;
        r10.onPingSuccess();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingTimeout() {
        IHeartBeatMonitor r10 = this.f19914a;
        if (r10 == null) goto L6;
        r10.onPingTimeout();
        return;
    }

    public a() {
    }
}
