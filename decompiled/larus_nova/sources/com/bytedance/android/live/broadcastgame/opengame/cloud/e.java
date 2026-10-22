package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f59819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f59820b = null;

    static {
        f59819a = ((IHostContext) k.n(IHostContext.class)).getServerDeviceId();
        f59820b = ((IUserService) k.n(IUserService.class)).user().getSessionKey();
    }
}
