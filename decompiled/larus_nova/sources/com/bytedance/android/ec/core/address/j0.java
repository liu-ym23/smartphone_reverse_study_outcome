package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/address/j0;", "", "", "path", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btm", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, SocialConstants.PARAM_APP_DESC, "getDesc", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("btm")
    private final String btm;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("path")
    private final String path;

    public j0() {
        this.path = null;
        this.btm = null;
        this.desc = null;
    }

    public final String a() {
        return this.btm;
    }

    public final String b() {
        return this.path;
    }
}
