package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h0;", "", "", "Lcom/bytedance/android/gamecp/common/setting/config/h0$a;", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("data")
    private final List<a> data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h0$a;", "", "", "", "rangeList", "Ljava/util/List;", "getRangeList", "()Ljava/util/List;", "Lcom/bytedance/android/gamecp/common/setting/config/h0$b;", "pkg2DownRate", "getPkg2DownRate", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("pkg_2_down_rate")
        private final List<b> pkg2DownRate;

        @SerializedName("range_list")
        private final List<String> rangeList;

        public a() {
            this.rangeList = CollectionsKt.emptyList();
            this.pkg2DownRate = CollectionsKt.emptyList();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/h0$b;", "", "", "pkg", "Ljava/lang/String;", "getPkg", "()Ljava/lang/String;", "", "bitrateDownRate", "D", "getBitrateDownRate", "()D", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("bitrate_rate")
        private final double bitrateDownRate;

        @SerializedName("pkg")
        private final String pkg;

        public b() {
            this.pkg = "";
            this.bitrateDownRate = 1.0d;
        }
    }

    public h0() {
    }
}
