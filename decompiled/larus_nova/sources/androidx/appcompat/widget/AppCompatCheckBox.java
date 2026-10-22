package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton, TintableBackgroundView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

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

    @Override // androidx.core.widget.TintableCompoundButton
    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper r100 = this.mCompoundButtonHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportButtonTintList();
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper r100 = this.mCompoundButtonHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportButtonTintMode();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
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

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r100 = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper r101 = this.mCompoundButtonHelper;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r101.getCompoundPaddingLeft(r100);
    }

    public AppCompatCheckBox(Context r100) {
        this(r100, null);
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int r100) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), r100));
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

    @Override // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList r100) {
        AppCompatCompoundButtonHelper r101 = this.mCompoundButtonHelper;
        if (r101 == null) goto L6;
        r101.setSupportButtonTintList(r100);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode r100) {
        AppCompatCompoundButtonHelper r101 = this.mCompoundButtonHelper;
        if (r101 == null) goto L6;
        r101.setSupportButtonTintMode(r100);
        return;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable r100) {
        super.setButtonDrawable(r100);
        AppCompatCompoundButtonHelper r101 = this.mCompoundButtonHelper;
        if (r101 == null) goto L6;
        r101.onSetButtonDrawable();
        return;
    }

    public AppCompatCheckBox(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatCompoundButtonHelper r103 = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper = r103;
        r103.loadFromAttributes(r101, r102);
        AppCompatBackgroundHelper r104 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r104;
        r104.loadFromAttributes(r101, r102);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.loadFromAttributes(r101, r102);
    }
}
