package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleRivalTag")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\nJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRivalTag;", "", "()V", "_backgroundImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_backgroundImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_backgroundImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_content", "", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "_fontColor", "get_fontColor", "set_fontColor", "_iconImage", "get_iconImage", "set_iconImage", "getBackgroundImage", "getContent", "getIconImage", "setBackgroundImage", "", "backgroundImage", "setContent", "content", "setIconImage", "iconImage", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleRivalTag implements h {

    @SerializedName("bg_image")
    protected ImageModel _backgroundImage;

    @SerializedName("content")
    protected String _content;

    @SerializedName("font_color")
    protected String _fontColor;

    @SerializedName("icon_image")
    protected ImageModel _iconImage;

    public BattleRivalTag() {
    }

    public BattleRivalTag(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this._backgroundImage = x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._iconImage = x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._content = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._fontColor = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final ImageModel getBackgroundImage() {
        return this._backgroundImage;
    }

    public final String getContent() {
        return this._content;
    }

    public final ImageModel getIconImage() {
        return this._iconImage;
    }

    public final ImageModel get_backgroundImage() {
        return this._backgroundImage;
    }

    public final String get_content() {
        return this._content;
    }

    public final String get_fontColor() {
        return this._fontColor;
    }

    public final ImageModel get_iconImage() {
        return this._iconImage;
    }

    public final void setBackgroundImage(ImageModel r100) {
        this._backgroundImage = r100;
    }

    public final void setContent(String r100) {
        this._content = r100;
    }

    public final void setIconImage(ImageModel r100) {
        this._iconImage = r100;
    }

    public final void set_backgroundImage(ImageModel r100) {
        this._backgroundImage = r100;
    }

    public final void set_content(String r100) {
        this._content = r100;
    }

    public final void set_fontColor(String r100) {
        this._fontColor = r100;
    }

    public final void set_iconImage(ImageModel r100) {
        this._iconImage = r100;
    }
}
