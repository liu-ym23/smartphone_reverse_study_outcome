package com.obric.autoaction.presentation.island.template;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UpdateBtnEventData {
    private final String btnId;
    private final boolean disabled;
    private final Text text;

    /* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
    public static final class Text {
        private final String text;
        private final String textColor;
        private final String textSize;

        public static /* synthetic */ Text copy$default(Text r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.textSize;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.textColor;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.textSize;
        }

        public final String component3() {
            return this.textColor;
        }

        public final Text copy(String r1, String r2, String r3) {
            o.e(r1, "text");
            o.e(r3, "textColor");
            return new Text(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Text.class) == true) goto L8;
            return false;
        L8:
            Text r6 = (Text) ZeusTransformUtils.preCheckCast(r5, Text.class, "com.obric.aiagent.plugin");
            if (o.a(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (o.a(this.textSize, r6.textSize) == true) goto L15;
            return false;
        L15:
            if (o.a(this.textColor, r6.textColor) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.text.hashCode() * 31;
            String r1 = this.textSize;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.textColor.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Text(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ')';
        }

        public Text(String r2, String r3, String r4) {
            o.e(r2, "text");
            o.e(r4, "textColor");
            this.text = r2;
            this.textSize = r3;
            this.textColor = r4;
        }

        public /* synthetic */ Text(String r1, String r2, String r3, int r4, h r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2, r3);
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextSize() {
            return this.textSize;
        }

        public final String getTextColor() {
            return this.textColor;
        }
    }

    public static /* synthetic */ UpdateBtnEventData copy$default(UpdateBtnEventData r0, String r1, boolean r2, Text r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.btnId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.disabled;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.text;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.btnId;
    }

    public final boolean component2() {
        return this.disabled;
    }

    public final Text component3() {
        return this.text;
    }

    public final UpdateBtnEventData copy(String r1, boolean r2, Text r3) {
        o.e(r1, "btnId");
        return new UpdateBtnEventData(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UpdateBtnEventData.class) == true) goto L8;
        return false;
    L8:
        UpdateBtnEventData r6 = (UpdateBtnEventData) ZeusTransformUtils.preCheckCast(r5, UpdateBtnEventData.class, "com.obric.aiagent.plugin");
        if (o.a(this.btnId, r6.btnId) == true) goto L12;
        return false;
    L12:
        if (this.disabled == r6.disabled) goto L15;
        return false;
    L15:
        if (o.a(this.text, r6.text) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.btnId.hashCode() * 31) + Boolean.hashCode(this.disabled)) * 31;
        Text r2 = this.text;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "UpdateBtnEventData(btnId=" + this.btnId + ", disabled=" + this.disabled + ", text=" + this.text + ')';
    }

    public UpdateBtnEventData(String r2, boolean r3, Text r4) {
        o.e(r2, "btnId");
        this.btnId = r2;
        this.disabled = r3;
        this.text = r4;
    }

    public final String getBtnId() {
        return this.btnId;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final Text getText() {
        return this.text;
    }
}
