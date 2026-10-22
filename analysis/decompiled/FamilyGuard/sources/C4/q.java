package C4;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public interface q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f942a = new q() { // from class: C4.p
        @Override // C4.q
        public final List a(String str) {
            return q.b(str);
        }
    };

    static /* synthetic */ List b(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(str));
        } catch (NullPointerException e6) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e6);
            throw unknownHostException;
        }
    }

    List<InetAddress> a(String str);
}
