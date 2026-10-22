package com.stepos.policy.sdk.util;

import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyCheckLogUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "policy_check";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final void d(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            if (PolicySdkLogUtils.Companion.getEnabled()) {
                Log.d(PolicyCheckLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void e(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            Log.e(PolicyCheckLogUtils.TAG, method + " | " + msg);
        }

        public final void i(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            if (PolicySdkLogUtils.Companion.getEnabled()) {
                Log.i(PolicyCheckLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void w(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            Log.w(PolicyCheckLogUtils.TAG, method + " | " + msg);
        }

        private Companion() {
        }
    }
}
