package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.util.AttributeSet;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAmountEditText extends CJPayPasteAwareEditText {
    private OnInputChangedListener mOnInputChangedListener;

    public interface OnInputChangedListener {
        void onInputChanged(String r100);
    }

    public CJPayAmountEditText(Context r100) {
        super(r100);
    }

    public static /* synthetic */ OnInputChangedListener access$000(CJPayAmountEditText r100) {
        return r100.mOnInputChangedListener;
    }

    public void setOnInputChangedListener(OnInputChangedListener r100) {
        this.mOnInputChangedListener = r100;
    }

    public CJPayAmountEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public void initDigitNumberLimit(final int r100, final int r101) {
        addTextChangedListener(new AnonymousClass1(this, r101, r100));
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        if (r100 != r101) goto L16;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAmountEditText#onSelectionChanged", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAmountEditText#onSelectionChanged", e);
        return;
    L5:
        if (getText() != null) goto L7;
        setSelection(0);     // Catch: Exception -> L9
    L12:
        return;
    L7:
        setSelection(getText().length());     // Catch: Exception -> L9
        goto L12
    }

    public CJPayAmountEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
