package com.bytedance.android.livesdkapi.depend.model.live.im;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.IndustryServiceInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010J\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\b\u0010\u001f\u001a\u00020 H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/im/IMIndustryServiceInfo;", "", "()V", "_consultInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/im/ConsultInfo;", "get_consultInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/im/ConsultInfo;", "set_consultInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/im/ConsultInfo;)V", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_isEntranceOpen", "", "get_isEntranceOpen", "()Z", "set_isEntranceOpen", "(Z)V", "getConsultInfo", "getIcon", "isEntranceOpen", "setConsultInfo", "", "consultInfo", "setEntranceOpen", "entranceOpen", "setIcon", "icon", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMIndustryServiceInfo implements h {

    @SerializedName("consult_info")
    protected ConsultInfo _consultInfo;

    @SerializedName("icon_image")
    protected ImageModel _icon;

    @SerializedName("entrance_open")
    protected boolean _isEntranceOpen;

    public IMIndustryServiceInfo() {
    }

    public IMIndustryServiceInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this._isEntranceOpen = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._icon = x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._consultInfo = new ConsultInfo(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public String toString() {
        return "IMIndustryServiceInfo{isEntranceOpen=" + this._isEntranceOpen + ", icon=" + this._icon + ", consultInfo=" + this._consultInfo + '}';
    }

    public final ConsultInfo getConsultInfo() {
        return this._consultInfo;
    }

    public final ImageModel getIcon() {
        return this._icon;
    }

    public final ConsultInfo get_consultInfo() {
        return this._consultInfo;
    }

    public final ImageModel get_icon() {
        return this._icon;
    }

    public final boolean get_isEntranceOpen() {
        return this._isEntranceOpen;
    }

    public final boolean isEntranceOpen() {
        return this._isEntranceOpen;
    }

    public final void setConsultInfo(ConsultInfo r100) {
        this._consultInfo = r100;
    }

    public final void setEntranceOpen(boolean r100) {
        this._isEntranceOpen = r100;
    }

    public final void setIcon(ImageModel r100) {
        this._icon = r100;
    }

    public final void set_consultInfo(ConsultInfo r100) {
        this._consultInfo = r100;
    }

    public final void set_icon(ImageModel r100) {
        this._icon = r100;
    }

    public final void set_isEntranceOpen(boolean r100) {
        this._isEntranceOpen = r100;
    }
}
