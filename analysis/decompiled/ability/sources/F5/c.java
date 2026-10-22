package F5;

import H4.o;
import android.util.Log;
import com.stepos.ability.commoninternal.Key;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c {
    public static void a(String type, String str, String str2, String str3, Long l, Map map, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l5 = (i & 128) != 0 ? null : l;
        k.f(type, "type");
        List<Pair> ordered = o.N(new Pair("type", type), new Pair("node", str), new Pair(Key.KEY_TRACE_ID, str2), new Pair("session_id", str3), new Pair("event_time", Long.valueOf(jCurrentTimeMillis)), new Pair("status", "ok"), new Pair("duration_ms", l5));
        k.f(ordered, "ordered");
        StringBuilder sb = new StringBuilder(128);
        sb.append('{');
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f4916a = true;
        for (Pair pair : ordered) {
            o.L(ref$BooleanRef, sb, (String) pair.f4886a, pair.b);
        }
        for (Map.Entry entry : map.entrySet()) {
            o.L(ref$BooleanRef, sb, (String) entry.getKey(), entry.getValue());
        }
        sb.append('}');
        String string = sb.toString();
        k.e(string, "toString(...)");
        Log.i("clawbench", string);
        ExecutorService executorService = d.f551a;
    }
}
