package com.android.ttcjpaysdk.thirdparty.supplementarysign.wrapper;

import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.android.ttcjpaysdk.base.ui.CJPayInputKeyboardHelper;
import com.android.ttcjpaysdk.thirdparty.view.CJPayPasteAwareEditText;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class SSMobileInputWrapper extends SSBasicInputWrapper {
    public static final int MAX_MOBILE_LENGTH = 13;
    private String mMaskedMobileNumber;

    public void clearMaskedMobileNumber() {
        String r100 = this.mMaskedMobileNumber;
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.mMaskedMobileNumber = null;
        getEditText().getText().clear();
        return;
    }

    private void initEditText() {
        getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
        setInputErrorDetector(new AnonymousClass1(this));
        CJPayPasteAwareEditText r100 = getEditText();
        final List r101 = Arrays.asList(new Integer[]{3, 7});
        r100.addTextChangedListener(new AnonymousClass2(this, r101));
        getEditText().setOnPasteListener(new AnonymousClass3(this));
        setOnFocusChangeListener(new AnonymousClass4(this));
        setOnClearListener(new AnonymousClass5(this));
    }

    public SSMobileInputWrapper(View r100) {
        super(r100);
        this.mMaskedMobileNumber = null;
        initEditText();
    }

    public static /* synthetic */ String access$000(SSMobileInputWrapper r100) {
        return r100.mMaskedMobileNumber;
    }

    public SSMobileInputWrapper(View r100, CJPayInputKeyboardHelper r101) {
        super(r100, r101);
        this.mMaskedMobileNumber = null;
        initEditText();
    }

    public static /* synthetic */ String access$002(SSMobileInputWrapper r100, String r101) {
        r100.mMaskedMobileNumber = r101;
        return r101;
    }

    public SSMobileInputWrapper(View r100, CJPayInputKeyboardHelper r101, String r102) {
        super(r100, r101);
        this.mMaskedMobileNumber = r102;
        initEditText();
    }
}
