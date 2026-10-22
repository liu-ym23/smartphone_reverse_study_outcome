package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RestrictTo;
import com.alibaba.fastjson.asm.Opcodes;
import e.EnumC0546d;
import h.RunnableC0583a;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class SearchView$SearchAutoComplete extends C0226t {

    /* renamed from: e, reason: collision with root package name */
    public int f2913e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2914f;

    /* renamed from: g, reason: collision with root package name */
    public final RunnableC0583a f2915g;

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2915g = new RunnableC0583a(2, this);
        this.f2913e = getThreshold();
    }

    private int getSearchViewTextMinWidthDp() {
        Configuration configuration = getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (i4 >= 960 && i5 >= 720 && configuration.orientation == 2) {
            return 256;
        }
        if (i4 >= 600) {
            return Opcodes.CHECKCAST;
        }
        if (i4 < 640 || i5 < 480) {
            return 160;
        }
        return Opcodes.CHECKCAST;
    }

    @Override // android.widget.AutoCompleteTextView
    public final boolean enoughToFilter() {
        return this.f2913e <= 0 || super.enoughToFilter();
    }

    @Override // androidx.appcompat.widget.C0226t, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.f2914f) {
            RunnableC0583a runnableC0583a = this.f2915g;
            removeCallbacks(runnableC0583a);
            post(runnableC0583a);
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        throw null;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    throw null;
                }
            }
        }
        return super.onKeyPreIme(i4, keyEvent);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        if (z4) {
            throw null;
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public final void performCompletion() {
    }

    @Override // android.widget.AutoCompleteTextView
    public final void replaceText(CharSequence charSequence) {
    }

    public void setImeVisibility(boolean z4) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        RunnableC0583a runnableC0583a = this.f2915g;
        if (!z4) {
            this.f2914f = false;
            removeCallbacks(runnableC0583a);
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else {
            if (!inputMethodManager.isActive(this)) {
                this.f2914f = true;
                return;
            }
            this.f2914f = false;
            removeCallbacks(runnableC0583a);
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    public void setSearchView(S0 s02) {
    }

    @Override // android.widget.AutoCompleteTextView
    public void setThreshold(int i4) {
        super.setThreshold(i4);
        this.f2913e = i4;
    }
}
