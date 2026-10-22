package com.bytedanceos.common;

import com.bytedanceos.common.model.AppInfo;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonCacheKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f9580a;

    public CommonCacheKtx() {
        this.f9580a = d0.b();
    }

    public final void a(AppInfo r10) {
        q.g(r10, "appInfo");
        h.d(this.f9580a, null, null, new CommonCacheKtx$cancelDownloadTask$1(r10, null), 3, null);
    }

    public final int b(List r10) {
        if (r10 != null) goto L5;
    L25:
        return 0;
    L5:
        if (r10.isEmpty() == true) goto L25;
        ArrayList r11 = new ArrayList(u.r(r10, 10));
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r11.add(((AppInfo) r12.next()).appPackageName);
        goto L9
    L11:
        Set r13 = b0.B0(r11);
        List r14 = t.l(new AppStatus.DownloadStatus[]{AppStatus.d.f17974a, AppStatus.c.f17972a});
        Iterable r15 = (Iterable) AppInstallActor.f17891n.b().S().getValue();
        if ((r15 instanceof Collection) == true) goto L14;
    L16:
        Iterator r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L34;
        com.smt.obric.appstore.domain.app.entity.a r17 = (com.smt.obric.appstore.domain.app.entity.a) r16.next();
        if (r13.contains(r17.E()) == false) goto L18;
        if (b0.S(r14, r17.G()) == false) goto L18;
        return 2;
    L34:
        return 1;
    L14:
        if (((Collection) r15).isEmpty() == false) goto L16;
        return 1;
    }
}
