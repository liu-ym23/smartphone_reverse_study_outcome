package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AppointmentData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AppointmentData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAppointmentData;", "()V", "appointmentId", "", "getAppointmentId", "()J", "setAppointmentId", "(J)V", "isSubscribe", "", "()Z", "setSubscribe", "(Z)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentData extends FlexModelBase<IAppointmentData> implements IAppointmentData, h {

    @SerializedName("appointment_id")
    protected long appointmentId;

    @SerializedName("is_subscribe")
    protected boolean isSubscribe;

    public AppointmentData() {
        super(IAppointmentData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAppointmentData
    public long getAppointmentId() {
        return this.appointmentId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAppointmentData
    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public AppointmentData(g r100) {
        super(IAppointmentData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.appointmentId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.isSubscribe = am3.h.a(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setAppointmentId(long r100) {
        this.appointmentId = r100;
    }

    public void setSubscribe(boolean r100) {
        this.isSubscribe = r100;
    }
}
