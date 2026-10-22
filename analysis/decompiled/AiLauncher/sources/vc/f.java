package vc;

import java.util.Map;
import org.slf4j.helpers.Reporter;
import org.slf4j.helpers.j;
import xc.h;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static xc.f f42881a;

    public static void a() {
        if (d() == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        d().clear();
    }

    public static void b(h hVar) {
        if (hVar instanceof j) {
            Reporter.f("Temporary mdcAdapter given by SubstituteServiceProvider.");
            Reporter.f("This mdcAdapter will be replaced after backend initialization has completed.");
        }
    }

    public static Map<String, String> c() {
        if (d() != null) {
            return d().a();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static xc.f d() {
        if (f42881a == null) {
            f42881a = e();
        }
        return f42881a;
    }

    public static xc.f e() {
        h hVarN = e.n();
        if (hVarN != null) {
            xc.f fVarD = hVarN.d();
            b(hVarN);
            return fVarD;
        }
        Reporter.b("Failed to find provider.");
        Reporter.b("Defaulting to no-operation MDCAdapter implementation.");
        return new org.slf4j.helpers.e();
    }

    public static void f(Map<String, String> map) {
        if (d() == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        d().b(map);
    }

    public static void g(xc.f fVar) {
        if (fVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        f42881a = fVar;
    }
}
