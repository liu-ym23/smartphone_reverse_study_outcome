package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.bytedance.android.ec.hybrid.api.card.mita.ECHybridMitaCardConfig;
import com.bytedance.android.ec.hybrid.list.util.j;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECListItemConfigDTO;", "Ljava/io/Serializable;", "()V", "lynxConfig", "", "getLynxConfig", "()Ljava/lang/String;", "setLynxConfig", "(Ljava/lang/String;)V", "mitaCardConfig", "Lcom/bytedance/android/ec/hybrid/api/card/mita/ECHybridMitaCardConfig;", "getMitaCardConfig", "()Lcom/bytedance/android/ec/hybrid/api/card/mita/ECHybridMitaCardConfig;", "setMitaCardConfig", "(Lcom/bytedance/android/ec/hybrid/api/card/mita/ECHybridMitaCardConfig;)V", "tackOutSchema", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECListItemConfigDTO implements Serializable {

    @SerializedName("lynx_config")
    private String lynxConfig;

    @SerializedName(ECHybridMitaCardConfig.KEY_CONFIG)
    private ECHybridMitaCardConfig mitaCardConfig;

    public ECListItemConfigDTO() {
    }

    public final String tackOutSchema() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        String r101 = this.lynxConfig;     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        Gson r102 = j.f47334a;     // Catch: Throwable -> L8
        return ((ECLynxConfigDTO) j.f47334a.fromJson(r101, ECLynxConfigDTO.class)).getLynxSchema();
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public final String getLynxConfig() {
        return this.lynxConfig;
    }

    public final ECHybridMitaCardConfig getMitaCardConfig() {
        return this.mitaCardConfig;
    }

    public final void setLynxConfig(String r100) {
        this.lynxConfig = r100;
    }

    public final void setMitaCardConfig(ECHybridMitaCardConfig r100) {
        this.mitaCardConfig = r100;
    }
}
