package com.google.android.material.textfield;

import a1.C0417j;
import a1.C0418k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.C0442l;
import g.C0728a;
import org.libpag.BuildConfig;
import x1.C1282a;

/* loaded from: classes.dex */
public class TextInputEditText extends C0442l {

    /* renamed from: g, reason: collision with root package name */
    private final Rect f13212g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13213h;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16809F);
    }

    private boolean d(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f13213h;
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!d(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f13212g);
        rect.bottom = this.f13212g.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!d(textInputLayout)) {
            return super.getGlobalVisibleRect(rect, point);
        }
        boolean globalVisibleRect = textInputLayout.getGlobalVisibleRect(rect, point);
        if (globalVisibleRect && point != null) {
            point.offset(-getScrollX(), -getScrollY());
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.T()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.T() && super.getHint() == null && com.google.android.material.internal.i.b()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    @Override // androidx.appcompat.widget.C0442l, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!d(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f13212g.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f13212g);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z5) {
        this.f13213h = z5;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i5) {
        super(C1282a.d(context, attributeSet, i5, 0), attributeSet, i5);
        this.f13212g = new Rect();
        TypedArray typedArrayI = com.google.android.material.internal.o.i(context, attributeSet, C0418k.f6982H4, i5, C0417j.f6916g, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayI.getBoolean(C0418k.f6988I4, false));
        typedArrayI.recycle();
    }
}
