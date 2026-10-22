package com.bytedance.android.livehostapi.platform;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.depend.Callback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J\b\u0010\r\u001a\u00020\u0007H&J,\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H&J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J$\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H&¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/IHostAccountAuth;", "Lcom/bytedance/android/live/base/IService;", "getDouyinToken", "", "getNickname", "getOpenId", "hasBoundDouyin", "", "hasDouyinInteractivePrivilege", "hasDouyinInteractivePrivilegeAsync", "", "callback", "Lcom/bytedance/android/livehostapi/platform/depend/Callback;", Keys.API_RETURN_KEY_IS_LOGIN, "loginOrBindDouyin", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lcom/bytedance/android/livehostapi/platform/depend/user/ILoginCallback;", "extra", "", "refreshDouyinToken", "requestInteractivePrivilege", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostAccountAuth extends IService {
    String getDouyinToken();

    String getNickname();

    String getOpenId();

    boolean hasBoundDouyin();

    boolean hasDouyinInteractivePrivilege();

    void hasDouyinInteractivePrivilegeAsync(Callback<Boolean> r100);

    boolean isLogin();

    void loginOrBindDouyin(Context r100, ILoginCallback r101, Map<String, String> r102);

    void refreshDouyinToken(Callback<String> r100);

    void requestInteractivePrivilege(ILoginCallback r100, Map<String, String> r101);
}
