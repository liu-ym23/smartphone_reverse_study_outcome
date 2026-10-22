package com.android.ttcjpaysdk.cybs.jsb;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.android.ttcjpaysdk.cybs.callback.CybsJsbCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/cybs/jsb/CybsBridge;", "", "callback", "Lcom/android/ttcjpaysdk/cybs/callback/CybsJsbCallback;", "(Lcom/android/ttcjpaysdk/cybs/callback/CybsJsbCallback;)V", "getCallback", "()Lcom/android/ttcjpaysdk/cybs/callback/CybsJsbCallback;", "setCallback", "collectDDCInfo", "", "deviceInfo", "", "ddcCallback", "resultCode", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CybsBridge {
    private CybsJsbCallback callback;

    public final CybsJsbCallback getCallback() {
        return this.callback;
    }

    public CybsBridge(CybsJsbCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.callback = r100;
    }

    @JavascriptInterface
    public final void collectDDCInfo(final String r100) {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r100));
    }

    @JavascriptInterface
    public final void ddcCallback(final String r100) {
        new Handler(Looper.getMainLooper()).post(new RunnableC91561(this, r100));
    }

    public final void setCallback(CybsJsbCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.callback = r100;
    }
}
