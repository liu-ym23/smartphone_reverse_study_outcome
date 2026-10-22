package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/APIAction;", "Ljava/io/Serializable;", ReportConstant.COMMON_ACTION_TYPE, "", "param", "(Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "getParam", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class APIAction implements Serializable {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("param")
    private final String param;

    /* JADX WARN: Multi-variable type inference failed */
    public APIAction() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getParam() {
        return this.param;
    }

    public APIAction(String r100, String r101) {
        this.actionType = r100;
        this.param = r101;
    }

    public /* synthetic */ APIAction(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
