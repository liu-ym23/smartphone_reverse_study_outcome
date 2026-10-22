package M4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;

/* loaded from: classes3.dex */
public final class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f969a;

    public a(b bVar) {
        this.f969a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f969a.c.set(ILogIngestService.Stub.asInterface(iBinder));
        Log.d("LogSdkClient", "service connected: " + componentName);
        AgentCacheSdk.init$lambda$0();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b bVar = this.f969a;
        bVar.c.set(null);
        bVar.d.set(false);
        Log.w("LogSdkClient", "service disconnected: " + componentName);
    }
}
