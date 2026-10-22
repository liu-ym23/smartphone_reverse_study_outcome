package com.obric.appstore.util;

import com.bytedanceos.common.toolbox.b0;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes3.dex */
public final class ApiEvn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ApiEvn f11052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f11053b = null;

    static {
        f11052a = new ApiEvn();
        f11053b = kotlin.b.b(ApiEvn$ppe$2.INSTANCE);
    }

    public ApiEvn() {
    }

    public final String a() {
        return (String) f11053b.getValue();
    }

    public final void b(String r10) {
        kotlin.jvm.internal.q.g(r10, "ppe");
        if (kotlin.jvm.internal.q.b(r10, a()) == true) goto L6;
        b0.n().G("sp_ppe", r10, "obric_debug_sp");
        return;
    }
}
