package com.bytedance.android.window.shop.repository.vo;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/vo/PopularRankInfoVO;", "Ljava/io/Serializable;", "", "rankId", "Ljava/lang/Integer;", "getRankId", "()Ljava/lang/Integer;", "setRankId", "(Ljava/lang/Integer;)V", "", "rankText", "Ljava/lang/String;", "getRankText", "()Ljava/lang/String;", "setRankText", "(Ljava/lang/String;)V", "rankSchema", "getRankSchema", "setRankSchema", "trackId", "getTrackId", "setTrackId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopularRankInfoVO implements Serializable {
    public static final a Companion = null;
    private Integer rankId;
    private String rankSchema;
    private String rankText;
    private Integer trackId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PopularRankInfoVO() {
    }

    public final Integer getRankId() {
        return this.rankId;
    }

    public final String getRankSchema() {
        return this.rankSchema;
    }

    public final String getRankText() {
        return this.rankText;
    }

    public final Integer getTrackId() {
        return this.trackId;
    }

    public final void setRankId(Integer r100) {
        this.rankId = r100;
    }

    public final void setRankSchema(String r100) {
        this.rankSchema = r100;
    }

    public final void setRankText(String r100) {
        this.rankText = r100;
    }

    public final void setTrackId(Integer r100) {
        this.trackId = r100;
    }
}
