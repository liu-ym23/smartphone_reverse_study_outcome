package com.stepos.policy.sdk.util;

import android.util.Log;
import yb.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyCheckLogUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "policy_check";

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void d(String str, String str2) {
            str.getClass();
            str2.getClass();
            if (PolicySdkLogUtils.Companion.getEnabled()) {
                Log.d(PolicyCheckLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void e(String str, String str2) {
            str.getClass();
            str2.getClass();
            Log.e(PolicyCheckLogUtils.TAG, str + " | " + str2);
        }

        public final void i(String str, String str2) {
            str.getClass();
            str2.getClass();
            if (PolicySdkLogUtils.Companion.getEnabled()) {
                Log.i(PolicyCheckLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void w(String str, String str2) {
            str.getClass();
            str2.getClass();
            Log.w(PolicyCheckLogUtils.TAG, str + " | " + str2);
        }

        private Companion() {
        }
    }
}
