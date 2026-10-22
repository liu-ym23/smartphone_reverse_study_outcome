package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/user/ProfileBadgeSuffix;", "", "()V", "bgEndColor", "", "getBgEndColor", "()Ljava/lang/String;", "setBgEndColor", "(Ljava/lang/String;)V", "bgStartColor", "getBgStartColor", "setBgStartColor", "text", "Lcom/bytedance/android/livesdkapi/message/Text;", "getText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileBadgeSuffix implements vh7.h {

    @SerializedName("bg_end_color")
    protected String bgEndColor;

    @SerializedName("bg_start_color")
    protected String bgStartColor;

    @SerializedName("text")
    protected Text text;

    public ProfileBadgeSuffix() {
    }

    public ProfileBadgeSuffix(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.bgStartColor = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.bgEndColor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.text = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getBgEndColor() {
        return this.bgEndColor;
    }

    public final String getBgStartColor() {
        return this.bgStartColor;
    }

    public final Text getText() {
        return this.text;
    }

    public final void setBgEndColor(String r100) {
        this.bgEndColor = r100;
    }

    public final void setBgStartColor(String r100) {
        this.bgStartColor = r100;
    }

    public final void setText(Text r100) {
        this.text = r100;
    }
}
