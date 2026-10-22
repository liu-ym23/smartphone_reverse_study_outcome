package com.stepos.policy.sdk.util;

import android.util.Log;
import j4.k;

/* loaded from: classes.dex */
public final class PolicyCheckLogUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "policy_check";

    public static final class Companion {
        public /* synthetic */ Companion(j4.g gVar) {
            this();
        }

        public final void d(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            if (PolicySdkLogUtils.Companion.getEnabled()) {
                Log.d(PolicyCheckLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void e(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            Log.e(PolicyCheckLogUtils.TAG, str + " | " + str2);
        }

        public final void i(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            if (PolicySdkLogUtils.Companion.getEnabled()) {
                Log.i(PolicyCheckLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void w(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            Log.w(PolicyCheckLogUtils.TAG, str + " | " + str2);
        }

        private Companion() {
        }
    }
}
