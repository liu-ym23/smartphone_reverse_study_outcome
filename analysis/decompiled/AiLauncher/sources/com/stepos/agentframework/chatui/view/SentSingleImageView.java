package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatui/view/SentSingleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SentSingleImageView extends AppCompatImageView {
    private static final float LANDSCAPE_HEIGHT_DP = 120.0f;
    private static final float PORTRAIT_HEIGHT_DP = 180.0f;
    private static final float RATIO_MAX = 1.7777778f;
    private static final float RATIO_MIN = 0.5625f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SentSingleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i10;
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
        float f10 = intrinsicWidth / intrinsicHeight;
        O6.d dVar = O6.d.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iA = dVar.a(context, 180.0f);
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        int iA2 = dVar.a(context2, 120.0f);
        if (intrinsicHeight > intrinsicWidth) {
            if (f10 < RATIO_MIN) {
                f10 = 0.5625f;
            }
            i10 = (int) (iA * f10);
        } else {
            if (f10 > RATIO_MAX) {
                f10 = 1.7777778f;
            }
            i10 = (int) (iA2 * f10);
            iA = iA2;
        }
        setMeasuredDimension(i10, iA);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SentSingleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setAdjustViewBounds(true);
    }

    public /* synthetic */ SentSingleImageView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
