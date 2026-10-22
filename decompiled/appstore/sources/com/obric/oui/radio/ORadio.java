package com.obric.oui.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use OCheckBox")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u000eR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "isFitOld", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "", "onAttachedToWindow", "()V", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "(Z)V", "", "text", "Landroid/widget/TextView$BufferType;", "type", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "style", "setStyle", "(I)V", "a", "Z", "b", "alwaysLight", "c", "adaptForCSR", "d", "I", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ORadio extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16515d;

    @JvmOverloads
    public ORadio(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        boolean r13 = false;
        this(r10, r11, r12, r13, 14, null);
    }

    public final void a() {
        if (this.f16512a == false) goto L6;
        return;
    L6:
        if (this.f16515d != 1) goto L9;
        setButtonDrawable(R$drawable.o_ic_radio_tick_checked);
    L13:
        setChecked(isChecked());
        return;
    L9:
        if (this.f16513b == false) goto L11;
        int r10 = R$drawable.o_radio_round_always_light;
    L12:
        setButtonDrawable(r10);
        goto L13
    L11:
        r10 = R$drawable.o_radio_round;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16512a == false) goto L6;
        return;
    L6:
        if (this.f16514c == false) goto L9;
        l.c(this, f.r(this, 44));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        super.setChecked(r10);
        if (this.f16512a == false) goto L6;
        return;
    L6:
        if (this.f16515d != 1) goto L12;
        if (r10 == false) goto L9;
        int r11 = 0;
    L10:
        setVisibility(r11);
        return;
    L9:
        r11 = 4;
        goto L10
    }

    public final void setStyle(int r10) {
        if (this.f16512a == false) goto L5;
        return;
    L5:
        this.f16515d = r10;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        super.setText(r10, r11);
    }

    @JvmOverloads
    public ORadio(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        boolean r13 = false;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public ORadio(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        boolean r13 = false;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ ORadio(Context r10, AttributeSet r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        this(r10, r11, r12, r13);
    }

    public ORadio(Context r10, AttributeSet r11, int r12, boolean r13) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16512a = r13;
        this.f16514c = true;
        if (r11 == null) goto L6;
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.ORadio, r12, 0);
        q.f(r14, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.f16512a = r14.getBoolean(R$styleable.ORadio_oui_fitOld, this.f16512a);
        this.f16515d = r14.getInt(R$styleable.ORadio_oui_radioStyle, 0);
        this.f16514c = r14.getBoolean(R$styleable.ORadio_oui_adapt_for_csr, true);
        this.f16513b = r14.getBoolean(R$styleable.ORadio_oui_radioAlwaysLight, false);
        r14.recycle();
    L6:
        if (this.f16512a == true) goto L8;
        a();
        return;
    L8:
        setClickable(true);
    }
}
