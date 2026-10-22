package com.android.ttcjpaysdk.integrated.counter.component.lynx;

import com.android.ttcjpaysdk.base.CJPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/PayTypeChangeInfo;", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "ptCode", "", "payTypeIndex", "combineType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "<set-?>", "ptcode", "getCombineInfo", "getPayTypeIndex", "getPtCode", CJPayConstant.CJ_PAY_SHARE_PARAMS_KEY_IS_ASSET_STANDARD, "", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayTypeChangeInfo implements IPayTypeChangeInfo {
    public static final Companion Companion = null;
    private String combineType;
    private String payTypeIndex;
    private String ptcode;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/PayTypeChangeInfo$Companion;", "", "()V", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public boolean isAssetStd() {
        return false;
    }

    public PayTypeChangeInfo() {
        this.ptcode = "";
        this.payTypeIndex = "";
        this.combineType = "";
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public String getCombineInfo() {
        return this.combineType;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public String getPayTypeIndex() {
        return this.payTypeIndex;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo
    public String getPtCode() {
        return this.ptcode;
    }

    public PayTypeChangeInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ptCode");
        Intrinsics.checkNotNullParameter(r101, "payTypeIndex");
        Intrinsics.checkNotNullParameter(r102, "combineType");
        this();
        this.ptcode = r100;
        this.payTypeIndex = r101;
        this.combineType = r102;
    }
}
