package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/f;", "", "", "elementType", "I", "c", "()I", "", "text", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "textColor", "e", "avatarURL", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "blankWidth", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("avatar_url")
    private final String avatarURL;

    @SerializedName("blank_width")
    private final int blankWidth;

    @SerializedName("element_type")
    private final int elementType;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (this.elementType == r101.elementType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarURL, r101.avatarURL) == true) goto L14;
        return false;
    L14:
        if (this.blankWidth == r101.blankWidth) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.elementType * 31;
        String r101 = this.text;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.textColor;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.avatarURL;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return ((r107 + r102) * 31) + this.blankWidth;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractionElement(elementType=" + this.elementType + ", text=" + this.text + ", textColor=" + this.textColor + ", avatarURL=" + this.avatarURL + ", blankWidth=" + this.blankWidth + ")";
    }

    public f() {
        this.elementType = 0;
        this.text = null;
        this.textColor = null;
        this.avatarURL = null;
        this.blankWidth = 1;
    }

    public final String a() {
        return this.avatarURL;
    }

    public final int b() {
        return this.blankWidth;
    }

    public final int c() {
        return this.elementType;
    }

    public final String d() {
        return this.text;
    }

    public final String e() {
        return this.textColor;
    }
}
