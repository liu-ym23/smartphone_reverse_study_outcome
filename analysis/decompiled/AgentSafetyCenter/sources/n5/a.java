package n5;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import g5.u;
import h.a0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: f, reason: collision with root package name */
    public final a0 f8760f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8761g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, p5.i iVar, int i) {
        super(context, iVar);
        this.f8761g = i;
        this.f8760f = new a0(this, 2);
    }

    @Override // n5.e
    public final Object a() {
        switch (this.f8761g) {
            case 0:
                Intent intentRegisterReceiver = this.f8766b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver == null) {
                    u.d().b(b.f8762a, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                return Boolean.valueOf(intExtra == 2 || intExtra == 5);
            case 1:
                Intent intentRegisterReceiver2 = this.f8766b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver2 == null) {
                    u.d().b(c.f8763a, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra2 = intentRegisterReceiver2.getIntExtra("status", -1);
                float intExtra3 = intentRegisterReceiver2.getIntExtra("level", -1) / intentRegisterReceiver2.getIntExtra("scale", -1);
                boolean z10 = true;
                if (intExtra2 != 1 && intExtra3 <= 0.15f) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            default:
                Intent intentRegisterReceiver3 = this.f8766b.registerReceiver(null, e());
                boolean z11 = true;
                if (intentRegisterReceiver3 != null && intentRegisterReceiver3.getAction() != null) {
                    String action = intentRegisterReceiver3.getAction();
                    if (action == null) {
                        z11 = false;
                    } else {
                        int iHashCode = action.hashCode();
                        if (iHashCode == -1181163412) {
                            action.equals("android.intent.action.DEVICE_STORAGE_LOW");
                        } else if (iHashCode != -730838620 || !action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                        }
                        z11 = false;
                    }
                }
                return Boolean.valueOf(z11);
        }
    }

    @Override // n5.e
    public final void c() {
        u.d().a(d.f8764a, getClass().getSimpleName().concat(": registering receiver"));
        this.f8766b.registerReceiver(this.f8760f, e());
    }

    @Override // n5.e
    public final void d() {
        u.d().a(d.f8764a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f8766b.unregisterReceiver(this.f8760f);
    }

    public final IntentFilter e() {
        switch (this.f8761g) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.CHARGING");
                intentFilter.addAction("android.os.action.DISCHARGING");
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }
}
