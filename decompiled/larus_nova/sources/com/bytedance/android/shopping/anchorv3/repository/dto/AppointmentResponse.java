package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v63.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/AppointmentResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "appointToast", "Ljava/lang/String;", "getAppointToast", "()Ljava/lang/String;", "setAppointToast", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "Lv63/a;", "calendarData", "Lv63/a;", "getCalendarData", "()Lv63/a;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentResponse extends CommerceBaseResponse {

    @SerializedName("appoint_toast")
    private String appointToast;

    @SerializedName("calendar_data")
    private final a calendarData;

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    public AppointmentResponse() {
        this.appointToast = "";
    }

    public final String getAppointToast() {
        return this.appointToast;
    }

    public final a getCalendarData() {
        return this.calendarData;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final void setAppointToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appointToast = r100;
    }
}
