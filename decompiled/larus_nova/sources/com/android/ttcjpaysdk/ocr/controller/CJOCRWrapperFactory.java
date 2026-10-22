package com.android.ttcjpaysdk.ocr.controller;

import android.app.Activity;
import android.view.View;
import com.android.ttcjpaysdk.ocr.data.CJOCRBean;
import com.android.ttcjpaysdk.ocr.wrapper.CJOCRBaseWrapper;
import com.android.ttcjpaysdk.ocr.wrapper.CJOCRCreditCertWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/controller/CJOCRWrapperFactory;", "", "()V", "getOCRWrapper", "Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRBaseWrapper;", "activity", "Landroid/app/Activity;", "contentView", "Landroid/view/View;", "ocrBean", "Lcom/android/ttcjpaysdk/ocr/data/CJOCRBean;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRWrapperFactory {
    public static final CJOCRWrapperFactory INSTANCE = null;

    static {
        INSTANCE = new CJOCRWrapperFactory();
    }

    private CJOCRWrapperFactory() {
    }

    public final CJOCRBaseWrapper getOCRWrapper(Activity r100, View r101, CJOCRBean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "contentView");
        if (r102 == null) goto L5;
        String r103 = r102.type;
    L7:
        if (Intrinsics.areEqual(r103, "credit_cert") == true) goto L9;
        return null;
    L9:
        return new CJOCRCreditCertWrapper(r100, r101, r102);
    L5:
        r103 = null;
        goto L7
    }
}
