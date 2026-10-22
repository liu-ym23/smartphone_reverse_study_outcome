package e8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2404f;

    @Override // e8.i
    public void a() throws IllegalAccessException, e, ClassNotFoundException, IOException, IllegalArgumentException, InvocationTargetException {
        switch (this.f2404f) {
            case 0:
                h("dns.server", "dns.search", "dns.ndots");
                return;
            case 1:
                g();
                if (j("/etc/resolv.conf")) {
                    return;
                }
                j("sys:/etc/resolv.cfg");
                return;
            default:
                g();
                try {
                    Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
                    Object objInvoke = cls.getDeclaredMethod("open", null).invoke(null, null);
                    Iterator it = ((List) cls.getMethod("nameservers", null).invoke(objInvoke, null)).iterator();
                    while (it.hasNext()) {
                        d(new InetSocketAddress((String) it.next(), 53));
                    }
                    Iterator it2 = ((List) cls.getMethod("searchlist", null).invoke(objInvoke, null)).iterator();
                    while (it2.hasNext()) {
                        e((String) it2.next());
                    }
                    return;
                } catch (Exception e9) {
                    throw new e(e9);
                }
        }
    }

    public void h(String str, String str2, String str3) throws NumberFormatException {
        g();
        String property = System.getProperty(str);
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                try {
                    URI uri = new URI("dns://" + strNextToken);
                    int i8 = 53;
                    if (uri.getHost() == null) {
                        d(new InetSocketAddress(strNextToken, 53));
                    } else {
                        int port = uri.getPort();
                        if (port != -1) {
                            i8 = port;
                        }
                        d(new InetSocketAddress(uri.getHost(), i8));
                    }
                } catch (URISyntaxException unused) {
                    this.f2398b.k(strNextToken, "Ignored invalid server {}");
                }
            }
        }
        String property2 = System.getProperty(str2);
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                e(stringTokenizer2.nextToken());
            }
        }
        b.f(System.getProperty(str3));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void i(InputStream inputStream) throws IOException, NumberFormatException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    ArrayList arrayList = this.f2399c;
                    if (line == null) {
                        bufferedReader.close();
                        inputStreamReader.close();
                        String str = System.getenv("LOCALDOMAIN");
                        if (str != null && !str.isEmpty()) {
                            arrayList.clear();
                            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
                            while (stringTokenizer.hasMoreTokens()) {
                                e(stringTokenizer.nextToken());
                            }
                        }
                        String str2 = System.getenv("RES_OPTIONS");
                        if (str2 == null || str2.isEmpty()) {
                            return;
                        }
                        StringTokenizer stringTokenizer2 = new StringTokenizer(str2, " ");
                        while (stringTokenizer2.hasMoreTokens()) {
                            String strNextToken = stringTokenizer2.nextToken();
                            if (strNextToken.startsWith("ndots:")) {
                                b.f(strNextToken.substring(6));
                            }
                        }
                        return;
                    }
                    StringTokenizer stringTokenizer3 = new StringTokenizer(line);
                    if (stringTokenizer3.hasMoreTokens()) {
                        String strNextToken2 = stringTokenizer3.nextToken();
                        switch (strNextToken2.hashCode()) {
                            case -1326197564:
                                if (!strNextToken2.equals("domain")) {
                                    break;
                                } else {
                                    arrayList.clear();
                                    if (!stringTokenizer3.hasMoreTokens()) {
                                        break;
                                    } else {
                                        e(stringTokenizer3.nextToken());
                                        break;
                                    }
                                }
                            case -1249474914:
                                if (!strNextToken2.equals("options")) {
                                    break;
                                } else {
                                    while (stringTokenizer3.hasMoreTokens()) {
                                        String strNextToken3 = stringTokenizer3.nextToken();
                                        if (strNextToken3.startsWith("ndots:")) {
                                            b.f(strNextToken3.substring(6));
                                        }
                                    }
                                    break;
                                }
                            case -906336856:
                                if (!strNextToken2.equals("search")) {
                                    break;
                                } else {
                                    arrayList.clear();
                                    while (stringTokenizer3.hasMoreTokens()) {
                                        e(stringTokenizer3.nextToken());
                                    }
                                    break;
                                }
                            case 154424718:
                                if (!strNextToken2.equals("nameserver")) {
                                    break;
                                } else {
                                    d(new InetSocketAddress(stringTokenizer3.nextToken(), 53));
                                    break;
                                }
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // e8.i
    public boolean isEnabled() {
        switch (this.f2404f) {
            case 1:
                return (System.getProperty("os.name").contains("Windows") || System.getProperty("java.specification.vendor").toLowerCase().contains("android")) ? false : true;
            case 2:
                return Boolean.getBoolean("dnsjava.configprovider.sunjvm.enabled");
            default:
                return super.isEnabled();
        }
    }

    public boolean j(String str) throws IOException {
        Path path = Paths.get(str, new String[0]);
        if (Files.exists(path, new LinkOption[0])) {
            try {
                InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
                try {
                    i(inputStreamNewInputStream);
                    if (inputStreamNewInputStream != null) {
                        inputStreamNewInputStream.close();
                    }
                    return true;
                } finally {
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }
}
