package com.stepos.agentframework.chatcore;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentcache.sdk.api.LogMessage;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/chatcore/a;", "", "<init>", "()V", "", DidiCardProvider.KEY_TRACE_ID, "nodeName", "", "data", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/stepos/agentcache/sdk/api/LogMessage;", "message", "", "statusCode", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentcache/sdk/api/LogMessage;I)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1846a {
    public static /* synthetic */ void c(C1846a c1846a, String str, String str2, LogMessage logMessage, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = 200;
        }
        c1846a.b(str, str2, logMessage, i10);
    }

    public final void a(String traceId, String nodeName, Map<String, ? extends Object> data) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(nodeName, "nodeName");
        kotlin.jvm.internal.p.i(data, "data");
        Map mapB = C1847b.b(data.get("biz_data"));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : data.entrySet()) {
            if (!kotlin.jvm.internal.p.d(entry.getKey(), "biz_data")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Log.i("ChatReporter", "report data: " + traceId + ", " + nodeName + ", msgType=" + linkedHashMap.get("msg_type") + ", bizData=" + mapB);
        AgentCacheSdk.reportEvent$default(AgentCacheSdk.INSTANCE, traceId, nodeName, linkedHashMap, mapB, null, null, 0, 112, null);
    }

    public final void b(String traceId, String nodeName, LogMessage message, int statusCode) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(nodeName, "nodeName");
        kotlin.jvm.internal.p.i(message, "message");
        Log.i("ChatReporter", "reportLog: " + traceId + ", " + nodeName + ", " + statusCode);
        AgentCacheSdk.INSTANCE.reportLog(traceId, nodeName, message, statusCode);
    }
}
