package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/k;", "", "", "level", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "param", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "value", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class k {

    @SerializedName("level")
    private final int level;

    @SerializedName("param")
    private final String param;

    @SerializedName("value")
    private final List<String> value;

    public k() {
        this.param = "";
        this.value = CollectionsKt.emptyList();
    }

    public final int a() {
        return this.level;
    }

    public final String b() {
        return this.param;
    }

    public final List<String> c() {
        return this.value;
    }
}
