package androidx.appcompat.widget;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private PorterDuff.Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    public int getCompoundPaddingLeft(int r100) {
        return r100;
    }

    public void applyButtonTint() {
        Drawable r100 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasButtonTint == false) goto L7;
    L8:
        Drawable r101 = DrawableCompat.wrap(r100).mutate();
        if (this.mHasButtonTint == false) goto L12;
        DrawableCompat.setTintList(r101, this.mButtonTintList);
    L12:
        if (this.mHasButtonTintMode == false) goto L15;
        DrawableCompat.setTintMode(r101, this.mButtonTintMode);
    L15:
        if (r101.isStateful() == false) goto L17;
        r101.setState(this.mView.getDrawableState());
    L17:
        this.mView.setButtonDrawable(r101);
        return;
    L7:
        if (this.mHasButtonTintMode == true) goto L8;
    }

    public void onSetButtonDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    public AppCompatCompoundButtonHelper(CompoundButton r100) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = r100;
    }

    public void setSupportButtonTintList(ColorStateList r100) {
        this.mButtonTintList = r100;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    public void setSupportButtonTintMode(PorterDuff.Mode r100) {
        this.mButtonTintMode = r100;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }

    public void loadFromAttributes(AttributeSet r110, int r111) {
        TintTypedArray r100 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r110, new int[]{R.attr.button, com.larus.nova.R.attr.buttonCompat, com.larus.nova.R.attr.buttonTint, com.larus.nova.R.attr.buttonTintMode}, r111, 0);
        CompoundButton r101 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r101, r101.getContext(), new int[]{R.attr.button, com.larus.nova.R.attr.buttonCompat, com.larus.nova.R.attr.buttonTint, com.larus.nova.R.attr.buttonTintMode}, r110, r100.getWrappedTypeArray(), r111, 0);
        boolean r112 = true;
    L25:
        th = move-exception;
        r100.recycle();
        throw th;
    L4:
        if (r100.hasValue(1) == false) goto L10;
        int r113 = r100.getResourceId(1, 0);     // Catch: Throwable -> L25
        if (r113 == 0) goto L10;
        CompoundButton r102 = this.mView;     // Catch: Resources.NotFoundException -> L9 Throwable -> L25
        r102.setButtonDrawable(AppCompatResources.getDrawable(r102.getContext(), r113));     // Catch: Resources.NotFoundException -> L9 Throwable -> L25
    L11:
        if (r112 == true) goto L18;
        if (r100.hasValue(0) == false) goto L18;
        int r114 = r100.getResourceId(0, 0);     // Catch: Throwable -> L25
        if (r114 == 0) goto L18;
        CompoundButton r115 = this.mView;     // Catch: Throwable -> L25
        r115.setButtonDrawable(AppCompatResources.getDrawable(r115.getContext(), r114));     // Catch: Throwable -> L25
    L18:
        if (r100.hasValue(2) == false) goto L21;
        CompoundButtonCompat.setButtonTintList(this.mView, r100.getColorStateList(2));     // Catch: Throwable -> L25
    L21:
        if (r100.hasValue(3) == false) goto L23;
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(r100.getInt(3, -1), null));     // Catch: Throwable -> L25
    L23:
        r100.recycle();
        return;
    L10:
        r112 = false;
        goto L11
    }
}
