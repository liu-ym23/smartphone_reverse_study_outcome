package stepos.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes5.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public static final b f40767b = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Context f40768a;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f40769a;

        /* renamed from: b, reason: collision with root package name */
        public long f40770b;

        public b() {
        }
    }

    public s(Context context) {
        this.f40768a = context;
    }

    public final Location a() {
        return null;
    }

    public boolean b() {
        b bVar = f40767b;
        if (!c(bVar) && a() == null) {
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int i10 = Calendar.getInstance().get(11);
            return i10 < 6 || i10 >= 22;
        }
        return bVar.f40769a;
    }

    public final boolean c(b bVar) {
        return bVar != null && bVar.f40770b > System.currentTimeMillis();
    }
}
