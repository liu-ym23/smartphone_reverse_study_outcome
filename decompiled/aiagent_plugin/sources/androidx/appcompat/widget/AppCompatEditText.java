package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements androidx.core.view.v, androidx.core.view.y, androidx.core.widget.k {
    private final e mAppCompatEmojiEditTextHelper;
    private final androidx.appcompat.widget.a mBackgroundTintHelper;
    private final androidx.core.widget.h mDefaultOnReceiveContentListener;
    private a mSuperCaller;
    private final l mTextClassifierHelper;
    private final m mTextHelper;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatEditText f354a;

        a(AppCompatEditText r1) {
            this.f354a = r1;
        }

        public TextClassifier a() {
            return AppCompatEditText.access$001(this.f354a);
        }

        public void a(TextClassifier r3) {
            TextClassifier r4 = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.aiagent.plugin");
            AppCompatEditText.access$101(this.f354a, r4);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    static /* synthetic */ TextClassifier access$001(AppCompatEditText r0) {
        return super.getTextClassifier();
    }

    static /* synthetic */ void access$101(AppCompatEditText r2, TextClassifier r3) {
        super.setTextClassifier((TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatEditText(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public AppCompatEditText(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.editTextStyle, "attr", "editTextStyle"));
    }

    public AppCompatEditText(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        androidx.appcompat.widget.a r8 = new androidx.appcompat.widget.a(this);
        this.mBackgroundTintHelper = r8;
        r8.a(r7, r5);
        m r9 = new m(this);
        this.mTextHelper = r9;
        r9.a(r7, r5);
        r9.b();
        this.mTextClassifierHelper = new l(this);
        this.mDefaultOnReceiveContentListener = new androidx.core.widget.h();
        e r10 = new e(this);
        this.mAppCompatEmojiEditTextHelper = r10;
        r10.a(r7, r5);
        initEmojiKeyListener(r10);
    }

    void initEmojiKeyListener(e r6) {
        KeyListener r0 = getKeyListener();
        if (r6.a(r0) == false) goto L9;
        boolean r1 = super.isFocusable();
        boolean r2 = super.isClickable();
        boolean r3 = super.isLongClickable();
        int r4 = super.getInputType();
        KeyListener r7 = r6.b(r0);
        if (r7 != r0) goto L7;
        return;
    L7:
        super.setKeyListener(r7);
        super.setRawInputType(r4);
        super.setFocusable(r1);
        super.setClickable(r2);
        super.setLongClickable(r3);
        return;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return super.getText();
    L7:
        return super.getEditableText();
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList r1) {
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.a r0 = this.mBackgroundTintHelper;
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r4) {
        InputConnection r0 = super.onCreateInputConnection(r4);
        this.mTextHelper.a(this, r0, r4);
        InputConnection r1 = g.a(r0, r4, this);
        if (r1 == null) goto L10;
        if (Build.VERSION.SDK_INT > 30) goto L10;
        String[] r2 = ViewCompat.y(this);
        if (r2 == null) goto L10;
        androidx.core.view.inputmethod.a.a(r4, r2);
        r1 = androidx.core.view.inputmethod.b.a(this, r1, r4);
    L10:
        return this.mAppCompatEmojiEditTextHelper.a(r1, r4);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.a(this, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.a(super.getCustomSelectionActionModeCallback());
    }

    private a getSuperCaller() {
        if (this.mSuperCaller != null) goto L6;
        this.mSuperCaller = new a(this);
    L6:
        return this.mSuperCaller;
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier r3) {
        TextClassifier r4 = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        l r0 = this.mTextClassifierHelper;
        if (r0 == null) goto L9;
        r0.a(r4);
        return;
    L9:
        getSuperCaller().a(r4);
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        l r0 = this.mTextClassifierHelper;
        if (r0 == null) goto L10;
        return r0.a();
    L10:
        return getSuperCaller().a();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent r2) {
        if (j.a(this, r2) == false) goto L7;
        return true;
    L7:
        return super.onDragEvent(r2);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r2) {
        if (j.a(this, r2) == false) goto L7;
        return true;
    L7:
        return super.onTextContextMenuItem(r2);
    }

    @Override // androidx.core.view.v
    public androidx.core.view.b onReceiveContent(androidx.core.view.b r2) {
        return this.mDefaultOnReceiveContentListener.a(this, r2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.aiagent.plugin");
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.b(r4));
    }

    public void setEmojiCompatEnabled(boolean r1) {
        this.mAppCompatEmojiEditTextHelper.a(r1);
    }

    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.a();
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
