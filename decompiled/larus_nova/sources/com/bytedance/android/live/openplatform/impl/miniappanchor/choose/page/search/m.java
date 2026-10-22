package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: classes46.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPrefHelper f84285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f84286b;

    public m() {
        this.f84285a = SharedPrefHelper.b(s1.getContext());
        StringBuilder r100 = new StringBuilder("opensearch:");
        IUserService r101 = (IUserService) jc1.k.f(IUserService.class);
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.user.f r102 = r101.user();
        if (r102 == null) goto L7;
        String r103 = r102.n();
    L8:
        r100.append(r103);
        this.f84286b = r100.toString();
        return;
    L7:
        r103 = null;
        goto L8
    }
}
