package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.TextViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements androidx.core.view.y, androidx.core.widget.i, androidx.core.widget.k {
    private f mAppCompatEmojiTextHelper;
    private final a mBackgroundTintHelper;
    private final b mCheckedHelper;
    private final m mTextHelper;

    public AppCompatCheckedTextView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public AppCompatCheckedTextView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.checkedTextViewStyle, "attr", "checkedTextViewStyle"));
    }

    public AppCompatCheckedTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        m r8 = new m(this);
        this.mTextHelper = r8;
        r8.a(r7, r5);
        r8.b();
        a r9 = new a(this);
        this.mBackgroundTintHelper = r9;
        r9.a(r7, r5);
        b r10 = new b(this);
        this.mCheckedHelper = r10;
        r10.a(r7, r5);
        getEmojiTextViewHelper().a(r7, r5);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable r1) {
        super.setCheckMarkDrawable(r1);
        b r0 = this.mCheckedHelper;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int r4) {
        setCheckMarkDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    @Override // androidx.core.widget.i
    public void setSupportCheckMarkTintList(ColorStateList r1) {
        b r0 = this.mCheckedHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        b r0 = this.mCheckedHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // androidx.core.widget.i
    public void setSupportCheckMarkTintMode(PorterDuff.Mode r1) {
        b r0 = this.mCheckedHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        b r0 = this.mCheckedHelper;
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super.setTextAppearance(r5, r4);
        m r2 = this.mTextHelper;
        if (r2 == null) goto L6;
        r2.a(r5, r4);
        return;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m r0 = this.mTextHelper;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        a r1 = this.mBackgroundTintHelper;
        if (r1 == null) goto L8;
        r1.c();
    L8:
        b r2 = this.mCheckedHelper;
        if (r2 == null) goto L12;
        r2.d();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        return g.a(super.onCreateInputConnection(r2), r2, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.a(this, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.a(super.getCustomSelectionActionModeCallback());
    }

    private f getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new f(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
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
