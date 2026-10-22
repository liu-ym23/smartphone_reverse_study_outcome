package com.alibaba.gaiax.adapter;

import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.template.GXIExpression;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/adapter/GXExtensionMultiVersionExpression;", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionExpression;", "()V", "create", "Lcom/alibaba/gaiax/template/GXIExpression;", "expVersion", "", "value", "", "isTrue", "", "GaiaX-Adapter"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXExtensionMultiVersionExpression implements GXRegisterCenterApi.GXIExtensionExpression {
    public GXExtensionMultiVersionExpression() {
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionExpression
    public GXIExpression create(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        return GaiaXExpression.Companion.create(r101);
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXIExtensionExpression
    public boolean isTrue(String r100, Object r101) {
        return GaiaXExpression.Companion.isCondition(r101);
    }
}
