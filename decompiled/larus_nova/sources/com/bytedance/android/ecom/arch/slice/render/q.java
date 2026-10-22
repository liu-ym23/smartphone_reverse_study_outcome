package com.bytedance.android.ecom.arch.slice.render;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/q;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "version", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "url", "getUrl", "", "gitInfo", "Ljava/util/Map;", "getGitInfo", "()Ljava/util/Map;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class q {

    @SerializedName("git_info")
    private final Map<String, Object> gitInfo;

    @SerializedName("name")
    private final String name;

    @SerializedName("url")
    private final String url;

    @SerializedName("version")
    private final String version;

    public q() {
        this(null, 15);
    }

    public final p b() {
        String r100 = this.name;
        return new p(this.url, r100, this.version, null, 120);
    }

    public final String a() {
        return this.version;
    }

    public q(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.name = r100;
        this.version = null;
        this.url = null;
        this.gitInfo = null;
    }
}
