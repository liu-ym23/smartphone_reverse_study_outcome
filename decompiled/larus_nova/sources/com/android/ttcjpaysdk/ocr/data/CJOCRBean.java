package com.android.ttcjpaysdk.ocr.data;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/CJOCRBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "type", "", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "ocrParams", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;Ljava/lang/String;)V", "extParams", "getExtParams", "()Ljava/lang/String;", "setExtParams", "(Ljava/lang/String;)V", "riskInfo", "getRiskInfo", "setRiskInfo", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRBean implements CJPayObject, Serializable {
    private String extParams;
    public CJPayHostInfo hostInfo;
    public String ocrParams;
    private String riskInfo;
    public String type;

    public final String getExtParams() {
        return this.extParams;
    }

    public final String getRiskInfo() {
        return this.riskInfo;
    }

    public final void setExtParams(String r100) {
        this.extParams = r100;
    }

    public final void setRiskInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.riskInfo = r100;
    }

    public CJOCRBean(String r100, CJPayHostInfo r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "hostInfo");
        Intrinsics.checkNotNullParameter(r102, "ocrParams");
        this.type = r100;
        this.hostInfo = r101;
        this.ocrParams = r102;
        this.riskInfo = "";
    }

    public /* synthetic */ CJOCRBean(String r100, CJPayHostInfo r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "";
    L8:
        this(r100, r101, r102);
    }
}
