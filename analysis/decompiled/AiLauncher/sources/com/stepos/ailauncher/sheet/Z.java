package com.stepos.ailauncher.sheet;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0003J\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\n*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/sheet/Z;", "", "<init>", "()V", "Landroid/graphics/drawable/Drawable;", "background", "", "multiplier", "", "preserveOpacity", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/drawable/Drawable;FZ)V", "c", "", "e", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Integer;", "color", Const.INTENT_KEY_UMID, "(Landroid/graphics/drawable/Drawable;I)V", "drawable", "Landroid/graphics/drawable/Drawable;", "originalColor", "I", "appliedColor", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    private int appliedColor;
    private Drawable drawable;
    private int originalColor;

    public static final int b(Z z10, float f10, int i10) {
        return C5227b.b(((z10.originalColor >>> i10) & 255) + ((((i0.STACK_BACKGROUND_RGB >>> i10) & 255) - r1) * f10));
    }

    public final void a(Drawable background, float multiplier, boolean preserveOpacity) {
        if (this.drawable != background) {
            c();
        }
        float fM = C5685n.m(multiplier, 0.0f, 1.0f);
        Integer numE = background != null ? e(background) : null;
        if (fM == 1.0f || numE == null) {
            c();
            return;
        }
        if (this.drawable == null) {
            this.drawable = background.mutate();
            this.originalColor = numE.intValue();
        } else {
            if (numE.intValue() != this.appliedColor) {
                this.originalColor = numE.intValue();
            }
        }
        int iB = preserveOpacity ? this.originalColor >>> 24 : C5227b.b((this.originalColor >>> 24) * fM);
        float fM2 = C5685n.m((1.0f - fM) / 0.09803921f, 0.0f, 1.0f);
        int iB2 = b(this, fM2, 0) | (iB << 24) | (b(this, fM2, 16) << 16) | (b(this, fM2, 8) << 8);
        this.appliedColor = iB2;
        if (numE.intValue() != iB2) {
            d(background, this.appliedColor);
        }
    }

    public final void c() {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            Integer numE = e(drawable);
            int i10 = this.appliedColor;
            if (numE != null && numE.intValue() == i10) {
                int i11 = this.appliedColor;
                int i12 = this.originalColor;
                if (i11 != i12) {
                    d(drawable, i12);
                }
            }
        }
        this.drawable = null;
    }

    public final void d(Drawable drawable, int i10) {
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(i10);
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i10);
        }
    }

    public final Integer e(Drawable drawable) {
        ColorStateList color;
        if (drawable instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) drawable).getColor());
        }
        if ((drawable instanceof GradientDrawable) && (color = ((GradientDrawable) drawable).getColor()) != null) {
            if (color.isStateful()) {
                color = null;
            }
            if (color != null) {
                return Integer.valueOf(color.getDefaultColor());
            }
        }
        return null;
    }
}
