package i3;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3142a;

    public a(b bVar) {
        this.f3142a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3142a.f3145c.set(ILogIngestService.Stub.asInterface(iBinder));
        Log.d("LogSdkClient", "service connected: " + componentName);
        AgentCacheSdk.init$lambda$0();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3142a.f3145c.set(null);
        Log.w("LogSdkClient", "service disconnected: " + componentName);
    }
}
