package com.obric.autogui.platforms.tools.platstrategy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ComputerControlApplicationAccessActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ComputerControlApplicationAccessActivity extends GeneratePluginActivity {
    private static final String ACCESS_LOG_TAG = "CCAppAccess";
    public static final a Companion = null;
    private static final String EXTRA_APPLICATION_ACCESS_INTENT_SENDER = "extra_application_access_intent_sender";
    private static final int REQUEST_CODE_APPLICATION_ACCESS = 1002;

    /* JADX INFO: compiled from: ComputerControlApplicationAccessActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final boolean a(Context r4, IntentSender r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "intentSender");
            Intent r0 = new Intent(r6, ComputerControlApplicationAccessActivity.class);
            r0.putExtra(ComputerControlApplicationAccessActivity.EXTRA_APPLICATION_ACCESS_INTENT_SENDER, (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.aiagent.plugin"));
            if (ZeusTransformUtils.instanceOf(r6, Activity.class) == true) goto L10;
            r0.addFlags(268435456);
        L10:
            ZeusTransformUtils.startActivity(r6, r0, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            Loog.INSTANCE.i(ComputerControlApplicationAccessActivity.ACCESS_LOG_TAG, "event=access_ui_host_start_dispatched");     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            Loog.INSTANCE.e(ComputerControlApplicationAccessActivity.ACCESS_LOG_TAG, "event=access_ui_host_start_failed", th);
            return false;
        }
    }

    static {
        Companion = new a(null);
    }

    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    public ComputerControlApplicationAccessActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r3) {
        super/*android.app.Activity*/.onCreate(r3);
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_host_created displayId=" + currentDisplayId() + " taskId=" + getTaskId());
        launchApplicationAccessConsent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*android.app.Activity*/.onResume();
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_host_resumed displayId=" + currentDisplayId() + " taskId=" + getTaskId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_host_destroyed displayId=" + currentDisplayId() + " taskId=" + getTaskId());
        super/*android.app.Activity*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int r2, int r3, Intent r4) {
        super/*android.app.Activity*/.onActivityResult(r2, r3, r4);
        if (r2 == 1002) goto L5;
        return;
    L5:
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_host_result resultCode=" + r3 + " displayId=" + currentDisplayId() + " taskId=" + getTaskId());
        finish();
    }

    private final void launchApplicationAccessConsent() {
        IntentSender r2 = (IntentSender) ZeusTransformUtils.preCheckCast(getIntent().getParcelableExtra(EXTRA_APPLICATION_ACCESS_INTENT_SENDER), IntentSender.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        Loog.INSTANCE.e(ACCESS_LOG_TAG, "event=access_ui_launch_failed reason=missing_intent_sender displayId=" + currentDisplayId() + " taskId=" + getTaskId());
        finish();
        return;
    L11:
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_launch_start displayId=" + currentDisplayId() + " taskId=" + getTaskId());     // Catch: Throwable -> L8
        startIntentSenderForResult(r2, 1002, null, 0, 0, 0);     // Catch: Throwable -> L8
        Loog.INSTANCE.i(ACCESS_LOG_TAG, "event=access_ui_launch_success displayId=" + currentDisplayId() + " taskId=" + getTaskId());     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Loog.INSTANCE.e(ACCESS_LOG_TAG, "event=access_ui_launch_failed reason=start_intent_sender displayId=" + currentDisplayId() + " taskId=" + getTaskId(), th);
        finish();
    }

    private final int currentDisplayId() {
        return getWindowManager().getDefaultDisplay().getDisplayId();
    }
}
