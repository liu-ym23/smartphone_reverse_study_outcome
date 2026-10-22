package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    private final TextView mView;

    AppCompatEmojiTextHelper(TextView r3) {
        this.mView = r3;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(r3, false);
    }

    void loadFromAttributes(AttributeSet r4, int r5) {
        TypedArray r6 = this.mView.getContext().obtainStyledAttributes(r4, R.styleable.AppCompatTextView, r5, 0);
        boolean r0 = true;
        if (r6.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) == false) goto L6;
        r0 = r6.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);     // Catch: Throwable -> L8
    L6:
        r6.recycle();
        setEnabled(r0);
        return;
    L8:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    void setEnabled(boolean r1) {
        this.mEmojiTextViewHelper.setEnabled(r1);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    InputFilter[] getFilters(InputFilter[] r1) {
        return this.mEmojiTextViewHelper.getFilters(r1);
    }

    void setAllCaps(boolean r1) {
        this.mEmojiTextViewHelper.setAllCaps(r1);
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod r1) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(r1);
    }
}
