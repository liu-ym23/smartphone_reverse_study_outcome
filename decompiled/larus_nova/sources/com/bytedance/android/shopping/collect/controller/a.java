package com.bytedance.android.shopping.collect.controller;

import com.bytedance.android.shopping.collect.common.controller.CollectHandleEventOpportunity;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.e;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements nb3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f172164a;

    @Override // nb3.b
    public final void a() {
        kb3.a r100 = this.f172164a.f172165a.f172137n;
        CollectHandleEventOpportunity r101 = CollectHandleEventOpportunity.RECEIVE_PRODUCTS_CLEAN_UP;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "opportunity");
        Function0<AndroidYaTaInstance> r102 = r100.f502204a;
        if (r102 == null) goto L13;
        AndroidYaTaInstance r103 = r102.invoke();
        if (r103 == null) goto L16;
        lb3.a r104 = r100.f502209f;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "opportunity");
        Intrinsics.checkNotNullParameter(r103, "yataInstance");
        lb3.a.C6670a r105 = r104.f508345a.get(r101.getValue());
        Lazy r106 = CollectCommonLog.f172289a;
        CollectCommonLog.c("CollectHandleEventController", "handleEvent  opportunity:" + r101 + "    info:" + r105);
        if (r105 == null) goto L14;
        r103.k().d(e.f251660a.a(r103, null, r105.f508349d, r105.f508346a, null, "CollectHandleEventController"));
        if (r105.f508348c == true) goto L15;
        r104.f508345a.remove(r101.getValue());
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public a(b r100) {
        this.f172164a = r100;
    }
}
