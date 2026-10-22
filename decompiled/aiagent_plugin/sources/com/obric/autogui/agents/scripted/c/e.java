package com.obric.autogui.agents.scripted.c;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: ScriptResourceUpdateConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<String, Long, Long> f26927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m<String, Integer, Integer> f26928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Boolean> f26929d;

    /* JADX INFO: compiled from: ScriptResourceUpdateConfig.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26926a = new a(null);
    }

    public e(m<? super String, ? super Long, Long> r3, m<? super String, ? super Integer, Integer> r4, d.h.a.a<Boolean> r5) {
        m<String, Long, Long> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        m<String, Integer, Integer> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d.h.a.a<Boolean> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "readLong");
        o.e(r7, "readInt");
        o.e(r8, "isDebugVersion");
        this.f26927b = r6;
        this.f26928c = r7;
        this.f26929d = r8;
    }

    public final d a() {
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f26929d.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Long r4 = Long.valueOf(DownloadConstants.HOUR);
        if (r1 == false) goto L5;
        long r5 = 1;
    L7:
        if (r1 == false) goto L9;
        long r9 = 300000;
    L11:
        return new d(r5, r9, n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26927b.invoke("js.script.resource.update.wifi_settle_delay_ms", 2000L), Number.class, "com.obric.aiagent.plugin")).longValue(), 0, 60000), n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26927b.invoke("js.script.resource.update.periodic_interval_ms", r4), Number.class, "com.obric.aiagent.plugin")).longValue(), 300000, 86400000), n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26927b.invoke("js.script.resource.update.round_timeout_ms", 300000L), Number.class, "com.obric.aiagent.plugin")).longValue(), 60000, 1800000), n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26928c.invoke("js.script.resource.update.download_retry_count", 2), Number.class, "com.obric.aiagent.plugin")).intValue(), 0, 5));
    L9:
        r9 = n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26927b.invoke("js.script.resource.update.attempt_floor_ms", 300000L), Number.class, "com.obric.aiagent.plugin")).longValue(), 60000, 21600000);
        goto L11
    L5:
        r5 = n.a(((Number) ZeusTransformUtils.preCheckCast(this.f26927b.invoke("js.script.resource.update.success_cooldown_ms", r4), Number.class, "com.obric.aiagent.plugin")).longValue(), 300000, 86400000);
        goto L7
    }
}
