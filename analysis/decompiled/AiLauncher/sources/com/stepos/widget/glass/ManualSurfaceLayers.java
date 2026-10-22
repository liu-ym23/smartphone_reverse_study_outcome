package com.stepos.widget.glass;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/widget/glass/ManualSurfaceLayers;", "", "Landroid/view/View;", "owner", "<init>", "(Landroid/view/View;)V", "Landroid/graphics/drawable/Drawable;", ChatTracker.WORLD_OLD, Const.STR_NEW, "replace", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "draw", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Canvas;)V", "setSurface", "(Landroid/graphics/drawable/Drawable;)V", "(Landroid/graphics/Canvas;)V", "", "stateChanged", "()Z", "", "x", "y", "hotspotChanged", "(FF)V", "jumpToCurrentState", "()V", "", "layoutDirection", "updateLayoutDirection", "(I)V", "verify", "(Landroid/graphics/drawable/Drawable;)Z", "Landroid/view/View;", "surface", "Landroid/graphics/drawable/Drawable;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ManualSurfaceLayers {
    private final View owner;
    private Drawable surface;

    public ManualSurfaceLayers(View owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.owner = owner;
    }

    private final Drawable replace(Drawable old, Drawable drawable) {
        if (old == drawable) {
            return old;
        }
        if (old != null) {
            old.setCallback(null);
        }
        if (drawable != null) {
            drawable.setCallback(this.owner);
            drawable.setLayoutDirection(this.owner.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.owner.getDrawableState());
            }
            drawable.setVisible(this.owner.getVisibility() == 0, true);
        }
        this.owner.invalidate();
        return drawable;
    }

    public final void draw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        draw(this.surface, canvas);
    }

    public final void hotspotChanged(float x10, float y10) {
        Drawable drawable = this.surface;
        if (drawable != null) {
            drawable.setHotspot(x10, y10);
        }
    }

    public final void jumpToCurrentState() {
        Drawable drawable = this.surface;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void setSurface(Drawable drawable) {
        this.surface = replace(this.surface, drawable);
    }

    public final boolean stateChanged() {
        Drawable drawable = this.surface;
        return drawable != null && drawable.isStateful() && drawable.setState(this.owner.getDrawableState());
    }

    public final void updateLayoutDirection(int layoutDirection) {
        Drawable drawable = this.surface;
        if (drawable != null) {
            drawable.setLayoutDirection(layoutDirection);
        }
    }

    public final boolean verify(Drawable drawable) {
        kotlin.jvm.internal.p.i(drawable, "drawable");
        return drawable == this.surface;
    }

    private final void draw(Drawable drawable, Canvas canvas) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, this.owner.getWidth(), this.owner.getHeight());
        drawable.draw(canvas);
    }
}
