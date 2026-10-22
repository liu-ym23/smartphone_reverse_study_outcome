package W1;

import a2.C0421c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.stepos.digitalwellbeing.server.category.data.room.PackageCategoryInfo;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.net.BaseEntity;
import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import com.stepos.digitalwellbeing.server.net.category.PackageCategoryParam;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.R;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import f2.C0702g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p2.g;

/* loaded from: classes.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f5720f = R1.a.f("CategoryManager", R1.a.f4966b);

    /* renamed from: g, reason: collision with root package name */
    private static final Map<String, Integer> f5721g = g();

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Category> f5722a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f5723b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private Context f5724c;

    /* renamed from: d, reason: collision with root package name */
    private a f5725d;

    /* renamed from: e, reason: collision with root package name */
    private long f5726e;

    public interface a {
        void a(List<Category> list);

        void b(List<Category> list);
    }

    public c(Context context) {
        C0702g.b("CategoryManager", "CategoryManager " + this);
        this.f5724c = context;
        f();
    }

    private PackageCategoryInfo A(String str) {
        return U1.a.c(P1.a.a()).b().v().d(str);
    }

    private void C(String str, int i5) {
        for (int i6 = 0; i6 < this.f5722a.size(); i6++) {
            Category categoryValueAt = this.f5722a.valueAt(i6);
            if (categoryValueAt != null && categoryValueAt.getId() != i5) {
                categoryValueAt.remove(str);
            }
        }
    }

    private void E(String str, int i5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        U1.a.c(P1.a.a()).b().v().e(new PackageCategoryInfo(str, i5));
    }

    public static /* synthetic */ int a(Category category, Category category2) {
        return category.getId() - category2.getId();
    }

    private void c() {
        for (Map.Entry<String, Integer> entry : f5721g.entrySet()) {
            String key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            boolean z5 = false;
            boolean z6 = false;
            for (int i5 = 0; i5 < this.f5722a.size(); i5++) {
                Category categoryValueAt = this.f5722a.valueAt(i5);
                if (categoryValueAt != null && categoryValueAt.getPackages().contains(key)) {
                    if (categoryValueAt.getId() != iIntValue) {
                        z5 = true;
                        z6 = true;
                    } else {
                        z5 = true;
                    }
                }
            }
            if (z5 && z6) {
                e(key, iIntValue, true);
            }
        }
    }

    public static <C> List<C> d(SparseArray<C> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            arrayList.add(sparseArray.valueAt(i5));
        }
        return arrayList;
    }

    private void e(String str, int i5, boolean z5) {
        int iP;
        Category category;
        if (TextUtils.isEmpty(str) || (category = this.f5722a.get((iP = p(str, i5)))) == null) {
            return;
        }
        if (iP != i5) {
            R1.a.e("CategoryManager", "local category override packageName=" + str + " from=" + i5 + " to=" + iP);
        }
        C(str, iP);
        category.add(str);
        if (z5) {
            E(str, iP);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r1 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r6.f5723b.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f() {
        /*
            r6 = this;
            java.lang.String r0 = "CategoryManager"
            r1 = 0
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r6.f5723b     // Catch: java.lang.Throwable -> L24 java.lang.InterruptedException -> L26
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()     // Catch: java.lang.Throwable -> L24 java.lang.InterruptedException -> L26
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L24 java.lang.InterruptedException -> L26
            r4 = 1
            boolean r1 = r2.tryLock(r4, r3)     // Catch: java.lang.Throwable -> L24 java.lang.InterruptedException -> L26
            if (r1 != 0) goto L28
            java.lang.String r2 = "Failed to acquire write lock for createCategories within 1 seconds"
            R1.a.l(r0, r2)     // Catch: java.lang.Throwable -> L24 java.lang.InterruptedException -> L26
            if (r1 == 0) goto L45
        L1a:
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r6.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.unlock()
            return
        L24:
            r0 = move-exception
            goto L46
        L26:
            r2 = move-exception
            goto L2e
        L28:
            r6.h()     // Catch: java.lang.Throwable -> L24 java.lang.InterruptedException -> L26
            if (r1 == 0) goto L45
            goto L1a
        L2e:
            java.lang.String r3 = "Interrupted while waiting for write lock in createCategories"
            R1.a.m(r0, r3, r2)     // Catch: java.lang.Throwable -> L24
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L24
            r0.interrupt()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L45
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r6.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.unlock()
        L45:
            return
        L46:
            if (r1 == 0) goto L51
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r6.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.unlock()
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.f():void");
    }

    private static Map<String, Integer> g() {
        HashMap map = new HashMap();
        map.put("com.stepos.notepaper", 0);
        map.put("com.meizu.notepaper", 0);
        map.put("com.stepos.appstore", 0);
        map.put("com.android.sound", 0);
        map.put("com.android.soundrecorder", 0);
        return Collections.unmodifiableMap(map);
    }

    private void h() {
        if (f5720f) {
            R1.a.a("CategoryManager", "ensureCategoryShellsLocked size=" + this.f5722a.size());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i5 : W1.a.d()) {
            if (this.f5722a.get(i5) == null) {
                this.f5722a.put(i5, new Category(i5, m(i5), jCurrentTimeMillis));
            }
        }
    }

    public static int l(int i5) {
        switch (i5) {
            case 0:
                return R.drawable.us_ic_system_tools;
            case 1:
                return R.drawable.us_ic_news;
            case 2:
                return R.drawable.us_ic_life;
            case 3:
                return R.drawable.us_ic_financing;
            case 4:
                return R.drawable.us_ic_social;
            case 5:
                return R.drawable.us_ic_game_video;
            case 6:
                return R.drawable.us_ic_study;
            case 7:
                return R.drawable.us_ic_office;
            case 8:
                return R.drawable.us_ic_sport;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return R.drawable.us_ic_shopping;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return R.drawable.us_ic_other;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return R.drawable.us_ic_system_app;
            default:
                return android.R.drawable.sym_def_app_icon;
        }
    }

    public static int m(int i5) {
        switch (i5) {
            case 0:
                return R.string.us_system_tools;
            case 1:
                return R.string.us_news;
            case 2:
                return R.string.us_life;
            case 3:
                return R.string.us_financing;
            case 4:
                return R.string.us_social;
            case 5:
                return R.string.us_game_and_video;
            case 6:
                return R.string.us_study;
            case 7:
                return R.string.us_office;
            case 8:
                return R.string.us_sport;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return R.string.us_shopping;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
            default:
                return R.string.us_other;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return R.string.us_system_app;
        }
    }

    private static List<PackageCategoryParam> n(String str) {
        ArrayList arrayList = new ArrayList();
        PackageUtils.AppInfo appInfoM = PackageUtils.h(P1.a.a()).m(str);
        if (appInfoM != null) {
            arrayList.add(new PackageCategoryParam(appInfoM.packageName, appInfoM.system));
        }
        return arrayList;
    }

    private static List<PackageCategoryParam> o(List<String> list) {
        ArrayList arrayList = new ArrayList();
        PackageUtils packageUtilsH = PackageUtils.h(P1.a.a());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            PackageUtils.AppInfo appInfoM = packageUtilsH.m(it.next());
            if (appInfoM != null) {
                arrayList.add(new PackageCategoryParam(appInfoM.packageName, appInfoM.system));
            }
        }
        return arrayList;
    }

    private static int p(String str, int i5) {
        Integer num = f5721g.get(str);
        return num != null ? num.intValue() : i5;
    }

    private CategoryEntity v(Context context, String str) {
        R1.a.a("CategoryManager", "pullPackageCategory packageName = " + str);
        if (!g.x(this.f5724c)) {
            return null;
        }
        try {
            return C0421c.b(context).a(n(str)).X(T3.a.c()).e().value.get(0);
        } catch (Exception unused) {
            return null;
        }
    }

    private List<CategoryEntity> w(Context context, List<String> list) {
        if (f5720f) {
            R1.a.a("CategoryManager", "pullPackageCategory packageNames = " + list);
        }
        if (!g.x(this.f5724c)) {
            return null;
        }
        try {
            BaseEntity<List<CategoryEntity>> baseEntity = new BaseEntity<>();
            baseEntity.code = 404;
            return C0421c.b(context).a(o(list)).X(T3.a.c()).f(baseEntity).value;
        } catch (Exception e6) {
            R1.a.a("CategoryManager", "pullPackageCategory packageNames = " + list + Log.getStackTraceString(e6));
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B() throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = W1.c.f5720f
            java.lang.String r1 = "CategoryManager"
            if (r0 == 0) goto Lb
            java.lang.String r0 = "releaseCategoryCache"
            R1.a.a(r1, r0)
        Lb:
            r0 = 0
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r7.f5723b     // Catch: java.lang.Throwable -> L53 java.lang.InterruptedException -> L57
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()     // Catch: java.lang.Throwable -> L53 java.lang.InterruptedException -> L57
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L53 java.lang.InterruptedException -> L57
            r4 = 1
            boolean r2 = r2.tryLock(r4, r3)     // Catch: java.lang.Throwable -> L53 java.lang.InterruptedException -> L57
            if (r2 != 0) goto L31
            java.lang.String r0 = "Failed to acquire write lock for releaseCategoryCache within 1 seconds"
            R1.a.l(r1, r0)     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            if (r2 == 0) goto L72
        L23:
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = r7.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.unlock()
            return
        L2d:
            r0 = move-exception
            goto L73
        L2f:
            r0 = move-exception
            goto L5b
        L31:
            android.util.SparseArray<com.stepos.digitalwellbeing.server.data.Category> r3 = r7.f5722a     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            if (r0 >= r3) goto L49
            android.util.SparseArray<com.stepos.digitalwellbeing.server.data.Category> r3 = r7.f5722a     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            java.lang.Object r3 = r3.valueAt(r0)     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            com.stepos.digitalwellbeing.server.data.Category r3 = (com.stepos.digitalwellbeing.server.data.Category) r3     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            if (r3 == 0) goto L46
            r3.clear()     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
        L46:
            int r0 = r0 + 1
            goto L31
        L49:
            r7.h()     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            r3 = 0
            r7.f5726e = r3     // Catch: java.lang.Throwable -> L2d java.lang.InterruptedException -> L2f
            if (r2 == 0) goto L72
            goto L23
        L53:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L73
        L57:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
        L5b:
            java.lang.String r3 = "Interrupted while waiting for write lock in releaseCategoryCache"
            R1.a.m(r1, r3, r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2d
            r0.interrupt()     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L72
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = r7.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.unlock()
        L72:
            return
        L73:
            if (r2 == 0) goto L7e
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = r7.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.unlock()
        L7e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.B():void");
    }

    public void D(a aVar) {
        this.f5725d = aVar;
    }

    public void b(List<String> list) {
        try {
            try {
                boolean zTryLock = this.f5723b.writeLock().tryLock(1L, TimeUnit.SECONDS);
                if (zTryLock) {
                    Category category = this.f5722a.get(10);
                    if (category != null) {
                        category.addAll(list);
                    }
                    if (!zTryLock) {
                        return;
                    }
                } else {
                    R1.a.l("CategoryManager", "Failed to acquire write lock for addToOther within 1 seconds");
                    if (!zTryLock) {
                        return;
                    }
                }
                this.f5723b.writeLock().unlock();
            } catch (InterruptedException e6) {
                R1.a.m("CategoryManager", "Interrupted while waiting for write lock in addToOther", e6);
                Thread.currentThread().interrupt();
                if (0 != 0) {
                    this.f5723b.writeLock().unlock();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.f5723b.writeLock().unlock();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x004a: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:15:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[PHI: r6
      0x006f: PHI (r6v3 boolean) = (r6v2 boolean), (r6v6 boolean) binds: [B:29:0x0089, B:22:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[Catch: all -> 0x00b8, InterruptedException -> 0x00bc, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00b8, blocks: (B:37:0x00a7, B:45:0x00be, B:46:0x00d0, B:48:0x00d6, B:59:0x0103), top: B:90:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be A[Catch: all -> 0x00b8, InterruptedException -> 0x00bc, TRY_ENTER, TryCatch #2 {all -> 0x00b8, blocks: (B:37:0x00a7, B:45:0x00be, B:46:0x00d0, B:48:0x00d6, B:59:0x0103), top: B:90:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0118 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.digitalwellbeing.server.data.Category i(java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.i(java.lang.String):com.stepos.digitalwellbeing.server.data.Category");
    }

    public List<Category> j() {
        try {
            try {
                boolean zTryLock = this.f5723b.readLock().tryLock(1L, TimeUnit.SECONDS);
                if (zTryLock) {
                    List<Category> listD = d(this.f5722a);
                    if (zTryLock) {
                        this.f5723b.readLock().unlock();
                    }
                    return listD;
                }
                R1.a.l("CategoryManager", "Failed to acquire read lock for getCategories within 1 seconds");
                if (zTryLock) {
                    this.f5723b.readLock().unlock();
                }
                return null;
            } catch (InterruptedException e6) {
                R1.a.m("CategoryManager", "Interrupted while waiting for read lock in getCategories", e6);
                Thread.currentThread().interrupt();
                if (0 != 0) {
                    this.f5723b.readLock().unlock();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.f5723b.readLock().unlock();
            }
            throw th;
        }
    }

    public Category k(int i5) {
        try {
            try {
                boolean zTryLock = this.f5723b.readLock().tryLock(1L, TimeUnit.SECONDS);
                if (zTryLock) {
                    Category category = this.f5722a.get(i5);
                    if (zTryLock) {
                        this.f5723b.readLock().unlock();
                    }
                    return category;
                }
                R1.a.l("CategoryManager", "Failed to acquire read lock for getCategory within 1 seconds");
                if (zTryLock) {
                    this.f5723b.readLock().unlock();
                }
                return null;
            } catch (InterruptedException e6) {
                R1.a.m("CategoryManager", "Interrupted while waiting for read lock in getCategory", e6);
                Thread.currentThread().interrupt();
                if (0 != 0) {
                    this.f5723b.readLock().unlock();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.f5723b.readLock().unlock();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r7 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
    
        r5.f5723b.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (r7 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(int r6, int r7) {
        /*
            r5 = this;
            boolean r0 = W1.c.f5720f
            java.lang.String r1 = "CategoryManager"
            if (r0 == 0) goto L22
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "onCategoryChanged oldVersion = "
            r0.append(r2)
            r0.append(r6)
            java.lang.String r2 = " newVersion = "
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            R1.a.a(r1, r0)
        L22:
            if (r6 != 0) goto L92
            r6 = 1
            if (r7 != r6) goto L92
            android.app.Application r7 = P1.a.a()
            U1.a r7 = U1.a.c(r7)
            com.stepos.digitalwellbeing.DigitalWellbeingDataBase r7 = r7.b()
            X1.a r7 = r7.v()
            r7.b()
            r7 = 0
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r5.f5723b     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            r3 = 1
            boolean r7 = r0.tryLock(r3, r2)     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            if (r7 != 0) goto L60
            java.lang.String r6 = "Failed to acquire write lock for onCategoryChanged within 1 seconds"
            R1.a.l(r1, r6)     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            if (r7 == 0) goto L92
        L52:
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = r5.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r5 = r5.writeLock()
            r5.unlock()
            return
        L5c:
            r6 = move-exception
            goto L86
        L5e:
            r6 = move-exception
            goto L6e
        L60:
            android.util.SparseArray<com.stepos.digitalwellbeing.server.data.Category> r0 = r5.f5722a     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            r0.clear()     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            r5.f()     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            r5.x(r6)     // Catch: java.lang.Throwable -> L5c java.lang.InterruptedException -> L5e
            if (r7 == 0) goto L92
            goto L52
        L6e:
            java.lang.String r0 = "Interrupted while waiting for write lock in onCategoryChanged"
            R1.a.m(r1, r0, r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L5c
            r6.interrupt()     // Catch: java.lang.Throwable -> L5c
            if (r7 == 0) goto L92
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = r5.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r5 = r5.writeLock()
            r5.unlock()
            goto L92
        L86:
            if (r7 == 0) goto L91
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = r5.f5723b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r5 = r5.writeLock()
            r5.unlock()
        L91:
            throw r6
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.q(int, int):void");
    }

    public void r(String str) throws Throwable {
        z(str);
    }

    public void s(String str) throws Throwable {
        Category categoryI = i(str);
        if (categoryI != null) {
            categoryI.remove(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
    
        if (r2 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r2 != false) goto L7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.stepos.digitalwellbeing.server.data.Category] */
    /* JADX WARN: Type inference failed for: r6v0, types: [W1.c] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [W1.c] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(com.stepos.digitalwellbeing.server.net.category.CategoryEntity r7, long r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.t(com.stepos.digitalwellbeing.server.net.category.CategoryEntity, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r9.f5723b.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010d, code lost:
    
        if (r2 != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r2 != false) goto L10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(java.util.List<com.stepos.digitalwellbeing.server.net.category.CategoryEntity> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.u(java.util.List):void");
    }

    public List<Category> x(boolean z5) {
        return y(z5, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0362  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.stepos.digitalwellbeing.server.data.Category> y(boolean r18, boolean r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 885
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.c.y(boolean, boolean):java.util.List");
    }

    public Category z(String str) throws Throwable {
        boolean zTryLock;
        Category category;
        if (f5720f) {
            R1.a.a("CategoryManager", "queryPackageCategory packageName = " + str);
        }
        Category categoryI = i(str);
        if (categoryI != null && categoryI.getId() != 10) {
            return categoryI;
        }
        if (categoryI != null && categoryI.getId() == 10) {
            categoryI.remove(str);
            R1.a.a("CategoryManager", "queryPackageCategory clear provisional OTHER, re-pull packageName = " + str);
        }
        PackageCategoryInfo packageCategoryInfoA = A(str);
        boolean z5 = false;
        try {
            if (packageCategoryInfoA != null) {
                try {
                    zTryLock = this.f5723b.writeLock().tryLock(1L, TimeUnit.SECONDS);
                } catch (InterruptedException e6) {
                    e = e6;
                }
                try {
                    if (!zTryLock) {
                        R1.a.l("CategoryManager", "Failed to acquire write lock for queryPackageCategory DB hydrate");
                        if (zTryLock) {
                            this.f5723b.writeLock().unlock();
                        }
                        return null;
                    }
                    if (this.f5722a.get(packageCategoryInfoA.getCategoryId()) != null) {
                        e(str, packageCategoryInfoA.getCategoryId(), true);
                        Category category2 = this.f5722a.get(p(str, packageCategoryInfoA.getCategoryId()));
                        if (zTryLock) {
                            this.f5723b.writeLock().unlock();
                        }
                        return category2;
                    }
                    if (zTryLock) {
                        this.f5723b.writeLock().unlock();
                    }
                } catch (InterruptedException e7) {
                    e = e7;
                    z5 = zTryLock;
                    R1.a.m("CategoryManager", "Interrupted while waiting for write lock in queryPackageCategory DB hydrate", e);
                    Thread.currentThread().interrupt();
                    if (z5) {
                        this.f5723b.writeLock().unlock();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    z5 = zTryLock;
                    if (z5) {
                        this.f5723b.writeLock().unlock();
                    }
                    throw th;
                }
            }
            CategoryEntity categoryEntityV = v(this.f5724c, str);
            try {
                if (categoryEntityV != null) {
                    t(categoryEntityV, System.currentTimeMillis());
                    return i(str);
                }
                try {
                    boolean zTryLock2 = this.f5723b.writeLock().tryLock(1L, TimeUnit.SECONDS);
                    if (!zTryLock2) {
                        R1.a.l("CategoryManager", "Failed to acquire write lock for queryPackageCategory OTHER fallback");
                        if (zTryLock2) {
                            this.f5723b.writeLock().unlock();
                        }
                        return null;
                    }
                    Iterator it = d(this.f5722a).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            category = null;
                            break;
                        }
                        category = (Category) it.next();
                        if (category.getPackages().contains(str)) {
                            break;
                        }
                    }
                    if (category != null) {
                        Integer num = f5721g.get(str);
                        if (num == null) {
                            if (zTryLock2) {
                                this.f5723b.writeLock().unlock();
                            }
                            return category;
                        }
                        e(str, num.intValue(), true);
                        Category category3 = this.f5722a.get(num.intValue());
                        if (zTryLock2) {
                            this.f5723b.writeLock().unlock();
                        }
                        return category3;
                    }
                    Integer num2 = f5721g.get(str);
                    if (num2 != null) {
                        e(str, num2.intValue(), true);
                        Category category4 = this.f5722a.get(num2.intValue());
                        if (zTryLock2) {
                            this.f5723b.writeLock().unlock();
                        }
                        return category4;
                    }
                    Category category5 = this.f5722a.get(10);
                    if (category5 == null) {
                        if (zTryLock2) {
                            this.f5723b.writeLock().unlock();
                        }
                        return null;
                    }
                    category5.add(str);
                    R1.a.l("CategoryManager", "queryPackageCategory fallback OTHER packageName = " + str);
                    if (zTryLock2) {
                        this.f5723b.writeLock().unlock();
                    }
                    return category5;
                } catch (InterruptedException e8) {
                    R1.a.m("CategoryManager", "Interrupted while waiting for write lock in queryPackageCategory OTHER fallback", e8);
                    Thread.currentThread().interrupt();
                    if (0 != 0) {
                        this.f5723b.writeLock().unlock();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    this.f5723b.writeLock().unlock();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
