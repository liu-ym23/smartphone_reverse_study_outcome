package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lqb/a;", "json", "", "source", "Lrb/L;", Const.INTENT_KEY_APIKEY, "(Lqb/a;Ljava/lang/String;)Lrb/L;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class M {
    public static final L a(AbstractC5171a json, String source) {
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(source, "source");
        return !json.getConfiguration().getAllowComments() ? new L(source) : new N(source);
    }
}
