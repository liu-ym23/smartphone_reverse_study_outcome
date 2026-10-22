package com.obric.appstore.buss.myapp.sysapp;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.base.j;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.network.g;
import com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
public final class SysAppVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LoadSysAppUseCase f10727i;

    /* JADX WARN: Multi-variable type inference failed */
    public SysAppVM() {
        BaseApplication r10 = BaseApplication.c();
        q.f(r10, "getContext(...)");
        this.f10727i = new LoadSysAppUseCase(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ Object v(SysAppVM r10, Continuation r11) {
        return r10.w(r11);
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(j r10, Continuation r11) {
        if ((r11 instanceof SysAppVM$doLoad$1) == false) goto L7;
        SysAppVM$doLoad$1 r12 = (SysAppVM$doLoad$1) r11;
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
        c.b(r14);
    L23:
        return new g.d((List) r14);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (j) r12.L$1;
        SysAppVM this = (SysAppVM) r12.L$0;
        c.b(r14);
    L19:
        com.bytedanceos.common.toolbox.j.n("SysAppVM doLoad() localCache loaded: loadParams = " + r10);
        r12.L$0 = null;
        r12.L$1 = null;
        r12.label = 2;
        r14 = this.w(r12);
        if (r14 != r15) goto L23;
        return r15;
    L16:
        c.b(r14);
        com.bytedanceos.common.toolbox.j.n("SysAppVM doLoad() waitLocalCacheInitialLoad: loadParams = " + r10);
        AppsManager r17 = AppsManager.f10585a;
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 1;
        if (r17.r(r12) != r15) goto L19;
        return r15;
    L7:
        r12 = new SysAppVM$doLoad$1(this, r11);
        goto L8
    }

    public final Object w(Continuation r10) {
        if ((r10 instanceof SysAppVM$loadSysApps$1) == false) goto L7;
        SysAppVM$loadSysApps$1 r11 = (SysAppVM$loadSysApps$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        c.b(r13);
    L17:
        Object r16 = ((Result) r13).m44unboximpl();
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 != null) goto L20;
        List r18 = (List) r16;
    L21:
        ArrayList r19 = new ArrayList(u.r(r18, 10));
        Iterator r20 = r18.iterator();
        int r21 = 0;
    L23:
        if (r20.hasNext() == false) goto L32;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L27;
        t.q();
    L27:
        AppInfo r24 = (AppInfo) r22;
        if (r21 == t.k(r18)) goto L30;
        boolean r25 = true;
    L31:
        r19.add(new a.C0168a(r24, r25));
        r21 = r23;
        goto L23
    L30:
        r25 = false;
        goto L31
    L32:
        return r19;
    L20:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][SysApp] SysAppVM loadSysApps() failed: " + r17);
        r18 = t.i();
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r13);
        Flow r26 = this.f10727i.l();
        r11.label = 1;
        r13 = kotlinx.coroutines.flow.c.u(r26, r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new SysAppVM$loadSysApps$1(this, r10);
        goto L8
    }
}
