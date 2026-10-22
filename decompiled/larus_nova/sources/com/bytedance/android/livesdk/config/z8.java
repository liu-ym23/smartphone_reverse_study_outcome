package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/z8;", "", "", "chorusFactor", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "setChorusFactor", "(F)V", "ktvFactor", "getKtvFactor", "setKtvFactor", "musicFactor", "getMusicFactor", "setMusicFactor", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z8 {

    @SerializedName("chorus")
    private float chorusFactor;

    @SerializedName("ktv")
    private float ktvFactor;

    @SerializedName("music")
    private float musicFactor;

    public z8() {
        this.chorusFactor = 1.2f;
        this.ktvFactor = 1.15f;
        this.musicFactor = 1.15f;
    }

    public final float a() {
        return this.chorusFactor;
    }
}
