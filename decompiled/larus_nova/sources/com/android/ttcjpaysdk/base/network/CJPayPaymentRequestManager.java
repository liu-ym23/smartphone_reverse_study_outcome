package com.android.ttcjpaysdk.base.network;

import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/network/CJPayPaymentRequestManager;", "", "()V", "pendingRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "addRequest", "key", "removeRequest", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPaymentRequestManager {
    public static final CJPayPaymentRequestManager INSTANCE = null;
    private static final ConcurrentHashMap<String, Boolean> pendingRequests = null;

    private CJPayPaymentRequestManager() {
    }

    static {
        INSTANCE = new CJPayPaymentRequestManager();
        pendingRequests = new ConcurrentHashMap();
    }

    public final boolean addRequest(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return true;
    L12:
        if (CJPaySettingsManager.getInstance().isNeedForDupPayOpt() == true) goto L14;
        return true;
    L14:
        if (pendingRequests.putIfAbsent(r100, Boolean.TRUE) != null) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void removeRequest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        pendingRequests.remove(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
