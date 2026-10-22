package com.bytedance.android.ec.hybrid.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/e;", "", "", "", "apiHosts", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "imageHosts", "b", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f46664a = null;

    @SerializedName("api_hosts")
    private final List<String> apiHosts;

    @SerializedName("image_hosts")
    private final List<String> imageHosts;

    public static final class a {
    }

    public e() {
    }

    static {
        f46664a = new e();
    }

    public final List<String> a() {
        return this.apiHosts;
    }

    public final List<String> b() {
        return this.imageHosts;
    }
}
