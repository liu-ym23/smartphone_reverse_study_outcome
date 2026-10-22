package k6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Calendar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u0003J\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lk6/a;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "c", Const.INTENT_KEY_APIKEY, "", Const.INTENT_KEY_PKGNAME, "()Z", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a extends BroadcastReceiver {
    public final void a() {
        if (b()) {
            U5.b bVar = U5.b.INSTANCE;
            if (!bVar.n()) {
                bVar.o(true);
                return;
            }
        }
        if (b()) {
            return;
        }
        U5.b bVar2 = U5.b.INSTANCE;
        if (bVar2.n()) {
            bVar2.o(false);
        }
    }

    public final boolean b() {
        c cVar = c.INSTANCE;
        if (cVar.e()) {
            return c.g(cVar, 0L, 1, null);
        }
        int i10 = Calendar.getInstance().get(11);
        boolean z10 = false;
        if (7 <= i10 && i10 < 23) {
            z10 = true;
        }
        return !z10;
    }

    public final void c() {
        U5.b.INSTANCE.x();
        a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object systemService = context != null ? context.getSystemService("power") : null;
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null || powerManager.isInteractive()) {
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -1513032534) {
                    if (action.equals("android.intent.action.TIME_TICK")) {
                        U5.b.INSTANCE.x();
                        a();
                        return;
                    }
                    return;
                }
                if (iHashCode == 505380757 && action.equals("android.intent.action.TIME_SET")) {
                    U5.b.INSTANCE.x();
                    a();
                }
            }
        }
    }
}
