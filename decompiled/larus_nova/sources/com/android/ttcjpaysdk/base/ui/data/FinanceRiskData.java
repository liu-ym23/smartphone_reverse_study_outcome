package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/FinanceRiskData;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "device_feat", "Lcom/android/ttcjpaysdk/base/ui/data/DeviceFeat;", "caijing_risk_sdk_feature", "", "(Lcom/android/ttcjpaysdk/base/ui/data/DeviceFeat;Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FinanceRiskData implements CJPayObject {
    public String caijing_risk_sdk_feature;
    public DeviceFeat device_feat;

    /* JADX WARN: Multi-variable type inference failed */
    public FinanceRiskData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        DeviceFeat r101 = this.device_feat;
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        JSONObject r103 = r101.toJson();
    L6:
        KtSafeMethodExtensionKt.safePut(r100, "device_feat", r103);
        String r104 = this.caijing_risk_sdk_feature;
        if (r104 == null) goto L9;
        r102 = new JSONObject(r104);
    L9:
        KtSafeMethodExtensionKt.safePut(r100, "caijing_risk_sdk_feature", r102);
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public String toString() {
        return this.device_feat + ';' + this.caijing_risk_sdk_feature;
    }

    public FinanceRiskData(DeviceFeat r100, String r101) {
        this.device_feat = r100;
        this.caijing_risk_sdk_feature = r101;
    }

    public /* synthetic */ FinanceRiskData(DeviceFeat r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
