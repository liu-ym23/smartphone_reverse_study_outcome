package com.stepos.widget.recipient;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.C1290c;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u000389:B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010&J\u0015\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001d¢\u0006\u0004\b)\u0010*R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView;", "Landroidx/appcompat/widget/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnKeyPreImeListener;", "listener", "LY8/t;", "setOnKeyPreImeListener", "(Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnKeyPreImeListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnDropDownListener;", "setOnDropDownListener", "(Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnDropDownListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnEmptyDeleteListener;", "setOnEmptyDeleteListener", "(Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnEmptyDeleteListener;)V", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "", "requestFocus", "(ILandroid/graphics/Rect;)Z", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyPreIme", "(ILandroid/view/KeyEvent;)Z", "showDropDown", "()V", "dismissDropDown", "close", DidiCardProvider.ACTION_DISMISS, "(Z)V", "Lkotlin/Function0;", "acceptFocusRequest", "Lp9/a;", "getAcceptFocusRequest$StepOSWidget_release", "()Lp9/a;", "setAcceptFocusRequest$StepOSWidget_release", "(Lp9/a;)V", "keyPreImeListener", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnKeyPreImeListener;", "dropDownListener", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnDropDownListener;", "emptyDeleteListener", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnEmptyDeleteListener;", "OnKeyPreImeListener", "OnDropDownListener", "OnEmptyDeleteListener", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientAutoCompleteTextView extends C1290c {
    private InterfaceC5063a<Boolean> acceptFocusRequest;
    private OnDropDownListener dropDownListener;
    private OnEmptyDeleteListener emptyDeleteListener;
    private OnKeyPreImeListener keyPreImeListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnDropDownListener;", "", "", "showing", "LY8/t;", "onDropDownVisibilityChanged", "(Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnDropDownListener {
        void onDropDownVisibilityChanged(boolean showing);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnEmptyDeleteListener;", "", "onEmptyDelete", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnEmptyDeleteListener {
        boolean onEmptyDelete();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnKeyPreImeListener;", "", "onKeyPreIme", "", "view", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView;", "keyCode", "", "event", "Landroid/view/KeyEvent;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnKeyPreImeListener {
        boolean onKeyPreIme(StepOSRecipientAutoCompleteTextView view, int keyCode, KeyEvent event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientAutoCompleteTextView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final void dismiss(boolean close) {
        if (close) {
            dismissDropDown();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        super.dismissDropDown();
        OnDropDownListener onDropDownListener = this.dropDownListener;
        if (onDropDownListener != null) {
            onDropDownListener.onDropDownVisibilityChanged(false);
        }
    }

    public final InterfaceC5063a<Boolean> getAcceptFocusRequest$StepOSWidget_release() {
        return this.acceptFocusRequest;
    }

    @Override // androidx.appcompat.widget.C1290c, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        kotlin.jvm.internal.p.i(outAttrs, "outAttrs");
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (inputConnectionOnCreateInputConnection == null) {
            return null;
        }
        return new InputConnectionWrapper(inputConnectionOnCreateInputConnection) { // from class: com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView.onCreateInputConnection.1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int beforeLength, int afterLength) {
                OnEmptyDeleteListener onEmptyDeleteListener;
                Editable text = this.getText();
                if ((text == null || text.length() == 0) && (onEmptyDeleteListener = this.emptyDeleteListener) != null && onEmptyDeleteListener.onEmptyDelete()) {
                    return true;
                }
                return super.deleteSurroundingText(beforeLength, afterLength);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
                OnEmptyDeleteListener onEmptyDeleteListener;
                Editable text = this.getText();
                if ((text == null || text.length() == 0) && (onEmptyDeleteListener = this.emptyDeleteListener) != null && onEmptyDeleteListener.onEmptyDelete()) {
                    return true;
                }
                return super.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
            }
        };
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        OnKeyPreImeListener onKeyPreImeListener = this.keyPreImeListener;
        if (onKeyPreImeListener == null || !onKeyPreImeListener.onKeyPreIme(this, keyCode, event)) {
            return super.onKeyPreIme(keyCode, event);
        }
        return true;
    }

    @Override // android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        InterfaceC5063a<Boolean> interfaceC5063a = this.acceptFocusRequest;
        if (interfaceC5063a == null || interfaceC5063a.invoke().booleanValue()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        return false;
    }

    public final void setAcceptFocusRequest$StepOSWidget_release(InterfaceC5063a<Boolean> interfaceC5063a) {
        this.acceptFocusRequest = interfaceC5063a;
    }

    public final void setOnDropDownListener(OnDropDownListener listener) {
        this.dropDownListener = listener;
    }

    public final void setOnEmptyDeleteListener(OnEmptyDeleteListener listener) {
        this.emptyDeleteListener = listener;
    }

    public final void setOnKeyPreImeListener(OnKeyPreImeListener listener) {
        this.keyPreImeListener = listener;
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        super.showDropDown();
        OnDropDownListener onDropDownListener = this.dropDownListener;
        if (onDropDownListener != null) {
            onDropDownListener.onDropDownVisibilityChanged(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSRecipientAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R$attr.autoCompleteTextViewStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }
}
