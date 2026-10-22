package com.stepos.probe;

import android.util.Log;
import c7.j;
import com.stepos.agentcache.core.ServiceContract;
import d7.a0;
import d7.s;
import java.util.Map;
import kotlin.Metadata;
import q7.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/probe/ProbeLine;", "", "<init>", "()V", "", "type", "node", "module", ServiceContract.RequiredKeys.TRACE_ID, "sessionId", "", ServiceContract.RequiredKeys.EVENT_TIME, "status", "durationMs", "", "extras", "Lc7/r;", "emit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "TAG", "Ljava/lang/String;", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProbeLine {
    public static final ProbeLine INSTANCE = new ProbeLine();
    private static final String TAG = "clawbench";

    private ProbeLine() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emit$default(ProbeLine probeLine, String str, String str2, String str3, String str4, String str5, long j2, String str6, Long l6, Map map, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        if ((i2 & 16) != 0) {
            str5 = null;
        }
        if ((i2 & 32) != 0) {
            j2 = System.currentTimeMillis();
        }
        if ((i2 & 64) != 0) {
            str6 = null;
        }
        if ((i2 & 128) != 0) {
            l6 = null;
        }
        if ((i2 & 256) != 0) {
            map = a0.f2944f;
        }
        probeLine.emit(str, str2, str3, str4, str5, j2, str6, l6, map);
    }

    public final void emit(String type, String node, String module, String traceId, String sessionId, long eventTime, String status, Long durationMs, Map<String, ? extends Object> extras) {
        k.e(type, "type");
        k.e(node, "node");
        k.e(module, "module");
        k.e(extras, "extras");
        String strLine = ProbeJson.INSTANCE.line(s.u0(new j("type", type), new j("node", node), new j("trace_id", traceId), new j("session_id", sessionId), new j("event_time", Long.valueOf(eventTime)), new j("status", status), new j("duration_ms", durationMs)), extras);
        Log.i(TAG, strLine);
        ProbeStore.INSTANCE.append(module, strLine);
    }
}
