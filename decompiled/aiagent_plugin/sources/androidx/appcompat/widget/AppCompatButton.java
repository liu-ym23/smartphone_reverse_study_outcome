package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.TextViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements androidx.core.view.y, androidx.core.widget.k {
    private f mAppCompatEmojiTextHelper;
    private final a mBackgroundTintHelper;
    private final m mTextHelper;

    public AppCompatButton(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public AppCompatButton(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.buttonStyle, "attr", "buttonStyle"));
    }

    public AppCompatButton(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        a r8 = new a(this);
        this.mBackgroundTintHelper = r8;
        r8.a(r7, r5);
        m r9 = new m(this);
        this.mTextHelper = r9;
        r9.a(r7, r5);
        r9.b();
        getEmojiTextViewHelper().a(r7, r5);
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
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

    @Override // android.widget.TextView, android.view.View
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
    public void setTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super.setTextAppearance(r5, r4);
        m r2 = this.mTextHelper;
        if (r2 == null) goto L6;
        r2.a(r5, r4);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        m r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.a(r7, r8, r9, r10, r11);
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r2, float r3) {
        if (ac.f411a == false) goto L5;
        super.setTextSize(r2, r3);
        return;
    L5:
        m r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.a(r2, r3);
        return;
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        super.onTextChanged((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        if (this.mTextHelper != null) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L13;
        this.mTextHelper.c();
        return;
    L13:
        return;
    L5:
        if (ac.f411a == true) goto L9;
        if (this.mTextHelper.d() == false) goto L9;
        r7 = true;
        goto L10
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int r2) {
        if (ac.f411a == false) goto L5;
        super.setAutoSizeTextTypeWithDefaults(r2);
        return;
    L5:
        m r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.a(r2);
        return;
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int r2, int r3, int r4, int r5) {
        if (ac.f411a == false) goto L5;
        super.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5);
        return;
    L5:
        m r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.a(r2, r3, r4, r5);
        return;
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r2, int r3) {
        if (ac.f411a == false) goto L5;
        super.setAutoSizeTextTypeUniformWithPresetSizes(r2, r3);
        return;
    L5:
        m r1 = this.mTextHelper;
        if (r1 == null) goto L10;
        r1.a(r2, r3);
        return;
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (ac.f411a == true) goto L5;
        m r2 = this.mTextHelper;
        if (r2 != null) goto L11;
        return 0;
    L11:
        return r2.e();
    L5:
        if (super.getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (ac.f411a == true) goto L5;
        m r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.f();
    L5:
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (ac.f411a == true) goto L5;
        m r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.g();
    L5:
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (ac.f411a == true) goto L5;
        m r1 = this.mTextHelper;
        if (r1 != null) goto L9;
        return -1;
    L9:
        return r1.h();
    L5:
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (ac.f411a == true) goto L5;
        m r1 = this.mTextHelper;
        if (r1 == null) goto L11;
        return r1.i();
    L11:
        return new int[0];
    L5:
        return super.getAutoSizeTextAvailableSizes();
    }

    public void setSupportAllCaps(boolean r1) {
        m r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.a(this, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.a(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList r2) {
        this.mTextHelper.a(r2);
        this.mTextHelper.b();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r2) {
        this.mTextHelper.a(r2);
        this.mTextHelper.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r2) {
        super.setFilters(getEmojiTextViewHelper().a(r2));
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
}
