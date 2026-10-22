package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BeautifyInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomBeautifyInfo;", "", "()V", "commerceUseFilter", "", "getCommerceUseFilter", "()Ljava/lang/Boolean;", "setCommerceUseFilter", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useFilter", "getUseFilter", "setUseFilter", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBeautifyInfo implements h {

    @SerializedName("commerce_use_filter")
    protected Boolean commerceUseFilter;

    @SerializedName("use_filter")
    protected Boolean useFilter;

    public RoomBeautifyInfo() {
        Boolean r100 = Boolean.FALSE;
        this.useFilter = r100;
        this.commerceUseFilter = r100;
    }

    public final Boolean getCommerceUseFilter() {
        return this.commerceUseFilter;
    }

    public final Boolean getUseFilter() {
        return this.useFilter;
    }

    public RoomBeautifyInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.useFilter = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.commerceUseFilter = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.useFilter != null) goto L16;
        this.useFilter = Boolean.FALSE;
    L16:
        if (this.commerceUseFilter != null) goto L28;
        this.commerceUseFilter = Boolean.FALSE;
        return;
    }

    public final void setCommerceUseFilter(Boolean r100) {
        this.commerceUseFilter = r100;
    }

    public final void setUseFilter(Boolean r100) {
        this.useFilter = r100;
    }
}
