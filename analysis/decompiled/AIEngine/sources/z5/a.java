package z5;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f14261a;

    public a(b bVar) {
        this.f14261a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f14261a.f14264c.set(ILogIngestService.Stub.asInterface(iBinder));
        Log.d("LogSdkClient", "service connected: " + componentName);
        AgentCacheSdk.init$lambda$0();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b bVar = this.f14261a;
        bVar.f14264c.set(null);
        bVar.f14265d.set(false);
        Log.w("LogSdkClient", "service disconnected: " + componentName);
    }
}
