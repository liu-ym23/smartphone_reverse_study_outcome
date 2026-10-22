package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cb;", "Lvh7/c;", "", "getActionType", "()I", "getActionType$annotations", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionExtra", "()Ljava/lang/String;", "getActionExtra$annotations", "actionExtra", "getPetMeta", "getPetMeta$annotations", "petMeta", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface cb extends vh7.c<cb> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "action_extra")
    String getActionExtra();

    @FieldName(name = "action_type")
    int getActionType();

    @FieldName(name = "pet_meta")
    String getPetMeta();
}
