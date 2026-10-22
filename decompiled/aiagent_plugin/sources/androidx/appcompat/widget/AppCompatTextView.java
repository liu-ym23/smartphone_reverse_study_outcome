package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements androidx.core.view.y, androidx.core.widget.k {
    private final androidx.appcompat.widget.a mBackgroundTintHelper;
    private f mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private a mSuperCaller;
    private final l mTextClassifierHelper;
    private final m mTextHelper;

    private interface a {
        int a();

        void a(int r1);

        void a(int r1, int r2, int r3, int r4);

        void a(TextClassifier r1);

        void a(int[] r1, int r2);

        int b();

        void b(int r1);

        int c();

        void c(int r1);

        int[] d();

        int e();

        TextClassifier f();
    }

    class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatTextView f357a;

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void b(int r1) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void c(int r1) {
        }

        b(AppCompatTextView r1) {
            this.f357a = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int a() {
            return AppCompatTextView.access$001(this.f357a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int b() {
            return AppCompatTextView.access$101(this.f357a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int c() {
            return AppCompatTextView.access$201(this.f357a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int[] d() {
            return AppCompatTextView.access$301(this.f357a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int e() {
            return AppCompatTextView.access$401(this.f357a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public TextClassifier f() {
            return AppCompatTextView.access$501(this.f357a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void a(int r1, int r2, int r3, int r4) {
            AppCompatTextView.access$601(this.f357a, r1, r2, r3, r4);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void a(int[] r1, int r2) {
            AppCompatTextView.access$701(this.f357a, r1, r2);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void a(int r1) {
            AppCompatTextView.access$801(this.f357a, r1);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void a(TextClassifier r3) {
            TextClassifier r4 = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.aiagent.plugin");
            AppCompatTextView.access$901(this.f357a, r4);
        }
    }

    class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppCompatTextView f358b;

        c(AppCompatTextView r1) {
            this.f358b = r1;
            super(r1);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public void b(int r1) {
            AppCompatTextView.access$1001(this.f358b, r1);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public void c(int r1) {
            AppCompatTextView.access$1101(this.f358b, r1);
        }
    }

    static /* synthetic */ int access$001(AppCompatTextView r0) {
        return super.getAutoSizeMaxTextSize();
    }

    static /* synthetic */ void access$1001(AppCompatTextView r0, int r1) {
        super.setFirstBaselineToTopHeight(r1);
    }

    static /* synthetic */ int access$101(AppCompatTextView r0) {
        return super.getAutoSizeMinTextSize();
    }

    static /* synthetic */ void access$1101(AppCompatTextView r0, int r1) {
        super.setLastBaselineToBottomHeight(r1);
    }

    static /* synthetic */ int access$201(AppCompatTextView r0) {
        return super.getAutoSizeStepGranularity();
    }

    static /* synthetic */ int[] access$301(AppCompatTextView r0) {
        return super.getAutoSizeTextAvailableSizes();
    }

    static /* synthetic */ int access$401(AppCompatTextView r0) {
        return super.getAutoSizeTextType();
    }

    static /* synthetic */ TextClassifier access$501(AppCompatTextView r0) {
        return super.getTextClassifier();
    }

    static /* synthetic */ void access$601(AppCompatTextView r0, int r1, int r2, int r3, int r4) {
        super.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$701(AppCompatTextView r0, int[] r1, int r2) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
    }

    static /* synthetic */ void access$801(AppCompatTextView r0, int r1) {
        super.setAutoSizeTextTypeWithDefaults(r1);
    }

    static /* synthetic */ void access$901(AppCompatTextView r2, TextClassifier r3) {
        super.setTextClassifier((TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatTextView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public AppCompatTextView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), R.attr.textViewStyle);
    }

    public AppCompatTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        androidx.appcompat.widget.a r8 = new androidx.appcompat.widget.a(this);
        this.mBackgroundTintHelper = r8;
        r8.a(r7, r5);
        m r9 = new m(this);
        this.mTextHelper = r9;
        r9.a(r7, r5);
        r9.b();
        this.mTextClassifierHelper = new l(this);
        getEmojiTextViewHelper().a(r7, r5);
    }

    private f getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper != null) goto L6;
        this.mEmojiTextViewHelper = new f(this);
    L6:
        return this.mEmojiTextViewHelper;
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super.setTextAppearance(r5, r4);
        m r2 = this.mTextHelper;
        if (r2 == null) goto L6;
        r2.a(r5, r4);
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
        getSuperCaller().a(r2);
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
        getSuperCaller().a(r2, r3, r4, r5);
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
        getSuperCaller().a(r2, r3);
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
        if (getSuperCaller().e() == 1) goto L7;
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
        return getSuperCaller().c();
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
        return getSuperCaller().b();
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
        return getSuperCaller().a();
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
        return getSuperCaller().d();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r3) {
        InputConnection r0 = super.onCreateInputConnection(r3);
        this.mTextHelper.a(this, r0, r3);
        return g.a(r0, r3, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        getSuperCaller().b(r3);
        return;
    L5:
        TextViewCompat.b(this, r3);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        getSuperCaller().c(r3);
        return;
    L5:
        TextViewCompat.c(this, r3);
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.c(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.d(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int r1) {
        TextViewCompat.d(this, r1);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.a(this, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.a(super.getCustomSelectionActionModeCallback());
    }

    public PrecomputedTextCompat.b getTextMetricsParamsCompat() {
        return TextViewCompat.e(this);
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.b r1) {
        TextViewCompat.a(this, r1);
    }

    public void setPrecomputedText(PrecomputedTextCompat r1) {
        TextViewCompat.a(this, r1);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> r0 = this.mPrecomputedTextFuture;
        if (r0 != null) goto L8;
        return;
    L8:
        this.mPrecomputedTextFuture = null;     // Catch: Throwable -> L7
        TextViewCompat.a(this, (PrecomputedTextCompat) ZeusTransformUtils.preCheckCast(r0.get(), PrecomputedTextCompat.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        return;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
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
        return getSuperCaller().f();
    }

    public void setTextFuture(Future<PrecomputedTextCompat> r3) {
        Future<PrecomputedTextCompat> r4 = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.aiagent.plugin");
        this.mPrecomputedTextFuture = r4;
        if (r4 == null) goto L6;
        requestLayout();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(r1, r2);
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

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        m r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r4, int r5, int r6, int r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Drawable r1 = null;
        if (r4 == 0) goto L5;
        Drawable r8 = androidx.appcompat.a.a.a.b(r0, r4);
    L6:
        if (r5 == 0) goto L8;
        Drawable r9 = androidx.appcompat.a.a.a.b(r0, r5);
    L9:
        if (r6 == 0) goto L11;
        Drawable r10 = androidx.appcompat.a.a.a.b(r0, r6);
    L12:
        if (r7 == 0) goto L14;
        r1 = androidx.appcompat.a.a.a.b(r0, r7);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r8, r9, r10, r1);
        m r3 = this.mTextHelper;
        if (r3 == null) goto L18;
        r3.a();
        return;
    L18:
        return;
    L11:
        r10 = null;
        goto L12
    L8:
        r9 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        m r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r4, int r5, int r6, int r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Drawable r1 = null;
        if (r4 == 0) goto L5;
        Drawable r8 = androidx.appcompat.a.a.a.b(r0, r4);
    L6:
        if (r5 == 0) goto L8;
        Drawable r9 = androidx.appcompat.a.a.a.b(r0, r5);
    L9:
        if (r6 == 0) goto L11;
        Drawable r10 = androidx.appcompat.a.a.a.b(r0, r6);
    L12:
        if (r7 == 0) goto L14;
        r1 = androidx.appcompat.a.a.a.b(r0, r7);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r8, r9, r10, r1);
        m r3 = this.mTextHelper;
        if (r3 == null) goto L18;
        r3.a();
        return;
    L18:
        return;
    L11:
        r10 = null;
        goto L12
    L8:
        r9 = null;
        goto L9
    L5:
        r8 = null;
        goto L6
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

    @Override // android.widget.TextView
    public void setTypeface(Typeface r4, int r5) {
        if (this.mIsSetTypefaceProcessing == false) goto L5;
        return;
    L5:
        Typeface r0 = null;
        if (r4 == null) goto L9;
        if (r5 <= 0) goto L9;
        r0 = androidx.core.graphics.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r5);
    L9:
        this.mIsSetTypefaceProcessing = true;
        if (r0 == null) goto L19;
        r4 = r0;
    L19:
        super.setTypeface(r4, r5);     // Catch: Throwable -> L16
        this.mIsSetTypefaceProcessing = false;
        return;
    L16:
        th = move-exception;
        this.mIsSetTypefaceProcessing = false;
        throw th;
    }

    a getSuperCaller() {
        if (this.mSuperCaller != null) goto L11;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        this.mSuperCaller = new c(this);
        goto L11
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L11;
        this.mSuperCaller = new b(this);
    L11:
        return this.mSuperCaller;
    }
}
