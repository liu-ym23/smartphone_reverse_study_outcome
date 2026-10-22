package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassification;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/selection/TextClassificationResult;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "<init>", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassification;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/CharSequence;", "getSelection-d9O1mEE", "()J", "J", "getTextClassification", "()Landroid/view/textclassifier/TextClassification;", "component1", "component2", "component2-d9O1mEE", "component3", "copy", "copy-Sb-Bc2M", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassification;)Landroidx/compose/foundation/text/selection/TextClassificationResult;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextClassificationResult {
    private final long selection;
    private final CharSequence text;
    private final TextClassification textClassification;

    public /* synthetic */ TextClassificationResult(CharSequence r100, long r101, TextClassification r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    /* JADX INFO: renamed from: copy-Sb-Bc2M$default, reason: not valid java name */
    public static /* synthetic */ TextClassificationResult m1494copySbBc2M$default(TextClassificationResult r100, CharSequence r101, long r102, TextClassification r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.selection;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textClassification;
    L12:
        return r100.m1496copySbBc2M(r101, r102, r103);
    }

    public final CharSequence component1() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2-d9O1mEE, reason: not valid java name */
    public final long m1495component2d9O1mEE() {
        return this.selection;
    }

    public final TextClassification component3() {
        return this.textClassification;
    }

    /* JADX INFO: renamed from: copy-Sb-Bc2M, reason: not valid java name */
    public final TextClassificationResult m1496copySbBc2M(CharSequence r100, long r101, TextClassification r110) {
        return new TextClassificationResult(r100, r101, r110, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextClassificationResult) == true) goto L8;
        return false;
    L8:
        TextClassificationResult r101 = (TextClassificationResult) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (TextRange.m6991equalsimpl0(this.selection, r101.selection) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textClassification, r101.textClassification) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + TextRange.m6999hashCodeimpl(this.selection)) * 31) + this.textClassification.hashCode();
    }

    public String toString() {
        return "TextClassificationResult(text=" + this.text + ", selection=" + TextRange.m7001toStringimpl(this.selection) + ", textClassification=" + this.textClassification + ')';
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1497getSelectiond9O1mEE() {
        return this.selection;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final TextClassification getTextClassification() {
        return this.textClassification;
    }

    private TextClassificationResult(CharSequence r100, long r101, TextClassification r102) {
        this.text = r100;
        this.selection = r101;
        this.textClassification = r102;
    }
}
