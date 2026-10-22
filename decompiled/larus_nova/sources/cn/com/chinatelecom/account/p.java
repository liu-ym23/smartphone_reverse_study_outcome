package cn.com.chinatelecom.account;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.Helper;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class p extends d {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f24435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f24436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f24437c;

        public a(Context r100, List r101, int r102) {
            this.f24435a = r100;
            this.f24436b = r101;
            this.f24437c = r102;
        }

        public void cn_com_chinatelecom_account_p$a__run$___twin___() {
            Queue r100 = p.a(this.f24435a, this.f24436b, this.f24437c);     // Catch: Throwable -> L20
            if (r100.isEmpty() == true) goto L28;
            String r101 = p.a(this.f24435a, r100);     // Catch: Throwable -> L20
            JSONObject r102 = null;
            int r103 = -1;
        L13:
            e = e;
        L14:
            e.printStackTrace();     // Catch: Throwable -> L20
        L15:
            if (r102 == null) goto L18;
            if (r103 != 0) goto L18;
            p.a(this.f24435a);     // Catch: Throwable -> L20
            r100.clear();     // Catch: Throwable -> L20
            return;
        L18:
            p.a(this.f24435a, r100, this.f24437c);     // Catch: Throwable -> L20
            return;
        L7:
            if (TextUtils.isEmpty(r101) == true) goto L15;
            JSONObject r104 = new JSONObject(r101);     // Catch: Exception -> L13 Throwable -> L20
            r103 = r104.getInt("code");     // Catch: Exception -> L11 Throwable -> L20
            r102 = r104;
        L11:
            e = e;
            r102 = r104;
            goto L14
        L28:
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // java.lang.Runnable
        public void run() {
            cn_com_chinatelecom_account_p$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void cn_com_chinatelecom_account_p$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.cn_com_chinatelecom_account_p$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private static String a(Context r100, String r101) {
        return l.a(r100, r.c(), r101);
    }

    public static /* synthetic */ String a(Context r100, Queue r101) {
        return b(r100, r101);
    }

    public static /* synthetic */ Queue a(Context r100, List r101, int r102) {
        return c(r100, r101, r102);
    }

    public static /* synthetic */ void a(Context r100) {
        b(r100);
    }

    private static void a(Context r100, int r101) {
        h.b(r100, "key_c_l_l_v", r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(Context r100, List<String> r101) {
        int r102 = c(r100);
        if (r102 != (-2)) goto L5;
        return;
    L5:
        b(r100, r101, r102);
    }

    public static /* synthetic */ void a(Context r100, Queue r101, int r102) {
        b(r100, r101, r102);
    }

    private static String b(Context r100, Queue<String> r101) {
        JSONArray r102 = new JSONArray();
        String r103 = r102.toString();
        if (r101.isEmpty() == true) goto L13;
        Iterator<String> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        r102.put(new JSONObject(r104.next()));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        if (r102.length() > 0) goto L16;
        return "";
    L16:
        String r105 = r102.toString();
        if (TextUtils.isEmpty(r105) == true) goto L23;
        r103 = URLEncoder.encode(Helper.guulam(r100, r105), "UTF-8");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L23:
        return a(r100, r103);
    }

    private static void b(Context r100) {
        o.a(r100, "");
    }

    public static void b(Context r100, String r101) {
        r101.getClass();
        if (r101.equals("OFF") == false) goto L5;
        int r102 = -2;
    L9:
        a(r100, r102);
        return;
    L5:
        if (r101.equals("ERROR") == true) goto L7;
        r102 = 0;
        goto L9
    L7:
        r102 = -1;
        goto L9
    }

    private static void b(Context r100, List<String> r101, int r102) {
        d.a(new a(r100, r101, r102));
    }

    private static void b(Context r100, Queue<String> r101, int r102) {
        JSONArray r103 = new JSONArray();
        if (r101 == null) goto L22;
        if (r101.isEmpty() == true) goto L22;
        Iterator<String> r104 = r101.iterator();
        int r105 = 0;
    L8:
        if (r104.hasNext() == false) goto L22;
        JSONObject r106 = new JSONObject(r104.next());     // Catch: Exception -> L17
        if (r102 != (-1)) goto L15;
        if (JSONObjectProtectorUtils.getInt(r106, "rt") == 0) goto L8;
    L15:
        r103.put(r106);     // Catch: Exception -> L17
    L19:
        r105 = r105 + 1;
        if (r105 <= 10) goto L8;
    L17:
        e = move-exception;
        e.printStackTrace();
    L22:
        if (r103.length() > 0) goto L32;
        String r107 = "";
    L29:
        if (TextUtils.isEmpty(r107) == true) goto L44;
        o.a(r100, r107);
        return;
    L44:
        return;
    L32:
        r107 = Helper.eneulret(r103.toString());     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        r107 = null;
        goto L29
    }

    private static int c(Context r100) {
        return h.a(r100, "key_c_l_l_v", 0);
    L5:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    private static synchronized Queue<String> c(Context r100, List<String> r101, int r102) {
        monitor-enter(p.class);
        ConcurrentLinkedQueue r103 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L38
        String r104 = o.c(r100);     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r104) == true) goto L19;
        JSONArray r105 = new JSONArray(new String(Helper.dneulret(b0.a(r104))));     // Catch: Exception -> L16 Throwable -> L38
        int r106 = r105.length();     // Catch: Exception -> L16 Throwable -> L38
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L14;
        if (r107 > 10) goto L14;
        JSONObject r108 = JSONArrayProtectorUtils.getJSONObject(r105, r107);     // Catch: Exception -> L16 Throwable -> L38
        if (r108 == null) goto L13;
        r103.add(r108.toString());     // Catch: Exception -> L16 Throwable -> L38
    L13:
        r107 = r107 + 1;     // Catch: Exception -> L16 Throwable -> L38
    L14:
        o.a(r100, "");     // Catch: Exception -> L16 Throwable -> L38
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L38
    L19:
        if (r102 != (-1)) goto L30;
        Iterator<String> r109 = r101.iterator();     // Catch: Throwable -> L38
    L22:
        if (r109.hasNext() == false) goto L32;
        String r110 = r109.next();     // Catch: Throwable -> L38
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L38
        goto L22
    L25:
        if (JSONObjectProtectorUtils.getInt(new JSONObject(r110), "rt") == 0) goto L22;
        r103.add(r110);     // Catch: Exception -> L28 Throwable -> L38
    L32:
        if (r103.size() <= 10) goto L36;
        r103.poll();     // Catch: Throwable -> L38
        goto L32
    L36:
        monitor-exit(p.class);
        return r103;
    L30:
        if (r102 != 0) goto L32;
        r103.addAll(r101);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }
}
