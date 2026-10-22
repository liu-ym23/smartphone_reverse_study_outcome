package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static m f390d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f393c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f395b;

        public a() {
        }
    }

    public m(Context r10, LocationManager r11) {
        this.f393c = new a();
        this.f391a = r10;
        this.f392b = r11;
    }

    public static m a(Context r10) {
        if (f390d != null) goto L6;
        Context r11 = r10.getApplicationContext();
        f390d = new m(r11, (LocationManager) r11.getSystemService("location"));
    L6:
        return f390d;
    }

    public final Location b() {
        Location r10 = null;
        if (PermissionChecker.b(this.f391a, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r11 = c("network");
    L7:
        if (PermissionChecker.b(this.f391a, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r10 = c("gps");
    L9:
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        if (r10.getTime() > r11.getTime()) goto L14;
        return r11;
    L14:
        return r10;
    L15:
        if (r10 != null) goto L17;
        return r11;
    L17:
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    public final Location c(String r10) {
    L6:
        e = move-exception;
        Log.d("TwilightManager", "Failed to get last known location", e);
        return null;
    L3:
        if (this.f392b.isProviderEnabled(r10) == false) goto L12;
        return this.f392b.getLastKnownLocation(r10);
    L12:
        return null;
    }

    public boolean d() {
        a r10 = this.f393c;
        if (e() == true) goto L5;
        Location r11 = b();
        if (r11 == null) goto L10;
        f(r11);
        return r10.f394a;
    L10:
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int r12 = Calendar.getInstance().get(11);
        if (r12 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r12 >= 22) goto L16;
        return false;
    L5:
        return r10.f394a;
    }

    public final boolean e() {
        if (this.f393c.f395b <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f(Location r19) {
        a r10 = this.f393c;
        long r11 = System.currentTimeMillis();
        l r12 = l.b();
        r12.a(r11 - 86400000, r19.getLatitude(), r19.getLongitude());
        r12.a(r11, r19.getLatitude(), r19.getLongitude());
        boolean r13 = true;
        if (r12.f389c != 1) goto L5;
    L4:
        boolean r14 = r13;
        long r15 = r12.f388b;
        long r16 = r12.f387a;
        r12.a(r11 + 86400000, r19.getLatitude(), r19.getLongitude());
        long r17 = r12.f388b;
        if (r15 != (-1)) goto L9;
    L18:
        long r18 = r11 + 43200000;
    L19:
        r10.f394a = r14;
        r10.f395b = r18;
        return;
    L9:
        if (r16 == (-1)) goto L18;
        if (r11 <= r16) goto L15;
        r15 = r17;
    L17:
        r18 = r15 + 60000;
        goto L19
    L15:
        if (r11 <= r15) goto L17;
        r15 = r16;
        goto L17
    L5:
        r13 = false;
        goto L4
    }
}
