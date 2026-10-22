package com.stepos.policy.sdk.util;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyCheckLogUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyCheckLogUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "policy_check";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyCheckLogUtils$Companion;", "", "<init>", "()V", "", "method", "msg", "LY8/t;", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "TAG", "Ljava/lang/String;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void d(String method, String msg) {
            p.i(method, "method");
            p.i(msg, "msg");
            if (PolicySdkLogUtils.INSTANCE.getEnabled()) {
                Log.d(PolicyCheckLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void e(String method, String msg) {
            p.i(method, "method");
            p.i(msg, "msg");
            Log.e(PolicyCheckLogUtils.TAG, method + " | " + msg);
        }

        public final void i(String method, String msg) {
            p.i(method, "method");
            p.i(msg, "msg");
            if (PolicySdkLogUtils.INSTANCE.getEnabled()) {
                Log.i(PolicyCheckLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void w(String method, String msg) {
            p.i(method, "method");
            p.i(msg, "msg");
            Log.w(PolicyCheckLogUtils.TAG, method + " | " + msg);
        }

        private Companion() {
        }
    }
}
