package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/config/h51;", "", "", "mockCheckAudienceLinkerException", "Z", "mockMessageManagerException", "mockRTSConnectException", "mockResetLinkerStateException", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h51 {

    @SerializedName("check_audience_linkers_exception")
    private boolean mockCheckAudienceLinkerException;

    @SerializedName("im_connect_exception")
    private boolean mockMessageManagerException;

    @SerializedName("rts_connect_exception")
    private boolean mockRTSConnectException;

    @SerializedName("reset_linker_state_exception")
    private boolean mockResetLinkerStateException;

    public h51() {
    }

    public final boolean a() {
        if (this.mockCheckAudienceLinkerException == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.mockMessageManagerException == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        return true;
    }

    public final boolean c() {
        if (this.mockResetLinkerStateException == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        return true;
    }

    public final boolean d() {
        if (this.mockRTSConnectException == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        return true;
    }
}
