package r4;

import com.bytedance.frameworks.baselib.network.http.impl.CookieStore;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class b implements CookieStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23733a;

    public b() {
        this.f23733a = new HashMap();
    }

    public final URI a(URI r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return new URI(HttpHost.DEFAULT_SCHEME_NAME, r10.getHost(), null, null);
    L7:
        return r10;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI r10, c r11) {
        monitor-enter(this);
        if (r11 == null) goto L14;
        URI r12 = a(r10);     // Catch: Throwable -> L7
        List r13 = (List) this.f23733a.get(r12);     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        r13 = new ArrayList();     // Catch: Throwable -> L7
        this.f23733a.put(r12, r13);     // Catch: Throwable -> L7
    L10:
        r13.add(r11);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L9:
        r13.remove(r11);     // Catch: Throwable -> L7
        goto L10
    L14:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List get(URI r10) {
        monitor-enter(this);
        if (r10 == null) goto L37;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L12
        List r12 = (List) this.f23733a.get(r10);     // Catch: Throwable -> L12
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L12
    L8:
        if (r13.hasNext() == false) goto L15;
        c r14 = (c) r13.next();     // Catch: Throwable -> L12
        if (r14.G() == true) goto L11;
        r11.add(r14);     // Catch: Throwable -> L12
        goto L8
    L11:
        r13.remove();     // Catch: Throwable -> L12
    L15:
        Iterator r15 = this.f23733a.entrySet().iterator();     // Catch: Throwable -> L12
    L17:
        if (r15.hasNext() == false) goto L33;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L12
        if (r10.equals(r16.getKey()) == true) goto L17;
        Iterator r17 = ((List) r16.getValue()).iterator();     // Catch: Throwable -> L12
    L23:
        if (r17.hasNext() == false) goto L17;
        c r18 = (c) r17.next();     // Catch: Throwable -> L12
        if (c.s(r18.x(), r10.getHost()) == false) goto L23;
        if (r18.G() == true) goto L29;
        if (r11.contains(r18) == true) goto L23;
        r11.add(r18);     // Catch: Throwable -> L12
        goto L23
    L29:
        r17.remove();     // Catch: Throwable -> L12
        goto L23
    L33:
        List r19 = Collections.unmodifiableList(r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r19;
    L37:
        throw new NullPointerException("uri == null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List getCookies() {
        monitor-enter(this);
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L12
        Iterator r11 = this.f23733a.values().iterator();     // Catch: Throwable -> L12
    L5:
        if (r11.hasNext() == false) goto L17;
        Iterator r12 = ((List) r11.next()).iterator();     // Catch: Throwable -> L12
    L8:
        if (r12.hasNext() == false) goto L5;
        c r13 = (c) r12.next();     // Catch: Throwable -> L12
        if (r13.G() == true) goto L11;
        if (r10.contains(r13) == true) goto L8;
        r10.add(r13);     // Catch: Throwable -> L12
        goto L8
    L11:
        r12.remove();     // Catch: Throwable -> L12
        goto L8
    L17:
        List r14 = Collections.unmodifiableList(r10);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r14;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List getURIs() {
        monitor-enter(this);
        ArrayList r10 = new ArrayList(this.f23733a.keySet());     // Catch: Throwable -> L6
        r10.remove(null);     // Catch: Throwable -> L6
        List r11 = Collections.unmodifiableList(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean remove(URI r10, c r11) {
        monitor-enter(this);
        if (r11 == null) goto L15;
        List r12 = (List) this.f23733a.get(a(r10));     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        boolean r13 = r12.remove(r11);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r13;
    L11:
        monitor-exit(this);
        return false;
    L15:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        monitor-enter(this);
        boolean r10 = !this.f23733a.isEmpty();     // Catch: Throwable -> L6
        this.f23733a.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
