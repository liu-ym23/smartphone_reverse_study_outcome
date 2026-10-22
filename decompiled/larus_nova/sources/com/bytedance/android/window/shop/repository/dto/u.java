package com.bytedance.android.window.shop.repository.dto;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/u;", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "", "cpsTrack", "Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/String;", "requestKey", "getRequestKey", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u extends WindowV2ProductItemDTO {

    @SerializedName("ecom_cps_track")
    private final String cpsTrack;

    @SerializedName("request_key")
    private final String requestKey;

    public u() {
        super(null);
    }

    public final String T() {
        return this.cpsTrack;
    }
}
