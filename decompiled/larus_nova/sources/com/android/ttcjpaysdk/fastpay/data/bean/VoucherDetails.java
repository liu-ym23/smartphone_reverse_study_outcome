package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/bean/VoucherDetails;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "front_bank_code", "", "label", "used_amount", "", "voucher_name", "voucher_no", "voucher_type", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetails implements CJPayObject {
    public String front_bank_code;
    public String label;
    public long used_amount;
    public String voucher_name;
    public String voucher_no;
    public String voucher_type;

    public VoucherDetails() {
        this.front_bank_code = "";
        this.label = "";
        this.voucher_no = "";
        this.voucher_name = "";
        this.voucher_type = "";
    }
}
