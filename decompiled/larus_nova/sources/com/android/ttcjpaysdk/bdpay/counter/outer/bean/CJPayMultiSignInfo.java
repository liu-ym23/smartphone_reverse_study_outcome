package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayMultiSignInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "authorization_code", "", "display_mask_value", "display_type_title", "display_value", "isNotEmpty", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayMultiSignInfo implements CJPayObject, Serializable {
    public String authorization_code;
    public String display_mask_value;
    public String display_type_title;
    public String display_value;

    public final boolean isNotEmpty() {
        if (this.display_value.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L18:
        return false;
    L8:
        if (this.display_type_title.length() <= 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L18;
        if (this.display_mask_value.length() <= 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        return true;
    L15:
        r102 = false;
        goto L16
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public CJPayMultiSignInfo() {
        this.authorization_code = "";
        this.display_type_title = "";
        this.display_value = "";
        this.display_mask_value = "";
    }
}
