package com.bytedance.android.live.openplatform.api.model.shelf;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/f;", "", "", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/e;", "cardInfoMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setCardInfoMap", "(Ljava/util/Map;)V", "<init>", "()V", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("card_info_map")
    private Map<Long, e> cardInfoMap;

    public f() {
    }

    public final Map<Long, e> a() {
        return this.cardInfoMap;
    }
}
