package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/m91;", "", "", "xmlCacheOpt", "Z", "b", "()Z", "setXmlCacheOpt", "(Z)V", "", "xmlCacheSize", "I", "c", "()I", "setXmlCacheSize", "(I)V", "drawableCacheOpt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDrawableCacheOpt", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m91 {

    @SerializedName("drawable_cache_opt")
    private boolean drawableCacheOpt;

    @SerializedName("xml_cache_opt")
    private boolean xmlCacheOpt;

    @SerializedName("xml_cache_size")
    private int xmlCacheSize;

    public m91() {
        this.xmlCacheSize = 4;
    }

    public final boolean a() {
        return this.drawableCacheOpt;
    }

    public final boolean b() {
        return this.xmlCacheOpt;
    }

    public final int c() {
        return this.xmlCacheSize;
    }
}
