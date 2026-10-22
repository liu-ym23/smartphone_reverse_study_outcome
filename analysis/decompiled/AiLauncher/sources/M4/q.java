package M4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.recipient.StepOSEmailRecipientAdapter;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"LM4/q;", "", "Lkotlin/Function2;", "", "", StepOSEmailRecipientAdapter.LOOKUP_KEY, "<init>", "(Lp9/p;)V", "type", "name", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)I", "Lp9/p;", "Ljava/util/concurrent/ConcurrentHashMap;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ConcurrentHashMap;", "idCache", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p9.p<String, String, Integer> lookup;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<String, Integer> idCache;

    /* JADX WARN: Multi-variable type inference failed */
    public q(p9.p<? super String, ? super String, Integer> lookup) {
        kotlin.jvm.internal.p.i(lookup, "lookup");
        this.lookup = lookup;
        this.idCache = new ConcurrentHashMap<>();
    }

    public final int a(String type, String name) {
        kotlin.jvm.internal.p.i(type, "type");
        if (name == null || name.length() == 0) {
            return 0;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.idCache;
        String str = type + "|" + name;
        Integer num = concurrentHashMap.get(str);
        if (num == null) {
            Integer numInvoke = this.lookup.invoke(type, name);
            Integer numPutIfAbsent = concurrentHashMap.putIfAbsent(str, numInvoke);
            num = numPutIfAbsent == null ? numInvoke : numPutIfAbsent;
        }
        kotlin.jvm.internal.p.h(num, "getOrPut(...)");
        return num.intValue();
    }
}
