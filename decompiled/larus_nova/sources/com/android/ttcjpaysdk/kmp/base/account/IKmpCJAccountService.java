package com.android.ttcjpaysdk.kmp.base.account;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/account/IKmpCJAccountService;", "Lcom/bytedance/kmp/spi/IKmpService;", "getCurrentUid", "", "openUserProfileQuickSwitch", "", "enterFrom", "enterMethod", "keepPagesUrl", "", "registerAccountActionCallback", "callback", "Lcom/android/ttcjpaysdk/kmp/base/account/IKmpCJAccountActionCallback;", "unRegisterAccountActionCallback", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJAccountService extends a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openUserProfileQuickSwitch$default(IKmpCJAccountService r100, String r101, String r102, List r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = "switch_account";
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = CollectionsKt.emptyList();
        L9:
            r100.openUserProfileQuickSwitch(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openUserProfileQuickSwitch");
        }
    }

    String getCurrentUid();

    void openUserProfileQuickSwitch(String r100, String r101, List<String> r102);

    void registerAccountActionCallback(IKmpCJAccountActionCallback r100);

    void unRegisterAccountActionCallback(IKmpCJAccountActionCallback r100);
}
