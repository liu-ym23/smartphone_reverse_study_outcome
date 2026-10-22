package com.stepos.policy.sdk.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyCheckLogUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyCheckLogUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "policy_check";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyCheckLogUtils$Companion;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "w", "i", "d", "TAG", "Ljava/lang/String;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final void d(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            if (PolicySdkLogUtils.INSTANCE.getEnabled()) {
                Log.d(PolicyCheckLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void e(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            Log.e(PolicyCheckLogUtils.TAG, method + " | " + msg);
        }

        public final void i(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            if (PolicySdkLogUtils.INSTANCE.getEnabled()) {
                Log.i(PolicyCheckLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void w(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            Log.w(PolicyCheckLogUtils.TAG, method + " | " + msg);
        }

        private Companion() {
        }
    }
}
