package r4;

import com.bytedance.frameworks.baselib.network.http.impl.CookiePolicy;
import com.bytedance.frameworks.baselib.network.http.impl.CookieStore;
import com.bytedance.frameworks.baselib.network.http.impl.SerializableHttpCookie;
import com.bytedance.librarian.LibrarianImpl;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CookieStore f23731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CookiePolicy f23732b;

    public a(CookieStore r10, CookiePolicy r11) {
        if (r10 != null) goto L5;
        r10 = new b();
    L5:
        this.f23731a = r10;
        if (r11 != null) goto L8;
        r11 = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
    L8:
        this.f23732b = r11;
    }

    public static Map a(List r10) {
        if (r10.isEmpty() == true) goto L5;
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r10.iterator();
        int r13 = 1;
        int r14 = 1;
    L8:
        if (r12.hasNext() == false) goto L10;
        r14 = Math.min(r14, ((c) r12.next()).F());
        goto L8
    L10:
        if (r14 != 1) goto L12;
        r11.append("$Version=\"1\"; ");
    L12:
        r11.append(((c) r10.get(0)).toString());
    L14:
        if (r13 >= r10.size()) goto L17;
        r11.append("; ");
        r11.append(((c) r10.get(r13)).toString());
        r13 = r13 + 1;
        goto L14
    L17:
        return Collections.singletonMap("Cookie", Collections.singletonList(r11.toString()));
    L5:
        return Collections.emptyMap();
    }

    public static List b(Map r10) {
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L20;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        if (r14 == null) goto L4;
        if (r14.equalsIgnoreCase("Set-cookie") == true) goto L11;
        if (r14.equalsIgnoreCase("Set-cookie2") == false) goto L4;
    L11:
        Iterator r15 = ((List) r13.getValue()).iterator();
    L13:
        if (r15.hasNext() == false) goto L4;
        Iterator r16 = c.L((String) r15.next()).iterator();     // Catch: IllegalArgumentException -> L21
    L17:
        if (r16.hasNext() == false) goto L13;
        r11.add((c) r16.next());     // Catch: IllegalArgumentException -> L21
    L20:
        return r11;
    }

    public static String c(String r10) {
        if (r10 != null) goto L6;
        return LibrarianImpl.Constants.SEPARATOR;
    L6:
        return r10.substring(0, r10.lastIndexOf(47) + 1);
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map get(URI r10, Map r11) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L17;
        ArrayList r12 = new ArrayList();
        Iterator<c> r13 = this.f23731a.get(r10).iterator();
    L6:
        if (r13.hasNext() == false) goto L15;
        c r14 = r13.next();
        if (c.N(r14, r10) == false) goto L6;
        if (c.P(r14, r10) == false) goto L6;
        if (c.O(r14, r10) == false) goto L6;
        r12.add(r14);
        goto L6
    L15:
        return a(r12);
    L17:
        throw new IllegalArgumentException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r10, Map r11) {
        if (r10 == null) goto L29;
        if (r11 == null) goto L29;
        Iterator r12 = b(r11).iterator();
    L6:
        if (r12.hasNext() == false) goto L27;
        c r13 = (c) r12.next();
        if (r13.x() != null) goto L11;
        r13.T(r10.getHost());
    L11:
        if (r13.B() == null) goto L12;
        if (c.N(r13, r10) == false) goto L6;
    L17:
        if ("".equals(r13.C()) == true) goto L18;
        if (r13.C() == null) goto L25;
        if (c.O(r13, r10) == false) goto L6;
    L25:
        if (this.f23732b.shouldAccept(r10, r13) == false) goto L6;
        this.f23731a.add(r10, r13);
        goto L6
    L18:
        r13.Y(Integer.toString(SerializableHttpCookie.getEffectivePort(r10.getScheme(), r10.getPort())));
        goto L25
    L12:
        r13.X(c(r10.getPath()));
        goto L17
    L27:
        return;
    L29:
        throw new IllegalArgumentException();
    }
}
