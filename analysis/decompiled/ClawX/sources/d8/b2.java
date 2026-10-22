package d8;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b2 {
    public static a0 d;

    /* renamed from: e, reason: collision with root package name */
    public static a0 f1955e;

    /* renamed from: g, reason: collision with root package name */
    public static Thread f1957g;

    /* renamed from: h, reason: collision with root package name */
    public static Thread f1958h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile Selector f1959i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f1960j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile boolean f1961k;

    /* renamed from: a, reason: collision with root package name */
    public static final z7.b f1952a = z7.d.b(b2.class);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1953b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final Runnable[] f1954c = new Runnable[2];

    /* renamed from: f, reason: collision with root package name */
    public static final Runnable[] f1956f = new Runnable[2];

    public static void a() {
        Iterator<SelectionKey> it = f1959i.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            ((a2) next.attachment()).a(next);
        }
    }

    public static Selector b() {
        if (f1959i == null) {
            synchronized (f1953b) {
                try {
                    if (f1959i == null) {
                        f1959i = Selector.open();
                        f1952a.o("Starting dnsjava NIO selector thread");
                        f1960j = true;
                        final int i8 = 0;
                        Thread thread = new Thread(new Runnable() { // from class: d8.z1
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, IOException {
                                switch (i8) {
                                    case 0:
                                        int iIntValue = Integer.getInteger("dnsjava.nio.selector_timeout", 1000).intValue();
                                        if (iIntValue <= 0 || iIntValue > 1000) {
                                            throw new IllegalArgumentException("Invalid selector_timeout, must be between 1 and 1000");
                                        }
                                        while (b2.f1960j) {
                                            try {
                                                if (b2.f1959i.select(iIntValue) == 0) {
                                                    Runnable[] runnableArr = b2.f1954c;
                                                    Runnable runnable = runnableArr[0];
                                                    if (runnable != null) {
                                                        runnable.run();
                                                    }
                                                    Runnable runnable2 = runnableArr[1];
                                                    if (runnable2 != null) {
                                                        runnable2.run();
                                                    }
                                                }
                                                if (b2.f1960j) {
                                                    a0 a0Var = b2.d;
                                                    if (a0Var != null) {
                                                        a0Var.accept(b2.f1959i);
                                                    }
                                                    a0 a0Var2 = b2.f1955e;
                                                    if (a0Var2 != null) {
                                                        a0Var2.accept(b2.f1959i);
                                                    }
                                                    b2.a();
                                                }
                                            } catch (IOException e9) {
                                                b2.f1952a.q(e9);
                                            } catch (ClosedSelectorException unused) {
                                            }
                                        }
                                        try {
                                            Runnable[] runnableArr2 = b2.f1956f;
                                            Runnable runnable3 = runnableArr2[0];
                                            if (runnable3 != null) {
                                                runnable3.run();
                                            }
                                            Runnable runnable4 = runnableArr2[1];
                                            if (runnable4 != null) {
                                                runnable4.run();
                                            }
                                        } catch (Exception e10) {
                                            b2.f1952a.n("Failed to execute shutdown task, ignoring and continuing close", e10);
                                        }
                                        Selector selector = b2.f1959i;
                                        Thread thread2 = b2.f1957g;
                                        Object obj = b2.f1953b;
                                        synchronized (obj) {
                                            b2.f1959i = null;
                                            b2.f1957g = null;
                                            b2.f1958h = null;
                                            b2.f1961k = true;
                                            obj.notifyAll();
                                        }
                                        if (selector != null) {
                                            try {
                                                selector.close();
                                            } catch (IOException e11) {
                                                b2.f1952a.n("Failed to properly close selector, ignoring and continuing close", e11);
                                            }
                                        }
                                        if (thread2 != null) {
                                            try {
                                                thread2.join();
                                            } catch (InterruptedException unused2) {
                                                Thread.currentThread().interrupt();
                                            }
                                        }
                                        b2.f1952a.o("dnsjava NIO selector thread stopped");
                                        return;
                                    default:
                                        b2.f1960j = false;
                                        Selector selector2 = b2.f1959i;
                                        if (selector2 != null) {
                                            b2.f1959i.wakeup();
                                        }
                                        if (selector2 == null) {
                                            return;
                                        }
                                        synchronized (b2.f1953b) {
                                            while (!b2.f1961k) {
                                                try {
                                                    try {
                                                        b2.f1953b.wait();
                                                    } finally {
                                                        b2.f1961k = false;
                                                    }
                                                } catch (InterruptedException unused3) {
                                                    Thread.currentThread().interrupt();
                                                }
                                            }
                                        }
                                        return;
                                }
                            }
                        });
                        f1957g = thread;
                        thread.setDaemon(true);
                        f1957g.setName("dnsjava NIO selector");
                        f1957g.start();
                        final int i9 = 1;
                        Thread thread2 = new Thread(new Runnable() { // from class: d8.z1
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, IOException {
                                switch (i9) {
                                    case 0:
                                        int iIntValue = Integer.getInteger("dnsjava.nio.selector_timeout", 1000).intValue();
                                        if (iIntValue <= 0 || iIntValue > 1000) {
                                            throw new IllegalArgumentException("Invalid selector_timeout, must be between 1 and 1000");
                                        }
                                        while (b2.f1960j) {
                                            try {
                                                if (b2.f1959i.select(iIntValue) == 0) {
                                                    Runnable[] runnableArr = b2.f1954c;
                                                    Runnable runnable = runnableArr[0];
                                                    if (runnable != null) {
                                                        runnable.run();
                                                    }
                                                    Runnable runnable2 = runnableArr[1];
                                                    if (runnable2 != null) {
                                                        runnable2.run();
                                                    }
                                                }
                                                if (b2.f1960j) {
                                                    a0 a0Var = b2.d;
                                                    if (a0Var != null) {
                                                        a0Var.accept(b2.f1959i);
                                                    }
                                                    a0 a0Var2 = b2.f1955e;
                                                    if (a0Var2 != null) {
                                                        a0Var2.accept(b2.f1959i);
                                                    }
                                                    b2.a();
                                                }
                                            } catch (IOException e9) {
                                                b2.f1952a.q(e9);
                                            } catch (ClosedSelectorException unused) {
                                            }
                                        }
                                        try {
                                            Runnable[] runnableArr2 = b2.f1956f;
                                            Runnable runnable3 = runnableArr2[0];
                                            if (runnable3 != null) {
                                                runnable3.run();
                                            }
                                            Runnable runnable4 = runnableArr2[1];
                                            if (runnable4 != null) {
                                                runnable4.run();
                                            }
                                        } catch (Exception e10) {
                                            b2.f1952a.n("Failed to execute shutdown task, ignoring and continuing close", e10);
                                        }
                                        Selector selector = b2.f1959i;
                                        Thread thread22 = b2.f1957g;
                                        Object obj = b2.f1953b;
                                        synchronized (obj) {
                                            b2.f1959i = null;
                                            b2.f1957g = null;
                                            b2.f1958h = null;
                                            b2.f1961k = true;
                                            obj.notifyAll();
                                        }
                                        if (selector != null) {
                                            try {
                                                selector.close();
                                            } catch (IOException e11) {
                                                b2.f1952a.n("Failed to properly close selector, ignoring and continuing close", e11);
                                            }
                                        }
                                        if (thread22 != null) {
                                            try {
                                                thread22.join();
                                            } catch (InterruptedException unused2) {
                                                Thread.currentThread().interrupt();
                                            }
                                        }
                                        b2.f1952a.o("dnsjava NIO selector thread stopped");
                                        return;
                                    default:
                                        b2.f1960j = false;
                                        Selector selector2 = b2.f1959i;
                                        if (selector2 != null) {
                                            b2.f1959i.wakeup();
                                        }
                                        if (selector2 == null) {
                                            return;
                                        }
                                        synchronized (b2.f1953b) {
                                            while (!b2.f1961k) {
                                                try {
                                                    try {
                                                        b2.f1953b.wait();
                                                    } finally {
                                                        b2.f1961k = false;
                                                    }
                                                } catch (InterruptedException unused3) {
                                                    Thread.currentThread().interrupt();
                                                }
                                            }
                                        }
                                        return;
                                }
                            }
                        });
                        f1958h = thread2;
                        thread2.setName("dnsjava NIO shutdown hook");
                        if (Boolean.parseBoolean(System.getProperty("dnsjava.nio.register_shutdown_hook", "true"))) {
                            Runtime.getRuntime().addShutdownHook(f1958h);
                        }
                    }
                } finally {
                }
            }
        }
        return f1959i;
    }

    public static void c(String str, byte[] bArr) {
        z7.b bVar = f1952a;
        if (bVar.p()) {
            char[] cArr = g8.a.f2996a;
            int length = bArr.length;
            StringBuilder sb = new StringBuilder();
            sb.append(length);
            sb.append("b");
            if (str != null) {
                sb.append(" (");
                sb.append(str);
                sb.append(")");
            }
            sb.append(AbstractJsonLexerKt.COLON);
            int length2 = (sb.toString().length() + 8) & (-8);
            sb.append('\t');
            int i8 = (80 - length2) / 3;
            for (int i9 = 0; i9 < length; i9++) {
                if (i9 != 0 && i9 % i8 == 0) {
                    sb.append('\n');
                    for (int i10 = 0; i10 < length2 / 8; i10++) {
                        sb.append('\t');
                    }
                }
                byte b9 = bArr[i9];
                char[] cArr2 = g8.a.f2996a;
                sb.append(cArr2[(b9 & 255) >> 4]);
                sb.append(cArr2[b9 & 15]);
                sb.append(' ');
            }
            sb.append('\n');
            bVar.h(sb.toString());
        }
    }
}
