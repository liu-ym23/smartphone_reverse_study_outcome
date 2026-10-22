package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class SystemMessageHandler extends Handler {
    private static final int SCHEDULED_WORK = 1;
    private static final String TAG = "SystemMessageHandler";
    private boolean mHasMethodBeenFound;
    private boolean mIsRunning;
    private Method mMessageMethodSetAsynchronous;
    private long mMessagePumpDelegateNative;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private native void nativeRunWork(long r1);

    private SystemMessageHandler(long r3) {
        this.mMessagePumpDelegateNative = 0;
        this.mIsRunning = false;
        this.mHasMethodBeenFound = false;
        this.mMessagePumpDelegateNative = r3;
        this.mIsRunning = true;
    }

    public static SystemMessageHandler create(long r1) {
        return new SystemMessageHandler(r1);
    }

    private void scheduleWork() {
        sendMessage(obtainAsyncMessage(1));
    }

    private void stop() {
        this.mIsRunning = false;
    }

    private void findMethodSetAsynchronous() {
        if (this.mHasMethodBeenFound == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 22) goto L17;
    L15:
        this.mHasMethodBeenFound = true;
        return;
    L17:
        this.mMessageMethodSetAsynchronous = ZeusTransformUtils.forName("android.os.Message", "com.obric.aiagent.plugin").getMethod("setAsynchronous", new Class[]{Boolean.TYPE});     // Catch: RuntimeException -> L9 NoSuchMethodException -> L11 ClassNotFoundException -> L13
    L13:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Failed to find android.os.Message class:" + e);
    L11:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Failed to load Message.setAsynchronous method:" + e);
    L9:
        e = move-exception;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Exception while loading Message.setAsynchronous method: " + e);
        goto L15
    }

    private Message obtainAsyncMessage(int r7) {
        Message r1 = Message.obtain();
        r1.what = r7;
        if (Build.VERSION.SDK_INT < 22) goto L5;
        r1.setAsynchronous(true);
    L14:
        return r1;
    L5:
        findMethodSetAsynchronous();
        Method r8 = this.mMessageMethodSetAsynchronous;
        if (r8 == null) goto L14;
        r8.invoke(r1, new Object[]{true});     // Catch: IllegalAccessException -> L10 RuntimeException -> L11 IllegalArgumentException -> L12 InvocationTargetException -> L13
    L10:
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Illegal access to asynchronous message creation.");
        this.mMessageMethodSetAsynchronous = null;
    L12:
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Illegal argument for asynchronous message creation.");
        this.mMessageMethodSetAsynchronous = null;
    L11:
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Runtime exception during asynchronous message creation");
        this.mMessageMethodSetAsynchronous = null;
    L13:
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Invocation exception during asynchronous message creation");
        this.mMessageMethodSetAsynchronous = null;
        goto L14
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        if (this.mIsRunning == false) goto L6;
        nativeRunWork(this.mMessagePumpDelegateNative);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_jsbridge_utils_SystemMessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
