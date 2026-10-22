package com.obric.autogui.platforms.tools.b;

import android.content.Context;
import com.obric.aiagent.utils.shared_state.b;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.account.IAutoActionAccountApi;
import com.obric.autogui.common.api.platform.account.LoggedInUserInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.d;
import d.h.b.h;
import java.util.Map;

/* JADX INFO: compiled from: FlowAccountApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IAutoActionAccountApi {
    private static final String TAG = "Acc/FlowAccountApi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0799a f30133a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlowAccountApi.kt */
    public static final class C0799a {
        public /* synthetic */ C0799a(h r1) {
            this();
        }

        private C0799a() {
        }
    }

    static {
        f30133a = new C0799a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.common.api.platform.account.IAutoActionAccountApi
    public IAutoActionAccountApi.UserInfoAcquiringResult acquireUserInfo() {
        if (b.f22344a.f() == true) goto L6;
        Loog.INSTANCE.i(TAG, " - [UserInfo] the user is not logged in.");
        return new IAutoActionAccountApi.UserInfoAcquiringResult(1, null, 2, null);
    L6:
        long r3 = System.currentTimeMillis();
        String r8 = b.f22344a.b();     // Catch: Throwable -> L16
        Map<String, String> r5 = b.f22344a.e();     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        r5 = ao.b();     // Catch: Throwable -> L16
    L10:
        long r6 = System.currentTimeMillis() - r3;
        if (r8 == null) goto L15;
        Loog.INSTANCE.d(TAG, "acquired user-info; latency: " + r6 + "ms");
        return new IAutoActionAccountApi.UserInfoAcquiringResult(0, new LoggedInUserInfo(r8, r5));
    L15:
        return new IAutoActionAccountApi.UserInfoAcquiringResult(2, null, 2, null);
    L16:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - [UserInfo] get user-info failed; AccountException: " + th.getMessage());
        return new IAutoActionAccountApi.UserInfoAcquiringResult(2, null, 2, null);
    }

    @Override // com.obric.autogui.common.api.platform.account.IAutoActionAccountApi
    public Object checkLoggedOn(Context r2, d<? super IAutoActionAccountApi.LoggedOnCheckResult> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (b.f22344a.f() == false) goto L7;
        return new IAutoActionAccountApi.LoggedOnCheckResult(IAutoActionAccountApi.LoggedOnType.LOGGED_ON);
    L7:
        return new IAutoActionAccountApi.LoggedOnCheckResult(IAutoActionAccountApi.LoggedOnType.DOUBAO_NOT_LOGGED_ON);
    }
}
