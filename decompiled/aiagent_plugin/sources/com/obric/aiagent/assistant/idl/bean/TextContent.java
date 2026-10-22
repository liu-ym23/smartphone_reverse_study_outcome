package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import org.json.JSONArray;

/* JADX INFO: compiled from: TextContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextContent implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("description")
    private final String desc;

    @SerializedName("im_cmd")
    private Integer imCmd;

    @SerializedName("images")
    private final JSONArray images;

    @SerializedName("text")
    public String text;

    @SerializedName(DBDefinition.TITLE)
    private final String title;

    /* JADX INFO: compiled from: TextContent.kt */
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

    public TextContent() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TextContent copy$default(TextContent r3, String r4, Integer r5, String r6, String r7, JSONArray r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.text;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.imCmd;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.title;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.desc;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.images;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component2() {
        return this.imCmd;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.desc;
    }

    public final JSONArray component5() {
        return this.images;
    }

    public final TextContent copy(String r7, Integer r8, String r9, String r10, JSONArray r11) {
        return new TextContent(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TextContent.class) == true) goto L8;
        return false;
    L8:
        TextContent r6 = (TextContent) ZeusTransformUtils.preCheckCast(r5, TextContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.imCmd, r6.imCmd) == true) goto L15;
        return false;
    L15:
        if (o.a(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (o.a(this.desc, r6.desc) == true) goto L21;
        return false;
    L21:
        if (o.a(this.images, r6.images) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.imCmd;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.desc;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        JSONArray r13 = this.images;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "TextContent(text=" + this.text + ", imCmd=" + this.imCmd + ", title=" + this.title + ", desc=" + this.desc + ", images=" + this.images + ')';
    }

    public TextContent(String r1, Integer r2, String r3, String r4, JSONArray r5) {
        this.text = r1;
        this.imCmd = r2;
        this.title = r3;
        this.desc = r4;
        this.images = r5;
    }

    public final Integer getImCmd() {
        return this.imCmd;
    }

    public final void setImCmd(Integer r1) {
        this.imCmd = r1;
    }

    public /* synthetic */ TextContent(String r2, Integer r3, String r4, String r5, JSONArray r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final JSONArray getImages() {
        return this.images;
    }
}
