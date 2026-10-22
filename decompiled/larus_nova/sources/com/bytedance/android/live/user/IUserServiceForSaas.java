package com.bytedance.android.live.user;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/user/IUserServiceForSaas;", "", "getAuthToastTimeWithID", "", "openID", "", "showAuthOrDailyToast", "", "isDailyToast", "", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserServiceForSaas {
    long getAuthToastTimeWithID(String r100);

    void showAuthOrDailyToast(boolean r100);
}
