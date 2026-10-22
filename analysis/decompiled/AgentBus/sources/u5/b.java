package u5;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.stepos.agentbus.platform.AgentBusApp;

/* loaded from: classes.dex */
public final class b extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AgentBusApp f10107a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f10108b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Handler handler, AgentBusApp agentBusApp, ContentResolver contentResolver) {
        super(handler);
        this.f10107a = agentBusApp;
        this.f10108b = contentResolver;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        AgentBusApp agentBusApp = this.f10107a;
        q7.k.e(agentBusApp, "context");
        if (Settings.Secure.getInt(agentBusApp.getContentResolver(), "user_setup_complete", 0) == 1) {
            Log.i("AgentBusApp", "user_setup_complete became true — running deferred init");
            this.f10108b.unregisterContentObserver(this);
            int i2 = AgentBusApp.f2679h;
            agentBusApp.a();
        }
    }
}
