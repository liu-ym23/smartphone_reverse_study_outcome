package r4;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.frameworks.baselib.network.http.impl.CookieStore;
import com.bytedance.frameworks.baselib.network.http.impl.SerializableHttpCookie;
import com.bytedance.librarian.LibrarianImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class d implements CookieStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23757c = "d";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f23758d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f23759e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f23760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f23761b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f23762a;

        public a(d r10) {
            this.f23762a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f23762a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        f23758d = new LinkedHashMap();
    }

    public d(Context r10) {
        this.f23761b = new LinkedHashMap();
        String r11 = f23759e;
        if (r11 != null) goto L5;
        r11 = "cookieStore";
    L5:
        SharedPreferences r12 = r10.getSharedPreferences(r11, 4);
        this.f23760a = r12;
        f(r12.getAll(), true);
        f(f23758d, false);
    }

    public static /* synthetic */ void a(d r10) {
        r10.k();
    }

    public static URI d(URI r10, c r11) {
        if (r11.x() == null) goto L19;
        String r12 = r11.x();
        if (r12.charAt(0) != '.') goto L17;
        r12 = r12.substring(1);
    L17:
    L10:
        e = move-exception;
        Log.w(f23757c, e);
        return r10;
    L8:
        if (r11.B() != null) goto L12;
        String r13 = LibrarianImpl.Constants.SEPARATOR;
    L13:
        return new URI(HttpHost.DEFAULT_SCHEME_NAME, r12, r13, null);
    L12:
        r13 = r11.B();     // Catch: URISyntaxException -> L10
        goto L13
    L19:
        return r10;
    }

    public static void l() {
        f23759e = "ttnetCookieStore";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI r10, c r11) {
        monitor-enter(this);
        URI r12 = d(r10, r11);     // Catch: Throwable -> L6
        Set r13 = (Set) this.f23761b.get(r12);     // Catch: Throwable -> L6
        SerializableHttpCookie r14 = new SerializableHttpCookie(r11);     // Catch: Throwable -> L6
        if (r13 != null) goto L8;
        r13 = new HashSet();     // Catch: Throwable -> L6
        this.f23761b.put(r12, r13);     // Catch: Throwable -> L6
    L9:
        r13.add(r14);     // Catch: Throwable -> L6
        j(r12, r14);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r13.remove(r14);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean b(String r10, String r11) {
        if (r11.equals(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r11.endsWith(LibrarianImpl.Constants.DOT + r10) == true) goto L8;
        return false;
    }

    public final boolean c(String r10, String r11) {
        if (r11.equals(r10) == false) goto L5;
        return true;
    L5:
        if (r11.startsWith(r10) == false) goto L9;
        if (r10.charAt(r10.length() - 1) != '/') goto L9;
        return true;
    L9:
        if (r11.startsWith(r10) == false) goto L14;
        if (r11.substring(r10.length()).charAt(0) != '/') goto L14;
        return true;
    L14:
        return false;
    }

    public final List e(URI r10) {
        ArrayList r11 = new ArrayList();
        Iterator r12 = this.f23761b.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        URI r13 = (URI) r12.next();
        if (b(r13.getHost(), r10.getHost()) == false) goto L4;
        if (c(r13.getPath(), r10.getPath()) == false) goto L4;
        r11.addAll((Collection) this.f23761b.get(r13));
        goto L4
    L10:
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r11.iterator();
    L12:
        if (r16.hasNext() == false) goto L18;
        SerializableHttpCookie r17 = (SerializableHttpCookie) r16.next();
        if (r17.hasExpired() == true) goto L15;
        r14.add(r17.getHttpCookie());
        goto L12
    L15:
        r15.add(r17);
        goto L12
    L18:
        if (r15.isEmpty() == true) goto L20;
        i(r10, r15);
    L20:
        return r14;
    }

    public final synchronized void f(Map r10, boolean r11) {
        monitor-enter(this);
        if (r10 != null) goto L33;
    L31:
        monitor-exit(this);
        return;
    L33:
    L28:
        th = move-exception;
        throw th;
    L5:
        if (r10.isEmpty() == true) goto L31;
        Iterator r12 = r10.entrySet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L14
        URI r14 = new URI(((String) r13.getKey()).split("\\|", 2)[0]);     // Catch: Throwable -> L14 URISyntaxException -> L16
        SerializableHttpCookie r15 = SerializableHttpCookie.decode((String) r13.getValue());     // Catch: Throwable -> L14 URISyntaxException -> L16
        Set r16 = (Set) this.f23761b.get(r14);     // Catch: Throwable -> L14 URISyntaxException -> L16
    L12:
        if (r16 != null) goto L18;
        r16 = new HashSet();     // Catch: Throwable -> L14 URISyntaxException -> L16
        this.f23761b.put(r14, r16);     // Catch: Throwable -> L14 URISyntaxException -> L16
    L18:
        if (r15 == null) goto L9;
        r16.add(r15);     // Catch: Throwable -> L14 URISyntaxException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L9
    L22:
        if (r11 == false) goto L26;
        w3.c.b(new a(this));     // Catch: Throwable -> L14
    L26:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        goto L26
    }

    public final void g() {
        this.f23760a.edit().clear().apply();
        f23758d.clear();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List get(URI r10) {
        monitor-enter(this);
        List r11 = e(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List getCookies() {
        monitor-enter(this);
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L8
        Iterator r11 = this.f23761b.keySet().iterator();     // Catch: Throwable -> L8
    L5:
        if (r11.hasNext() == false) goto L10;
        r10.addAll(e((URI) r11.next()));     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List getURIs() {
        monitor-enter(this);
        ArrayList r10 = new ArrayList(this.f23761b.keySet());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final void h(URI r10, SerializableHttpCookie r11) {
        SharedPreferences.Editor r12 = this.f23760a.edit();
        String r13 = r10.toString() + "|" + r11.getHttpCookie().A();
        r12.remove(r13);
        r12.apply();
        f23758d.remove(r13);
    }

    public final void i(URI r10, List r11) {
        SharedPreferences.Editor r12 = this.f23760a.edit();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r10.toString() + "|" + ((SerializableHttpCookie) r13.next()).getHttpCookie().A();
        r12.remove(r14);
        f23758d.remove(r14);
        goto L4
    L6:
        r12.apply();
    }

    public final void j(URI r10, SerializableHttpCookie r11) {
        String r12 = r10.toString() + "|" + r11.getHttpCookie().A();
        String r13 = r11.encode();
        if (r11.getHttpCookie().z() <= 0) goto L5;
        SharedPreferences.Editor r14 = this.f23760a.edit();
        r14.putString(r12, r13);
        r14.apply();
        return;
    L5:
        f23758d.put(r12, r13);
    }

    public final synchronized void k() {
        monitor-enter(this);
        Map r10 = this.f23761b;     // Catch: Throwable -> L19
        if (r10 != null) goto L6;
    L92:
        monitor-exit(this);
        return;
    L6:
        if (r10.isEmpty() == true) goto L92;
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L19
        Iterator r12 = this.f23761b.entrySet().iterator();     // Catch: Throwable -> L19
    L10:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L19
        if (r13 == null) goto L10;
        URI r14 = (URI) r13.getKey();     // Catch: Throwable -> L19
        if (r14.getScheme() == null) goto L10;
        if (r14.getScheme().equals("https") == false) goto L10;
        r11.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L19
        goto L10
    L22:
        if (r11.isEmpty() == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        Iterator r15 = r11.entrySet().iterator();     // Catch: Throwable -> L19
    L27:
        if (r15.hasNext() == false) goto L98;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L19
        if (r16 == null) goto L27;
        URI r17 = (URI) r16.getKey();     // Catch: Throwable -> L19
        Set r18 = (Set) r16.getValue();     // Catch: Throwable -> L19
        URI r19 = new URI(r17.toString().replace("https:", "http:"));     // Catch: Throwable -> L52
        Set r20 = (Set) this.f23761b.get(r19);     // Catch: Throwable -> L52
    L33:
        if (r20 == null) goto L64;
        if (r20.isEmpty() == true) goto L64;
        LinkedHashSet r21 = new LinkedHashSet();     // Catch: Throwable -> L52
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L52
    L39:
        if (r22.hasNext() == false) goto L56;
        SerializableHttpCookie r23 = (SerializableHttpCookie) r22.next();     // Catch: Throwable -> L52
        Iterator r24 = r18.iterator();     // Catch: Throwable -> L52
        boolean r25 = false;
    L42:
        if (r24.hasNext() == false) goto L54;
        SerializableHttpCookie r26 = (SerializableHttpCookie) r24.next();     // Catch: Throwable -> L52
        if (r23 == null) goto L42;
        if (r26 == null) goto L42;
        if (r23.getHttpCookie().equals(r26.getHttpCookie()) == false) goto L42;
        if (r26.getWhenCreated().longValue() < r23.getWhenCreated().longValue()) goto L42;
        r21.add(r26);     // Catch: Throwable -> L52
        r25 = true;
        goto L42
    L54:
        if (r25 == true) goto L39;
        r21.add(r23);     // Catch: Throwable -> L52
        goto L39
    L56:
        Iterator r27 = r18.iterator();     // Catch: Throwable -> L52
    L58:
        if (r27.hasNext() == false) goto L63;
        SerializableHttpCookie r28 = (SerializableHttpCookie) r27.next();     // Catch: Throwable -> L52
        if (r21.contains(r28) == true) goto L58;
        r21.add(r28);     // Catch: Throwable -> L52
        goto L58
    L63:
        this.f23761b.remove(r17);     // Catch: Throwable -> L52
        this.f23761b.put(r19, r21);     // Catch: Throwable -> L52
    L64:
        this.f23761b.remove(r17);     // Catch: Throwable -> L52
        this.f23761b.put(r19, r18);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        goto L27
    L98:
        Map r29 = this.f23761b;     // Catch: Throwable -> L82
        if (r29 != null) goto L71;
    L87:
        monitor-exit(this);
        return;
    L71:
        if (r29.isEmpty() == true) goto L87;
        SharedPreferences.Editor r30 = this.f23760a.edit();     // Catch: Throwable -> L82
        r30.clear();     // Catch: Throwable -> L82
        Iterator r31 = this.f23761b.entrySet().iterator();     // Catch: Throwable -> L82
    L75:
        if (r31.hasNext() == false) goto L85;
        Map.Entry r32 = (Map.Entry) r31.next();     // Catch: Throwable -> L82
        URI r33 = (URI) r32.getKey();     // Catch: Throwable -> L82
        Iterator r34 = ((Set) r32.getValue()).iterator();     // Catch: Throwable -> L82
    L78:
        if (r34.hasNext() == false) goto L75;
        SerializableHttpCookie r35 = (SerializableHttpCookie) r34.next();     // Catch: Throwable -> L82
        String r36 = r33.toString() + "|" + r35.getHttpCookie().A();     // Catch: Throwable -> L82
        String r37 = r35.encode();     // Catch: Throwable -> L82
        if (r35.getHttpCookie().z() > 0) goto L81;
        f23758d.put(r36, r37);     // Catch: Throwable -> L82
        goto L78
    L81:
        r30.putString(r36, r37);     // Catch: Throwable -> L82
        goto L78
    L85:
        SharedPrefsEditorCompat.a(r30);     // Catch: Throwable -> L82
    L90:
        monitor-exit(this);
        return;
    L82:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean remove(URI r10, c r11) {
        monitor-enter(this);
        Set r12 = (Set) this.f23761b.get(r10);     // Catch: Throwable -> L6
        SerializableHttpCookie r13 = new SerializableHttpCookie(r11);     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        boolean r14 = r12.remove(r13);     // Catch: Throwable -> L6
    L9:
        if (r14 == false) goto L11;
        h(r10, r13);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return r14;
    L8:
        r14 = false;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        monitor-enter(this);
        this.f23761b.clear();     // Catch: Throwable -> L7
        g();     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    }
}
