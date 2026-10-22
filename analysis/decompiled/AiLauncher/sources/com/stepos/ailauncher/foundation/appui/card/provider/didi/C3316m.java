package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/m;", "", "<init>", "()V", "", "vendor", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "reason", "c", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "", "e", "()Z", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "f", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/Long;", "TTL_MS", "J", "", "armed", "Ljava/util/Map;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3316m {
    public static final C3316m INSTANCE = new C3316m();
    private static final long TTL_MS = TimeUnit.MINUTES.toMillis(10);
    private static final Map<String, Long> armed = new LinkedHashMap();

    public final synchronized void a(String vendor) {
        String strH = h(vendor);
        armed.put(strH, Long.valueOf(SystemClock.elapsedRealtime()));
        R5.b.INSTANCE.c("didi.authResume.arm", Y8.j.a("vendor", strH));
    }

    public final synchronized String b() {
        Object next;
        try {
            List listM1 = Z8.F.m1(armed.keySet());
            ArrayList arrayList = new ArrayList();
            for (Object obj : listM1) {
                if (INSTANCE.g((String) obj) != null) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    Long l10 = armed.get((String) next);
                    long jLongValue = l10 != null ? l10.longValue() : Long.MAX_VALUE;
                    do {
                        Object next2 = it.next();
                        Long l11 = armed.get((String) next2);
                        long jLongValue2 = l11 != null ? l11.longValue() : Long.MAX_VALUE;
                        if (jLongValue > jLongValue2) {
                            next = next2;
                            jLongValue = jLongValue2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            String str = (String) next;
            if (str == null) {
                return null;
            }
            armed.remove(str);
            String strF = f(str);
            R5.b.INSTANCE.c("didi.authResume.consume", Y8.j.a("vendor", str));
            return strF;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(String vendor, String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        String strH = h(vendor);
        if (armed.remove(strH) == null) {
            return;
        }
        R5.b.INSTANCE.c("didi.authResume.disarm", Y8.j.a("vendor", strH), Y8.j.a("reason", reason));
    }

    public final synchronized void d(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        Map<String, Long> map = armed;
        if (map.isEmpty()) {
            return;
        }
        String strA0 = Z8.F.A0(map.keySet(), Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
        map.clear();
        R5.b.INSTANCE.c("didi.authResume.disarmAll", Y8.j.a("vendors", strA0), Y8.j.a("reason", reason));
    }

    public final synchronized boolean e() {
        boolean z10;
        try {
            List listM1 = Z8.F.m1(armed.keySet());
            z10 = false;
            if (!(listM1 instanceof Collection) || !listM1.isEmpty()) {
                Iterator it = listM1.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (INSTANCE.g((String) it.next()) != null) {
                        z10 = true;
                        break;
                    }
                }
            }
        } finally {
        }
        return z10;
    }

    public final String f(String vendor) {
        return "使用" + q0.INSTANCE.a(vendor) + "授权";
    }

    public final Long g(String vendor) {
        Map<String, Long> map = armed;
        Long l10 = map.get(vendor);
        if (l10 == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - l10.longValue();
        if (jElapsedRealtime <= TTL_MS) {
            return l10;
        }
        map.remove(vendor);
        R5.b.INSTANCE.c("didi.authResume.expired", Y8.j.a("vendor", vendor), Y8.j.a("ageMs", Long.valueOf(jElapsedRealtime)));
        return null;
    }

    public final String h(String vendor) {
        String string;
        if (vendor == null || (string = La.H.D1(vendor).toString()) == null) {
            return q0.DIDI;
        }
        if (string.length() <= 0) {
            string = null;
        }
        return string == null ? q0.DIDI : string;
    }
}
