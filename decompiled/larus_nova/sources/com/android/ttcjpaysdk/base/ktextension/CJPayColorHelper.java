package com.android.ttcjpaysdk.base.ktextension;

import android.graphics.Color;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J(\u0010\u0005\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/CJPayColorHelper;", "", "()V", "TAG", "", "safeParseColor", "", "colorString", "defaultColor", "", "colorStr", "success", "Lcom/android/ttcjpaysdk/base/ktextension/CJPayColorHelper$OnColorParseSuccess;", "failure", "Lcom/android/ttcjpaysdk/base/ktextension/CJPayColorHelper$OnColorParseFailure;", "OnColorParseFailure", "OnColorParseSuccess", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayColorHelper {
    public static final CJPayColorHelper INSTANCE = null;
    public static final String TAG = "CJPayColorHelper";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/CJPayColorHelper$OnColorParseFailure;", "", "onFailure", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnColorParseFailure {
        void onFailure();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/CJPayColorHelper$OnColorParseSuccess;", "", "onSuccess", "", "parseColor", "", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnColorParseSuccess {
        void onSuccess(int r100);
    }

    static {
        INSTANCE = new CJPayColorHelper();
    }

    private CJPayColorHelper() {
    }

    @JvmStatic
    public static final int safeParseColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "colorString");
        return safeParseColor$default(r100, 0, 2, null);
    }

    @JvmStatic
    public static final void safeParseColor(String r100, OnColorParseSuccess r101) {
        safeParseColor$default(r100, r101, null, 4, null);
    }

    @JvmStatic
    public static final int safeParseColor(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "colorString");
        return Color.parseColor(r100);
    L5:
        e = move-exception;
        a.f554342a.getClass();
        ALogService r102 = (ALogService) a.a(ALogService.class);
        if (r102 == null) goto L12;
        r102.e(TAG, "safeParseColor " + e.getMessage());
        return r101;
    L12:
        return r101;
    }

    @JvmStatic
    public static final void safeParseColor(String r100, OnColorParseSuccess r101, OnColorParseFailure r102) {
        if (r100 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == false) goto L23;
        if (r102 == null) goto L25;
        r102.onFailure();
        return;
    L25:
        return;
    L23:
        int r104 = Color.parseColor(r100);     // Catch: Exception -> L16
        if (r101 == null) goto L26;
        r101.onSuccess(r104);     // Catch: Exception -> L16
        return;
    L26:
        return;
    L16:
        e = move-exception;
        if (r102 == null) goto L19;
        r102.onFailure();
    L19:
        a.f554342a.getClass();
        ALogService r105 = (ALogService) a.a(ALogService.class);
        if (r105 == null) goto L27;
        r105.e(TAG, "safeParseColor " + e.getMessage());
        return;
    L27:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r103 = false;
        goto L8
    }

    public static /* synthetic */ int safeParseColor$default(String r100, int r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        return safeParseColor(r100, r101);
    }

    public static /* synthetic */ void safeParseColor$default(String r100, OnColorParseSuccess r101, OnColorParseFailure r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        safeParseColor(r100, r101, r102);
    }
}
