package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {
    private static final int[] TINT_ATTRS = null;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    static {
        TINT_ATTRS = new int[]{R.attr.popupBackground};
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 == null) goto L5;
        r100.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r101 = this.mTextHelper;
        if (r101 == null) goto L9;
        r101.applyCompoundDrawablesTints();
        return;
    }

    public AppCompatMultiAutoCompleteTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(r100), r100, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        super.setBackgroundDrawable(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundDrawable(r100);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        super.setBackgroundResource(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundResource(r100);
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int r100) {
        setDropDownBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintList(r100);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintMode(r100);
        return;
    }

    public AppCompatMultiAutoCompleteTextView(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.autoCompleteTextViewStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r100, int r101) {
        super.setTextAppearance(r100, r101);
        AppCompatTextHelper r102 = this.mTextHelper;
        if (r102 == null) goto L6;
        r102.onSetTextAppearance(r100, r101);
        return;
    }

    public AppCompatMultiAutoCompleteTextView(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r103 = TintTypedArray.obtainStyledAttributes(getContext(), r101, TINT_ATTRS, r102, 0);
        if (r103.hasValue(0) == false) goto L5;
        setDropDownBackgroundDrawable(r103.getDrawable(0));
    L5:
        r103.recycle();
        AppCompatBackgroundHelper r104 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r104;
        r104.loadFromAttributes(r101, r102);
        AppCompatTextHelper r105 = new AppCompatTextHelper(this);
        this.mTextHelper = r105;
        this.mTextHelper.loadFromAttributes(r101, r102);
        r105.applyCompoundDrawablesTints();
    }
}
