package com.stepos.widget.searchbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchEditText;", "Landroid/widget/EditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "applyEditableState", "()V", "", "show", "showIme", "(Z)V", UxipConstants.f30680s, "isEditable", "Z", "()Z", "setEditable", "isInputComplete", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class StepOSSearchEditText extends EditText {
    private boolean isEditable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSearchEditText(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void applyEditableState() {
        if (this.isEditable) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            setLongClickable(true);
            setCursorVisible(true);
            setMovementMethod(getDefaultMovementMethod());
            return;
        }
        setFocusable(false);
        setFocusableInTouchMode(false);
        setClickable(false);
        setLongClickable(false);
        setCursorVisible(false);
        setMovementMethod(null);
        setTextIsSelectable(false);
    }

    /* renamed from: isEditable, reason: from getter */
    public final boolean getIsEditable() {
        return this.isEditable;
    }

    public final boolean isInputComplete() {
        return BaseInputConnection.getComposingSpanStart(getEditableText()) == -1;
    }

    public final void setEditable(boolean z10) {
        this.isEditable = z10;
        applyEditableState();
    }

    public final void showIme(boolean show) {
        WindowInsetsController windowInsetsController = getWindowInsetsController();
        if (show) {
            requestFocus();
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
                return;
            }
            return;
        }
        clearFocus();
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsets.Type.ime());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSearchEditText(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSSearchEditText(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposSearchBarEditTextStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_SearchBar_EditText : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSearchEditText(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.isEditable = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSSearchEditText, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setEditable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSearchEditText_steposSearchEditable, true));
        Y8.t tVar = Y8.t.f7040a;
        typedArrayObtainStyledAttributes.recycle();
    }
}
