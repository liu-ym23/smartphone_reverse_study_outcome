package com.bytedance.android.livesdk.configmodel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.revenue.platform.api.core.c;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import ys1.b;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/configmodel/LiveSceneGiftSyncConfigSerializableObjectImpl;", "Lys1/b;", "", "", "pkTimeToEnd", "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "", "resetGiftAfterPk", "Z", "o6", "()Z", "featureEnable", "Q7", "<init>", "()V", "Adapter", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveSceneGiftSyncConfigSerializableObjectImpl implements b {

    @SerializedName("feature_enable")
    private final boolean featureEnable;

    @SerializedName("pk_time_to_end")
    private final List<Long> pkTimeToEnd;

    @SerializedName("reset_gift_after_pk")
    private final boolean resetGiftAfterPk;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/configmodel/LiveSceneGiftSyncConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveSceneGiftSyncConfigSerializableObjectImpl.class);
        }
    }

    public LiveSceneGiftSyncConfigSerializableObjectImpl() {
        this.pkTimeToEnd = c.a(new Long[0]);
        this.resetGiftAfterPk = false;
        this.featureEnable = false;
    }

    @Override // ys1.b
    public final List<Long> A() {
        return this.pkTimeToEnd;
    }

    @Override // ys1.b
    public final boolean Q7() {
        return this.featureEnable;
    }

    @Override // ys1.b
    public final boolean o6() {
        return this.resetGiftAfterPk;
    }
}
