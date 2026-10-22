package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2;", "Ljava/io/Serializable;", "", "girdleType", "Ljava/lang/String;", "getGirdleType", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgPic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "namePic", "getNamePic", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2Slogan;", "slogan", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2Slogan;", "getSlogan", "()Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2Slogan;", "Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "countdown", "Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "getCountdown", "()Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "url", "getUrl", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CommonGirdleStructV2 implements Serializable {
    public static final a Companion = null;
    public static final String TYPE_N_GROUP = "n_group_buy";
    public static final String TYPE_PRESALE = "deposit_presale";

    @SerializedName("bg_pic")
    private final ECUrlModel bgPic;

    @SerializedName("countdown")
    private final CountDown countdown;

    @SerializedName("girdle_type")
    private final String girdleType;

    @SerializedName("name_pic")
    private final ECUrlModel namePic;

    @SerializedName("slogan")
    private final CommonGirdleStructV2Slogan slogan;

    @SerializedName("url")
    private final String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommonGirdleStructV2() {
    }

    public final ECUrlModel getBgPic() {
        return this.bgPic;
    }

    public final CountDown getCountdown() {
        return this.countdown;
    }

    public final String getGirdleType() {
        return this.girdleType;
    }

    public final ECUrlModel getNamePic() {
        return this.namePic;
    }

    public final CommonGirdleStructV2Slogan getSlogan() {
        return this.slogan;
    }

    public final String getUrl() {
        return this.url;
    }
}
