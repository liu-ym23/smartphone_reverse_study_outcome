package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.BrotherhoodInfo")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/base/model/user/FraternityInfo;", "", "", "getName", "", "getLevel", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBackground", "getFontColor", "", "isValid", "name", "", "setName", "level", "setLevel", "background", "setBackground", "fontColor", "setFontColor", "_name", "Ljava/lang/String;", "get_name", "()Ljava/lang/String;", "set_name", "(Ljava/lang/String;)V", "_level", "J", "get_level", "()J", "set_level", "(J)V", "_background", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_background", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_background", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_fontColor", "get_fontColor", "set_fontColor", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FraternityInfo implements vh7.h {

    @SerializedName("background")
    protected ImageModel _background;

    @SerializedName("font_color")
    protected String _fontColor;

    @SerializedName("level")
    protected long _level;

    @SerializedName("name")
    protected String _name;

    public FraternityInfo() {
    }

    /* JADX INFO: renamed from: getBackground, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ py.k m8161getBackground() {
        return getBackground();
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(getName()) == false) goto L5;
    L9:
        return false;
    L5:
        if (getLevel() <= 0) goto L9;
        if (getBackground() == null) goto L9;
        return true;
    }

    public String getFontColor() {
        return this._fontColor;
    }

    public long getLevel() {
        return this._level;
    }

    public String getName() {
        return this._name;
    }

    public final ImageModel get_background() {
        return this._background;
    }

    public final String get_fontColor() {
        return this._fontColor;
    }

    public final long get_level() {
        return this._level;
    }

    public final String get_name() {
        return this._name;
    }

    public ImageModel getBackground() {
        return this._background;
    }

    public FraternityInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this._name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._level = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._background = com.bytedance.android.live.base.model.x.a(r100);
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

    public final void setBackground(ImageModel r100) {
        this._background = r100;
    }

    public final void setFontColor(String r100) {
        this._fontColor = r100;
    }

    public final void setLevel(long r100) {
        this._level = r100;
    }

    public final void setName(String r100) {
        this._name = r100;
    }

    public final void set_background(ImageModel r100) {
        this._background = r100;
    }

    public final void set_fontColor(String r100) {
        this._fontColor = r100;
    }

    public final void set_level(long r100) {
        this._level = r100;
    }

    public final void set_name(String r100) {
        this._name = r100;
    }
}
