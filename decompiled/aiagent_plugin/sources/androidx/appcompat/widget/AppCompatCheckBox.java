package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements androidx.core.view.y, androidx.core.widget.j, androidx.core.widget.k {
    private f mAppCompatEmojiTextHelper;
    private final a mBackgroundTintHelper;
    private final c mCompoundButtonHelper;
    private final m mTextHelper;

    public AppCompatCheckBox(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public AppCompatCheckBox(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.checkboxStyle, "attr", "checkboxStyle"));
    }

    public AppCompatCheckBox(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        c r8 = new c(this);
        this.mCompoundButtonHelper = r8;
        r8.a(r7, r5);
        a r9 = new a(this);
        this.mBackgroundTintHelper = r9;
        r9.a(r7, r5);
        m r10 = new m(this);
        this.mTextHelper = r10;
        r10.a(r7, r5);
        getEmojiTextViewHelper().a(r7, r5);
    }

    private f getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new f(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable r1) {
        super.setButtonDrawable(r1);
        c r0 = this.mCompoundButtonHelper;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int r4) {
        setButtonDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r0 = super.getCompoundPaddingLeft();
        c r1 = this.mCompoundButtonHelper;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r1.a(r0);
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList r1) {
        c r0 = this.mCompoundButtonHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.widget.j
    public ColorStateList getSupportButtonTintList() {
        c r0 = this.mCompoundButtonHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode r1) {
        c r0 = this.mCompoundButtonHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        c r0 = this.mCompoundButtonHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList r1) {
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        a r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        a r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        m r1 = this.mTextHelper;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r2) {
        super.setFilters(getEmojiTextViewHelper().a(r2));
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r1) {
        super.setAllCaps(r1);
        getEmojiTextViewHelper().b(r1);
    }

    public void setEmojiCompatEnabled(boolean r1) {
        getEmojiTextViewHelper().a(r1);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().a();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        m r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        m r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList r2) {
        this.mTextHelper.a(r2);
        this.mTextHelper.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r2) {
        this.mTextHelper.a(r2);
        this.mTextHelper.b();
    }
}
