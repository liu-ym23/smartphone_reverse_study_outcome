package E5;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"LE5/b;", "", "<init>", "()V", "", DidiCardProvider.KEY_TRACE_ID, "event", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "NODE_NAME", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final String NODE_NAME = "user_chat";
    private static final String TAG = "TraceReporter";

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r14, java.lang.String r15, java.lang.String r16) {
        /*
            r13 = this;
            r2 = r15
            java.lang.String r13 = "traceId"
            kotlin.jvm.internal.p.i(r14, r13)
            java.lang.String r13 = "event"
            kotlin.jvm.internal.p.i(r15, r13)
            java.lang.String r13 = "log"
            r3 = r16
            kotlin.jvm.internal.p.i(r3, r13)
            int r13 = r14.length()
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r10 = "TraceReporter"
            if (r13 != 0) goto L34
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "skip report: empty traceId, event="
            r13.append(r0)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            h8.C4148a.u(r10, r13, r9, r8, r7)
            return
        L34:
            kotlin.Result$a r13 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5f
            com.stepos.agentcache.sdk.api.AgentCacheSdk r13 = com.stepos.agentcache.sdk.api.AgentCacheSdk.INSTANCE     // Catch: java.lang.Throwable -> L5f
            java.lang.String r11 = "user_chat"
            com.stepos.agentcache.sdk.api.LogMessage r0 = new com.stepos.agentcache.sdk.api.LogMessage     // Catch: java.lang.Throwable -> L5f
            com.stepos.agentcache.sdk.api.LogLevel r1 = com.stepos.agentcache.sdk.api.LogLevel.INFO     // Catch: java.lang.Throwable -> L5f
            r5 = 8
            r6 = 0
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L5f
            r12 = r2
            r5 = 8
            r6 = 0
            r4 = 0
            r1 = r14
            r3 = r0
            r2 = r11
            r0 = r13
            boolean r13 = com.stepos.agentcache.sdk.api.AgentCacheSdk.reportLog$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> L5c
            goto L6c
        L5c:
            r0 = move-exception
        L5d:
            r13 = r0
            goto L62
        L5f:
            r0 = move-exception
            r12 = r2
            goto L5d
        L62:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        L6c:
            java.lang.Throwable r13 = kotlin.Result.e(r13)
            if (r13 == 0) goto L8f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reportLog failed: event="
            r0.append(r1)
            r0.append(r15)
            java.lang.String r1 = ", err="
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            h8.C4148a.u(r10, r13, r9, r8, r7)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: E5.b.a(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
