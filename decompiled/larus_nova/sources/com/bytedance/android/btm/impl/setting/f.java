package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/f;", "", "", "switch", "I", "b", "()I", "", "errorCodes", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class f {

    @SerializedName("error_codes")
    private final List<Integer> errorCodes;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f60switch;

    public f() {
        this.f60switch = 1;
        this.errorCodes = CollectionsKt.listOf(new Integer[]{Integer.valueOf(AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED), 6003, Integer.valueOf(AuthCode.StatusCode.PERMISSION_EXPIRED), 2012, 6007});
    }

    public final List<Integer> a() {
        return this.errorCodes;
    }

    public final int b() {
        return this.f60switch;
    }
}
