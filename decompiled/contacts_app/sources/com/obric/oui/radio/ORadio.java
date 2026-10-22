package com.obric.oui.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ORadio.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use OCheckBox")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007J\u001c\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "isFitOld", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "adaptForCSR", "alwaysLight", "style", "applyStyle", "", "onAttachedToWindow", "setChecked", MaterialConfigFormatNames.CHECKED, "setStyle", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ORadio extends AppCompatRadioButton {
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean isFitOld;
    private int style;

    public ORadio(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, false, 14, null);
    }

    public ORadio(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, false, 12, null);
    }

    public ORadio(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, false, 8, null);
    }

    public /* synthetic */ ORadio(Context r2, AttributeSet r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    public ORadio(Context r3, AttributeSet r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.isFitOld = r6;
        this.adaptForCSR = true;
        if (r4 == null) goto L6;
        TypedArray r7 = r3.obtainStyledAttributes(r4, R.styleable.ORadio, r5, 0);
        Intrinsics.checkNotNullExpressionValue(r7, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.isFitOld = r7.getBoolean(R.styleable.ORadio_oui_fitOld, this.isFitOld);
        this.style = r7.getInt(R.styleable.ORadio_oui_radioStyle, 0);
        this.adaptForCSR = r7.getBoolean(R.styleable.ORadio_oui_adapt_for_csr, true);
        this.alwaysLight = r7.getBoolean(R.styleable.ORadio_oui_radioAlwaysLight, false);
        r7.recycle();
    L6:
        if (this.isFitOld == true) goto L8;
        applyStyle();
        return;
    L8:
        setClickable(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.adaptForCSR == false) goto L9;
        ORadio r1 = this;
        ViewExtensionsKt.expandTouchArea(r1, OUnitExtensionKt.vdp(r1, 44));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        super.setChecked(r3);
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L12;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        setVisibility(r4);
        return;
    L9:
        r4 = 4;
        goto L10
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Use OTextView individually", replaceWith = @ReplaceWith(expression = "OTextView", imports = {}))
    public void setText(CharSequence r1, TextView.BufferType r2) {
        super.setText(r1, r2);
    }

    public final void setStyle(int r2) {
        if (this.isFitOld == false) goto L5;
        return;
    L5:
        this.style = r2;
        applyStyle();
    }

    private final void applyStyle() {
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L9;
        setButtonDrawable(R.drawable.o_ic_radio_tick_checked);
    L13:
        setChecked(isChecked());
        return;
    L9:
        if (this.alwaysLight == false) goto L11;
        int r0 = R.drawable.o_radio_round_always_light;
    L12:
        setButtonDrawable(r0);
        goto L13
    L11:
        r0 = R.drawable.o_radio_round;
        goto L12
    }
}
