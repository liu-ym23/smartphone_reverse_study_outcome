package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/ECAutoHideKeyboardLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAutoHideKeyboardLayout extends FrameLayout {
    public ECAutoHideKeyboardLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECAutoHideKeyboardLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static View a(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isFocused() == false) goto L9;
        return r100;
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L12;
        return a(((ViewGroup) r100).getFocusedChild());
    L12:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getAction() != 0) goto L22;
        View r101 = a(this);
        if ((r101 instanceof EditText) == false) goto L22;
        Rect r102 = new Rect();
        r101.getGlobalVisibleRect(r102);
        if (r102.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L22;
        r101.clearFocus();
        EditText r103 = (EditText) r101;
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ViewGroup) == true) goto L11;
        r104 = null;
    L11:
        ViewGroup r105 = (ViewGroup) r104;
        if (r105 == null) goto L14;
        r105.clearChildFocus(r101);
    L14:
        int r106 = o.f153103a;
        Context r107 = getContext();
        Intrinsics.checkNotNullParameter(r103, "editText");
        if (r107 == null) goto L22;
        Object r108 = r107.getSystemService("input_method");
        if (r108 == null) goto L20;
        ((InputMethodManager) r108).hideSoftInputFromWindow(r103.getWindowToken(), 0);
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L22:
        return super.dispatchTouchEvent(r100);
    }

    public ECAutoHideKeyboardLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECAutoHideKeyboardLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
