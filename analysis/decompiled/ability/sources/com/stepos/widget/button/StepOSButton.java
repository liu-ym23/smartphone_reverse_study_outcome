package com.stepos.widget.button;

import D6.f;
import D6.g;
import D6.h;
import O2.a;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import com.stepos.ability.R;
import com.stepos.ability.task.executor.e;
import com.stepos.motionkit.fx.material.GlassEffect;
import i9.l;
import io.modelcontextprotocol.spec.c;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import w6.AbstractC2104a;
import x6.C2116a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006R*\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/widget/button/StepOSButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "enabled", "LC7/r;", "setEnabled", "(Z)V", "value", "g", "Z", "isGlassEnabled", "()Z", "setGlassEnabled", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "h", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "getGlassEffect", "()Lcom/stepos/motionkit/fx/material/GlassEffect;", "setGlassEffect", "(Lcom/stepos/motionkit/fx/material/GlassEffect;)V", "glassEffect", "Landroid/graphics/drawable/Drawable;", "getSurfaceDrawable", "()Landroid/graphics/drawable/Drawable;", "setSurfaceDrawable", "(Landroid/graphics/drawable/Drawable;)V", "surfaceDrawable", "x6/a", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSButton extends AppCompatTextView {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f4086j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a f4087a;
    public final f b;
    public C2116a c;
    public boolean d;
    public final c e;
    public final h f;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean isGlassEnabled;

    /* renamed from: h, reason: from kotlin metadata */
    public GlassEffect glassEffect;
    public Drawable i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.StepOSWidget_Button), attributeSet, R.attr.steposButtonStyle);
        k.f(context, "context");
        this.b = new f(this);
        this.e = new c(this, 7);
        this.f = new h(this, new l(this, 5));
        this.isGlassEnabled = true;
        this.glassEffect = GlassEffect.INSTANCE.getDARK_SMALL();
        this.f4087a = new a(this);
        setClickable(true);
        setFocusable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2104a.b, R.attr.steposButtonStyle, R.style.StepOSWidget_Button);
        try {
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(2, true));
            GlassEffect glassEffectA = g.a(typedArrayObtainStyledAttributes, 1);
            if (glassEffectA != null) {
                setGlassEffect(glassEffectA);
            }
            e.s(typedArrayObtainStyledAttributes, null);
            Drawable background = getBackground();
            setBackground(null);
            setSurfaceDrawable(background);
            setAlpha(isEnabled() ? 1.0f : 0.3f);
        } finally {
        }
    }

    public final void b() {
        if (this.isGlassEnabled && isAttachedToWindow() && !this.d) {
            this.d = true;
            post(this.e);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f7) {
        Drawable drawable;
        super.drawableHotspotChanged(f, f7);
        a aVar = this.f4087a;
        if (aVar == null || (drawable = (Drawable) aVar.c) == null) {
            return;
        }
        drawable.setHotspot(f, f7);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f4087a;
        if (aVar == null || !aVar.q()) {
            return;
        }
        invalidate();
    }

    public GlassEffect getGlassEffect() {
        return this.glassEffect;
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public Drawable getI() {
        return this.i;
    }

    @Override // android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        Drawable drawable;
        super.jumpDrawablesToCurrentState();
        a aVar = this.f4087a;
        if (aVar == null || (drawable = (Drawable) aVar.c) == null) {
            return;
        }
        drawable.jumpToCurrentState();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration newConfig) {
        k.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.f.a(newConfig);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.e);
        this.d = false;
        h hVar = this.f;
        hVar.f384a.removeCallbacks(hVar.f);
        hVar.e = false;
        this.b.d();
        this.c = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        k.f(canvas, "canvas");
        a aVar = this.f4087a;
        if (aVar != null) {
            aVar.m(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        k.f(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.Button");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        Drawable drawable;
        super.onRtlPropertiesChanged(i);
        a aVar = this.f4087a;
        if (aVar == null || (drawable = (Drawable) aVar.c) == null) {
            return;
        }
        drawable.setLayoutDirection(i);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        b();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(isEnabled() ? 1.0f : 0.3f);
    }

    public void setGlassEffect(GlassEffect value) {
        k.f(value, "value");
        if (k.b(this.glassEffect, value)) {
            return;
        }
        this.glassEffect = value;
        this.b.d();
        this.c = null;
        b();
    }

    public void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            b();
        } else {
            this.b.d();
            this.c = null;
        }
    }

    public void setSurfaceDrawable(Drawable drawable) {
        this.i = drawable;
        a aVar = this.f4087a;
        if (aVar != null) {
            aVar.p(drawable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable who) {
        k.f(who, "who");
        a aVar = this.f4087a;
        return (aVar != null && who == ((Drawable) aVar.c)) || super.verifyDrawable(who);
    }
}
