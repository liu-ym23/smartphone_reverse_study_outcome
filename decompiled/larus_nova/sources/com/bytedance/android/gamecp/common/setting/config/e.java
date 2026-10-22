package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/e;", "", "", "fileName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "noAcFileName", "b", "originalFileName", "c", "d", "(Ljava/lang/String;)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("no_ac_file_name")
    private final String noAcFileName;

    @SerializedName("original_file_name")
    private String originalFileName;

    public e() {
        this.fileName = "";
        this.noAcFileName = "";
        this.originalFileName = "";
    }

    public final String a() {
        return this.fileName;
    }

    public final String b() {
        return this.noAcFileName;
    }

    public final String c() {
        return this.originalFileName;
    }

    public final void d(String r100) {
        this.originalFileName = r100;
    }
}
