package com.bytedance.android.livehostapi.business.depend.xplay;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/XplayEnvParams;", "", "()V", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "getFragmentActivity", "()Landroidx/fragment/app/FragmentActivity;", "setFragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "userId", "getUserId", "setUserId", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayEnvParams {
    private String deviceId;
    private FragmentActivity fragmentActivity;
    private String userId;

    public XplayEnvParams() {
        this.userId = "";
        this.deviceId = "";
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final FragmentActivity getFragmentActivity() {
        return this.fragmentActivity;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setDeviceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceId = r100;
    }

    public final void setFragmentActivity(FragmentActivity r100) {
        this.fragmentActivity = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }
}
