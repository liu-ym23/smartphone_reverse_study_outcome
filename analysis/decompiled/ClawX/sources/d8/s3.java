package d8;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s3 implements x2 {

    /* renamed from: e, reason: collision with root package name */
    public static final z7.b f2166e = z7.d.b(s3.class);

    /* renamed from: f, reason: collision with root package name */
    public static final InetSocketAddress f2167f = new InetSocketAddress(InetAddress.getLoopbackAddress(), 53);

    /* renamed from: a, reason: collision with root package name */
    public InetSocketAddress f2168a;

    /* renamed from: b, reason: collision with root package name */
    public final n2 f2169b;

    /* renamed from: c, reason: collision with root package name */
    public Duration f2170c;
    public final f8.a d;

    public s3() {
        y2 y2Var;
        n2 n2Var = new n2(x1.f2208g, 41, 1280);
        w2.c(1280, "payloadSize");
        w2.c(0, "flags");
        long j4 = 0;
        n2Var.d = (j4 << 24) + (j4 << 16) + j4;
        this.f2169b = n2Var;
        this.f2170c = Duration.ofSeconds(10L);
        this.d = new f8.a();
        z7.b bVar = y2.f2227c;
        synchronized (y2.class) {
            if (y2.d == null || y2.f2228e == null) {
                y2 y2Var2 = new y2();
                synchronized (y2.class) {
                    y2.d = y2Var2;
                }
            }
            y2Var = y2.d;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) y2Var.f2229a.get(0);
        this.f2168a = inetSocketAddress;
        if (inetSocketAddress == null) {
            this.f2168a = f2167f;
        }
    }

    @Override // d8.x2
    public final CompletionStage b(j1 j1Var, Executor executor) {
        w2 w2VarD;
        if (j1Var.f2031a.d() == 0 && (w2VarD = j1Var.d()) != null && w2VarD.f2196b == 252) {
            CompletableFuture completableFuture = new CompletableFuture();
            CompletableFuture.runAsync(new androidx.emoji2.text.k(this, completableFuture, j1Var, 1), executor);
            return completableFuture;
        }
        j1 j1VarClone = j1Var.clone();
        n2 n2Var = this.f2169b;
        if (n2Var != null && j1VarClone.c() == null) {
            j1VarClone.a(n2Var, 3);
        }
        return f(j1VarClone, false, executor);
    }

    @Override // d8.x2
    public final Duration c() {
        return this.f2170c;
    }

    @Override // d8.x2
    public final CompletionStage d(j1 j1Var) {
        return b(j1Var, ForkJoinPool.commonPool());
    }

    public final j1 e(j1 j1Var) throws l4 {
        r4 r4Var = new r4(j1Var.d().f2195a, this.f2168a);
        r4Var.f2149g = this.f2170c;
        try {
            r4Var.d = new androidx.emoji2.text.p(4, false);
            try {
                r4Var.c();
                r4Var.a();
                androidx.emoji2.text.p pVar = r4Var.d;
                if (pVar == null) {
                    throw new IllegalArgumentException("ZoneTransferIn used callback interface");
                }
                ArrayList arrayList = (ArrayList) pVar.f623b;
                u0 u0Var = new u0(j1Var.f2031a.f2175a);
                j1 j1Var2 = new j1(u0Var);
                u0.a(5);
                int i8 = u0Var.f2176b;
                u0.a(5);
                u0Var.f2176b = i8 | 1024;
                u0 u0Var2 = j1Var2.f2031a;
                u0Var2.getClass();
                int i9 = 0;
                u0.a(0);
                int i10 = u0Var2.f2176b;
                u0.a(0);
                u0Var2.f2176b = i10 | 32768;
                j1Var2.a(j1Var.d(), 0);
                int size = arrayList.size();
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    j1Var2.a((w2) obj, 1);
                }
                return j1Var2;
            } finally {
                try {
                    v3 v3Var = r4Var.f2148f;
                    if (v3Var != null) {
                        v3Var.close();
                    }
                } catch (IOException unused) {
                }
            }
        } catch (p4 e9) {
            throw new l4(e9.getMessage());
        }
    }

    public final CompletableFuture f(j1 j1Var, boolean z, final Executor executor) throws Throwable {
        final CompletableFuture completableFuture;
        DatagramChannel datagramChannel;
        InetSocketAddress inetSocketAddress;
        final j1 j1Var2 = j1Var;
        u0 u0Var = j1Var2.f2031a;
        final int i8 = u0Var.f2175a;
        int i9 = 0;
        boolean z2 = u0Var.d() != 5;
        try {
            b0.j jVar = new b0.j(2);
            if (!j1Var2.e(jVar) && !z2) {
                throw new k1("Message size would exceed the allowed maximum of 65535 bytes");
            }
            j1Var2.f2033c = jVar.f832a;
            byte[] bArrF = jVar.f();
            n2 n2VarC = j1Var2.c();
            int i10 = n2VarC == null ? 512 : n2VarC.f2197c;
            boolean z8 = z || bArrF.length > i10;
            z7.b bVar = f2166e;
            if (bVar.p()) {
                Object[] objArr = {j1Var2.d().f2195a, f4.f1995a.d(j1Var2.d().f2196b), Integer.valueOf(i8), z8 ? "tcp" : "udp", this.f2168a.getAddress().getHostAddress(), Integer.valueOf(this.f2168a.getPort()), j1Var2};
                j1Var2 = j1Var2;
                bVar.g("Sending {}/{}, id={} to {}/{}:{}, query:\n{}", objArr);
            } else if (bVar.d()) {
                bVar.a("Sending {}/{}, id={} to {}/{}:{}", j1Var2.d().f2195a, f4.f1995a.d(j1Var2.d().f2196b), Integer.valueOf(i8), z8 ? "tcp" : "udp", this.f2168a.getAddress().getHostAddress(), Integer.valueOf(this.f2168a.getPort()));
            }
            f8.a aVar = this.d;
            if (z8) {
                aVar.getClass();
                androidx.emoji2.text.p pVar = f8.a.f2666a;
                final InetSocketAddress inetSocketAddress2 = this.f2168a;
                Duration duration = this.f2170c;
                final i2 i2Var = (i2) pVar.f623b;
                i2Var.getClass();
                completableFuture = new CompletableFuture();
                try {
                    Selector selectorB = b2.b();
                    long jNanoTime = System.nanoTime() + duration.toNanos();
                    g2 g2Var = (g2) i2Var.f2024m.computeIfAbsent(new f2(inetSocketAddress2), new Function() { // from class: d8.e2
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) throws IOException {
                            SocketChannel socketChannelOpen;
                            i2 i2Var2 = i2Var;
                            z7.b bVar2 = i2.f2022n;
                            InetSocketAddress inetSocketAddress3 = inetSocketAddress2;
                            bVar2.c("Opening async channel for l={}/r={}", null, inetSocketAddress3);
                            try {
                                socketChannelOpen = SocketChannel.open();
                            } catch (IOException e9) {
                                e = e9;
                                socketChannelOpen = null;
                            }
                            try {
                                socketChannelOpen.configureBlocking(false);
                                socketChannelOpen.connect(inetSocketAddress3);
                                return new g2(i2Var2, socketChannelOpen);
                            } catch (IOException e10) {
                                e = e10;
                                if (socketChannelOpen != null) {
                                    try {
                                        socketChannelOpen.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                completableFuture.completeExceptionally(e);
                                return null;
                            }
                        }
                    });
                    if (g2Var != null) {
                        i2.f2022n.g("Creating transaction for id {} ({}/{})", Integer.valueOf(j1Var2.f2031a.f2175a), j1Var2.d().f2195a, f4.f1995a.d(j1Var2.d().f2196b));
                        g2Var.f2003b.add(new h2(j1Var2, bArrF, jNanoTime, g2Var.f2002a, completableFuture));
                        i2Var.f2023l.add(g2Var);
                        selectorB.wakeup();
                    }
                } catch (IOException e9) {
                    completableFuture.completeExceptionally(e9);
                }
            } else {
                aVar.getClass();
                androidx.emoji2.text.p pVar2 = f8.a.f2666a;
                InetSocketAddress inetSocketAddress3 = this.f2168a;
                Duration duration2 = this.f2170c;
                l2 l2Var = (l2) pVar2.f624c;
                int i11 = l2Var.f2068l;
                int i12 = l2Var.f2069m;
                SecureRandom secureRandom = l2Var.f2070n;
                long nanos = duration2.toNanos() + System.nanoTime();
                CompletableFuture completableFuture2 = new CompletableFuture();
                DatagramChannel datagramChannel2 = null;
                try {
                    Selector selectorB2 = b2.b();
                    DatagramChannel datagramChannelOpen = DatagramChannel.open();
                    try {
                        datagramChannelOpen.configureBlocking(false);
                        try {
                            k2 k2Var = new k2(l2Var, j1Var2.f2031a.f2175a, bArrF, i10, nanos, datagramChannelOpen, completableFuture2);
                            datagramChannel = datagramChannelOpen;
                            completableFuture = completableFuture2;
                            while (true) {
                                if (i9 >= 1024) {
                                    k2Var.b(new IOException("No available source port found"));
                                    break;
                                }
                                if (secureRandom != null) {
                                    try {
                                        try {
                                            inetSocketAddress = new InetSocketAddress(secureRandom.nextInt(i12) + i11);
                                        } catch (SocketException unused) {
                                            i9++;
                                        }
                                    } catch (IOException e10) {
                                        e = e10;
                                        datagramChannel2 = datagramChannel;
                                        l2.d(datagramChannel2);
                                        completableFuture.completeExceptionally(e);
                                        final boolean z9 = z8;
                                        return completableFuture.thenComposeAsync(new Function() { // from class: d8.r3
                                            @Override // java.util.function.Function
                                            public final Object apply(Object obj) throws l4 {
                                                byte[] bArr = (byte[]) obj;
                                                CompletableFuture completableFuture3 = new CompletableFuture();
                                                if (bArr.length < 12) {
                                                    completableFuture3.completeExceptionally(new l4("invalid DNS header - too short"));
                                                    return completableFuture3;
                                                }
                                                int i13 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                                                int i14 = i8;
                                                if (i13 != i14) {
                                                    completableFuture3.completeExceptionally(new l4(a8.b.i(i14, i13, "invalid message id: expected ", "; got id ")));
                                                    return completableFuture3;
                                                }
                                                try {
                                                    j1 j1Var3 = new j1(bArr);
                                                    j1 j1Var4 = j1Var2;
                                                    if (j1Var4.f2031a.d() == 5) {
                                                        if (j1Var3.f2031a.d() != 5) {
                                                            completableFuture3.completeExceptionally(new l4("invalid message: opcode response is not UPDATE"));
                                                            return completableFuture3;
                                                        }
                                                    } else {
                                                        if (j1Var3.d() == null) {
                                                            completableFuture3.completeExceptionally(new l4("invalid message: question section missing"));
                                                            return completableFuture3;
                                                        }
                                                        if (!j1Var4.d().f2195a.equals(j1Var3.d().f2195a)) {
                                                            completableFuture3.completeExceptionally(new l4("invalid name in message: expected " + j1Var4.d().f2195a + "; got " + j1Var3.d().f2195a));
                                                            return completableFuture3;
                                                        }
                                                        if (j1Var4.d().f2197c != j1Var3.d().f2197c) {
                                                            StringBuilder sb = new StringBuilder("invalid class in message: expected ");
                                                            int i15 = j1Var4.d().f2197c;
                                                            p pVar3 = q.f2118a;
                                                            sb.append(pVar3.d(i15));
                                                            sb.append("; got ");
                                                            sb.append(pVar3.d(j1Var3.d().f2197c));
                                                            completableFuture3.completeExceptionally(new l4(sb.toString()));
                                                            return completableFuture3;
                                                        }
                                                        if (j1Var4.d().f2196b != j1Var3.d().f2196b) {
                                                            StringBuilder sb2 = new StringBuilder("invalid type in message: expected ");
                                                            int i16 = j1Var4.d().f2196b;
                                                            l3 l3Var = f4.f1995a;
                                                            sb2.append(l3Var.d(i16));
                                                            sb2.append("; got ");
                                                            sb2.append(l3Var.d(j1Var3.d().f2196b));
                                                            completableFuture3.completeExceptionally(new l4(sb2.toString()));
                                                            return completableFuture3;
                                                        }
                                                    }
                                                    if (z9 || !u0.c(j1Var3.f2031a.f2176b, 6)) {
                                                        completableFuture3.complete(j1Var3);
                                                        return completableFuture3;
                                                    }
                                                    z7.b bVar2 = s3.f2166e;
                                                    if (bVar2.p()) {
                                                        bVar2.f("Got truncated response for id {}, retrying via TCP, response:\n{}", Integer.valueOf(i14), j1Var3);
                                                    } else {
                                                        bVar2.l(Integer.valueOf(i14), "Got truncated response for id {}, retrying via TCP");
                                                    }
                                                    return this.f2139a.f(j1Var4, true, executor);
                                                } catch (IOException e11) {
                                                    try {
                                                        if (e11 instanceof l4) {
                                                            throw ((l4) e11);
                                                        }
                                                        throw new l4("Error parsing message", e11);
                                                    } catch (l4 e12) {
                                                        completableFuture3.completeExceptionally(e12);
                                                        return completableFuture3;
                                                    }
                                                }
                                            }
                                        }, executor);
                                    } catch (Throwable th) {
                                        th = th;
                                        datagramChannel2 = datagramChannel;
                                        l2.d(datagramChannel2);
                                        throw th;
                                    }
                                } else {
                                    inetSocketAddress = null;
                                }
                                datagramChannel.bind((SocketAddress) inetSocketAddress);
                                datagramChannel.connect(inetSocketAddress3);
                                l2Var.f2072p.add(k2Var);
                                l2Var.f2071o.add(k2Var);
                                selectorB2.wakeup();
                                break;
                            }
                        } catch (IOException e11) {
                            e = e11;
                            datagramChannel = datagramChannelOpen;
                            completableFuture = completableFuture2;
                            datagramChannel2 = datagramChannel;
                            l2.d(datagramChannel2);
                            completableFuture.completeExceptionally(e);
                            final boolean z92 = z8;
                            return completableFuture.thenComposeAsync(new Function() { // from class: d8.r3
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) throws l4 {
                                    byte[] bArr = (byte[]) obj;
                                    CompletableFuture completableFuture3 = new CompletableFuture();
                                    if (bArr.length < 12) {
                                        completableFuture3.completeExceptionally(new l4("invalid DNS header - too short"));
                                        return completableFuture3;
                                    }
                                    int i13 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                                    int i14 = i8;
                                    if (i13 != i14) {
                                        completableFuture3.completeExceptionally(new l4(a8.b.i(i14, i13, "invalid message id: expected ", "; got id ")));
                                        return completableFuture3;
                                    }
                                    try {
                                        j1 j1Var3 = new j1(bArr);
                                        j1 j1Var4 = j1Var2;
                                        if (j1Var4.f2031a.d() == 5) {
                                            if (j1Var3.f2031a.d() != 5) {
                                                completableFuture3.completeExceptionally(new l4("invalid message: opcode response is not UPDATE"));
                                                return completableFuture3;
                                            }
                                        } else {
                                            if (j1Var3.d() == null) {
                                                completableFuture3.completeExceptionally(new l4("invalid message: question section missing"));
                                                return completableFuture3;
                                            }
                                            if (!j1Var4.d().f2195a.equals(j1Var3.d().f2195a)) {
                                                completableFuture3.completeExceptionally(new l4("invalid name in message: expected " + j1Var4.d().f2195a + "; got " + j1Var3.d().f2195a));
                                                return completableFuture3;
                                            }
                                            if (j1Var4.d().f2197c != j1Var3.d().f2197c) {
                                                StringBuilder sb = new StringBuilder("invalid class in message: expected ");
                                                int i15 = j1Var4.d().f2197c;
                                                p pVar3 = q.f2118a;
                                                sb.append(pVar3.d(i15));
                                                sb.append("; got ");
                                                sb.append(pVar3.d(j1Var3.d().f2197c));
                                                completableFuture3.completeExceptionally(new l4(sb.toString()));
                                                return completableFuture3;
                                            }
                                            if (j1Var4.d().f2196b != j1Var3.d().f2196b) {
                                                StringBuilder sb2 = new StringBuilder("invalid type in message: expected ");
                                                int i16 = j1Var4.d().f2196b;
                                                l3 l3Var = f4.f1995a;
                                                sb2.append(l3Var.d(i16));
                                                sb2.append("; got ");
                                                sb2.append(l3Var.d(j1Var3.d().f2196b));
                                                completableFuture3.completeExceptionally(new l4(sb2.toString()));
                                                return completableFuture3;
                                            }
                                        }
                                        if (z92 || !u0.c(j1Var3.f2031a.f2176b, 6)) {
                                            completableFuture3.complete(j1Var3);
                                            return completableFuture3;
                                        }
                                        z7.b bVar2 = s3.f2166e;
                                        if (bVar2.p()) {
                                            bVar2.f("Got truncated response for id {}, retrying via TCP, response:\n{}", Integer.valueOf(i14), j1Var3);
                                        } else {
                                            bVar2.l(Integer.valueOf(i14), "Got truncated response for id {}, retrying via TCP");
                                        }
                                        return this.f2139a.f(j1Var4, true, executor);
                                    } catch (IOException e112) {
                                        try {
                                            if (e112 instanceof l4) {
                                                throw ((l4) e112);
                                            }
                                            throw new l4("Error parsing message", e112);
                                        } catch (l4 e12) {
                                            completableFuture3.completeExceptionally(e12);
                                            return completableFuture3;
                                        }
                                    }
                                }
                            }, executor);
                        } catch (Throwable th2) {
                            th = th2;
                            datagramChannel = datagramChannelOpen;
                        }
                    } catch (IOException e12) {
                        e = e12;
                        datagramChannel = datagramChannelOpen;
                    } catch (Throwable th3) {
                        th = th3;
                        datagramChannel = datagramChannelOpen;
                    }
                } catch (IOException e13) {
                    e = e13;
                    completableFuture = completableFuture2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            final boolean z922 = z8;
            return completableFuture.thenComposeAsync(new Function() { // from class: d8.r3
                @Override // java.util.function.Function
                public final Object apply(Object obj) throws l4 {
                    byte[] bArr = (byte[]) obj;
                    CompletableFuture completableFuture3 = new CompletableFuture();
                    if (bArr.length < 12) {
                        completableFuture3.completeExceptionally(new l4("invalid DNS header - too short"));
                        return completableFuture3;
                    }
                    int i13 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                    int i14 = i8;
                    if (i13 != i14) {
                        completableFuture3.completeExceptionally(new l4(a8.b.i(i14, i13, "invalid message id: expected ", "; got id ")));
                        return completableFuture3;
                    }
                    try {
                        j1 j1Var3 = new j1(bArr);
                        j1 j1Var4 = j1Var2;
                        if (j1Var4.f2031a.d() == 5) {
                            if (j1Var3.f2031a.d() != 5) {
                                completableFuture3.completeExceptionally(new l4("invalid message: opcode response is not UPDATE"));
                                return completableFuture3;
                            }
                        } else {
                            if (j1Var3.d() == null) {
                                completableFuture3.completeExceptionally(new l4("invalid message: question section missing"));
                                return completableFuture3;
                            }
                            if (!j1Var4.d().f2195a.equals(j1Var3.d().f2195a)) {
                                completableFuture3.completeExceptionally(new l4("invalid name in message: expected " + j1Var4.d().f2195a + "; got " + j1Var3.d().f2195a));
                                return completableFuture3;
                            }
                            if (j1Var4.d().f2197c != j1Var3.d().f2197c) {
                                StringBuilder sb = new StringBuilder("invalid class in message: expected ");
                                int i15 = j1Var4.d().f2197c;
                                p pVar3 = q.f2118a;
                                sb.append(pVar3.d(i15));
                                sb.append("; got ");
                                sb.append(pVar3.d(j1Var3.d().f2197c));
                                completableFuture3.completeExceptionally(new l4(sb.toString()));
                                return completableFuture3;
                            }
                            if (j1Var4.d().f2196b != j1Var3.d().f2196b) {
                                StringBuilder sb2 = new StringBuilder("invalid type in message: expected ");
                                int i16 = j1Var4.d().f2196b;
                                l3 l3Var = f4.f1995a;
                                sb2.append(l3Var.d(i16));
                                sb2.append("; got ");
                                sb2.append(l3Var.d(j1Var3.d().f2196b));
                                completableFuture3.completeExceptionally(new l4(sb2.toString()));
                                return completableFuture3;
                            }
                        }
                        if (z922 || !u0.c(j1Var3.f2031a.f2176b, 6)) {
                            completableFuture3.complete(j1Var3);
                            return completableFuture3;
                        }
                        z7.b bVar2 = s3.f2166e;
                        if (bVar2.p()) {
                            bVar2.f("Got truncated response for id {}, retrying via TCP, response:\n{}", Integer.valueOf(i14), j1Var3);
                        } else {
                            bVar2.l(Integer.valueOf(i14), "Got truncated response for id {}, retrying via TCP");
                        }
                        return this.f2139a.f(j1Var4, true, executor);
                    } catch (IOException e112) {
                        try {
                            if (e112 instanceof l4) {
                                throw ((l4) e112);
                            }
                            throw new l4("Error parsing message", e112);
                        } catch (l4 e122) {
                            completableFuture3.completeExceptionally(e122);
                            return completableFuture3;
                        }
                    }
                }
            }, executor);
        } catch (k1 e14) {
            CompletableFuture completableFuture3 = new CompletableFuture();
            completableFuture3.completeExceptionally(e14);
            return completableFuture3;
        }
    }

    public final String toString() {
        return "SimpleResolver [" + this.f2168a + "]";
    }
}
