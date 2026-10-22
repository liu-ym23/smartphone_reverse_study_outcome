package Z7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.bq;
import com.tencent.bugly.proguard.bu;
import com.tencent.bugly.proguard.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Q {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f7344e = true;

    /* renamed from: a, reason: collision with root package name */
    public Context f7345a;

    /* renamed from: b, reason: collision with root package name */
    public long f7346b;

    /* renamed from: c, reason: collision with root package name */
    public int f7347c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7348d;

    public class a implements InterfaceC1135g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f7349a;

        public a(List list) {
            this.f7349a = list;
        }

        @Override // Z7.InterfaceC1135g
        public final void a(boolean z10, String str) {
            if (z10) {
                C1139k.h("[UserInfo] Successfully uploaded user info.", new Object[0]);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (UserInfoBean userInfoBean : this.f7349a) {
                    userInfoBean.f31430f = jCurrentTimeMillis;
                    Q.this.j(userInfoBean, true);
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7351a = false;

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Q.this.m(this.f7351a);
            } catch (Throwable th) {
                C1139k.e(th);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7353a;

        /* renamed from: b, reason: collision with root package name */
        public UserInfoBean f7354b;

        public c(UserInfoBean userInfoBean, boolean z10) {
            this.f7354b = userInfoBean;
            this.f7353a = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (Q.this.f7348d) {
                try {
                    UserInfoBean userInfoBean = this.f7354b;
                    if (userInfoBean != null) {
                        Q.i(userInfoBean);
                        C1139k.h("[UserInfo] Record user info.", new Object[0]);
                        Q.this.j(this.f7354b, false);
                    }
                    if (this.f7353a) {
                        Q.this.q();
                    }
                } catch (Throwable th) {
                    if (C1139k.e(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < Q.this.f7346b) {
                C1138j.a().c(Q.this.new d(), (Q.this.f7346b - jCurrentTimeMillis) + 5000);
            } else {
                Q.this.e(3, false);
                Q.this.d();
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public long f7357a;

        public e(long j10) {
            this.f7357a = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Q.this.q();
            Q.this.f(this.f7357a);
        }
    }

    public Q(Context context, boolean z10) {
        this.f7345a = context;
        this.f7348d = z10;
    }

    public static int a(List<UserInfoBean> list) {
        int i10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f31429e > jCurrentTimeMillis - 600000 && ((i10 = userInfoBean.f31426b) == 1 || i10 == 4 || i10 == 3)) {
                i11++;
            }
        }
        return i11;
    }

    public static UserInfoBean b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID));
            UserInfoBean userInfoBean = (UserInfoBean) C1143o.e(blob, UserInfoBean.CREATOR);
            if (userInfoBean == null) {
                return userInfoBean;
            }
            userInfoBean.f31425a = j10;
            return userInfoBean;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<UserInfoBean> c(String str) {
        Cursor cursorJ;
        String str2;
        try {
            if (C1143o.G(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorJ = V.f().j("t_ui", null, str2);
            if (cursorJ == null) {
                return null;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorJ.moveToNext()) {
                    UserInfoBean userInfoBeanB = b(cursorJ);
                    if (userInfoBeanB != null) {
                        arrayList.add(userInfoBeanB);
                    } else {
                        try {
                            long j10 = cursorJ.getLong(cursorJ.getColumnIndex(StepOSRecipientEmailHistory._ID));
                            sb2.append(" or _id = ");
                            sb2.append(j10);
                        } catch (Throwable unused) {
                            C1139k.i("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb2.toString();
                if (string.length() > 0) {
                    C1139k.i("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(V.f().b("t_ui", string.substring(4))));
                }
                cursorJ.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C1139k.e(th)) {
                        th.printStackTrace();
                    }
                    if (cursorJ != null) {
                        cursorJ.close();
                    }
                    return null;
                } finally {
                    if (cursorJ != null) {
                        cursorJ.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorJ = null;
        }
    }

    public static /* synthetic */ void i(UserInfoBean userInfoBean) {
        C1130b c1130bL;
        if (userInfoBean == null || (c1130bL = C1130b.l()) == null) {
            return;
        }
        userInfoBean.f31434j = c1130bL.p();
    }

    public static void k(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i10 = 0;
            while (i10 < list.size() - 1) {
                int i11 = i10 + 1;
                for (int i12 = i11; i12 < list.size(); i12++) {
                    if (list.get(i10).f31429e > list.get(i12).f31429e) {
                        UserInfoBean userInfoBean = list.get(i10);
                        list.set(i10, list.get(i12));
                        list.set(i12, userInfoBean);
                    }
                }
                i10 = i11;
            }
            for (int i13 = 0; i13 < size; i13++) {
                list2.add(list.get(i13));
            }
        }
    }

    public static ContentValues p(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = userInfoBean.f31425a;
            if (j10 > 0) {
                contentValues.put(StepOSRecipientEmailHistory._ID, Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f31429e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f31430f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f31426b));
            contentValues.put("_pc", userInfoBean.f31427c);
            contentValues.put("_dt", C1143o.w(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static void r(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size() && i10 < 50; i10++) {
            UserInfoBean userInfoBean = list.get(i10);
            sb2.append(" or _id = ");
            sb2.append(userInfoBean.f31425a);
        }
        String string = sb2.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        sb2.setLength(0);
        try {
            C1139k.h("[Database] deleted %s data %d", "t_ui", Integer.valueOf(V.f().b("t_ui", string)));
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static void s(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f31430f != -1) {
                it.remove();
                if (next.f31429e < C1143o.z()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void d() {
        this.f7346b = C1143o.z() + 86400000;
        C1138j.a().c(new d(), (this.f7346b - System.currentTimeMillis()) + 5000);
    }

    public final void e(int i10, boolean z10) {
        C1131c c1131cA = C1131c.a();
        if (c1131cA != null && !c1131cA.i().f31453g && i10 != 1 && i10 != 3) {
            C1139k.j("UserInfo is disable", new Object[0]);
            return;
        }
        if (i10 == 1 || i10 == 3) {
            this.f7347c++;
        }
        C1130b c1130bH = C1130b.h(this.f7345a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f31426b = i10;
        userInfoBean.f31427c = c1130bH.f7455f;
        userInfoBean.f31428d = c1130bH.t();
        userInfoBean.f31429e = System.currentTimeMillis();
        userInfoBean.f31430f = -1L;
        userInfoBean.f31438n = c1130bH.f7422D;
        userInfoBean.f31439o = i10 == 1 ? 1 : 0;
        userInfoBean.f31436l = c1130bH.k();
        userInfoBean.f31437m = c1130bH.f7439U;
        userInfoBean.f31431g = c1130bH.f7440V;
        userInfoBean.f31432h = c1130bH.f7441W;
        userInfoBean.f31433i = c1130bH.f7442X;
        userInfoBean.f31435k = c1130bH.f7443Y;
        userInfoBean.f31442r = c1130bH.H();
        userInfoBean.f31443s = c1130bH.J();
        userInfoBean.f31440p = c1130bH.K();
        userInfoBean.f31441q = c1130bH.f7435Q;
        C1138j.a().c(new c(userInfoBean, z10), 0L);
    }

    public final void f(long j10) {
        C1138j.a().c(new e(j10), j10);
    }

    public final void j(UserInfoBean userInfoBean, boolean z10) {
        List<UserInfoBean> listC;
        if (userInfoBean == null) {
            return;
        }
        if (!z10 && userInfoBean.f31426b != 1 && (listC = c(C1130b.h(this.f7345a).f7455f)) != null && listC.size() >= 20) {
            C1139k.d("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listC.size()));
            return;
        }
        long jE = V.f().e("t_ui", p(userInfoBean), null);
        if (jE >= 0) {
            C1139k.h("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jE));
            userInfoBean.f31425a = jE;
        }
    }

    public final void l(List<UserInfoBean> list, boolean z10) {
        C1130b c1130bL;
        if (!t(z10)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f31430f = jCurrentTimeMillis;
                j(userInfoBean, true);
            }
            C1139k.i("uploadCheck failed", new Object[0]);
            return;
        }
        int i10 = this.f7347c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null && list.size() != 0 && (c1130bL = C1130b.l()) != null) {
            c1130bL.C();
            bv bvVar2 = new bv();
            bvVar2.f31680b = c1130bL.f7455f;
            bvVar2.f31681c = c1130bL.u();
            ArrayList<bu> arrayList = new ArrayList<>();
            Iterator<UserInfoBean> it = list.iterator();
            while (it.hasNext()) {
                bu buVarC = C1133e.c(it.next());
                if (buVarC != null) {
                    arrayList.add(buVarC);
                }
            }
            bvVar2.f31682d = arrayList;
            HashMap map = new HashMap();
            bvVar2.f31683e = map;
            map.put("A7", new StringBuilder().toString());
            bvVar2.f31683e.put("A6", C1130b.B());
            bvVar2.f31683e.put("A5", c1130bL.A());
            Map<String, String> map2 = bvVar2.f31683e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c1130bL.y());
            map2.put("A2", sb2.toString());
            Map<String, String> map3 = bvVar2.f31683e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c1130bL.y());
            map3.put("A1", sb3.toString());
            bvVar2.f31683e.put("A24", c1130bL.f7471n);
            Map<String, String> map4 = bvVar2.f31683e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(c1130bL.z());
            map4.put("A17", sb4.toString());
            bvVar2.f31683e.put("A15", c1130bL.E());
            Map<String, String> map5 = bvVar2.f31683e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c1130bL.F());
            map5.put("A13", sb5.toString());
            bvVar2.f31683e.put("F08", c1130bL.f7446a0);
            bvVar2.f31683e.put("F09", c1130bL.f7448b0);
            Map<String, String> mapJ = c1130bL.J();
            if (mapJ != null && mapJ.size() > 0) {
                for (Map.Entry<String, String> entry : mapJ.entrySet()) {
                    bvVar2.f31683e.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i10 == 1) {
                bvVar2.f31679a = (byte) 1;
            } else if (i10 != 2) {
                C1139k.j("unknown up type %d ", Integer.valueOf(i10));
            } else {
                bvVar2.f31679a = (byte) 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            C1139k.i("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] bArrE = C1133e.e(bvVar);
        if (bArrE == null) {
            C1139k.i("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq bqVarA = C1133e.a(this.f7345a, 840, bArrE);
        if (bqVarA == null) {
            C1139k.i("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        C1136h.c().i(1001, bqVarA, C1131c.a().i().f31463q, StrategyBean.f31447a, new a(list), this.f7347c == 1);
    }

    public final synchronized void m(boolean z10) {
        C1136h c1136hC;
        C1131c c1131cA;
        if (this.f7348d && (c1136hC = C1136h.c()) != null && (c1131cA = C1131c.a()) != null && (!c1131cA.h() || c1136hC.r(1001))) {
            String str = C1130b.h(this.f7345a).f7455f;
            ArrayList arrayList = new ArrayList();
            List<UserInfoBean> listC = c(str);
            boolean z11 = true;
            if (listC != null) {
                k(listC, arrayList);
                s(listC, arrayList);
                int iA = a(listC);
                if (iA > 15) {
                    C1139k.i("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(iA));
                    z11 = false;
                }
            } else {
                listC = new ArrayList<>();
            }
            if (arrayList.size() > 0) {
                r(arrayList);
            }
            if (z11 && listC.size() != 0) {
                C1139k.h("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listC.size()));
                l(listC, z10);
                return;
            }
            C1139k.h("[UserInfo] There is no user info in local database.", new Object[0]);
        }
    }

    public final void q() {
        C1138j c1138jA = C1138j.a();
        if (c1138jA != null) {
            c1138jA.b(new b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0074 A[EXC_TOP_SPLITTER, PHI: r1
      0x0074: PHI (r1v2 boolean) = (r1v0 boolean), (r1v3 boolean) binds: [B:25:0x006a, B:36:0x0087] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(boolean r13) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = Z7.Q.f7344e
            r1 = 1
            if (r0 != 0) goto L6
            return r1
        L6:
            java.io.File r0 = new java.io.File
            android.content.Context r12 = r12.f7345a
            java.io.File r12 = r12.getFilesDir()
            java.lang.String r2 = "bugly_last_us_up_tm"
            r0.<init>(r12, r2)
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1024(0x400, double:5.06E-321)
            r12 = 0
            if (r13 == 0) goto L24
            java.lang.String r13 = java.lang.String.valueOf(r2)
            Z7.C1140l.d(r0, r13, r4, r12)
            return r1
        L24:
            boolean r13 = r0.exists()
            if (r13 != 0) goto L32
            java.lang.String r13 = java.lang.String.valueOf(r2)
            Z7.C1140l.d(r0, r13, r4, r12)
            goto L8a
        L32:
            java.io.BufferedReader r13 = Z7.C1143o.c(r0)
            if (r13 == 0) goto L87
            java.lang.String r6 = r13.readLine()     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L69
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L69
            long r6 = r6.longValue()     // Catch: java.lang.Throwable -> L69
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 < 0) goto L61
            long r8 = r2 - r6
            r10 = 86400000(0x5265c00, double:4.2687272E-316)
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L56
            goto L61
        L56:
            long r6 = r2 - r6
            r8 = 300000(0x493e0, double:1.482197E-318)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L61
            r1 = r12
            goto L87
        L61:
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L69
            Z7.C1140l.d(r0, r6, r4, r12)     // Catch: java.lang.Throwable -> L69
            goto L87
        L69:
            r6 = move-exception
            Z7.C1139k.g(r6)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L7d
            Z7.C1140l.d(r0, r2, r4, r12)     // Catch: java.lang.Throwable -> L7d
        L74:
            r13.close()     // Catch: java.lang.Exception -> L78
            goto L8a
        L78:
            r12 = move-exception
            Z7.C1139k.e(r12)
            goto L8a
        L7d:
            r12 = move-exception
            r13.close()     // Catch: java.lang.Exception -> L82
            goto L86
        L82:
            r13 = move-exception
            Z7.C1139k.e(r13)
        L86:
            throw r12
        L87:
            if (r13 == 0) goto L8a
            goto L74
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.Q.t(boolean):boolean");
    }
}
