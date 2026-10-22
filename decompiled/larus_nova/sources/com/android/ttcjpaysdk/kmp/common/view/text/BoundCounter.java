package com.android.ttcjpaysdk.kmp.common.view.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0016\u001a\u00020\u000fJ\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/text/BoundCounter;", "", "text", "", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "charPosition", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLayoutResult;Lkotlin/jvm/functions/Function1;)V", "value", "string", "getString", "()Ljava/lang/String;", "", "width", "getWidth", "()F", "_nextCharWidth", "Ljava/lang/Float;", "invalidCharsCount", "widthWithNextChar", "nextCharWidth", "addNextChar", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class BoundCounter {
    private Float _nextCharWidth;
    private final Function1<Integer, Integer> charPosition;
    private int invalidCharsCount;
    private String string;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private float width;

    private final float nextCharWidth() {
        Float r100 = this._nextCharWidth;
        if (r100 != null) goto L17;
        this.invalidCharsCount--;
    L6:
        TextLayoutResult r101 = this.textLayoutResult;
        Function1<Integer, Integer> r102 = this.charPosition;
        int r103 = this.string.length();
        boolean r104 = true;
        int r105 = this.invalidCharsCount + 1;
        this.invalidCharsCount = r105;
        Rect r106 = r101.getBoundingBox(r102.invoke(Integer.valueOf(r103 + r105)).intValue());
        if (r106.getRight() == 0.0f) goto L10;
        r104 = false;
    L10:
        if (r104 == true) goto L6;
        this._nextCharWidth = Float.valueOf(r106.getRight() - r106.getLeft());
        return r106.getRight() - r106.getLeft();
    L17:
        return r100.floatValue();
    }

    public final void addNextChar() {
        this.string += this.text.charAt(this.charPosition.invoke(Integer.valueOf(this.string.length())).intValue());
        this.width += nextCharWidth();
        this._nextCharWidth = null;
    }

    public final float widthWithNextChar() {
        return this.width + nextCharWidth();
    }

    public final String getString() {
        return this.string;
    }

    public final float getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BoundCounter(String r100, TextLayoutResult r101, Function1<? super Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "textLayoutResult");
        Intrinsics.checkNotNullParameter(r102, "charPosition");
        this.text = r100;
        this.textLayoutResult = r101;
        this.charPosition = r102;
        this.string = "";
    }
}
