package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/r;", "", "", "fromBtm", "Ljava/lang/String;", "getFromBtm", "()Ljava/lang/String;", "setFromBtm", "(Ljava/lang/String;)V", "toSchemaReg", "getToSchemaReg", "setToSchemaReg", "toBtm", "getToBtm", "setToBtm", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class r {

    @SerializedName("from_btm")
    private String fromBtm;

    @SerializedName("to_btm")
    private String toBtm;

    @SerializedName("to_schema_reg")
    private String toSchemaReg;

    public r() {
        this.fromBtm = "";
        this.toSchemaReg = "";
        this.toBtm = "";
    }
}
