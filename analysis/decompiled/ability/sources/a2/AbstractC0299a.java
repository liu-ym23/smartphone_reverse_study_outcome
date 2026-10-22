package a2;

import android.content.Context;
import ca.AbstractC0897f;
import java.util.concurrent.ConcurrentHashMap;
import u1.d;

/* renamed from: a2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0299a implements InterfaceC0300b {
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public String f1636a;

    public static boolean b(d dVar) {
        String str = (String) dVar.d;
        ConcurrentHashMap concurrentHashMap = b;
        if (!concurrentHashMap.containsKey(str)) {
            concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            return true;
        }
        if (System.currentTimeMillis() - ((Long) concurrentHashMap.get(str)).longValue() < 10000) {
            return false;
        }
        concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public abstract String a();

    public final boolean c(d dVar) {
        R1.b bVarB = R1.b.b(this.f1636a);
        if (bVarB.f1141a.get((String) dVar.d) != Boolean.TRUE || AbstractC0897f.j((Context) R1.b.b(this.f1636a).c.c)) {
            return true;
        }
        S0.b.v(0, this.f1636a, (String) dVar.d, "产物超过阈值，等待WiFi环境执行");
        return false;
    }

    public abstract boolean d(d dVar);
}
