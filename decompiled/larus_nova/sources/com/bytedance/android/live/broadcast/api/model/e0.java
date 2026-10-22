package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.DisableInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/e0;", "", "", "disableEditTitle", "Z", "disableEditCover", "", "disableEditTitleToast", "Ljava/lang/String;", "disableEditCoverToast", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 implements vh7.h {

    @SerializedName("disable_edit_cover")
    public boolean disableEditCover;

    @SerializedName("disable_edit_cover_toast")
    public String disableEditCoverToast;

    @SerializedName("disable_edit_title")
    public boolean disableEditTitle;

    @SerializedName("disable_edit_title_toast")
    public String disableEditTitleToast;

    public e0() {
        this.disableEditTitleToast = "";
        this.disableEditCoverToast = "";
    }

    public e0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.disableEditTitle = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.disableEditCover = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.disableEditTitleToast = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.disableEditCoverToast = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.disableEditTitleToast != null) goto L22;
        this.disableEditTitleToast = "";
    L22:
        if (this.disableEditCoverToast != null) goto L40;
        this.disableEditCoverToast = "";
        return;
    }
}
