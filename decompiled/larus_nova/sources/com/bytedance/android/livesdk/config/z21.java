package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/config/z21;", "", "", "times", "I", "d", "()I", "setTimes", "(I)V", "", "enableAutoPage", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableAutoPage", "(Z)V", "", "", "sourceList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setSourceList", "(Ljava/util/List;)V", "firstSkipList", "b", "setFirstSkipList", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z21 {

    @SerializedName("enable_auto_page")
    private boolean enableAutoPage;

    @SerializedName("first_skip_list")
    private List<String> firstSkipList;

    @SerializedName("source_list")
    private List<String> sourceList;

    @SerializedName("times")
    private int times;

    public z21() {
        this.times = 3;
        this.enableAutoPage = true;
    }

    public final boolean a() {
        return this.enableAutoPage;
    }

    public final List<String> b() {
        return this.firstSkipList;
    }

    public final List<String> c() {
        return this.sourceList;
    }

    public final int d() {
        return this.times;
    }
}
