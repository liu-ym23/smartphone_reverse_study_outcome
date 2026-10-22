package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
class j {
    private static final String TAG = "TwilightManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocationManager f269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f270d;

    /* JADX INFO: compiled from: TwilightManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f272b;

        a() {
        }
    }

    static j a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (f267a != null) goto L6;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f267a = new j(r6, (LocationManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("location"), LocationManager.class, "com.obric.aiagent.plugin"));
    L6:
        return f267a;
    }

    j(Context r3, LocationManager r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f270d = new a();
        this.f268b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f269c = r4;
    }

    boolean a() {
        a r0 = this.f270d;
        if (c() == true) goto L5;
        Location r1 = b();
        if (r1 == null) goto L10;
        a(r1);
        return r0.f271a;
    L10:
        a(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int r2 = Calendar.getInstance().get(11);
        if (r2 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r2 >= 22) goto L16;
        return false;
    L5:
        return r0.f271a;
    }

    private Location b() {
        Location r1 = null;
        if (androidx.core.content.d.a(this.f268b, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r0 = a("network");
    L7:
        if (androidx.core.content.d.a(this.f268b, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r1 = a("gps");
    L9:
        if (r1 == null) goto L15;
        if (r0 == null) goto L15;
        if (r1.getTime() > r0.getTime()) goto L14;
        return r0;
    L14:
        return r1;
    L15:
        if (r1 != null) goto L17;
        return r0;
    L17:
        return r1;
    L5:
        r0 = null;
        goto L7
    }

    private Location a(String r2) {
    L6:
        e = move-exception;
        a(TAG, "Failed to get last known location", e);
        return null;
    L3:
        if (this.f269c.isProviderEnabled(r2) == false) goto L12;
        return this.f269c.getLastKnownLocation(r2);
    L12:
        return null;
    }

    private boolean c() {
        if (this.f270d.f272b <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(Location r19) {
        a r0 = this.f270d;
        long r8 = System.currentTimeMillis();
        i r10 = i.a();
        r10.a(r8 - 86400000, r19.getLatitude(), r19.getLongitude());
        r10.a(r8, r19.getLatitude(), r19.getLongitude());
        boolean r2 = true;
        if (r10.f266c == 1) goto L6;
        r2 = false;
    L6:
        boolean r13 = r2;
        long r14 = r10.f265b;
        long r6 = r10.f264a;
        r10.a(r8 + 86400000, r19.getLatitude(), r19.getLongitude());
        long r1 = r10.f265b;
        if (r14 != (-1)) goto L9;
    L19:
        long r3 = 43200000 + r8;
    L20:
        r0.f271a = r13;
        r0.f272b = r3;
        return;
    L9:
        if (r6 == (-1)) goto L19;
        if (r8 <= r6) goto L15;
        long r4 = r1 + 0;
    L18:
        r3 = r4 + 60000;
        goto L20
    L15:
        if (r8 <= r14) goto L17;
        r4 = r6 + 0;
        goto L18
    L17:
        r4 = r14 + 0;
        goto L18
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
