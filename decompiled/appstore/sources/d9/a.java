package d9;

import android.text.TextUtils;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.tracker.TrackerElement;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.bytedanceos.common.ui.recycler.entity.ReportItem;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements TrackerElement {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f19123c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19125b;

    /* JADX INFO: renamed from: d9.a$a, reason: collision with other inner class name */
    public static class C0234a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f19127b;

        public C0234a(String r10) {
            this.f19126a = r10;
            this.f19127b = new JSONObject();
        }

        public static C0234a a(String r10) {
            return new C0234a(r10);
        }

        public String b() {
            JSONObject r10 = this.f19127b;
            if (r10 != null) goto L6;
            return "";
        L6:
            return r10.toString();
        }

        public String c() {
            return this.f19126a;
        }

        public C0234a d(String r10, Object r11) {
            this.f19127b.put(r10, r11);     // Catch: Exception -> L4
        L6:
            return this;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }

        public C0234a e(String r10, String r11) {
            this.f19127b.put(r10, r11);     // Catch: Exception -> L4
        L6:
            return this;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }

        public C0234a f(String r10, int r11) {
            this.f19127b.put(r10, r11);     // Catch: Exception -> L4
        L6:
            return this;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }
    }

    static {
    }

    public a() {
        this.f19124a = "0101";
        this.f19125b = "0102";
    }

    public static String a(String r10, String r11, String r12) {
        String r13 = r11 + "," + r12;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r13;
    L6:
        return r10 + ";" + r13;
    }

    public static void b(StringBuilder r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10.toString()) == true) goto L5;
        r10.append(";");
    L5:
        r10.append(r11);
        r10.append(",");
        r10.append(r12);
    }

    public static a e() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f19123c != null) goto L9;
        f19123c = new a();     // Catch: Throwable -> L7
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return f19123c;
    }

    public void A(String r10, boolean r11) {
        C0234a r12 = C0234a.a("0084");     // Catch: Exception -> L4
        r12.e("pkg_name", r10);     // Catch: Exception -> L4
        r12.f("source_page", !r11 ? 1 : 0);     // Catch: Exception -> L4
        O(r12);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void B(int r10, int r11, Object[] r12, Map r13) {
        switch(r11) {
            case 100001: goto L35;
            case 200001: goto L34;
            case 200002: goto L33;
            case 300001: goto L32;
            case 300002: goto L31;
            case 300003: goto L30;
            case 400001: goto L29;
            case 400002: goto L22;
            case 400003: goto L15;
            case 500002: goto L14;
            case 700011: goto L13;
            case 1100000: goto L12;
            case 1200000: goto L11;
            case 1400001: goto L10;
            case 1400002: goto L9;
            case 2000002: goto L5;
            case 2000003: goto L15;
            default: goto L69;
        };
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.size() <= 0) goto L45;
        String r14 = (String) r13.get("cid");
        O(C0234a.a("9026").e(TrackerElement.CATEGORY_APP_TOP, r14));
        return;
    L45:
        return;
    L9:
        P("9016");
        return;
    L10:
        P("9015");
        return;
    L11:
        P("9000");
        return;
    L12:
        P("9022");
        return;
    L13:
        n("9021");
        return;
    L14:
        n("9024");
        return;
    L15:
        if (r12 != null) goto L17;
        return;
    L17:
        if (r12.length <= 1) goto L54;
        if (r13 != null) goto L20;
        return;
    L20:
        if (r13.isEmpty() == true) goto L56;
        String r15 = (String) r13.get("page");
        return;
    L56:
        return;
    L54:
        return;
    L22:
        if (r12 != null) goto L24;
        return;
    L24:
        if (r12.length <= 0) goto L59;
        if (r13 != null) goto L27;
        return;
    L27:
        if (r13.isEmpty() == true) goto L61;
        String r16 = (String) r13.get("page");
        return;
    L61:
        return;
    L59:
        return;
    L29:
        P("9005");
        return;
    L30:
        w("9004", r13);
        return;
    L31:
        w("9003", r13);
        return;
    L32:
        w("9002", r13);
        return;
    L33:
        P("9012");
        return;
    L34:
        P("9013");
        return;
    L35:
        if (r13 != null) goto L37;
    L41:
        String r17 = "9001";
    L42:
        w(r17, r13);
        return;
    L37:
        if ("1".equalsIgnoreCase((String) r13.get("page_from")) == false) goto L41;
        if (r10 != 3) goto L41;
        r17 = "9019";
        goto L42
    }

    public void C(String r10, int r11) {
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L4
        r12.put(AppPermissionActivity.EXTRA_APP_PKG, r10);     // Catch: Exception -> L4
        r12.put("type", r11);     // Catch: Exception -> L4
        b.b().f(TrackerElement.OS_PACKAGE_ADD_REMOVE_ENENT_ID, r12.toString());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void D(String r10) {
        C0234a r11 = C0234a.a("9029");
        r11.e(TrackerElement.PACKAGE_NAME, r10);
        O(r11);
    }

    public void E(int r10, int r11) {
        O(C0234a.a(TrackerElement.NET_AD).f("position", r11).f("type", r10));
    }

    public void F(String r10, String r11, String r12) {
        C0234a r13 = C0234a.a("0094");     // Catch: Exception -> L4
        r13.e(TrackerElement.GAME_NAME, r10);     // Catch: Exception -> L4
        r13.e("category", r11);     // Catch: Exception -> L4
        r13.e("online_time", r12);     // Catch: Exception -> L4
        O(r13);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void G(String r10, int r11) {
        C0234a r12 = C0234a.a(r10);
        r12.d("source_page", Integer.valueOf(r11));
        O(r12);
    }

    public void H(int r10) {
        C0234a r11 = C0234a.a("0074");     // Catch: Exception -> L4
        r11.e("download_count", String.valueOf(r10));     // Catch: Exception -> L4
        O(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void I(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        O(C0234a.a("0068").e("keyword", r10));
        return;
    }

    public void J(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        O(C0234a.a(TrackerElement.SEARCH_HISTORY_WORDS).e("keyword", r10));
        return;
    }

    public void K(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        O(C0234a.a(TrackerElement.SEARCH_HOT_WORDS).e("keyword", r10));
        return;
    }

    public void L(int r10, int r11) {
        C0234a r12 = C0234a.a("0072");
        r12.f("type", r10);
        r12.f("position", r11);
        O(r12);
    }

    public void M(String r10, String r11, boolean r12) {
        if (r12 == false) goto L5;
        O(C0234a.a(TrackerElement.SEARCH_RESULT_ENTER).e(TrackerElement.INPUT_CONTENT, r11));
        return;
    L5:
        if (r10 == null) goto L9;
        O(C0234a.a(TrackerElement.SEARCH_RESULT).e(TrackerElement.SEARCH_CONTENT, r10).e(TrackerElement.INPUT_CONTENT, r11));
        return;
    }

    public void N(String r10, boolean r11) {
        C0234a r12 = C0234a.a("0087");     // Catch: Exception -> L4
        r12.e("title", r10);     // Catch: Exception -> L4
        r12.f("type", !r11 ? 1 : 0);     // Catch: Exception -> L4
        O(r12);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final void O(C0234a r10) {
        b.b().d(r10);
    }

    public void P(String r10) {
        b.b().e(d(r10));
    }

    public void Q(String r10, String r11) {
        O(h(C0234a.a(r10), r11));
    }

    public void R(String r10, Map r11) {
        C0234a r12 = C0234a.a(r10);     // Catch: Exception -> L6
        Iterator r13 = r11.entrySet().iterator();     // Catch: Exception -> L6
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Exception -> L6
        r12.e((String) r14.getKey(), (String) r14.getValue());     // Catch: Exception -> L6
        goto L4
    L8:
        O(r12);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void S(boolean r10, String r11) {
        if (r10 == false) goto L4;
        String r12 = "0060";
    L5:
        C0234a r13 = C0234a.a(r12);
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r13.e("pkg_name", r11);
    L8:
        O(r13);
        return;
    L4:
        r12 = "0061";
        goto L5
    }

    public void c() {
        b.b().a();
    }

    public final String d(String r10) {
        return r10;
    }

    public void f() {
        b.b().g();
    }

    public void g(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        b.b().j(C0234a.a(TrackerElement.LAUNCH_STATUS).f(TrackerElement.ISLOGIN, r10).f(TrackerElement.PUSH_MSG, r11).f(TrackerElement.UPDATE_MSG, r12).f(TrackerElement.AUTO_UPDATE, r13).f(TrackerElement.DESK_PROMOTE, r14).f(TrackerElement.NOTICE_PROMOTE, r15).f(TrackerElement.SAVE_TRAFFIC, r16));
    }

    public final C0234a h(C0234a r10, String r11) {
        if (r10 != null) goto L25;
        return null;
    L25:
        String[] r12 = r11.split(";");     // Catch: Exception -> L19
        if (r12 != null) goto L9;
    L24:
        return r10;
    L9:
        if (r12.length <= 0) goto L24;
        int r13 = r12.length;     // Catch: Exception -> L19
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L24;
        String r15 = r12[r14];     // Catch: Exception -> L19
        if (r15.contains(",") == false) goto L22;
        String[] r16 = r15.split(",");     // Catch: Exception -> L19
        if (r16.length != 2) goto L22;
        if (TextUtils.equals(r16[0], DownloadInfoColumns.APP_SOURCE) == false) goto L21;
        r10.f(r16[0], Integer.parseInt(r16[1]));     // Catch: Exception -> L19
        goto L22
    L21:
        r10.e(r16[0], r16[1]);     // Catch: Exception -> L19
    L22:
        r14 = r14 + 1;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public void i(String r10, boolean r11) {
        if (TextUtils.equals(r10, "0038") == false) goto L5;
    L10:
        O(C0234a.a(r10).f(TrackerElement.INSTALL, r11 ? 1 : 0));
        return;
    L5:
        if (TextUtils.equals(r10, "0040") == true) goto L10;
        if (TextUtils.equals(r10, "0039") == false) goto L12;
        O(C0234a.a(r10).f("type", r11 ? 1 : 0));
        return;
    }

    public void j(boolean r10, boolean r11, String r12) {
        C0234a r13 = C0234a.a("0062");
        r13.f(TrackerElement.ISLOGIN, r10 ? 1 : 0);
        r13.f(TrackerElement.INSTALL, r11 ? 1 : 0);
        r13.e("pkg_name", r12);
        O(r13);
    }

    public void k(String r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put("pkg_name", r10);     // Catch: Exception -> L4
        b.b().k(TrackerElement.OS_ALL_APP_LISTS_ENENT_ID, r11.toString());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void l(Topic r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = r10.getLocation();
        StringBuilder r13 = new StringBuilder();
        if (r12 != 0) goto L7;
        int r14 = 1;
    L8:
        r13.append(r14);
        r13.append("-");
        r13.append(r11 + 1);
        m("tab_featured".equals(e.W(e.f10020b)), r13.toString(), r10.getTitle());
        return;
    L7:
        r14 = r12 + 2;
        goto L8
    }

    public void m(boolean r10, String r11, String r12) {
        if (r10 == false) goto L4;
        String r13 = this.f19124a;
    L5:
        C0234a r14 = C0234a.a(r13);
        r14.e("location", r11);
        r14.e(TrackerElement.BANNER_NAME, r12);
        O(r14);
        return;
    L4:
        r13 = this.f19125b;
        goto L5
    }

    public void n(String r10) {
        P(r10);
    }

    public void o(int r10) {
        O(C0234a.a("0042").f("type", r10));
    }

    public void p(boolean r10, String r11) {
        if (r10 == false) goto L4;
        String r12 = TrackerElement.DOWNLOAD_SUCCESS;
    L5:
        O(h(C0234a.a(r12), r11));
        return;
    L4:
        r12 = TrackerElement.DOWNLOAD_FAILED;
        goto L5
    }

    public void q(String r10, String r11) {
        C0234a r12 = C0234a.a(r10);
        r12.e("type", r11);
        O(r12);
    }

    public void r(int r10) {
        C0234a r11 = C0234a.a("0100");     // Catch: Exception -> L4
        r11.d(TrackerElement.CHECK_TYPE, Integer.valueOf(r10));     // Catch: Exception -> L4
        O(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void s(JSONArray r10, JSONArray r11, int r12, int r13) {
        C0234a r14 = C0234a.a("0099");     // Catch: Exception -> L4
        r14.d(TrackerElement.POSITIONS, r10);     // Catch: Exception -> L4
        r14.d(TrackerElement.PKG_NAME_S, r11);     // Catch: Exception -> L4
        r14.d(TrackerElement.TOTAL_NUM_S, Integer.valueOf(r11.length()));     // Catch: Exception -> L4
        r14.d(TrackerElement.INSTALL_TYPE, Integer.valueOf(r12));     // Catch: Exception -> L4
        r14.d(TrackerElement.CHECK_TYPE, Integer.valueOf(r13));     // Catch: Exception -> L4
        O(r14);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void t(SubAppEntity r10, ReportItem r11, String r12) {
        String r13 = "";
        if (r10 != null) goto L5;
        String r14 = "";
    L6:
        if (r11 != null) goto L8;
        String r15 = "";
    L9:
        if (r10 != null) goto L11;
        String r16 = "";
    L12:
        if (r10 == null) goto L15;
        r13 = e.T(r10.getOnline_time());
    L15:
        u(r14, r15, r16, r13, r12);
        return;
    L11:
        r16 = r10.getCategory();
        goto L12
    L8:
        r15 = r11.getOrder();
        goto L9
    L5:
        r14 = r10.getName();
        goto L6
    }

    public void u(String r10, String r11, String r12, String r13, String r14) {
        C0234a r15 = C0234a.a("0092");     // Catch: Exception -> L4
        r15.e(TrackerElement.GAME_NAME, r10);     // Catch: Exception -> L4
        r15.e(TrackerElement.ORDER, r11);     // Catch: Exception -> L4
        r15.e("category", r12);     // Catch: Exception -> L4
        r15.e("online_time", r13);     // Catch: Exception -> L4
        r15.e(TrackerElement.CLICK_TYPE, r14);     // Catch: Exception -> L4
        O(r15);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void v(boolean r10, String r11) {
        if (r10 == false) goto L4;
        String r12 = TrackerElement.INSTALL_SUCCESS;
    L5:
        O(h(C0234a.a(r12), r11));
        return;
    L4:
        r12 = TrackerElement.INSTALL_FAILED;
        goto L5
    }

    public final void w(String r10, Map r11) {
        String r12 = (String) r11.get("page");
    }

    public void x(String r10, Map r11) {
        C0234a r12 = C0234a.a(r10);
        Iterator r13 = r11.keySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = (String) r13.next();
        r12.e(r14, (String) r11.get(r14));
        goto L4
    L6:
        O(r12);
    }

    public void y(String r10, int r11) {
        C0234a r12 = C0234a.a("0079");
        r12.f("source_page", r11);
        r12.e("pkg_name", r10);
        O(r12);
    }

    public void z(String r10, boolean r11, boolean r12) {
        C0234a r13 = C0234a.a("0085");     // Catch: Exception -> L4
        r13.e("pkg_name", r10);     // Catch: Exception -> L4
        r13.f("type", !r11 ? 1 : 0);     // Catch: Exception -> L4
        r13.f("source_page", !r12 ? 1 : 0);     // Catch: Exception -> L4
        O(r13);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
