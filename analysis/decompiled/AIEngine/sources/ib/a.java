package ib;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f9586a;

    /* renamed from: b, reason: collision with root package name */
    public DataInputStream f9587b;

    /* renamed from: c, reason: collision with root package name */
    public DataOutputStream f9588c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9589d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f9590e;

    public a() {
        this(0);
    }

    public final void a() {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        synchronized (this.f9589d) {
            try {
                if (!this.f9590e) {
                    this.f9590e = true;
                    try {
                        dataInputStream = this.f9587b;
                    } catch (Exception unused) {
                    }
                    if (dataInputStream == null) {
                        g.l("dataInput");
                        throw null;
                    }
                    dataInputStream.close();
                    try {
                        dataOutputStream = this.f9588c;
                    } catch (Exception unused2) {
                    }
                    if (dataOutputStream == null) {
                        g.l("dataOutput");
                        throw null;
                    }
                    dataOutputStream.close();
                    try {
                        this.f9586a.close();
                    } catch (Exception unused3) {
                    }
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() throws Exception {
        if (this.f9590e) {
            throw new Exception("FetchFileResourceTransporter is already closed.");
        }
    }

    public final void c() {
        if (this.f9587b == null) {
            g.l("dataInput");
            throw null;
        }
        if (this.f9588c != null) {
            return;
        }
        g.l("dataOutput");
        throw null;
    }

    public a(int i10) {
        Socket socket = new Socket();
        this.f9586a = socket;
        this.f9589d = new Object();
        if (socket.isConnected() && !socket.isClosed()) {
            this.f9587b = new DataInputStream(socket.getInputStream());
            this.f9588c = new DataOutputStream(socket.getOutputStream());
        }
        if (socket.isClosed()) {
            this.f9590e = true;
        }
    }
}
