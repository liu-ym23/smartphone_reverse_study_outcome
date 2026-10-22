package d8;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.channels.DatagramChannel;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l2 extends b2 {

    /* renamed from: q, reason: collision with root package name */
    public static final z7.b f2067q = z7.d.b(l2.class);

    /* renamed from: l, reason: collision with root package name */
    public final int f2068l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2069m;

    /* renamed from: n, reason: collision with root package name */
    public final SecureRandom f2070n;

    /* renamed from: o, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2071o = new ConcurrentLinkedQueue();

    /* renamed from: p, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2072p = new ConcurrentLinkedQueue();

    public l2() {
        int i8;
        int i9;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            i8 = 32768;
            i9 = 60999;
        } else {
            i8 = 49152;
            i9 = Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
        }
        int iIntValue = Integer.getInteger("dnsjava.udp.ephemeral.start", i8).intValue();
        this.f2068l = iIntValue;
        this.f2069m = Integer.getInteger("dnsjava.udp.ephemeral.end", i9).intValue() - iIntValue;
        if (Boolean.getBoolean("dnsjava.udp.ephemeral.use_ephemeral_port")) {
            this.f2070n = null;
        } else {
            this.f2070n = new SecureRandom();
        }
        b2.f1955e = new a0(2, this);
        final int i10 = 0;
        b2.f1954c[1] = new Runnable(this) { // from class: d8.j2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l2 f2036b;

            {
                this.f2036b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case 0:
                        Iterator it = this.f2036b.f2072p.iterator();
                        while (it.hasNext()) {
                            k2 k2Var = (k2) it.next();
                            if (k2Var.d - System.nanoTime() < 0) {
                                k2Var.b(new SocketTimeoutException("Query timed out"));
                                it.remove();
                            }
                        }
                        break;
                    default:
                        l2 l2Var = this.f2036b;
                        l2Var.f2071o.clear();
                        EOFException eOFException = new EOFException("Client is closing");
                        ConcurrentLinkedQueue concurrentLinkedQueue = l2Var.f2072p;
                        concurrentLinkedQueue.forEach(new a0(3, eOFException));
                        concurrentLinkedQueue.clear();
                        break;
                }
            }
        };
        final int i11 = 1;
        b2.f1956f[1] = new Runnable(this) { // from class: d8.j2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l2 f2036b;

            {
                this.f2036b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i11) {
                    case 0:
                        Iterator it = this.f2036b.f2072p.iterator();
                        while (it.hasNext()) {
                            k2 k2Var = (k2) it.next();
                            if (k2Var.d - System.nanoTime() < 0) {
                                k2Var.b(new SocketTimeoutException("Query timed out"));
                                it.remove();
                            }
                        }
                        break;
                    default:
                        l2 l2Var = this.f2036b;
                        l2Var.f2071o.clear();
                        EOFException eOFException = new EOFException("Client is closing");
                        ConcurrentLinkedQueue concurrentLinkedQueue = l2Var.f2072p;
                        concurrentLinkedQueue.forEach(new a0(3, eOFException));
                        concurrentLinkedQueue.clear();
                        break;
                }
            }
        };
    }

    public static void d(DatagramChannel datagramChannel) throws IOException {
        if (datagramChannel != null) {
            try {
                datagramChannel.close();
            } catch (IOException unused) {
            }
        }
    }
}
