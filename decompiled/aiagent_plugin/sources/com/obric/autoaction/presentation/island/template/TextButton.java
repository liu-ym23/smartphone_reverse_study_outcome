package com.obric.autoaction.presentation.island.template;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TextButton {
    private final String backgroundColor;
    private final Boolean dismissKeyguard;
    private final Icon icon;
    private final String id;
    private final Text text;

    public static /* synthetic */ TextButton copy$default(TextButton r3, String r4, Icon r5, Text r6, String r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.id;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.icon;
    L8:
        Icon r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.text;
    L11:
        Text r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.backgroundColor;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.dismissKeyguard;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.id;
    }

    public final Icon component2() {
        return this.icon;
    }

    public final Text component3() {
        return this.text;
    }

    public final String component4() {
        return this.backgroundColor;
    }

    public final Boolean component5() {
        return this.dismissKeyguard;
    }

    public final TextButton copy(String r7, Icon r8, Text r9, String r10, Boolean r11) {
        o.e(r7, DbHelper.COL_ID);
        o.e(r9, "text");
        return new TextButton(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TextButton.class) == true) goto L8;
        return false;
    L8:
        TextButton r6 = (TextButton) ZeusTransformUtils.preCheckCast(r5, TextButton.class, "com.obric.aiagent.plugin");
        if (o.a(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (o.a(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (o.a(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (o.a(this.backgroundColor, r6.backgroundColor) == true) goto L21;
        return false;
    L21:
        if (o.a(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.id.hashCode() * 31;
        Icon r1 = this.icon;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.text.hashCode()) * 31;
        String r5 = this.backgroundColor;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Boolean r8 = this.dismissKeyguard;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TextButton(id=" + this.id + ", icon=" + this.icon + ", text=" + this.text + ", backgroundColor=" + this.backgroundColor + ", dismissKeyguard=" + this.dismissKeyguard + ')';
    }

    public TextButton(String r2, Icon r3, Text r4, String r5, Boolean r6) {
        o.e(r2, DbHelper.COL_ID);
        o.e(r4, "text");
        this.id = r2;
        this.icon = r3;
        this.text = r4;
        this.backgroundColor = r5;
        this.dismissKeyguard = r6;
    }

    public /* synthetic */ TextButton(String r8, Icon r9, Text r10, String r11, Boolean r12, int r13, h r14) {
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Boolean r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final String getId() {
        return this.id;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getText() {
        return this.text;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }
}
