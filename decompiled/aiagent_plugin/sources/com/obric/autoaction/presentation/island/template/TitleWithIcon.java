package com.obric.autoaction.presentation.island.template;

import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoExpandCardTemplate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TitleWithIcon {
    private final Icon icon;
    private final Text text;

    public static /* synthetic */ TitleWithIcon copy$default(TitleWithIcon r0, Icon r1, Text r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.icon;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.text;
    L9:
        return r0.copy(r1, r2);
    }

    public final Icon component1() {
        return this.icon;
    }

    public final Text component2() {
        return this.text;
    }

    public final TitleWithIcon copy(Icon r1, Text r2) {
        o.e(r1, "icon");
        o.e(r2, "text");
        return new TitleWithIcon(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TitleWithIcon.class) == true) goto L8;
        return false;
    L8:
        TitleWithIcon r6 = (TitleWithIcon) ZeusTransformUtils.preCheckCast(r5, TitleWithIcon.class, "com.obric.aiagent.plugin");
        if (o.a(this.icon, r6.icon) == true) goto L12;
        return false;
    L12:
        if (o.a(this.text, r6.text) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "TitleWithIcon(icon=" + this.icon + ", text=" + this.text + ')';
    }

    public TitleWithIcon(Icon r2, Text r3) {
        o.e(r2, "icon");
        o.e(r3, "text");
        this.icon = r2;
        this.text = r3;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getText() {
        return this.text;
    }
}
