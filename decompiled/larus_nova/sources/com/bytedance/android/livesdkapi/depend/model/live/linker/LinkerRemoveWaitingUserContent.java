package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR/\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "", "", "<set-?>", "waitingUserToast$delegate", "Ljava/lang/Object;", "getWaitingUserToast", "()Ljava/lang/String;", "setWaitingUserToast", "(Ljava/lang/String;)V", "waitingUserToast", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerRemoveWaitingUserContent implements h {

    @SerializedName("waiting_user_toast")
    protected String _$$waitingUserToast;

    public LinkerRemoveWaitingUserContent() {
    }

    public LinkerRemoveWaitingUserContent(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this._$$waitingUserToast = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final String getWaitingUserToast() {
        return this._$$waitingUserToast;
    }

    public final void setWaitingUserToast(String r100) {
        this._$$waitingUserToast = r100;
    }
}
