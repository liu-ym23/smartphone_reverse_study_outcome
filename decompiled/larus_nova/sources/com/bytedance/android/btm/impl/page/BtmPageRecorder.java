package com.bytedance.android.btm.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.e;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.c;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class BtmPageRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42212a = "BtmPageRecorder_putSourceBtm";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f42213b = "BtmPageRecorder_findPageByItem";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f42214c = "BtmPageRecorder_getPageInfo";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<f<? extends Object>, PageInfoStack> f42215d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<f<? extends Object>, PageInfoStack> f42216e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<f<? extends Object>, c> f42217f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f42218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f42219h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f42220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f42221j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, e> f42222k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, e> f42223l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap<f<View>, f<Fragment>> f42224m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<View, f<Fragment>> f42225n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ConcurrentHashMap<f<View>, f<DialogFragment>> f42226o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ConcurrentHashMap<f<View>, f<Dialog>> f42227p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final List<f<View>> f42228q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.android.btm.api.model.b> f42229r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map<f<Activity>, Boolean> f42230s = null;

    public BtmPageRecorder() {
    }

    static {
        f42212a = "BtmPageRecorder_putSourceBtm";
        f42213b = "BtmPageRecorder_findPageByItem";
        f42214c = "BtmPageRecorder_getPageInfo";
        f42215d = new ConcurrentHashMap();
        f42216e = new LruCache(10);
        f42217f = new ConcurrentHashMap();
        Lazy r100 = LazyKt.lazy(BtmPageRecorder$btmIdPageRelatedInfoMap$2.INSTANCE);
        f42219h = r100;
        Lazy r101 = LazyKt.lazy(BtmPageRecorder$eventBtmIdPageRelatedInfoMap$2.INSTANCE);
        f42221j = r101;
        f42222k = Collections.synchronizedMap((BtmPageRecorder$btmIdPageRelatedInfoMap$2.AnonymousClass1) r100.getValue());
        f42223l = Collections.synchronizedMap((BtmPageRecorder$eventBtmIdPageRelatedInfoMap$2.AnonymousClass1) r101.getValue());
        f42224m = new ConcurrentHashMap();
        f42225n = Collections.synchronizedMap(new WeakHashMap());
        f42226o = new ConcurrentHashMap();
        f42227p = new ConcurrentHashMap();
        f42228q = new ArrayList();
        f42229r = new ConcurrentHashMap();
        f42230s = new LinkedHashMap();
    }

    public static boolean a(Object r100) {
        if (f42215d.containsKey(new f(r100)) == false) goto L5;
    L8:
        return true;
    L5:
        if (f42216e.get(new f(r100)) != null) goto L8;
        return false;
    }

    public static Object b(final com.bytedance.android.btm.api.model.c r100) {
        ALogger r101 = ALogger.f41996d;
        String r102 = f42213b;
        ALogger.j(r101, r102, new BtmPageRecorder$findPageByItem$1(r100));
        String r103 = BtmPageFinder.f42209a;
        Object r104 = BtmPageFinder.a(r100.f42015e);
        if (r104 == null) goto L6;
        final String r105 = r104.getClass().getName();
        ALogger.j(r101, r102, new BtmPageRecorder$findPageByItem$2(r105));
        return r104;
    L6:
        ViewPager r106 = r100.f42016f;
        final String r107 = null;
        if (r106 == null) goto L19;
        int r108 = r100.f42017g;
        if (r108 < 0) goto L14;
        PagerAdapter r109 = r106.getAdapter();
        if (r109 == null) goto L14;
        Object r110 = r109.instantiateItem(r106, r108);
    L15:
        if (r110 == null) goto L17;
        r107 = r110.getClass().getName();
    L17:
        ALogger.j(r101, r102, new BtmPageRecorder$findPageByItem$3(r107));
        return r110;
    L14:
        r110 = null;
        goto L15
    L19:
        return null;
    }

    public static Object c(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<Map.Entry<f<? extends Object>, PageInfoStack>> r101 = f42215d.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<f<? extends Object>, PageInfoStack> r102 = r101.next();
        if (Intrinsics.areEqual(r102.getValue().current().getPageId(), r100) == false) goto L7;
        return r102.getKey().get();
    L12:
        Iterator<Map.Entry<f<? extends Object>, PageInfoStack>> r103 = f42216e.snapshot().entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L19;
        Map.Entry<f<? extends Object>, PageInfoStack> r104 = r103.next();
        if (Intrinsics.areEqual(r104.getValue().current().getPageId(), r100) == false) goto L14;
        return r104.getKey().get();
    L19:
        return null;
    }

    public static Fragment d(View r100) {
        if (BtmSetting.f42469d.c().d().v() != 1) goto L8;
        f<Fragment> r101 = f42225n.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    L8:
        f<Fragment> r102 = f42224m.get(new f(r100));
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.get();
    }

    public static Set e(Function1 r100) {
        HashSet r101 = new HashSet();
        Map<String, e> r102 = f42222k;
        monitor-enter(r102);
        Iterator<Map.Entry<String, e>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L29
    L6:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, e> r104 = r103.next();     // Catch: Throwable -> L29
        if (((Boolean) r100.invoke(r104.getValue())).booleanValue() == false) goto L6;
        r101.add(r104.getKey());     // Catch: Throwable -> L29
        goto L6
    L10:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r102);
        if (BtmSetting.f42469d.c().d().g() != 1) goto L28;
        Map<String, e> r106 = f42223l;
        monitor-enter(r106);
        Iterator<Map.Entry<String, e>> r107 = r106.entrySet().iterator();     // Catch: Throwable -> L25
    L18:
        if (r107.hasNext() == false) goto L22;
        Map.Entry<String, e> r108 = r107.next();     // Catch: Throwable -> L25
        if (((Boolean) r100.invoke(r108.getValue())).booleanValue() == false) goto L18;
        r101.add(r108.getKey());     // Catch: Throwable -> L25
        goto L18
    L22:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r106);
    L25:
        th = move-exception;
        throw th;
    L28:
        return r101;
    L29:
        th = move-exception;
        throw th;
    }

    public static e f(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return null;
    L11:
        e r102 = f42222k.get(r100);
        if (r102 == null) goto L15;
        return r102;
    L15:
        return f42223l.get(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static String g(String r100) {
        e r101 = f(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f42025a;
    }

    public static c h(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return f42217f.get(new f(r100));
    }

    public static Object i(PageInfo r100) {
        Iterator<Map.Entry<f<? extends Object>, PageInfoStack>> r101 = f42215d.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<f<? extends Object>, PageInfoStack> r102 = r101.next();
        Iterator<PageInfo> r103 = r102.getValue().all().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        if (Intrinsics.areEqual(r103.next().getPageId(), r100.getPageId()) == false) goto L7;
        return r102.getKey().get();
    L12:
        return null;
    }

    public static PageInfo j(Object r100) {
        PageInfo r101 = null;
        if (r100 != null) goto L6;
        ALogger.j(ALogger.f41996d, f42214c, BtmPageRecorder$getPageInfo$1.INSTANCE);
        return null;
    L6:
        final String r102 = r100.getClass().getName();
        PageInfoStack r103 = k(r100);
        if (r103 == null) goto L9;
        r101 = r103.current();
    L9:
        if (r101 != null) goto L11;
        ALogger.j(ALogger.f41996d, f42214c, new BtmPageRecorder$getPageInfo$2(r102));
    L11:
        return r101;
    }

    public static PageInfoStack k(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        PageInfoStack r101 = f42215d.get(new f(r100));
        if (r101 == null) goto L9;
        return r101;
    L9:
        return f42216e.get(new f(r100));
    }

    public static void l(Object r100) {
        ConcurrentHashMap<f<? extends Object>, c> r101 = f42217f;
        if (r101.get(new f(r100)) != null) goto L6;
        c r102 = new c();
        r101.put(new f(r100), r102);
        return;
    }

    public static PageInfoStack m(Object r100, boolean r101) {
        ConcurrentHashMap<f<? extends Object>, PageInfoStack> r102 = f42215d;
        PageInfoStack r103 = r102.get(new f(r100));
        if (r103 != null) goto L6;
        PageInfoStack.Companion.getClass();
        PageInfoStack r104 = new PageInfoStack(null);
        r104.setContainer(r101);
        r102.put(new f(r100), r104);
        return r104;
    L6:
        return r103;
    }

    public static void p(String r100, PageInfo r101, com.bytedance.android.btm.api.model.c r102) {
        q(r100, r101, !r102.a());
        if (r102.a() == true) goto L6;
        return;
    L6:
        if ((BtmSetting.f42469d.c().c().G() & 1) == 0) goto L9;
        com.bytedance.android.btm.api.model.b r103 = new com.bytedance.android.btm.api.model.b(0);
        r103.f42008a = r101.getPageShowId();
        r103.f42010c = r100;
        r101.setLatestBtmIdNode(r103);
        return;
    }

    public static void q(String r100, PageInfo r101, boolean r110) {
        String r102 = r101.getPageShowId();
        String r103 = r101.getPageBtm();
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        e r104 = new e(r102, r103, r101.getPageId(), r101.getInstanceId(), r101.getLastPageShowId(), 480);
        if (r110 == true) goto L9;
    L11:
        f42222k.put(r100, r104);
        return;
    L9:
        if (BtmSetting.f42469d.c().d().g() != 1) goto L11;
        f42223l.put(r100, r104);
    }

    public static void n(Object r100, final String r101, final int r102, final String r103, boolean r110, boolean r111) {
        final String r104 = r100.getClass().getName();
        ALogger.j(ALogger.f41996d, f42212a, new BtmPageRecorder$putSourceBtm$1(r104, r101, r102, r103));
        PageInfoStack r105 = k(r100);
        if (r105 == null) goto L8;
        PageInfo r106 = r105.current();
        if (r106 == null) goto L9;
        r106.putSourceBtm(r101, r102, r103, r110, r111);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void o(Object r100, String r101, int r110, String r111, boolean r112, int r113) {
        if ((r113 & 16) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r113 & 32) == 0) goto L9;
        boolean r103 = false;
    L10:
        n(r100, r101, r110, r111, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = false;
        goto L7
    }
}
