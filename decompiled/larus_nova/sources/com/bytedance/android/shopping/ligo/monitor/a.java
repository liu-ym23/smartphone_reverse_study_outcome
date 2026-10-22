package com.bytedance.android.shopping.ligo.monitor;

import com.bytedance.android.ec.sdk.helper.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.ligo.monitor.a$a, reason: collision with other inner class name */
    public static final class C2612a {
        public static void a(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            g r102 = g.f48122a;
            JSONObject r103 = new JSONObject();
            if (r101 == null) goto L8;
            Iterator r104 = r101.entrySet().iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            Map.Entry r105 = (Map.Entry) r104.next();
            r103.put((String) r105.getKey(), r105.getValue());
        L8:
            Unit r106 = Unit.INSTANCE;
            r102.logV3(r100, r103);
        }
    }

    String a();

    void b(String r100, Map<String, String> r101);
}
