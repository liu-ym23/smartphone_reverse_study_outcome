package com.obric.autogui.agents.vlm.models.omni;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: OmniSessionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f28523a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f28524b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedHashMap<String, r> f28525c = null;

    private t() {
    }

    static {
        f28523a = new t();
        f28524b = new Object();
        f28525c = new LinkedHashMap(16, 0.75f, true);
    }

    public static /* synthetic */ r a(t r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final r a(String r5, String r6) {
        d.h.b.o.e(r5, ObricMemoryConstants.KEY_SESSION_ID);
        Object r4 = f28524b;
        monitor-enter(r4);
        LinkedHashMap<String, r> r0 = f28525c;     // Catch: Throwable -> L10
        r r1 = (r) ZeusTransformUtils.preCheckCast(r0.get(r5), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = new r(r5, r6);     // Catch: Throwable -> L10
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(r5, r1);     // Catch: Throwable -> L10
        com.obric.autogui.agents.vlm.models.omni.upload.e.f28643a.c(r5);     // Catch: Throwable -> L10
        com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.a(r5);     // Catch: Throwable -> L10
    L7:
        f28523a.a();     // Catch: Throwable -> L10
        monitor-exit(r4);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public final r a(String r3) {
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        Object r2 = f28524b;
        monitor-enter(r2);
        r r4 = (r) ZeusTransformUtils.preCheckCast(f28525c.get(r3), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r2);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private final void a() {
        LinkedHashMap<String, r> r4 = f28525c;
        if (r4.size() > 5) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, r>> r5 = r4.entrySet().iterator();
    L7:
        if (f28525c.size() <= 5) goto L11;
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, r> r0 = r5.next();
        d.h.b.o.c(r0, "next(...)");
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin");
        r5.remove();
        ((r) ZeusTransformUtils.preCheckCast(r1.getValue(), r.class, "com.obric.aiagent.plugin")).m();
        goto L7
    L14:
        return;
    }
}
