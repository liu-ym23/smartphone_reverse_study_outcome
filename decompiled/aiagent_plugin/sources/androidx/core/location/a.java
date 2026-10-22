package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;

/* JADX INFO: compiled from: GnssStatusCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.core.location.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GnssStatusCompat.java */
    public static abstract class AbstractC0030a {
        public void a() {
        }

        public void a(int r1) {
        }

        public void a(a r1) {
        }

        public void b() {
        }
    }

    public static a a(GnssStatus r1) {
        return new b(r1);
    }

    public static a a(GpsStatus r1) {
        return new c(r1);
    }

    a() {
    }
}
