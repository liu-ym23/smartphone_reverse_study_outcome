package com.bytedance.android.livesdk.message.model;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface y8 extends vh7.c<y8> {
    public static final int Show10SecBeforeStart = 1;
    public static final int Show3HourBeforeStart = 0;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    int getIntType();

    @FieldName(name = UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    String getMToastMsg();

    @FieldName(name = "type")
    int getMType();
}
