package da;

import android.util.Log;
import com.stepos.core.common.util.TraceIdKeys;
import com.tonyodev.fetch2core.server.FileResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String type, String str, String str2, String str3, Long l10, Map map, int i10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l11 = (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : l10;
        g.f(type, "type");
        List<Pair> ordered = m.b0(new Pair(FileResponse.FIELD_TYPE, type), new Pair("node", str), new Pair("trace_id", str2), new Pair("session_id", ""), new Pair("event_time", Long.valueOf(jCurrentTimeMillis)), new Pair(FileResponse.FIELD_STATUS, str3), new Pair("duration_ms", l11));
        g.f(ordered, "ordered");
        StringBuilder sb2 = new StringBuilder(TraceIdKeys.MAX_LENGTH);
        sb2.append('{');
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f10073a = true;
        for (Pair pair : ordered) {
            c.c(ref$BooleanRef, sb2, (String) pair.f9985a, pair.f9986b);
        }
        for (Map.Entry entry : map.entrySet()) {
            c.c(ref$BooleanRef, sb2, (String) entry.getKey(), entry.getValue());
        }
        sb2.append('}');
        String string = sb2.toString();
        g.e(string, "toString(...)");
        Log.i("clawbench", string);
        ExecutorService executorService = e.f8418a;
    }
}
