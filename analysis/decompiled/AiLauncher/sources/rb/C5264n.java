package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lrb/q;", "sb", "Lqb/a;", "json", "Lrb/j;", Const.INTENT_KEY_APIKEY, "(Lrb/q;Lqb/a;)Lrb/j;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5264n {
    public static final C5260j a(InterfaceC5267q sb2, AbstractC5171a json) {
        kotlin.jvm.internal.p.i(sb2, "sb");
        kotlin.jvm.internal.p.i(json, "json");
        return json.getConfiguration().getPrettyPrint() ? new C5263m(sb2, json) : new C5260j(sb2);
    }
}
