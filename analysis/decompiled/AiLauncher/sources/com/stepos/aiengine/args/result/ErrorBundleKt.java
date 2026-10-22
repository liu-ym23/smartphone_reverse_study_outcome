package com.stepos.aiengine.args.result;

import La.C;
import La.H;
import La.m;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016\"\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroid/os/Bundle;", "", "code", "", "message", "LY8/t;", "writeInferError", "(Landroid/os/Bundle;ILjava/lang/String;)V", "getErrorCode", "(Landroid/os/Bundle;)I", "", "getRetryAfterMs", "(Landroid/os/Bundle;)J", "", "isQuotaExceeded", "(Landroid/os/Bundle;)Z", "hasInferError", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)J", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "KEY_EXCEPTION", "Ljava/lang/String;", "KEY_ERROR_CODE", "KEY_RETRY_AFTER_MS", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "RETRY_AFTER_REGEX", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorBundleKt {
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_EXCEPTION = "exception";
    public static final String KEY_RETRY_AFTER_MS = "retry_after_ms";

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f23705a = new Regex("retryAfterMs=(\\d+)");

    public static final long a(String str) {
        List<String> listC;
        String str2;
        Long lY;
        m mVarD = Regex.d(f23705a, str, 0, 2, null);
        if (mVarD == null || (listC = mVarD.c()) == null || (str2 = listC.get(1)) == null || (lY = C.y(str2)) == null) {
            return 0L;
        }
        return lY.longValue();
    }

    public static final String b(String str) {
        return H.w1(str, '|', null, 2, null);
    }

    public static final int getErrorCode(Bundle bundle) {
        p.i(bundle, "<this>");
        return bundle.getInt("error_code", 0);
    }

    public static final long getRetryAfterMs(Bundle bundle) {
        p.i(bundle, "<this>");
        return bundle.getLong(KEY_RETRY_AFTER_MS, 0L);
    }

    public static final boolean hasInferError(Bundle bundle) {
        p.i(bundle, "<this>");
        if (bundle.containsKey("exception")) {
            return true;
        }
        return bundle.containsKey("error_code") && getErrorCode(bundle) != 0;
    }

    public static final boolean isQuotaExceeded(Bundle bundle) {
        p.i(bundle, "<this>");
        return getErrorCode(bundle) == 220007;
    }

    public static final void writeInferError(Bundle bundle, int i10, String str) {
        p.i(bundle, "<this>");
        if (str == null) {
            str = "";
        }
        long jA = a(str);
        String strB = b(str);
        bundle.putInt("error_code", i10);
        if (jA > 0) {
            bundle.putLong(KEY_RETRY_AFTER_MS, jA);
        }
        bundle.putString("exception", "infer error(" + i10 + "): " + strB);
    }
}
