package c2;

import Y1.u;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.limit.data.room.m;
import com.stepos.digitalwellbeing.server.limit.data.room.o;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.R;
import f2.C0702g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.libpag.BuildConfig;
import x3.EnumC1285a;
import x3.e;
import x3.f;
import x3.g;
import x3.h;

/* renamed from: c2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0582c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, o> f11953a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f11954b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f11955c;

    /* renamed from: d, reason: collision with root package name */
    private m f11956d;

    /* renamed from: e, reason: collision with root package name */
    private W1.c f11957e;

    /* renamed from: f, reason: collision with root package name */
    private A3.c f11958f;

    /* renamed from: g, reason: collision with root package name */
    private f<Long> f11959g;

    /* renamed from: h, reason: collision with root package name */
    private e<Long> f11960h;

    /* renamed from: i, reason: collision with root package name */
    private final Context f11961i;

    public C0582c(Context context) {
        this.f11961i = context;
    }

    private static boolean A(int i5, int i6) {
        return (i5 & i6) != 0;
    }

    private static boolean B(int i5, int i6) {
        return ((i5 & i6) >>> Integer.numberOfTrailingZeros(i6)) == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(g gVar) {
        this.f11960h = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Long l5) {
        try {
            j();
        } catch (Exception e6) {
            C0702g.r("SuspendedRecordUtils", e6);
        }
    }

    private synchronized void O() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.f11954b.iterator();
            while (it.hasNext()) {
                o oVar = this.f11953a.get(it.next());
                if (oVar != null) {
                    arrayList.add(oVar);
                }
            }
            this.f11956d.b(arrayList);
            this.f11954b.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void P(String[] strArr, boolean z5, String str, boolean z6) {
        if (!z5) {
            u.f(strArr, false, str);
            return;
        }
        String[] strArrO = o(strArr);
        if (strArrO == null || strArrO.length == 0) {
            return;
        }
        if (z6) {
            u.f(strArrO, true, str);
        } else {
            u.o(strArrO, str);
        }
    }

    private synchronized void j() {
        C0702g.b("SuspendedRecordUtils", "applyApplyChanges START");
        l(this.f11961i);
        O();
        E();
        C0702g.b("SuspendedRecordUtils", "applyApplyChanges END");
    }

    private synchronized void k(String str, int i5, long j5) {
        try {
            o oVar = this.f11953a.get(str);
            if (oVar == null) {
                this.f11953a.put(str, new o(str, i5, j5));
            } else {
                oVar.c(g(oVar.a(), i5));
            }
            if (!this.f11954b.contains(str)) {
                this.f11954b.add(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void l(Context context) {
        m(context, true);
    }

    private synchronized void m(Context context, boolean z5) {
        List arrayList;
        try {
            C0702g.b("SuspendedRecordUtils", "doApplyChanges() called with: mChangedList = " + C0702g.l(this.f11954b) + " kickForeground = " + z5);
            HashMap map = new HashMap();
            Iterator<String> it = this.f11954b.iterator();
            while (true) {
                int iA = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                o oVar = this.f11953a.get(next);
                if (oVar != null) {
                    iA = oVar.a();
                }
                List arrayList2 = (List) map.get(Integer.valueOf(iA));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(Integer.valueOf(iA), arrayList2);
                }
                arrayList2.add(next);
            }
            C0702g.b("SuspendedRecordUtils", "suspended map = " + C0702g.m(map));
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((Integer) entry.getKey()).intValue();
                String[] strArr = new String[0];
                List<String> list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    strArr = (String[]) list.toArray(strArr);
                }
                if (strArr.length > 0) {
                    if (!t(iIntValue)) {
                        P(strArr, false, BuildConfig.FLAVOR, z5);
                    } else if (y(iIntValue) || z(iIntValue)) {
                        P(strArr, true, q(context, iIntValue, new Object[0]), z5);
                    } else if (w(iIntValue) || x(iIntValue)) {
                        HashMap map2 = new HashMap();
                        for (String str : list) {
                            long id = this.f11957e.i(str) == null ? 10L : r7.getId();
                            if (map2.containsKey(Long.valueOf(id))) {
                                arrayList = (List) map2.get(Long.valueOf(id));
                            } else {
                                arrayList = new ArrayList();
                                map2.put(Long.valueOf(id), arrayList);
                            }
                            if (arrayList != null) {
                                arrayList.add(str);
                            }
                        }
                        for (Map.Entry entry2 : map2.entrySet()) {
                            Long l5 = (Long) entry2.getKey();
                            l5.longValue();
                            P((String[]) ((List) entry2.getValue()).toArray(new String[0]), true, q(context, iIntValue, l5), z5);
                        }
                    } else if (v(iIntValue) || u(iIntValue)) {
                        for (String str2 : list) {
                            PackageUtils.AppInfo appInfoM = PackageUtils.h(context).m(str2);
                            P(new String[]{str2}, true, q(context, iIntValue, appInfoM == null ? str2 : appInfoM.label), z5);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void n(String str, int i5, long j5) {
        o oVar = this.f11953a.get(str);
        if (oVar != null) {
            oVar.c(L(oVar.a(), i5));
            oVar.d(j5);
            if (!this.f11954b.contains(str)) {
                this.f11954b.add(str);
            }
            return;
        }
        this.f11953a.put(str, new o(str, 0, j5));
        if (!this.f11954b.contains(str)) {
            this.f11954b.add(str);
        }
    }

    private String[] o(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!s(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private List<String> p(long j5) {
        Category categoryK = this.f11957e.k((int) j5);
        if (categoryK != null) {
            return categoryK.getPackages();
        }
        C0702g.O("SuspendedRecordUtils", "getCategoryPackagesOrEmpty category is null, categoryId = " + j5);
        return Collections.EMPTY_LIST;
    }

    public static String q(Context context, int i5, Object... objArr) {
        if (y(i5) || z(i5)) {
            return context.getString(R.string.mm_global_overtime_limit_dialog_message);
        }
        boolean zW = w(i5);
        boolean zX = x(i5);
        if (zW || zX) {
            String string = context.getString(W1.c.m((int) ((Long) objArr[0]).longValue()));
            if (string == null) {
                string = context.getString(R.string.us_other);
            }
            return zW ? context.getString(R.string.us_category_overtime_period_limit_dialog_message, string) : B(i5, 3840) ? context.getString(R.string.us_category_total_limit_dialog_message, string) : context.getString(R.string.us_category_overtime_limit_dialog_message, string);
        }
        boolean zU = u(i5);
        boolean zV = v(i5);
        if (!zU && !zV) {
            return "know reason";
        }
        String str = (String) objArr[0];
        return zU ? context.getString(R.string.us_app_overtime_period_limit_dialog_message, str) : B(i5, 15) ? context.getString(R.string.us_app_total_limit_dialog_message, str) : context.getString(R.string.us_app_overtime_limit_dialog_message, str);
    }

    private boolean s(String str) {
        boolean zContains = this.f11955c.contains(str);
        C0702g.b("SuspendedRecordUtils", "isInWhiteList() called with: packageName = [" + str + "] result = [" + zContains + "]");
        return zContains;
    }

    public static boolean t(int i5) {
        return i5 != 0;
    }

    public static boolean u(int i5) {
        return A(i5, 16);
    }

    public static boolean v(int i5) {
        return A(i5, 1);
    }

    public static boolean w(int i5) {
        return A(i5, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
    }

    public static boolean x(int i5) {
        return A(i5, 256);
    }

    public static boolean y(int i5) {
        return A(i5, 1048576);
    }

    public static boolean z(int i5) {
        return A(i5, 65536);
    }

    public synchronized void E() {
        try {
            C0702g.b("SuspendedRecordUtils", "loadRecords START");
            this.f11953a.clear();
            this.f11954b.clear();
            for (o oVar : this.f11956d.a()) {
                this.f11953a.put(oVar.b(), oVar);
            }
            C0702g.b("SuspendedRecordUtils", "loadRecords END");
        } catch (Throwable th) {
            throw th;
        }
    }

    public void F(List<String> list, List<String> list2) {
        if (list != null) {
            u.f((String[]) list.toArray(new String[0]), false, "whitelist");
        }
        this.f11954b.addAll(list);
        this.f11954b.addAll(list2);
        this.f11960h.d(Long.valueOf(System.currentTimeMillis()));
    }

    public synchronized void G() {
        try {
            if (this.f11953a.isEmpty()) {
                E();
            }
            for (Map.Entry<String, o> entry : this.f11953a.entrySet()) {
                o value = entry.getValue();
                if (value != null && t(value.a())) {
                    this.f11954b.add(entry.getKey());
                }
            }
            if (this.f11954b.isEmpty()) {
                C0702g.b("SuspendedRecordUtils", "refreshSuspendDialogs skip, no suspended packages");
                return;
            }
            C0702g.b("SuspendedRecordUtils", "refreshSuspendDialogs count=" + this.f11954b.size());
            m(this.f11961i, false);
            O();
            E();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void H(String str) {
        C0702g.b("SuspendedRecordUtils", "removeAppPeriodLimitReason() called with: packageName = " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        n(str, 240, jCurrentTimeMillis);
        this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
    }

    public synchronized void I(String str) {
        C0702g.b("SuspendedRecordUtils", "removeAppUsageLimitReason() called with: packageName = " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        n(str, 15, jCurrentTimeMillis);
        this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
    }

    public synchronized void J(long j5) {
        try {
            C0702g.b("SuspendedRecordUtils", "removeCategoryPeriodLimitReason() called with: categoryId = " + j5);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<String> it = p(j5).iterator();
            while (it.hasNext()) {
                n(it.next(), 61440, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void K(long j5) {
        try {
            C0702g.b("SuspendedRecordUtils", "removeCategoryUsageLimitReason() called with: categoryId = " + j5);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<String> it = p(j5).iterator();
            while (it.hasNext()) {
                n(it.next(), 3840, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public int L(int i5, int i6) {
        return (~i6) & i5;
    }

    public synchronized void M() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<String> listG = PackageUtils.h(this.f11961i).g();
            C0702g.b("SuspendedRecordUtils", "removeGlobalPeriodLimitReason() called with: packages = " + C0702g.k(listG));
            Iterator<String> it = listG.iterator();
            while (it.hasNext()) {
                n(it.next(), 15728640, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void N() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<String> listG = PackageUtils.h(this.f11961i).g();
            C0702g.b("SuspendedRecordUtils", "removeGlobalUsageLimitReason() called with: packages = " + C0702g.k(listG));
            Iterator<String> it = listG.iterator();
            while (it.hasNext()) {
                n(it.next(), 983040, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public void Q(List<String> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f11955c) {
            if (!list.contains(str)) {
                arrayList2.add(str);
            }
        }
        for (String str2 : list) {
            if (!this.f11955c.contains(str2)) {
                arrayList.add(str2);
            }
        }
        F(arrayList, arrayList2);
        this.f11955c.clear();
        this.f11955c.addAll(list);
    }

    public synchronized void c(String str, boolean z5) {
        C0702g.b("SuspendedRecordUtils", "addAppPeriodLimitReason() called with: packageName = " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        k(str, z5 ? 48 : 16, jCurrentTimeMillis);
        this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
    }

    public synchronized void d(String str, boolean z5) {
        C0702g.b("SuspendedRecordUtils", "addAppUsageLimitReason() called with: packageName = " + str);
        int i5 = z5 ? 3 : 1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        k(str, i5, jCurrentTimeMillis);
        this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
    }

    public synchronized void e(long j5, boolean z5) {
        try {
            C0702g.b("SuspendedRecordUtils", "addCategoryPeriodLimitReason() called with: categoryId = " + j5);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i5 = z5 ? 12288 : RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
            Iterator<String> it = p(j5).iterator();
            while (it.hasNext()) {
                k(it.next(), i5, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void f(long j5, boolean z5) {
        try {
            C0702g.b("SuspendedRecordUtils", "addCategoryUsageLimitReason() called with: categoryId = " + j5);
            int i5 = z5 ? 768 : 256;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<String> it = p(j5).iterator();
            while (it.hasNext()) {
                k(it.next(), i5, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public int g(int i5, int i6) {
        return i5 | i6;
    }

    public synchronized void h(boolean z5) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<String> listG = PackageUtils.h(this.f11961i).g();
            C0702g.b("SuspendedRecordUtils", "addGlobalPeriodLimitReason() called with: packages = " + C0702g.k(listG));
            int i5 = z5 ? 3145728 : 1048576;
            Iterator<String> it = listG.iterator();
            while (it.hasNext()) {
                k(it.next(), i5, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i(boolean z5) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<String> listG = PackageUtils.h(this.f11961i).g();
            C0702g.b("SuspendedRecordUtils", "addGlobalUsageLimitReason() called with: packages = " + C0702g.k(listG));
            int i5 = z5 ? 196608 : 65536;
            Iterator<String> it = listG.iterator();
            while (it.hasNext()) {
                k(it.next(), i5, jCurrentTimeMillis);
            }
            this.f11960h.d(Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void r(m mVar, W1.c cVar, List<String> list) {
        this.f11956d = mVar;
        this.f11957e = cVar;
        this.f11955c = new HashSet(list);
        f<Long> fVarH = f.h(new h() { // from class: c2.a
            @Override // x3.h
            public final void a(g gVar) {
                this.f11951a.C(gVar);
            }
        }, EnumC1285a.LATEST);
        this.f11959g = fVarH;
        this.f11958f = fVarH.i(500L, TimeUnit.MILLISECONDS).O(3L).T(new D3.c() { // from class: c2.b
            @Override // D3.c
            public final void accept(Object obj) {
                this.f11952a.D((Long) obj);
            }
        }, S1.a.b());
        E();
    }
}
