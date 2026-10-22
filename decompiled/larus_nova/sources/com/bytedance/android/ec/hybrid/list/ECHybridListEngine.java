package com.bytedance.android.ec.hybrid.list;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.ec.hybrid.list.ability.impl.ListDataPool;
import com.bytedance.android.ec.hybrid.list.ability.n0;
import com.bytedance.android.ec.hybrid.list.ability.o0;
import com.bytedance.android.ec.hybrid.list.ability.p0;
import com.bytedance.android.ec.hybrid.list.ability.r0;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.ability.w;
import com.bytedance.android.ec.hybrid.list.ability.z;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridHolderUpdateParams;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridItemDataShrinkHelper;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.entity.p;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.holder.EmptyViewHolder;
import com.bytedance.android.ec.hybrid.list.util.l;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridRecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.hybrid.monitor.h;
import com.bytedance.common.utility.Logger;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridListEngine implements com.bytedance.android.ec.hybrid.list.ability.a, w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final HashMap<String, r0> f46867v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final HashMap<Integer, n0> f46868w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f46869x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECHybridListAdapter f46870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECHybridRecyclerView f46871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataResolver f46872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECHybridItemDataShrinkHelper f46873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Pair<Integer, Integer> f46874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, Integer> f46875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f46876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f46877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<Function3<Long, Long, com.bytedance.android.ec.hybrid.list.util.d, Unit>> f46878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<yj.b> f46879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Function2<Long, com.bytedance.android.ec.hybrid.list.util.d, Unit>> f46880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Function2<RecyclerView, Integer, Unit>> f46881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f46882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Unit> f46883n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function3<? super String, ? super Boolean, ? super Boolean, Unit> f46884o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f46885p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super ECHybridHolderUpdateParams, Unit> f46886q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f46887r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f46888s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LifecycleOwner f46889t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap<Class<? extends Object>, Object> f46890u;

    public static final class Companion {
        public Companion() {
        }

        public static String b(String r100, int r101) {
            if (StringsKt.isBlank(r100) == false) goto L7;
            return String.valueOf(r101);
        L7:
            return r100 + '_' + r101;
        }

        public static BaseViewHolder a(String r100, int r101, ViewGroup r102) {
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            Intrinsics.checkNotNullParameter(r102, "parent");
            String r103 = b(r100, r101);
            r0 r104 = ECHybridListEngine.f46867v.get(r103);
            if (r104 == null) goto L7;
            BaseViewHolder r105 = r104.n(r102);
            if (r105 == null) goto L7;
            return r105;
        L7:
            return new EmptyViewHolder(new FrameLayout(r102.getContext()));
        }

        public static void c(String r100, int r101, LifecycleOwner r102, p0 r103) {
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r103, "holderCreator");
            if (r103.f46998a != null) goto L5;
            o0 r104 = null;
        L6:
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r103, "holderCreator");
            final String r105 = b(r100, r101);
            ECHybridListEngine.f46867v.put(r105, r103);
            if (r104 == null) goto L9;
            ECHybridListEngine.f46868w.put(Integer.valueOf(r101), r104);
        L9:
            r102.getLifecycle().addObserver(new ECHybridListEngine$Companion$registerNativeHolder$1(r105));
            return;
        L5:
            r104 = new o0(r103.f46998a);
            goto L6
        }

        public static void d(String r100, LifecycleOwner r101, Pair r102, Map r103) {
            Intrinsics.checkNotNullParameter(r100, "sceneID");
            Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r102, "itemDataTypeToTransformer");
            Intrinsics.checkNotNullParameter(r103, "itemTypeToCreators");
            int r104 = ((Number) r102.component1()).intValue();
            n0 r105 = (n0) r102.component2();
            ECHybridListEngine.f46868w.put(Integer.valueOf(r104), r105);
            final ArrayList r106 = new ArrayList();
            Iterator r107 = ((LinkedHashMap) r103).entrySet().iterator();
        L4:
            if (r107.hasNext() == false) goto L6;
            Map.Entry r108 = (Map.Entry) r107.next();
            int r109 = ((Number) r108.getKey()).intValue();
            r0 r110 = (r0) r108.getValue();
            String r111 = b(r100, r109);
            r106.add(r111);
            ECHybridListEngine.f46867v.put(r111, r110);
            goto L4
        L6:
            r101.getLifecycle().addObserver(new ECHybridListEngine$Companion$registerNativeHolder$2(r106));
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<Class<? extends Object>, Object> f46894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ECHybridListContainer f46895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LifecycleOwner f46896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f46897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public h f46898e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public l f46899f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<Function3<Long, Long, com.bytedance.android.ec.hybrid.list.util.d, Unit>> f46900g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<yj.b> f46901h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<Function2<Long, com.bytedance.android.ec.hybrid.list.util.d, Unit>> f46902i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<Function2<RecyclerView, Integer, Unit>> f46903j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Function2<? super String, ? super Boolean, Unit> f46904k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Function3<? super String, ? super Boolean, ? super Boolean, Unit> f46905l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Function1<? super ECHybridHolderUpdateParams, Unit> f46906m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f46907n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ListEngineOptConfig f46908o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public com.bytedance.android.ec.hybrid.list.opt.a f46909p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final List<Function1<String, Unit>> f46910q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Context f46911r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final String f46912s;

        public final ECHybridListEngine c() {
            if (this.f46895b == null) goto L27;
            if (this.f46896c == null) goto L27;
            Context r100 = this.f46911r;
            String r101 = this.f46912s;
            ECHybridListContainer r102 = this.f46895b;
            Intrinsics.checkNotNull(r102);
            LifecycleOwner r103 = this.f46896c;
            Intrinsics.checkNotNull(r103);
            ECHybridListEngine r104 = new ECHybridListEngine(r100, r101, r102, r103, this.f46894a);
            int r105 = this.f46897d;
            r104.f46871b.setEarlyCountForAutoLoad(r105);
            ListEngineOptConfig r106 = this.f46908o;
            r104.f46871b.setListEngineOpt(r106);
            com.bytedance.android.ec.hybrid.list.opt.a r107 = this.f46909p;
            r104.f46871b.setLoadMoreHelp(r107);
            h r108 = this.f46898e;
            r104.f46882m = r108;
            if (r108 == null) goto L12;
            l r109 = r104.f46877h;
            if (r109 == null) goto L11;
            r109.f47335a = r108;
        L11:
            r104.f46871b.addOnScrollListener(new HybridRecyclerViewPerformanceMonitor(r108));
        L12:
            l r110 = this.f46899f;
            r104.f46877h = r110;
            r104.f46871b.setLoadSession(r110);
            DataResolver r111 = r104.f46872c;
            r111.f46938d = new ECHybridListEngine$loadSession$1(r104.f46871b);
            DataResolver r112 = r104.f46872c;
            r112.f46940f = new ECHybridListEngine$loadSession$2(r104.f46871b);
            if (r110 == null) goto L15;
            r110.f47335a = r104.f46882m;
        L15:
            List<Function3<Long, Long, com.bytedance.android.ec.hybrid.list.util.d, Unit>> r113 = this.f46900g;
            r104.f46878i = r113;
            r104.f46871b.setFirstScreenCallbacks(r113);
            List<yj.b> r114 = this.f46901h;
            r104.f46879j = r114;
            r104.f46871b.setCardLoadLifecycleList(r114);
            List<Function2<Long, com.bytedance.android.ec.hybrid.list.util.d, Unit>> r115 = this.f46902i;
            r104.f46880k = r115;
            r104.f46871b.setAllLynxCardEndCallbacks(r115);
            List<Function2<RecyclerView, Integer, Unit>> r116 = this.f46903j;
            r104.f46881l = r116;
            r104.f46871b.setScrollStateChangedCallbacks(r116);
            Function2<? super String, ? super Boolean, Unit> r117 = this.f46904k;
            r104.f46883n = r117;
            if (r117 == null) goto L18;
            r104.f46870a.f46849j = r117;
        L18:
            Function3<? super String, ? super Boolean, ? super Boolean, Unit> r118 = this.f46905l;
            r104.f46884o = r118;
            if (r118 == null) goto L21;
            r104.f46870a.f46850k = r118;
        L21:
            Function1<? super ECHybridHolderUpdateParams, Unit> r119 = this.f46906m;
            r104.f46886q = r119;
            if (r119 == null) goto L24;
            r104.f46870a.f46851l = r119;
        L24:
            r104.f46885p = this.f46907n;
            DataResolver r120 = r104.f46872c;
            r120.f46939e = this.f46910q;
            return r104;
        L27:
            throw new IllegalArgumentException("adapter is null or lifecycle is null");
        }

        public final Context getContext() {
            return this.f46911r;
        }

        public final void a(Function3 r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            ((ArrayList) this.f46900g).add(r100);
        }

        public final void b(LifecycleOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "life");
            this.f46896c = r100;
        }

        public a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "sceneId");
            this.f46911r = r100;
            this.f46912s = r101;
            this.f46894a = new HashMap();
            this.f46900g = new ArrayList();
            this.f46901h = new ArrayList();
            this.f46902i = new ArrayList();
            this.f46903j = new ArrayList();
            this.f46910q = new ArrayList();
        }

        public final void d(Class r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "ability");
            this.f46894a.put(r100, r101);
        }
    }

    public interface b {
        void a(String r100);
    }

    public interface c {
        void a(int r100, String r101, boolean r102);
    }

    public static final class d extends ak.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ECHybridListEngine f46913f;

        @Override // ak.a
        public final ECHybridRecyclerView a() {
            return this.f46913f.f46871b;
        }

        public d(ECHybridListEngine r100, ECHybridListAdapter r101) {
            this.f46913f = r100;
            super(r101);
        }
    }

    public ECHybridListEngine() {
        throw null;
    }

    static {
        f46869x = new Companion();
        f46867v = new HashMap();
        f46868w = new HashMap();
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.w
    public final int a() {
        return this.f46871b.getScrollState();
    }

    public final int i() {
        ArrayList<ECHybridListItemVO> r100 = this.f46872c.f46943i;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final Integer j() {
        ArrayList<ECHybridListItemVO> r100 = this.f46872c.f46943i;
        if (r100 == null) goto L12;
        int r101 = r100.size() - 1;
    L5:
        if (r101 < 0) goto L12;
        ECHybridListItemVO r102 = (ECHybridListItemVO) CollectionsKt.getOrNull(r100, r101);
        if (r102 == null) goto L11;
        if (r102.I != true) goto L11;
        return Integer.valueOf(r101);
    L11:
        r101 = r101 - 1;
    L12:
        return null;
    }

    public final void l() {
        d r100 = this.f46876g;
        r100.getClass();
        if (Logger.debug() == false) goto L6;
        Logger.d("CardPreload_ECHLIdleHandler", "start isRunning = " + r100.f3974b);
    L6:
        if (r100.f3974b == true) goto L10;
        Looper.myQueue().removeIdleHandler(r100.f3975c);
        Looper.myQueue().addIdleHandler(r100.f3975c);
        r100.f3974b = true;
        return;
    }

    public final void c(k r100) {
        Intrinsics.checkNotNullParameter(r100, "listVO");
        this.f46872c.a(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.a
    public final <T> T getAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return r100.cast(this.f46890u.get(r100));
    }

    public final ECHybridListItemVO h(int r100) {
        return this.f46872c.g(r100);
    }

    public final void m(final com.bytedance.android.ec.hybrid.list.entity.g r100) {
        Intrinsics.checkNotNullParameter(r100, "preload");
        final ECHybridListAdapter r101 = this.f46870a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "preloadCard");
        List<com.bytedance.android.ec.hybrid.list.entity.h> r102 = r100.f47105b;
        if (r102 == null) goto L11;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        com.bytedance.android.ec.hybrid.list.entity.h r104 = (com.bytedance.android.ec.hybrid.list.entity.h) r103.next();
        if ((!r100.f47104a.isEmpty()) == true) goto L34;
        r104.getClass();
        goto L6
    L34:
        return;
    L11:
        List<p> r105 = r100.f47106c;
        if (r105 == null) goto L25;
        Iterator<T> r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L37;
        final p r107 = (p) r106.next();
        if ((!r100.f47104a.isEmpty()) == true) goto L35;
        Lazy r108 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "preload lynx view " + r107.f47147a + ", num is " + r107.f47148b);
        int r109 = r107.f47148b;
        int r110 = 0;
    L20:
        if (r110 >= r109) goto L15;
        if ((!r100.f47104a.isEmpty()) == true) goto L36;
        r101.G2(r107.f47147a, r107.f47149c, new ECHybridListAdapter$preloadCardAllowInterrupt$$inlined$let$lambda$1(r107, r101, r100));
        r110 = r110 + 1;
        goto L20
    L36:
        return;
    L35:
        return;
    L37:
        return;
    }

    public final int n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "section");
        DataResolver r101 = this.f46872c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sectionId");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L18;
        ArrayList<i> r103 = r101.f46937c;
        if (r103 == null) goto L18;
        Iterator<T> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L18;
        i r105 = (i) r104.next();
        if (Intrinsics.areEqual(r105.f47107a, r100) == false) goto L12;
        ArrayList<ECHybridListItemVO> r106 = r105.f47115i;
        if (r106 == null) goto L18;
        return r106.size();
    L18:
        return -1;
    L5:
        r102 = false;
        goto L6
    }

    public final void q(c r100) {
        DataResolver r101 = this.f46872c;
        r101.f46946l = r100;
        r101.b(r101.f46935a.R());
    }

    public final void r(k r100) {
        Intrinsics.checkNotNullParameter(r100, "listVO");
        DataResolver r101 = this.f46872c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        if (((LinkedList) r101.f46935a.R()).size() > 1) goto L5;
        r101.o(r100, true, "default");
        return;
    L5:
        HashMap<String, k.a> r102 = r100.f47129b;
        if (r102 == null) goto L10;
        HashMap<String, k.a> r103 = r101.f46936b;
        if (r103 == null) goto L10;
        r103.putAll(r102);
    L10:
        ArrayList<i> r104 = r100.f47130c;
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r101.r((i) r105.next(), null, null);
    L16:
        r101.f46949o++;
    }

    public static void k(ECHybridListEngine r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "schemeCountMap");
        ECHybridListAdapter r102 = r100.f46870a;
        ECHybridRecyclerView r103 = r100.f46871b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "schemeCountMap");
        Intrinsics.checkNotNullParameter(r103, "recyclerView");
        Iterator r104 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L16;
        Map.Entry r105 = (Map.Entry) r104.next();
        String r106 = (String) r105.getKey();
        int r107 = ((Number) r105.getValue()).intValue();
        if (r106 == null) goto L4;
        Stack<ECLynxCardHolder> r108 = new Stack();
        int r109 = Math.min(r107, 5);
        int r110 = 1;
        if (1 > r109) goto L15;
    L9:
        com.bytedance.android.ec.hybrid.list.util.e r111 = r102.f46846g;
        ECHybridListAdapter$preLoadOneCard$2 r112 = new ECHybridListAdapter$preLoadOneCard$2(r102, r106, null, r108);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        r111.a(r112);
    L13:
        if (r110 == r109) goto L15;
        r110 = r110 + 1;
        goto L9
    L12:
        r111.f47317a.post(new com.bytedance.android.ec.hybrid.list.util.f(r111, r112));
    L15:
        String r113 = ECHybridListAdapter.B2(r106);
        r102.f46844e.put(r113, r108);
        goto L4
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.a
    public final <T> void b(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "ability");
        this.f46890u.put(r100, r101);
    }

    public final Integer d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        DataResolver r102 = this.f46872c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "itemId");
        ECHybridListItemVO r103 = r102.d(r100, r101);
        if (r103 == null) goto L7;
        ArrayList<ECHybridListItemVO> r104 = r102.f46943i;
        if (r104 == null) goto L7;
        int r105 = r104.indexOf(r103);
    L8:
        Integer r106 = Integer.valueOf(r105);
        if (r106.intValue() < 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L16;
        return null;
    L16:
        return r106;
    L11:
        r107 = false;
    L7:
        r105 = -1;
        goto L8
    }

    public final BaseViewHolder e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        return this.f46870a.y2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    public final BaseViewHolder f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        ECHybridListAdapter r102 = this.f46870a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "itemId");
        DataResolver r103 = r102.f46840a;
        if (r103 == null) goto L35;
        Intrinsics.checkNotNullParameter(r101, "itemId");
        ArrayList r104 = new ArrayList();
        if (r100 == null) goto L18;
        i r105 = r103.f(r100);
        if (r105 == null) goto L18;
        ArrayList<ECHybridListItemVO> r106 = r105.f47115i;
        if (r106 == null) goto L16;
        List r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L17;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((ECHybridListItemVO) r109).f47029d, r101) == false) goto L12;
        r107.add(r109);
    L17:
        r104.addAll(r107);
        goto L18
    L16:
        r107 = CollectionsKt.emptyList();
    L18:
        ArrayList<ECHybridListItemVO> r110 = r103.f46943i;
        if (r110 == null) goto L26;
        List r111 = new ArrayList();
        Iterator<ECHybridListItemVO> r112 = r110.iterator();
    L22:
        if (r112.hasNext() == false) goto L27;
        ECHybridListItemVO r113 = r112.next();
        if (Intrinsics.areEqual(r113.f47029d, r101) == false) goto L22;
        r111.add(r113);
    L27:
        r104.addAll(r111);
        Iterator r114 = r104.iterator();
    L29:
        if (r114.hasNext() == false) goto L35;
        Object r115 = ((ECHybridListItemVO) r114.next()).T;
        if (r115 == null) goto L29;
        if ((r115 instanceof BaseViewHolder) == false) goto L29;
        return (BaseViewHolder) r115;
    L26:
        r111 = CollectionsKt.emptyList();
    L35:
        return null;
    }

    public final BaseViewHolder g(String r100, int r101) {
        DataResolver r102 = this.f46870a.f46840a;
        if (r102 == null) goto L11;
        ECHybridListItemVO r103 = r102.e(r100, r101);
        if (r103 == null) goto L11;
        Object r104 = r103.T;
        if (r104 == null) goto L11;
        if ((r104 instanceof BaseViewHolder) == false) goto L11;
        return (BaseViewHolder) r104;
    L11:
        return null;
    }

    public static /* synthetic */ void p(ECHybridListEngine r100, k r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 4) == 0) goto L9;
        String r104 = "default";
    L10:
        r100.o(r101, r103, r104);
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = false;
        goto L7
    }

    public final void o(k r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "listVO");
        Intrinsics.checkNotNullParameter(r102, ForwardDependency$ForwardLocation.FLAG);
        this.f46872c.o(r100, r101, r102);
    }

    public final void t(i r100, Boolean r101, Map<String, k.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "section");
        this.f46872c.r(r100, r101, null);
        if (r102 == null) goto L8;
        DataResolver r103 = this.f46872c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "itemConfigs");
        HashMap<String, k.a> r104 = r103.f46936b;
        if (r104 == null) goto L9;
        r104.putAll(r102);
        return;
    L9:
        return;
    }

    public static void s(ECHybridListEngine r100, i r101, Boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "section");
        r100.f46872c.r(r101, r102, null);
    }

    public ECHybridListEngine(Context r100, String r101, ECHybridListContainer r102, LifecycleOwner r103, HashMap r104) {
        this.f46888s = r101;
        this.f46889t = r103;
        this.f46890u = r104;
        ECHybridListAdapter r105 = new ECHybridListAdapter(r100, this, this);
        this.f46870a = r105;
        ECHybridRecyclerView r106 = r102.getRecyclerView();
        this.f46871b = r106;
        DataResolver r107 = new DataResolver(r105, r106);
        this.f46872c = r107;
        this.f46876g = new d(this, this.f46870a);
        Intrinsics.checkNotNullParameter(r107, "dataResolver");
        r105.f46840a = r107;
        com.bytedance.android.ec.hybrid.list.b r108 = new com.bytedance.android.ec.hybrid.list.b(r105);
        Intrinsics.checkNotNullParameter(r108, "listener");
        ((ArrayList) r107.f46945k).add(r108);
        r106.setAdapter(r105);
        r106.N(this, r101);
        r103.getLifecycle().addObserver(new AnonymousClass1(this));
        b(v.class, r107);
        b(z.class, new ListDataPool());
        b(w.class, this);
    }
}
