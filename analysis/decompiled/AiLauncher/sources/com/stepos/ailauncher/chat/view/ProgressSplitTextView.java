package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ProgressSplitTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", Const.INTENT_KEY_APIKEY, "()V", "", UxipConstants.f30680s, "progressFraction", "F", "getProgressFraction", "()F", "setProgressFraction", "(F)V", "filledTextColor", "I", "getFilledTextColor", "()I", "setFilledTextColor", "(I)V", "unfilledTextColor", "getUnfilledTextColor", "setUnfilledTextColor", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProgressSplitTextView extends TextView {
    private int filledTextColor;
    private float progressFraction;
    private int unfilledTextColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressSplitTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void a() {
        float width = getWidth();
        if (width <= 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        int i10 = this.filledTextColor;
        int i11 = this.unfilledTextColor;
        int[] iArr = {i10, i10, i11, i11};
        float f10 = this.progressFraction;
        paint.setShader(new LinearGradient(0.0f, 0.0f, width, 0.0f, iArr, new float[]{0.0f, f10, f10, 1.0f}, Shader.TileMode.CLAMP));
        invalidate();
    }

    public final int getFilledTextColor() {
        return this.filledTextColor;
    }

    public final float getProgressFraction() {
        return this.progressFraction;
    }

    public final int getUnfilledTextColor() {
        return this.unfilledTextColor;
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        a();
    }

    public final void setFilledTextColor(int i10) {
        if (this.filledTextColor != i10) {
            this.filledTextColor = i10;
            a();
        }
    }

    public final void setProgressFraction(float f10) {
        float fM = C5685n.m(f10, 0.0f, 1.0f);
        if (this.progressFraction == fM) {
            return;
        }
        this.progressFraction = fM;
        a();
    }

    public final void setUnfilledTextColor(int i10) {
        if (this.unfilledTextColor != i10) {
            this.unfilledTextColor = i10;
            a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressSplitTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.filledTextColor = -16777216;
        this.unfilledTextColor = -1;
    }

    public /* synthetic */ ProgressSplitTextView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
