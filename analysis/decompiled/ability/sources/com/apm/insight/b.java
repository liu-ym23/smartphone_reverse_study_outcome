package com.apm.insight;

import N9.j;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLException;
import o2.RunnableC1756a;
import org.apache.http.conn.ConnectTimeoutException;
import z2.l;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2156a = 0;

    static {
        if (j.f1023a) {
            return;
        }
        j.f1023a = true;
    }

    public static void a(Throwable th) {
        if (g.g.isEnsureEnable()) {
            HashSet hashSet = y2.c.f6890a;
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (!(th instanceof ConnectTimeoutException) && !(th instanceof SocketTimeoutException) && !(th instanceof BindException) && !(th instanceof ConnectException) && !(th instanceof NoRouteToHostException) && !(th instanceof PortUnreachableException) && !(th instanceof SocketException) && !(th instanceof UnknownHostException) && !(th instanceof ProtocolException)) {
                if (th instanceof SSLException) {
                    return;
                }
                try {
                    l.i().a(new RunnableC1756a(0, th));
                } catch (Throwable unused) {
                }
            }
        }
    }
}
