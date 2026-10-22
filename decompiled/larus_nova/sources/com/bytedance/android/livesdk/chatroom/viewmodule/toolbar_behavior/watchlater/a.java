package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.api.distribution.AddWatchLaterData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IWatchLaterData;", "", "drawerButtonText", "Ljava/lang/String;", "getDrawerButtonText", "()Ljava/lang/String;", "toast", "getToast", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "displayText", "getDisplayText", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements IWatchLaterData, vh7.h {

    @SerializedName("display_text")
    protected String displayText;

    @SerializedName("button_text")
    protected String drawerButtonText;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("toast")
    protected String toast;

    public a() {
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.drawerButtonText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.toast = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.icon = x.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.displayText = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData
    public final String getDisplayText() {
        return this.displayText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData
    public final String getDrawerButtonText() {
        return this.drawerButtonText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData
    public final String getToast() {
        return this.toast;
    }
}
