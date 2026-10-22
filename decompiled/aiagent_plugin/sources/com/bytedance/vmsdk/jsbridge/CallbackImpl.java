package com.bytedance.vmsdk.jsbridge;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackImpl implements Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mInvoked;
    private long mNativePtr;

    static {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    private native void nativeInvoke(long r1, WritableArray r3);

    private native void nativeReleaseNativePtr(long r1);

    public CallbackImpl(long r1) {
        this.mNativePtr = r1;
        this.mInvoked = false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Callback
    public void invoke(Object... r7) {
        if (this.mInvoked == false) goto L6;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_CallbackImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("VmsdkModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
        return;
    L6:
        long r2 = this.mNativePtr;
        if (r2 != 0) goto L10;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_CallbackImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("VmsdkModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L10:
        nativeInvoke(r2, JavaOnlyArray.a(r7));
        this.mInvoked = true;
    }

    public void invokeCallback(Object... r7) {
        if (this.mInvoked == false) goto L6;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_CallbackImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("VmsdkModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
        return;
    L6:
        long r2 = this.mNativePtr;
        if (r2 != 0) goto L10;
        INVOKESTATIC_com_bytedance_vmsdk_jsbridge_CallbackImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("VmsdkModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L10:
        nativeInvoke(r2, JavaOnlyArray.a(r7));
        this.mInvoked = true;
    }

    public void finalize() {
        super.finalize();
        nativeReleaseNativePtr(this.mNativePtr);
    }

    public void resetNativePtr() {
        this.mNativePtr = 0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_jsbridge_CallbackImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_vmsdk_jsbridge_CallbackImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
