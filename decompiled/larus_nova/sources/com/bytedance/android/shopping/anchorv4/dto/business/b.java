package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/b;", "", "", "screenShotPhotoSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "findSameUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("find_same_url")
    private final String findSameUrl;

    @SerializedName("screen_shot_photo_schema")
    private final String screenShotPhotoSchema;

    public b() {
        this.screenShotPhotoSchema = null;
        this.findSameUrl = null;
    }

    public final String a() {
        return this.findSameUrl;
    }

    public final String b() {
        return this.screenShotPhotoSchema;
    }
}
