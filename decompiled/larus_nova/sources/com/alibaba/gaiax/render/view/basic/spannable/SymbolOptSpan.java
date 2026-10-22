package com.alibaba.gaiax.render.view.basic.spannable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.alibaba.gaiax.template.GXSize;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007JR\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0016J4\u0010+\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006."}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/SymbolOptSpan;", "Landroid/text/style/ReplacementSpan;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "symbols", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "DEFAULT_PADDING", "", "getDEFAULT_PADDING", "()I", "getContext", "()Landroid/content/Context;", "emptySpaceWidth", "", "getEmptySpaceWidth", "()F", "setEmptySpaceWidth", "(F)V", GXTemplateKey.FLEXBOX_PADDING, "getPadding", "setPadding", "(I)V", "getSymbols", "()Ljava/util/List;", "textWidth", "getTextWidth", "setTextWidth", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SymbolOptSpan extends ReplacementSpan {
    private final int DEFAULT_PADDING;
    private final Context context;
    private float emptySpaceWidth;
    private int padding;
    private final List<Character> symbols;
    private float textWidth;

    public final Context getContext() {
        return this.context;
    }

    public final int getDEFAULT_PADDING() {
        return this.DEFAULT_PADDING;
    }

    public final float getEmptySpaceWidth() {
        return this.emptySpaceWidth;
    }

    public final int getPadding() {
        return this.padding;
    }

    public final List<Character> getSymbols() {
        return this.symbols;
    }

    public final float getTextWidth() {
        return this.textWidth;
    }

    public final void setEmptySpaceWidth(float r100) {
        this.emptySpaceWidth = r100;
    }

    public final void setPadding(int r100) {
        this.padding = r100;
    }

    public final void setTextWidth(float r100) {
        this.textWidth = r100;
    }

    public SymbolOptSpan(Context r100, List<Character> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.symbols = r101;
        int r102 = GXSize.Companion.dpToIntPx(4.0f);
        this.DEFAULT_PADDING = r102;
        this.padding = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r101 == null) goto L6;
        char r105 = r101.charAt(r102);
        this.padding = MathKt.roundToInt(this.DEFAULT_PADDING * ((r100.getTextSize() / ((TextPaint) r100).density) / 15.0f));
        Rect r106 = new Rect();
        float[] r107 = new float[1];
        r100.getTextBounds(String.valueOf(r105), 0, 1, r106);
        r100.getTextWidths(String.valueOf(r105), 0, 1, r107);
        this.emptySpaceWidth = r107[0] - r106.width();
        float r108 = r106.width();
        this.textWidth = r108;
        return ((int) r108) + this.padding;
    L6:
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r118, "paint");
        if (r111 == null) goto L13;
        char r100 = r111.charAt(r112);
        List<Character> r101 = this.symbols;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L11;
        float r103 = r114 - this.emptySpaceWidth;
    L12:
        float r104 = r103 + (this.padding / 2);
    L14:
        r110.drawText(String.valueOf(r111), r112, r113, r104, r116, r118);
        return;
    L11:
        r103 = r114;
        goto L12
    L7:
        if (r101.contains(Character.valueOf(r100)) != true) goto L9;
        r102 = true;
        goto L9
    L13:
        r104 = r114;
        goto L14
    }
}
