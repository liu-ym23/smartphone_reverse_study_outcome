package yb;

import com.autonavi.aps.amapapi.config.Const;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Ljava/net/InetAddress;", "addresses", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6031l {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<InetAddress> a(List<? extends InetAddress> addresses) {
        kotlin.jvm.internal.p.i(addresses, "addresses");
        if (addresses.size() < 2) {
            return addresses;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : addresses) {
            if (((InetAddress) obj) instanceof Inet6Address) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.a();
        List list2 = (List) pair.b();
        return (list.isEmpty() || list2.isEmpty()) ? addresses : ub.n.t(list, list2);
    }
}
