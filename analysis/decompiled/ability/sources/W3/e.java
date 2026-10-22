package W3;

import android.content.Context;
import com.stepos.ability.deviceid.OnDeviceIdChangedListener;
import com.stepos.ability.manager.AbilityManager;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class e implements OnDeviceIdChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbilityManager f1488a;

    public e(AbilityManager abilityManager) {
        this.f1488a = abilityManager;
    }

    @Override // com.stepos.ability.deviceid.OnDeviceIdChangedListener
    public final void onDeviceIdChanged(String deviceId) {
        k.f(deviceId, "deviceId");
        AbilityManager abilityManager = this.f1488a;
        abilityManager.deviceId = deviceId;
        com.stepos.ability.manager.watcher.b bVar = abilityManager.abilityInstallerWatcher;
        if (bVar == null) {
            k.n("abilityInstallerWatcher");
            throw null;
        }
        bVar.b = deviceId;
        com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
        if (aVar == null) {
            k.n("syncCoordinator");
            throw null;
        }
        Context context = abilityManager.getContext();
        k.f(context, "context");
        aVar.n = deviceId;
        com.stepos.ability.manager.discovery.a aVar2 = aVar.m;
        if (aVar2 != null) {
            aVar2.b = deviceId;
        }
        aVar.l(context, "deviceIdChanged");
    }
}
