package com.stepos.agentframework.adapter.agentbus;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/v;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "SECURE_KEY", "", x5.d.EXTRA_ENABLED, "Z", Const.INTENT_KEY_APIKEY, "()Z", "setEnabled", "(Z)V", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class v {
    public static final v INSTANCE = new v();
    private static final String SECURE_KEY = "agentbus_verbose_log";
    private static final String TAG = "AgentBusVerboseLog";
    private static volatile boolean enabled;

    public final boolean a() {
        return enabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r7 = "AgentBusVerboseLog"
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r8, r0)
            r0 = 4
            r1 = 0
            r2 = 0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L22
            java.lang.String r3 = "agentbus_verbose_log"
            java.lang.String r8 = android.provider.Settings.Secure.getString(r8, r3)     // Catch: java.lang.Throwable -> L22
            if (r8 == 0) goto L24
            java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L22
            java.lang.String r8 = r8.toLowerCase(r3)     // Catch: java.lang.Throwable -> L22
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r8, r3)     // Catch: java.lang.Throwable -> L22
            goto L25
        L22:
            r8 = move-exception
            goto L68
        L24:
            r8 = r2
        L25:
            if (r8 == 0) goto L80
            int r3 = r8.hashCode()     // Catch: java.lang.Throwable -> L22
            r4 = 48
            if (r3 == r4) goto L5c
            r4 = 49
            if (r3 == r4) goto L50
            r4 = 3569038(0x36758e, float:5.001287E-39)
            if (r3 == r4) goto L47
            r4 = 97196323(0x5cb1923, float:1.9099262E-35)
            if (r3 == r4) goto L3e
            goto L80
        L3e:
            java.lang.String r3 = "false"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Throwable -> L22
            if (r8 != 0) goto L65
            goto L80
        L47:
            java.lang.String r3 = "true"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Throwable -> L22
            if (r8 != 0) goto L59
            goto L80
        L50:
            java.lang.String r3 = "1"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Throwable -> L22
            if (r8 != 0) goto L59
            goto L80
        L59:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L22
            goto L81
        L5c:
            java.lang.String r3 = "0"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Throwable -> L22
            if (r8 != 0) goto L65
            goto L80
        L65:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L22
            goto L81
        L68:
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "read agentbus_verbose_log failed, fall back to build default: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            h8.C4148a.u(r7, r8, r1, r0, r2)
        L80:
            r8 = r2
        L81:
            boolean r3 = h8.C4148a.l()
            if (r3 != 0) goto L93
            r3 = 1
            if (r8 == 0) goto L8f
            boolean r4 = r8.booleanValue()
            goto L90
        L8f:
            r4 = r3
        L90:
            if (r4 == 0) goto L93
            goto L94
        L93:
            r3 = r1
        L94:
            com.stepos.agentframework.adapter.agentbus.v.enabled = r3
            boolean r3 = com.stepos.agentframework.adapter.agentbus.v.enabled
            boolean r4 = h8.C4148a.l()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "verbose log enabled="
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = " (secure key=agentbus_verbose_log, explicit="
            r5.append(r3)
            r5.append(r8)
            java.lang.String r8 = ", release="
            r5.append(r8)
            r5.append(r4)
            java.lang.String r8 = ")"
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            h8.C4148a.k(r7, r8, r1, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.v.b(android.content.Context):void");
    }
}
