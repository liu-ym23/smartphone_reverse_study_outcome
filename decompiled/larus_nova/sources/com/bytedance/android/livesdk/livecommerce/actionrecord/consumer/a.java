package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a$a, reason: collision with other inner class name */
    public static final class C2293a {
        public static Map a(vg2.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            LinkedHashMap r101 = new LinkedHashMap();
            r101.put(EventConstant.Key.MODULE, r100.f554679d);
            r101.put("action", r100.f554680e);
            r101.put("action_uuid", r100.f554681f);
            return r101;
        }
    }

    String a();

    Set<EventType> b();

    boolean c(vg2.a r100);
}
