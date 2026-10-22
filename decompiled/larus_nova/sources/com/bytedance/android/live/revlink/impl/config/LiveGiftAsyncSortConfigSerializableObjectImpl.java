package com.bytedance.android.live.revlink.impl.config;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.revenue.platform.api.core.c;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import r11.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LiveGiftAsyncSortConfigSerializableObjectImpl;", "Lr11/k;", "", "enable", "Z", "getEnable", "()Z", "enablePk", "K6", "enablePkReset", "u3", "", "", "pkTimeToEnd", "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveGiftAsyncSortConfigSerializableObjectImpl implements k {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_pk")
    private final boolean enablePk;

    @SerializedName("enable_pk_reset")
    private final boolean enablePkReset;

    @SerializedName("pk_time_to_end")
    private final List<Long> pkTimeToEnd;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LiveGiftAsyncSortConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveGiftAsyncSortConfigSerializableObjectImpl.class);
        }
    }

    public LiveGiftAsyncSortConfigSerializableObjectImpl() {
        this.enable = false;
        this.enablePk = false;
        this.enablePkReset = false;
        this.pkTimeToEnd = c.a(new Long[]{30000L});
    }

    @Override // r11.k
    public final List<Long> A() {
        return this.pkTimeToEnd;
    }

    @Override // r11.k
    public final boolean K6() {
        return this.enablePk;
    }

    @Override // r11.k
    public final boolean u3() {
        return this.enablePkReset;
    }
}
