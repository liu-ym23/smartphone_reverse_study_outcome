package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.windowsprompt.WindowsPrompt;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/GetAdminOperationTypeResponseData;", "", "", "operationType", "J", "getOperationType", "()J", "setOperationType", "(J)V", "Lcom/bytedance/android/livesdkapi/windowsprompt/WindowsPrompt;", "windowsPrompts", "Lcom/bytedance/android/livesdkapi/windowsprompt/WindowsPrompt;", "getWindowsPrompts", "()Lcom/bytedance/android/livesdkapi/windowsprompt/WindowsPrompt;", "setWindowsPrompts", "(Lcom/bytedance/android/livesdkapi/windowsprompt/WindowsPrompt;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAdminOperationTypeResponseData implements vh7.h {
    public static final a Companion = null;
    public static final long OPERATION_CONFIRM = 2;
    public static final long OPERATION_DEFAULT = 0;
    public static final long OPERATION_IMMEDIATE = 1;
    public static final long OPERATION_UNAVAILABLE = 3;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE)
    protected long operationType;

    @SerializedName("windows_prompt")
    protected WindowsPrompt windowsPrompts;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GetAdminOperationTypeResponseData() {
    }

    public final long getOperationType() {
        return this.operationType;
    }

    public final WindowsPrompt getWindowsPrompts() {
        return this.windowsPrompts;
    }

    public GetAdminOperationTypeResponseData(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.operationType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.windowsPrompts = new WindowsPrompt(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setOperationType(long r100) {
        this.operationType = r100;
    }

    public final void setWindowsPrompts(WindowsPrompt r100) {
        this.windowsPrompts = r100;
    }
}
