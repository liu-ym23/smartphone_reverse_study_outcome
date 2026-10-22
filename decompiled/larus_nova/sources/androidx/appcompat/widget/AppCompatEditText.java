package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView, OnReceiveContentViewBehavior {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
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

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return super.getText();
    L7:
        return super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        AppCompatTextClassifierHelper r100 = this.mTextClassifierHelper;
        if (r100 == null) goto L10;
        return r100.getTextClassifier();
    L10:
        return super.getTextClassifier();
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

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    public AppCompatEditText(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r101, r100);
        InputConnection r102 = AppCompatHintHelper.onCreateInputConnection(r101, r100, this);
        String[] r103 = ViewCompat.getOnReceiveContentMimeTypes(this);
        if (r102 == null) goto L7;
        if (r103 == null) goto L8;
        EditorInfoCompat.setContentMimeTypes(r100, r103);
        return InputConnectionCompat.createWrapper(r102, r100, AppCompatReceiveContentHelper.createOnCommitContentListener(this));
    L8:
        return r102;
    L7:
        return r102;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent r100) {
        if (AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent(this, r100) == false) goto L7;
        return true;
    L7:
        return super.onDragEvent(r100);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public ContentInfoCompat onReceiveContent(ContentInfoCompat r100) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, r100);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r100) {
        if (AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent(this, r100) == false) goto L7;
        return true;
    L7:
        return super.onTextContextMenuItem(r100);
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
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

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        AppCompatTextClassifierHelper r101 = this.mTextClassifierHelper;
        if (r101 == null) goto L9;
        r101.setTextClassifier(r100);
        return;
    L9:
        super.setTextClassifier(r100);
    }

    public AppCompatEditText(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.editTextStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r100, int r101) {
        super.setTextAppearance(r100, r101);
        AppCompatTextHelper r102 = this.mTextHelper;
        if (r102 == null) goto L6;
        r102.onSetTextAppearance(r100, r101);
        return;
    }

    public AppCompatEditText(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r103 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r103;
        r103.loadFromAttributes(r101, r102);
        AppCompatTextHelper r104 = new AppCompatTextHelper(this);
        this.mTextHelper = r104;
        this.mTextHelper.loadFromAttributes(r101, r102);
        r104.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
    }
}
