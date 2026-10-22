package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private int mEmojiReplaceStrategy;
    private boolean mEnabled;
    private final boolean mExpectInitializedEmojiCompat;
    private d.e mInitCallback;
    private int mMaxEmojiCount;

    private static class a extends d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference<EditText> f1664a;

        a(EditText r2) {
            this.f1664a = new WeakReference(r2);
        }

        @Override // androidx.emoji2.text.d.e
        public void a() {
            super.a();
            EmojiTextWatcher.processTextOnEnablingEvent((EditText) ZeusTransformUtils.preCheckCast(this.f1664a.get(), EditText.class, "com.obric.aiagent.plugin"), 1);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.aiagent.plugin");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
    }

    EmojiTextWatcher(EditText r2, boolean r3) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        this.mEditText = r2;
        this.mExpectInitializedEmojiCompat = r3;
        this.mEnabled = true;
    }

    void setMaxEmojiCount(int r1) {
        this.mMaxEmojiCount = r1;
    }

    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    void setEmojiReplaceStrategy(int r1) {
        this.mEmojiReplaceStrategy = r1;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (this.mEditText.isInEditMode() == false) goto L5;
        return;
    L5:
        if (shouldSkipForDisabledOrNotConfigured() == true) goto L24;
        if (r9 <= r10) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r11, Spannable.class) == false) goto L22;
        int r12 = d.b().e();
        if (r12 != 0) goto L13;
    L18:
        d.b().a(getInitCallback());
        return;
    L13:
        if (r12 != 1) goto L15;
        Spannable r1 = (Spannable) ZeusTransformUtils.preCheckCast(r11, Spannable.class, "com.obric.aiagent.plugin");
        d.b().a(r1, r8, r8 + r10, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
        return;
    L15:
        if (r12 == 3) goto L18;
        return;
    L22:
        return;
    }

    private boolean shouldSkipForDisabledOrNotConfigured() {
        if (this.mEnabled == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mExpectInitializedEmojiCompat == false) goto L7;
    L9:
        return false;
    L7:
        if (d.a() == true) goto L9;
        goto L9
    }

    private d.e getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new a(this.mEditText);
    L6:
        return this.mInitCallback;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean r3) {
        if (this.mEnabled != r3) goto L5;
        return;
    L5:
        if (this.mInitCallback == null) goto L7;
        d.b().b(this.mInitCallback);
    L7:
        this.mEnabled = r3;
        if (r3 == false) goto L12;
        processTextOnEnablingEvent(this.mEditText, d.b().e());
        return;
    }

    static void processTextOnEnablingEvent(EditText r2, int r3) {
        if (r3 != 1) goto L9;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.isAttachedToWindow() == false) goto L11;
        Editable r4 = r2.getEditableText();
        int r5 = Selection.getSelectionStart(r4);
        int r0 = Selection.getSelectionEnd(r4);
        d.b().a(r4);
        EmojiInputFilter.updateSelection(r4, r5, r0);
        return;
    L11:
        return;
    }
}
