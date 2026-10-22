package com.stepos.widget.circlebutton;

import D6.f;
import D6.h;
import D6.n;
import D6.o;
import D7.v;
import E6.d;
import E6.e;
import O2.a;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.motionkit.fx.material.GlassEffect;
import io.modelcontextprotocol.spec.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import y6.C2133a;
import y6.C2134b;
import y6.C2135c;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001{J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0006J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\nJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0006J\u0017\u0010 \u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0006J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$R.\u0010,\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b\u001a\u0010+R,\u00102\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u0006R,\u00106\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u0010\u0006R,\u0010>\u001a\u0002072\b\b\u0001\u0010&\u001a\u0002078W@VX\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R.\u0010C\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010\u0014R,\u0010G\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u0012\n\u0004\bD\u0010.\u001a\u0004\bE\u00100\"\u0004\bF\u0010\u0006R.\u0010O\u001a\u0004\u0018\u00010H2\b\u0010&\u001a\u0004\u0018\u00010H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR,\u0010S\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u0012\n\u0004\bP\u0010.\u001a\u0004\bQ\u00100\"\u0004\bR\u0010\u0006R.\u0010W\u001a\u0004\u0018\u00010H2\b\u0010&\u001a\u0004\u0018\u00010H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bT\u0010J\u001a\u0004\bU\u0010L\"\u0004\bV\u0010NR,\u0010[\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00028W@VX\u0096\u000e¢\u0006\u0012\n\u0004\bX\u0010.\u001a\u0004\bY\u00100\"\u0004\bZ\u0010\u0006R*\u0010^\u001a\u00020!2\u0006\u0010&\u001a\u00020!8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010$R,\u0010d\u001a\u0002072\b\b\u0001\u0010&\u001a\u0002078W@VX\u0096\u000e¢\u0006\u0012\n\u0004\ba\u00109\u001a\u0004\bb\u0010;\"\u0004\bc\u0010=R*\u0010f\u001a\u00020!2\u0006\u0010&\u001a\u00020!8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\be\u0010]\u001a\u0004\bf\u0010_\"\u0004\bg\u0010$R*\u0010o\u001a\u00020h2\u0006\u0010&\u001a\u00020h8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR*\u0010q\u001a\u00020!2\u0006\u0010&\u001a\u00020!8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bp\u0010]\u001a\u0004\bq\u0010_\"\u0004\br\u0010$R(\u0010u\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bs\u0010\u0011\"\u0004\bt\u0010\u0014R\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020w0v8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010y¨\u0006|"}, d2 = {"Lcom/stepos/widget/circlebutton/StepOSCircleButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "resId", "LC7/r;", "setImageResource", "(I)V", "Landroid/graphics/Bitmap;", "bitmap", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Icon;", "icon", "setImageIcon", "(Landroid/graphics/drawable/Icon;)V", "Landroid/graphics/drawable/Drawable;", "getImageDrawable", "()Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setIconSizeRes", TypedValues.Custom.S_COLOR, "setIconTint", "setIconTintResource", "setSubTextSizeRes", "setSubText", "setSubDrawableResource", "setSubBitmap", "setSubIcon", "setSubDrawableSizeRes", "setSubDrawableTint", "setSubDrawableTintResource", "", "enabled", "setEnabled", "(Z)V", "", "value", "p", "Ljava/lang/CharSequence;", "getSubText", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "subText", "q", "I", "getSubTextSize", "()I", "setSubTextSize", "subTextSize", "r", "getSubTextColor", "setSubTextColor", "subTextColor", "", "s", "F", "getSubLetterSpacing", "()F", "setSubLetterSpacing", "(F)V", "subLetterSpacing", "t", "Landroid/graphics/drawable/Drawable;", "getSubDrawable", "setSubDrawable", "subDrawable", "u", "getSubDrawableSize", "setSubDrawableSize", "subDrawableSize", "Landroid/content/res/ColorStateList;", "v", "Landroid/content/res/ColorStateList;", "getSubDrawableTintList", "()Landroid/content/res/ColorStateList;", "setSubDrawableTintList", "(Landroid/content/res/ColorStateList;)V", "subDrawableTintList", "w", "getIconSize", "setIconSize", "iconSize", "x", "getIconTintList", "setIconTintList", "iconTintList", "y", "getRippleColor", "setRippleColor", "rippleColor", "z", "Z", "isGlassEnabled", "()Z", "setGlassEnabled", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getGlassCornerRadius", "setGlassCornerRadius", "glassCornerRadius", "B", "isGlassCrossWindow", "setGlassCrossWindow", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "C", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "getGlassEffect", "()Lcom/stepos/motionkit/fx/material/GlassEffect;", "setGlassEffect", "(Lcom/stepos/motionkit/fx/material/GlassEffect;)V", "glassEffect", "D", "isPressScaleEnabled", "setPressScaleEnabled", "getSurfaceDrawable", "setSurfaceDrawable", "surfaceDrawable", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "glassActiveIds", "y6/c", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSCircleButton extends AppCompatTextView {

    /* renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ int f4088F = 0;

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public float glassCornerRadius;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public boolean isGlassCrossWindow;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public GlassEffect glassEffect;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public boolean isPressScaleEnabled;
    public Drawable E;

    /* renamed from: a, reason: collision with root package name */
    public final a f4093a;
    public final f b;
    public C2135c c;
    public boolean d;
    public D6.a e;
    public boolean f;
    public CharSequence g;
    public final int h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f4094j;
    public final boolean k;
    public final d l;
    public boolean m;
    public final c n;
    public final h o;

    /* renamed from: p, reason: from kotlin metadata */
    public CharSequence subText;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public int subTextSize;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public int subTextColor;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public float subLetterSpacing;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public Drawable subDrawable;

    /* renamed from: u, reason: from kotlin metadata */
    public int subDrawableSize;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public ColorStateList subDrawableTintList;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public int iconSize;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public ColorStateList iconTintList;

    /* renamed from: y, reason: from kotlin metadata */
    public int rippleColor;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public boolean isGlassEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0152 A[Catch: all -> 0x00dc, TRY_LEAVE, TryCatch #1 {all -> 0x00dc, blocks: (B:3:0x0063, B:5:0x00d4, B:8:0x00df, B:10:0x010b, B:11:0x010e, B:13:0x011d, B:14:0x0120, B:17:0x0128, B:19:0x012e, B:21:0x013e, B:23:0x0146, B:24:0x0152), top: B:44:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public StepOSCircleButton(android.content.Context r8, android.util.AttributeSet r9) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.circlebutton.StepOSCircleButton.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void b() {
        Drawable subDrawable = getSubDrawable();
        if (subDrawable == null) {
            return;
        }
        int subDrawableSize = getSubDrawableSize() > 0 ? getSubDrawableSize() : this.h;
        int intrinsicWidth = subDrawable.getIntrinsicWidth();
        int intrinsicHeight = subDrawable.getIntrinsicHeight();
        if (subDrawableSize > 0 && intrinsicWidth > 0 && intrinsicHeight > 0) {
            intrinsicWidth = (int) ((subDrawableSize * intrinsicWidth) / intrinsicHeight);
            if (intrinsicWidth < 1) {
                intrinsicWidth = 1;
            }
        } else if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            if (subDrawableSize < 1) {
                subDrawableSize = 1;
            }
            intrinsicWidth = subDrawableSize;
        } else {
            subDrawableSize = intrinsicHeight;
        }
        subDrawable.setBounds(0, 0, intrinsicWidth, subDrawableSize);
        subDrawable.setTintList(getSubDrawableTintList());
        subDrawable.setState(getDrawableState());
    }

    public final CharSequence c() {
        if (this.f4094j != null) {
            return "";
        }
        CharSequence charSequence = this.g;
        Drawable subDrawable = getSubDrawable();
        int i = this.h;
        int i6 = this.i;
        if (subDrawable != null) {
            b();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (charSequence.length() > 0) {
                spannableStringBuilder.append(charSequence);
                if (i6 > 0) {
                    spannableStringBuilder.setSpan(new C2133a(i6), 0, charSequence.length(), 33);
                }
                spannableStringBuilder.append('\n');
            }
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((char) 65532);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new ImageSpan(subDrawable, 2), length, length2, 33);
            int iHeight = subDrawable.getBounds().height();
            if (i < iHeight) {
                i = iHeight;
            }
            if (i > 0) {
                spannableStringBuilder.setSpan(new C2133a(i), length, length2, 33);
            }
            return spannableStringBuilder;
        }
        CharSequence subText = getSubText();
        if (subText == null || subText.length() == 0) {
            if (i6 <= 0 || charSequence.length() == 0) {
                return charSequence;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence);
            spannableStringBuilder2.setSpan(new C2133a(i6), 0, charSequence.length(), 33);
            return spannableStringBuilder2;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        spannableStringBuilder3.append(charSequence);
        if (i6 > 0 && charSequence.length() > 0) {
            spannableStringBuilder3.setSpan(new C2133a(i6), 0, charSequence.length(), 33);
        }
        spannableStringBuilder3.append('\n');
        int length3 = spannableStringBuilder3.length();
        spannableStringBuilder3.append(subText);
        int length4 = spannableStringBuilder3.length();
        spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(getSubTextSize(), false), length3, length4, 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(getSubTextColor()), length3, length4, 33);
        if (i > 0) {
            spannableStringBuilder3.setSpan(new C2133a(i), length3, length4, 33);
        }
        if (getSubLetterSpacing() == 0.0f) {
            return spannableStringBuilder3;
        }
        spannableStringBuilder3.setSpan(new C2134b(getSubLetterSpacing()), length3, length4, 33);
        return spannableStringBuilder3;
    }

    public final D6.a d() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            return new n(getResources().getDisplayMetrics().density, 0);
        }
        return o.f391a.a(getResources().getDisplayMetrics().density);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f7) {
        Drawable drawable;
        super.drawableHotspotChanged(f, f7);
        a aVar = this.f4093a;
        if (aVar != null && (drawable = (Drawable) aVar.c) != null) {
            drawable.setHotspot(f, f7);
        }
        Drawable foreground = getForeground();
        if (foreground != null) {
            foreground.setHotspot(f, f7);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        boolean z10 = false;
        a aVar = this.f4093a;
        if (aVar != null && aVar.q()) {
            z10 = true;
        }
        Drawable subDrawable = getSubDrawable();
        if ((subDrawable == null || !subDrawable.setState(getDrawableState())) ? z10 : true) {
            invalidate();
        }
    }

    public final void e() throws Resources.NotFoundException {
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        e.a(this, getRippleColor(), fMin, false, fMin);
        if (this.isPressScaleEnabled) {
            d dVar = this.l;
            if (dVar.l == 0.0f && dVar.m == 0.0f && dVar.n == 0.0f && !dVar.c) {
                return;
            }
            dVar.b();
        }
    }

    public final void f() {
        if (this.k) {
            super.setText(c(), TextView.BufferType.SPANNABLE);
        }
    }

    public final void g() {
        this.b.d();
        this.c = null;
        invalidate();
    }

    public Set<String> getGlassActiveIds() {
        return v.j1(this.b.e);
    }

    @Px
    public float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public GlassEffect getGlassEffect() {
        return this.glassEffect;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTintList() {
        return this.iconTintList;
    }

    /* renamed from: getImageDrawable, reason: from getter */
    public Drawable getF4094j() {
        return this.f4094j;
    }

    @ColorInt
    public int getRippleColor() {
        return this.rippleColor;
    }

    public Drawable getSubDrawable() {
        return this.subDrawable;
    }

    @Px
    public int getSubDrawableSize() {
        return this.subDrawableSize;
    }

    public ColorStateList getSubDrawableTintList() {
        return this.subDrawableTintList;
    }

    @FloatRange(from = 0.0d)
    public float getSubLetterSpacing() {
        return this.subLetterSpacing;
    }

    public CharSequence getSubText() {
        return this.subText;
    }

    @ColorInt
    public int getSubTextColor() {
        return this.subTextColor;
    }

    @Px
    public int getSubTextSize() {
        return this.subTextSize;
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public Drawable getE() {
        return this.E;
    }

    public final void h() {
        if (this.isGlassEnabled && isAttachedToWindow() && !this.d) {
            this.d = true;
            post(this.n);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        Drawable drawable;
        super.jumpDrawablesToCurrentState();
        a aVar = this.f4093a;
        if (aVar != null && (drawable = (Drawable) aVar.c) != null) {
            drawable.jumpToCurrentState();
        }
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setCallback(this);
        }
        if (this.isPressScaleEnabled) {
            this.l.a();
        }
        h();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration newConfig) {
        k.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.isGlassEnabled && this.f) {
            this.e = d();
        }
        this.o.a(newConfig);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.n);
        this.d = false;
        h hVar = this.o;
        hVar.f384a.removeCallbacks(hVar.f);
        hVar.e = false;
        this.l.e();
        g();
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setCallback(null);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        a aVar;
        k.f(canvas, "canvas");
        if (!this.b.d && (aVar = this.f4093a) != null) {
            aVar.m(canvas);
        }
        super.onDraw(canvas);
        Drawable drawable = this.f4094j;
        if (drawable != null) {
            float iconSize = (getIconSize() > 0 ? getIconSize() : Math.min(getWidth(), getHeight())) / 2.0f;
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            drawable.setBounds((int) (width - iconSize), (int) (height - iconSize), (int) (width + iconSize), (int) (height + iconSize));
            drawable.setState(getDrawableState());
            ColorStateList iconTintList = getIconTintList();
            if (iconTintList != null) {
                drawable.setTintList(iconTintList);
            }
            drawable.draw(canvas);
        }
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
        a aVar = this.f4093a;
        if (aVar != null && (drawable = (Drawable) aVar.c) != null) {
            drawable.setLayoutDirection(i);
        }
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setLayoutDirection(i);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) throws Resources.NotFoundException {
        super.onSizeChanged(i, i6, i10, i11);
        e();
        h();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        k.f(event, "event");
        if (this.k && this.isPressScaleEnabled && isEnabled()) {
            this.l.d(event);
        }
        return super.onTouchEvent(event);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!this.k || enabled) {
            return;
        }
        this.l.e();
    }

    public void setGlassCornerRadius(@Px float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f).toString());
        }
        if (this.glassCornerRadius == f) {
            return;
        }
        this.glassCornerRadius = f;
        g();
        h();
    }

    public void setGlassCrossWindow(boolean z10) {
        if (this.isGlassCrossWindow == z10) {
            return;
        }
        this.isGlassCrossWindow = z10;
        g();
        h();
    }

    public void setGlassEffect(GlassEffect value) {
        k.f(value, "value");
        boolean z10 = this.e != null;
        this.e = null;
        this.f = false;
        if (!k.b(this.glassEffect, value) || z10) {
            this.glassEffect = value;
            g();
            h();
        }
    }

    public void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            h();
        } else {
            g();
        }
    }

    public void setIconSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "iconSize must be >= 0 but was ").toString());
        }
        if (this.iconSize == i) {
            return;
        }
        this.iconSize = i;
        invalidate();
    }

    public final void setIconSizeRes(@DimenRes int resId) {
        setIconSize(getResources().getDimensionPixelSize(resId));
    }

    public final void setIconTint(@ColorInt int color) {
        setIconTintList(ColorStateList.valueOf(color));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        invalidate();
    }

    public final void setIconTintResource(@ColorRes int resId) {
        setIconTintList(ContextCompat.getColorStateList(getContext(), resId));
    }

    public final void setImageBitmap(Bitmap bitmap) {
        k.f(bitmap, "bitmap");
        setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public final void setImageDrawable(Drawable drawable) {
        this.f4094j = drawable;
        f();
        invalidate();
    }

    public final void setImageIcon(Icon icon) {
        k.f(icon, "icon");
        setImageDrawable(icon.loadDrawable(getContext()));
    }

    public final void setImageResource(@DrawableRes int resId) {
        setImageDrawable(ContextCompat.getDrawable(getContext(), resId));
    }

    public void setPressScaleEnabled(boolean z10) throws Resources.NotFoundException {
        if (this.isPressScaleEnabled == z10) {
            return;
        }
        this.isPressScaleEnabled = z10;
        d dVar = this.l;
        if (!z10) {
            dVar.e();
        }
        e();
        if (z10 && isAttachedToWindow()) {
            dVar.a();
        }
    }

    public void setRippleColor(@ColorInt int i) throws Resources.NotFoundException {
        if (this.rippleColor == i) {
            return;
        }
        this.rippleColor = i;
        e();
    }

    public final void setSubBitmap(Bitmap bitmap) {
        k.f(bitmap, "bitmap");
        setSubDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public void setSubDrawable(Drawable drawable) {
        CharSequence subText;
        if (drawable == null) {
            Drawable drawable2 = this.subDrawable;
            if (drawable2 == null) {
                return;
            }
            drawable2.setCallback(null);
            this.subDrawable = null;
            if (this.m) {
                return;
            }
            f();
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        k.e(drawableMutate, "mutate(...)");
        Drawable drawable3 = this.subDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        drawableMutate.setCallback(this);
        this.subDrawable = drawableMutate;
        b();
        if (!this.m && (subText = getSubText()) != null && subText.length() != 0) {
            this.m = true;
            try {
                setSubText((CharSequence) null);
            } finally {
                this.m = false;
            }
        }
        if (this.m) {
            return;
        }
        f();
    }

    public final void setSubDrawableResource(@DrawableRes int resId) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), resId);
        if (drawable == null) {
            throw new Resources.NotFoundException(androidx.appfunctions.metadata.a.i(resId, "Drawable resource #", " not found"));
        }
        setSubDrawable(drawable);
    }

    public void setSubDrawableSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "subDrawableSize must be >= 0 but was ").toString());
        }
        if (this.subDrawableSize == i) {
            return;
        }
        this.subDrawableSize = i;
        if (getSubDrawable() != null) {
            b();
            f();
        }
    }

    public final void setSubDrawableSizeRes(@DimenRes int resId) {
        setSubDrawableSize(getResources().getDimensionPixelSize(resId));
    }

    public final void setSubDrawableTint(@ColorInt int color) {
        setSubDrawableTintList(ColorStateList.valueOf(color));
    }

    public void setSubDrawableTintList(ColorStateList colorStateList) {
        if (k.b(this.subDrawableTintList, colorStateList)) {
            return;
        }
        this.subDrawableTintList = colorStateList;
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setTintList(colorStateList);
        }
        if (getSubDrawable() != null) {
            invalidate();
        }
    }

    public final void setSubDrawableTintResource(@ColorRes int resId) {
        setSubDrawableTintList(ContextCompat.getColorStateList(getContext(), resId));
    }

    public final void setSubIcon(Icon icon) {
        k.f(icon, "icon");
        setSubDrawable(icon.loadDrawable(getContext()));
    }

    public void setSubLetterSpacing(@FloatRange float f) {
        if (this.subLetterSpacing == f) {
            return;
        }
        this.subLetterSpacing = f;
        f();
    }

    public void setSubText(CharSequence charSequence) {
        boolean z10 = (this.m || getSubDrawable() == null) ? false : true;
        if (!k.b(this.subText, charSequence) || z10) {
            this.subText = charSequence;
            if (z10) {
                this.m = true;
                try {
                    setSubDrawable(null);
                } finally {
                    this.m = false;
                }
            }
            if (this.m) {
                return;
            }
            f();
        }
    }

    public void setSubTextColor(@ColorInt int i) {
        if (this.subTextColor == i) {
            return;
        }
        this.subTextColor = i;
        f();
    }

    public void setSubTextSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "subTextSize must be >= 0 but was ").toString());
        }
        if (this.subTextSize == i) {
            return;
        }
        this.subTextSize = i;
        f();
    }

    public final void setSubTextSizeRes(@DimenRes int resId) {
        setSubTextSize(getResources().getDimensionPixelSize(resId));
    }

    public void setSurfaceDrawable(Drawable drawable) {
        this.E = drawable;
        a aVar = this.f4093a;
        if (aVar != null) {
            aVar.p(drawable);
        }
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!this.k) {
            super.setText(charSequence, bufferType);
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        this.g = charSequence;
        super.setText(c(), TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable who) {
        a aVar;
        k.f(who, "who");
        return who == getSubDrawable() || ((aVar = this.f4093a) != null && who == ((Drawable) aVar.c)) || super.verifyDrawable(who);
    }

    public final void setSubText(@StringRes int resId) {
        setSubText(getResources().getText(resId));
    }
}
