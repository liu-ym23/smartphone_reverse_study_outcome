package com.obric.appstore.buss.myapp.myapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.l0;
import bg.h;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.base.j;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.network.g;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.domain.app.l;
import com.smt.obric.appstore.domain.usecase.app.install.CancelAppInstallUseCase;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.a0;
import kotlin.collections.b0;
import kotlin.collections.j0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.StateFlow;
import s8.d;

/* JADX INFO: loaded from: classes3.dex */
public final class MyAppVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LiveData f10710i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f10711j;

    public MyAppVM() {
        this.f10710i = Transformations.a(k(), MyAppVM$dataCount$1.INSTANCE);
        this.f10711j = new LinkedHashMap();
    }

    public static final /* synthetic */ CancelAppInstallUseCase v(MyAppVM r10) {
        return r10.y();
    }

    public final AppInstallActor A() {
        return AppInstallActor.f17891n.b();
    }

    public final Object B(Continuation r24) {
        List r10 = (List) A().S().getValue();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L49;
        Object r13 = r12.next();
        com.smt.obric.appstore.domain.app.entity.a r14 = (com.smt.obric.appstore.domain.app.entity.a) r13;
        if (r14.M() == true) goto L4;
        AppStatus r15 = r14.G();
        if (q.b(r15, AppStatus.a.f17968a) == true) goto L46;
        if (q.b(r15, AppStatus.b.f17970a) == true) goto L46;
        if (q.b(r15, AppStatus.c.f17972a) == true) goto L46;
        if (q.b(r15, AppStatus.d.f17974a) == true) goto L46;
        if (q.b(r15, AppStatus.e.f17976a) == true) goto L46;
        if (q.b(r15, AppStatus.f.f17978a) == true) goto L46;
        if (q.b(r15, AppStatus.g.f17980a) == true) goto L46;
        if (q.b(r15, AppStatus.h.f17982a) == true) goto L46;
        if (q.b(r15, AppStatus.j.f17986a) == true) goto L46;
        if (q.b(r15, AppStatus.i.f17984a) == true) goto L4;
        if (q.b(r15, AppStatus.k.f17988a) == true) goto L4;
        if (q.b(r15, AppStatus.m.f17992a) == true) goto L4;
        if (q.b(r15, AppStatus.l.f17990a) == true) goto L46;
        throw new NoWhenBranchMatchedException();
    L46:
        r11.add(r13);
        goto L4
    L49:
        d r16 = new d(t.n(new AppFilter[]{s8.b.c(), s8.b.a()}));
        ArrayList r17 = new ArrayList();
        Iterator r18 = r11.iterator();
    L51:
        if (r18.hasNext() == false) goto L64;
        com.smt.obric.appstore.domain.app.entity.a r19 = (com.smt.obric.appstore.domain.app.entity.a) r18.next();
        AppInfo r20 = (AppInfo) this.f10711j.get(r19.E());
        if (r20 != null) goto L62;
        String r21 = r19.g();
        r20 = null;
        if (r21 == null) goto L58;
        AppInfo r22 = l.f18037a.a(r21, 0, 0, 0, "", "", 0, 0, tf.a.d(0), null);
    L59:
        if (r22 == null) goto L62;
        this.f10711j.put(r19.E(), r22);
        r20 = r22;
        goto L62
    L58:
        r22 = null;
    L62:
        if (r20 == null) goto L51;
        r17.add(r20);
        goto L51
    L64:
        ArrayList r23 = new ArrayList();
        Iterator r25 = r17.iterator();
    L66:
        if (r25.hasNext() == false) goto L72;
        Object r26 = r25.next();
        AppInfo r27 = (AppInfo) r26;
        if (r27.isSystemApp() == true) goto L66;
        if (r16.filter(r27) == true) goto L66;
        r23.add(r26);
        goto L66
    L72:
        Comparator<AppInfo> r28 = AppInfo.getComparator();
        q.f(r28, "getComparator(...)");
        List r29 = b0.t0(r23, r28);
        List r30 = x().v("LOCAL_APPS_ONLINE");
        if (r30 != null) goto L75;
        r30 = t.i();
    L75:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
    L77:
        if (r32.hasNext() == false) goto L81;
        Object r33 = r32.next();
        if (com.obric.appstore.buss.apps.a.f10594a.a().contains(((AppInfo) r33).appPackageName) == true) goto L77;
        r31.add(r33);
        goto L77
    L81:
        List r34 = b0.z0(r31);
        Comparator<AppInfo> r35 = AppInfo.getComparator();
        q.f(r35, "getComparator(...)");
        x.u(r34, r35);
        a0.O(r34);
        LinkedHashMap r36 = new LinkedHashMap(h.d(j0.e(u.r(r34, 10)), 16));
        Iterator r37 = r34.iterator();
    L82:
        String r38 = "";
        if (r37.hasNext() == false) goto L89;
        Object r39 = r37.next();
        String r40 = ((AppInfo) r39).appPackageName;
        if (r40 == null) goto L88;
        q.d(r40);
        r38 = r40;
    L88:
        r36.put(r38, r39);
        goto L82
    L89:
        ArrayList r41 = new ArrayList();
        if (r29.isEmpty() == true) goto L103;
        r41.add(new b.c(0, r29.size(), false));
        ArrayList r42 = new ArrayList(u.r(r29, 10));
        Iterator r43 = r29.iterator();
    L93:
        if (r43.hasNext() == false) goto L101;
        AppInfo r44 = (AppInfo) r43.next();
        String r110 = r44.appPackageName;
        if (r110 != null) goto L97;
        r110 = "";
    L97:
        AppInfo r111 = (AppInfo) r36.get(r110);
        if (r111 == null) goto L100;
        r44 = r44.clone();
        q.f(r44, "clone(...)");
        r44.appBrief = r111.appBrief;
        r44.appCategoryName = r111.appCategoryName;
        r44.recmd_brief = r111.recmd_brief;
    L100:
        r42.add(new b.a(r44, 0, false, 4, null));
        goto L93
    L101:
        y.v(r41, r42);
    L103:
        if (r34.isEmpty() == true) goto L109;
        r41.add(new b.c(1, r34.size(), !r29.isEmpty()));
        ArrayList r45 = new ArrayList(u.r(r34, 10));
        Iterator r46 = r34.iterator();
    L106:
        if (r46.hasNext() == false) goto L108;
        AppInfo r47 = (AppInfo) r46.next();
        q.d(r47);
        r45.add(new b.a(r47, 1, false, 4, null));
        goto L106
    L108:
        y.v(r41, r45);
    L109:
        return r41;
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(j r10, Continuation r11) {
        if ((r11 instanceof MyAppVM$doLoad$1) == false) goto L7;
        MyAppVM$doLoad$1 r12 = (MyAppVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        kotlin.c.b(r14);
    L23:
        return new g.d(r14);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MyAppVM this = (MyAppVM) r12.L$0;
        kotlin.c.b(r14);
    L19:
        r12.L$0 = null;
        r12.label = 2;
        r14 = this.B(r12);
        if (r14 != r15) goto L23;
        return r15;
    L16:
        kotlin.c.b(r14);
        StateFlow r17 = AppsManager.f10585a.h();
        MyAppVM$doLoad$2 r18 = new MyAppVM$doLoad$2(null);
        r12.L$0 = this;
        r12.label = 1;
        if (kotlinx.coroutines.flow.c.v(r17, r18, r12) != r15) goto L19;
        return r15;
    L7:
        r12 = new MyAppVM$doLoad$1(this, r11);
        goto L8
    }

    public final void w(AppInfo r10) {
        q.g(r10, "appInfo");
        kotlinx.coroutines.h.d(l0.a(this), null, null, new MyAppVM$cancelDownload$1(this, r10, null), 3, null);
    }

    public final CommonCache x() {
        return BaseApplication.c().b();
    }

    public final CancelAppInstallUseCase y() {
        return new CancelAppInstallUseCase(A());
    }

    public final LiveData z() {
        return this.f10710i;
    }
}
