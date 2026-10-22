package com.bytedance.android.live.saas.middleware.login;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.IConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/login/LoginProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "Lcom/bytedance/android/live/saas/middleware/login/ILogin;", "Lcom/bytedance/android/live/saas/middleware/login/LoginConfig;", "()V", "create", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "conf", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class LoginProxy implements IConfiguration<ILogin<?>, LoginConfig> {
    public LoginProxy() {
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<ILogin<?>, LoginConfig> create2(LoginConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "conf");
        return new AnonymousClass1();
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<ILogin<?>, LoginConfig> create(LoginConfig r100) {
        return create2(r100);
    }
}
