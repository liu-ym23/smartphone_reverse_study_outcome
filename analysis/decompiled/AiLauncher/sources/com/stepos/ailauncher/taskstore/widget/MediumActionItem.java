package com.stepos.ailauncher.taskstore.widget;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/j;", "", "", "label", "Lcom/stepos/ailauncher/taskstore/widget/MediumActionStyle;", "style", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/widget/MediumActionStyle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/taskstore/widget/MediumActionStyle;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/taskstore/widget/MediumActionStyle;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.widget.j, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class MediumActionItem {
    private final String label;
    private final MediumActionStyle style;

    public MediumActionItem(String label, MediumActionStyle style) {
        kotlin.jvm.internal.p.i(label, "label");
        kotlin.jvm.internal.p.i(style, "style");
        this.label = label;
        this.style = style;
    }

    /* renamed from: a, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: b, reason: from getter */
    public final MediumActionStyle getStyle() {
        return this.style;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediumActionItem)) {
            return false;
        }
        MediumActionItem mediumActionItem = (MediumActionItem) other;
        return kotlin.jvm.internal.p.d(this.label, mediumActionItem.label) && this.style == mediumActionItem.style;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.style.hashCode();
    }

    public String toString() {
        return "MediumActionItem(label=" + this.label + ", style=" + this.style + ")";
    }
}
