package com.stepos.ailauncher.chat.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010#J\u001f\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J1\u0010-\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0012H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0011\u0010C\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ImeHintEditText;", "Lcom/stepos/ailauncher/chat/view/c7;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "idle", "typing", "", "showing", "LY8/t;", "e", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)V", "", "rawFraction", "k", "(F)V", "shown", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, UxipConstants.f30680s, "available", "Landroid/text/StaticLayout;", "f", "(Ljava/lang/CharSequence;I)Landroid/text/StaticLayout;", "hintLayout", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "weight", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/graphics/Canvas;Landroid/text/StaticLayout;IF)V", "Lcom/stepos/ailauncher/chat/input/a;", "blend", "Lcom/stepos/ailauncher/chat/input/a;", "Landroid/view/animation/PathInterpolator;", "curve", "Landroid/view/animation/PathInterpolator;", "Landroid/text/TextPaint;", "hintPaint", "Landroid/text/TextPaint;", "Landroid/content/res/ColorStateList;", "savedHintColors", "Landroid/content/res/ColorStateList;", "idleText", "Ljava/lang/CharSequence;", "typingText", "idleLayout", "Landroid/text/StaticLayout;", "typingLayout", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "isHintAnimating", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImeHintEditText extends C2785c7 {
    private final com.stepos.ailauncher.chat.input.a blend;
    private final PathInterpolator curve;
    private final TextPaint hintPaint;
    private StaticLayout idleLayout;
    private CharSequence idleText;
    private ColorStateList savedHintColors;
    private StaticLayout typingLayout;
    private CharSequence typingText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImeHintEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void e(CharSequence idle, CharSequence typing, boolean showing) {
        kotlin.jvm.internal.p.i(idle, "idle");
        kotlin.jvm.internal.p.i(typing, "typing");
        if (!this.blend.getRunning()) {
            this.savedHintColors = getHintTextColors();
            setHintTextColor(0);
        }
        this.idleText = idle;
        this.typingText = typing;
        this.blend.e(showing);
        j();
        invalidate();
    }

    public final StaticLayout f(CharSequence value, int available) {
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(value, 0, value.length(), this.hintPaint, available).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(getLayoutDirection() == 1 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR).setIncludePad(getIncludeFontPadding()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).build();
        kotlin.jvm.internal.p.h(staticLayoutBuild, "build(...)");
        return staticLayoutBuild;
    }

    public final void g(Canvas canvas, StaticLayout hintLayout, int alpha, float weight) {
        if (hintLayout == null || weight <= 0.0f) {
            return;
        }
        this.hintPaint.setAlpha((int) (alpha * weight));
        int iSave = canvas.save();
        canvas.clipRect(getScrollX() + getCompoundPaddingLeft(), getScrollY() + getExtendedPaddingTop(), (getScrollX() + getWidth()) - getCompoundPaddingRight(), (getScrollY() + getHeight()) - getExtendedPaddingBottom());
        canvas.translate(getCompoundPaddingLeft(), getBaseline() - hintLayout.getLineBaseline(0));
        hintLayout.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public final void h(boolean shown) {
        this.blend.d(shown);
        ColorStateList colorStateList = this.savedHintColors;
        if (colorStateList != null) {
            setHintTextColor(colorStateList);
        }
        this.savedHintColors = null;
        this.idleLayout = null;
        this.typingLayout = null;
        invalidate();
    }

    public final boolean i() {
        return this.blend.getRunning();
    }

    public final void j() {
        int width = (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        if (width <= 0) {
            return;
        }
        this.hintPaint.set(getPaint());
        this.idleLayout = f(this.idleText, width);
        this.typingLayout = f(this.typingText, width);
    }

    public final void k(float rawFraction) {
        this.blend.c(this.curve.getInterpolation(C5685n.m(rawFraction, 0.0f, 1.0f)));
        if (this.blend.getRunning()) {
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void onDetachedFromWindow() {
        h(false);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ColorStateList colorStateList;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        super.onDraw(canvas);
        if (this.blend.getRunning()) {
            Editable text = getText();
            if ((text == null || text.length() == 0) && (colorStateList = this.savedHintColors) != null) {
                this.hintPaint.setColor(colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor()));
                int alpha = this.hintPaint.getAlpha();
                g(canvas, this.idleLayout, alpha, 1.0f - this.blend.getShortAlpha());
                g(canvas, this.typingLayout, alpha, this.blend.getShortAlpha());
                this.hintPaint.setAlpha(alpha);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (this.blend.getRunning()) {
            j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImeHintEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.blend = new com.stepos.ailauncher.chat.input.a();
        this.curve = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.hintPaint = new TextPaint();
        this.idleText = "";
        this.typingText = "";
    }

    public /* synthetic */ ImeHintEditText(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.editTextStyle : i10);
    }
}
