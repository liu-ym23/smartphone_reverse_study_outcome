package com.bytedance.android.livesdk.action;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseActionMethod<R> {
    private boolean isValid;
    private Callback mCallback;

    public interface Callback<R> {
        void onFail(Throwable r100);

        void onSuccess(R r100);
    }

    public abstract void invoke(Map<String, Object> r100) throws Exception;

    public void onDestroy() {
        this.isValid = false;
    }

    public abstract void onTerminate();

    public BaseActionMethod() {
        this.isValid = true;
    }

    public void terminate() {
        onTerminate();
        onDestroy();
    }

    private void setCallback(Callback r100) {
        this.mCallback = r100;
    }

    public final void finishWithError(Throwable r100) {
        if (this.isValid == false) goto L7;
        Callback r101 = this.mCallback;
        if (r101 == null) goto L7;
        r101.onFail(r100);
    L7:
        onDestroy();
    }

    public final void finishWithResult(R r100) {
        if (this.isValid == false) goto L7;
        Callback r101 = this.mCallback;
        if (r101 == null) goto L7;
        r101.onSuccess(r100);
    L7:
        onDestroy();
    }

    public void invokeWithCallback(String r100, Callback r101) throws Exception {
        setCallback(r101);
        Uri r102 = UriProtector.parse(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        HashMap r103 = new HashMap();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r102).iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        String r105 = r104.next();
        String r106 = UriProtector.getQueryParameter(r102, r105);
        if (TextUtils.isEmpty(r105) == true) goto L7;
        if (TextUtils.isEmpty(r106) == true) goto L7;
        r103.put(r105, r106);
        goto L7
    L14:
        invoke(r103);
    }
}
