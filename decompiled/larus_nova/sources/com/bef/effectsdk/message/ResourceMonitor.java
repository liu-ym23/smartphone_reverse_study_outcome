package com.bef.effectsdk.message;

import android.os.Message;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes39.dex */
public class ResourceMonitor implements MessageInterceptor {
    private static final String TAG = "ResourceMonitor";
    private Listener mListener;

    public interface Listener {
        void onResourceLoadFinish(String r100, boolean r101);
    }

    public ResourceMonitor() {
    }

    @Override // com.bef.effectsdk.message.MessageInterceptor
    public void destroy() {
        this.mListener = null;
    }

    public void reset() {
    }

    @Override // com.bef.effectsdk.message.MessageInterceptor
    public boolean intercept(Message r100) {
        if (17 != r100.what) goto L19;
        String r101 = (String) r100.obj;
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return true;
    L7:
        int r102 = r100.arg1;
        if (r102 != 3) goto L10;
        Listener r103 = this.mListener;
        if (r103 == null) goto L18;
        r103.onResourceLoadFinish(r101, true);
    L18:
        return true;
    L10:
        if (r102 != 4) goto L18;
        Listener r104 = this.mListener;
        if (r104 == null) goto L18;
        r104.onResourceLoadFinish(r101, false);
        goto L18
    L19:
        return false;
    }

    public void setListener(Listener r100) {
        this.mListener = r100;
    }
}
