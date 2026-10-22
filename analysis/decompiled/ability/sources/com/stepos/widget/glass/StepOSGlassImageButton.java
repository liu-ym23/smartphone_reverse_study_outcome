package com.stepos.widget.glass;

import D6.b;
import D6.f;
import D6.g;
import D6.h;
import D6.i;
import D6.k;
import D7.v;
import E6.d;
import O2.a;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatImageButton;
import com.stepos.ability.R;
import com.stepos.motionkit.fx.material.GlassEffect;
import java.util.Set;
import kotlin.Metadata;
import w6.AbstractC2104a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0006R,\u0010\u0018\u001a\u00020\u00112\b\b\u0001\u0010\u000b\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0006R*\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0006R$\u0010$\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\nR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/stepos/widget/glass/StepOSGlassImageButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "", "enabled", "LC7/r;", "setEnabled", "(Z)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "value", "k", "Z", "isGlassEnabled", "()Z", "setGlassEnabled", "", "l", "F", "getGlassCornerRadius", "()F", "setGlassCornerRadius", "(F)V", "glassCornerRadius", "m", "isGlassCrossWindow", "setGlassCrossWindow", "o", "isPressScaleEnabled", "setPressScaleEnabled", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "getGlassEffect", "()Lcom/stepos/motionkit/fx/material/GlassEffect;", "setGlassEffect", "(Lcom/stepos/motionkit/fx/material/GlassEffect;)V", "glassEffect", "getSurfaceDrawable", "()Landroid/graphics/drawable/Drawable;", "setSurfaceDrawable", "surfaceDrawable", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "glassActiveIds", "D6/k", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSGlassImageButton extends AppCompatImageButton {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f4106q = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a f4107a;
    public final f b;
    public k c;
    public boolean d;
    public D6.a e;
    public final boolean f;
    public final d g;
    public int h;
    public final b i;

    /* renamed from: j, reason: collision with root package name */
    public final h f4108j;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean isGlassEnabled;

    /* renamed from: l, reason: from kotlin metadata */
    public float glassCornerRadius;

    /* renamed from: m, reason: from kotlin metadata */
    public boolean isGlassCrossWindow;
    public GlassEffect n;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean isPressScaleEnabled;
    public Drawable p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 12);
        kotlin.jvm.internal.k.f(context, "context");
    }

    public final void a() {
        this.b.d();
        this.c = null;
        invalidate();
    }

    public final void b() {
        if (this.isGlassEnabled && isAttachedToWindow() && !this.d) {
            this.d = true;
            post(this.i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableHotspotChanged(float f, float f7) {
        Drawable drawable;
        super.drawableHotspotChanged(f, f7);
        a aVar = this.f4107a;
        if (aVar != null && (drawable = (Drawable) aVar.c) != null) {
            drawable.setHotspot(f, f7);
        }
        Drawable foreground = getForeground();
        if (foreground != null) {
            foreground.setHotspot(f, f7);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f4107a;
        if (aVar == null || !aVar.q()) {
            return;
        }
        invalidate();
    }

    public final Set<String> getGlassActiveIds() {
        return v.j1(this.b.e);
    }

    @Px
    public final float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public final GlassEffect getGlassEffect() {
        GlassEffect glassEffect = this.n;
        if (glassEffect != null) {
            return glassEffect;
        }
        Context context = getContext();
        kotlin.jvm.internal.k.e(context, "getContext(...)");
        return (context.getResources().getConfiguration().uiMode & 48) == 32 ? GlassEffect.INSTANCE.getDARK_SMALL() : GlassEffect.INSTANCE.getLIGHT_SMALL();
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public final Drawable getP() {
        return this.p;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        Drawable drawable;
        super.jumpDrawablesToCurrentState();
        a aVar = this.f4107a;
        if (aVar == null || (drawable = (Drawable) aVar.c) == null) {
            return;
        }
        drawable.jumpToCurrentState();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isPressScaleEnabled) {
            this.g.a();
        }
        b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.k.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.f4108j.a(newConfig);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.i);
        this.d = false;
        h hVar = this.f4108j;
        hVar.f384a.removeCallbacks(hVar.f);
        hVar.e = false;
        this.g.e();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        a aVar;
        kotlin.jvm.internal.k.f(canvas, "canvas");
        if (!this.b.d && (aVar = this.f4107a) != null) {
            aVar.m(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        Drawable drawable;
        super.onRtlPropertiesChanged(i);
        a aVar = this.f4107a;
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

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.k.f(event, "event");
        if (this.f && this.isPressScaleEnabled && isEnabled()) {
            this.g.d(event);
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        int i = enabled ? 255 : 77;
        this.h = i;
        setImageAlpha(i);
        if (!this.f || enabled) {
            return;
        }
        this.g.e();
    }

    public final void setGlassCornerRadius(@Px float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f).toString());
        }
        if (this.glassCornerRadius == f) {
            return;
        }
        this.glassCornerRadius = f;
        a();
        b();
    }

    public final void setGlassCrossWindow(boolean z10) {
        if (this.isGlassCrossWindow == z10) {
            return;
        }
        this.isGlassCrossWindow = z10;
        a();
        b();
    }

    public final void setGlassEffect(GlassEffect value) {
        kotlin.jvm.internal.k.f(value, "value");
        boolean z10 = this.e != null;
        this.e = null;
        if (!kotlin.jvm.internal.k.b(this.n, value) || z10) {
            this.n = value;
            a();
            b();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            b();
        } else {
            a();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setImageAlpha(this.h);
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.isPressScaleEnabled == z10) {
            return;
        }
        this.isPressScaleEnabled = z10;
        d dVar = this.g;
        if (!z10) {
            dVar.e();
        }
        if (z10 && isAttachedToWindow()) {
            dVar.a();
        }
    }

    public final void setSurfaceDrawable(Drawable drawable) {
        this.p = drawable;
        a aVar = this.f4107a;
        if (aVar != null) {
            aVar.p(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean verifyDrawable(Drawable who) {
        kotlin.jvm.internal.k.f(who, "who");
        a aVar = this.f4107a;
        return (aVar != null && who == ((Drawable) aVar.c)) || super.verifyDrawable(who);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StepOSGlassImageButton(Context context, AttributeSet attributeSet, int i) {
        attributeSet = (i & 2) != 0 ? null : attributeSet;
        super(context, attributeSet, R.attr.steposGlassImageButtonStyle);
        this.b = new f(this);
        this.g = new d(this);
        this.h = 255;
        this.i = new b(this, 2);
        this.f4108j = new h(this, new i(this, 0));
        this.isGlassEnabled = true;
        this.isPressScaleEnabled = true;
        this.f4107a = new a(this);
        setBackground(null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2104a.d, R.attr.steposGlassImageButtonStyle, R.style.StepOSWidget_GlassImageButton);
        kotlin.jvm.internal.k.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        GlassEffect glassEffectA = g.a(typedArrayObtainStyledAttributes, 1);
        if (glassEffectA != null) {
            setGlassEffect(glassEffectA);
        }
        setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(2, true));
        setGlassCrossWindow(typedArrayObtainStyledAttributes.getBoolean(0, false));
        setPressScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(3, true));
        typedArrayObtainStyledAttributes.recycle();
        int i6 = isEnabled() ? 255 : 77;
        this.h = i6;
        setImageAlpha(i6);
        this.f = true;
    }
}
