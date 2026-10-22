package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleTitleConfig")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleTitleConfig;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "newIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getNewIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setNewIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "scheme", "getScheme", "setScheme", "schemeHotsoon", "getSchemeHotsoon", "setSchemeHotsoon", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleTitleConfig implements h {

    @SerializedName("content")
    protected String content;

    @SerializedName("new_icon")
    protected ImageModel newIcon;

    @SerializedName("scheme")
    protected String scheme;

    @SerializedName("hotsoon_scheme")
    protected String schemeHotsoon;

    public BattleTitleConfig() {
    }

    public BattleTitleConfig(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 2) goto L8;
        this.content = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.scheme = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.schemeHotsoon = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 7) goto L13;
        this.newIcon = x.a(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final String getContent() {
        return this.content;
    }

    public final ImageModel getNewIcon() {
        return this.newIcon;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final String getSchemeHotsoon() {
        return this.schemeHotsoon;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setNewIcon(ImageModel r100) {
        this.newIcon = r100;
    }

    public final void setScheme(String r100) {
        this.scheme = r100;
    }

    public final void setSchemeHotsoon(String r100) {
        this.schemeHotsoon = r100;
    }
}
