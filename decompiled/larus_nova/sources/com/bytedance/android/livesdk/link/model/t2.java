package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/t2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/z;", "Lcom/bytedance/android/livesdk/link/model/x7;", "getPkResult", "()Lcom/bytedance/android/livesdk/link/model/x7;", "getPkResult$annotations", "()V", "pkResult", "Lcom/bytedance/android/livesdk/link/model/w9;", "getUpGradeResult", "()Lcom/bytedance/android/livesdk/link/model/w9;", "getUpGradeResult$annotations", "upGradeResult", "Lcom/bytedance/android/livesdk/link/model/k4;", "getGetGrade", "()Lcom/bytedance/android/livesdk/link/model/k4;", "getGetGrade$annotations", "getGrade", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t2 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.z>, com.bytedance.android.livesdk.link.model.bridge.z {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.z, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "get_grade_info")
    k4 getGetGrade();

    @FieldName(name = "pk_result")
    x7 getPkResult();

    @FieldName(name = "upgrade_result")
    w9 getUpGradeResult();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
