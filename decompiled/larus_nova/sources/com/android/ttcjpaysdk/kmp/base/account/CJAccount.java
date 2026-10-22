package com.android.ttcjpaysdk.kmp.base.account;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/account/CJAccount;", "Lcom/android/ttcjpaysdk/kmp/base/account/IKmpCJAccountService;", "<init>", "()V", "getCurrentUid", "", "openUserProfileQuickSwitch", "", "enterFrom", "enterMethod", "keepPagesUrl", "", "registerAccountActionCallback", "callback", "Lcom/android/ttcjpaysdk/kmp/base/account/IKmpCJAccountActionCallback;", "unRegisterAccountActionCallback", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJAccount implements IKmpCJAccountService {
    public static final int $stable = 0;
    public static final CJAccount INSTANCE = null;

    static {
        INSTANCE = new CJAccount();
    }

    private CJAccount() {
    }

    @Override // com.android.ttcjpaysdk.kmp.base.account.IKmpCJAccountService
    public String getCurrentUid() {
        b r100 = c.f528682a;
        IKmpCJAccountService r101 = (IKmpCJAccountService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAccountService.class));
        if (r101 == null) goto L6;
        String r102 = r101.getCurrentUid();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // com.android.ttcjpaysdk.kmp.base.account.IKmpCJAccountService
    public void registerAccountActionCallback(IKmpCJAccountActionCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = c.f528682a;
        IKmpCJAccountService r102 = (IKmpCJAccountService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAccountService.class));
        if (r102 == null) goto L6;
        r102.registerAccountActionCallback(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.account.IKmpCJAccountService
    public void unRegisterAccountActionCallback(IKmpCJAccountActionCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = c.f528682a;
        IKmpCJAccountService r102 = (IKmpCJAccountService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAccountService.class));
        if (r102 == null) goto L6;
        r102.unRegisterAccountActionCallback(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.account.IKmpCJAccountService
    public void openUserProfileQuickSwitch(String r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "keepPagesUrl");
        b r103 = c.f528682a;
        IKmpCJAccountService r104 = (IKmpCJAccountService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAccountService.class));
        if (r104 == null) goto L6;
        r104.openUserProfileQuickSwitch(r100, r101, r102);
        return;
    }
}
