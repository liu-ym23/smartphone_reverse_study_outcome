package com.stepos.common.widget;

import android.annotation.SuppressLint;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.view.View;
import java.lang.ref.WeakReference;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes3.dex */
class FoldableTextView$MoreClickSpan extends TypefaceSpan {
    WeakReference<u> mFoldableTextView;
    private int mLinkColor;
    final /* synthetic */ u this$0;

    public FoldableTextView$MoreClickSpan(u uVar, String str, CharSequence charSequence) {
        super(str);
        this.mLinkColor = 0;
    }

    public void onClick(View view) {
        WeakReference<u> weakReference = this.mFoldableTextView;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.mFoldableTextView.get() != null) {
            throw new ClassCastException();
        }
        int i = u.f3813a;
        throw null;
    }

    public void setFoldableTextView(u uVar) {
        this.mFoldableTextView = new WeakReference<>(uVar);
    }

    public void setLinkColor(int i) {
        this.mLinkColor = i;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = this.mLinkColor;
        if (i == 0) {
            textPaint.setColor(textPaint.linkColor);
        } else {
            textPaint.setColor(i);
        }
    }
}
