package com.google.android.material.textfield;

import K.C0069b;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.appcompat.widget.C0200f0;

/* loaded from: classes.dex */
public final class y extends C0069b {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f11123a;

    public y(TextInputLayout textInputLayout) {
        this.f11123a = textInputLayout;
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, L.g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        TextInputLayout textInputLayout = this.f11123a;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean z4 = !zIsEmpty;
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(hint);
        boolean z7 = !textInputLayout.f10928F0;
        boolean z8 = !TextUtils.isEmpty(error);
        if (!z8 && TextUtils.isEmpty(counterOverflowDescription)) {
            z5 = false;
        }
        String string = z6 ? hint.toString() : "";
        w wVar = textInputLayout.f10953b;
        C0200f0 c0200f0 = wVar.f11111b;
        int visibility = c0200f0.getVisibility();
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f1142a;
        if (visibility == 0) {
            accessibilityNodeInfo.setLabelFor(c0200f0);
            accessibilityNodeInfo.setTraversalAfter(c0200f0);
        } else {
            accessibilityNodeInfo.setTraversalAfter(wVar.f11113d);
        }
        if (z4) {
            gVar.i(text);
        } else if (!TextUtils.isEmpty(string)) {
            gVar.i(string);
            if (z7 && placeholderText != null) {
                gVar.i(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            gVar.i(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setHintText(string);
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z5) {
            if (z8) {
                counterOverflowDescription = error;
            }
            accessibilityNodeInfo.setError(counterOverflowDescription);
        }
        C0200f0 c0200f02 = textInputLayout.f10962k.f11093y;
        if (c0200f02 != null) {
            accessibilityNodeInfo.setLabelFor(c0200f02);
        }
        textInputLayout.f10954c.b().n(gVar);
    }

    @Override // K.C0069b
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        this.f11123a.f10954c.b().o(accessibilityEvent);
    }
}
