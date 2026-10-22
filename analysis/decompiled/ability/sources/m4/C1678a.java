package m4;

import android.util.Log;
import com.stepos.ability.deviceid.OnDeviceIdChangedListener;
import com.stepos.ability.net.NetImpl;
import kotlin.jvm.internal.k;
import n4.b;

/* renamed from: m4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1678a implements OnDeviceIdChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetImpl f5301a;

    public C1678a(NetImpl netImpl) {
        this.f5301a = netImpl;
    }

    @Override // com.stepos.ability.deviceid.OnDeviceIdChangedListener
    public final void onDeviceIdChanged(String deviceId) {
        k.f(deviceId, "deviceId");
        Log.d("NetImpl", "onDeviceIdChanged: ".concat(deviceId));
        b bVar = this.f5301a.signInterceptor;
        if (bVar != null) {
            bVar.b = deviceId;
        }
    }
}
