package com.android.ttcjpaysdk.facelive.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/FaceLiveFactory;", "", "()V", "getFaceLiveImpl", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive;", "channel", "", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceLiveFactory {
    public static final FaceLiveFactory INSTANCE = null;

    static {
        INSTANCE = new FaceLiveFactory();
    }

    private FaceLiveFactory() {
    }

    public final IFaceLive getFaceLiveImpl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        int r101 = r100.hashCode();
        if (r101 == (-80305799)) goto L17;
        if (r101 == 291057079) goto L13;
        if (r101 != 781322474) goto L22;
        if (r100.equals("ALIYUNFIA") == false) goto L22;
    L20:
        return new FaceLiveAiLabImpl();
    L22:
        return new FaceLiveDefaultImpl();
    L13:
        if (r100.equals("KSKJFIA") == false) goto L22;
        return new FaceLiveKSImpl();
    L17:
        if (r100.equals("AILABFIA") == true) goto L20;
        goto L20
    }
}
