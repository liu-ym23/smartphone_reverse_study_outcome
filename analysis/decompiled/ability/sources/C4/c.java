package C4;

import D6.i;
import android.net.Uri;
import com.stepos.ability.App;
import com.stepos.ability.commoninternal.KeepAliveHelper;
import com.stepos.ability.commoninternal.NetworkStateBridge;
import com.stepos.ability.voicewakeup.VoicePermissionProvider;
import com.stepos.ability.voicewakeup.service.l;
import io.modelcontextprotocol.spec.McpStreamableServerSession;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292a;

    public /* synthetic */ c(int i) {
        this.f292a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f292a) {
            case 0:
                Uri uri = VoicePermissionProvider.c;
                l.o(!l.i(), new i(null, 19));
                break;
            case 1:
                O5.d dVar = O5.c.f1037a;
                if (dVar.a() != null) {
                    S5.a aVarA = dVar.a();
                    App app = dVar.f1038a;
                    aVarA.getClass();
                    A0.b bVar = new A0.b(2);
                    bVar.b = app;
                    aVarA.f1175a = bVar.t();
                    break;
                } else {
                    W5.c.b("SDKInstanceImpl", "refreshDeviceInfo fail, subject is null");
                    break;
                }
            case 2:
                KeepAliveHelper.endKeepAlive$lambda$0();
                break;
            case 3:
                KeepAliveHelper.setKeepAliveRunnable$lambda$0();
                break;
            case 4:
                NetworkStateBridge.notifyNetworkLost$lambda$0();
                break;
            default:
                McpStreamableServerSession.lambda$delete$2();
                break;
        }
    }
}
