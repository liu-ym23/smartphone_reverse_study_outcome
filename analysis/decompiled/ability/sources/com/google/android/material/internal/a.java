package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.stepos.textinputlayout.TextInputLayout;

/* loaded from: classes3.dex */
public final class a extends AccessibilityDelegateCompat {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2451a;
    public final /* synthetic */ View b;

    public /* synthetic */ a(int i, View view) {
        this.f2451a = i;
        this.b = view;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2451a) {
            case 0:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.b).f2445a);
                break;
            case 1:
            default:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                break;
            case 2:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName("TextInputLayout");
                break;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        switch (this.f2451a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                CheckableImageButton checkableImageButton = (CheckableImageButton) this.b;
                accessibilityNodeInfoCompat.setCheckable(checkableImageButton.b);
                accessibilityNodeInfoCompat.setChecked(checkableImageButton.f2445a);
                break;
            case 1:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(((NavigationMenuItemView) this.b).i);
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName("TextInputLayout");
                TextInputLayout textInputLayout = (TextInputLayout) this.b;
                CharSequence charSequence = textInputLayout.o.f6777s;
                if (!TextUtils.isEmpty(charSequence)) {
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                EditText editText = textInputLayout.b;
                if (editText != null) {
                    accessibilityNodeInfoCompat.setLabelFor(editText);
                }
                TextView textView = textInputLayout.f;
                CharSequence text = textView != null ? textView.getText() : null;
                if (!TextUtils.isEmpty(text)) {
                    accessibilityNodeInfoCompat.setContentInvalid(true);
                    accessibilityNodeInfoCompat.setError(text);
                    break;
                }
                break;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2451a) {
            case 2:
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                CharSequence charSequence = ((TextInputLayout) this.b).o.f6777s;
                if (!TextUtils.isEmpty(charSequence)) {
                    accessibilityEvent.getText().add(charSequence);
                    break;
                }
                break;
            default:
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }
}
