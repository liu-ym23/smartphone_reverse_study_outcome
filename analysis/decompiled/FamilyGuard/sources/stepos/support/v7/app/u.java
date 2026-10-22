package stepos.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class u {

    /* renamed from: b, reason: collision with root package name */
    private static final b f21111b = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Context f21112a;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f21113a;

        /* renamed from: b, reason: collision with root package name */
        long f21114b;

        private b() {
        }
    }

    u(Context context) {
        this.f21112a = context;
    }

    private Location a() {
        return null;
    }

    private boolean c(b bVar) {
        return bVar != null && bVar.f21114b > System.currentTimeMillis();
    }

    boolean b() {
        b bVar = f21111b;
        if (!c(bVar) && a() == null) {
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int i5 = Calendar.getInstance().get(11);
            return i5 < 6 || i5 >= 22;
        }
        return bVar.f21113a;
    }
}
