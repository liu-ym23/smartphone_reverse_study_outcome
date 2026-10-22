package ce1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lce1/b;", "", "", "popSeq", "Ljava/lang/Integer;", "getPopSeq", "()Ljava/lang/Integer;", "popDayUpLimit", "getPopDayUpLimit", "popTotalUpLimit", "getPopTotalUpLimit", "", "giftFusionGuideText", "Ljava/lang/String;", "getGiftFusionGuideText", "()Ljava/lang/String;", "fansClubFusionGuideText", "getFansClubFusionGuideText", "fusionGuideSchema", "getFusionGuideSchema", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("fansclub_fusion_guide_text")
    private final String fansClubFusionGuideText;

    @SerializedName("fusion_guide_schema")
    private final String fusionGuideSchema;

    @SerializedName("gift_fusion_guide_text")
    private final String giftFusionGuideText;

    @SerializedName("pop_day_uplimit")
    private final Integer popDayUpLimit;

    @SerializedName("pop_seq")
    private final Integer popSeq;

    @SerializedName("pop_total_uplimit")
    private final Integer popTotalUpLimit;

    public b() {
    }
}
