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
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R$attr;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView, OnReceiveContentViewBehavior, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    @NonNull
    private final g mAppCompatEmojiEditTextHelper;
    private final c mBackgroundTintHelper;
    private final androidx.core.widget.k mDefaultOnReceiveContentListener;

    @Nullable
    private a mSuperCaller;
    private final n mTextClassifierHelper;
    private final o mTextHelper;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatEditText f775a;

        public a(AppCompatEditText r10) {
            this.f775a = r10;
        }

        public TextClassifier a() {
            return AppCompatEditText.access$001(this.f775a);
        }

        public void b(TextClassifier r10) {
            AppCompatEditText.access$101(this.f775a, r10);
        }
    }

    public AppCompatEditText(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ TextClassifier access$001(AppCompatEditText r10) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void access$101(AppCompatEditText r10, TextClassifier r11) {
        super.setTextClassifier(r11);
    }

    @NonNull
    @RequiresApi(26)
    @UiThread
    private a getSuperCaller() {
        if (this.mSuperCaller != null) goto L6;
        this.mSuperCaller = new a(this);
    L6:
        return this.mSuperCaller;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        o r11 = this.mTextHelper;
        if (r11 == null) goto L9;
        r11.b();
        return;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.p(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        c r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        return getSuperCaller().a();
    }

    public void initEmojiKeyListener(g r10) {
        KeyListener r11 = getKeyListener();
        if (r10.b(r11) == false) goto L9;
        boolean r12 = super.isFocusable();
        boolean r13 = super.isClickable();
        boolean r14 = super.isLongClickable();
        int r15 = super.getInputType();
        KeyListener r16 = r10.a(r11);
        if (r16 != r11) goto L7;
        return;
    L7:
        super.setKeyListener(r16);
        super.setRawInputType(r15);
        super.setFocusable(r12);
        super.setClickable(r13);
        super.setLongClickable(r14);
        return;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.c();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        InputConnection r11 = super.onCreateInputConnection(r10);
        this.mTextHelper.r(this, r11, r10);
        InputConnection r12 = i.a(r11, r10, this);
        if (r12 == null) goto L10;
        if (Build.VERSION.SDK_INT > 30) goto L10;
        String[] r13 = ViewCompat.D(this);
        if (r13 == null) goto L10;
        androidx.core.view.inputmethod.a.a(r10, r13);
        r12 = InputConnectionCompat.c(this, r12, r10);
    L10:
        return this.mAppCompatEmojiEditTextHelper.e(r12, r10);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent r10) {
        if (l.a(this, r10) == false) goto L7;
        return true;
    L7:
        return super.onDragEvent(r10);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat r10) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, r10);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r10) {
        if (l.b(this, r10) == false) goto L7;
        return true;
    L7:
        return super.onTextContextMenuItem(r10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r10) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.q(this, r10));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        this.mAppCompatEmojiEditTextHelper.f(r10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener r10) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(r10));
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r10) {
        this.mTextHelper.w(r10);
        this.mTextHelper.b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r10) {
        this.mTextHelper.x(r10);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        o r12 = this.mTextHelper;
        if (r12 == null) goto L6;
        r12.q(r10, r11);
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r10) {
        getSuperCaller().b(r10);
    }

    public AppCompatEditText(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        return super.getText();
    }

    public AppCompatEditText(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        x.a(this, getContext());
        c r13 = new c(this);
        this.mBackgroundTintHelper = r13;
        r13.e(r11, r12);
        o r14 = new o(this);
        this.mTextHelper = r14;
        r14.m(r11, r12);
        r14.b();
        this.mTextClassifierHelper = new n(this);
        this.mDefaultOnReceiveContentListener = new androidx.core.widget.k();
        g r15 = new g(this);
        this.mAppCompatEmojiEditTextHelper = r15;
        r15.d(r11, r12);
        initEmojiKeyListener(r15);
    }
}
