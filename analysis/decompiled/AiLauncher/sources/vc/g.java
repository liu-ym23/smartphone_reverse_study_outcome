package vc;

import org.slf4j.Marker;
import org.slf4j.helpers.Reporter;
import xc.h;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static b f42882a;

    static {
        h hVarN = e.n();
        if (hVarN != null) {
            f42882a = hVarN.c();
            return;
        }
        Reporter.b("Failed to find provider");
        Reporter.b("Defaulting to BasicMarkerFactory.");
        f42882a = new org.slf4j.helpers.b();
    }

    public static Marker a(String str) {
        return f42882a.a(str);
    }
}
