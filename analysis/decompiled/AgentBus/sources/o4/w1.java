package o4;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.Log;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class w1 implements NsdManager.ResolveListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y1 f7678a;

    public w1(y1 y1Var) {
        this.f7678a = y1Var;
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i2) {
        q7.k.e(nsdServiceInfo, "info");
        Log.w("OpenClaw/Discovery", "onResolveFailed: " + nsdServiceInfo.getServiceName() + " code=" + i2);
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
        String hostAddress;
        String str;
        q7.k.e(nsdServiceInfo, "resolved");
        InetAddress host = nsdServiceInfo.getHost();
        z1 z1Var = null;
        lowerCase = null;
        String lowerCase = null;
        z1Var = null;
        z1Var = null;
        if (host != null && (hostAddress = host.getHostAddress()) != null) {
            int port = nsdServiceInfo.getPort();
            Integer numValueOf = Integer.valueOf(port);
            if (port <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                HashMap map = new HashMap();
                Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
                q7.k.d(attributes, "getAttributes(...)");
                for (Map.Entry<String, byte[]> entry : attributes.entrySet()) {
                    String key = entry.getKey();
                    byte[] value = entry.getValue();
                    if (value != null) {
                        map.put(key, new String(value, ga.a.f4005a));
                    }
                }
                String str2 = (String) map.get("tls");
                boolean z4 = true;
                if ((str2 == null || !str2.equalsIgnoreCase("1")) && ((str = (String) map.get("scheme")) == null || !str.equalsIgnoreCase("wss"))) {
                    z4 = false;
                }
                boolean z10 = z4;
                String str3 = (String) map.get("sha256");
                if (str3 != null) {
                    if (str3.length() != 64) {
                        str3 = null;
                    }
                    if (str3 != null) {
                        lowerCase = str3.toLowerCase(Locale.ROOT);
                        q7.k.d(lowerCase, "toLowerCase(...)");
                    }
                }
                String str4 = lowerCase;
                String strD = y1.d(nsdServiceInfo, hostAddress, numValueOf);
                String serviceName = nsdServiceInfo.getServiceName();
                if (serviceName == null) {
                    serviceName = hostAddress + ":" + iIntValue;
                }
                z1Var = new z1(strD, serviceName, hostAddress, iIntValue, z10, str4, hostAddress, 896);
            }
        }
        if (z1Var == null) {
            return;
        }
        y1 y1Var = this.f7678a;
        ((ConcurrentHashMap) y1Var.f7701b).put(z1Var.f7717a, z1Var);
        y1.a(y1Var);
    }
}
