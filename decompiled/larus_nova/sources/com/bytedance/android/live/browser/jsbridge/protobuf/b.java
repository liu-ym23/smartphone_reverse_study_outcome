package com.bytedance.android.live.browser.jsbridge.protobuf;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/protobuf/b;", "", "", "", "weekdaysArray", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "", "anchorId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "nickName", "d", "", "scheduleDate", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "scheduleTime", "f", "appointmentId", "b", "enterFromType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("anchor_id")
    private final String anchorId;

    @SerializedName("appointment_id")
    private final String appointmentId;

    @SerializedName("enter_from_type")
    private final Integer enterFromType;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("scheduled_date")
    private final Long scheduleDate;

    @SerializedName("scheduled_time")
    private final Long scheduleTime;

    @SerializedName("weekdays_array")
    private final List<Integer> weekdaysArray;

    public b() {
    }

    public final String a() {
        return this.anchorId;
    }

    public final String b() {
        return this.appointmentId;
    }

    public final Integer c() {
        return this.enterFromType;
    }

    public final String d() {
        return this.nickName;
    }

    public final Long e() {
        return this.scheduleDate;
    }

    public final Long f() {
        return this.scheduleTime;
    }

    public final List<Integer> g() {
        return this.weekdaysArray;
    }
}
