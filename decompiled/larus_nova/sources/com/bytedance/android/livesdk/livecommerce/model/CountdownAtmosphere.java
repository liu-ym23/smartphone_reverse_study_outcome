package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.CountdownAtmosphere")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/CountdownAtmosphere;", "", "", DyPayConstant.KEY_START_TIME, "J", "endTime", "Lcom/bytedance/android/livesdk/livecommerce/model/AtmosphereData;", "data", "Lcom/bytedance/android/livesdk/livecommerce/model/AtmosphereData;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountdownAtmosphere {
    public static final a Companion = null;

    @SerializedName("data")
    public AtmosphereData data;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CountdownAtmosphere() {
    }
}
