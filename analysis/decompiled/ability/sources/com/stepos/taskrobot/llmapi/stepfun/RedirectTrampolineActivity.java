package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/RedirectTrampolineActivity;", "Landroid/app/Activity;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "handleRedirect", "Landroid/os/Bundle;", "savedInstanceState", AppAgent.ON_CREATE, "(Landroid/os/Bundle;)V", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RedirectTrampolineActivity extends Activity {
    public static final String EXTRA_CALLING_PID = "calling_pid";
    public static final String EXTRA_CALLING_UID = "calling_uid";
    public static final String EXTRA_TARGET_PACKAGE = "target_package";
    private static final String TAG = "RedirectTrampoline";

    private final void handleRedirect() {
        Object objA;
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_TARGET_PACKAGE) : null;
        Intent intent2 = getIntent();
        int intExtra = intent2 != null ? intent2.getIntExtra("calling_pid", -1) : -1;
        Intent intent3 = getIntent();
        int intExtra2 = intent3 != null ? intent3.getIntExtra(EXTRA_CALLING_UID, -1) : -1;
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(intExtra, "redirect: target=", stringExtra, ", callingPid=", ", callingUid=");
        sbT.append(intExtra2);
        AbstractC1436a.d(TAG, sbT.toString(), true);
        if (stringExtra == null || stringExtra.length() == 0) {
            AbstractC1436a.e(TAG, "redirect: empty target_package, skip", true);
            return;
        }
        if (SystemSdkBridge.INSTANCE.showFullScreenForPackage(stringExtra)) {
            return;
        }
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(stringExtra);
        if (launchIntentForPackage == null) {
            B7.a.z("redirect: no launch intent for ", stringExtra, ", give up", TAG, true);
            return;
        }
        try {
            startActivity(launchIntentForPackage);
            AbstractC1436a.d(TAG, "redirect: passed through to ".concat(stringExtra), true);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, "redirect: pass-through failed: " + thA.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Object objA;
        super.onCreate(savedInstanceState);
        try {
            handleRedirect();
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, "handleRedirect failed: " + thA.getMessage(), true);
        }
        finish();
        overridePendingTransition(0, 0);
    }
}
