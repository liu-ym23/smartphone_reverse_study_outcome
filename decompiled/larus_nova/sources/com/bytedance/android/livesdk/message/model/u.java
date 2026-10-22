package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u;", "", "", "isAnimSupported", "Ljava/lang/Boolean;", "", "enterAnimType", "Ljava/lang/Integer;", "exitAnimType", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u implements vh7.h {

    @SerializedName("enter_anim_type")
    public Integer enterAnimType;

    @SerializedName("exit_anim_type")
    public Integer exitAnimType;

    @SerializedName("is_anim_supported")
    public Boolean isAnimSupported;

    public u() {
        this.isAnimSupported = Boolean.FALSE;
        this.enterAnimType = 0;
        this.exitAnimType = 0;
    }

    public u(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.isAnimSupported = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.enterAnimType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.exitAnimType = Integer.valueOf(r100.i());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.isAnimSupported != null) goto L19;
        this.isAnimSupported = Boolean.FALSE;
    L19:
        if (this.enterAnimType != null) goto L22;
        this.enterAnimType = 0;
    L22:
        if (this.exitAnimType != null) goto L37;
        this.exitAnimType = 0;
        return;
    }
}
