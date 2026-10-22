package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b-\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR*\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECFloatWindowInfo;", "Ljava/io/Serializable;", "", "getInfoType", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "getType$annotations", "()V", "status", "getStatus", "setStatus", "Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;", "detailInfo", "Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;", "getDetailInfo", "()Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;", "setDetailInfo", "(Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;)V", "getDetailInfo$annotations", "", "Lcom/bytedance/android/ec/model/response/CarouselDetailInfo;", "carouselDetailInfos", "Ljava/util/List;", "getCarouselDetailInfos", "()Ljava/util/List;", "setCarouselDetailInfos", "(Ljava/util/List;)V", "", "carouselInterval", "J", "getCarouselInterval", "()J", "setCarouselInterval", "(J)V", "keepTime", "Ljava/lang/Long;", "getKeepTime", "()Ljava/lang/Long;", "setKeepTime", "(Ljava/lang/Long;)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowInfo implements Serializable {
    public static final long AUTO_SCROLL_DELAY = 15000;
    public static final a Companion = null;
    public static final String INFO_TYPE_ATTRIBUTE = "attribute";
    public static final String INFO_TYPE_SIZE = "size";
    public static final int STATUS_CLOSE = 2;
    public static final int STATUS_EXPAND = 1;
    public static final int TYPE_ATTRIBUTE = 2;
    public static final int TYPE_SIZE_INFO = 1;
    private static final long serialVersionUID = 1;

    @SerializedName("carousel_detail_infos")
    private List<CarouselDetailInfo> carouselDetailInfos;

    @SerializedName("carousel_interval")
    private long carouselInterval;

    @SerializedName("detail_info")
    private ECFloatWindowDetailInfo detailInfo;

    @SerializedName("keep_time")
    private Long keepTime;

    @SerializedName("status")
    private Integer status;

    @SerializedName("type")
    private Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Deprecated(message = "废弃，请使用 carousel_detail_infos")
    public static /* synthetic */ void getDetailInfo$annotations() {
    }

    @Deprecated(message = "废弃，请使用 carousel_detail_infos 内 type")
    public static /* synthetic */ void getType$annotations() {
    }

    public final String getInfoType() {
        Integer r100 = this.type;
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        return "";
    L11:
        if (r100.intValue() != 2) goto L13;
        return INFO_TYPE_ATTRIBUTE;
    L6:
        if (r100.intValue() != 1) goto L8;
        return "size";
    }

    public ECFloatWindowInfo() {
        this.carouselInterval = 15000;
    }

    public final List<CarouselDetailInfo> getCarouselDetailInfos() {
        return this.carouselDetailInfos;
    }

    public final long getCarouselInterval() {
        return this.carouselInterval;
    }

    public final ECFloatWindowDetailInfo getDetailInfo() {
        return this.detailInfo;
    }

    public final Long getKeepTime() {
        return this.keepTime;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setCarouselDetailInfos(List<CarouselDetailInfo> r100) {
        this.carouselDetailInfos = r100;
    }

    public final void setCarouselInterval(long r100) {
        this.carouselInterval = r100;
    }

    public final void setDetailInfo(ECFloatWindowDetailInfo r100) {
        this.detailInfo = r100;
    }

    public final void setKeepTime(Long r100) {
        this.keepTime = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
