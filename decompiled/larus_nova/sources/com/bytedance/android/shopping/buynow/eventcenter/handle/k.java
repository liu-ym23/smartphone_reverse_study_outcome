package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia3.b f170962a;

    public static final class a {
    }

    static {
    }

    public k(ia3.b r100) {
        this.f170962a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        BuyNowLog.d("selfLoading", "selfLoading starts");
        Map<String, Object> r102 = r100.q();
        if (r102 == null) goto L9;
        Object r103 = r102.get(ForwardDependency$ForwardLocation.FLAG);
        if (r103 == null) goto L9;
        String r104 = r103.toString();
        if (r104 == null) goto L9;
        boolean r105 = com.bytedance.android.shopping.extensions.k.n(r104, false);
    L10:
        if (r105 == false) goto L14;
        ia3.b r106 = this.f170962a;
        if (r106 == null) goto L17;
        r106.b(new ia3.c(false, false));
    L17:
        BuyNowLog.d("selfLoading", "selfLoading finishes");
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L14:
        ia3.b r108 = this.f170962a;
        if (r108 == null) goto L17;
        r108.c();
    L9:
        r105 = false;
        goto L10
    }
}
