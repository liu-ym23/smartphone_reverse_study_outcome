package R5;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJM\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012JU\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u000bJ\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"LR5/b;", "", "<init>", "()V", "", "stage", "", "Lkotlin/Pair;", "fields", "LY8/t;", "c", "(Ljava/lang/String;[Lkotlin/Pair;)V", "", "sensitive", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z[Lkotlin/Pair;)V", "dedupeKey", "e", "(Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Z[Lkotlin/Pair;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "key", "f", "(Ljava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "timers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "oncePrinted", "Ljava/util/Set;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final String TAG = "TripartiteCard";
    private static final Set<String> oncePrinted;
    public static final b INSTANCE = new b();
    private static final ConcurrentHashMap<String, Long> timers = new ConcurrentHashMap<>();

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet, "newKeySet(...)");
        oncePrinted = keySetViewNewKeySet;
    }

    public final String a(String stage, Pair<String, ? extends Object>[] fields) {
        String string;
        if (fields.length == 0) {
            return stage;
        }
        StringBuilder sb2 = new StringBuilder(stage);
        for (Pair<String, ? extends Object> pair : fields) {
            String strA = pair.a();
            Object objB = pair.b();
            sb2.append(" | ");
            sb2.append(strA);
            sb2.append('=');
            if (objB == null || (string = objB.toString()) == null) {
                string = "null";
            }
            sb2.append(string);
        }
        String string2 = sb2.toString();
        p.h(string2, "toString(...)");
        return string2;
    }

    public final void b(String stage, boolean sensitive, Pair<String, ? extends Object>... fields) {
        p.i(stage, "stage");
        p.i(fields, "fields");
        C4148a.j(TAG, a(stage, fields), sensitive);
    }

    public final void c(String stage, Pair<String, ? extends Object>... fields) {
        p.i(stage, "stage");
        p.i(fields, "fields");
        b(stage, false, (Pair[]) Arrays.copyOf(fields, fields.length));
    }

    public final void d(String dedupeKey, String stage, boolean sensitive, Pair<String, ? extends Object>... fields) {
        p.i(dedupeKey, "dedupeKey");
        p.i(stage, "stage");
        p.i(fields, "fields");
        if (oncePrinted.add(dedupeKey)) {
            C4148a.j(TAG, a(stage, fields), sensitive);
        }
    }

    public final void e(String dedupeKey, String stage, Pair<String, ? extends Object>... fields) {
        p.i(dedupeKey, "dedupeKey");
        p.i(stage, "stage");
        p.i(fields, "fields");
        d(dedupeKey, stage, false, (Pair[]) Arrays.copyOf(fields, fields.length));
    }

    public final void f(String key) {
        p.i(key, "key");
        timers.put(key, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final Long g(String key) {
        p.i(key, "key");
        Long lRemove = timers.remove(key);
        if (lRemove == null) {
            return null;
        }
        return Long.valueOf(SystemClock.elapsedRealtime() - lRemove.longValue());
    }

    public final void h(String stage, Pair<String, ? extends Object>... fields) {
        p.i(stage, "stage");
        p.i(fields, "fields");
        C4148a.u(TAG, a(stage, fields), false, 4, null);
    }
}
