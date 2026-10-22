package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.Result;
import w0.C2085f;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/LiveNotificationLaunchActivity;", "Landroid/app/Activity;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "handleLaunch", "Landroid/os/Bundle;", "savedInstanceState", AppAgent.ON_CREATE, "(Landroid/os/Bundle;)V", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LiveNotificationLaunchActivity extends Activity {
    public static final String EXTRA_TASK_ID = "extra_task_id";
    private static final String TAG = "LiveNotifLaunch";

    private final void handleLaunch() {
        Object objA;
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("extra_task_id") : null;
        if (stringExtra == null || stringExtra.length() == 0) {
            AbstractC1436a.e(TAG, "empty taskId, skip", true);
            return;
        }
        AbstractC1436a.d(TAG, "launching FullScreenActivity for taskId=".concat(stringExtra), true);
        SystemSdkBridge.showFullScreenActivity$default(SystemSdkBridge.INSTANCE, stringExtra, null, 2, null);
        try {
            C2085f c2085f = m6.b.d;
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
            c2085f.g(applicationContext).dismiss(stringExtra);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, "dismiss failed: " + thA.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Object objA;
        super.onCreate(savedInstanceState);
        try {
            handleLaunch();
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, "handleLaunch failed: " + thA.getMessage(), true);
        }
        finish();
        overridePendingTransition(0, 0);
    }
}
