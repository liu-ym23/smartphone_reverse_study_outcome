package com.android.ttcjpaysdk.integrated.counter.component.lynx.std;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/std/StdPayTypeChangeInfo;", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "ptCode", "", "payTypeIndex", "combinePayTypeIndex", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "<set-?>", "ptcode", "getCombineInfo", "getPayTypeIndex", "getPtCode", CJPayConstant.CJ_PAY_SHARE_PARAMS_KEY_IS_ASSET_STANDARD, "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdPayTypeChangeInfo implements IPayTypeChangeInfo {
    private String combinePayTypeIndex;
    private String payTypeIndex;
    private String ptcode;

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public boolean isAssetStd() {
        return true;
    }

    public StdPayTypeChangeInfo() {
        this.ptcode = "";
        this.payTypeIndex = "";
        this.combinePayTypeIndex = "";
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public String getCombineInfo() {
        return this.combinePayTypeIndex;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public String getPayTypeIndex() {
        return this.payTypeIndex;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public String getPtCode() {
        return this.ptcode;
    }

    public StdPayTypeChangeInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ptCode");
        Intrinsics.checkNotNullParameter(r101, "payTypeIndex");
        Intrinsics.checkNotNullParameter(r102, "combinePayTypeIndex");
        this();
        this.ptcode = r100;
        this.payTypeIndex = r101;
        this.combinePayTypeIndex = r102;
    }
}
