package com.stepos.widget.tabbar;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/tabbar/ParsedTabMenuItem;", "", "itemId", "", "title", "", "iconResId", "contentDescription", "visible", "", x5.d.EXTRA_ENABLED, "<init>", "(ILjava/lang/CharSequence;ILjava/lang/CharSequence;ZZ)V", "getItemId", "()I", "getTitle", "()Ljava/lang/CharSequence;", "getIconResId", "getContentDescription", "getVisible", "()Z", "getEnabled", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ParsedTabMenuItem {
    private final CharSequence contentDescription;
    private final boolean enabled;
    private final int iconResId;
    private final int itemId;
    private final CharSequence title;
    private final boolean visible;

    public ParsedTabMenuItem(int i10, CharSequence charSequence, int i11, CharSequence charSequence2, boolean z10, boolean z11) {
        this.itemId = i10;
        this.title = charSequence;
        this.iconResId = i11;
        this.contentDescription = charSequence2;
        this.visible = z10;
        this.enabled = z11;
    }

    public final CharSequence getContentDescription() {
        return this.contentDescription;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final boolean getVisible() {
        return this.visible;
    }
}
