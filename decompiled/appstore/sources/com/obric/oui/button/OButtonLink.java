package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.d;
import bg.h;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yf.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001#B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "alpha", "onPressAlphaChange", "(I)V", "", "fraction", "d", "(F)V", "b", "(F)I", "Lcom/obric/oui/text/OBaseTextView;", "h", "Lcom/obric/oui/text/OBaseTextView;", "textView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "arrowView", "j", "I", "pressOverlayColor", "k", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonLink extends OUILinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f12494k = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OBaseTextView f12495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f12496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12497j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12494k = new a(null);
    }

    @JvmOverloads
    public OButtonLink(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    private final void c(Context r18, AttributeSet r19) {
        TypedArray r10 = r18.obtainStyledAttributes(r19, R$styleable.OButtonLink);
        q.f(r10, "context.obtainStyledAttr… R.styleable.OButtonLink)");
        String r11 = r10.getString(R$styleable.OButtonLink_oui_widgetText);
        int r12 = r10.getResourceId(R$styleable.OButtonLink_oui_widgetTextStyle, R$style.Button_1_Medium);
        Drawable r13 = null;
        int r14 = r10.getColor(R$styleable.OButtonLink_oui_widgetTextColor, getResources().getColor(R$color.oui_accent_7_fg, null));
        boolean r15 = r10.getBoolean(R$styleable.OButtonLink_oui_buttonLinkShowArrow, false);
        Drawable r16 = r10.getDrawable(R$styleable.OButtonLink_oui_buttonLinkArrowDrawable);
        setOrientation(0);
        OBaseTextView r17 = new OBaseTextView(r18, null, 0, 6, null);
        r17.setSingleLine();
        r17.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r17.setTextAppearance(r12);
        r17.setTextColor(r14);
        r17.setText(r11);
        r17.setIncludeFontPadding(false);
        r17.setGravity(17);
        this.f12495h = r17;
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-2, -2);
        r20.weight = 1.0f;
        Unit r21 = Unit.f21064a;
        addView(r17, r20);
        if (r15 == false) goto L12;
        AppCompatImageView r22 = new AppCompatImageView(r18);
        if (r16 == null) goto L11;
        Drawable r23 = r16.mutate();
        if (r23 == null) goto L11;
        r23.setTint(r14);
        r13 = r23;
    L11:
        r22.setImageDrawable(r13);
        this.f12496i = r22;
        addView(r22, new LinearLayout.LayoutParams(-2, -2));
    L12:
        r10.recycle();
        setOverridePressColor(0);
        refreshColors("OButtonLink");
        setChangeAlphaWhenPress(true);
        setClickable(true);
    }

    public final int b(float r10) {
        return d.k(this.f12497j, h.k(b.b(r10 * Color.alpha(this.f12497j)), 0, PrivateKeyType.INVALID));
    }

    public final void d(float r10) {
        int r11 = b(r10);
        OBaseTextView r12 = null;
        if (r10 <= 0.0f) goto L5;
        PorterDuffColorFilter r13 = new PorterDuffColorFilter(r11, PorterDuff.Mode.SRC_ATOP);
    L6:
        OBaseTextView r14 = this.f12495h;
        if (r14 != null) goto L9;
        q.y("textView");
        r14 = null;
    L9:
        r14.getPaint().setColorFilter(r13);
        OBaseTextView r15 = this.f12495h;
        if (r15 != null) goto L12;
        q.y("textView");
    L13:
        r12.invalidate();
        if (r13 == null) goto L19;
        ImageView r16 = this.f12496i;
        if (r16 == null) goto L25;
        r16.setColorFilter(r13);
        return;
    L25:
        return;
    L19:
        ImageView r17 = this.f12496i;
        if (r17 == null) goto L26;
        r17.clearColorFilter();
        return;
    L26:
        return;
    L12:
        r12 = r15;
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r10) {
        d(h.j(r10 / 255.0f, 0.0f, 1.0f));
    }

    @JvmOverloads
    public OButtonLink(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OButtonLink(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OButtonLink(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public OButtonLink(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        this.f12497j = r10.getResources().getColor(R$color.oui_state_overlay_pressed_on_color);
        c(r10, r11);
    }
}
