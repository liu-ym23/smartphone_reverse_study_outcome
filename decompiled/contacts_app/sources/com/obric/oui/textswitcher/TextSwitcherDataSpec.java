package com.obric.oui.textswitcher;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;", "", "textList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "fromIndex", "", "(Ljava/util/ArrayList;I)V", "getFromIndex", "()I", "setFromIndex", "(I)V", "getTextList", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextSwitcherDataSpec {
    private int fromIndex;
    private final ArrayList<String> textList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextSwitcherDataSpec copy$default(TextSwitcherDataSpec r0, ArrayList r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.textList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.fromIndex;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<String> component1() {
        return this.textList;
    }

    public final int component2() {
        return this.fromIndex;
    }

    public final TextSwitcherDataSpec copy(ArrayList<String> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "textList");
        return new TextSwitcherDataSpec(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextSwitcherDataSpec) == true) goto L8;
        return false;
    L8:
        TextSwitcherDataSpec r6 = (TextSwitcherDataSpec) r5;
        if (Intrinsics.areEqual(this.textList, r6.textList) == true) goto L12;
        return false;
    L12:
        if (this.fromIndex == r6.fromIndex) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.textList.hashCode() * 31) + Integer.hashCode(this.fromIndex);
    }

    public String toString() {
        return "TextSwitcherDataSpec(textList=" + this.textList + ", fromIndex=" + this.fromIndex + ')';
    }

    public TextSwitcherDataSpec(ArrayList<String> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "textList");
        this.textList = r2;
        this.fromIndex = r3;
    }

    public /* synthetic */ TextSwitcherDataSpec(ArrayList r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    public final ArrayList<String> getTextList() {
        return this.textList;
    }

    public final int getFromIndex() {
        return this.fromIndex;
    }

    public final void setFromIndex(int r1) {
        this.fromIndex = r1;
    }
}
