package cn.com.chinatelecom.account;

import android.content.Context;
import cn.com.chinatelecom.account.api.CtAuth;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f24438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, n> f24439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<n> f24440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static n f24441d;

    /* JADX INFO: loaded from: classes28.dex */
    public class a extends TimerTask {
        public a() {
        }

        public void cn_com_chinatelecom_account_q$a__run$___twin___() {
            q.a(CtAuth.mContext);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cn_com_chinatelecom_account_q$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void cn_com_chinatelecom_account_q$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.cn_com_chinatelecom_account_q$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f24439b = new HashMap();
        f24440c = new ArrayList();
        f24441d = null;
    }

    public q() {
    }

    public static /* synthetic */ void a(Context r100) {
        b(r100);
    }

    public static void a(Context r100, String r101) {
        p.b(r100, r101);
    }

    public static synchronized void a(String r100) {
        monitor-enter(q.class);
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
    L10:
        monitor-exit(q.class);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f24439b.containsKey(r100) == false) goto L10;
        n r101 = f24439b.get(r100);     // Catch: Throwable -> L8
        f24441d = r101;     // Catch: Throwable -> L8
        r101.a();     // Catch: Throwable -> L8
        f24439b.remove(r100);     // Catch: Throwable -> L8
        goto L10
    }

    public static synchronized void a(String r100, JSONObject r101, String r102) {
        monitor-enter(q.class);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
    L23:
        monitor-exit(q.class);
        return;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (f24439b.containsKey(r100) == false) goto L10;
        f24439b.get(r100).a(r102);     // Catch: Throwable -> L21
        monitor-exit(q.class);
        return;
    L10:
        if (f24440c.size() <= 0) goto L23;
        Iterator<n> r103 = f24440c.iterator();     // Catch: Throwable -> L21
    L13:
        if (r103.hasNext() == false) goto L23;
        n r104 = r103.next();     // Catch: Throwable -> L21
        if (r104.b() == null) goto L13;
        if (r104.b().equals(r100) == false) goto L13;
        if (r101 == null) goto L13;
        r101.remove("data");     // Catch: Throwable -> L21
        r104.a(r101.toString());     // Catch: Throwable -> L21
        r104.a(r102);     // Catch: Throwable -> L21
        goto L13
    }

    public static synchronized n b(String r100) {
        monitor-enter(q.class);
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        return new n(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f24439b.containsKey(r100) == false) goto L7;
        n r101 = f24439b.get(r100);     // Catch: Throwable -> L12
    L8:
        if (r101 != null) goto L10;
        r101 = new n(r100);     // Catch: Throwable -> L12
        f24439b.put(r100, r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(q.class);
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    private static void b(Context r100) {
        if (r100 != null) goto L28;
        return;
    L28:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L23
        monitor-enter(q.class);     // Catch: Throwable -> L23
        n r102 = f24441d;     // Catch: Throwable -> L20
        if (r102 == null) goto L9;
        r101.add(r102.toString());     // Catch: Throwable -> L20
        f24441d = null;     // Catch: Throwable -> L20
    L9:
        Iterator<n> r103 = f24440c.iterator();     // Catch: Throwable -> L20
    L11:
        if (r103.hasNext() == false) goto L13;
        r101.add(r103.next().toString());     // Catch: Throwable -> L20
        goto L11
    L13:
        f24438a = 0;     // Catch: Throwable -> L20
        f24440c.clear();     // Catch: Throwable -> L20
        monitor-exit(q.class);     // Catch: Throwable -> L20
    L16:
        if (r101.isEmpty() == false) goto L18;
        return;
    L18:
        p.a(r100, r101);     // Catch: Throwable -> L23
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    }

    public static void b(String r100, JSONObject r101, String r102) {
        int r103 = r101.optInt("result");     // Catch: Exception -> L7
        String r104 = r101.optString("msg");     // Catch: Exception -> L7
        if (r103 != 0) goto L5;
        b(r100).a(r103).d(r104);     // Catch: Exception -> L7
    L10:
        return;
    L5:
        b(r100).a(r103).d(r104).g(r102);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(String r100) {
        monitor-enter(q.class);     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L5:
        if (f24439b.containsKey(r100) == false) goto L8;
        n r101 = f24439b.get(r100);     // Catch: Throwable -> L18
        r101.a();     // Catch: Throwable -> L18
        f24440c.add(r101);     // Catch: Throwable -> L18
        f24439b.remove(r100);     // Catch: Throwable -> L18
    L8:
        if (f24438a != 1) goto L10;
    L16:
        monitor-exit(q.class);     // Catch: Throwable -> L18
        return;
    L10:
        if (f24440c.isEmpty() == true) goto L16;
        f24438a = 1;     // Catch: Throwable -> L18
        monitor-exit(q.class);     // Catch: Throwable -> L18
        a r102 = new a();     // Catch: Throwable -> L21
        new Timer().schedule(r102, KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
    }
}
