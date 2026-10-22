package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface x0 extends vh7.c<x0> {
    public static final int AUDIT_STATUS_LIVE_DECO_TEXT_NO_PASS = 31;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "audit_nopass_warn")
    String getAuditNotPassWarnText();

    @FieldName(name = "audit_status")
    int getAuditStatus();

    @FieldName(name = EventConstant.Key.RETAIN_PROMPT)
    String getPrompt();

    @FieldName(name = "can_edit")
    boolean isIsCanEdit();
}
