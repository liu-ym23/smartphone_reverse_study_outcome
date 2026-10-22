package com.obric.autogui.agents.scripted.b;

import android.os.Debug;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ScriptMemorySnapshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "Script-MemorySnapshot";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<Map<String, String>> f26913b;

    /* JADX INFO: compiled from: ScriptMemorySnapshot.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26912a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Map lambda$W6rMLKH6nRtH2fVMBuvEfeeIhCE() {
        return b();
    }

    public e(d.h.a.a<? extends Map<String, String>> r3) {
        d.h.a.a<Map<String, String>> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "memoryStatsProvider");
        this.f26913b = r4;
    }

    public /* synthetic */ e(d.h.a.a r2, int r3, h r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$e$W6rMLKH6nRtH2fVMBuvEfeeIhCE.INSTANCE;
    L5:
        this(r5);
    }

    private static final Map b() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.getMemoryStats();
    }

    public final d a() {
        d r2 = d.f26907a.a((Map) ZeusTransformUtils.preCheckCast(this.f26913b.invoke(), Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L7
        if (r2 != null) goto L12;
        a(this, "Invalid process memory snapshot", null, 2, null);     // Catch: Exception -> L7
    L12:
        return r2;
    L7:
        e = move-exception;
        a("Failed to capture process memory snapshot", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    static /* synthetic */ void a(e r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    private final void a(String r2, Throwable r3) {
        f.f26914a.a(TAG, r2, r3);
    }
}
