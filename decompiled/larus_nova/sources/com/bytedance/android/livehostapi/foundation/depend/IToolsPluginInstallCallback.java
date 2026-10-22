package com.bytedance.android.livehostapi.foundation.depend;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/IToolsPluginInstallCallback;", "", "onFailure", "", LynxError.LYNX_THROWABLE, "", "onSuccess", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IToolsPluginInstallCallback {
    void onFailure(Throwable r100);

    void onSuccess();
}
