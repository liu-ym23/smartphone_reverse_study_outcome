package f2;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;

/* renamed from: f2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0697b {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f16780a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static long f16781b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static long f16782c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static long f16783d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static long f16784e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f16785f = false;

    private static void a() {
        synchronized (f16780a) {
            b();
        }
    }

    private static void b() {
        f16784e = -1L;
        f16783d = -1L;
        SharedPreferences sharedPreferencesK = k();
        if (sharedPreferencesK != null) {
            sharedPreferencesK.edit().remove("last_jump_wall_ms").remove("last_jump_elapsed_ms").remove("last_jump_wall_delta_ms").apply();
        }
    }

    public static boolean c() {
        synchronized (f16780a) {
            try {
                if (!f16785f) {
                    return false;
                }
                f16785f = false;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int d(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        int i5 = 0;
        for (long j5 : jArr) {
            if (j5 >= 3000000) {
                i5++;
            }
        }
        return i5;
    }

    public static long e() {
        synchronized (f16780a) {
            try {
                w();
                long jH = f16783d;
                if (jH < 0) {
                    jH = h();
                }
                if (jH <= 0) {
                    return Long.MAX_VALUE;
                }
                return Math.max(0L, SystemClock.elapsedRealtime() - jH);
            } finally {
            }
        }
    }

    private static void f() {
        long j5 = f16784e;
        if (j5 < 0) {
            j5 = j();
        }
        if (j5 > 0 && C0711p.k(j5) < C0711p.y()) {
            R1.a.l("ClockJumpDetector", "expire clock-jump sanitize after calendar day roll jumpWall=" + C0711p.j(j5));
            b();
        }
    }

    public static long g() {
        synchronized (f16780a) {
            try {
                w();
                long j5 = f16784e;
                if (j5 > 0) {
                    return j5;
                }
                return Math.max(0L, j());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long h() {
        SharedPreferences sharedPreferencesK = k();
        return sharedPreferencesK == null ? f16783d : sharedPreferencesK.getLong("last_jump_elapsed_ms", 0L);
    }

    private static long i() {
        SharedPreferences sharedPreferencesK = k();
        if (sharedPreferencesK == null) {
            return 0L;
        }
        return sharedPreferencesK.getLong("last_jump_wall_delta_ms", 0L);
    }

    private static long j() {
        SharedPreferences sharedPreferencesK = k();
        return sharedPreferencesK == null ? f16784e : sharedPreferencesK.getLong("last_jump_wall_ms", 0L);
    }

    private static SharedPreferences k() {
        Application applicationA = P1.a.a();
        if (applicationA == null) {
            return null;
        }
        return applicationA.getSharedPreferences("digital_wellbeing_clock_jump", 0);
    }

    public static boolean l() {
        long j5 = j();
        return j5 > 0 && C0711p.k(j5) == C0711p.y();
    }

    public static boolean m(long j5, long j6, long j7) {
        if (j5 > 0 && n()) {
            if (j6 > 0 && j5 <= j6 + 3600000) {
                return false;
            }
            long jMax = Math.max(0L, Math.min(System.currentTimeMillis(), 86400000 + j7) - j7);
            if (jMax < 60000 || Math.abs(j5 - jMax) > 120000) {
                return false;
            }
            long jE = e();
            if (jE == Long.MAX_VALUE) {
                return false;
            }
            z = j5 > 120000 + jE;
            if (z) {
                R1.a.l("ClockJumpDetector", "phantom since-midnight usage daily=" + C0711p.t(j5) + " sinceMidnight=" + C0711p.t(jMax) + " sinceJump=" + C0711p.t(jE) + " dayStart=" + C0711p.j(j7));
            }
        }
        return z;
    }

    public static boolean n() {
        synchronized (f16780a) {
            try {
                w();
                f();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long jH = h();
                boolean z5 = false;
                if (jH <= 120000 + jElapsedRealtime) {
                    long j5 = f16783d;
                    if (j5 >= 0 && jElapsedRealtime - j5 <= 86400000) {
                        return true;
                    }
                    if (jH > 0 && jElapsedRealtime - jH <= 86400000) {
                        z5 = true;
                    }
                    return z5;
                }
                long j6 = j();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (j6 <= 0 || jCurrentTimeMillis < j6 || jCurrentTimeMillis - j6 > 86400000) {
                    b();
                    return false;
                }
                long jI = i();
                f16784e = j6;
                f16783d = jElapsedRealtime;
                v(j6, jElapsedRealtime, jI);
                R1.a.l("ClockJumpDetector", "rebase clock-jump sanitize after reboot jumpWall=" + C0711p.j(j6));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean o(long j5, long j6) {
        return j5 > 0 && j6 > 0 && Math.abs(j5 - j6) <= 120000;
    }

    public static boolean p() {
        SharedPreferences sharedPreferencesK;
        return n() && (sharedPreferencesK = k()) != null && sharedPreferencesK.getLong("last_jump_wall_delta_ms", 0L) < -120000;
    }

    public static boolean q() {
        synchronized (f16780a) {
            try {
                if (f16783d < 0) {
                    return false;
                }
                return SystemClock.elapsedRealtime() - f16783d <= 1800000;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean r() {
        SharedPreferences sharedPreferencesK;
        return n() && (sharedPreferencesK = k()) != null && sharedPreferencesK.getLong("last_jump_wall_delta_ms", 0L) > 120000;
    }

    public static boolean s(long[] jArr) {
        return d(jArr) >= 6;
    }

    private static void t(long j5, long j6, long j7, long j8) {
        f16784e = j5;
        f16783d = j6;
        f16785f = true;
        v(j5, j6, j8);
        R1.a.l("ClockJumpDetector", "mark clock jump wall=" + C0711p.j(j5) + " skew=" + C0711p.t(j7) + " wallDelta=" + C0711p.t(j8));
    }

    public static boolean u(String str) {
        boolean z5;
        synchronized (f16780a) {
            try {
                w();
                f();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j5 = f16782c;
                z5 = false;
                if (j5 >= 0) {
                    long j6 = jCurrentTimeMillis - f16781b;
                    long j7 = jElapsedRealtime - j5;
                    long jAbs = Math.abs(j6 - j7);
                    if (jAbs > 120000) {
                        t(jCurrentTimeMillis, jElapsedRealtime, jAbs, j6);
                        R1.a.l("ClockJumpDetector", "clock jump on " + str + " skew=" + C0711p.t(jAbs) + " wallDelta=" + C0711p.t(j6) + " elapsedDelta=" + C0711p.t(j7));
                        z5 = true;
                    } else {
                        long j8 = f16781b;
                        if (j8 > 0 && C0711p.k(j8) != C0711p.k(jCurrentTimeMillis) && o(j6, j7)) {
                            b();
                            R1.a.l("ClockJumpDetector", "natural midnight rollover on " + str);
                        }
                    }
                } else {
                    R1.a.l("ClockJumpDetector", "time broadcast " + str + " no baseline, init only");
                }
                f16781b = jCurrentTimeMillis;
                f16782c = jElapsedRealtime;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z5;
    }

    private static void v(long j5, long j6, long j7) {
        SharedPreferences sharedPreferencesK = k();
        if (sharedPreferencesK == null) {
            return;
        }
        sharedPreferencesK.edit().putLong("last_jump_wall_ms", j5).putLong("last_jump_elapsed_ms", j6).putLong("last_jump_wall_delta_ms", j7).apply();
    }

    private static void w() {
        if (f16783d >= 0) {
            return;
        }
        long jH = h();
        long j5 = j();
        if (jH <= 0 || j5 <= 0) {
            return;
        }
        f16783d = jH;
        f16784e = j5;
    }

    public static boolean x(long j5) {
        if (j5 <= 0) {
            return false;
        }
        if (j5 > System.currentTimeMillis()) {
            return true;
        }
        long jY = C0711p.y();
        if (j5 <= jY) {
            return false;
        }
        if (n()) {
            R1.a.l("ClockJumpDetector", "ignore truncate clearTime after clock jump clear=" + C0711p.j(j5) + " todayStart=" + C0711p.j(jY));
            return true;
        }
        long j6 = j();
        if (j6 > 0) {
            if (C0711p.k(j6) < jY) {
                a();
                return false;
            }
            if (j5 >= j6 - 300000) {
                R1.a.l("ClockJumpDetector", "ignore clearTime stamped during clock jump clear=" + C0711p.j(j5) + " jumpWall=" + C0711p.j(j6));
                return true;
            }
        }
        if (!q()) {
            return false;
        }
        R1.a.l("ClockJumpDetector", "ignore clearTime within jump effect window clear=" + C0711p.j(j5));
        return true;
    }

    public static boolean y() {
        return n();
    }

    public static void z() {
        synchronized (f16780a) {
            try {
                w();
                f();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j5 = f16782c;
                if (j5 < 0) {
                    f16781b = jCurrentTimeMillis;
                    f16782c = jElapsedRealtime;
                    return;
                }
                long j6 = jCurrentTimeMillis - f16781b;
                long jAbs = Math.abs(j6 - (jElapsedRealtime - j5));
                if (jAbs > 120000) {
                    t(jCurrentTimeMillis, jElapsedRealtime, jAbs, j6);
                }
                f16781b = jCurrentTimeMillis;
                f16782c = jElapsedRealtime;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
