package com.bytedance.apm6;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: Apm6.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<com.bytedance.services.slardar.config.b> f5007a;

    public static Runnable a(Context r2) {
        final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return com.bytedance.apm6.hub.a.a(new AnonymousClass1(r3));
    }

    public static void a(com.bytedance.services.slardar.config.b r2) {
        com.bytedance.services.slardar.config.b r3 = (com.bytedance.services.slardar.config.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.services.slardar.config.b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (f5007a != null) goto L9;
        f5007a = new CopyOnWriteArrayList();
    L9:
        if (f5007a.contains(r3) == true) goto L12;
        f5007a.add(r3);
        return;
    }

    public static void b(com.bytedance.services.slardar.config.b r2) {
        com.bytedance.services.slardar.config.b r3 = (com.bytedance.services.slardar.config.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.services.slardar.config.b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        List<com.bytedance.services.slardar.config.b> r0 = f5007a;
        if (r0 == null) goto L9;
        r0.remove(r3);
        return;
    }

    public static void a(JSONObject r4) {
        List<com.bytedance.services.slardar.config.b> r0 = f5007a;
        if (r0 == null) goto L8;
        Iterator<com.bytedance.services.slardar.config.b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.services.slardar.config.b) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.services.slardar.config.b.class, "com.obric.aiagent.plugin")).a(r4);
        goto L6
    L10:
        return;
    }
}
