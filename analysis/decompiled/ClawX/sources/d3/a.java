package d3;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.util.function.Predicate;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1792a;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1792a) {
            case 0:
                return !((g) obj).b();
            case 1:
                return !((g) obj).a();
            case 2:
                return !((g) obj).b();
            case 3:
                return !((g) obj).a();
            default:
                return ((InetSocketAddress) obj).getAddress() instanceof Inet4Address;
        }
    }
}
