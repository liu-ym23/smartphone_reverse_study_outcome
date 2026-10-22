package com.stepos.aiengine.args.result;

import D7.K;
import android.os.Bundle;
import androidx.constraintlayout.core.dsl.a;
import j9.l;
import j9.m;
import j9.t;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroid/os/Bundle;", "", "code", "", "message", "LC7/r;", "writeInferError", "(Landroid/os/Bundle;ILjava/lang/String;)V", "getErrorCode", "(Landroid/os/Bundle;)I", "", "getRetryAfterMs", "(Landroid/os/Bundle;)J", "", "isQuotaExceeded", "(Landroid/os/Bundle;)Z", "hasInferError", "KEY_EXCEPTION", "Ljava/lang/String;", "KEY_ERROR_CODE", "KEY_RETRY_AFTER_MS", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ErrorBundleKt {
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_EXCEPTION = "exception";
    public static final String KEY_RETRY_AFTER_MS = "retry_after_ms";

    /* renamed from: a, reason: collision with root package name */
    public static final Regex f3497a = new Regex("retryAfterMs=(\\d+)");

    public static final int getErrorCode(Bundle bundle) {
        k.f(bundle, "<this>");
        return bundle.getInt("error_code", 0);
    }

    public static final long getRetryAfterMs(Bundle bundle) {
        k.f(bundle, "<this>");
        return bundle.getLong(KEY_RETRY_AFTER_MS, 0L);
    }

    public static final boolean hasInferError(Bundle bundle) {
        k.f(bundle, "<this>");
        if (bundle.containsKey("exception")) {
            return true;
        }
        return bundle.containsKey("error_code") && getErrorCode(bundle) != 0;
    }

    public static final boolean isQuotaExceeded(Bundle bundle) {
        k.f(bundle, "<this>");
        return getErrorCode(bundle) == 220007;
    }

    public static final void writeInferError(Bundle bundle, int i, String str) {
        String str2;
        Long lG0;
        k.f(bundle, "<this>");
        if (str == null) {
            str = "";
        }
        l lVarB = f3497a.b(str);
        long jLongValue = (lVarB == null || (str2 = (String) ((K) lVarB.a()).get(1)) == null || (lG0 = t.g0(str2)) == null) ? 0L : lG0.longValue();
        String strK0 = m.K0(str, '|');
        bundle.putInt("error_code", i);
        if (jLongValue > 0) {
            bundle.putLong(KEY_RETRY_AFTER_MS, jLongValue);
        }
        bundle.putString("exception", a.c(i, "infer error(", "): ", strK0));
    }
}
