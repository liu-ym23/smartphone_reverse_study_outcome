package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/d;", "", "", "hint", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/b;", "fastChatInfo", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/b;", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/c;", "fixedChatInfo", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/c;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName("fast_chat_info")
    public b fastChatInfo;

    @SerializedName("fixed_chat_info")
    public c fixedChatInfo;

    @SerializedName("hint")
    public String hint;

    public d() {
    }

    public d(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.hint = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.fastChatInfo = new b(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.fixedChatInfo = new c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
