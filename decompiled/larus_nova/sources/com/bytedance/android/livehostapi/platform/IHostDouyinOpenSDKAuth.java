package com.bytedance.android.livehostapi.platform;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/IHostDouyinOpenSDKAuth;", "", "getAccessToken", "", "getAccessTokenAsync", "", "callback", "Lcom/bytedance/android/livehostapi/platform/IHostDouyinOpenSDKAuth$Callback;", "getClientKey", Keys.API_RETURN_KEY_IS_LOGIN, "", "login", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lcom/bytedance/android/livehostapi/platform/depend/user/ILoginCallback;", "updateAccessCode", "code", "Callback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostDouyinOpenSDKAuth {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/IHostDouyinOpenSDKAuth$Callback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onFailed", "", LynxError.LYNX_THROWABLE, "", "onSuccess", "param", "(Ljava/lang/Object;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback<T> {
        void onFailed(Throwable r100);

        void onSuccess(T r100);
    }

    String getAccessToken();

    void getAccessTokenAsync(Callback<String> r100);

    String getClientKey();

    boolean isLogin();

    void login(Context r100, ILoginCallback r101);

    void updateAccessCode(String r100, Callback<String> r101);
}
