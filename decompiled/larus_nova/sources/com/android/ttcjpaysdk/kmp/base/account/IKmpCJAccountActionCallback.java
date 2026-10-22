package com.android.ttcjpaysdk.kmp.base.account;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/account/IKmpCJAccountActionCallback;", "", "loginFinishCallback", "", "success", "", "logoutFinishCallback", "switchAccountFinishCallback", "getCallbackId", "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJAccountActionCallback {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void loginFinishCallback(IKmpCJAccountActionCallback r100, boolean r101) {
        }

        public static void logoutFinishCallback(IKmpCJAccountActionCallback r100, boolean r101) {
        }

        public static void switchAccountFinishCallback(IKmpCJAccountActionCallback r100, boolean r101) {
        }
    }

    String getCallbackId();

    void loginFinishCallback(boolean r100);

    void logoutFinishCallback(boolean r100);

    void switchAccountFinishCallback(boolean r100);
}
