package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: TextBlock.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextBlock implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("icon_url")
    public final String iconUrl;

    @SerializedName("icon_url_dark")
    public final String iconUrlDark;

    @SerializedName("summary")
    public final String summary;

    @SerializedName("text")
    public final String text;

    /* JADX INFO: compiled from: TextBlock.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public TextBlock() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TextBlock copy$default(TextBlock r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.iconUrl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.iconUrlDark;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.summary;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.iconUrlDark;
    }

    public final String component4() {
        return this.summary;
    }

    public final TextBlock copy(String r1, String r2, String r3, String r4) {
        return new TextBlock(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TextBlock.class) == true) goto L8;
        return false;
    L8:
        TextBlock r6 = (TextBlock) ZeusTransformUtils.preCheckCast(r5, TextBlock.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.iconUrl, r6.iconUrl) == true) goto L15;
        return false;
    L15:
        if (o.a(this.iconUrlDark, r6.iconUrlDark) == true) goto L18;
        return false;
    L18:
        if (o.a(this.summary, r6.summary) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.iconUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.iconUrlDark;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.summary;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TextBlock(text=" + this.text + ", iconUrl=" + this.iconUrl + ", iconUrlDark=" + this.iconUrlDark + ", summary=" + this.summary + ')';
    }

    public TextBlock(String r1, String r2, String r3, String r4) {
        this.text = r1;
        this.iconUrl = r2;
        this.iconUrlDark = r3;
        this.summary = r4;
    }

    public /* synthetic */ TextBlock(String r2, String r3, String r4, String r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
