package com.stepos.widget.tabbar;

import Y8.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.stepos.widget.R;
import com.stepos.widget.internal.HotspotRipple;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleActionView;", "Lcom/stepos/widget/tabbar/StepOSCollapsibleGlassSurface;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/drawable/Drawable;", "icon", "LY8/t;", "setIcon$StepOSWidget_release", "(Landroid/graphics/drawable/Drawable;)V", "setIcon", "Landroid/content/res/ColorStateList;", "tint", "setIconTint$StepOSWidget_release", "(Landroid/content/res/ColorStateList;)V", "setIconTint", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/ImageView;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSCollapsibleActionView extends StepOSCollapsibleGlassSurface {
    private final ImageView iconView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleActionView(Context context) throws Resources.NotFoundException {
        super(context, null, 2, null);
        kotlin.jvm.internal.p.i(context, "context");
        ImageView imageView = new ImageView(context);
        this.iconView = imageView;
        setClickable(true);
        setFocusable(true);
        HotspotRipple.install$StepOSWidget_release$default(HotspotRipple.INSTANCE, this, androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_item_ripple), 0.0f, true, false, 0.0f, 52, null);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_collapsible_tabbar_action_icon_size);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImportantForAccessibility(2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        t tVar = t.f7040a;
        addView(imageView, layoutParams);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        kotlin.jvm.internal.p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
    }

    public final void setIcon$StepOSWidget_release(Drawable icon) {
        this.iconView.setImageDrawable(icon);
    }

    public final void setIconTint$StepOSWidget_release(ColorStateList tint) {
        this.iconView.setImageTintList(tint);
    }
}
