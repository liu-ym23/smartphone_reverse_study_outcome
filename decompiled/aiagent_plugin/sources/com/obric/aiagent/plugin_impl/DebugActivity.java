package com.obric.aiagent.plugin_impl;

import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class DebugActivity extends FragmentActivity {
    private static final String TAG = "DebugActivity";
    private TextView resultTextView;

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public DebugActivity() {
    }

    static /* synthetic */ void access$000(DebugActivity r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).testStringUtils();
    }

    static /* synthetic */ void access$100(DebugActivity r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).testIsEmpty();
    }

    static /* synthetic */ void access$200(DebugActivity r2) {
        ((DebugActivity) ZeusTransformUtils.wrapperContextForParams(r2, DebugActivity.class, "com.obric.aiagent.plugin")).openVoicePrintEnroll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r7) {
        super.onCreate(r7);
        String r8 = Application.getProcessName();
        INVOKESTATIC_com_obric_aiagent_plugin_impl_DebugActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, "DebugActivity.onCreate 当前进程: " + r8 + ", pid: " + Process.myPid());
        ScrollView r0 = new ScrollView(this);
        LinearLayout r1 = new LinearLayout(this);
        r1.setOrientation(1);
        r1.setPadding(32, 32, 32, 32);
        TextView r3 = new TextView(this);
        r3.setText("Plugin Debug Page\n进程: " + r8);
        r3.setTextSize(24.0f);
        r3.setGravity(17);
        r3.setPadding(0, 0, 0, 32);
        r1.addView(r3);
        Button r4 = new Button(this);
        r4.setText("Test StringUtils");
        r4.setOnClickListener(new AnonymousClass1(this));
        r1.addView(r4);
        Button r5 = new Button(this);
        r5.setText("Test StringUtils.isEmpty");
        r5.setOnClickListener(new AnonymousClass2(this));
        r1.addView(r5);
        Button r6 = new Button(this);
        r6.setText("Open VoicePrintEnrollActivity");
        r6.setOnClickListener(new AnonymousClass3(this));
        r1.addView(r6);
        TextView r9 = new TextView(this);
        this.resultTextView = r9;
        r9.setTextSize(14.0f);
        this.resultTextView.setPadding(0, 32, 0, 0);
        this.resultTextView.setText("Click a button to test...");
        r1.addView(this.resultTextView);
        r0.addView(r1);
        setContentView(r0);
    }

    private void testStringUtils() {
        StringBuilder r1 = new StringBuilder();
        r1.append("=== StringUtils Test ===\n\n");
        r1.append("✓ StringUtils class loaded successfully!\n");     // Catch: Throwable -> L13
        r1.append("Class: ").append(j.class.getName()).append("\n");     // Catch: Throwable -> L13
        r1.append("ClassLoader: ").append(j.class.getClassLoader()).append("\n\n");     // Catch: Throwable -> L13
        r1.append("Available methods:\n");     // Catch: Throwable -> L13
        Method[] r2 = j.class.getDeclaredMethods();     // Catch: Throwable -> L13
        int r3 = r2.length;     // Catch: Throwable -> L13
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r3) goto L10;
        Method r7 = r2[r4];     // Catch: Throwable -> L13
        if (r5 >= 10) goto L9;
        r1.append("  - ").append(r7.getName()).append("()\n");     // Catch: Throwable -> L13
    L9:
        r5 = r5 + 1;     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L5
    L10:
        if (r5 <= 10) goto L17;
        r1.append("  ... and ").append(r5 - 10).append(" more methods\n");     // Catch: Throwable -> L13
    L17:
        this.resultTextView.setText(r1.toString());
        return;
    L13:
        th = move-exception;
        r1.append("✗ Error: ").append(th.getClass().getSimpleName()).append("\n");
        r1.append("Message: ").append(th.getMessage()).append("\n");
        if (th.getCause() == null) goto L17;
        r1.append("Cause: ").append(th.getCause().getMessage()).append("\n");
        goto L17
    }

    private void testIsEmpty() {
        StringBuilder r1 = new StringBuilder();
        r1.append("=== StringUtils.isEmpty Test ===\n\n");
        boolean r2 = j.a("");     // Catch: Throwable -> L10
        boolean r3 = j.a(null);     // Catch: Throwable -> L10
        boolean r4 = j.a("hello");     // Catch: Throwable -> L10
        r1.append("StringUtils.isEmpty(\"\") = ").append(r2).append("\n");     // Catch: Throwable -> L10
        r1.append("StringUtils.isEmpty(null) = ").append(r3).append("\n");     // Catch: Throwable -> L10
        r1.append("StringUtils.isEmpty(\"hello\") = ").append(r4).append("\n\n");     // Catch: Throwable -> L10
        if (r2 == false) goto L8;
        if (r3 == false) goto L8;
        if (r4 == true) goto L8;
        r1.append("✓ All tests passed!\n");     // Catch: Throwable -> L10
    L16:
    L14:
        this.resultTextView.setText(r1.toString());
        return;
    L8:
        r1.append("✗ Some tests failed\n");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r1.append("✗ Error: ").append(th.getClass().getSimpleName()).append("\n");
        r1.append("Message: ").append(th.getMessage()).append("\n");
        if (th.getCause() == null) goto L14;
        r1.append("Cause: ").append(th.getCause().getMessage()).append("\n");
        goto L14
    }

    private void openVoicePrintEnroll() {
        this.resultTextView.setText("SVA模块不进插件 VoicePrintEnrollActivity 暂不支持打开");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        StringBuilder r1 = new StringBuilder();
        r1.append("✗ Error starting VoicePrintEnrollActivity:\n");
        r1.append("Exception: ").append(th.getClass().getSimpleName()).append("\n");
        r1.append("Message: ").append(th.getMessage()).append("\n");
        if (th.getCause() == null) goto L8;
        r1.append("Cause: ").append(th.getCause().getMessage()).append("\n");
    L8:
        this.resultTextView.setText(r1.toString());
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_plugin_impl_DebugActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
