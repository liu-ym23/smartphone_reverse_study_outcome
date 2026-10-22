package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Dns {
    public static final Dns SYSTEM = null;

    public static class a implements Dns {
        public a() {
        }

        @Override // okhttp3.Dns
        public List lookup(String r10) {
            if (r10 == null) goto L14;
            return Arrays.asList(InetAddress.getAllByName(r10));
        L7:
            e = move-exception;
            UnknownHostException r11 = new UnknownHostException("Broken system behaviour for dns lookup of " + r10);
            r11.initCause(e);
            throw r11;
        L5:
            e = move-exception;
            throw new UnknownHostException(e.getMessage());
        L14:
            throw new UnknownHostException("hostname == null");
        }
    }

    static {
        SYSTEM = new a();
    }

    List<InetAddress> lookup(String r10) throws UnknownHostException;
}
