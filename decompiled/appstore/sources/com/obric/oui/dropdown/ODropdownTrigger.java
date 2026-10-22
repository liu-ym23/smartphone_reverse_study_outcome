package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.d;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0017\u0010(\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010.\u001a\u00020)8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00103\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8\u0002@BX\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R+\u0010:\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00138F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>R(\u0010D\u001a\u0004\u0018\u00010<2\b\u0010(\u001a\u0004\u0018\u00010<8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "d", "()V", "f", "e", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "h", "I", "backgroundOff", "i", "backgroundOn", "j", "iconOff", "k", "iconOn", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", CommonKey.KEY_VALUE, "Landroid/widget/ImageView;", "m", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", ServerElements.ICON, "Lcom/obric/oui/dropdown/ODropdown;", "<set-?>", "n", "Lcom/obric/oui/dropdown/ODropdown;", "dropdown", "o", "Lkotlin/properties/ReadWriteProperty;", "getActive", "()Z", "setActive", "(Z)V", "active", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "p", "Ljava/lang/ref/WeakReference;", TypedValues.Custom.S_REFERENCE, "getDropdownActivity", "()Landroid/app/Activity;", "setDropdownActivity", "(Landroid/app/Activity;)V", "dropdownActivity", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODropdownTrigger extends OUILinearLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f14508q = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f14512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f14513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f14514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ODropdown f14515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ReadWriteProperty f14516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference f14517p;

    public static final class a extends zf.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ODropdownTrigger f14518b;

        public a(Object r10, ODropdownTrigger r11) {
            this.f14518b = r11;
            super(r10);
        }

        @Override // zf.b
        public void a(KProperty r10, Object r11, Object r12) {
            q.g(r10, "property");
            boolean r13 = ((Boolean) r12).booleanValue();
            if (((Boolean) r11).booleanValue() == r13) goto L10;
            if (r13 == false) goto L7;
            this.f14518b.f();
            return;
        L7:
            this.f14518b.e();
            return;
        }
    }

    static {
        f14508q = new KProperty[]{u.e(new MutablePropertyReference1Impl(ODropdownTrigger.class, "active", "getActive()Z", 0))};
    }

    @JvmOverloads
    public ODropdownTrigger(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void b(ODropdownTrigger r10, View r11) {
        c(r10, r11);
    }

    public static final void c(ODropdownTrigger r10, View r11) {
        q.g(r10, "this$0");
        r10.d();
    }

    public void d() {
        if (getDropdownActivity() != null) goto L6;
        d.c(d.f24779a, "ODropdownTrigger", "no activity for popup showing", null, 4, null);
        return;
    L6:
        Activity r10 = getDropdownActivity();
        if (r10 == null) goto L15;
        ODropdown r11 = this.f14515n;
        if (r11 == null) goto L13;
        ODropdown.DefaultImpls.a(r11, this, r10, null, new ODropdownTrigger$showPopup$1$1(this), 4, null);
        Unit r12 = Unit.f21064a;
    L13:
        setActive(true);
        return;
    }

    public void e() {
        this.f14514m.setImageResource(this.f14511j);
        setBackgroundColor(this.f14509h);
    }

    public void f() {
        this.f14514m.setImageResource(this.f14512k);
        setBackgroundColor(this.f14510i);
    }

    public final boolean getActive() {
        return ((Boolean) this.f14516o.getValue(this, f14508q[0])).booleanValue();
    }

    @Nullable
    public final Activity getDropdownActivity() {
        WeakReference r10 = this.f14517p;
        if (r10 != null) goto L6;
        q.y(TypedValues.Custom.S_REFERENCE);
        r10 = null;
    L6:
        return (Activity) r10.get();
    }

    @NotNull
    public final ImageView getIcon() {
        return this.f14514m;
    }

    @NotNull
    public final TextView getValue() {
        return this.f14513l;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setActive(boolean r10) {
        this.f14516o.setValue(this, f14508q[0], Boolean.valueOf(r10));
    }

    public final void setDropdownActivity(@Nullable Activity r10) {
        this.f14517p = new WeakReference(r10);
    }

    @JvmOverloads
    public ODropdownTrigger(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ODropdownTrigger(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ODropdownTrigger(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        OUIStyleProvider r13 = null;
        super(r10, r11, r12, r13, 8, null);
        zf.a r14 = zf.a.f26387a;
        this.f14516o = new a(Boolean.FALSE, this);
        if ((r10 instanceof Activity) == false) goto L5;
        setDropdownActivity((Activity) r10);
    L5:
        TypedArray r15 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.ODropdownTrigger, 0, 0);
        q.f(r15, "context.theme.obtainStyl…           0, 0\n        )");
        this.f14509h = r15.getColor(R$styleable.ODropdownTrigger_oui_backgroundOff, getResources().getColor(R$color.oui_fill_element_2, r10.getTheme()));
        this.f14510i = r15.getColor(R$styleable.ODropdownTrigger_oui_backgroundOn, getResources().getColor(R$color.oui_fill_active, r10.getTheme()));
        this.f14511j = r15.getResourceId(R$styleable.ODropdownTrigger_oui_iconOff, R$drawable.dropdown_default_off);
        this.f14512k = r15.getResourceId(R$styleable.ODropdownTrigger_oui_iconOn, R$drawable.dropdown_default_on);
        OBaseTextView r16 = new OBaseTextView(new g.b(r10, r15.getResourceId(R$styleable.ODropdownTrigger_oui_textStyle, R$style.ODropdownTriggerText)), null, 0, 6, null);
        this.f14513l = r16;
        addView(r16);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(r16.getLayoutParams());
        r17.weight = 1.0f;
        r17.rightMargin = r15.getDimensionPixelOffset(R$styleable.ODropdownTrigger_oui_midMargin, f.r(this, 0));
        r16.setLayoutParams(r17);
        ImageView r18 = new ImageView(new g.b(r10, r15.getResourceId(R$styleable.ODropdownTrigger_oui_imageStyle, R$style.ODropdownTriggerIcon)));
        this.f14514m = r18;
        addView(r18);
        e();
        setOnClickListener(new b(this));
    }
}
