package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatui/view/g;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxWidthDp", "maxHeightDp", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(II)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "f", "(ILandroid/content/Context;)I", "maxWidthPx", "I", "maxHeightPx", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.view.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2074g extends AppCompatImageView {
    private int maxHeightPx;
    private int maxWidthPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2074g(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.maxWidthPx = f(300, context);
        this.maxHeightPx = f(300, context);
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setAdjustViewBounds(true);
    }

    public final int f(int i10, Context context) {
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }

    public final void g(int maxWidthDp, int maxHeightDp) {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        this.maxWidthPx = f(maxWidthDp, context);
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        this.maxHeightPx = f(maxHeightDp, context2);
        requestLayout();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i10;
        int i11;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (intrinsicHeight > intrinsicWidth) {
            i11 = this.maxHeightPx;
            i10 = (int) ((i11 * intrinsicWidth) / intrinsicHeight);
        } else {
            i10 = this.maxWidthPx;
            i11 = (int) ((i10 * intrinsicHeight) / intrinsicWidth);
        }
        setMeasuredDimension(i10, i11);
    }

    public /* synthetic */ C2074g(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
