package com.bytedance.android.livesdk.action.instance;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@ActionMethod("webcast_inroom_toast")
public class ToastAction extends BaseActionMethod<Void> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public ToastAction() {
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r100) throws Exception {
        Object r101 = r100.get("content");
        if (r101 == null) goto L6;
        f2.c(r101.toString(), 0);
        finishWithResult(null);
        return;
    }
}
