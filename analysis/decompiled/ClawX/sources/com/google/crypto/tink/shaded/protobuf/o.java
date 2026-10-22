package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile o f1503a;

    /* renamed from: b, reason: collision with root package name */
    public static final o f1504b;

    static {
        o oVar = new o();
        Map map = Collections.EMPTY_MAP;
        f1504b = oVar;
    }

    public static o a() {
        o oVar;
        o oVar2 = f1503a;
        if (oVar2 != null) {
            return oVar2;
        }
        synchronized (o.class) {
            try {
                oVar = f1503a;
                if (oVar == null) {
                    Class cls = n.f1496a;
                    o oVar3 = null;
                    if (cls != null) {
                        try {
                            oVar3 = (o) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    oVar = oVar3 != null ? oVar3 : f1504b;
                    f1503a = oVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }
}
