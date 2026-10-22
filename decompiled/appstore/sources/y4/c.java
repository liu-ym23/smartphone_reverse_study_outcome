package y4;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.librarian.LibrarianImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f26105h = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f26107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f26108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f26109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f26110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set f26111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f26112g;

    static {
    }

    public c(int r10) {
        this.f26108c = false;
        this.f26109d = new HashSet();
        this.f26110e = new HashSet();
        this.f26111f = new HashSet();
        this.f26112g = new HashSet();
        this.f26106a = r10;
        this.f26107b = r10;
    }

    public static c a(String r10, int r11, int r12, JSONObject r13) {
        if (r10.equals("rm") == false) goto L6;
        c r14 = new f(r11);
    L8:
        r14.h(r13);
        r14.l(r12);
        return r14;
    L6:
        if (r10.equals("encrypt") == false) goto L10;
        r14 = new b(r11);
        goto L8
    L10:
        return null;
    }

    public static boolean f(Set r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static void j(JSONArray r10, Set r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L23;
        int r12 = 0;
    L16:
        if (r12 >= r10.length()) goto L25;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r13) == true) goto L12;
        r11.add(Pattern.compile(r13, 2));     // Catch: Throwable -> L14
    L12:
        r12 = r12 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    public abstract boolean b(g6.b r10, Map r11);

    public final boolean c(g6.b r10, Map r11) {
        if (e(r10) == true) goto L7;
        return false;
    L7:
        return b(r10, r11);
    }

    public int d() {
        return this.f26106a;
    }

    public final boolean e(g6.b r10) {
        if (r10.A() <= this.f26106a) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean g(g6.b r10) {
        if (f(this.f26109d) == true) goto L11;
        Iterator r11 = this.f26109d.iterator();
    L7:
        if (r11.hasNext() == false) goto L48;
        if (i.i(r10.v(), (String) r11.next()) == false) goto L7;
    L48:
        Logger.d(f26105h, "Domain not match: " + r10.v());
        return false;
    L11:
        if (this.f26108c == true) goto L13;
    L15:
        String r12 = r10.z();
        if (TextUtils.isEmpty(r12) == false) goto L19;
        Logger.d(f26105h, "Path is empty: " + r12);
        return false;
    L19:
        int r13 = r12.length();
        if (r13 <= 1) goto L25;
        int r14 = r13 - 1;
        if (r12.substring(r14).equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L25;
        r12 = r12.substring(0, r14);
    L25:
        if (f(this.f26110e) == true) goto L30;
        if (this.f26110e.contains(r12) == false) goto L30;
        return true;
    L30:
        if (f(this.f26111f) == true) goto L38;
        Iterator r15 = this.f26111f.iterator();
    L33:
        if (r15.hasNext() == false) goto L38;
        if (r12.startsWith((String) r15.next()) == false) goto L33;
        return true;
    L38:
        if (f(this.f26112g) == true) goto L47;
        Iterator r16 = this.f26112g.iterator();
    L41:
        if (r16.hasNext() == false) goto L47;
        Pattern r17 = (Pattern) r16.next();
        if (r17 == null) goto L41;
        if (r17.matcher(r12).matches() == false) goto L41;
        return true;
    L47:
        return false;
    L13:
        if (e.f().f26121c.get() == true) goto L15;
        return false;
    }

    public abstract void h(JSONObject r10);

    public void i(JSONObject r10) {
        k(r10.optJSONArray("host_group"), this.f26109d);
        k(r10.optJSONArray("equal_group"), this.f26110e);
        k(r10.optJSONArray("prefix_group"), this.f26111f);
        j(r10.optJSONArray("pattern_group"), this.f26112g);
    }

    public final void k(JSONArray r10, Set r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r10.length()) goto L21;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r11.add(r13);     // Catch: JSONException -> L13
    L11:
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void l(int r10) {
        this.f26107b = r10;
    }

    public boolean m(g6.b r10, Map r11, List r12) {
        a r13 = new a();
        r13.g(SystemClock.uptimeMillis());
        boolean r14 = c(r10, r11);
        if (r14 == false) goto L5;
        r10.P(this.f26107b);
    L5:
        r13.e(r14);
        r13.f(this.f26106a);
        r13.d(SystemClock.uptimeMillis());
        r12.add(r13);
        return r14;
    }
}
