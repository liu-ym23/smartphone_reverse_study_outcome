package ib;

import ab.u;
import d7.t;
import ga.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class j extends m {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f5046c;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numI0 = property != null ? r.i0(property) : null;
        boolean z4 = false;
        if (numI0 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z4 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numI0.intValue() >= 9) {
            z4 = true;
        }
        f5046c = z4;
    }

    @Override // ib.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        q7.k.e(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((u) obj) != u.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((u) it.next()).f655f);
        }
        sSLParameters.setApplicationProtocols((String[]) arrayList2.toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // ib.m
    public final String e(SSLSocket sSLSocket) {
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
