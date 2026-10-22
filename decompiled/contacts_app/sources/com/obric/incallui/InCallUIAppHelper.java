package com.obric.incallui;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.GlobalProxyLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InCallUIAppHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/incallui/InCallUIAppHelper;", "", "()V", "AUTHORITY", "", "METHOD_PARAMETER_CALL_CREATE_TIME", "METHOD_PARAMETER_PHONE_NUMBER", InCallUIAppHelper.METHOD_RECORD_FILE_ASR_RETRY, "SCHEME_CONTENT", "TAG", "inCallUIASRProviderUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getInCallUIASRProviderUri", "()Landroid/net/Uri;", "inCallUIASRProviderUri$delegate", "Lkotlin/Lazy;", "notifyRetryRecordASR", "", "context", "Landroid/content/Context;", "callCreateTime", "", "phoneNumber", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InCallUIAppHelper {
    private static final String AUTHORITY = "incallui_asr";
    public static final InCallUIAppHelper INSTANCE = null;
    private static final String METHOD_PARAMETER_CALL_CREATE_TIME = "call_create_time";
    private static final String METHOD_PARAMETER_PHONE_NUMBER = "phone_number";
    private static final String METHOD_RECORD_FILE_ASR_RETRY = "METHOD_RECORD_FILE_ASR_RETRY";
    private static final String SCHEME_CONTENT = "content";
    private static final String TAG = "InCallUIAppHelper";
    private static final Lazy inCallUIASRProviderUri$delegate = null;

    private InCallUIAppHelper() {
    }

    static {
        INSTANCE = new InCallUIAppHelper();
        inCallUIASRProviderUri$delegate = LazyKt.lazy(InCallUIAppHelper$inCallUIASRProviderUri$2.INSTANCE);
    }

    private final Uri getInCallUIASRProviderUri() {
        return (Uri) inCallUIASRProviderUri$delegate.getValue();
    }

    public final void notifyRetryRecordASR(Context r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "phoneNumber");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "notifyStartCallSummaryTask start callCreateTime:" + r4);
        ContentResolver r5 = r3.getContentResolver();
        Uri r2 = getInCallUIASRProviderUri();
        Bundle r0 = new Bundle();
        r0.putLong("call_create_time", r4);
        r0.putString("phone_number", r6);
        Unit r7 = Unit.INSTANCE;
        r5.call(r2, METHOD_RECORD_FILE_ASR_RETRY, null, r0);
    }
}
