package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import dd.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.c;
import tc.f;
import tc.l;
import td.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0003fghB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0001\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000eJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000f2\b\b\u0001\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0016H\u0016¢\u0006\u0004\b$\u0010!J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0016H\u0016¢\u0006\u0004\b&\u0010\u0019J\u0017\u0010)\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010+¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u000fH\u0014¢\u0006\u0004\b2\u0010#J7\u00108\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0014¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\b>\u0010#J\u000f\u0010?\u001a\u00020\u000fH\u0002¢\u0006\u0004\b?\u0010#J\u000f\u0010@\u001a\u00020\u000fH\u0002¢\u0006\u0004\b@\u0010#R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010BR\u0016\u0010E\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010DR\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010DR0\u0010L\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b?\u0010D\u0012\u0004\bK\u0010#\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010\u0013R\u0016\u0010N\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010MR\u0016\u0010P\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010SR\u0018\u0010Y\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010DR\u0016\u0010`\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010DR\u0016\u0010b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010DR\u0016\u0010d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010M¨\u0006i"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "c", "styleRes", "setStyle", "(I)V", "color", "setPrimaryColor", "", "light", "setAlwaysLight", "(Z)V", "enableExpand", "setEnableExpandTouchRect", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "isChecked", "()Z", "toggle", "()V", "performClick", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "listener", "setOnCheckedStateChangedListener", "(Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;)V", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;)V", "extraSpace", "", "onCreateDrawableState", "(I)[I", "onAttachedToWindow", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/TypedArray;", "array", "a", "(Landroid/content/res/TypedArray;)V", "e", "d", "b", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "buttonDrawable", "I", "colorStyle", "iconSize", CommonKey.KEY_VALUE, "getCheckedState", "()I", "setCheckedState", "getCheckedState$annotations", "checkedState", "Z", "broadcasting", "f", "alwaysLight", "Landroid/graphics/ColorFilter;", "g", "Landroid/graphics/ColorFilter;", "checkedColorFilter", "h", "uncheckedColorFilter", "i", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "onCheckedStateChangedListener", "j", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "onCheckedChangeListener", "k", "colorPrimary", "l", "colorChecked", "m", "colorUnchecked", "n", "adaptForCSR", "o", "Companion", "OnCheckedChangeListener", "OnCheckedStateChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCheckBox extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f12752o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f12753p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f12754q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f12755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorFilter f12761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorFilter f12762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OnCheckedStateChangedListener f12763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OnCheckedChangeListener f12764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12768n;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$Companion$CheckedState;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface CheckedState {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "", "onCheckedChanged", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", "isChecked", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCheckedChangeListener {
        void onCheckedChanged(@NotNull OCheckBox r10, boolean r11);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "", "onCheckedStateChangedListener", "", "buttonView", "Lcom/obric/oui/checkbox/OCheckBox;", WsConstants.KEY_CONNECTION_STATE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCheckedStateChangedListener {
        void onCheckedStateChangedListener(@NotNull OCheckBox r10, int r11);
    }

    static {
        f12752o = new Companion(null);
        f12753p = new int[]{R.attr.state_checked};
        f12754q = new int[]{R$attr.oui_state_indeterminate};
    }

    public OCheckBox(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }

    private final void c(Context r10, AttributeSet r11, int r12, int r13) {
        int[] r14 = R$styleable.OCheckBox;
        q.f(r14, "OCheckBox");
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14, r12, r13);
        q.f(r15, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        a(r15);
        this.f12768n = r15.getBoolean(R$styleable.ORadio_oui_adapt_for_csr, true);
        int r16 = R$styleable.OCheckBox_oui_checkedState;
        if (r15.hasValue(r16) == false) goto L5;
        setCheckedState(r15.getInt(r16, 0));
    L5:
        r15.recycle();
        b();
        e();
        setBackground(null);
        d();
        setClickable(true);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    public final void a(TypedArray r10) {
        this.f12756b = r10.getInt(R$styleable.OCheckBox_oui_checkBoxColorStyle, 0);
        this.f12765k = r10.getColor(R$styleable.OCheckBox_oui_checkBoxPrimaryColor, -1);
        this.f12766l = r10.getColor(R$styleable.OCheckBox_oui_checkBoxCheckedColor, -1);
        this.f12767m = r10.getColor(R$styleable.OCheckBox_oui_checkBoxUncheckedColor, -1);
        Drawable r11 = r10.getDrawable(R$styleable.OCheckBox_oui_checkBoxButton);
        if (r11 != null) goto L5;
        r11 = null;
    L5:
        this.f12755a = r11;
        this.f12760f = r10.getBoolean(R$styleable.OCheckBox_oui_checkBoxAlwaysLight, false);
    }

    public final void b() {
        int r10 = this.f12766l;
        if (r10 == (-1)) goto L6;
        this.f12761g = c.a(r10);
    L6:
        if (this.f12767m == (-1)) goto L9;
        this.f12762h = new PorterDuffColorFilter(this.f12767m, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final void d() {
        Drawable r10 = getDrawable();
        if (r10 == null) goto L6;
        r10.clearColorFilter();
    L6:
        b();
        Drawable r11 = getDrawable();
        if (r11 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r12 = this.f12761g;
    L13:
        r11.setColorFilter(r12);
        return;
    L12:
        r12 = this.f12762h;
        goto L13
    }

    public final void e() {
        if (this.f12760f == false) goto L6;
        Drawable r10 = getResources().getDrawable(R$drawable.o_checkbox_circle_always_light, null);
    L12:
        int r11 = this.f12765k;
        if (r11 != (-1)) goto L15;
    L17:
        setImageDrawable(r10);
        return;
    L15:
        if ((r10 instanceof StateListDrawable) == false) goto L17;
        g.f24800a.c((StateListDrawable) r10, "primary_shape", r11);
        goto L17
    L6:
        if (this.f12756b != 1) goto L8;
        r10 = getResources().getDrawable(R$drawable.o_checkbox_circle_on_image, null);
        goto L12
    L8:
        r10 = this.f12755a;
        if (r10 != null) goto L12;
        r10 = getResources().getDrawable(R$drawable.o_checkbox_circle, null);
        goto L12
    }

    public final int getCheckedState() {
        return this.f12758d;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.f12758d == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12768n == false) goto L6;
        l.c(this, f.r(this, 44));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 2);
        if (this.f12758d != 2) goto L6;
        ImageView.mergeDrawableStates(r11, f12754q);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r11, f12753p);
    L8:
        return r11;
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.makeMeasureSpec(this.f12757c, Ints.MAX_POWER_OF_TWO);
        super.onMeasure(r12, r12);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r10 = super.performClick();
        if (r10 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        a.b(getContext(), 1);
    L8:
        return r10;
    }

    public final void setAlwaysLight(boolean r10) {
        this.f12760f = r10;
        e();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        setCheckedState(r10 ? 1 : 0);
    }

    public final void setCheckedState(int r10) {
        if (this.f12758d == r10) goto L19;
        this.f12758d = r10;
        d();
        refreshDrawableState();
        if (this.f12759e == false) goto L7;
        return;
    L7:
        this.f12759e = true;
        OnCheckedStateChangedListener r11 = this.f12763i;
        if (r11 == null) goto L12;
        r11.onCheckedStateChangedListener(this, this.f12758d);
    L12:
        if (this.f12758d == 2) goto L17;
        OnCheckedChangeListener r12 = this.f12764j;
        if (r12 == null) goto L17;
        r12.onCheckedChanged(this, isChecked());
    L17:
        this.f12759e = false;
        return;
    }

    public final void setEnableExpandTouchRect(boolean r10) {
        this.f12768n = r10;
    }

    public final void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener r10) {
        this.f12764j = r10;
    }

    public final void setOnCheckedStateChangedListener(@Nullable OnCheckedStateChangedListener r10) {
        this.f12763i = r10;
    }

    public final void setPrimaryColor(@ColorInt int r10) {
        this.f12765k = r10;
        e();
        invalidate();
    }

    public final void setStyle(@StyleRes int r10) {
        Context r11 = getContext();
        q.f(r11, "context");
        int[] r12 = R$styleable.OCheckBox;
        q.f(r12, "OCheckBox");
        TypedArray r13 = r11.obtainStyledAttributes(null, r12, 0, r10);
        q.f(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        a(r13);
        r13.recycle();
        b();
        e();
        d();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public OCheckBox(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        this(r10, r11, R$attr.OCheckBoxStyle);
    }

    public OCheckBox(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        this(r10, r11, r12, R$style.OStyleV2_OCheckBox_DayNight);
    }

    public OCheckBox(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f12757c = f.r(this, 18);
        this.f12765k = -1;
        this.f12766l = -1;
        this.f12767m = -1;
        this.f12768n = true;
        c(r10, r11, r12, r13);
    }
}
