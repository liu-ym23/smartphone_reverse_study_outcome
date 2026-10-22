package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/g;", "", "", "sdkSwitch", "I", "e", "()I", "setSdkSwitch", "(I)V", "bcmSdkSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBcmSdkSwitch", "Lcom/bytedance/android/btm/impl/setting/l;", "feature", "Lcom/bytedance/android/btm/impl/setting/l;", "c", "()Lcom/bytedance/android/btm/impl/setting/l;", "Lcom/bytedance/android/btm/impl/setting/h;", DownloadSettingKeys.BUG_FIX, "Lcom/bytedance/android/btm/impl/setting/h;", "b", "()Lcom/bytedance/android/btm/impl/setting/h;", "Lcom/bytedance/android/btm/impl/setting/o;", "optimize", "Lcom/bytedance/android/btm/impl/setting/o;", "d", "()Lcom/bytedance/android/btm/impl/setting/o;", "kmpSdkSwitch", "getKmpSdkSwitch", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class g {

    @SerializedName("bcm_sdk_switch")
    private int bcmSdkSwitch;

    @SerializedName(DownloadSettingKeys.BUG_FIX)
    private final h bugfix;

    @SerializedName("feature")
    private final l feature;

    @SerializedName("kmp_sdk_switch")
    private final int kmpSdkSwitch;

    @SerializedName("optimize")
    private final o optimize;

    @SerializedName("sdk_switch")
    private int sdkSwitch;

    public g() {
        this.sdkSwitch = 1;
        this.bcmSdkSwitch = 1;
        this.feature = new l();
        this.bugfix = new h();
        this.optimize = new o();
        this.kmpSdkSwitch = 1;
    }

    public final int a() {
        return this.bcmSdkSwitch;
    }

    public final h b() {
        return this.bugfix;
    }

    public final l c() {
        return this.feature;
    }

    public final o d() {
        return this.optimize;
    }

    public final int e() {
        return this.sdkSwitch;
    }
}
