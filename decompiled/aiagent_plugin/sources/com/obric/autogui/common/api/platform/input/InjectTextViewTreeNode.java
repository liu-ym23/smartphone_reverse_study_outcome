package com.obric.autogui.common.api.platform.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InjectTextResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InjectTextViewTreeNode {
    private final String className;
    private final String hint;
    private final int inputType;
    private final boolean isFocused;
    private final String resourceId;
    private final String stableKey;
    private final String text;

    public static /* synthetic */ InjectTextViewTreeNode copy$default(InjectTextViewTreeNode r5, String r6, String r7, String r8, String r9, String r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.stableKey;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.resourceId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.className;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.hint;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.text;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isFocused;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.inputType;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.stableKey;
    }

    public final String component2() {
        return this.resourceId;
    }

    public final String component3() {
        return this.className;
    }

    public final String component4() {
        return this.hint;
    }

    public final String component5() {
        return this.text;
    }

    public final boolean component6() {
        return this.isFocused;
    }

    public final int component7() {
        return this.inputType;
    }

    public final InjectTextViewTreeNode copy(String r9, String r10, String r11, String r12, String r13, boolean r14, int r15) {
        o.e(r9, "stableKey");
        o.e(r10, "resourceId");
        o.e(r11, "className");
        o.e(r12, "hint");
        o.e(r13, "text");
        return new InjectTextViewTreeNode(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InjectTextViewTreeNode.class) == true) goto L8;
        return false;
    L8:
        InjectTextViewTreeNode r6 = (InjectTextViewTreeNode) ZeusTransformUtils.preCheckCast(r5, InjectTextViewTreeNode.class, "com.obric.aiagent.plugin");
        if (o.a(this.stableKey, r6.stableKey) == true) goto L12;
        return false;
    L12:
        if (o.a(this.resourceId, r6.resourceId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.className, r6.className) == true) goto L18;
        return false;
    L18:
        if (o.a(this.hint, r6.hint) == true) goto L21;
        return false;
    L21:
        if (o.a(this.text, r6.text) == true) goto L24;
        return false;
    L24:
        if (this.isFocused == r6.isFocused) goto L27;
        return false;
    L27:
        if (this.inputType == r6.inputType) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.stableKey.hashCode() * 31) + this.resourceId.hashCode()) * 31) + this.className.hashCode()) * 31) + this.hint.hashCode()) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.isFocused)) * 31) + Integer.hashCode(this.inputType);
    }

    public String toString() {
        return "InjectTextViewTreeNode(stableKey=" + this.stableKey + ", resourceId=" + this.resourceId + ", className=" + this.className + ", hint=" + this.hint + ", text=" + this.text + ", isFocused=" + this.isFocused + ", inputType=" + this.inputType + ')';
    }

    public InjectTextViewTreeNode(String r2, String r3, String r4, String r5, String r6, boolean r7, int r8) {
        o.e(r2, "stableKey");
        o.e(r3, "resourceId");
        o.e(r4, "className");
        o.e(r5, "hint");
        o.e(r6, "text");
        this.stableKey = r2;
        this.resourceId = r3;
        this.className = r4;
        this.hint = r5;
        this.text = r6;
        this.isFocused = r7;
        this.inputType = r8;
    }

    public final String getStableKey() {
        return this.stableKey;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final int getInputType() {
        return this.inputType;
    }
}
