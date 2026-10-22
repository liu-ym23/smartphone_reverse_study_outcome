package l6;

import com.bytedance.common.utility.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f21879a;

    public class a extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f21880e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f21881f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f21882g;

        public a(e r10, String r11, String r12, String r13) {
            this.f21882g = r10;
            this.f21880e = r12;
            this.f21881f = r13;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            e.a(this.f21882g, this.f21880e, this.f21881f);
        }
    }

    public e() {
    }

    public static /* synthetic */ void a(e r10, String r11, String r12) {
        r10.b(r11, r12);
    }

    public static e c() {
        if (f21879a != null) goto L16;
        monitor-enter(e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21879a != null) goto L11;
        f21879a = new e();     // Catch: Throwable -> L9
    L11:
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L16:
        return f21879a;
    }

    public final void b(String r10, String r11) {
        CookieHandler r12 = CookieHandler.getDefault();
        if (r12 != null) goto L6;
        Logger.e("ShareCookieHostsSync", "Default CookieHandler is null.");
        return;
    L6:
        List r13 = e(r10);
        List r14 = e(r11);
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r14.iterator();
    L8:
        if (r17.hasNext() == false) goto L14;
        String r18 = (String) r17.next();
        if (com.bytedance.ttnet.utils.c.a(r18, r13) == true) goto L11;
        Logger.d("ShareCookieHostsSync", "added hosts add: " + r18);
        r16.add(r18);
        goto L8
    L11:
        Logger.d("ShareCookieHostsSync", "kept hosts add: " + r18);
        r15.add(r18);
        goto L8
    L14:
        if (r16.isEmpty() == false) goto L17;
        return;
    L17:
        if (r15.isEmpty() == false) goto L20;
        r15 = r16;
    L20:
        Map<String, List<String>> r19 = new HashMap();
        Iterator r110 = r15.iterator();
    L22:
        if (r110.hasNext() == false) goto L30;
        String r20 = (String) r110.next();
        r19 = r12.get(new URI("https://" + r20 + LibrarianImpl.Constants.SEPARATOR), null);     // Catch: Throwable -> L28
        if (r19.size() <= 0) goto L22;
        Logger.d("ShareCookieHostsSync", "Sync cookie from host: " + r20 + " sync cookies: " + r19.toString());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L30:
        if (r19 != null) goto L32;
        return;
    L32:
        if (r19.isEmpty() == true) goto L86;
        List<String> r111 = r19.get("Cookie");
        if (r111 != null) goto L37;
    L38:
        r111 = r19.get("cookie");
        if (r111 != null) goto L41;
        return;
    L41:
        if (r111.isEmpty() == true) goto L87;
    L43:
        LinkedHashMap r112 = new LinkedHashMap();
        List r21 = f(r111);
        Iterator r113 = r16.iterator();
    L45:
        if (r113.hasNext() == false) goto L88;
        String r22 = (String) r113.next();
        ArrayList r23 = new ArrayList();
        URI r24 = new URI("https://" + r22 + LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L53
        Iterator r25 = r21.iterator();     // Catch: Throwable -> L53
    L49:
        if (r25.hasNext() == false) goto L55;
        String r26 = (String) r25.next();     // Catch: Throwable -> L53
        if (com.bytedance.common.utility.e.b(r26) == true) goto L49;
        r23.add(r26 + "; Domain=" + r22);     // Catch: Throwable -> L53
        goto L49
    L55:
        r112.put("Set-Cookie", r23);     // Catch: Throwable -> L53
        r12.put(r24, r112);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        th.printStackTrace();
        goto L45
    L88:
        return;
    L87:
        return;
    L37:
        if (r111.isEmpty() == false) goto L43;
    }

    public void d(String r10, String r11) {
        if (r11.equals(r10) == false) goto L5;
        return;
    L5:
        new a(this, "Sync-Cookie", r10, r11).a();
    }

    public final List e(String r10) {
        ArrayList r11 = new ArrayList();
        if (com.bytedance.common.utility.e.b(r10) == false) goto L5;
        return r11;
    L5:
        String[] r12 = r10.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = r12[r14];
        if (com.bytedance.common.utility.e.b(r15) == true) goto L10;
        r11.add(r15.trim());
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        return r11;
    }

    public final List f(List r10) {
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        String[] r13 = ((String) r12.next()).split(";");
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        String r16 = r13[r15];
        if (com.bytedance.common.utility.e.b(r16) == true) goto L10;
        r11.add(r16.trim());
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r11;
    }
}
