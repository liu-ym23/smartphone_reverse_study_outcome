package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: AppletBlock.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppletBlock implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("applet_type")
    public final Integer appletType;

    @SerializedName("is_full_width")
    public final Boolean isFullWidth;

    @SerializedName("render_data")
    public final String renderData;

    /* JADX INFO: compiled from: AppletBlock.kt */
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

    public AppletBlock() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AppletBlock copy$default(AppletBlock r0, String r1, Boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.renderData;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isFullWidth;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.appletType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.renderData;
    }

    public final Boolean component2() {
        return this.isFullWidth;
    }

    public final Integer component3() {
        return this.appletType;
    }

    public final AppletBlock copy(String r1, Boolean r2, Integer r3) {
        return new AppletBlock(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppletBlock.class) == true) goto L8;
        return false;
    L8:
        AppletBlock r6 = (AppletBlock) ZeusTransformUtils.preCheckCast(r5, AppletBlock.class, "com.obric.aiagent.plugin");
        if (o.a(this.renderData, r6.renderData) == true) goto L12;
        return false;
    L12:
        if (o.a(this.isFullWidth, r6.isFullWidth) == true) goto L15;
        return false;
    L15:
        if (o.a(this.appletType, r6.appletType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.renderData;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isFullWidth;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.appletType;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletBlock(renderData=" + this.renderData + ", isFullWidth=" + this.isFullWidth + ", appletType=" + this.appletType + ')';
    }

    public AppletBlock(String r1, Boolean r2, Integer r3) {
        this.renderData = r1;
        this.isFullWidth = r2;
        this.appletType = r3;
    }

    public /* synthetic */ AppletBlock(String r2, Boolean r3, Integer r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
