package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] TINT_ATTRS = null;
    private final AppCompatTextHelper mTextHelper;

    static {
        TINT_ATTRS = new int[]{R.attr.checkMark};
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper r100 = this.mTextHelper;
        if (r100 == null) goto L6;
        r100.applyCompoundDrawablesTints();
        return;
    }

    public AppCompatCheckedTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(r100), r100, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int r100) {
        setCheckMarkDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
    }

    public AppCompatCheckedTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.checkedTextViewStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r100, int r101) {
        super.setTextAppearance(r100, r101);
        AppCompatTextHelper r102 = this.mTextHelper;
        if (r102 == null) goto L6;
        r102.onSetTextAppearance(r100, r101);
        return;
    }

    public AppCompatCheckedTextView(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatTextHelper r103 = new AppCompatTextHelper(this);
        this.mTextHelper = r103;
        this.mTextHelper.loadFromAttributes(r101, r102);
        r103.applyCompoundDrawablesTints();
        TintTypedArray r104 = TintTypedArray.obtainStyledAttributes(getContext(), r101, TINT_ATTRS, r102, 0);
        setCheckMarkDrawable(r104.getDrawable(0));
        r104.recycle();
    }
}
